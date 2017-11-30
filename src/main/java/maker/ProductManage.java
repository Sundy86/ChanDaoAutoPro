package maker;

import java.io.IOException;
import common.BaseDataPrepare;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testcase.AssignBug;
import testcase.CloseBug;
import testcase.FixedBug;
import testcase.HomePage;
import testcase.LoginPage;
import testcase.SearchBug;
import testcase.SubmitBug;
import utils.ThreadUtils;

@Listeners({utils.AssertionListener.class})
public class ProductManage extends BaseDataPrepare {
	//本类日志对象
	public static Logger logger = Logger.getLogger(ProductManage.class);
 	@Test(dataProvider="readExcel",dataProviderClass = BaseDataPrepare.class,priority = 5)
	public void loginToHome(String adminAccount,String password) throws Exception{
		new LoginPage(driver).Login(adminAccount,password);
		logger.info("检查是否成功登陆系统：" + driver.getCurrentUrl());
		ThreadUtils.ThreadSleep(2);
 		/* //新增产品
		 String productName = new CreatProduct(driver,jsExecutor).addPro();
		 //新增项目
		 String projectName = new CreatProject(driver,jsExecutor).addProject(productName);
		 //新增版本
		 String versionName = new AddVersion(driver,jsExecutor).addVersion();
		 //新增用户
		 String account = new AddUserandPower(driver,jsExecutor).addUser();
		 //项目关联用户
		 new ProjectRelationUser(driver,jsExecutor).relationUser(account, projectName);
		 //产品新增模块
		 String moduleName= new AddmoduleForProduct(driver,jsExecutor).addModule(productName);
		 */
		//新增bug,指派bug，解决bug，关闭bug
		//bugFlow("admin","123456","Product2SC3371","userSC6162","V1.0.0","moduleSC1157");
	}
	@Test(dependsOnMethods = {"loginToHome"}, dataProvider = "readExcel", dataProviderClass = BaseDataPrepare.class,
 	description = "bug flow ",priority = 6)
	public void bugFlow(String adminAccount,String password,String productName,String account,String versionName,String moduleName) throws InterruptedException, IOException, Exception{

		//创建bug
		String bugCode =new SubmitBug(driver,seleniumUtils).submitBug(productName,versionName,moduleName,account);
	//	String bugCode = new SubmitBug(driver,myAction).submitBug(productName,versionName,moduleName);
		//bug指派
//		logger.info("bug指派");
//		new AssignBug(driver).assign(account);
//		//退出当前用户（admin）
//		new LoginPage(driver).loginOut();
//		//用户登录
//		new LoginPage(driver).Login(account,password);
//		//进入禅道主页面
//		new HomePage(driver).enterHome(productName);
//		//搜索bug，进入到bug页面
//		new SearchBug(driver).searchToBugSingle(bugCode);
//		//返回bug 列表
//		new HomePage(driver).backToList();
//		//搜索bug,搜索完成后返回buglist
//		new SearchBug(driver).searchToBugList(bugCode);
//		//解决bug
//		new FixedBug(driver).fixbug(bugCode,versionName);
//		//退出当前用户
//		new LoginPage(driver).loginOut();
//		//用户登录（admin）
//		new LoginPage(driver).Login(adminAccount,password);
//		//进入禅道主页面
//		new HomePage(driver).enterHome(productName);
//		//搜索bug,搜索完成后返回buglist
//		new SearchBug(driver).searchToBugList(bugCode);
//		//关闭bug
//		new CloseBug(driver).closeBug();
	}



}
