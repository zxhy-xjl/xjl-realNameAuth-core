package com.zxhy.xjl.rna.fileService.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.zxhy.xjl.rna.fileService.RealNameAuthFileService;
@Component("RealNameAuthFileService")
public class RealNameAuthFileServiceImpl   implements RealNameAuthFileService  {

	/**
	 *上传文件
	 */
	@Override
	public void doUploadImage(MultipartFile file,String outPath, String name) {
		// TODO Auto-generated method stub
		OutputStream os = null;//输出流
		InputStream is = null;//输入流
		if(null!=file){
			try {
				 is = file.getInputStream();
				 os = new FileOutputStream(outPath+""+this.doChangeFileName(file, name));
				 int byteRead=0;
				 byte[] buffer = new byte[1024];
				  while ((byteRead = is.read(buffer, 0,1024)) != -1) {
					  os.write(buffer, 0, byteRead);// 将文件写入
				    }
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				 try {
					 if(null!=os){
						 os.close();
					 }
					 if(null!=is){
						 is.close();
					 }
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 替换文件名称
	 */
	@Override
	public String doChangeFileName(MultipartFile file, String name) {
		String  fileName = file.getOriginalFilename();//获取文件名称
		int fileNameLen = fileName.lastIndexOf(".");//获取后缀名.的位置
		String fileExtension=fileName.substring(fileNameLen, fileName.length());//截取后缀名
		return name+""+fileExtension;//返回新名称
	}
}
