package testcase;

import java.io.IOException;

import common.GlobalSettings;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.SubmitBugPage;
import pagehelper.SubmitBugPageHelper;
import utils.*;

import static page.SubmitBugPage.*;


public class SubmitBug {
	WebDriver driver;
 	SeleniumUtils seleniumUtils;
	private  Logger logger = Logger.getLogger(SubmitBug.class);
	public SubmitBug(WebDriver driver,SeleniumUtils seleniumUtils) throws InterruptedException, IOException {
		this.driver = driver;
 		this.seleniumUtils = seleniumUtils;
	}
	public String submitBug(String productName,String versionName,String moduleName,String account) throws Exception {
		logger.info("创建bug");
		//点击测试菜单
		SubmitBugPageHelper.clickOnPage(seleniumUtils,MENU_QA);

		//点击测试菜单的子菜单---bug
		logger.info("点击测试菜单的子菜单");
		SubmitBugPageHelper.clickOnPage(seleniumUtils,SUB_MENU_BUG);

		//点击提bug
		logger.info("点击提bug");
		SubmitBugPageHelper.clickOnPage(seleniumUtils,ADD_BUG_BTN);

		//选择产品模块
		logger.info("选择产品模块");
		SubmitBugPageHelper.clickOnPage(seleniumUtils,PRODUCT_CHOSENINPUT);
		SubmitBugPageHelper.clickOnPage(seleniumUtils,SubmitBugPage.product_chosenSelect(productName));

		//选择模块
		logger.info("选择模块");
		SubmitBugPageHelper.clickOnPage(seleniumUtils,MODULEID_CHOSENINPUT);
		SubmitBugPageHelper.clickOnPage(seleniumUtils,SubmitBugPage.moduleid_chosenSelect(moduleName));

		//影响版本
		logger.info("选择影响版本");
		SubmitBugPageHelper.clickOnPage(seleniumUtils,BUILDBOX_INPUT);
		SubmitBugPageHelper.clickOnPage(seleniumUtils,SubmitBugPage.buildbox_chosenSelect(versionName));

		//当前指派
		logger.info("选择当前指派人");
		SubmitBugPageHelper.clickOnPage(seleniumUtils,ASSIGNEDTO_INPUT);
		SubmitBugPageHelper.clickOnPage(seleniumUtils,SubmitBugPage.assignedto_chosenSelect(account));

		//Bug标题
		String title ="用户名为空时，提交应提示"+NumRandom.random();
		SubmitBugPageHelper.setValue(seleniumUtils,TITLE,title);

 //		//切换iframe
		logger.info("切换iframe");
 		SubmitBugPageHelper.changeFrame(seleniumUtils,SubmitBugPageHelper.findOneElement(seleniumUtils,IFRAME));
		//重现步骤
		WebElement step1 = SubmitBugPageHelper.findOneElement(seleniumUtils,BUG_STEP);
		WebElement step2 =SubmitBugPageHelper.findOneElement(seleniumUtils,BUG_RESULT);
		WebElement step3 = SubmitBugPageHelper.findOneElement(seleniumUtils,BUG_EXPECT);

		SubmitBugPageHelper.setFrameValue(seleniumUtils,step1,"用户名为空时，点击提交");
		SubmitBugPageHelper.setFrameValue(seleniumUtils,step2,"用户名为空时，提交时没有提示");
		SubmitBugPageHelper.setFrameValue(seleniumUtils,step3,"用户名为空时，提交应提示");

		//跳出iFrame
		SubmitBugPageHelper.changeFrameDefault(seleniumUtils);
 		//附件
		String filePath = GlobalSettings.picFilePath;
		SubmitBugPageHelper.setValue(seleniumUtils,FILE_CONTROL,filePath);

 		//附件标题
		SubmitBugPageHelper.setValue(seleniumUtils,FILE_BOX,"我是附件");

		//保存
		ThreadUtils.ThreadSleep(5);
		SubmitBugPageHelper.clickSubmit(seleniumUtils,SUBMIT_BTN);

 		//点击bug标题
 		SubmitBugPageHelper.clickOnPage(seleniumUtils,SubmitBugPage.but_title(title));
		String bugCode = SubmitBugPageHelper.getElementText(seleniumUtils,BUT_CODE);

		logger.info("当前bug的编号为："+bugCode);
		ScreenshotTakes.screenShot(driver);
		String status = SubmitBugPageHelper.getElementText(seleniumUtils,BUT_ACTIVE_STATUS);

		SubmitBugPageHelper.assertIsEquals(seleniumUtils,"激活", status,"检查当前bug的状态是否为激活:");
 		return bugCode;

	}

}
