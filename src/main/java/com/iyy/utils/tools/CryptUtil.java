package com.iyy.utils.tools;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by dhc on 17-7-18.
 */
public class CryptUtil {
    /**
     * T代码加密
     * @param Tcode
     * @return
     */
    public static String tcodeEncrypt(String Tcode){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String s = base64Encoder.encodeBuffer(Tcode.getBytes());
        String s1 = new StringBuffer(s).reverse().toString();
        return s1.trim();
    }

    /**
     * T代码解密
     * @param s
     * @return
     */
    public static String tcodeDecrypt(String s){
        //翻转字符串
        String s2 = new StringBuilder(s).reverse().toString();
        //等号补位
        int c = s2.length() % 4;
        StringBuilder sb = new StringBuilder();
        if(c>0) {
            for (int i = 0; i < 4 - c; i++) {
                sb.append("=");
            }
        }
        //完整字符串
        s2 += sb.toString();
        try {
            //base64解密
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] bytes = base64Decoder.decodeBuffer(s2);
            String s1 = new String(bytes);
            return s1.toUpperCase();
        }catch (Exception e){
            return s;
        }
    }

    /***
     * md5
     */
    public static String md5(String s) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(s.getBytes("utf-8"));
            StringBuffer buffer = new StringBuffer();
            for (byte b : digest) {
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            return buffer.toString();

        } catch (Exception e) {
            System.out.println("出错拉");

        }
        return null;
    }
}
