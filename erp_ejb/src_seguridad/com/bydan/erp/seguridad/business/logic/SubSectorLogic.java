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
import com.bydan.erp.seguridad.util.SubSectorConstantesFunciones;
import com.bydan.erp.seguridad.util.SubSectorParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SubSectorParameterGeneral;
import com.bydan.erp.seguridad.business.entity.SubSector;
import com.bydan.erp.seguridad.business.logic.SubSectorLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class SubSectorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SubSectorLogic.class);
	
	protected SubSectorDataAccess subsectorDataAccess; 	
	protected SubSector subsector;
	protected List<SubSector> subsectors;
	protected Object subsectorObject;	
	protected List<Object> subsectorsObject;
	
	public static ClassValidator<SubSector> subsectorValidator = new ClassValidator<SubSector>(SubSector.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SubSectorLogicAdditional subsectorLogicAdditional=null;
	
	public SubSectorLogicAdditional getSubSectorLogicAdditional() {
		return this.subsectorLogicAdditional;
	}
	
	public void setSubSectorLogicAdditional(SubSectorLogicAdditional subsectorLogicAdditional) {
		try {
			this.subsectorLogicAdditional=subsectorLogicAdditional;
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
	
	
	
	
	public  SubSectorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.subsectorDataAccess = new SubSectorDataAccess();
			
			this.subsectors= new ArrayList<SubSector>();
			this.subsector= new SubSector();
			
			this.subsectorObject=new Object();
			this.subsectorsObject=new ArrayList<Object>();
				
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
			
			this.subsectorDataAccess.setConnexionType(this.connexionType);
			this.subsectorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SubSectorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.subsectorDataAccess = new SubSectorDataAccess();
			this.subsectors= new ArrayList<SubSector>();
			this.subsector= new SubSector();
			this.subsectorObject=new Object();
			this.subsectorsObject=new ArrayList<Object>();
			
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
			
			this.subsectorDataAccess.setConnexionType(this.connexionType);
			this.subsectorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SubSector getSubSector() throws Exception {	
		SubSectorLogicAdditional.checkSubSectorToGet(subsector,this.datosCliente,this.arrDatoGeneral);
		SubSectorLogicAdditional.updateSubSectorToGet(subsector,this.arrDatoGeneral);
		
		return subsector;
	}
		
	public void setSubSector(SubSector newSubSector) {
		this.subsector = newSubSector;
	}
	
	public SubSectorDataAccess getSubSectorDataAccess() {
		return subsectorDataAccess;
	}
	
	public void setSubSectorDataAccess(SubSectorDataAccess newsubsectorDataAccess) {
		this.subsectorDataAccess = newsubsectorDataAccess;
	}
	
	public List<SubSector> getSubSectors() throws Exception {		
		this.quitarSubSectorsNulos();
		
		SubSectorLogicAdditional.checkSubSectorToGets(subsectors,this.datosCliente,this.arrDatoGeneral);
		
		for (SubSector subsectorLocal: subsectors ) {
			SubSectorLogicAdditional.updateSubSectorToGet(subsectorLocal,this.arrDatoGeneral);
		}
		
		return subsectors;
	}
	
	public void setSubSectors(List<SubSector> newSubSectors) {
		this.subsectors = newSubSectors;
	}
	
	public Object getSubSectorObject() {	
		this.subsectorObject=this.subsectorDataAccess.getEntityObject();
		return this.subsectorObject;
	}
		
	public void setSubSectorObject(Object newSubSectorObject) {
		this.subsectorObject = newSubSectorObject;
	}
	
	public List<Object> getSubSectorsObject() {		
		this.subsectorsObject=this.subsectorDataAccess.getEntitiesObject();
		return this.subsectorsObject;
	}
		
	public void setSubSectorsObject(List<Object> newSubSectorsObject) {
		this.subsectorsObject = newSubSectorsObject;
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
		
		if(this.subsectorDataAccess!=null) {
			this.subsectorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			subsectorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			subsectorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		subsector = new  SubSector();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subsector=subsectorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subsector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsector);
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
		subsector = new  SubSector();
		  		  
        try {
			
			subsector=subsectorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subsector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		subsector = new  SubSector();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subsector=subsectorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subsector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsector);
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
		subsector = new  SubSector();
		  		  
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
		subsector = new  SubSector();
		  		  
        try {
			
			subsector=subsectorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subsector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		subsector = new  SubSector();
		  		  
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
		subsector = new  SubSector();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =subsectorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subsector = new  SubSector();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=subsectorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subsector = new  SubSector();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =subsectorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subsector = new  SubSector();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=subsectorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subsector = new  SubSector();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =subsectorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subsector = new  SubSector();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=subsectorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subsectors = new  ArrayList<SubSector>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
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
		subsectors = new  ArrayList<SubSector>();
		  		  
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
		subsectors = new  ArrayList<SubSector>();
		  		  
        try {			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		subsectors = new  ArrayList<SubSector>();
		  		  
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
		subsectors = new  ArrayList<SubSector>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
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
		subsectors = new  ArrayList<SubSector>();
		  		  
        try {
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
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
		subsectors = new  ArrayList<SubSector>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
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
		subsectors = new  ArrayList<SubSector>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		subsector = new  SubSector();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsector=subsectorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubSector(subsector);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsector);
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
		subsector = new  SubSector();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsector=subsectorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubSector(subsector);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subsectors = new  ArrayList<SubSector>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
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
		subsectors = new  ArrayList<SubSector>();
		  		  
        try {
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSubSectorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		subsectors = new  ArrayList<SubSector>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getTodosSubSectorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
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
	
	public  void  getTodosSubSectors(String sFinalQuery,Pagination pagination)throws Exception {
		subsectors = new  ArrayList<SubSector>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subsectors=subsectorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubSector(subsectors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSubSector(SubSector subsector) throws Exception {
		Boolean estaValidado=false;
		
		if(subsector.getIsNew() || subsector.getIsChanged()) { 
			this.invalidValues = subsectorValidator.getInvalidValues(subsector);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(subsector);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSubSector(List<SubSector> SubSectors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SubSector subsectorLocal:subsectors) {				
			estaValidadoObjeto=this.validarGuardarSubSector(subsectorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSubSector(List<SubSector> SubSectors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubSector(subsectors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSubSector(SubSector SubSector) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubSector(subsector)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SubSector subsector) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+subsector.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SubSectorConstantesFunciones.getSubSectorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"subsector","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SubSectorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SubSectorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSubSectorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-saveSubSectorWithConnection");connexion.begin();			
			
			SubSectorLogicAdditional.checkSubSectorToSave(this.subsector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubSectorLogicAdditional.updateSubSectorToSave(this.subsector,this.arrDatoGeneral);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subsector,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSubSector();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubSector(this.subsector)) {
				SubSectorDataAccess.save(this.subsector, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.subsector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubSectorLogicAdditional.checkSubSectorToSaveAfter(this.subsector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubSector();
			
			connexion.commit();			
			
			if(this.subsector.getIsDeleted()) {
				this.subsector=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSubSector()throws Exception {	
		try {	
			
			SubSectorLogicAdditional.checkSubSectorToSave(this.subsector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubSectorLogicAdditional.updateSubSectorToSave(this.subsector,this.arrDatoGeneral);
			
			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subsector,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubSector(this.subsector)) {			
				SubSectorDataAccess.save(this.subsector, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.subsector,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubSectorLogicAdditional.checkSubSectorToSaveAfter(this.subsector,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.subsector.getIsDeleted()) {
				this.subsector=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSubSectorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-saveSubSectorsWithConnection");connexion.begin();			
			
			SubSectorLogicAdditional.checkSubSectorToSaves(subsectors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSubSectors();
			
			Boolean validadoTodosSubSector=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubSector subsectorLocal:subsectors) {		
				if(subsectorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubSectorLogicAdditional.updateSubSectorToSave(subsectorLocal,this.arrDatoGeneral);
	        	
				SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subsectorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubSector(subsectorLocal)) {
					SubSectorDataAccess.save(subsectorLocal, connexion);				
				} else {
					validadoTodosSubSector=false;
				}
			}
			
			if(!validadoTodosSubSector) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubSectorLogicAdditional.checkSubSectorToSavesAfter(subsectors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubSectors();
			
			connexion.commit();		
			
			this.quitarSubSectorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSubSectors()throws Exception {				
		 try {	
			SubSectorLogicAdditional.checkSubSectorToSaves(subsectors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSubSector=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubSector subsectorLocal:subsectors) {				
				if(subsectorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubSectorLogicAdditional.updateSubSectorToSave(subsectorLocal,this.arrDatoGeneral);
	        	
				SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subsectorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubSector(subsectorLocal)) {				
					SubSectorDataAccess.save(subsectorLocal, connexion);				
				} else {
					validadoTodosSubSector=false;
				}
			}
			
			if(!validadoTodosSubSector) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubSectorLogicAdditional.checkSubSectorToSavesAfter(subsectors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSubSectorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubSectorParameterReturnGeneral procesarAccionSubSectors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubSector> subsectors,SubSectorParameterReturnGeneral subsectorParameterGeneral)throws Exception {
		 try {	
			SubSectorParameterReturnGeneral subsectorReturnGeneral=new SubSectorParameterReturnGeneral();
	
			SubSectorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subsectors,subsectorParameterGeneral,subsectorReturnGeneral);
			
			return subsectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubSectorParameterReturnGeneral procesarAccionSubSectorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubSector> subsectors,SubSectorParameterReturnGeneral subsectorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-procesarAccionSubSectorsWithConnection");connexion.begin();			
			
			SubSectorParameterReturnGeneral subsectorReturnGeneral=new SubSectorParameterReturnGeneral();
	
			SubSectorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subsectors,subsectorParameterGeneral,subsectorReturnGeneral);
			
			this.connexion.commit();
			
			return subsectorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubSectorParameterReturnGeneral procesarEventosSubSectors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubSector> subsectors,SubSector subsector,SubSectorParameterReturnGeneral subsectorParameterGeneral,Boolean isEsNuevoSubSector,ArrayList<Classe> clases)throws Exception {
		 try {	
			SubSectorParameterReturnGeneral subsectorReturnGeneral=new SubSectorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subsectorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubSectorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subsectors,subsector,subsectorParameterGeneral,subsectorReturnGeneral,isEsNuevoSubSector,clases);
			
			return subsectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SubSectorParameterReturnGeneral procesarEventosSubSectorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubSector> subsectors,SubSector subsector,SubSectorParameterReturnGeneral subsectorParameterGeneral,Boolean isEsNuevoSubSector,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-procesarEventosSubSectorsWithConnection");connexion.begin();			
			
			SubSectorParameterReturnGeneral subsectorReturnGeneral=new SubSectorParameterReturnGeneral();
	
			subsectorReturnGeneral.setSubSector(subsector);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subsectorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubSectorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subsectors,subsector,subsectorParameterGeneral,subsectorReturnGeneral,isEsNuevoSubSector,clases);
			
			this.connexion.commit();
			
			return subsectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubSectorParameterReturnGeneral procesarImportacionSubSectorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SubSectorParameterReturnGeneral subsectorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-procesarImportacionSubSectorsWithConnection");connexion.begin();			
			
			SubSectorParameterReturnGeneral subsectorReturnGeneral=new SubSectorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.subsectors=new ArrayList<SubSector>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.subsector=new SubSector();
				
				
				if(conColumnasBase) {this.subsector.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.subsector.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.subsector.setcodigo(arrColumnas[iColumn++]);
				this.subsector.setnombre(arrColumnas[iColumn++]);
			this.subsector.setdescripcion(arrColumnas[iColumn++]);
				
				this.subsectors.add(this.subsector);
			}
			
			this.saveSubSectors();
			
			this.connexion.commit();
			
			subsectorReturnGeneral.setConRetornoEstaProcesado(true);
			subsectorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return subsectorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSubSectorsEliminados() throws Exception {				
		
		List<SubSector> subsectorsAux= new ArrayList<SubSector>();
		
		for(SubSector subsector:subsectors) {
			if(!subsector.getIsDeleted()) {
				subsectorsAux.add(subsector);
			}
		}
		
		subsectors=subsectorsAux;
	}
	
	public void quitarSubSectorsNulos() throws Exception {				
		
		List<SubSector> subsectorsAux= new ArrayList<SubSector>();
		
		for(SubSector subsector : this.subsectors) {
			if(subsector==null) {
				subsectorsAux.add(subsector);
			}
		}
		
		//this.subsectors=subsectorsAux;
		
		this.subsectors.removeAll(subsectorsAux);
	}
	
	public void getSetVersionRowSubSectorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(subsector.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((subsector.getIsDeleted() || (subsector.getIsChanged()&&!subsector.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=subsectorDataAccess.getSetVersionRowSubSector(connexion,subsector.getId());
				
				if(!subsector.getVersionRow().equals(timestamp)) {	
					subsector.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				subsector.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSubSector()throws Exception {	
		
		if(subsector.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((subsector.getIsDeleted() || (subsector.getIsChanged()&&!subsector.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=subsectorDataAccess.getSetVersionRowSubSector(connexion,subsector.getId());
			
			try {							
				if(!subsector.getVersionRow().equals(timestamp)) {	
					subsector.setVersionRow(timestamp);
				}
				
				subsector.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSubSectorsWithConnection()throws Exception {	
		if(subsectors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SubSector subsectorAux:subsectors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(subsectorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subsectorAux.getIsDeleted() || (subsectorAux.getIsChanged()&&!subsectorAux.getIsNew())) {
						
						timestamp=subsectorDataAccess.getSetVersionRowSubSector(connexion,subsectorAux.getId());
						
						if(!subsector.getVersionRow().equals(timestamp)) {	
							subsectorAux.setVersionRow(timestamp);
						}
								
						subsectorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSubSectors()throws Exception {	
		if(subsectors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SubSector subsectorAux:subsectors) {
					if(subsectorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subsectorAux.getIsDeleted() || (subsectorAux.getIsChanged()&&!subsectorAux.getIsNew())) {
						
						timestamp=subsectorDataAccess.getSetVersionRowSubSector(connexion,subsectorAux.getId());
						
						if(!subsectorAux.getVersionRow().equals(timestamp)) {	
							subsectorAux.setVersionRow(timestamp);
						}
						
													
						subsectorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SubSectorParameterReturnGeneral cargarCombosLoteForeignKeySubSectorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSector) throws Exception {
		SubSectorParameterReturnGeneral  subsectorReturnGeneral =new SubSectorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-cargarCombosLoteForeignKeySubSectorWithConnection");connexion.begin();
			
			subsectorReturnGeneral =new SubSectorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subsectorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sector> sectorsForeignKey=new ArrayList<Sector>();
			SectorLogic sectorLogic=new SectorLogic();
			sectorLogic.setConnexion(this.connexion);
			sectorLogic.getSectorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSector.equals("NONE")) {
				sectorLogic.getTodosSectors(finalQueryGlobalSector,new Pagination());
				sectorsForeignKey=sectorLogic.getSectors();
			}

			subsectorReturnGeneral.setsectorsForeignKey(sectorsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return subsectorReturnGeneral;
	}
	
	public SubSectorParameterReturnGeneral cargarCombosLoteForeignKeySubSector(String finalQueryGlobalEmpresa,String finalQueryGlobalSector) throws Exception {
		SubSectorParameterReturnGeneral  subsectorReturnGeneral =new SubSectorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			subsectorReturnGeneral =new SubSectorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subsectorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sector> sectorsForeignKey=new ArrayList<Sector>();
			SectorLogic sectorLogic=new SectorLogic();
			sectorLogic.setConnexion(this.connexion);
			sectorLogic.getSectorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSector.equals("NONE")) {
				sectorLogic.getTodosSectors(finalQueryGlobalSector,new Pagination());
				sectorsForeignKey=sectorLogic.getSectors();
			}

			subsectorReturnGeneral.setsectorsForeignKey(sectorsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return subsectorReturnGeneral;
	}
	
	
	public void deepLoad(SubSector subsector,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SubSectorLogicAdditional.updateSubSectorToGet(subsector,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subsector.setEmpresa(subsectorDataAccess.getEmpresa(connexion,subsector));
		subsector.setSector(subsectorDataAccess.getSector(connexion,subsector));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subsector.setEmpresa(subsectorDataAccess.getEmpresa(connexion,subsector));
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				subsector.setSector(subsectorDataAccess.getSector(connexion,subsector));
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
			subsector.setEmpresa(subsectorDataAccess.getEmpresa(connexion,subsector));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sector.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subsector.setSector(subsectorDataAccess.getSector(connexion,subsector));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subsector.setEmpresa(subsectorDataAccess.getEmpresa(connexion,subsector));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subsector.getEmpresa(),isDeep,deepLoadType,clases);
				
		subsector.setSector(subsectorDataAccess.getSector(connexion,subsector));
		SectorLogic sectorLogic= new SectorLogic(connexion);
		sectorLogic.deepLoad(subsector.getSector(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subsector.setEmpresa(subsectorDataAccess.getEmpresa(connexion,subsector));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(subsector.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				subsector.setSector(subsectorDataAccess.getSector(connexion,subsector));
				SectorLogic sectorLogic= new SectorLogic(connexion);
				sectorLogic.deepLoad(subsector.getSector(),isDeep,deepLoadType,clases);				
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
			subsector.setEmpresa(subsectorDataAccess.getEmpresa(connexion,subsector));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(subsector.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sector.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subsector.setSector(subsectorDataAccess.getSector(connexion,subsector));
			SectorLogic sectorLogic= new SectorLogic(connexion);
			sectorLogic.deepLoad(subsector.getSector(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SubSector subsector,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SubSectorLogicAdditional.updateSubSectorToSave(subsector,this.arrDatoGeneral);
			
SubSectorDataAccess.save(subsector, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subsector.getEmpresa(),connexion);

		SectorDataAccess.save(subsector.getSector(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subsector.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				SectorDataAccess.save(subsector.getSector(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subsector.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subsector.getEmpresa(),isDeep,deepLoadType,clases);
				

		SectorDataAccess.save(subsector.getSector(),connexion);
		SectorLogic sectorLogic= new SectorLogic(connexion);
		sectorLogic.deepLoad(subsector.getSector(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subsector.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(subsector.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sector.class)) {
				SectorDataAccess.save(subsector.getSector(),connexion);
				SectorLogic sectorLogic= new SectorLogic(connexion);
				sectorLogic.deepSave(subsector.getSector(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(SubSector.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(subsector,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(subsector);
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
			this.deepLoad(this.subsector,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsector);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SubSector.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(subsectors!=null) {
				for(SubSector subsector:subsectors) {
					this.deepLoad(subsector,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(subsectors);
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
			if(subsectors!=null) {
				for(SubSector subsector:subsectors) {
					this.deepLoad(subsector,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(subsectors);
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
			this.getNewConnexionToDeep(SubSector.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(subsector,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SubSector.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(subsectors!=null) {
				for(SubSector subsector:subsectors) {
					this.deepSave(subsector,isDeep,deepLoadType,clases);
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
			if(subsectors!=null) {
				for(SubSector subsector:subsectors) {
					this.deepSave(subsector,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSubSectorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubSectorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subsectors=subsectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubSectorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubSectorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subsectors=subsectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubSectorsFK_IdSectorWithConnection(String sFinalQuery,Pagination pagination,Long id_sector)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubSector.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSector= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSector.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sector,SubSectorConstantesFunciones.IDSECTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSector);

			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSector","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subsectors=subsectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubSectorsFK_IdSector(String sFinalQuery,Pagination pagination,Long id_sector)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSector= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSector.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sector,SubSectorConstantesFunciones.IDSECTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSector);

			SubSectorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSector","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subsectors=subsectorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubSectorConstantesFunciones.refrescarForeignKeysDescripcionesSubSector(this.subsectors);
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
			if(SubSectorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SubSectorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SubSector subsector,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SubSectorConstantesFunciones.ISCONAUDITORIA) {
				if(subsector.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubSectorDataAccess.TABLENAME, subsector.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubSectorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubSectorLogic.registrarAuditoriaDetallesSubSector(connexion,subsector,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(subsector.getIsDeleted()) {
					/*if(!subsector.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SubSectorDataAccess.TABLENAME, subsector.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SubSectorLogic.registrarAuditoriaDetallesSubSector(connexion,subsector,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubSectorDataAccess.TABLENAME, subsector.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(subsector.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubSectorDataAccess.TABLENAME, subsector.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubSectorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubSectorLogic.registrarAuditoriaDetallesSubSector(connexion,subsector,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSubSector(Connexion connexion,SubSector subsector)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(subsector.getIsNew()||!subsector.getid_empresa().equals(subsector.getSubSectorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subsector.getSubSectorOriginal().getid_empresa()!=null)
				{
					strValorActual=subsector.getSubSectorOriginal().getid_empresa().toString();
				}
				if(subsector.getid_empresa()!=null)
				{
					strValorNuevo=subsector.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubSectorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(subsector.getIsNew()||!subsector.getid_sector().equals(subsector.getSubSectorOriginal().getid_sector()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subsector.getSubSectorOriginal().getid_sector()!=null)
				{
					strValorActual=subsector.getSubSectorOriginal().getid_sector().toString();
				}
				if(subsector.getid_sector()!=null)
				{
					strValorNuevo=subsector.getid_sector().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubSectorConstantesFunciones.IDSECTOR,strValorActual,strValorNuevo);
			}	
			
			if(subsector.getIsNew()||!subsector.getcodigo().equals(subsector.getSubSectorOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subsector.getSubSectorOriginal().getcodigo()!=null)
				{
					strValorActual=subsector.getSubSectorOriginal().getcodigo();
				}
				if(subsector.getcodigo()!=null)
				{
					strValorNuevo=subsector.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubSectorConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(subsector.getIsNew()||!subsector.getnombre().equals(subsector.getSubSectorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subsector.getSubSectorOriginal().getnombre()!=null)
				{
					strValorActual=subsector.getSubSectorOriginal().getnombre();
				}
				if(subsector.getnombre()!=null)
				{
					strValorNuevo=subsector.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubSectorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(subsector.getIsNew()||!subsector.getdescripcion().equals(subsector.getSubSectorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subsector.getSubSectorOriginal().getdescripcion()!=null)
				{
					strValorActual=subsector.getSubSectorOriginal().getdescripcion();
				}
				if(subsector.getdescripcion()!=null)
				{
					strValorNuevo=subsector.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubSectorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSubSectorRelacionesWithConnection(SubSector subsector) throws Exception {

		if(!subsector.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubSectorRelacionesBase(subsector,true);
		}
	}

	public void saveSubSectorRelaciones(SubSector subsector)throws Exception {

		if(!subsector.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubSectorRelacionesBase(subsector,false);
		}
	}

	public void saveSubSectorRelacionesBase(SubSector subsector,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SubSector-saveRelacionesWithConnection");}
	

			this.setSubSector(subsector);

			if(SubSectorLogicAdditional.validarSaveRelaciones(subsector,this)) {

				SubSectorLogicAdditional.updateRelacionesToSave(subsector,this);

				if((subsector.getIsNew()||subsector.getIsChanged())&&!subsector.getIsDeleted()) {
					this.saveSubSector();
					this.saveSubSectorRelacionesDetalles();

				} else if(subsector.getIsDeleted()) {
					this.saveSubSectorRelacionesDetalles();
					this.saveSubSector();
				}

				SubSectorLogicAdditional.updateRelacionesToSaveAfter(subsector,this);

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
	
	
	private void saveSubSectorRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSubSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubSectorConstantesFunciones.getClassesForeignKeysOfSubSector(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubSectorConstantesFunciones.getClassesRelationshipsOfSubSector(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
