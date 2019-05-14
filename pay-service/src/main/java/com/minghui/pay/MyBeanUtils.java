package com.minghui.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyBeanUtils {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(MyBeanUtils.class);

	// TChatLevelConfig
	static String ClassName = "PayAgent";
	static String varName = "payAgent";
	static String Entity = "PayAgent";

	static String encoding = "UTF-8";

	static String pojoTargetPath = getPath() + "\\src\\main\\java\\com\\minghui\\pay\\pojo";
	static String serviceTargetPath = getPath() + "\\src\\main\\java\\com\\minghui\\pay\\service";
	static String serviceImplTargetPath = getPath() + "\\src\\main\\java\\com\\minghui\\pay\\service\\impl";

	static String tmpReqBeanfilePath = "src/main/resources/CmEntityReqBean.java";
	static String tmpResBeanfilePath = "src/main/resources/CmEntityResBean.java";
	static String tmpServicefilePath = "src/main/resources/IEntityService.java";
	static String tmpServiceImplfilePath = "src/main/resources/EntityServiceImpl.java";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readTxtFile1(tmpReqBeanfilePath, pojoTargetPath + "", "Cm" + Entity + "ReqBean.java");
		readTxtFile1(tmpResBeanfilePath, pojoTargetPath, "Cm" + Entity + "ResBean.java");
		readTxtFile1(tmpServicefilePath, serviceTargetPath, "I" + Entity + "Service.java");
		readTxtFile1(tmpServiceImplfilePath, serviceImplTargetPath, "" + Entity + "ServiceImpl.java");
		
		System.out.println("生成代码完成!");

	}
	
	private static String getPath() {
		File directory = new File("");//参数为空 
		String courseFile = null;
		try {
			courseFile = directory.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return courseFile;
	}

	public static void readTxtFile1(String filePath, String targetFilePath, String fileName) {
		try {

			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				StringBuffer classContent = new StringBuffer();
				while ((lineTxt = bufferedReader.readLine()) != null) {
					lineTxt = lineTxt.replace("${Entity}", Entity);
					lineTxt = lineTxt.replace("${ClassName}", ClassName);
					lineTxt = lineTxt.replace("${varName}", varName);
					classContent.append(lineTxt).append("\n");
				}
				read.close();

				String classFilePath = targetFilePath + "\\" + fileName;
				writerTxt(classFilePath, classContent.toString());

			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}

	public static void writerTxt(String targetFile, String content) {
		BufferedWriter fw = null;
		try {
			File file = new File(targetFile);// targetPath + "\\Cm" + Entity +
			// "ReqBean.java"
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), encoding)); // 指定编码格式，以免读取时中文字符异常
			fw.append(content);
			fw.flush(); // 全部写入缓存中的内容
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
