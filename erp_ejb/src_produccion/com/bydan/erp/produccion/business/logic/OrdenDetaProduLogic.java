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
import com.bydan.erp.produccion.util.OrdenDetaProduConstantesFunciones;
import com.bydan.erp.produccion.util.OrdenDetaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.OrdenDetaProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.OrdenDetaProdu;
import com.bydan.erp.produccion.business.logic.OrdenDetaProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class OrdenDetaProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(OrdenDetaProduLogic.class);
	
	protected OrdenDetaProduDataAccess ordendetaproduDataAccess; 	
	protected OrdenDetaProdu ordendetaprodu;
	protected List<OrdenDetaProdu> ordendetaprodus;
	protected Object ordendetaproduObject;	
	protected List<Object> ordendetaprodusObject;
	
	public static ClassValidator<OrdenDetaProdu> ordendetaproduValidator = new ClassValidator<OrdenDetaProdu>(OrdenDetaProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected OrdenDetaProduLogicAdditional ordendetaproduLogicAdditional=null;
	
	public OrdenDetaProduLogicAdditional getOrdenDetaProduLogicAdditional() {
		return this.ordendetaproduLogicAdditional;
	}
	
	public void setOrdenDetaProduLogicAdditional(OrdenDetaProduLogicAdditional ordendetaproduLogicAdditional) {
		try {
			this.ordendetaproduLogicAdditional=ordendetaproduLogicAdditional;
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
	
	
	
	
	public  OrdenDetaProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.ordendetaproduDataAccess = new OrdenDetaProduDataAccess();
			
			this.ordendetaprodus= new ArrayList<OrdenDetaProdu>();
			this.ordendetaprodu= new OrdenDetaProdu();
			
			this.ordendetaproduObject=new Object();
			this.ordendetaprodusObject=new ArrayList<Object>();
				
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
			
			this.ordendetaproduDataAccess.setConnexionType(this.connexionType);
			this.ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  OrdenDetaProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.ordendetaproduDataAccess = new OrdenDetaProduDataAccess();
			this.ordendetaprodus= new ArrayList<OrdenDetaProdu>();
			this.ordendetaprodu= new OrdenDetaProdu();
			this.ordendetaproduObject=new Object();
			this.ordendetaprodusObject=new ArrayList<Object>();
			
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
			
			this.ordendetaproduDataAccess.setConnexionType(this.connexionType);
			this.ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public OrdenDetaProdu getOrdenDetaProdu() throws Exception {	
		OrdenDetaProduLogicAdditional.checkOrdenDetaProduToGet(ordendetaprodu,this.datosCliente,this.arrDatoGeneral);
		OrdenDetaProduLogicAdditional.updateOrdenDetaProduToGet(ordendetaprodu,this.arrDatoGeneral);
		
		return ordendetaprodu;
	}
		
	public void setOrdenDetaProdu(OrdenDetaProdu newOrdenDetaProdu) {
		this.ordendetaprodu = newOrdenDetaProdu;
	}
	
	public OrdenDetaProduDataAccess getOrdenDetaProduDataAccess() {
		return ordendetaproduDataAccess;
	}
	
	public void setOrdenDetaProduDataAccess(OrdenDetaProduDataAccess newordendetaproduDataAccess) {
		this.ordendetaproduDataAccess = newordendetaproduDataAccess;
	}
	
	public List<OrdenDetaProdu> getOrdenDetaProdus() throws Exception {		
		this.quitarOrdenDetaProdusNulos();
		
		OrdenDetaProduLogicAdditional.checkOrdenDetaProduToGets(ordendetaprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (OrdenDetaProdu ordendetaproduLocal: ordendetaprodus ) {
			OrdenDetaProduLogicAdditional.updateOrdenDetaProduToGet(ordendetaproduLocal,this.arrDatoGeneral);
		}
		
		return ordendetaprodus;
	}
	
	public void setOrdenDetaProdus(List<OrdenDetaProdu> newOrdenDetaProdus) {
		this.ordendetaprodus = newOrdenDetaProdus;
	}
	
	public Object getOrdenDetaProduObject() {	
		this.ordendetaproduObject=this.ordendetaproduDataAccess.getEntityObject();
		return this.ordendetaproduObject;
	}
		
	public void setOrdenDetaProduObject(Object newOrdenDetaProduObject) {
		this.ordendetaproduObject = newOrdenDetaProduObject;
	}
	
	public List<Object> getOrdenDetaProdusObject() {		
		this.ordendetaprodusObject=this.ordendetaproduDataAccess.getEntitiesObject();
		return this.ordendetaprodusObject;
	}
		
	public void setOrdenDetaProdusObject(List<Object> newOrdenDetaProdusObject) {
		this.ordendetaprodusObject = newOrdenDetaProdusObject;
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
		
		if(this.ordendetaproduDataAccess!=null) {
			this.ordendetaproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			ordendetaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			ordendetaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ordendetaprodu = new  OrdenDetaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodu);
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
		ordendetaprodu = new  OrdenDetaProdu();
		  		  
        try {
			
			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ordendetaprodu = new  OrdenDetaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodu);
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
		ordendetaprodu = new  OrdenDetaProdu();
		  		  
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
		ordendetaprodu = new  OrdenDetaProdu();
		  		  
        try {
			
			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ordendetaprodu = new  OrdenDetaProdu();
		  		  
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
		ordendetaprodu = new  OrdenDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =ordendetaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordendetaprodu = new  OrdenDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=ordendetaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ordendetaprodu = new  OrdenDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =ordendetaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordendetaprodu = new  OrdenDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=ordendetaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ordendetaprodu = new  OrdenDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =ordendetaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ordendetaprodu = new  OrdenDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=ordendetaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
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
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
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
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
        try {			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
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
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
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
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
        try {
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
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
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
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
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ordendetaprodu = new  OrdenDetaProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodu);
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
		ordendetaprodu = new  OrdenDetaProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
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
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		  		  
        try {
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosOrdenDetaProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getTodosOrdenDetaProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
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
	
	public  void  getTodosOrdenDetaProdus(String sFinalQuery,Pagination pagination)throws Exception {
		ordendetaprodus = new  ArrayList<OrdenDetaProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOrdenDetaProdu(ordendetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarOrdenDetaProdu(OrdenDetaProdu ordendetaprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(ordendetaprodu.getIsNew() || ordendetaprodu.getIsChanged()) { 
			this.invalidValues = ordendetaproduValidator.getInvalidValues(ordendetaprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ordendetaprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarOrdenDetaProdu(List<OrdenDetaProdu> OrdenDetaProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(OrdenDetaProdu ordendetaproduLocal:ordendetaprodus) {				
			estaValidadoObjeto=this.validarGuardarOrdenDetaProdu(ordendetaproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarOrdenDetaProdu(List<OrdenDetaProdu> OrdenDetaProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOrdenDetaProdu(ordendetaprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarOrdenDetaProdu(OrdenDetaProdu OrdenDetaProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOrdenDetaProdu(ordendetaprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(OrdenDetaProdu ordendetaprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ordendetaprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=OrdenDetaProduConstantesFunciones.getOrdenDetaProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ordendetaprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(OrdenDetaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(OrdenDetaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveOrdenDetaProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-saveOrdenDetaProduWithConnection");connexion.begin();			
			
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSave(this.ordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OrdenDetaProduLogicAdditional.updateOrdenDetaProduToSave(this.ordendetaprodu,this.arrDatoGeneral);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ordendetaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowOrdenDetaProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOrdenDetaProdu(this.ordendetaprodu)) {
				OrdenDetaProduDataAccess.save(this.ordendetaprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSaveAfter(this.ordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOrdenDetaProdu();
			
			connexion.commit();			
			
			if(this.ordendetaprodu.getIsDeleted()) {
				this.ordendetaprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveOrdenDetaProdu()throws Exception {	
		try {	
			
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSave(this.ordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OrdenDetaProduLogicAdditional.updateOrdenDetaProduToSave(this.ordendetaprodu,this.arrDatoGeneral);
			
			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ordendetaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOrdenDetaProdu(this.ordendetaprodu)) {			
				OrdenDetaProduDataAccess.save(this.ordendetaprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ordendetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSaveAfter(this.ordendetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ordendetaprodu.getIsDeleted()) {
				this.ordendetaprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveOrdenDetaProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-saveOrdenDetaProdusWithConnection");connexion.begin();			
			
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSaves(ordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowOrdenDetaProdus();
			
			Boolean validadoTodosOrdenDetaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(OrdenDetaProdu ordendetaproduLocal:ordendetaprodus) {		
				if(ordendetaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OrdenDetaProduLogicAdditional.updateOrdenDetaProduToSave(ordendetaproduLocal,this.arrDatoGeneral);
	        	
				OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ordendetaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOrdenDetaProdu(ordendetaproduLocal)) {
					OrdenDetaProduDataAccess.save(ordendetaproduLocal, connexion);				
				} else {
					validadoTodosOrdenDetaProdu=false;
				}
			}
			
			if(!validadoTodosOrdenDetaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSavesAfter(ordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOrdenDetaProdus();
			
			connexion.commit();		
			
			this.quitarOrdenDetaProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveOrdenDetaProdus()throws Exception {				
		 try {	
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSaves(ordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosOrdenDetaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(OrdenDetaProdu ordendetaproduLocal:ordendetaprodus) {				
				if(ordendetaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OrdenDetaProduLogicAdditional.updateOrdenDetaProduToSave(ordendetaproduLocal,this.arrDatoGeneral);
	        	
				OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ordendetaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOrdenDetaProdu(ordendetaproduLocal)) {				
					OrdenDetaProduDataAccess.save(ordendetaproduLocal, connexion);				
				} else {
					validadoTodosOrdenDetaProdu=false;
				}
			}
			
			if(!validadoTodosOrdenDetaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OrdenDetaProduLogicAdditional.checkOrdenDetaProduToSavesAfter(ordendetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarOrdenDetaProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OrdenDetaProduParameterReturnGeneral procesarAccionOrdenDetaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<OrdenDetaProdu> ordendetaprodus,OrdenDetaProduParameterReturnGeneral ordendetaproduParameterGeneral)throws Exception {
		 try {	
			OrdenDetaProduParameterReturnGeneral ordendetaproduReturnGeneral=new OrdenDetaProduParameterReturnGeneral();
	
			OrdenDetaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ordendetaprodus,ordendetaproduParameterGeneral,ordendetaproduReturnGeneral);
			
			return ordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OrdenDetaProduParameterReturnGeneral procesarAccionOrdenDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<OrdenDetaProdu> ordendetaprodus,OrdenDetaProduParameterReturnGeneral ordendetaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-procesarAccionOrdenDetaProdusWithConnection");connexion.begin();			
			
			OrdenDetaProduParameterReturnGeneral ordendetaproduReturnGeneral=new OrdenDetaProduParameterReturnGeneral();
	
			OrdenDetaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ordendetaprodus,ordendetaproduParameterGeneral,ordendetaproduReturnGeneral);
			
			this.connexion.commit();
			
			return ordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OrdenDetaProduParameterReturnGeneral procesarEventosOrdenDetaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<OrdenDetaProdu> ordendetaprodus,OrdenDetaProdu ordendetaprodu,OrdenDetaProduParameterReturnGeneral ordendetaproduParameterGeneral,Boolean isEsNuevoOrdenDetaProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			OrdenDetaProduParameterReturnGeneral ordendetaproduReturnGeneral=new OrdenDetaProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ordendetaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OrdenDetaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ordendetaprodus,ordendetaprodu,ordendetaproduParameterGeneral,ordendetaproduReturnGeneral,isEsNuevoOrdenDetaProdu,clases);
			
			return ordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public OrdenDetaProduParameterReturnGeneral procesarEventosOrdenDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<OrdenDetaProdu> ordendetaprodus,OrdenDetaProdu ordendetaprodu,OrdenDetaProduParameterReturnGeneral ordendetaproduParameterGeneral,Boolean isEsNuevoOrdenDetaProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-procesarEventosOrdenDetaProdusWithConnection");connexion.begin();			
			
			OrdenDetaProduParameterReturnGeneral ordendetaproduReturnGeneral=new OrdenDetaProduParameterReturnGeneral();
	
			ordendetaproduReturnGeneral.setOrdenDetaProdu(ordendetaprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ordendetaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OrdenDetaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ordendetaprodus,ordendetaprodu,ordendetaproduParameterGeneral,ordendetaproduReturnGeneral,isEsNuevoOrdenDetaProdu,clases);
			
			this.connexion.commit();
			
			return ordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OrdenDetaProduParameterReturnGeneral procesarImportacionOrdenDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,OrdenDetaProduParameterReturnGeneral ordendetaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-procesarImportacionOrdenDetaProdusWithConnection");connexion.begin();			
			
			OrdenDetaProduParameterReturnGeneral ordendetaproduReturnGeneral=new OrdenDetaProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.ordendetaprodus=new ArrayList<OrdenDetaProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ordendetaprodu=new OrdenDetaProdu();
				
				
				if(conColumnasBase) {this.ordendetaprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ordendetaprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.ordendetaprodu.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.ordendetaprodu.setcantidad_pendiente(Integer.parseInt(arrColumnas[iColumn++]));
			this.ordendetaprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.ordendetaprodus.add(this.ordendetaprodu);
			}
			
			this.saveOrdenDetaProdus();
			
			this.connexion.commit();
			
			ordendetaproduReturnGeneral.setConRetornoEstaProcesado(true);
			ordendetaproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return ordendetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarOrdenDetaProdusEliminados() throws Exception {				
		
		List<OrdenDetaProdu> ordendetaprodusAux= new ArrayList<OrdenDetaProdu>();
		
		for(OrdenDetaProdu ordendetaprodu:ordendetaprodus) {
			if(!ordendetaprodu.getIsDeleted()) {
				ordendetaprodusAux.add(ordendetaprodu);
			}
		}
		
		ordendetaprodus=ordendetaprodusAux;
	}
	
	public void quitarOrdenDetaProdusNulos() throws Exception {				
		
		List<OrdenDetaProdu> ordendetaprodusAux= new ArrayList<OrdenDetaProdu>();
		
		for(OrdenDetaProdu ordendetaprodu : this.ordendetaprodus) {
			if(ordendetaprodu==null) {
				ordendetaprodusAux.add(ordendetaprodu);
			}
		}
		
		//this.ordendetaprodus=ordendetaprodusAux;
		
		this.ordendetaprodus.removeAll(ordendetaprodusAux);
	}
	
	public void getSetVersionRowOrdenDetaProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ordendetaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ordendetaprodu.getIsDeleted() || (ordendetaprodu.getIsChanged()&&!ordendetaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=ordendetaproduDataAccess.getSetVersionRowOrdenDetaProdu(connexion,ordendetaprodu.getId());
				
				if(!ordendetaprodu.getVersionRow().equals(timestamp)) {	
					ordendetaprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ordendetaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowOrdenDetaProdu()throws Exception {	
		
		if(ordendetaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ordendetaprodu.getIsDeleted() || (ordendetaprodu.getIsChanged()&&!ordendetaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=ordendetaproduDataAccess.getSetVersionRowOrdenDetaProdu(connexion,ordendetaprodu.getId());
			
			try {							
				if(!ordendetaprodu.getVersionRow().equals(timestamp)) {	
					ordendetaprodu.setVersionRow(timestamp);
				}
				
				ordendetaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowOrdenDetaProdusWithConnection()throws Exception {	
		if(ordendetaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(OrdenDetaProdu ordendetaproduAux:ordendetaprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(ordendetaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ordendetaproduAux.getIsDeleted() || (ordendetaproduAux.getIsChanged()&&!ordendetaproduAux.getIsNew())) {
						
						timestamp=ordendetaproduDataAccess.getSetVersionRowOrdenDetaProdu(connexion,ordendetaproduAux.getId());
						
						if(!ordendetaprodu.getVersionRow().equals(timestamp)) {	
							ordendetaproduAux.setVersionRow(timestamp);
						}
								
						ordendetaproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowOrdenDetaProdus()throws Exception {	
		if(ordendetaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(OrdenDetaProdu ordendetaproduAux:ordendetaprodus) {
					if(ordendetaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ordendetaproduAux.getIsDeleted() || (ordendetaproduAux.getIsChanged()&&!ordendetaproduAux.getIsNew())) {
						
						timestamp=ordendetaproduDataAccess.getSetVersionRowOrdenDetaProdu(connexion,ordendetaproduAux.getId());
						
						if(!ordendetaproduAux.getVersionRow().equals(timestamp)) {	
							ordendetaproduAux.setVersionRow(timestamp);
						}
						
													
						ordendetaproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public OrdenDetaProduParameterReturnGeneral cargarCombosLoteForeignKeyOrdenDetaProduWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalOrdenProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalBodegaDestino,String finalQueryGlobalTipoProcesoProdu) throws Exception {
		OrdenDetaProduParameterReturnGeneral  ordendetaproduReturnGeneral =new OrdenDetaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyOrdenDetaProduWithConnection");connexion.begin();
			
			ordendetaproduReturnGeneral =new OrdenDetaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ordendetaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ordendetaproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			ordendetaproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			ordendetaproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<OrdenProdu> ordenprodusForeignKey=new ArrayList<OrdenProdu>();
			OrdenProduLogic ordenproduLogic=new OrdenProduLogic();
			ordenproduLogic.setConnexion(this.connexion);
			ordenproduLogic.getOrdenProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenProdu.equals("NONE")) {
				ordenproduLogic.getTodosOrdenProdus(finalQueryGlobalOrdenProdu,new Pagination());
				ordenprodusForeignKey=ordenproduLogic.getOrdenProdus();
			}

			ordendetaproduReturnGeneral.setordenprodusForeignKey(ordenprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ordendetaproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			ordendetaproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			ordendetaproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Bodega> bodegadestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegadestinoLogic=new BodegaLogic();
			bodegadestinoLogic.setConnexion(this.connexion);
			bodegadestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaDestino.equals("NONE")) {
				bodegadestinoLogic.getTodosBodegas(finalQueryGlobalBodegaDestino,new Pagination());
				bodegadestinosForeignKey=bodegadestinoLogic.getBodegas();
			}

			ordendetaproduReturnGeneral.setbodegadestinosForeignKey(bodegadestinosForeignKey);


			List<TipoProcesoProdu> tipoprocesoprodusForeignKey=new ArrayList<TipoProcesoProdu>();
			TipoProcesoProduLogic tipoprocesoproduLogic=new TipoProcesoProduLogic();
			tipoprocesoproduLogic.setConnexion(this.connexion);
			tipoprocesoproduLogic.getTipoProcesoProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoProdu.equals("NONE")) {
				tipoprocesoproduLogic.getTodosTipoProcesoProdus(finalQueryGlobalTipoProcesoProdu,new Pagination());
				tipoprocesoprodusForeignKey=tipoprocesoproduLogic.getTipoProcesoProdus();
			}

			ordendetaproduReturnGeneral.settipoprocesoprodusForeignKey(tipoprocesoprodusForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return ordendetaproduReturnGeneral;
	}
	
	public OrdenDetaProduParameterReturnGeneral cargarCombosLoteForeignKeyOrdenDetaProdu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalOrdenProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalBodegaDestino,String finalQueryGlobalTipoProcesoProdu) throws Exception {
		OrdenDetaProduParameterReturnGeneral  ordendetaproduReturnGeneral =new OrdenDetaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			ordendetaproduReturnGeneral =new OrdenDetaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ordendetaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ordendetaproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			ordendetaproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			ordendetaproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<OrdenProdu> ordenprodusForeignKey=new ArrayList<OrdenProdu>();
			OrdenProduLogic ordenproduLogic=new OrdenProduLogic();
			ordenproduLogic.setConnexion(this.connexion);
			ordenproduLogic.getOrdenProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenProdu.equals("NONE")) {
				ordenproduLogic.getTodosOrdenProdus(finalQueryGlobalOrdenProdu,new Pagination());
				ordenprodusForeignKey=ordenproduLogic.getOrdenProdus();
			}

			ordendetaproduReturnGeneral.setordenprodusForeignKey(ordenprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ordendetaproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			ordendetaproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			ordendetaproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Bodega> bodegadestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegadestinoLogic=new BodegaLogic();
			bodegadestinoLogic.setConnexion(this.connexion);
			bodegadestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaDestino.equals("NONE")) {
				bodegadestinoLogic.getTodosBodegas(finalQueryGlobalBodegaDestino,new Pagination());
				bodegadestinosForeignKey=bodegadestinoLogic.getBodegas();
			}

			ordendetaproduReturnGeneral.setbodegadestinosForeignKey(bodegadestinosForeignKey);


			List<TipoProcesoProdu> tipoprocesoprodusForeignKey=new ArrayList<TipoProcesoProdu>();
			TipoProcesoProduLogic tipoprocesoproduLogic=new TipoProcesoProduLogic();
			tipoprocesoproduLogic.setConnexion(this.connexion);
			tipoprocesoproduLogic.getTipoProcesoProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoProdu.equals("NONE")) {
				tipoprocesoproduLogic.getTodosTipoProcesoProdus(finalQueryGlobalTipoProcesoProdu,new Pagination());
				tipoprocesoprodusForeignKey=tipoprocesoproduLogic.getTipoProcesoProdus();
			}

			ordendetaproduReturnGeneral.settipoprocesoprodusForeignKey(tipoprocesoprodusForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return ordendetaproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyOrdenDetaProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic=new ProductoOrdenDetaProduGastoLogic();
			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic=new ProductoOrdenDetaProduManoLogic();
			ProductoOrdenDetaProduLogic productoordendetaproduLogic=new ProductoOrdenDetaProduLogic();
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic=new ProductoOrdenDetaProduMaquinaLogic();
			ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic=new ProductoOrdenDetaProduMermaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyOrdenDetaProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProductoOrdenDetaProduGasto.class));
			classes.add(new Classe(ProductoOrdenDetaProduMano.class));
			classes.add(new Classe(ProductoOrdenDetaProdu.class));
			classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			classes.add(new Classe(ProductoOrdenDetaProduMerma.class));
											
			

			productoordendetaprodugastoLogic.setConnexion(this.getConnexion());
			productoordendetaprodugastoLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodugastoLogic.setIsConRefrescarForeignKeys(true);

			productoordendetaprodumanoLogic.setConnexion(this.getConnexion());
			productoordendetaprodumanoLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodumanoLogic.setIsConRefrescarForeignKeys(true);

			productoordendetaproduLogic.setConnexion(this.getConnexion());
			productoordendetaproduLogic.setDatosCliente(this.datosCliente);
			productoordendetaproduLogic.setIsConRefrescarForeignKeys(true);

			productoordendetaprodumaquinaLogic.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodumaquinaLogic.setIsConRefrescarForeignKeys(true);

			productoordendetaprodumermaLogic.setConnexion(this.getConnexion());
			productoordendetaprodumermaLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodumermaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(OrdenDetaProdu ordendetaprodu:this.ordendetaprodus) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduGastoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduGasto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodugastoLogic.setProductoOrdenDetaProduGastos(ordendetaprodu.productoordendetaprodugastos);
				productoordendetaprodugastoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduManoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodumanoLogic.setProductoOrdenDetaProduManos(ordendetaprodu.productoordendetaprodumanos);
				productoordendetaprodumanoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaproduLogic.setProductoOrdenDetaProdus(ordendetaprodu.productoordendetaprodus);
				productoordendetaproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(ordendetaprodu.productoordendetaprodumaquinas);
				productoordendetaprodumaquinaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduMermaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMerma(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodumermaLogic.setProductoOrdenDetaProduMermas(ordendetaprodu.productoordendetaprodumermas);
				productoordendetaprodumermaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(OrdenDetaProdu ordendetaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			OrdenDetaProduLogicAdditional.updateOrdenDetaProduToGet(ordendetaprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ordendetaprodu.setEmpresa(ordendetaproduDataAccess.getEmpresa(connexion,ordendetaprodu));
		ordendetaprodu.setSucursal(ordendetaproduDataAccess.getSucursal(connexion,ordendetaprodu));
		ordendetaprodu.setEjercicio(ordendetaproduDataAccess.getEjercicio(connexion,ordendetaprodu));
		ordendetaprodu.setPeriodo(ordendetaproduDataAccess.getPeriodo(connexion,ordendetaprodu));
		ordendetaprodu.setOrdenProdu(ordendetaproduDataAccess.getOrdenProdu(connexion,ordendetaprodu));
		ordendetaprodu.setBodega(ordendetaproduDataAccess.getBodega(connexion,ordendetaprodu));
		ordendetaprodu.setProducto(ordendetaproduDataAccess.getProducto(connexion,ordendetaprodu));
		ordendetaprodu.setUnidad(ordendetaproduDataAccess.getUnidad(connexion,ordendetaprodu));
		ordendetaprodu.setBodegaDestino(ordendetaproduDataAccess.getBodegaDestino(connexion,ordendetaprodu));
		ordendetaprodu.setTipoProcesoProdu(ordendetaproduDataAccess.getTipoProcesoProdu(connexion,ordendetaprodu));
		ordendetaprodu.setProductoOrdenDetaProduGastos(ordendetaproduDataAccess.getProductoOrdenDetaProduGastos(connexion,ordendetaprodu));
		ordendetaprodu.setProductoOrdenDetaProduManos(ordendetaproduDataAccess.getProductoOrdenDetaProduManos(connexion,ordendetaprodu));
		ordendetaprodu.setProductoOrdenDetaProdus(ordendetaproduDataAccess.getProductoOrdenDetaProdus(connexion,ordendetaprodu));
		ordendetaprodu.setProductoOrdenDetaProduMaquinas(ordendetaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,ordendetaprodu));
		ordendetaprodu.setProductoOrdenDetaProduMermas(ordendetaproduDataAccess.getProductoOrdenDetaProduMermas(connexion,ordendetaprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ordendetaprodu.setEmpresa(ordendetaproduDataAccess.getEmpresa(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ordendetaprodu.setSucursal(ordendetaproduDataAccess.getSucursal(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				ordendetaprodu.setEjercicio(ordendetaproduDataAccess.getEjercicio(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				ordendetaprodu.setPeriodo(ordendetaproduDataAccess.getPeriodo(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(OrdenProdu.class)) {
				ordendetaprodu.setOrdenProdu(ordendetaproduDataAccess.getOrdenProdu(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ordendetaprodu.setBodega(ordendetaproduDataAccess.getBodega(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ordendetaprodu.setProducto(ordendetaproduDataAccess.getProducto(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				ordendetaprodu.setUnidad(ordendetaproduDataAccess.getUnidad(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ordendetaprodu.setBodegaDestino(ordendetaproduDataAccess.getBodegaDestino(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				ordendetaprodu.setTipoProcesoProdu(ordendetaproduDataAccess.getTipoProcesoProdu(connexion,ordendetaprodu));
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduGastos(ordendetaproduDataAccess.getProductoOrdenDetaProduGastos(connexion,ordendetaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic= new ProductoOrdenDetaProduGastoLogic(this.connexion);
					productoordendetaprodugastoLogic.setProductoOrdenDetaProduGastos(ordendetaprodu.getProductoOrdenDetaProduGastos());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduGastoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduGasto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodugastoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduGastoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduGasto(productoordendetaprodugastoLogic.getProductoOrdenDetaProduGastos());
					ordendetaprodu.setProductoOrdenDetaProduGastos(productoordendetaprodugastoLogic.getProductoOrdenDetaProduGastos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduManos(ordendetaproduDataAccess.getProductoOrdenDetaProduManos(connexion,ordendetaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(this.connexion);
					productoordendetaprodumanoLogic.setProductoOrdenDetaProduManos(ordendetaprodu.getProductoOrdenDetaProduManos());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduManoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodumanoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(productoordendetaprodumanoLogic.getProductoOrdenDetaProduManos());
					ordendetaprodu.setProductoOrdenDetaProduManos(productoordendetaprodumanoLogic.getProductoOrdenDetaProduManos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProdus(ordendetaproduDataAccess.getProductoOrdenDetaProdus(connexion,ordendetaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduLogic productoordendetaproduLogic= new ProductoOrdenDetaProduLogic(this.connexion);
					productoordendetaproduLogic.setProductoOrdenDetaProdus(ordendetaprodu.getProductoOrdenDetaProdus());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProdu(productoordendetaproduLogic.getProductoOrdenDetaProdus());
					ordendetaprodu.setProductoOrdenDetaProdus(productoordendetaproduLogic.getProductoOrdenDetaProdus());
				}

				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduMaquinas(ordendetaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,ordendetaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(this.connexion);
					productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(ordendetaprodu.getProductoOrdenDetaProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
					ordendetaprodu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
				}

				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduMermas(ordendetaproduDataAccess.getProductoOrdenDetaProduMermas(connexion,ordendetaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic= new ProductoOrdenDetaProduMermaLogic(this.connexion);
					productoordendetaprodumermaLogic.setProductoOrdenDetaProduMermas(ordendetaprodu.getProductoOrdenDetaProduMermas());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduMermaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMerma(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodumermaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduMermaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMerma(productoordendetaprodumermaLogic.getProductoOrdenDetaProduMermas());
					ordendetaprodu.setProductoOrdenDetaProduMermas(productoordendetaprodumermaLogic.getProductoOrdenDetaProduMermas());
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
			ordendetaprodu.setEmpresa(ordendetaproduDataAccess.getEmpresa(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setSucursal(ordendetaproduDataAccess.getSucursal(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setEjercicio(ordendetaproduDataAccess.getEjercicio(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setPeriodo(ordendetaproduDataAccess.getPeriodo(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setOrdenProdu(ordendetaproduDataAccess.getOrdenProdu(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setBodega(ordendetaproduDataAccess.getBodega(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setProducto(ordendetaproduDataAccess.getProducto(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setUnidad(ordendetaproduDataAccess.getUnidad(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setBodegaDestino(ordendetaproduDataAccess.getBodegaDestino(connexion,ordendetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setTipoProcesoProdu(ordendetaproduDataAccess.getTipoProcesoProdu(connexion,ordendetaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduGasto.class));
			ordendetaprodu.setProductoOrdenDetaProduGastos(ordendetaproduDataAccess.getProductoOrdenDetaProduGastos(connexion,ordendetaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMano.class));
			ordendetaprodu.setProductoOrdenDetaProduManos(ordendetaproduDataAccess.getProductoOrdenDetaProduManos(connexion,ordendetaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProdu.class));
			ordendetaprodu.setProductoOrdenDetaProdus(ordendetaproduDataAccess.getProductoOrdenDetaProdus(connexion,ordendetaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			ordendetaprodu.setProductoOrdenDetaProduMaquinas(ordendetaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,ordendetaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMerma.class));
			ordendetaprodu.setProductoOrdenDetaProduMermas(ordendetaproduDataAccess.getProductoOrdenDetaProduMermas(connexion,ordendetaprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ordendetaprodu.setEmpresa(ordendetaproduDataAccess.getEmpresa(connexion,ordendetaprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ordendetaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setSucursal(ordendetaproduDataAccess.getSucursal(connexion,ordendetaprodu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ordendetaprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setEjercicio(ordendetaproduDataAccess.getEjercicio(connexion,ordendetaprodu));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(ordendetaprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setPeriodo(ordendetaproduDataAccess.getPeriodo(connexion,ordendetaprodu));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(ordendetaprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setOrdenProdu(ordendetaproduDataAccess.getOrdenProdu(connexion,ordendetaprodu));
		OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
		ordenproduLogic.deepLoad(ordendetaprodu.getOrdenProdu(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setBodega(ordendetaproduDataAccess.getBodega(connexion,ordendetaprodu));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ordendetaprodu.getBodega(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setProducto(ordendetaproduDataAccess.getProducto(connexion,ordendetaprodu));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(ordendetaprodu.getProducto(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setUnidad(ordendetaproduDataAccess.getUnidad(connexion,ordendetaprodu));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(ordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setBodegaDestino(ordendetaproduDataAccess.getBodegaDestino(connexion,ordendetaprodu));
		BodegaLogic bodegadestinoLogic= new BodegaLogic(connexion);
		bodegadestinoLogic.deepLoad(ordendetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);
				
		ordendetaprodu.setTipoProcesoProdu(ordendetaproduDataAccess.getTipoProcesoProdu(connexion,ordendetaprodu));
		TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
		tipoprocesoproduLogic.deepLoad(ordendetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);
				

		ordendetaprodu.setProductoOrdenDetaProduGastos(ordendetaproduDataAccess.getProductoOrdenDetaProduGastos(connexion,ordendetaprodu));

		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:ordendetaprodu.getProductoOrdenDetaProduGastos()) {
			ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic= new ProductoOrdenDetaProduGastoLogic(connexion);
			productoordendetaprodugastoLogic.deepLoad(productoordendetaprodugasto,isDeep,deepLoadType,clases);
		}

		ordendetaprodu.setProductoOrdenDetaProduManos(ordendetaproduDataAccess.getProductoOrdenDetaProduManos(connexion,ordendetaprodu));

		for(ProductoOrdenDetaProduMano productoordendetaprodumano:ordendetaprodu.getProductoOrdenDetaProduManos()) {
			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
			productoordendetaprodumanoLogic.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
		}

		ordendetaprodu.setProductoOrdenDetaProdus(ordendetaproduDataAccess.getProductoOrdenDetaProdus(connexion,ordendetaprodu));

		for(ProductoOrdenDetaProdu productoordendetaprodu:ordendetaprodu.getProductoOrdenDetaProdus()) {
			ProductoOrdenDetaProduLogic productoordendetaproduLogic= new ProductoOrdenDetaProduLogic(connexion);
			productoordendetaproduLogic.deepLoad(productoordendetaprodu,isDeep,deepLoadType,clases);
		}

		ordendetaprodu.setProductoOrdenDetaProduMaquinas(ordendetaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,ordendetaprodu));

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:ordendetaprodu.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		ordendetaprodu.setProductoOrdenDetaProduMermas(ordendetaproduDataAccess.getProductoOrdenDetaProduMermas(connexion,ordendetaprodu));

		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:ordendetaprodu.getProductoOrdenDetaProduMermas()) {
			ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic= new ProductoOrdenDetaProduMermaLogic(connexion);
			productoordendetaprodumermaLogic.deepLoad(productoordendetaprodumerma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ordendetaprodu.setEmpresa(ordendetaproduDataAccess.getEmpresa(connexion,ordendetaprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ordendetaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ordendetaprodu.setSucursal(ordendetaproduDataAccess.getSucursal(connexion,ordendetaprodu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ordendetaprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				ordendetaprodu.setEjercicio(ordendetaproduDataAccess.getEjercicio(connexion,ordendetaprodu));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(ordendetaprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				ordendetaprodu.setPeriodo(ordendetaproduDataAccess.getPeriodo(connexion,ordendetaprodu));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(ordendetaprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenProdu.class)) {
				ordendetaprodu.setOrdenProdu(ordendetaproduDataAccess.getOrdenProdu(connexion,ordendetaprodu));
				OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
				ordenproduLogic.deepLoad(ordendetaprodu.getOrdenProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ordendetaprodu.setBodega(ordendetaproduDataAccess.getBodega(connexion,ordendetaprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(ordendetaprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ordendetaprodu.setProducto(ordendetaproduDataAccess.getProducto(connexion,ordendetaprodu));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(ordendetaprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				ordendetaprodu.setUnidad(ordendetaproduDataAccess.getUnidad(connexion,ordendetaprodu));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(ordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ordendetaprodu.setBodegaDestino(ordendetaproduDataAccess.getBodegaDestino(connexion,ordendetaprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(ordendetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				ordendetaprodu.setTipoProcesoProdu(ordendetaproduDataAccess.getTipoProcesoProdu(connexion,ordendetaprodu));
				TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
				tipoprocesoproduLogic.deepLoad(ordendetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduGastos(ordendetaproduDataAccess.getProductoOrdenDetaProduGastos(connexion,ordendetaprodu));

				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:ordendetaprodu.getProductoOrdenDetaProduGastos()) {
					ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic= new ProductoOrdenDetaProduGastoLogic(connexion);
					productoordendetaprodugastoLogic.deepLoad(productoordendetaprodugasto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduManos(ordendetaproduDataAccess.getProductoOrdenDetaProduManos(connexion,ordendetaprodu));

				for(ProductoOrdenDetaProduMano productoordendetaprodumano:ordendetaprodu.getProductoOrdenDetaProduManos()) {
					ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
					productoordendetaprodumanoLogic.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProdus(ordendetaproduDataAccess.getProductoOrdenDetaProdus(connexion,ordendetaprodu));

				for(ProductoOrdenDetaProdu productoordendetaprodu:ordendetaprodu.getProductoOrdenDetaProdus()) {
					ProductoOrdenDetaProduLogic productoordendetaproduLogic= new ProductoOrdenDetaProduLogic(connexion);
					productoordendetaproduLogic.deepLoad(productoordendetaprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduMaquinas(ordendetaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,ordendetaprodu));

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:ordendetaprodu.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ordendetaprodu.setProductoOrdenDetaProduMermas(ordendetaproduDataAccess.getProductoOrdenDetaProduMermas(connexion,ordendetaprodu));

				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:ordendetaprodu.getProductoOrdenDetaProduMermas()) {
					ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic= new ProductoOrdenDetaProduMermaLogic(connexion);
					productoordendetaprodumermaLogic.deepLoad(productoordendetaprodumerma,isDeep,deepLoadType,clases);
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
			ordendetaprodu.setEmpresa(ordendetaproduDataAccess.getEmpresa(connexion,ordendetaprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ordendetaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setSucursal(ordendetaproduDataAccess.getSucursal(connexion,ordendetaprodu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ordendetaprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setEjercicio(ordendetaproduDataAccess.getEjercicio(connexion,ordendetaprodu));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(ordendetaprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setPeriodo(ordendetaproduDataAccess.getPeriodo(connexion,ordendetaprodu));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(ordendetaprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setOrdenProdu(ordendetaproduDataAccess.getOrdenProdu(connexion,ordendetaprodu));
			OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
			ordenproduLogic.deepLoad(ordendetaprodu.getOrdenProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setBodega(ordendetaproduDataAccess.getBodega(connexion,ordendetaprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(ordendetaprodu.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setProducto(ordendetaproduDataAccess.getProducto(connexion,ordendetaprodu));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(ordendetaprodu.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setUnidad(ordendetaproduDataAccess.getUnidad(connexion,ordendetaprodu));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(ordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setBodegaDestino(ordendetaproduDataAccess.getBodegaDestino(connexion,ordendetaprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(ordendetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ordendetaprodu.setTipoProcesoProdu(ordendetaproduDataAccess.getTipoProcesoProdu(connexion,ordendetaprodu));
			TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
			tipoprocesoproduLogic.deepLoad(ordendetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduGasto.class));
			ordendetaprodu.setProductoOrdenDetaProduGastos(ordendetaproduDataAccess.getProductoOrdenDetaProduGastos(connexion,ordendetaprodu));

			for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:ordendetaprodu.getProductoOrdenDetaProduGastos()) {
				ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic= new ProductoOrdenDetaProduGastoLogic(connexion);
				productoordendetaprodugastoLogic.deepLoad(productoordendetaprodugasto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMano.class));
			ordendetaprodu.setProductoOrdenDetaProduManos(ordendetaproduDataAccess.getProductoOrdenDetaProduManos(connexion,ordendetaprodu));

			for(ProductoOrdenDetaProduMano productoordendetaprodumano:ordendetaprodu.getProductoOrdenDetaProduManos()) {
				ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
				productoordendetaprodumanoLogic.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProdu.class));
			ordendetaprodu.setProductoOrdenDetaProdus(ordendetaproduDataAccess.getProductoOrdenDetaProdus(connexion,ordendetaprodu));

			for(ProductoOrdenDetaProdu productoordendetaprodu:ordendetaprodu.getProductoOrdenDetaProdus()) {
				ProductoOrdenDetaProduLogic productoordendetaproduLogic= new ProductoOrdenDetaProduLogic(connexion);
				productoordendetaproduLogic.deepLoad(productoordendetaprodu,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			ordendetaprodu.setProductoOrdenDetaProduMaquinas(ordendetaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,ordendetaprodu));

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:ordendetaprodu.getProductoOrdenDetaProduMaquinas()) {
				ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
				productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMerma.class));
			ordendetaprodu.setProductoOrdenDetaProduMermas(ordendetaproduDataAccess.getProductoOrdenDetaProduMermas(connexion,ordendetaprodu));

			for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:ordendetaprodu.getProductoOrdenDetaProduMermas()) {
				ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic= new ProductoOrdenDetaProduMermaLogic(connexion);
				productoordendetaprodumermaLogic.deepLoad(productoordendetaprodumerma,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(OrdenDetaProdu ordendetaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			OrdenDetaProduLogicAdditional.updateOrdenDetaProduToSave(ordendetaprodu,this.arrDatoGeneral);
			
OrdenDetaProduDataAccess.save(ordendetaprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ordendetaprodu.getEmpresa(),connexion);

		SucursalDataAccess.save(ordendetaprodu.getSucursal(),connexion);

		EjercicioDataAccess.save(ordendetaprodu.getEjercicio(),connexion);

		PeriodoDataAccess.save(ordendetaprodu.getPeriodo(),connexion);

		OrdenProduDataAccess.save(ordendetaprodu.getOrdenProdu(),connexion);

		BodegaDataAccess.save(ordendetaprodu.getBodega(),connexion);

		ProductoDataAccess.save(ordendetaprodu.getProducto(),connexion);

		UnidadDataAccess.save(ordendetaprodu.getUnidad(),connexion);

		BodegaDataAccess.save(ordendetaprodu.getBodegaDestino(),connexion);

		TipoProcesoProduDataAccess.save(ordendetaprodu.getTipoProcesoProdu(),connexion);

		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:ordendetaprodu.getProductoOrdenDetaProduGastos()) {
			productoordendetaprodugasto.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduGastoDataAccess.save(productoordendetaprodugasto,connexion);
		}

		for(ProductoOrdenDetaProduMano productoordendetaprodumano:ordendetaprodu.getProductoOrdenDetaProduManos()) {
			productoordendetaprodumano.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
		}

		for(ProductoOrdenDetaProdu productoordendetaprodu:ordendetaprodu.getProductoOrdenDetaProdus()) {
			productoordendetaprodu.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduDataAccess.save(productoordendetaprodu,connexion);
		}

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:ordendetaprodu.getProductoOrdenDetaProduMaquinas()) {
			productoordendetaprodumaquina.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
		}

		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:ordendetaprodu.getProductoOrdenDetaProduMermas()) {
			productoordendetaprodumerma.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduMermaDataAccess.save(productoordendetaprodumerma,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ordendetaprodu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ordendetaprodu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(ordendetaprodu.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(ordendetaprodu.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(OrdenProdu.class)) {
				OrdenProduDataAccess.save(ordendetaprodu.getOrdenProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ordendetaprodu.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ordendetaprodu.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(ordendetaprodu.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ordendetaprodu.getBodegaDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				TipoProcesoProduDataAccess.save(ordendetaprodu.getTipoProcesoProdu(),connexion);
				continue;
			}


			if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:ordendetaprodu.getProductoOrdenDetaProduGastos()) {
					productoordendetaprodugasto.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduGastoDataAccess.save(productoordendetaprodugasto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMano productoordendetaprodumano:ordendetaprodu.getProductoOrdenDetaProduManos()) {
					productoordendetaprodumano.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProdu productoordendetaprodu:ordendetaprodu.getProductoOrdenDetaProdus()) {
					productoordendetaprodu.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduDataAccess.save(productoordendetaprodu,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:ordendetaprodu.getProductoOrdenDetaProduMaquinas()) {
					productoordendetaprodumaquina.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:ordendetaprodu.getProductoOrdenDetaProduMermas()) {
					productoordendetaprodumerma.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduMermaDataAccess.save(productoordendetaprodumerma,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ordendetaprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ordendetaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(ordendetaprodu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ordendetaprodu.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(ordendetaprodu.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(ordendetaprodu.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(ordendetaprodu.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(ordendetaprodu.getPeriodo(),isDeep,deepLoadType,clases);
				

		OrdenProduDataAccess.save(ordendetaprodu.getOrdenProdu(),connexion);
		OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
		ordenproduLogic.deepLoad(ordendetaprodu.getOrdenProdu(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(ordendetaprodu.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ordendetaprodu.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(ordendetaprodu.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(ordendetaprodu.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(ordendetaprodu.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(ordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(ordendetaprodu.getBodegaDestino(),connexion);
		BodegaLogic bodegadestinoLogic= new BodegaLogic(connexion);
		bodegadestinoLogic.deepLoad(ordendetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);
				

		TipoProcesoProduDataAccess.save(ordendetaprodu.getTipoProcesoProdu(),connexion);
		TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
		tipoprocesoproduLogic.deepLoad(ordendetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);
				

		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:ordendetaprodu.getProductoOrdenDetaProduGastos()) {
			ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic= new ProductoOrdenDetaProduGastoLogic(connexion);
			productoordendetaprodugasto.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduGastoDataAccess.save(productoordendetaprodugasto,connexion);
			productoordendetaprodugastoLogic.deepSave(productoordendetaprodugasto,isDeep,deepLoadType,clases);
		}

		for(ProductoOrdenDetaProduMano productoordendetaprodumano:ordendetaprodu.getProductoOrdenDetaProduManos()) {
			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
			productoordendetaprodumano.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
			productoordendetaprodumanoLogic.deepSave(productoordendetaprodumano,isDeep,deepLoadType,clases);
		}

		for(ProductoOrdenDetaProdu productoordendetaprodu:ordendetaprodu.getProductoOrdenDetaProdus()) {
			ProductoOrdenDetaProduLogic productoordendetaproduLogic= new ProductoOrdenDetaProduLogic(connexion);
			productoordendetaprodu.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduDataAccess.save(productoordendetaprodu,connexion);
			productoordendetaproduLogic.deepSave(productoordendetaprodu,isDeep,deepLoadType,clases);
		}

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:ordendetaprodu.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquina.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
			productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:ordendetaprodu.getProductoOrdenDetaProduMermas()) {
			ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic= new ProductoOrdenDetaProduMermaLogic(connexion);
			productoordendetaprodumerma.setid_orden_deta_produ(ordendetaprodu.getId());
			ProductoOrdenDetaProduMermaDataAccess.save(productoordendetaprodumerma,connexion);
			productoordendetaprodumermaLogic.deepSave(productoordendetaprodumerma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ordendetaprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(ordendetaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ordendetaprodu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(ordendetaprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(ordendetaprodu.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(ordendetaprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(ordendetaprodu.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(ordendetaprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenProdu.class)) {
				OrdenProduDataAccess.save(ordendetaprodu.getOrdenProdu(),connexion);
				OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
				ordenproduLogic.deepSave(ordendetaprodu.getOrdenProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ordendetaprodu.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(ordendetaprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ordendetaprodu.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(ordendetaprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(ordendetaprodu.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(ordendetaprodu.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ordendetaprodu.getBodegaDestino(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(ordendetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				TipoProcesoProduDataAccess.save(ordendetaprodu.getTipoProcesoProdu(),connexion);
				TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
				tipoprocesoproduLogic.deepSave(ordendetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:ordendetaprodu.getProductoOrdenDetaProduGastos()) {
					ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic= new ProductoOrdenDetaProduGastoLogic(connexion);
					productoordendetaprodugasto.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduGastoDataAccess.save(productoordendetaprodugasto,connexion);
					productoordendetaprodugastoLogic.deepSave(productoordendetaprodugasto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMano productoordendetaprodumano:ordendetaprodu.getProductoOrdenDetaProduManos()) {
					ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
					productoordendetaprodumano.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
					productoordendetaprodumanoLogic.deepSave(productoordendetaprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProdu productoordendetaprodu:ordendetaprodu.getProductoOrdenDetaProdus()) {
					ProductoOrdenDetaProduLogic productoordendetaproduLogic= new ProductoOrdenDetaProduLogic(connexion);
					productoordendetaprodu.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduDataAccess.save(productoordendetaprodu,connexion);
					productoordendetaproduLogic.deepSave(productoordendetaprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:ordendetaprodu.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquina.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
					productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:ordendetaprodu.getProductoOrdenDetaProduMermas()) {
					ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic= new ProductoOrdenDetaProduMermaLogic(connexion);
					productoordendetaprodumerma.setid_orden_deta_produ(ordendetaprodu.getId());
					ProductoOrdenDetaProduMermaDataAccess.save(productoordendetaprodumerma,connexion);
					productoordendetaprodumermaLogic.deepSave(productoordendetaprodumerma,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(OrdenDetaProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ordendetaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(ordendetaprodu);
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
			this.deepLoad(this.ordendetaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(OrdenDetaProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(ordendetaprodus!=null) {
				for(OrdenDetaProdu ordendetaprodu:ordendetaprodus) {
					this.deepLoad(ordendetaprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(ordendetaprodus);
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
			if(ordendetaprodus!=null) {
				for(OrdenDetaProdu ordendetaprodu:ordendetaprodus) {
					this.deepLoad(ordendetaprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(ordendetaprodus);
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
			this.getNewConnexionToDeep(OrdenDetaProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ordendetaprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(OrdenDetaProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(ordendetaprodus!=null) {
				for(OrdenDetaProdu ordendetaprodu:ordendetaprodus) {
					this.deepSave(ordendetaprodu,isDeep,deepLoadType,clases);
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
			if(ordendetaprodus!=null) {
				for(OrdenDetaProdu ordendetaprodu:ordendetaprodus) {
					this.deepSave(ordendetaprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getOrdenDetaProdusFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,OrdenDetaProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,OrdenDetaProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdBodegaDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_destino,OrdenDetaProduConstantesFunciones.IDBODEGADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaDestino);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdBodegaDestino(String sFinalQuery,Pagination pagination,Long id_bodega_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_destino,OrdenDetaProduConstantesFunciones.IDBODEGADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaDestino);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,OrdenDetaProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,OrdenDetaProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,OrdenDetaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,OrdenDetaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdOrdenProduWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_produ,OrdenDetaProduConstantesFunciones.IDORDENPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenProdu);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdOrdenProdu(String sFinalQuery,Pagination pagination,Long id_orden_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_produ,OrdenDetaProduConstantesFunciones.IDORDENPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenProdu);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,OrdenDetaProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,OrdenDetaProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,OrdenDetaProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,OrdenDetaProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,OrdenDetaProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,OrdenDetaProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdTipoProcesoProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_produ,OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoProdu);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdTipoProcesoProdu(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_produ,OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoProdu);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOrdenDetaProdusFK_IdUnidadUnadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,OrdenDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,OrdenDetaProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOrdenDetaProdusFK_IdUnidadUnad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,OrdenDetaProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			OrdenDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidadUnad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OrdenDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenDetaProdu(this.ordendetaprodus);
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
			if(OrdenDetaProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenDetaProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,OrdenDetaProdu ordendetaprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(OrdenDetaProduConstantesFunciones.ISCONAUDITORIA) {
				if(ordendetaprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenDetaProduDataAccess.TABLENAME, ordendetaprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OrdenDetaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////OrdenDetaProduLogic.registrarAuditoriaDetallesOrdenDetaProdu(connexion,ordendetaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ordendetaprodu.getIsDeleted()) {
					/*if(!ordendetaprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,OrdenDetaProduDataAccess.TABLENAME, ordendetaprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////OrdenDetaProduLogic.registrarAuditoriaDetallesOrdenDetaProdu(connexion,ordendetaprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenDetaProduDataAccess.TABLENAME, ordendetaprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ordendetaprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OrdenDetaProduDataAccess.TABLENAME, ordendetaprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OrdenDetaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////OrdenDetaProduLogic.registrarAuditoriaDetallesOrdenDetaProdu(connexion,ordendetaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesOrdenDetaProdu(Connexion connexion,OrdenDetaProdu ordendetaprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_empresa().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_empresa()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_empresa().toString();
				}
				if(ordendetaprodu.getid_empresa()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_sucursal().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_sucursal()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_sucursal().toString();
				}
				if(ordendetaprodu.getid_sucursal()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_ejercicio().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_ejercicio()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_ejercicio().toString();
				}
				if(ordendetaprodu.getid_ejercicio()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_periodo().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_periodo()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_periodo().toString();
				}
				if(ordendetaprodu.getid_periodo()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_orden_produ().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_orden_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_orden_produ()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_orden_produ().toString();
				}
				if(ordendetaprodu.getid_orden_produ()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_orden_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDORDENPRODU,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_bodega().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_bodega()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_bodega().toString();
				}
				if(ordendetaprodu.getid_bodega()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_producto().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_producto()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_producto().toString();
				}
				if(ordendetaprodu.getid_producto()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_unidad().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_unidad()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_unidad().toString();
				}
				if(ordendetaprodu.getid_unidad()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_bodega_destino().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_bodega_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_bodega_destino()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_bodega_destino().toString();
				}
				if(ordendetaprodu.getid_bodega_destino()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_bodega_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDBODEGADESTINO,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getid_tipo_proceso_produ().equals(ordendetaprodu.getOrdenDetaProduOriginal().getid_tipo_proceso_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getid_tipo_proceso_produ()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getid_tipo_proceso_produ().toString();
				}
				if(ordendetaprodu.getid_tipo_proceso_produ()!=null)
				{
					strValorNuevo=ordendetaprodu.getid_tipo_proceso_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getcantidad().equals(ordendetaprodu.getOrdenDetaProduOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getcantidad()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getcantidad().toString();
				}
				if(ordendetaprodu.getcantidad()!=null)
				{
					strValorNuevo=ordendetaprodu.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getcantidad_pendiente().equals(ordendetaprodu.getOrdenDetaProduOriginal().getcantidad_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getcantidad_pendiente()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getcantidad_pendiente().toString();
				}
				if(ordendetaprodu.getcantidad_pendiente()!=null)
				{
					strValorNuevo=ordendetaprodu.getcantidad_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE,strValorActual,strValorNuevo);
			}	
			
			if(ordendetaprodu.getIsNew()||!ordendetaprodu.getdescripcion().equals(ordendetaprodu.getOrdenDetaProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ordendetaprodu.getOrdenDetaProduOriginal().getdescripcion()!=null)
				{
					strValorActual=ordendetaprodu.getOrdenDetaProduOriginal().getdescripcion();
				}
				if(ordendetaprodu.getdescripcion()!=null)
				{
					strValorNuevo=ordendetaprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OrdenDetaProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveOrdenDetaProduRelacionesWithConnection(OrdenDetaProdu ordendetaprodu,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProdu> productoordendetaprodus,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas) throws Exception {

		if(!ordendetaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOrdenDetaProduRelacionesBase(ordendetaprodu,productoordendetaprodugastos,productoordendetaprodumanos,productoordendetaprodus,productoordendetaprodumaquinas,productoordendetaprodumermas,true);
		}
	}

	public void saveOrdenDetaProduRelaciones(OrdenDetaProdu ordendetaprodu,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProdu> productoordendetaprodus,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas)throws Exception {

		if(!ordendetaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOrdenDetaProduRelacionesBase(ordendetaprodu,productoordendetaprodugastos,productoordendetaprodumanos,productoordendetaprodus,productoordendetaprodumaquinas,productoordendetaprodumermas,false);
		}
	}

	public void saveOrdenDetaProduRelacionesBase(OrdenDetaProdu ordendetaprodu,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProdu> productoordendetaprodus,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("OrdenDetaProdu-saveRelacionesWithConnection");}
	
			ordendetaprodu.setProductoOrdenDetaProduGastos(productoordendetaprodugastos);
			ordendetaprodu.setProductoOrdenDetaProduManos(productoordendetaprodumanos);
			ordendetaprodu.setProductoOrdenDetaProdus(productoordendetaprodus);
			ordendetaprodu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);
			ordendetaprodu.setProductoOrdenDetaProduMermas(productoordendetaprodumermas);

			this.setOrdenDetaProdu(ordendetaprodu);

			if(OrdenDetaProduLogicAdditional.validarSaveRelaciones(ordendetaprodu,this)) {

				OrdenDetaProduLogicAdditional.updateRelacionesToSave(ordendetaprodu,this);

				if((ordendetaprodu.getIsNew()||ordendetaprodu.getIsChanged())&&!ordendetaprodu.getIsDeleted()) {
					this.saveOrdenDetaProdu();
					this.saveOrdenDetaProduRelacionesDetalles(productoordendetaprodugastos,productoordendetaprodumanos,productoordendetaprodus,productoordendetaprodumaquinas,productoordendetaprodumermas);

				} else if(ordendetaprodu.getIsDeleted()) {
					this.saveOrdenDetaProduRelacionesDetalles(productoordendetaprodugastos,productoordendetaprodumanos,productoordendetaprodus,productoordendetaprodumaquinas,productoordendetaprodumermas);
					this.saveOrdenDetaProdu();
				}

				OrdenDetaProduLogicAdditional.updateRelacionesToSaveAfter(ordendetaprodu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoOrdenDetaProduGastoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduGastos(productoordendetaprodugastos,true,true);
			ProductoOrdenDetaProduManoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduManos(productoordendetaprodumanos,true,true);
			ProductoOrdenDetaProduConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProdus(productoordendetaprodus,true,true);
			ProductoOrdenDetaProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas,true,true);
			ProductoOrdenDetaProduMermaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMermas(productoordendetaprodumermas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveOrdenDetaProduRelacionesDetalles(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProdu> productoordendetaprodus,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas)throws Exception {
		try {
	

			Long idOrdenDetaProduActual=this.getOrdenDetaProdu().getId();

			ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduGastoLogic();
			productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduGastos(productoordendetaprodugastos);

			productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
			productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduGasto productoordendetaprodugasto_Desde_OrdenDetaProdu:productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduGastos()) {
				productoordendetaprodugasto_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
			}

			productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduGastos();

			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduManoLogic();
			productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduManos(productoordendetaprodumanos);

			productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
			productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduMano productoordendetaprodumano_Desde_OrdenDetaProdu:productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduManos()) {
				productoordendetaprodumano_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
			}

			productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduManos();

			ProductoOrdenDetaProduLogic productoordendetaproduLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduLogic();
			productoordendetaproduLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProdus(productoordendetaprodus);

			productoordendetaproduLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
			productoordendetaproduLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProdu productoordendetaprodu_Desde_OrdenDetaProdu:productoordendetaproduLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProdus()) {
				productoordendetaprodu_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
			}

			productoordendetaproduLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProdus();

			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduMaquinaLogic();
			productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);

			productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina_Desde_OrdenDetaProdu:productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduMaquinas()) {
				productoordendetaprodumaquina_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
			}

			productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduMaquinas();

			ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduMermaLogic();
			productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduMermas(productoordendetaprodumermas);

			productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
			productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduMerma productoordendetaprodumerma_Desde_OrdenDetaProdu:productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduMermas()) {
				productoordendetaprodumerma_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
			}

			productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduMermas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OrdenDetaProduConstantesFunciones.getClassesForeignKeysOfOrdenDetaProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OrdenDetaProduConstantesFunciones.getClassesRelationshipsOfOrdenDetaProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
