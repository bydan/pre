package com.bydan.framework.global.seguridad.logic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
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
public class FuncionesNetwork {
	public static String getPrimerMacAddress() throws Exception {
		String sPrimerMacAddress=FuncionesNetwork.getPrimerMacAddressBase(true,false);
		
		return sPrimerMacAddress;
	}
	
	public static String getTodosMacAddress() throws Exception {
		String sPrimerMacAddress=FuncionesNetwork.getPrimerMacAddressBase(false,true);
		
		return sPrimerMacAddress;
	}
	
	public static String getPrimerMacAddressBase(Boolean esDefecto,Boolean conTodosMac) throws Exception {
		String sPrimerMacAddress="NONE";
		StringBuilder stringBuilder = new StringBuilder();
		Boolean esPrimero=true;
		
		try {
			
			if(esDefecto) {
					InetAddress inetAddress=null;
					
					inetAddress = InetAddress.getLocalHost();
					
					NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
					
					byte[] macAddress = networkInterface.getHardwareAddress();
					
					//byte[] macAddress =inetAddress.getAddress();
			    	  
			    	if(macAddress != null) {
			    	      for (int i = 0; i < macAddress.length; i++) {
			    	    	  stringBuilder.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
			    	      }
			    	}
			    	  
			    	sPrimerMacAddress=stringBuilder.toString();				
				
		    	  
			} else {
				Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
				
				 while (networkInterfaces.hasMoreElements()) {
				      NetworkInterface networkInterface = networkInterfaces.nextElement();
				      List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();
				      Iterator<InterfaceAddress> interfaceAddressIterator = interfaceAddresses.iterator();
				      
				      //NO ESTA FUNCIONANDO O ES VIRTUAL
				      if(!networkInterface.isUp() || networkInterface.isVirtual() 
				    		  	|| networkInterface.isPointToPoint() || networkInterface.isLoopback()) {
				    	  continue;
				      }
				      
				      while (interfaceAddressIterator.hasNext()) {
				    	  InterfaceAddress interfaceAddress = interfaceAddressIterator.next();
				    	  InetAddress inetAddress=interfaceAddress.getAddress();
				    	  stringBuilder = new StringBuilder();
				    	  
				    	  byte[] macAddress = networkInterface.getHardwareAddress();
				    	  
				    	 //byte[] macAddress =inetAddress.getAddress();
				    	   
				    	  if(macAddress != null) {
				    	      for (int i = 0; i < macAddress.length; i++) {
				    	    	  stringBuilder.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
				    	      }
				    	  }
				    	  
				    	  if(!conTodosMac) {
				    		  sPrimerMacAddress=stringBuilder.toString();				    	  				    	 
				    		  break;
				    	  } else {
				    		  
				    		  if(!esPrimero) {
				    			  sPrimerMacAddress+=","; 
				    			  
				    		  }  else {
				    			  sPrimerMacAddress="";
				    		  }
				    		  
				    		  sPrimerMacAddress+=stringBuilder.toString();
				    		  
				    		  if(esPrimero) {
				    			  esPrimero=false;
				    		  }
				    	  }
				      }
				      
				      if(!conTodosMac) {
				    	  break;
				      }
				 }
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sPrimerMacAddress;
	}
	
	public static String getHostName() throws Exception {
		String sHostname = "NONE";

		try {
			InetAddress inetAddress=null;
			
			inetAddress = InetAddress.getLocalHost();
			
			sHostname = inetAddress.getHostName();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sHostname;
	}
	
	public static String getHostIp() throws Exception {
		String sHostname = "NONE";

		try {
			InetAddress inetAddress=null;
			
			inetAddress = InetAddress.getLocalHost();
			
			sHostname = inetAddress.getHostAddress();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sHostname;
	}
	
	public static String getHostUser() throws Exception {
		String sHostname = "NONE";

		try {
			sHostname=System.getProperty("user.name");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sHostname;
	}
}