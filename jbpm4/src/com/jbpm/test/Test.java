package com.jbpm.test;

import java.util.List;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;

public class Test {

	//加载流程引擎 作为JBPM的入口
	ProcessEngine pengine =	Configuration.getProcessEngine();
	//流程发布服务    Repository==库 
	RepositoryService reservice = pengine.getRepositoryService();
	
	//部署流程操作
	public void depy(){
		
		String newpdID = reservice.createDeployment().
		addResourceFromClasspath("proccess/test.jpdl.xml").deploy();
		 
		System.out.println("新流程 " + newpdID + " 部署完成!");
	}
	
	public void listPD(){
		
		//获得流程定义查询	Definition==定义 
		ProcessDefinitionQuery pdQuery = reservice.createProcessDefinitionQuery();
		//查询当前所有部署的流程定义
		List<ProcessDefinition> pds = pdQuery.list();
		
		for(ProcessDefinition pd : pds){
			System.out.println(
					"流程部署deploymentId:"+pd.getDeploymentId()+"  流程定义id:"+pd.getId()
						+"  流程的key:"+pd.getKey()+"  流程定义的名字:"+pd.getName()
							+"  流程版本号:"+pd.getVersion());
		}
	}
	
	//根据流程id 开始一个 ProcessInstance流程实例
	public void startPIbyId(){
		ExecutionService exeService = pengine.getExecutionService();
		ProcessInstance piA = exeService.startProcessInstanceById("test-1");
		System.out.println("流程id是:" + piA.getId());
	}
	
	/*根据ExecutionService标记可执行节点()  
	根据task表字段 execution_ID_ testA.140001 执行完整条数据后自动被删除*/
	public void oprtExecutionService(){
		//获得可执行服务
		ExecutionService exService = pengine.getExecutionService();
		//arg0 是task表字段 execution_ID_的val arg1是导航方向
		exService.signalExecutionById("test.10001", "to java2");
	}
	
	//执行task服务执行,完成以后对应数据自动delete 
	public void oprtTask() {
		// 获得可执行节点服务
		TaskService taskService = pengine.getTaskService();
		// arg0是task表字段 DBID_的val arg1是导航信息
		taskService.completeTask("30003", "to java3");
	}
	
	public static void main(String[] args) {

		Test  t = new Test();
		//t.depy();
		//t.listPD();
		//t.startPIbyId();
		//t.oprtExecutionService();
		t.oprtTask();
	}
}
