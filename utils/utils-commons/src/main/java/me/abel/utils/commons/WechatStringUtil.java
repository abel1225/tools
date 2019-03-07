/**
 * 
 */
package me.abel.utils.commons;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.Random;

/**
*@description: 
*@author: able.li
*@create: 2018/8/3 18:06
*/
public class WechatStringUtil {
	
	
	private static String LOACAL_CHARACTER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static String LOACAL_DIGITAL = "0123456789";
	
	public static String derange(String id){
		int idLength = id.length();
		String target = "";
		for(int i = 0 ; i < idLength ; i ++){
			if(i > 4 && i < 10){
				target += (char)(id.charAt(i) - 1);
			} else {
				target += (char)(id.charAt(i) + 1);
			}
		}
		return target;
	}
	
	public static String range(String id){
		int idLength = id.length();
		String target = "";
		for(int i = 0 ; i < idLength ; i ++){
			if(i > 4 && i < 10){
				target += (char)(id.charAt(i) + 1);
			} else {
				target += (char)(id.charAt(i) - 1);
			}
		}
		return target;
	}
	
	public static String authCode(int keyLength) {
		Random random = new Random();
		String key = "";
		int length = LOACAL_DIGITAL.length();
		for (int i = 0; i < keyLength; i++) {
			key += LOACAL_DIGITAL.charAt(random.nextInt(length));
		}
		return key;
	}
	
	public static String streamToString(InputStream is){
		try{
			StringBuilder xmlMsg= new StringBuilder();
			byte[] b = new byte[4096];    
			for (int n; (n = is.read(b)) != -1;) {    
				xmlMsg.append(new String(b, 0, n, "UTF-8"));    
			}
        	return xmlMsg.toString();
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
			if(is !=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public static String keyCreate(int keySize){
		Random random = new Random();
		String key = "";
		int length = LOACAL_CHARACTER.length();
		for(int i = 0; i<keySize; i++) {
			key += LOACAL_CHARACTER.charAt(random.nextInt(length));
		}
		return key;
	}
	
	public static String urlEnodeUTF8(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String byteToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    
    public static String SHA1(String orign){
        try {
        	MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        	crypt.reset();
        	crypt.update(orign.getBytes("UTF-8"));
        	return byteToHex(crypt.digest());
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
    }
    
}
