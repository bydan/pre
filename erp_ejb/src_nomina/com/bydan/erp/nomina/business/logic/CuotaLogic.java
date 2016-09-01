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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.CuotaConstantesFunciones;
import com.bydan.erp.nomina.util.CuotaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CuotaParameterGeneral;
import com.bydan.erp.nomina.business.entity.Cuota;
import com.bydan.erp.nomina.business.logic.CuotaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class CuotaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuotaLogic.class);
	
	protected CuotaDataAccess cuotaDataAccess; 	
	protected Cuota cuota;
	protected List<Cuota> cuotas;
	protected Object cuotaObject;	
	protected List<Object> cuotasObject;
	
	public static ClassValidator<Cuota> cuotaValidator = new ClassValidator<Cuota>(Cuota.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuotaLogicAdditional cuotaLogicAdditional=null;
	
	public CuotaLogicAdditional getCuotaLogicAdditional() {
		return this.cuotaLogicAdditional;
	}
	
	public void setCuotaLogicAdditional(CuotaLogicAdditional cuotaLogicAdditional) {
		try {
			this.cuotaLogicAdditional=cuotaLogicAdditional;
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
	
	
	
	
	public  CuotaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuotaDataAccess = new CuotaDataAccess();
			
			this.cuotas= new ArrayList<Cuota>();
			this.cuota= new Cuota();
			
			this.cuotaObject=new Object();
			this.cuotasObject=new ArrayList<Object>();
				
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
			
			this.cuotaDataAccess.setConnexionType(this.connexionType);
			this.cuotaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuotaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuotaDataAccess = new CuotaDataAccess();
			this.cuotas= new ArrayList<Cuota>();
			this.cuota= new Cuota();
			this.cuotaObject=new Object();
			this.cuotasObject=new ArrayList<Object>();
			
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
			
			this.cuotaDataAccess.setConnexionType(this.connexionType);
			this.cuotaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Cuota getCuota() throws Exception {	
		CuotaLogicAdditional.checkCuotaToGet(cuota,this.datosCliente,this.arrDatoGeneral);
		CuotaLogicAdditional.updateCuotaToGet(cuota,this.arrDatoGeneral);
		
		return cuota;
	}
		
	public void setCuota(Cuota newCuota) {
		this.cuota = newCuota;
	}
	
	public CuotaDataAccess getCuotaDataAccess() {
		return cuotaDataAccess;
	}
	
	public void setCuotaDataAccess(CuotaDataAccess newcuotaDataAccess) {
		this.cuotaDataAccess = newcuotaDataAccess;
	}
	
	public List<Cuota> getCuotas() throws Exception {		
		this.quitarCuotasNulos();
		
		CuotaLogicAdditional.checkCuotaToGets(cuotas,this.datosCliente,this.arrDatoGeneral);
		
		for (Cuota cuotaLocal: cuotas ) {
			CuotaLogicAdditional.updateCuotaToGet(cuotaLocal,this.arrDatoGeneral);
		}
		
		return cuotas;
	}
	
	public void setCuotas(List<Cuota> newCuotas) {
		this.cuotas = newCuotas;
	}
	
	public Object getCuotaObject() {	
		this.cuotaObject=this.cuotaDataAccess.getEntityObject();
		return this.cuotaObject;
	}
		
	public void setCuotaObject(Object newCuotaObject) {
		this.cuotaObject = newCuotaObject;
	}
	
	public List<Object> getCuotasObject() {		
		this.cuotasObject=this.cuotaDataAccess.getEntitiesObject();
		return this.cuotasObject;
	}
		
	public void setCuotasObject(List<Object> newCuotasObject) {
		this.cuotasObject = newCuotasObject;
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
		
		if(this.cuotaDataAccess!=null) {
			this.cuotaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuotaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuotaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuota = new  Cuota();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuota=cuotaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuota);
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
		cuota = new  Cuota();
		  		  
        try {
			
			cuota=cuotaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuota = new  Cuota();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuota=cuotaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuota);
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
		cuota = new  Cuota();
		  		  
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
		cuota = new  Cuota();
		  		  
        try {
			
			cuota=cuotaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuota = new  Cuota();
		  		  
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
		cuota = new  Cuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuotaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuota = new  Cuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuotaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuota = new  Cuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuotaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuota = new  Cuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuotaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuota = new  Cuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuotaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuota = new  Cuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuotaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuotas = new  ArrayList<Cuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
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
		cuotas = new  ArrayList<Cuota>();
		  		  
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
		cuotas = new  ArrayList<Cuota>();
		  		  
        try {			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuotas = new  ArrayList<Cuota>();
		  		  
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
		cuotas = new  ArrayList<Cuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
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
		cuotas = new  ArrayList<Cuota>();
		  		  
        try {
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
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
		cuotas = new  ArrayList<Cuota>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
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
		cuotas = new  ArrayList<Cuota>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuota = new  Cuota();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuota=cuotaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuota(cuota);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuota);
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
		cuota = new  Cuota();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuota=cuotaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuota(cuota);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuotas = new  ArrayList<Cuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
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
		cuotas = new  ArrayList<Cuota>();
		  		  
        try {
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuotasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuotas = new  ArrayList<Cuota>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getTodosCuotasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
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
	
	public  void  getTodosCuotas(String sFinalQuery,Pagination pagination)throws Exception {
		cuotas = new  ArrayList<Cuota>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuota(cuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuota(Cuota cuota) throws Exception {
		Boolean estaValidado=false;
		
		if(cuota.getIsNew() || cuota.getIsChanged()) { 
			this.invalidValues = cuotaValidator.getInvalidValues(cuota);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuota);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuota(List<Cuota> Cuotas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Cuota cuotaLocal:cuotas) {				
			estaValidadoObjeto=this.validarGuardarCuota(cuotaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuota(List<Cuota> Cuotas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuota(cuotas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuota(Cuota Cuota) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuota(cuota)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Cuota cuota) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuota.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuotaConstantesFunciones.getCuotaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuota","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuotaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuotaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuotaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-saveCuotaWithConnection");connexion.begin();			
			
			CuotaLogicAdditional.checkCuotaToSave(this.cuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuotaLogicAdditional.updateCuotaToSave(this.cuota,this.arrDatoGeneral);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuota,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuota();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuota(this.cuota)) {
				CuotaDataAccess.save(this.cuota, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuotaLogicAdditional.checkCuotaToSaveAfter(this.cuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuota();
			
			connexion.commit();			
			
			if(this.cuota.getIsDeleted()) {
				this.cuota=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuota()throws Exception {	
		try {	
			
			CuotaLogicAdditional.checkCuotaToSave(this.cuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuotaLogicAdditional.updateCuotaToSave(this.cuota,this.arrDatoGeneral);
			
			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuota,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuota(this.cuota)) {			
				CuotaDataAccess.save(this.cuota, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuotaLogicAdditional.checkCuotaToSaveAfter(this.cuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuota.getIsDeleted()) {
				this.cuota=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuotasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-saveCuotasWithConnection");connexion.begin();			
			
			CuotaLogicAdditional.checkCuotaToSaves(cuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuotas();
			
			Boolean validadoTodosCuota=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cuota cuotaLocal:cuotas) {		
				if(cuotaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuotaLogicAdditional.updateCuotaToSave(cuotaLocal,this.arrDatoGeneral);
	        	
				CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuotaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuota(cuotaLocal)) {
					CuotaDataAccess.save(cuotaLocal, connexion);				
				} else {
					validadoTodosCuota=false;
				}
			}
			
			if(!validadoTodosCuota) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuotaLogicAdditional.checkCuotaToSavesAfter(cuotas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuotas();
			
			connexion.commit();		
			
			this.quitarCuotasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuotas()throws Exception {				
		 try {	
			CuotaLogicAdditional.checkCuotaToSaves(cuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuota=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cuota cuotaLocal:cuotas) {				
				if(cuotaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuotaLogicAdditional.updateCuotaToSave(cuotaLocal,this.arrDatoGeneral);
	        	
				CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuotaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuota(cuotaLocal)) {				
					CuotaDataAccess.save(cuotaLocal, connexion);				
				} else {
					validadoTodosCuota=false;
				}
			}
			
			if(!validadoTodosCuota) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuotaLogicAdditional.checkCuotaToSavesAfter(cuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuotasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuotaParameterReturnGeneral procesarAccionCuotas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cuota> cuotas,CuotaParameterReturnGeneral cuotaParameterGeneral)throws Exception {
		 try {	
			CuotaParameterReturnGeneral cuotaReturnGeneral=new CuotaParameterReturnGeneral();
	
			CuotaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuotas,cuotaParameterGeneral,cuotaReturnGeneral);
			
			return cuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuotaParameterReturnGeneral procesarAccionCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cuota> cuotas,CuotaParameterReturnGeneral cuotaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-procesarAccionCuotasWithConnection");connexion.begin();			
			
			CuotaParameterReturnGeneral cuotaReturnGeneral=new CuotaParameterReturnGeneral();
	
			CuotaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuotas,cuotaParameterGeneral,cuotaReturnGeneral);
			
			this.connexion.commit();
			
			return cuotaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuotaParameterReturnGeneral procesarEventosCuotas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cuota> cuotas,Cuota cuota,CuotaParameterReturnGeneral cuotaParameterGeneral,Boolean isEsNuevoCuota,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuotaParameterReturnGeneral cuotaReturnGeneral=new CuotaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuotaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuotaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuotas,cuota,cuotaParameterGeneral,cuotaReturnGeneral,isEsNuevoCuota,clases);
			
			return cuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuotaParameterReturnGeneral procesarEventosCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cuota> cuotas,Cuota cuota,CuotaParameterReturnGeneral cuotaParameterGeneral,Boolean isEsNuevoCuota,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-procesarEventosCuotasWithConnection");connexion.begin();			
			
			CuotaParameterReturnGeneral cuotaReturnGeneral=new CuotaParameterReturnGeneral();
	
			cuotaReturnGeneral.setCuota(cuota);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuotaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuotaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuotas,cuota,cuotaParameterGeneral,cuotaReturnGeneral,isEsNuevoCuota,clases);
			
			this.connexion.commit();
			
			return cuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuotaParameterReturnGeneral procesarImportacionCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuotaParameterReturnGeneral cuotaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-procesarImportacionCuotasWithConnection");connexion.begin();			
			
			CuotaParameterReturnGeneral cuotaReturnGeneral=new CuotaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuotas=new ArrayList<Cuota>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuota=new Cuota();
				
				
				if(conColumnasBase) {this.cuota.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuota.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuota.setnumero_cuota(Integer.parseInt(arrColumnas[iColumn++]));
				this.cuota.setcapital(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuota.setinteres(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuota.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuota.setfecha_liquidacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuota.setmonto_ajuste(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuota.setinteres_ajuste(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuota.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.cuota.setdescripcion(arrColumnas[iColumn++]);
				
				this.cuotas.add(this.cuota);
			}
			
			this.saveCuotas();
			
			this.connexion.commit();
			
			cuotaReturnGeneral.setConRetornoEstaProcesado(true);
			cuotaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuotasEliminados() throws Exception {				
		
		List<Cuota> cuotasAux= new ArrayList<Cuota>();
		
		for(Cuota cuota:cuotas) {
			if(!cuota.getIsDeleted()) {
				cuotasAux.add(cuota);
			}
		}
		
		cuotas=cuotasAux;
	}
	
	public void quitarCuotasNulos() throws Exception {				
		
		List<Cuota> cuotasAux= new ArrayList<Cuota>();
		
		for(Cuota cuota : this.cuotas) {
			if(cuota==null) {
				cuotasAux.add(cuota);
			}
		}
		
		//this.cuotas=cuotasAux;
		
		this.cuotas.removeAll(cuotasAux);
	}
	
	public void getSetVersionRowCuotaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuota.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuota.getIsDeleted() || (cuota.getIsChanged()&&!cuota.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuotaDataAccess.getSetVersionRowCuota(connexion,cuota.getId());
				
				if(!cuota.getVersionRow().equals(timestamp)) {	
					cuota.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuota.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuota()throws Exception {	
		
		if(cuota.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuota.getIsDeleted() || (cuota.getIsChanged()&&!cuota.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuotaDataAccess.getSetVersionRowCuota(connexion,cuota.getId());
			
			try {							
				if(!cuota.getVersionRow().equals(timestamp)) {	
					cuota.setVersionRow(timestamp);
				}
				
				cuota.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuotasWithConnection()throws Exception {	
		if(cuotas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Cuota cuotaAux:cuotas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuotaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuotaAux.getIsDeleted() || (cuotaAux.getIsChanged()&&!cuotaAux.getIsNew())) {
						
						timestamp=cuotaDataAccess.getSetVersionRowCuota(connexion,cuotaAux.getId());
						
						if(!cuota.getVersionRow().equals(timestamp)) {	
							cuotaAux.setVersionRow(timestamp);
						}
								
						cuotaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuotas()throws Exception {	
		if(cuotas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Cuota cuotaAux:cuotas) {
					if(cuotaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuotaAux.getIsDeleted() || (cuotaAux.getIsChanged()&&!cuotaAux.getIsNew())) {
						
						timestamp=cuotaDataAccess.getSetVersionRowCuota(connexion,cuotaAux.getId());
						
						if(!cuotaAux.getVersionRow().equals(timestamp)) {	
							cuotaAux.setVersionRow(timestamp);
						}
						
													
						cuotaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuotaParameterReturnGeneral cargarCombosLoteForeignKeyCuotaWithConnection(String finalQueryGlobalPrestamo,String finalQueryGlobalEstadoCuota,String finalQueryGlobalDefiProvisionEmpleado) throws Exception {
		CuotaParameterReturnGeneral  cuotaReturnGeneral =new CuotaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuotaWithConnection");connexion.begin();
			
			cuotaReturnGeneral =new CuotaParameterReturnGeneral();
			
			

			List<Prestamo> prestamosForeignKey=new ArrayList<Prestamo>();
			PrestamoLogic prestamoLogic=new PrestamoLogic();
			prestamoLogic.setConnexion(this.connexion);
			prestamoLogic.getPrestamoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPrestamo.equals("NONE")) {
				prestamoLogic.getTodosPrestamos(finalQueryGlobalPrestamo,new Pagination());
				prestamosForeignKey=prestamoLogic.getPrestamos();
			}

			cuotaReturnGeneral.setprestamosForeignKey(prestamosForeignKey);


			List<EstadoCuota> estadocuotasForeignKey=new ArrayList<EstadoCuota>();
			EstadoCuotaLogic estadocuotaLogic=new EstadoCuotaLogic();
			estadocuotaLogic.setConnexion(this.connexion);
			estadocuotaLogic.getEstadoCuotaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCuota.equals("NONE")) {
				estadocuotaLogic.getTodosEstadoCuotas(finalQueryGlobalEstadoCuota,new Pagination());
				estadocuotasForeignKey=estadocuotaLogic.getEstadoCuotas();
			}

			cuotaReturnGeneral.setestadocuotasForeignKey(estadocuotasForeignKey);


			List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey=new ArrayList<DefiProvisionEmpleado>();
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic=new DefiProvisionEmpleadoLogic();
			defiprovisionempleadoLogic.setConnexion(this.connexion);
			defiprovisionempleadoLogic.getDefiProvisionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDefiProvisionEmpleado.equals("NONE")) {
				defiprovisionempleadoLogic.getTodosDefiProvisionEmpleados(finalQueryGlobalDefiProvisionEmpleado,new Pagination());
				defiprovisionempleadosForeignKey=defiprovisionempleadoLogic.getDefiProvisionEmpleados();
			}

			cuotaReturnGeneral.setdefiprovisionempleadosForeignKey(defiprovisionempleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuotaReturnGeneral;
	}
	
	public CuotaParameterReturnGeneral cargarCombosLoteForeignKeyCuota(String finalQueryGlobalPrestamo,String finalQueryGlobalEstadoCuota,String finalQueryGlobalDefiProvisionEmpleado) throws Exception {
		CuotaParameterReturnGeneral  cuotaReturnGeneral =new CuotaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuotaReturnGeneral =new CuotaParameterReturnGeneral();
			
			

			List<Prestamo> prestamosForeignKey=new ArrayList<Prestamo>();
			PrestamoLogic prestamoLogic=new PrestamoLogic();
			prestamoLogic.setConnexion(this.connexion);
			prestamoLogic.getPrestamoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPrestamo.equals("NONE")) {
				prestamoLogic.getTodosPrestamos(finalQueryGlobalPrestamo,new Pagination());
				prestamosForeignKey=prestamoLogic.getPrestamos();
			}

			cuotaReturnGeneral.setprestamosForeignKey(prestamosForeignKey);


			List<EstadoCuota> estadocuotasForeignKey=new ArrayList<EstadoCuota>();
			EstadoCuotaLogic estadocuotaLogic=new EstadoCuotaLogic();
			estadocuotaLogic.setConnexion(this.connexion);
			estadocuotaLogic.getEstadoCuotaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCuota.equals("NONE")) {
				estadocuotaLogic.getTodosEstadoCuotas(finalQueryGlobalEstadoCuota,new Pagination());
				estadocuotasForeignKey=estadocuotaLogic.getEstadoCuotas();
			}

			cuotaReturnGeneral.setestadocuotasForeignKey(estadocuotasForeignKey);


			List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey=new ArrayList<DefiProvisionEmpleado>();
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic=new DefiProvisionEmpleadoLogic();
			defiprovisionempleadoLogic.setConnexion(this.connexion);
			defiprovisionempleadoLogic.getDefiProvisionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDefiProvisionEmpleado.equals("NONE")) {
				defiprovisionempleadoLogic.getTodosDefiProvisionEmpleados(finalQueryGlobalDefiProvisionEmpleado,new Pagination());
				defiprovisionempleadosForeignKey=defiprovisionempleadoLogic.getDefiProvisionEmpleados();
			}

			cuotaReturnGeneral.setdefiprovisionempleadosForeignKey(defiprovisionempleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuotaReturnGeneral;
	}
	
	
	public void deepLoad(Cuota cuota,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuotaLogicAdditional.updateCuotaToGet(cuota,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuota.setPrestamo(cuotaDataAccess.getPrestamo(connexion,cuota));
		cuota.setEstadoCuota(cuotaDataAccess.getEstadoCuota(connexion,cuota));
		cuota.setDefiProvisionEmpleado(cuotaDataAccess.getDefiProvisionEmpleado(connexion,cuota));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				cuota.setPrestamo(cuotaDataAccess.getPrestamo(connexion,cuota));
				continue;
			}

			if(clas.clas.equals(EstadoCuota.class)) {
				cuota.setEstadoCuota(cuotaDataAccess.getEstadoCuota(connexion,cuota));
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				cuota.setDefiProvisionEmpleado(cuotaDataAccess.getDefiProvisionEmpleado(connexion,cuota));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuota.setPrestamo(cuotaDataAccess.getPrestamo(connexion,cuota));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCuota.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuota.setEstadoCuota(cuotaDataAccess.getEstadoCuota(connexion,cuota));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuota.setDefiProvisionEmpleado(cuotaDataAccess.getDefiProvisionEmpleado(connexion,cuota));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuota.setPrestamo(cuotaDataAccess.getPrestamo(connexion,cuota));
		PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
		prestamoLogic.deepLoad(cuota.getPrestamo(),isDeep,deepLoadType,clases);
				
		cuota.setEstadoCuota(cuotaDataAccess.getEstadoCuota(connexion,cuota));
		EstadoCuotaLogic estadocuotaLogic= new EstadoCuotaLogic(connexion);
		estadocuotaLogic.deepLoad(cuota.getEstadoCuota(),isDeep,deepLoadType,clases);
				
		cuota.setDefiProvisionEmpleado(cuotaDataAccess.getDefiProvisionEmpleado(connexion,cuota));
		DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
		defiprovisionempleadoLogic.deepLoad(cuota.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				cuota.setPrestamo(cuotaDataAccess.getPrestamo(connexion,cuota));
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepLoad(cuota.getPrestamo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCuota.class)) {
				cuota.setEstadoCuota(cuotaDataAccess.getEstadoCuota(connexion,cuota));
				EstadoCuotaLogic estadocuotaLogic= new EstadoCuotaLogic(connexion);
				estadocuotaLogic.deepLoad(cuota.getEstadoCuota(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				cuota.setDefiProvisionEmpleado(cuotaDataAccess.getDefiProvisionEmpleado(connexion,cuota));
				DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
				defiprovisionempleadoLogic.deepLoad(cuota.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuota.setPrestamo(cuotaDataAccess.getPrestamo(connexion,cuota));
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamoLogic.deepLoad(cuota.getPrestamo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCuota.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuota.setEstadoCuota(cuotaDataAccess.getEstadoCuota(connexion,cuota));
			EstadoCuotaLogic estadocuotaLogic= new EstadoCuotaLogic(connexion);
			estadocuotaLogic.deepLoad(cuota.getEstadoCuota(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuota.setDefiProvisionEmpleado(cuotaDataAccess.getDefiProvisionEmpleado(connexion,cuota));
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
			defiprovisionempleadoLogic.deepLoad(cuota.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Cuota cuota,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuotaLogicAdditional.updateCuotaToSave(cuota,this.arrDatoGeneral);
			
CuotaDataAccess.save(cuota, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PrestamoDataAccess.save(cuota.getPrestamo(),connexion);

		EstadoCuotaDataAccess.save(cuota.getEstadoCuota(),connexion);

		DefiProvisionEmpleadoDataAccess.save(cuota.getDefiProvisionEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				PrestamoDataAccess.save(cuota.getPrestamo(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCuota.class)) {
				EstadoCuotaDataAccess.save(cuota.getEstadoCuota(),connexion);
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				DefiProvisionEmpleadoDataAccess.save(cuota.getDefiProvisionEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PrestamoDataAccess.save(cuota.getPrestamo(),connexion);
		PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
		prestamoLogic.deepLoad(cuota.getPrestamo(),isDeep,deepLoadType,clases);
				

		EstadoCuotaDataAccess.save(cuota.getEstadoCuota(),connexion);
		EstadoCuotaLogic estadocuotaLogic= new EstadoCuotaLogic(connexion);
		estadocuotaLogic.deepLoad(cuota.getEstadoCuota(),isDeep,deepLoadType,clases);
				

		DefiProvisionEmpleadoDataAccess.save(cuota.getDefiProvisionEmpleado(),connexion);
		DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
		defiprovisionempleadoLogic.deepLoad(cuota.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				PrestamoDataAccess.save(cuota.getPrestamo(),connexion);
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepSave(cuota.getPrestamo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCuota.class)) {
				EstadoCuotaDataAccess.save(cuota.getEstadoCuota(),connexion);
				EstadoCuotaLogic estadocuotaLogic= new EstadoCuotaLogic(connexion);
				estadocuotaLogic.deepSave(cuota.getEstadoCuota(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				DefiProvisionEmpleadoDataAccess.save(cuota.getDefiProvisionEmpleado(),connexion);
				DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
				defiprovisionempleadoLogic.deepSave(cuota.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Cuota.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuota,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(cuota);
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
			this.deepLoad(this.cuota,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Cuota.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuotas!=null) {
				for(Cuota cuota:cuotas) {
					this.deepLoad(cuota,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(cuotas);
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
			if(cuotas!=null) {
				for(Cuota cuota:cuotas) {
					this.deepLoad(cuota,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(cuotas);
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
			this.getNewConnexionToDeep(Cuota.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuota,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Cuota.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuotas!=null) {
				for(Cuota cuota:cuotas) {
					this.deepSave(cuota,isDeep,deepLoadType,clases);
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
			if(cuotas!=null) {
				for(Cuota cuota:cuotas) {
					this.deepSave(cuota,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuotasFK_IdDefiProvisionEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_defi_provision_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDefiProvisionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDefiProvisionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_defi_provision_empleado,CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDefiProvisionEmpleado);

			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDefiProvisionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuotasFK_IdDefiProvisionEmpleado(String sFinalQuery,Pagination pagination,Long id_defi_provision_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDefiProvisionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDefiProvisionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_defi_provision_empleado,CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDefiProvisionEmpleado);

			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDefiProvisionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuotasFK_IdEstadoCuotaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_cuota)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCuota= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCuota.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_cuota,CuotaConstantesFunciones.IDESTADOCUOTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCuota);

			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCuota","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuotasFK_IdEstadoCuota(String sFinalQuery,Pagination pagination,Long id_estado_cuota)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCuota= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCuota.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_cuota,CuotaConstantesFunciones.IDESTADOCUOTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCuota);

			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCuota","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuotasFK_IdPrestamoWithConnection(String sFinalQuery,Pagination pagination,Long id_prestamo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cuota.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPrestamo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPrestamo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_prestamo,CuotaConstantesFunciones.IDPRESTAMO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPrestamo);

			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuotasFK_IdPrestamo(String sFinalQuery,Pagination pagination,Long id_prestamo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPrestamo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPrestamo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_prestamo,CuotaConstantesFunciones.IDPRESTAMO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPrestamo);

			CuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(this.cuotas);
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
			if(CuotaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuotaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Cuota cuota,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuotaConstantesFunciones.ISCONAUDITORIA) {
				if(cuota.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuotaDataAccess.TABLENAME, cuota.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuotaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuotaLogic.registrarAuditoriaDetallesCuota(connexion,cuota,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuota.getIsDeleted()) {
					/*if(!cuota.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuotaDataAccess.TABLENAME, cuota.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuotaLogic.registrarAuditoriaDetallesCuota(connexion,cuota,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuotaDataAccess.TABLENAME, cuota.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuota.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuotaDataAccess.TABLENAME, cuota.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuotaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuotaLogic.registrarAuditoriaDetallesCuota(connexion,cuota,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuota(Connexion connexion,Cuota cuota)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuota.getIsNew()||!cuota.getid_prestamo().equals(cuota.getCuotaOriginal().getid_prestamo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getid_prestamo()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getid_prestamo().toString();
				}
				if(cuota.getid_prestamo()!=null)
				{
					strValorNuevo=cuota.getid_prestamo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.IDPRESTAMO,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getid_estado_cuota().equals(cuota.getCuotaOriginal().getid_estado_cuota()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getid_estado_cuota()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getid_estado_cuota().toString();
				}
				if(cuota.getid_estado_cuota()!=null)
				{
					strValorNuevo=cuota.getid_estado_cuota().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.IDESTADOCUOTA,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getid_defi_provision_empleado().equals(cuota.getCuotaOriginal().getid_defi_provision_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getid_defi_provision_empleado()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getid_defi_provision_empleado().toString();
				}
				if(cuota.getid_defi_provision_empleado()!=null)
				{
					strValorNuevo=cuota.getid_defi_provision_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getnumero_cuota().equals(cuota.getCuotaOriginal().getnumero_cuota()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getnumero_cuota()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getnumero_cuota().toString();
				}
				if(cuota.getnumero_cuota()!=null)
				{
					strValorNuevo=cuota.getnumero_cuota().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.NUMEROCUOTA,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getcapital().equals(cuota.getCuotaOriginal().getcapital()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getcapital()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getcapital().toString();
				}
				if(cuota.getcapital()!=null)
				{
					strValorNuevo=cuota.getcapital().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.CAPITAL,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getinteres().equals(cuota.getCuotaOriginal().getinteres()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getinteres()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getinteres().toString();
				}
				if(cuota.getinteres()!=null)
				{
					strValorNuevo=cuota.getinteres().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.INTERES,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.gettotal().equals(cuota.getCuotaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().gettotal()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().gettotal().toString();
				}
				if(cuota.gettotal()!=null)
				{
					strValorNuevo=cuota.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getfecha_liquidacion().equals(cuota.getCuotaOriginal().getfecha_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getfecha_liquidacion()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getfecha_liquidacion().toString();
				}
				if(cuota.getfecha_liquidacion()!=null)
				{
					strValorNuevo=cuota.getfecha_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.FECHALIQUIDACION,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getmonto_ajuste().equals(cuota.getCuotaOriginal().getmonto_ajuste()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getmonto_ajuste()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getmonto_ajuste().toString();
				}
				if(cuota.getmonto_ajuste()!=null)
				{
					strValorNuevo=cuota.getmonto_ajuste().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.MONTOAJUSTE,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getinteres_ajuste().equals(cuota.getCuotaOriginal().getinteres_ajuste()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getinteres_ajuste()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getinteres_ajuste().toString();
				}
				if(cuota.getinteres_ajuste()!=null)
				{
					strValorNuevo=cuota.getinteres_ajuste().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.INTERESAJUSTE,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getfecha_vencimiento().equals(cuota.getCuotaOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getfecha_vencimiento().toString();
				}
				if(cuota.getfecha_vencimiento()!=null)
				{
					strValorNuevo=cuota.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(cuota.getIsNew()||!cuota.getdescripcion().equals(cuota.getCuotaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuota.getCuotaOriginal().getdescripcion()!=null)
				{
					strValorActual=cuota.getCuotaOriginal().getdescripcion();
				}
				if(cuota.getdescripcion()!=null)
				{
					strValorNuevo=cuota.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuotaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuotaRelacionesWithConnection(Cuota cuota) throws Exception {

		if(!cuota.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuotaRelacionesBase(cuota,true);
		}
	}

	public void saveCuotaRelaciones(Cuota cuota)throws Exception {

		if(!cuota.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuotaRelacionesBase(cuota,false);
		}
	}

	public void saveCuotaRelacionesBase(Cuota cuota,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Cuota-saveRelacionesWithConnection");}
	

			this.setCuota(cuota);

			if(CuotaLogicAdditional.validarSaveRelaciones(cuota,this)) {

				CuotaLogicAdditional.updateRelacionesToSave(cuota,this);

				if((cuota.getIsNew()||cuota.getIsChanged())&&!cuota.getIsDeleted()) {
					this.saveCuota();
					this.saveCuotaRelacionesDetalles();

				} else if(cuota.getIsDeleted()) {
					this.saveCuotaRelacionesDetalles();
					this.saveCuota();
				}

				CuotaLogicAdditional.updateRelacionesToSaveAfter(cuota,this);

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
	
	
	private void saveCuotaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuotaConstantesFunciones.getClassesForeignKeysOfCuota(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuotaConstantesFunciones.getClassesRelationshipsOfCuota(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
