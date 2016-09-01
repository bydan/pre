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
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.importaciones.util.ValorPorUnidadConstantesFunciones;
import com.bydan.erp.importaciones.util.ValorPorUnidadParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.ValorPorUnidadParameterGeneral;
import com.bydan.erp.importaciones.business.entity.ValorPorUnidad;
import com.bydan.erp.importaciones.business.logic.ValorPorUnidadLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ValorPorUnidadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ValorPorUnidadLogic.class);
	
	protected ValorPorUnidadDataAccess valorporunidadDataAccess; 	
	protected ValorPorUnidad valorporunidad;
	protected List<ValorPorUnidad> valorporunidads;
	protected Object valorporunidadObject;	
	protected List<Object> valorporunidadsObject;
	
	public static ClassValidator<ValorPorUnidad> valorporunidadValidator = new ClassValidator<ValorPorUnidad>(ValorPorUnidad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ValorPorUnidadLogicAdditional valorporunidadLogicAdditional=null;
	
	public ValorPorUnidadLogicAdditional getValorPorUnidadLogicAdditional() {
		return this.valorporunidadLogicAdditional;
	}
	
	public void setValorPorUnidadLogicAdditional(ValorPorUnidadLogicAdditional valorporunidadLogicAdditional) {
		try {
			this.valorporunidadLogicAdditional=valorporunidadLogicAdditional;
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
	
	
	
	
	public  ValorPorUnidadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.valorporunidadDataAccess = new ValorPorUnidadDataAccess();
			
			this.valorporunidads= new ArrayList<ValorPorUnidad>();
			this.valorporunidad= new ValorPorUnidad();
			
			this.valorporunidadObject=new Object();
			this.valorporunidadsObject=new ArrayList<Object>();
				
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
			
			this.valorporunidadDataAccess.setConnexionType(this.connexionType);
			this.valorporunidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ValorPorUnidadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.valorporunidadDataAccess = new ValorPorUnidadDataAccess();
			this.valorporunidads= new ArrayList<ValorPorUnidad>();
			this.valorporunidad= new ValorPorUnidad();
			this.valorporunidadObject=new Object();
			this.valorporunidadsObject=new ArrayList<Object>();
			
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
			
			this.valorporunidadDataAccess.setConnexionType(this.connexionType);
			this.valorporunidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ValorPorUnidad getValorPorUnidad() throws Exception {	
		ValorPorUnidadLogicAdditional.checkValorPorUnidadToGet(valorporunidad,this.datosCliente,this.arrDatoGeneral);
		ValorPorUnidadLogicAdditional.updateValorPorUnidadToGet(valorporunidad,this.arrDatoGeneral);
		
		return valorporunidad;
	}
		
	public void setValorPorUnidad(ValorPorUnidad newValorPorUnidad) {
		this.valorporunidad = newValorPorUnidad;
	}
	
	public ValorPorUnidadDataAccess getValorPorUnidadDataAccess() {
		return valorporunidadDataAccess;
	}
	
	public void setValorPorUnidadDataAccess(ValorPorUnidadDataAccess newvalorporunidadDataAccess) {
		this.valorporunidadDataAccess = newvalorporunidadDataAccess;
	}
	
	public List<ValorPorUnidad> getValorPorUnidads() throws Exception {		
		this.quitarValorPorUnidadsNulos();
		
		ValorPorUnidadLogicAdditional.checkValorPorUnidadToGets(valorporunidads,this.datosCliente,this.arrDatoGeneral);
		
		for (ValorPorUnidad valorporunidadLocal: valorporunidads ) {
			ValorPorUnidadLogicAdditional.updateValorPorUnidadToGet(valorporunidadLocal,this.arrDatoGeneral);
		}
		
		return valorporunidads;
	}
	
	public void setValorPorUnidads(List<ValorPorUnidad> newValorPorUnidads) {
		this.valorporunidads = newValorPorUnidads;
	}
	
	public Object getValorPorUnidadObject() {	
		this.valorporunidadObject=this.valorporunidadDataAccess.getEntityObject();
		return this.valorporunidadObject;
	}
		
	public void setValorPorUnidadObject(Object newValorPorUnidadObject) {
		this.valorporunidadObject = newValorPorUnidadObject;
	}
	
	public List<Object> getValorPorUnidadsObject() {		
		this.valorporunidadsObject=this.valorporunidadDataAccess.getEntitiesObject();
		return this.valorporunidadsObject;
	}
		
	public void setValorPorUnidadsObject(List<Object> newValorPorUnidadsObject) {
		this.valorporunidadsObject = newValorPorUnidadsObject;
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
		
		if(this.valorporunidadDataAccess!=null) {
			this.valorporunidadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			valorporunidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			valorporunidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		valorporunidad = new  ValorPorUnidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			valorporunidad=valorporunidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorporunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidad);
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
		valorporunidad = new  ValorPorUnidad();
		  		  
        try {
			
			valorporunidad=valorporunidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorporunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		valorporunidad = new  ValorPorUnidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			valorporunidad=valorporunidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorporunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidad);
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
		valorporunidad = new  ValorPorUnidad();
		  		  
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
		valorporunidad = new  ValorPorUnidad();
		  		  
        try {
			
			valorporunidad=valorporunidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorporunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		valorporunidad = new  ValorPorUnidad();
		  		  
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
		valorporunidad = new  ValorPorUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =valorporunidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		valorporunidad = new  ValorPorUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=valorporunidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		valorporunidad = new  ValorPorUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =valorporunidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		valorporunidad = new  ValorPorUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=valorporunidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		valorporunidad = new  ValorPorUnidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =valorporunidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		valorporunidad = new  ValorPorUnidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=valorporunidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
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
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
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
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
        try {			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
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
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
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
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
        try {
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
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
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
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
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		valorporunidad = new  ValorPorUnidad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidad=valorporunidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidad);
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
		valorporunidad = new  ValorPorUnidad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidad=valorporunidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
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
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		  		  
        try {
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosValorPorUnidadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getTodosValorPorUnidadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
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
	
	public  void  getTodosValorPorUnidads(String sFinalQuery,Pagination pagination)throws Exception {
		valorporunidads = new  ArrayList<ValorPorUnidad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorporunidads=valorporunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarValorPorUnidad(valorporunidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarValorPorUnidad(ValorPorUnidad valorporunidad) throws Exception {
		Boolean estaValidado=false;
		
		if(valorporunidad.getIsNew() || valorporunidad.getIsChanged()) { 
			this.invalidValues = valorporunidadValidator.getInvalidValues(valorporunidad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(valorporunidad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarValorPorUnidad(List<ValorPorUnidad> ValorPorUnidads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ValorPorUnidad valorporunidadLocal:valorporunidads) {				
			estaValidadoObjeto=this.validarGuardarValorPorUnidad(valorporunidadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarValorPorUnidad(List<ValorPorUnidad> ValorPorUnidads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarValorPorUnidad(valorporunidads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarValorPorUnidad(ValorPorUnidad ValorPorUnidad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarValorPorUnidad(valorporunidad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ValorPorUnidad valorporunidad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+valorporunidad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ValorPorUnidadConstantesFunciones.getValorPorUnidadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"valorporunidad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ValorPorUnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ValorPorUnidadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveValorPorUnidadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-saveValorPorUnidadWithConnection");connexion.begin();			
			
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSave(this.valorporunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ValorPorUnidadLogicAdditional.updateValorPorUnidadToSave(this.valorporunidad,this.arrDatoGeneral);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.valorporunidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowValorPorUnidad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarValorPorUnidad(this.valorporunidad)) {
				ValorPorUnidadDataAccess.save(this.valorporunidad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.valorporunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSaveAfter(this.valorporunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowValorPorUnidad();
			
			connexion.commit();			
			
			if(this.valorporunidad.getIsDeleted()) {
				this.valorporunidad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveValorPorUnidad()throws Exception {	
		try {	
			
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSave(this.valorporunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ValorPorUnidadLogicAdditional.updateValorPorUnidadToSave(this.valorporunidad,this.arrDatoGeneral);
			
			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.valorporunidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarValorPorUnidad(this.valorporunidad)) {			
				ValorPorUnidadDataAccess.save(this.valorporunidad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.valorporunidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSaveAfter(this.valorporunidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.valorporunidad.getIsDeleted()) {
				this.valorporunidad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveValorPorUnidadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-saveValorPorUnidadsWithConnection");connexion.begin();			
			
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSaves(valorporunidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowValorPorUnidads();
			
			Boolean validadoTodosValorPorUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ValorPorUnidad valorporunidadLocal:valorporunidads) {		
				if(valorporunidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ValorPorUnidadLogicAdditional.updateValorPorUnidadToSave(valorporunidadLocal,this.arrDatoGeneral);
	        	
				ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),valorporunidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarValorPorUnidad(valorporunidadLocal)) {
					ValorPorUnidadDataAccess.save(valorporunidadLocal, connexion);				
				} else {
					validadoTodosValorPorUnidad=false;
				}
			}
			
			if(!validadoTodosValorPorUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSavesAfter(valorporunidads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowValorPorUnidads();
			
			connexion.commit();		
			
			this.quitarValorPorUnidadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveValorPorUnidads()throws Exception {				
		 try {	
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSaves(valorporunidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosValorPorUnidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ValorPorUnidad valorporunidadLocal:valorporunidads) {				
				if(valorporunidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ValorPorUnidadLogicAdditional.updateValorPorUnidadToSave(valorporunidadLocal,this.arrDatoGeneral);
	        	
				ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),valorporunidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarValorPorUnidad(valorporunidadLocal)) {				
					ValorPorUnidadDataAccess.save(valorporunidadLocal, connexion);				
				} else {
					validadoTodosValorPorUnidad=false;
				}
			}
			
			if(!validadoTodosValorPorUnidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ValorPorUnidadLogicAdditional.checkValorPorUnidadToSavesAfter(valorporunidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarValorPorUnidadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ValorPorUnidadParameterReturnGeneral procesarAccionValorPorUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ValorPorUnidad> valorporunidads,ValorPorUnidadParameterReturnGeneral valorporunidadParameterGeneral)throws Exception {
		 try {	
			ValorPorUnidadParameterReturnGeneral valorporunidadReturnGeneral=new ValorPorUnidadParameterReturnGeneral();
	
			ValorPorUnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,valorporunidads,valorporunidadParameterGeneral,valorporunidadReturnGeneral);
			
			return valorporunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ValorPorUnidadParameterReturnGeneral procesarAccionValorPorUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ValorPorUnidad> valorporunidads,ValorPorUnidadParameterReturnGeneral valorporunidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-procesarAccionValorPorUnidadsWithConnection");connexion.begin();			
			
			ValorPorUnidadParameterReturnGeneral valorporunidadReturnGeneral=new ValorPorUnidadParameterReturnGeneral();
	
			ValorPorUnidadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,valorporunidads,valorporunidadParameterGeneral,valorporunidadReturnGeneral);
			
			this.connexion.commit();
			
			return valorporunidadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ValorPorUnidadParameterReturnGeneral procesarEventosValorPorUnidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ValorPorUnidad> valorporunidads,ValorPorUnidad valorporunidad,ValorPorUnidadParameterReturnGeneral valorporunidadParameterGeneral,Boolean isEsNuevoValorPorUnidad,ArrayList<Classe> clases)throws Exception {
		 try {	
			ValorPorUnidadParameterReturnGeneral valorporunidadReturnGeneral=new ValorPorUnidadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				valorporunidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ValorPorUnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,valorporunidads,valorporunidad,valorporunidadParameterGeneral,valorporunidadReturnGeneral,isEsNuevoValorPorUnidad,clases);
			
			return valorporunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ValorPorUnidadParameterReturnGeneral procesarEventosValorPorUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ValorPorUnidad> valorporunidads,ValorPorUnidad valorporunidad,ValorPorUnidadParameterReturnGeneral valorporunidadParameterGeneral,Boolean isEsNuevoValorPorUnidad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-procesarEventosValorPorUnidadsWithConnection");connexion.begin();			
			
			ValorPorUnidadParameterReturnGeneral valorporunidadReturnGeneral=new ValorPorUnidadParameterReturnGeneral();
	
			valorporunidadReturnGeneral.setValorPorUnidad(valorporunidad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				valorporunidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ValorPorUnidadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,valorporunidads,valorporunidad,valorporunidadParameterGeneral,valorporunidadReturnGeneral,isEsNuevoValorPorUnidad,clases);
			
			this.connexion.commit();
			
			return valorporunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ValorPorUnidadParameterReturnGeneral procesarImportacionValorPorUnidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ValorPorUnidadParameterReturnGeneral valorporunidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-procesarImportacionValorPorUnidadsWithConnection");connexion.begin();			
			
			ValorPorUnidadParameterReturnGeneral valorporunidadReturnGeneral=new ValorPorUnidadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.valorporunidads=new ArrayList<ValorPorUnidad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.valorporunidad=new ValorPorUnidad();
				
				
				if(conColumnasBase) {this.valorporunidad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.valorporunidad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.valorporunidad.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.valorporunidads.add(this.valorporunidad);
			}
			
			this.saveValorPorUnidads();
			
			this.connexion.commit();
			
			valorporunidadReturnGeneral.setConRetornoEstaProcesado(true);
			valorporunidadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return valorporunidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarValorPorUnidadsEliminados() throws Exception {				
		
		List<ValorPorUnidad> valorporunidadsAux= new ArrayList<ValorPorUnidad>();
		
		for(ValorPorUnidad valorporunidad:valorporunidads) {
			if(!valorporunidad.getIsDeleted()) {
				valorporunidadsAux.add(valorporunidad);
			}
		}
		
		valorporunidads=valorporunidadsAux;
	}
	
	public void quitarValorPorUnidadsNulos() throws Exception {				
		
		List<ValorPorUnidad> valorporunidadsAux= new ArrayList<ValorPorUnidad>();
		
		for(ValorPorUnidad valorporunidad : this.valorporunidads) {
			if(valorporunidad==null) {
				valorporunidadsAux.add(valorporunidad);
			}
		}
		
		//this.valorporunidads=valorporunidadsAux;
		
		this.valorporunidads.removeAll(valorporunidadsAux);
	}
	
	public void getSetVersionRowValorPorUnidadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(valorporunidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((valorporunidad.getIsDeleted() || (valorporunidad.getIsChanged()&&!valorporunidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=valorporunidadDataAccess.getSetVersionRowValorPorUnidad(connexion,valorporunidad.getId());
				
				if(!valorporunidad.getVersionRow().equals(timestamp)) {	
					valorporunidad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				valorporunidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowValorPorUnidad()throws Exception {	
		
		if(valorporunidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((valorporunidad.getIsDeleted() || (valorporunidad.getIsChanged()&&!valorporunidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=valorporunidadDataAccess.getSetVersionRowValorPorUnidad(connexion,valorporunidad.getId());
			
			try {							
				if(!valorporunidad.getVersionRow().equals(timestamp)) {	
					valorporunidad.setVersionRow(timestamp);
				}
				
				valorporunidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowValorPorUnidadsWithConnection()throws Exception {	
		if(valorporunidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ValorPorUnidad valorporunidadAux:valorporunidads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(valorporunidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(valorporunidadAux.getIsDeleted() || (valorporunidadAux.getIsChanged()&&!valorporunidadAux.getIsNew())) {
						
						timestamp=valorporunidadDataAccess.getSetVersionRowValorPorUnidad(connexion,valorporunidadAux.getId());
						
						if(!valorporunidad.getVersionRow().equals(timestamp)) {	
							valorporunidadAux.setVersionRow(timestamp);
						}
								
						valorporunidadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowValorPorUnidads()throws Exception {	
		if(valorporunidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ValorPorUnidad valorporunidadAux:valorporunidads) {
					if(valorporunidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(valorporunidadAux.getIsDeleted() || (valorporunidadAux.getIsChanged()&&!valorporunidadAux.getIsNew())) {
						
						timestamp=valorporunidadDataAccess.getSetVersionRowValorPorUnidad(connexion,valorporunidadAux.getId());
						
						if(!valorporunidadAux.getVersionRow().equals(timestamp)) {	
							valorporunidadAux.setVersionRow(timestamp);
						}
						
													
						valorporunidadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ValorPorUnidadParameterReturnGeneral cargarCombosLoteForeignKeyValorPorUnidadWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ValorPorUnidadParameterReturnGeneral  valorporunidadReturnGeneral =new ValorPorUnidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-cargarCombosLoteForeignKeyValorPorUnidadWithConnection");connexion.begin();
			
			valorporunidadReturnGeneral =new ValorPorUnidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			valorporunidadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			valorporunidadReturnGeneral.setunidadsForeignKey(unidadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return valorporunidadReturnGeneral;
	}
	
	public ValorPorUnidadParameterReturnGeneral cargarCombosLoteForeignKeyValorPorUnidad(String finalQueryGlobalEmpresa,String finalQueryGlobalUnidad) throws Exception {
		ValorPorUnidadParameterReturnGeneral  valorporunidadReturnGeneral =new ValorPorUnidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			valorporunidadReturnGeneral =new ValorPorUnidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			valorporunidadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			valorporunidadReturnGeneral.setunidadsForeignKey(unidadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return valorporunidadReturnGeneral;
	}
	
	
	public void deepLoad(ValorPorUnidad valorporunidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ValorPorUnidadLogicAdditional.updateValorPorUnidadToGet(valorporunidad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		valorporunidad.setEmpresa(valorporunidadDataAccess.getEmpresa(connexion,valorporunidad));
		valorporunidad.setUnidad(valorporunidadDataAccess.getUnidad(connexion,valorporunidad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				valorporunidad.setEmpresa(valorporunidadDataAccess.getEmpresa(connexion,valorporunidad));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				valorporunidad.setUnidad(valorporunidadDataAccess.getUnidad(connexion,valorporunidad));
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
			valorporunidad.setEmpresa(valorporunidadDataAccess.getEmpresa(connexion,valorporunidad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			valorporunidad.setUnidad(valorporunidadDataAccess.getUnidad(connexion,valorporunidad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		valorporunidad.setEmpresa(valorporunidadDataAccess.getEmpresa(connexion,valorporunidad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(valorporunidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		valorporunidad.setUnidad(valorporunidadDataAccess.getUnidad(connexion,valorporunidad));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(valorporunidad.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				valorporunidad.setEmpresa(valorporunidadDataAccess.getEmpresa(connexion,valorporunidad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(valorporunidad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				valorporunidad.setUnidad(valorporunidadDataAccess.getUnidad(connexion,valorporunidad));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(valorporunidad.getUnidad(),isDeep,deepLoadType,clases);				
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
			valorporunidad.setEmpresa(valorporunidadDataAccess.getEmpresa(connexion,valorporunidad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(valorporunidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			valorporunidad.setUnidad(valorporunidadDataAccess.getUnidad(connexion,valorporunidad));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(valorporunidad.getUnidad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ValorPorUnidad valorporunidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ValorPorUnidadLogicAdditional.updateValorPorUnidadToSave(valorporunidad,this.arrDatoGeneral);
			
ValorPorUnidadDataAccess.save(valorporunidad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(valorporunidad.getEmpresa(),connexion);

		UnidadDataAccess.save(valorporunidad.getUnidad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(valorporunidad.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(valorporunidad.getUnidad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(valorporunidad.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(valorporunidad.getEmpresa(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(valorporunidad.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(valorporunidad.getUnidad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(valorporunidad.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(valorporunidad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(valorporunidad.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(valorporunidad.getUnidad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ValorPorUnidad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(valorporunidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(valorporunidad);
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
			this.deepLoad(this.valorporunidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ValorPorUnidad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(valorporunidads!=null) {
				for(ValorPorUnidad valorporunidad:valorporunidads) {
					this.deepLoad(valorporunidad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(valorporunidads);
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
			if(valorporunidads!=null) {
				for(ValorPorUnidad valorporunidad:valorporunidads) {
					this.deepLoad(valorporunidad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(valorporunidads);
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
			this.getNewConnexionToDeep(ValorPorUnidad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(valorporunidad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ValorPorUnidad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(valorporunidads!=null) {
				for(ValorPorUnidad valorporunidad:valorporunidads) {
					this.deepSave(valorporunidad,isDeep,deepLoadType,clases);
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
			if(valorporunidads!=null) {
				for(ValorPorUnidad valorporunidad:valorporunidads) {
					this.deepSave(valorporunidad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getValorPorUnidadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ValorPorUnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorporunidads=valorporunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getValorPorUnidadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ValorPorUnidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorporunidads=valorporunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getValorPorUnidadsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorPorUnidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ValorPorUnidadConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorporunidads=valorporunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getValorPorUnidadsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,ValorPorUnidadConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			ValorPorUnidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorporunidads=valorporunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorPorUnidadConstantesFunciones.refrescarForeignKeysDescripcionesValorPorUnidad(this.valorporunidads);
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
			if(ValorPorUnidadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorPorUnidadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ValorPorUnidad valorporunidad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ValorPorUnidadConstantesFunciones.ISCONAUDITORIA) {
				if(valorporunidad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorPorUnidadDataAccess.TABLENAME, valorporunidad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ValorPorUnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ValorPorUnidadLogic.registrarAuditoriaDetallesValorPorUnidad(connexion,valorporunidad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(valorporunidad.getIsDeleted()) {
					/*if(!valorporunidad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ValorPorUnidadDataAccess.TABLENAME, valorporunidad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ValorPorUnidadLogic.registrarAuditoriaDetallesValorPorUnidad(connexion,valorporunidad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorPorUnidadDataAccess.TABLENAME, valorporunidad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(valorporunidad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorPorUnidadDataAccess.TABLENAME, valorporunidad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ValorPorUnidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ValorPorUnidadLogic.registrarAuditoriaDetallesValorPorUnidad(connexion,valorporunidad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesValorPorUnidad(Connexion connexion,ValorPorUnidad valorporunidad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(valorporunidad.getIsNew()||!valorporunidad.getid_empresa().equals(valorporunidad.getValorPorUnidadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorporunidad.getValorPorUnidadOriginal().getid_empresa()!=null)
				{
					strValorActual=valorporunidad.getValorPorUnidadOriginal().getid_empresa().toString();
				}
				if(valorporunidad.getid_empresa()!=null)
				{
					strValorNuevo=valorporunidad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorPorUnidadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(valorporunidad.getIsNew()||!valorporunidad.getid_unidad().equals(valorporunidad.getValorPorUnidadOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorporunidad.getValorPorUnidadOriginal().getid_unidad()!=null)
				{
					strValorActual=valorporunidad.getValorPorUnidadOriginal().getid_unidad().toString();
				}
				if(valorporunidad.getid_unidad()!=null)
				{
					strValorNuevo=valorporunidad.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorPorUnidadConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(valorporunidad.getIsNew()||!valorporunidad.getvalor().equals(valorporunidad.getValorPorUnidadOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorporunidad.getValorPorUnidadOriginal().getvalor()!=null)
				{
					strValorActual=valorporunidad.getValorPorUnidadOriginal().getvalor().toString();
				}
				if(valorporunidad.getvalor()!=null)
				{
					strValorNuevo=valorporunidad.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorPorUnidadConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveValorPorUnidadRelacionesWithConnection(ValorPorUnidad valorporunidad) throws Exception {

		if(!valorporunidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveValorPorUnidadRelacionesBase(valorporunidad,true);
		}
	}

	public void saveValorPorUnidadRelaciones(ValorPorUnidad valorporunidad)throws Exception {

		if(!valorporunidad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveValorPorUnidadRelacionesBase(valorporunidad,false);
		}
	}

	public void saveValorPorUnidadRelacionesBase(ValorPorUnidad valorporunidad,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ValorPorUnidad-saveRelacionesWithConnection");}
	

			this.setValorPorUnidad(valorporunidad);

			if(ValorPorUnidadLogicAdditional.validarSaveRelaciones(valorporunidad,this)) {

				ValorPorUnidadLogicAdditional.updateRelacionesToSave(valorporunidad,this);

				if((valorporunidad.getIsNew()||valorporunidad.getIsChanged())&&!valorporunidad.getIsDeleted()) {
					this.saveValorPorUnidad();
					this.saveValorPorUnidadRelacionesDetalles();

				} else if(valorporunidad.getIsDeleted()) {
					this.saveValorPorUnidadRelacionesDetalles();
					this.saveValorPorUnidad();
				}

				ValorPorUnidadLogicAdditional.updateRelacionesToSaveAfter(valorporunidad,this);

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
	
	
	private void saveValorPorUnidadRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfValorPorUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ValorPorUnidadConstantesFunciones.getClassesForeignKeysOfValorPorUnidad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfValorPorUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ValorPorUnidadConstantesFunciones.getClassesRelationshipsOfValorPorUnidad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
