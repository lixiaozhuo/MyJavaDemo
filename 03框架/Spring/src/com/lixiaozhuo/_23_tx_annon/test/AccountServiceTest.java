package com.lixiaozhuo._23_tx_annon.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lixiaozhuo._23_tx_annon.service.IAccountService;
//转账 事务测试(注解配置)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AccountServiceTest {

	@Autowired
	private IAccountService accountService;

	@Test
	public void testTrans() {
		accountService.trans(2L, 1L, 1000);
	}

}
