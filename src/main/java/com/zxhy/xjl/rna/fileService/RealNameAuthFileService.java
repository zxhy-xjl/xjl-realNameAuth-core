package com.zxhy.xjl.rna.fileService;
import org.springframework.web.multipart.MultipartFile;
public interface RealNameAuthFileService {



	/**
	 * 上传照片
	 * @param file 文件
	 * @param outPath 输出路径
	 * @param name 名称
	 */
	public void doUploadFile(MultipartFile file,String outPath,String name);
	/**
	 * 替换文件名称
	 * @param file 文件
	 * @param name 名称
	 * @return 返回新名称
	 */
	public String doChangeFileName(MultipartFile file,String name);
	/**
	 * 将Base64编码的字符串转化成图片
	 * @param imgText
	 */
	public boolean Base64StringToImage(String imgText,String outPath,String name);
}
