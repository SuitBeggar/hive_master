package jdbc;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by fangyitao on 2019/11/5.
 */

public class HiveJDBCTest {

    public static Logger logger = LoggerFactory.getLogger(HiveJDBCTest.class);

    @Test
    public void test(){
        try {
            HiveJDBC.showDatabases();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
