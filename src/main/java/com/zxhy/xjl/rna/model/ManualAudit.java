package com.zxhy.xjl.rna.model;

/**
 * 管理员 
 * @author  人工审核
 * 
 */
public class ManualAudit {
	private String phone;
	private String id_name;
	private String processname; 
	private String face_url;
	private String id_code;
	public String getId_code() {
		return id_code;
	}
	public void setId_code(String id_code) {
		this.id_code = id_code;
	}
	private String id_photo_url;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId_name() {
		return id_name;
	}
	public void setId_name(String id_name) {
		this.id_name = id_name;
	}
	public String getProcessname() {
		return processname;
	}
	public void setProcessname(String processname) {
		this.processname = processname;
	}
	public String getFace_url() {
		return face_url;
	}
	public void setFace_url(String face_url) {
		this.face_url = face_url;
	}
	public String getId_photo_url() {
		return id_photo_url;
	}
	public void setId_photo_url(String id_photo_url) {
		this.id_photo_url = id_photo_url;
	} 
	
	
	
}
