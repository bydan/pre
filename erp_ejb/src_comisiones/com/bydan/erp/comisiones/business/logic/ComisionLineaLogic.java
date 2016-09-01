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
package com.bydan.erp.comisiones.business.logic;

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
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.comisiones.util.ComisionLineaConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionLineaParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionLineaParameterGeneral;
import com.bydan.erp.comisiones.business.entity.ComisionLinea;
import com.bydan.erp.comisiones.business.logic.ComisionLineaLogicAdditional;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.comisiones.business.entity.*;

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
public class ComisionLineaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ComisionLineaLogic.class);
	
	protected ComisionLineaDataAccess comisionlineaDataAccess; 	
	protected ComisionLinea comisionlinea;
	protected List<ComisionLinea> comisionlineas;
	protected Object comisionlineaObject;	
	protected List<Object> comisionlineasObject;
	
	public static ClassValidator<ComisionLinea> comisionlineaValidator = new ClassValidator<ComisionLinea>(ComisionLinea.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ComisionLineaLogicAdditional comisionlineaLogicAdditional=null;
	
	public ComisionLineaLogicAdditional getComisionLineaLogicAdditional() {
		return this.comisionlineaLogicAdditional;
	}
	
	public void setComisionLineaLogicAdditional(ComisionLineaLogicAdditional comisionlineaLogicAdditional) {
		try {
			this.comisionlineaLogicAdditional=comisionlineaLogicAdditional;
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
	
	
	
	
	public  ComisionLineaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.comisionlineaDataAccess = new ComisionLineaDataAccess();
			
			this.comisionlineas= new ArrayList<ComisionLinea>();
			this.comisionlinea= new ComisionLinea();
			
			this.comisionlineaObject=new Object();
			this.comisionlineasObject=new ArrayList<Object>();
				
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
			
			this.comisionlineaDataAccess.setConnexionType(this.connexionType);
			this.comisionlineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComisionLineaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.comisionlineaDataAccess = new ComisionLineaDataAccess();
			this.comisionlineas= new ArrayList<ComisionLinea>();
			this.comisionlinea= new ComisionLinea();
			this.comisionlineaObject=new Object();
			this.comisionlineasObject=new ArrayList<Object>();
			
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
			
			this.comisionlineaDataAccess.setConnexionType(this.connexionType);
			this.comisionlineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComisionLinea getComisionLinea() throws Exception {	
		ComisionLineaLogicAdditional.checkComisionLineaToGet(comisionlinea,this.datosCliente,this.arrDatoGeneral);
		ComisionLineaLogicAdditional.updateComisionLineaToGet(comisionlinea,this.arrDatoGeneral);
		
		return comisionlinea;
	}
		
	public void setComisionLinea(ComisionLinea newComisionLinea) {
		this.comisionlinea = newComisionLinea;
	}
	
	public ComisionLineaDataAccess getComisionLineaDataAccess() {
		return comisionlineaDataAccess;
	}
	
	public void setComisionLineaDataAccess(ComisionLineaDataAccess newcomisionlineaDataAccess) {
		this.comisionlineaDataAccess = newcomisionlineaDataAccess;
	}
	
	public List<ComisionLinea> getComisionLineas() throws Exception {		
		this.quitarComisionLineasNulos();
		
		ComisionLineaLogicAdditional.checkComisionLineaToGets(comisionlineas,this.datosCliente,this.arrDatoGeneral);
		
		for (ComisionLinea comisionlineaLocal: comisionlineas ) {
			ComisionLineaLogicAdditional.updateComisionLineaToGet(comisionlineaLocal,this.arrDatoGeneral);
		}
		
		return comisionlineas;
	}
	
	public void setComisionLineas(List<ComisionLinea> newComisionLineas) {
		this.comisionlineas = newComisionLineas;
	}
	
	public Object getComisionLineaObject() {	
		this.comisionlineaObject=this.comisionlineaDataAccess.getEntityObject();
		return this.comisionlineaObject;
	}
		
	public void setComisionLineaObject(Object newComisionLineaObject) {
		this.comisionlineaObject = newComisionLineaObject;
	}
	
	public List<Object> getComisionLineasObject() {		
		this.comisionlineasObject=this.comisionlineaDataAccess.getEntitiesObject();
		return this.comisionlineasObject;
	}
		
	public void setComisionLineasObject(List<Object> newComisionLineasObject) {
		this.comisionlineasObject = newComisionLineasObject;
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
		
		if(this.comisionlineaDataAccess!=null) {
			this.comisionlineaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			comisionlineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			comisionlineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		comisionlinea = new  ComisionLinea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionlinea=comisionlineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionlinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlinea);
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
		comisionlinea = new  ComisionLinea();
		  		  
        try {
			
			comisionlinea=comisionlineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionlinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisionlinea = new  ComisionLinea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionlinea=comisionlineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionlinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlinea);
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
		comisionlinea = new  ComisionLinea();
		  		  
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
		comisionlinea = new  ComisionLinea();
		  		  
        try {
			
			comisionlinea=comisionlineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionlinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		comisionlinea = new  ComisionLinea();
		  		  
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
		comisionlinea = new  ComisionLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =comisionlineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionlinea = new  ComisionLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=comisionlineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionlinea = new  ComisionLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =comisionlineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionlinea = new  ComisionLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=comisionlineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionlinea = new  ComisionLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =comisionlineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionlinea = new  ComisionLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=comisionlineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
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
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
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
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
        try {			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
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
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
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
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
        try {
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
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
		comisionlineas = new  ArrayList<ComisionLinea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
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
		comisionlineas = new  ArrayList<ComisionLinea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionlinea = new  ComisionLinea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlinea=comisionlineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlinea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlinea);
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
		comisionlinea = new  ComisionLinea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlinea=comisionlineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlinea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
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
		comisionlineas = new  ArrayList<ComisionLinea>();
		  		  
        try {
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComisionLineasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		comisionlineas = new  ArrayList<ComisionLinea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getTodosComisionLineasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
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
	
	public  void  getTodosComisionLineas(String sFinalQuery,Pagination pagination)throws Exception {
		comisionlineas = new  ArrayList<ComisionLinea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionLinea(comisionlineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarComisionLinea(ComisionLinea comisionlinea) throws Exception {
		Boolean estaValidado=false;
		
		if(comisionlinea.getIsNew() || comisionlinea.getIsChanged()) { 
			this.invalidValues = comisionlineaValidator.getInvalidValues(comisionlinea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(comisionlinea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarComisionLinea(List<ComisionLinea> ComisionLineas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ComisionLinea comisionlineaLocal:comisionlineas) {				
			estaValidadoObjeto=this.validarGuardarComisionLinea(comisionlineaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarComisionLinea(List<ComisionLinea> ComisionLineas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionLinea(comisionlineas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarComisionLinea(ComisionLinea ComisionLinea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionLinea(comisionlinea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ComisionLinea comisionlinea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+comisionlinea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ComisionLineaConstantesFunciones.getComisionLineaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"comisionlinea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ComisionLineaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ComisionLineaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveComisionLineaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-saveComisionLineaWithConnection");connexion.begin();			
			
			ComisionLineaLogicAdditional.checkComisionLineaToSave(this.comisionlinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionLineaLogicAdditional.updateComisionLineaToSave(this.comisionlinea,this.arrDatoGeneral);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionlinea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowComisionLinea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionLinea(this.comisionlinea)) {
				ComisionLineaDataAccess.save(this.comisionlinea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.comisionlinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionLineaLogicAdditional.checkComisionLineaToSaveAfter(this.comisionlinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionLinea();
			
			connexion.commit();			
			
			if(this.comisionlinea.getIsDeleted()) {
				this.comisionlinea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveComisionLinea()throws Exception {	
		try {	
			
			ComisionLineaLogicAdditional.checkComisionLineaToSave(this.comisionlinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionLineaLogicAdditional.updateComisionLineaToSave(this.comisionlinea,this.arrDatoGeneral);
			
			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionlinea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionLinea(this.comisionlinea)) {			
				ComisionLineaDataAccess.save(this.comisionlinea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.comisionlinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionLineaLogicAdditional.checkComisionLineaToSaveAfter(this.comisionlinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.comisionlinea.getIsDeleted()) {
				this.comisionlinea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComisionLineasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-saveComisionLineasWithConnection");connexion.begin();			
			
			ComisionLineaLogicAdditional.checkComisionLineaToSaves(comisionlineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowComisionLineas();
			
			Boolean validadoTodosComisionLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionLinea comisionlineaLocal:comisionlineas) {		
				if(comisionlineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionLineaLogicAdditional.updateComisionLineaToSave(comisionlineaLocal,this.arrDatoGeneral);
	        	
				ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionlineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionLinea(comisionlineaLocal)) {
					ComisionLineaDataAccess.save(comisionlineaLocal, connexion);				
				} else {
					validadoTodosComisionLinea=false;
				}
			}
			
			if(!validadoTodosComisionLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionLineaLogicAdditional.checkComisionLineaToSavesAfter(comisionlineas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionLineas();
			
			connexion.commit();		
			
			this.quitarComisionLineasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveComisionLineas()throws Exception {				
		 try {	
			ComisionLineaLogicAdditional.checkComisionLineaToSaves(comisionlineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosComisionLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionLinea comisionlineaLocal:comisionlineas) {				
				if(comisionlineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionLineaLogicAdditional.updateComisionLineaToSave(comisionlineaLocal,this.arrDatoGeneral);
	        	
				ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionlineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionLinea(comisionlineaLocal)) {				
					ComisionLineaDataAccess.save(comisionlineaLocal, connexion);				
				} else {
					validadoTodosComisionLinea=false;
				}
			}
			
			if(!validadoTodosComisionLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionLineaLogicAdditional.checkComisionLineaToSavesAfter(comisionlineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComisionLineasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionLineaParameterReturnGeneral procesarAccionComisionLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionLinea> comisionlineas,ComisionLineaParameterReturnGeneral comisionlineaParameterGeneral)throws Exception {
		 try {	
			ComisionLineaParameterReturnGeneral comisionlineaReturnGeneral=new ComisionLineaParameterReturnGeneral();
	
			ComisionLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionlineas,comisionlineaParameterGeneral,comisionlineaReturnGeneral);
			
			return comisionlineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionLineaParameterReturnGeneral procesarAccionComisionLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionLinea> comisionlineas,ComisionLineaParameterReturnGeneral comisionlineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-procesarAccionComisionLineasWithConnection");connexion.begin();			
			
			ComisionLineaParameterReturnGeneral comisionlineaReturnGeneral=new ComisionLineaParameterReturnGeneral();
	
			ComisionLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionlineas,comisionlineaParameterGeneral,comisionlineaReturnGeneral);
			
			this.connexion.commit();
			
			return comisionlineaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionLineaParameterReturnGeneral procesarEventosComisionLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionLinea> comisionlineas,ComisionLinea comisionlinea,ComisionLineaParameterReturnGeneral comisionlineaParameterGeneral,Boolean isEsNuevoComisionLinea,ArrayList<Classe> clases)throws Exception {
		 try {	
			ComisionLineaParameterReturnGeneral comisionlineaReturnGeneral=new ComisionLineaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionlineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionLineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionlineas,comisionlinea,comisionlineaParameterGeneral,comisionlineaReturnGeneral,isEsNuevoComisionLinea,clases);
			
			return comisionlineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ComisionLineaParameterReturnGeneral procesarEventosComisionLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionLinea> comisionlineas,ComisionLinea comisionlinea,ComisionLineaParameterReturnGeneral comisionlineaParameterGeneral,Boolean isEsNuevoComisionLinea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-procesarEventosComisionLineasWithConnection");connexion.begin();			
			
			ComisionLineaParameterReturnGeneral comisionlineaReturnGeneral=new ComisionLineaParameterReturnGeneral();
	
			comisionlineaReturnGeneral.setComisionLinea(comisionlinea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionlineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionLineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionlineas,comisionlinea,comisionlineaParameterGeneral,comisionlineaReturnGeneral,isEsNuevoComisionLinea,clases);
			
			this.connexion.commit();
			
			return comisionlineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionLineaParameterReturnGeneral procesarImportacionComisionLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ComisionLineaParameterReturnGeneral comisionlineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-procesarImportacionComisionLineasWithConnection");connexion.begin();			
			
			ComisionLineaParameterReturnGeneral comisionlineaReturnGeneral=new ComisionLineaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.comisionlineas=new ArrayList<ComisionLinea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.comisionlinea=new ComisionLinea();
				
				
				if(conColumnasBase) {this.comisionlinea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.comisionlinea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.comisionlinea.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisionlinea.setdescripcion(arrColumnas[iColumn++]);
				
				this.comisionlineas.add(this.comisionlinea);
			}
			
			this.saveComisionLineas();
			
			this.connexion.commit();
			
			comisionlineaReturnGeneral.setConRetornoEstaProcesado(true);
			comisionlineaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return comisionlineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComisionLineasEliminados() throws Exception {				
		
		List<ComisionLinea> comisionlineasAux= new ArrayList<ComisionLinea>();
		
		for(ComisionLinea comisionlinea:comisionlineas) {
			if(!comisionlinea.getIsDeleted()) {
				comisionlineasAux.add(comisionlinea);
			}
		}
		
		comisionlineas=comisionlineasAux;
	}
	
	public void quitarComisionLineasNulos() throws Exception {				
		
		List<ComisionLinea> comisionlineasAux= new ArrayList<ComisionLinea>();
		
		for(ComisionLinea comisionlinea : this.comisionlineas) {
			if(comisionlinea==null) {
				comisionlineasAux.add(comisionlinea);
			}
		}
		
		//this.comisionlineas=comisionlineasAux;
		
		this.comisionlineas.removeAll(comisionlineasAux);
	}
	
	public void getSetVersionRowComisionLineaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(comisionlinea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((comisionlinea.getIsDeleted() || (comisionlinea.getIsChanged()&&!comisionlinea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=comisionlineaDataAccess.getSetVersionRowComisionLinea(connexion,comisionlinea.getId());
				
				if(!comisionlinea.getVersionRow().equals(timestamp)) {	
					comisionlinea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				comisionlinea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionLinea()throws Exception {	
		
		if(comisionlinea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((comisionlinea.getIsDeleted() || (comisionlinea.getIsChanged()&&!comisionlinea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=comisionlineaDataAccess.getSetVersionRowComisionLinea(connexion,comisionlinea.getId());
			
			try {							
				if(!comisionlinea.getVersionRow().equals(timestamp)) {	
					comisionlinea.setVersionRow(timestamp);
				}
				
				comisionlinea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComisionLineasWithConnection()throws Exception {	
		if(comisionlineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ComisionLinea comisionlineaAux:comisionlineas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(comisionlineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionlineaAux.getIsDeleted() || (comisionlineaAux.getIsChanged()&&!comisionlineaAux.getIsNew())) {
						
						timestamp=comisionlineaDataAccess.getSetVersionRowComisionLinea(connexion,comisionlineaAux.getId());
						
						if(!comisionlinea.getVersionRow().equals(timestamp)) {	
							comisionlineaAux.setVersionRow(timestamp);
						}
								
						comisionlineaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowComisionLineas()throws Exception {	
		if(comisionlineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ComisionLinea comisionlineaAux:comisionlineas) {
					if(comisionlineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionlineaAux.getIsDeleted() || (comisionlineaAux.getIsChanged()&&!comisionlineaAux.getIsNew())) {
						
						timestamp=comisionlineaDataAccess.getSetVersionRowComisionLinea(connexion,comisionlineaAux.getId());
						
						if(!comisionlineaAux.getVersionRow().equals(timestamp)) {	
							comisionlineaAux.setVersionRow(timestamp);
						}
						
													
						comisionlineaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ComisionLineaParameterReturnGeneral cargarCombosLoteForeignKeyComisionLineaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionLineaParameterReturnGeneral  comisionlineaReturnGeneral =new ComisionLineaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-cargarCombosLoteForeignKeyComisionLineaWithConnection");connexion.begin();
			
			comisionlineaReturnGeneral =new ComisionLineaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionlineaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisionlineaReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisionlineaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisionlineaReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisionlineaReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return comisionlineaReturnGeneral;
	}
	
	public ComisionLineaParameterReturnGeneral cargarCombosLoteForeignKeyComisionLinea(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionLineaParameterReturnGeneral  comisionlineaReturnGeneral =new ComisionLineaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			comisionlineaReturnGeneral =new ComisionLineaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionlineaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisionlineaReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisionlineaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisionlineaReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisionlineaReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return comisionlineaReturnGeneral;
	}
	
	
	public void deepLoad(ComisionLinea comisionlinea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComisionLineaLogicAdditional.updateComisionLineaToGet(comisionlinea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionlinea.setEmpresa(comisionlineaDataAccess.getEmpresa(connexion,comisionlinea));
		comisionlinea.setComisionConfig(comisionlineaDataAccess.getComisionConfig(connexion,comisionlinea));
		comisionlinea.setVendedor(comisionlineaDataAccess.getVendedor(connexion,comisionlinea));
		comisionlinea.setLinea(comisionlineaDataAccess.getLinea(connexion,comisionlinea));
		comisionlinea.setEstadoComision(comisionlineaDataAccess.getEstadoComision(connexion,comisionlinea));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionlinea.setEmpresa(comisionlineaDataAccess.getEmpresa(connexion,comisionlinea));
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisionlinea.setComisionConfig(comisionlineaDataAccess.getComisionConfig(connexion,comisionlinea));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisionlinea.setVendedor(comisionlineaDataAccess.getVendedor(connexion,comisionlinea));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionlinea.setLinea(comisionlineaDataAccess.getLinea(connexion,comisionlinea));
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisionlinea.setEstadoComision(comisionlineaDataAccess.getEstadoComision(connexion,comisionlinea));
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
			comisionlinea.setEmpresa(comisionlineaDataAccess.getEmpresa(connexion,comisionlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setComisionConfig(comisionlineaDataAccess.getComisionConfig(connexion,comisionlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setVendedor(comisionlineaDataAccess.getVendedor(connexion,comisionlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setLinea(comisionlineaDataAccess.getLinea(connexion,comisionlinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setEstadoComision(comisionlineaDataAccess.getEstadoComision(connexion,comisionlinea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionlinea.setEmpresa(comisionlineaDataAccess.getEmpresa(connexion,comisionlinea));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionlinea.getEmpresa(),isDeep,deepLoadType,clases);
				
		comisionlinea.setComisionConfig(comisionlineaDataAccess.getComisionConfig(connexion,comisionlinea));
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisionlinea.getComisionConfig(),isDeep,deepLoadType,clases);
				
		comisionlinea.setVendedor(comisionlineaDataAccess.getVendedor(connexion,comisionlinea));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisionlinea.getVendedor(),isDeep,deepLoadType,clases);
				
		comisionlinea.setLinea(comisionlineaDataAccess.getLinea(connexion,comisionlinea));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisionlinea.getLinea(),isDeep,deepLoadType,clases);
				
		comisionlinea.setEstadoComision(comisionlineaDataAccess.getEstadoComision(connexion,comisionlinea));
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisionlinea.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionlinea.setEmpresa(comisionlineaDataAccess.getEmpresa(connexion,comisionlinea));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comisionlinea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisionlinea.setComisionConfig(comisionlineaDataAccess.getComisionConfig(connexion,comisionlinea));
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepLoad(comisionlinea.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisionlinea.setVendedor(comisionlineaDataAccess.getVendedor(connexion,comisionlinea));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(comisionlinea.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionlinea.setLinea(comisionlineaDataAccess.getLinea(connexion,comisionlinea));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisionlinea.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisionlinea.setEstadoComision(comisionlineaDataAccess.getEstadoComision(connexion,comisionlinea));
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepLoad(comisionlinea.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			comisionlinea.setEmpresa(comisionlineaDataAccess.getEmpresa(connexion,comisionlinea));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comisionlinea.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setComisionConfig(comisionlineaDataAccess.getComisionConfig(connexion,comisionlinea));
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfigLogic.deepLoad(comisionlinea.getComisionConfig(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setVendedor(comisionlineaDataAccess.getVendedor(connexion,comisionlinea));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(comisionlinea.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setLinea(comisionlineaDataAccess.getLinea(connexion,comisionlinea));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisionlinea.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionlinea.setEstadoComision(comisionlineaDataAccess.getEstadoComision(connexion,comisionlinea));
			EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
			estadocomisionLogic.deepLoad(comisionlinea.getEstadoComision(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ComisionLinea comisionlinea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ComisionLineaLogicAdditional.updateComisionLineaToSave(comisionlinea,this.arrDatoGeneral);
			
ComisionLineaDataAccess.save(comisionlinea, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionlinea.getEmpresa(),connexion);

		ComisionConfigDataAccess.save(comisionlinea.getComisionConfig(),connexion);

		VendedorDataAccess.save(comisionlinea.getVendedor(),connexion);

		LineaDataAccess.save(comisionlinea.getLinea(),connexion);

		EstadoComisionDataAccess.save(comisionlinea.getEstadoComision(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionlinea.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisionlinea.getComisionConfig(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisionlinea.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionlinea.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisionlinea.getEstadoComision(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionlinea.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionlinea.getEmpresa(),isDeep,deepLoadType,clases);
				

		ComisionConfigDataAccess.save(comisionlinea.getComisionConfig(),connexion);
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisionlinea.getComisionConfig(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(comisionlinea.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisionlinea.getVendedor(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisionlinea.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisionlinea.getLinea(),isDeep,deepLoadType,clases);
				

		EstadoComisionDataAccess.save(comisionlinea.getEstadoComision(),connexion);
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisionlinea.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionlinea.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(comisionlinea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisionlinea.getComisionConfig(),connexion);
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepSave(comisionlinea.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisionlinea.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(comisionlinea.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionlinea.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisionlinea.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisionlinea.getEstadoComision(),connexion);
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepSave(comisionlinea.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ComisionLinea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(comisionlinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(comisionlinea);
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
			this.deepLoad(this.comisionlinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionLinea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(comisionlineas!=null) {
				for(ComisionLinea comisionlinea:comisionlineas) {
					this.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(comisionlineas);
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
			if(comisionlineas!=null) {
				for(ComisionLinea comisionlinea:comisionlineas) {
					this.deepLoad(comisionlinea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(comisionlineas);
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
			this.getNewConnexionToDeep(ComisionLinea.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(comisionlinea,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ComisionLinea.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(comisionlineas!=null) {
				for(ComisionLinea comisionlinea:comisionlineas) {
					this.deepSave(comisionlinea,isDeep,deepLoadType,clases);
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
			if(comisionlineas!=null) {
				for(ComisionLinea comisionlinea:comisionlineas) {
					this.deepSave(comisionlinea,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComisionLineasFK_IdComisionConfigWithConnection(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionLineaConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionLineasFK_IdComisionConfig(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionLineaConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionLineasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionLineaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionLineasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionLineaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionLineasFK_IdEstadoComisionWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionLineaConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionLineasFK_IdEstadoComision(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionLineaConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionLineasFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionLineaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionLineasFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionLineaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionLineasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionLineaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionLineasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionLineaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionLineaConstantesFunciones.refrescarForeignKeysDescripcionesComisionLinea(this.comisionlineas);
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
			if(ComisionLineaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionLineaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ComisionLinea comisionlinea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionLineaConstantesFunciones.ISCONAUDITORIA) {
				if(comisionlinea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionLineaDataAccess.TABLENAME, comisionlinea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionLineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionLineaLogic.registrarAuditoriaDetallesComisionLinea(connexion,comisionlinea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(comisionlinea.getIsDeleted()) {
					/*if(!comisionlinea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ComisionLineaDataAccess.TABLENAME, comisionlinea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ComisionLineaLogic.registrarAuditoriaDetallesComisionLinea(connexion,comisionlinea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionLineaDataAccess.TABLENAME, comisionlinea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(comisionlinea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionLineaDataAccess.TABLENAME, comisionlinea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionLineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionLineaLogic.registrarAuditoriaDetallesComisionLinea(connexion,comisionlinea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesComisionLinea(Connexion connexion,ComisionLinea comisionlinea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(comisionlinea.getIsNew()||!comisionlinea.getid_empresa().equals(comisionlinea.getComisionLineaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionlinea.getComisionLineaOriginal().getid_empresa()!=null)
				{
					strValorActual=comisionlinea.getComisionLineaOriginal().getid_empresa().toString();
				}
				if(comisionlinea.getid_empresa()!=null)
				{
					strValorNuevo=comisionlinea.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionLineaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(comisionlinea.getIsNew()||!comisionlinea.getid_comision_config().equals(comisionlinea.getComisionLineaOriginal().getid_comision_config()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionlinea.getComisionLineaOriginal().getid_comision_config()!=null)
				{
					strValorActual=comisionlinea.getComisionLineaOriginal().getid_comision_config().toString();
				}
				if(comisionlinea.getid_comision_config()!=null)
				{
					strValorNuevo=comisionlinea.getid_comision_config().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionLineaConstantesFunciones.IDCOMISIONCONFIG,strValorActual,strValorNuevo);
			}	
			
			if(comisionlinea.getIsNew()||!comisionlinea.getid_vendedor().equals(comisionlinea.getComisionLineaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionlinea.getComisionLineaOriginal().getid_vendedor()!=null)
				{
					strValorActual=comisionlinea.getComisionLineaOriginal().getid_vendedor().toString();
				}
				if(comisionlinea.getid_vendedor()!=null)
				{
					strValorNuevo=comisionlinea.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionLineaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(comisionlinea.getIsNew()||!comisionlinea.getid_linea().equals(comisionlinea.getComisionLineaOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionlinea.getComisionLineaOriginal().getid_linea()!=null)
				{
					strValorActual=comisionlinea.getComisionLineaOriginal().getid_linea().toString();
				}
				if(comisionlinea.getid_linea()!=null)
				{
					strValorNuevo=comisionlinea.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionLineaConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(comisionlinea.getIsNew()||!comisionlinea.getid_estado_comision().equals(comisionlinea.getComisionLineaOriginal().getid_estado_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionlinea.getComisionLineaOriginal().getid_estado_comision()!=null)
				{
					strValorActual=comisionlinea.getComisionLineaOriginal().getid_estado_comision().toString();
				}
				if(comisionlinea.getid_estado_comision()!=null)
				{
					strValorNuevo=comisionlinea.getid_estado_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionLineaConstantesFunciones.IDESTADOCOMISION,strValorActual,strValorNuevo);
			}	
			
			if(comisionlinea.getIsNew()||!comisionlinea.getporcentaje().equals(comisionlinea.getComisionLineaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionlinea.getComisionLineaOriginal().getporcentaje()!=null)
				{
					strValorActual=comisionlinea.getComisionLineaOriginal().getporcentaje().toString();
				}
				if(comisionlinea.getporcentaje()!=null)
				{
					strValorNuevo=comisionlinea.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionLineaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(comisionlinea.getIsNew()||!comisionlinea.getdescripcion().equals(comisionlinea.getComisionLineaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionlinea.getComisionLineaOriginal().getdescripcion()!=null)
				{
					strValorActual=comisionlinea.getComisionLineaOriginal().getdescripcion();
				}
				if(comisionlinea.getdescripcion()!=null)
				{
					strValorNuevo=comisionlinea.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionLineaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveComisionLineaRelacionesWithConnection(ComisionLinea comisionlinea) throws Exception {

		if(!comisionlinea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionLineaRelacionesBase(comisionlinea,true);
		}
	}

	public void saveComisionLineaRelaciones(ComisionLinea comisionlinea)throws Exception {

		if(!comisionlinea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionLineaRelacionesBase(comisionlinea,false);
		}
	}

	public void saveComisionLineaRelacionesBase(ComisionLinea comisionlinea,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ComisionLinea-saveRelacionesWithConnection");}
	

			this.setComisionLinea(comisionlinea);

			if(ComisionLineaLogicAdditional.validarSaveRelaciones(comisionlinea,this)) {

				ComisionLineaLogicAdditional.updateRelacionesToSave(comisionlinea,this);

				if((comisionlinea.getIsNew()||comisionlinea.getIsChanged())&&!comisionlinea.getIsDeleted()) {
					this.saveComisionLinea();
					this.saveComisionLineaRelacionesDetalles();

				} else if(comisionlinea.getIsDeleted()) {
					this.saveComisionLineaRelacionesDetalles();
					this.saveComisionLinea();
				}

				ComisionLineaLogicAdditional.updateRelacionesToSaveAfter(comisionlinea,this);

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
	
	
	private void saveComisionLineaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfComisionLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionLineaConstantesFunciones.getClassesForeignKeysOfComisionLinea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionLineaConstantesFunciones.getClassesRelationshipsOfComisionLinea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
