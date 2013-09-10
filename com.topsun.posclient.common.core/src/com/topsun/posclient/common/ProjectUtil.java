package com.topsun.posclient.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.eclipse.core.runtime.Platform;

/**
 * @author LiLei
 *
 */
public class ProjectUtil {

	static SimpleDateFormat defaultFmt = new SimpleDateFormat("yyyy-MM-dd");

	static SimpleDateFormat defaultTimeFmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static String getRuntimeClassPath() {
		String path = Platform.getInstanceLocation().getURL().getFile();
//		String path = "D:/devtools/eclipse-rcp-helios-SR2-win32/runtime-New_configuration/";
		return path;
	}

	public static Date getDateByFormat(String dateStr, String custFormat) {
		SimpleDateFormat dataformat = new SimpleDateFormat(custFormat);
		Date date = null;
		try {
			date = dataformat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * @param startHour
	 * @param endHour
	 * @return
	 */
	public static boolean compareCurrentHour(int startHour, int endHour){
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if(hour >= startHour && hour <= endHour){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean compareCurrentDate(Date startDate, Date endDate){
		Calendar calendar = Calendar.getInstance();
		Date currentDate = ProjectUtil.getDateByFormat("yyyyMMdd");
		Date sDate = ProjectUtil.getDateByFormat(ProjectUtil.getDateString(startDate), "yyyyMMdd");
		Date eDate = ProjectUtil.getDateByFormat(ProjectUtil.getDateString(endDate), "yyyyMMdd");
		if(currentDate.compareTo(sDate) == 1 || currentDate.compareTo(eDate) == 1){
			return true;
		}else if(calendar.after(sDate) && calendar.before(eDate)){
			return true;
		}else{
			return false;
		}
	}
	
	public static Date getDateByFormat(String custFormat) {
		SimpleDateFormat dataformat = new SimpleDateFormat(custFormat);
		Date date = null;
		try {
			date = dataformat.parse(dataformat.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getDate(String dateStr) {
		Date date = null;
		try {
			date = defaultFmt.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String getDateString(Date date) {
		String dateStr = null;
		if(null == date){
			dateStr = defaultFmt.format(new Date());
		}else{
			dateStr = defaultFmt.format(date);
		}
		return dateStr;
	}
	
	public static String getDateString(Date date, String custFormat) {
		SimpleDateFormat dataformat = new SimpleDateFormat(custFormat);
		String dateStr = null;
		if(null == date){
			dateStr = dataformat.format(new Date());
		}else{
			dateStr = dataformat.format(date);
		}
		return dateStr;
	}

	public static Date getDateTime(String dateStr) {
		Date date = null;
		try {
			date = defaultTimeFmt.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	private static Properties getProperties(String fileName) {
		InputStream in = ProjectUtil.class.getClassLoader()
				.getResourceAsStream(fileName);
		Properties p = new Properties();
		try {
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	public static Object getPropertiesValue(String keyName, String fileName) {
		Properties p = getProperties(fileName);
		return p.get(keyName);
	}

	public static String readValue(String filePath, String key)
			throws Exception {
		Properties props = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		props.load(in);
		String value = props.getProperty(key);
		return value;
	}

	public static BigDecimal getBigDecimal(String value) {
		if (null != value) {
			value = value.trim();
		} else {
			value = "0";
		}
		BigDecimal decimal = new BigDecimal(value);
		return decimal;
	}

	public static Calendar getCalendar(Date date) {
		if (null == date) {
			date = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	/**
	 * Check net connection status
	 * @return
	 */
	public static boolean checkConnection() {
		boolean status = true;
//		try {
//			String host = ProjectUtil.readValue(
//					ProjectUtil.getRuntimeClassPath()
//							+ AppConstants.SEETING_FILE, "serverIP");
//			String timeOut = ProjectUtil.readValue(
//					ProjectUtil.getRuntimeClassPath()
//							+ AppConstants.SEETING_FILE, "reconnectionTime");
//			status = InetAddress.getByName(host).isReachable(
//					Integer.valueOf(timeOut));
//			System.out.println("联机状态 --------->>> "+status);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return status;
	}
	
	/**
	 * @return
	 */
	public static String getOldGoldCountNum(){
		StringBuffer ret = new StringBuffer("0000");
		String countNum = POSClientApp.get().getSysConfig().getOldGoldCountNum();//当前累加0001-9999
		if(countNum.equals("0000")){
			return "0001";
		}else{
			Integer num = Integer.valueOf(countNum);
			num = num+1;
			String numStr = String.valueOf(num);
			for(int i=0; i<4-numStr.length(); i++){
				ret.append("0");
			}
			ret.append(numStr);
		}
		return ret.toString();
	}
	
	public static void main(String[] args){
//		boolean status = false;
//		try {
//			 InetAddress theAddress = InetAddress.getByName("114.80.119.77");
//			 Socket theSocket = new Socket(theAddress, 8088);
//			 BufferedReader  networkIn = new BufferedReader(new InputStreamReader(
//				       theSocket.getInputStream()));
//				     System.out.println(networkIn.readLine());
//			 
//			status = InetAddress.getByName("114.80.119.77").isReachable(5000);
//			System.out.println("联机状态 --------->>> "+status);
//			
//			InetAddress address1=InetAddress.getLocalHost();
//			System.out.println(address1.isReachable(5000));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		StringBuffer ret = new StringBuffer();
		String countNum = "0023";//当前累加0001-9999
			Integer num = Integer.valueOf(countNum);
			num = num+1;
			String numStr = String.valueOf(num);
			for(int i=0; i<4-numStr.length(); i++){
				ret.append("0");
			}
			ret.append(numStr);
		System.out.println(ret.toString());
	}
	
}
