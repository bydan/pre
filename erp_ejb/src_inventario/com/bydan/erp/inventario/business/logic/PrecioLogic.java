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
import com.bydan.erp.inventario.util.PrecioConstantesFunciones;
import com.bydan.erp.inventario.util.PrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PrecioParameterGeneral;
import com.bydan.erp.inventario.business.entity.Precio;
import com.bydan.erp.inventario.business.logic.PrecioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PrecioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PrecioLogic.class);
	
	protected PrecioDataAccess precioDataAccess; 	
	protected Precio precio;
	protected List<Precio> precios;
	protected Object precioObject;	
	protected List<Object> preciosObject;
	
	public static ClassValidator<Precio> precioValidator = new ClassValidator<Precio>(Precio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PrecioLogicAdditional precioLogicAdditional=null;
	
	public PrecioLogicAdditional getPrecioLogicAdditional() {
		return this.precioLogicAdditional;
	}
	
	public void setPrecioLogicAdditional(PrecioLogicAdditional precioLogicAdditional) {
		try {
			this.precioLogicAdditional=precioLogicAdditional;
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
	
	
	
	
	public  PrecioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.precioDataAccess = new PrecioDataAccess();
			
			this.precios= new ArrayList<Precio>();
			this.precio= new Precio();
			
			this.precioObject=new Object();
			this.preciosObject=new ArrayList<Object>();
				
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
			
			this.precioDataAccess.setConnexionType(this.connexionType);
			this.precioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PrecioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.precioDataAccess = new PrecioDataAccess();
			this.precios= new ArrayList<Precio>();
			this.precio= new Precio();
			this.precioObject=new Object();
			this.preciosObject=new ArrayList<Object>();
			
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
			
			this.precioDataAccess.setConnexionType(this.connexionType);
			this.precioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Precio getPrecio() throws Exception {	
		PrecioLogicAdditional.checkPrecioToGet(precio,this.datosCliente,this.arrDatoGeneral);
		PrecioLogicAdditional.updatePrecioToGet(precio,this.arrDatoGeneral);
		
		return precio;
	}
		
	public void setPrecio(Precio newPrecio) {
		this.precio = newPrecio;
	}
	
	public PrecioDataAccess getPrecioDataAccess() {
		return precioDataAccess;
	}
	
	public void setPrecioDataAccess(PrecioDataAccess newprecioDataAccess) {
		this.precioDataAccess = newprecioDataAccess;
	}
	
	public List<Precio> getPrecios() throws Exception {		
		this.quitarPreciosNulos();
		
		PrecioLogicAdditional.checkPrecioToGets(precios,this.datosCliente,this.arrDatoGeneral);
		
		for (Precio precioLocal: precios ) {
			PrecioLogicAdditional.updatePrecioToGet(precioLocal,this.arrDatoGeneral);
		}
		
		return precios;
	}
	
	public void setPrecios(List<Precio> newPrecios) {
		this.precios = newPrecios;
	}
	
	public Object getPrecioObject() {	
		this.precioObject=this.precioDataAccess.getEntityObject();
		return this.precioObject;
	}
		
	public void setPrecioObject(Object newPrecioObject) {
		this.precioObject = newPrecioObject;
	}
	
	public List<Object> getPreciosObject() {		
		this.preciosObject=this.precioDataAccess.getEntitiesObject();
		return this.preciosObject;
	}
		
	public void setPreciosObject(List<Object> newPreciosObject) {
		this.preciosObject = newPreciosObject;
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
		
		if(this.precioDataAccess!=null) {
			this.precioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			precioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			precioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		precio = new  Precio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			precio=precioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.precio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precio);
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
		precio = new  Precio();
		  		  
        try {
			
			precio=precioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.precio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		precio = new  Precio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			precio=precioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.precio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precio);
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
		precio = new  Precio();
		  		  
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
		precio = new  Precio();
		  		  
        try {
			
			precio=precioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.precio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		precio = new  Precio();
		  		  
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
		precio = new  Precio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =precioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		precio = new  Precio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=precioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		precio = new  Precio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =precioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		precio = new  Precio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=precioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		precio = new  Precio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =precioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		precio = new  Precio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=precioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		precios = new  ArrayList<Precio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
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
		precios = new  ArrayList<Precio>();
		  		  
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
		precios = new  ArrayList<Precio>();
		  		  
        try {			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		precios = new  ArrayList<Precio>();
		  		  
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
		precios = new  ArrayList<Precio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
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
		precios = new  ArrayList<Precio>();
		  		  
        try {
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
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
		precios = new  ArrayList<Precio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
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
		precios = new  ArrayList<Precio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		precio = new  Precio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precio=precioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrecio(precio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precio);
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
		precio = new  Precio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precio=precioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrecio(precio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		precios = new  ArrayList<Precio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
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
		precios = new  ArrayList<Precio>();
		  		  
        try {
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPreciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		precios = new  ArrayList<Precio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getTodosPreciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
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
	
	public  void  getTodosPrecios(String sFinalQuery,Pagination pagination)throws Exception {
		precios = new  ArrayList<Precio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPrecio(precios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPrecio(Precio precio) throws Exception {
		Boolean estaValidado=false;
		
		if(precio.getIsNew() || precio.getIsChanged()) { 
			this.invalidValues = precioValidator.getInvalidValues(precio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(precio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPrecio(List<Precio> Precios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Precio precioLocal:precios) {				
			estaValidadoObjeto=this.validarGuardarPrecio(precioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPrecio(List<Precio> Precios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPrecio(precios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPrecio(Precio Precio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPrecio(precio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Precio precio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+precio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PrecioConstantesFunciones.getPrecioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"precio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePrecioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-savePrecioWithConnection");connexion.begin();			
			
			PrecioLogicAdditional.checkPrecioToSave(this.precio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PrecioLogicAdditional.updatePrecioToSave(this.precio,this.arrDatoGeneral);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.precio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPrecio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPrecio(this.precio)) {
				PrecioDataAccess.save(this.precio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.precio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PrecioLogicAdditional.checkPrecioToSaveAfter(this.precio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPrecio();
			
			connexion.commit();			
			
			if(this.precio.getIsDeleted()) {
				this.precio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePrecio()throws Exception {	
		try {	
			
			PrecioLogicAdditional.checkPrecioToSave(this.precio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PrecioLogicAdditional.updatePrecioToSave(this.precio,this.arrDatoGeneral);
			
			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.precio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPrecio(this.precio)) {			
				PrecioDataAccess.save(this.precio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.precio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PrecioLogicAdditional.checkPrecioToSaveAfter(this.precio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.precio.getIsDeleted()) {
				this.precio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePreciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-savePreciosWithConnection");connexion.begin();			
			
			PrecioLogicAdditional.checkPrecioToSaves(precios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPrecios();
			
			Boolean validadoTodosPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Precio precioLocal:precios) {		
				if(precioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PrecioLogicAdditional.updatePrecioToSave(precioLocal,this.arrDatoGeneral);
	        	
				PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),precioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPrecio(precioLocal)) {
					PrecioDataAccess.save(precioLocal, connexion);				
				} else {
					validadoTodosPrecio=false;
				}
			}
			
			if(!validadoTodosPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PrecioLogicAdditional.checkPrecioToSavesAfter(precios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPrecios();
			
			connexion.commit();		
			
			this.quitarPreciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePrecios()throws Exception {				
		 try {	
			PrecioLogicAdditional.checkPrecioToSaves(precios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Precio precioLocal:precios) {				
				if(precioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PrecioLogicAdditional.updatePrecioToSave(precioLocal,this.arrDatoGeneral);
	        	
				PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),precioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPrecio(precioLocal)) {				
					PrecioDataAccess.save(precioLocal, connexion);				
				} else {
					validadoTodosPrecio=false;
				}
			}
			
			if(!validadoTodosPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PrecioLogicAdditional.checkPrecioToSavesAfter(precios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPreciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PrecioParameterReturnGeneral procesarAccionPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Precio> precios,PrecioParameterReturnGeneral precioParameterGeneral)throws Exception {
		 try {	
			PrecioParameterReturnGeneral precioReturnGeneral=new PrecioParameterReturnGeneral();
	
			PrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,precios,precioParameterGeneral,precioReturnGeneral);
			
			return precioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PrecioParameterReturnGeneral procesarAccionPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Precio> precios,PrecioParameterReturnGeneral precioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-procesarAccionPreciosWithConnection");connexion.begin();			
			
			PrecioParameterReturnGeneral precioReturnGeneral=new PrecioParameterReturnGeneral();
	
			PrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,precios,precioParameterGeneral,precioReturnGeneral);
			
			this.connexion.commit();
			
			return precioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PrecioParameterReturnGeneral procesarEventosPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Precio> precios,Precio precio,PrecioParameterReturnGeneral precioParameterGeneral,Boolean isEsNuevoPrecio,ArrayList<Classe> clases)throws Exception {
		 try {	
			PrecioParameterReturnGeneral precioReturnGeneral=new PrecioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				precioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,precios,precio,precioParameterGeneral,precioReturnGeneral,isEsNuevoPrecio,clases);
			
			return precioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PrecioParameterReturnGeneral procesarEventosPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Precio> precios,Precio precio,PrecioParameterReturnGeneral precioParameterGeneral,Boolean isEsNuevoPrecio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-procesarEventosPreciosWithConnection");connexion.begin();			
			
			PrecioParameterReturnGeneral precioReturnGeneral=new PrecioParameterReturnGeneral();
	
			precioReturnGeneral.setPrecio(precio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				precioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,precios,precio,precioParameterGeneral,precioReturnGeneral,isEsNuevoPrecio,clases);
			
			this.connexion.commit();
			
			return precioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PrecioParameterReturnGeneral procesarImportacionPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PrecioParameterReturnGeneral precioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-procesarImportacionPreciosWithConnection");connexion.begin();			
			
			PrecioParameterReturnGeneral precioReturnGeneral=new PrecioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.precios=new ArrayList<Precio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.precio=new Precio();
				
				
				if(conColumnasBase) {this.precio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.precio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.precio.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.precio.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.precio.setprecio_minimo(Double.parseDouble(arrColumnas[iColumn++]));
				this.precio.setcon_impuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.precios.add(this.precio);
			}
			
			this.savePrecios();
			
			this.connexion.commit();
			
			precioReturnGeneral.setConRetornoEstaProcesado(true);
			precioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return precioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPreciosEliminados() throws Exception {				
		
		List<Precio> preciosAux= new ArrayList<Precio>();
		
		for(Precio precio:precios) {
			if(!precio.getIsDeleted()) {
				preciosAux.add(precio);
			}
		}
		
		precios=preciosAux;
	}
	
	public void quitarPreciosNulos() throws Exception {				
		
		List<Precio> preciosAux= new ArrayList<Precio>();
		
		for(Precio precio : this.precios) {
			if(precio==null) {
				preciosAux.add(precio);
			}
		}
		
		//this.precios=preciosAux;
		
		this.precios.removeAll(preciosAux);
	}
	
	public void getSetVersionRowPrecioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(precio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((precio.getIsDeleted() || (precio.getIsChanged()&&!precio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=precioDataAccess.getSetVersionRowPrecio(connexion,precio.getId());
				
				if(!precio.getVersionRow().equals(timestamp)) {	
					precio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				precio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPrecio()throws Exception {	
		
		if(precio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((precio.getIsDeleted() || (precio.getIsChanged()&&!precio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=precioDataAccess.getSetVersionRowPrecio(connexion,precio.getId());
			
			try {							
				if(!precio.getVersionRow().equals(timestamp)) {	
					precio.setVersionRow(timestamp);
				}
				
				precio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPreciosWithConnection()throws Exception {	
		if(precios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Precio precioAux:precios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(precioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(precioAux.getIsDeleted() || (precioAux.getIsChanged()&&!precioAux.getIsNew())) {
						
						timestamp=precioDataAccess.getSetVersionRowPrecio(connexion,precioAux.getId());
						
						if(!precio.getVersionRow().equals(timestamp)) {	
							precioAux.setVersionRow(timestamp);
						}
								
						precioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPrecios()throws Exception {	
		if(precios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Precio precioAux:precios) {
					if(precioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(precioAux.getIsDeleted() || (precioAux.getIsChanged()&&!precioAux.getIsNew())) {
						
						timestamp=precioDataAccess.getSetVersionRowPrecio(connexion,precioAux.getId());
						
						if(!precioAux.getVersionRow().equals(timestamp)) {	
							precioAux.setVersionRow(timestamp);
						}
						
													
						precioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PrecioParameterReturnGeneral cargarCombosLoteForeignKeyPrecioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca,String finalQueryGlobalRangoUnidadVenta,String finalQueryGlobalTipoPrecio,String finalQueryGlobalEstadoPrecio) throws Exception {
		PrecioParameterReturnGeneral  precioReturnGeneral =new PrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-cargarCombosLoteForeignKeyPrecioWithConnection");connexion.begin();
			
			precioReturnGeneral =new PrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			precioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			precioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			precioReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			precioReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			precioReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			precioReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			precioReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			precioReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);


			List<RangoUnidadVenta> rangounidadventasForeignKey=new ArrayList<RangoUnidadVenta>();
			RangoUnidadVentaLogic rangounidadventaLogic=new RangoUnidadVentaLogic();
			rangounidadventaLogic.setConnexion(this.connexion);
			rangounidadventaLogic.getRangoUnidadVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRangoUnidadVenta.equals("NONE")) {
				rangounidadventaLogic.getTodosRangoUnidadVentas(finalQueryGlobalRangoUnidadVenta,new Pagination());
				rangounidadventasForeignKey=rangounidadventaLogic.getRangoUnidadVentas();
			}

			precioReturnGeneral.setrangounidadventasForeignKey(rangounidadventasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			precioReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<EstadoPrecio> estadopreciosForeignKey=new ArrayList<EstadoPrecio>();
			EstadoPrecioLogic estadoprecioLogic=new EstadoPrecioLogic();
			estadoprecioLogic.setConnexion(this.connexion);
			estadoprecioLogic.getEstadoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPrecio.equals("NONE")) {
				estadoprecioLogic.getTodosEstadoPrecios(finalQueryGlobalEstadoPrecio,new Pagination());
				estadopreciosForeignKey=estadoprecioLogic.getEstadoPrecios();
			}

			precioReturnGeneral.setestadopreciosForeignKey(estadopreciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return precioReturnGeneral;
	}
	
	public PrecioParameterReturnGeneral cargarCombosLoteForeignKeyPrecio(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca,String finalQueryGlobalRangoUnidadVenta,String finalQueryGlobalTipoPrecio,String finalQueryGlobalEstadoPrecio) throws Exception {
		PrecioParameterReturnGeneral  precioReturnGeneral =new PrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			precioReturnGeneral =new PrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			precioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			precioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			precioReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			precioReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			precioReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			precioReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			precioReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			precioReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);


			List<RangoUnidadVenta> rangounidadventasForeignKey=new ArrayList<RangoUnidadVenta>();
			RangoUnidadVentaLogic rangounidadventaLogic=new RangoUnidadVentaLogic();
			rangounidadventaLogic.setConnexion(this.connexion);
			rangounidadventaLogic.getRangoUnidadVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRangoUnidadVenta.equals("NONE")) {
				rangounidadventaLogic.getTodosRangoUnidadVentas(finalQueryGlobalRangoUnidadVenta,new Pagination());
				rangounidadventasForeignKey=rangounidadventaLogic.getRangoUnidadVentas();
			}

			precioReturnGeneral.setrangounidadventasForeignKey(rangounidadventasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			precioReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<EstadoPrecio> estadopreciosForeignKey=new ArrayList<EstadoPrecio>();
			EstadoPrecioLogic estadoprecioLogic=new EstadoPrecioLogic();
			estadoprecioLogic.setConnexion(this.connexion);
			estadoprecioLogic.getEstadoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPrecio.equals("NONE")) {
				estadoprecioLogic.getTodosEstadoPrecios(finalQueryGlobalEstadoPrecio,new Pagination());
				estadopreciosForeignKey=estadoprecioLogic.getEstadoPrecios();
			}

			precioReturnGeneral.setestadopreciosForeignKey(estadopreciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return precioReturnGeneral;
	}
	
	
	public void deepLoad(Precio precio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PrecioLogicAdditional.updatePrecioToGet(precio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		precio.setEmpresa(precioDataAccess.getEmpresa(connexion,precio));
		precio.setSucursal(precioDataAccess.getSucursal(connexion,precio));
		precio.setBodega(precioDataAccess.getBodega(connexion,precio));
		precio.setProducto(precioDataAccess.getProducto(connexion,precio));
		precio.setLinea(precioDataAccess.getLinea(connexion,precio));
		precio.setLineaGrupo(precioDataAccess.getLineaGrupo(connexion,precio));
		precio.setLineaCategoria(precioDataAccess.getLineaCategoria(connexion,precio));
		precio.setLineaMarca(precioDataAccess.getLineaMarca(connexion,precio));
		precio.setRangoUnidadVenta(precioDataAccess.getRangoUnidadVenta(connexion,precio));
		precio.setTipoPrecio(precioDataAccess.getTipoPrecio(connexion,precio));
		precio.setEstadoPrecio(precioDataAccess.getEstadoPrecio(connexion,precio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				precio.setEmpresa(precioDataAccess.getEmpresa(connexion,precio));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				precio.setSucursal(precioDataAccess.getSucursal(connexion,precio));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				precio.setBodega(precioDataAccess.getBodega(connexion,precio));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				precio.setProducto(precioDataAccess.getProducto(connexion,precio));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLinea(precioDataAccess.getLinea(connexion,precio));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLineaGrupo(precioDataAccess.getLineaGrupo(connexion,precio));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLineaCategoria(precioDataAccess.getLineaCategoria(connexion,precio));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLineaMarca(precioDataAccess.getLineaMarca(connexion,precio));
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				precio.setRangoUnidadVenta(precioDataAccess.getRangoUnidadVenta(connexion,precio));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				precio.setTipoPrecio(precioDataAccess.getTipoPrecio(connexion,precio));
				continue;
			}

			if(clas.clas.equals(EstadoPrecio.class)) {
				precio.setEstadoPrecio(precioDataAccess.getEstadoPrecio(connexion,precio));
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
			precio.setEmpresa(precioDataAccess.getEmpresa(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setSucursal(precioDataAccess.getSucursal(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setBodega(precioDataAccess.getBodega(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setProducto(precioDataAccess.getProducto(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLinea(precioDataAccess.getLinea(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLineaGrupo(precioDataAccess.getLineaGrupo(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLineaCategoria(precioDataAccess.getLineaCategoria(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLineaMarca(precioDataAccess.getLineaMarca(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RangoUnidadVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setRangoUnidadVenta(precioDataAccess.getRangoUnidadVenta(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setTipoPrecio(precioDataAccess.getTipoPrecio(connexion,precio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setEstadoPrecio(precioDataAccess.getEstadoPrecio(connexion,precio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		precio.setEmpresa(precioDataAccess.getEmpresa(connexion,precio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(precio.getEmpresa(),isDeep,deepLoadType,clases);
				
		precio.setSucursal(precioDataAccess.getSucursal(connexion,precio));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(precio.getSucursal(),isDeep,deepLoadType,clases);
				
		precio.setBodega(precioDataAccess.getBodega(connexion,precio));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(precio.getBodega(),isDeep,deepLoadType,clases);
				
		precio.setProducto(precioDataAccess.getProducto(connexion,precio));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(precio.getProducto(),isDeep,deepLoadType,clases);
				
		precio.setLinea(precioDataAccess.getLinea(connexion,precio));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(precio.getLinea(),isDeep,deepLoadType,clases);
				
		precio.setLineaGrupo(precioDataAccess.getLineaGrupo(connexion,precio));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(precio.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		precio.setLineaCategoria(precioDataAccess.getLineaCategoria(connexion,precio));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(precio.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		precio.setLineaMarca(precioDataAccess.getLineaMarca(connexion,precio));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(precio.getLineaMarca(),isDeep,deepLoadType,clases);
				
		precio.setRangoUnidadVenta(precioDataAccess.getRangoUnidadVenta(connexion,precio));
		RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
		rangounidadventaLogic.deepLoad(precio.getRangoUnidadVenta(),isDeep,deepLoadType,clases);
				
		precio.setTipoPrecio(precioDataAccess.getTipoPrecio(connexion,precio));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(precio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		precio.setEstadoPrecio(precioDataAccess.getEstadoPrecio(connexion,precio));
		EstadoPrecioLogic estadoprecioLogic= new EstadoPrecioLogic(connexion);
		estadoprecioLogic.deepLoad(precio.getEstadoPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				precio.setEmpresa(precioDataAccess.getEmpresa(connexion,precio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(precio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				precio.setSucursal(precioDataAccess.getSucursal(connexion,precio));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(precio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				precio.setBodega(precioDataAccess.getBodega(connexion,precio));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(precio.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				precio.setProducto(precioDataAccess.getProducto(connexion,precio));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(precio.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLinea(precioDataAccess.getLinea(connexion,precio));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(precio.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLineaGrupo(precioDataAccess.getLineaGrupo(connexion,precio));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(precio.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLineaCategoria(precioDataAccess.getLineaCategoria(connexion,precio));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(precio.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				precio.setLineaMarca(precioDataAccess.getLineaMarca(connexion,precio));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(precio.getLineaMarca(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				precio.setRangoUnidadVenta(precioDataAccess.getRangoUnidadVenta(connexion,precio));
				RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
				rangounidadventaLogic.deepLoad(precio.getRangoUnidadVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				precio.setTipoPrecio(precioDataAccess.getTipoPrecio(connexion,precio));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(precio.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPrecio.class)) {
				precio.setEstadoPrecio(precioDataAccess.getEstadoPrecio(connexion,precio));
				EstadoPrecioLogic estadoprecioLogic= new EstadoPrecioLogic(connexion);
				estadoprecioLogic.deepLoad(precio.getEstadoPrecio(),isDeep,deepLoadType,clases);				
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
			precio.setEmpresa(precioDataAccess.getEmpresa(connexion,precio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(precio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setSucursal(precioDataAccess.getSucursal(connexion,precio));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(precio.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setBodega(precioDataAccess.getBodega(connexion,precio));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(precio.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setProducto(precioDataAccess.getProducto(connexion,precio));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(precio.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLinea(precioDataAccess.getLinea(connexion,precio));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(precio.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLineaGrupo(precioDataAccess.getLineaGrupo(connexion,precio));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(precio.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLineaCategoria(precioDataAccess.getLineaCategoria(connexion,precio));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(precio.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setLineaMarca(precioDataAccess.getLineaMarca(connexion,precio));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(precio.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RangoUnidadVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setRangoUnidadVenta(precioDataAccess.getRangoUnidadVenta(connexion,precio));
			RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
			rangounidadventaLogic.deepLoad(precio.getRangoUnidadVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setTipoPrecio(precioDataAccess.getTipoPrecio(connexion,precio));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(precio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			precio.setEstadoPrecio(precioDataAccess.getEstadoPrecio(connexion,precio));
			EstadoPrecioLogic estadoprecioLogic= new EstadoPrecioLogic(connexion);
			estadoprecioLogic.deepLoad(precio.getEstadoPrecio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Precio precio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PrecioLogicAdditional.updatePrecioToSave(precio,this.arrDatoGeneral);
			
PrecioDataAccess.save(precio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(precio.getEmpresa(),connexion);

		SucursalDataAccess.save(precio.getSucursal(),connexion);

		BodegaDataAccess.save(precio.getBodega(),connexion);

		ProductoDataAccess.save(precio.getProducto(),connexion);

		LineaDataAccess.save(precio.getLinea(),connexion);

		LineaDataAccess.save(precio.getLineaGrupo(),connexion);

		LineaDataAccess.save(precio.getLineaCategoria(),connexion);

		LineaDataAccess.save(precio.getLineaMarca(),connexion);

		RangoUnidadVentaDataAccess.save(precio.getRangoUnidadVenta(),connexion);

		TipoPrecioDataAccess.save(precio.getTipoPrecio(),connexion);

		EstadoPrecioDataAccess.save(precio.getEstadoPrecio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(precio.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(precio.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(precio.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(precio.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLineaMarca(),connexion);
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				RangoUnidadVentaDataAccess.save(precio.getRangoUnidadVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(precio.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPrecio.class)) {
				EstadoPrecioDataAccess.save(precio.getEstadoPrecio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(precio.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(precio.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(precio.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(precio.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(precio.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(precio.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(precio.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(precio.getProducto(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(precio.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(precio.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(precio.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(precio.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(precio.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(precio.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(precio.getLineaMarca(),connexion);
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(precio.getLineaMarca(),isDeep,deepLoadType,clases);
				

		RangoUnidadVentaDataAccess.save(precio.getRangoUnidadVenta(),connexion);
		RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
		rangounidadventaLogic.deepLoad(precio.getRangoUnidadVenta(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(precio.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(precio.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		EstadoPrecioDataAccess.save(precio.getEstadoPrecio(),connexion);
		EstadoPrecioLogic estadoprecioLogic= new EstadoPrecioLogic(connexion);
		estadoprecioLogic.deepLoad(precio.getEstadoPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(precio.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(precio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(precio.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(precio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(precio.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(precio.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(precio.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(precio.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(precio.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(precio.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(precio.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(precio.getLineaMarca(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(precio.getLineaMarca(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				RangoUnidadVentaDataAccess.save(precio.getRangoUnidadVenta(),connexion);
				RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
				rangounidadventaLogic.deepSave(precio.getRangoUnidadVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(precio.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(precio.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPrecio.class)) {
				EstadoPrecioDataAccess.save(precio.getEstadoPrecio(),connexion);
				EstadoPrecioLogic estadoprecioLogic= new EstadoPrecioLogic(connexion);
				estadoprecioLogic.deepSave(precio.getEstadoPrecio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Precio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(precio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precio);
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
			this.deepLoad(this.precio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Precio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(precios!=null) {
				for(Precio precio:precios) {
					this.deepLoad(precio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precios);
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
			if(precios!=null) {
				for(Precio precio:precios) {
					this.deepLoad(precio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precios);
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
			this.getNewConnexionToDeep(Precio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(precio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Precio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(precios!=null) {
				for(Precio precio:precios) {
					this.deepSave(precio,isDeep,deepLoadType,clases);
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
			if(precios!=null) {
				for(Precio precio:precios) {
					this.deepSave(precio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPreciosBusquedaPorIdBodegaPorIdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,PrecioConstantesFunciones.IDBODEGA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PrecioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdBodegaPorIdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosBusquedaPorIdBodegaPorIdProducto(String sFinalQuery,Pagination pagination,Long id_bodega,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,PrecioConstantesFunciones.IDBODEGA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PrecioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdBodegaPorIdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosBusquedaPorLineaGrupoCategoriaMarcaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PrecioConstantesFunciones.IDLINEA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PrecioConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PrecioConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PrecioConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorLineaGrupoCategoriaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosBusquedaPorLineaGrupoCategoriaMarca(String sFinalQuery,Pagination pagination,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PrecioConstantesFunciones.IDLINEA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PrecioConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PrecioConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PrecioConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorLineaGrupoCategoriaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosBusquedaPorLineaGrupoCategoriaMarcaProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PrecioConstantesFunciones.IDLINEA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PrecioConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PrecioConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PrecioConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PrecioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorLineaGrupoCategoriaMarcaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosBusquedaPorLineaGrupoCategoriaMarcaProducto(String sFinalQuery,Pagination pagination,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PrecioConstantesFunciones.IDLINEA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PrecioConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PrecioConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PrecioConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PrecioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorLineaGrupoCategoriaMarcaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,PrecioConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,PrecioConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdEstadoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_precio,PrecioConstantesFunciones.IDESTADOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPrecio);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdEstadoPrecio(String sFinalQuery,Pagination pagination,Long id_estado_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_precio,PrecioConstantesFunciones.IDESTADOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPrecio);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PrecioConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PrecioConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PrecioConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PrecioConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PrecioConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PrecioConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdLineaMarcaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PrecioConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdLineaMarca(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PrecioConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PrecioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PrecioConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdRangoUnidadVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_rango_unidad_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRangoUnidadVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRangoUnidadVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rango_unidad_venta,PrecioConstantesFunciones.IDRANGOUNIDADVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRangoUnidadVenta);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRangoUnidadVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdRangoUnidadVenta(String sFinalQuery,Pagination pagination,Long id_rango_unidad_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRangoUnidadVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRangoUnidadVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rango_unidad_venta,PrecioConstantesFunciones.IDRANGOUNIDADVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRangoUnidadVenta);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRangoUnidadVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PrecioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PrecioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreciosFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Precio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PrecioConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreciosFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PrecioConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(this.precios);
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
			if(PrecioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PrecioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Precio precio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PrecioConstantesFunciones.ISCONAUDITORIA) {
				if(precio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrecioDataAccess.TABLENAME, precio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PrecioLogic.registrarAuditoriaDetallesPrecio(connexion,precio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(precio.getIsDeleted()) {
					/*if(!precio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PrecioDataAccess.TABLENAME, precio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PrecioLogic.registrarAuditoriaDetallesPrecio(connexion,precio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrecioDataAccess.TABLENAME, precio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(precio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrecioDataAccess.TABLENAME, precio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PrecioLogic.registrarAuditoriaDetallesPrecio(connexion,precio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPrecio(Connexion connexion,Precio precio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(precio.getIsNew()||!precio.getid_empresa().equals(precio.getPrecioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_empresa()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_empresa().toString();
				}
				if(precio.getid_empresa()!=null)
				{
					strValorNuevo=precio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_sucursal().equals(precio.getPrecioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_sucursal()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_sucursal().toString();
				}
				if(precio.getid_sucursal()!=null)
				{
					strValorNuevo=precio.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_bodega().equals(precio.getPrecioOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_bodega()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_bodega().toString();
				}
				if(precio.getid_bodega()!=null)
				{
					strValorNuevo=precio.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_producto().equals(precio.getPrecioOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_producto()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_producto().toString();
				}
				if(precio.getid_producto()!=null)
				{
					strValorNuevo=precio.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_linea().equals(precio.getPrecioOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_linea()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_linea().toString();
				}
				if(precio.getid_linea()!=null)
				{
					strValorNuevo=precio.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_linea_grupo().equals(precio.getPrecioOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_linea_grupo().toString();
				}
				if(precio.getid_linea_grupo()!=null)
				{
					strValorNuevo=precio.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_linea_categoria().equals(precio.getPrecioOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_linea_categoria().toString();
				}
				if(precio.getid_linea_categoria()!=null)
				{
					strValorNuevo=precio.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_linea_marca().equals(precio.getPrecioOriginal().getid_linea_marca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_linea_marca()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_linea_marca().toString();
				}
				if(precio.getid_linea_marca()!=null)
				{
					strValorNuevo=precio.getid_linea_marca().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDLINEAMARCA,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_rango_unidad_venta().equals(precio.getPrecioOriginal().getid_rango_unidad_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_rango_unidad_venta()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_rango_unidad_venta().toString();
				}
				if(precio.getid_rango_unidad_venta()!=null)
				{
					strValorNuevo=precio.getid_rango_unidad_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDRANGOUNIDADVENTA,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_tipo_precio().equals(precio.getPrecioOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_tipo_precio().toString();
				}
				if(precio.getid_tipo_precio()!=null)
				{
					strValorNuevo=precio.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getprecio().equals(precio.getPrecioOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getprecio()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getprecio().toString();
				}
				if(precio.getprecio()!=null)
				{
					strValorNuevo=precio.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getdescuento().equals(precio.getPrecioOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getdescuento()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getdescuento().toString();
				}
				if(precio.getdescuento()!=null)
				{
					strValorNuevo=precio.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getprecio_minimo().equals(precio.getPrecioOriginal().getprecio_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getprecio_minimo()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getprecio_minimo().toString();
				}
				if(precio.getprecio_minimo()!=null)
				{
					strValorNuevo=precio.getprecio_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.PRECIOMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getcon_impuesto().equals(precio.getPrecioOriginal().getcon_impuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getcon_impuesto()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getcon_impuesto().toString();
				}
				if(precio.getcon_impuesto()!=null)
				{
					strValorNuevo=precio.getcon_impuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.CONIMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(precio.getIsNew()||!precio.getid_estado_precio().equals(precio.getPrecioOriginal().getid_estado_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(precio.getPrecioOriginal().getid_estado_precio()!=null)
				{
					strValorActual=precio.getPrecioOriginal().getid_estado_precio().toString();
				}
				if(precio.getid_estado_precio()!=null)
				{
					strValorNuevo=precio.getid_estado_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrecioConstantesFunciones.IDESTADOPRECIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePrecioRelacionesWithConnection(Precio precio) throws Exception {

		if(!precio.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePrecioRelacionesBase(precio,true);
		}
	}

	public void savePrecioRelaciones(Precio precio)throws Exception {

		if(!precio.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePrecioRelacionesBase(precio,false);
		}
	}

	public void savePrecioRelacionesBase(Precio precio,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Precio-saveRelacionesWithConnection");}
	

			this.setPrecio(precio);

			if(PrecioLogicAdditional.validarSaveRelaciones(precio,this)) {

				PrecioLogicAdditional.updateRelacionesToSave(precio,this);

				if((precio.getIsNew()||precio.getIsChanged())&&!precio.getIsDeleted()) {
					this.savePrecio();
					this.savePrecioRelacionesDetalles();

				} else if(precio.getIsDeleted()) {
					this.savePrecioRelacionesDetalles();
					this.savePrecio();
				}

				PrecioLogicAdditional.updateRelacionesToSaveAfter(precio,this);

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
	
	
	private void savePrecioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PrecioConstantesFunciones.getClassesRelationshipsOfPrecio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
