package utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class  MyAssert extends Assertion {
   
  	public static List<Error> errors = new ArrayList<Error>();
  	public static boolean flag = true;
  	private static Logger logger = Logger.getLogger(MyAssert.class); 
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
	    	errors.add(e);
	    	flag = false;
	    }
		
 	}
	 
}
