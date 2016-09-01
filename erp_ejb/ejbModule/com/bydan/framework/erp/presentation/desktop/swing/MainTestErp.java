package com.bydan.framework.erp.presentation.desktop.swing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.bydan.framework.erp.util.Constantes;

@SuppressWarnings("unused")
public class MainTestErp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//com.bydan.framework.erp.util.Constantes.PROVIDER_URL="http://bydan.homelinux.com:80/invoker/JNDIFactory";
		//System.out.println(com.bydan.framework.erp.util.Constantes.PROVIDER_URL);
		//com.bydan.framework.erp.util.Constantes.PROVIDER_URL="http://0.0.0.0:80/invoker/JNDIFactory";
		// TODO Auto-generated method stub
		
		Properties propertiesConfig = new Properties();
		
		try {
            //load a properties file
			//propertiesConfig.load(new FileInputStream("config/config.properties"));
	
	        //get the property value and print it out
	        //System.out.println(propertiesConfig.getProperty("is_debug"));
	 		
			/*
			if(propertiesConfig.getProperty("is_debug").equals("true")) {
				Constantes.ISDEVELOPING=true;
			} else {
				Constantes.ISDEVELOPING=false;
			}
			*/
			LoginJFrameErp loginJFrameErp = new LoginJFrameErp();
			
	        SwingUtilities.invokeLater(new AccionesAuxiliarSwing(loginJFrameErp));
	        
	 	 } catch (Exception ex) {
	 		ex.printStackTrace();
	     }				
	}

}
