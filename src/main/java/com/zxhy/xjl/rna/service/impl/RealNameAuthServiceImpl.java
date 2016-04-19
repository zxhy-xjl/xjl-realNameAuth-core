package com.zxhy.xjl.rna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxhy.xjl.rna.mapper.RealNameAuthMapper;
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
}
