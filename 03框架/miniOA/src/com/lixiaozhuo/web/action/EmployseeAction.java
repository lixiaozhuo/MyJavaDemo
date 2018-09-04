package com.lixiaozhuo.web.action;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.EmployeeQueryObject;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.service.impl.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import lombok.Getter;

public class EmployseeAction extends ActionSupport implements Preparable{

	private static final long serialVersionUID = 1L;
	
	@Getter
	private Employee employee = new Employee();
	
	@Getter
	private EmployeeQueryObject qo = new EmployeeQueryObject(1,10);
	
		
	private IEmployeeService service = new EmployeeServiceImpl();
	//列表
	@Override
	public String execute() throws Exception {	
		System.out.println("===========================");
		System.out.println("EmployseeAction.execute()");
		PageResult result = service.query(qo);
		System.out.println("data = " + result.getData());
		System.out.println("currentPage = " + result.getCurrentPage());
		//把数据共享到JSP:context区域
		ActionContext.getContext().put("result",result);
		return "list";
	}
	
	//新增和更改
	public String save() throws Exception {
		System.out.println("===========================");
		System.out.println("EmployseeAction.saveOrUpdate()");
		System.out.println("employee = " + employee);
		if(employee.getId() == null){
			service.save(employee);
		}else{
			service.update(employee);
		}		
		return SUCCESS;
	}
	

	//删除
	public String delete() throws Exception {
		System.out.println("===========================");
		System.out.println("EmployseeAction.delete()");
		System.out.println(employee.getId());
		if(employee.getId() != null){
			service.delete(employee.getId());
		}
		return SUCCESS;
	}

	//编辑
	public String input() throws Exception {
		System.out.println("===========================");
		System.out.println("EmployseeAction.input()");
		System.out.println(employee.getId());
		if(employee.getId() != null){
			employee = service.get(employee.getId());
		}		
		return INPUT;
	}

	@Override
	public void prepare() throws Exception {
	}
	
	//预先执行方法
	public void prepareSave() throws Exception {
		System.out.println("===========================");
		System.out.println("EmployseeAction.prepareSave()");
		if(employee.getId() != null){
			employee = service.get(employee.getId());
		}		
	}
}
