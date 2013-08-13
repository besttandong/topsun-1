package com.topsun.posclient.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * @author Dong
 * 
 */
public class LocalDataProcessor {

	String id;

	public LocalDataProcessor() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDataProcessor(String id) {
		this.id = id;
	}
	
	public void cleanBackData(File backFile){
		if(backFile.exists()){
			backFile.delete();
		}
	}
	
	/**
	 * @param file
	 * @param backPath
	 * @param needDel
	 * @return
	 * @throws IOException
	 */
	public boolean copyFileToBack(File file,String backPath, boolean needDel) throws IOException{
		File backFile = new File(backPath);
		if(backFile.exists()){
			backFile.delete();
		}
		copyFile(file, backFile);
		if(needDel){
			file.delete();
		}
		return true;
	}
	
	// 复制文件
    private static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
            	outBuff.close();
        }
    }
	
	/**
	 * @param file
	 * @return
	 */
	public String getDataFileContent(File file){
		StringBuffer fileData = new StringBuffer();
		BufferedReader reader = null;
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			reader = new BufferedReader(read);
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
				fileData.append(tempString);
				line++;
			}
//			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return fileData.toString();
	}

	/**
	 * 
	 * @param data
	 * @param classe
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("rawtypes")
	public Object getObjectFromXml(String data, Class classe)
			throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(classe);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		return unMarshaller.unmarshal(new StringReader(data));
	}

	/**
	 * 
	 * @param data
	 * @param fileName
	 * @param dataPath
	 * @throws JAXBException
	 * @throws IOException
	 */
	public File createXmlFileFromObject(Object data, String fileName,
			String dataPath) throws JAXBException, IOException {
		String filePath = ProjectUtil.getRuntimeClassPath();
		File file = new File(filePath + dataPath + fileName + "_"
				+ System.currentTimeMillis() + ".xml");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
		JAXBContext context = JAXBContext.newInstance(data.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(data, fos);
		return file;
	}
	
	/**
	 * 更新本地数据文件
	 * @param fileName 文件名，包含文件路径
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public void updateLocalDataFile(Object data,String backPath, String fileName) throws IOException, JAXBException{
		String filePath = ProjectUtil.getRuntimeClassPath();
		File file = new File(filePath + fileName);
		if (file.exists()) {
			// 将旧文件拷贝到备份目录，删除原文件
			this.copyFileToBack(file, filePath+backPath, true);
		}
		//创建新的本地数据文件
		FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
		JAXBContext context = JAXBContext.newInstance(data.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(data, fos);
	}
	
	public String getStringFromObject(Object data) throws JAXBException, IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JAXBContext context = JAXBContext.newInstance(data.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(data, baos);
		return baos.toString();
		
	}
}
