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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.CiudadConstantesFunciones;
import com.bydan.erp.seguridad.util.CiudadParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.CiudadParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Ciudad;
import com.bydan.erp.seguridad.business.logic.CiudadLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class CiudadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CiudadLogic.class);
	
	protected CiudadDataAccess ciudadDataAccess; 	
	protected Ciudad ciudad;
	protected List<Ciudad> ciudads;
	protected Object ciudadObject;	
	protected List<Object> ciudadsObject;
	
	public static ClassValidator<Ciudad> ciudadValidator = new ClassValidator<Ciudad>(Ciudad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CiudadLogicAdditional ciudadLogicAdditional=null;
	
	public CiudadLogicAdditional getCiudadLogicAdditional() {
		return this.ciudadLogicAdditional;
	}
	
	public void setCiudadLogicAdditional(CiudadLogicAdditional ciudadLogicAdditional) {
		try {
			this.ciudadLogicAdditional=ciudadLogicAdditional;
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
	
	
	
	
	public  CiudadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.ciudadDataAccess = new CiudadDataAccess();
			
			this.ciudads= new ArrayList<Ciudad>();
			this.ciudad= new Ciudad();
			
			this.ciudadObject=new Object();
			this.ciudadsObject=new ArrayList<Object>();
				
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
			
			this.ciudadDataAccess.setConnexionType(this.connexionType);
			this.ciudadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CiudadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.ciudadDataAccess = new CiudadDataAccess();
			this.ciudads= new ArrayList<Ciudad>();
			this.ciudad= new Ciudad();
			this.ciudadObject=new Object();
			this.ciudadsObject=new ArrayList<Object>();
			
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
			
			this.ciudadDataAccess.setConnexionType(this.connexionType);
			this.ciudadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Ciudad getCiudad() throws Exception {	
		CiudadLogicAdditional.checkCiudadToGet(ciudad,this.datosCliente,this.arrDatoGeneral);
		CiudadLogicAdditional.updateCiudadToGet(ciudad,this.arrDatoGeneral);
		
		return ciudad;
	}
		
	public void setCiudad(Ciudad newCiudad) {
		this.ciudad = newCiudad;
	}
	
	public CiudadDataAccess getCiudadDataAccess() {
		return ciudadDataAccess;
	}
	
	public void setCiudadDataAccess(CiudadDataAccess newciudadDataAccess) {
		this.ciudadDataAccess = newciudadDataAccess;
	}
	
	public List<Ciudad> getCiudads() throws Exception {		
		this.quitarCiudadsNulos();
		
		CiudadLogicAdditional.checkCiudadToGets(ciudads,this.datosCliente,this.arrDatoGeneral);
		
		for (Ciudad ciudadLocal: ciudads ) {
			CiudadLogicAdditional.updateCiudadToGet(ciudadLocal,this.arrDatoGeneral);
		}
		
		return ciudads;
	}
	
	public void setCiudads(List<Ciudad> newCiudads) {
		this.ciudads = newCiudads;
	}
	
	public Object getCiudadObject() {	
		this.ciudadObject=this.ciudadDataAccess.getEntityObject();
		return this.ciudadObject;
	}
		
	public void setCiudadObject(Object newCiudadObject) {
		this.ciudadObject = newCiudadObject;
	}
	
	public List<Object> getCiudadsObject() {		
		this.ciudadsObject=this.ciudadDataAccess.getEntitiesObject();
		return this.ciudadsObject;
	}
		
	public void setCiudadsObject(List<Object> newCiudadsObject) {
		this.ciudadsObject = newCiudadsObject;
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
		
		if(this.ciudadDataAccess!=null) {
			this.ciudadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			ciudadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			ciudadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ciudad = new  Ciudad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ciudad=ciudadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
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
		ciudad = new  Ciudad();
		  		  
        try {
			
			ciudad=ciudadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ciudad = new  Ciudad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ciudad=ciudadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
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
		ciudad = new  Ciudad();
		  		  
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
		ciudad = new  Ciudad();
		  		  
        try {
			
			ciudad=ciudadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ciudad = new  Ciudad();
		  		  
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
		ciudad = new  Ciudad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =ciudadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ciudad = new  Ciudad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=ciudadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ciudad = new  Ciudad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =ciudadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ciudad = new  Ciudad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=ciudadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ciudad = new  Ciudad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =ciudadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ciudad = new  Ciudad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=ciudadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ciudads = new  ArrayList<Ciudad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
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
		ciudads = new  ArrayList<Ciudad>();
		  		  
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
		ciudads = new  ArrayList<Ciudad>();
		  		  
        try {			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		ciudads = new  ArrayList<Ciudad>();
		  		  
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
		ciudads = new  ArrayList<Ciudad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
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
		ciudads = new  ArrayList<Ciudad>();
		  		  
        try {
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
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
		ciudads = new  ArrayList<Ciudad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
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
		ciudads = new  ArrayList<Ciudad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ciudad = new  Ciudad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudad=ciudadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCiudad(ciudad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
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
		ciudad = new  Ciudad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudad=ciudadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCiudad(ciudad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ciudads = new  ArrayList<Ciudad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
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
		ciudads = new  ArrayList<Ciudad>();
		  		  
        try {
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCiudadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		ciudads = new  ArrayList<Ciudad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getTodosCiudadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
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
	
	public  void  getTodosCiudads(String sFinalQuery,Pagination pagination)throws Exception {
		ciudads = new  ArrayList<Ciudad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCiudad(ciudads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCiudad(Ciudad ciudad) throws Exception {
		Boolean estaValidado=false;
		
		if(ciudad.getIsNew() || ciudad.getIsChanged()) { 
			this.invalidValues = ciudadValidator.getInvalidValues(ciudad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ciudad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCiudad(List<Ciudad> Ciudads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Ciudad ciudadLocal:ciudads) {				
			estaValidadoObjeto=this.validarGuardarCiudad(ciudadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCiudad(List<Ciudad> Ciudads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCiudad(ciudads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCiudad(Ciudad Ciudad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCiudad(ciudad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Ciudad ciudad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ciudad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CiudadConstantesFunciones.getCiudadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ciudad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CiudadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CiudadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCiudadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-saveCiudadWithConnection");connexion.begin();			
			
			CiudadLogicAdditional.checkCiudadToSave(this.ciudad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CiudadLogicAdditional.updateCiudadToSave(this.ciudad,this.arrDatoGeneral);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ciudad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCiudad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCiudad(this.ciudad)) {
				CiudadDataAccess.save(this.ciudad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CiudadLogicAdditional.checkCiudadToSaveAfter(this.ciudad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCiudad();
			
			connexion.commit();			
			
			if(this.ciudad.getIsDeleted()) {
				this.ciudad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCiudad()throws Exception {	
		try {	
			
			CiudadLogicAdditional.checkCiudadToSave(this.ciudad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CiudadLogicAdditional.updateCiudadToSave(this.ciudad,this.arrDatoGeneral);
			
			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ciudad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCiudad(this.ciudad)) {			
				CiudadDataAccess.save(this.ciudad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CiudadLogicAdditional.checkCiudadToSaveAfter(this.ciudad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ciudad.getIsDeleted()) {
				this.ciudad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCiudadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-saveCiudadsWithConnection");connexion.begin();			
			
			CiudadLogicAdditional.checkCiudadToSaves(ciudads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCiudads();
			
			Boolean validadoTodosCiudad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Ciudad ciudadLocal:ciudads) {		
				if(ciudadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CiudadLogicAdditional.updateCiudadToSave(ciudadLocal,this.arrDatoGeneral);
	        	
				CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ciudadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCiudad(ciudadLocal)) {
					CiudadDataAccess.save(ciudadLocal, connexion);				
				} else {
					validadoTodosCiudad=false;
				}
			}
			
			if(!validadoTodosCiudad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CiudadLogicAdditional.checkCiudadToSavesAfter(ciudads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCiudads();
			
			connexion.commit();		
			
			this.quitarCiudadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCiudads()throws Exception {				
		 try {	
			CiudadLogicAdditional.checkCiudadToSaves(ciudads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCiudad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Ciudad ciudadLocal:ciudads) {				
				if(ciudadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CiudadLogicAdditional.updateCiudadToSave(ciudadLocal,this.arrDatoGeneral);
	        	
				CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ciudadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCiudad(ciudadLocal)) {				
					CiudadDataAccess.save(ciudadLocal, connexion);				
				} else {
					validadoTodosCiudad=false;
				}
			}
			
			if(!validadoTodosCiudad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CiudadLogicAdditional.checkCiudadToSavesAfter(ciudads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCiudadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CiudadParameterReturnGeneral procesarAccionCiudads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Ciudad> ciudads,CiudadParameterReturnGeneral ciudadParameterGeneral)throws Exception {
		 try {	
			CiudadParameterReturnGeneral ciudadReturnGeneral=new CiudadParameterReturnGeneral();
	
			CiudadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ciudads,ciudadParameterGeneral,ciudadReturnGeneral);
			
			return ciudadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CiudadParameterReturnGeneral procesarAccionCiudadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Ciudad> ciudads,CiudadParameterReturnGeneral ciudadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-procesarAccionCiudadsWithConnection");connexion.begin();			
			
			CiudadParameterReturnGeneral ciudadReturnGeneral=new CiudadParameterReturnGeneral();
	
			CiudadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ciudads,ciudadParameterGeneral,ciudadReturnGeneral);
			
			this.connexion.commit();
			
			return ciudadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CiudadParameterReturnGeneral procesarEventosCiudads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Ciudad> ciudads,Ciudad ciudad,CiudadParameterReturnGeneral ciudadParameterGeneral,Boolean isEsNuevoCiudad,ArrayList<Classe> clases)throws Exception {
		 try {	
			CiudadParameterReturnGeneral ciudadReturnGeneral=new CiudadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ciudadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CiudadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ciudads,ciudad,ciudadParameterGeneral,ciudadReturnGeneral,isEsNuevoCiudad,clases);
			
			return ciudadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CiudadParameterReturnGeneral procesarEventosCiudadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Ciudad> ciudads,Ciudad ciudad,CiudadParameterReturnGeneral ciudadParameterGeneral,Boolean isEsNuevoCiudad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-procesarEventosCiudadsWithConnection");connexion.begin();			
			
			CiudadParameterReturnGeneral ciudadReturnGeneral=new CiudadParameterReturnGeneral();
	
			ciudadReturnGeneral.setCiudad(ciudad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ciudadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CiudadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ciudads,ciudad,ciudadParameterGeneral,ciudadReturnGeneral,isEsNuevoCiudad,clases);
			
			this.connexion.commit();
			
			return ciudadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CiudadParameterReturnGeneral procesarImportacionCiudadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CiudadParameterReturnGeneral ciudadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-procesarImportacionCiudadsWithConnection");connexion.begin();			
			
			CiudadParameterReturnGeneral ciudadReturnGeneral=new CiudadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.ciudads=new ArrayList<Ciudad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ciudad=new Ciudad();
				
				
				if(conColumnasBase) {this.ciudad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ciudad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.ciudad.setcodigo(arrColumnas[iColumn++]);
			this.ciudad.setnombre(arrColumnas[iColumn++]);
				
				this.ciudads.add(this.ciudad);
			}
			
			this.saveCiudads();
			
			this.connexion.commit();
			
			ciudadReturnGeneral.setConRetornoEstaProcesado(true);
			ciudadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return ciudadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCiudadsEliminados() throws Exception {				
		
		List<Ciudad> ciudadsAux= new ArrayList<Ciudad>();
		
		for(Ciudad ciudad:ciudads) {
			if(!ciudad.getIsDeleted()) {
				ciudadsAux.add(ciudad);
			}
		}
		
		ciudads=ciudadsAux;
	}
	
	public void quitarCiudadsNulos() throws Exception {				
		
		List<Ciudad> ciudadsAux= new ArrayList<Ciudad>();
		
		for(Ciudad ciudad : this.ciudads) {
			if(ciudad==null) {
				ciudadsAux.add(ciudad);
			}
		}
		
		//this.ciudads=ciudadsAux;
		
		this.ciudads.removeAll(ciudadsAux);
	}
	
	public void getSetVersionRowCiudadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ciudad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ciudad.getIsDeleted() || (ciudad.getIsChanged()&&!ciudad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=ciudadDataAccess.getSetVersionRowCiudad(connexion,ciudad.getId());
				
				if(!ciudad.getVersionRow().equals(timestamp)) {	
					ciudad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ciudad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCiudad()throws Exception {	
		
		if(ciudad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ciudad.getIsDeleted() || (ciudad.getIsChanged()&&!ciudad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=ciudadDataAccess.getSetVersionRowCiudad(connexion,ciudad.getId());
			
			try {							
				if(!ciudad.getVersionRow().equals(timestamp)) {	
					ciudad.setVersionRow(timestamp);
				}
				
				ciudad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCiudadsWithConnection()throws Exception {	
		if(ciudads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Ciudad ciudadAux:ciudads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(ciudadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ciudadAux.getIsDeleted() || (ciudadAux.getIsChanged()&&!ciudadAux.getIsNew())) {
						
						timestamp=ciudadDataAccess.getSetVersionRowCiudad(connexion,ciudadAux.getId());
						
						if(!ciudad.getVersionRow().equals(timestamp)) {	
							ciudadAux.setVersionRow(timestamp);
						}
								
						ciudadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCiudads()throws Exception {	
		if(ciudads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Ciudad ciudadAux:ciudads) {
					if(ciudadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ciudadAux.getIsDeleted() || (ciudadAux.getIsChanged()&&!ciudadAux.getIsNew())) {
						
						timestamp=ciudadDataAccess.getSetVersionRowCiudad(connexion,ciudadAux.getId());
						
						if(!ciudadAux.getVersionRow().equals(timestamp)) {	
							ciudadAux.setVersionRow(timestamp);
						}
						
													
						ciudadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CiudadParameterReturnGeneral cargarCombosLoteForeignKeyCiudadWithConnection(String finalQueryGlobalPais,String finalQueryGlobalProvincia) throws Exception {
		CiudadParameterReturnGeneral  ciudadReturnGeneral =new CiudadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-cargarCombosLoteForeignKeyCiudadWithConnection");connexion.begin();
			
			ciudadReturnGeneral =new CiudadParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			ciudadReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			ciudadReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return ciudadReturnGeneral;
	}
	
	public CiudadParameterReturnGeneral cargarCombosLoteForeignKeyCiudad(String finalQueryGlobalPais,String finalQueryGlobalProvincia) throws Exception {
		CiudadParameterReturnGeneral  ciudadReturnGeneral =new CiudadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			ciudadReturnGeneral =new CiudadParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			ciudadReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			ciudadReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return ciudadReturnGeneral;
	}
	
	
	public void deepLoad(Ciudad ciudad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CiudadLogicAdditional.updateCiudadToGet(ciudad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ciudad.setPais(ciudadDataAccess.getPais(connexion,ciudad));
		ciudad.setProvincia(ciudadDataAccess.getProvincia(connexion,ciudad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				ciudad.setPais(ciudadDataAccess.getPais(connexion,ciudad));
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ciudad.setProvincia(ciudadDataAccess.getProvincia(connexion,ciudad));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ciudad.setPais(ciudadDataAccess.getPais(connexion,ciudad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ciudad.setProvincia(ciudadDataAccess.getProvincia(connexion,ciudad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ciudad.setPais(ciudadDataAccess.getPais(connexion,ciudad));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(ciudad.getPais(),isDeep,deepLoadType,clases);
				
		ciudad.setProvincia(ciudadDataAccess.getProvincia(connexion,ciudad));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(ciudad.getProvincia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				ciudad.setPais(ciudadDataAccess.getPais(connexion,ciudad));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(ciudad.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ciudad.setProvincia(ciudadDataAccess.getProvincia(connexion,ciudad));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(ciudad.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ciudad.setPais(ciudadDataAccess.getPais(connexion,ciudad));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(ciudad.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ciudad.setProvincia(ciudadDataAccess.getProvincia(connexion,ciudad));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(ciudad.getProvincia(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Ciudad ciudad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CiudadLogicAdditional.updateCiudadToSave(ciudad,this.arrDatoGeneral);
			
CiudadDataAccess.save(ciudad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(ciudad.getPais(),connexion);

		ProvinciaDataAccess.save(ciudad.getProvincia(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(ciudad.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(ciudad.getProvincia(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(ciudad.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(ciudad.getPais(),isDeep,deepLoadType,clases);
				

		ProvinciaDataAccess.save(ciudad.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(ciudad.getProvincia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(ciudad.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(ciudad.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(ciudad.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(ciudad.getProvincia(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Ciudad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ciudad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(ciudad);
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
			this.deepLoad(this.ciudad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Ciudad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(ciudads!=null) {
				for(Ciudad ciudad:ciudads) {
					this.deepLoad(ciudad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(ciudads);
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
			if(ciudads!=null) {
				for(Ciudad ciudad:ciudads) {
					this.deepLoad(ciudad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(ciudads);
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
			this.getNewConnexionToDeep(Ciudad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ciudad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Ciudad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(ciudads!=null) {
				for(Ciudad ciudad:ciudads) {
					this.deepSave(ciudad,isDeep,deepLoadType,clases);
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
			if(ciudads!=null) {
				for(Ciudad ciudad:ciudads) {
					this.deepSave(ciudad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCiudadsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CiudadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCiudadsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CiudadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCiudadsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,CiudadConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCiudadsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,CiudadConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCiudadsFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,CiudadConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCiudadsFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,CiudadConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			CiudadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCiudadPorIdPaisPorNombreWithConnection(Long id_pais,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ciudad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,CiudadConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,CiudadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ciudad=ciudadDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCiudadPorIdPaisPorNombre(Long id_pais,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,CiudadConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,CiudadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ciudad=ciudadDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.ciudad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(this.ciudad);
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
			if(CiudadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CiudadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Ciudad ciudad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CiudadConstantesFunciones.ISCONAUDITORIA) {
				if(ciudad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CiudadDataAccess.TABLENAME, ciudad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CiudadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CiudadLogic.registrarAuditoriaDetallesCiudad(connexion,ciudad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ciudad.getIsDeleted()) {
					/*if(!ciudad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CiudadDataAccess.TABLENAME, ciudad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CiudadLogic.registrarAuditoriaDetallesCiudad(connexion,ciudad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CiudadDataAccess.TABLENAME, ciudad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ciudad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CiudadDataAccess.TABLENAME, ciudad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CiudadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CiudadLogic.registrarAuditoriaDetallesCiudad(connexion,ciudad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCiudad(Connexion connexion,Ciudad ciudad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ciudad.getIsNew()||!ciudad.getid_pais().equals(ciudad.getCiudadOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ciudad.getCiudadOriginal().getid_pais()!=null)
				{
					strValorActual=ciudad.getCiudadOriginal().getid_pais().toString();
				}
				if(ciudad.getid_pais()!=null)
				{
					strValorNuevo=ciudad.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CiudadConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(ciudad.getIsNew()||!ciudad.getid_provincia().equals(ciudad.getCiudadOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ciudad.getCiudadOriginal().getid_provincia()!=null)
				{
					strValorActual=ciudad.getCiudadOriginal().getid_provincia().toString();
				}
				if(ciudad.getid_provincia()!=null)
				{
					strValorNuevo=ciudad.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CiudadConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(ciudad.getIsNew()||!ciudad.getcodigo().equals(ciudad.getCiudadOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ciudad.getCiudadOriginal().getcodigo()!=null)
				{
					strValorActual=ciudad.getCiudadOriginal().getcodigo();
				}
				if(ciudad.getcodigo()!=null)
				{
					strValorNuevo=ciudad.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CiudadConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(ciudad.getIsNew()||!ciudad.getnombre().equals(ciudad.getCiudadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ciudad.getCiudadOriginal().getnombre()!=null)
				{
					strValorActual=ciudad.getCiudadOriginal().getnombre();
				}
				if(ciudad.getnombre()!=null)
				{
					strValorNuevo=ciudad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CiudadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCiudadRelacionesWithConnection(Ciudad ciudad) throws Exception {

		if(!ciudad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCiudadRelacionesBase(ciudad,true);
		}
	}

	public void saveCiudadRelaciones(Ciudad ciudad)throws Exception {

		if(!ciudad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCiudadRelacionesBase(ciudad,false);
		}
	}

	public void saveCiudadRelacionesBase(Ciudad ciudad,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Ciudad-saveRelacionesWithConnection");}
	

			this.setCiudad(ciudad);

			if(CiudadLogicAdditional.validarSaveRelaciones(ciudad,this)) {

				CiudadLogicAdditional.updateRelacionesToSave(ciudad,this);

				if((ciudad.getIsNew()||ciudad.getIsChanged())&&!ciudad.getIsDeleted()) {
					this.saveCiudad();
					this.saveCiudadRelacionesDetalles();

				} else if(ciudad.getIsDeleted()) {
					this.saveCiudadRelacionesDetalles();
					this.saveCiudad();
				}

				CiudadLogicAdditional.updateRelacionesToSaveAfter(ciudad,this);

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
	
	
	private void saveCiudadRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCiudad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CiudadConstantesFunciones.getClassesForeignKeysOfCiudad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCiudad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CiudadConstantesFunciones.getClassesRelationshipsOfCiudad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
