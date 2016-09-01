package com.bydan.framework.global.seguridad.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.activation.DataHandler;

import javax.naming.Context;
import javax.naming.InitialContext;


@SuppressWarnings("unused")
public class Funciones {		
	public static Date ConvertToDate(String sDate,String sFormat)throws Exception  {
		DateFormat formatter=new SimpleDateFormat(sFormat);
		Date date ; 
		//formatter = new SimpleDateFormat(sDate);
		date = (Date)formatter.parse(sDate);   
		
		return date;
	}
	
	public static Date ConvertToDate(String sDate)throws Exception  {
		DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date date ; 
		//formatter = new SimpleDateFormat(sDate);
		date = (Date)formatter.parse(sDate);   
		
		return date;
	}
	
	public static String getStringMySqlCurrentDateTime() {
		Date date = new Date();
        
		String strDateTime="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
		strDateTime=dateFormat.format(date);
	     
		return strDateTime;
	}
	
	public static String getStringMySqlCurrentDate() {
		Date date = new Date();
        
		String strDateTime="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        
		strDateTime=dateFormat.format(date);
	     
		return strDateTime;
	}
	
	public static String getStringFromInputStream(InputStream is) {
		 
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		String line;
		Boolean esPrimer=true;
		
		try {
 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				if(!esPrimer) {
					line="\r\n"+line;
				} else {
					esPrimer=false;
				}
				
				sb.append(line);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return sb.toString();
	}
	
	public static String getStringFecha(String sFecha,Boolean paraFinal) {
		String sFechaFinal=sFecha;
		
		if(paraFinal) {
			sFechaFinal=sFechaFinal.replace("-","Z(X");
			sFechaFinal=sFechaFinal.replace("0","C)V");
			sFechaFinal=sFechaFinal.replace("1","B=N");
			sFechaFinal=sFechaFinal.replace("2","M.A");
			sFechaFinal=sFechaFinal.replace("3","S,D");
			sFechaFinal=sFechaFinal.replace("4","F_G");
			sFechaFinal=sFechaFinal.replace("5","H+J");
			sFechaFinal=sFechaFinal.replace("6","K!L");
			sFechaFinal=sFechaFinal.replace("7","Q*W");
			sFechaFinal=sFechaFinal.replace("8","E:R");
			sFechaFinal=sFechaFinal.replace("9","T$Y");
		} else {
			sFechaFinal=sFechaFinal.replace("Z(X","-");
			sFechaFinal=sFechaFinal.replace("C)V","0");
			sFechaFinal=sFechaFinal.replace("B=N","1");
			sFechaFinal=sFechaFinal.replace("M.A","2");
			sFechaFinal=sFechaFinal.replace("S,D","3");
			sFechaFinal=sFechaFinal.replace("F_G","4");
			sFechaFinal=sFechaFinal.replace("H+J","5");
			sFechaFinal=sFechaFinal.replace("K!L","6");
			sFechaFinal=sFechaFinal.replace("Q*W","7");
			sFechaFinal=sFechaFinal.replace("E:R","8");
			sFechaFinal=sFechaFinal.replace("T$Y","9");
		}
			
		return sFechaFinal;
	}
}
