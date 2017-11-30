package utils;

import common.BrowserEmulator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SeleniumUtils {
    public WebDriver driver  ;
    public static Logger logger = Logger.getLogger(SeleniumUtils.class);

    public SeleniumUtils(WebDriver driver) throws InterruptedException {
        this.driver = driver;
    }

    /**通过By对象 去查找某个元素*/
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    /**清空元素内容*/
    public void clear(By byElement){
        WebElement element = findElement(byElement);
        element.clear();
        logger.info("清空元素："+getLocatorByElement(element, ">")+"上的内容");
    }

    /**元素中输入内容*/
    public void typeContent(By byElement,String str){
        WebElement element = findElement(byElement);
        element.sendKeys(str);
        ThreadUtils.ThreadSleep(3);
        logger.info("在元素："+getLocatorByElement(element, ">")+"  中输入内容："+str);
    }

    /**点击*/
    public void click(By byElement){
        WebElement element = findElement(byElement);
        try{
            element.click();
            ThreadUtils.ThreadSleep(3);
            logger.info("点击元素："+getLocatorByElement(element, ">"));
        }catch(Exception e){
            logger.error("点击元素:"+getLocatorByElement(element, ">")+"失败", e);
            Assert.fail("点击元素:"+getLocatorByElement(element, ">")+"失败", e);
        }
    }

    /** 根据元素来获取此元素的定位值 */
    public String getLocatorByElement(WebElement element, String expectText) {
        String text = element.toString();
        String expect = null;
        try {
            expect = text.substring(text.indexOf(expectText) + 1, text.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("failed to find the string [" + expectText + "]");
        }
        return expect;
    }
    /**提交*/
    public void submit(By by){
        WebElement element=findElement(by);
        try{
            element.submit();
        }catch(Exception e){
            logger.error("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
            Assert.fail("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
        }
        logger.info("在元素："+getLocatorByElement(element, ">")+"做了提交操作");
    }
    /**获取文本1*/
    public String getText(By by){
        return findElement(by).getText().trim();
    }
    /**跳转到指定frame*/
    public void switchToFrame(WebElement frame){
        try{
            driver.switchTo().frame(frame);
        }catch(Exception e){
            logger.error("没有这个frame:"+frame);
            Assert.fail("没有这个frame:"+frame);
        }

    }
    /*给元素赋值*/
    public void setFrameContext(WebElement element,String str){
             Actions action = new Actions(driver);
             action.sendKeys(element, str).perform();
            logger.info("在元素："+getLocatorByElement(element, ">")+"  中输入内容："+str);
    }
    /**查找一个元素  查找元素方法*/
    public WebElement findSingleElement(By byElement) {
        WebElement element = null;
        try{
            element = findElement(byElement);
            logger.info("查找元素："+byElement+ "成功");
        }catch(Exception e){
            logger.error("查找元素:"+byElement+"失败", e);
            Assert.fail("查找元素:"+byElement+"失败", e);
        }
        return element;
    }
    /*切换到默认frame*/
      public  void switchToDefault(){
        driver.switchTo().defaultContent();
        ThreadUtils.ThreadSleep(3);
    }
    /**断言取值比较*/
    public void assertEquals(String actual,String expected,String message){
        String inp1 = actual.trim();
        String inp2 = expected.trim();

        logger.info("begin assert ["+inp1+"] ["+inp2+"]");
        if(StringUtils.isBlank(inp1)){
            inp1="";
        }
        if(StringUtils.isBlank(inp2)){
            inp2="";
        }
        try{
            Assert.assertEquals(inp1,inp2,message);
            logger.info(message+"  assert contains ok!["+inp1+"] ["+inp2+"]");
        }catch (AssertionError  e) {
            logger.info(message+"  assert contains fail!["+inp1+"] ["+inp2+"]");
         }

    }
}
