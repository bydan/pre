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
import com.bydan.erp.inventario.util.PresupuestoLineaConstantesFunciones;
import com.bydan.erp.inventario.util.PresupuestoLineaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PresupuestoLineaParameterGeneral;
import com.bydan.erp.inventario.business.entity.PresupuestoLinea;
import com.bydan.erp.inventario.business.logic.PresupuestoLineaLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PresupuestoLineaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresupuestoLineaLogic.class);
	
	protected PresupuestoLineaDataAccess presupuestolineaDataAccess; 	
	protected PresupuestoLinea presupuestolinea;
	protected List<PresupuestoLinea> presupuestolineas;
	protected Object presupuestolineaObject;	
	protected List<Object> presupuestolineasObject;
	
	public static ClassValidator<PresupuestoLinea> presupuestolineaValidator = new ClassValidator<PresupuestoLinea>(PresupuestoLinea.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresupuestoLineaLogicAdditional presupuestolineaLogicAdditional=null;
	
	public PresupuestoLineaLogicAdditional getPresupuestoLineaLogicAdditional() {
		return this.presupuestolineaLogicAdditional;
	}
	
	public void setPresupuestoLineaLogicAdditional(PresupuestoLineaLogicAdditional presupuestolineaLogicAdditional) {
		try {
			this.presupuestolineaLogicAdditional=presupuestolineaLogicAdditional;
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
	
	
	
	
	public  PresupuestoLineaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presupuestolineaDataAccess = new PresupuestoLineaDataAccess();
			
			this.presupuestolineas= new ArrayList<PresupuestoLinea>();
			this.presupuestolinea= new PresupuestoLinea();
			
			this.presupuestolineaObject=new Object();
			this.presupuestolineasObject=new ArrayList<Object>();
				
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
			
			this.presupuestolineaDataAccess.setConnexionType(this.connexionType);
			this.presupuestolineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresupuestoLineaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presupuestolineaDataAccess = new PresupuestoLineaDataAccess();
			this.presupuestolineas= new ArrayList<PresupuestoLinea>();
			this.presupuestolinea= new PresupuestoLinea();
			this.presupuestolineaObject=new Object();
			this.presupuestolineasObject=new ArrayList<Object>();
			
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
			
			this.presupuestolineaDataAccess.setConnexionType(this.connexionType);
			this.presupuestolineaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresupuestoLinea getPresupuestoLinea() throws Exception {	
		PresupuestoLineaLogicAdditional.checkPresupuestoLineaToGet(presupuestolinea,this.datosCliente,this.arrDatoGeneral);
		PresupuestoLineaLogicAdditional.updatePresupuestoLineaToGet(presupuestolinea,this.arrDatoGeneral);
		
		return presupuestolinea;
	}
		
	public void setPresupuestoLinea(PresupuestoLinea newPresupuestoLinea) {
		this.presupuestolinea = newPresupuestoLinea;
	}
	
	public PresupuestoLineaDataAccess getPresupuestoLineaDataAccess() {
		return presupuestolineaDataAccess;
	}
	
	public void setPresupuestoLineaDataAccess(PresupuestoLineaDataAccess newpresupuestolineaDataAccess) {
		this.presupuestolineaDataAccess = newpresupuestolineaDataAccess;
	}
	
	public List<PresupuestoLinea> getPresupuestoLineas() throws Exception {		
		this.quitarPresupuestoLineasNulos();
		
		PresupuestoLineaLogicAdditional.checkPresupuestoLineaToGets(presupuestolineas,this.datosCliente,this.arrDatoGeneral);
		
		for (PresupuestoLinea presupuestolineaLocal: presupuestolineas ) {
			PresupuestoLineaLogicAdditional.updatePresupuestoLineaToGet(presupuestolineaLocal,this.arrDatoGeneral);
		}
		
		return presupuestolineas;
	}
	
	public void setPresupuestoLineas(List<PresupuestoLinea> newPresupuestoLineas) {
		this.presupuestolineas = newPresupuestoLineas;
	}
	
	public Object getPresupuestoLineaObject() {	
		this.presupuestolineaObject=this.presupuestolineaDataAccess.getEntityObject();
		return this.presupuestolineaObject;
	}
		
	public void setPresupuestoLineaObject(Object newPresupuestoLineaObject) {
		this.presupuestolineaObject = newPresupuestoLineaObject;
	}
	
	public List<Object> getPresupuestoLineasObject() {		
		this.presupuestolineasObject=this.presupuestolineaDataAccess.getEntitiesObject();
		return this.presupuestolineasObject;
	}
		
	public void setPresupuestoLineasObject(List<Object> newPresupuestoLineasObject) {
		this.presupuestolineasObject = newPresupuestoLineasObject;
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
		
		if(this.presupuestolineaDataAccess!=null) {
			this.presupuestolineaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presupuestolineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presupuestolineaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presupuestolinea = new  PresupuestoLinea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestolinea=presupuestolineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestolinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolinea);
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
		presupuestolinea = new  PresupuestoLinea();
		  		  
        try {
			
			presupuestolinea=presupuestolineaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestolinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presupuestolinea = new  PresupuestoLinea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestolinea=presupuestolineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestolinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolinea);
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
		presupuestolinea = new  PresupuestoLinea();
		  		  
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
		presupuestolinea = new  PresupuestoLinea();
		  		  
        try {
			
			presupuestolinea=presupuestolineaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestolinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presupuestolinea = new  PresupuestoLinea();
		  		  
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
		presupuestolinea = new  PresupuestoLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presupuestolineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestolinea = new  PresupuestoLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presupuestolineaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestolinea = new  PresupuestoLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presupuestolineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestolinea = new  PresupuestoLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presupuestolineaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestolinea = new  PresupuestoLinea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presupuestolineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestolinea = new  PresupuestoLinea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presupuestolineaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
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
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
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
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
        try {			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
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
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
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
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
        try {
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
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
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
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
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presupuestolinea = new  PresupuestoLinea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolinea=presupuestolineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolinea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolinea);
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
		presupuestolinea = new  PresupuestoLinea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolinea=presupuestolineaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolinea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
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
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		  		  
        try {
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresupuestoLineasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getTodosPresupuestoLineasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
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
	
	public  void  getTodosPresupuestoLineas(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestolineas = new  ArrayList<PresupuestoLinea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoLinea(presupuestolineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresupuestoLinea(PresupuestoLinea presupuestolinea) throws Exception {
		Boolean estaValidado=false;
		
		if(presupuestolinea.getIsNew() || presupuestolinea.getIsChanged()) { 
			this.invalidValues = presupuestolineaValidator.getInvalidValues(presupuestolinea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presupuestolinea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresupuestoLinea(List<PresupuestoLinea> PresupuestoLineas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresupuestoLinea presupuestolineaLocal:presupuestolineas) {				
			estaValidadoObjeto=this.validarGuardarPresupuestoLinea(presupuestolineaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresupuestoLinea(List<PresupuestoLinea> PresupuestoLineas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoLinea(presupuestolineas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresupuestoLinea(PresupuestoLinea PresupuestoLinea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoLinea(presupuestolinea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresupuestoLinea presupuestolinea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presupuestolinea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresupuestoLineaConstantesFunciones.getPresupuestoLineaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presupuestolinea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresupuestoLineaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresupuestoLineaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresupuestoLineaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-savePresupuestoLineaWithConnection");connexion.begin();			
			
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSave(this.presupuestolinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoLineaLogicAdditional.updatePresupuestoLineaToSave(this.presupuestolinea,this.arrDatoGeneral);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestolinea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoLinea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoLinea(this.presupuestolinea)) {
				PresupuestoLineaDataAccess.save(this.presupuestolinea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presupuestolinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSaveAfter(this.presupuestolinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoLinea();
			
			connexion.commit();			
			
			if(this.presupuestolinea.getIsDeleted()) {
				this.presupuestolinea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresupuestoLinea()throws Exception {	
		try {	
			
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSave(this.presupuestolinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoLineaLogicAdditional.updatePresupuestoLineaToSave(this.presupuestolinea,this.arrDatoGeneral);
			
			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestolinea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoLinea(this.presupuestolinea)) {			
				PresupuestoLineaDataAccess.save(this.presupuestolinea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presupuestolinea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSaveAfter(this.presupuestolinea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presupuestolinea.getIsDeleted()) {
				this.presupuestolinea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresupuestoLineasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-savePresupuestoLineasWithConnection");connexion.begin();			
			
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSaves(presupuestolineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoLineas();
			
			Boolean validadoTodosPresupuestoLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoLinea presupuestolineaLocal:presupuestolineas) {		
				if(presupuestolineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoLineaLogicAdditional.updatePresupuestoLineaToSave(presupuestolineaLocal,this.arrDatoGeneral);
	        	
				PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestolineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoLinea(presupuestolineaLocal)) {
					PresupuestoLineaDataAccess.save(presupuestolineaLocal, connexion);				
				} else {
					validadoTodosPresupuestoLinea=false;
				}
			}
			
			if(!validadoTodosPresupuestoLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSavesAfter(presupuestolineas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoLineas();
			
			connexion.commit();		
			
			this.quitarPresupuestoLineasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresupuestoLineas()throws Exception {				
		 try {	
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSaves(presupuestolineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresupuestoLinea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoLinea presupuestolineaLocal:presupuestolineas) {				
				if(presupuestolineaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoLineaLogicAdditional.updatePresupuestoLineaToSave(presupuestolineaLocal,this.arrDatoGeneral);
	        	
				PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestolineaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoLinea(presupuestolineaLocal)) {				
					PresupuestoLineaDataAccess.save(presupuestolineaLocal, connexion);				
				} else {
					validadoTodosPresupuestoLinea=false;
				}
			}
			
			if(!validadoTodosPresupuestoLinea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoLineaLogicAdditional.checkPresupuestoLineaToSavesAfter(presupuestolineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresupuestoLineasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoLineaParameterReturnGeneral procesarAccionPresupuestoLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoLinea> presupuestolineas,PresupuestoLineaParameterReturnGeneral presupuestolineaParameterGeneral)throws Exception {
		 try {	
			PresupuestoLineaParameterReturnGeneral presupuestolineaReturnGeneral=new PresupuestoLineaParameterReturnGeneral();
	
			PresupuestoLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestolineas,presupuestolineaParameterGeneral,presupuestolineaReturnGeneral);
			
			return presupuestolineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoLineaParameterReturnGeneral procesarAccionPresupuestoLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoLinea> presupuestolineas,PresupuestoLineaParameterReturnGeneral presupuestolineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-procesarAccionPresupuestoLineasWithConnection");connexion.begin();			
			
			PresupuestoLineaParameterReturnGeneral presupuestolineaReturnGeneral=new PresupuestoLineaParameterReturnGeneral();
	
			PresupuestoLineaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestolineas,presupuestolineaParameterGeneral,presupuestolineaReturnGeneral);
			
			this.connexion.commit();
			
			return presupuestolineaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoLineaParameterReturnGeneral procesarEventosPresupuestoLineas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoLinea> presupuestolineas,PresupuestoLinea presupuestolinea,PresupuestoLineaParameterReturnGeneral presupuestolineaParameterGeneral,Boolean isEsNuevoPresupuestoLinea,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresupuestoLineaParameterReturnGeneral presupuestolineaReturnGeneral=new PresupuestoLineaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestolineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoLineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestolineas,presupuestolinea,presupuestolineaParameterGeneral,presupuestolineaReturnGeneral,isEsNuevoPresupuestoLinea,clases);
			
			return presupuestolineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresupuestoLineaParameterReturnGeneral procesarEventosPresupuestoLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoLinea> presupuestolineas,PresupuestoLinea presupuestolinea,PresupuestoLineaParameterReturnGeneral presupuestolineaParameterGeneral,Boolean isEsNuevoPresupuestoLinea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-procesarEventosPresupuestoLineasWithConnection");connexion.begin();			
			
			PresupuestoLineaParameterReturnGeneral presupuestolineaReturnGeneral=new PresupuestoLineaParameterReturnGeneral();
	
			presupuestolineaReturnGeneral.setPresupuestoLinea(presupuestolinea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestolineaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoLineaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestolineas,presupuestolinea,presupuestolineaParameterGeneral,presupuestolineaReturnGeneral,isEsNuevoPresupuestoLinea,clases);
			
			this.connexion.commit();
			
			return presupuestolineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoLineaParameterReturnGeneral procesarImportacionPresupuestoLineasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresupuestoLineaParameterReturnGeneral presupuestolineaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-procesarImportacionPresupuestoLineasWithConnection");connexion.begin();			
			
			PresupuestoLineaParameterReturnGeneral presupuestolineaReturnGeneral=new PresupuestoLineaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presupuestolineas=new ArrayList<PresupuestoLinea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presupuestolinea=new PresupuestoLinea();
				
				
				if(conColumnasBase) {this.presupuestolinea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presupuestolinea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presupuestolinea.setmargen(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestolinea.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestolinea.setes_para_presupuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.presupuestolineas.add(this.presupuestolinea);
			}
			
			this.savePresupuestoLineas();
			
			this.connexion.commit();
			
			presupuestolineaReturnGeneral.setConRetornoEstaProcesado(true);
			presupuestolineaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presupuestolineaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresupuestoLineasEliminados() throws Exception {				
		
		List<PresupuestoLinea> presupuestolineasAux= new ArrayList<PresupuestoLinea>();
		
		for(PresupuestoLinea presupuestolinea:presupuestolineas) {
			if(!presupuestolinea.getIsDeleted()) {
				presupuestolineasAux.add(presupuestolinea);
			}
		}
		
		presupuestolineas=presupuestolineasAux;
	}
	
	public void quitarPresupuestoLineasNulos() throws Exception {				
		
		List<PresupuestoLinea> presupuestolineasAux= new ArrayList<PresupuestoLinea>();
		
		for(PresupuestoLinea presupuestolinea : this.presupuestolineas) {
			if(presupuestolinea==null) {
				presupuestolineasAux.add(presupuestolinea);
			}
		}
		
		//this.presupuestolineas=presupuestolineasAux;
		
		this.presupuestolineas.removeAll(presupuestolineasAux);
	}
	
	public void getSetVersionRowPresupuestoLineaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presupuestolinea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presupuestolinea.getIsDeleted() || (presupuestolinea.getIsChanged()&&!presupuestolinea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presupuestolineaDataAccess.getSetVersionRowPresupuestoLinea(connexion,presupuestolinea.getId());
				
				if(!presupuestolinea.getVersionRow().equals(timestamp)) {	
					presupuestolinea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presupuestolinea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresupuestoLinea()throws Exception {	
		
		if(presupuestolinea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presupuestolinea.getIsDeleted() || (presupuestolinea.getIsChanged()&&!presupuestolinea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presupuestolineaDataAccess.getSetVersionRowPresupuestoLinea(connexion,presupuestolinea.getId());
			
			try {							
				if(!presupuestolinea.getVersionRow().equals(timestamp)) {	
					presupuestolinea.setVersionRow(timestamp);
				}
				
				presupuestolinea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresupuestoLineasWithConnection()throws Exception {	
		if(presupuestolineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresupuestoLinea presupuestolineaAux:presupuestolineas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presupuestolineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestolineaAux.getIsDeleted() || (presupuestolineaAux.getIsChanged()&&!presupuestolineaAux.getIsNew())) {
						
						timestamp=presupuestolineaDataAccess.getSetVersionRowPresupuestoLinea(connexion,presupuestolineaAux.getId());
						
						if(!presupuestolinea.getVersionRow().equals(timestamp)) {	
							presupuestolineaAux.setVersionRow(timestamp);
						}
								
						presupuestolineaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresupuestoLineas()throws Exception {	
		if(presupuestolineas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresupuestoLinea presupuestolineaAux:presupuestolineas) {
					if(presupuestolineaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestolineaAux.getIsDeleted() || (presupuestolineaAux.getIsChanged()&&!presupuestolineaAux.getIsNew())) {
						
						timestamp=presupuestolineaDataAccess.getSetVersionRowPresupuestoLinea(connexion,presupuestolineaAux.getId());
						
						if(!presupuestolineaAux.getVersionRow().equals(timestamp)) {	
							presupuestolineaAux.setVersionRow(timestamp);
						}
						
													
						presupuestolineaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresupuestoLineaParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoLineaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalLinea) throws Exception {
		PresupuestoLineaParameterReturnGeneral  presupuestolineaReturnGeneral =new PresupuestoLineaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresupuestoLineaWithConnection");connexion.begin();
			
			presupuestolineaReturnGeneral =new PresupuestoLineaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestolineaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			presupuestolineaReturnGeneral.setlineasForeignKey(lineasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presupuestolineaReturnGeneral;
	}
	
	public PresupuestoLineaParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoLinea(String finalQueryGlobalEmpresa,String finalQueryGlobalLinea) throws Exception {
		PresupuestoLineaParameterReturnGeneral  presupuestolineaReturnGeneral =new PresupuestoLineaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presupuestolineaReturnGeneral =new PresupuestoLineaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestolineaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			presupuestolineaReturnGeneral.setlineasForeignKey(lineasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presupuestolineaReturnGeneral;
	}
	
	
	public void deepLoad(PresupuestoLinea presupuestolinea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresupuestoLineaLogicAdditional.updatePresupuestoLineaToGet(presupuestolinea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestolinea.setEmpresa(presupuestolineaDataAccess.getEmpresa(connexion,presupuestolinea));
		presupuestolinea.setLinea(presupuestolineaDataAccess.getLinea(connexion,presupuestolinea));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestolinea.setEmpresa(presupuestolineaDataAccess.getEmpresa(connexion,presupuestolinea));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestolinea.setLinea(presupuestolineaDataAccess.getLinea(connexion,presupuestolinea));
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
			presupuestolinea.setEmpresa(presupuestolineaDataAccess.getEmpresa(connexion,presupuestolinea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestolinea.setLinea(presupuestolineaDataAccess.getLinea(connexion,presupuestolinea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestolinea.setEmpresa(presupuestolineaDataAccess.getEmpresa(connexion,presupuestolinea));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestolinea.getEmpresa(),isDeep,deepLoadType,clases);
				
		presupuestolinea.setLinea(presupuestolineaDataAccess.getLinea(connexion,presupuestolinea));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(presupuestolinea.getLinea(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestolinea.setEmpresa(presupuestolineaDataAccess.getEmpresa(connexion,presupuestolinea));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presupuestolinea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestolinea.setLinea(presupuestolineaDataAccess.getLinea(connexion,presupuestolinea));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(presupuestolinea.getLinea(),isDeep,deepLoadType,clases);				
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
			presupuestolinea.setEmpresa(presupuestolineaDataAccess.getEmpresa(connexion,presupuestolinea));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presupuestolinea.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestolinea.setLinea(presupuestolineaDataAccess.getLinea(connexion,presupuestolinea));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(presupuestolinea.getLinea(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresupuestoLinea presupuestolinea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresupuestoLineaLogicAdditional.updatePresupuestoLineaToSave(presupuestolinea,this.arrDatoGeneral);
			
PresupuestoLineaDataAccess.save(presupuestolinea, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestolinea.getEmpresa(),connexion);

		LineaDataAccess.save(presupuestolinea.getLinea(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestolinea.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestolinea.getLinea(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestolinea.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestolinea.getEmpresa(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(presupuestolinea.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(presupuestolinea.getLinea(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestolinea.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presupuestolinea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestolinea.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(presupuestolinea.getLinea(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresupuestoLinea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presupuestolinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(presupuestolinea);
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
			this.deepLoad(this.presupuestolinea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolinea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresupuestoLinea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presupuestolineas!=null) {
				for(PresupuestoLinea presupuestolinea:presupuestolineas) {
					this.deepLoad(presupuestolinea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(presupuestolineas);
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
			if(presupuestolineas!=null) {
				for(PresupuestoLinea presupuestolinea:presupuestolineas) {
					this.deepLoad(presupuestolinea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(presupuestolineas);
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
			this.getNewConnexionToDeep(PresupuestoLinea.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presupuestolinea,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresupuestoLinea.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presupuestolineas!=null) {
				for(PresupuestoLinea presupuestolinea:presupuestolineas) {
					this.deepSave(presupuestolinea,isDeep,deepLoadType,clases);
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
			if(presupuestolineas!=null) {
				for(PresupuestoLinea presupuestolinea:presupuestolineas) {
					this.deepSave(presupuestolinea,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresupuestoLineasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoLineaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoLineasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoLineaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoLineasFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoLinea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PresupuestoLineaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoLineasFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PresupuestoLineaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			PresupuestoLineaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoLineaConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoLinea(this.presupuestolineas);
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
			if(PresupuestoLineaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoLineaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresupuestoLinea presupuestolinea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresupuestoLineaConstantesFunciones.ISCONAUDITORIA) {
				if(presupuestolinea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoLineaDataAccess.TABLENAME, presupuestolinea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoLineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoLineaLogic.registrarAuditoriaDetallesPresupuestoLinea(connexion,presupuestolinea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presupuestolinea.getIsDeleted()) {
					/*if(!presupuestolinea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresupuestoLineaDataAccess.TABLENAME, presupuestolinea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresupuestoLineaLogic.registrarAuditoriaDetallesPresupuestoLinea(connexion,presupuestolinea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoLineaDataAccess.TABLENAME, presupuestolinea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presupuestolinea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoLineaDataAccess.TABLENAME, presupuestolinea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoLineaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoLineaLogic.registrarAuditoriaDetallesPresupuestoLinea(connexion,presupuestolinea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresupuestoLinea(Connexion connexion,PresupuestoLinea presupuestolinea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presupuestolinea.getIsNew()||!presupuestolinea.getid_empresa().equals(presupuestolinea.getPresupuestoLineaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestolinea.getPresupuestoLineaOriginal().getid_empresa()!=null)
				{
					strValorActual=presupuestolinea.getPresupuestoLineaOriginal().getid_empresa().toString();
				}
				if(presupuestolinea.getid_empresa()!=null)
				{
					strValorNuevo=presupuestolinea.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoLineaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestolinea.getIsNew()||!presupuestolinea.getid_linea().equals(presupuestolinea.getPresupuestoLineaOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestolinea.getPresupuestoLineaOriginal().getid_linea()!=null)
				{
					strValorActual=presupuestolinea.getPresupuestoLineaOriginal().getid_linea().toString();
				}
				if(presupuestolinea.getid_linea()!=null)
				{
					strValorNuevo=presupuestolinea.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoLineaConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestolinea.getIsNew()||!presupuestolinea.getmargen().equals(presupuestolinea.getPresupuestoLineaOriginal().getmargen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestolinea.getPresupuestoLineaOriginal().getmargen()!=null)
				{
					strValorActual=presupuestolinea.getPresupuestoLineaOriginal().getmargen().toString();
				}
				if(presupuestolinea.getmargen()!=null)
				{
					strValorNuevo=presupuestolinea.getmargen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoLineaConstantesFunciones.MARGEN,strValorActual,strValorNuevo);
			}	
			
			if(presupuestolinea.getIsNew()||!presupuestolinea.getdescuento().equals(presupuestolinea.getPresupuestoLineaOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestolinea.getPresupuestoLineaOriginal().getdescuento()!=null)
				{
					strValorActual=presupuestolinea.getPresupuestoLineaOriginal().getdescuento().toString();
				}
				if(presupuestolinea.getdescuento()!=null)
				{
					strValorNuevo=presupuestolinea.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoLineaConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestolinea.getIsNew()||!presupuestolinea.getes_para_presupuesto().equals(presupuestolinea.getPresupuestoLineaOriginal().getes_para_presupuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestolinea.getPresupuestoLineaOriginal().getes_para_presupuesto()!=null)
				{
					strValorActual=presupuestolinea.getPresupuestoLineaOriginal().getes_para_presupuesto().toString();
				}
				if(presupuestolinea.getes_para_presupuesto()!=null)
				{
					strValorNuevo=presupuestolinea.getes_para_presupuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresupuestoLineaRelacionesWithConnection(PresupuestoLinea presupuestolinea) throws Exception {

		if(!presupuestolinea.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoLineaRelacionesBase(presupuestolinea,true);
		}
	}

	public void savePresupuestoLineaRelaciones(PresupuestoLinea presupuestolinea)throws Exception {

		if(!presupuestolinea.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoLineaRelacionesBase(presupuestolinea,false);
		}
	}

	public void savePresupuestoLineaRelacionesBase(PresupuestoLinea presupuestolinea,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresupuestoLinea-saveRelacionesWithConnection");}
	

			this.setPresupuestoLinea(presupuestolinea);

			if(PresupuestoLineaLogicAdditional.validarSaveRelaciones(presupuestolinea,this)) {

				PresupuestoLineaLogicAdditional.updateRelacionesToSave(presupuestolinea,this);

				if((presupuestolinea.getIsNew()||presupuestolinea.getIsChanged())&&!presupuestolinea.getIsDeleted()) {
					this.savePresupuestoLinea();
					this.savePresupuestoLineaRelacionesDetalles();

				} else if(presupuestolinea.getIsDeleted()) {
					this.savePresupuestoLineaRelacionesDetalles();
					this.savePresupuestoLinea();
				}

				PresupuestoLineaLogicAdditional.updateRelacionesToSaveAfter(presupuestolinea,this);

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
	
	
	private void savePresupuestoLineaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoLineaConstantesFunciones.getClassesForeignKeysOfPresupuestoLinea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoLineaConstantesFunciones.getClassesRelationshipsOfPresupuestoLinea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
