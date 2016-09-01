package com.bydan.framework.erp.presentation.desktop.swing;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

@SuppressWarnings("unused")
public class AccionesAuxiliarSwing extends AbstractAction implements Runnable, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginJFrameErp loginJFrameErp=null;
	public String sTipo="";
	
	public AccionesAuxiliarSwing(LoginJFrameErp loginJFrameErp) {
		this.loginJFrameErp=loginJFrameErp;
	}
	
	public AccionesAuxiliarSwing(LoginJFrameErp loginJFrameErp,String sTipo) {
		this.loginJFrameErp=loginJFrameErp;
		this.sTipo=sTipo;
	}
	
	 public void run() {
		 this.loginJFrameErp.setVisible(true);
		 this.loginJFrameErp.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	   	 //new MigrationJFrame().setVisible(true);
	 }
	 
	 public void actionPerformed(java.awt.event.ActionEvent evt) {
         try {
        	 
	        	if(sTipo=="ACEPTAR") {
	        		 this.loginJFrameErp.jButtonAceptarActionPerformed(evt);
	        		 
	        	} else if(sTipo=="CANCELAR") {
	        		this.loginJFrameErp.jButtonCancelarActionPerformed(evt);
	        	}
	        	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     }
}
