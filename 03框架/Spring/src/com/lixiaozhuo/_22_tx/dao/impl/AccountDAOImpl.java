package com.lixiaozhuo._22_tx.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.lixiaozhuo._22_tx.dao.IAccountDAO;

public class AccountDAOImpl extends JdbcDaoSupport implements IAccountDAO {

	@Override
	public void tranasOut(Long outId, int money) {
		getJdbcTemplate().update("UPDATE t_account SET money=money-? WHERE id=?",
				money, outId);
	}

	@Override
	public void transIN(Long inId, int money) {
		getJdbcTemplate().update("UPDATE t_account SET money=money+? WHERE id=?",
				money, inId);
	}

}
