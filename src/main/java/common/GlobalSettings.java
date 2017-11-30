package common;

import java.io.FileInputStream;
import java.util.Properties;



public class GlobalSettings {
	
	public static final Properties prop = getProperties();

	public static final String chromeDriverPath=MConstant.PATH_SYS+prop.getProperty("ChromeDriverPath");
	public static final  String zentaoUrl=prop.getProperty("zentaoUrl");
	public static final  String dataFilePath=MConstant.PATH_SYS+"data/ProductManage.xls";
	public static final  String picFilePath=MConstant.PATH_SYS+"data/pic/1.jpg";
	
	public static Properties getProperties(){
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(MConstant.PATH_CONFIG_PROPERTIES+"prop.properties");
			prop.load(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
		
	}
}
