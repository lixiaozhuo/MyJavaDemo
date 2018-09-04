package com.lixiaozhuo.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JsonResult {
	private Boolean success;
	private String msg;
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private  Date date;
	
}
