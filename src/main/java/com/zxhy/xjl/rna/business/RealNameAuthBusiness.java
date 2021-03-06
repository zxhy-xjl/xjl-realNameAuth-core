package com.zxhy.xjl.rna.business;

import java.util.List;

import com.zxhy.xjl.rna.model.ManualAudit;

public interface RealNameAuthBusiness {
	
	/**
	 * 注册
	 * @param phone
	 * @param passwd
	 */
	public void register(String phone, String passwd);
	/**
	 * 登陆
	 * @param phone
	 * @param passwd
	 * @return
	 */
	public boolean logon(String phone, String passwd);
	/**
	 * 补充完成注册流程
	 * @param phone
	 * @param taskId
	 */
	public void checkRegister(String phone, String taskId);
	/**
	 * 核名
	 * @param phone
	 * @param idCode
	 * @param idName
	 */
	public void checkRealName(String phone, String idCode, String idName, String taskId);
	/**
	 * 刷脸
	 * @param phone
	 * @param face
	 */
	public void checkFace(String phone, String face, String taskId);
	/**
	 * 实名认证是否完成
	 * @param phone
	 * @return
	 */
	public boolean realNameAuthFinish(String phone);
	/**
	 * 得到实名认证任务信息
	 * @param phone
	 * @return
	 */
	public RealNameAuthTask getRealNameAuthTask(String phone);
	
	/**
	 * 得到注册到那个环节
	 * @param phone
	 * @return
	 */
	public RealNameAuthTask getRegisterLinkByPhone(String phone);
	
	/**
	 * 管理员登录
	 * @param phone
	 * @return
	 */
	public boolean adminLogon(String accountNumber, String passwd);
	
	/**
	 * 人工审核列表
	 * @param phone
	 * @return
	 */
	public List<ManualAudit> manualAudit(String processname);
	
	/**
	 * 修改审核状态
	 * @param phone
	 * @return
	 */
	public void manualAuditState(String phone, String processname);
	
	
}
