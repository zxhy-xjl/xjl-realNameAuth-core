package com.zxhy.xjl.rna.fileService.impl;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.zxhy.xjl.rna.fileService.RealNameAuthFileService;
@Component("RealNameAuthFileService")
public class RealNameAuthFileServiceImpl implements RealNameAuthFileService {


	/**
	 *上传文件
	 */
	@Override
	public void doUploadImage(MultipartFile file, String outPath){
		String fileName = file.getOriginalFilename();
		File targetFile = new File(outPath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
