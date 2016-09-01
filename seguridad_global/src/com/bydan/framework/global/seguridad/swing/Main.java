package com.bydan.framework.global.seguridad.swing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.SwingUtilities;

@SuppressWarnings("unused")
public class Main {

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
			//BYDAN_ERROR
			//propertiesConfig.load(new FileInputStream("config/config.properties"));	
			//propertiesConfig.load(new FileInputStream("config.properties"));
			
	        //get the property value and print it out
	        //System.out.println(propertiesConfig.getProperty("is_debug"));
	 		
	
	        SwingUtilities.invokeLater(new Runnable() {						
			      public void run() {
			        new DataJFrame().setVisible(true);
			    	//new MigrationJFrame().setVisible(true);
			      }
			});
	        
	 	 } catch (Exception ex) {
	 		ex.printStackTrace();
	     }				
	}

}
