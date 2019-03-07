package me.abel.utils.commons;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util{

	public static String encode(String origin, String charsetname) throws UnsupportedEncodingException {
		MessageDigest md;
		try{
			md = MessageDigest.getInstance("MD5");
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}

		if(StringUtils.isEmpty(charsetname)){
			return Hex.encodeHexString(md.digest(origin.getBytes()));
		}
		return Hex.encodeHexString(md.digest(origin.getBytes(charsetname)));
	}
}