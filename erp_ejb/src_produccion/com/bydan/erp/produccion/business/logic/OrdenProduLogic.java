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
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.produccion.util.OrdenProduConstantesFunciones;
import com.bydan.erp.produccion.util.OrdenProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.OrdenProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.OrdenProdu;
import com.bydan.erp.produccion.business.logic.OrdenProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class OrdenProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(OrdenProduLogic.class);
	
	protected OrdenProduDataAccess ordenproduDataAccess; 	
	protected OrdenProdu ordenprodu;
	protected List<OrdenProdu> ordenprodus;
	protected Object ordenproduObject;	
	protected List<Object> ordenprodusObject;
	
	public static ClassValidator<OrdenProdu> ordenproduValidator = new ClassValidator<OrdenProdu>(OrdenProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected OrdenProduLogicAdditional ordenproduLogicAdditional=null;
	
	public OrdenProduLogicAdditional getOrdenProduLogicAdditional() {
		return this.ordenproduLogicAdditional;
	}
	
	public void setOrdenProduLogicAdditional(OrdenProduLogicAdditional ordenproduLogicAdditional) {
		try {
			this.ordenproduLogicAdditional=ordenproduLogicAdditional;
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
	
	
	
	
	public  OrdenProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.ordenproduDataAccess = new OrdenProduDataAccess();
			
			this.ordenprodus= new ArrayList<OrdenProdu>();
			this.ordenprodu= new OrdenProdu();
			
			this.ordenproduObject=new Object();
			this.ordenprodusObject=new ArrayList<Object>();
				
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
			
			this.ordenproduDataAccess.setConnexionType(this.connexionType);
			this.ordenproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  OrdenProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.ordenproduDataAccess = new OrdenProduDataAccess();
			this.ordenprodus= new ArrayList<OrdenProdu>();
			this.ordenprodu= new OrdenProdu();
			this.ordenproduObject=new Object();
			this.ordenprodusObject=new ArrayList<Object>();
			
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
			
			this.ordenproduDataAccess.setConnexionType(this.connexionType);
			this.ordenproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public OrdenProdu getOrdenProdu() throws Exception {	
		OrdenProduLogicAdditional.checkOrdenProduToGet(ordenprodu,this.datosCliente,this.arrDatoGeneral);
		OrdenProduLogicAdditional.updateOrdenProduToGet(ordenprodu,this.arrDatoGeneral);
		
		return ordenprodu;
	}
		
	public void setOrdenProdu(OrdenProdu newOrdenProdu) {
		this.ordenprodu = newOrdenProdu;
	}
	
	public OrdenProduDataAccess getOrdenProduDataAccess() {
		return ordenproduDataAccess;
	}
	
	public void setOrdenProduDataAccess(OrdenProduDataAccess newordenproduDataAccess) {
		this.ordenproduDataAccess = newordenproduDataAccess;
	}
	
	public List<OrdenProdu> getOrdenProdus() throws Exception {		
		this.quitarOrdenProdusNulos();
		
		OrdenProduLogicAdditional.checkOrdenProduToGets(ordenprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (OrdenProdu ordenproduLocal: ordenprodus ) {
			OrdenProduLogicAdditional.updateOrdenProduToGet(ordenproduLocal,this.arrDatoGeneral);
		}
		
		return ordenprodus;
	}
	
	public void setOrdenProdus(List<OrdenProdu> newOrdenProdus) {
		this.ordenprodus = newOrdenProdus;
	}
	
	public Object getOrdenProduObject() {	
		this.ordenproduObject=this.ordenproduDataAccess.getEntityObject();
		return this.ordenproduObject;
	}
		
	public void setOrdenProduObject(Object newOrdenProduObject) {
		this.ordenproduObject = newOrdenProduObject;
	}
	
	public List<Object> getOrdenProdusObject() {		
		this.ordenprodusObject=this.ordenproduDataAccess.getEntitiesObject();
		return this.ordenprodusObject;
	}
		
	public void setOrdenProdusObject(List<Object> newOrdenProdusObject) {
		this.ordenprodusObject = newOrdenProdusObject;
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
		
		if(this.ordenproduDataAccess!=null) {
			this.ordenproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			ordenproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			ordenproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ordenprodu = new  OrdenProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ordenprodu=ordenproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodu);
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
		ordenprodu = new  OrdenProdu();
		  		  
        try {
			
			ordenprodu=ordenproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ordenprodu = new  OrdenProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ordenprodu=ordenproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodu);
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
		ordenprodu = new  OrdenProdu();
		  		  
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
		ordenprodu = new  OrdenProdu();
		  		  
        try {
			
			ordenprodu=ordenproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ordenprodu = new  OrdenProdu();
		  		  
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
		ordenprodu = new  OrdenProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =ordenproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordenprodu = new  OrdenProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=ordenproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ordenprodu = new  OrdenProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =ordenproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordenprodu = new  OrdenProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=ordenproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ordenprodu = new  OrdenProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =ordenproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordenprodu = new  OrdenProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=ordenproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
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
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
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
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
        try {			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
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
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
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
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
        try {
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
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
		ordenprodus = new  ArrayList<OrdenProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
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
		ordenprodus = new  ArrayList<OrdenProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ordenprodu = new  OrdenProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodu=ordenproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodu);
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
		ordenprodu = new  OrdenProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodu=ordenproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
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
		ordenprodus = new  ArrayList<OrdenProdu>();
		  		  
        try {
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosOrdenProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		ordenprodus = new  ArrayList<OrdenProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getTodosOrdenProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
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
	
	public  void  getTodosOrdenProdus(String sFinalQuery,Pagination pagination)throws Exception {
		ordenprodus = new  ArrayList<OrdenProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOrdenProdu(ordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarOrdenProdu(OrdenProdu ordenprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(ordenprodu.getIsNew() || ordenprodu.getIsChanged()) { 
			this.invalidValues = ordenproduValidator.getInvalidValues(ordenprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ordenprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarOrdenProdu(List<OrdenProdu> OrdenProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(OrdenProdu ordenproduLocal:ordenprodus) {				
			estaValidadoObjeto=this.validarGuardarOrdenProdu(ordenproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarOrdenProdu(List<OrdenProdu> OrdenProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOrdenProdu(ordenprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarOrdenProdu(OrdenProdu OrdenProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOrdenProdu(ordenprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(OrdenProdu ordenprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ordenprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=OrdenProduConstantesFunciones.getOrdenProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ordenprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(OrdenProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(OrdenProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveOrdenProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-saveOrdenProduWithConnection");connexion.begin();			
			
			OrdenProduLogicAdditional.checkOrdenProduToSave(this.ordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OrdenProduLogicAdditional.updateOrdenProduToSave(this.ordenprodu,this.arrDatoGeneral);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ordenprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowOrdenProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOrdenProdu(this.ordenprodu)) {
				OrdenProduDataAccess.save(this.ordenprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OrdenProduLogicAdditional.checkOrdenProduToSaveAfter(this.ordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOrdenProdu();
			
			connexion.commit();			
			
			if(this.ordenprodu.getIsDeleted()) {
				this.ordenprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveOrdenProdu()throws Exception {	
		try {	
			
			OrdenProduLogicAdditional.checkOrdenProduToSave(this.ordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OrdenProduLogicAdditional.updateOrdenProduToSave(this.ordenprodu,this.arrDatoGeneral);
			
			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ordenprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOrdenProdu(this.ordenprodu)) {			
				OrdenProduDataAccess.save(this.ordenprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OrdenProduLogicAdditional.checkOrdenProduToSaveAfter(this.ordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ordenprodu.getIsDeleted()) {
				this.ordenprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveOrdenProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-saveOrdenProdusWithConnection");connexion.begin();			
			
			OrdenProduLogicAdditional.checkOrdenProduToSaves(ordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowOrdenProdus();
			
			Boolean validadoTodosOrdenProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(OrdenProdu ordenproduLocal:ordenprodus) {		
				if(ordenproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OrdenProduLogicAdditional.updateOrdenProduToSave(ordenproduLocal,this.arrDatoGeneral);
	        	
				OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ordenproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOrdenProdu(ordenproduLocal)) {
					OrdenProduDataAccess.save(ordenproduLocal, connexion);				
				} else {
					validadoTodosOrdenProdu=false;
				}
			}
			
			if(!validadoTodosOrdenProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OrdenProduLogicAdditional.checkOrdenProduToSavesAfter(ordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOrdenProdus();
			
			connexion.commit();		
			
			this.quitarOrdenProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveOrdenProdus()throws Exception {				
		 try {	
			OrdenProduLogicAdditional.checkOrdenProduToSaves(ordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosOrdenProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(OrdenProdu ordenproduLocal:ordenprodus) {				
				if(ordenproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OrdenProduLogicAdditional.updateOrdenProduToSave(ordenproduLocal,this.arrDatoGeneral);
	        	
				OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ordenproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOrdenProdu(ordenproduLocal)) {				
					OrdenProduDataAccess.save(ordenproduLocal, connexion);				
				} else {
					validadoTodosOrdenProdu=false;
				}
			}
			
			if(!validadoTodosOrdenProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OrdenProduLogicAdditional.checkOrdenProduToSavesAfter(ordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarOrdenProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OrdenProduParameterReturnGeneral procesarAccionOrdenProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<OrdenProdu> ordenprodus,OrdenProduParameterReturnGeneral ordenproduParameterGeneral)throws Exception {
		 try {	
			OrdenProduParameterReturnGeneral ordenproduReturnGeneral=new OrdenProduParameterReturnGeneral();
	
			OrdenProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ordenprodus,ordenproduParameterGeneral,ordenproduReturnGeneral);
			
			return ordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OrdenProduParameterReturnGeneral procesarAccionOrdenProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<OrdenProdu> ordenprodus,OrdenProduParameterReturnGeneral ordenproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-procesarAccionOrdenProdusWithConnection");connexion.begin();			
			
			OrdenProduParameterReturnGeneral ordenproduReturnGeneral=new OrdenProduParameterReturnGeneral();
	
			OrdenProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ordenprodus,ordenproduParameterGeneral,ordenproduReturnGeneral);
			
			this.connexion.commit();
			
			return ordenproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OrdenProduParameterReturnGeneral procesarEventosOrdenProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<OrdenProdu> ordenprodus,OrdenProdu ordenprodu,OrdenProduParameterReturnGeneral ordenproduParameterGeneral,Boolean isEsNuevoOrdenProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			OrdenProduParameterReturnGeneral ordenproduReturnGeneral=new OrdenProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ordenproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OrdenProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ordenprodus,ordenprodu,ordenproduParameterGeneral,ordenproduReturnGeneral,isEsNuevoOrdenProdu,clases);
			
			return ordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public OrdenProduParameterReturnGeneral procesarEventosOrdenProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<OrdenProdu> ordenprodus,OrdenProdu ordenprodu,OrdenProduParameterReturnGeneral ordenproduParameterGeneral,Boolean isEsNuevoOrdenProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-procesarEventosOrdenProdusWithConnection");connexion.begin();			
			
			OrdenProduParameterReturnGeneral ordenproduReturnGeneral=new OrdenProduParameterReturnGeneral();
	
			ordenproduReturnGeneral.setOrdenProdu(ordenprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ordenproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OrdenProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ordenprodus,ordenprodu,ordenproduParameterGeneral,ordenproduReturnGeneral,isEsNuevoOrdenProdu,clases);
			
			this.connexion.commit();
			
			return ordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OrdenProduParameterReturnGeneral procesarImportacionOrdenProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,OrdenProduParameterReturnGeneral ordenproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-procesarImportacionOrdenProdusWithConnection");connexion.begin();			
			
			OrdenProduParameterReturnGeneral ordenproduReturnGeneral=new OrdenProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.ordenprodus=new ArrayList<OrdenProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ordenprodu=new OrdenProdu();
				
				
				if(conColumnasBase) {this.ordenprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ordenprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.ordenprodu.setsecuencial(arrColumnas[iColumn++]);
				this.ordenprodu.setdireccion_cliente(arrColumnas[iColumn++]);
				this.ordenprodu.settelefono_cliente(arrColumnas[iColumn++]);
				this.ordenprodu.setruc_cliente(arrColumnas[iColumn++]);
				this.ordenprodu.setlote(arrColumnas[iColumn++]);
				this.ordenprodu.setfecha_pedido(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.ordenprodu.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.ordenprodu.setes_uso_interno(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.ordenprodu.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.ordenprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.ordenprodus.add(this.ordenprodu);
			}
			
			this.saveOrdenProdus();
			
			this.connexion.commit();
			
			ordenproduReturnGeneral.setConRetornoEstaProcesado(true);
			ordenproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return ordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarOrdenProdusEliminados() throws Exception {				
		
		List<OrdenProdu> ordenprodusAux= new ArrayList<OrdenProdu>();
		
		for(OrdenProdu ordenprodu:ordenprodus) {
			if(!ordenprodu.getIsDeleted()) {
				ordenprodusAux.add(ordenprodu);
			}
		}
		
		ordenprodus=ordenprodusAux;
	}
	
	public void quitarOrdenProdusNulos() throws Exception {				
		
		List<OrdenProdu> ordenprodusAux= new ArrayList<OrdenProdu>();
		
		for(OrdenProdu ordenprodu : this.ordenprodus) {
			if(ordenprodu==null) {
				ordenprodusAux.add(ordenprodu);
			}
		}
		
		//this.ordenprodus=ordenprodusAux;
		
		this.ordenprodus.removeAll(ordenprodusAux);
	}
	
	public void getSetVersionRowOrdenProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ordenprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ordenprodu.getIsDeleted() || (ordenprodu.getIsChanged()&&!ordenprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=ordenproduDataAccess.getSetVersionRowOrdenProdu(connexion,ordenprodu.getId());
				
				if(!ordenprodu.getVersionRow().equals(timestamp)) {	
					ordenprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ordenprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowOrdenProdu()throws Exception {	
		
		if(ordenprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ordenprodu.getIsDeleted() || (ordenprodu.getIsChanged()&&!ordenprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=ordenproduDataAccess.getSetVersionRowOrdenProdu(connexion,ordenprodu.getId());
			
			try {							
				if(!ordenprodu.getVersionRow().equals(timestamp)) {	
					ordenprodu.setVersionRow(timestamp);
				}
				
				ordenprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowOrdenProdusWithConnection()throws Exception {	
		if(ordenprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(OrdenProdu ordenproduAux:ordenprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(ordenproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ordenproduAux.getIsDeleted() || (ordenproduAux.getIsChanged()&&!ordenproduAux.getIsNew())) {
						
						timestamp=ordenproduDataAccess.getSetVersionRowOrdenProdu(connexion,ordenproduAux.getId());
						
						if(!ordenprodu.getVersionRow().equals(timestamp)) {	
							ordenproduAux.setVersionRow(timestamp);
						}
								
						ordenproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowOrdenProdus()throws Exception {	
		if(ordenprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(OrdenProdu ordenproduAux:ordenprodus) {
					if(ordenproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ordenproduAux.getIsDeleted() || (ordenproduAux.getIsChanged()&&!ordenproduAux.getIsNew())) {
						
						timestamp=ordenproduDataAccess.getSetVersionRowOrdenProdu(connexion,ordenproduAux.getId());
						
						if(!ordenproduAux.getVersionRow().equals(timestamp)) {	
							ordenproduAux.setVersionRow(timestamp);
						}
						
													
						ordenproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public OrdenProduParameterReturnGeneral cargarCombosLoteForeignKeyOrdenProduWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrioridadEmpresaProdu,String finalQueryGlobalEmpleadoResponsable,String finalQueryGlobalCliente,String finalQueryGlobalEstadoOrdenProdu) throws Exception {
		OrdenProduParameterReturnGeneral  ordenproduReturnGeneral =new OrdenProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyOrdenProduWithConnection");connexion.begin();
			
			ordenproduReturnGeneral =new OrdenProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ordenproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ordenproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			ordenproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			ordenproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			ordenproduReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusForeignKey=new ArrayList<TipoPrioridadEmpresaProdu>();
			TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic=new TipoPrioridadEmpresaProduLogic();
			tipoprioridadempresaproduLogic.setConnexion(this.connexion);
			tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrioridadEmpresaProdu.equals("NONE")) {
				tipoprioridadempresaproduLogic.getTodosTipoPrioridadEmpresaProdus(finalQueryGlobalTipoPrioridadEmpresaProdu,new Pagination());
				tipoprioridadempresaprodusForeignKey=tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProdus();
			}

			ordenproduReturnGeneral.settipoprioridadempresaprodusForeignKey(tipoprioridadempresaprodusForeignKey);


			List<Empleado> empleadoresponsablesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoresponsableLogic=new EmpleadoLogic();
			empleadoresponsableLogic.setConnexion(this.connexion);
			empleadoresponsableLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoResponsable.equals("NONE")) {
				empleadoresponsableLogic.getTodosEmpleados(finalQueryGlobalEmpleadoResponsable,new Pagination());
				empleadoresponsablesForeignKey=empleadoresponsableLogic.getEmpleados();
			}

			ordenproduReturnGeneral.setempleadoresponsablesForeignKey(empleadoresponsablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			ordenproduReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<EstadoOrdenProdu> estadoordenprodusForeignKey=new ArrayList<EstadoOrdenProdu>();
			EstadoOrdenProduLogic estadoordenproduLogic=new EstadoOrdenProduLogic();
			estadoordenproduLogic.setConnexion(this.connexion);
			estadoordenproduLogic.getEstadoOrdenProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoOrdenProdu.equals("NONE")) {
				estadoordenproduLogic.getTodosEstadoOrdenProdus(finalQueryGlobalEstadoOrdenProdu,new Pagination());
				estadoordenprodusForeignKey=estadoordenproduLogic.getEstadoOrdenProdus();
			}

			ordenproduReturnGeneral.setestadoordenprodusForeignKey(estadoordenprodusForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return ordenproduReturnGeneral;
	}
	
	public OrdenProduParameterReturnGeneral cargarCombosLoteForeignKeyOrdenProdu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrioridadEmpresaProdu,String finalQueryGlobalEmpleadoResponsable,String finalQueryGlobalCliente,String finalQueryGlobalEstadoOrdenProdu) throws Exception {
		OrdenProduParameterReturnGeneral  ordenproduReturnGeneral =new OrdenProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			ordenproduReturnGeneral =new OrdenProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ordenproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ordenproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			ordenproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			ordenproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			ordenproduReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusForeignKey=new ArrayList<TipoPrioridadEmpresaProdu>();
			TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic=new TipoPrioridadEmpresaProduLogic();
			tipoprioridadempresaproduLogic.setConnexion(this.connexion);
			tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrioridadEmpresaProdu.equals("NONE")) {
				tipoprioridadempresaproduLogic.getTodosTipoPrioridadEmpresaProdus(finalQueryGlobalTipoPrioridadEmpresaProdu,new Pagination());
				tipoprioridadempresaprodusForeignKey=tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProdus();
			}

			ordenproduReturnGeneral.settipoprioridadempresaprodusForeignKey(tipoprioridadempresaprodusForeignKey);


			List<Empleado> empleadoresponsablesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoresponsableLogic=new EmpleadoLogic();
			empleadoresponsableLogic.setConnexion(this.connexion);
			empleadoresponsableLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoResponsable.equals("NONE")) {
				empleadoresponsableLogic.getTodosEmpleados(finalQueryGlobalEmpleadoResponsable,new Pagination());
				empleadoresponsablesForeignKey=empleadoresponsableLogic.getEmpleados();
			}

			ordenproduReturnGeneral.setempleadoresponsablesForeignKey(empleadoresponsablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			ordenproduReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<EstadoOrdenProdu> estadoordenprodusForeignKey=new ArrayList<EstadoOrdenProdu>();
			EstadoOrdenProduLogic estadoordenproduLogic=new EstadoOrdenProduLogic();
			estadoordenproduLogic.setConnexion(this.connexion);
			estadoordenproduLogic.getEstadoOrdenProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoOrdenProdu.equals("NONE")) {
				estadoordenproduLogic.getTodosEstadoOrdenProdus(finalQueryGlobalEstadoOrdenProdu,new Pagination());
				estadoordenprodusForeignKey=estadoordenproduLogic.getEstadoOrdenProdus();
			}

			ordenproduReturnGeneral.setestadoordenprodusForeignKey(estadoordenprodusForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return ordenproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyOrdenProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			OrdenDetaProduLogic ordendetaproduLogic=new OrdenDetaProduLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyOrdenProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(OrdenDetaProdu.class));
											
			

			ordendetaproduLogic.setConnexion(this.getConnexion());
			ordendetaproduLogic.setDatosCliente(this.datosCliente);
			ordendetaproduLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(OrdenProdu ordenprodu:this.ordenprodus) {
				

				classes=new ArrayList<Classe>();
				classes=OrdenDetaProduConstantesFunciones.getClassesForeignKeysOfOrdenDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				ordendetaproduLogic.setOrdenDetaProdus(ordenprodu.ordendetaprodus);
				ordendetaproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(OrdenProdu ordenprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			OrdenProduLogicAdditional.updateOrdenProduToGet(ordenprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ordenprodu.setEmpresa(ordenproduDataAccess.getEmpresa(connexion,ordenprodu));
		ordenprodu.setSucursal(ordenproduDataAccess.getSucursal(connexion,ordenprodu));
		ordenprodu.setEjercicio(ordenproduDataAccess.getEjercicio(connexion,ordenprodu));
		ordenprodu.setPeriodo(ordenproduDataAccess.getPeriodo(connexion,ordenprodu));
		ordenprodu.setFormato(ordenproduDataAccess.getFormato(connexion,ordenprodu));
		ordenprodu.setTipoPrioridadEmpresaProdu(ordenproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,ordenprodu));
		ordenprodu.setEmpleadoResponsable(ordenproduDataAccess.getEmpleadoResponsable(connexion,ordenprodu));
		ordenprodu.setCliente(ordenproduDataAccess.getCliente(connexion,ordenprodu));
		ordenprodu.setEstadoOrdenProdu(ordenproduDataAccess.getEstadoOrdenProdu(connexion,ordenprodu));
		ordenprodu.setOrdenDetaProdus(ordenproduDataAccess.getOrdenDetaProdus(connexion,ordenprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ordenprodu.setEmpresa(ordenproduDataAccess.getEmpresa(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ordenprodu.setSucursal(ordenproduDataAccess.getSucursal(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				ordenprodu.setEjercicio(ordenproduDataAccess.getEjercicio(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				ordenprodu.setPeriodo(ordenproduDataAccess.getPeriodo(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				ordenprodu.setFormato(ordenproduDataAccess.getFormato(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				ordenprodu.setTipoPrioridadEmpresaProdu(ordenproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				ordenprodu.setEmpleadoResponsable(ordenproduDataAccess.getEmpleadoResponsable(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ordenprodu.setCliente(ordenproduDataAccess.getCliente(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				ordenprodu.setEstadoOrdenProdu(ordenproduDataAccess.getEstadoOrdenProdu(connexion,ordenprodu));
				continue;
			}

			if(clas.clas.equals(OrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordenprodu.setOrdenDetaProdus(ordenproduDataAccess.getOrdenDetaProdus(connexion,ordenprodu));

				if(this.isConDeep) {
					OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(this.connexion);
					ordendetaproduLogic.setOrdenDetaProdus(ordenprodu.getOrdenDetaProdus());
					ArrayList<Classe> classesLocal=OrdenDetaProduConstantesFunciones.getClassesForeignKeysOfOrdenDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					ordendetaproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(ordendetaproduLogic.getOrdenDetaProdus());
					ordenprodu.setOrdenDetaProdus(ordendetaproduLogic.getOrdenDetaProdus());
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
			ordenprodu.setEmpresa(ordenproduDataAccess.getEmpresa(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setSucursal(ordenproduDataAccess.getSucursal(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setEjercicio(ordenproduDataAccess.getEjercicio(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setPeriodo(ordenproduDataAccess.getPeriodo(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setFormato(ordenproduDataAccess.getFormato(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setTipoPrioridadEmpresaProdu(ordenproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setEmpleadoResponsable(ordenproduDataAccess.getEmpleadoResponsable(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setCliente(ordenproduDataAccess.getCliente(connexion,ordenprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setEstadoOrdenProdu(ordenproduDataAccess.getEstadoOrdenProdu(connexion,ordenprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenDetaProdu.class));
			ordenprodu.setOrdenDetaProdus(ordenproduDataAccess.getOrdenDetaProdus(connexion,ordenprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ordenprodu.setEmpresa(ordenproduDataAccess.getEmpresa(connexion,ordenprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ordenprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		ordenprodu.setSucursal(ordenproduDataAccess.getSucursal(connexion,ordenprodu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ordenprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		ordenprodu.setEjercicio(ordenproduDataAccess.getEjercicio(connexion,ordenprodu));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(ordenprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		ordenprodu.setPeriodo(ordenproduDataAccess.getPeriodo(connexion,ordenprodu));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(ordenprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		ordenprodu.setFormato(ordenproduDataAccess.getFormato(connexion,ordenprodu));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(ordenprodu.getFormato(),isDeep,deepLoadType,clases);
				
		ordenprodu.setTipoPrioridadEmpresaProdu(ordenproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,ordenprodu));
		TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
		tipoprioridadempresaproduLogic.deepLoad(ordenprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);
				
		ordenprodu.setEmpleadoResponsable(ordenproduDataAccess.getEmpleadoResponsable(connexion,ordenprodu));
		EmpleadoLogic empleadoresponsableLogic= new EmpleadoLogic(connexion);
		empleadoresponsableLogic.deepLoad(ordenprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);
				
		ordenprodu.setCliente(ordenproduDataAccess.getCliente(connexion,ordenprodu));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(ordenprodu.getCliente(),isDeep,deepLoadType,clases);
				
		ordenprodu.setEstadoOrdenProdu(ordenproduDataAccess.getEstadoOrdenProdu(connexion,ordenprodu));
		EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
		estadoordenproduLogic.deepLoad(ordenprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);
				

		ordenprodu.setOrdenDetaProdus(ordenproduDataAccess.getOrdenDetaProdus(connexion,ordenprodu));

		for(OrdenDetaProdu ordendetaprodu:ordenprodu.getOrdenDetaProdus()) {
			OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
			ordendetaproduLogic.deepLoad(ordendetaprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ordenprodu.setEmpresa(ordenproduDataAccess.getEmpresa(connexion,ordenprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ordenprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ordenprodu.setSucursal(ordenproduDataAccess.getSucursal(connexion,ordenprodu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ordenprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				ordenprodu.setEjercicio(ordenproduDataAccess.getEjercicio(connexion,ordenprodu));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(ordenprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				ordenprodu.setPeriodo(ordenproduDataAccess.getPeriodo(connexion,ordenprodu));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(ordenprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				ordenprodu.setFormato(ordenproduDataAccess.getFormato(connexion,ordenprodu));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(ordenprodu.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				ordenprodu.setTipoPrioridadEmpresaProdu(ordenproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,ordenprodu));
				TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
				tipoprioridadempresaproduLogic.deepLoad(ordenprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				ordenprodu.setEmpleadoResponsable(ordenproduDataAccess.getEmpleadoResponsable(connexion,ordenprodu));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(ordenprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ordenprodu.setCliente(ordenproduDataAccess.getCliente(connexion,ordenprodu));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(ordenprodu.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				ordenprodu.setEstadoOrdenProdu(ordenproduDataAccess.getEstadoOrdenProdu(connexion,ordenprodu));
				EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
				estadoordenproduLogic.deepLoad(ordenprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordenprodu.setOrdenDetaProdus(ordenproduDataAccess.getOrdenDetaProdus(connexion,ordenprodu));

				for(OrdenDetaProdu ordendetaprodu:ordenprodu.getOrdenDetaProdus()) {
					OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
					ordendetaproduLogic.deepLoad(ordendetaprodu,isDeep,deepLoadType,clases);
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
			ordenprodu.setEmpresa(ordenproduDataAccess.getEmpresa(connexion,ordenprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ordenprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setSucursal(ordenproduDataAccess.getSucursal(connexion,ordenprodu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ordenprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setEjercicio(ordenproduDataAccess.getEjercicio(connexion,ordenprodu));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(ordenprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setPeriodo(ordenproduDataAccess.getPeriodo(connexion,ordenprodu));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(ordenprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setFormato(ordenproduDataAccess.getFormato(connexion,ordenprodu));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(ordenprodu.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setTipoPrioridadEmpresaProdu(ordenproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,ordenprodu));
			TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
			tipoprioridadempresaproduLogic.deepLoad(ordenprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setEmpleadoResponsable(ordenproduDataAccess.getEmpleadoResponsable(connexion,ordenprodu));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(ordenprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setCliente(ordenproduDataAccess.getCliente(connexion,ordenprodu));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(ordenprodu.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordenprodu.setEstadoOrdenProdu(ordenproduDataAccess.getEstadoOrdenProdu(connexion,ordenprodu));
			EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
			estadoordenproduLogic.deepLoad(ordenprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenDetaProdu.class));
			ordenprodu.setOrdenDetaProdus(ordenproduDataAccess.getOrdenDetaProdus(connexion,ordenprodu));

			for(OrdenDetaProdu ordendetaprodu:ordenprodu.getOrdenDetaProdus()) {
				OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
				ordendetaproduLogic.deepLoad(ordendetaprodu,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(OrdenProdu ordenprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			OrdenProduLogicAdditional.updateOrdenProduToSave(ordenprodu,this.arrDatoGeneral);
			
OrdenProduDataAccess.save(ordenprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ordenprodu.getEmpresa(),connexion);

		SucursalDataAccess.save(ordenprodu.getSucursal(),connexion);

		EjercicioDataAccess.save(ordenprodu.getEjercicio(),connexion);

		PeriodoDataAccess.save(ordenprodu.getPeriodo(),connexion);

		FormatoDataAccess.save(ordenprodu.getFormato(),connexion);

		TipoPrioridadEmpresaProduDataAccess.save(ordenprodu.getTipoPrioridadEmpresaProdu(),connexion);

		EmpleadoDataAccess.save(ordenprodu.getEmpleadoResponsable(),connexion);

		ClienteDataAccess.save(ordenprodu.getCliente(),connexion);

		EstadoOrdenProduDataAccess.save(ordenprodu.getEstadoOrdenProdu(),connexion);

		for(OrdenDetaProdu ordendetaprodu:ordenprodu.getOrdenDetaProdus()) {
			ordendetaprodu.setid_orden_produ(ordenprodu.getId());
			OrdenDetaProduDataAccess.save(ordendetaprodu,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ordenprodu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ordenprodu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(ordenprodu.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(ordenprodu.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(ordenprodu.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				TipoPrioridadEmpresaProduDataAccess.save(ordenprodu.getTipoPrioridadEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(ordenprodu.getEmpleadoResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(ordenprodu.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				EstadoOrdenProduDataAccess.save(ordenprodu.getEstadoOrdenProdu(),connexion);
				continue;
			}


			if(clas.clas.equals(OrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenDetaProdu ordendetaprodu:ordenprodu.getOrdenDetaProdus()) {
					ordendetaprodu.setid_orden_produ(ordenprodu.getId());
					OrdenDetaProduDataAccess.save(ordendetaprodu,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ordenprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ordenprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(ordenprodu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ordenprodu.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(ordenprodu.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(ordenprodu.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(ordenprodu.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(ordenprodu.getPeriodo(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(ordenprodu.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(ordenprodu.getFormato(),isDeep,deepLoadType,clases);
				

		TipoPrioridadEmpresaProduDataAccess.save(ordenprodu.getTipoPrioridadEmpresaProdu(),connexion);
		TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
		tipoprioridadempresaproduLogic.deepLoad(ordenprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(ordenprodu.getEmpleadoResponsable(),connexion);
		EmpleadoLogic empleadoresponsableLogic= new EmpleadoLogic(connexion);
		empleadoresponsableLogic.deepLoad(ordenprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(ordenprodu.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(ordenprodu.getCliente(),isDeep,deepLoadType,clases);
				

		EstadoOrdenProduDataAccess.save(ordenprodu.getEstadoOrdenProdu(),connexion);
		EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
		estadoordenproduLogic.deepLoad(ordenprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);
				

		for(OrdenDetaProdu ordendetaprodu:ordenprodu.getOrdenDetaProdus()) {
			OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
			ordendetaprodu.setid_orden_produ(ordenprodu.getId());
			OrdenDetaProduDataAccess.save(ordendetaprodu,connexion);
			ordendetaproduLogic.deepSave(ordendetaprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ordenprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(ordenprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ordenprodu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(ordenprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(ordenprodu.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(ordenprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(ordenprodu.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(ordenprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(ordenprodu.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(ordenprodu.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				TipoPrioridadEmpresaProduDataAccess.save(ordenprodu.getTipoPrioridadEmpresaProdu(),connexion);
				TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
				tipoprioridadempresaproduLogic.deepSave(ordenprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(ordenprodu.getEmpleadoResponsable(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(ordenprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(ordenprodu.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(ordenprodu.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				EstadoOrdenProduDataAccess.save(ordenprodu.getEstadoOrdenProdu(),connexion);
				EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
				estadoordenproduLogic.deepSave(ordenprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(OrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenDetaProdu ordendetaprodu:ordenprodu.getOrdenDetaProdus()) {
					OrdenDetaProduLogic ordendetaproduLogic= new OrdenDetaProduLogic(connexion);
					ordendetaprodu.setid_orden_produ(ordenprodu.getId());
					OrdenDetaProduDataAccess.save(ordendetaprodu,connexion);
					ordendetaproduLogic.deepSave(ordendetaprodu,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(OrdenProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ordenprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(ordenprodu);
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
			this.deepLoad(this.ordenprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(OrdenProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(ordenprodus!=null) {
				for(OrdenProdu ordenprodu:ordenprodus) {
					this.deepLoad(ordenprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(ordenprodus);
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
			if(ordenprodus!=null) {
				for(OrdenProdu ordenprodu:ordenprodus) {
					this.deepLoad(ordenprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(ordenprodus);
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
			this.getNewConnexionToDeep(OrdenProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ordenprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(OrdenProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(ordenprodus!=null) {
				for(OrdenProdu ordenprodu:ordenprodus) {
					this.deepSave(ordenprodu,isDeep,deepLoadType,clases);
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
			if(ordenprodus!=null) {
				for(OrdenProdu ordenprodu:ordenprodus) {
					this.deepSave(ordenprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getOrdenProdusFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,OrdenProduConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,OrdenProduConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,OrdenProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,OrdenProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdEmpleadoResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_responsable,OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoResponsable);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdEmpleadoResponsable(String sFinalQuery,Pagination pagination,Long id_empleado_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_responsable,OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoResponsable);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,OrdenProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,OrdenProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdEstadoOrdenProduWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_orden_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoOrdenProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoOrdenProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_orden_produ,OrdenProduConstantesFunciones.IDESTADOORDENPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoOrdenProdu);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoOrdenProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdEstadoOrdenProdu(String sFinalQuery,Pagination pagination,Long id_estado_orden_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoOrdenProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoOrdenProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_orden_produ,OrdenProduConstantesFunciones.IDESTADOORDENPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoOrdenProdu);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoOrdenProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,OrdenProduConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,OrdenProduConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,OrdenProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,OrdenProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,OrdenProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,OrdenProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenProdusFK_IdTipoPrioridadEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_prioridad_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrioridadEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrioridadEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prioridad_empresa_produ,OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrioridadEmpresaProdu);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrioridadEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenProdusFK_IdTipoPrioridadEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_prioridad_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrioridadEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrioridadEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prioridad_empresa_produ,OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrioridadEmpresaProdu);

			OrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrioridadEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(this.ordenprodus);
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
			if(OrdenProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,OrdenProdu ordenprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(OrdenProduConstantesFunciones.ISCONAUDITORIA) {
				if(ordenprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenProduDataAccess.TABLENAME, ordenprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OrdenProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////OrdenProduLogic.registrarAuditoriaDetallesOrdenProdu(connexion,ordenprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ordenprodu.getIsDeleted()) {
					/*if(!ordenprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,OrdenProduDataAccess.TABLENAME, ordenprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////OrdenProduLogic.registrarAuditoriaDetallesOrdenProdu(connexion,ordenprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenProduDataAccess.TABLENAME, ordenprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ordenprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenProduDataAccess.TABLENAME, ordenprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OrdenProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////OrdenProduLogic.registrarAuditoriaDetallesOrdenProdu(connexion,ordenprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesOrdenProdu(Connexion connexion,OrdenProdu ordenprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_empresa().equals(ordenprodu.getOrdenProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_empresa()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_empresa().toString();
				}
				if(ordenprodu.getid_empresa()!=null)
				{
					strValorNuevo=ordenprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_sucursal().equals(ordenprodu.getOrdenProduOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_sucursal()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_sucursal().toString();
				}
				if(ordenprodu.getid_sucursal()!=null)
				{
					strValorNuevo=ordenprodu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_ejercicio().equals(ordenprodu.getOrdenProduOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_ejercicio()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_ejercicio().toString();
				}
				if(ordenprodu.getid_ejercicio()!=null)
				{
					strValorNuevo=ordenprodu.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_periodo().equals(ordenprodu.getOrdenProduOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_periodo()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_periodo().toString();
				}
				if(ordenprodu.getid_periodo()!=null)
				{
					strValorNuevo=ordenprodu.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_formato().equals(ordenprodu.getOrdenProduOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_formato()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_formato().toString();
				}
				if(ordenprodu.getid_formato()!=null)
				{
					strValorNuevo=ordenprodu.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_tipo_prioridad_empresa_produ().equals(ordenprodu.getOrdenProduOriginal().getid_tipo_prioridad_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_tipo_prioridad_empresa_produ()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_tipo_prioridad_empresa_produ().toString();
				}
				if(ordenprodu.getid_tipo_prioridad_empresa_produ()!=null)
				{
					strValorNuevo=ordenprodu.getid_tipo_prioridad_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_empleado_responsable().equals(ordenprodu.getOrdenProduOriginal().getid_empleado_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_empleado_responsable()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_empleado_responsable().toString();
				}
				if(ordenprodu.getid_empleado_responsable()!=null)
				{
					strValorNuevo=ordenprodu.getid_empleado_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getsecuencial().equals(ordenprodu.getOrdenProduOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getsecuencial()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getsecuencial();
				}
				if(ordenprodu.getsecuencial()!=null)
				{
					strValorNuevo=ordenprodu.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_cliente().equals(ordenprodu.getOrdenProduOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_cliente()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_cliente().toString();
				}
				if(ordenprodu.getid_cliente()!=null)
				{
					strValorNuevo=ordenprodu.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getdireccion_cliente().equals(ordenprodu.getOrdenProduOriginal().getdireccion_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getdireccion_cliente()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getdireccion_cliente();
				}
				if(ordenprodu.getdireccion_cliente()!=null)
				{
					strValorNuevo=ordenprodu.getdireccion_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.DIRECCIONCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.gettelefono_cliente().equals(ordenprodu.getOrdenProduOriginal().gettelefono_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().gettelefono_cliente()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().gettelefono_cliente();
				}
				if(ordenprodu.gettelefono_cliente()!=null)
				{
					strValorNuevo=ordenprodu.gettelefono_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.TELEFONOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getruc_cliente().equals(ordenprodu.getOrdenProduOriginal().getruc_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getruc_cliente()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getruc_cliente();
				}
				if(ordenprodu.getruc_cliente()!=null)
				{
					strValorNuevo=ordenprodu.getruc_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.RUCCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getlote().equals(ordenprodu.getOrdenProduOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getlote()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getlote();
				}
				if(ordenprodu.getlote()!=null)
				{
					strValorNuevo=ordenprodu.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getfecha_pedido().equals(ordenprodu.getOrdenProduOriginal().getfecha_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getfecha_pedido()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getfecha_pedido().toString();
				}
				if(ordenprodu.getfecha_pedido()!=null)
				{
					strValorNuevo=ordenprodu.getfecha_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.FECHAPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getfecha_entrega().equals(ordenprodu.getOrdenProduOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getfecha_entrega()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getfecha_entrega().toString();
				}
				if(ordenprodu.getfecha_entrega()!=null)
				{
					strValorNuevo=ordenprodu.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getes_uso_interno().equals(ordenprodu.getOrdenProduOriginal().getes_uso_interno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getes_uso_interno()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getes_uso_interno().toString();
				}
				if(ordenprodu.getes_uso_interno()!=null)
				{
					strValorNuevo=ordenprodu.getes_uso_interno().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.ESUSOINTERNO,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getfecha().equals(ordenprodu.getOrdenProduOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getfecha()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getfecha().toString();
				}
				if(ordenprodu.getfecha()!=null)
				{
					strValorNuevo=ordenprodu.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getdescripcion().equals(ordenprodu.getOrdenProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getdescripcion()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getdescripcion();
				}
				if(ordenprodu.getdescripcion()!=null)
				{
					strValorNuevo=ordenprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(ordenprodu.getIsNew()||!ordenprodu.getid_estado_orden_produ().equals(ordenprodu.getOrdenProduOriginal().getid_estado_orden_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordenprodu.getOrdenProduOriginal().getid_estado_orden_produ()!=null)
				{
					strValorActual=ordenprodu.getOrdenProduOriginal().getid_estado_orden_produ().toString();
				}
				if(ordenprodu.getid_estado_orden_produ()!=null)
				{
					strValorNuevo=ordenprodu.getid_estado_orden_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenProduConstantesFunciones.IDESTADOORDENPRODU,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveOrdenProduRelacionesWithConnection(OrdenProdu ordenprodu,List<OrdenDetaProdu> ordendetaprodus) throws Exception {

		if(!ordenprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOrdenProduRelacionesBase(ordenprodu,ordendetaprodus,true);
		}
	}

	public void saveOrdenProduRelaciones(OrdenProdu ordenprodu,List<OrdenDetaProdu> ordendetaprodus)throws Exception {

		if(!ordenprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOrdenProduRelacionesBase(ordenprodu,ordendetaprodus,false);
		}
	}

	public void saveOrdenProduRelacionesBase(OrdenProdu ordenprodu,List<OrdenDetaProdu> ordendetaprodus,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("OrdenProdu-saveRelacionesWithConnection");}
	
			ordenprodu.setOrdenDetaProdus(ordendetaprodus);

			this.setOrdenProdu(ordenprodu);

			if(OrdenProduLogicAdditional.validarSaveRelaciones(ordenprodu,this)) {

				OrdenProduLogicAdditional.updateRelacionesToSave(ordenprodu,this);

				if((ordenprodu.getIsNew()||ordenprodu.getIsChanged())&&!ordenprodu.getIsDeleted()) {
					this.saveOrdenProdu();
					this.saveOrdenProduRelacionesDetalles(ordendetaprodus);

				} else if(ordenprodu.getIsDeleted()) {
					this.saveOrdenProduRelacionesDetalles(ordendetaprodus);
					this.saveOrdenProdu();
				}

				OrdenProduLogicAdditional.updateRelacionesToSaveAfter(ordenprodu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			OrdenDetaProduConstantesFunciones.InicializarGeneralEntityAuxiliaresOrdenDetaProdus(ordendetaprodus,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveOrdenProduRelacionesDetalles(List<OrdenDetaProdu> ordendetaprodus)throws Exception {
		try {
	

			Long idOrdenProduActual=this.getOrdenProdu().getId();

			OrdenDetaProduLogic ordendetaproduLogic_Desde_OrdenProdu=new OrdenDetaProduLogic();
			ordendetaproduLogic_Desde_OrdenProdu.setOrdenDetaProdus(ordendetaprodus);

			ordendetaproduLogic_Desde_OrdenProdu.setConnexion(this.getConnexion());
			ordendetaproduLogic_Desde_OrdenProdu.setDatosCliente(this.datosCliente);

			for(OrdenDetaProdu ordendetaprodu_Desde_OrdenProdu:ordendetaproduLogic_Desde_OrdenProdu.getOrdenDetaProdus()) {
				ordendetaprodu_Desde_OrdenProdu.setid_orden_produ(idOrdenProduActual);

				ordendetaproduLogic_Desde_OrdenProdu.setOrdenDetaProdu(ordendetaprodu_Desde_OrdenProdu);
				ordendetaproduLogic_Desde_OrdenProdu.saveOrdenDetaProdu();

				Long idOrdenDetaProduActual=ordendetaprodu_Desde_OrdenProdu.getId();

				ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduGastoLogic();

				if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduGastos()==null){
					ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduGastos(new ArrayList<ProductoOrdenDetaProduGasto>());
				}

				productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduGastos(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduGastos());

				productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
				productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto_Desde_OrdenDetaProdu:productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduGastos()) {
					productoordendetaprodugasto_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
				}

				productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduGastos();

				ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduManoLogic();

				if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduManos()==null){
					ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduManos(new ArrayList<ProductoOrdenDetaProduMano>());
				}

				productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduManos(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduManos());

				productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
				productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

				for(ProductoOrdenDetaProduMano productoordendetaprodumano_Desde_OrdenDetaProdu:productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduManos()) {
					productoordendetaprodumano_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
				}

				productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduManos();

				ProductoOrdenDetaProduLogic productoordendetaproduLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduLogic();

				if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProdus()==null){
					ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProdus(new ArrayList<ProductoOrdenDetaProdu>());
				}

				productoordendetaproduLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProdus(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProdus());

				productoordendetaproduLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
				productoordendetaproduLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

				for(ProductoOrdenDetaProdu productoordendetaprodu_Desde_OrdenDetaProdu:productoordendetaproduLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProdus()) {
					productoordendetaprodu_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
				}

				productoordendetaproduLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProdus();

				ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduMaquinaLogic();

				if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMaquinas()==null){
					ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduMaquinas(new ArrayList<ProductoOrdenDetaProduMaquina>());
				}

				productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduMaquinas(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMaquinas());

				productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
				productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina_Desde_OrdenDetaProdu:productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduMaquinas()) {
					productoordendetaprodumaquina_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
				}

				productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduMaquinas();

				ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduMermaLogic();

				if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMermas()==null){
					ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduMermas(new ArrayList<ProductoOrdenDetaProduMerma>());
				}

				productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduMermas(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMermas());

				productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
				productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma_Desde_OrdenDetaProdu:productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduMermas()) {
					productoordendetaprodumerma_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
				}

				productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduMermas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OrdenProduConstantesFunciones.getClassesForeignKeysOfOrdenProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OrdenProduConstantesFunciones.getClassesRelationshipsOfOrdenProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
