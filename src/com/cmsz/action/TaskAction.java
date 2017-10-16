package com.cmsz.action;

import java.util.List;

import com.cmsz.domain.Company;
import com.cmsz.domain.Employee;
import com.cmsz.domain.PageBean;
import com.cmsz.domain.Task;
import com.cmsz.service.CompanyService;
import com.cmsz.service.EmployeeService;
import com.cmsz.service.TaskService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class TaskAction extends ActionSupport implements ModelDriven<Task>{
	
	private int currentPage=1;

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	private Task task = new Task();
	
	@Override
	public Task getModel() {
		return task;
	}
	
	private TaskService taskService;
	
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}	
	
	public CompanyService companyService;
	


	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public String findAll(){
		PageBean<Task> pageBean = taskService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String assessment() {
		PageBean<Task> pageBean = taskService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		List<Company> clist = companyService.findAll();
		ActionContext.getContext().getSession().put("clist", clist);
		return "assessment";
	}
	private List<Task> lista ;
	
	public void setLista(List<Task> lista) {
		this.lista = lista;
	}

	public String findByCpname() {
		lista = taskService.findAll();
		if (lista == null) {
			return null;
		}
		else {
			System.out.println(lista.size());
		
			return "assessmentByComp";
		}
	}
	
	

	//通过action返回跳转的jsp
	public String saveUI(){
		List<Employee> list = employeeService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}
	
	public String addTask() {
		taskService.save(task);
		return "addSuccess";
	}
	
	public String editTask() {
		task = taskService.edit(task.getTask_id());
		List<Employee> list = employeeService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	
	public String updateTask() {
		System.out.println(task.getTask_name().toString());
		taskService.update(task);
		return "updateSuccess";
	}
	
	public String delTask() {
		taskService.delete(task);
		return "delSuccess";
	}
}
