package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import utils.LogConfiguration;
import utils.MyAction;
import utils.ReadExcel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import utils.SeleniumUtils;

public class BaseDataPrepare {
    protected BrowserEmulator browserEmulator ;
    protected WebDriver driver  ;
    protected JavascriptExecutor jsExecutor  ;
    protected MyAction myAction;
    protected SeleniumUtils seleniumUtils;
    public static Logger logger = Logger.getLogger(BaseDataPrepare.class);
    @BeforeClass
    public void initTest() throws InterruptedException, IOException {
        browserEmulator = new BrowserEmulator();
        driver = browserEmulator.getDriver();
        jsExecutor = browserEmulator.getJavaScriptExecutor();
        myAction = new MyAction(driver);
        seleniumUtils = new SeleniumUtils(driver);
        //使log4j的配置生效，以便输出日志
        LogConfiguration.initLog(this.getClass().getSimpleName());
     }
    @AfterClass
    public void clenTest() {
        if(driver!=null){
          driver.quit();
        }else{
            Assert.fail("driver没有获得对象,退出操作失败");
        }
    }
    @DataProvider()
    public Object[][] readExcel(Method method)throws FileNotFoundException {
        String methodName = method.getName();
        if(methodName.equals("loginToHome")){
            return ReadExcel.rangeData("loginToHome");
        }
        else if(methodName.equals("bugFlow")){
            return ReadExcel.rangeData("bugFlow");
        }
        else{
            return  null;
         }
     }
}
