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
import com.bydan.erp.inventario.util.BodegaConstantesFunciones;
import com.bydan.erp.inventario.util.BodegaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.BodegaParameterGeneral;
import com.bydan.erp.inventario.business.entity.Bodega;
import com.bydan.erp.inventario.business.logic.BodegaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class BodegaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BodegaLogic.class);
	
	protected BodegaDataAccess bodegaDataAccess; 	
	protected Bodega bodega;
	protected List<Bodega> bodegas;
	protected Object bodegaObject;	
	protected List<Object> bodegasObject;
	
	public static ClassValidator<Bodega> bodegaValidator = new ClassValidator<Bodega>(Bodega.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BodegaLogicAdditional bodegaLogicAdditional=null;
	
	public BodegaLogicAdditional getBodegaLogicAdditional() {
		return this.bodegaLogicAdditional;
	}
	
	public void setBodegaLogicAdditional(BodegaLogicAdditional bodegaLogicAdditional) {
		try {
			this.bodegaLogicAdditional=bodegaLogicAdditional;
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
	
	
	
	
	public  BodegaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.bodegaDataAccess = new BodegaDataAccess();
			
			this.bodegas= new ArrayList<Bodega>();
			this.bodega= new Bodega();
			
			this.bodegaObject=new Object();
			this.bodegasObject=new ArrayList<Object>();
				
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
			
			this.bodegaDataAccess.setConnexionType(this.connexionType);
			this.bodegaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BodegaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.bodegaDataAccess = new BodegaDataAccess();
			this.bodegas= new ArrayList<Bodega>();
			this.bodega= new Bodega();
			this.bodegaObject=new Object();
			this.bodegasObject=new ArrayList<Object>();
			
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
			
			this.bodegaDataAccess.setConnexionType(this.connexionType);
			this.bodegaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Bodega getBodega() throws Exception {	
		BodegaLogicAdditional.checkBodegaToGet(bodega,this.datosCliente,this.arrDatoGeneral);
		BodegaLogicAdditional.updateBodegaToGet(bodega,this.arrDatoGeneral);
		
		return bodega;
	}
		
	public void setBodega(Bodega newBodega) {
		this.bodega = newBodega;
	}
	
	public BodegaDataAccess getBodegaDataAccess() {
		return bodegaDataAccess;
	}
	
	public void setBodegaDataAccess(BodegaDataAccess newbodegaDataAccess) {
		this.bodegaDataAccess = newbodegaDataAccess;
	}
	
	public List<Bodega> getBodegas() throws Exception {		
		this.quitarBodegasNulos();
		
		BodegaLogicAdditional.checkBodegaToGets(bodegas,this.datosCliente,this.arrDatoGeneral);
		
		for (Bodega bodegaLocal: bodegas ) {
			BodegaLogicAdditional.updateBodegaToGet(bodegaLocal,this.arrDatoGeneral);
		}
		
		return bodegas;
	}
	
	public void setBodegas(List<Bodega> newBodegas) {
		this.bodegas = newBodegas;
	}
	
	public Object getBodegaObject() {	
		this.bodegaObject=this.bodegaDataAccess.getEntityObject();
		return this.bodegaObject;
	}
		
	public void setBodegaObject(Object newBodegaObject) {
		this.bodegaObject = newBodegaObject;
	}
	
	public List<Object> getBodegasObject() {		
		this.bodegasObject=this.bodegaDataAccess.getEntitiesObject();
		return this.bodegasObject;
	}
		
	public void setBodegasObject(List<Object> newBodegasObject) {
		this.bodegasObject = newBodegasObject;
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
		
		if(this.bodegaDataAccess!=null) {
			this.bodegaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			bodegaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			bodegaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		bodega = new  Bodega();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bodega=bodegaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodega);
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
		bodega = new  Bodega();
		  		  
        try {
			
			bodega=bodegaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		bodega = new  Bodega();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bodega=bodegaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodega);
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
		bodega = new  Bodega();
		  		  
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
		bodega = new  Bodega();
		  		  
        try {
			
			bodega=bodegaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		bodega = new  Bodega();
		  		  
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
		bodega = new  Bodega();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =bodegaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodega = new  Bodega();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=bodegaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bodega = new  Bodega();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =bodegaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodega = new  Bodega();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=bodegaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bodega = new  Bodega();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =bodegaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodega = new  Bodega();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=bodegaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bodegas = new  ArrayList<Bodega>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
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
		bodegas = new  ArrayList<Bodega>();
		  		  
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
		bodegas = new  ArrayList<Bodega>();
		  		  
        try {			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		bodegas = new  ArrayList<Bodega>();
		  		  
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
		bodegas = new  ArrayList<Bodega>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
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
		bodegas = new  ArrayList<Bodega>();
		  		  
        try {
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
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
		bodegas = new  ArrayList<Bodega>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
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
		bodegas = new  ArrayList<Bodega>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		bodega = new  Bodega();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodega=bodegaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodega(bodega);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodega);
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
		bodega = new  Bodega();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodega=bodegaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodega(bodega);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bodegas = new  ArrayList<Bodega>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
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
		bodegas = new  ArrayList<Bodega>();
		  		  
        try {
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBodegasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		bodegas = new  ArrayList<Bodega>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getTodosBodegasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
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
	
	public  void  getTodosBodegas(String sFinalQuery,Pagination pagination)throws Exception {
		bodegas = new  ArrayList<Bodega>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBodega(bodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBodega(Bodega bodega) throws Exception {
		Boolean estaValidado=false;
		
		if(bodega.getIsNew() || bodega.getIsChanged()) { 
			this.invalidValues = bodegaValidator.getInvalidValues(bodega);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(bodega);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBodega(List<Bodega> Bodegas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Bodega bodegaLocal:bodegas) {				
			estaValidadoObjeto=this.validarGuardarBodega(bodegaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBodega(List<Bodega> Bodegas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBodega(bodegas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBodega(Bodega Bodega) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBodega(bodega)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Bodega bodega) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+bodega.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BodegaConstantesFunciones.getBodegaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"bodega","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BodegaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BodegaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBodegaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-saveBodegaWithConnection");connexion.begin();			
			
			BodegaLogicAdditional.checkBodegaToSave(this.bodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BodegaLogicAdditional.updateBodegaToSave(this.bodega,this.arrDatoGeneral);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bodega,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBodega();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBodega(this.bodega)) {
				BodegaDataAccess.save(this.bodega, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.bodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BodegaLogicAdditional.checkBodegaToSaveAfter(this.bodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBodega();
			
			connexion.commit();			
			
			if(this.bodega.getIsDeleted()) {
				this.bodega=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBodega()throws Exception {	
		try {	
			
			BodegaLogicAdditional.checkBodegaToSave(this.bodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BodegaLogicAdditional.updateBodegaToSave(this.bodega,this.arrDatoGeneral);
			
			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bodega,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBodega(this.bodega)) {			
				BodegaDataAccess.save(this.bodega, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.bodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BodegaLogicAdditional.checkBodegaToSaveAfter(this.bodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.bodega.getIsDeleted()) {
				this.bodega=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBodegasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-saveBodegasWithConnection");connexion.begin();			
			
			BodegaLogicAdditional.checkBodegaToSaves(bodegas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBodegas();
			
			Boolean validadoTodosBodega=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Bodega bodegaLocal:bodegas) {		
				if(bodegaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BodegaLogicAdditional.updateBodegaToSave(bodegaLocal,this.arrDatoGeneral);
	        	
				BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bodegaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBodega(bodegaLocal)) {
					BodegaDataAccess.save(bodegaLocal, connexion);				
				} else {
					validadoTodosBodega=false;
				}
			}
			
			if(!validadoTodosBodega) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BodegaLogicAdditional.checkBodegaToSavesAfter(bodegas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBodegas();
			
			connexion.commit();		
			
			this.quitarBodegasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBodegas()throws Exception {				
		 try {	
			BodegaLogicAdditional.checkBodegaToSaves(bodegas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBodega=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Bodega bodegaLocal:bodegas) {				
				if(bodegaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BodegaLogicAdditional.updateBodegaToSave(bodegaLocal,this.arrDatoGeneral);
	        	
				BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bodegaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBodega(bodegaLocal)) {				
					BodegaDataAccess.save(bodegaLocal, connexion);				
				} else {
					validadoTodosBodega=false;
				}
			}
			
			if(!validadoTodosBodega) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BodegaLogicAdditional.checkBodegaToSavesAfter(bodegas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBodegasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BodegaParameterReturnGeneral procesarAccionBodegas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Bodega> bodegas,BodegaParameterReturnGeneral bodegaParameterGeneral)throws Exception {
		 try {	
			BodegaParameterReturnGeneral bodegaReturnGeneral=new BodegaParameterReturnGeneral();
	
			BodegaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bodegas,bodegaParameterGeneral,bodegaReturnGeneral);
			
			return bodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BodegaParameterReturnGeneral procesarAccionBodegasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Bodega> bodegas,BodegaParameterReturnGeneral bodegaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-procesarAccionBodegasWithConnection");connexion.begin();			
			
			BodegaParameterReturnGeneral bodegaReturnGeneral=new BodegaParameterReturnGeneral();
	
			BodegaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bodegas,bodegaParameterGeneral,bodegaReturnGeneral);
			
			this.connexion.commit();
			
			return bodegaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BodegaParameterReturnGeneral procesarEventosBodegas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Bodega> bodegas,Bodega bodega,BodegaParameterReturnGeneral bodegaParameterGeneral,Boolean isEsNuevoBodega,ArrayList<Classe> clases)throws Exception {
		 try {	
			BodegaParameterReturnGeneral bodegaReturnGeneral=new BodegaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bodegaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BodegaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bodegas,bodega,bodegaParameterGeneral,bodegaReturnGeneral,isEsNuevoBodega,clases);
			
			return bodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BodegaParameterReturnGeneral procesarEventosBodegasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Bodega> bodegas,Bodega bodega,BodegaParameterReturnGeneral bodegaParameterGeneral,Boolean isEsNuevoBodega,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-procesarEventosBodegasWithConnection");connexion.begin();			
			
			BodegaParameterReturnGeneral bodegaReturnGeneral=new BodegaParameterReturnGeneral();
	
			bodegaReturnGeneral.setBodega(bodega);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bodegaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BodegaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bodegas,bodega,bodegaParameterGeneral,bodegaReturnGeneral,isEsNuevoBodega,clases);
			
			this.connexion.commit();
			
			return bodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BodegaParameterReturnGeneral procesarImportacionBodegasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BodegaParameterReturnGeneral bodegaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-procesarImportacionBodegasWithConnection");connexion.begin();			
			
			BodegaParameterReturnGeneral bodegaReturnGeneral=new BodegaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.bodegas=new ArrayList<Bodega>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.bodega=new Bodega();
				
				
				if(conColumnasBase) {this.bodega.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.bodega.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.bodega.setcodigo(arrColumnas[iColumn++]);
				this.bodega.setnombre(arrColumnas[iColumn++]);
				this.bodega.setsiglas(arrColumnas[iColumn++]);
				this.bodega.setdireccion(arrColumnas[iColumn++]);
				this.bodega.settelefono(arrColumnas[iColumn++]);
				this.bodega.setruc(arrColumnas[iColumn++]);
				this.bodega.setresponsable_nombre(arrColumnas[iColumn++]);
			this.bodega.setdescripcion(arrColumnas[iColumn++]);
				this.bodega.setes_multi_empresa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodega.setcon_mostrar_stock(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodega.setes_bodega_transito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.bodega.setcon_stock_negativo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.bodegas.add(this.bodega);
			}
			
			this.saveBodegas();
			
			this.connexion.commit();
			
			bodegaReturnGeneral.setConRetornoEstaProcesado(true);
			bodegaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return bodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBodegasEliminados() throws Exception {				
		
		List<Bodega> bodegasAux= new ArrayList<Bodega>();
		
		for(Bodega bodega:bodegas) {
			if(!bodega.getIsDeleted()) {
				bodegasAux.add(bodega);
			}
		}
		
		bodegas=bodegasAux;
	}
	
	public void quitarBodegasNulos() throws Exception {				
		
		List<Bodega> bodegasAux= new ArrayList<Bodega>();
		
		for(Bodega bodega : this.bodegas) {
			if(bodega==null) {
				bodegasAux.add(bodega);
			}
		}
		
		//this.bodegas=bodegasAux;
		
		this.bodegas.removeAll(bodegasAux);
	}
	
	public void getSetVersionRowBodegaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(bodega.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((bodega.getIsDeleted() || (bodega.getIsChanged()&&!bodega.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=bodegaDataAccess.getSetVersionRowBodega(connexion,bodega.getId());
				
				if(!bodega.getVersionRow().equals(timestamp)) {	
					bodega.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				bodega.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBodega()throws Exception {	
		
		if(bodega.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((bodega.getIsDeleted() || (bodega.getIsChanged()&&!bodega.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=bodegaDataAccess.getSetVersionRowBodega(connexion,bodega.getId());
			
			try {							
				if(!bodega.getVersionRow().equals(timestamp)) {	
					bodega.setVersionRow(timestamp);
				}
				
				bodega.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBodegasWithConnection()throws Exception {	
		if(bodegas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Bodega bodegaAux:bodegas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(bodegaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bodegaAux.getIsDeleted() || (bodegaAux.getIsChanged()&&!bodegaAux.getIsNew())) {
						
						timestamp=bodegaDataAccess.getSetVersionRowBodega(connexion,bodegaAux.getId());
						
						if(!bodega.getVersionRow().equals(timestamp)) {	
							bodegaAux.setVersionRow(timestamp);
						}
								
						bodegaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBodegas()throws Exception {	
		if(bodegas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Bodega bodegaAux:bodegas) {
					if(bodegaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bodegaAux.getIsDeleted() || (bodegaAux.getIsChanged()&&!bodegaAux.getIsNew())) {
						
						timestamp=bodegaDataAccess.getSetVersionRowBodega(connexion,bodegaAux.getId());
						
						if(!bodegaAux.getVersionRow().equals(timestamp)) {	
							bodegaAux.setVersionRow(timestamp);
						}
						
													
						bodegaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BodegaParameterReturnGeneral cargarCombosLoteForeignKeyBodegaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalGrupoBodega,String finalQueryGlobalCalidadProducto,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpleado,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalCuentaContableBonifica,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableCostoBonifica) throws Exception {
		BodegaParameterReturnGeneral  bodegaReturnGeneral =new BodegaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-cargarCombosLoteForeignKeyBodegaWithConnection");connexion.begin();
			
			bodegaReturnGeneral =new BodegaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bodegaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<GrupoBodega> grupobodegasForeignKey=new ArrayList<GrupoBodega>();
			GrupoBodegaLogic grupobodegaLogic=new GrupoBodegaLogic();
			grupobodegaLogic.setConnexion(this.connexion);
			grupobodegaLogic.getGrupoBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoBodega.equals("NONE")) {
				grupobodegaLogic.getTodosGrupoBodegas(finalQueryGlobalGrupoBodega,new Pagination());
				grupobodegasForeignKey=grupobodegaLogic.getGrupoBodegas();
			}

			bodegaReturnGeneral.setgrupobodegasForeignKey(grupobodegasForeignKey);


			List<CalidadProducto> calidadproductosForeignKey=new ArrayList<CalidadProducto>();
			CalidadProductoLogic calidadproductoLogic=new CalidadProductoLogic();
			calidadproductoLogic.setConnexion(this.connexion);
			calidadproductoLogic.getCalidadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCalidadProducto.equals("NONE")) {
				calidadproductoLogic.getTodosCalidadProductos(finalQueryGlobalCalidadProducto,new Pagination());
				calidadproductosForeignKey=calidadproductoLogic.getCalidadProductos();
			}

			bodegaReturnGeneral.setcalidadproductosForeignKey(calidadproductosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			bodegaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			bodegaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			bodegaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			bodegaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<CuentaContable> cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonificaLogic=new CuentaContableLogic();
			cuentacontablebonificaLogic.setConnexion(this.connexion);
			cuentacontablebonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBonifica.equals("NONE")) {
				cuentacontablebonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBonifica,new Pagination());
				cuentacontablebonificasForeignKey=cuentacontablebonificaLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablebonificasForeignKey(cuentacontablebonificasForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostobonificaLogic=new CuentaContableLogic();
			cuentacontablecostobonificaLogic.setConnexion(this.connexion);
			cuentacontablecostobonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoBonifica.equals("NONE")) {
				cuentacontablecostobonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoBonifica,new Pagination());
				cuentacontablecostobonificasForeignKey=cuentacontablecostobonificaLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablecostobonificasForeignKey(cuentacontablecostobonificasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return bodegaReturnGeneral;
	}
	
	public BodegaParameterReturnGeneral cargarCombosLoteForeignKeyBodega(String finalQueryGlobalEmpresa,String finalQueryGlobalGrupoBodega,String finalQueryGlobalCalidadProducto,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpleado,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalCuentaContableBonifica,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableCostoBonifica) throws Exception {
		BodegaParameterReturnGeneral  bodegaReturnGeneral =new BodegaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			bodegaReturnGeneral =new BodegaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bodegaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<GrupoBodega> grupobodegasForeignKey=new ArrayList<GrupoBodega>();
			GrupoBodegaLogic grupobodegaLogic=new GrupoBodegaLogic();
			grupobodegaLogic.setConnexion(this.connexion);
			grupobodegaLogic.getGrupoBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoBodega.equals("NONE")) {
				grupobodegaLogic.getTodosGrupoBodegas(finalQueryGlobalGrupoBodega,new Pagination());
				grupobodegasForeignKey=grupobodegaLogic.getGrupoBodegas();
			}

			bodegaReturnGeneral.setgrupobodegasForeignKey(grupobodegasForeignKey);


			List<CalidadProducto> calidadproductosForeignKey=new ArrayList<CalidadProducto>();
			CalidadProductoLogic calidadproductoLogic=new CalidadProductoLogic();
			calidadproductoLogic.setConnexion(this.connexion);
			calidadproductoLogic.getCalidadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCalidadProducto.equals("NONE")) {
				calidadproductoLogic.getTodosCalidadProductos(finalQueryGlobalCalidadProducto,new Pagination());
				calidadproductosForeignKey=calidadproductoLogic.getCalidadProductos();
			}

			bodegaReturnGeneral.setcalidadproductosForeignKey(calidadproductosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			bodegaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			bodegaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			bodegaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			bodegaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<CuentaContable> cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonificaLogic=new CuentaContableLogic();
			cuentacontablebonificaLogic.setConnexion(this.connexion);
			cuentacontablebonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBonifica.equals("NONE")) {
				cuentacontablebonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBonifica,new Pagination());
				cuentacontablebonificasForeignKey=cuentacontablebonificaLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablebonificasForeignKey(cuentacontablebonificasForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostobonificaLogic=new CuentaContableLogic();
			cuentacontablecostobonificaLogic.setConnexion(this.connexion);
			cuentacontablecostobonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoBonifica.equals("NONE")) {
				cuentacontablecostobonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoBonifica,new Pagination());
				cuentacontablecostobonificasForeignKey=cuentacontablecostobonificaLogic.getCuentaContables();
			}

			bodegaReturnGeneral.setcuentacontablecostobonificasForeignKey(cuentacontablecostobonificasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return bodegaReturnGeneral;
	}
	
	
	public void deepLoad(Bodega bodega,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BodegaLogicAdditional.updateBodegaToGet(bodega,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bodega.setEmpresa(bodegaDataAccess.getEmpresa(connexion,bodega));
		bodega.setGrupoBodega(bodegaDataAccess.getGrupoBodega(connexion,bodega));
		bodega.setCalidadProducto(bodegaDataAccess.getCalidadProducto(connexion,bodega));
		bodega.setPais(bodegaDataAccess.getPais(connexion,bodega));
		bodega.setCiudad(bodegaDataAccess.getCiudad(connexion,bodega));
		bodega.setCentroCosto(bodegaDataAccess.getCentroCosto(connexion,bodega));
		bodega.setEmpleado(bodegaDataAccess.getEmpleado(connexion,bodega));
		bodega.setCuentaContableInventario(bodegaDataAccess.getCuentaContableInventario(connexion,bodega));
		bodega.setCuentaContableCosto(bodegaDataAccess.getCuentaContableCosto(connexion,bodega));
		bodega.setCuentaContableVenta(bodegaDataAccess.getCuentaContableVenta(connexion,bodega));
		bodega.setCuentaContableDescuento(bodegaDataAccess.getCuentaContableDescuento(connexion,bodega));
		bodega.setCuentaContableDevolucion(bodegaDataAccess.getCuentaContableDevolucion(connexion,bodega));
		bodega.setCuentaContableDebito(bodegaDataAccess.getCuentaContableDebito(connexion,bodega));
		bodega.setCuentaContableCredito(bodegaDataAccess.getCuentaContableCredito(connexion,bodega));
		bodega.setCuentaContableBonifica(bodegaDataAccess.getCuentaContableBonifica(connexion,bodega));
		bodega.setCuentaContableProduccion(bodegaDataAccess.getCuentaContableProduccion(connexion,bodega));
		bodega.setCuentaContableCostoBonifica(bodegaDataAccess.getCuentaContableCostoBonifica(connexion,bodega));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bodega.setEmpresa(bodegaDataAccess.getEmpresa(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				bodega.setGrupoBodega(bodegaDataAccess.getGrupoBodega(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				bodega.setCalidadProducto(bodegaDataAccess.getCalidadProducto(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				bodega.setPais(bodegaDataAccess.getPais(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				bodega.setCiudad(bodegaDataAccess.getCiudad(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				bodega.setCentroCosto(bodegaDataAccess.getCentroCosto(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				bodega.setEmpleado(bodegaDataAccess.getEmpleado(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableInventario(bodegaDataAccess.getCuentaContableInventario(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableCosto(bodegaDataAccess.getCuentaContableCosto(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableVenta(bodegaDataAccess.getCuentaContableVenta(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableDescuento(bodegaDataAccess.getCuentaContableDescuento(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableDevolucion(bodegaDataAccess.getCuentaContableDevolucion(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableDebito(bodegaDataAccess.getCuentaContableDebito(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableCredito(bodegaDataAccess.getCuentaContableCredito(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableBonifica(bodegaDataAccess.getCuentaContableBonifica(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableProduccion(bodegaDataAccess.getCuentaContableProduccion(connexion,bodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableCostoBonifica(bodegaDataAccess.getCuentaContableCostoBonifica(connexion,bodega));
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
			bodega.setEmpresa(bodegaDataAccess.getEmpresa(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoBodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setGrupoBodega(bodegaDataAccess.getGrupoBodega(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalidadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCalidadProducto(bodegaDataAccess.getCalidadProducto(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setPais(bodegaDataAccess.getPais(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCiudad(bodegaDataAccess.getCiudad(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCentroCosto(bodegaDataAccess.getCentroCosto(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setEmpleado(bodegaDataAccess.getEmpleado(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableInventario(bodegaDataAccess.getCuentaContableInventario(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableCosto(bodegaDataAccess.getCuentaContableCosto(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableVenta(bodegaDataAccess.getCuentaContableVenta(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableDescuento(bodegaDataAccess.getCuentaContableDescuento(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableDevolucion(bodegaDataAccess.getCuentaContableDevolucion(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableDebito(bodegaDataAccess.getCuentaContableDebito(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableCredito(bodegaDataAccess.getCuentaContableCredito(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableBonifica(bodegaDataAccess.getCuentaContableBonifica(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableProduccion(bodegaDataAccess.getCuentaContableProduccion(connexion,bodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableCostoBonifica(bodegaDataAccess.getCuentaContableCostoBonifica(connexion,bodega));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bodega.setEmpresa(bodegaDataAccess.getEmpresa(connexion,bodega));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bodega.getEmpresa(),isDeep,deepLoadType,clases);
				
		bodega.setGrupoBodega(bodegaDataAccess.getGrupoBodega(connexion,bodega));
		GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
		grupobodegaLogic.deepLoad(bodega.getGrupoBodega(),isDeep,deepLoadType,clases);
				
		bodega.setCalidadProducto(bodegaDataAccess.getCalidadProducto(connexion,bodega));
		CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
		calidadproductoLogic.deepLoad(bodega.getCalidadProducto(),isDeep,deepLoadType,clases);
				
		bodega.setPais(bodegaDataAccess.getPais(connexion,bodega));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(bodega.getPais(),isDeep,deepLoadType,clases);
				
		bodega.setCiudad(bodegaDataAccess.getCiudad(connexion,bodega));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(bodega.getCiudad(),isDeep,deepLoadType,clases);
				
		bodega.setCentroCosto(bodegaDataAccess.getCentroCosto(connexion,bodega));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(bodega.getCentroCosto(),isDeep,deepLoadType,clases);
				
		bodega.setEmpleado(bodegaDataAccess.getEmpleado(connexion,bodega));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(bodega.getEmpleado(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableInventario(bodegaDataAccess.getCuentaContableInventario(connexion,bodega));
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(bodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableCosto(bodegaDataAccess.getCuentaContableCosto(connexion,bodega));
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(bodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableVenta(bodegaDataAccess.getCuentaContableVenta(connexion,bodega));
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(bodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableDescuento(bodegaDataAccess.getCuentaContableDescuento(connexion,bodega));
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(bodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableDevolucion(bodegaDataAccess.getCuentaContableDevolucion(connexion,bodega));
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(bodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableDebito(bodegaDataAccess.getCuentaContableDebito(connexion,bodega));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(bodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableCredito(bodegaDataAccess.getCuentaContableCredito(connexion,bodega));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(bodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableBonifica(bodegaDataAccess.getCuentaContableBonifica(connexion,bodega));
		CuentaContableLogic cuentacontablebonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablebonificaLogic.deepLoad(bodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableProduccion(bodegaDataAccess.getCuentaContableProduccion(connexion,bodega));
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(bodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		bodega.setCuentaContableCostoBonifica(bodegaDataAccess.getCuentaContableCostoBonifica(connexion,bodega));
		CuentaContableLogic cuentacontablecostobonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostobonificaLogic.deepLoad(bodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bodega.setEmpresa(bodegaDataAccess.getEmpresa(connexion,bodega));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(bodega.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				bodega.setGrupoBodega(bodegaDataAccess.getGrupoBodega(connexion,bodega));
				GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
				grupobodegaLogic.deepLoad(bodega.getGrupoBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				bodega.setCalidadProducto(bodegaDataAccess.getCalidadProducto(connexion,bodega));
				CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
				calidadproductoLogic.deepLoad(bodega.getCalidadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				bodega.setPais(bodegaDataAccess.getPais(connexion,bodega));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(bodega.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				bodega.setCiudad(bodegaDataAccess.getCiudad(connexion,bodega));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(bodega.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				bodega.setCentroCosto(bodegaDataAccess.getCentroCosto(connexion,bodega));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(bodega.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				bodega.setEmpleado(bodegaDataAccess.getEmpleado(connexion,bodega));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(bodega.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableInventario(bodegaDataAccess.getCuentaContableInventario(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableCosto(bodegaDataAccess.getCuentaContableCosto(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableVenta(bodegaDataAccess.getCuentaContableVenta(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableDescuento(bodegaDataAccess.getCuentaContableDescuento(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableDevolucion(bodegaDataAccess.getCuentaContableDevolucion(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableDebito(bodegaDataAccess.getCuentaContableDebito(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableCredito(bodegaDataAccess.getCuentaContableCredito(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableBonifica(bodegaDataAccess.getCuentaContableBonifica(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableProduccion(bodegaDataAccess.getCuentaContableProduccion(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				bodega.setCuentaContableCostoBonifica(bodegaDataAccess.getCuentaContableCostoBonifica(connexion,bodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(bodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);				
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
			bodega.setEmpresa(bodegaDataAccess.getEmpresa(connexion,bodega));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(bodega.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoBodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setGrupoBodega(bodegaDataAccess.getGrupoBodega(connexion,bodega));
			GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
			grupobodegaLogic.deepLoad(bodega.getGrupoBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CalidadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCalidadProducto(bodegaDataAccess.getCalidadProducto(connexion,bodega));
			CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
			calidadproductoLogic.deepLoad(bodega.getCalidadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setPais(bodegaDataAccess.getPais(connexion,bodega));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(bodega.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCiudad(bodegaDataAccess.getCiudad(connexion,bodega));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(bodega.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCentroCosto(bodegaDataAccess.getCentroCosto(connexion,bodega));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(bodega.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setEmpleado(bodegaDataAccess.getEmpleado(connexion,bodega));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(bodega.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableInventario(bodegaDataAccess.getCuentaContableInventario(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableCosto(bodegaDataAccess.getCuentaContableCosto(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableVenta(bodegaDataAccess.getCuentaContableVenta(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableDescuento(bodegaDataAccess.getCuentaContableDescuento(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableDevolucion(bodegaDataAccess.getCuentaContableDevolucion(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableDebito(bodegaDataAccess.getCuentaContableDebito(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableCredito(bodegaDataAccess.getCuentaContableCredito(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableBonifica(bodegaDataAccess.getCuentaContableBonifica(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableProduccion(bodegaDataAccess.getCuentaContableProduccion(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodega.setCuentaContableCostoBonifica(bodegaDataAccess.getCuentaContableCostoBonifica(connexion,bodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(bodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Bodega bodega,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BodegaLogicAdditional.updateBodegaToSave(bodega,this.arrDatoGeneral);
			
BodegaDataAccess.save(bodega, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bodega.getEmpresa(),connexion);

		GrupoBodegaDataAccess.save(bodega.getGrupoBodega(),connexion);

		CalidadProductoDataAccess.save(bodega.getCalidadProducto(),connexion);

		PaisDataAccess.save(bodega.getPais(),connexion);

		CiudadDataAccess.save(bodega.getCiudad(),connexion);

		CentroCostoDataAccess.save(bodega.getCentroCosto(),connexion);

		EmpleadoDataAccess.save(bodega.getEmpleado(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableInventario(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableCosto(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableVenta(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableDescuento(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableDevolucion(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableCredito(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableBonifica(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableProduccion(),connexion);

		CuentaContableDataAccess.save(bodega.getCuentaContableCostoBonifica(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bodega.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				GrupoBodegaDataAccess.save(bodega.getGrupoBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				CalidadProductoDataAccess.save(bodega.getCalidadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(bodega.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(bodega.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(bodega.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(bodega.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableDescuento(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableDevolucion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableBonifica(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableProduccion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableCostoBonifica(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bodega.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bodega.getEmpresa(),isDeep,deepLoadType,clases);
				

		GrupoBodegaDataAccess.save(bodega.getGrupoBodega(),connexion);
		GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
		grupobodegaLogic.deepLoad(bodega.getGrupoBodega(),isDeep,deepLoadType,clases);
				

		CalidadProductoDataAccess.save(bodega.getCalidadProducto(),connexion);
		CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
		calidadproductoLogic.deepLoad(bodega.getCalidadProducto(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(bodega.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(bodega.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(bodega.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(bodega.getCiudad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(bodega.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(bodega.getCentroCosto(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(bodega.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(bodega.getEmpleado(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableInventario(),connexion);
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(bodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableCosto(),connexion);
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(bodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableVenta(),connexion);
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(bodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableDescuento(),connexion);
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(bodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableDevolucion(),connexion);
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(bodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(bodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(bodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableBonifica(),connexion);
		CuentaContableLogic cuentacontablebonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablebonificaLogic.deepLoad(bodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableProduccion(),connexion);
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(bodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(bodega.getCuentaContableCostoBonifica(),connexion);
		CuentaContableLogic cuentacontablecostobonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostobonificaLogic.deepLoad(bodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bodega.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(bodega.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				GrupoBodegaDataAccess.save(bodega.getGrupoBodega(),connexion);
				GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
				grupobodegaLogic.deepSave(bodega.getGrupoBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				CalidadProductoDataAccess.save(bodega.getCalidadProducto(),connexion);
				CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
				calidadproductoLogic.deepSave(bodega.getCalidadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(bodega.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(bodega.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(bodega.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(bodega.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(bodega.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(bodega.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(bodega.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(bodega.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableInventario(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableCosto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableDescuento(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableDevolucion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableBonifica(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableProduccion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(bodega.getCuentaContableCostoBonifica(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(bodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Bodega.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(bodega,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(bodega);
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
			this.deepLoad(this.bodega,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Bodega.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(bodegas!=null) {
				for(Bodega bodega:bodegas) {
					this.deepLoad(bodega,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(bodegas);
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
			if(bodegas!=null) {
				for(Bodega bodega:bodegas) {
					this.deepLoad(bodega,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(bodegas);
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
			this.getNewConnexionToDeep(Bodega.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(bodega,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Bodega.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(bodegas!=null) {
				for(Bodega bodega:bodegas) {
					this.deepSave(bodega,isDeep,deepLoadType,clases);
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
			if(bodegas!=null) {
				for(Bodega bodega:bodegas) {
					this.deepSave(bodega,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBodegasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",BodegaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",BodegaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",BodegaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",BodegaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasBusquedaPorResponsableNombreWithConnection(String sFinalQuery,Pagination pagination,String responsable_nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralResponsableNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralResponsableNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+responsable_nombre+"%",BodegaConstantesFunciones.RESPONSABLENOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralResponsableNombre);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorResponsableNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasBusquedaPorResponsableNombre(String sFinalQuery,Pagination pagination,String responsable_nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralResponsableNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralResponsableNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+responsable_nombre+"%",BodegaConstantesFunciones.RESPONSABLENOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralResponsableNombre);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorResponsableNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasBusquedaPorRucWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",BodegaConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasBusquedaPorRuc(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",BodegaConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasBusquedaPorSiglasWithConnection(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",BodegaConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasBusquedaPorSiglas(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",BodegaConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasBusquedaPorTelefonoWithConnection(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",BodegaConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasBusquedaPorTelefono(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",BodegaConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCalidadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_calidad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCalidadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCalidadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_calidad_producto,BodegaConstantesFunciones.IDCALIDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCalidadProducto);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCalidadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCalidadProducto(String sFinalQuery,Pagination pagination,Long id_calidad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCalidadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCalidadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_calidad_producto,BodegaConstantesFunciones.IDCALIDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCalidadProducto);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCalidadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,BodegaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,BodegaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,BodegaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,BodegaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableBonificaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_bonifica)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_bonifica,BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBonifica);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableBonifica(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_bonifica)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_bonifica,BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBonifica);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,BodegaConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableCosto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,BodegaConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableCostoBonificaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_bonifica)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_bonifica,BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoBonifica);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableCostoBonifica(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_bonifica)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_bonifica,BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoBonifica);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,BodegaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,BodegaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableDescuentoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableDescuento(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableDevolucionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableDevolucion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableInventario(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableProduccionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableProduccion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdCuentaContableVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,BodegaConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdCuentaContableVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,BodegaConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,BodegaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,BodegaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdGrupoBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_bodega,BodegaConstantesFunciones.IDGRUPOBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoBodega);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdGrupoBodega(String sFinalQuery,Pagination pagination,Long id_grupo_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_bodega,BodegaConstantesFunciones.IDGRUPOBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoBodega);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Bodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,BodegaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,BodegaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			BodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(this.bodegas);
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
			if(BodegaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Bodega bodega,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BodegaConstantesFunciones.ISCONAUDITORIA) {
				if(bodega.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaDataAccess.TABLENAME, bodega.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BodegaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BodegaLogic.registrarAuditoriaDetallesBodega(connexion,bodega,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(bodega.getIsDeleted()) {
					/*if(!bodega.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BodegaDataAccess.TABLENAME, bodega.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BodegaLogic.registrarAuditoriaDetallesBodega(connexion,bodega,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaDataAccess.TABLENAME, bodega.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(bodega.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaDataAccess.TABLENAME, bodega.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BodegaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BodegaLogic.registrarAuditoriaDetallesBodega(connexion,bodega,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBodega(Connexion connexion,Bodega bodega)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(bodega.getIsNew()||!bodega.getid_empresa().equals(bodega.getBodegaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_empresa()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_empresa().toString();
				}
				if(bodega.getid_empresa()!=null)
				{
					strValorNuevo=bodega.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_grupo_bodega().equals(bodega.getBodegaOriginal().getid_grupo_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_grupo_bodega()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_grupo_bodega().toString();
				}
				if(bodega.getid_grupo_bodega()!=null)
				{
					strValorNuevo=bodega.getid_grupo_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDGRUPOBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_calidad_producto().equals(bodega.getBodegaOriginal().getid_calidad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_calidad_producto()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_calidad_producto().toString();
				}
				if(bodega.getid_calidad_producto()!=null)
				{
					strValorNuevo=bodega.getid_calidad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCALIDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getcodigo().equals(bodega.getBodegaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getcodigo()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getcodigo();
				}
				if(bodega.getcodigo()!=null)
				{
					strValorNuevo=bodega.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getnombre().equals(bodega.getBodegaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getnombre()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getnombre();
				}
				if(bodega.getnombre()!=null)
				{
					strValorNuevo=bodega.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getsiglas().equals(bodega.getBodegaOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getsiglas()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getsiglas();
				}
				if(bodega.getsiglas()!=null)
				{
					strValorNuevo=bodega.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getdireccion().equals(bodega.getBodegaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getdireccion()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getdireccion();
				}
				if(bodega.getdireccion()!=null)
				{
					strValorNuevo=bodega.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.gettelefono().equals(bodega.getBodegaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().gettelefono()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().gettelefono();
				}
				if(bodega.gettelefono()!=null)
				{
					strValorNuevo=bodega.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getruc().equals(bodega.getBodegaOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getruc()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getruc();
				}
				if(bodega.getruc()!=null)
				{
					strValorNuevo=bodega.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getresponsable_nombre().equals(bodega.getBodegaOriginal().getresponsable_nombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getresponsable_nombre()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getresponsable_nombre();
				}
				if(bodega.getresponsable_nombre()!=null)
				{
					strValorNuevo=bodega.getresponsable_nombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.RESPONSABLENOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getdescripcion().equals(bodega.getBodegaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getdescripcion()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getdescripcion();
				}
				if(bodega.getdescripcion()!=null)
				{
					strValorNuevo=bodega.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_pais().equals(bodega.getBodegaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_pais()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_pais().toString();
				}
				if(bodega.getid_pais()!=null)
				{
					strValorNuevo=bodega.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_ciudad().equals(bodega.getBodegaOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_ciudad()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_ciudad().toString();
				}
				if(bodega.getid_ciudad()!=null)
				{
					strValorNuevo=bodega.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_centro_costo().equals(bodega.getBodegaOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_centro_costo()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_centro_costo().toString();
				}
				if(bodega.getid_centro_costo()!=null)
				{
					strValorNuevo=bodega.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_empleado().equals(bodega.getBodegaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_empleado()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_empleado().toString();
				}
				if(bodega.getid_empleado()!=null)
				{
					strValorNuevo=bodega.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getes_multi_empresa().equals(bodega.getBodegaOriginal().getes_multi_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getes_multi_empresa()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getes_multi_empresa().toString();
				}
				if(bodega.getes_multi_empresa()!=null)
				{
					strValorNuevo=bodega.getes_multi_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.ESMULTIEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getcon_mostrar_stock().equals(bodega.getBodegaOriginal().getcon_mostrar_stock()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getcon_mostrar_stock()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getcon_mostrar_stock().toString();
				}
				if(bodega.getcon_mostrar_stock()!=null)
				{
					strValorNuevo=bodega.getcon_mostrar_stock().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.CONMOSTRARSTOCK,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getes_bodega_transito().equals(bodega.getBodegaOriginal().getes_bodega_transito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getes_bodega_transito()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getes_bodega_transito().toString();
				}
				if(bodega.getes_bodega_transito()!=null)
				{
					strValorNuevo=bodega.getes_bodega_transito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.ESBODEGATRANSITO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getcon_stock_negativo().equals(bodega.getBodegaOriginal().getcon_stock_negativo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getcon_stock_negativo()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getcon_stock_negativo().toString();
				}
				if(bodega.getcon_stock_negativo()!=null)
				{
					strValorNuevo=bodega.getcon_stock_negativo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.CONSTOCKNEGATIVO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_inventario().equals(bodega.getBodegaOriginal().getid_cuenta_contable_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_inventario()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_inventario().toString();
				}
				if(bodega.getid_cuenta_contable_inventario()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_costo().equals(bodega.getBodegaOriginal().getid_cuenta_contable_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_costo()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_costo().toString();
				}
				if(bodega.getid_cuenta_contable_costo()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLECOSTO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_venta().equals(bodega.getBodegaOriginal().getid_cuenta_contable_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_venta()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_venta().toString();
				}
				if(bodega.getid_cuenta_contable_venta()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_descuento().equals(bodega.getBodegaOriginal().getid_cuenta_contable_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_descuento()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_descuento().toString();
				}
				if(bodega.getid_cuenta_contable_descuento()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_devolucion().equals(bodega.getBodegaOriginal().getid_cuenta_contable_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_devolucion()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_devolucion().toString();
				}
				if(bodega.getid_cuenta_contable_devolucion()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_debito().equals(bodega.getBodegaOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_debito().toString();
				}
				if(bodega.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_credito().equals(bodega.getBodegaOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_credito().toString();
				}
				if(bodega.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_bonifica().equals(bodega.getBodegaOriginal().getid_cuenta_contable_bonifica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_bonifica()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_bonifica().toString();
				}
				if(bodega.getid_cuenta_contable_bonifica()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_bonifica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_produccion().equals(bodega.getBodegaOriginal().getid_cuenta_contable_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_produccion()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_produccion().toString();
				}
				if(bodega.getid_cuenta_contable_produccion()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(bodega.getIsNew()||!bodega.getid_cuenta_contable_costo_bonifica().equals(bodega.getBodegaOriginal().getid_cuenta_contable_costo_bonifica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodega.getBodegaOriginal().getid_cuenta_contable_costo_bonifica()!=null)
				{
					strValorActual=bodega.getBodegaOriginal().getid_cuenta_contable_costo_bonifica().toString();
				}
				if(bodega.getid_cuenta_contable_costo_bonifica()!=null)
				{
					strValorNuevo=bodega.getid_cuenta_contable_costo_bonifica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBodegaRelacionesWithConnection(Bodega bodega) throws Exception {

		if(!bodega.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBodegaRelacionesBase(bodega,true);
		}
	}

	public void saveBodegaRelaciones(Bodega bodega)throws Exception {

		if(!bodega.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBodegaRelacionesBase(bodega,false);
		}
	}

	public void saveBodegaRelacionesBase(Bodega bodega,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Bodega-saveRelacionesWithConnection");}
	

			this.setBodega(bodega);

			if(BodegaLogicAdditional.validarSaveRelaciones(bodega,this)) {

				BodegaLogicAdditional.updateRelacionesToSave(bodega,this);

				if((bodega.getIsNew()||bodega.getIsChanged())&&!bodega.getIsDeleted()) {
					this.saveBodega();
					this.saveBodegaRelacionesDetalles();

				} else if(bodega.getIsDeleted()) {
					this.saveBodegaRelacionesDetalles();
					this.saveBodega();
				}

				BodegaLogicAdditional.updateRelacionesToSaveAfter(bodega,this);

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
	
	
	private void saveBodegaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BodegaConstantesFunciones.getClassesForeignKeysOfBodega(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BodegaConstantesFunciones.getClassesRelationshipsOfBodega(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
