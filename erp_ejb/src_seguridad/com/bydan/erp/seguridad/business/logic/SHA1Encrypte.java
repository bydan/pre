package com.bydan.erp.seguridad.business.logic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Encrypte {

	private static String convertToHex(byte[] byData) {
        StringBuffer stringBuffer = new StringBuffer();
        
        for (int i = 0; i < byData.length; i++) {
        	
        	int halfbyte = (byData[i] >>> 4) & 0x0F;
        	int two_halfs = 0;
        	
        	do {
	            if ((0 <= halfbyte) && (halfbyte <= 9)) {
	                stringBuffer.append((char) ('0' + halfbyte));
	            
	            } else {
	            	stringBuffer.append((char) ('a' + (halfbyte - 10)));
	            }
	            
	            halfbyte = byData[i] & 0x0F;
	            
        	} while(two_halfs++ < 1);
        }
        
        return stringBuffer.toString();
    }
 
	public static String SHA1(String sText)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String sShai1=SHA1Encrypte.SHA1Base(sText,40);
		
		return sShai1;
    }
    
	//SOLO FUNCIONA PARA iTamanio=40
    public static String SHA1Base(String sText, int iTamanio)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest messageDigest;
		
		messageDigest = MessageDigest.getInstance("SHA-1");
		
		byte[] bySha1hash = new byte[iTamanio];
		
		messageDigest.update(sText.getBytes("iso-8859-1"), 0, sText.length());
		
		bySha1hash = messageDigest.digest();
		
		return SHA1Encrypte.convertToHex(bySha1hash);
    }
}
