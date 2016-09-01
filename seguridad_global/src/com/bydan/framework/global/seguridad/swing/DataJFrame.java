package com.bydan.framework.global.seguridad.swing;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.swing.*;

import javax.swing.UIManager.*;

import com.bydan.framework.global.seguridad.logic.Funciones;
import com.bydan.framework.global.seguridad.logic.GlobalSeguridad;
import com.bydan.framework.global.seguridad.logic.SHA1Encrypte;
import com.bydan.framework.global.seguridad.logic.FuncionesNetwork;

//import com.bydan.erp.service.ejb.interfaces.TipoProfeciaImplementable;
//import com.bydan.erp.util.TipoProfeciaConstantesFunciones;

import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings({ "unused", "serial" })
public class DataJFrame extends JFrame {
		
	private JButton jButtonAceptar;
    private JButton jButtonCancelar;
    private JButton jButtonTestGenerar;
    private JButton jButtonGenerarArchivo;
    private JLabel jLabelUsuario;
    private JLabel jLabelPassword;
    private JLabel jLabelPath;
    private JLabel jLabelTestGenerar;
    private JLabel jLabelGenerarArchivo;
    private JPasswordField jPasswordFieldPassword;
    private JTextField jTextFieldUsuario;
    private JTextField jTextFieldPath;
    
    private JLabel jLabelDatosCliente;
    private JLabel jLabelUsuarioPc;
    private JLabel jLabelNombrePc;
    private JLabel jLabelIpPc;
    private JLabel jLabelMacAddressPc;
    private JLabel jLabelMacAddresssPc;
    private JLabel jLabelFecha;
    private JLabel jLabelClaveSistema;
    private JLabel jLabelClaveArchivo;
    private JLabel jLabelClaveFecha;
    private JLabel jLabelClaveGeneral;
    
    private JTextField jTextFieldUsuarioPc;
    private JTextField jTextFieldNombrePc;
    private JTextField jTextFieldIpPc;
    private JTextField jTextFieldMacAddressPc;
    private JTextField jTextFieldMacAddresssPc;
    private JTextField jTextFieldFecha;
    private JTextField jTextFieldClaveSistema;
    private JTextField jTextFieldClaveArchivo;
    private JTextField jTextFieldClaveFecha;
    private JTextField jTextFieldClaveGeneral;
    
    private JPanel jContentPane;
    private JPanel jPanelLogin;
    
    //private static Logger logger = Logger.getLogger(LoginJFrame.class);  
	
    //static final int xOffset = 10, yOffset = 35;
    public static Boolean CON_CARGAR_MEMORIA_INICIAL=true; 
    
