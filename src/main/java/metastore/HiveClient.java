package metastore;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.RetryingMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.Database;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by fangyitao on 2019/11/5.
 */
public class HiveClient {

    protected final static Logger logger = LoggerFactory.getLogger(HiveClient.class);

    private static IMetaStoreClient client;

    public HiveClient() {
        try {
            HiveConf hiveConf = new HiveConf();
            hiveConf.addResource("hive-site.xml");
            client = RetryingMetaStoreClient.getProxy(hiveConf);
        } catch (MetaException ex) {
            logger.error(ex.getMessage());
        }
    }

    /**
     * ��ȡ�������ݿ�
     * @return
     */
    public static List<String> getAllDatabases() {
        List<String> databases = null;
        try {
            databases = client.getAllDatabases();
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return databases;
    }

    /**
     * ��ȡ���ݿ�
     * @param db
     * @return
     */
    public static Database getDatabase(String db) {
        Database database = null;
        try {
            database = client.getDatabase(db);
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return database;
    }


    /**
     * ��ȡ��ǰ���ݿ�ĳһ�ű�
     * @param db
     * @param table
     * @return
     */
    public static List<FieldSchema> getSchema(String db, String table) {
        List<FieldSchema> schema = null;
        try {
            schema = client.getSchema(db, table);
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return schema;
    }

    /**
     *��ȡ��ǰ���ݿ����б�
     * @param db
     * @return
     */
    public static List<String> getAllTables(String db) {
        List<String> tables = null;
        try {
            tables = client.getAllTables(db);
        } catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return tables;
    }

    /**
     * ��ȡ��ǰ���ݿ�ı�
     * @param db
     * @param table
     * @return
     */
    public static String getLocation(String db, String table) {
        String location = null;
        try {
            location = client.getTable(db, table).getSd().getLocation();
        }catch (TException ex) {
            logger.error(ex.getMessage());
        }
        return location;
    }
}
