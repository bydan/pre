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
import com.bydan.erp.inventario.util.TransaccionIngresoEgresoConstantesFunciones;
import com.bydan.erp.inventario.util.TransaccionIngresoEgresoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TransaccionIngresoEgresoParameterGeneral;
import com.bydan.erp.inventario.business.entity.TransaccionIngresoEgreso;
import com.bydan.erp.inventario.business.logic.TransaccionIngresoEgresoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class TransaccionIngresoEgresoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TransaccionIngresoEgresoLogic.class);
	
	protected TransaccionIngresoEgresoDataAccess transaccioningresoegresoDataAccess; 	
	protected TransaccionIngresoEgreso transaccioningresoegreso;
	protected List<TransaccionIngresoEgreso> transaccioningresoegresos;
	protected Object transaccioningresoegresoObject;	
	protected List<Object> transaccioningresoegresosObject;
	
	public static ClassValidator<TransaccionIngresoEgreso> transaccioningresoegresoValidator = new ClassValidator<TransaccionIngresoEgreso>(TransaccionIngresoEgreso.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TransaccionIngresoEgresoLogicAdditional transaccioningresoegresoLogicAdditional=null;
	
	public TransaccionIngresoEgresoLogicAdditional getTransaccionIngresoEgresoLogicAdditional() {
		return this.transaccioningresoegresoLogicAdditional;
	}
	
	public void setTransaccionIngresoEgresoLogicAdditional(TransaccionIngresoEgresoLogicAdditional transaccioningresoegresoLogicAdditional) {
		try {
			this.transaccioningresoegresoLogicAdditional=transaccioningresoegresoLogicAdditional;
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
	
	
	
	
	public  TransaccionIngresoEgresoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.transaccioningresoegresoDataAccess = new TransaccionIngresoEgresoDataAccess();
			
			this.transaccioningresoegresos= new ArrayList<TransaccionIngresoEgreso>();
			this.transaccioningresoegreso= new TransaccionIngresoEgreso();
			
			this.transaccioningresoegresoObject=new Object();
			this.transaccioningresoegresosObject=new ArrayList<Object>();
				
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
			
			this.transaccioningresoegresoDataAccess.setConnexionType(this.connexionType);
			this.transaccioningresoegresoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransaccionIngresoEgresoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.transaccioningresoegresoDataAccess = new TransaccionIngresoEgresoDataAccess();
			this.transaccioningresoegresos= new ArrayList<TransaccionIngresoEgreso>();
			this.transaccioningresoegreso= new TransaccionIngresoEgreso();
			this.transaccioningresoegresoObject=new Object();
			this.transaccioningresoegresosObject=new ArrayList<Object>();
			
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
			
			this.transaccioningresoegresoDataAccess.setConnexionType(this.connexionType);
			this.transaccioningresoegresoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TransaccionIngresoEgreso getTransaccionIngresoEgreso() throws Exception {	
		TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToGet(transaccioningresoegreso,this.datosCliente,this.arrDatoGeneral);
		TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToGet(transaccioningresoegreso,this.arrDatoGeneral);
		
		return transaccioningresoegreso;
	}
		
	public void setTransaccionIngresoEgreso(TransaccionIngresoEgreso newTransaccionIngresoEgreso) {
		this.transaccioningresoegreso = newTransaccionIngresoEgreso;
	}
	
	public TransaccionIngresoEgresoDataAccess getTransaccionIngresoEgresoDataAccess() {
		return transaccioningresoegresoDataAccess;
	}
	
	public void setTransaccionIngresoEgresoDataAccess(TransaccionIngresoEgresoDataAccess newtransaccioningresoegresoDataAccess) {
		this.transaccioningresoegresoDataAccess = newtransaccioningresoegresoDataAccess;
	}
	
	public List<TransaccionIngresoEgreso> getTransaccionIngresoEgresos() throws Exception {		
		this.quitarTransaccionIngresoEgresosNulos();
		
		TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToGets(transaccioningresoegresos,this.datosCliente,this.arrDatoGeneral);
		
		for (TransaccionIngresoEgreso transaccioningresoegresoLocal: transaccioningresoegresos ) {
			TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToGet(transaccioningresoegresoLocal,this.arrDatoGeneral);
		}
		
		return transaccioningresoegresos;
	}
	
	public void setTransaccionIngresoEgresos(List<TransaccionIngresoEgreso> newTransaccionIngresoEgresos) {
		this.transaccioningresoegresos = newTransaccionIngresoEgresos;
	}
	
	public Object getTransaccionIngresoEgresoObject() {	
		this.transaccioningresoegresoObject=this.transaccioningresoegresoDataAccess.getEntityObject();
		return this.transaccioningresoegresoObject;
	}
		
	public void setTransaccionIngresoEgresoObject(Object newTransaccionIngresoEgresoObject) {
		this.transaccioningresoegresoObject = newTransaccionIngresoEgresoObject;
	}
	
	public List<Object> getTransaccionIngresoEgresosObject() {		
		this.transaccioningresoegresosObject=this.transaccioningresoegresoDataAccess.getEntitiesObject();
		return this.transaccioningresoegresosObject;
	}
		
	public void setTransaccionIngresoEgresosObject(List<Object> newTransaccionIngresoEgresosObject) {
		this.transaccioningresoegresosObject = newTransaccionIngresoEgresosObject;
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
		
		if(this.transaccioningresoegresoDataAccess!=null) {
			this.transaccioningresoegresoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			transaccioningresoegresoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			transaccioningresoegresoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccioningresoegreso=transaccioningresoegresoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioningresoegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegreso);
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  		  
        try {
			
			transaccioningresoegreso=transaccioningresoegresoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioningresoegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccioningresoegreso=transaccioningresoegresoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioningresoegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegreso);
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  		  
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  		  
        try {
			
			transaccioningresoegreso=transaccioningresoegresoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioningresoegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  		  
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =transaccioningresoegresoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=transaccioningresoegresoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =transaccioningresoegresoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=transaccioningresoegresoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =transaccioningresoegresoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=transaccioningresoegresoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
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
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
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
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
        try {			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
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
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
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
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
        try {
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
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
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
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
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegreso=transaccioningresoegresoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegreso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegreso);
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
		transaccioningresoegreso = new  TransaccionIngresoEgreso();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegreso=transaccioningresoegresoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegreso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
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
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		  		  
        try {
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTransaccionIngresoEgresosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getTodosTransaccionIngresoEgresosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
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
	
	public  void  getTodosTransaccionIngresoEgresos(String sFinalQuery,Pagination pagination)throws Exception {
		transaccioningresoegresos = new  ArrayList<TransaccionIngresoEgreso>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionIngresoEgreso(transaccioningresoegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {
		Boolean estaValidado=false;
		
		if(transaccioningresoegreso.getIsNew() || transaccioningresoegreso.getIsChanged()) { 
			this.invalidValues = transaccioningresoegresoValidator.getInvalidValues(transaccioningresoegreso);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(transaccioningresoegreso);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTransaccionIngresoEgreso(List<TransaccionIngresoEgreso> TransaccionIngresoEgresos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TransaccionIngresoEgreso transaccioningresoegresoLocal:transaccioningresoegresos) {				
			estaValidadoObjeto=this.validarGuardarTransaccionIngresoEgreso(transaccioningresoegresoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTransaccionIngresoEgreso(List<TransaccionIngresoEgreso> TransaccionIngresoEgresos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionIngresoEgreso(transaccioningresoegresos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTransaccionIngresoEgreso(TransaccionIngresoEgreso TransaccionIngresoEgreso) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionIngresoEgreso(transaccioningresoegreso)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+transaccioningresoegreso.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TransaccionIngresoEgresoConstantesFunciones.getTransaccionIngresoEgresoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"transaccioningresoegreso","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TransaccionIngresoEgresoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TransaccionIngresoEgresoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTransaccionIngresoEgresoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-saveTransaccionIngresoEgresoWithConnection");connexion.begin();			
			
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSave(this.transaccioningresoegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToSave(this.transaccioningresoegreso,this.arrDatoGeneral);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccioningresoegreso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionIngresoEgreso();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionIngresoEgreso(this.transaccioningresoegreso)) {
				TransaccionIngresoEgresoDataAccess.save(this.transaccioningresoegreso, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.transaccioningresoegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSaveAfter(this.transaccioningresoegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionIngresoEgreso();
			
			connexion.commit();			
			
			if(this.transaccioningresoegreso.getIsDeleted()) {
				this.transaccioningresoegreso=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTransaccionIngresoEgreso()throws Exception {	
		try {	
			
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSave(this.transaccioningresoegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToSave(this.transaccioningresoegreso,this.arrDatoGeneral);
			
			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccioningresoegreso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionIngresoEgreso(this.transaccioningresoegreso)) {			
				TransaccionIngresoEgresoDataAccess.save(this.transaccioningresoegreso, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.transaccioningresoegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSaveAfter(this.transaccioningresoegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.transaccioningresoegreso.getIsDeleted()) {
				this.transaccioningresoegreso=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTransaccionIngresoEgresosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-saveTransaccionIngresoEgresosWithConnection");connexion.begin();			
			
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSaves(transaccioningresoegresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionIngresoEgresos();
			
			Boolean validadoTodosTransaccionIngresoEgreso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionIngresoEgreso transaccioningresoegresoLocal:transaccioningresoegresos) {		
				if(transaccioningresoegresoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToSave(transaccioningresoegresoLocal,this.arrDatoGeneral);
	        	
				TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccioningresoegresoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionIngresoEgreso(transaccioningresoegresoLocal)) {
					TransaccionIngresoEgresoDataAccess.save(transaccioningresoegresoLocal, connexion);				
				} else {
					validadoTodosTransaccionIngresoEgreso=false;
				}
			}
			
			if(!validadoTodosTransaccionIngresoEgreso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSavesAfter(transaccioningresoegresos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionIngresoEgresos();
			
			connexion.commit();		
			
			this.quitarTransaccionIngresoEgresosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTransaccionIngresoEgresos()throws Exception {				
		 try {	
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSaves(transaccioningresoegresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTransaccionIngresoEgreso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionIngresoEgreso transaccioningresoegresoLocal:transaccioningresoegresos) {				
				if(transaccioningresoegresoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToSave(transaccioningresoegresoLocal,this.arrDatoGeneral);
	        	
				TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccioningresoegresoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionIngresoEgreso(transaccioningresoegresoLocal)) {				
					TransaccionIngresoEgresoDataAccess.save(transaccioningresoegresoLocal, connexion);				
				} else {
					validadoTodosTransaccionIngresoEgreso=false;
				}
			}
			
			if(!validadoTodosTransaccionIngresoEgreso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionIngresoEgresoLogicAdditional.checkTransaccionIngresoEgresoToSavesAfter(transaccioningresoegresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTransaccionIngresoEgresosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionIngresoEgresoParameterReturnGeneral procesarAccionTransaccionIngresoEgresos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionIngresoEgreso> transaccioningresoegresos,TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoParameterGeneral)throws Exception {
		 try {	
			TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoReturnGeneral=new TransaccionIngresoEgresoParameterReturnGeneral();
	
			TransaccionIngresoEgresoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccioningresoegresos,transaccioningresoegresoParameterGeneral,transaccioningresoegresoReturnGeneral);
			
			return transaccioningresoegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionIngresoEgresoParameterReturnGeneral procesarAccionTransaccionIngresoEgresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionIngresoEgreso> transaccioningresoegresos,TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-procesarAccionTransaccionIngresoEgresosWithConnection");connexion.begin();			
			
			TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoReturnGeneral=new TransaccionIngresoEgresoParameterReturnGeneral();
	
			TransaccionIngresoEgresoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccioningresoegresos,transaccioningresoegresoParameterGeneral,transaccioningresoegresoReturnGeneral);
			
			this.connexion.commit();
			
			return transaccioningresoegresoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionIngresoEgresoParameterReturnGeneral procesarEventosTransaccionIngresoEgresos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionIngresoEgreso> transaccioningresoegresos,TransaccionIngresoEgreso transaccioningresoegreso,TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoParameterGeneral,Boolean isEsNuevoTransaccionIngresoEgreso,ArrayList<Classe> clases)throws Exception {
		 try {	
			TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoReturnGeneral=new TransaccionIngresoEgresoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccioningresoegresoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionIngresoEgresoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccioningresoegresos,transaccioningresoegreso,transaccioningresoegresoParameterGeneral,transaccioningresoegresoReturnGeneral,isEsNuevoTransaccionIngresoEgreso,clases);
			
			return transaccioningresoegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TransaccionIngresoEgresoParameterReturnGeneral procesarEventosTransaccionIngresoEgresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionIngresoEgreso> transaccioningresoegresos,TransaccionIngresoEgreso transaccioningresoegreso,TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoParameterGeneral,Boolean isEsNuevoTransaccionIngresoEgreso,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-procesarEventosTransaccionIngresoEgresosWithConnection");connexion.begin();			
			
			TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoReturnGeneral=new TransaccionIngresoEgresoParameterReturnGeneral();
	
			transaccioningresoegresoReturnGeneral.setTransaccionIngresoEgreso(transaccioningresoegreso);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccioningresoegresoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionIngresoEgresoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccioningresoegresos,transaccioningresoegreso,transaccioningresoegresoParameterGeneral,transaccioningresoegresoReturnGeneral,isEsNuevoTransaccionIngresoEgreso,clases);
			
			this.connexion.commit();
			
			return transaccioningresoegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionIngresoEgresoParameterReturnGeneral procesarImportacionTransaccionIngresoEgresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-procesarImportacionTransaccionIngresoEgresosWithConnection");connexion.begin();			
			
			TransaccionIngresoEgresoParameterReturnGeneral transaccioningresoegresoReturnGeneral=new TransaccionIngresoEgresoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.transaccioningresoegresos=new ArrayList<TransaccionIngresoEgreso>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.transaccioningresoegreso=new TransaccionIngresoEgreso();
				
				
				if(conColumnasBase) {this.transaccioningresoegreso.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.transaccioningresoegreso.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.transaccioningresoegreso.setes_ingreso(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.transaccioningresoegresos.add(this.transaccioningresoegreso);
			}
			
			this.saveTransaccionIngresoEgresos();
			
			this.connexion.commit();
			
			transaccioningresoegresoReturnGeneral.setConRetornoEstaProcesado(true);
			transaccioningresoegresoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return transaccioningresoegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTransaccionIngresoEgresosEliminados() throws Exception {				
		
		List<TransaccionIngresoEgreso> transaccioningresoegresosAux= new ArrayList<TransaccionIngresoEgreso>();
		
		for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos) {
			if(!transaccioningresoegreso.getIsDeleted()) {
				transaccioningresoegresosAux.add(transaccioningresoegreso);
			}
		}
		
		transaccioningresoegresos=transaccioningresoegresosAux;
	}
	
	public void quitarTransaccionIngresoEgresosNulos() throws Exception {				
		
		List<TransaccionIngresoEgreso> transaccioningresoegresosAux= new ArrayList<TransaccionIngresoEgreso>();
		
		for(TransaccionIngresoEgreso transaccioningresoegreso : this.transaccioningresoegresos) {
			if(transaccioningresoegreso==null) {
				transaccioningresoegresosAux.add(transaccioningresoegreso);
			}
		}
		
		//this.transaccioningresoegresos=transaccioningresoegresosAux;
		
		this.transaccioningresoegresos.removeAll(transaccioningresoegresosAux);
	}
	
	public void getSetVersionRowTransaccionIngresoEgresoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(transaccioningresoegreso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((transaccioningresoegreso.getIsDeleted() || (transaccioningresoegreso.getIsChanged()&&!transaccioningresoegreso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=transaccioningresoegresoDataAccess.getSetVersionRowTransaccionIngresoEgreso(connexion,transaccioningresoegreso.getId());
				
				if(!transaccioningresoegreso.getVersionRow().equals(timestamp)) {	
					transaccioningresoegreso.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				transaccioningresoegreso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTransaccionIngresoEgreso()throws Exception {	
		
		if(transaccioningresoegreso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((transaccioningresoegreso.getIsDeleted() || (transaccioningresoegreso.getIsChanged()&&!transaccioningresoegreso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=transaccioningresoegresoDataAccess.getSetVersionRowTransaccionIngresoEgreso(connexion,transaccioningresoegreso.getId());
			
			try {							
				if(!transaccioningresoegreso.getVersionRow().equals(timestamp)) {	
					transaccioningresoegreso.setVersionRow(timestamp);
				}
				
				transaccioningresoegreso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTransaccionIngresoEgresosWithConnection()throws Exception {	
		if(transaccioningresoegresos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TransaccionIngresoEgreso transaccioningresoegresoAux:transaccioningresoegresos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(transaccioningresoegresoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccioningresoegresoAux.getIsDeleted() || (transaccioningresoegresoAux.getIsChanged()&&!transaccioningresoegresoAux.getIsNew())) {
						
						timestamp=transaccioningresoegresoDataAccess.getSetVersionRowTransaccionIngresoEgreso(connexion,transaccioningresoegresoAux.getId());
						
						if(!transaccioningresoegreso.getVersionRow().equals(timestamp)) {	
							transaccioningresoegresoAux.setVersionRow(timestamp);
						}
								
						transaccioningresoegresoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTransaccionIngresoEgresos()throws Exception {	
		if(transaccioningresoegresos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TransaccionIngresoEgreso transaccioningresoegresoAux:transaccioningresoegresos) {
					if(transaccioningresoegresoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccioningresoegresoAux.getIsDeleted() || (transaccioningresoegresoAux.getIsChanged()&&!transaccioningresoegresoAux.getIsNew())) {
						
						timestamp=transaccioningresoegresoDataAccess.getSetVersionRowTransaccionIngresoEgreso(connexion,transaccioningresoegresoAux.getId());
						
						if(!transaccioningresoegresoAux.getVersionRow().equals(timestamp)) {	
							transaccioningresoegresoAux.setVersionRow(timestamp);
						}
						
													
						transaccioningresoegresoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TransaccionIngresoEgresoParameterReturnGeneral cargarCombosLoteForeignKeyTransaccionIngresoEgresoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion) throws Exception {
		TransaccionIngresoEgresoParameterReturnGeneral  transaccioningresoegresoReturnGeneral =new TransaccionIngresoEgresoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-cargarCombosLoteForeignKeyTransaccionIngresoEgresoWithConnection");connexion.begin();
			
			transaccioningresoegresoReturnGeneral =new TransaccionIngresoEgresoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transaccioningresoegresoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transaccioningresoegresoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			transaccioningresoegresoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return transaccioningresoegresoReturnGeneral;
	}
	
	public TransaccionIngresoEgresoParameterReturnGeneral cargarCombosLoteForeignKeyTransaccionIngresoEgreso(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion) throws Exception {
		TransaccionIngresoEgresoParameterReturnGeneral  transaccioningresoegresoReturnGeneral =new TransaccionIngresoEgresoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			transaccioningresoegresoReturnGeneral =new TransaccionIngresoEgresoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transaccioningresoegresoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transaccioningresoegresoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			transaccioningresoegresoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return transaccioningresoegresoReturnGeneral;
	}
	
	
	public void deepLoad(TransaccionIngresoEgreso transaccioningresoegreso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToGet(transaccioningresoegreso,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccioningresoegreso.setEmpresa(transaccioningresoegresoDataAccess.getEmpresa(connexion,transaccioningresoegreso));
		transaccioningresoegreso.setModulo(transaccioningresoegresoDataAccess.getModulo(connexion,transaccioningresoegreso));
		transaccioningresoegreso.setTransaccion(transaccioningresoegresoDataAccess.getTransaccion(connexion,transaccioningresoegreso));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccioningresoegreso.setEmpresa(transaccioningresoegresoDataAccess.getEmpresa(connexion,transaccioningresoegreso));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transaccioningresoegreso.setModulo(transaccioningresoegresoDataAccess.getModulo(connexion,transaccioningresoegreso));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioningresoegreso.setTransaccion(transaccioningresoegresoDataAccess.getTransaccion(connexion,transaccioningresoegreso));
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
			transaccioningresoegreso.setEmpresa(transaccioningresoegresoDataAccess.getEmpresa(connexion,transaccioningresoegreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioningresoegreso.setModulo(transaccioningresoegresoDataAccess.getModulo(connexion,transaccioningresoegreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioningresoegreso.setTransaccion(transaccioningresoegresoDataAccess.getTransaccion(connexion,transaccioningresoegreso));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccioningresoegreso.setEmpresa(transaccioningresoegresoDataAccess.getEmpresa(connexion,transaccioningresoegreso));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transaccioningresoegreso.getEmpresa(),isDeep,deepLoadType,clases);
				
		transaccioningresoegreso.setModulo(transaccioningresoegresoDataAccess.getModulo(connexion,transaccioningresoegreso));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transaccioningresoegreso.getModulo(),isDeep,deepLoadType,clases);
				
		transaccioningresoegreso.setTransaccion(transaccioningresoegresoDataAccess.getTransaccion(connexion,transaccioningresoegreso));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(transaccioningresoegreso.getTransaccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccioningresoegreso.setEmpresa(transaccioningresoegresoDataAccess.getEmpresa(connexion,transaccioningresoegreso));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(transaccioningresoegreso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transaccioningresoegreso.setModulo(transaccioningresoegresoDataAccess.getModulo(connexion,transaccioningresoegreso));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(transaccioningresoegreso.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioningresoegreso.setTransaccion(transaccioningresoegresoDataAccess.getTransaccion(connexion,transaccioningresoegreso));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transaccioningresoegreso.getTransaccion(),isDeep,deepLoadType,clases);				
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
			transaccioningresoegreso.setEmpresa(transaccioningresoegresoDataAccess.getEmpresa(connexion,transaccioningresoegreso));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(transaccioningresoegreso.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioningresoegreso.setModulo(transaccioningresoegresoDataAccess.getModulo(connexion,transaccioningresoegreso));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(transaccioningresoegreso.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioningresoegreso.setTransaccion(transaccioningresoegresoDataAccess.getTransaccion(connexion,transaccioningresoegreso));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transaccioningresoegreso.getTransaccion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TransaccionIngresoEgreso transaccioningresoegreso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TransaccionIngresoEgresoLogicAdditional.updateTransaccionIngresoEgresoToSave(transaccioningresoegreso,this.arrDatoGeneral);
			
TransaccionIngresoEgresoDataAccess.save(transaccioningresoegreso, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transaccioningresoegreso.getEmpresa(),connexion);

		ModuloDataAccess.save(transaccioningresoegreso.getModulo(),connexion);

		TransaccionDataAccess.save(transaccioningresoegreso.getTransaccion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transaccioningresoegreso.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transaccioningresoegreso.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioningresoegreso.getTransaccion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transaccioningresoegreso.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transaccioningresoegreso.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(transaccioningresoegreso.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transaccioningresoegreso.getModulo(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(transaccioningresoegreso.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(transaccioningresoegreso.getTransaccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transaccioningresoegreso.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(transaccioningresoegreso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transaccioningresoegreso.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(transaccioningresoegreso.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioningresoegreso.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(transaccioningresoegreso.getTransaccion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TransaccionIngresoEgreso.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(transaccioningresoegreso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(transaccioningresoegreso);
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
			this.deepLoad(this.transaccioningresoegreso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TransaccionIngresoEgreso.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(transaccioningresoegresos!=null) {
				for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos) {
					this.deepLoad(transaccioningresoegreso,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(transaccioningresoegresos);
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
			if(transaccioningresoegresos!=null) {
				for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos) {
					this.deepLoad(transaccioningresoegreso,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(transaccioningresoegresos);
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
			this.getNewConnexionToDeep(TransaccionIngresoEgreso.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(transaccioningresoegreso,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TransaccionIngresoEgreso.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(transaccioningresoegresos!=null) {
				for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos) {
					this.deepSave(transaccioningresoegreso,isDeep,deepLoadType,clases);
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
			if(transaccioningresoegresos!=null) {
				for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos) {
					this.deepSave(transaccioningresoegreso,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTransaccionIngresoEgresosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionIngresoEgresosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionIngresoEgresosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionIngresoEgresoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionIngresoEgresosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionIngresoEgresoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionIngresoEgresosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionIngresoEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionIngresoEgresosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			TransaccionIngresoEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioningresoegresos=transaccioningresoegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionIngresoEgresoConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(this.transaccioningresoegresos);
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
			if(TransaccionIngresoEgresoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionIngresoEgresoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TransaccionIngresoEgreso transaccioningresoegreso,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TransaccionIngresoEgresoConstantesFunciones.ISCONAUDITORIA) {
				if(transaccioningresoegreso.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionIngresoEgresoDataAccess.TABLENAME, transaccioningresoegreso.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionIngresoEgresoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionIngresoEgresoLogic.registrarAuditoriaDetallesTransaccionIngresoEgreso(connexion,transaccioningresoegreso,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(transaccioningresoegreso.getIsDeleted()) {
					/*if(!transaccioningresoegreso.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TransaccionIngresoEgresoDataAccess.TABLENAME, transaccioningresoegreso.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TransaccionIngresoEgresoLogic.registrarAuditoriaDetallesTransaccionIngresoEgreso(connexion,transaccioningresoegreso,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionIngresoEgresoDataAccess.TABLENAME, transaccioningresoegreso.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(transaccioningresoegreso.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionIngresoEgresoDataAccess.TABLENAME, transaccioningresoegreso.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionIngresoEgresoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionIngresoEgresoLogic.registrarAuditoriaDetallesTransaccionIngresoEgreso(connexion,transaccioningresoegreso,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTransaccionIngresoEgreso(Connexion connexion,TransaccionIngresoEgreso transaccioningresoegreso)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(transaccioningresoegreso.getIsNew()||!transaccioningresoegreso.getid_empresa().equals(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_empresa()!=null)
				{
					strValorActual=transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_empresa().toString();
				}
				if(transaccioningresoegreso.getid_empresa()!=null)
				{
					strValorNuevo=transaccioningresoegreso.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(transaccioningresoegreso.getIsNew()||!transaccioningresoegreso.getid_modulo().equals(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_modulo()!=null)
				{
					strValorActual=transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_modulo().toString();
				}
				if(transaccioningresoegreso.getid_modulo()!=null)
				{
					strValorNuevo=transaccioningresoegreso.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionIngresoEgresoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(transaccioningresoegreso.getIsNew()||!transaccioningresoegreso.getid_transaccion().equals(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_transaccion()!=null)
				{
					strValorActual=transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getid_transaccion().toString();
				}
				if(transaccioningresoegreso.getid_transaccion()!=null)
				{
					strValorNuevo=transaccioningresoegreso.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(transaccioningresoegreso.getIsNew()||!transaccioningresoegreso.getes_ingreso().equals(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getes_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getes_ingreso()!=null)
				{
					strValorActual=transaccioningresoegreso.getTransaccionIngresoEgresoOriginal().getes_ingreso().toString();
				}
				if(transaccioningresoegreso.getes_ingreso()!=null)
				{
					strValorNuevo=transaccioningresoegreso.getes_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionIngresoEgresoConstantesFunciones.ESINGRESO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTransaccionIngresoEgresoRelacionesWithConnection(TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {

		if(!transaccioningresoegreso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionIngresoEgresoRelacionesBase(transaccioningresoegreso,true);
		}
	}

	public void saveTransaccionIngresoEgresoRelaciones(TransaccionIngresoEgreso transaccioningresoegreso)throws Exception {

		if(!transaccioningresoegreso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionIngresoEgresoRelacionesBase(transaccioningresoegreso,false);
		}
	}

	public void saveTransaccionIngresoEgresoRelacionesBase(TransaccionIngresoEgreso transaccioningresoegreso,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TransaccionIngresoEgreso-saveRelacionesWithConnection");}
	

			this.setTransaccionIngresoEgreso(transaccioningresoegreso);

			if(TransaccionIngresoEgresoLogicAdditional.validarSaveRelaciones(transaccioningresoegreso,this)) {

				TransaccionIngresoEgresoLogicAdditional.updateRelacionesToSave(transaccioningresoegreso,this);

				if((transaccioningresoegreso.getIsNew()||transaccioningresoegreso.getIsChanged())&&!transaccioningresoegreso.getIsDeleted()) {
					this.saveTransaccionIngresoEgreso();
					this.saveTransaccionIngresoEgresoRelacionesDetalles();

				} else if(transaccioningresoegreso.getIsDeleted()) {
					this.saveTransaccionIngresoEgresoRelacionesDetalles();
					this.saveTransaccionIngresoEgreso();
				}

				TransaccionIngresoEgresoLogicAdditional.updateRelacionesToSaveAfter(transaccioningresoegreso,this);

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
	
	
	private void saveTransaccionIngresoEgresoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionIngresoEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionIngresoEgresoConstantesFunciones.getClassesForeignKeysOfTransaccionIngresoEgreso(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionIngresoEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionIngresoEgresoConstantesFunciones.getClassesRelationshipsOfTransaccionIngresoEgreso(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
