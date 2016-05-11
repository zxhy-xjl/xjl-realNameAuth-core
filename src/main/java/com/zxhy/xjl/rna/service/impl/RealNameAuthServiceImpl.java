package com.zxhy.xjl.rna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxhy.xjl.rna.business.RealNameAuthTask;
import com.zxhy.xjl.rna.mapper.RealNameAuthMapper;
import com.zxhy.xjl.rna.model.Admin;
import com.zxhy.xjl.rna.model.ManualAudit;
import com.zxhy.xjl.rna.model.RealNameAuth;
import com.zxhy.xjl.rna.service.RealNameAuthService;
@Service("realNameAuthService")
public class RealNameAuthServiceImpl implements RealNameAuthService {
	@Autowired
	private RealNameAuthMapper mapper;
	public void register(String phone, String passwd) {
		RealNameAuth realNameAuth = new RealNameAuth();
		realNameAuth.setPhone(phone);
		realNameAuth.setPasswd(passwd);
		mapper.save(realNameAuth);
	}
	
	public void updatePhoto(String phone, String photoUrl){
		RealNameAuth realNameAuth = new RealNameAuth();
		realNameAuth.setPhone(phone);
		realNameAuth.setIdPhotoUrl(photoUrl);
		this.mapper.updatePhoto(realNameAuth);
		
	}
	
	public void updateFace(String phone, String faceUrl) {
		RealNameAuth realNameAuth = new RealNameAuth();
		realNameAuth.setPhone(phone);
		realNameAuth.setFaceUrl(faceUrl);
		this.mapper.updateFace(realNameAuth);
		
	}
	
	public void delete(String phone) {
		this.mapper.delete(phone);
	}

	public RealNameAuth findByPhone(String phone) {
		return this.mapper.findByPhone(phone);
	}
	
	@Override
	public void updateRealName(String phone, String idCode, String idName) {
		RealNameAuth realNameAuth = new RealNameAuth();
		realNameAuth.setPhone(phone);
		realNameAuth.setIdCode(idCode);
		realNameAuth.setIdName(idName);
		this.mapper.updateRealName(realNameAuth);
	}

	@Override
	public RealNameAuthTask getRegisterLinkByPhone(String phone) {
		
		return this.mapper.getRegisterLinkByPhone(phone);
	}

	@Override
	public Admin adminLogin(String accountNumber) {
		return this.mapper.adminLogin(accountNumber);
	}
	
	@Override
	public void updatePassword(String phone, String password) { 
		RealNameAuth realNameAuth = new RealNameAuth();
		realNameAuth.setPhone(phone);
		realNameAuth.setPasswd(password);
		this.mapper.updatePassword(realNameAuth);
	}

	@Override
	public List<ManualAudit> manualAudit(String processname) {
		if(processname.equals("1")){
			processname="审核中";
		}
		if(processname.equals("2")){
			processname="审核通过";
		}
		if(processname.equals("3")){
			processname="审核不通过";
		}
		if(null!=this.mapper.manualAudit(processname)){
			return this.mapper.manualAudit(processname);
		}
		return null;
	}

	@Override
	public void manualAuditState(String phone, String processname) {
		if(processname.equals("yes")){
			processname="审核通过";
		}
		if(processname.equals("no")){
			processname="审核不通过";
		}
		ManualAudit manualAudit=new ManualAudit();
		manualAudit.setPhone(phone);
		manualAudit.setProcessname(processname);
		this.mapper.updateManualAuditState(manualAudit);
	}
}