   public static Boolean ME=true;

    
    public DataJFrame() {
    	try {
    		long start = System.currentTimeMillis();  
    		
    		
    		double diff = (double)System.currentTimeMillis() - start;  
    	    System.out.println("time (ms): " + diff);  
    	        
    			
    		initComponents();
    		
    		JRootPane rootPane = this.getRootPane();
    		rootPane.setDefaultButton(this.jButtonAceptar);
    			
    		
    		
    		
    		
    		//this.CargarObjetosRendimientoCritico(new Usuario(),parametroGeneralSg,parametroGeneralUsuario);
    		
    	} catch(Exception e) {
    		try {
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    }

   
    
   
    
   

	private void initComponents() {
    	  
    	int intX=Toolkit.getDefaultToolkit().getScreenSize().width/3-this.getWidth();
    	int intY=Toolkit.getDefaultToolkit().getScreenSize().height/3-this.getHeight();
    	
    	this.setLocation(intX, intY);
    	 
    	String sUsuarioDefault="";
    	String sPasswordDefault="";
    	String sValorDefault="XXX";
    	
    	sUsuarioDefault="811";
    	sPasswordDefault="118";
    	
    	//this.setTitle("Login");
    	//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
		//this.setSize((screenSize.width-xOffset*3)/2,screenSize.height-yOffset*3);
		
		this.setSize(new Dimension(500,400));
		   	
		
    	this.jLabelUsuario = new JLabel();
    	this.jTextFieldUsuario = new JTextField();
    	this.jPasswordFieldPassword = new JPasswordField();
    	this.jTextFieldPath= new JTextField();
    	this.jLabelPassword = new JLabel();
    	this.jLabelPath= new JLabel();
    	this.jLabelTestGenerar= new JLabel();
    	this.jLabelGenerarArchivo= new JLabel();
    	this.jButtonAceptar = new JButton();
    	this.jButtonCancelar = new JButton();
    	this.jButtonTestGenerar= new JButton();
    	this.jButtonGenerarArchivo= new JButton();
    	
    	this.jLabelDatosCliente= new JLabel();
    	this.jLabelUsuarioPc= new JLabel();
    	this.jLabelNombrePc= new JLabel();
    	this.jLabelIpPc= new JLabel();
    	this.jLabelMacAddressPc= new JLabel();
    	this.jLabelMacAddresssPc= new JLabel();
    	this.jLabelFecha= new JLabel();
    	this.jLabelClaveSistema= new JLabel();
    	this.jLabelClaveArchivo= new JLabel();
    	this.jLabelClaveFecha= new JLabel();
    	this.jLabelClaveGeneral= new JLabel();
    	
    	this.jTextFieldUsuarioPc= new JTextField();
    	this.jTextFieldNombrePc= new JTextField();
    	this.jTextFieldIpPc= new JTextField();
    	this.jTextFieldMacAddressPc= new JTextField();
    	this.jTextFieldMacAddresssPc= new JTextField();
    	this.jTextFieldFecha= new JTextField();
    	this.jTextFieldClaveSistema= new JTextField();
    	this.jTextFieldClaveArchivo= new JTextField();
    	this.jTextFieldClaveFecha= new JTextField();
    	this.jTextFieldClaveGeneral= new JTextField();
    	
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("DATA");

        
        this.jLabelUsuario.setText("Usuario");
        this.jLabelPassword.setText("Password");
        this.jLabelPath.setText("Path");
        this.jLabelTestGenerar.setText("Test Generar");
        this.jLabelGenerarArchivo.setText("Generar Archivo");
        
        this.jLabelDatosCliente.setText("DATOS CONFIG CLIENTE");
        
        this.jLabelUsuarioPc.setText("Usuario PC");
        this.jLabelNombrePc.setText("Nombre PC");
        this.jLabelIpPc.setText("Ip PC");
        this.jLabelMacAddressPc.setText("Mac Address PC");
        this.jLabelMacAddresssPc.setText("Mac Address PC TODOS");
        this.jLabelFecha.setText("Fecha");
        this.jLabelClaveSistema.setText("Clave Sistema(N + M)");
        this.jLabelClaveArchivo.setText("Clave Archivo");
        this.jLabelClaveFecha.setText("Clave Fecha");
        this.jLabelClaveGeneral.setText("Clave General");
        
        this.jTextFieldUsuario.setText(sUsuarioDefault);
        this.jTextFieldUsuario.setMinimumSize(new Dimension(100,20));
		this.jTextFieldUsuario.setMaximumSize(new Dimension(100,20));
		this.jTextFieldUsuario.setPreferredSize(new Dimension(100,20));
		
        this.jPasswordFieldPassword.setText(sPasswordDefault);
        this.jPasswordFieldPassword.setMinimumSize(new Dimension(100,20));
		this.jPasswordFieldPassword.setMaximumSize(new Dimension(100,20));
		this.jPasswordFieldPassword.setPreferredSize(new Dimension(100,20));
        
		this.jTextFieldPath.setText("D:/");
        this.jTextFieldPath.setMinimumSize(new Dimension(150,20));
		this.jTextFieldPath.setMaximumSize(new Dimension(150,20));
		this.jTextFieldPath.setPreferredSize(new Dimension(150,20));
		
		//
		this.jTextFieldUsuarioPc.setText(sValorDefault);
        this.jTextFieldUsuarioPc.setMinimumSize(new Dimension(150,20));
		this.jTextFieldUsuarioPc.setMaximumSize(new Dimension(150,20));
		this.jTextFieldUsuarioPc.setPreferredSize(new Dimension(150,20));
		this.jTextFieldUsuarioPc.setEditable(false);
		
		this.jTextFieldNombrePc.setText(sValorDefault);
        this.jTextFieldNombrePc.setMinimumSize(new Dimension(150,20));
		this.jTextFieldNombrePc.setMaximumSize(new Dimension(150,20));
		this.jTextFieldNombrePc.setPreferredSize(new Dimension(150,20));
		this.jTextFieldNombrePc.setEditable(false);
		
		this.jTextFieldIpPc.setText(sValorDefault);
        this.jTextFieldIpPc.setMinimumSize(new Dimension(100,20));
		this.jTextFieldIpPc.setMaximumSize(new Dimension(100,20));
		this.jTextFieldIpPc.setPreferredSize(new Dimension(100,20));
		this.jTextFieldIpPc.setEditable(false);
		
		this.jTextFieldMacAddressPc.setText(sValorDefault);
        this.jTextFieldMacAddressPc.setMinimumSize(new Dimension(300,20));
		this.jTextFieldMacAddressPc.setMaximumSize(new Dimension(300,20));
		this.jTextFieldMacAddressPc.setPreferredSize(new Dimension(300,20));
		this.jTextFieldMacAddressPc.setEditable(false);
		
		this.jTextFieldMacAddresssPc.setText(sValorDefault);
        this.jTextFieldMacAddresssPc.setMinimumSize(new Dimension(300,20));
		this.jTextFieldMacAddresssPc.setMaximumSize(new Dimension(300,20));
		this.jTextFieldMacAddresssPc.setPreferredSize(new Dimension(300,20));
		this.jTextFieldMacAddresssPc.setEditable(false);
		
		this.jTextFieldFecha.setText("2013-12-31");
        this.jTextFieldFecha.setMinimumSize(new Dimension(100,20));
		this.jTextFieldFecha.setMaximumSize(new Dimension(100,20));
		this.jTextFieldFecha.setPreferredSize(new Dimension(100,20));
		
		this.jTextFieldClaveSistema.setText(sValorDefault);
        this.jTextFieldClaveSistema.setMinimumSize(new Dimension(300,20));
		this.jTextFieldClaveSistema.setMaximumSize(new Dimension(300,20));
		this.jTextFieldClaveSistema.setPreferredSize(new Dimension(300,20));
		this.jTextFieldClaveSistema.setEditable(false);
		
		this.jTextFieldClaveArchivo.setText(sValorDefault);
        this.jTextFieldClaveArchivo.setMinimumSize(new Dimension(300,20));
		this.jTextFieldClaveArchivo.setMaximumSize(new Dimension(300,20));
		this.jTextFieldClaveArchivo.setPreferredSize(new Dimension(300,20));
		this.jTextFieldClaveArchivo.setEditable(false);
		
		this.jTextFieldClaveFecha.setText(sValorDefault);
        this.jTextFieldClaveFecha.setMinimumSize(new Dimension(300,20));
		this.jTextFieldClaveFecha.setMaximumSize(new Dimension(300,20));
		this.jTextFieldClaveFecha.setPreferredSize(new Dimension(300,20));
		this.jTextFieldClaveFecha.setEditable(false);
		
		this.jTextFieldClaveGeneral.setText(sValorDefault);
        this.jTextFieldClaveGeneral.setMinimumSize(new Dimension(300,20));
		this.jTextFieldClaveGeneral.setMaximumSize(new Dimension(300,20));
		this.jTextFieldClaveGeneral.setPreferredSize(new Dimension(300,20));
		this.jTextFieldClaveGeneral.setEditable(false);
		
		if(ME) {
			this.jTextFieldNombrePc.setEditable(true);
			this.jTextFieldMacAddressPc.setEditable(true);
			this.jTextFieldMacAddresssPc.setEditable(true);
		}
		
		String sMapKey = "CTRL_1";
		InputMap inputMap =null;
		
        this.jButtonAceptar.setText("ACEPTAR");
               
        this.jButtonAceptar.addActionListener (
        	new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                try {
						jButtonAceptarActionPerformed(evt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }
        );

        sMapKey = "F5";
		inputMap = this.jButtonAceptar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_1 , KeyEvent.CTRL_MASK), sMapKey);
		inputMap.put(KeyStroke.getKeyStroke("F5"), sMapKey);
		
		this.jButtonAceptar.getActionMap().put(sMapKey, new AbstractAction() {
		  private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent evt) {
		    	try {
					jButtonAceptarActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		
        this.jButtonCancelar.setText("CANCELAR");
        
        this.jButtonCancelar.addActionListener (
        	new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		            try {
						jButtonCancelarActionPerformed(evt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
        );

        sMapKey="F6";
        inputMap = this.jButtonCancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_2 , KeyEvent.CTRL_MASK), sMapKey);
        inputMap.put(KeyStroke.getKeyStroke("F6"), sMapKey);
        
		this.jButtonCancelar.getActionMap().put(sMapKey, new AbstractAction() {
		  private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent evt) {
		    	try {
					jButtonCancelarActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		
		this.jButtonTestGenerar.setText("Test Generar");
        
        this.jButtonTestGenerar.addActionListener (
        	new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		            try {
		            	jButtonTestGenerarActionPerformed(evt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
        );
        
        this.jButtonGenerarArchivo.setText("Generar Archivo");
        
        this.jButtonGenerarArchivo.addActionListener (
        	new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		            try {
		            	jButtonGenerarArchivoActionPerformed(evt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
        );
        
        this.jContentPane = new JPanel();//fondo_formulario        
        this.jPanelLogin = new JPanel();  
          
        this.jPanelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        this.jPanelLogin.setToolTipText("Login");
        this.jPanelLogin.setName("Login"); 
        
        
        this.jContentPane.setLayout(new GridBagLayout());
        this.jPanelLogin.setLayout(new GridBagLayout());
       // GridBagLayout gridaBagLayout= new GridBagLayout();
        
        int iFila=0;
        int iYPosicion=iFila++;
        int iXPosicion=0;
		
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelUsuario, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldUsuario, gridBagConstraints);
		
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelPassword, gridBagConstraints);
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jPasswordFieldPassword, gridBagConstraints);
		
		//PATH
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelPath, gridBagConstraints);
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldPath, gridBagConstraints);
		
        //SOLO LABEL DATOS
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelDatosCliente, gridBagConstraints);
						
		
		//USUARIO PC
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelUsuarioPc, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldUsuarioPc, gridBagConstraints);
		
		//NOMBRE PC
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelNombrePc, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldNombrePc, gridBagConstraints);

		
		//IP PC
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelIpPc, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldIpPc, gridBagConstraints);
		

		//MAC ADDRESS
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelMacAddressPc, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldMacAddressPc, gridBagConstraints);


		//MAC ADDRESS TODOS
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelMacAddresssPc, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldMacAddresssPc, gridBagConstraints);

		//FECHA
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelFecha, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jTextFieldFecha, gridBagConstraints);

