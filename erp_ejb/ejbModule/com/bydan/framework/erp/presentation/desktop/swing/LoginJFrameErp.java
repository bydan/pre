package com.bydan.framework.erp.presentation.desktop.swing;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

import org.apache.log4j.Logger;

import javax.swing.UIManager.*;

//import com.bydan.erp.service.ejb.interfaces.TipoProfeciaImplementable;
//import com.bydan.erp.util.TipoProfeciaConstantesFunciones;
import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.util.ConnexionType;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.util.ParameterDbType;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.Pagination;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.logic.*;

import java.awt.event.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings({ "unused", "serial" })
public class LoginJFrameErp extends JFrame{
	/*
	protected static SistemaImplementable sistemaImplementable=SistemaConstantesFunciones.getSistemaImplementableEjbReference(SistemaConstantesFunciones.SREMOTEEJBNAMEADDITIONAL);//LoginJFrame.lookupRemoteStatelessCalculator2();//
	
	protected static SistemaAdditionable sistemaAdditionable=SistemaConstantesFunciones.getSistemaAdditionableEjbReference(SistemaConstantesFunciones.SREMOTEEJBNAMEADDITIONAL);//LoginJFrame.lookupRemoteStatelessCalculator();//
	//protected static SistemaAdditionableHome sistemaAdditionableHome= SistemaConstantesFunciones.getSistemaAdditionableHomeEjbReference(SistemaConstantesFunciones.SLOCALEJBNAMEADDITIONAL);
	
	
	protected static ParametroGeneralSgImplementable parametroGeneralSgImplementable=ParametroGeneralSgConstantesFunciones.getParametroGeneralSgImplementableEjbReference(ParametroGeneralSgConstantesFunciones.SREMOTEEJBNAMEADDITIONAL);
	//protected static ParametroGeneralSgImplementableHome parametroGeneralSgImplementableHome= ParametroGeneralSgConstantesFunciones.getParametroGeneralSgImplementableHomeEjbReference(ParametroGeneralSgConstantesFunciones.SLOCALEJBNAMEADDITIONAL);
	
	protected static ParametroGeneralUsuarioImplementable parametroGeneralUsuarioImplementable=ParametroGeneralUsuarioConstantesFunciones.getParametroGeneralUsuarioImplementableEjbReference(ParametroGeneralUsuarioConstantesFunciones.SREMOTEEJBNAMEADDITIONAL);
	//protected static ParametroGeneralUsuarioImplementableHome parametroGeneralUsuarioImplementableHome= ParametroGeneralUsuarioConstantesFunciones.getParametroGeneralUsuarioImplementableHomeEjbReference(ParametroGeneralUsuarioConstantesFunciones.SLOCALEJBNAMEADDITIONAL);
	*/
	
	protected SistemaLogicAdditional sistemaLogicAdditional;
	protected UsuarioLogicAdditional usuarioLogicAdditional;
	protected ParametroGeneralSgLogic parametroGeneralSgLogic;
	protected ParametroGeneralSg parametroGeneralSg;
	protected ParametroGeneralUsuarioLogic parametroGeneralUsuarioLogic;
	protected ParametroGeneralUsuario parametroGeneralUsuario;
	protected Usuario usuarioActual;
	
	protected DatosCliente datosCliente;
	
	private JButton jButtonAceptar;
    private JButton jButtonCancelar;
    private JLabel jLabelUsuario;
    private JLabel jLabelPassword;
    private JPasswordField jPasswordFieldPassword;
    private JTextField jTextFieldUsuario;
    
    private JPanel jContentPane;
    private JPanel jPanelLogin;
    
    //static final int xOffset = 10, yOffset = 35;
    public static Boolean CON_CARGAR_MEMORIA_INICIAL=true; 
    
