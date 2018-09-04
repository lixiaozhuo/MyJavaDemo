package com.lixiaozhuo._22_tx.service.impl;

import com.lixiaozhuo._22_tx.dao.IAccountDAO;
import com.lixiaozhuo._22_tx.service.IAccountService;

import lombok.Setter;

public class AccountService implements IAccountService {
	@Setter
	private IAccountDAO accountDAO;

	@Override
	public void trans(Long outId, Long inId, int money) {
		accountDAO.tranasOut(outId, money);
		System.out.println(1/0);	
		accountDAO.transIN(inId, money);
	}

}
