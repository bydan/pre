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
import com.bydan.erp.inventario.util.BodegaSucursalConstantesFunciones;
import com.bydan.erp.inventario.util.BodegaSucursalParameterReturnGeneral;
//import com.bydan.erp.inventario.util.BodegaSucursalParameterGeneral;
import com.bydan.erp.inventario.business.entity.BodegaSucursal;
import com.bydan.erp.inventario.business.logic.BodegaSucursalLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class BodegaSucursalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BodegaSucursalLogic.class);
	
	protected BodegaSucursalDataAccess bodegasucursalDataAccess; 	
	protected BodegaSucursal bodegasucursal;
	protected List<BodegaSucursal> bodegasucursals;
	protected Object bodegasucursalObject;	
	protected List<Object> bodegasucursalsObject;
	
	public static ClassValidator<BodegaSucursal> bodegasucursalValidator = new ClassValidator<BodegaSucursal>(BodegaSucursal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BodegaSucursalLogicAdditional bodegasucursalLogicAdditional=null;
	
	public BodegaSucursalLogicAdditional getBodegaSucursalLogicAdditional() {
		return this.bodegasucursalLogicAdditional;
	}
	
	public void setBodegaSucursalLogicAdditional(BodegaSucursalLogicAdditional bodegasucursalLogicAdditional) {
		try {
			this.bodegasucursalLogicAdditional=bodegasucursalLogicAdditional;
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
	
	
	
	
	public  BodegaSucursalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.bodegasucursalDataAccess = new BodegaSucursalDataAccess();
			
			this.bodegasucursals= new ArrayList<BodegaSucursal>();
			this.bodegasucursal= new BodegaSucursal();
			
			this.bodegasucursalObject=new Object();
			this.bodegasucursalsObject=new ArrayList<Object>();
				
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
			
			this.bodegasucursalDataAccess.setConnexionType(this.connexionType);
			this.bodegasucursalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BodegaSucursalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.bodegasucursalDataAccess = new BodegaSucursalDataAccess();
			this.bodegasucursals= new ArrayList<BodegaSucursal>();
			this.bodegasucursal= new BodegaSucursal();
			this.bodegasucursalObject=new Object();
			this.bodegasucursalsObject=new ArrayList<Object>();
			
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
			
			this.bodegasucursalDataAccess.setConnexionType(this.connexionType);
			this.bodegasucursalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BodegaSucursal getBodegaSucursal() throws Exception {	
		BodegaSucursalLogicAdditional.checkBodegaSucursalToGet(bodegasucursal,this.datosCliente,this.arrDatoGeneral);
		BodegaSucursalLogicAdditional.updateBodegaSucursalToGet(bodegasucursal,this.arrDatoGeneral);
		
		return bodegasucursal;
	}
		
	public void setBodegaSucursal(BodegaSucursal newBodegaSucursal) {
		this.bodegasucursal = newBodegaSucursal;
	}
	
	public BodegaSucursalDataAccess getBodegaSucursalDataAccess() {
		return bodegasucursalDataAccess;
	}
	
	public void setBodegaSucursalDataAccess(BodegaSucursalDataAccess newbodegasucursalDataAccess) {
		this.bodegasucursalDataAccess = newbodegasucursalDataAccess;
	}
	
	public List<BodegaSucursal> getBodegaSucursals() throws Exception {		
		this.quitarBodegaSucursalsNulos();
		
		BodegaSucursalLogicAdditional.checkBodegaSucursalToGets(bodegasucursals,this.datosCliente,this.arrDatoGeneral);
		
		for (BodegaSucursal bodegasucursalLocal: bodegasucursals ) {
			BodegaSucursalLogicAdditional.updateBodegaSucursalToGet(bodegasucursalLocal,this.arrDatoGeneral);
		}
		
		return bodegasucursals;
	}
	
	public void setBodegaSucursals(List<BodegaSucursal> newBodegaSucursals) {
		this.bodegasucursals = newBodegaSucursals;
	}
	
	public Object getBodegaSucursalObject() {	
		this.bodegasucursalObject=this.bodegasucursalDataAccess.getEntityObject();
		return this.bodegasucursalObject;
	}
		
	public void setBodegaSucursalObject(Object newBodegaSucursalObject) {
		this.bodegasucursalObject = newBodegaSucursalObject;
	}
	
	public List<Object> getBodegaSucursalsObject() {		
		this.bodegasucursalsObject=this.bodegasucursalDataAccess.getEntitiesObject();
		return this.bodegasucursalsObject;
	}
		
	public void setBodegaSucursalsObject(List<Object> newBodegaSucursalsObject) {
		this.bodegasucursalsObject = newBodegaSucursalsObject;
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
		
		if(this.bodegasucursalDataAccess!=null) {
			this.bodegasucursalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			bodegasucursalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			bodegasucursalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		bodegasucursal = new  BodegaSucursal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
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
		bodegasucursal = new  BodegaSucursal();
		  		  
        try {
			
			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		bodegasucursal = new  BodegaSucursal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
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
		bodegasucursal = new  BodegaSucursal();
		  		  
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
		bodegasucursal = new  BodegaSucursal();
		  		  
        try {
			
			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		bodegasucursal = new  BodegaSucursal();
		  		  
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
		bodegasucursal = new  BodegaSucursal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =bodegasucursalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodegasucursal = new  BodegaSucursal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=bodegasucursalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bodegasucursal = new  BodegaSucursal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =bodegasucursalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodegasucursal = new  BodegaSucursal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=bodegasucursalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bodegasucursal = new  BodegaSucursal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =bodegasucursalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bodegasucursal = new  BodegaSucursal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=bodegasucursalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
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
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
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
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
        try {			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
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
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
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
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
        try {
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
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
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
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
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		bodegasucursal = new  BodegaSucursal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
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
		bodegasucursal = new  BodegaSucursal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
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
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		  		  
        try {
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBodegaSucursalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getTodosBodegaSucursalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
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
	
	public  void  getTodosBodegaSucursals(String sFinalQuery,Pagination pagination)throws Exception {
		bodegasucursals = new  ArrayList<BodegaSucursal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBodegaSucursal(bodegasucursals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBodegaSucursal(BodegaSucursal bodegasucursal) throws Exception {
		Boolean estaValidado=false;
		
		if(bodegasucursal.getIsNew() || bodegasucursal.getIsChanged()) { 
			this.invalidValues = bodegasucursalValidator.getInvalidValues(bodegasucursal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(bodegasucursal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBodegaSucursal(List<BodegaSucursal> BodegaSucursals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(BodegaSucursal bodegasucursalLocal:bodegasucursals) {				
			estaValidadoObjeto=this.validarGuardarBodegaSucursal(bodegasucursalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBodegaSucursal(List<BodegaSucursal> BodegaSucursals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBodegaSucursal(bodegasucursals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBodegaSucursal(BodegaSucursal BodegaSucursal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBodegaSucursal(bodegasucursal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(BodegaSucursal bodegasucursal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+bodegasucursal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BodegaSucursalConstantesFunciones.getBodegaSucursalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"bodegasucursal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BodegaSucursalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BodegaSucursalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBodegaSucursalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-saveBodegaSucursalWithConnection");connexion.begin();			
			
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSave(this.bodegasucursal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BodegaSucursalLogicAdditional.updateBodegaSucursalToSave(this.bodegasucursal,this.arrDatoGeneral);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bodegasucursal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBodegaSucursal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBodegaSucursal(this.bodegasucursal)) {
				BodegaSucursalDataAccess.save(this.bodegasucursal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSaveAfter(this.bodegasucursal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBodegaSucursal();
			
			connexion.commit();			
			
			if(this.bodegasucursal.getIsDeleted()) {
				this.bodegasucursal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBodegaSucursal()throws Exception {	
		try {	
			
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSave(this.bodegasucursal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BodegaSucursalLogicAdditional.updateBodegaSucursalToSave(this.bodegasucursal,this.arrDatoGeneral);
			
			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bodegasucursal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBodegaSucursal(this.bodegasucursal)) {			
				BodegaSucursalDataAccess.save(this.bodegasucursal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSaveAfter(this.bodegasucursal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.bodegasucursal.getIsDeleted()) {
				this.bodegasucursal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBodegaSucursalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-saveBodegaSucursalsWithConnection");connexion.begin();			
			
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSaves(bodegasucursals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBodegaSucursals();
			
			Boolean validadoTodosBodegaSucursal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BodegaSucursal bodegasucursalLocal:bodegasucursals) {		
				if(bodegasucursalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BodegaSucursalLogicAdditional.updateBodegaSucursalToSave(bodegasucursalLocal,this.arrDatoGeneral);
	        	
				BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bodegasucursalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBodegaSucursal(bodegasucursalLocal)) {
					BodegaSucursalDataAccess.save(bodegasucursalLocal, connexion);				
				} else {
					validadoTodosBodegaSucursal=false;
				}
			}
			
			if(!validadoTodosBodegaSucursal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSavesAfter(bodegasucursals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBodegaSucursals();
			
			connexion.commit();		
			
			this.quitarBodegaSucursalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBodegaSucursals()throws Exception {				
		 try {	
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSaves(bodegasucursals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBodegaSucursal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BodegaSucursal bodegasucursalLocal:bodegasucursals) {				
				if(bodegasucursalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BodegaSucursalLogicAdditional.updateBodegaSucursalToSave(bodegasucursalLocal,this.arrDatoGeneral);
	        	
				BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bodegasucursalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBodegaSucursal(bodegasucursalLocal)) {				
					BodegaSucursalDataAccess.save(bodegasucursalLocal, connexion);				
				} else {
					validadoTodosBodegaSucursal=false;
				}
			}
			
			if(!validadoTodosBodegaSucursal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BodegaSucursalLogicAdditional.checkBodegaSucursalToSavesAfter(bodegasucursals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBodegaSucursalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BodegaSucursalParameterReturnGeneral procesarAccionBodegaSucursals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BodegaSucursal> bodegasucursals,BodegaSucursalParameterReturnGeneral bodegasucursalParameterGeneral)throws Exception {
		 try {	
			BodegaSucursalParameterReturnGeneral bodegasucursalReturnGeneral=new BodegaSucursalParameterReturnGeneral();
	
			BodegaSucursalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bodegasucursals,bodegasucursalParameterGeneral,bodegasucursalReturnGeneral);
			
			return bodegasucursalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BodegaSucursalParameterReturnGeneral procesarAccionBodegaSucursalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BodegaSucursal> bodegasucursals,BodegaSucursalParameterReturnGeneral bodegasucursalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-procesarAccionBodegaSucursalsWithConnection");connexion.begin();			
			
			BodegaSucursalParameterReturnGeneral bodegasucursalReturnGeneral=new BodegaSucursalParameterReturnGeneral();
	
			BodegaSucursalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bodegasucursals,bodegasucursalParameterGeneral,bodegasucursalReturnGeneral);
			
			this.connexion.commit();
			
			return bodegasucursalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BodegaSucursalParameterReturnGeneral procesarEventosBodegaSucursals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BodegaSucursal> bodegasucursals,BodegaSucursal bodegasucursal,BodegaSucursalParameterReturnGeneral bodegasucursalParameterGeneral,Boolean isEsNuevoBodegaSucursal,ArrayList<Classe> clases)throws Exception {
		 try {	
			BodegaSucursalParameterReturnGeneral bodegasucursalReturnGeneral=new BodegaSucursalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bodegasucursalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BodegaSucursalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bodegasucursals,bodegasucursal,bodegasucursalParameterGeneral,bodegasucursalReturnGeneral,isEsNuevoBodegaSucursal,clases);
			
			return bodegasucursalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BodegaSucursalParameterReturnGeneral procesarEventosBodegaSucursalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BodegaSucursal> bodegasucursals,BodegaSucursal bodegasucursal,BodegaSucursalParameterReturnGeneral bodegasucursalParameterGeneral,Boolean isEsNuevoBodegaSucursal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-procesarEventosBodegaSucursalsWithConnection");connexion.begin();			
			
			BodegaSucursalParameterReturnGeneral bodegasucursalReturnGeneral=new BodegaSucursalParameterReturnGeneral();
	
			bodegasucursalReturnGeneral.setBodegaSucursal(bodegasucursal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bodegasucursalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BodegaSucursalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bodegasucursals,bodegasucursal,bodegasucursalParameterGeneral,bodegasucursalReturnGeneral,isEsNuevoBodegaSucursal,clases);
			
			this.connexion.commit();
			
			return bodegasucursalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BodegaSucursalParameterReturnGeneral procesarImportacionBodegaSucursalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BodegaSucursalParameterReturnGeneral bodegasucursalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-procesarImportacionBodegaSucursalsWithConnection");connexion.begin();			
			
			BodegaSucursalParameterReturnGeneral bodegasucursalReturnGeneral=new BodegaSucursalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.bodegasucursals=new ArrayList<BodegaSucursal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.bodegasucursal=new BodegaSucursal();
				
				
				if(conColumnasBase) {this.bodegasucursal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.bodegasucursal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.bodegasucursal.setsecuencia(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegasucursal.settamanio(Integer.parseInt(arrColumnas[iColumn++]));
				this.bodegasucursal.setdescripcion(arrColumnas[iColumn++]);
				
				this.bodegasucursals.add(this.bodegasucursal);
			}
			
			this.saveBodegaSucursals();
			
			this.connexion.commit();
			
			bodegasucursalReturnGeneral.setConRetornoEstaProcesado(true);
			bodegasucursalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return bodegasucursalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBodegaSucursalsEliminados() throws Exception {				
		
		List<BodegaSucursal> bodegasucursalsAux= new ArrayList<BodegaSucursal>();
		
		for(BodegaSucursal bodegasucursal:bodegasucursals) {
			if(!bodegasucursal.getIsDeleted()) {
				bodegasucursalsAux.add(bodegasucursal);
			}
		}
		
		bodegasucursals=bodegasucursalsAux;
	}
	
	public void quitarBodegaSucursalsNulos() throws Exception {				
		
		List<BodegaSucursal> bodegasucursalsAux= new ArrayList<BodegaSucursal>();
		
		for(BodegaSucursal bodegasucursal : this.bodegasucursals) {
			if(bodegasucursal==null) {
				bodegasucursalsAux.add(bodegasucursal);
			}
		}
		
		//this.bodegasucursals=bodegasucursalsAux;
		
		this.bodegasucursals.removeAll(bodegasucursalsAux);
	}
	
	public void getSetVersionRowBodegaSucursalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(bodegasucursal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((bodegasucursal.getIsDeleted() || (bodegasucursal.getIsChanged()&&!bodegasucursal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=bodegasucursalDataAccess.getSetVersionRowBodegaSucursal(connexion,bodegasucursal.getId());
				
				if(!bodegasucursal.getVersionRow().equals(timestamp)) {	
					bodegasucursal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				bodegasucursal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBodegaSucursal()throws Exception {	
		
		if(bodegasucursal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((bodegasucursal.getIsDeleted() || (bodegasucursal.getIsChanged()&&!bodegasucursal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=bodegasucursalDataAccess.getSetVersionRowBodegaSucursal(connexion,bodegasucursal.getId());
			
			try {							
				if(!bodegasucursal.getVersionRow().equals(timestamp)) {	
					bodegasucursal.setVersionRow(timestamp);
				}
				
				bodegasucursal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBodegaSucursalsWithConnection()throws Exception {	
		if(bodegasucursals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(BodegaSucursal bodegasucursalAux:bodegasucursals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(bodegasucursalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bodegasucursalAux.getIsDeleted() || (bodegasucursalAux.getIsChanged()&&!bodegasucursalAux.getIsNew())) {
						
						timestamp=bodegasucursalDataAccess.getSetVersionRowBodegaSucursal(connexion,bodegasucursalAux.getId());
						
						if(!bodegasucursal.getVersionRow().equals(timestamp)) {	
							bodegasucursalAux.setVersionRow(timestamp);
						}
								
						bodegasucursalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBodegaSucursals()throws Exception {	
		if(bodegasucursals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(BodegaSucursal bodegasucursalAux:bodegasucursals) {
					if(bodegasucursalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bodegasucursalAux.getIsDeleted() || (bodegasucursalAux.getIsChanged()&&!bodegasucursalAux.getIsNew())) {
						
						timestamp=bodegasucursalDataAccess.getSetVersionRowBodegaSucursal(connexion,bodegasucursalAux.getId());
						
						if(!bodegasucursalAux.getVersionRow().equals(timestamp)) {	
							bodegasucursalAux.setVersionRow(timestamp);
						}
						
													
						bodegasucursalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BodegaSucursalParameterReturnGeneral cargarCombosLoteForeignKeyBodegaSucursalWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega) throws Exception {
		BodegaSucursalParameterReturnGeneral  bodegasucursalReturnGeneral =new BodegaSucursalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-cargarCombosLoteForeignKeyBodegaSucursalWithConnection");connexion.begin();
			
			bodegasucursalReturnGeneral =new BodegaSucursalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bodegasucursalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bodegasucursalReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			bodegasucursalReturnGeneral.setbodegasForeignKey(bodegasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return bodegasucursalReturnGeneral;
	}
	
	public BodegaSucursalParameterReturnGeneral cargarCombosLoteForeignKeyBodegaSucursal(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega) throws Exception {
		BodegaSucursalParameterReturnGeneral  bodegasucursalReturnGeneral =new BodegaSucursalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			bodegasucursalReturnGeneral =new BodegaSucursalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bodegasucursalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bodegasucursalReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			bodegasucursalReturnGeneral.setbodegasForeignKey(bodegasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return bodegasucursalReturnGeneral;
	}
	
	
	public void deepLoad(BodegaSucursal bodegasucursal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BodegaSucursalLogicAdditional.updateBodegaSucursalToGet(bodegasucursal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bodegasucursal.setEmpresa(bodegasucursalDataAccess.getEmpresa(connexion,bodegasucursal));
		bodegasucursal.setSucursal(bodegasucursalDataAccess.getSucursal(connexion,bodegasucursal));
		bodegasucursal.setBodega(bodegasucursalDataAccess.getBodega(connexion,bodegasucursal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bodegasucursal.setEmpresa(bodegasucursalDataAccess.getEmpresa(connexion,bodegasucursal));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				bodegasucursal.setSucursal(bodegasucursalDataAccess.getSucursal(connexion,bodegasucursal));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				bodegasucursal.setBodega(bodegasucursalDataAccess.getBodega(connexion,bodegasucursal));
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
			bodegasucursal.setEmpresa(bodegasucursalDataAccess.getEmpresa(connexion,bodegasucursal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegasucursal.setSucursal(bodegasucursalDataAccess.getSucursal(connexion,bodegasucursal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegasucursal.setBodega(bodegasucursalDataAccess.getBodega(connexion,bodegasucursal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bodegasucursal.setEmpresa(bodegasucursalDataAccess.getEmpresa(connexion,bodegasucursal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bodegasucursal.getEmpresa(),isDeep,deepLoadType,clases);
				
		bodegasucursal.setSucursal(bodegasucursalDataAccess.getSucursal(connexion,bodegasucursal));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(bodegasucursal.getSucursal(),isDeep,deepLoadType,clases);
				
		bodegasucursal.setBodega(bodegasucursalDataAccess.getBodega(connexion,bodegasucursal));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(bodegasucursal.getBodega(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bodegasucursal.setEmpresa(bodegasucursalDataAccess.getEmpresa(connexion,bodegasucursal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(bodegasucursal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				bodegasucursal.setSucursal(bodegasucursalDataAccess.getSucursal(connexion,bodegasucursal));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(bodegasucursal.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				bodegasucursal.setBodega(bodegasucursalDataAccess.getBodega(connexion,bodegasucursal));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(bodegasucursal.getBodega(),isDeep,deepLoadType,clases);				
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
			bodegasucursal.setEmpresa(bodegasucursalDataAccess.getEmpresa(connexion,bodegasucursal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(bodegasucursal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegasucursal.setSucursal(bodegasucursalDataAccess.getSucursal(connexion,bodegasucursal));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(bodegasucursal.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bodegasucursal.setBodega(bodegasucursalDataAccess.getBodega(connexion,bodegasucursal));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(bodegasucursal.getBodega(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(BodegaSucursal bodegasucursal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BodegaSucursalLogicAdditional.updateBodegaSucursalToSave(bodegasucursal,this.arrDatoGeneral);
			
BodegaSucursalDataAccess.save(bodegasucursal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bodegasucursal.getEmpresa(),connexion);

		SucursalDataAccess.save(bodegasucursal.getSucursal(),connexion);

		BodegaDataAccess.save(bodegasucursal.getBodega(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bodegasucursal.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(bodegasucursal.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(bodegasucursal.getBodega(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bodegasucursal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bodegasucursal.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(bodegasucursal.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(bodegasucursal.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(bodegasucursal.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(bodegasucursal.getBodega(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bodegasucursal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(bodegasucursal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(bodegasucursal.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(bodegasucursal.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(bodegasucursal.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(bodegasucursal.getBodega(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(BodegaSucursal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(bodegasucursal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(bodegasucursal);
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
			this.deepLoad(this.bodegasucursal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(BodegaSucursal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(bodegasucursals!=null) {
				for(BodegaSucursal bodegasucursal:bodegasucursals) {
					this.deepLoad(bodegasucursal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(bodegasucursals);
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
			if(bodegasucursals!=null) {
				for(BodegaSucursal bodegasucursal:bodegasucursals) {
					this.deepLoad(bodegasucursal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(bodegasucursals);
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
			this.getNewConnexionToDeep(BodegaSucursal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(bodegasucursal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(BodegaSucursal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(bodegasucursals!=null) {
				for(BodegaSucursal bodegasucursal:bodegasucursals) {
					this.deepSave(bodegasucursal,isDeep,deepLoadType,clases);
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
			if(bodegasucursals!=null) {
				for(BodegaSucursal bodegasucursal:bodegasucursals) {
					this.deepSave(bodegasucursal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBodegaSucursalsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaSucursalConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaSucursalsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaSucursalConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaSucursalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaSucursalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaSucursalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaSucursalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaSucursalsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BodegaSucursalConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaSucursalsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BodegaSucursalConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BodegaSucursalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bodegasucursals=bodegasucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBodegaSucursalPorIdEmpresaPorIdSucursalPorIdBodegaWithConnection(Long id_empresa,Long id_sucursal,Long id_bodega)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BodegaSucursal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaSucursalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BodegaSucursalConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaSucursalConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBodegaSucursalPorIdEmpresaPorIdSucursalPorIdBodega(Long id_empresa,Long id_sucursal,Long id_bodega)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BodegaSucursalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BodegaSucursalConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,BodegaSucursalConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			bodegasucursal=bodegasucursalDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.bodegasucursal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				BodegaSucursalConstantesFunciones.refrescarForeignKeysDescripcionesBodegaSucursal(this.bodegasucursal);
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
			if(BodegaSucursalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaSucursalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,BodegaSucursal bodegasucursal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BodegaSucursalConstantesFunciones.ISCONAUDITORIA) {
				if(bodegasucursal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaSucursalDataAccess.TABLENAME, bodegasucursal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BodegaSucursalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BodegaSucursalLogic.registrarAuditoriaDetallesBodegaSucursal(connexion,bodegasucursal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(bodegasucursal.getIsDeleted()) {
					/*if(!bodegasucursal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BodegaSucursalDataAccess.TABLENAME, bodegasucursal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BodegaSucursalLogic.registrarAuditoriaDetallesBodegaSucursal(connexion,bodegasucursal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaSucursalDataAccess.TABLENAME, bodegasucursal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(bodegasucursal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BodegaSucursalDataAccess.TABLENAME, bodegasucursal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BodegaSucursalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BodegaSucursalLogic.registrarAuditoriaDetallesBodegaSucursal(connexion,bodegasucursal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBodegaSucursal(Connexion connexion,BodegaSucursal bodegasucursal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(bodegasucursal.getIsNew()||!bodegasucursal.getid_empresa().equals(bodegasucursal.getBodegaSucursalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegasucursal.getBodegaSucursalOriginal().getid_empresa()!=null)
				{
					strValorActual=bodegasucursal.getBodegaSucursalOriginal().getid_empresa().toString();
				}
				if(bodegasucursal.getid_empresa()!=null)
				{
					strValorNuevo=bodegasucursal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaSucursalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(bodegasucursal.getIsNew()||!bodegasucursal.getid_sucursal().equals(bodegasucursal.getBodegaSucursalOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegasucursal.getBodegaSucursalOriginal().getid_sucursal()!=null)
				{
					strValorActual=bodegasucursal.getBodegaSucursalOriginal().getid_sucursal().toString();
				}
				if(bodegasucursal.getid_sucursal()!=null)
				{
					strValorNuevo=bodegasucursal.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaSucursalConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(bodegasucursal.getIsNew()||!bodegasucursal.getid_bodega().equals(bodegasucursal.getBodegaSucursalOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegasucursal.getBodegaSucursalOriginal().getid_bodega()!=null)
				{
					strValorActual=bodegasucursal.getBodegaSucursalOriginal().getid_bodega().toString();
				}
				if(bodegasucursal.getid_bodega()!=null)
				{
					strValorNuevo=bodegasucursal.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaSucursalConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(bodegasucursal.getIsNew()||!bodegasucursal.getsecuencia().equals(bodegasucursal.getBodegaSucursalOriginal().getsecuencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegasucursal.getBodegaSucursalOriginal().getsecuencia()!=null)
				{
					strValorActual=bodegasucursal.getBodegaSucursalOriginal().getsecuencia().toString();
				}
				if(bodegasucursal.getsecuencia()!=null)
				{
					strValorNuevo=bodegasucursal.getsecuencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaSucursalConstantesFunciones.SECUENCIA,strValorActual,strValorNuevo);
			}	
			
			if(bodegasucursal.getIsNew()||!bodegasucursal.gettamanio().equals(bodegasucursal.getBodegaSucursalOriginal().gettamanio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegasucursal.getBodegaSucursalOriginal().gettamanio()!=null)
				{
					strValorActual=bodegasucursal.getBodegaSucursalOriginal().gettamanio().toString();
				}
				if(bodegasucursal.gettamanio()!=null)
				{
					strValorNuevo=bodegasucursal.gettamanio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaSucursalConstantesFunciones.TAMANIO,strValorActual,strValorNuevo);
			}	
			
			if(bodegasucursal.getIsNew()||!bodegasucursal.getdescripcion().equals(bodegasucursal.getBodegaSucursalOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bodegasucursal.getBodegaSucursalOriginal().getdescripcion()!=null)
				{
					strValorActual=bodegasucursal.getBodegaSucursalOriginal().getdescripcion();
				}
				if(bodegasucursal.getdescripcion()!=null)
				{
					strValorNuevo=bodegasucursal.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BodegaSucursalConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBodegaSucursalRelacionesWithConnection(BodegaSucursal bodegasucursal) throws Exception {

		if(!bodegasucursal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBodegaSucursalRelacionesBase(bodegasucursal,true);
		}
	}

	public void saveBodegaSucursalRelaciones(BodegaSucursal bodegasucursal)throws Exception {

		if(!bodegasucursal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBodegaSucursalRelacionesBase(bodegasucursal,false);
		}
	}

	public void saveBodegaSucursalRelacionesBase(BodegaSucursal bodegasucursal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("BodegaSucursal-saveRelacionesWithConnection");}
	

			this.setBodegaSucursal(bodegasucursal);

			if(BodegaSucursalLogicAdditional.validarSaveRelaciones(bodegasucursal,this)) {

				BodegaSucursalLogicAdditional.updateRelacionesToSave(bodegasucursal,this);

				if((bodegasucursal.getIsNew()||bodegasucursal.getIsChanged())&&!bodegasucursal.getIsDeleted()) {
					this.saveBodegaSucursal();
					this.saveBodegaSucursalRelacionesDetalles();

				} else if(bodegasucursal.getIsDeleted()) {
					this.saveBodegaSucursalRelacionesDetalles();
					this.saveBodegaSucursal();
				}

				BodegaSucursalLogicAdditional.updateRelacionesToSaveAfter(bodegasucursal,this);

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
	
	
	private void saveBodegaSucursalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBodegaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BodegaSucursalConstantesFunciones.getClassesForeignKeysOfBodegaSucursal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodegaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BodegaSucursalConstantesFunciones.getClassesRelationshipsOfBodegaSucursal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
