package com.zxhy.xjl.rna.fileService;

import org.springframework.web.multipart.MultipartFile;
public interface RealNameAuthFileService {

	/**
	 * 上传图片
	 */
	public void doUploadImage(MultipartFile file,String outPath);
}
