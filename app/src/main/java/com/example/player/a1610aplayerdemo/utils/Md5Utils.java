package com.example.player.a1610aplayerdemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public static String MD5(String str){
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        byte[] strTemp = str.getBytes();
        MessageDigest messageDigest;
        try {
            messageDigest=MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        messageDigest.update(strTemp);

        byte tmp[] =messageDigest.digest();

        char outputChars[]=new char[16*2];

        int k = 0;

        for (int i = 0; i < 16; i++) {
            byte byte0 = tmp[i];
            outputChars[k++] = hexDigits[byte0 >>> 4 & 0xf];
            outputChars[k++] = hexDigits[byte0 & 0xf];
        }

        return new String(outputChars).toUpperCase();
    }
}