		//TOPUBLIC
		if(ME) {
			//CLAVE SISTEMA
			iYPosicion=iFila++;
			iXPosicion=0;
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jLabelClaveSistema, gridBagConstraints);
			
			
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jTextFieldClaveSistema, gridBagConstraints);
	
			
			//CLAVE ARCHIVO
			iYPosicion=iFila++;
			iXPosicion=0;
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jLabelClaveArchivo, gridBagConstraints);
			
			
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jTextFieldClaveArchivo, gridBagConstraints);
	
			//CLAVE FECHA
			iYPosicion=iFila++;
			iXPosicion=0;
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jLabelClaveFecha, gridBagConstraints);
			
			
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jTextFieldClaveFecha, gridBagConstraints);
			
			//CLAVE GENERAL
			iYPosicion=iFila++;
			iXPosicion=0;
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jLabelClaveGeneral, gridBagConstraints);
			
			
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jTextFieldClaveGeneral, gridBagConstraints);
			
			//BOTON TEST GENERAR
			iYPosicion=iFila++;
			iXPosicion=0;
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jLabelTestGenerar, gridBagConstraints);
			
			
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints.gridy = iYPosicion;
			gridBagConstraints.gridx = iXPosicion++;			
			this.jPanelLogin.add(this.jButtonTestGenerar, gridBagConstraints);
		}	
	        
		
		//BOTON GENERAR ARCHIVO
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jLabelGenerarArchivo, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jButtonGenerarArchivo, gridBagConstraints);
		
			
		//BOTONES
		iYPosicion=iFila++;
		iXPosicion=0;
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jButtonAceptar, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = iYPosicion;
		gridBagConstraints.gridx = iXPosicion++;			
		this.jPanelLogin.add(this.jButtonCancelar, gridBagConstraints);
		
		
		//PANEL PRINCIPAL
        gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy =0;		
		gridBagConstraints.gridx = 0;
		this.jContentPane.add(this.jPanelLogin, gridBagConstraints);
				
		
		this.setContentPane(this.jContentPane);
		
		
		/*
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAceptar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabelPassword))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldUsuario, GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldPassword, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();|
        */ 
		
		
    }

   
    
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	try {    		
	    	/*
    		if(GlobalSeguridad.validarLicenciaCliente("informix", "bydan-PC", "192.168.1.2", "C0-A8-01-02",new Date(), 1L, false, "a325f24db2daa06f73d490cd16ebb90c8409a160")) {
    			System.out.println("OK");
    		}
    		*/
    		
    		this.traerDatosCliente();
    		
    		//JOptionPane.showMessageDialog(this,"GENERADO CORRECTAMENTE","DATOS CLIENTE",JOptionPane.INFORMATION_MESSAGE);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
	    	JOptionPane.showMessageDialog(this,"ERROR:"+e.getMessage(),"DATOS CLIENTE",JOptionPane.ERROR_MESSAGE);
     	}
    }
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	try {
	    	quit();
	    	
	    } catch(Exception e) {
		}
    }
    
    private void jButtonTestGenerarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	try {
	    		   		   		
    		//CLASE SISTEMA
    		String sEncript=this.getClaveSistema();	    	
	    	this.jTextFieldClaveSistema.setText(sEncript);
	    	
	    	
	    	//CLAVE ARCHIVO
	    	sEncript=this.getClaveGeneral(true);	    	
	    	this.jTextFieldClaveArchivo.setText(sEncript);
	    	
	    	//CLAVE FECHA
	    	sEncript=this.getClaveFecha();	    	
	    	this.jTextFieldClaveFecha.setText(sEncript);
	    	
	    	//CLAVE GENERAL
	    	sEncript=this.getClaveGeneral(false);	    	
	    	this.jTextFieldClaveGeneral.setText(sEncript);
	    	
	    	//JOptionPane.showMessageDialog(this,"GENERADO CORRECTAMENTE","DATOS CLIENTE",JOptionPane.INFORMATION_MESSAGE);
	    	
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	JOptionPane.showMessageDialog(this,"ERROR:"+e.getMessage(),"DATOS CLIENTE",JOptionPane.ERROR_MESSAGE);
		}
    }
    
    private void jButtonGenerarArchivoActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	BufferedWriter bufferedWriter = null;
		String sStringFile="";
		String sPath="";
		String sNombreArchivo="licencia";
		
    	try {
	    		
    		if(ME) {
    			sNombreArchivo="vdatos";
    		} 
    		
    		sPath=this.jTextFieldPath.getText()+sNombreArchivo+".txt";
    				
    		bufferedWriter = new BufferedWriter(new FileWriter(sPath));
			
			sStringFile=this.getDatosArchivo();
			
			bufferedWriter.write(sStringFile);
			
			bufferedWriter.close();
			
			JOptionPane.showMessageDialog(this,"ARCHIVO GENERADO CORRECTAMENTE:  "+sPath,"DATOS CLIENTE",JOptionPane.INFORMATION_MESSAGE);
	    	
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	JOptionPane.showMessageDialog(this,"ERROR:"+e.getMessage(),"DATOS CLIENTE",JOptionPane.ERROR_MESSAGE);
	    	
	    } finally {			
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}	
		}
    }
    
    public String getDatosArchivo() {
    	String sDatos="";
    	
    	sDatos+="USUARIO_PC="+this.jTextFieldUsuarioPc.getText().trim();
    	sDatos+="\r\nNOMBRE_PC="+this.jTextFieldNombrePc.getText().trim();
    	sDatos+="\r\nIP_PC="+this.jTextFieldIpPc.getText().trim();
    	sDatos+="\r\nMAC_PC="+this.jTextFieldMacAddressPc.getText().trim();
    	sDatos+="\r\nFECHA_PC="+this.jTextFieldFecha.getText().trim();
    	
    	if(ME) {
    		sDatos+="\r\nC._SISTEMA="+this.jTextFieldClaveSistema.getText().trim();
    		sDatos+="\r\nC._ARCHIVO="+this.jTextFieldClaveArchivo.getText().trim();
    		sDatos+="\r\nC._FECHA="+this.jTextFieldClaveFecha.getText().trim();
    		sDatos+="\r\nC._GENERAL="+this.jTextFieldClaveGeneral.getText().trim();
    	}
    	
    	return sDatos;
    }
    
    private String getClaveSistema() throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	String sStringParaClave=this.jTextFieldNombrePc.getText();
    	String sEncript="";
    			
    	if(!this.jTextFieldMacAddressPc.getText().contains("127.0.0.1")
    		&& !this.jTextFieldMacAddressPc.getText().equals("")) {
    		sStringParaClave+=this.jTextFieldMacAddressPc.getText();
    	}
    	
    	sEncript=SHA1Encrypte.SHA1(sStringParaClave);
    	
    	return sEncript;
    }
    
    private String getClaveGeneral(Boolean esParaArchivo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	    String sStringParaClave=this.jTextFieldNombrePc.getText();
		
	    String sEncript=SHA1Encrypte.SHA1(sStringParaClave);
			   
	    if(esParaArchivo) {
	    	sEncript=sEncript.substring(0,20);
	    }
	    
		return sEncript;
	}

    private String getClaveFecha() throws NoSuchAlgorithmException, UnsupportedEncodingException {	    		
	    String sEncript="";
			   
	    sEncript=Funciones.getStringFecha(this.jTextFieldFecha.getText(),true);
	    
		return sEncript;
	}
    
    protected void quit() {
        System.exit(0);
    }
    
   
    public static void main(String args[]) {
    	//LoginJFrame.SetLookAndFeel(1L);
    	 
        java.awt.EventQueue.invokeLater (
        	new Runnable() {
	            public void run() {
	                //new LoginJFrame().setVisible(true);
	            	try {
						//new SistemaBeanSwingJInternalFrame().setVisible(true);
	            		new DataJFrame().setVisible(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
        	}
       );
    } 
    
    @SuppressWarnings("deprecation")
	public void traerDatosCliente() throws Exception {
    	Boolean isUsuario=false;
    	Boolean isClave=false;
    	
    	String sEncript="";
    	
    	/*
    	String sEncript=SHA1Encrypte.SHA1("xxx");
    	System.out.println("xxx="+sEncript);
    	
    	sEncript=SHA1Encrypte.SHA1("yyy");
    	System.out.println("yyy="+sEncript);
    	*/
    	
    	sEncript=SHA1Encrypte.SHA1(this.jTextFieldUsuario.getText());
    	
    	if(sEncript.equals("6f8246002c1c5967ffc5e0ec80f2d7b59a60b1e3")) {
    		isUsuario=true;
    		
    	}
    	
    	sEncript=SHA1Encrypte.SHA1(this.jPasswordFieldPassword.getText());
    	
    	if(sEncript.equals("12f0de3dc76e067d21ed85125716e02e9f1e69f0")) {
    		isClave=true;
    	}
    	
    	if(isUsuario && isClave) {
	    	this.jTextFieldUsuarioPc.setText(FuncionesNetwork.getHostUser());
	    	this.jTextFieldNombrePc.setText(FuncionesNetwork.getHostName());
	    	this.jTextFieldIpPc.setText(FuncionesNetwork.getHostIp());
	    	this.jTextFieldMacAddressPc.setText(FuncionesNetwork.getPrimerMacAddress());
	    	this.jTextFieldMacAddresssPc.setText(FuncionesNetwork.getTodosMacAddress());
	    	
	    	String sStringParaClave="";
	    	
	    	//CLAVE SISTEMA
	    	sEncript=this.getClaveSistema();	    	
	    	this.jTextFieldClaveSistema.setText(sEncript);
	    	
	    	/*
	    	sStringParaClave=this.jTextFieldNombrePc.getText();
	    	
	    	if(!this.jTextFieldMacAddressPc.getText().contains("127.0.0.1")
	    		&& !this.jTextFieldMacAddressPc.getText().equals("")) {
	    		sStringParaClave+=this.jTextFieldMacAddressPc.getText();
	    	}
	    	
	    	sEncript=SHA1Encrypte.SHA1(sStringParaClave);
	    	*/
	    	
	    	
	    	
	    	//CLAVE ARCHIVO
	    	sEncript=this.getClaveGeneral(true);	    	
	    	this.jTextFieldClaveArchivo.setText(sEncript);
	    	

	    	//CLAVE FECHA
	    	sEncript=this.getClaveFecha();	    	
	    	this.jTextFieldClaveFecha.setText(sEncript);
	    	
	    	
	    	//CLAVE GENERAL
	    	sEncript=this.getClaveGeneral(false);	    	
	    	this.jTextFieldClaveGeneral.setText(sEncript);
	    	
	    	/*
	    	sStringParaClave=this.jTextFieldNombrePc.getText();
	    	sEncript=SHA1Encrypte.SHA1(sStringParaClave);
	    	*/	    		    	
    	}
    }
}