package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTakes {
	public static  void screenShot(WebDriver driver){
		String dirName="screenshot";
		if(!(new File(dirName).isDirectory())){ // 判断是否存在该目录
			new File(dirName).mkdir();// 如果不存在则新建一个目录
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date());

		try {
			//执行屏幕截图，默认会把截图保存到temp目录
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//这里将截图另存到我们需要保存的目录，例如screenshot\20120406-165210.png
			FileUtils.copyFile(sourceFile, new File(dirName+File.separator+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
