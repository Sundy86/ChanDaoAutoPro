package pagehelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

public class SubmitBugPageHelper {
    public static Logger logger = Logger.getLogger(SubmitBugPageHelper.class);
    public static  void clickOnPage(SeleniumUtils seleniumUtil, By byElement){
        seleniumUtil.click(byElement);
    }
    public static WebElement findOneElement(SeleniumUtils seleniumUtil, By byElement){
          return  seleniumUtil.findSingleElement(byElement);
    }
    public static void setValue(SeleniumUtils seleniumUtil, By byElement,String str){
        seleniumUtil.typeContent(byElement,str);
    }
    public static void clickSubmit(SeleniumUtils seleniumUtil, By byElement){
        seleniumUtil.submit(byElement);
    }
    public static String getElementText(SeleniumUtils seleniumUtil, By byElement){
       return seleniumUtil.getText(byElement);
    }
    public static void changeFrame(SeleniumUtils seleniumUtil, WebElement frame){
         seleniumUtil.switchToFrame(frame);
    }
    public static void setFrameValue(SeleniumUtils seleniumUtil, WebElement element,String str){
        seleniumUtil.setFrameContext(element,str);
    }
    public static void changeFrameDefault(SeleniumUtils seleniumUtil){
        seleniumUtil.switchToDefault();
    }
    public static void assertIsEquals(SeleniumUtils seleniumUtil,String actual,String expected,String message){
        seleniumUtil.assertEquals(actual,expected,message);
    }


}
