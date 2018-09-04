package com.lixiaozhuo._13_smis_hibernate.template;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import com.lixiaozhuo._13_smis_hibernate.domain.SqlField;
import com.lixiaozhuo._13_smis_hibernate.domain.SqlTable;
import com.lixiaozhuo._13_smis_hibernate.handler.BeanHandler;
import com.lixiaozhuo._13_smis_hibernate.handler.BeanListHandler;

//模拟Hibernate封装DML DQL操作
public class HibernateTemplate {
	private HibernateTemplate() {
	};

	public static void save(Object obj) throws Exception {
		Class<?> clazz = obj.getClass();
		// 拼接SQL INSERT INTO tb_student(name,age) VALUE(?,?)
		StringBuilder sql = new StringBuilder("INSERT INTO ");
		// 拼接列名
		StringBuilder column = new StringBuilder();
		// 拼接占位符
		StringBuilder placeholder = new StringBuilder();
		// 存储插入的值
		List<Object> list = new ArrayList<>();
		// 获取类上的SqlTable.class
		if (clazz.isAnnotationPresent(SqlTable.class)) {
			SqlTable sqlTable = clazz.getAnnotation(SqlTable.class);
			sql.append(sqlTable.value());
		} else {
			sql.append(clazz.getSimpleName());
		}
		sql.append("(");
		// 利用内省获取属性
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			String name = pd.getName();
			// 获取字段上的注解:字段对应数据库的列名
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			if (field.isAnnotationPresent(SqlField.class)) {
				SqlField sqlField = field.getAnnotation(SqlField.class);
				column.append(sqlField.value());
			} else {
				column.append(pd.getName());
			}
			// 属性名拼接列明
			column.append(",");
			// 拼接占位符
			placeholder.append("?,");
			// 存储插入的值
			Object value = pd.getReadMethod().invoke(obj);
			list.add(value);
		}
		// 去掉尾部逗号
		column.deleteCharAt(column.length() - 1);
		placeholder.deleteCharAt(placeholder.length() - 1);
		// 拼接字符串
		sql.append(column).append(" )  VALUES(").append(placeholder)
				.append(");");
		System.out.println(sql);
		System.out.println(list);
		// 执行更新语句
		jdbcTemplate.update(sql.toString(), list.toArray());
	}

	public static void update(Object obj) throws Exception {
		Class<?> clazz = obj.getClass();
		// 拼接SQL "UPDATE tb_student SET name = ?,age = ? WHERE id = ?";
		StringBuilder sql = new StringBuilder("UPDATE ");
		// 拼接设置
		StringBuilder column = new StringBuilder();
		// 存储插入的值
		List<Object> list = new ArrayList<>();
		// 存储插入表的id
		String id = "";
		// 获取类上的SqlTable.class,得到对应表名
		if (clazz.isAnnotationPresent(SqlTable.class)) {
			SqlTable sqlTable = clazz.getAnnotation(SqlTable.class);
			sql.append(sqlTable.value());
		} else {
			sql.append(clazz.getSimpleName());
		}
		sql.append(" SET ");
		// 利用内省获取属性
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			String name = pd.getName();
			// 获取字段上的注解:字段对应数据库的列名
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			if (field.isAnnotationPresent(SqlField.class)) {
				SqlField sqlField = field.getAnnotation(SqlField.class);
				if ("id".equals(sqlField.value())) {
					id = sqlField.value();
					continue;
				}
				column.append(sqlField.value());
			} else {
				column.append(pd.getName());
			}
			// 属性名拼接列明
			column.append(" = ?,");
			// 存储插入的值
			Object value = pd.getReadMethod().invoke(obj);
			list.add(value);
		}
		// 参数加入id
		list.add(id);
		// 去掉尾部逗号
		column.deleteCharAt(column.length() - 1);
		// 拼接字符串
		sql.append(column).append("  WHERE id = ?");
		System.out.println(sql);
		System.out.println(list);
		// 执行更新语句
		jdbcTemplate.update(sql.toString(), list.toArray());
	}

	public static void delete(Long id, Class<?> clazz) {
		// 拼接SQL "DELETE FROM tb_student WHERE id = ?";
		StringBuilder sql = new StringBuilder("DELETE FROM ");
		// 获取类上的SqlTable.class,得到对应表名
		if (clazz.isAnnotationPresent(SqlTable.class)) {
			SqlTable sqlTable = clazz.getAnnotation(SqlTable.class);
			sql.append(sqlTable.value());
		} else {
			sql.append(clazz.getSimpleName());
		}
		sql.append(" WHERE id = ?");
		System.out.println(sql);
		// 执行更新语句
		jdbcTemplate.update(sql.toString(), id);
	}

	public static <T> T get(Long id, Class<T> clazz) {
		// 拼接SQL "SELECT id,name,age FROM tb_student WHERE id = ?";
		StringBuilder sql = new StringBuilder("SELECT * FROM ");
		// 获取类上的SqlTable.class,得到对应表名
		if (clazz.isAnnotationPresent(SqlTable.class)) {
			SqlTable sqlTable = clazz.getAnnotation(SqlTable.class);
			sql.append(sqlTable.value());
		} else {
			sql.append(clazz.getSimpleName());
		}
		sql.append(" WHERE id = ?");
		System.out.println(sql);
		// 执行查询语句
		return jdbcTemplate.query(sql.toString(), new BeanHandler<>(clazz), id);
	}

	public static <T> List<T> list(Class<T> clazz) {
		// 拼接SQL String sql = "SELECT id,name,age FROM tb_student";
		StringBuilder sql = new StringBuilder("SELECT * FROM ");
		// 获取类上的SqlTable.class,得到对应表名
		if (clazz.isAnnotationPresent(SqlTable.class)) {
			SqlTable sqlTable = clazz.getAnnotation(SqlTable.class);
			sql.append(sqlTable.value());
		} else {
			sql.append(clazz.getSimpleName());
		}
		sql.append(";");
		System.out.println(sql);
		// 执行查询语句
		return jdbcTemplate.query(sql.toString(), new BeanListHandler<>(clazz));
	}
}
