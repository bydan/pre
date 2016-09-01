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
import com.bydan.erp.inventario.util.DetalleMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleMensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleMensajeCorreoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleMensajeCorreoInven;
import com.bydan.erp.inventario.business.logic.DetalleMensajeCorreoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleMensajeCorreoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleMensajeCorreoInvenLogic.class);
	
	protected DetalleMensajeCorreoInvenDataAccess detallemensajecorreoinvenDataAccess; 	
	protected DetalleMensajeCorreoInven detallemensajecorreoinven;
	protected List<DetalleMensajeCorreoInven> detallemensajecorreoinvens;
	protected Object detallemensajecorreoinvenObject;	
	protected List<Object> detallemensajecorreoinvensObject;
	
	public static ClassValidator<DetalleMensajeCorreoInven> detallemensajecorreoinvenValidator = new ClassValidator<DetalleMensajeCorreoInven>(DetalleMensajeCorreoInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleMensajeCorreoInvenLogicAdditional detallemensajecorreoinvenLogicAdditional=null;
	
	public DetalleMensajeCorreoInvenLogicAdditional getDetalleMensajeCorreoInvenLogicAdditional() {
		return this.detallemensajecorreoinvenLogicAdditional;
	}
	
	public void setDetalleMensajeCorreoInvenLogicAdditional(DetalleMensajeCorreoInvenLogicAdditional detallemensajecorreoinvenLogicAdditional) {
		try {
			this.detallemensajecorreoinvenLogicAdditional=detallemensajecorreoinvenLogicAdditional;
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
	
	
	
	
	public  DetalleMensajeCorreoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallemensajecorreoinvenDataAccess = new DetalleMensajeCorreoInvenDataAccess();
			
			this.detallemensajecorreoinvens= new ArrayList<DetalleMensajeCorreoInven>();
			this.detallemensajecorreoinven= new DetalleMensajeCorreoInven();
			
			this.detallemensajecorreoinvenObject=new Object();
			this.detallemensajecorreoinvensObject=new ArrayList<Object>();
				
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
			
			this.detallemensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.detallemensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleMensajeCorreoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallemensajecorreoinvenDataAccess = new DetalleMensajeCorreoInvenDataAccess();
			this.detallemensajecorreoinvens= new ArrayList<DetalleMensajeCorreoInven>();
			this.detallemensajecorreoinven= new DetalleMensajeCorreoInven();
			this.detallemensajecorreoinvenObject=new Object();
			this.detallemensajecorreoinvensObject=new ArrayList<Object>();
			
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
			
			this.detallemensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.detallemensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleMensajeCorreoInven getDetalleMensajeCorreoInven() throws Exception {	
		DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToGet(detallemensajecorreoinven,this.datosCliente,this.arrDatoGeneral);
		DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToGet(detallemensajecorreoinven,this.arrDatoGeneral);
		
		return detallemensajecorreoinven;
	}
		
	public void setDetalleMensajeCorreoInven(DetalleMensajeCorreoInven newDetalleMensajeCorreoInven) {
		this.detallemensajecorreoinven = newDetalleMensajeCorreoInven;
	}
	
	public DetalleMensajeCorreoInvenDataAccess getDetalleMensajeCorreoInvenDataAccess() {
		return detallemensajecorreoinvenDataAccess;
	}
	
	public void setDetalleMensajeCorreoInvenDataAccess(DetalleMensajeCorreoInvenDataAccess newdetallemensajecorreoinvenDataAccess) {
		this.detallemensajecorreoinvenDataAccess = newdetallemensajecorreoinvenDataAccess;
	}
	
	public List<DetalleMensajeCorreoInven> getDetalleMensajeCorreoInvens() throws Exception {		
		this.quitarDetalleMensajeCorreoInvensNulos();
		
		DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToGets(detallemensajecorreoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleMensajeCorreoInven detallemensajecorreoinvenLocal: detallemensajecorreoinvens ) {
			DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToGet(detallemensajecorreoinvenLocal,this.arrDatoGeneral);
		}
		
		return detallemensajecorreoinvens;
	}
	
	public void setDetalleMensajeCorreoInvens(List<DetalleMensajeCorreoInven> newDetalleMensajeCorreoInvens) {
		this.detallemensajecorreoinvens = newDetalleMensajeCorreoInvens;
	}
	
	public Object getDetalleMensajeCorreoInvenObject() {	
		this.detallemensajecorreoinvenObject=this.detallemensajecorreoinvenDataAccess.getEntityObject();
		return this.detallemensajecorreoinvenObject;
	}
		
	public void setDetalleMensajeCorreoInvenObject(Object newDetalleMensajeCorreoInvenObject) {
		this.detallemensajecorreoinvenObject = newDetalleMensajeCorreoInvenObject;
	}
	
	public List<Object> getDetalleMensajeCorreoInvensObject() {		
		this.detallemensajecorreoinvensObject=this.detallemensajecorreoinvenDataAccess.getEntitiesObject();
		return this.detallemensajecorreoinvensObject;
	}
		
	public void setDetalleMensajeCorreoInvensObject(List<Object> newDetalleMensajeCorreoInvensObject) {
		this.detallemensajecorreoinvensObject = newDetalleMensajeCorreoInvensObject;
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
		
		if(this.detallemensajecorreoinvenDataAccess!=null) {
			this.detallemensajecorreoinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallemensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallemensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallemensajecorreoinven=detallemensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinven);
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  		  
        try {
			
			detallemensajecorreoinven=detallemensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallemensajecorreoinven=detallemensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinven);
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  		  
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  		  
        try {
			
			detallemensajecorreoinven=detallemensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallemensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  		  
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallemensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallemensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallemensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallemensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallemensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallemensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
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
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
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
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
        try {			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
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
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
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
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
        try {
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
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
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
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
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinven=detallemensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinven);
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
		detallemensajecorreoinven = new  DetalleMensajeCorreoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinven=detallemensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
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
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		  		  
        try {
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleMensajeCorreoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getTodosDetalleMensajeCorreoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
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
	
	public  void  getTodosDetalleMensajeCorreoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		detallemensajecorreoinvens = new  ArrayList<DetalleMensajeCorreoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleMensajeCorreoInven(detallemensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(detallemensajecorreoinven.getIsNew() || detallemensajecorreoinven.getIsChanged()) { 
			this.invalidValues = detallemensajecorreoinvenValidator.getInvalidValues(detallemensajecorreoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallemensajecorreoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleMensajeCorreoInven(List<DetalleMensajeCorreoInven> DetalleMensajeCorreoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinvenLocal:detallemensajecorreoinvens) {				
			estaValidadoObjeto=this.validarGuardarDetalleMensajeCorreoInven(detallemensajecorreoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleMensajeCorreoInven(List<DetalleMensajeCorreoInven> DetalleMensajeCorreoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleMensajeCorreoInven(detallemensajecorreoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleMensajeCorreoInven(DetalleMensajeCorreoInven DetalleMensajeCorreoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleMensajeCorreoInven(detallemensajecorreoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallemensajecorreoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleMensajeCorreoInvenConstantesFunciones.getDetalleMensajeCorreoInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallemensajecorreoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleMensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleMensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleMensajeCorreoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-saveDetalleMensajeCorreoInvenWithConnection");connexion.begin();			
			
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSave(this.detallemensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToSave(this.detallemensajecorreoinven,this.arrDatoGeneral);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallemensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleMensajeCorreoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleMensajeCorreoInven(this.detallemensajecorreoinven)) {
				DetalleMensajeCorreoInvenDataAccess.save(this.detallemensajecorreoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallemensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSaveAfter(this.detallemensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleMensajeCorreoInven();
			
			connexion.commit();			
			
			if(this.detallemensajecorreoinven.getIsDeleted()) {
				this.detallemensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleMensajeCorreoInven()throws Exception {	
		try {	
			
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSave(this.detallemensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToSave(this.detallemensajecorreoinven,this.arrDatoGeneral);
			
			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallemensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleMensajeCorreoInven(this.detallemensajecorreoinven)) {			
				DetalleMensajeCorreoInvenDataAccess.save(this.detallemensajecorreoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallemensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSaveAfter(this.detallemensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallemensajecorreoinven.getIsDeleted()) {
				this.detallemensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleMensajeCorreoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-saveDetalleMensajeCorreoInvensWithConnection");connexion.begin();			
			
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSaves(detallemensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleMensajeCorreoInvens();
			
			Boolean validadoTodosDetalleMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleMensajeCorreoInven detallemensajecorreoinvenLocal:detallemensajecorreoinvens) {		
				if(detallemensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToSave(detallemensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallemensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleMensajeCorreoInven(detallemensajecorreoinvenLocal)) {
					DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosDetalleMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosDetalleMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSavesAfter(detallemensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleMensajeCorreoInvens();
			
			connexion.commit();		
			
			this.quitarDetalleMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleMensajeCorreoInvens()throws Exception {				
		 try {	
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSaves(detallemensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleMensajeCorreoInven detallemensajecorreoinvenLocal:detallemensajecorreoinvens) {				
				if(detallemensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToSave(detallemensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallemensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleMensajeCorreoInven(detallemensajecorreoinvenLocal)) {				
					DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosDetalleMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosDetalleMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleMensajeCorreoInvenLogicAdditional.checkDetalleMensajeCorreoInvenToSavesAfter(detallemensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleMensajeCorreoInvenParameterReturnGeneral procesarAccionDetalleMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenParameterGeneral)throws Exception {
		 try {	
			DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenReturnGeneral=new DetalleMensajeCorreoInvenParameterReturnGeneral();
	
			DetalleMensajeCorreoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallemensajecorreoinvens,detallemensajecorreoinvenParameterGeneral,detallemensajecorreoinvenReturnGeneral);
			
			return detallemensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleMensajeCorreoInvenParameterReturnGeneral procesarAccionDetalleMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-procesarAccionDetalleMensajeCorreoInvensWithConnection");connexion.begin();			
			
			DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenReturnGeneral=new DetalleMensajeCorreoInvenParameterReturnGeneral();
	
			DetalleMensajeCorreoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallemensajecorreoinvens,detallemensajecorreoinvenParameterGeneral,detallemensajecorreoinvenReturnGeneral);
			
			this.connexion.commit();
			
			return detallemensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleMensajeCorreoInvenParameterReturnGeneral procesarEventosDetalleMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,DetalleMensajeCorreoInven detallemensajecorreoinven,DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenParameterGeneral,Boolean isEsNuevoDetalleMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenReturnGeneral=new DetalleMensajeCorreoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallemensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleMensajeCorreoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallemensajecorreoinvens,detallemensajecorreoinven,detallemensajecorreoinvenParameterGeneral,detallemensajecorreoinvenReturnGeneral,isEsNuevoDetalleMensajeCorreoInven,clases);
			
			return detallemensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleMensajeCorreoInvenParameterReturnGeneral procesarEventosDetalleMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,DetalleMensajeCorreoInven detallemensajecorreoinven,DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenParameterGeneral,Boolean isEsNuevoDetalleMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-procesarEventosDetalleMensajeCorreoInvensWithConnection");connexion.begin();			
			
			DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenReturnGeneral=new DetalleMensajeCorreoInvenParameterReturnGeneral();
	
			detallemensajecorreoinvenReturnGeneral.setDetalleMensajeCorreoInven(detallemensajecorreoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallemensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleMensajeCorreoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallemensajecorreoinvens,detallemensajecorreoinven,detallemensajecorreoinvenParameterGeneral,detallemensajecorreoinvenReturnGeneral,isEsNuevoDetalleMensajeCorreoInven,clases);
			
			this.connexion.commit();
			
			return detallemensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleMensajeCorreoInvenParameterReturnGeneral procesarImportacionDetalleMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-procesarImportacionDetalleMensajeCorreoInvensWithConnection");connexion.begin();			
			
			DetalleMensajeCorreoInvenParameterReturnGeneral detallemensajecorreoinvenReturnGeneral=new DetalleMensajeCorreoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallemensajecorreoinvens=new ArrayList<DetalleMensajeCorreoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallemensajecorreoinven=new DetalleMensajeCorreoInven();
				
				
				if(conColumnasBase) {this.detallemensajecorreoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallemensajecorreoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallemensajecorreoinven.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.detallemensajecorreoinvens.add(this.detallemensajecorreoinven);
			}
			
			this.saveDetalleMensajeCorreoInvens();
			
			this.connexion.commit();
			
			detallemensajecorreoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			detallemensajecorreoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallemensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleMensajeCorreoInvensEliminados() throws Exception {				
		
		List<DetalleMensajeCorreoInven> detallemensajecorreoinvensAux= new ArrayList<DetalleMensajeCorreoInven>();
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens) {
			if(!detallemensajecorreoinven.getIsDeleted()) {
				detallemensajecorreoinvensAux.add(detallemensajecorreoinven);
			}
		}
		
		detallemensajecorreoinvens=detallemensajecorreoinvensAux;
	}
	
	public void quitarDetalleMensajeCorreoInvensNulos() throws Exception {				
		
		List<DetalleMensajeCorreoInven> detallemensajecorreoinvensAux= new ArrayList<DetalleMensajeCorreoInven>();
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven : this.detallemensajecorreoinvens) {
			if(detallemensajecorreoinven==null) {
				detallemensajecorreoinvensAux.add(detallemensajecorreoinven);
			}
		}
		
		//this.detallemensajecorreoinvens=detallemensajecorreoinvensAux;
		
		this.detallemensajecorreoinvens.removeAll(detallemensajecorreoinvensAux);
	}
	
	public void getSetVersionRowDetalleMensajeCorreoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallemensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallemensajecorreoinven.getIsDeleted() || (detallemensajecorreoinven.getIsChanged()&&!detallemensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallemensajecorreoinvenDataAccess.getSetVersionRowDetalleMensajeCorreoInven(connexion,detallemensajecorreoinven.getId());
				
				if(!detallemensajecorreoinven.getVersionRow().equals(timestamp)) {	
					detallemensajecorreoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallemensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleMensajeCorreoInven()throws Exception {	
		
		if(detallemensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallemensajecorreoinven.getIsDeleted() || (detallemensajecorreoinven.getIsChanged()&&!detallemensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallemensajecorreoinvenDataAccess.getSetVersionRowDetalleMensajeCorreoInven(connexion,detallemensajecorreoinven.getId());
			
			try {							
				if(!detallemensajecorreoinven.getVersionRow().equals(timestamp)) {	
					detallemensajecorreoinven.setVersionRow(timestamp);
				}
				
				detallemensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleMensajeCorreoInvensWithConnection()throws Exception {	
		if(detallemensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleMensajeCorreoInven detallemensajecorreoinvenAux:detallemensajecorreoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallemensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallemensajecorreoinvenAux.getIsDeleted() || (detallemensajecorreoinvenAux.getIsChanged()&&!detallemensajecorreoinvenAux.getIsNew())) {
						
						timestamp=detallemensajecorreoinvenDataAccess.getSetVersionRowDetalleMensajeCorreoInven(connexion,detallemensajecorreoinvenAux.getId());
						
						if(!detallemensajecorreoinven.getVersionRow().equals(timestamp)) {	
							detallemensajecorreoinvenAux.setVersionRow(timestamp);
						}
								
						detallemensajecorreoinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleMensajeCorreoInvens()throws Exception {	
		if(detallemensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleMensajeCorreoInven detallemensajecorreoinvenAux:detallemensajecorreoinvens) {
					if(detallemensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallemensajecorreoinvenAux.getIsDeleted() || (detallemensajecorreoinvenAux.getIsChanged()&&!detallemensajecorreoinvenAux.getIsNew())) {
						
						timestamp=detallemensajecorreoinvenDataAccess.getSetVersionRowDetalleMensajeCorreoInven(connexion,detallemensajecorreoinvenAux.getId());
						
						if(!detallemensajecorreoinvenAux.getVersionRow().equals(timestamp)) {	
							detallemensajecorreoinvenAux.setVersionRow(timestamp);
						}
						
													
						detallemensajecorreoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleMensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyDetalleMensajeCorreoInvenWithConnection(String finalQueryGlobalMensajeCorreoInven,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalUsuario,String finalQueryGlobalEmpleado) throws Exception {
		DetalleMensajeCorreoInvenParameterReturnGeneral  detallemensajecorreoinvenReturnGeneral =new DetalleMensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleMensajeCorreoInvenWithConnection");connexion.begin();
			
			detallemensajecorreoinvenReturnGeneral =new DetalleMensajeCorreoInvenParameterReturnGeneral();
			
			

			List<MensajeCorreoInven> mensajecorreoinvensForeignKey=new ArrayList<MensajeCorreoInven>();
			MensajeCorreoInvenLogic mensajecorreoinvenLogic=new MensajeCorreoInvenLogic();
			mensajecorreoinvenLogic.setConnexion(this.connexion);
			mensajecorreoinvenLogic.getMensajeCorreoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMensajeCorreoInven.equals("NONE")) {
				mensajecorreoinvenLogic.getTodosMensajeCorreoInvens(finalQueryGlobalMensajeCorreoInven,new Pagination());
				mensajecorreoinvensForeignKey=mensajecorreoinvenLogic.getMensajeCorreoInvens();
			}

			detallemensajecorreoinvenReturnGeneral.setmensajecorreoinvensForeignKey(mensajecorreoinvensForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallemensajecorreoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallemensajecorreoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detallemensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			detallemensajecorreoinvenReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			detallemensajecorreoinvenReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallemensajecorreoinvenReturnGeneral;
	}
	
	public DetalleMensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyDetalleMensajeCorreoInven(String finalQueryGlobalMensajeCorreoInven,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalUsuario,String finalQueryGlobalEmpleado) throws Exception {
		DetalleMensajeCorreoInvenParameterReturnGeneral  detallemensajecorreoinvenReturnGeneral =new DetalleMensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallemensajecorreoinvenReturnGeneral =new DetalleMensajeCorreoInvenParameterReturnGeneral();
			
			

			List<MensajeCorreoInven> mensajecorreoinvensForeignKey=new ArrayList<MensajeCorreoInven>();
			MensajeCorreoInvenLogic mensajecorreoinvenLogic=new MensajeCorreoInvenLogic();
			mensajecorreoinvenLogic.setConnexion(this.connexion);
			mensajecorreoinvenLogic.getMensajeCorreoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMensajeCorreoInven.equals("NONE")) {
				mensajecorreoinvenLogic.getTodosMensajeCorreoInvens(finalQueryGlobalMensajeCorreoInven,new Pagination());
				mensajecorreoinvensForeignKey=mensajecorreoinvenLogic.getMensajeCorreoInvens();
			}

			detallemensajecorreoinvenReturnGeneral.setmensajecorreoinvensForeignKey(mensajecorreoinvensForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallemensajecorreoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallemensajecorreoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detallemensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			detallemensajecorreoinvenReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			detallemensajecorreoinvenReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallemensajecorreoinvenReturnGeneral;
	}
	
	
	public void deepLoad(DetalleMensajeCorreoInven detallemensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToGet(detallemensajecorreoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallemensajecorreoinven.setMensajeCorreoInven(detallemensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,detallemensajecorreoinven));
		detallemensajecorreoinven.setEmpresa(detallemensajecorreoinvenDataAccess.getEmpresa(connexion,detallemensajecorreoinven));
		detallemensajecorreoinven.setSucursal(detallemensajecorreoinvenDataAccess.getSucursal(connexion,detallemensajecorreoinven));
		detallemensajecorreoinven.setModulo(detallemensajecorreoinvenDataAccess.getModulo(connexion,detallemensajecorreoinven));
		detallemensajecorreoinven.setUsuario(detallemensajecorreoinvenDataAccess.getUsuario(connexion,detallemensajecorreoinven));
		detallemensajecorreoinven.setEmpleado(detallemensajecorreoinvenDataAccess.getEmpleado(connexion,detallemensajecorreoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				detallemensajecorreoinven.setMensajeCorreoInven(detallemensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,detallemensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallemensajecorreoinven.setEmpresa(detallemensajecorreoinvenDataAccess.getEmpresa(connexion,detallemensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemensajecorreoinven.setSucursal(detallemensajecorreoinvenDataAccess.getSucursal(connexion,detallemensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detallemensajecorreoinven.setModulo(detallemensajecorreoinvenDataAccess.getModulo(connexion,detallemensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				detallemensajecorreoinven.setUsuario(detallemensajecorreoinvenDataAccess.getUsuario(connexion,detallemensajecorreoinven));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				detallemensajecorreoinven.setEmpleado(detallemensajecorreoinvenDataAccess.getEmpleado(connexion,detallemensajecorreoinven));
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
			detallemensajecorreoinven.setMensajeCorreoInven(detallemensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,detallemensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setEmpresa(detallemensajecorreoinvenDataAccess.getEmpresa(connexion,detallemensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setSucursal(detallemensajecorreoinvenDataAccess.getSucursal(connexion,detallemensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setModulo(detallemensajecorreoinvenDataAccess.getModulo(connexion,detallemensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setUsuario(detallemensajecorreoinvenDataAccess.getUsuario(connexion,detallemensajecorreoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setEmpleado(detallemensajecorreoinvenDataAccess.getEmpleado(connexion,detallemensajecorreoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallemensajecorreoinven.setMensajeCorreoInven(detallemensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,detallemensajecorreoinven));
		MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
		mensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);
				
		detallemensajecorreoinven.setEmpresa(detallemensajecorreoinvenDataAccess.getEmpresa(connexion,detallemensajecorreoinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallemensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallemensajecorreoinven.setSucursal(detallemensajecorreoinvenDataAccess.getSucursal(connexion,detallemensajecorreoinven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallemensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		detallemensajecorreoinven.setModulo(detallemensajecorreoinvenDataAccess.getModulo(connexion,detallemensajecorreoinven));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detallemensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
		detallemensajecorreoinven.setUsuario(detallemensajecorreoinvenDataAccess.getUsuario(connexion,detallemensajecorreoinven));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(detallemensajecorreoinven.getUsuario(),isDeep,deepLoadType,clases);
				
		detallemensajecorreoinven.setEmpleado(detallemensajecorreoinvenDataAccess.getEmpleado(connexion,detallemensajecorreoinven));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(detallemensajecorreoinven.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				detallemensajecorreoinven.setMensajeCorreoInven(detallemensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,detallemensajecorreoinven));
				MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
				mensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallemensajecorreoinven.setEmpresa(detallemensajecorreoinvenDataAccess.getEmpresa(connexion,detallemensajecorreoinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallemensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallemensajecorreoinven.setSucursal(detallemensajecorreoinvenDataAccess.getSucursal(connexion,detallemensajecorreoinven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallemensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detallemensajecorreoinven.setModulo(detallemensajecorreoinvenDataAccess.getModulo(connexion,detallemensajecorreoinven));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(detallemensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				detallemensajecorreoinven.setUsuario(detallemensajecorreoinvenDataAccess.getUsuario(connexion,detallemensajecorreoinven));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(detallemensajecorreoinven.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				detallemensajecorreoinven.setEmpleado(detallemensajecorreoinvenDataAccess.getEmpleado(connexion,detallemensajecorreoinven));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(detallemensajecorreoinven.getEmpleado(),isDeep,deepLoadType,clases);				
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
			detallemensajecorreoinven.setMensajeCorreoInven(detallemensajecorreoinvenDataAccess.getMensajeCorreoInven(connexion,detallemensajecorreoinven));
			MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
			mensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setEmpresa(detallemensajecorreoinvenDataAccess.getEmpresa(connexion,detallemensajecorreoinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallemensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setSucursal(detallemensajecorreoinvenDataAccess.getSucursal(connexion,detallemensajecorreoinven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallemensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setModulo(detallemensajecorreoinvenDataAccess.getModulo(connexion,detallemensajecorreoinven));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(detallemensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setUsuario(detallemensajecorreoinvenDataAccess.getUsuario(connexion,detallemensajecorreoinven));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(detallemensajecorreoinven.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallemensajecorreoinven.setEmpleado(detallemensajecorreoinvenDataAccess.getEmpleado(connexion,detallemensajecorreoinven));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(detallemensajecorreoinven.getEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleMensajeCorreoInven detallemensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleMensajeCorreoInvenLogicAdditional.updateDetalleMensajeCorreoInvenToSave(detallemensajecorreoinven,this.arrDatoGeneral);
			
DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		MensajeCorreoInvenDataAccess.save(detallemensajecorreoinven.getMensajeCorreoInven(),connexion);

		EmpresaDataAccess.save(detallemensajecorreoinven.getEmpresa(),connexion);

		SucursalDataAccess.save(detallemensajecorreoinven.getSucursal(),connexion);

		ModuloDataAccess.save(detallemensajecorreoinven.getModulo(),connexion);

		UsuarioDataAccess.save(detallemensajecorreoinven.getUsuario(),connexion);

		EmpleadoDataAccess.save(detallemensajecorreoinven.getEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				MensajeCorreoInvenDataAccess.save(detallemensajecorreoinven.getMensajeCorreoInven(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallemensajecorreoinven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemensajecorreoinven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detallemensajecorreoinven.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(detallemensajecorreoinven.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(detallemensajecorreoinven.getEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		MensajeCorreoInvenDataAccess.save(detallemensajecorreoinven.getMensajeCorreoInven(),connexion);
		MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
		mensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallemensajecorreoinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallemensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallemensajecorreoinven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallemensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(detallemensajecorreoinven.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detallemensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(detallemensajecorreoinven.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(detallemensajecorreoinven.getUsuario(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(detallemensajecorreoinven.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(detallemensajecorreoinven.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(MensajeCorreoInven.class)) {
				MensajeCorreoInvenDataAccess.save(detallemensajecorreoinven.getMensajeCorreoInven(),connexion);
				MensajeCorreoInvenLogic mensajecorreoinvenLogic= new MensajeCorreoInvenLogic(connexion);
				mensajecorreoinvenLogic.deepSave(detallemensajecorreoinven.getMensajeCorreoInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallemensajecorreoinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallemensajecorreoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallemensajecorreoinven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallemensajecorreoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detallemensajecorreoinven.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(detallemensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(detallemensajecorreoinven.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(detallemensajecorreoinven.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(detallemensajecorreoinven.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(detallemensajecorreoinven.getEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleMensajeCorreoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(detallemensajecorreoinven);
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
			this.deepLoad(this.detallemensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleMensajeCorreoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallemensajecorreoinvens!=null) {
				for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens) {
					this.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(detallemensajecorreoinvens);
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
			if(detallemensajecorreoinvens!=null) {
				for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens) {
					this.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(detallemensajecorreoinvens);
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
			this.getNewConnexionToDeep(DetalleMensajeCorreoInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallemensajecorreoinven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleMensajeCorreoInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallemensajecorreoinvens!=null) {
				for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens) {
					this.deepSave(detallemensajecorreoinven,isDeep,deepLoadType,clases);
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
			if(detallemensajecorreoinvens!=null) {
				for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens) {
					this.deepSave(detallemensajecorreoinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleMensajeCorreoInvensFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdMensajeCorreoInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_mensaje_correo_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMensajeCorreoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMensajeCorreoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mensaje_correo_inven,DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMensajeCorreoInven);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMensajeCorreoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdMensajeCorreoInven(String sFinalQuery,Pagination pagination,Long id_mensaje_correo_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMensajeCorreoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMensajeCorreoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mensaje_correo_inven,DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMensajeCorreoInven);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMensajeCorreoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleMensajeCorreoInvensFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DetalleMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(this.detallemensajecorreoinvens);
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
			if(DetalleMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMensajeCorreoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleMensajeCorreoInven detallemensajecorreoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(detallemensajecorreoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMensajeCorreoInvenDataAccess.TABLENAME, detallemensajecorreoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleMensajeCorreoInvenLogic.registrarAuditoriaDetallesDetalleMensajeCorreoInven(connexion,detallemensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallemensajecorreoinven.getIsDeleted()) {
					/*if(!detallemensajecorreoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleMensajeCorreoInvenDataAccess.TABLENAME, detallemensajecorreoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleMensajeCorreoInvenLogic.registrarAuditoriaDetallesDetalleMensajeCorreoInven(connexion,detallemensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMensajeCorreoInvenDataAccess.TABLENAME, detallemensajecorreoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallemensajecorreoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleMensajeCorreoInvenDataAccess.TABLENAME, detallemensajecorreoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleMensajeCorreoInvenLogic.registrarAuditoriaDetallesDetalleMensajeCorreoInven(connexion,detallemensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleMensajeCorreoInven(Connexion connexion,DetalleMensajeCorreoInven detallemensajecorreoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallemensajecorreoinven.getIsNew()||!detallemensajecorreoinven.getid_mensaje_correo_inven().equals(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_mensaje_correo_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_mensaje_correo_inven()!=null)
				{
					strValorActual=detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_mensaje_correo_inven().toString();
				}
				if(detallemensajecorreoinven.getid_mensaje_correo_inven()!=null)
				{
					strValorNuevo=detallemensajecorreoinven.getid_mensaje_correo_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,strValorActual,strValorNuevo);
			}	
			
			if(detallemensajecorreoinven.getIsNew()||!detallemensajecorreoinven.getid_empresa().equals(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_empresa().toString();
				}
				if(detallemensajecorreoinven.getid_empresa()!=null)
				{
					strValorNuevo=detallemensajecorreoinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallemensajecorreoinven.getIsNew()||!detallemensajecorreoinven.getid_sucursal().equals(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_sucursal().toString();
				}
				if(detallemensajecorreoinven.getid_sucursal()!=null)
				{
					strValorNuevo=detallemensajecorreoinven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallemensajecorreoinven.getIsNew()||!detallemensajecorreoinven.getid_modulo().equals(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_modulo()!=null)
				{
					strValorActual=detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_modulo().toString();
				}
				if(detallemensajecorreoinven.getid_modulo()!=null)
				{
					strValorNuevo=detallemensajecorreoinven.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detallemensajecorreoinven.getIsNew()||!detallemensajecorreoinven.getid_usuario().equals(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_usuario()!=null)
				{
					strValorActual=detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_usuario().toString();
				}
				if(detallemensajecorreoinven.getid_usuario()!=null)
				{
					strValorNuevo=detallemensajecorreoinven.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallemensajecorreoinven.getIsNew()||!detallemensajecorreoinven.getid_empleado().equals(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_empleado()!=null)
				{
					strValorActual=detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getid_empleado().toString();
				}
				if(detallemensajecorreoinven.getid_empleado()!=null)
				{
					strValorNuevo=detallemensajecorreoinven.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(detallemensajecorreoinven.getIsNew()||!detallemensajecorreoinven.getesta_activo().equals(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getesta_activo()!=null)
				{
					strValorActual=detallemensajecorreoinven.getDetalleMensajeCorreoInvenOriginal().getesta_activo().toString();
				}
				if(detallemensajecorreoinven.getesta_activo()!=null)
				{
					strValorNuevo=detallemensajecorreoinven.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleMensajeCorreoInvenRelacionesWithConnection(DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {

		if(!detallemensajecorreoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleMensajeCorreoInvenRelacionesBase(detallemensajecorreoinven,true);
		}
	}

	public void saveDetalleMensajeCorreoInvenRelaciones(DetalleMensajeCorreoInven detallemensajecorreoinven)throws Exception {

		if(!detallemensajecorreoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleMensajeCorreoInvenRelacionesBase(detallemensajecorreoinven,false);
		}
	}

	public void saveDetalleMensajeCorreoInvenRelacionesBase(DetalleMensajeCorreoInven detallemensajecorreoinven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleMensajeCorreoInven-saveRelacionesWithConnection");}
	

			this.setDetalleMensajeCorreoInven(detallemensajecorreoinven);

			if(DetalleMensajeCorreoInvenLogicAdditional.validarSaveRelaciones(detallemensajecorreoinven,this)) {

				DetalleMensajeCorreoInvenLogicAdditional.updateRelacionesToSave(detallemensajecorreoinven,this);

				if((detallemensajecorreoinven.getIsNew()||detallemensajecorreoinven.getIsChanged())&&!detallemensajecorreoinven.getIsDeleted()) {
					this.saveDetalleMensajeCorreoInven();
					this.saveDetalleMensajeCorreoInvenRelacionesDetalles();

				} else if(detallemensajecorreoinven.getIsDeleted()) {
					this.saveDetalleMensajeCorreoInvenRelacionesDetalles();
					this.saveDetalleMensajeCorreoInven();
				}

				DetalleMensajeCorreoInvenLogicAdditional.updateRelacionesToSaveAfter(detallemensajecorreoinven,this);

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
	
	
	private void saveDetalleMensajeCorreoInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfDetalleMensajeCorreoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfDetalleMensajeCorreoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
