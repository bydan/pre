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
import com.bydan.erp.inventario.util.MensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.MensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MensajeCorreoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.MensajeCorreoInven;
import com.bydan.erp.inventario.business.logic.MensajeCorreoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class MensajeCorreoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MensajeCorreoInvenLogic.class);
	
	protected MensajeCorreoInvenDataAccess mensajecorreoinvenDataAccess; 	
	protected MensajeCorreoInven mensajecorreoinven;
	protected List<MensajeCorreoInven> mensajecorreoinvens;
	protected Object mensajecorreoinvenObject;	
	protected List<Object> mensajecorreoinvensObject;
	
	public static ClassValidator<MensajeCorreoInven> mensajecorreoinvenValidator = new ClassValidator<MensajeCorreoInven>(MensajeCorreoInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MensajeCorreoInvenLogicAdditional mensajecorreoinvenLogicAdditional=null;
	
	public MensajeCorreoInvenLogicAdditional getMensajeCorreoInvenLogicAdditional() {
		return this.mensajecorreoinvenLogicAdditional;
	}
	
	public void setMensajeCorreoInvenLogicAdditional(MensajeCorreoInvenLogicAdditional mensajecorreoinvenLogicAdditional) {
		try {
			this.mensajecorreoinvenLogicAdditional=mensajecorreoinvenLogicAdditional;
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
	
	
	
	
	public  MensajeCorreoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.mensajecorreoinvenDataAccess = new MensajeCorreoInvenDataAccess();
			
			this.mensajecorreoinvens= new ArrayList<MensajeCorreoInven>();
			this.mensajecorreoinven= new MensajeCorreoInven();
			
			this.mensajecorreoinvenObject=new Object();
			this.mensajecorreoinvensObject=new ArrayList<Object>();
				
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
			
			this.mensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.mensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MensajeCorreoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.mensajecorreoinvenDataAccess = new MensajeCorreoInvenDataAccess();
			this.mensajecorreoinvens= new ArrayList<MensajeCorreoInven>();
			this.mensajecorreoinven= new MensajeCorreoInven();
			this.mensajecorreoinvenObject=new Object();
			this.mensajecorreoinvensObject=new ArrayList<Object>();
			
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
			
			this.mensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.mensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MensajeCorreoInven getMensajeCorreoInven() throws Exception {	
		MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToGet(mensajecorreoinven,this.datosCliente,this.arrDatoGeneral);
		MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToGet(mensajecorreoinven,this.arrDatoGeneral);
		
		return mensajecorreoinven;
	}
		
	public void setMensajeCorreoInven(MensajeCorreoInven newMensajeCorreoInven) {
		this.mensajecorreoinven = newMensajeCorreoInven;
	}
	
	public MensajeCorreoInvenDataAccess getMensajeCorreoInvenDataAccess() {
		return mensajecorreoinvenDataAccess;
	}
	
	public void setMensajeCorreoInvenDataAccess(MensajeCorreoInvenDataAccess newmensajecorreoinvenDataAccess) {
		this.mensajecorreoinvenDataAccess = newmensajecorreoinvenDataAccess;
	}
	
	public List<MensajeCorreoInven> getMensajeCorreoInvens() throws Exception {		
		this.quitarMensajeCorreoInvensNulos();
		
		MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToGets(mensajecorreoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (MensajeCorreoInven mensajecorreoinvenLocal: mensajecorreoinvens ) {
			MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToGet(mensajecorreoinvenLocal,this.arrDatoGeneral);
		}
		
		return mensajecorreoinvens;
	}
	
	public void setMensajeCorreoInvens(List<MensajeCorreoInven> newMensajeCorreoInvens) {
		this.mensajecorreoinvens = newMensajeCorreoInvens;
	}
	
	public Object getMensajeCorreoInvenObject() {	
		this.mensajecorreoinvenObject=this.mensajecorreoinvenDataAccess.getEntityObject();
		return this.mensajecorreoinvenObject;
	}
		
	public void setMensajeCorreoInvenObject(Object newMensajeCorreoInvenObject) {
		this.mensajecorreoinvenObject = newMensajeCorreoInvenObject;
	}
	
	public List<Object> getMensajeCorreoInvensObject() {		
		this.mensajecorreoinvensObject=this.mensajecorreoinvenDataAccess.getEntitiesObject();
		return this.mensajecorreoinvensObject;
	}
		
	public void setMensajeCorreoInvensObject(List<Object> newMensajeCorreoInvensObject) {
		this.mensajecorreoinvensObject = newMensajeCorreoInvensObject;
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
		
		if(this.mensajecorreoinvenDataAccess!=null) {
			this.mensajecorreoinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			mensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			mensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		mensajecorreoinven = new  MensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mensajecorreoinven=mensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinven);
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
		mensajecorreoinven = new  MensajeCorreoInven();
		  		  
        try {
			
			mensajecorreoinven=mensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		mensajecorreoinven = new  MensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mensajecorreoinven=mensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinven);
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
		mensajecorreoinven = new  MensajeCorreoInven();
		  		  
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
		mensajecorreoinven = new  MensajeCorreoInven();
		  		  
        try {
			
			mensajecorreoinven=mensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		mensajecorreoinven = new  MensajeCorreoInven();
		  		  
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
		mensajecorreoinven = new  MensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =mensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mensajecorreoinven = new  MensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=mensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mensajecorreoinven = new  MensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =mensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mensajecorreoinven = new  MensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=mensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mensajecorreoinven = new  MensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =mensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mensajecorreoinven = new  MensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=mensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
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
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
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
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
        try {			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
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
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
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
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
        try {
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
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
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
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
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		mensajecorreoinven = new  MensajeCorreoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinven=mensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinven);
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
		mensajecorreoinven = new  MensajeCorreoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinven=mensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
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
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		  		  
        try {
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMensajeCorreoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getTodosMensajeCorreoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
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
	
	public  void  getTodosMensajeCorreoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		mensajecorreoinvens = new  ArrayList<MensajeCorreoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMensajeCorreoInven(mensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMensajeCorreoInven(MensajeCorreoInven mensajecorreoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(mensajecorreoinven.getIsNew() || mensajecorreoinven.getIsChanged()) { 
			this.invalidValues = mensajecorreoinvenValidator.getInvalidValues(mensajecorreoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(mensajecorreoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMensajeCorreoInven(List<MensajeCorreoInven> MensajeCorreoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(MensajeCorreoInven mensajecorreoinvenLocal:mensajecorreoinvens) {				
			estaValidadoObjeto=this.validarGuardarMensajeCorreoInven(mensajecorreoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMensajeCorreoInven(List<MensajeCorreoInven> MensajeCorreoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMensajeCorreoInven(mensajecorreoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMensajeCorreoInven(MensajeCorreoInven MensajeCorreoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMensajeCorreoInven(mensajecorreoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(MensajeCorreoInven mensajecorreoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+mensajecorreoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"mensajecorreoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMensajeCorreoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-saveMensajeCorreoInvenWithConnection");connexion.begin();			
			
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSave(this.mensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToSave(this.mensajecorreoinven,this.arrDatoGeneral);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMensajeCorreoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMensajeCorreoInven(this.mensajecorreoinven)) {
				MensajeCorreoInvenDataAccess.save(this.mensajecorreoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.mensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSaveAfter(this.mensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMensajeCorreoInven();
			
			connexion.commit();			
			
			if(this.mensajecorreoinven.getIsDeleted()) {
				this.mensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMensajeCorreoInven()throws Exception {	
		try {	
			
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSave(this.mensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToSave(this.mensajecorreoinven,this.arrDatoGeneral);
			
			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMensajeCorreoInven(this.mensajecorreoinven)) {			
				MensajeCorreoInvenDataAccess.save(this.mensajecorreoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.mensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSaveAfter(this.mensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.mensajecorreoinven.getIsDeleted()) {
				this.mensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMensajeCorreoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-saveMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSaves(mensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMensajeCorreoInvens();
			
			Boolean validadoTodosMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MensajeCorreoInven mensajecorreoinvenLocal:mensajecorreoinvens) {		
				if(mensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToSave(mensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMensajeCorreoInven(mensajecorreoinvenLocal)) {
					MensajeCorreoInvenDataAccess.save(mensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSavesAfter(mensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMensajeCorreoInvens();
			
			connexion.commit();		
			
			this.quitarMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMensajeCorreoInvens()throws Exception {				
		 try {	
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSaves(mensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MensajeCorreoInven mensajecorreoinvenLocal:mensajecorreoinvens) {				
				if(mensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToSave(mensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMensajeCorreoInven(mensajecorreoinvenLocal)) {				
					MensajeCorreoInvenDataAccess.save(mensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MensajeCorreoInvenLogicAdditional.checkMensajeCorreoInvenToSavesAfter(mensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MensajeCorreoInvenParameterReturnGeneral procesarAccionMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MensajeCorreoInven> mensajecorreoinvens,MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenParameterGeneral)throws Exception {
		 try {	
			MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenReturnGeneral=new MensajeCorreoInvenParameterReturnGeneral();
	
			MensajeCorreoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mensajecorreoinvens,mensajecorreoinvenParameterGeneral,mensajecorreoinvenReturnGeneral);
			
			return mensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MensajeCorreoInvenParameterReturnGeneral procesarAccionMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MensajeCorreoInven> mensajecorreoinvens,MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-procesarAccionMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenReturnGeneral=new MensajeCorreoInvenParameterReturnGeneral();
	
			MensajeCorreoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mensajecorreoinvens,mensajecorreoinvenParameterGeneral,mensajecorreoinvenReturnGeneral);
			
			this.connexion.commit();
			
			return mensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MensajeCorreoInvenParameterReturnGeneral procesarEventosMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MensajeCorreoInven> mensajecorreoinvens,MensajeCorreoInven mensajecorreoinven,MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenParameterGeneral,Boolean isEsNuevoMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenReturnGeneral=new MensajeCorreoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MensajeCorreoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mensajecorreoinvens,mensajecorreoinven,mensajecorreoinvenParameterGeneral,mensajecorreoinvenReturnGeneral,isEsNuevoMensajeCorreoInven,clases);
			
			return mensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MensajeCorreoInvenParameterReturnGeneral procesarEventosMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MensajeCorreoInven> mensajecorreoinvens,MensajeCorreoInven mensajecorreoinven,MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenParameterGeneral,Boolean isEsNuevoMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-procesarEventosMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenReturnGeneral=new MensajeCorreoInvenParameterReturnGeneral();
	
			mensajecorreoinvenReturnGeneral.setMensajeCorreoInven(mensajecorreoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MensajeCorreoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mensajecorreoinvens,mensajecorreoinven,mensajecorreoinvenParameterGeneral,mensajecorreoinvenReturnGeneral,isEsNuevoMensajeCorreoInven,clases);
			
			this.connexion.commit();
			
			return mensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MensajeCorreoInvenParameterReturnGeneral procesarImportacionMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-procesarImportacionMensajeCorreoInvensWithConnection");connexion.begin();			
			
			MensajeCorreoInvenParameterReturnGeneral mensajecorreoinvenReturnGeneral=new MensajeCorreoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.mensajecorreoinvens=new ArrayList<MensajeCorreoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.mensajecorreoinven=new MensajeCorreoInven();
				
				
				if(conColumnasBase) {this.mensajecorreoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.mensajecorreoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.mensajecorreoinven.settema(arrColumnas[iColumn++]);
			this.mensajecorreoinven.setmensaje(arrColumnas[iColumn++]);
				this.mensajecorreoinven.setaviso(arrColumnas[iColumn++]);
				this.mensajecorreoinven.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.mensajecorreoinvens.add(this.mensajecorreoinven);
			}
			
			this.saveMensajeCorreoInvens();
			
			this.connexion.commit();
			
			mensajecorreoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			mensajecorreoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return mensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMensajeCorreoInvensEliminados() throws Exception {				
		
		List<MensajeCorreoInven> mensajecorreoinvensAux= new ArrayList<MensajeCorreoInven>();
		
		for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens) {
			if(!mensajecorreoinven.getIsDeleted()) {
				mensajecorreoinvensAux.add(mensajecorreoinven);
			}
		}
		
		mensajecorreoinvens=mensajecorreoinvensAux;
	}
	
	public void quitarMensajeCorreoInvensNulos() throws Exception {				
		
		List<MensajeCorreoInven> mensajecorreoinvensAux= new ArrayList<MensajeCorreoInven>();
		
		for(MensajeCorreoInven mensajecorreoinven : this.mensajecorreoinvens) {
			if(mensajecorreoinven==null) {
				mensajecorreoinvensAux.add(mensajecorreoinven);
			}
		}
		
		//this.mensajecorreoinvens=mensajecorreoinvensAux;
		
		this.mensajecorreoinvens.removeAll(mensajecorreoinvensAux);
	}
	
	public void getSetVersionRowMensajeCorreoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(mensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((mensajecorreoinven.getIsDeleted() || (mensajecorreoinven.getIsChanged()&&!mensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=mensajecorreoinvenDataAccess.getSetVersionRowMensajeCorreoInven(connexion,mensajecorreoinven.getId());
				
				if(!mensajecorreoinven.getVersionRow().equals(timestamp)) {	
					mensajecorreoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				mensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMensajeCorreoInven()throws Exception {	
		
		if(mensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((mensajecorreoinven.getIsDeleted() || (mensajecorreoinven.getIsChanged()&&!mensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=mensajecorreoinvenDataAccess.getSetVersionRowMensajeCorreoInven(connexion,mensajecorreoinven.getId());
			
			try {							
				if(!mensajecorreoinven.getVersionRow().equals(timestamp)) {	
					mensajecorreoinven.setVersionRow(timestamp);
				}
				
				mensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMensajeCorreoInvensWithConnection()throws Exception {	
		if(mensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(MensajeCorreoInven mensajecorreoinvenAux:mensajecorreoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(mensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mensajecorreoinvenAux.getIsDeleted() || (mensajecorreoinvenAux.getIsChanged()&&!mensajecorreoinvenAux.getIsNew())) {
						
						timestamp=mensajecorreoinvenDataAccess.getSetVersionRowMensajeCorreoInven(connexion,mensajecorreoinvenAux.getId());
						
						if(!mensajecorreoinven.getVersionRow().equals(timestamp)) {	
							mensajecorreoinvenAux.setVersionRow(timestamp);
						}
								
						mensajecorreoinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowMensajeCorreoInvens()throws Exception {	
		if(mensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(MensajeCorreoInven mensajecorreoinvenAux:mensajecorreoinvens) {
					if(mensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mensajecorreoinvenAux.getIsDeleted() || (mensajecorreoinvenAux.getIsChanged()&&!mensajecorreoinvenAux.getIsNew())) {
						
						timestamp=mensajecorreoinvenDataAccess.getSetVersionRowMensajeCorreoInven(connexion,mensajecorreoinvenAux.getId());
						
						if(!mensajecorreoinvenAux.getVersionRow().equals(timestamp)) {	
							mensajecorreoinvenAux.setVersionRow(timestamp);
						}
						
													
						mensajecorreoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyMensajeCorreoInvenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTipoMensajeCorreoInven) throws Exception {
		MensajeCorreoInvenParameterReturnGeneral  mensajecorreoinvenReturnGeneral =new MensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyMensajeCorreoInvenWithConnection");connexion.begin();
			
			mensajecorreoinvenReturnGeneral =new MensajeCorreoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mensajecorreoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mensajecorreoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			mensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMensajeCorreoInven> tipomensajecorreoinvensForeignKey=new ArrayList<TipoMensajeCorreoInven>();
			TipoMensajeCorreoInvenLogic tipomensajecorreoinvenLogic=new TipoMensajeCorreoInvenLogic();
			tipomensajecorreoinvenLogic.setConnexion(this.connexion);
			tipomensajecorreoinvenLogic.getTipoMensajeCorreoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMensajeCorreoInven.equals("NONE")) {
				tipomensajecorreoinvenLogic.getTodosTipoMensajeCorreoInvens(finalQueryGlobalTipoMensajeCorreoInven,new Pagination());
				tipomensajecorreoinvensForeignKey=tipomensajecorreoinvenLogic.getTipoMensajeCorreoInvens();
			}

			mensajecorreoinvenReturnGeneral.settipomensajecorreoinvensForeignKey(tipomensajecorreoinvensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return mensajecorreoinvenReturnGeneral;
	}
	
	public MensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyMensajeCorreoInven(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTipoMensajeCorreoInven) throws Exception {
		MensajeCorreoInvenParameterReturnGeneral  mensajecorreoinvenReturnGeneral =new MensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			mensajecorreoinvenReturnGeneral =new MensajeCorreoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mensajecorreoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mensajecorreoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			mensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMensajeCorreoInven> tipomensajecorreoinvensForeignKey=new ArrayList<TipoMensajeCorreoInven>();
			TipoMensajeCorreoInvenLogic tipomensajecorreoinvenLogic=new TipoMensajeCorreoInvenLogic();
			tipomensajecorreoinvenLogic.setConnexion(this.connexion);
			tipomensajecorreoinvenLogic.getTipoMensajeCorreoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMensajeCorreoInven.equals("NONE")) {
				tipomensajecorreoinvenLogic.getTodosTipoMensajeCorreoInvens(finalQueryGlobalTipoMensajeCorreoInven,new Pagination());
				tipomensajecorreoinvensForeignKey=tipomensajecorreoinvenLogic.getTipoMensajeCorreoInvens();
			}

			mensajecorreoinvenReturnGeneral.settipomensajecorreoinvensForeignKey(tipomensajecorreoinvensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return mensajecorreoinvenReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyMensajeCorreoInvenWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic=new DetalleMensajeCorreoInvenLogic();
			MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic=new MailMensajeCorreoInvenLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyMensajeCorreoInvenWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleMensajeCorreoInven.class));
			classes.add(new Classe(MailMensajeCorreoInven.class));
											
			

			detallemensajecorreoinvenLogic.setConnexion(this.getConnexion());
			detallemensajecorreoinvenLogic.setDatosCliente(this.datosCliente);
			detallemensajecorreoinvenLogic.setIsConRefrescarForeignKeys(true);

			mailmensajecorreoinvenLogic.setConnexion(this.getConnexion());
			mailmensajecorreoinvenLogic.setDatosCliente(this.datosCliente);
			mailmensajecorreoinvenLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(MensajeCorreoInven mensajecorreoinven:this.mensajecorreoinvens) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfDetalleMensajeCorreoInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemensajecorreoinvenLogic.setDetalleMensajeCorreoInvens(mensajecorreoinven.detallemensajecorreoinvens);
				detallemensajecorreoinvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=MailMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfMailMensajeCorreoInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				mailmensajecorreoinvenLogic.setMailMensajeCorreoInvens(mensajecorreoinven.mailmensajecorreoinvens);
				mailmensajecorreoinvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(MensajeCorreoInven mensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToGet(mensajecorreoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mensajecorreoinven.setEmpresa(mensajecorreoinvenDataAccess.getEmpresa(connexion,mensajecorreoinven));
		mensajecorreoinven.setSucursal(mensajecorreoinvenDataAccess.getSucursal(connexion,mensajecorreoinven));
		mensajecorreoinven.setModulo(mensajecorreoinvenDataAccess.getModulo(connexion,mensajecorreoinven));
		mensajecorreoinven.setTipoMensajeCorreoInven(mensajecorreoinvenDataAccess.getTipoMensajeCorreoInven(connexion,mensajecorreoinven));
		mensajecorreoinven.setDetalleMensajeCorreoInvens(mensajecorreoinvenDataAccess.getDetalleMensajeCorreoInvens(connexion,mensajecorreoinven));
		mensajecorreoinven.setMailMensajeCorreoInvens(mensajecorreoinvenDataAccess.getMailMensajeCorreoInvens(connexion,mensajecorreoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mensajecorreoinven.setEmpresa(mensajecorreoinvenDataAccess.getEmpresa(connexion,mensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mensajecorreoinven.setSucursal(mensajecorreoinvenDataAccess.getSucursal(connexion,mensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				mensajecorreoinven.setModulo(mensajecorreoinvenDataAccess.getModulo(connexion,mensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(TipoMensajeCorreoInven.class)) {
				mensajecorreoinven.setTipoMensajeCorreoInven(mensajecorreoinvenDataAccess.getTipoMensajeCorreoInven(connexion,mensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mensajecorreoinven.setDetalleMensajeCorreoInvens(mensajecorreoinvenDataAccess.getDetalleMensajeCorreoInvens(connexion,mensajecorreoinven));

				if(this.isConDeep) {
					DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(this.connexion);
					detallemensajecorreoinvenLogic.setDetalleMensajeCorreoInvens(mensajecorreoinven.getDetalleMensajeCorreoInvens());
					ArrayList<Classe> classesLocal=DetalleMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfDetalleMensajeCorreoInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemensajecorreoinvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(detallemensajecorreoinvenLogic.getDetalleMensajeCorreoInvens());
					mensajecorreoinven.setDetalleMensajeCorreoInvens(detallemensajecorreoinvenLogic.getDetalleMensajeCorreoInvens());
				}

				continue;
			}

			if(clas.clas.equals(MailMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mensajecorreoinven.setMailMensajeCorreoInvens(mensajecorreoinvenDataAccess.getMailMensajeCorreoInvens(connexion,mensajecorreoinven));

				if(this.isConDeep) {
					MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic= new MailMensajeCorreoInvenLogic(this.connexion);
					mailmensajecorreoinvenLogic.setMailMensajeCorreoInvens(mensajecorreoinven.getMailMensajeCorreoInvens());
					ArrayList<Classe> classesLocal=MailMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfMailMensajeCorreoInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					mailmensajecorreoinvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MailMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMailMensajeCorreoInven(mailmensajecorreoinvenLogic.getMailMensajeCorreoInvens());
					mensajecorreoinven.setMailMensajeCorreoInvens(mailmensajecorreoinvenLogic.getMailMensajeCorreoInvens());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setEmpresa(mensajecorreoinvenDataAccess.getEmpresa(connexion,mensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setSucursal(mensajecorreoinvenDataAccess.getSucursal(connexion,mensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setModulo(mensajecorreoinvenDataAccess.getModulo(connexion,mensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMensajeCorreoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setTipoMensajeCorreoInven(mensajecorreoinvenDataAccess.getTipoMensajeCorreoInven(connexion,mensajecorreoinven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMensajeCorreoInven.class));
			mensajecorreoinven.setDetalleMensajeCorreoInvens(mensajecorreoinvenDataAccess.getDetalleMensajeCorreoInvens(connexion,mensajecorreoinven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MailMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MailMensajeCorreoInven.class));
			mensajecorreoinven.setMailMensajeCorreoInvens(mensajecorreoinvenDataAccess.getMailMensajeCorreoInvens(connexion,mensajecorreoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mensajecorreoinven.setEmpresa(mensajecorreoinvenDataAccess.getEmpresa(connexion,mensajecorreoinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		mensajecorreoinven.setSucursal(mensajecorreoinvenDataAccess.getSucursal(connexion,mensajecorreoinven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		mensajecorreoinven.setModulo(mensajecorreoinvenDataAccess.getModulo(connexion,mensajecorreoinven));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(mensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
		mensajecorreoinven.setTipoMensajeCorreoInven(mensajecorreoinvenDataAccess.getTipoMensajeCorreoInven(connexion,mensajecorreoinven));
		TipoMensajeCorreoInvenLogic tipomensajecorreoinvenLogic= new TipoMensajeCorreoInvenLogic(connexion);
		tipomensajecorreoinvenLogic.deepLoad(mensajecorreoinven.getTipoMensajeCorreoInven(),isDeep,deepLoadType,clases);
				

		mensajecorreoinven.setDetalleMensajeCorreoInvens(mensajecorreoinvenDataAccess.getDetalleMensajeCorreoInvens(connexion,mensajecorreoinven));

		for(DetalleMensajeCorreoInven detallemensajecorreoinven:mensajecorreoinven.getDetalleMensajeCorreoInvens()) {
			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
			detallemensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
		}

		mensajecorreoinven.setMailMensajeCorreoInvens(mensajecorreoinvenDataAccess.getMailMensajeCorreoInvens(connexion,mensajecorreoinven));

		for(MailMensajeCorreoInven mailmensajecorreoinven:mensajecorreoinven.getMailMensajeCorreoInvens()) {
			MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic= new MailMensajeCorreoInvenLogic(connexion);
			mailmensajecorreoinvenLogic.deepLoad(mailmensajecorreoinven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mensajecorreoinven.setEmpresa(mensajecorreoinvenDataAccess.getEmpresa(connexion,mensajecorreoinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(mensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mensajecorreoinven.setSucursal(mensajecorreoinvenDataAccess.getSucursal(connexion,mensajecorreoinven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(mensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				mensajecorreoinven.setModulo(mensajecorreoinvenDataAccess.getModulo(connexion,mensajecorreoinven));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(mensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMensajeCorreoInven.class)) {
				mensajecorreoinven.setTipoMensajeCorreoInven(mensajecorreoinvenDataAccess.getTipoMensajeCorreoInven(connexion,mensajecorreoinven));
				TipoMensajeCorreoInvenLogic tipomensajecorreoinvenLogic= new TipoMensajeCorreoInvenLogic(connexion);
				tipomensajecorreoinvenLogic.deepLoad(mensajecorreoinven.getTipoMensajeCorreoInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mensajecorreoinven.setDetalleMensajeCorreoInvens(mensajecorreoinvenDataAccess.getDetalleMensajeCorreoInvens(connexion,mensajecorreoinven));

				for(DetalleMensajeCorreoInven detallemensajecorreoinven:mensajecorreoinven.getDetalleMensajeCorreoInvens()) {
					DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
					detallemensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MailMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mensajecorreoinven.setMailMensajeCorreoInvens(mensajecorreoinvenDataAccess.getMailMensajeCorreoInvens(connexion,mensajecorreoinven));

				for(MailMensajeCorreoInven mailmensajecorreoinven:mensajecorreoinven.getMailMensajeCorreoInvens()) {
					MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic= new MailMensajeCorreoInvenLogic(connexion);
					mailmensajecorreoinvenLogic.deepLoad(mailmensajecorreoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setEmpresa(mensajecorreoinvenDataAccess.getEmpresa(connexion,mensajecorreoinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(mensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setSucursal(mensajecorreoinvenDataAccess.getSucursal(connexion,mensajecorreoinven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(mensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setModulo(mensajecorreoinvenDataAccess.getModulo(connexion,mensajecorreoinven));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(mensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMensajeCorreoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mensajecorreoinven.setTipoMensajeCorreoInven(mensajecorreoinvenDataAccess.getTipoMensajeCorreoInven(connexion,mensajecorreoinven));
			TipoMensajeCorreoInvenLogic tipomensajecorreoinvenLogic= new TipoMensajeCorreoInvenLogic(connexion);
			tipomensajecorreoinvenLogic.deepLoad(mensajecorreoinven.getTipoMensajeCorreoInven(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMensajeCorreoInven.class));
			mensajecorreoinven.setDetalleMensajeCorreoInvens(mensajecorreoinvenDataAccess.getDetalleMensajeCorreoInvens(connexion,mensajecorreoinven));

			for(DetalleMensajeCorreoInven detallemensajecorreoinven:mensajecorreoinven.getDetalleMensajeCorreoInvens()) {
				DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
				detallemensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MailMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MailMensajeCorreoInven.class));
			mensajecorreoinven.setMailMensajeCorreoInvens(mensajecorreoinvenDataAccess.getMailMensajeCorreoInvens(connexion,mensajecorreoinven));

			for(MailMensajeCorreoInven mailmensajecorreoinven:mensajecorreoinven.getMailMensajeCorreoInvens()) {
				MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic= new MailMensajeCorreoInvenLogic(connexion);
				mailmensajecorreoinvenLogic.deepLoad(mailmensajecorreoinven,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(MensajeCorreoInven mensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MensajeCorreoInvenLogicAdditional.updateMensajeCorreoInvenToSave(mensajecorreoinven,this.arrDatoGeneral);
			
MensajeCorreoInvenDataAccess.save(mensajecorreoinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(mensajecorreoinven.getEmpresa(),connexion);

		SucursalDataAccess.save(mensajecorreoinven.getSucursal(),connexion);

		ModuloDataAccess.save(mensajecorreoinven.getModulo(),connexion);

		TipoMensajeCorreoInvenDataAccess.save(mensajecorreoinven.getTipoMensajeCorreoInven(),connexion);

		for(DetalleMensajeCorreoInven detallemensajecorreoinven:mensajecorreoinven.getDetalleMensajeCorreoInvens()) {
			detallemensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
			DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
		}

		for(MailMensajeCorreoInven mailmensajecorreoinven:mensajecorreoinven.getMailMensajeCorreoInvens()) {
			mailmensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
			MailMensajeCorreoInvenDataAccess.save(mailmensajecorreoinven,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mensajecorreoinven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mensajecorreoinven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(mensajecorreoinven.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMensajeCorreoInven.class)) {
				TipoMensajeCorreoInvenDataAccess.save(mensajecorreoinven.getTipoMensajeCorreoInven(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMensajeCorreoInven detallemensajecorreoinven:mensajecorreoinven.getDetalleMensajeCorreoInvens()) {
					detallemensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
					DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(MailMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MailMensajeCorreoInven mailmensajecorreoinven:mensajecorreoinven.getMailMensajeCorreoInvens()) {
					mailmensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
					MailMensajeCorreoInvenDataAccess.save(mailmensajecorreoinven,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(mensajecorreoinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(mensajecorreoinven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(mensajecorreoinven.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(mensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				

		TipoMensajeCorreoInvenDataAccess.save(mensajecorreoinven.getTipoMensajeCorreoInven(),connexion);
		TipoMensajeCorreoInvenLogic tipomensajecorreoinvenLogic= new TipoMensajeCorreoInvenLogic(connexion);
		tipomensajecorreoinvenLogic.deepLoad(mensajecorreoinven.getTipoMensajeCorreoInven(),isDeep,deepLoadType,clases);
				

		for(DetalleMensajeCorreoInven detallemensajecorreoinven:mensajecorreoinven.getDetalleMensajeCorreoInvens()) {
			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
			detallemensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
			DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
			detallemensajecorreoinvenLogic.deepSave(detallemensajecorreoinven,isDeep,deepLoadType,clases);
		}

		for(MailMensajeCorreoInven mailmensajecorreoinven:mensajecorreoinven.getMailMensajeCorreoInvens()) {
			MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic= new MailMensajeCorreoInvenLogic(connexion);
			mailmensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
			MailMensajeCorreoInvenDataAccess.save(mailmensajecorreoinven,connexion);
			mailmensajecorreoinvenLogic.deepSave(mailmensajecorreoinven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mensajecorreoinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(mensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mensajecorreoinven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(mensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(mensajecorreoinven.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(mensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMensajeCorreoInven.class)) {
				TipoMensajeCorreoInvenDataAccess.save(mensajecorreoinven.getTipoMensajeCorreoInven(),connexion);
				TipoMensajeCorreoInvenLogic tipomensajecorreoinvenLogic= new TipoMensajeCorreoInvenLogic(connexion);
				tipomensajecorreoinvenLogic.deepSave(mensajecorreoinven.getTipoMensajeCorreoInven(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMensajeCorreoInven detallemensajecorreoinven:mensajecorreoinven.getDetalleMensajeCorreoInvens()) {
					DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
					detallemensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
					DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
					detallemensajecorreoinvenLogic.deepSave(detallemensajecorreoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MailMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MailMensajeCorreoInven mailmensajecorreoinven:mensajecorreoinven.getMailMensajeCorreoInvens()) {
					MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic= new MailMensajeCorreoInvenLogic(connexion);
					mailmensajecorreoinven.setid_mensaje_correo_inven(mensajecorreoinven.getId());
					MailMensajeCorreoInvenDataAccess.save(mailmensajecorreoinven,connexion);
					mailmensajecorreoinvenLogic.deepSave(mailmensajecorreoinven,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(MensajeCorreoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(mensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(mensajecorreoinven);
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
			this.deepLoad(this.mensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MensajeCorreoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(mensajecorreoinvens!=null) {
				for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens) {
					this.deepLoad(mensajecorreoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(mensajecorreoinvens);
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
			if(mensajecorreoinvens!=null) {
				for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens) {
					this.deepLoad(mensajecorreoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(mensajecorreoinvens);
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
			this.getNewConnexionToDeep(MensajeCorreoInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(mensajecorreoinven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(MensajeCorreoInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(mensajecorreoinvens!=null) {
				for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens) {
					this.deepSave(mensajecorreoinven,isDeep,deepLoadType,clases);
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
			if(mensajecorreoinvens!=null) {
				for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens) {
					this.deepSave(mensajecorreoinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMensajeCorreoInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MensajeCorreoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMensajeCorreoInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MensajeCorreoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMensajeCorreoInvensFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,MensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMensajeCorreoInvensFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,MensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMensajeCorreoInvensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MensajeCorreoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMensajeCorreoInvensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MensajeCorreoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMensajeCorreoInvensFK_IdTipoMensajeCorreoInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_mensaje_correo_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMensajeCorreoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMensajeCorreoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_mensaje_correo_inven,MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMensajeCorreoInven);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMensajeCorreoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMensajeCorreoInvensFK_IdTipoMensajeCorreoInven(String sFinalQuery,Pagination pagination,Long id_tipo_mensaje_correo_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMensajeCorreoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMensajeCorreoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_mensaje_correo_inven,MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMensajeCorreoInven);

			MensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMensajeCorreoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesMensajeCorreoInven(this.mensajecorreoinvens);
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
			if(MensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MensajeCorreoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,MensajeCorreoInven mensajecorreoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(mensajecorreoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MensajeCorreoInvenDataAccess.TABLENAME, mensajecorreoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MensajeCorreoInvenLogic.registrarAuditoriaDetallesMensajeCorreoInven(connexion,mensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(mensajecorreoinven.getIsDeleted()) {
					/*if(!mensajecorreoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MensajeCorreoInvenDataAccess.TABLENAME, mensajecorreoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MensajeCorreoInvenLogic.registrarAuditoriaDetallesMensajeCorreoInven(connexion,mensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MensajeCorreoInvenDataAccess.TABLENAME, mensajecorreoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(mensajecorreoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MensajeCorreoInvenDataAccess.TABLENAME, mensajecorreoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MensajeCorreoInvenLogic.registrarAuditoriaDetallesMensajeCorreoInven(connexion,mensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMensajeCorreoInven(Connexion connexion,MensajeCorreoInven mensajecorreoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.getid_empresa().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_empresa().toString();
				}
				if(mensajecorreoinven.getid_empresa()!=null)
				{
					strValorNuevo=mensajecorreoinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.getid_sucursal().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_sucursal()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_sucursal().toString();
				}
				if(mensajecorreoinven.getid_sucursal()!=null)
				{
					strValorNuevo=mensajecorreoinven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.getid_modulo().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_modulo()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_modulo().toString();
				}
				if(mensajecorreoinven.getid_modulo()!=null)
				{
					strValorNuevo=mensajecorreoinven.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.getid_tipo_mensaje_correo_inven().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_tipo_mensaje_correo_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_tipo_mensaje_correo_inven()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().getid_tipo_mensaje_correo_inven().toString();
				}
				if(mensajecorreoinven.getid_tipo_mensaje_correo_inven()!=null)
				{
					strValorNuevo=mensajecorreoinven.getid_tipo_mensaje_correo_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN,strValorActual,strValorNuevo);
			}	
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.gettema().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().gettema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().gettema()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().gettema();
				}
				if(mensajecorreoinven.gettema()!=null)
				{
					strValorNuevo=mensajecorreoinven.gettema() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.TEMA,strValorActual,strValorNuevo);
			}	
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.getmensaje().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().getmensaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().getmensaje()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().getmensaje();
				}
				if(mensajecorreoinven.getmensaje()!=null)
				{
					strValorNuevo=mensajecorreoinven.getmensaje() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.MENSAJE,strValorActual,strValorNuevo);
			}	
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.getaviso().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().getaviso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().getaviso()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().getaviso();
				}
				if(mensajecorreoinven.getaviso()!=null)
				{
					strValorNuevo=mensajecorreoinven.getaviso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.AVISO,strValorActual,strValorNuevo);
			}	
			
			if(mensajecorreoinven.getIsNew()||!mensajecorreoinven.getesta_activo().equals(mensajecorreoinven.getMensajeCorreoInvenOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mensajecorreoinven.getMensajeCorreoInvenOriginal().getesta_activo()!=null)
				{
					strValorActual=mensajecorreoinven.getMensajeCorreoInvenOriginal().getesta_activo().toString();
				}
				if(mensajecorreoinven.getesta_activo()!=null)
				{
					strValorNuevo=mensajecorreoinven.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MensajeCorreoInvenConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMensajeCorreoInvenRelacionesWithConnection(MensajeCorreoInven mensajecorreoinven,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,List<MailMensajeCorreoInven> mailmensajecorreoinvens) throws Exception {

		if(!mensajecorreoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMensajeCorreoInvenRelacionesBase(mensajecorreoinven,detallemensajecorreoinvens,mailmensajecorreoinvens,true);
		}
	}

	public void saveMensajeCorreoInvenRelaciones(MensajeCorreoInven mensajecorreoinven,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,List<MailMensajeCorreoInven> mailmensajecorreoinvens)throws Exception {

		if(!mensajecorreoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMensajeCorreoInvenRelacionesBase(mensajecorreoinven,detallemensajecorreoinvens,mailmensajecorreoinvens,false);
		}
	}

	public void saveMensajeCorreoInvenRelacionesBase(MensajeCorreoInven mensajecorreoinven,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,List<MailMensajeCorreoInven> mailmensajecorreoinvens,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("MensajeCorreoInven-saveRelacionesWithConnection");}
	
			mensajecorreoinven.setDetalleMensajeCorreoInvens(detallemensajecorreoinvens);
			mensajecorreoinven.setMailMensajeCorreoInvens(mailmensajecorreoinvens);

			this.setMensajeCorreoInven(mensajecorreoinven);

			if(MensajeCorreoInvenLogicAdditional.validarSaveRelaciones(mensajecorreoinven,this)) {

				MensajeCorreoInvenLogicAdditional.updateRelacionesToSave(mensajecorreoinven,this);

				if((mensajecorreoinven.getIsNew()||mensajecorreoinven.getIsChanged())&&!mensajecorreoinven.getIsDeleted()) {
					this.saveMensajeCorreoInven();
					this.saveMensajeCorreoInvenRelacionesDetalles(detallemensajecorreoinvens,mailmensajecorreoinvens);

				} else if(mensajecorreoinven.getIsDeleted()) {
					this.saveMensajeCorreoInvenRelacionesDetalles(detallemensajecorreoinvens,mailmensajecorreoinvens);
					this.saveMensajeCorreoInven();
				}

				MensajeCorreoInvenLogicAdditional.updateRelacionesToSaveAfter(mensajecorreoinven,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleMensajeCorreoInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleMensajeCorreoInvens(detallemensajecorreoinvens,true,true);
			MailMensajeCorreoInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresMailMensajeCorreoInvens(mailmensajecorreoinvens,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveMensajeCorreoInvenRelacionesDetalles(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,List<MailMensajeCorreoInven> mailmensajecorreoinvens)throws Exception {
		try {
	

			Long idMensajeCorreoInvenActual=this.getMensajeCorreoInven().getId();

			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic_Desde_MensajeCorreoInven=new DetalleMensajeCorreoInvenLogic();
			detallemensajecorreoinvenLogic_Desde_MensajeCorreoInven.setDetalleMensajeCorreoInvens(detallemensajecorreoinvens);

			detallemensajecorreoinvenLogic_Desde_MensajeCorreoInven.setConnexion(this.getConnexion());
			detallemensajecorreoinvenLogic_Desde_MensajeCorreoInven.setDatosCliente(this.datosCliente);

			for(DetalleMensajeCorreoInven detallemensajecorreoinven_Desde_MensajeCorreoInven:detallemensajecorreoinvenLogic_Desde_MensajeCorreoInven.getDetalleMensajeCorreoInvens()) {
				detallemensajecorreoinven_Desde_MensajeCorreoInven.setid_mensaje_correo_inven(idMensajeCorreoInvenActual);
			}

			detallemensajecorreoinvenLogic_Desde_MensajeCorreoInven.saveDetalleMensajeCorreoInvens();

			MailMensajeCorreoInvenLogic mailmensajecorreoinvenLogic_Desde_MensajeCorreoInven=new MailMensajeCorreoInvenLogic();
			mailmensajecorreoinvenLogic_Desde_MensajeCorreoInven.setMailMensajeCorreoInvens(mailmensajecorreoinvens);

			mailmensajecorreoinvenLogic_Desde_MensajeCorreoInven.setConnexion(this.getConnexion());
			mailmensajecorreoinvenLogic_Desde_MensajeCorreoInven.setDatosCliente(this.datosCliente);

			for(MailMensajeCorreoInven mailmensajecorreoinven_Desde_MensajeCorreoInven:mailmensajecorreoinvenLogic_Desde_MensajeCorreoInven.getMailMensajeCorreoInvens()) {
				mailmensajecorreoinven_Desde_MensajeCorreoInven.setid_mensaje_correo_inven(idMensajeCorreoInvenActual);
			}

			mailmensajecorreoinvenLogic_Desde_MensajeCorreoInven.saveMailMensajeCorreoInvens();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfMensajeCorreoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfMensajeCorreoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
