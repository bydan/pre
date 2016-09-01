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
import com.bydan.erp.produccion.util.EstadoOrdenProduConstantesFunciones;
import com.bydan.erp.produccion.util.EstadoOrdenProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.EstadoOrdenProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.EstadoOrdenProdu;
//import com.bydan.erp.produccion.business.logic.EstadoOrdenProduLogicAdditional;
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
public class EstadoOrdenProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoOrdenProduLogic.class);
	
	protected EstadoOrdenProduDataAccess estadoordenproduDataAccess; 	
	protected EstadoOrdenProdu estadoordenprodu;
	protected List<EstadoOrdenProdu> estadoordenprodus;
	protected Object estadoordenproduObject;	
	protected List<Object> estadoordenprodusObject;
	
	public static ClassValidator<EstadoOrdenProdu> estadoordenproduValidator = new ClassValidator<EstadoOrdenProdu>(EstadoOrdenProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoOrdenProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoordenproduDataAccess = new EstadoOrdenProduDataAccess();
			
			this.estadoordenprodus= new ArrayList<EstadoOrdenProdu>();
			this.estadoordenprodu= new EstadoOrdenProdu();
			
			this.estadoordenproduObject=new Object();
			this.estadoordenprodusObject=new ArrayList<Object>();
				
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
			
			this.estadoordenproduDataAccess.setConnexionType(this.connexionType);
			this.estadoordenproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoOrdenProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoordenproduDataAccess = new EstadoOrdenProduDataAccess();
			this.estadoordenprodus= new ArrayList<EstadoOrdenProdu>();
			this.estadoordenprodu= new EstadoOrdenProdu();
			this.estadoordenproduObject=new Object();
			this.estadoordenprodusObject=new ArrayList<Object>();
			
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
			
			this.estadoordenproduDataAccess.setConnexionType(this.connexionType);
			this.estadoordenproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoOrdenProdu getEstadoOrdenProdu() throws Exception {	
		//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToGet(estadoordenprodu,this.datosCliente,this.arrDatoGeneral);
		//EstadoOrdenProduLogicAdditional.updateEstadoOrdenProduToGet(estadoordenprodu,this.arrDatoGeneral);
		
		return estadoordenprodu;
	}
		
	public void setEstadoOrdenProdu(EstadoOrdenProdu newEstadoOrdenProdu) {
		this.estadoordenprodu = newEstadoOrdenProdu;
	}
	
	public EstadoOrdenProduDataAccess getEstadoOrdenProduDataAccess() {
		return estadoordenproduDataAccess;
	}
	
	public void setEstadoOrdenProduDataAccess(EstadoOrdenProduDataAccess newestadoordenproduDataAccess) {
		this.estadoordenproduDataAccess = newestadoordenproduDataAccess;
	}
	
	public List<EstadoOrdenProdu> getEstadoOrdenProdus() throws Exception {		
		this.quitarEstadoOrdenProdusNulos();
		
		//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToGets(estadoordenprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoOrdenProdu estadoordenproduLocal: estadoordenprodus ) {
			//EstadoOrdenProduLogicAdditional.updateEstadoOrdenProduToGet(estadoordenproduLocal,this.arrDatoGeneral);
		}
		
		return estadoordenprodus;
	}
	
	public void setEstadoOrdenProdus(List<EstadoOrdenProdu> newEstadoOrdenProdus) {
		this.estadoordenprodus = newEstadoOrdenProdus;
	}
	
	public Object getEstadoOrdenProduObject() {	
		this.estadoordenproduObject=this.estadoordenproduDataAccess.getEntityObject();
		return this.estadoordenproduObject;
	}
		
	public void setEstadoOrdenProduObject(Object newEstadoOrdenProduObject) {
		this.estadoordenproduObject = newEstadoOrdenProduObject;
	}
	
	public List<Object> getEstadoOrdenProdusObject() {		
		this.estadoordenprodusObject=this.estadoordenproduDataAccess.getEntitiesObject();
		return this.estadoordenprodusObject;
	}
		
	public void setEstadoOrdenProdusObject(List<Object> newEstadoOrdenProdusObject) {
		this.estadoordenprodusObject = newEstadoOrdenProdusObject;
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
		
		if(this.estadoordenproduDataAccess!=null) {
			this.estadoordenproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoordenproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoordenproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoordenprodu = new  EstadoOrdenProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodu);
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
		estadoordenprodu = new  EstadoOrdenProdu();
		  		  
        try {
			
			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoordenprodu = new  EstadoOrdenProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodu);
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
		estadoordenprodu = new  EstadoOrdenProdu();
		  		  
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
		estadoordenprodu = new  EstadoOrdenProdu();
		  		  
        try {
			
			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoordenprodu = new  EstadoOrdenProdu();
		  		  
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
		estadoordenprodu = new  EstadoOrdenProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoordenproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoordenprodu = new  EstadoOrdenProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoordenproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoordenprodu = new  EstadoOrdenProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoordenproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoordenprodu = new  EstadoOrdenProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoordenproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoordenprodu = new  EstadoOrdenProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoordenproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoordenprodu = new  EstadoOrdenProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoordenproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
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
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		  		  
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
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		  		  
        try {			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		  		  
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
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
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
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		  		  
        try {
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
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
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
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
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoordenprodu = new  EstadoOrdenProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodu);
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
		estadoordenprodu = new  EstadoOrdenProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoOrdenProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-getTodosEstadoOrdenProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
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
	
	public  void  getTodosEstadoOrdenProdus(String sFinalQuery,Pagination pagination)throws Exception {
		estadoordenprodus = new  ArrayList<EstadoOrdenProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoordenprodus=estadoordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoOrdenProdu(estadoordenprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoOrdenProdu(EstadoOrdenProdu estadoordenprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoordenprodu.getIsNew() || estadoordenprodu.getIsChanged()) { 
			this.invalidValues = estadoordenproduValidator.getInvalidValues(estadoordenprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoordenprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoOrdenProdu(List<EstadoOrdenProdu> EstadoOrdenProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoOrdenProdu estadoordenproduLocal:estadoordenprodus) {				
			estaValidadoObjeto=this.validarGuardarEstadoOrdenProdu(estadoordenproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoOrdenProdu(List<EstadoOrdenProdu> EstadoOrdenProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoOrdenProdu(estadoordenprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoOrdenProdu(EstadoOrdenProdu EstadoOrdenProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoOrdenProdu(estadoordenprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoOrdenProdu estadoordenprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoordenprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoOrdenProduConstantesFunciones.getEstadoOrdenProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoordenprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoOrdenProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoOrdenProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoOrdenProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-saveEstadoOrdenProduWithConnection");connexion.begin();			
			
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSave(this.estadoordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoOrdenProduLogicAdditional.updateEstadoOrdenProduToSave(this.estadoordenprodu,this.arrDatoGeneral);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoordenprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoOrdenProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoOrdenProdu(this.estadoordenprodu)) {
				EstadoOrdenProduDataAccess.save(this.estadoordenprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSaveAfter(this.estadoordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoOrdenProdu();
			
			connexion.commit();			
			
			if(this.estadoordenprodu.getIsDeleted()) {
				this.estadoordenprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoOrdenProdu()throws Exception {	
		try {	
			
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSave(this.estadoordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoOrdenProduLogicAdditional.updateEstadoOrdenProduToSave(this.estadoordenprodu,this.arrDatoGeneral);
			
			EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoordenprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoOrdenProdu(this.estadoordenprodu)) {			
				EstadoOrdenProduDataAccess.save(this.estadoordenprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoordenprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSaveAfter(this.estadoordenprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoordenprodu.getIsDeleted()) {
				this.estadoordenprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoOrdenProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-saveEstadoOrdenProdusWithConnection");connexion.begin();			
			
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSaves(estadoordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoOrdenProdus();
			
			Boolean validadoTodosEstadoOrdenProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoOrdenProdu estadoordenproduLocal:estadoordenprodus) {		
				if(estadoordenproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoOrdenProduLogicAdditional.updateEstadoOrdenProduToSave(estadoordenproduLocal,this.arrDatoGeneral);
	        	
				EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoordenproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoOrdenProdu(estadoordenproduLocal)) {
					EstadoOrdenProduDataAccess.save(estadoordenproduLocal, connexion);				
				} else {
					validadoTodosEstadoOrdenProdu=false;
				}
			}
			
			if(!validadoTodosEstadoOrdenProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSavesAfter(estadoordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoOrdenProdus();
			
			connexion.commit();		
			
			this.quitarEstadoOrdenProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoOrdenProdus()throws Exception {				
		 try {	
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSaves(estadoordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoOrdenProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoOrdenProdu estadoordenproduLocal:estadoordenprodus) {				
				if(estadoordenproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoOrdenProduLogicAdditional.updateEstadoOrdenProduToSave(estadoordenproduLocal,this.arrDatoGeneral);
	        	
				EstadoOrdenProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoordenproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoOrdenProdu(estadoordenproduLocal)) {				
					EstadoOrdenProduDataAccess.save(estadoordenproduLocal, connexion);				
				} else {
					validadoTodosEstadoOrdenProdu=false;
				}
			}
			
			if(!validadoTodosEstadoOrdenProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoOrdenProduLogicAdditional.checkEstadoOrdenProduToSavesAfter(estadoordenprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoOrdenProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoOrdenProduParameterReturnGeneral procesarAccionEstadoOrdenProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoOrdenProdu> estadoordenprodus,EstadoOrdenProduParameterReturnGeneral estadoordenproduParameterGeneral)throws Exception {
		 try {	
			EstadoOrdenProduParameterReturnGeneral estadoordenproduReturnGeneral=new EstadoOrdenProduParameterReturnGeneral();
	
			
			return estadoordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoOrdenProduParameterReturnGeneral procesarAccionEstadoOrdenProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoOrdenProdu> estadoordenprodus,EstadoOrdenProduParameterReturnGeneral estadoordenproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-procesarAccionEstadoOrdenProdusWithConnection");connexion.begin();			
			
			EstadoOrdenProduParameterReturnGeneral estadoordenproduReturnGeneral=new EstadoOrdenProduParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadoordenproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoOrdenProduParameterReturnGeneral procesarEventosEstadoOrdenProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoOrdenProdu> estadoordenprodus,EstadoOrdenProdu estadoordenprodu,EstadoOrdenProduParameterReturnGeneral estadoordenproduParameterGeneral,Boolean isEsNuevoEstadoOrdenProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoOrdenProduParameterReturnGeneral estadoordenproduReturnGeneral=new EstadoOrdenProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoordenproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadoordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoOrdenProduParameterReturnGeneral procesarEventosEstadoOrdenProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoOrdenProdu> estadoordenprodus,EstadoOrdenProdu estadoordenprodu,EstadoOrdenProduParameterReturnGeneral estadoordenproduParameterGeneral,Boolean isEsNuevoEstadoOrdenProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-procesarEventosEstadoOrdenProdusWithConnection");connexion.begin();			
			
			EstadoOrdenProduParameterReturnGeneral estadoordenproduReturnGeneral=new EstadoOrdenProduParameterReturnGeneral();
	
			estadoordenproduReturnGeneral.setEstadoOrdenProdu(estadoordenprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoordenproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadoordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoOrdenProduParameterReturnGeneral procesarImportacionEstadoOrdenProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoOrdenProduParameterReturnGeneral estadoordenproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-procesarImportacionEstadoOrdenProdusWithConnection");connexion.begin();			
			
			EstadoOrdenProduParameterReturnGeneral estadoordenproduReturnGeneral=new EstadoOrdenProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoordenprodus=new ArrayList<EstadoOrdenProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoordenprodu=new EstadoOrdenProdu();
				
				
				if(conColumnasBase) {this.estadoordenprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoordenprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoordenprodu.setnombre(arrColumnas[iColumn++]);
				
				this.estadoordenprodus.add(this.estadoordenprodu);
			}
			
			this.saveEstadoOrdenProdus();
			
			this.connexion.commit();
			
			estadoordenproduReturnGeneral.setConRetornoEstaProcesado(true);
			estadoordenproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoordenproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoOrdenProdusEliminados() throws Exception {				
		
		List<EstadoOrdenProdu> estadoordenprodusAux= new ArrayList<EstadoOrdenProdu>();
		
		for(EstadoOrdenProdu estadoordenprodu:estadoordenprodus) {
			if(!estadoordenprodu.getIsDeleted()) {
				estadoordenprodusAux.add(estadoordenprodu);
			}
		}
		
		estadoordenprodus=estadoordenprodusAux;
	}
	
	public void quitarEstadoOrdenProdusNulos() throws Exception {				
		
		List<EstadoOrdenProdu> estadoordenprodusAux= new ArrayList<EstadoOrdenProdu>();
		
		for(EstadoOrdenProdu estadoordenprodu : this.estadoordenprodus) {
			if(estadoordenprodu==null) {
				estadoordenprodusAux.add(estadoordenprodu);
			}
		}
		
		//this.estadoordenprodus=estadoordenprodusAux;
		
		this.estadoordenprodus.removeAll(estadoordenprodusAux);
	}
	
	public void getSetVersionRowEstadoOrdenProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoordenprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoordenprodu.getIsDeleted() || (estadoordenprodu.getIsChanged()&&!estadoordenprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoordenproduDataAccess.getSetVersionRowEstadoOrdenProdu(connexion,estadoordenprodu.getId());
				
				if(!estadoordenprodu.getVersionRow().equals(timestamp)) {	
					estadoordenprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoordenprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoOrdenProdu()throws Exception {	
		
		if(estadoordenprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoordenprodu.getIsDeleted() || (estadoordenprodu.getIsChanged()&&!estadoordenprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoordenproduDataAccess.getSetVersionRowEstadoOrdenProdu(connexion,estadoordenprodu.getId());
			
			try {							
				if(!estadoordenprodu.getVersionRow().equals(timestamp)) {	
					estadoordenprodu.setVersionRow(timestamp);
				}
				
				estadoordenprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoOrdenProdusWithConnection()throws Exception {	
		if(estadoordenprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoOrdenProdu estadoordenproduAux:estadoordenprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoordenproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoordenproduAux.getIsDeleted() || (estadoordenproduAux.getIsChanged()&&!estadoordenproduAux.getIsNew())) {
						
						timestamp=estadoordenproduDataAccess.getSetVersionRowEstadoOrdenProdu(connexion,estadoordenproduAux.getId());
						
						if(!estadoordenprodu.getVersionRow().equals(timestamp)) {	
							estadoordenproduAux.setVersionRow(timestamp);
						}
								
						estadoordenproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoOrdenProdus()throws Exception {	
		if(estadoordenprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoOrdenProdu estadoordenproduAux:estadoordenprodus) {
					if(estadoordenproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoordenproduAux.getIsDeleted() || (estadoordenproduAux.getIsChanged()&&!estadoordenproduAux.getIsNew())) {
						
						timestamp=estadoordenproduDataAccess.getSetVersionRowEstadoOrdenProdu(connexion,estadoordenproduAux.getId());
						
						if(!estadoordenproduAux.getVersionRow().equals(timestamp)) {	
							estadoordenproduAux.setVersionRow(timestamp);
						}
						
													
						estadoordenproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoOrdenProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PedidoProduLogic pedidoproduLogic=new PedidoProduLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoOrdenProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoOrdenProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PedidoProdu.class));
											
			

			pedidoproduLogic.setConnexion(this.getConnexion());
			pedidoproduLogic.setDatosCliente(this.datosCliente);
			pedidoproduLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoOrdenProdu estadoordenprodu:this.estadoordenprodus) {
				

				classes=new ArrayList<Classe>();
				classes=PedidoProduConstantesFunciones.getClassesForeignKeysOfPedidoProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoproduLogic.setPedidoProdus(estadoordenprodu.pedidoprodus);
				pedidoproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoOrdenProdu estadoordenprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoOrdenProduLogicAdditional.updateEstadoOrdenProduToGet(estadoordenprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoordenprodu.setPedidoProdus(estadoordenproduDataAccess.getPedidoProdus(connexion,estadoordenprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoordenprodu.setPedidoProdus(estadoordenproduDataAccess.getPedidoProdus(connexion,estadoordenprodu));

				if(this.isConDeep) {
					PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(this.connexion);
					pedidoproduLogic.setPedidoProdus(estadoordenprodu.getPedidoProdus());
					ArrayList<Classe> classesLocal=PedidoProduConstantesFunciones.getClassesForeignKeysOfPedidoProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(pedidoproduLogic.getPedidoProdus());
					estadoordenprodu.setPedidoProdus(pedidoproduLogic.getPedidoProdus());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoProdu.class));
			estadoordenprodu.setPedidoProdus(estadoordenproduDataAccess.getPedidoProdus(connexion,estadoordenprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoordenprodu.setPedidoProdus(estadoordenproduDataAccess.getPedidoProdus(connexion,estadoordenprodu));

		for(PedidoProdu pedidoprodu:estadoordenprodu.getPedidoProdus()) {
			PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
			pedidoproduLogic.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoordenprodu.setPedidoProdus(estadoordenproduDataAccess.getPedidoProdus(connexion,estadoordenprodu));

				for(PedidoProdu pedidoprodu:estadoordenprodu.getPedidoProdus()) {
					PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
					pedidoproduLogic.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoProdu.class));
			estadoordenprodu.setPedidoProdus(estadoordenproduDataAccess.getPedidoProdus(connexion,estadoordenprodu));

			for(PedidoProdu pedidoprodu:estadoordenprodu.getPedidoProdus()) {
				PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
				pedidoproduLogic.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoOrdenProdu estadoordenprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoOrdenProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoordenprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(estadoordenprodu);
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
			this.deepLoad(this.estadoordenprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(this.estadoordenprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoOrdenProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoordenprodus!=null) {
				for(EstadoOrdenProdu estadoordenprodu:estadoordenprodus) {
					this.deepLoad(estadoordenprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(estadoordenprodus);
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
			if(estadoordenprodus!=null) {
				for(EstadoOrdenProdu estadoordenprodu:estadoordenprodus) {
					this.deepLoad(estadoordenprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoOrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesEstadoOrdenProdu(estadoordenprodus);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoOrdenProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoOrdenProdu estadoordenprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoOrdenProduConstantesFunciones.ISCONAUDITORIA) {
				if(estadoordenprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenProduDataAccess.TABLENAME, estadoordenprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoOrdenProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoOrdenProduLogic.registrarAuditoriaDetallesEstadoOrdenProdu(connexion,estadoordenprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoordenprodu.getIsDeleted()) {
					/*if(!estadoordenprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoOrdenProduDataAccess.TABLENAME, estadoordenprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoOrdenProduLogic.registrarAuditoriaDetallesEstadoOrdenProdu(connexion,estadoordenprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenProduDataAccess.TABLENAME, estadoordenprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoordenprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoOrdenProduDataAccess.TABLENAME, estadoordenprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoOrdenProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoOrdenProduLogic.registrarAuditoriaDetallesEstadoOrdenProdu(connexion,estadoordenprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoOrdenProdu(Connexion connexion,EstadoOrdenProdu estadoordenprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoordenprodu.getIsNew()||!estadoordenprodu.getnombre().equals(estadoordenprodu.getEstadoOrdenProduOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoordenprodu.getEstadoOrdenProduOriginal().getnombre()!=null)
				{
					strValorActual=estadoordenprodu.getEstadoOrdenProduOriginal().getnombre();
				}
				if(estadoordenprodu.getnombre()!=null)
				{
					strValorNuevo=estadoordenprodu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoOrdenProduConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoOrdenProduConstantesFunciones.getClassesForeignKeysOfEstadoOrdenProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoOrdenProduConstantesFunciones.getClassesRelationshipsOfEstadoOrdenProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
