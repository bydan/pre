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
import com.bydan.erp.inventario.util.ParametroInvenConstantesFunciones;
import com.bydan.erp.inventario.util.ParametroInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ParametroInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.ParametroInven;
import com.bydan.erp.inventario.business.logic.ParametroInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroInvenLogic.class);
	
	protected ParametroInvenDataAccess parametroinvenDataAccess; 	
	protected ParametroInven parametroinven;
	protected List<ParametroInven> parametroinvens;
	protected Object parametroinvenObject;	
	protected List<Object> parametroinvensObject;
	
	public static ClassValidator<ParametroInven> parametroinvenValidator = new ClassValidator<ParametroInven>(ParametroInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroInvenLogicAdditional parametroinvenLogicAdditional=null;
	
	public ParametroInvenLogicAdditional getParametroInvenLogicAdditional() {
		return this.parametroinvenLogicAdditional;
	}
	
	public void setParametroInvenLogicAdditional(ParametroInvenLogicAdditional parametroinvenLogicAdditional) {
		try {
			this.parametroinvenLogicAdditional=parametroinvenLogicAdditional;
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
	
	
	
	
	public  ParametroInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametroinvenDataAccess = new ParametroInvenDataAccess();
			
			this.parametroinvens= new ArrayList<ParametroInven>();
			this.parametroinven= new ParametroInven();
			
			this.parametroinvenObject=new Object();
			this.parametroinvensObject=new ArrayList<Object>();
				
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
			
			this.parametroinvenDataAccess.setConnexionType(this.connexionType);
			this.parametroinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametroinvenDataAccess = new ParametroInvenDataAccess();
			this.parametroinvens= new ArrayList<ParametroInven>();
			this.parametroinven= new ParametroInven();
			this.parametroinvenObject=new Object();
			this.parametroinvensObject=new ArrayList<Object>();
			
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
			
			this.parametroinvenDataAccess.setConnexionType(this.connexionType);
			this.parametroinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroInven getParametroInven() throws Exception {	
		ParametroInvenLogicAdditional.checkParametroInvenToGet(parametroinven,this.datosCliente,this.arrDatoGeneral);
		ParametroInvenLogicAdditional.updateParametroInvenToGet(parametroinven,this.arrDatoGeneral);
		
		return parametroinven;
	}
		
	public void setParametroInven(ParametroInven newParametroInven) {
		this.parametroinven = newParametroInven;
	}
	
	public ParametroInvenDataAccess getParametroInvenDataAccess() {
		return parametroinvenDataAccess;
	}
	
	public void setParametroInvenDataAccess(ParametroInvenDataAccess newparametroinvenDataAccess) {
		this.parametroinvenDataAccess = newparametroinvenDataAccess;
	}
	
	public List<ParametroInven> getParametroInvens() throws Exception {		
		this.quitarParametroInvensNulos();
		
		ParametroInvenLogicAdditional.checkParametroInvenToGets(parametroinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroInven parametroinvenLocal: parametroinvens ) {
			ParametroInvenLogicAdditional.updateParametroInvenToGet(parametroinvenLocal,this.arrDatoGeneral);
		}
		
		return parametroinvens;
	}
	
	public void setParametroInvens(List<ParametroInven> newParametroInvens) {
		this.parametroinvens = newParametroInvens;
	}
	
	public Object getParametroInvenObject() {	
		this.parametroinvenObject=this.parametroinvenDataAccess.getEntityObject();
		return this.parametroinvenObject;
	}
		
	public void setParametroInvenObject(Object newParametroInvenObject) {
		this.parametroinvenObject = newParametroInvenObject;
	}
	
	public List<Object> getParametroInvensObject() {		
		this.parametroinvensObject=this.parametroinvenDataAccess.getEntitiesObject();
		return this.parametroinvensObject;
	}
		
	public void setParametroInvensObject(List<Object> newParametroInvensObject) {
		this.parametroinvensObject = newParametroInvensObject;
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
		
		if(this.parametroinvenDataAccess!=null) {
			this.parametroinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametroinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametroinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroinven = new  ParametroInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroinven=parametroinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinven);
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
		parametroinven = new  ParametroInven();
		  		  
        try {
			
			parametroinven=parametroinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroinven = new  ParametroInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroinven=parametroinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinven);
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
		parametroinven = new  ParametroInven();
		  		  
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
		parametroinven = new  ParametroInven();
		  		  
        try {
			
			parametroinven=parametroinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroinven = new  ParametroInven();
		  		  
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
		parametroinven = new  ParametroInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametroinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroinven = new  ParametroInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametroinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroinven = new  ParametroInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametroinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroinven = new  ParametroInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametroinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroinven = new  ParametroInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametroinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroinven = new  ParametroInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametroinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
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
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
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
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
        try {			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
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
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
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
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
        try {
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
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
		parametroinvens = new  ArrayList<ParametroInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
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
		parametroinvens = new  ArrayList<ParametroInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroinven = new  ParametroInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinven=parametroinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinven);
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
		parametroinven = new  ParametroInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinven=parametroinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
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
		parametroinvens = new  ArrayList<ParametroInven>();
		  		  
        try {
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametroinvens = new  ArrayList<ParametroInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getTodosParametroInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
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
	
	public  void  getTodosParametroInvens(String sFinalQuery,Pagination pagination)throws Exception {
		parametroinvens = new  ArrayList<ParametroInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinvens=parametroinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroInven(parametroinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroInven(ParametroInven parametroinven) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroinven.getIsNew() || parametroinven.getIsChanged()) { 
			this.invalidValues = parametroinvenValidator.getInvalidValues(parametroinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroInven(List<ParametroInven> ParametroInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroInven parametroinvenLocal:parametroinvens) {				
			estaValidadoObjeto=this.validarGuardarParametroInven(parametroinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroInven(List<ParametroInven> ParametroInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroInven(parametroinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroInven(ParametroInven ParametroInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroInven(parametroinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroInven parametroinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroInvenConstantesFunciones.getParametroInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-saveParametroInvenWithConnection");connexion.begin();			
			
			ParametroInvenLogicAdditional.checkParametroInvenToSave(this.parametroinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroInvenLogicAdditional.updateParametroInvenToSave(this.parametroinven,this.arrDatoGeneral);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroInven(this.parametroinven)) {
				ParametroInvenDataAccess.save(this.parametroinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroInvenLogicAdditional.checkParametroInvenToSaveAfter(this.parametroinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroInven();
			
			connexion.commit();			
			
			if(this.parametroinven.getIsDeleted()) {
				this.parametroinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroInven()throws Exception {	
		try {	
			
			ParametroInvenLogicAdditional.checkParametroInvenToSave(this.parametroinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroInvenLogicAdditional.updateParametroInvenToSave(this.parametroinven,this.arrDatoGeneral);
			
			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroInven(this.parametroinven)) {			
				ParametroInvenDataAccess.save(this.parametroinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroInvenLogicAdditional.checkParametroInvenToSaveAfter(this.parametroinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroinven.getIsDeleted()) {
				this.parametroinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-saveParametroInvensWithConnection");connexion.begin();			
			
			ParametroInvenLogicAdditional.checkParametroInvenToSaves(parametroinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroInvens();
			
			Boolean validadoTodosParametroInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroInven parametroinvenLocal:parametroinvens) {		
				if(parametroinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroInvenLogicAdditional.updateParametroInvenToSave(parametroinvenLocal,this.arrDatoGeneral);
	        	
				ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroInven(parametroinvenLocal)) {
					ParametroInvenDataAccess.save(parametroinvenLocal, connexion);				
				} else {
					validadoTodosParametroInven=false;
				}
			}
			
			if(!validadoTodosParametroInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroInvenLogicAdditional.checkParametroInvenToSavesAfter(parametroinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroInvens();
			
			connexion.commit();		
			
			this.quitarParametroInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroInvens()throws Exception {				
		 try {	
			ParametroInvenLogicAdditional.checkParametroInvenToSaves(parametroinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroInven parametroinvenLocal:parametroinvens) {				
				if(parametroinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroInvenLogicAdditional.updateParametroInvenToSave(parametroinvenLocal,this.arrDatoGeneral);
	        	
				ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroInven(parametroinvenLocal)) {				
					ParametroInvenDataAccess.save(parametroinvenLocal, connexion);				
				} else {
					validadoTodosParametroInven=false;
				}
			}
			
			if(!validadoTodosParametroInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroInvenLogicAdditional.checkParametroInvenToSavesAfter(parametroinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroInvenParameterReturnGeneral procesarAccionParametroInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroInven> parametroinvens,ParametroInvenParameterReturnGeneral parametroinvenParameterGeneral)throws Exception {
		 try {	
			ParametroInvenParameterReturnGeneral parametroinvenReturnGeneral=new ParametroInvenParameterReturnGeneral();
	
			ParametroInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroinvens,parametroinvenParameterGeneral,parametroinvenReturnGeneral);
			
			return parametroinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroInvenParameterReturnGeneral procesarAccionParametroInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroInven> parametroinvens,ParametroInvenParameterReturnGeneral parametroinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-procesarAccionParametroInvensWithConnection");connexion.begin();			
			
			ParametroInvenParameterReturnGeneral parametroinvenReturnGeneral=new ParametroInvenParameterReturnGeneral();
	
			ParametroInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroinvens,parametroinvenParameterGeneral,parametroinvenReturnGeneral);
			
			this.connexion.commit();
			
			return parametroinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroInvenParameterReturnGeneral procesarEventosParametroInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroInven> parametroinvens,ParametroInven parametroinven,ParametroInvenParameterReturnGeneral parametroinvenParameterGeneral,Boolean isEsNuevoParametroInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroInvenParameterReturnGeneral parametroinvenReturnGeneral=new ParametroInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroinvens,parametroinven,parametroinvenParameterGeneral,parametroinvenReturnGeneral,isEsNuevoParametroInven,clases);
			
			return parametroinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroInvenParameterReturnGeneral procesarEventosParametroInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroInven> parametroinvens,ParametroInven parametroinven,ParametroInvenParameterReturnGeneral parametroinvenParameterGeneral,Boolean isEsNuevoParametroInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-procesarEventosParametroInvensWithConnection");connexion.begin();			
			
			ParametroInvenParameterReturnGeneral parametroinvenReturnGeneral=new ParametroInvenParameterReturnGeneral();
	
			parametroinvenReturnGeneral.setParametroInven(parametroinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroinvens,parametroinven,parametroinvenParameterGeneral,parametroinvenReturnGeneral,isEsNuevoParametroInven,clases);
			
			this.connexion.commit();
			
			return parametroinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroInvenParameterReturnGeneral procesarImportacionParametroInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroInvenParameterReturnGeneral parametroinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-procesarImportacionParametroInvensWithConnection");connexion.begin();			
			
			ParametroInvenParameterReturnGeneral parametroinvenReturnGeneral=new ParametroInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametroinvens=new ArrayList<ParametroInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroinven=new ParametroInven();
				
				
				if(conColumnasBase) {this.parametroinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametroinven.setsecuencial_pedido(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroinven.setnumero_serie(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroinven.setnumero_decimales(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroinven.setnumero_items_requisicion(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroinven.setcon_cuenta_contable(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroinven.setcon_cuenta_contable_linea(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroinven.setcon_cuenta_banco(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroinven.setcon_copiar_producto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroinven.setcon_crear_producto_sucursal(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroinven.setcon_crear_lista_precio_sucursal_bodega(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroinven.setcon_compras_aprobacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroinven.setcon_envio_mail(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametroinvens.add(this.parametroinven);
			}
			
			this.saveParametroInvens();
			
			this.connexion.commit();
			
			parametroinvenReturnGeneral.setConRetornoEstaProcesado(true);
			parametroinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametroinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroInvensEliminados() throws Exception {				
		
		List<ParametroInven> parametroinvensAux= new ArrayList<ParametroInven>();
		
		for(ParametroInven parametroinven:parametroinvens) {
			if(!parametroinven.getIsDeleted()) {
				parametroinvensAux.add(parametroinven);
			}
		}
		
		parametroinvens=parametroinvensAux;
	}
	
	public void quitarParametroInvensNulos() throws Exception {				
		
		List<ParametroInven> parametroinvensAux= new ArrayList<ParametroInven>();
		
		for(ParametroInven parametroinven : this.parametroinvens) {
			if(parametroinven==null) {
				parametroinvensAux.add(parametroinven);
			}
		}
		
		//this.parametroinvens=parametroinvensAux;
		
		this.parametroinvens.removeAll(parametroinvensAux);
	}
	
	public void getSetVersionRowParametroInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroinven.getIsDeleted() || (parametroinven.getIsChanged()&&!parametroinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametroinvenDataAccess.getSetVersionRowParametroInven(connexion,parametroinven.getId());
				
				if(!parametroinven.getVersionRow().equals(timestamp)) {	
					parametroinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroInven()throws Exception {	
		
		if(parametroinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroinven.getIsDeleted() || (parametroinven.getIsChanged()&&!parametroinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametroinvenDataAccess.getSetVersionRowParametroInven(connexion,parametroinven.getId());
			
			try {							
				if(!parametroinven.getVersionRow().equals(timestamp)) {	
					parametroinven.setVersionRow(timestamp);
				}
				
				parametroinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroInvensWithConnection()throws Exception {	
		if(parametroinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroInven parametroinvenAux:parametroinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametroinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroinvenAux.getIsDeleted() || (parametroinvenAux.getIsChanged()&&!parametroinvenAux.getIsNew())) {
						
						timestamp=parametroinvenDataAccess.getSetVersionRowParametroInven(connexion,parametroinvenAux.getId());
						
						if(!parametroinven.getVersionRow().equals(timestamp)) {	
							parametroinvenAux.setVersionRow(timestamp);
						}
								
						parametroinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroInvens()throws Exception {	
		if(parametroinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroInven parametroinvenAux:parametroinvens) {
					if(parametroinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroinvenAux.getIsDeleted() || (parametroinvenAux.getIsChanged()&&!parametroinvenAux.getIsNew())) {
						
						timestamp=parametroinvenDataAccess.getSetVersionRowParametroInven(connexion,parametroinvenAux.getId());
						
						if(!parametroinvenAux.getVersionRow().equals(timestamp)) {	
							parametroinvenAux.setVersionRow(timestamp);
						}
						
													
						parametroinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroInvenParameterReturnGeneral cargarCombosLoteForeignKeyParametroInvenWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		ParametroInvenParameterReturnGeneral  parametroinvenReturnGeneral =new ParametroInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroInvenWithConnection");connexion.begin();
			
			parametroinvenReturnGeneral =new ParametroInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametroinvenReturnGeneral;
	}
	
	public ParametroInvenParameterReturnGeneral cargarCombosLoteForeignKeyParametroInven(String finalQueryGlobalEmpresa) throws Exception {
		ParametroInvenParameterReturnGeneral  parametroinvenReturnGeneral =new ParametroInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametroinvenReturnGeneral =new ParametroInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametroinvenReturnGeneral;
	}
	
	
	public void deepLoad(ParametroInven parametroinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroInvenLogicAdditional.updateParametroInvenToGet(parametroinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroinven.setEmpresa(parametroinvenDataAccess.getEmpresa(connexion,parametroinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroinven.setEmpresa(parametroinvenDataAccess.getEmpresa(connexion,parametroinven));
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
			parametroinven.setEmpresa(parametroinvenDataAccess.getEmpresa(connexion,parametroinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroinven.setEmpresa(parametroinvenDataAccess.getEmpresa(connexion,parametroinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroinven.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroinven.setEmpresa(parametroinvenDataAccess.getEmpresa(connexion,parametroinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroinven.getEmpresa(),isDeep,deepLoadType,clases);				
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
			parametroinven.setEmpresa(parametroinvenDataAccess.getEmpresa(connexion,parametroinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroInven parametroinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroInvenLogicAdditional.updateParametroInvenToSave(parametroinven,this.arrDatoGeneral);
			
ParametroInvenDataAccess.save(parametroinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroinven.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroinven.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroinven.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametroinven.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(parametroinven);
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
			this.deepLoad(this.parametroinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametroinvens!=null) {
				for(ParametroInven parametroinven:parametroinvens) {
					this.deepLoad(parametroinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(parametroinvens);
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
			if(parametroinvens!=null) {
				for(ParametroInven parametroinven:parametroinvens) {
					this.deepLoad(parametroinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(parametroinvens);
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
			this.getNewConnexionToDeep(ParametroInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametroinven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametroinvens!=null) {
				for(ParametroInven parametroinven:parametroinvens) {
					this.deepSave(parametroinven,isDeep,deepLoadType,clases);
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
			if(parametroinvens!=null) {
				for(ParametroInven parametroinven:parametroinvens) {
					this.deepSave(parametroinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinvens=parametroinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinvens=parametroinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInvenConstantesFunciones.refrescarForeignKeysDescripcionesParametroInven(this.parametroinvens);
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
			if(ParametroInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroInven parametroinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroInvenConstantesFunciones.ISCONAUDITORIA) {
				if(parametroinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInvenDataAccess.TABLENAME, parametroinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroInvenLogic.registrarAuditoriaDetallesParametroInven(connexion,parametroinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroinven.getIsDeleted()) {
					/*if(!parametroinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroInvenDataAccess.TABLENAME, parametroinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroInvenLogic.registrarAuditoriaDetallesParametroInven(connexion,parametroinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInvenDataAccess.TABLENAME, parametroinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInvenDataAccess.TABLENAME, parametroinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroInvenLogic.registrarAuditoriaDetallesParametroInven(connexion,parametroinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroInven(Connexion connexion,ParametroInven parametroinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroinven.getIsNew()||!parametroinven.getid_empresa().equals(parametroinven.getParametroInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getid_empresa().toString();
				}
				if(parametroinven.getid_empresa()!=null)
				{
					strValorNuevo=parametroinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getsecuencial_pedido().equals(parametroinven.getParametroInvenOriginal().getsecuencial_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getsecuencial_pedido()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getsecuencial_pedido().toString();
				}
				if(parametroinven.getsecuencial_pedido()!=null)
				{
					strValorNuevo=parametroinven.getsecuencial_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.SECUENCIALPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getnumero_serie().equals(parametroinven.getParametroInvenOriginal().getnumero_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getnumero_serie()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getnumero_serie().toString();
				}
				if(parametroinven.getnumero_serie()!=null)
				{
					strValorNuevo=parametroinven.getnumero_serie().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.NUMEROSERIE,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getnumero_decimales().equals(parametroinven.getParametroInvenOriginal().getnumero_decimales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getnumero_decimales()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getnumero_decimales().toString();
				}
				if(parametroinven.getnumero_decimales()!=null)
				{
					strValorNuevo=parametroinven.getnumero_decimales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.NUMERODECIMALES,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getnumero_items_requisicion().equals(parametroinven.getParametroInvenOriginal().getnumero_items_requisicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getnumero_items_requisicion()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getnumero_items_requisicion().toString();
				}
				if(parametroinven.getnumero_items_requisicion()!=null)
				{
					strValorNuevo=parametroinven.getnumero_items_requisicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_cuenta_contable().equals(parametroinven.getParametroInvenOriginal().getcon_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_cuenta_contable()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_cuenta_contable().toString();
				}
				if(parametroinven.getcon_cuenta_contable()!=null)
				{
					strValorNuevo=parametroinven.getcon_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_cuenta_contable_linea().equals(parametroinven.getParametroInvenOriginal().getcon_cuenta_contable_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_cuenta_contable_linea()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_cuenta_contable_linea().toString();
				}
				if(parametroinven.getcon_cuenta_contable_linea()!=null)
				{
					strValorNuevo=parametroinven.getcon_cuenta_contable_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_cuenta_banco().equals(parametroinven.getParametroInvenOriginal().getcon_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_cuenta_banco()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_cuenta_banco().toString();
				}
				if(parametroinven.getcon_cuenta_banco()!=null)
				{
					strValorNuevo=parametroinven.getcon_cuenta_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_copiar_producto().equals(parametroinven.getParametroInvenOriginal().getcon_copiar_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_copiar_producto()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_copiar_producto().toString();
				}
				if(parametroinven.getcon_copiar_producto()!=null)
				{
					strValorNuevo=parametroinven.getcon_copiar_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_crear_producto_sucursal().equals(parametroinven.getParametroInvenOriginal().getcon_crear_producto_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_crear_producto_sucursal()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_crear_producto_sucursal().toString();
				}
				if(parametroinven.getcon_crear_producto_sucursal()!=null)
				{
					strValorNuevo=parametroinven.getcon_crear_producto_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_crear_lista_precio_sucursal_bodega().equals(parametroinven.getParametroInvenOriginal().getcon_crear_lista_precio_sucursal_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_crear_lista_precio_sucursal_bodega()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_crear_lista_precio_sucursal_bodega().toString();
				}
				if(parametroinven.getcon_crear_lista_precio_sucursal_bodega()!=null)
				{
					strValorNuevo=parametroinven.getcon_crear_lista_precio_sucursal_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_compras_aprobacion().equals(parametroinven.getParametroInvenOriginal().getcon_compras_aprobacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_compras_aprobacion()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_compras_aprobacion().toString();
				}
				if(parametroinven.getcon_compras_aprobacion()!=null)
				{
					strValorNuevo=parametroinven.getcon_compras_aprobacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION,strValorActual,strValorNuevo);
			}	
			
			if(parametroinven.getIsNew()||!parametroinven.getcon_envio_mail().equals(parametroinven.getParametroInvenOriginal().getcon_envio_mail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinven.getParametroInvenOriginal().getcon_envio_mail()!=null)
				{
					strValorActual=parametroinven.getParametroInvenOriginal().getcon_envio_mail().toString();
				}
				if(parametroinven.getcon_envio_mail()!=null)
				{
					strValorNuevo=parametroinven.getcon_envio_mail().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInvenConstantesFunciones.CONENVIOMAIL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroInvenRelacionesWithConnection(ParametroInven parametroinven) throws Exception {

		if(!parametroinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroInvenRelacionesBase(parametroinven,true);
		}
	}

	public void saveParametroInvenRelaciones(ParametroInven parametroinven)throws Exception {

		if(!parametroinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroInvenRelacionesBase(parametroinven,false);
		}
	}

	public void saveParametroInvenRelacionesBase(ParametroInven parametroinven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroInven-saveRelacionesWithConnection");}
	

			this.setParametroInven(parametroinven);

			if(ParametroInvenLogicAdditional.validarSaveRelaciones(parametroinven,this)) {

				ParametroInvenLogicAdditional.updateRelacionesToSave(parametroinven,this);

				if((parametroinven.getIsNew()||parametroinven.getIsChanged())&&!parametroinven.getIsDeleted()) {
					this.saveParametroInven();
					this.saveParametroInvenRelacionesDetalles();

				} else if(parametroinven.getIsDeleted()) {
					this.saveParametroInvenRelacionesDetalles();
					this.saveParametroInven();
				}

				ParametroInvenLogicAdditional.updateRelacionesToSaveAfter(parametroinven,this);

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
	
	
	private void saveParametroInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroInvenConstantesFunciones.getClassesForeignKeysOfParametroInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroInvenConstantesFunciones.getClassesRelationshipsOfParametroInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
