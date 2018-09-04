package com.lixiaozhuo._23_tx_annon.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lixiaozhuo._23_tx_annon.dao.IAccountDAO;

@Repository
public class AccountDAOImpl implements IAccountDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void tranasOut(Long outId, int money) {
		jdbcTemplate.update("UPDATE t_account SET money=money-? WHERE id=?",
				money, outId);
	}

	@Override
	public void transIN(Long inId, int money) {
		jdbcTemplate.update("UPDATE t_account SET money=money+? WHERE id=?",
				money, inId);
	}

}
