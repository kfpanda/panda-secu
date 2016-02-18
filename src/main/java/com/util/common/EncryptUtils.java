package com.util.common;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.MessageDigest;



public  class EncryptUtils {

	/// <summary>
    /// md5加密
    /// </summary>
    /// <param name="data">待加密字符串</param>
    /// <returns></returns>
	public final static String MD5(String data) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = data.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
    /// <summary>
    /// 3des解码
    /// </summary>
    /// <param name="value">待解密字符串</param>
    /// <param name="key">原始密钥字符串</param>
    /// <returns></returns>
    public static String decrypt3DES(String value, String key) throws Exception {
        byte[] b = decryptMode(getKeyBytes(key), Base64.decode(value));
        return new String(b);
    }

 

    /// <summary>
    /// 3des加密
    /// </summary>
    /// <param name="value">待加密字符串</param>
    /// <param name="strKey">原始密钥字符串</param>
    /// <returns></returns>
    public static String encrypt3DES(String value, String key) throws Exception {
        String str = byte2Base64(encryptMode(getKeyBytes(key), value.getBytes()));
        return str;
    }
 

    //计算24位长的密码byte值,首先对原始密钥做MD5算hash值，再用前8位数据对应补全后8位
    public static byte[] getKeyBytes(String strKey) throws Exception {
        if (null == strKey || strKey.length() < 1)
            throw new Exception("key is null or empty!");
 
        java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
        alg.update(strKey.getBytes());
        byte[] bkey = alg.digest();
        //System.out.println("md5key.length=" + bkey.length);
        //System.out.println("md5key=" + byte2Hex(bkey));
        int start = bkey.length;
        byte[] bkey24 = new byte[24];
        for (int i = 0; i < start; i++) {
            bkey24[i] = bkey[i];
        }

        for (int i = start; i < 24; i++) {//为了与.net16位key兼容
            bkey24[i] = bkey[i - start];
        }

 
        //System.out.println("byte24key.length=" + bkey24.length);
        //System.out.println("byte24key=" + byte2Hex(bkey24));
        return bkey24;
    }

 

    private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish       

 

    //keybyte为加密密钥，长度为24字节

    //src为被加密的数据缓冲区（源）  

    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm); //加密 
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
       } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

 

    //keybyte为加密密钥，长度为24字节  
    //src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try { //生成密钥   
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            //解密     
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

 

    //转换成base64编码
    public static String byte2Base64(byte[] b) {
        return Base64.encode(b);
    }

 

    //转换成十六进制字符串  
    public static String byte2Hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }
}

   
/*
    public static void main(String[] args) {
        String key = "abcd1234";
        String password = "password";
        System.out.println("key=" + key + ",password=" + password);
        System.out.println();
        System.out.println("----------示例开始：使用java写的算法加密解密-----------");
       try {
            String encrypt = "";
            String decrypt = "";
           byte[] bkey = EncryptUtils.GetKeyBytes(key);
            encrypt = EncryptUtils.byte2Base64(EncryptUtils.encryptMode(bkey, password.getBytes()));
            System.out.println("用预转换密钥算加密结果=" + encrypt);
            System.out.println("加密后base64表示=" + EncryptUtils.byte2hex(Base64.decode(encrypt)));
            System.out.println("调用原始密钥算加密结果=" + EncryptUtils.Encrypt3DES(password, key));

           try {
                decrypt = new String(EncryptUtils.decryptMode(bkey, Base64.decode(encrypt)));
                System.out.println("用预转换密钥算解密结果=" + decrypt);
                System.out.println("调用原始密钥算解密结果=" + EncryptUtils.Decrypt3DES(encrypt, key));
            } catch (Exception ex) {
                System.out.println("Exception:" + ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
        }
        System.out.println("----------示例结束：使用java写的算法加密解密-----------");
    }
}
----------示例开始：使用java写的算法加密解密-----------

md5key.length=16

md5key=E1:9D:5C:D5:AF:03:78:DA:05:F6:3F:89:1C:74:67:AF

byte24key.length=24

byte24key=E1:9D:5C:D5:AF:03:78:DA:05:F6:3F:89:1C:74:67:AF:E1:9D:5C:D5:AF:03:78:DA

用预转换密钥算加密结果=ftwPzxFH4WpzT4Orq8uSLQ==

 

加密后base64表示=7E:DC:0F:CF:11:47:E1:6A:73:4F:83:AB:AB:CB:92:2D

md5key.length=16

md5key=E1:9D:5C:D5:AF:03:78:DA:05:F6:3F:89:1C:74:67:AF

byte24key.length=24

byte24key=E1:9D:5C:D5:AF:03:78:DA:05:F6:3F:89:1C:74:67:AF:E1:9D:5C:D5:AF:03:78:DA

调用原始密钥算加密结果=ftwPzxFH4WpzT4Orq8uSLQ==

 

用预转换密钥算解密结果=password

md5key.length=16

md5key=E1:9D:5C:D5:AF:03:78:DA:05:F6:3F:89:1C:74:67:AF

byte24key.length=24

byte24key=E1:9D:5C:D5:AF:03:78:DA:05:F6:3F:89:1C:74:67:AF:E1:9D:5C:D5:AF:03:78:DA

调用原始密钥算解密结果=password

*/