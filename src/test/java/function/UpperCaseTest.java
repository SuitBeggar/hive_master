package function;

import jdbc.HiveJDBC;
import jdbc.HiveJDBCTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @Author:bella
 * @Date:2019/12/323:44
 * @Version:
 **/
public class UpperCaseTest {
    public static Logger logger = LoggerFactory.getLogger(UpperCaseTest.class);

    @Test
    public void test()throws Exception{
        String jarPath = "";
        String functionName = "upperCase";
        String packageName = "'function.UpperCase'";
        HiveJDBC.createTempFunction(jarPath,functionName,packageName);
        //HiveJDBC.executeQuery("select ")
    }
}
