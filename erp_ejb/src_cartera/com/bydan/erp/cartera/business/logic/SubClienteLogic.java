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
import com.bydan.erp.cartera.util.SubClienteConstantesFunciones;
import com.bydan.erp.cartera.util.SubClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.SubClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.SubCliente;
import com.bydan.erp.cartera.business.logic.SubClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class SubClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SubClienteLogic.class);
	
	protected SubClienteDataAccess subclienteDataAccess; 	
	protected SubCliente subcliente;
	protected List<SubCliente> subclientes;
	protected Object subclienteObject;	
	protected List<Object> subclientesObject;
	
	public static ClassValidator<SubCliente> subclienteValidator = new ClassValidator<SubCliente>(SubCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SubClienteLogicAdditional subclienteLogicAdditional=null;
	
	public SubClienteLogicAdditional getSubClienteLogicAdditional() {
		return this.subclienteLogicAdditional;
	}
	
	public void setSubClienteLogicAdditional(SubClienteLogicAdditional subclienteLogicAdditional) {
		try {
			this.subclienteLogicAdditional=subclienteLogicAdditional;
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
	
	
	
	
	public  SubClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.subclienteDataAccess = new SubClienteDataAccess();
			
			this.subclientes= new ArrayList<SubCliente>();
			this.subcliente= new SubCliente();
			
			this.subclienteObject=new Object();
			this.subclientesObject=new ArrayList<Object>();
				
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
			
			this.subclienteDataAccess.setConnexionType(this.connexionType);
			this.subclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SubClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.subclienteDataAccess = new SubClienteDataAccess();
			this.subclientes= new ArrayList<SubCliente>();
			this.subcliente= new SubCliente();
			this.subclienteObject=new Object();
			this.subclientesObject=new ArrayList<Object>();
			
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
			
			this.subclienteDataAccess.setConnexionType(this.connexionType);
			this.subclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SubCliente getSubCliente() throws Exception {	
		SubClienteLogicAdditional.checkSubClienteToGet(subcliente,this.datosCliente,this.arrDatoGeneral);
		SubClienteLogicAdditional.updateSubClienteToGet(subcliente,this.arrDatoGeneral);
		
		return subcliente;
	}
		
	public void setSubCliente(SubCliente newSubCliente) {
		this.subcliente = newSubCliente;
	}
	
	public SubClienteDataAccess getSubClienteDataAccess() {
		return subclienteDataAccess;
	}
	
	public void setSubClienteDataAccess(SubClienteDataAccess newsubclienteDataAccess) {
		this.subclienteDataAccess = newsubclienteDataAccess;
	}
	
	public List<SubCliente> getSubClientes() throws Exception {		
		this.quitarSubClientesNulos();
		
		SubClienteLogicAdditional.checkSubClienteToGets(subclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (SubCliente subclienteLocal: subclientes ) {
			SubClienteLogicAdditional.updateSubClienteToGet(subclienteLocal,this.arrDatoGeneral);
		}
		
		return subclientes;
	}
	
	public void setSubClientes(List<SubCliente> newSubClientes) {
		this.subclientes = newSubClientes;
	}
	
	public Object getSubClienteObject() {	
		this.subclienteObject=this.subclienteDataAccess.getEntityObject();
		return this.subclienteObject;
	}
		
	public void setSubClienteObject(Object newSubClienteObject) {
		this.subclienteObject = newSubClienteObject;
	}
	
	public List<Object> getSubClientesObject() {		
		this.subclientesObject=this.subclienteDataAccess.getEntitiesObject();
		return this.subclientesObject;
	}
		
	public void setSubClientesObject(List<Object> newSubClientesObject) {
		this.subclientesObject = newSubClientesObject;
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
		
		if(this.subclienteDataAccess!=null) {
			this.subclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			subclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			subclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		subcliente = new  SubCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subcliente=subclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subcliente);
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
		subcliente = new  SubCliente();
		  		  
        try {
			
			subcliente=subclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		subcliente = new  SubCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subcliente=subclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subcliente);
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
		subcliente = new  SubCliente();
		  		  
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
		subcliente = new  SubCliente();
		  		  
        try {
			
			subcliente=subclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		subcliente = new  SubCliente();
		  		  
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
		subcliente = new  SubCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =subclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subcliente = new  SubCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=subclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subcliente = new  SubCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =subclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subcliente = new  SubCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=subclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subcliente = new  SubCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =subclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subcliente = new  SubCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=subclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subclientes = new  ArrayList<SubCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
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
		subclientes = new  ArrayList<SubCliente>();
		  		  
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
		subclientes = new  ArrayList<SubCliente>();
		  		  
        try {			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		subclientes = new  ArrayList<SubCliente>();
		  		  
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
		subclientes = new  ArrayList<SubCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
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
		subclientes = new  ArrayList<SubCliente>();
		  		  
        try {
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
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
		subclientes = new  ArrayList<SubCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
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
		subclientes = new  ArrayList<SubCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		subcliente = new  SubCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subcliente=subclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubCliente(subcliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subcliente);
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
		subcliente = new  SubCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subcliente=subclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubCliente(subcliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subclientes = new  ArrayList<SubCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
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
		subclientes = new  ArrayList<SubCliente>();
		  		  
        try {
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSubClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		subclientes = new  ArrayList<SubCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getTodosSubClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
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
	
	public  void  getTodosSubClientes(String sFinalQuery,Pagination pagination)throws Exception {
		subclientes = new  ArrayList<SubCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubCliente(subclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSubCliente(SubCliente subcliente) throws Exception {
		Boolean estaValidado=false;
		
		if(subcliente.getIsNew() || subcliente.getIsChanged()) { 
			this.invalidValues = subclienteValidator.getInvalidValues(subcliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(subcliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSubCliente(List<SubCliente> SubClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SubCliente subclienteLocal:subclientes) {				
			estaValidadoObjeto=this.validarGuardarSubCliente(subclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSubCliente(List<SubCliente> SubClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubCliente(subclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSubCliente(SubCliente SubCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubCliente(subcliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SubCliente subcliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+subcliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SubClienteConstantesFunciones.getSubClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"subcliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SubClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SubClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSubClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-saveSubClienteWithConnection");connexion.begin();			
			
			SubClienteLogicAdditional.checkSubClienteToSave(this.subcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubClienteLogicAdditional.updateSubClienteToSave(this.subcliente,this.arrDatoGeneral);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subcliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSubCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubCliente(this.subcliente)) {
				SubClienteDataAccess.save(this.subcliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.subcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubClienteLogicAdditional.checkSubClienteToSaveAfter(this.subcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubCliente();
			
			connexion.commit();			
			
			if(this.subcliente.getIsDeleted()) {
				this.subcliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSubCliente()throws Exception {	
		try {	
			
			SubClienteLogicAdditional.checkSubClienteToSave(this.subcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubClienteLogicAdditional.updateSubClienteToSave(this.subcliente,this.arrDatoGeneral);
			
			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subcliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubCliente(this.subcliente)) {			
				SubClienteDataAccess.save(this.subcliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.subcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubClienteLogicAdditional.checkSubClienteToSaveAfter(this.subcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.subcliente.getIsDeleted()) {
				this.subcliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSubClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-saveSubClientesWithConnection");connexion.begin();			
			
			SubClienteLogicAdditional.checkSubClienteToSaves(subclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSubClientes();
			
			Boolean validadoTodosSubCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubCliente subclienteLocal:subclientes) {		
				if(subclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubClienteLogicAdditional.updateSubClienteToSave(subclienteLocal,this.arrDatoGeneral);
	        	
				SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubCliente(subclienteLocal)) {
					SubClienteDataAccess.save(subclienteLocal, connexion);				
				} else {
					validadoTodosSubCliente=false;
				}
			}
			
			if(!validadoTodosSubCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubClienteLogicAdditional.checkSubClienteToSavesAfter(subclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubClientes();
			
			connexion.commit();		
			
			this.quitarSubClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSubClientes()throws Exception {				
		 try {	
			SubClienteLogicAdditional.checkSubClienteToSaves(subclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSubCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubCliente subclienteLocal:subclientes) {				
				if(subclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubClienteLogicAdditional.updateSubClienteToSave(subclienteLocal,this.arrDatoGeneral);
	        	
				SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubCliente(subclienteLocal)) {				
					SubClienteDataAccess.save(subclienteLocal, connexion);				
				} else {
					validadoTodosSubCliente=false;
				}
			}
			
			if(!validadoTodosSubCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubClienteLogicAdditional.checkSubClienteToSavesAfter(subclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSubClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubClienteParameterReturnGeneral procesarAccionSubClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubCliente> subclientes,SubClienteParameterReturnGeneral subclienteParameterGeneral)throws Exception {
		 try {	
			SubClienteParameterReturnGeneral subclienteReturnGeneral=new SubClienteParameterReturnGeneral();
	
			SubClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subclientes,subclienteParameterGeneral,subclienteReturnGeneral);
			
			return subclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubClienteParameterReturnGeneral procesarAccionSubClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubCliente> subclientes,SubClienteParameterReturnGeneral subclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-procesarAccionSubClientesWithConnection");connexion.begin();			
			
			SubClienteParameterReturnGeneral subclienteReturnGeneral=new SubClienteParameterReturnGeneral();
	
			SubClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subclientes,subclienteParameterGeneral,subclienteReturnGeneral);
			
			this.connexion.commit();
			
			return subclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubClienteParameterReturnGeneral procesarEventosSubClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubCliente> subclientes,SubCliente subcliente,SubClienteParameterReturnGeneral subclienteParameterGeneral,Boolean isEsNuevoSubCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			SubClienteParameterReturnGeneral subclienteReturnGeneral=new SubClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subclientes,subcliente,subclienteParameterGeneral,subclienteReturnGeneral,isEsNuevoSubCliente,clases);
			
			return subclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SubClienteParameterReturnGeneral procesarEventosSubClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubCliente> subclientes,SubCliente subcliente,SubClienteParameterReturnGeneral subclienteParameterGeneral,Boolean isEsNuevoSubCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-procesarEventosSubClientesWithConnection");connexion.begin();			
			
			SubClienteParameterReturnGeneral subclienteReturnGeneral=new SubClienteParameterReturnGeneral();
	
			subclienteReturnGeneral.setSubCliente(subcliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subclientes,subcliente,subclienteParameterGeneral,subclienteReturnGeneral,isEsNuevoSubCliente,clases);
			
			this.connexion.commit();
			
			return subclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubClienteParameterReturnGeneral procesarImportacionSubClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SubClienteParameterReturnGeneral subclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-procesarImportacionSubClientesWithConnection");connexion.begin();			
			
			SubClienteParameterReturnGeneral subclienteReturnGeneral=new SubClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.subclientes=new ArrayList<SubCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.subcliente=new SubCliente();
				
				
				if(conColumnasBase) {this.subcliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.subcliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.subcliente.setidentificacion(arrColumnas[iColumn++]);
				this.subcliente.setruc(arrColumnas[iColumn++]);
				this.subcliente.setnombre(arrColumnas[iColumn++]);
				this.subcliente.setapellido(arrColumnas[iColumn++]);
			this.subcliente.setnombre_completo(arrColumnas[iColumn++]);
				this.subcliente.setdireccion(arrColumnas[iColumn++]);
				this.subcliente.settelefono(arrColumnas[iColumn++]);
				this.subcliente.setnumero_celular(arrColumnas[iColumn++]);
				this.subcliente.setmail(arrColumnas[iColumn++]);
				this.subcliente.setfecha_nacimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.subcliente.setfechao(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.subcliente.setobservacion(arrColumnas[iColumn++]);
				this.subcliente.setpath_imagen_firma(arrColumnas[iColumn++]);
				this.subcliente.setnumero_carga(Integer.parseInt(arrColumnas[iColumn++]));
				this.subcliente.setlimite_credito(Double.parseDouble(arrColumnas[iColumn++]));
				this.subcliente.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.subcliente.setcodigo_contrato(arrColumnas[iColumn++]);
				this.subcliente.setvalor_contrato(Double.parseDouble(arrColumnas[iColumn++]));
				this.subcliente.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.subcliente.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.subcliente.setplazo(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.subclientes.add(this.subcliente);
			}
			
			this.saveSubClientes();
			
			this.connexion.commit();
			
			subclienteReturnGeneral.setConRetornoEstaProcesado(true);
			subclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return subclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSubClientesEliminados() throws Exception {				
		
		List<SubCliente> subclientesAux= new ArrayList<SubCliente>();
		
		for(SubCliente subcliente:subclientes) {
			if(!subcliente.getIsDeleted()) {
				subclientesAux.add(subcliente);
			}
		}
		
		subclientes=subclientesAux;
	}
	
	public void quitarSubClientesNulos() throws Exception {				
		
		List<SubCliente> subclientesAux= new ArrayList<SubCliente>();
		
		for(SubCliente subcliente : this.subclientes) {
			if(subcliente==null) {
				subclientesAux.add(subcliente);
			}
		}
		
		//this.subclientes=subclientesAux;
		
		this.subclientes.removeAll(subclientesAux);
	}
	
	public void getSetVersionRowSubClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(subcliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((subcliente.getIsDeleted() || (subcliente.getIsChanged()&&!subcliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=subclienteDataAccess.getSetVersionRowSubCliente(connexion,subcliente.getId());
				
				if(!subcliente.getVersionRow().equals(timestamp)) {	
					subcliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				subcliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSubCliente()throws Exception {	
		
		if(subcliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((subcliente.getIsDeleted() || (subcliente.getIsChanged()&&!subcliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=subclienteDataAccess.getSetVersionRowSubCliente(connexion,subcliente.getId());
			
			try {							
				if(!subcliente.getVersionRow().equals(timestamp)) {	
					subcliente.setVersionRow(timestamp);
				}
				
				subcliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSubClientesWithConnection()throws Exception {	
		if(subclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SubCliente subclienteAux:subclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(subclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subclienteAux.getIsDeleted() || (subclienteAux.getIsChanged()&&!subclienteAux.getIsNew())) {
						
						timestamp=subclienteDataAccess.getSetVersionRowSubCliente(connexion,subclienteAux.getId());
						
						if(!subcliente.getVersionRow().equals(timestamp)) {	
							subclienteAux.setVersionRow(timestamp);
						}
								
						subclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSubClientes()throws Exception {	
		if(subclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SubCliente subclienteAux:subclientes) {
					if(subclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subclienteAux.getIsDeleted() || (subclienteAux.getIsChanged()&&!subclienteAux.getIsNew())) {
						
						timestamp=subclienteDataAccess.getSetVersionRowSubCliente(connexion,subclienteAux.getId());
						
						if(!subclienteAux.getVersionRow().equals(timestamp)) {	
							subclienteAux.setVersionRow(timestamp);
						}
						
													
						subclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SubClienteParameterReturnGeneral cargarCombosLoteForeignKeySubClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalSucursal,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalPaisNacionalidad,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil,String finalQueryGlobalEstadoLegal,String finalQueryGlobalTipoNivelEdu,String finalQueryGlobalCuentaContable) throws Exception {
		SubClienteParameterReturnGeneral  subclienteReturnGeneral =new SubClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeySubClienteWithConnection");connexion.begin();
			
			subclienteReturnGeneral =new SubClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			subclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			subclienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			subclienteReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			subclienteReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			subclienteReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			subclienteReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Pais> paisnacionalidadsForeignKey=new ArrayList<Pais>();
			PaisLogic paisnacionalidadLogic=new PaisLogic();
			paisnacionalidadLogic.setConnexion(this.connexion);
			paisnacionalidadLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaisNacionalidad.equals("NONE")) {
				paisnacionalidadLogic.getTodosPaiss(finalQueryGlobalPaisNacionalidad,new Pagination());
				paisnacionalidadsForeignKey=paisnacionalidadLogic.getPaiss();
			}

			subclienteReturnGeneral.setpaisnacionalidadsForeignKey(paisnacionalidadsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			subclienteReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			subclienteReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<EstadoLegal> estadolegalsForeignKey=new ArrayList<EstadoLegal>();
			EstadoLegalLogic estadolegalLogic=new EstadoLegalLogic();
			estadolegalLogic.setConnexion(this.connexion);
			estadolegalLogic.getEstadoLegalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoLegal.equals("NONE")) {
				estadolegalLogic.getTodosEstadoLegals(finalQueryGlobalEstadoLegal,new Pagination());
				estadolegalsForeignKey=estadolegalLogic.getEstadoLegals();
			}

			subclienteReturnGeneral.setestadolegalsForeignKey(estadolegalsForeignKey);


			List<TipoNivelEdu> tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
			TipoNivelEduLogic tiponiveleduLogic=new TipoNivelEduLogic();
			tiponiveleduLogic.setConnexion(this.connexion);
			//tiponiveleduLogic.getTipoNivelEduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNivelEdu.equals("NONE")) {
				tiponiveleduLogic.getTodosTipoNivelEdus(finalQueryGlobalTipoNivelEdu,new Pagination());
				tiponiveledusForeignKey=tiponiveleduLogic.getTipoNivelEdus();
			}

			subclienteReturnGeneral.settiponiveledusForeignKey(tiponiveledusForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			subclienteReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return subclienteReturnGeneral;
	}
	
	public SubClienteParameterReturnGeneral cargarCombosLoteForeignKeySubCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalSucursal,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalPaisNacionalidad,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil,String finalQueryGlobalEstadoLegal,String finalQueryGlobalTipoNivelEdu,String finalQueryGlobalCuentaContable) throws Exception {
		SubClienteParameterReturnGeneral  subclienteReturnGeneral =new SubClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			subclienteReturnGeneral =new SubClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			subclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			subclienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			subclienteReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			subclienteReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			subclienteReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			subclienteReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Pais> paisnacionalidadsForeignKey=new ArrayList<Pais>();
			PaisLogic paisnacionalidadLogic=new PaisLogic();
			paisnacionalidadLogic.setConnexion(this.connexion);
			paisnacionalidadLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaisNacionalidad.equals("NONE")) {
				paisnacionalidadLogic.getTodosPaiss(finalQueryGlobalPaisNacionalidad,new Pagination());
				paisnacionalidadsForeignKey=paisnacionalidadLogic.getPaiss();
			}

			subclienteReturnGeneral.setpaisnacionalidadsForeignKey(paisnacionalidadsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			subclienteReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			subclienteReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<EstadoLegal> estadolegalsForeignKey=new ArrayList<EstadoLegal>();
			EstadoLegalLogic estadolegalLogic=new EstadoLegalLogic();
			estadolegalLogic.setConnexion(this.connexion);
			estadolegalLogic.getEstadoLegalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoLegal.equals("NONE")) {
				estadolegalLogic.getTodosEstadoLegals(finalQueryGlobalEstadoLegal,new Pagination());
				estadolegalsForeignKey=estadolegalLogic.getEstadoLegals();
			}

			subclienteReturnGeneral.setestadolegalsForeignKey(estadolegalsForeignKey);


			List<TipoNivelEdu> tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
			TipoNivelEduLogic tiponiveleduLogic=new TipoNivelEduLogic();
			tiponiveleduLogic.setConnexion(this.connexion);
			//tiponiveleduLogic.getTipoNivelEduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNivelEdu.equals("NONE")) {
				tiponiveleduLogic.getTodosTipoNivelEdus(finalQueryGlobalTipoNivelEdu,new Pagination());
				tiponiveledusForeignKey=tiponiveleduLogic.getTipoNivelEdus();
			}

			subclienteReturnGeneral.settiponiveledusForeignKey(tiponiveledusForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			subclienteReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return subclienteReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeySubClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FacturaLogic facturaLogic=new FacturaLogic();
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			ProformaLogic proformaLogic=new ProformaLogic();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
			PedidoLogic pedidoLogic=new PedidoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySubClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Factura.class));
			classes.add(new Classe(Consignacion.class));
			classes.add(new Classe(GuiaRemision.class));
			classes.add(new Classe(Proforma.class));
			classes.add(new Classe(PedidoExpor.class));
			classes.add(new Classe(Pedido.class));
											
			

			facturaLogic.setConnexion(this.getConnexion());
			facturaLogic.setDatosCliente(this.datosCliente);
			facturaLogic.setIsConRefrescarForeignKeys(true);

			consignacionLogic.setConnexion(this.getConnexion());
			consignacionLogic.setDatosCliente(this.datosCliente);
			consignacionLogic.setIsConRefrescarForeignKeys(true);

			guiaremisionLogic.setConnexion(this.getConnexion());
			guiaremisionLogic.setDatosCliente(this.datosCliente);
			guiaremisionLogic.setIsConRefrescarForeignKeys(true);

			proformaLogic.setConnexion(this.getConnexion());
			proformaLogic.setDatosCliente(this.datosCliente);
			proformaLogic.setIsConRefrescarForeignKeys(true);

			pedidoexporLogic.setConnexion(this.getConnexion());
			pedidoexporLogic.setDatosCliente(this.datosCliente);
			pedidoexporLogic.setIsConRefrescarForeignKeys(true);

			pedidoLogic.setConnexion(this.getConnexion());
			pedidoLogic.setDatosCliente(this.datosCliente);
			pedidoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(SubCliente subcliente:this.subclientes) {
				

				classes=new ArrayList<Classe>();
				classes=FacturaConstantesFunciones.getClassesForeignKeysOfFactura(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturaLogic.setFacturas(subcliente.facturas);
				facturaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignacionLogic.setConsignacions(subcliente.consignacions);
				consignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);

				guiaremisionLogic.setGuiaRemisions(subcliente.guiaremisions);
				guiaremisionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				proformaLogic.setProformas(subcliente.proformas);
				proformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoexporLogic.setPedidoExpors(subcliente.pedidoexpors);
				pedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoLogic.setPedidos(subcliente.pedidos);
				pedidoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(SubCliente subcliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SubClienteLogicAdditional.updateSubClienteToGet(subcliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subcliente.setEmpresa(subclienteDataAccess.getEmpresa(connexion,subcliente));
		subcliente.setCliente(subclienteDataAccess.getCliente(connexion,subcliente));
		subcliente.setSucursal(subclienteDataAccess.getSucursal(connexion,subcliente));
		subcliente.setTipoIdentificacion(subclienteDataAccess.getTipoIdentificacion(connexion,subcliente));
		subcliente.setPais(subclienteDataAccess.getPais(connexion,subcliente));
		subcliente.setCiudad(subclienteDataAccess.getCiudad(connexion,subcliente));
		subcliente.setZona(subclienteDataAccess.getZona(connexion,subcliente));
		subcliente.setPaisNacionalidad(subclienteDataAccess.getPaisNacionalidad(connexion,subcliente));
		subcliente.setTipoGenero(subclienteDataAccess.getTipoGenero(connexion,subcliente));
		subcliente.setEstadoCivil(subclienteDataAccess.getEstadoCivil(connexion,subcliente));
		subcliente.setEstadoLegal(subclienteDataAccess.getEstadoLegal(connexion,subcliente));
		subcliente.setTipoNivelEdu(subclienteDataAccess.getTipoNivelEdu(connexion,subcliente));
		subcliente.setCuentaContable(subclienteDataAccess.getCuentaContable(connexion,subcliente));
		subcliente.setFacturas(subclienteDataAccess.getFacturas(connexion,subcliente));
		subcliente.setConsignacions(subclienteDataAccess.getConsignacions(connexion,subcliente));
		subcliente.setGuiaRemisions(subclienteDataAccess.getGuiaRemisions(connexion,subcliente));
		subcliente.setProformas(subclienteDataAccess.getProformas(connexion,subcliente));
		subcliente.setPedidoExpors(subclienteDataAccess.getPedidoExpors(connexion,subcliente));
		subcliente.setPedidos(subclienteDataAccess.getPedidos(connexion,subcliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subcliente.setEmpresa(subclienteDataAccess.getEmpresa(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				subcliente.setCliente(subclienteDataAccess.getCliente(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				subcliente.setSucursal(subclienteDataAccess.getSucursal(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				subcliente.setTipoIdentificacion(subclienteDataAccess.getTipoIdentificacion(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				subcliente.setPais(subclienteDataAccess.getPais(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				subcliente.setCiudad(subclienteDataAccess.getCiudad(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				subcliente.setZona(subclienteDataAccess.getZona(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				subcliente.setPaisNacionalidad(subclienteDataAccess.getPaisNacionalidad(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				subcliente.setTipoGenero(subclienteDataAccess.getTipoGenero(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				subcliente.setEstadoCivil(subclienteDataAccess.getEstadoCivil(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				subcliente.setEstadoLegal(subclienteDataAccess.getEstadoLegal(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				subcliente.setTipoNivelEdu(subclienteDataAccess.getTipoNivelEdu(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				subcliente.setCuentaContable(subclienteDataAccess.getCuentaContable(connexion,subcliente));
				continue;
			}

			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setFacturas(subclienteDataAccess.getFacturas(connexion,subcliente));

				if(this.isConDeep) {
					FacturaLogic facturaLogic= new FacturaLogic(this.connexion);
					facturaLogic.setFacturas(subcliente.getFacturas());
					ArrayList<Classe> classesLocal=FacturaConstantesFunciones.getClassesForeignKeysOfFactura(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaConstantesFunciones.refrescarForeignKeysDescripcionesFactura(facturaLogic.getFacturas());
					subcliente.setFacturas(facturaLogic.getFacturas());
				}

				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setConsignacions(subclienteDataAccess.getConsignacions(connexion,subcliente));

				if(this.isConDeep) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(this.connexion);
					consignacionLogic.setConsignacions(subcliente.getConsignacions());
					ArrayList<Classe> classesLocal=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacionLogic.getConsignacions());
					subcliente.setConsignacions(consignacionLogic.getConsignacions());
				}

				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setGuiaRemisions(subclienteDataAccess.getGuiaRemisions(connexion,subcliente));

				if(this.isConDeep) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(this.connexion);
					guiaremisionLogic.setGuiaRemisions(subcliente.getGuiaRemisions());
					ArrayList<Classe> classesLocal=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);
					guiaremisionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(guiaremisionLogic.getGuiaRemisions());
					subcliente.setGuiaRemisions(guiaremisionLogic.getGuiaRemisions());
				}

				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setProformas(subclienteDataAccess.getProformas(connexion,subcliente));

				if(this.isConDeep) {
					ProformaLogic proformaLogic= new ProformaLogic(this.connexion);
					proformaLogic.setProformas(subcliente.getProformas());
					ArrayList<Classe> classesLocal=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					proformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proformaLogic.getProformas());
					subcliente.setProformas(proformaLogic.getProformas());
				}

				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setPedidoExpors(subclienteDataAccess.getPedidoExpors(connexion,subcliente));

				if(this.isConDeep) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(this.connexion);
					pedidoexporLogic.setPedidoExpors(subcliente.getPedidoExpors());
					ArrayList<Classe> classesLocal=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexporLogic.getPedidoExpors());
					subcliente.setPedidoExpors(pedidoexporLogic.getPedidoExpors());
				}

				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setPedidos(subclienteDataAccess.getPedidos(connexion,subcliente));

				if(this.isConDeep) {
					PedidoLogic pedidoLogic= new PedidoLogic(this.connexion);
					pedidoLogic.setPedidos(subcliente.getPedidos());
					ArrayList<Classe> classesLocal=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(pedidoLogic.getPedidos());
					subcliente.setPedidos(pedidoLogic.getPedidos());
				}

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
			subcliente.setEmpresa(subclienteDataAccess.getEmpresa(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setCliente(subclienteDataAccess.getCliente(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setSucursal(subclienteDataAccess.getSucursal(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setTipoIdentificacion(subclienteDataAccess.getTipoIdentificacion(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setPais(subclienteDataAccess.getPais(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setCiudad(subclienteDataAccess.getCiudad(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setZona(subclienteDataAccess.getZona(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setPaisNacionalidad(subclienteDataAccess.getPaisNacionalidad(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setTipoGenero(subclienteDataAccess.getTipoGenero(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setEstadoCivil(subclienteDataAccess.getEstadoCivil(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoLegal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setEstadoLegal(subclienteDataAccess.getEstadoLegal(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNivelEdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setTipoNivelEdu(subclienteDataAccess.getTipoNivelEdu(connexion,subcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setCuentaContable(subclienteDataAccess.getCuentaContable(connexion,subcliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Factura.class));
			subcliente.setFacturas(subclienteDataAccess.getFacturas(connexion,subcliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			subcliente.setConsignacions(subclienteDataAccess.getConsignacions(connexion,subcliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			subcliente.setGuiaRemisions(subclienteDataAccess.getGuiaRemisions(connexion,subcliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			subcliente.setProformas(subclienteDataAccess.getProformas(connexion,subcliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			subcliente.setPedidoExpors(subclienteDataAccess.getPedidoExpors(connexion,subcliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			subcliente.setPedidos(subclienteDataAccess.getPedidos(connexion,subcliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subcliente.setEmpresa(subclienteDataAccess.getEmpresa(connexion,subcliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subcliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		subcliente.setCliente(subclienteDataAccess.getCliente(connexion,subcliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(subcliente.getCliente(),isDeep,deepLoadType,clases);
				
		subcliente.setSucursal(subclienteDataAccess.getSucursal(connexion,subcliente));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(subcliente.getSucursal(),isDeep,deepLoadType,clases);
				
		subcliente.setTipoIdentificacion(subclienteDataAccess.getTipoIdentificacion(connexion,subcliente));
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(subcliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		subcliente.setPais(subclienteDataAccess.getPais(connexion,subcliente));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(subcliente.getPais(),isDeep,deepLoadType,clases);
				
		subcliente.setCiudad(subclienteDataAccess.getCiudad(connexion,subcliente));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(subcliente.getCiudad(),isDeep,deepLoadType,clases);
				
		subcliente.setZona(subclienteDataAccess.getZona(connexion,subcliente));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(subcliente.getZona(),isDeep,deepLoadType,clases);
				
		subcliente.setPaisNacionalidad(subclienteDataAccess.getPaisNacionalidad(connexion,subcliente));
		PaisLogic paisnacionalidadLogic= new PaisLogic(connexion);
		paisnacionalidadLogic.deepLoad(subcliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				
		subcliente.setTipoGenero(subclienteDataAccess.getTipoGenero(connexion,subcliente));
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(subcliente.getTipoGenero(),isDeep,deepLoadType,clases);
				
		subcliente.setEstadoCivil(subclienteDataAccess.getEstadoCivil(connexion,subcliente));
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(subcliente.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		subcliente.setEstadoLegal(subclienteDataAccess.getEstadoLegal(connexion,subcliente));
		EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
		estadolegalLogic.deepLoad(subcliente.getEstadoLegal(),isDeep,deepLoadType,clases);
				
		subcliente.setTipoNivelEdu(subclienteDataAccess.getTipoNivelEdu(connexion,subcliente));
		TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
		tiponiveleduLogic.deepLoad(subcliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				
		subcliente.setCuentaContable(subclienteDataAccess.getCuentaContable(connexion,subcliente));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(subcliente.getCuentaContable(),isDeep,deepLoadType,clases);
				

		subcliente.setFacturas(subclienteDataAccess.getFacturas(connexion,subcliente));

		for(Factura factura:subcliente.getFacturas()) {
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
		}

		subcliente.setConsignacions(subclienteDataAccess.getConsignacions(connexion,subcliente));

		for(Consignacion consignacion:subcliente.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
		}

		subcliente.setGuiaRemisions(subclienteDataAccess.getGuiaRemisions(connexion,subcliente));

		for(GuiaRemision guiaremision:subcliente.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
		}

		subcliente.setProformas(subclienteDataAccess.getProformas(connexion,subcliente));

		for(Proforma proforma:subcliente.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
		}

		subcliente.setPedidoExpors(subclienteDataAccess.getPedidoExpors(connexion,subcliente));

		for(PedidoExpor pedidoexpor:subcliente.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
		}

		subcliente.setPedidos(subclienteDataAccess.getPedidos(connexion,subcliente));

		for(Pedido pedido:subcliente.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subcliente.setEmpresa(subclienteDataAccess.getEmpresa(connexion,subcliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(subcliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				subcliente.setCliente(subclienteDataAccess.getCliente(connexion,subcliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(subcliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				subcliente.setSucursal(subclienteDataAccess.getSucursal(connexion,subcliente));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(subcliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				subcliente.setTipoIdentificacion(subclienteDataAccess.getTipoIdentificacion(connexion,subcliente));
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepLoad(subcliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				subcliente.setPais(subclienteDataAccess.getPais(connexion,subcliente));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(subcliente.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				subcliente.setCiudad(subclienteDataAccess.getCiudad(connexion,subcliente));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(subcliente.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				subcliente.setZona(subclienteDataAccess.getZona(connexion,subcliente));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(subcliente.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				subcliente.setPaisNacionalidad(subclienteDataAccess.getPaisNacionalidad(connexion,subcliente));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(subcliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				subcliente.setTipoGenero(subclienteDataAccess.getTipoGenero(connexion,subcliente));
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepLoad(subcliente.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				subcliente.setEstadoCivil(subclienteDataAccess.getEstadoCivil(connexion,subcliente));
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepLoad(subcliente.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				subcliente.setEstadoLegal(subclienteDataAccess.getEstadoLegal(connexion,subcliente));
				EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
				estadolegalLogic.deepLoad(subcliente.getEstadoLegal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				subcliente.setTipoNivelEdu(subclienteDataAccess.getTipoNivelEdu(connexion,subcliente));
				TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
				tiponiveleduLogic.deepLoad(subcliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				subcliente.setCuentaContable(subclienteDataAccess.getCuentaContable(connexion,subcliente));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(subcliente.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setFacturas(subclienteDataAccess.getFacturas(connexion,subcliente));

				for(Factura factura:subcliente.getFacturas()) {
					FacturaLogic facturaLogic= new FacturaLogic(connexion);
					facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setConsignacions(subclienteDataAccess.getConsignacions(connexion,subcliente));

				for(Consignacion consignacion:subcliente.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setGuiaRemisions(subclienteDataAccess.getGuiaRemisions(connexion,subcliente));

				for(GuiaRemision guiaremision:subcliente.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setProformas(subclienteDataAccess.getProformas(connexion,subcliente));

				for(Proforma proforma:subcliente.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setPedidoExpors(subclienteDataAccess.getPedidoExpors(connexion,subcliente));

				for(PedidoExpor pedidoexpor:subcliente.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subcliente.setPedidos(subclienteDataAccess.getPedidos(connexion,subcliente));

				for(Pedido pedido:subcliente.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
				}
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
			subcliente.setEmpresa(subclienteDataAccess.getEmpresa(connexion,subcliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(subcliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setCliente(subclienteDataAccess.getCliente(connexion,subcliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(subcliente.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setSucursal(subclienteDataAccess.getSucursal(connexion,subcliente));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(subcliente.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setTipoIdentificacion(subclienteDataAccess.getTipoIdentificacion(connexion,subcliente));
			TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
			tipoidentificacionLogic.deepLoad(subcliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setPais(subclienteDataAccess.getPais(connexion,subcliente));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(subcliente.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setCiudad(subclienteDataAccess.getCiudad(connexion,subcliente));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(subcliente.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setZona(subclienteDataAccess.getZona(connexion,subcliente));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(subcliente.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setPaisNacionalidad(subclienteDataAccess.getPaisNacionalidad(connexion,subcliente));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(subcliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setTipoGenero(subclienteDataAccess.getTipoGenero(connexion,subcliente));
			TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
			tipogeneroLogic.deepLoad(subcliente.getTipoGenero(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setEstadoCivil(subclienteDataAccess.getEstadoCivil(connexion,subcliente));
			EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
			estadocivilLogic.deepLoad(subcliente.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoLegal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setEstadoLegal(subclienteDataAccess.getEstadoLegal(connexion,subcliente));
			EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
			estadolegalLogic.deepLoad(subcliente.getEstadoLegal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNivelEdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setTipoNivelEdu(subclienteDataAccess.getTipoNivelEdu(connexion,subcliente));
			TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
			tiponiveleduLogic.deepLoad(subcliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subcliente.setCuentaContable(subclienteDataAccess.getCuentaContable(connexion,subcliente));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(subcliente.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Factura.class));
			subcliente.setFacturas(subclienteDataAccess.getFacturas(connexion,subcliente));

			for(Factura factura:subcliente.getFacturas()) {
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(factura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			subcliente.setConsignacions(subclienteDataAccess.getConsignacions(connexion,subcliente));

			for(Consignacion consignacion:subcliente.getConsignacions()) {
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			subcliente.setGuiaRemisions(subclienteDataAccess.getGuiaRemisions(connexion,subcliente));

			for(GuiaRemision guiaremision:subcliente.getGuiaRemisions()) {
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			subcliente.setProformas(subclienteDataAccess.getProformas(connexion,subcliente));

			for(Proforma proforma:subcliente.getProformas()) {
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			subcliente.setPedidoExpors(subclienteDataAccess.getPedidoExpors(connexion,subcliente));

			for(PedidoExpor pedidoexpor:subcliente.getPedidoExpors()) {
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			subcliente.setPedidos(subclienteDataAccess.getPedidos(connexion,subcliente));

			for(Pedido pedido:subcliente.getPedidos()) {
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SubCliente subcliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SubClienteLogicAdditional.updateSubClienteToSave(subcliente,this.arrDatoGeneral);
			
SubClienteDataAccess.save(subcliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subcliente.getEmpresa(),connexion);

		ClienteDataAccess.save(subcliente.getCliente(),connexion);

		SucursalDataAccess.save(subcliente.getSucursal(),connexion);

		TipoIdentificacionDataAccess.save(subcliente.getTipoIdentificacion(),connexion);

		PaisDataAccess.save(subcliente.getPais(),connexion);

		CiudadDataAccess.save(subcliente.getCiudad(),connexion);

		ZonaDataAccess.save(subcliente.getZona(),connexion);

		PaisDataAccess.save(subcliente.getPaisNacionalidad(),connexion);

		TipoGeneroDataAccess.save(subcliente.getTipoGenero(),connexion);

		EstadoCivilDataAccess.save(subcliente.getEstadoCivil(),connexion);

		EstadoLegalDataAccess.save(subcliente.getEstadoLegal(),connexion);

		TipoNivelEduDataAccess.save(subcliente.getTipoNivelEdu(),connexion);

		CuentaContableDataAccess.save(subcliente.getCuentaContable(),connexion);

		for(Factura factura:subcliente.getFacturas()) {
			factura.setid_sub_cliente(subcliente.getId());
			FacturaDataAccess.save(factura,connexion);
		}

		for(Consignacion consignacion:subcliente.getConsignacions()) {
			consignacion.setid_sub_cliente(subcliente.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
		}

		for(GuiaRemision guiaremision:subcliente.getGuiaRemisions()) {
			guiaremision.setid_sub_cliente(subcliente.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
		}

		for(Proforma proforma:subcliente.getProformas()) {
			proforma.setid_sub_cliente(subcliente.getId());
			ProformaDataAccess.save(proforma,connexion);
		}

		for(PedidoExpor pedidoexpor:subcliente.getPedidoExpors()) {
			pedidoexpor.setid_sub_cliente(subcliente.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
		}

		for(Pedido pedido:subcliente.getPedidos()) {
			pedido.setid_sub_cliente(subcliente.getId());
			PedidoDataAccess.save(pedido,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subcliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(subcliente.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(subcliente.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(subcliente.getTipoIdentificacion(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(subcliente.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(subcliente.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(subcliente.getZona(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(subcliente.getPaisNacionalidad(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(subcliente.getTipoGenero(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(subcliente.getEstadoCivil(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				EstadoLegalDataAccess.save(subcliente.getEstadoLegal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				TipoNivelEduDataAccess.save(subcliente.getTipoNivelEdu(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(subcliente.getCuentaContable(),connexion);
				continue;
			}


			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Factura factura:subcliente.getFacturas()) {
					factura.setid_sub_cliente(subcliente.getId());
					FacturaDataAccess.save(factura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:subcliente.getConsignacions()) {
					consignacion.setid_sub_cliente(subcliente.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:subcliente.getGuiaRemisions()) {
					guiaremision.setid_sub_cliente(subcliente.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:subcliente.getProformas()) {
					proforma.setid_sub_cliente(subcliente.getId());
					ProformaDataAccess.save(proforma,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:subcliente.getPedidoExpors()) {
					pedidoexpor.setid_sub_cliente(subcliente.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:subcliente.getPedidos()) {
					pedido.setid_sub_cliente(subcliente.getId());
					PedidoDataAccess.save(pedido,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subcliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subcliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(subcliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(subcliente.getCliente(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(subcliente.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(subcliente.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoIdentificacionDataAccess.save(subcliente.getTipoIdentificacion(),connexion);
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(subcliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(subcliente.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(subcliente.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(subcliente.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(subcliente.getCiudad(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(subcliente.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(subcliente.getZona(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(subcliente.getPaisNacionalidad(),connexion);
		PaisLogic paisnacionalidadLogic= new PaisLogic(connexion);
		paisnacionalidadLogic.deepLoad(subcliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				

		TipoGeneroDataAccess.save(subcliente.getTipoGenero(),connexion);
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(subcliente.getTipoGenero(),isDeep,deepLoadType,clases);
				

		EstadoCivilDataAccess.save(subcliente.getEstadoCivil(),connexion);
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(subcliente.getEstadoCivil(),isDeep,deepLoadType,clases);
				

		EstadoLegalDataAccess.save(subcliente.getEstadoLegal(),connexion);
		EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
		estadolegalLogic.deepLoad(subcliente.getEstadoLegal(),isDeep,deepLoadType,clases);
				

		TipoNivelEduDataAccess.save(subcliente.getTipoNivelEdu(),connexion);
		TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
		tiponiveleduLogic.deepLoad(subcliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(subcliente.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(subcliente.getCuentaContable(),isDeep,deepLoadType,clases);
				

		for(Factura factura:subcliente.getFacturas()) {
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			factura.setid_sub_cliente(subcliente.getId());
			FacturaDataAccess.save(factura,connexion);
			facturaLogic.deepSave(factura,isDeep,deepLoadType,clases);
		}

		for(Consignacion consignacion:subcliente.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacion.setid_sub_cliente(subcliente.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
			consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
		}

		for(GuiaRemision guiaremision:subcliente.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremision.setid_sub_cliente(subcliente.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
			guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
		}

		for(Proforma proforma:subcliente.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proforma.setid_sub_cliente(subcliente.getId());
			ProformaDataAccess.save(proforma,connexion);
			proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
		}

		for(PedidoExpor pedidoexpor:subcliente.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexpor.setid_sub_cliente(subcliente.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
			pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
		}

		for(Pedido pedido:subcliente.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedido.setid_sub_cliente(subcliente.getId());
			PedidoDataAccess.save(pedido,connexion);
			pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subcliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(subcliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(subcliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(subcliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(subcliente.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(subcliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(subcliente.getTipoIdentificacion(),connexion);
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepSave(subcliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(subcliente.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(subcliente.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(subcliente.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(subcliente.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(subcliente.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(subcliente.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(subcliente.getPaisNacionalidad(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(subcliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(subcliente.getTipoGenero(),connexion);
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepSave(subcliente.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(subcliente.getEstadoCivil(),connexion);
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepSave(subcliente.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				EstadoLegalDataAccess.save(subcliente.getEstadoLegal(),connexion);
				EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
				estadolegalLogic.deepSave(subcliente.getEstadoLegal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				TipoNivelEduDataAccess.save(subcliente.getTipoNivelEdu(),connexion);
				TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
				tiponiveleduLogic.deepSave(subcliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(subcliente.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(subcliente.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Factura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Factura factura:subcliente.getFacturas()) {
					FacturaLogic facturaLogic= new FacturaLogic(connexion);
					factura.setid_sub_cliente(subcliente.getId());
					FacturaDataAccess.save(factura,connexion);
					facturaLogic.deepSave(factura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:subcliente.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacion.setid_sub_cliente(subcliente.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
					consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:subcliente.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremision.setid_sub_cliente(subcliente.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
					guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:subcliente.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proforma.setid_sub_cliente(subcliente.getId());
					ProformaDataAccess.save(proforma,connexion);
					proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:subcliente.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexpor.setid_sub_cliente(subcliente.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
					pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:subcliente.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedido.setid_sub_cliente(subcliente.getId());
					PedidoDataAccess.save(pedido,connexion);
					pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(SubCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(subcliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subcliente);
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
			this.deepLoad(this.subcliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SubCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(subclientes!=null) {
				for(SubCliente subcliente:subclientes) {
					this.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclientes);
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
			if(subclientes!=null) {
				for(SubCliente subcliente:subclientes) {
					this.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclientes);
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
			this.getNewConnexionToDeep(SubCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(subcliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SubCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(subclientes!=null) {
				for(SubCliente subcliente:subclientes) {
					this.deepSave(subcliente,isDeep,deepLoadType,clases);
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
			if(subclientes!=null) {
				for(SubCliente subcliente:subclientes) {
					this.deepSave(subcliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSubClientesBusquedaPorIdentificacionWithConnection(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",SubClienteConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesBusquedaPorIdentificacion(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",SubClienteConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesBusquedaPorNombreCompletoWithConnection(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",SubClienteConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesBusquedaPorNombreCompleto(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",SubClienteConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesBusquedaPorRucWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",SubClienteConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesBusquedaPorRuc(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",SubClienteConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,SubClienteConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,SubClienteConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,SubClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,SubClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,SubClienteConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,SubClienteConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdEstadoCivilWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,SubClienteConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdEstadoCivil(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,SubClienteConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdEstadoLegalWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_legal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoLegal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoLegal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_legal,SubClienteConstantesFunciones.IDESTADOLEGAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoLegal);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoLegal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdEstadoLegal(String sFinalQuery,Pagination pagination,Long id_estado_legal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoLegal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoLegal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_legal,SubClienteConstantesFunciones.IDESTADOLEGAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoLegal);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoLegal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,SubClienteConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,SubClienteConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdPaisNacionalidadWithConnection(String sFinalQuery,Pagination pagination,Long id_pais_nacionalidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaisNacionalidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaisNacionalidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais_nacionalidad,SubClienteConstantesFunciones.IDPAISNACIONALIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaisNacionalidad);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaisNacionalidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdPaisNacionalidad(String sFinalQuery,Pagination pagination,Long id_pais_nacionalidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaisNacionalidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaisNacionalidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais_nacionalidad,SubClienteConstantesFunciones.IDPAISNACIONALIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaisNacionalidad);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaisNacionalidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SubClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SubClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdTipoGeneroWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,SubClienteConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdTipoGenero(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,SubClienteConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdTipoIdentificacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,SubClienteConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdTipoIdentificacion(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,SubClienteConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdTipoNivelEduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_nivel_edu)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNivelEdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNivelEdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nivel_edu,SubClienteConstantesFunciones.IDTIPONIVELEDU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNivelEdu);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNivelEdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdTipoNivelEdu(String sFinalQuery,Pagination pagination,Long id_tipo_nivel_edu)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNivelEdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNivelEdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nivel_edu,SubClienteConstantesFunciones.IDTIPONIVELEDU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNivelEdu);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNivelEdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubClientesFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,SubClienteConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubClientesFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,SubClienteConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			SubClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(this.subclientes);
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
			if(SubClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SubClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SubCliente subcliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SubClienteConstantesFunciones.ISCONAUDITORIA) {
				if(subcliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubClienteDataAccess.TABLENAME, subcliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubClienteLogic.registrarAuditoriaDetallesSubCliente(connexion,subcliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(subcliente.getIsDeleted()) {
					/*if(!subcliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SubClienteDataAccess.TABLENAME, subcliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SubClienteLogic.registrarAuditoriaDetallesSubCliente(connexion,subcliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubClienteDataAccess.TABLENAME, subcliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(subcliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubClienteDataAccess.TABLENAME, subcliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubClienteLogic.registrarAuditoriaDetallesSubCliente(connexion,subcliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSubCliente(Connexion connexion,SubCliente subcliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(subcliente.getIsNew()||!subcliente.getid_empresa().equals(subcliente.getSubClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_empresa().toString();
				}
				if(subcliente.getid_empresa()!=null)
				{
					strValorNuevo=subcliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_cliente().equals(subcliente.getSubClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_cliente().toString();
				}
				if(subcliente.getid_cliente()!=null)
				{
					strValorNuevo=subcliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_sucursal().equals(subcliente.getSubClienteOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_sucursal()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_sucursal().toString();
				}
				if(subcliente.getid_sucursal()!=null)
				{
					strValorNuevo=subcliente.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_tipo_identificacion().equals(subcliente.getSubClienteOriginal().getid_tipo_identificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_tipo_identificacion()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_tipo_identificacion().toString();
				}
				if(subcliente.getid_tipo_identificacion()!=null)
				{
					strValorNuevo=subcliente.getid_tipo_identificacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDTIPOIDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getidentificacion().equals(subcliente.getSubClienteOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getidentificacion()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getidentificacion();
				}
				if(subcliente.getidentificacion()!=null)
				{
					strValorNuevo=subcliente.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getruc().equals(subcliente.getSubClienteOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getruc()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getruc();
				}
				if(subcliente.getruc()!=null)
				{
					strValorNuevo=subcliente.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getnombre().equals(subcliente.getSubClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getnombre()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getnombre();
				}
				if(subcliente.getnombre()!=null)
				{
					strValorNuevo=subcliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getapellido().equals(subcliente.getSubClienteOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getapellido()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getapellido();
				}
				if(subcliente.getapellido()!=null)
				{
					strValorNuevo=subcliente.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getnombre_completo().equals(subcliente.getSubClienteOriginal().getnombre_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getnombre_completo()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getnombre_completo();
				}
				if(subcliente.getnombre_completo()!=null)
				{
					strValorNuevo=subcliente.getnombre_completo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.NOMBRECOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getdireccion().equals(subcliente.getSubClienteOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getdireccion()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getdireccion();
				}
				if(subcliente.getdireccion()!=null)
				{
					strValorNuevo=subcliente.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.gettelefono().equals(subcliente.getSubClienteOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().gettelefono()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().gettelefono();
				}
				if(subcliente.gettelefono()!=null)
				{
					strValorNuevo=subcliente.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getnumero_celular().equals(subcliente.getSubClienteOriginal().getnumero_celular()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getnumero_celular()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getnumero_celular();
				}
				if(subcliente.getnumero_celular()!=null)
				{
					strValorNuevo=subcliente.getnumero_celular() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.NUMEROCELULAR,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getmail().equals(subcliente.getSubClienteOriginal().getmail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getmail()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getmail();
				}
				if(subcliente.getmail()!=null)
				{
					strValorNuevo=subcliente.getmail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.MAIL,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getfecha_nacimiento().equals(subcliente.getSubClienteOriginal().getfecha_nacimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getfecha_nacimiento()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getfecha_nacimiento().toString();
				}
				if(subcliente.getfecha_nacimiento()!=null)
				{
					strValorNuevo=subcliente.getfecha_nacimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.FECHANACIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getfechao().equals(subcliente.getSubClienteOriginal().getfechao()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getfechao()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getfechao().toString();
				}
				if(subcliente.getfechao()!=null)
				{
					strValorNuevo=subcliente.getfechao().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getobservacion().equals(subcliente.getSubClienteOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getobservacion()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getobservacion();
				}
				if(subcliente.getobservacion()!=null)
				{
					strValorNuevo=subcliente.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_pais().equals(subcliente.getSubClienteOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_pais()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_pais().toString();
				}
				if(subcliente.getid_pais()!=null)
				{
					strValorNuevo=subcliente.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_ciudad().equals(subcliente.getSubClienteOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_ciudad()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_ciudad().toString();
				}
				if(subcliente.getid_ciudad()!=null)
				{
					strValorNuevo=subcliente.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_zona().equals(subcliente.getSubClienteOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_zona()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_zona().toString();
				}
				if(subcliente.getid_zona()!=null)
				{
					strValorNuevo=subcliente.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_pais_nacionalidad().equals(subcliente.getSubClienteOriginal().getid_pais_nacionalidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_pais_nacionalidad()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_pais_nacionalidad().toString();
				}
				if(subcliente.getid_pais_nacionalidad()!=null)
				{
					strValorNuevo=subcliente.getid_pais_nacionalidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDPAISNACIONALIDAD,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_tipo_genero().equals(subcliente.getSubClienteOriginal().getid_tipo_genero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_tipo_genero()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_tipo_genero().toString();
				}
				if(subcliente.getid_tipo_genero()!=null)
				{
					strValorNuevo=subcliente.getid_tipo_genero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDTIPOGENERO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_estado_civil().equals(subcliente.getSubClienteOriginal().getid_estado_civil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_estado_civil()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_estado_civil().toString();
				}
				if(subcliente.getid_estado_civil()!=null)
				{
					strValorNuevo=subcliente.getid_estado_civil().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDESTADOCIVIL,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_estado_legal().equals(subcliente.getSubClienteOriginal().getid_estado_legal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_estado_legal()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_estado_legal().toString();
				}
				if(subcliente.getid_estado_legal()!=null)
				{
					strValorNuevo=subcliente.getid_estado_legal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDESTADOLEGAL,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_tipo_nivel_edu().equals(subcliente.getSubClienteOriginal().getid_tipo_nivel_edu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_tipo_nivel_edu()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_tipo_nivel_edu().toString();
				}
				if(subcliente.getid_tipo_nivel_edu()!=null)
				{
					strValorNuevo=subcliente.getid_tipo_nivel_edu().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDTIPONIVELEDU,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getpath_imagen_firma().equals(subcliente.getSubClienteOriginal().getpath_imagen_firma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getpath_imagen_firma()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getpath_imagen_firma();
				}
				if(subcliente.getpath_imagen_firma()!=null)
				{
					strValorNuevo=subcliente.getpath_imagen_firma() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.PATHIMAGENFIRMA,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getid_cuenta_contable().equals(subcliente.getSubClienteOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getid_cuenta_contable().toString();
				}
				if(subcliente.getid_cuenta_contable()!=null)
				{
					strValorNuevo=subcliente.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getnumero_carga().equals(subcliente.getSubClienteOriginal().getnumero_carga()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getnumero_carga()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getnumero_carga().toString();
				}
				if(subcliente.getnumero_carga()!=null)
				{
					strValorNuevo=subcliente.getnumero_carga().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.NUMEROCARGA,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getlimite_credito().equals(subcliente.getSubClienteOriginal().getlimite_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getlimite_credito()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getlimite_credito().toString();
				}
				if(subcliente.getlimite_credito()!=null)
				{
					strValorNuevo=subcliente.getlimite_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.LIMITECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getdescuento().equals(subcliente.getSubClienteOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getdescuento()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getdescuento().toString();
				}
				if(subcliente.getdescuento()!=null)
				{
					strValorNuevo=subcliente.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getcodigo_contrato().equals(subcliente.getSubClienteOriginal().getcodigo_contrato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getcodigo_contrato()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getcodigo_contrato();
				}
				if(subcliente.getcodigo_contrato()!=null)
				{
					strValorNuevo=subcliente.getcodigo_contrato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.CODIGOCONTRATO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getvalor_contrato().equals(subcliente.getSubClienteOriginal().getvalor_contrato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getvalor_contrato()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getvalor_contrato().toString();
				}
				if(subcliente.getvalor_contrato()!=null)
				{
					strValorNuevo=subcliente.getvalor_contrato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.VALORCONTRATO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getfecha_inicio().equals(subcliente.getSubClienteOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getfecha_inicio()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getfecha_inicio().toString();
				}
				if(subcliente.getfecha_inicio()!=null)
				{
					strValorNuevo=subcliente.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getfecha_fin().equals(subcliente.getSubClienteOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getfecha_fin()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getfecha_fin().toString();
				}
				if(subcliente.getfecha_fin()!=null)
				{
					strValorNuevo=subcliente.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(subcliente.getIsNew()||!subcliente.getplazo().equals(subcliente.getSubClienteOriginal().getplazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subcliente.getSubClienteOriginal().getplazo()!=null)
				{
					strValorActual=subcliente.getSubClienteOriginal().getplazo().toString();
				}
				if(subcliente.getplazo()!=null)
				{
					strValorNuevo=subcliente.getplazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubClienteConstantesFunciones.PLAZO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSubClienteRelacionesWithConnection(SubCliente subcliente,List<Factura> facturas,List<Consignacion> consignacions,List<GuiaRemision> guiaremisions,List<Proforma> proformas,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos) throws Exception {

		if(!subcliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubClienteRelacionesBase(subcliente,facturas,consignacions,guiaremisions,proformas,pedidoexpors,pedidos,true);
		}
	}

	public void saveSubClienteRelaciones(SubCliente subcliente,List<Factura> facturas,List<Consignacion> consignacions,List<GuiaRemision> guiaremisions,List<Proforma> proformas,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos)throws Exception {

		if(!subcliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubClienteRelacionesBase(subcliente,facturas,consignacions,guiaremisions,proformas,pedidoexpors,pedidos,false);
		}
	}

	public void saveSubClienteRelacionesBase(SubCliente subcliente,List<Factura> facturas,List<Consignacion> consignacions,List<GuiaRemision> guiaremisions,List<Proforma> proformas,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SubCliente-saveRelacionesWithConnection");}
	
			subcliente.setFacturas(facturas);
			subcliente.setConsignacions(consignacions);
			subcliente.setGuiaRemisions(guiaremisions);
			subcliente.setProformas(proformas);
			subcliente.setPedidoExpors(pedidoexpors);
			subcliente.setPedidos(pedidos);

			this.setSubCliente(subcliente);

			if(SubClienteLogicAdditional.validarSaveRelaciones(subcliente,this)) {

				SubClienteLogicAdditional.updateRelacionesToSave(subcliente,this);

				if((subcliente.getIsNew()||subcliente.getIsChanged())&&!subcliente.getIsDeleted()) {
					this.saveSubCliente();
					this.saveSubClienteRelacionesDetalles(facturas,consignacions,guiaremisions,proformas,pedidoexpors,pedidos);

				} else if(subcliente.getIsDeleted()) {
					this.saveSubClienteRelacionesDetalles(facturas,consignacions,guiaremisions,proformas,pedidoexpors,pedidos);
					this.saveSubCliente();
				}

				SubClienteLogicAdditional.updateRelacionesToSaveAfter(subcliente,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FacturaConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturas(facturas,true,true);
			ConsignacionConstantesFunciones.InicializarGeneralEntityAuxiliaresConsignacions(consignacions,true,true);
			GuiaRemisionConstantesFunciones.InicializarGeneralEntityAuxiliaresGuiaRemisions(guiaremisions,true,true);
			ProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresProformas(proformas,true,true);
			PedidoExporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoExpors(pedidoexpors,true,true);
			PedidoConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidos(pedidos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveSubClienteRelacionesDetalles(List<Factura> facturas,List<Consignacion> consignacions,List<GuiaRemision> guiaremisions,List<Proforma> proformas,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos)throws Exception {
		try {
	

			Long idSubClienteActual=this.getSubCliente().getId();

			FacturaLogic facturaLogic_Desde_SubCliente=new FacturaLogic();
			facturaLogic_Desde_SubCliente.setFacturas(facturas);

			facturaLogic_Desde_SubCliente.setConnexion(this.getConnexion());
			facturaLogic_Desde_SubCliente.setDatosCliente(this.datosCliente);

			for(Factura factura_Desde_SubCliente:facturaLogic_Desde_SubCliente.getFacturas()) {
				factura_Desde_SubCliente.setid_sub_cliente(idSubClienteActual);

				facturaLogic_Desde_SubCliente.setFactura(factura_Desde_SubCliente);
				facturaLogic_Desde_SubCliente.saveFactura();

				Long idFacturaActual=factura_Desde_SubCliente.getId();

				DetaFormaPagoLogic detaformapagoLogic_Desde_Factura=new DetaFormaPagoLogic();

				if(factura_Desde_SubCliente.getDetaFormaPagos()==null){
					factura_Desde_SubCliente.setDetaFormaPagos(new ArrayList<DetaFormaPago>());
				}

				detaformapagoLogic_Desde_Factura.setDetaFormaPagos(factura_Desde_SubCliente.getDetaFormaPagos());

				detaformapagoLogic_Desde_Factura.setConnexion(this.getConnexion());
				detaformapagoLogic_Desde_Factura.setDatosCliente(this.datosCliente);

				for(DetaFormaPago detaformapago_Desde_Factura:detaformapagoLogic_Desde_Factura.getDetaFormaPagos()) {
					detaformapago_Desde_Factura.setid_factura(idFacturaActual);

					detaformapagoLogic_Desde_Factura.setDetaFormaPago(detaformapago_Desde_Factura);
					detaformapagoLogic_Desde_Factura.saveDetaFormaPago();

					Long idDetaFormaPagoActual=detaformapago_Desde_Factura.getId();

					BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

					if(detaformapago_Desde_Factura.getBancoFormaPagos()==null){
						detaformapago_Desde_Factura.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
					}

					bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_Factura.getBancoFormaPagos());

					bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
					bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

					for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
						bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
					}

					bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
				}


				DetalleFacturaLogic detallefacturaLogic_Desde_Factura=new DetalleFacturaLogic();

				if(factura_Desde_SubCliente.getDetalleFacturas()==null){
					factura_Desde_SubCliente.setDetalleFacturas(new ArrayList<DetalleFactura>());
				}

				detallefacturaLogic_Desde_Factura.setDetalleFacturas(factura_Desde_SubCliente.getDetalleFacturas());

				detallefacturaLogic_Desde_Factura.setConnexion(this.getConnexion());
				detallefacturaLogic_Desde_Factura.setDatosCliente(this.datosCliente);

				for(DetalleFactura detallefactura_Desde_Factura:detallefacturaLogic_Desde_Factura.getDetalleFacturas()) {
					detallefactura_Desde_Factura.setid_factura(idFacturaActual);
				}

				detallefacturaLogic_Desde_Factura.saveDetalleFacturas();
			}


			ConsignacionLogic consignacionLogic_Desde_SubCliente=new ConsignacionLogic();
			consignacionLogic_Desde_SubCliente.setConsignacions(consignacions);

			consignacionLogic_Desde_SubCliente.setConnexion(this.getConnexion());
			consignacionLogic_Desde_SubCliente.setDatosCliente(this.datosCliente);

			for(Consignacion consignacion_Desde_SubCliente:consignacionLogic_Desde_SubCliente.getConsignacions()) {
				consignacion_Desde_SubCliente.setid_sub_cliente(idSubClienteActual);

				consignacionLogic_Desde_SubCliente.setConsignacion(consignacion_Desde_SubCliente);
				consignacionLogic_Desde_SubCliente.saveConsignacion();

				Long idConsignacionActual=consignacion_Desde_SubCliente.getId();

				DetalleConsignacionLogic detalleconsignacionLogic_Desde_Consignacion=new DetalleConsignacionLogic();

				if(consignacion_Desde_SubCliente.getDetalleConsignacions()==null){
					consignacion_Desde_SubCliente.setDetalleConsignacions(new ArrayList<DetalleConsignacion>());
				}

				detalleconsignacionLogic_Desde_Consignacion.setDetalleConsignacions(consignacion_Desde_SubCliente.getDetalleConsignacions());

				detalleconsignacionLogic_Desde_Consignacion.setConnexion(this.getConnexion());
				detalleconsignacionLogic_Desde_Consignacion.setDatosCliente(this.datosCliente);

				for(DetalleConsignacion detalleconsignacion_Desde_Consignacion:detalleconsignacionLogic_Desde_Consignacion.getDetalleConsignacions()) {
					detalleconsignacion_Desde_Consignacion.setid_consignacion(idConsignacionActual);
				}

				detalleconsignacionLogic_Desde_Consignacion.saveDetalleConsignacions();
			}


			GuiaRemisionLogic guiaremisionLogic_Desde_SubCliente=new GuiaRemisionLogic();
			guiaremisionLogic_Desde_SubCliente.setGuiaRemisions(guiaremisions);

			guiaremisionLogic_Desde_SubCliente.setConnexion(this.getConnexion());
			guiaremisionLogic_Desde_SubCliente.setDatosCliente(this.datosCliente);

			for(GuiaRemision guiaremision_Desde_SubCliente:guiaremisionLogic_Desde_SubCliente.getGuiaRemisions()) {
				guiaremision_Desde_SubCliente.setid_sub_cliente(idSubClienteActual);

				guiaremisionLogic_Desde_SubCliente.setGuiaRemision(guiaremision_Desde_SubCliente);
				guiaremisionLogic_Desde_SubCliente.saveGuiaRemision();

				Long idGuiaRemisionActual=guiaremision_Desde_SubCliente.getId();

				DetalleGuiaRemisionLogic detalleguiaremisionLogic_Desde_GuiaRemision=new DetalleGuiaRemisionLogic();

				if(guiaremision_Desde_SubCliente.getDetalleGuiaRemisions()==null){
					guiaremision_Desde_SubCliente.setDetalleGuiaRemisions(new ArrayList<DetalleGuiaRemision>());
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.setDetalleGuiaRemisions(guiaremision_Desde_SubCliente.getDetalleGuiaRemisions());

				detalleguiaremisionLogic_Desde_GuiaRemision.setConnexion(this.getConnexion());
				detalleguiaremisionLogic_Desde_GuiaRemision.setDatosCliente(this.datosCliente);

				for(DetalleGuiaRemision detalleguiaremision_Desde_GuiaRemision:detalleguiaremisionLogic_Desde_GuiaRemision.getDetalleGuiaRemisions()) {
					detalleguiaremision_Desde_GuiaRemision.setid_guia_remision(idGuiaRemisionActual);
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.saveDetalleGuiaRemisions();
			}


			ProformaLogic proformaLogic_Desde_SubCliente=new ProformaLogic();
			proformaLogic_Desde_SubCliente.setProformas(proformas);

			proformaLogic_Desde_SubCliente.setConnexion(this.getConnexion());
			proformaLogic_Desde_SubCliente.setDatosCliente(this.datosCliente);

			for(Proforma proforma_Desde_SubCliente:proformaLogic_Desde_SubCliente.getProformas()) {
				proforma_Desde_SubCliente.setid_sub_cliente(idSubClienteActual);

				proformaLogic_Desde_SubCliente.setProforma(proforma_Desde_SubCliente);
				proformaLogic_Desde_SubCliente.saveProforma();

				Long idProformaActual=proforma_Desde_SubCliente.getId();

				TerminoProformaLogic terminoproformaLogic_Desde_Proforma=new TerminoProformaLogic();

				if(proforma_Desde_SubCliente.getTerminoProformas()==null){
					proforma_Desde_SubCliente.setTerminoProformas(new ArrayList<TerminoProforma>());
				}

				terminoproformaLogic_Desde_Proforma.setTerminoProformas(proforma_Desde_SubCliente.getTerminoProformas());

				terminoproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				terminoproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(TerminoProforma terminoproforma_Desde_Proforma:terminoproformaLogic_Desde_Proforma.getTerminoProformas()) {
					terminoproforma_Desde_Proforma.setid_proforma(idProformaActual);

					terminoproformaLogic_Desde_Proforma.setTerminoProforma(terminoproforma_Desde_Proforma);
					terminoproformaLogic_Desde_Proforma.saveTerminoProforma();
				}


				DetalleProformaLogic detalleproformaLogic_Desde_Proforma=new DetalleProformaLogic();

				if(proforma_Desde_SubCliente.getDetalleProformas()==null){
					proforma_Desde_SubCliente.setDetalleProformas(new ArrayList<DetalleProforma>());
				}

				detalleproformaLogic_Desde_Proforma.setDetalleProformas(proforma_Desde_SubCliente.getDetalleProformas());

				detalleproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				detalleproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(DetalleProforma detalleproforma_Desde_Proforma:detalleproformaLogic_Desde_Proforma.getDetalleProformas()) {
					detalleproforma_Desde_Proforma.setid_proforma(idProformaActual);
				}

				detalleproformaLogic_Desde_Proforma.saveDetalleProformas();
			}


			PedidoExporLogic pedidoexporLogic_Desde_SubCliente=new PedidoExporLogic();
			pedidoexporLogic_Desde_SubCliente.setPedidoExpors(pedidoexpors);

			pedidoexporLogic_Desde_SubCliente.setConnexion(this.getConnexion());
			pedidoexporLogic_Desde_SubCliente.setDatosCliente(this.datosCliente);

			for(PedidoExpor pedidoexpor_Desde_SubCliente:pedidoexporLogic_Desde_SubCliente.getPedidoExpors()) {
				pedidoexpor_Desde_SubCliente.setid_sub_cliente(idSubClienteActual);

				pedidoexporLogic_Desde_SubCliente.setPedidoExpor(pedidoexpor_Desde_SubCliente);
				pedidoexporLogic_Desde_SubCliente.savePedidoExpor();
			}


			PedidoLogic pedidoLogic_Desde_SubCliente=new PedidoLogic();
			pedidoLogic_Desde_SubCliente.setPedidos(pedidos);

			pedidoLogic_Desde_SubCliente.setConnexion(this.getConnexion());
			pedidoLogic_Desde_SubCliente.setDatosCliente(this.datosCliente);

			for(Pedido pedido_Desde_SubCliente:pedidoLogic_Desde_SubCliente.getPedidos()) {
				pedido_Desde_SubCliente.setid_sub_cliente(idSubClienteActual);

				pedidoLogic_Desde_SubCliente.setPedido(pedido_Desde_SubCliente);
				pedidoLogic_Desde_SubCliente.savePedido();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSubCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubClienteConstantesFunciones.getClassesRelationshipsOfSubCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
