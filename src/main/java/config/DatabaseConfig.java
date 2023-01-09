package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class DatabaseConfig {

    static Properties prop = new Properties();
    static {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("application.properties");

        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static String DRIVER_NAME = prop.getProperty("db.driver");
    public final static String DB_HOST = System.getProperty("RDS_HOSTNAME");
    public final static String DB_PORT = System.getProperty("RDS_PORT");
    public final static String DB_NAME = System.getProperty("RDS_DB_NAME");
    public final static String DB_USER_NAME = System.getProperty("RDS_USERNAME");
    public final static String DB_PASSWORD = System.getProperty("RDS_PASSWORD");
    public final static String CONNECTION_STRING = DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

}
