package page;

import org.openqa.selenium.By;
import utils.PropertiesUtils;

public class SubmitBugPage {
    public static final By  MENU_QA = By.xpath(PropertiesUtils.getPropertyStr("menuqa_XPATH"));
    public static final  By SUB_MENU_BUG =By.xpath(PropertiesUtils.getPropertyStr("submenubug_XPATH"));
    public static final  By ADD_BUG_BTN = By.xpath(PropertiesUtils.getPropertyStr("addbugBtn_XPATH"));
    public static final  By PRODUCT_CHOSENINPUT =By.xpath(PropertiesUtils.getPropertyStr("product_chosenInput_XPATH"));
   // public static final  By PRODUCT_CHOSENSELECT =By.xpath(PropertiesUtils.getPropertyStr("product_chosenSelect_XPATH"));
    public static final  By MODULEID_CHOSENINPUT = By.xpath(PropertiesUtils.getPropertyStr("moduleId_chosenInput_XPATH"));
    //public static final  By MODULEID_CHOSENSELECT = By.xpath(PropertiesUtils.getPropertyStr("moduleId_chosenSelect_XPATH"));
    public static final By BUILDBOX_INPUT = By.xpath(PropertiesUtils.getPropertyStr("buildBox_input_XPATH"));
    //public static final By BUILDBOX_SELECT= By.xpath(PropertiesUtils.getPropertyStr("buildBox_select_XPATH"));
    public static final By ASSIGNEDTO_INPUT= By.xpath(PropertiesUtils.getPropertyStr("assignedTo_input_XPATH"));
    //public static final By ASSIGNEDTO_SELECT= By.xpath(PropertiesUtils.getPropertyStr("assignedTo_select_XPATH"));
    public static final By TITLE=By.xpath(PropertiesUtils.getPropertyStr("title_XPATH"));
    public static final By IFRAME=By.xpath(PropertiesUtils.getPropertyStr("iframe_XPATH"));
    public static final By BUG_STEP= By.xpath(PropertiesUtils.getPropertyStr("bugStep_XPATH"));
    public static final By BUG_RESULT= By.xpath(PropertiesUtils.getPropertyStr("bugResult_XPATH"));
    public static final By BUG_EXPECT= By.xpath(PropertiesUtils.getPropertyStr("bugExpect_XPATH"));
    public static final By FILE_CONTROL= By.xpath(PropertiesUtils.getPropertyStr("fileControl_XPATH"));
    public static final By FILE_BOX= By.xpath(PropertiesUtils.getPropertyStr("fileBox_XPATH"));
    public static final By SUBMIT_BTN= By.xpath(PropertiesUtils.getPropertyStr("submitBtn_XPATH"));
    //public static final By BUT_TITLE= By.xpath(PropertiesUtils.getPropertyStr("butTitle_XPATH"));
    public static final By BUT_CODE= By.xpath(PropertiesUtils.getPropertyStr("butcode_XPATH"));
    public static final By BUT_ACTIVE_STATUS= By.xpath(PropertiesUtils.getPropertyStr("butActiveStatus_XPATH"));
    public static By product_chosenSelect(String str){
         By PRODUCT_CHOSENSELECT;
         return  PRODUCT_CHOSENSELECT = By.xpath(PropertiesUtils.getPropertyStr("product_chosenSelect_XPATH")+str+"']");
    }
    public static By moduleid_chosenSelect(String str){
        By MODULEID_CHOSENSELECT;
        return  MODULEID_CHOSENSELECT = By.xpath(PropertiesUtils.getPropertyStr("moduleId_chosenSelect_XPATH")+str+"']");
    }
    public static By buildbox_chosenSelect(String str){
        By BUILDBOX_SELECT;
        return  BUILDBOX_SELECT = By.xpath(PropertiesUtils.getPropertyStr("buildBox_select_XPATH")+str+"']");
    }
    public static By assignedto_chosenSelect(String str){
        By ASSIGNEDTO_SELECT;
        return  ASSIGNEDTO_SELECT = By.xpath(PropertiesUtils.getPropertyStr("assignedTo_select_XPATH")+str+"')]");
    }
    public static By but_title(String str){
        By BUT_TITLE;
        return  BUT_TITLE = By.xpath(PropertiesUtils.getPropertyStr("butTitle_XPATH")+str+"']");
    }
}