    /*
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static SistemaAdditionable lookupRemoteStatelessCalculator() {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        SistemaAdditionable sistemaAdditionable=null;
        try {
        final Context context = new InitialContext(jndiProperties);
        
	      // The JNDI lookup name for a stateless session bean has the syntax of:
	      // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
	      //
	      // <appName> The application name is the name of the EAR that the EJB is deployed in 
	      //           (without the .ear).  If the EJB JAR is not deployed in an EAR then this is
	      //           blank.  The app name can also be specified in the EAR's application.xml
	      //           
	      // <moduleName> By the default the module name is the name of the EJB JAR file (without the
	      //              .jar suffix).  The module name might be overridden in the ejb-jar.xml
	      //
	      // <distinctName> : AS7 allows each deployment to have an (optional) distinct name. 
	      //                  This example does not use this so leave it blank.
	      //
	      // <beanName>     : The name of the session been to be invoked.
	      //
	      // <viewClassName>: The fully qualified classname of the remote interface.  Must include
	      //                  the whole package name.

        	// let's do the lookup
        String sClassName=SistemaAdditionable.class.getName();
       
        sistemaAdditionable=(SistemaAdditionable) context.lookup("ejb:/erp_ejb/SistemaHomeRemoteAdditional!" + sClassName);
        //sistemaAdditionable=(SistemaAdditionable) context.lookup("java:global/erp_ejb/SistemaHomeRemoteAdditional!com.bydan.erp.seguridad.service.ejb.interfaces.SistemaAdditionable");
        //java:app/erp_ejb/SistemaHomeRemoteAdditional!com.bydan.erp.seguridad.service.ejb.interfaces.SistemaAdditionable

        } catch(Exception e) {
        	e.printStackTrace();
        }
      
      return sistemaAdditionable;
    }
    */
    
