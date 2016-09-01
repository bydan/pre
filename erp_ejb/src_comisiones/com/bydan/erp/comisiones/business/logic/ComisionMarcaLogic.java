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
import com.bydan.erp.comisiones.util.ComisionMarcaConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionMarcaParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionMarcaParameterGeneral;
import com.bydan.erp.comisiones.business.entity.ComisionMarca;
import com.bydan.erp.comisiones.business.logic.ComisionMarcaLogicAdditional;
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
public class ComisionMarcaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ComisionMarcaLogic.class);
	
	protected ComisionMarcaDataAccess comisionmarcaDataAccess; 	
	protected ComisionMarca comisionmarca;
	protected List<ComisionMarca> comisionmarcas;
	protected Object comisionmarcaObject;	
	protected List<Object> comisionmarcasObject;
	
	public static ClassValidator<ComisionMarca> comisionmarcaValidator = new ClassValidator<ComisionMarca>(ComisionMarca.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ComisionMarcaLogicAdditional comisionmarcaLogicAdditional=null;
	
	public ComisionMarcaLogicAdditional getComisionMarcaLogicAdditional() {
		return this.comisionmarcaLogicAdditional;
	}
	
	public void setComisionMarcaLogicAdditional(ComisionMarcaLogicAdditional comisionmarcaLogicAdditional) {
		try {
			this.comisionmarcaLogicAdditional=comisionmarcaLogicAdditional;
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
	
	
	
	
	public  ComisionMarcaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.comisionmarcaDataAccess = new ComisionMarcaDataAccess();
			
			this.comisionmarcas= new ArrayList<ComisionMarca>();
			this.comisionmarca= new ComisionMarca();
			
			this.comisionmarcaObject=new Object();
			this.comisionmarcasObject=new ArrayList<Object>();
				
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
			
			this.comisionmarcaDataAccess.setConnexionType(this.connexionType);
			this.comisionmarcaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComisionMarcaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.comisionmarcaDataAccess = new ComisionMarcaDataAccess();
			this.comisionmarcas= new ArrayList<ComisionMarca>();
			this.comisionmarca= new ComisionMarca();
			this.comisionmarcaObject=new Object();
			this.comisionmarcasObject=new ArrayList<Object>();
			
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
			
			this.comisionmarcaDataAccess.setConnexionType(this.connexionType);
			this.comisionmarcaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComisionMarca getComisionMarca() throws Exception {	
		ComisionMarcaLogicAdditional.checkComisionMarcaToGet(comisionmarca,this.datosCliente,this.arrDatoGeneral);
		ComisionMarcaLogicAdditional.updateComisionMarcaToGet(comisionmarca,this.arrDatoGeneral);
		
		return comisionmarca;
	}
		
	public void setComisionMarca(ComisionMarca newComisionMarca) {
		this.comisionmarca = newComisionMarca;
	}
	
	public ComisionMarcaDataAccess getComisionMarcaDataAccess() {
		return comisionmarcaDataAccess;
	}
	
	public void setComisionMarcaDataAccess(ComisionMarcaDataAccess newcomisionmarcaDataAccess) {
		this.comisionmarcaDataAccess = newcomisionmarcaDataAccess;
	}
	
	public List<ComisionMarca> getComisionMarcas() throws Exception {		
		this.quitarComisionMarcasNulos();
		
		ComisionMarcaLogicAdditional.checkComisionMarcaToGets(comisionmarcas,this.datosCliente,this.arrDatoGeneral);
		
		for (ComisionMarca comisionmarcaLocal: comisionmarcas ) {
			ComisionMarcaLogicAdditional.updateComisionMarcaToGet(comisionmarcaLocal,this.arrDatoGeneral);
		}
		
		return comisionmarcas;
	}
	
	public void setComisionMarcas(List<ComisionMarca> newComisionMarcas) {
		this.comisionmarcas = newComisionMarcas;
	}
	
	public Object getComisionMarcaObject() {	
		this.comisionmarcaObject=this.comisionmarcaDataAccess.getEntityObject();
		return this.comisionmarcaObject;
	}
		
	public void setComisionMarcaObject(Object newComisionMarcaObject) {
		this.comisionmarcaObject = newComisionMarcaObject;
	}
	
	public List<Object> getComisionMarcasObject() {		
		this.comisionmarcasObject=this.comisionmarcaDataAccess.getEntitiesObject();
		return this.comisionmarcasObject;
	}
		
	public void setComisionMarcasObject(List<Object> newComisionMarcasObject) {
		this.comisionmarcasObject = newComisionMarcasObject;
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
		
		if(this.comisionmarcaDataAccess!=null) {
			this.comisionmarcaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			comisionmarcaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			comisionmarcaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		comisionmarca = new  ComisionMarca();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionmarca=comisionmarcaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionmarca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarca);
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
		comisionmarca = new  ComisionMarca();
		  		  
        try {
			
			comisionmarca=comisionmarcaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionmarca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisionmarca = new  ComisionMarca();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionmarca=comisionmarcaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionmarca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarca);
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
		comisionmarca = new  ComisionMarca();
		  		  
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
		comisionmarca = new  ComisionMarca();
		  		  
        try {
			
			comisionmarca=comisionmarcaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionmarca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		comisionmarca = new  ComisionMarca();
		  		  
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
		comisionmarca = new  ComisionMarca();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =comisionmarcaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionmarca = new  ComisionMarca();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=comisionmarcaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionmarca = new  ComisionMarca();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =comisionmarcaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionmarca = new  ComisionMarca();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=comisionmarcaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionmarca = new  ComisionMarca();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =comisionmarcaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionmarca = new  ComisionMarca();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=comisionmarcaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
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
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
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
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
        try {			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
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
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
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
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
        try {
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
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
		comisionmarcas = new  ArrayList<ComisionMarca>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
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
		comisionmarcas = new  ArrayList<ComisionMarca>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionmarca = new  ComisionMarca();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarca=comisionmarcaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarca);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarca);
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
		comisionmarca = new  ComisionMarca();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarca=comisionmarcaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarca);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
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
		comisionmarcas = new  ArrayList<ComisionMarca>();
		  		  
        try {
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComisionMarcasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		comisionmarcas = new  ArrayList<ComisionMarca>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getTodosComisionMarcasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
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
	
	public  void  getTodosComisionMarcas(String sFinalQuery,Pagination pagination)throws Exception {
		comisionmarcas = new  ArrayList<ComisionMarca>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionMarca(comisionmarcas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarComisionMarca(ComisionMarca comisionmarca) throws Exception {
		Boolean estaValidado=false;
		
		if(comisionmarca.getIsNew() || comisionmarca.getIsChanged()) { 
			this.invalidValues = comisionmarcaValidator.getInvalidValues(comisionmarca);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(comisionmarca);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarComisionMarca(List<ComisionMarca> ComisionMarcas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ComisionMarca comisionmarcaLocal:comisionmarcas) {				
			estaValidadoObjeto=this.validarGuardarComisionMarca(comisionmarcaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarComisionMarca(List<ComisionMarca> ComisionMarcas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionMarca(comisionmarcas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarComisionMarca(ComisionMarca ComisionMarca) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionMarca(comisionmarca)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ComisionMarca comisionmarca) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+comisionmarca.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ComisionMarcaConstantesFunciones.getComisionMarcaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"comisionmarca","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ComisionMarcaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ComisionMarcaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveComisionMarcaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-saveComisionMarcaWithConnection");connexion.begin();			
			
			ComisionMarcaLogicAdditional.checkComisionMarcaToSave(this.comisionmarca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionMarcaLogicAdditional.updateComisionMarcaToSave(this.comisionmarca,this.arrDatoGeneral);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionmarca,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowComisionMarca();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionMarca(this.comisionmarca)) {
				ComisionMarcaDataAccess.save(this.comisionmarca, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.comisionmarca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionMarcaLogicAdditional.checkComisionMarcaToSaveAfter(this.comisionmarca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionMarca();
			
			connexion.commit();			
			
			if(this.comisionmarca.getIsDeleted()) {
				this.comisionmarca=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveComisionMarca()throws Exception {	
		try {	
			
			ComisionMarcaLogicAdditional.checkComisionMarcaToSave(this.comisionmarca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionMarcaLogicAdditional.updateComisionMarcaToSave(this.comisionmarca,this.arrDatoGeneral);
			
			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionmarca,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionMarca(this.comisionmarca)) {			
				ComisionMarcaDataAccess.save(this.comisionmarca, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.comisionmarca,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionMarcaLogicAdditional.checkComisionMarcaToSaveAfter(this.comisionmarca,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.comisionmarca.getIsDeleted()) {
				this.comisionmarca=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComisionMarcasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-saveComisionMarcasWithConnection");connexion.begin();			
			
			ComisionMarcaLogicAdditional.checkComisionMarcaToSaves(comisionmarcas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowComisionMarcas();
			
			Boolean validadoTodosComisionMarca=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionMarca comisionmarcaLocal:comisionmarcas) {		
				if(comisionmarcaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionMarcaLogicAdditional.updateComisionMarcaToSave(comisionmarcaLocal,this.arrDatoGeneral);
	        	
				ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionmarcaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionMarca(comisionmarcaLocal)) {
					ComisionMarcaDataAccess.save(comisionmarcaLocal, connexion);				
				} else {
					validadoTodosComisionMarca=false;
				}
			}
			
			if(!validadoTodosComisionMarca) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionMarcaLogicAdditional.checkComisionMarcaToSavesAfter(comisionmarcas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionMarcas();
			
			connexion.commit();		
			
			this.quitarComisionMarcasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveComisionMarcas()throws Exception {				
		 try {	
			ComisionMarcaLogicAdditional.checkComisionMarcaToSaves(comisionmarcas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosComisionMarca=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionMarca comisionmarcaLocal:comisionmarcas) {				
				if(comisionmarcaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionMarcaLogicAdditional.updateComisionMarcaToSave(comisionmarcaLocal,this.arrDatoGeneral);
	        	
				ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionmarcaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionMarca(comisionmarcaLocal)) {				
					ComisionMarcaDataAccess.save(comisionmarcaLocal, connexion);				
				} else {
					validadoTodosComisionMarca=false;
				}
			}
			
			if(!validadoTodosComisionMarca) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionMarcaLogicAdditional.checkComisionMarcaToSavesAfter(comisionmarcas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComisionMarcasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionMarcaParameterReturnGeneral procesarAccionComisionMarcas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionMarca> comisionmarcas,ComisionMarcaParameterReturnGeneral comisionmarcaParameterGeneral)throws Exception {
		 try {	
			ComisionMarcaParameterReturnGeneral comisionmarcaReturnGeneral=new ComisionMarcaParameterReturnGeneral();
	
			ComisionMarcaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionmarcas,comisionmarcaParameterGeneral,comisionmarcaReturnGeneral);
			
			return comisionmarcaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionMarcaParameterReturnGeneral procesarAccionComisionMarcasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionMarca> comisionmarcas,ComisionMarcaParameterReturnGeneral comisionmarcaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-procesarAccionComisionMarcasWithConnection");connexion.begin();			
			
			ComisionMarcaParameterReturnGeneral comisionmarcaReturnGeneral=new ComisionMarcaParameterReturnGeneral();
	
			ComisionMarcaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionmarcas,comisionmarcaParameterGeneral,comisionmarcaReturnGeneral);
			
			this.connexion.commit();
			
			return comisionmarcaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionMarcaParameterReturnGeneral procesarEventosComisionMarcas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionMarca> comisionmarcas,ComisionMarca comisionmarca,ComisionMarcaParameterReturnGeneral comisionmarcaParameterGeneral,Boolean isEsNuevoComisionMarca,ArrayList<Classe> clases)throws Exception {
		 try {	
			ComisionMarcaParameterReturnGeneral comisionmarcaReturnGeneral=new ComisionMarcaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionmarcaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionMarcaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionmarcas,comisionmarca,comisionmarcaParameterGeneral,comisionmarcaReturnGeneral,isEsNuevoComisionMarca,clases);
			
			return comisionmarcaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ComisionMarcaParameterReturnGeneral procesarEventosComisionMarcasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionMarca> comisionmarcas,ComisionMarca comisionmarca,ComisionMarcaParameterReturnGeneral comisionmarcaParameterGeneral,Boolean isEsNuevoComisionMarca,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-procesarEventosComisionMarcasWithConnection");connexion.begin();			
			
			ComisionMarcaParameterReturnGeneral comisionmarcaReturnGeneral=new ComisionMarcaParameterReturnGeneral();
	
			comisionmarcaReturnGeneral.setComisionMarca(comisionmarca);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionmarcaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionMarcaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionmarcas,comisionmarca,comisionmarcaParameterGeneral,comisionmarcaReturnGeneral,isEsNuevoComisionMarca,clases);
			
			this.connexion.commit();
			
			return comisionmarcaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionMarcaParameterReturnGeneral procesarImportacionComisionMarcasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ComisionMarcaParameterReturnGeneral comisionmarcaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-procesarImportacionComisionMarcasWithConnection");connexion.begin();			
			
			ComisionMarcaParameterReturnGeneral comisionmarcaReturnGeneral=new ComisionMarcaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.comisionmarcas=new ArrayList<ComisionMarca>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.comisionmarca=new ComisionMarca();
				
				
				if(conColumnasBase) {this.comisionmarca.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.comisionmarca.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.comisionmarca.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisionmarca.setdescripcion(arrColumnas[iColumn++]);
				
				this.comisionmarcas.add(this.comisionmarca);
			}
			
			this.saveComisionMarcas();
			
			this.connexion.commit();
			
			comisionmarcaReturnGeneral.setConRetornoEstaProcesado(true);
			comisionmarcaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return comisionmarcaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComisionMarcasEliminados() throws Exception {				
		
		List<ComisionMarca> comisionmarcasAux= new ArrayList<ComisionMarca>();
		
		for(ComisionMarca comisionmarca:comisionmarcas) {
			if(!comisionmarca.getIsDeleted()) {
				comisionmarcasAux.add(comisionmarca);
			}
		}
		
		comisionmarcas=comisionmarcasAux;
	}
	
	public void quitarComisionMarcasNulos() throws Exception {				
		
		List<ComisionMarca> comisionmarcasAux= new ArrayList<ComisionMarca>();
		
		for(ComisionMarca comisionmarca : this.comisionmarcas) {
			if(comisionmarca==null) {
				comisionmarcasAux.add(comisionmarca);
			}
		}
		
		//this.comisionmarcas=comisionmarcasAux;
		
		this.comisionmarcas.removeAll(comisionmarcasAux);
	}
	
	public void getSetVersionRowComisionMarcaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(comisionmarca.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((comisionmarca.getIsDeleted() || (comisionmarca.getIsChanged()&&!comisionmarca.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=comisionmarcaDataAccess.getSetVersionRowComisionMarca(connexion,comisionmarca.getId());
				
				if(!comisionmarca.getVersionRow().equals(timestamp)) {	
					comisionmarca.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				comisionmarca.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionMarca()throws Exception {	
		
		if(comisionmarca.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((comisionmarca.getIsDeleted() || (comisionmarca.getIsChanged()&&!comisionmarca.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=comisionmarcaDataAccess.getSetVersionRowComisionMarca(connexion,comisionmarca.getId());
			
			try {							
				if(!comisionmarca.getVersionRow().equals(timestamp)) {	
					comisionmarca.setVersionRow(timestamp);
				}
				
				comisionmarca.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComisionMarcasWithConnection()throws Exception {	
		if(comisionmarcas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ComisionMarca comisionmarcaAux:comisionmarcas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(comisionmarcaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionmarcaAux.getIsDeleted() || (comisionmarcaAux.getIsChanged()&&!comisionmarcaAux.getIsNew())) {
						
						timestamp=comisionmarcaDataAccess.getSetVersionRowComisionMarca(connexion,comisionmarcaAux.getId());
						
						if(!comisionmarca.getVersionRow().equals(timestamp)) {	
							comisionmarcaAux.setVersionRow(timestamp);
						}
								
						comisionmarcaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowComisionMarcas()throws Exception {	
		if(comisionmarcas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ComisionMarca comisionmarcaAux:comisionmarcas) {
					if(comisionmarcaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionmarcaAux.getIsDeleted() || (comisionmarcaAux.getIsChanged()&&!comisionmarcaAux.getIsNew())) {
						
						timestamp=comisionmarcaDataAccess.getSetVersionRowComisionMarca(connexion,comisionmarcaAux.getId());
						
						if(!comisionmarcaAux.getVersionRow().equals(timestamp)) {	
							comisionmarcaAux.setVersionRow(timestamp);
						}
						
													
						comisionmarcaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ComisionMarcaParameterReturnGeneral cargarCombosLoteForeignKeyComisionMarcaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionMarcaParameterReturnGeneral  comisionmarcaReturnGeneral =new ComisionMarcaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-cargarCombosLoteForeignKeyComisionMarcaWithConnection");connexion.begin();
			
			comisionmarcaReturnGeneral =new ComisionMarcaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionmarcaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisionmarcaReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisionmarcaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisionmarcaReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return comisionmarcaReturnGeneral;
	}
	
	public ComisionMarcaParameterReturnGeneral cargarCombosLoteForeignKeyComisionMarca(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig,String finalQueryGlobalVendedor,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca,String finalQueryGlobalEstadoComision) throws Exception {
		ComisionMarcaParameterReturnGeneral  comisionmarcaReturnGeneral =new ComisionMarcaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			comisionmarcaReturnGeneral =new ComisionMarcaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionmarcaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisionmarcaReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisionmarcaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			comisionmarcaReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);


			List<EstadoComision> estadocomisionsForeignKey=new ArrayList<EstadoComision>();
			EstadoComisionLogic estadocomisionLogic=new EstadoComisionLogic();
			estadocomisionLogic.setConnexion(this.connexion);
			estadocomisionLogic.getEstadoComisionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoComision.equals("NONE")) {
				estadocomisionLogic.getTodosEstadoComisions(finalQueryGlobalEstadoComision,new Pagination());
				estadocomisionsForeignKey=estadocomisionLogic.getEstadoComisions();
			}

			comisionmarcaReturnGeneral.setestadocomisionsForeignKey(estadocomisionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return comisionmarcaReturnGeneral;
	}
	
	
	public void deepLoad(ComisionMarca comisionmarca,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComisionMarcaLogicAdditional.updateComisionMarcaToGet(comisionmarca,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionmarca.setEmpresa(comisionmarcaDataAccess.getEmpresa(connexion,comisionmarca));
		comisionmarca.setComisionConfig(comisionmarcaDataAccess.getComisionConfig(connexion,comisionmarca));
		comisionmarca.setVendedor(comisionmarcaDataAccess.getVendedor(connexion,comisionmarca));
		comisionmarca.setLinea(comisionmarcaDataAccess.getLinea(connexion,comisionmarca));
		comisionmarca.setLineaGrupo(comisionmarcaDataAccess.getLineaGrupo(connexion,comisionmarca));
		comisionmarca.setLineaCategoria(comisionmarcaDataAccess.getLineaCategoria(connexion,comisionmarca));
		comisionmarca.setLineaMarca(comisionmarcaDataAccess.getLineaMarca(connexion,comisionmarca));
		comisionmarca.setEstadoComision(comisionmarcaDataAccess.getEstadoComision(connexion,comisionmarca));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionmarca.setEmpresa(comisionmarcaDataAccess.getEmpresa(connexion,comisionmarca));
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisionmarca.setComisionConfig(comisionmarcaDataAccess.getComisionConfig(connexion,comisionmarca));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisionmarca.setVendedor(comisionmarcaDataAccess.getVendedor(connexion,comisionmarca));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLinea(comisionmarcaDataAccess.getLinea(connexion,comisionmarca));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLineaGrupo(comisionmarcaDataAccess.getLineaGrupo(connexion,comisionmarca));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLineaCategoria(comisionmarcaDataAccess.getLineaCategoria(connexion,comisionmarca));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLineaMarca(comisionmarcaDataAccess.getLineaMarca(connexion,comisionmarca));
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisionmarca.setEstadoComision(comisionmarcaDataAccess.getEstadoComision(connexion,comisionmarca));
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
			comisionmarca.setEmpresa(comisionmarcaDataAccess.getEmpresa(connexion,comisionmarca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setComisionConfig(comisionmarcaDataAccess.getComisionConfig(connexion,comisionmarca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setVendedor(comisionmarcaDataAccess.getVendedor(connexion,comisionmarca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLinea(comisionmarcaDataAccess.getLinea(connexion,comisionmarca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLineaGrupo(comisionmarcaDataAccess.getLineaGrupo(connexion,comisionmarca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLineaCategoria(comisionmarcaDataAccess.getLineaCategoria(connexion,comisionmarca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLineaMarca(comisionmarcaDataAccess.getLineaMarca(connexion,comisionmarca));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setEstadoComision(comisionmarcaDataAccess.getEstadoComision(connexion,comisionmarca));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionmarca.setEmpresa(comisionmarcaDataAccess.getEmpresa(connexion,comisionmarca));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionmarca.getEmpresa(),isDeep,deepLoadType,clases);
				
		comisionmarca.setComisionConfig(comisionmarcaDataAccess.getComisionConfig(connexion,comisionmarca));
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisionmarca.getComisionConfig(),isDeep,deepLoadType,clases);
				
		comisionmarca.setVendedor(comisionmarcaDataAccess.getVendedor(connexion,comisionmarca));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisionmarca.getVendedor(),isDeep,deepLoadType,clases);
				
		comisionmarca.setLinea(comisionmarcaDataAccess.getLinea(connexion,comisionmarca));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisionmarca.getLinea(),isDeep,deepLoadType,clases);
				
		comisionmarca.setLineaGrupo(comisionmarcaDataAccess.getLineaGrupo(connexion,comisionmarca));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(comisionmarca.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		comisionmarca.setLineaCategoria(comisionmarcaDataAccess.getLineaCategoria(connexion,comisionmarca));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(comisionmarca.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		comisionmarca.setLineaMarca(comisionmarcaDataAccess.getLineaMarca(connexion,comisionmarca));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(comisionmarca.getLineaMarca(),isDeep,deepLoadType,clases);
				
		comisionmarca.setEstadoComision(comisionmarcaDataAccess.getEstadoComision(connexion,comisionmarca));
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisionmarca.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionmarca.setEmpresa(comisionmarcaDataAccess.getEmpresa(connexion,comisionmarca));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comisionmarca.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisionmarca.setComisionConfig(comisionmarcaDataAccess.getComisionConfig(connexion,comisionmarca));
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepLoad(comisionmarca.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisionmarca.setVendedor(comisionmarcaDataAccess.getVendedor(connexion,comisionmarca));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(comisionmarca.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLinea(comisionmarcaDataAccess.getLinea(connexion,comisionmarca));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisionmarca.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLineaGrupo(comisionmarcaDataAccess.getLineaGrupo(connexion,comisionmarca));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisionmarca.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLineaCategoria(comisionmarcaDataAccess.getLineaCategoria(connexion,comisionmarca));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisionmarca.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				comisionmarca.setLineaMarca(comisionmarcaDataAccess.getLineaMarca(connexion,comisionmarca));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(comisionmarca.getLineaMarca(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				comisionmarca.setEstadoComision(comisionmarcaDataAccess.getEstadoComision(connexion,comisionmarca));
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepLoad(comisionmarca.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			comisionmarca.setEmpresa(comisionmarcaDataAccess.getEmpresa(connexion,comisionmarca));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comisionmarca.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setComisionConfig(comisionmarcaDataAccess.getComisionConfig(connexion,comisionmarca));
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfigLogic.deepLoad(comisionmarca.getComisionConfig(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setVendedor(comisionmarcaDataAccess.getVendedor(connexion,comisionmarca));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(comisionmarca.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLinea(comisionmarcaDataAccess.getLinea(connexion,comisionmarca));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisionmarca.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLineaGrupo(comisionmarcaDataAccess.getLineaGrupo(connexion,comisionmarca));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisionmarca.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLineaCategoria(comisionmarcaDataAccess.getLineaCategoria(connexion,comisionmarca));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisionmarca.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setLineaMarca(comisionmarcaDataAccess.getLineaMarca(connexion,comisionmarca));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(comisionmarca.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoComision.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionmarca.setEstadoComision(comisionmarcaDataAccess.getEstadoComision(connexion,comisionmarca));
			EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
			estadocomisionLogic.deepLoad(comisionmarca.getEstadoComision(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ComisionMarca comisionmarca,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ComisionMarcaLogicAdditional.updateComisionMarcaToSave(comisionmarca,this.arrDatoGeneral);
			
ComisionMarcaDataAccess.save(comisionmarca, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionmarca.getEmpresa(),connexion);

		ComisionConfigDataAccess.save(comisionmarca.getComisionConfig(),connexion);

		VendedorDataAccess.save(comisionmarca.getVendedor(),connexion);

		LineaDataAccess.save(comisionmarca.getLinea(),connexion);

		LineaDataAccess.save(comisionmarca.getLineaGrupo(),connexion);

		LineaDataAccess.save(comisionmarca.getLineaCategoria(),connexion);

		LineaDataAccess.save(comisionmarca.getLineaMarca(),connexion);

		EstadoComisionDataAccess.save(comisionmarca.getEstadoComision(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionmarca.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisionmarca.getComisionConfig(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisionmarca.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLineaMarca(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisionmarca.getEstadoComision(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionmarca.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionmarca.getEmpresa(),isDeep,deepLoadType,clases);
				

		ComisionConfigDataAccess.save(comisionmarca.getComisionConfig(),connexion);
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisionmarca.getComisionConfig(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(comisionmarca.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisionmarca.getVendedor(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisionmarca.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(comisionmarca.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisionmarca.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(comisionmarca.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisionmarca.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(comisionmarca.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(comisionmarca.getLineaMarca(),connexion);
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(comisionmarca.getLineaMarca(),isDeep,deepLoadType,clases);
				

		EstadoComisionDataAccess.save(comisionmarca.getEstadoComision(),connexion);
		EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
		estadocomisionLogic.deepLoad(comisionmarca.getEstadoComision(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionmarca.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(comisionmarca.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisionmarca.getComisionConfig(),connexion);
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepSave(comisionmarca.getComisionConfig(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisionmarca.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(comisionmarca.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisionmarca.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisionmarca.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisionmarca.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(comisionmarca.getLineaMarca(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(comisionmarca.getLineaMarca(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoComision.class)) {
				EstadoComisionDataAccess.save(comisionmarca.getEstadoComision(),connexion);
				EstadoComisionLogic estadocomisionLogic= new EstadoComisionLogic(connexion);
				estadocomisionLogic.deepSave(comisionmarca.getEstadoComision(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ComisionMarca.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(comisionmarca,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(comisionmarca);
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
			this.deepLoad(this.comisionmarca,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarca);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionMarca.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(comisionmarcas!=null) {
				for(ComisionMarca comisionmarca:comisionmarcas) {
					this.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(comisionmarcas);
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
			if(comisionmarcas!=null) {
				for(ComisionMarca comisionmarca:comisionmarcas) {
					this.deepLoad(comisionmarca,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(comisionmarcas);
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
			this.getNewConnexionToDeep(ComisionMarca.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(comisionmarca,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ComisionMarca.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(comisionmarcas!=null) {
				for(ComisionMarca comisionmarca:comisionmarcas) {
					this.deepSave(comisionmarca,isDeep,deepLoadType,clases);
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
			if(comisionmarcas!=null) {
				for(ComisionMarca comisionmarca:comisionmarcas) {
					this.deepSave(comisionmarca,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComisionMarcasFK_IdComisionConfigWithConnection(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdComisionConfig(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionMarcasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionMarcaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionMarcaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionMarcasFK_IdEstadoComisionWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionMarcaConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdEstadoComision(String sFinalQuery,Pagination pagination,Long id_estado_comision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_comision,ComisionMarcaConstantesFunciones.IDESTADOCOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoComision);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionMarcasFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionMarcaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,ComisionMarcaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionMarcasFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,ComisionMarcaConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,ComisionMarcaConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionMarcasFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ComisionMarcaConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,ComisionMarcaConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionMarcasFK_IdLineaMarcaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,ComisionMarcaConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdLineaMarca(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,ComisionMarcaConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionMarcasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionMarca.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionMarcaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionMarcasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionMarcaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionMarcaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionMarcaConstantesFunciones.refrescarForeignKeysDescripcionesComisionMarca(this.comisionmarcas);
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
			if(ComisionMarcaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionMarcaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ComisionMarca comisionmarca,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionMarcaConstantesFunciones.ISCONAUDITORIA) {
				if(comisionmarca.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionMarcaDataAccess.TABLENAME, comisionmarca.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionMarcaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionMarcaLogic.registrarAuditoriaDetallesComisionMarca(connexion,comisionmarca,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(comisionmarca.getIsDeleted()) {
					/*if(!comisionmarca.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ComisionMarcaDataAccess.TABLENAME, comisionmarca.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ComisionMarcaLogic.registrarAuditoriaDetallesComisionMarca(connexion,comisionmarca,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionMarcaDataAccess.TABLENAME, comisionmarca.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(comisionmarca.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionMarcaDataAccess.TABLENAME, comisionmarca.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionMarcaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionMarcaLogic.registrarAuditoriaDetallesComisionMarca(connexion,comisionmarca,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesComisionMarca(Connexion connexion,ComisionMarca comisionmarca)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_empresa().equals(comisionmarca.getComisionMarcaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_empresa()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_empresa().toString();
				}
				if(comisionmarca.getid_empresa()!=null)
				{
					strValorNuevo=comisionmarca.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_comision_config().equals(comisionmarca.getComisionMarcaOriginal().getid_comision_config()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_comision_config()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_comision_config().toString();
				}
				if(comisionmarca.getid_comision_config()!=null)
				{
					strValorNuevo=comisionmarca.getid_comision_config().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_vendedor().equals(comisionmarca.getComisionMarcaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_vendedor()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_vendedor().toString();
				}
				if(comisionmarca.getid_vendedor()!=null)
				{
					strValorNuevo=comisionmarca.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_linea().equals(comisionmarca.getComisionMarcaOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_linea()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_linea().toString();
				}
				if(comisionmarca.getid_linea()!=null)
				{
					strValorNuevo=comisionmarca.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_linea_grupo().equals(comisionmarca.getComisionMarcaOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_linea_grupo().toString();
				}
				if(comisionmarca.getid_linea_grupo()!=null)
				{
					strValorNuevo=comisionmarca.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_linea_categoria().equals(comisionmarca.getComisionMarcaOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_linea_categoria().toString();
				}
				if(comisionmarca.getid_linea_categoria()!=null)
				{
					strValorNuevo=comisionmarca.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_linea_marca().equals(comisionmarca.getComisionMarcaOriginal().getid_linea_marca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_linea_marca()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_linea_marca().toString();
				}
				if(comisionmarca.getid_linea_marca()!=null)
				{
					strValorNuevo=comisionmarca.getid_linea_marca().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDLINEAMARCA,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getid_estado_comision().equals(comisionmarca.getComisionMarcaOriginal().getid_estado_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getid_estado_comision()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getid_estado_comision().toString();
				}
				if(comisionmarca.getid_estado_comision()!=null)
				{
					strValorNuevo=comisionmarca.getid_estado_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.IDESTADOCOMISION,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getporcentaje().equals(comisionmarca.getComisionMarcaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getporcentaje()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getporcentaje().toString();
				}
				if(comisionmarca.getporcentaje()!=null)
				{
					strValorNuevo=comisionmarca.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(comisionmarca.getIsNew()||!comisionmarca.getdescripcion().equals(comisionmarca.getComisionMarcaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionmarca.getComisionMarcaOriginal().getdescripcion()!=null)
				{
					strValorActual=comisionmarca.getComisionMarcaOriginal().getdescripcion();
				}
				if(comisionmarca.getdescripcion()!=null)
				{
					strValorNuevo=comisionmarca.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionMarcaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveComisionMarcaRelacionesWithConnection(ComisionMarca comisionmarca) throws Exception {

		if(!comisionmarca.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionMarcaRelacionesBase(comisionmarca,true);
		}
	}

	public void saveComisionMarcaRelaciones(ComisionMarca comisionmarca)throws Exception {

		if(!comisionmarca.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionMarcaRelacionesBase(comisionmarca,false);
		}
	}

	public void saveComisionMarcaRelacionesBase(ComisionMarca comisionmarca,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ComisionMarca-saveRelacionesWithConnection");}
	

			this.setComisionMarca(comisionmarca);

			if(ComisionMarcaLogicAdditional.validarSaveRelaciones(comisionmarca,this)) {

				ComisionMarcaLogicAdditional.updateRelacionesToSave(comisionmarca,this);

				if((comisionmarca.getIsNew()||comisionmarca.getIsChanged())&&!comisionmarca.getIsDeleted()) {
					this.saveComisionMarca();
					this.saveComisionMarcaRelacionesDetalles();

				} else if(comisionmarca.getIsDeleted()) {
					this.saveComisionMarcaRelacionesDetalles();
					this.saveComisionMarca();
				}

				ComisionMarcaLogicAdditional.updateRelacionesToSaveAfter(comisionmarca,this);

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
	
	
	private void saveComisionMarcaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfComisionMarca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionMarcaConstantesFunciones.getClassesForeignKeysOfComisionMarca(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionMarca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionMarcaConstantesFunciones.getClassesRelationshipsOfComisionMarca(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
