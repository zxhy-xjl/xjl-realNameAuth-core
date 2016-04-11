package com.zxhy.xjl.rna.business;
/**
 * 实名认证配置参数管理
 * @author leasonlive
 *
 */
public class RealNameAuthConfig {
	//使用人口库身份证认证
	private boolean usePeopleIDCheck;
	//使用人脸认证
	private boolean useFaceCheck;
	public boolean isUsePeopleIDCheck() {
		return usePeopleIDCheck;
	}
	public void setUsePeopleIDCheck(boolean usePeopleIDCheck) {
		this.usePeopleIDCheck = usePeopleIDCheck;
	}
	public boolean isUseFaceCheck() {
		return useFaceCheck;
	}
	public void setUseFaceCheck(boolean useFaceCheck) {
		this.useFaceCheck = useFaceCheck;
	}
	
}
