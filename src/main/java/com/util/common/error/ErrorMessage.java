package com.util.common.error;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.kfpanda.core.FilePath;


/**
 * 系统错误信息实现类
 * @author liuhualuo
 */
public class ErrorMessage {
    private static Properties msgProp;

    /**
     * 载入配置文件
     */
    private static void loadMsgProp(){
        if(msgProp != null){
            return ;
        }
        try {
            msgProp = new Properties();
            msgProp.load(new FileInputStream(FilePath.getAbsolutePathWithClass() + "/properties/message.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取错误消息
     * @param key
     * @return
     */
    public static String getErrorMsg(String key){
        loadMsgProp();
        return msgProp.get(key + ".msg").toString();
    }

    /**
     * 获取错误码
     * @param key
     * @return
     */
    public static int getErrorMsgCode(String key){
        loadMsgProp();
        return Integer.parseInt(msgProp.get(key + ".code").toString());
    }

}
