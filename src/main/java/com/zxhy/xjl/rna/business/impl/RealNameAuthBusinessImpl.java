package com.zxhy.xjl.rna.business.impl;

import java.util.List;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zxhy.xjl.workflow.ProcessEngine;
import com.zxhy.xjl.workflow.impl.TaskInfo;
import com.zxhy.xjl.rna.business.RealNameAuthBusiness;
import com.zxhy.xjl.rna.business.RealNameAuthTask;
import com.zxhy.xjl.rna.model.Admin;
import com.zxhy.xjl.rna.model.RealNameAuth;
import com.zxhy.xjl.rna.service.RealNameAuthService;
import com.zxhy.xjl.rna.model.ManualAudit;
@Component("realNameAuthBusiness")
public class RealNameAuthBusinessImpl implements RealNameAuthBusiness{
	private static final Log log = LogFactory.getLog(RealNameAuthBusinessImpl.class);
	private static final String ProcessDefinitionKey = "realNameAuth";
	@Autowired
	private RealNameAuthService realNameAuthService;
	
	@Autowired
	private ProcessEngine processEngine;
	public void register(String phone, String passwd) {
		this.realNameAuthService.register(phone, passwd);
		this.processEngine.addUser(phone, phone, phone, null, passwd);
		this.processEngine.addUserToGroup(phone, "realName");
		JSONArray json = new JSONArray();
		JSONObject businessKey = new JSONObject();
		businessKey.put("name", "businessKey");
		businessKey.put("value", phone);
		json.put(businessKey);
		//启动任务
		this.processEngine.startProcessByKey(ProcessDefinitionKey, phone, json);
		RealNameAuthTask task = this.getRealNameAuthTask(phone);
		//完成第一步注册，到核名环节
		this.processEngine.completeTask(task.getTaskId(), null);
	}
	
	public boolean logon(String phone, String passwd) {
		log.debug("登陆  phone:" + phone + " passwd:" + passwd);
		RealNameAuth realNameAuth = this.realNameAuthService.findByPhone(phone);
		//通过异常抛出方式，而不是使用字符串进行区分
		if (realNameAuth == null){
			throw new RuntimeException("用户名称（手机号码）不存在");
		}
		if (!passwd.equals(realNameAuth.getPasswd())){
			throw new RuntimeException("用户名称和密码不匹配");
		}
		log.debug("登录成功");
		return true;
	}
	public void checkRegister(String phone, String taskId){
		this.processEngine.completeTask(taskId, null);
	}
	public void checkRealName(String phone, String idCode, String idName, String taskId) {
		this.realNameAuthService.updateRealName(phone, idCode, idName);
		this.processEngine.completeTask(taskId, null);
	}

	public void checkFace(String phone, String face, String taskId) {
		this.realNameAuthService.updateFace(phone, face);
		this.processEngine.completeTask(taskId, null);
		
	}

	public boolean realNameAuthFinish(String phone) {
		return this.getRealNameAuthTask(phone) == null;
	}

	public RealNameAuthTask getRealNameAuthTask(String phone) {
		List<TaskInfo> list = this.processEngine.getMyTask(phone, ProcessDefinitionKey);
		for (TaskInfo taskInfo : list) {
			log.debug("processDefinitionID:" + taskInfo.getProcessDefinitionId());
			RealNameAuthTask task = new RealNameAuthTask();
			task.setPhone(phone);
			task.setProcessName(taskInfo.getProcessDefinitionName());
			task.setTaskId(taskInfo.getTaskId());
			task.setTaskName(taskInfo.getName());
			return task;
		}
		return null;
	}
	
	public RealNameAuthTask getRegisterLinkByPhone(String phone){
		
		return this.realNameAuthService.getRegisterLinkByPhone(phone);
		
	}

	@Override
	public boolean adminLogon(String accountNumber,String passwd) {
		log.debug("登陆  accountNumber:" + accountNumber + " passwd:" + passwd);
		Admin admin = this.realNameAuthService.adminLogin(accountNumber);
		//通过异常抛出方式，而不是使用字符串进行区分
		if (admin == null){
			throw new RuntimeException("账号不存在");
		}
		if (!passwd.equals(admin.getPasswd())){
			throw new RuntimeException("账号和密码不匹配");
		}
		log.debug("登录成功");
		return true;
	}

	@Override
	public List<ManualAudit> manualAudit(String processname) {
		if (null!=this.realNameAuthService.manualAudit(processname)){
			return  this.realNameAuthService.manualAudit(processname);
		}
		return  null;
	}

	@Override
	public void manualAuditState(String phone, String processname) {
		this.realNameAuthService.manualAuditState(phone,processname);
		
	}
	
}
