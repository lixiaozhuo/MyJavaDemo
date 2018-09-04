package com.lixiaozhuo._23_tx_annon.dao;

public interface IAccountDAO {
	//从指定账户转出指定金额的钱
	void tranasOut(Long outId,int money);
	
	//给指定的账户 转入指定金额的钱
	void transIN(Long inId,int money);
}
