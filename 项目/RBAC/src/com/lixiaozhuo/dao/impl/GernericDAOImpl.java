package com.lixiaozhuo.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.lixiaozhuo.dao.IGernericDAO;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;

import lombok.Setter;

public class GernericDAOImpl<T> implements IGernericDAO<T> {

	@Setter
	protected SessionFactory sessionFactory;
	
	//泛型类型
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GernericDAOImpl() {
		//获取调用对象的类型
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		// 获取泛型类型
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	@Override
	public T get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(clazz, id);
	}

	@Override
	public List<T> list() {
		Session session = sessionFactory.getCurrentSession();

		return session.createQuery(
				"SELECT obj FROM " + clazz.getSimpleName() + " obj", clazz)
				.list();
	}

	@Override
	public PageResult<T> query(QueryObject qo) {
		Session session = sessionFactory.getCurrentSession();
		// 查询记录总数
		String hqlCount = "SELECT COUNT(obj) FROM " + clazz.getSimpleName()
				+ " obj" + qo.getCondition();
		Query<Long> queryCount = session.createQuery(hqlCount, Long.class);
		addParams(qo.getParams(), queryCount);
		System.out.println("记录总数查询  : " + hqlCount);
		System.out.println("查询参数 : " + qo.getParams());
		//记录总数
		Integer count = queryCount.uniqueResult().intValue();
		if (count == 0) {
			return new PageResult<T>(new ArrayList<T>(), 0,
					qo.getPageSize(), qo.getCurrentPage());
		}
		// 查询结果集
		String hqlData = "SELECT obj FROM " + clazz.getSimpleName() + " obj "
				+ qo.getCondition();
		Query<T> queryData = session.createQuery(hqlData, clazz);
		addParams(qo.getParams(), queryData);
		System.out.println("结果集查询  : " + hqlData);
		System.out.println("查询参数 : " + qo.getParams());
		List<T> data = queryData
				.setFirstResult((qo.getCurrentPage() - 1) * qo.getPageSize())
				.setMaxResults(qo.getPageSize()).list();
		//返回结果对象
		return new PageResult<T>(data, count, qo.getPageSize(),
				qo.getCurrentPage());
	}
	
	/**
	 * 往结果集中添加参数
	 * @param params 参数集合
	 * @param query 结果对象
	 */
	private void addParams(Map<String, Object> params, Query<?> query) {
		for (String key : params.keySet()) {
			query.setParameter(key.toString(), params.get(key));
		}
	}
}
