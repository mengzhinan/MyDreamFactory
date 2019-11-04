package com.duke.mybase64;

import android.text.TextUtils;
import android.util.Log;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-10-11 11:30
 * description: base64 编码思路
 * 1、输入数据转换为字节数组
 * 2、每次取出三个字节，即 3 * 8 = 24 bit
 * 3、在上面 24 bit 中分别取出 6 bit，再各自在高位补 2 个 0，形成 4 * 6 = 24 bit（或者说是 4 * 8 = 24 bit）
 * 4、然后取出每个 6 bit 的字节，转换成 int 值的范围为 0 ~ 63，即对应编码数组的字符输出
 * 5、
 * 6、
 */
public class MyBase64 {
    private static final String B = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String BASE_64 = B + "+/";
    private static final String BASE_64_URL = B + "-_";

    private static final int DEFAULT_RULE_SIZE = 3;

    // 编码字符集
    private String mBaseChars;

    private MyBase64(String baseStr) {
        this.mBaseChars = baseStr;
        if (TextUtils.isEmpty(baseStr)) {
            this.mBaseChars = BASE_64;
        }
    }

    public static MyBase64 getBase64() {
        Log.v("ddffa","A = " + ("A".getBytes().toString()));
        byte[] b = "A".getBytes();
        String ddd = "";
        for (int i = 0; i < b.length; i++) {
            ddd += b[i];
        }
        Log.v("ddffa","ddd = " + Integer.toBinaryString(65));

        return new MyBase64(BASE_64);
    }

    public static MyBase64 getBase64URL() {
        return new MyBase64(BASE_64_URL);
    }


    public String encode(byte[] bytes) {
        bytes = InnerHelper.adjustForEncode(bytes, DEFAULT_RULE_SIZE);
        StringBuilder stringBuilder = new StringBuilder();
        int forSize = bytes.length / DEFAULT_RULE_SIZE;
        byte[] buffer = new byte[DEFAULT_RULE_SIZE];
        for (int i = 0; i < forSize; i++) {
            System.arraycopy(bytes, i * DEFAULT_RULE_SIZE, buffer, 0, DEFAULT_RULE_SIZE);
            stringBuilder.append(InnerHelper.encodeByteArray(buffer, mBaseChars));
        }
        return stringBuilder.toString();
    }

    private static class InnerHelper {

        /**
         * 将原始数据数组长度补位，补齐到倍数(比喻补充到 3 整除)
         *
         * @param sourceBytes 原始数组
         * @param bit         需要调整的长度倍数
         * @return
         */
        private static byte[] adjustForEncode(byte[] sourceBytes, int bit) {
            int remainder = sourceBytes.length % bit;
            if (remainder == 0) {
                return sourceBytes;
            }
            int newLength = (sourceBytes.length / bit + 1) * bit;
            byte[] newBytes = new byte[newLength];
            System.arraycopy(sourceBytes, 0, newBytes, 0, sourceBytes.length);
            return newBytes;
        }

        /**
         * 将原始的三个字节数组拆分并编码为字符串
         *
         * @param array
         * @return
         */
        private static String encodeByteArray(byte[] array, String baseChars) {

            return "";
        }



//        private static int to(){
//
//            Log.v("","");
////            Integer.parseInt(bin6Str[i], 2);
//
//
//
//            Integer.toString(101,10);
//            Integer.valueOf("0101",2).toString();
//        }
    }


}
