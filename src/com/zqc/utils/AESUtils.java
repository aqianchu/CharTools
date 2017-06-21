package com.zqc.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AESUtils {

    private static final String CBC_KEYS = "62ac6afdd993c395";
    private static final String IV_KEYS = "e593c395b953c508";

    public static String encode(byte[] data) {
        byte[] enc = aesEnc(data);
        if(enc != null) {
            return Base64.encodeToString(enc, Base64.DEFAULT);
        }
        return null;
    }

	public static String decode(String decodedMessage) {
		try {
			if (TextUtils.isEmpty(decodedMessage)) {
				return "";
			}
			byte[] enc = Base64.decode(decodedMessage, Base64.DEFAULT);
			if (enc == null || enc.length == 0) {
				return null;
			}
			byte[] dec = aesDec(enc);
            if(dec != null){
                return new String(dec);
            }else{
                return "";
            }
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

    private static byte[] aesEnc(byte[] data) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(CBC_KEYS.getBytes(), "AES");
            IvParameterSpec iv = new IvParameterSpec(IV_KEYS.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            return cipher.doFinal(data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] aesDec(byte[] enc) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(CBC_KEYS.getBytes(), "AES");
            IvParameterSpec iv = new IvParameterSpec(IV_KEYS.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            int outLen = cipher.getOutputSize(enc.length);
            byte[] cryptBytes = new byte[outLen];
            int cryptSize = cipher.doFinal(enc, 0, enc.length, cryptBytes, 0);
            byte[] retBytes = new byte[cryptSize];
            System.arraycopy(cryptBytes, 0, retBytes, 0, cryptSize);
            return retBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    
    
    }
 
}
