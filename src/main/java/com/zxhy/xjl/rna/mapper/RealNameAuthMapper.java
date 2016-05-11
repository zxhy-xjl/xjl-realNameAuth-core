package com.zxhy.xjl.rna.mapper;

import java.util.List;

import com.zxhy.xjl.rna.business.RealNameAuthTask;
import com.zxhy.xjl.rna.model.Admin;
import com.zxhy.xjl.rna.model.ManualAudit;
import com.zxhy.xjl.rna.model.RealNameAuth;

/**
 * 实名认证数据库操作类
 * @author leasonlive
 *
 */
public interface RealNameAuthMapper {
	void save(RealNameAuth realNameAuth);
	void updatePassword(RealNameAuth realNameAuth);
	void updateRealName(RealNameAuth realNameAuth);
	void updatePhoto(RealNameAuth realNameAuth);
	void updateFace(RealNameAuth realNameAuth);
	RealNameAuth findByPhone(String phone);
	void delete(String phone);
    RealNameAuthTask getRegisterLinkByPhone(String phone);
    Admin adminLogin(String accountNumber);
    List<ManualAudit> manualAudit(String manualAudit);
    void updateManualAuditState(ManualAudit manualAudit);
}
