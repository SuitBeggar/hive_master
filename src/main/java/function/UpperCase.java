package function;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * hive自定义udf
 * create temporary function UpperCase as "function.UpperCase" ;(创建临时函数)
 * @description:
 * @Author:bella
 * @Date:2019/12/323:28
 * @Version:
 **/
public class UpperCase extends UDF{
    public Text evaluate(final Text s) {
        if(s==null) {return null ;}
        return new Text(s.toString().toUpperCase());
    }
    public String evaluate( String s) {
        if(s==null) {return null ;}
        return new String(s.toString().toUpperCase());
    }
}
