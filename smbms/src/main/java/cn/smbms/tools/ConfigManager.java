package cn.smbms.tools;

import cn.smbms.dao.BaseDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager configManager ;
    private static Properties params;

    private ConfigManager() {
        params = new Properties();
        String configFile = "database.properties";
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
        try {
            params.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class InitInstance{
        private static ConfigManager init = new ConfigManager();
    }

    public static ConfigManager getInstance(){
        configManager = InitInstance.init;
        return configManager;
    }


    /*public static synchronized ConfigManager getInstance() {
        if (configManager == null) {
            configManager = new ConfigManager();
        }
        return configManager;
    }*/


    public  String getValue(String key) {
        return params.getProperty(key);
    }
}
