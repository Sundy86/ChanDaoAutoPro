package utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class SystemUtils {
	private static Logger logger = Logger.getLogger(common.BrowserEmulator.class
			.getName());
	public static String getSysPath(){
		String path = System.getenv("testsuitefold");
		if(StringUtils.isNotBlank(path)){
			return path+"/";
		}
		String ret = System.getProperty("user.dir").toString();
		ret = ret.replace("\\","/") + "/";
		return ret;
	}

	/**
	 * 加密,用于ticket URL的组装
	 *
	 * @param s
	 *            the string which is used to encoder
	 * @return
	 */
	public static String encoderBASE64(String s) {
		if (s == null) {
			return null;
		}
		try {
			return Base64.encodeBase64String(s.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			//	logger.warn("Encoder failed");
			return null;
		}
	}

	/**
	 * get keyInfo of Claim
	 *
	 * @param id
	 *
	 * @return
	 */
	public static String getkeyInfo() {
		String jsScript = null;

		jsScript = "return KeyInfo.getClaimId()";

		logger.info("jsScript is:" + jsScript);

		return jsScript;
	}

}