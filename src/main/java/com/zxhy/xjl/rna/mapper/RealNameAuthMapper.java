package com.zxhy.xjl.rna.mapper;

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
}