    /*
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static SistemaImplementable lookupRemoteStatelessCalculator2() {
    	
    	final Hashtable jndiProperties = new Hashtable();
        
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        SistemaImplementable sistemaImplementable=null;
        try {
        final Context context = new InitialContext(jndiProperties);
                  
        String sClassName=SistemaImplementable.class.getName();
       
        sistemaImplementable=(SistemaImplementable) context.lookup("ejb:/erp_ejb/SistemaHomeRemote!" + sClassName);
        	
       
        Object sistemas=sistemaImplementable.getEntities("", new DatosCliente());
        
        //sistemaAdditionable=(SistemaAdditionable) context.lookup("java:global/erp_ejb/SistemaHomeRemoteAdditional!com.bydan.erp.seguridad.service.ejb.interfaces.SistemaAdditionable");
        //java:app/erp_ejb/SistemaHomeRemoteAdditional!com.bydan.erp.seguridad.service.ejb.interfaces.SistemaAdditionable

        } catch(Exception e) {
        	e.printStackTrace();
        }
      
      return sistemaImplementable;
    }
    */

    
    public LoginJFrameErp() {
    	try {
    		long start = System.currentTimeMillis();  
    		EntityManagerFactory JPAENTITYMANAGERFACTORY=null;
    		
    		if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
    			JPAENTITYMANAGERFACTORY=Persistence.createEntityManagerFactory("PersistenceUnitSeguridad");
    		}
    		
    		double diff = (double)System.currentTimeMillis() - start;  
    	    System.out.println("time (ms): " + diff);  
    	        
    		datosCliente=new DatosCliente();
    		sistemaLogicAdditional=new SistemaLogicAdditional();
    		usuarioLogicAdditional=new UsuarioLogicAdditional();    		    	
    		parametroGeneralSgLogic=new ParametroGeneralSgLogic();
    		parametroGeneralUsuarioLogic=new ParametroGeneralUsuarioLogic();
    		
    		initComponents();
    		
    		if(Constantes.ISDEVELOPING) {    			    			
    			//JRootPane rootPane = this.getRootPane();
    			//rootPane.setDefaultButton(this.jButtonAceptar);
    			
    		}
    		
    		this.cargarParametroGeneral();
    		
    		//ESTE PASO DEMORA EN CARGAR
    		//LoginJFrame.CargarObjetosRendimientoCritico("TIPO1");
    		
    		//this.CargarObjetosRendimientoCritico(new Usuario(),parametroGeneralSg,parametroGeneralUsuario);
    		
    	} catch(Exception e) {
    		try {
				//FuncionesSwing.manageException(this, e,logger);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    }

    public static void CargarObjetosRendimientoCritico(String sTipo) {
    	/*
    	if(sTipo.equals("TIPO1")) {
    		
    		MainJFrameSeguridad.AUX_TEMP="CARGADO";
    		MainJFrameContabilidad.AUX_TEMP="CARGADO";
    		
    		MainJFrameActivosFijos.AUX_TEMP="CARGADO";
    		MainJFrameCartera.AUX_TEMP="CARGADO";
    		MainJFrameCuentasPorPagar.AUX_TEMP="CARGADO";
    		MainJFrameCuentasPorCobrar.AUX_TEMP="CARGADO";    		
    		
    		
    	} else if(sTipo.equals("TIPO2")) {
    		
    		MainJFrameFacturacion.AUX_TEMP="CARGADO";
    		MainJFrameComisiones.AUX_TEMP="CARGADO";
    		MainJFrameInventario.AUX_TEMP="CARGADO";
    		
    		MainJFrameNomina.AUX_TEMP="CARGADO";
    		MainJFrameImportaciones.AUX_TEMP="CARGADO";
    		MainJFrameTesoreria.AUX_TEMP="CARGADO";
    		
    		MainJFrameProduccion.AUX_TEMP="CARGADO";
    		MainJFramePuntoVenta.AUX_TEMP="CARGADO";
    		
    	}
    	*/
    }
    
    public static void CargarObjetosRendimientoCriticoPorModulo(Modulo moduloUsuarioSeleccionado,Opcion opcionActual,Usuario usuarioActual,ParametroGeneralSg parametroGeneralSg,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,JDesktopPane desktop) throws Exception {
    	/*
    	if(moduloUsuarioSeleccionado.getId().equals(1L)) {
    		MainJFrameContabilidad.AUX_TEMP="CARGADO";
    		LoginJFrame.CargarObjetosRendimientoCriticoModuloContabilidad(opcionActual,usuarioActual,parametroGeneralSg,parametroGeneralUsuario,moduloActual,desktop);
    	}
    	*/
    	
    	int id_modulo=moduloUsuarioSeleccionado.getId().intValue();
    	
    	
    }       
    
    
    
    public void cargarParametroGeneral() throws Exception {
    	this.cargarDatosCliente();
    	
    	String finalQuery=SeguridadSql.GetWhereParametroGeneralActivo(this.parametroGeneralSgLogic.getConnexionType(), this.parametroGeneralSgLogic.getParameterDbType());
		
    	
    	//LoginJFrame.SetLookAndFeel(Integer.parseInt(this.parametroGeneralSg.getid_tipo_visual().toString()));
    }
    
    public void cargarParametroGeneralUsuario(Long lIdUsuario) throws Exception {
    	this.cargarDatosCliente();
    	
    	
    }
    
    public ParametroGeneralSg getParametroGeneralSg() {
		return parametroGeneralSg;
	}

	public void setParametroGeneralSg(ParametroGeneralSg parametroGeneralSg) {
		this.parametroGeneralSg = parametroGeneralSg;
	}

	
	public ParametroGeneralUsuario getParametroGeneralUsuario() {
		return parametroGeneralUsuario;
	}

	public void setParametroGeneralUsuario(
			ParametroGeneralUsuario parametroGeneralUsuario) {
		this.parametroGeneralUsuario = parametroGeneralUsuario;
	}

	private void initComponents() {
    	  
    	int intX=Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getWidth();
    	int intY=Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getHeight();
    	
    	 
    	String sUsuarioDefault="";
    	String sPasswordDefault="";
    	
    	if(Constantes.ISDEVELOPING) {
    		sUsuarioDefault="ADMIN";
    		sPasswordDefault="123456";
    	}
    	//this.setTitle("Login");
    	//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
		//this.setSize((screenSize.width-xOffset*3)/2,screenSize.height-yOffset*3);
		
		this.setSize(new Dimension(300,150));
		   	
		//this.setIconImage(FuncionesSwingMe.getImagenBackground(Constantes2.S_ICON_IMAGE));		
		
    	this.jLabelUsuario = new JLabel();
    	this.jTextFieldUsuario = new JTextField();
    	this.jPasswordFieldPassword = new JPasswordField();
    	this.jLabelPassword = new JLabel();
    	this.jButtonAceptar = new JButton();
    	this.jButtonCancelar = new JButton();

    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Login");

        this.jLabelUsuario.setText("Usuario");
        this.jLabelPassword.setText("Password");
                
        this.jTextFieldUsuario.setText(sUsuarioDefault);
        this.jTextFieldUsuario.setMinimumSize(new Dimension(100,20));
		this.jTextFieldUsuario.setMaximumSize(new Dimension(100,20));
		this.jTextFieldUsuario.setPreferredSize(new Dimension(100,20));
		
        this.jPasswordFieldPassword.setText(sPasswordDefault);
        this.jPasswordFieldPassword.setMinimumSize(new Dimension(100,20));
		this.jPasswordFieldPassword.setMaximumSize(new Dimension(100,20));
		this.jPasswordFieldPassword.setPreferredSize(new Dimension(100,20));
        
		String sMapKey = "CTRL_1";
		InputMap inputMap =null;
		
        this.jButtonAceptar.setText("Aceptar");
               
        
        //new AccionesAuxiliarSwing(this,"ACEPTAR")
        
        this.jButtonAceptar.addActionListener (new AccionesAuxiliarSwing(this,"ACEPTAR"));

        sMapKey = "F5";
		inputMap = this.jButtonAceptar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_1 , KeyEvent.CTRL_MASK), sMapKey);
		inputMap.put(KeyStroke.getKeyStroke("F5"), sMapKey);
		
		this.jButtonAceptar.getActionMap().put(sMapKey,new AccionesAuxiliarSwing(this,"ACEPTAR"));
		
		
        this.jButtonCancelar.setText("Cancelar");
        
        this.jButtonCancelar.addActionListener (new AccionesAuxiliarSwing(this,"CANCELAR"));

        sMapKey="F6";
        inputMap = this.jButtonCancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_2 , KeyEvent.CTRL_MASK), sMapKey);
        inputMap.put(KeyStroke.getKeyStroke("F6"), sMapKey);
        
		this.jButtonCancelar.getActionMap().put(sMapKey, new AccionesAuxiliarSwing(this,"CANCELAR"));
		
		
        this.jContentPane = new JPanel();//fondo_formulario        
        this.jPanelLogin = new JPanel();  
          
        this.jPanelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        this.jPanelLogin.setToolTipText("Login");
        this.jPanelLogin.setName("Login"); 
        
        
        this.jContentPane.setLayout(new GridBagLayout());
        this.jPanelLogin.setLayout(new GridBagLayout());
       // GridBagLayout gridaBagLayout= new GridBagLayout();
        
			
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 0;			
		this.jPanelLogin.add(this.jLabelUsuario, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 1;			
		this.jPanelLogin.add(this.jTextFieldUsuario, gridBagConstraints);
		
        
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridx = 0;			
		this.jPanelLogin.add(this.jLabelPassword, gridBagConstraints);
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridx = 1;			
		this.jPanelLogin.add(this.jPasswordFieldPassword, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridx = 0;			
		this.jPanelLogin.add(this.jButtonAceptar, gridBagConstraints);
		
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridx = 1;			
		this.jPanelLogin.add(this.jButtonCancelar, gridBagConstraints);
		
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

    private void cargarDatosCliente() {
    	this.datosCliente.setIdUsuario(17L);
		this.datosCliente.setsIPPC("0.0.0.0");
		this.datosCliente.setsNamePC("x");
		this.datosCliente.setsUsuarioPC("u");
    }
    
    public void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	try {
    		/*
    		Properties propertiesConfig = new Properties();
    		 
        	//load a properties file
    		propertiesConfig.load(new FileInputStream("config/config.properties"));
     
        	String sDbUser=propertiesConfig.getProperty("db_user");
        	String sDbPassword=propertiesConfig.getProperty("db_password");
        	String sDatabase=propertiesConfig.getProperty("database");
        	String sDbPort=propertiesConfig.getProperty("db_port");
        	*/
        	//System.out.println(sDbUser+"-"+sDbPassword+"-"+sDatabase+"-"+sDbPort);
        	 
           
        	
    		//System.out.println(com.bydan.framework.erp.util.Constantes.PROVIDER_URL);
    		//System.out.println(com.bydan.framework.erp.util.Constantes.PROVIDER_URL);
    		
    		this.cargarDatosCliente();
    		
    		//TipoProfeciaImplementable tipoprofeciaImplementable= TipoProfeciaConstantesFunciones.getTipoProfeciaImplementableEjbReference(TipoProfeciaConstantesFunciones.SREMOTEEJBNAME);

    		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));	
			
	    	String sUsuario=this.jTextFieldUsuario.getText();
	    	String sPassword=new String(this.jPasswordFieldPassword.getPassword());
	    	
	    	
	    	//OpcionImplementable opcionImplementable=OpcionConstantesFunciones.getOpcionImplementableEjbReference(OpcionConstantesFunciones.SREMOTEEJBNAME);
	    	
	    	//Set<Opcion> opciones=opcionImplementable.getTodosOpcionsWithConnection("", new Pagination(), new DatosCliente());
	    	Boolean isValidado=false;
	    	
	    	//EntityManagerFactory JPAENTITYMANAGERFACTORY= Persistence.createEntityManagerFactory("PersistenceUnitSeguridad");
	    	
	    	
	    	
	    	if(this.usuarioActual!=null && this.usuarioActual.getId()>0) {
				isValidado=true;//usuarioLogicAdditional.validarUsuarioSeguridad(strNombreUsuario, strClaveUsuario);
			}
	    	
	    	if(isValidado) {   	    		
	    		/*
	    		if(Constantes.ISUSAEJBLOGICLAYER) {	
	    			this.usuarioActual=this.usuarioLogicAdditional.validarUsuario(sUsuario,sPassword);			
					
				} else if(Constantes.ISUSAEJBREMOTE) {
					this.usuarioActual=this.sistemaAdditionable.validarUsuarioConUsuario(sUsuario,sPassword);
				
				} else if(Constantes.ISUSAEJBHOME) {
					this.usuarioActual=this.sistemaAdditionableHome.validarUsuarioConUsuario(sUsuario,sPassword);			
				}
	    		*/
	    		
	    		this.cargarParametroGeneralUsuario(this.usuarioActual.getId());
	    		
	    		
	    		//final LoginJFrameMe loginJFrame=this;
	    		final Usuario usuarioActualFinal=this.usuarioActual;
	    		final ParametroGeneralSg parametroGeneralSg=this.parametroGeneralSg;
	    		final ParametroGeneralUsuario parametroGeneralUsuario=this.parametroGeneralUsuario;
	    		
	    		
	    		//ESTE PASO DEMORA EN CARGAR
	    		
	    		
	    		//this.CargarObjetosRendimientoCriticoThread(usuarioActualFinal,parametroGeneralSg,parametroGeneralUsuario);
	    		
	    		
		    	java.awt.EventQueue.invokeLater (new AccionesAuxiliarSwing(this));
		    	
		    	if(Constantes.ISUSAEJBLOGICLAYER) {	
		    		this.setVisible(false);
		    	} else if(Constantes.ISUSAEJBREMOTE) {
		    		this.setVisible(false);
		    		//this.dispose();
				} else if(Constantes.ISUSAEJBHOME) {
					this.setVisible(false);
					//this.dispose();			
				}		    			    	
	    	} else {
	    		JOptionPane.showMessageDialog(this,"USUARIO O PASSWORD INCORRECTO","ERROR",JOptionPane.ERROR_MESSAGE);
	    	}
	    	
    	} catch(Exception e) {
    		//FuncionesSwing.manageException(this, e,logger);
    	}
    }
    
    private void CargarObjetosRendimientoCriticoThread(Usuario usuarioActual, ParametroGeneralSg parametroGeneralSg,ParametroGeneralUsuario parametroGeneralUsuario) {
    	//ESTE PASO CARGA LOS OBJETOS EN MEMORIA 
    	
    	
		
    }
    
    public void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	try {
	    	quit();
    		
    		//CON ID AUTOMATICO
    		/*
    		TipoDetalleDocumentoLogic tipoDetalleDocumentoLogic=new TipoDetalleDocumentoLogic();
    		String sFinalQuery="";
    		Pagination pagination=new Pagination();
    		
    		tipoDetalleDocumentoLogic.setConnexionType(ConnexionType.JDBC32);
    		tipoDetalleDocumentoLogic.setParameterDbType(ParameterDbType.POSTGRES);
    		
    		tipoDetalleDocumentoLogic.getTodosTipoDetalleDocumentosWithConnection(sFinalQuery, pagination);
	    	
    		for(TipoDetalleDocumento tipoDetalleDocumento:tipoDetalleDocumentoLogic.getTipoDetalleDocumentos()) {
    			System.out.println(tipoDetalleDocumento.getId()+","+tipoDetalleDocumento.getid_empresa()+","+tipoDetalleDocumento.getcodigo()+","+tipoDetalleDocumento.getnombre()+","+tipoDetalleDocumento.getVersionRow());
    		}
    		*/
    		//INSERT
    		/*
    		TipoDetalleDocumento tipoDetalleDocumento=new TipoDetalleDocumento();
    		tipoDetalleDocumento.setid_empresa(1L);
    		tipoDetalleDocumento.setcodigo("4");
    		tipoDetalleDocumento.setnombre("44");
    		
    		tipoDetalleDocumentoLogic.setTipoDetalleDocumento(tipoDetalleDocumento);
    		*/
    		
    		//UPDATE
    		/*
    		tipoDetalleDocumentoLogic.getEntityWithConnection(4L);
    		tipoDetalleDocumentoLogic.getTipoDetalleDocumento().setcodigo("a4g");
    		tipoDetalleDocumentoLogic.getTipoDetalleDocumento().setnombre("a44h");
    		tipoDetalleDocumentoLogic.getTipoDetalleDocumento().setid_empresa(1L);
    		*/
    		
    		//DELETE
    		/*
    		tipoDetalleDocumentoLogic.getEntityWithConnection(4L);
    		tipoDetalleDocumentoLogic.getTipoDetalleDocumento().setIsDeleted(true);
    		*/
    		
    		//tipoDetalleDocumentoLogic.saveTipoDetalleDocumentoWithConnection();
    		
	    	//CON ID AUTOMATICO FIN
	    	
	    	
	    	
	    	
	    	
	    	
	    	
    		
    		//SIN ID AUTOMATICO
    		/*
    		TipoComprobanteLogic tipoComprobanteLogic=new TipoComprobanteLogic();
    		String sFinalQuery="";
    		Pagination pagination=new Pagination();
    		
    		tipoComprobanteLogic.setConnexionType(ConnexionType.JDBC32);
    		tipoComprobanteLogic.setParameterDbType(ParameterDbType.POSTGRES);
    		
    		tipoComprobanteLogic.getTodosTipoComprobantesWithConnection(sFinalQuery, pagination);
	    	
    		for(TipoComprobante tipoComprobante:tipoComprobanteLogic.getTipoComprobantes()) {
    			System.out.println(tipoComprobante.getId()+","+tipoComprobante.getcodigo()+","+tipoComprobante.getnombre()+","+tipoComprobante.getVersionRow());
    		}
    		*/
    		    		
    		//INSERT
    		/*
    		TipoComprobante tipoComprobante=new TipoComprobante();
    		tipoComprobante.setId(4L);
    		tipoComprobante.setcodigo("4");
    		tipoComprobante.setnombre("44");
    		
    		tipoComprobanteLogic.setTipoComprobante(tipoComprobante);
    		*/
    		
    		//UPDATE
    		/*
    		tipoComprobanteLogic.getEntityWithConnection(4L);
    		tipoComprobanteLogic.getTipoComprobante().setcodigo("a4g");
    		tipoComprobanteLogic.getTipoComprobante().setnombre("a44h");
    		*/
    		
    		//DELETE
    		/*
    		tipoComprobanteLogic.getEntityWithConnection(4L);
    		tipoComprobanteLogic.getTipoComprobante().setIsDeleted(true);
    		
    		
    		tipoComprobanteLogic.saveTipoComprobanteWithConnection();
    		*/
    		
	    	//SIN ID AUTOMATICO FIN
    		
    		
	    } catch(Exception e) {
			//FuncionesSwing.manageException(this, e,logger);
		}
    }
    
    protected void quit() {
        System.exit(0);
    }
    
    protected static void SetLookAndFeel(int iTipo) {
    		
    		
    }
    
    public static void main(String args[]) {
    	//LoginJFrame.SetLookAndFeel(1L);
    	 
    	LoginJFrameErp loginJFrameErp = new LoginJFrameErp();
		    	
        java.awt.EventQueue.invokeLater (new AccionesAuxiliarSwing(loginJFrameErp));
        
        loginJFrameErp.setVisible(true);
        
    } 
}