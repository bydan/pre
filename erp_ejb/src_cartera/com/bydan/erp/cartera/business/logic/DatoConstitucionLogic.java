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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.DatoConstitucionConstantesFunciones;
import com.bydan.erp.cartera.util.DatoConstitucionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DatoConstitucionParameterGeneral;
import com.bydan.erp.cartera.business.entity.DatoConstitucion;
import com.bydan.erp.cartera.business.logic.DatoConstitucionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class DatoConstitucionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DatoConstitucionLogic.class);
	
	protected DatoConstitucionDataAccess datoconstitucionDataAccess; 	
	protected DatoConstitucion datoconstitucion;
	protected List<DatoConstitucion> datoconstitucions;
	protected Object datoconstitucionObject;	
	protected List<Object> datoconstitucionsObject;
	
	public static ClassValidator<DatoConstitucion> datoconstitucionValidator = new ClassValidator<DatoConstitucion>(DatoConstitucion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DatoConstitucionLogicAdditional datoconstitucionLogicAdditional=null;
	
	public DatoConstitucionLogicAdditional getDatoConstitucionLogicAdditional() {
		return this.datoconstitucionLogicAdditional;
	}
	
	public void setDatoConstitucionLogicAdditional(DatoConstitucionLogicAdditional datoconstitucionLogicAdditional) {
		try {
			this.datoconstitucionLogicAdditional=datoconstitucionLogicAdditional;
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
	
	
	
	
	public  DatoConstitucionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.datoconstitucionDataAccess = new DatoConstitucionDataAccess();
			
			this.datoconstitucions= new ArrayList<DatoConstitucion>();
			this.datoconstitucion= new DatoConstitucion();
			
			this.datoconstitucionObject=new Object();
			this.datoconstitucionsObject=new ArrayList<Object>();
				
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
			
			this.datoconstitucionDataAccess.setConnexionType(this.connexionType);
			this.datoconstitucionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DatoConstitucionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.datoconstitucionDataAccess = new DatoConstitucionDataAccess();
			this.datoconstitucions= new ArrayList<DatoConstitucion>();
			this.datoconstitucion= new DatoConstitucion();
			this.datoconstitucionObject=new Object();
			this.datoconstitucionsObject=new ArrayList<Object>();
			
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
			
			this.datoconstitucionDataAccess.setConnexionType(this.connexionType);
			this.datoconstitucionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DatoConstitucion getDatoConstitucion() throws Exception {	
		DatoConstitucionLogicAdditional.checkDatoConstitucionToGet(datoconstitucion,this.datosCliente,this.arrDatoGeneral);
		DatoConstitucionLogicAdditional.updateDatoConstitucionToGet(datoconstitucion,this.arrDatoGeneral);
		
		return datoconstitucion;
	}
		
	public void setDatoConstitucion(DatoConstitucion newDatoConstitucion) {
		this.datoconstitucion = newDatoConstitucion;
	}
	
	public DatoConstitucionDataAccess getDatoConstitucionDataAccess() {
		return datoconstitucionDataAccess;
	}
	
	public void setDatoConstitucionDataAccess(DatoConstitucionDataAccess newdatoconstitucionDataAccess) {
		this.datoconstitucionDataAccess = newdatoconstitucionDataAccess;
	}
	
	public List<DatoConstitucion> getDatoConstitucions() throws Exception {		
		this.quitarDatoConstitucionsNulos();
		
		DatoConstitucionLogicAdditional.checkDatoConstitucionToGets(datoconstitucions,this.datosCliente,this.arrDatoGeneral);
		
		for (DatoConstitucion datoconstitucionLocal: datoconstitucions ) {
			DatoConstitucionLogicAdditional.updateDatoConstitucionToGet(datoconstitucionLocal,this.arrDatoGeneral);
		}
		
		return datoconstitucions;
	}
	
	public void setDatoConstitucions(List<DatoConstitucion> newDatoConstitucions) {
		this.datoconstitucions = newDatoConstitucions;
	}
	
	public Object getDatoConstitucionObject() {	
		this.datoconstitucionObject=this.datoconstitucionDataAccess.getEntityObject();
		return this.datoconstitucionObject;
	}
		
	public void setDatoConstitucionObject(Object newDatoConstitucionObject) {
		this.datoconstitucionObject = newDatoConstitucionObject;
	}
	
	public List<Object> getDatoConstitucionsObject() {		
		this.datoconstitucionsObject=this.datoconstitucionDataAccess.getEntitiesObject();
		return this.datoconstitucionsObject;
	}
		
	public void setDatoConstitucionsObject(List<Object> newDatoConstitucionsObject) {
		this.datoconstitucionsObject = newDatoConstitucionsObject;
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
		
		if(this.datoconstitucionDataAccess!=null) {
			this.datoconstitucionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			datoconstitucionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			datoconstitucionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		datoconstitucion = new  DatoConstitucion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datoconstitucion=datoconstitucionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoconstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucion);
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
		datoconstitucion = new  DatoConstitucion();
		  		  
        try {
			
			datoconstitucion=datoconstitucionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoconstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		datoconstitucion = new  DatoConstitucion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datoconstitucion=datoconstitucionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoconstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucion);
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
		datoconstitucion = new  DatoConstitucion();
		  		  
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
		datoconstitucion = new  DatoConstitucion();
		  		  
        try {
			
			datoconstitucion=datoconstitucionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoconstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		datoconstitucion = new  DatoConstitucion();
		  		  
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
		datoconstitucion = new  DatoConstitucion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =datoconstitucionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoconstitucion = new  DatoConstitucion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=datoconstitucionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datoconstitucion = new  DatoConstitucion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =datoconstitucionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoconstitucion = new  DatoConstitucion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=datoconstitucionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datoconstitucion = new  DatoConstitucion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =datoconstitucionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoconstitucion = new  DatoConstitucion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=datoconstitucionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
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
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
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
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
        try {			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
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
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
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
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
        try {
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
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
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
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
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		datoconstitucion = new  DatoConstitucion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucion=datoconstitucionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucion);
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
		datoconstitucion = new  DatoConstitucion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucion=datoconstitucionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
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
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		  		  
        try {
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDatoConstitucionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getTodosDatoConstitucionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
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
	
	public  void  getTodosDatoConstitucions(String sFinalQuery,Pagination pagination)throws Exception {
		datoconstitucions = new  ArrayList<DatoConstitucion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoConstitucion(datoconstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDatoConstitucion(DatoConstitucion datoconstitucion) throws Exception {
		Boolean estaValidado=false;
		
		if(datoconstitucion.getIsNew() || datoconstitucion.getIsChanged()) { 
			this.invalidValues = datoconstitucionValidator.getInvalidValues(datoconstitucion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(datoconstitucion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDatoConstitucion(List<DatoConstitucion> DatoConstitucions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DatoConstitucion datoconstitucionLocal:datoconstitucions) {				
			estaValidadoObjeto=this.validarGuardarDatoConstitucion(datoconstitucionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDatoConstitucion(List<DatoConstitucion> DatoConstitucions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoConstitucion(datoconstitucions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDatoConstitucion(DatoConstitucion DatoConstitucion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoConstitucion(datoconstitucion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DatoConstitucion datoconstitucion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+datoconstitucion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DatoConstitucionConstantesFunciones.getDatoConstitucionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"datoconstitucion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DatoConstitucionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DatoConstitucionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDatoConstitucionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-saveDatoConstitucionWithConnection");connexion.begin();			
			
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSave(this.datoconstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoConstitucionLogicAdditional.updateDatoConstitucionToSave(this.datoconstitucion,this.arrDatoGeneral);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datoconstitucion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDatoConstitucion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoConstitucion(this.datoconstitucion)) {
				DatoConstitucionDataAccess.save(this.datoconstitucion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.datoconstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSaveAfter(this.datoconstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoConstitucion();
			
			connexion.commit();			
			
			if(this.datoconstitucion.getIsDeleted()) {
				this.datoconstitucion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDatoConstitucion()throws Exception {	
		try {	
			
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSave(this.datoconstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoConstitucionLogicAdditional.updateDatoConstitucionToSave(this.datoconstitucion,this.arrDatoGeneral);
			
			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datoconstitucion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoConstitucion(this.datoconstitucion)) {			
				DatoConstitucionDataAccess.save(this.datoconstitucion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.datoconstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSaveAfter(this.datoconstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.datoconstitucion.getIsDeleted()) {
				this.datoconstitucion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDatoConstitucionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-saveDatoConstitucionsWithConnection");connexion.begin();			
			
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSaves(datoconstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDatoConstitucions();
			
			Boolean validadoTodosDatoConstitucion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoConstitucion datoconstitucionLocal:datoconstitucions) {		
				if(datoconstitucionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoConstitucionLogicAdditional.updateDatoConstitucionToSave(datoconstitucionLocal,this.arrDatoGeneral);
	        	
				DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datoconstitucionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoConstitucion(datoconstitucionLocal)) {
					DatoConstitucionDataAccess.save(datoconstitucionLocal, connexion);				
				} else {
					validadoTodosDatoConstitucion=false;
				}
			}
			
			if(!validadoTodosDatoConstitucion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSavesAfter(datoconstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoConstitucions();
			
			connexion.commit();		
			
			this.quitarDatoConstitucionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDatoConstitucions()throws Exception {				
		 try {	
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSaves(datoconstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDatoConstitucion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoConstitucion datoconstitucionLocal:datoconstitucions) {				
				if(datoconstitucionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoConstitucionLogicAdditional.updateDatoConstitucionToSave(datoconstitucionLocal,this.arrDatoGeneral);
	        	
				DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datoconstitucionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoConstitucion(datoconstitucionLocal)) {				
					DatoConstitucionDataAccess.save(datoconstitucionLocal, connexion);				
				} else {
					validadoTodosDatoConstitucion=false;
				}
			}
			
			if(!validadoTodosDatoConstitucion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoConstitucionLogicAdditional.checkDatoConstitucionToSavesAfter(datoconstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDatoConstitucionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoConstitucionParameterReturnGeneral procesarAccionDatoConstitucions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoConstitucion> datoconstitucions,DatoConstitucionParameterReturnGeneral datoconstitucionParameterGeneral)throws Exception {
		 try {	
			DatoConstitucionParameterReturnGeneral datoconstitucionReturnGeneral=new DatoConstitucionParameterReturnGeneral();
	
			DatoConstitucionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datoconstitucions,datoconstitucionParameterGeneral,datoconstitucionReturnGeneral);
			
			return datoconstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoConstitucionParameterReturnGeneral procesarAccionDatoConstitucionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoConstitucion> datoconstitucions,DatoConstitucionParameterReturnGeneral datoconstitucionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-procesarAccionDatoConstitucionsWithConnection");connexion.begin();			
			
			DatoConstitucionParameterReturnGeneral datoconstitucionReturnGeneral=new DatoConstitucionParameterReturnGeneral();
	
			DatoConstitucionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datoconstitucions,datoconstitucionParameterGeneral,datoconstitucionReturnGeneral);
			
			this.connexion.commit();
			
			return datoconstitucionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoConstitucionParameterReturnGeneral procesarEventosDatoConstitucions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoConstitucion> datoconstitucions,DatoConstitucion datoconstitucion,DatoConstitucionParameterReturnGeneral datoconstitucionParameterGeneral,Boolean isEsNuevoDatoConstitucion,ArrayList<Classe> clases)throws Exception {
		 try {	
			DatoConstitucionParameterReturnGeneral datoconstitucionReturnGeneral=new DatoConstitucionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datoconstitucionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoConstitucionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datoconstitucions,datoconstitucion,datoconstitucionParameterGeneral,datoconstitucionReturnGeneral,isEsNuevoDatoConstitucion,clases);
			
			return datoconstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DatoConstitucionParameterReturnGeneral procesarEventosDatoConstitucionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoConstitucion> datoconstitucions,DatoConstitucion datoconstitucion,DatoConstitucionParameterReturnGeneral datoconstitucionParameterGeneral,Boolean isEsNuevoDatoConstitucion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-procesarEventosDatoConstitucionsWithConnection");connexion.begin();			
			
			DatoConstitucionParameterReturnGeneral datoconstitucionReturnGeneral=new DatoConstitucionParameterReturnGeneral();
	
			datoconstitucionReturnGeneral.setDatoConstitucion(datoconstitucion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datoconstitucionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoConstitucionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datoconstitucions,datoconstitucion,datoconstitucionParameterGeneral,datoconstitucionReturnGeneral,isEsNuevoDatoConstitucion,clases);
			
			this.connexion.commit();
			
			return datoconstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoConstitucionParameterReturnGeneral procesarImportacionDatoConstitucionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DatoConstitucionParameterReturnGeneral datoconstitucionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-procesarImportacionDatoConstitucionsWithConnection");connexion.begin();			
			
			DatoConstitucionParameterReturnGeneral datoconstitucionReturnGeneral=new DatoConstitucionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.datoconstitucions=new ArrayList<DatoConstitucion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.datoconstitucion=new DatoConstitucion();
				
				
				if(conColumnasBase) {this.datoconstitucion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.datoconstitucion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

			this.datoconstitucion.setdireccion(arrColumnas[iColumn++]);
				this.datoconstitucion.setfechaconstitucion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.datoconstitucion.setcapitalsuscrito(Double.parseDouble(arrColumnas[iColumn++]));
				this.datoconstitucion.setplazofiniquito(Integer.parseInt(arrColumnas[iColumn++]));
				this.datoconstitucion.setreservalegal(Double.parseDouble(arrColumnas[iColumn++]));
				this.datoconstitucion.setfechaestatuto(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.datoconstitucion.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.datoconstitucions.add(this.datoconstitucion);
			}
			
			this.saveDatoConstitucions();
			
			this.connexion.commit();
			
			datoconstitucionReturnGeneral.setConRetornoEstaProcesado(true);
			datoconstitucionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return datoconstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDatoConstitucionsEliminados() throws Exception {				
		
		List<DatoConstitucion> datoconstitucionsAux= new ArrayList<DatoConstitucion>();
		
		for(DatoConstitucion datoconstitucion:datoconstitucions) {
			if(!datoconstitucion.getIsDeleted()) {
				datoconstitucionsAux.add(datoconstitucion);
			}
		}
		
		datoconstitucions=datoconstitucionsAux;
	}
	
	public void quitarDatoConstitucionsNulos() throws Exception {				
		
		List<DatoConstitucion> datoconstitucionsAux= new ArrayList<DatoConstitucion>();
		
		for(DatoConstitucion datoconstitucion : this.datoconstitucions) {
			if(datoconstitucion==null) {
				datoconstitucionsAux.add(datoconstitucion);
			}
		}
		
		//this.datoconstitucions=datoconstitucionsAux;
		
		this.datoconstitucions.removeAll(datoconstitucionsAux);
	}
	
	public void getSetVersionRowDatoConstitucionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(datoconstitucion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((datoconstitucion.getIsDeleted() || (datoconstitucion.getIsChanged()&&!datoconstitucion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=datoconstitucionDataAccess.getSetVersionRowDatoConstitucion(connexion,datoconstitucion.getId());
				
				if(!datoconstitucion.getVersionRow().equals(timestamp)) {	
					datoconstitucion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				datoconstitucion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDatoConstitucion()throws Exception {	
		
		if(datoconstitucion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((datoconstitucion.getIsDeleted() || (datoconstitucion.getIsChanged()&&!datoconstitucion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=datoconstitucionDataAccess.getSetVersionRowDatoConstitucion(connexion,datoconstitucion.getId());
			
			try {							
				if(!datoconstitucion.getVersionRow().equals(timestamp)) {	
					datoconstitucion.setVersionRow(timestamp);
				}
				
				datoconstitucion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDatoConstitucionsWithConnection()throws Exception {	
		if(datoconstitucions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DatoConstitucion datoconstitucionAux:datoconstitucions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(datoconstitucionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datoconstitucionAux.getIsDeleted() || (datoconstitucionAux.getIsChanged()&&!datoconstitucionAux.getIsNew())) {
						
						timestamp=datoconstitucionDataAccess.getSetVersionRowDatoConstitucion(connexion,datoconstitucionAux.getId());
						
						if(!datoconstitucion.getVersionRow().equals(timestamp)) {	
							datoconstitucionAux.setVersionRow(timestamp);
						}
								
						datoconstitucionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDatoConstitucions()throws Exception {	
		if(datoconstitucions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DatoConstitucion datoconstitucionAux:datoconstitucions) {
					if(datoconstitucionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datoconstitucionAux.getIsDeleted() || (datoconstitucionAux.getIsChanged()&&!datoconstitucionAux.getIsNew())) {
						
						timestamp=datoconstitucionDataAccess.getSetVersionRowDatoConstitucion(connexion,datoconstitucionAux.getId());
						
						if(!datoconstitucionAux.getVersionRow().equals(timestamp)) {	
							datoconstitucionAux.setVersionRow(timestamp);
						}
						
													
						datoconstitucionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DatoConstitucionParameterReturnGeneral cargarCombosLoteForeignKeyDatoConstitucionWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoCompania) throws Exception {
		DatoConstitucionParameterReturnGeneral  datoconstitucionReturnGeneral =new DatoConstitucionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-cargarCombosLoteForeignKeyDatoConstitucionWithConnection");connexion.begin();
			
			datoconstitucionReturnGeneral =new DatoConstitucionParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			datoconstitucionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoCompania> tipocompaniasForeignKey=new ArrayList<TipoCompania>();
			TipoCompaniaLogic tipocompaniaLogic=new TipoCompaniaLogic();
			tipocompaniaLogic.setConnexion(this.connexion);
			tipocompaniaLogic.getTipoCompaniaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCompania.equals("NONE")) {
				tipocompaniaLogic.getTodosTipoCompanias(finalQueryGlobalTipoCompania,new Pagination());
				tipocompaniasForeignKey=tipocompaniaLogic.getTipoCompanias();
			}

			datoconstitucionReturnGeneral.settipocompaniasForeignKey(tipocompaniasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return datoconstitucionReturnGeneral;
	}
	
	public DatoConstitucionParameterReturnGeneral cargarCombosLoteForeignKeyDatoConstitucion(String finalQueryGlobalCliente,String finalQueryGlobalTipoCompania) throws Exception {
		DatoConstitucionParameterReturnGeneral  datoconstitucionReturnGeneral =new DatoConstitucionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			datoconstitucionReturnGeneral =new DatoConstitucionParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			datoconstitucionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoCompania> tipocompaniasForeignKey=new ArrayList<TipoCompania>();
			TipoCompaniaLogic tipocompaniaLogic=new TipoCompaniaLogic();
			tipocompaniaLogic.setConnexion(this.connexion);
			tipocompaniaLogic.getTipoCompaniaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCompania.equals("NONE")) {
				tipocompaniaLogic.getTodosTipoCompanias(finalQueryGlobalTipoCompania,new Pagination());
				tipocompaniasForeignKey=tipocompaniaLogic.getTipoCompanias();
			}

			datoconstitucionReturnGeneral.settipocompaniasForeignKey(tipocompaniasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return datoconstitucionReturnGeneral;
	}
	
	
	public void deepLoad(DatoConstitucion datoconstitucion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DatoConstitucionLogicAdditional.updateDatoConstitucionToGet(datoconstitucion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datoconstitucion.setCliente(datoconstitucionDataAccess.getCliente(connexion,datoconstitucion));
		datoconstitucion.setTipoCompania(datoconstitucionDataAccess.getTipoCompania(connexion,datoconstitucion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				datoconstitucion.setCliente(datoconstitucionDataAccess.getCliente(connexion,datoconstitucion));
				continue;
			}

			if(clas.clas.equals(TipoCompania.class)) {
				datoconstitucion.setTipoCompania(datoconstitucionDataAccess.getTipoCompania(connexion,datoconstitucion));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoconstitucion.setCliente(datoconstitucionDataAccess.getCliente(connexion,datoconstitucion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCompania.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoconstitucion.setTipoCompania(datoconstitucionDataAccess.getTipoCompania(connexion,datoconstitucion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datoconstitucion.setCliente(datoconstitucionDataAccess.getCliente(connexion,datoconstitucion));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(datoconstitucion.getCliente(),isDeep,deepLoadType,clases);
				
		datoconstitucion.setTipoCompania(datoconstitucionDataAccess.getTipoCompania(connexion,datoconstitucion));
		TipoCompaniaLogic tipocompaniaLogic= new TipoCompaniaLogic(connexion);
		tipocompaniaLogic.deepLoad(datoconstitucion.getTipoCompania(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				datoconstitucion.setCliente(datoconstitucionDataAccess.getCliente(connexion,datoconstitucion));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(datoconstitucion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCompania.class)) {
				datoconstitucion.setTipoCompania(datoconstitucionDataAccess.getTipoCompania(connexion,datoconstitucion));
				TipoCompaniaLogic tipocompaniaLogic= new TipoCompaniaLogic(connexion);
				tipocompaniaLogic.deepLoad(datoconstitucion.getTipoCompania(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoconstitucion.setCliente(datoconstitucionDataAccess.getCliente(connexion,datoconstitucion));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(datoconstitucion.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCompania.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoconstitucion.setTipoCompania(datoconstitucionDataAccess.getTipoCompania(connexion,datoconstitucion));
			TipoCompaniaLogic tipocompaniaLogic= new TipoCompaniaLogic(connexion);
			tipocompaniaLogic.deepLoad(datoconstitucion.getTipoCompania(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DatoConstitucion datoconstitucion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DatoConstitucionLogicAdditional.updateDatoConstitucionToSave(datoconstitucion,this.arrDatoGeneral);
			
DatoConstitucionDataAccess.save(datoconstitucion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(datoconstitucion.getCliente(),connexion);

		TipoCompaniaDataAccess.save(datoconstitucion.getTipoCompania(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(datoconstitucion.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCompania.class)) {
				TipoCompaniaDataAccess.save(datoconstitucion.getTipoCompania(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(datoconstitucion.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(datoconstitucion.getCliente(),isDeep,deepLoadType,clases);
				

		TipoCompaniaDataAccess.save(datoconstitucion.getTipoCompania(),connexion);
		TipoCompaniaLogic tipocompaniaLogic= new TipoCompaniaLogic(connexion);
		tipocompaniaLogic.deepLoad(datoconstitucion.getTipoCompania(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(datoconstitucion.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(datoconstitucion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCompania.class)) {
				TipoCompaniaDataAccess.save(datoconstitucion.getTipoCompania(),connexion);
				TipoCompaniaLogic tipocompaniaLogic= new TipoCompaniaLogic(connexion);
				tipocompaniaLogic.deepSave(datoconstitucion.getTipoCompania(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DatoConstitucion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(datoconstitucion);
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
			this.deepLoad(this.datoconstitucion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DatoConstitucion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(datoconstitucions!=null) {
				for(DatoConstitucion datoconstitucion:datoconstitucions) {
					this.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(datoconstitucions);
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
			if(datoconstitucions!=null) {
				for(DatoConstitucion datoconstitucion:datoconstitucions) {
					this.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(datoconstitucions);
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
			this.getNewConnexionToDeep(DatoConstitucion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(datoconstitucion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DatoConstitucion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(datoconstitucions!=null) {
				for(DatoConstitucion datoconstitucion:datoconstitucions) {
					this.deepSave(datoconstitucion,isDeep,deepLoadType,clases);
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
			if(datoconstitucions!=null) {
				for(DatoConstitucion datoconstitucion:datoconstitucions) {
					this.deepSave(datoconstitucion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDatoConstitucionsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,DatoConstitucionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoConstitucionsFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,DatoConstitucionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoConstitucionsFK_IdValorClienteCompaniaWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientecompania)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoConstitucion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCompania= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCompania.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientecompania,DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCompania);

			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteCompania","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoConstitucionsFK_IdValorClienteCompania(String sFinalQuery,Pagination pagination,Long idvalorclientecompania)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCompania= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCompania.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientecompania,DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCompania);

			DatoConstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteCompania","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(this.datoconstitucions);
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
			if(DatoConstitucionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoConstitucionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DatoConstitucion datoconstitucion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DatoConstitucionConstantesFunciones.ISCONAUDITORIA) {
				if(datoconstitucion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoConstitucionDataAccess.TABLENAME, datoconstitucion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoConstitucionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoConstitucionLogic.registrarAuditoriaDetallesDatoConstitucion(connexion,datoconstitucion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(datoconstitucion.getIsDeleted()) {
					/*if(!datoconstitucion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DatoConstitucionDataAccess.TABLENAME, datoconstitucion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DatoConstitucionLogic.registrarAuditoriaDetallesDatoConstitucion(connexion,datoconstitucion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoConstitucionDataAccess.TABLENAME, datoconstitucion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(datoconstitucion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoConstitucionDataAccess.TABLENAME, datoconstitucion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoConstitucionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoConstitucionLogic.registrarAuditoriaDetallesDatoConstitucion(connexion,datoconstitucion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDatoConstitucion(Connexion connexion,DatoConstitucion datoconstitucion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getidcliente().equals(datoconstitucion.getDatoConstitucionOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getidcliente()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getidcliente().toString();
				}
				if(datoconstitucion.getidcliente()!=null)
				{
					strValorNuevo=datoconstitucion.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getidvalorclientecompania().equals(datoconstitucion.getDatoConstitucionOriginal().getidvalorclientecompania()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getidvalorclientecompania()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getidvalorclientecompania().toString();
				}
				if(datoconstitucion.getidvalorclientecompania()!=null)
				{
					strValorNuevo=datoconstitucion.getidvalorclientecompania().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getdireccion().equals(datoconstitucion.getDatoConstitucionOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getdireccion()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getdireccion();
				}
				if(datoconstitucion.getdireccion()!=null)
				{
					strValorNuevo=datoconstitucion.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getfechaconstitucion().equals(datoconstitucion.getDatoConstitucionOriginal().getfechaconstitucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getfechaconstitucion()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getfechaconstitucion().toString();
				}
				if(datoconstitucion.getfechaconstitucion()!=null)
				{
					strValorNuevo=datoconstitucion.getfechaconstitucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.FECHACONSTITUCION,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getcapitalsuscrito().equals(datoconstitucion.getDatoConstitucionOriginal().getcapitalsuscrito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getcapitalsuscrito()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getcapitalsuscrito().toString();
				}
				if(datoconstitucion.getcapitalsuscrito()!=null)
				{
					strValorNuevo=datoconstitucion.getcapitalsuscrito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.CAPITALSUSCRITO,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getplazofiniquito().equals(datoconstitucion.getDatoConstitucionOriginal().getplazofiniquito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getplazofiniquito()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getplazofiniquito().toString();
				}
				if(datoconstitucion.getplazofiniquito()!=null)
				{
					strValorNuevo=datoconstitucion.getplazofiniquito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.PLAZOFINIQUITO,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getreservalegal().equals(datoconstitucion.getDatoConstitucionOriginal().getreservalegal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getreservalegal()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getreservalegal().toString();
				}
				if(datoconstitucion.getreservalegal()!=null)
				{
					strValorNuevo=datoconstitucion.getreservalegal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.RESERVALEGAL,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getfechaestatuto().equals(datoconstitucion.getDatoConstitucionOriginal().getfechaestatuto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getfechaestatuto()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getfechaestatuto().toString();
				}
				if(datoconstitucion.getfechaestatuto()!=null)
				{
					strValorNuevo=datoconstitucion.getfechaestatuto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.FECHAESTATUTO,strValorActual,strValorNuevo);
			}	
			
			if(datoconstitucion.getIsNew()||!datoconstitucion.getesactivo().equals(datoconstitucion.getDatoConstitucionOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoconstitucion.getDatoConstitucionOriginal().getesactivo()!=null)
				{
					strValorActual=datoconstitucion.getDatoConstitucionOriginal().getesactivo().toString();
				}
				if(datoconstitucion.getesactivo()!=null)
				{
					strValorNuevo=datoconstitucion.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoConstitucionConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDatoConstitucionRelacionesWithConnection(DatoConstitucion datoconstitucion) throws Exception {

		if(!datoconstitucion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoConstitucionRelacionesBase(datoconstitucion,true);
		}
	}

	public void saveDatoConstitucionRelaciones(DatoConstitucion datoconstitucion)throws Exception {

		if(!datoconstitucion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoConstitucionRelacionesBase(datoconstitucion,false);
		}
	}

	public void saveDatoConstitucionRelacionesBase(DatoConstitucion datoconstitucion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DatoConstitucion-saveRelacionesWithConnection");}
	

			this.setDatoConstitucion(datoconstitucion);

			if(DatoConstitucionLogicAdditional.validarSaveRelaciones(datoconstitucion,this)) {

				DatoConstitucionLogicAdditional.updateRelacionesToSave(datoconstitucion,this);

				if((datoconstitucion.getIsNew()||datoconstitucion.getIsChanged())&&!datoconstitucion.getIsDeleted()) {
					this.saveDatoConstitucion();
					this.saveDatoConstitucionRelacionesDetalles();

				} else if(datoconstitucion.getIsDeleted()) {
					this.saveDatoConstitucionRelacionesDetalles();
					this.saveDatoConstitucion();
				}

				DatoConstitucionLogicAdditional.updateRelacionesToSaveAfter(datoconstitucion,this);

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
	
	
	private void saveDatoConstitucionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDatoConstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoConstitucionConstantesFunciones.getClassesForeignKeysOfDatoConstitucion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoConstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoConstitucionConstantesFunciones.getClassesRelationshipsOfDatoConstitucion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
