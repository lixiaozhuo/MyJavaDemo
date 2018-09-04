package com.lixiaozhuo._04_i18n;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

//国际化
public class I18nTest {
	@Test
	public void testLocale() {
		Locale local = Locale.CHINA;
		System.out.println("CHINA : " + local);
		System.out.println("TAIWAN : " + Locale.TAIWAN);
		System.out.println("ENGLISH : " + Locale.ENGLISH);
		System.out.println("US : " + Locale.US);
	}

	@Test
	public void testFormat() {
		Double money = 123456.423;
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		String str = format.format(money);
		System.out.println(str);
	}

	@Test
	public void test() throws Exception {
		ResourceBundle bundle = ResourceBundle.getBundle("list", Locale.US);
		String str = bundle.getString("username");
		System.out.println(str);

	}

	@Test
	public void messageFormatTest() throws Exception {
		String msg = "{1},{2},{0}";
		msg = MessageFormat.format(msg, "1", "2", "3");
		System.out.println(msg);
	}
}
