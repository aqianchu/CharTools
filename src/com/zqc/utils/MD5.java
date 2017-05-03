
package com.zqc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5 {

    private static final char[] HEX = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    private static String toHex(byte[] b) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            int v = b[i];
            builder.append(HEX[(0xF0 & v) >> 4]);
            builder.append(HEX[0x0F & v]);
        }
        return builder.toString();
    }

    /**
     *  璁＄畻鏂囦欢md5锛岃繑鍥瀖d5瀛楃涓茬殑瀛楁瘝涓哄ぇ鍐�
     *  浣跨敤鍓嶈纭繚鏂囦欢鏄惁瀛樺湪
     * */
    public static String getFileMd5Upper(File file) {
        InputStream fis = null;
        byte[] buffer = new byte[1024];
        int numRead = 0;
        MessageDigest md5;

        try {
            fis = new FileInputStream(file);
            md5 = MessageDigest.getInstance("MD5");
            while ((numRead = fis.read(buffer)) > 0) {
                md5.update(buffer, 0, numRead);
            }

            return toHex(md5.digest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static String getFileMd5Lower(File file) {
        String md5 = getFileMd5Upper(file);
        if (md5 != null) {
            return md5.toLowerCase();
        }
        return md5;
    }


    /**
     * 璁＄畻瀛楃涓瞞d5锛岃繑鍥瀖d5瀛楃涓茬殑瀛楁瘝涓哄ぇ鍐�
     * */
    public final static String getStringMd5Upper(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 鑾峰緱MD5鎽樿绠楁硶鐨� MessageDigest 瀵硅薄
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 浣跨敤鎸囧畾鐨勫瓧鑺傛洿鏂版憳瑕�
            mdInst.update(btInput);
            // 鑾峰緱瀵嗘枃
            byte[] md = mdInst.digest();
            // 鎶婂瘑鏂囪浆鎹㈡垚鍗佸叚杩涘埗鐨勫瓧绗︿覆褰㈠紡
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

    /**
     * 璁＄畻瀛楃涓瞞d5锛岃繑鍥瀖d5瀛楃涓茬殑瀛楁瘝涓哄皬鍐�
     * */
    public static String getStringMd5Lower(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 璁＄畻瀛楄妭涓瞞d5锛岃繑鍥瀖d5瀛楃涓茬殑瀛楁瘝涓哄皬鍐�
     * */
    public static String getBytesMd5Lower(byte[] bytes) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] digest = md.digest();
            String text;
            for (int i = 0; i < digest.length; i++) {
                text = Integer.toHexString(0xFF & digest[i]);
                if (text.length() < 2) {
                    text = "0" + text;
                }
                hexString.append(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }
}
