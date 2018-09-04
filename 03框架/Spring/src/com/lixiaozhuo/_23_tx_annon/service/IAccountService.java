package com.lixiaozhuo._23_tx_annon.service;

public interface IAccountService {
	/**
	 * 转账
	 * 
	 * @param outId
	 *            转出账户
	 * @param inId
	 *            转入账户
	 * @param money
	 *            转账金额
	 */
	void trans(Long outId, Long inId, int money);
}
