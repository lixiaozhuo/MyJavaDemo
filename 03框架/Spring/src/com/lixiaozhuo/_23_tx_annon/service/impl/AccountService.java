package com.lixiaozhuo._23_tx_annon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lixiaozhuo._23_tx_annon.dao.IAccountDAO;
import com.lixiaozhuo._23_tx_annon.service.IAccountService;
//遍历所有方法,给方法添加事务
@Transactional(readOnly=true)
@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountDAO accountDAO;
	
	@Transactional//方法上重新定义事务
	@Override
	public void trans(Long outId, Long inId, int money) {
		accountDAO.tranasOut(outId, money);
		System.out.println(1 / 0);
		accountDAO.transIN(inId, money);
	}

}
