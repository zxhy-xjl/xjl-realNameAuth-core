package com.zxhy.xjl.rna.service;

import java.util.List;

import com.zxhy.xjl.rna.business.RealNameAuthTask;
import com.zxhy.xjl.rna.model.Admin;
import com.zxhy.xjl.rna.model.RealNameAuth;
import com.zxhy.xjl.rna.model.ManualAudit;

/**
 * 实名认证服务接口
 * @author leasonlive
 *
 */
public interface RealNameAuthService {
	/**
	 * 注册
	 * @param phone
	 * @param passwd
	 */
	public void register(String phone, String passwd);
	public void updateRealName(String phone, String idCode, String idName);
	public void updatePhoto(String phone, String photoUrl);
	public void updateFace(String phone, String faceUrl);
	public void updatePassword(String phone,String password);
	public void delete(String phone);
	public RealNameAuth findByPhone(String phone);
	public RealNameAuthTask getRegisterLinkByPhone(String phone);
	public Admin adminLogin(String accountNumber);
	public List<ManualAudit> manualAudit(String processname);
	public void manualAuditState(String phone,String processname); 
}
