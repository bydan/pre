/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.MailMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.MailMensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MailMensajeCorreoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.MailMensajeCorreoInven;
import com.bydan.erp.inventario.business.logic.MailMensajeCorreoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class MailMensajeCorreoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MailMensajeCorreoInvenLogic.class);
	
	protected MailMensajeCorreoInvenDataAccess mailmensajecorreoinvenDataAccess; 	
	protected MailMensajeCorreoInven mailmensajecorreoinven;
	protected List<MailMensajeCorreoInven> mailmensajecorreoinvens;
	protected Object mailmensajecorreoinvenObject;	
	protected List<Object> mailmensajecorreoinvensObject;
	
	public static ClassValidator<MailMensajeCorreoInven> mailmensajecorreoinvenValidator = new ClassValidator<MailMensajeCorreoInven>(MailMensajeCorreoInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MailMensajeCorreoInvenLogicAdditional mailmensajecorreoinvenLogicAdditional=null;
	
	public MailMensajeCorreoInvenLogicAdditional getMailMensajeCorreoInvenLogicAdditional() {
		return this.mailmensajecorreoinvenLogicAdditional;
	}
	
	public void setMailMensajeCorreoInvenLogicAdditional(MailMensajeCorreoInvenLogicAdditional mailmensajecorreoinvenLogicAdditional) {
		try {
			this.mailmensajecorreoinvenLogicAdditional=mailmensajecorreoinvenLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  MailMensajeCorreoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.mailmensajecorreoinvenDataAccess = new MailMensajeCorreoInvenDataAccess();
			
			this.mailmensajecorreoinvens= new ArrayList<MailMensajeCorreoInven>();
			this.mailmensajecorreoinven= new MailMensajeCorreoInven();
			
			this.mailmensajecorreoinvenObject=new Object();
			this.mailmensajecorreoinvensObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.mailmensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.mailmensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MailMensajeCorreoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.mailmensajecorreoinvenDataAccess = new MailMensajeCorreoInvenDataAccess();
			this.mailmensajecorreoinvens= new ArrayList<MailMensajeCorreoInven>();
			this.mailmensajecorreoinven= new MailMensajeCorreoInven();
			this.mailmensajecorreoinvenObject=new Object();
			this.mailmensajecorreoinvensObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.mailmensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.mailmensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MailMensajeCorreoInven getMailMensajeCorreoInven() throws Exception {	
		MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToGet(mailmensajecorreoinven,this.datosCliente,this.arrDatoGeneral);
		MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToGet(mailmensajecorreoinven,this.arrDatoGeneral);
		
		return mailmensajecorreoinven;
	}
		
	public void setMailMensajeCorreoInven(MailMensajeCorreoInven newMailMensajeCorreoInven) {
		this.mailmensajecorreoinven = newMailMensajeCorreoInven;
	}
	
	public MailMensajeCorreoInvenDataAccess getMailMensajeCorreoInvenDataAccess() {
		return mailmensajecorreoinvenDataAccess;
	}
	
	public void setMailMensajeCorreoInvenDataAccess(MailMensajeCorreoInvenDataAccess newmailmensajecorreoinvenDataAccess) {
		this.mailmensajecorreoinvenDataAccess = newmailmensajecorreoinvenDataAccess;
	}
	
	public List<MailMensajeCorreoInven> getMailMensajeCorreoInvens() throws Exception {		
		this.quitarMailMensajeCorreoInvensNulos();
		
		MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToGets(mailmensajecorreoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (MailMensajeCorreoInven mailmensajecorreoinvenLocal: mailmensajecorreoinvens ) {
			MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToGet(mailmensajecorreoinvenLocal,this.arrDatoGeneral);
		}
		
		return mailmensajecorreoinvens;
	}
	
	public void setMailMensajeCorreoInvens(List<MailMensajeCorreoInven> newMailMensajeCorreoInvens) {
		this.mailmensajecorreoinvens = newMailMensajeCorreoInvens;
	}
	
	public Object getMailMensajeCorreoInvenObject() {	
		this.mailmensajecorreoinvenObject=this.mailmensajecorreoinvenDataAccess.getEntityObject();
		return this.mailmensajecorreoinvenObject;
	}
		
	public void setMailMensajeCorreoInvenObject(Object newMailMensajeCorreoInvenObject) {
		this.mailmensajecorreoinvenObject = newMailMensajeCorreoInvenObject;
	}
	
	public List<Object> getMailMensajeCorreoInvensObject() {		
		this.mailmensajecorreoinvensObject=this.mailmensajecorreoinvenDataAccess.getEntitiesObject();
		return this.mailmensajecorreoinvensObject;
	}
		
	public void setMailMensajeCorreoInvensObject(List<Object> newMailMensajeCorreoInvensObject) {
		this.mailmensajecorreoinvensObject = newMailMensajeCorreoInvensObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.mailmensajecorreoinvenDataAccess!=null) {
			this.mailmensajecorreoinvenDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			mailmensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			mailmensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mailmensajecorreoinven=mailmensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mailmensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinven);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  		  
        try {
			
			mailmensajecorreoinven=mailmensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mailmensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mailmensajecorreoinven=mailmensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mailmensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinven);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  		  
        try {
			
			mailmensajecorreoinven=mailmensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mailmensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =mailmensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=mailmensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =mailmensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=mailmensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =mailmensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=mailmensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinven=mailmensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinven);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		mailmensajecorreoinven = new  MailMensajeCorreoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinven=mailmensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		  		  
        try {
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMailMensajeCorreoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getTodosMailMensajeCorreoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosMailMensajeCorreoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		mailmensajecorreoinvens = new  ArrayList<MailMensajeCorreoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMailMensajeCorreoInven(mailmensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMailMensajeCorreoInven(MailMensajeCorreoInven mailmensajecorreoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(mailmensajecorreoinven.getIsNew() || mailmensajecorreoinven.getIsChanged()) { 
			this.invalidValues = mailmensajecorreoinvenValidator.getInvalidValues(mailmensajecorreoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(mailmensajecorreoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMailMensajeCorreoInven(List<MailMensajeCorreoInven> MailMensajeCorreoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(MailMensajeCorreoInven mailmensajecorreoinvenLocal:mailmensajecorreoinvens) {				
			estaValidadoObjeto=this.validarGuardarMailMensajeCorreoInven(mailmensajecorreoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMailMensajeCorreoInven(List<MailMensajeCorreoInven> MailMensajeCorreoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMailMensajeCorreoInven(mailmensajecorreoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMailMensajeCorreoInven(MailMensajeCorreoInven MailMensajeCorreoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMailMensajeCorreoInven(mailmensajecorreoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(MailMensajeCorreoInven mailmensajecorreoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+mailmensajecorreoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MailMensajeCorreoInvenConstantesFunciones.getMailMensajeCorreoInvenLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"mailmensajecorreoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MailMensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MailMensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMailMensajeCorreoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-saveMailMensajeCorreoInvenWithConnection");connexion.begin();			
			
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSave(this.mailmensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToSave(this.mailmensajecorreoinven,this.arrDatoGeneral);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mailmensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMailMensajeCorreoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMailMensajeCorreoInven(this.mailmensajecorreoinven)) {
				MailMensajeCorreoInvenDataAccess.save(this.mailmensajecorreoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.mailmensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSaveAfter(this.mailmensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMailMensajeCorreoInven();
			
			connexion.commit();			
			
			if(this.mailmensajecorreoinven.getIsDeleted()) {
				this.mailmensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMailMensajeCorreoInven()throws Exception {	
		try {	
			
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSave(this.mailmensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToSave(this.mailmensajecorreoinven,this.arrDatoGeneral);
			
			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mailmensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMailMensajeCorreoInven(this.mailmensajecorreoinven)) {			
				MailMensajeCorreoInvenDataAccess.save(this.mailmensajecorreoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.mailmensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSaveAfter(this.mailmensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.mailmensajecorreoinven.getIsDeleted()) {
				this.mailmensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMailMensajeCorreoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-saveMailMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSaves(mailmensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMailMensajeCorreoInvens();
			
			Boolean validadoTodosMailMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MailMensajeCorreoInven mailmensajecorreoinvenLocal:mailmensajecorreoinvens) {		
				if(mailmensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToSave(mailmensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mailmensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMailMensajeCorreoInven(mailmensajecorreoinvenLocal)) {
					MailMensajeCorreoInvenDataAccess.save(mailmensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosMailMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosMailMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSavesAfter(mailmensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMailMensajeCorreoInvens();
			
			connexion.commit();		
			
			this.quitarMailMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMailMensajeCorreoInvens()throws Exception {				
		 try {	
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSaves(mailmensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMailMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MailMensajeCorreoInven mailmensajecorreoinvenLocal:mailmensajecorreoinvens) {				
				if(mailmensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToSave(mailmensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mailmensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMailMensajeCorreoInven(mailmensajecorreoinvenLocal)) {				
					MailMensajeCorreoInvenDataAccess.save(mailmensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosMailMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosMailMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MailMensajeCorreoInvenLogicAdditional.checkMailMensajeCorreoInvenToSavesAfter(mailmensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMailMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MailMensajeCorreoInvenParameterReturnGeneral procesarAccionMailMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MailMensajeCorreoInven> mailmensajecorreoinvens,MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenParameterGeneral)throws Exception {
		 try {	
			MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenReturnGeneral=new MailMensajeCorreoInvenParameterReturnGeneral();
	
			MailMensajeCorreoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mailmensajecorreoinvens,mailmensajecorreoinvenParameterGeneral,mailmensajecorreoinvenReturnGeneral);
			
			return mailmensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MailMensajeCorreoInvenParameterReturnGeneral procesarAccionMailMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MailMensajeCorreoInven> mailmensajecorreoinvens,MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-procesarAccionMailMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenReturnGeneral=new MailMensajeCorreoInvenParameterReturnGeneral();
	
			MailMensajeCorreoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mailmensajecorreoinvens,mailmensajecorreoinvenParameterGeneral,mailmensajecorreoinvenReturnGeneral);
			
			this.connexion.commit();
			
			return mailmensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MailMensajeCorreoInvenParameterReturnGeneral procesarEventosMailMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MailMensajeCorreoInven> mailmensajecorreoinvens,MailMensajeCorreoInven mailmensajecorreoinven,MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenParameterGeneral,Boolean isEsNuevoMailMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenReturnGeneral=new MailMensajeCorreoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mailmensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MailMensajeCorreoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mailmensajecorreoinvens,mailmensajecorreoinven,mailmensajecorreoinvenParameterGeneral,mailmensajecorreoinvenReturnGeneral,isEsNuevoMailMensajeCorreoInven,clases);
			
			return mailmensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MailMensajeCorreoInvenParameterReturnGeneral procesarEventosMailMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MailMensajeCorreoInven> mailmensajecorreoinvens,MailMensajeCorreoInven mailmensajecorreoinven,MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenParameterGeneral,Boolean isEsNuevoMailMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-procesarEventosMailMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenReturnGeneral=new MailMensajeCorreoInvenParameterReturnGeneral();
	
			mailmensajecorreoinvenReturnGeneral.setMailMensajeCorreoInven(mailmensajecorreoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mailmensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MailMensajeCorreoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mailmensajecorreoinvens,mailmensajecorreoinven,mailmensajecorreoinvenParameterGeneral,mailmensajecorreoinvenReturnGeneral,isEsNuevoMailMensajeCorreoInven,clases);
			
			this.connexion.commit();
			
			return mailmensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MailMensajeCorreoInvenParameterReturnGeneral procesarImportacionMailMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-procesarImportacionMailMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MailMensajeCorreoInvenParameterReturnGeneral mailmensajecorreoinvenReturnGeneral=new MailMensajeCorreoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.mailmensajecorreoinvens=new ArrayList<MailMensajeCorreoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.mailmensajecorreoinven=new MailMensajeCorreoInven();
				
				
				if(conColumnasBase) {this.mailmensajecorreoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.mailmensajecorreoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.mailmensajecorreoinven.setmail(arrColumnas[iColumn++]);
				this.mailmensajecorreoinven.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.mailmensajecorreoinvens.add(this.mailmensajecorreoinven);
			}
			
			this.saveMailMensajeCorreoInvens();
			
			this.connexion.commit();
			
			mailmensajecorreoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			mailmensajecorreoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return mailmensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMailMensajeCorreoInvensEliminados() throws Exception {				
		
		List<MailMensajeCorreoInven> mailmensajecorreoinvensAux= new ArrayList<MailMensajeCorreoInven>();
		
		for(MailMensajeCorreoInven mailmensajecorreoinven:mailmensajecorreoinvens) {
			if(!mailmensajecorreoinven.getIsDeleted()) {
				mailmensajecorreoinvensAux.add(mailmensajecorreoinven);
			}
		}
		
		mailmensajecorreoinvens=mailmensajecorreoinvensAux;
	}
	
	public void quitarMailMensajeCorreoInvensNulos() throws Exception {				
		
		List<MailMensajeCorreoInven> mailmensajecorreoinvensAux= new ArrayList<MailMensajeCorreoInven>();
		
		for(MailMensajeCorreoInven mailmensajecorreoinven : this.mailmensajecorreoinvens) {
			if(mailmensajecorreoinven==null) {
				mailmensajecorreoinvensAux.add(mailmensajecorreoinven);
			}
		}
		
		//this.mailmensajecorreoinvens=mailmensajecorreoinvensAux;
		
		this.mailmensajecorreoinvens.removeAll(mailmensajecorreoinvensAux);
	}
	
	public void getSetVersionRowMailMensajeCorreoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(mailmensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((mailmensajecorreoinven.getIsDeleted() || (mailmensajecorreoinven.getIsChanged()&&!mailmensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=mailmensajecorreoinvenDataAccess.getSetVersionRowMailMensajeCorreoInven(connexion,mailmensajecorreoinven.getId());
				
				if(!mailmensajecorreoinven.getVersionRow().equals(timestamp)) {	
					mailmensajecorreoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				mailmensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMailMensajeCorreoInven()throws Exception {	
		
		if(mailmensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((mailmensajecorreoinven.getIsDeleted() || (mailmensajecorreoinven.getIsChanged()&&!mailmensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=mailmensajecorreoinvenDataAccess.getSetVersionRowMailMensajeCorreoInven(connexion,mailmensajecorreoinven.getId());
			
			try {							
				if(!mailmensajecorreoinven.getVersionRow().equals(timestamp)) {	
					mailmensajecorreoinven.setVersionRow(timestamp);
				}
				
				mailmensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMailMensajeCorreoInvensWithConnection()throws Exception {	
		if(mailmensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(MailMensajeCorreoInven mailmensajecorreoinvenAux:mailmensajecorreoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(mailmensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mailmensajecorreoinvenAux.getIsDeleted() || (mailmensajecorreoinvenAux.getIsChanged()&&!mailmensajecorreoinvenAux.getIsNew())) {
						
						timestamp=mailmensajecorreoinvenDataAccess.getSetVersionRowMailMensajeCorreoInven(connexion,mailmensajecorreoinvenAux.getId());
						
						if(!mailmensajecorreoinven.getVersionRow().equals(timestamp)) {	
							mailmensajecorreoinvenAux.setVersionRow(timestamp);
						}
								
						mailmensajecorreoinvenAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMailMensajeCorreoInvens()throws Exception {	
		if(mailmensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(MailMensajeCorreoInven mailmensajecorreoinvenAux:mailmensajecorreoinvens) {
					if(mailmensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mailmensajecorreoinvenAux.getIsDeleted() || (mailmensajecorreoinvenAux.getIsChanged()&&!mailmensajecorreoinvenAux.getIsNew())) {
						
						timestamp=mailmensajecorreoinvenDataAccess.getSetVersionRowMailMensajeCorreoInven(connexion,mailmensajecorreoinvenAux.getId());
						
						if(!mailmensajecorreoinvenAux.getVersionRow().equals(timestamp)) {	
							mailmensajecorreoinvenAux.setVersionRow(timestamp);
						}
						
													
						mailmensajecorreoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MailMensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyMailMensajeCorreoInvenWithConnection(String finalQueryGlobalMensajeCorreoInven,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo) throws Exception {
		MailMensajeCorreoInvenParameterReturnGeneral  mailmensajecorreoinvenReturnGeneral =new MailMensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyMailMensajeCorreoInvenWithConnection");connexion.begin();
			
			mailmensajecorreoinvenReturnGeneral =new MailMensajeCorreoInvenParameterReturnGeneral();
			
			

			List<MensajeCorreoInven> mensajecorreoinvensForeignKey=new ArrayList<MensajeCorreoInven>();
			MensajeCorreoInvenLogic mensajecorreoinvenLogic=new MensajeCorreoInvenLogic();
			mensajecorreoinvenLogic.setConnexion(this.connexion);
			mensajecorreoinvenLogic.getMensajeCorreoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMensajeCorreoInven.equals("NONE")) {
				mensajecorreoinvenLogic.getTodosMensajeCorreoInvens(finalQueryGlobalMensajeCorreoInven,new Pagination());
				mensajecorreoinvensForeignKey=mensajecorreoinvenLogic.getMensajeCorreoInvens();
			}

			mailmensajecorreoinvenReturnGeneral.setmensajecorreoinvensForeignKey(mensajecorreoinvensForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mailmensajecorreoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mailmensajecorreoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			mailmensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return mailmensajecorreoinvenReturnGeneral;
	}
	
	public MailMensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyMailMensajeCorreoInven(String finalQueryGlobalMensajeCorreoInven,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo) throws Exception {
		MailMensajeCorreoInvenParameterReturnGeneral  mailmensajecorreoinvenReturnGeneral =new MailMensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			mailmensajecorreoinvenReturnGeneral =new MailMensajeCorreoInvenParameterReturnGeneral();
			
			

			List<MensajeCorreoInven> mensajecorreoinvensForeignKey=new ArrayList<MensajeCorreoInven>();
			MensajeCorreoInvenLogic mensajecorreoinvenLogic=new MensajeCorreoInvenLogic();
			mensajecorreoinvenLogic.setConnexion(this.connexion);
			mensajecorreoinvenLogic.getMensajeCorreoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMensajeCorreoInven.equals("NONE")) {
				mensajecorreoinvenLogic.getTodosMensajeCorreoInvens(finalQueryGlobalMensajeCorreoInven,new Pagination());
				mensajecorreoinvensForeignKey=mensajecorreoinvenLogic.getMensajeCorreoInvens();
			}

			mailmensajecorreoinvenReturnGeneral.setmensajecorreoinvensForeignKey(mensajecorreoinvensForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mailmensajecorreoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mailmensajecorreoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			mailmensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return mailmensajecorreoinvenReturnGeneral;
	}
	
	
	public void deepLoad(MailMensajeCorreoInven mailmensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToGet(mailmensajecorreoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mailmensajecorreoinven.setMensajeCorreoInven(mailmensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,mailmensajecorreoinven));
		mailmensajecorreoinven.setEmpresa(mailmensajecorreoinvenDataAccess.getEmpresa(connexion,mailmensajecorreoinven));
		mailmensajecorreoinven.setSucursal(mailmensajecorreoinvenDataAccess.getSucursal(connexion,mailmensajecorreoinven));
		mailmensajecorreoinven.setModulo(mailmensajecorreoinvenDataAccess.getModulo(connexion,mailmensajecorreoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				mailmensajecorreoinven.setMensajeCorreoInven(mailmensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,mailmensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				mailmensajecorreoinven.setEmpresa(mailmensajecorreoinvenDataAccess.getEmpresa(connexion,mailmensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mailmensajecorreoinven.setSucursal(mailmensajecorreoinvenDataAccess.getSucursal(connexion,mailmensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				mailmensajecorreoinven.setModulo(mailmensajecorreoinvenDataAccess.getModulo(connexion,mailmensajecorreoinven));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setMensajeCorreoInven(mailmensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,mailmensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setEmpresa(mailmensajecorreoinvenDataAccess.getEmpresa(connexion,mailmensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setSucursal(mailmensajecorreoinvenDataAccess.getSucursal(connexion,mailmensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setModulo(mailmensajecorreoinvenDataAccess.getModulo(connexion,mailmensajecorreoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mailmensajecorreoinven.setMensajeCorreoInven(mailmensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,mailmensajecorreoinven));
		MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
		mensajecorreoinvenLogic.deepLoad(mailmensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);
				
		mailmensajecorreoinven.setEmpresa(mailmensajecorreoinvenDataAccess.getEmpresa(connexion,mailmensajecorreoinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mailmensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		mailmensajecorreoinven.setSucursal(mailmensajecorreoinvenDataAccess.getSucursal(connexion,mailmensajecorreoinven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mailmensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		mailmensajecorreoinven.setModulo(mailmensajecorreoinvenDataAccess.getModulo(connexion,mailmensajecorreoinven));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(mailmensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				mailmensajecorreoinven.setMensajeCorreoInven(mailmensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,mailmensajecorreoinven));
				MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
				mensajecorreoinvenLogic.deepLoad(mailmensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				mailmensajecorreoinven.setEmpresa(mailmensajecorreoinvenDataAccess.getEmpresa(connexion,mailmensajecorreoinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(mailmensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mailmensajecorreoinven.setSucursal(mailmensajecorreoinvenDataAccess.getSucursal(connexion,mailmensajecorreoinven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(mailmensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				mailmensajecorreoinven.setModulo(mailmensajecorreoinvenDataAccess.getModulo(connexion,mailmensajecorreoinven));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(mailmensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setMensajeCorreoInven(mailmensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,mailmensajecorreoinven));
			MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
			mensajecorreoinvenLogic.deepLoad(mailmensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setEmpresa(mailmensajecorreoinvenDataAccess.getEmpresa(connexion,mailmensajecorreoinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(mailmensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setSucursal(mailmensajecorreoinvenDataAccess.getSucursal(connexion,mailmensajecorreoinven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(mailmensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mailmensajecorreoinven.setModulo(mailmensajecorreoinvenDataAccess.getModulo(connexion,mailmensajecorreoinven));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(mailmensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(MailMensajeCorreoInven mailmensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MailMensajeCorreoInvenLogicAdditional.updateMailMensajeCorreoInvenToSave(mailmensajecorreoinven,this.arrDatoGeneral);
			
MailMensajeCorreoInvenDataAccess.save(mailmensajecorreoinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		MensajeCorreoInvenDataAccess.save(mailmensajecorreoinven.getMensajeCorreoInven(),connexion);

		EmpresaDataAccess.save(mailmensajecorreoinven.getEmpresa(),connexion);

		SucursalDataAccess.save(mailmensajecorreoinven.getSucursal(),connexion);

		ModuloDataAccess.save(mailmensajecorreoinven.getModulo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				MensajeCorreoInvenDataAccess.save(mailmensajecorreoinven.getMensajeCorreoInven(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mailmensajecorreoinven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mailmensajecorreoinven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(mailmensajecorreoinven.getModulo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		MensajeCorreoInvenDataAccess.save(mailmensajecorreoinven.getMensajeCorreoInven(),connexion);
		MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
		mensajecorreoinvenLogic.deepLoad(mailmensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(mailmensajecorreoinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mailmensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(mailmensajecorreoinven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mailmensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(mailmensajecorreoinven.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(mailmensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				MensajeCorreoInvenDataAccess.save(mailmensajecorreoinven.getMensajeCorreoInven(),connexion);
				MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
				mensajecorreoinvenLogic.deepSave(mailmensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mailmensajecorreoinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(mailmensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mailmensajecorreoinven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(mailmensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(mailmensajecorreoinven.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(mailmensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MailMensajeCorreoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(mailmensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(mailmensajecorreoinven);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.mailmensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MailMensajeCorreoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(mailmensajecorreoinvens!=null) {
				for(MailMensajeCorreoInven mailmensajecorreoinven:mailmensajecorreoinvens) {
					this.deepLoad(mailmensajecorreoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(mailmensajecorreoinvens);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(mailmensajecorreoinvens!=null) {
				for(MailMensajeCorreoInven mailmensajecorreoinven:mailmensajecorreoinvens) {
					this.deepLoad(mailmensajecorreoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(mailmensajecorreoinvens);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(MailMensajeCorreoInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(mailmensajecorreoinven,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(MailMensajeCorreoInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(mailmensajecorreoinvens!=null) {
				for(MailMensajeCorreoInven mailmensajecorreoinven:mailmensajecorreoinvens) {
					this.deepSave(mailmensajecorreoinven,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(mailmensajecorreoinvens!=null) {
				for(MailMensajeCorreoInven mailmensajecorreoinven:mailmensajecorreoinvens) {
					this.deepSave(mailmensajecorreoinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMailMensajeCorreoInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMailMensajeCorreoInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMailMensajeCorreoInvensFK_IdMensajeCorreoInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_mensaje_correo_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMensajeCorreoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMensajeCorreoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mensaje_correo_inven,MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMensajeCorreoInven);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMensajeCorreoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMailMensajeCorreoInvensFK_IdMensajeCorreoInven(String sFinalQuery,Pagination pagination,Long id_mensaje_correo_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMensajeCorreoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMensajeCorreoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mensaje_correo_inven,MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMensajeCorreoInven);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMensajeCorreoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMailMensajeCorreoInvensFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,MailMensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMailMensajeCorreoInvensFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,MailMensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMailMensajeCorreoInvensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MailMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMailMensajeCorreoInvensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MailMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(this.mailmensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MailMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MailMensajeCorreoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,MailMensajeCorreoInven mailmensajecorreoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MailMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(mailmensajecorreoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MailMensajeCorreoInvenDataAccess.TABLENAME, mailmensajecorreoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MailMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MailMensajeCorreoInvenLogic.registrarAuditoriaDetallesMailMensajeCorreoInven(connexion,mailmensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(mailmensajecorreoinven.getIsDeleted()) {
					/*if(!mailmensajecorreoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MailMensajeCorreoInvenDataAccess.TABLENAME, mailmensajecorreoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MailMensajeCorreoInvenLogic.registrarAuditoriaDetallesMailMensajeCorreoInven(connexion,mailmensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MailMensajeCorreoInvenDataAccess.TABLENAME, mailmensajecorreoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(mailmensajecorreoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MailMensajeCorreoInvenDataAccess.TABLENAME, mailmensajecorreoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MailMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MailMensajeCorreoInvenLogic.registrarAuditoriaDetallesMailMensajeCorreoInven(connexion,mailmensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMailMensajeCorreoInven(Connexion connexion,MailMensajeCorreoInven mailmensajecorreoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(mailmensajecorreoinven.getIsNew()||!mailmensajecorreoinven.getid_mensaje_correo_inven().equals(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_mensaje_correo_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_mensaje_correo_inven()!=null)
				{
					strValorActual=mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_mensaje_correo_inven().toString();
				}
				if(mailmensajecorreoinven.getid_mensaje_correo_inven()!=null)
				{
					strValorNuevo=mailmensajecorreoinven.getid_mensaje_correo_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MailMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,strValorActual,strValorNuevo);
			}	
			
			if(mailmensajecorreoinven.getIsNew()||!mailmensajecorreoinven.getid_empresa().equals(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_empresa().toString();
				}
				if(mailmensajecorreoinven.getid_empresa()!=null)
				{
					strValorNuevo=mailmensajecorreoinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MailMensajeCorreoInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(mailmensajecorreoinven.getIsNew()||!mailmensajecorreoinven.getid_sucursal().equals(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_sucursal()!=null)
				{
					strValorActual=mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_sucursal().toString();
				}
				if(mailmensajecorreoinven.getid_sucursal()!=null)
				{
					strValorNuevo=mailmensajecorreoinven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MailMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(mailmensajecorreoinven.getIsNew()||!mailmensajecorreoinven.getid_modulo().equals(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_modulo()!=null)
				{
					strValorActual=mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getid_modulo().toString();
				}
				if(mailmensajecorreoinven.getid_modulo()!=null)
				{
					strValorNuevo=mailmensajecorreoinven.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MailMensajeCorreoInvenConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(mailmensajecorreoinven.getIsNew()||!mailmensajecorreoinven.getmail().equals(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getmail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getmail()!=null)
				{
					strValorActual=mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getmail();
				}
				if(mailmensajecorreoinven.getmail()!=null)
				{
					strValorNuevo=mailmensajecorreoinven.getmail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MailMensajeCorreoInvenConstantesFunciones.MAIL,strValorActual,strValorNuevo);
			}	
			
			if(mailmensajecorreoinven.getIsNew()||!mailmensajecorreoinven.getesta_activo().equals(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getesta_activo()!=null)
				{
					strValorActual=mailmensajecorreoinven.getMailMensajeCorreoInvenOriginal().getesta_activo().toString();
				}
				if(mailmensajecorreoinven.getesta_activo()!=null)
				{
					strValorNuevo=mailmensajecorreoinven.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MailMensajeCorreoInvenConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMailMensajeCorreoInvenRelacionesWithConnection(MailMensajeCorreoInven mailmensajecorreoinven) throws Exception {

		if(!mailmensajecorreoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMailMensajeCorreoInvenRelacionesBase(mailmensajecorreoinven,true);
		}
	}

	public void saveMailMensajeCorreoInvenRelaciones(MailMensajeCorreoInven mailmensajecorreoinven)throws Exception {

		if(!mailmensajecorreoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMailMensajeCorreoInvenRelacionesBase(mailmensajecorreoinven,false);
		}
	}

	public void saveMailMensajeCorreoInvenRelacionesBase(MailMensajeCorreoInven mailmensajecorreoinven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("MailMensajeCorreoInven-saveRelacionesWithConnection");}
	

			this.setMailMensajeCorreoInven(mailmensajecorreoinven);

			if(MailMensajeCorreoInvenLogicAdditional.validarSaveRelaciones(mailmensajecorreoinven,this)) {

				MailMensajeCorreoInvenLogicAdditional.updateRelacionesToSave(mailmensajecorreoinven,this);

				if((mailmensajecorreoinven.getIsNew()||mailmensajecorreoinven.getIsChanged())&&!mailmensajecorreoinven.getIsDeleted()) {
					this.saveMailMensajeCorreoInven();
					this.saveMailMensajeCorreoInvenRelacionesDetalles();

				} else if(mailmensajecorreoinven.getIsDeleted()) {
					this.saveMailMensajeCorreoInvenRelacionesDetalles();
					this.saveMailMensajeCorreoInven();
				}

				MailMensajeCorreoInvenLogicAdditional.updateRelacionesToSaveAfter(mailmensajecorreoinven,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveMailMensajeCorreoInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMailMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MailMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfMailMensajeCorreoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMailMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MailMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfMailMensajeCorreoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
