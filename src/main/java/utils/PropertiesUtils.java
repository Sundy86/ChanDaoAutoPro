package utils;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import common.MConstant;

public class PropertiesUtils {
	public static final Properties prop = getProperties();

	public static String getPropertyStr(String str) {

		String propertyValue = null;
		try {
			//读取properties文件中的内容，并转换为UTF-8格式，以防返回乱码
			propertyValue = new String(prop.getProperty(str).getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return propertyValue;
	}

	public static Properties getProperties(){
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(MConstant.PATH_CONFIG_PROPERTIES+"UIMap.properties");
			prop.load(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;

	}
}
