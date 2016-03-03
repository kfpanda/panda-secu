package com.util.common.safe;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.Md5Crypt;

public class MD5 {

    /**
     * @param str 参数
     * @return String
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0){
                    i += 256;
                }
                if (i < 16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    
    public static String MD5Salt(String username, String pwd){
    	return Md5Crypt.apr1Crypt(username.getBytes(), pwd);
    }
    /**
     * @param args 参数
     */
    public static void main(String[] args) {
//        System.out.println(md5("123456"));
     System.out.println(Md5Crypt.apr1Crypt("superadmin", "a123456"));
    }
}
