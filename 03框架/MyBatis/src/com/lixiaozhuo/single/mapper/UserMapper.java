package com.lixiaozhuo.single.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lixiaozhuo.single.domain.User;
import com.lixiaozhuo.single.query.UserQuery;

public interface UserMapper {
	// @Insert("INSERT INTO t_user(username,password,age)
	// VALUE(#{username},#{password},#{age})")
	// @Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	void add(User obj);

	void update(User obj);

	void delete(Long id);

	// @Select("SELECT id, username username1,password,age FROM t_user WHERE
	// id=#{id}")
	// @Results(id="getResults",value={
	// @Result(column="id",property="id"),
	// @Result(column="username1",property="username"),
	// @Result(column="password",property="password"),
	// @Result(column="age",property="age")
	// })
	User get(Long id);

	List<User> list();

	List<User> queryByCondition(UserQuery qo);

	List<User> queryByAge(List<Integer> ages);

	List<User> query(UserQuery qo);

	Long queryCount(UserQuery qo);

	User getUserByUsernameAndPassword(@Param("username") String username,
			@Param("password") String password);
}
