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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.TransaccionConstantesFunciones;
import com.bydan.erp.tesoreria.util.TransaccionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TransaccionParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.Transaccion;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;








@SuppressWarnings("unused")
public class TransaccionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TransaccionLogic.class);
	
	protected TransaccionDataAccess transaccionDataAccess; 	
	protected Transaccion transaccion;
	protected List<Transaccion> transaccions;
	protected Object transaccionObject;	
	protected List<Object> transaccionsObject;
	
	public static ClassValidator<Transaccion> transaccionValidator = new ClassValidator<Transaccion>(Transaccion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TransaccionLogicAdditional transaccionLogicAdditional=null;
	
	public TransaccionLogicAdditional getTransaccionLogicAdditional() {
		return this.transaccionLogicAdditional;
	}
	
	public void setTransaccionLogicAdditional(TransaccionLogicAdditional transaccionLogicAdditional) {
		try {
			this.transaccionLogicAdditional=transaccionLogicAdditional;
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
	
	
	
	
	public  TransaccionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.transaccionDataAccess = new TransaccionDataAccess();
			
			this.transaccions= new ArrayList<Transaccion>();
			this.transaccion= new Transaccion();
			
			this.transaccionObject=new Object();
			this.transaccionsObject=new ArrayList<Object>();
				
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
			
			this.transaccionDataAccess.setConnexionType(this.connexionType);
			this.transaccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransaccionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.transaccionDataAccess = new TransaccionDataAccess();
			this.transaccions= new ArrayList<Transaccion>();
			this.transaccion= new Transaccion();
			this.transaccionObject=new Object();
			this.transaccionsObject=new ArrayList<Object>();
			
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
			
			this.transaccionDataAccess.setConnexionType(this.connexionType);
			this.transaccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Transaccion getTransaccion() throws Exception {	
		TransaccionLogicAdditional.checkTransaccionToGet(transaccion,this.datosCliente,this.arrDatoGeneral);
		TransaccionLogicAdditional.updateTransaccionToGet(transaccion,this.arrDatoGeneral);
		
		return transaccion;
	}
		
	public void setTransaccion(Transaccion newTransaccion) {
		this.transaccion = newTransaccion;
	}
	
	public TransaccionDataAccess getTransaccionDataAccess() {
		return transaccionDataAccess;
	}
	
	public void setTransaccionDataAccess(TransaccionDataAccess newtransaccionDataAccess) {
		this.transaccionDataAccess = newtransaccionDataAccess;
	}
	
	public List<Transaccion> getTransaccions() throws Exception {		
		this.quitarTransaccionsNulos();
		
		TransaccionLogicAdditional.checkTransaccionToGets(transaccions,this.datosCliente,this.arrDatoGeneral);
		
		for (Transaccion transaccionLocal: transaccions ) {
			TransaccionLogicAdditional.updateTransaccionToGet(transaccionLocal,this.arrDatoGeneral);
		}
		
		return transaccions;
	}
	
	public void setTransaccions(List<Transaccion> newTransaccions) {
		this.transaccions = newTransaccions;
	}
	
	public Object getTransaccionObject() {	
		this.transaccionObject=this.transaccionDataAccess.getEntityObject();
		return this.transaccionObject;
	}
		
	public void setTransaccionObject(Object newTransaccionObject) {
		this.transaccionObject = newTransaccionObject;
	}
	
	public List<Object> getTransaccionsObject() {		
		this.transaccionsObject=this.transaccionDataAccess.getEntitiesObject();
		return this.transaccionsObject;
	}
		
	public void setTransaccionsObject(List<Object> newTransaccionsObject) {
		this.transaccionsObject = newTransaccionsObject;
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
		
		if(this.transaccionDataAccess!=null) {
			this.transaccionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			transaccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			transaccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		transaccion = new  Transaccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccion=transaccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
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
		transaccion = new  Transaccion();
		  		  
        try {
			
			transaccion=transaccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		transaccion = new  Transaccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccion=transaccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
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
		transaccion = new  Transaccion();
		  		  
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
		transaccion = new  Transaccion();
		  		  
        try {
			
			transaccion=transaccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		transaccion = new  Transaccion();
		  		  
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
		transaccion = new  Transaccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =transaccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccion = new  Transaccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=transaccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccion = new  Transaccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =transaccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccion = new  Transaccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=transaccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccion = new  Transaccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =transaccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccion = new  Transaccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=transaccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccions = new  ArrayList<Transaccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
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
		transaccions = new  ArrayList<Transaccion>();
		  		  
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
		transaccions = new  ArrayList<Transaccion>();
		  		  
        try {			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		transaccions = new  ArrayList<Transaccion>();
		  		  
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
		transaccions = new  ArrayList<Transaccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
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
		transaccions = new  ArrayList<Transaccion>();
		  		  
        try {
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
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
		transaccions = new  ArrayList<Transaccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
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
		transaccions = new  ArrayList<Transaccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		transaccion = new  Transaccion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccion=transaccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
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
		transaccion = new  Transaccion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccion=transaccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccions = new  ArrayList<Transaccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
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
		transaccions = new  ArrayList<Transaccion>();
		  		  
        try {
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTransaccionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		transaccions = new  ArrayList<Transaccion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getTodosTransaccionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
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
	
	public  void  getTodosTransaccions(String sFinalQuery,Pagination pagination)throws Exception {
		transaccions = new  ArrayList<Transaccion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccion(transaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTransaccion(Transaccion transaccion) throws Exception {
		Boolean estaValidado=false;
		
		if(transaccion.getIsNew() || transaccion.getIsChanged()) { 
			this.invalidValues = transaccionValidator.getInvalidValues(transaccion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(transaccion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTransaccion(List<Transaccion> Transaccions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Transaccion transaccionLocal:transaccions) {				
			estaValidadoObjeto=this.validarGuardarTransaccion(transaccionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTransaccion(List<Transaccion> Transaccions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccion(transaccions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTransaccion(Transaccion Transaccion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccion(transaccion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Transaccion transaccion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+transaccion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TransaccionConstantesFunciones.getTransaccionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"transaccion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TransaccionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TransaccionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTransaccionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-saveTransaccionWithConnection");connexion.begin();			
			
			TransaccionLogicAdditional.checkTransaccionToSave(this.transaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionLogicAdditional.updateTransaccionToSave(this.transaccion,this.arrDatoGeneral);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTransaccion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccion(this.transaccion)) {
				TransaccionDataAccess.save(this.transaccion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionLogicAdditional.checkTransaccionToSaveAfter(this.transaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccion();
			
			connexion.commit();			
			
			if(this.transaccion.getIsDeleted()) {
				this.transaccion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTransaccion()throws Exception {	
		try {	
			
			TransaccionLogicAdditional.checkTransaccionToSave(this.transaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionLogicAdditional.updateTransaccionToSave(this.transaccion,this.arrDatoGeneral);
			
			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccion(this.transaccion)) {			
				TransaccionDataAccess.save(this.transaccion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionLogicAdditional.checkTransaccionToSaveAfter(this.transaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.transaccion.getIsDeleted()) {
				this.transaccion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTransaccionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-saveTransaccionsWithConnection");connexion.begin();			
			
			TransaccionLogicAdditional.checkTransaccionToSaves(transaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTransaccions();
			
			Boolean validadoTodosTransaccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Transaccion transaccionLocal:transaccions) {		
				if(transaccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionLogicAdditional.updateTransaccionToSave(transaccionLocal,this.arrDatoGeneral);
	        	
				TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccion(transaccionLocal)) {
					TransaccionDataAccess.save(transaccionLocal, connexion);				
				} else {
					validadoTodosTransaccion=false;
				}
			}
			
			if(!validadoTodosTransaccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionLogicAdditional.checkTransaccionToSavesAfter(transaccions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccions();
			
			connexion.commit();		
			
			this.quitarTransaccionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTransaccions()throws Exception {				
		 try {	
			TransaccionLogicAdditional.checkTransaccionToSaves(transaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTransaccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Transaccion transaccionLocal:transaccions) {				
				if(transaccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionLogicAdditional.updateTransaccionToSave(transaccionLocal,this.arrDatoGeneral);
	        	
				TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccion(transaccionLocal)) {				
					TransaccionDataAccess.save(transaccionLocal, connexion);				
				} else {
					validadoTodosTransaccion=false;
				}
			}
			
			if(!validadoTodosTransaccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionLogicAdditional.checkTransaccionToSavesAfter(transaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTransaccionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionParameterReturnGeneral procesarAccionTransaccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Transaccion> transaccions,TransaccionParameterReturnGeneral transaccionParameterGeneral)throws Exception {
		 try {	
			TransaccionParameterReturnGeneral transaccionReturnGeneral=new TransaccionParameterReturnGeneral();
	
			TransaccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccions,transaccionParameterGeneral,transaccionReturnGeneral);
			
			return transaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionParameterReturnGeneral procesarAccionTransaccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Transaccion> transaccions,TransaccionParameterReturnGeneral transaccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-procesarAccionTransaccionsWithConnection");connexion.begin();			
			
			TransaccionParameterReturnGeneral transaccionReturnGeneral=new TransaccionParameterReturnGeneral();
	
			TransaccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccions,transaccionParameterGeneral,transaccionReturnGeneral);
			
			this.connexion.commit();
			
			return transaccionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionParameterReturnGeneral procesarEventosTransaccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Transaccion> transaccions,Transaccion transaccion,TransaccionParameterReturnGeneral transaccionParameterGeneral,Boolean isEsNuevoTransaccion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TransaccionParameterReturnGeneral transaccionReturnGeneral=new TransaccionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccions,transaccion,transaccionParameterGeneral,transaccionReturnGeneral,isEsNuevoTransaccion,clases);
			
			return transaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TransaccionParameterReturnGeneral procesarEventosTransaccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Transaccion> transaccions,Transaccion transaccion,TransaccionParameterReturnGeneral transaccionParameterGeneral,Boolean isEsNuevoTransaccion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-procesarEventosTransaccionsWithConnection");connexion.begin();			
			
			TransaccionParameterReturnGeneral transaccionReturnGeneral=new TransaccionParameterReturnGeneral();
	
			transaccionReturnGeneral.setTransaccion(transaccion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccions,transaccion,transaccionParameterGeneral,transaccionReturnGeneral,isEsNuevoTransaccion,clases);
			
			this.connexion.commit();
			
			return transaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionParameterReturnGeneral procesarImportacionTransaccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TransaccionParameterReturnGeneral transaccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-procesarImportacionTransaccionsWithConnection");connexion.begin();			
			
			TransaccionParameterReturnGeneral transaccionReturnGeneral=new TransaccionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.transaccions=new ArrayList<Transaccion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.transaccion=new Transaccion();
				
				
				if(conColumnasBase) {this.transaccion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.transaccion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.transaccion.setcodigo(arrColumnas[iColumn++]);
				this.transaccion.setnombre(arrColumnas[iColumn++]);
			this.transaccion.setdescripcion(arrColumnas[iColumn++]);
				
				this.transaccions.add(this.transaccion);
			}
			
			this.saveTransaccions();
			
			this.connexion.commit();
			
			transaccionReturnGeneral.setConRetornoEstaProcesado(true);
			transaccionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return transaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTransaccionsEliminados() throws Exception {				
		
		List<Transaccion> transaccionsAux= new ArrayList<Transaccion>();
		
		for(Transaccion transaccion:transaccions) {
			if(!transaccion.getIsDeleted()) {
				transaccionsAux.add(transaccion);
			}
		}
		
		transaccions=transaccionsAux;
	}
	
	public void quitarTransaccionsNulos() throws Exception {				
		
		List<Transaccion> transaccionsAux= new ArrayList<Transaccion>();
		
		for(Transaccion transaccion : this.transaccions) {
			if(transaccion==null) {
				transaccionsAux.add(transaccion);
			}
		}
		
		//this.transaccions=transaccionsAux;
		
		this.transaccions.removeAll(transaccionsAux);
	}
	
	public void getSetVersionRowTransaccionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(transaccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((transaccion.getIsDeleted() || (transaccion.getIsChanged()&&!transaccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=transaccionDataAccess.getSetVersionRowTransaccion(connexion,transaccion.getId());
				
				if(!transaccion.getVersionRow().equals(timestamp)) {	
					transaccion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				transaccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTransaccion()throws Exception {	
		
		if(transaccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((transaccion.getIsDeleted() || (transaccion.getIsChanged()&&!transaccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=transaccionDataAccess.getSetVersionRowTransaccion(connexion,transaccion.getId());
			
			try {							
				if(!transaccion.getVersionRow().equals(timestamp)) {	
					transaccion.setVersionRow(timestamp);
				}
				
				transaccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTransaccionsWithConnection()throws Exception {	
		if(transaccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Transaccion transaccionAux:transaccions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(transaccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccionAux.getIsDeleted() || (transaccionAux.getIsChanged()&&!transaccionAux.getIsNew())) {
						
						timestamp=transaccionDataAccess.getSetVersionRowTransaccion(connexion,transaccionAux.getId());
						
						if(!transaccion.getVersionRow().equals(timestamp)) {	
							transaccionAux.setVersionRow(timestamp);
						}
								
						transaccionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTransaccions()throws Exception {	
		if(transaccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Transaccion transaccionAux:transaccions) {
					if(transaccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccionAux.getIsDeleted() || (transaccionAux.getIsChanged()&&!transaccionAux.getIsNew())) {
						
						timestamp=transaccionDataAccess.getSetVersionRowTransaccion(connexion,transaccionAux.getId());
						
						if(!transaccionAux.getVersionRow().equals(timestamp)) {	
							transaccionAux.setVersionRow(timestamp);
						}
						
													
						transaccionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TransaccionParameterReturnGeneral cargarCombosLoteForeignKeyTransaccionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTipoTransa,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContable) throws Exception {
		TransaccionParameterReturnGeneral  transaccionReturnGeneral =new TransaccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTransaccionWithConnection");connexion.begin();
			
			transaccionReturnGeneral =new TransaccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transaccionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			transaccionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transaccionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoTransa> tipotransasForeignKey=new ArrayList<TipoTransa>();
			TipoTransaLogic tipotransaLogic=new TipoTransaLogic();
			tipotransaLogic.setConnexion(this.connexion);
			tipotransaLogic.getTipoTransaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransa.equals("NONE")) {
				tipotransaLogic.getTodosTipoTransas(finalQueryGlobalTipoTransa,new Pagination());
				tipotransasForeignKey=tipotransaLogic.getTipoTransas();
			}

			transaccionReturnGeneral.settipotransasForeignKey(tipotransasForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			transaccionReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			transaccionReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			transaccionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			transaccionReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return transaccionReturnGeneral;
	}
	
	public TransaccionParameterReturnGeneral cargarCombosLoteForeignKeyTransaccion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTipoTransa,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContable) throws Exception {
		TransaccionParameterReturnGeneral  transaccionReturnGeneral =new TransaccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			transaccionReturnGeneral =new TransaccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transaccionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			transaccionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transaccionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoTransa> tipotransasForeignKey=new ArrayList<TipoTransa>();
			TipoTransaLogic tipotransaLogic=new TipoTransaLogic();
			tipotransaLogic.setConnexion(this.connexion);
			tipotransaLogic.getTipoTransaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransa.equals("NONE")) {
				tipotransaLogic.getTodosTipoTransas(finalQueryGlobalTipoTransa,new Pagination());
				tipotransasForeignKey=tipotransaLogic.getTipoTransas();
			}

			transaccionReturnGeneral.settipotransasForeignKey(tipotransasForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			transaccionReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			transaccionReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			transaccionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			transaccionReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return transaccionReturnGeneral;
	}
	
	
	public void deepLoad(Transaccion transaccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransaccionLogicAdditional.updateTransaccionToGet(transaccion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccion.setEmpresa(transaccionDataAccess.getEmpresa(connexion,transaccion));
		transaccion.setSucursal(transaccionDataAccess.getSucursal(connexion,transaccion));
		transaccion.setModulo(transaccionDataAccess.getModulo(connexion,transaccion));
		transaccion.setTipoTransa(transaccionDataAccess.getTipoTransa(connexion,transaccion));
		transaccion.setTipoComprobante(transaccionDataAccess.getTipoComprobante(connexion,transaccion));
		transaccion.setTipoTransaccionModulo(transaccionDataAccess.getTipoTransaccionModulo(connexion,transaccion));
		transaccion.setTipoRetencion(transaccionDataAccess.getTipoRetencion(connexion,transaccion));
		transaccion.setCuentaContable(transaccionDataAccess.getCuentaContable(connexion,transaccion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccion.setEmpresa(transaccionDataAccess.getEmpresa(connexion,transaccion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				transaccion.setSucursal(transaccionDataAccess.getSucursal(connexion,transaccion));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transaccion.setModulo(transaccionDataAccess.getModulo(connexion,transaccion));
				continue;
			}

			if(clas.clas.equals(TipoTransa.class)) {
				transaccion.setTipoTransa(transaccionDataAccess.getTipoTransa(connexion,transaccion));
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				transaccion.setTipoComprobante(transaccionDataAccess.getTipoComprobante(connexion,transaccion));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				transaccion.setTipoTransaccionModulo(transaccionDataAccess.getTipoTransaccionModulo(connexion,transaccion));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				transaccion.setTipoRetencion(transaccionDataAccess.getTipoRetencion(connexion,transaccion));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				transaccion.setCuentaContable(transaccionDataAccess.getCuentaContable(connexion,transaccion));
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
			transaccion.setEmpresa(transaccionDataAccess.getEmpresa(connexion,transaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setSucursal(transaccionDataAccess.getSucursal(connexion,transaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setModulo(transaccionDataAccess.getModulo(connexion,transaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoTransa(transaccionDataAccess.getTipoTransa(connexion,transaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoComprobante(transaccionDataAccess.getTipoComprobante(connexion,transaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoTransaccionModulo(transaccionDataAccess.getTipoTransaccionModulo(connexion,transaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoRetencion(transaccionDataAccess.getTipoRetencion(connexion,transaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setCuentaContable(transaccionDataAccess.getCuentaContable(connexion,transaccion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccion.setEmpresa(transaccionDataAccess.getEmpresa(connexion,transaccion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transaccion.getEmpresa(),isDeep,deepLoadType,clases);
				
		transaccion.setSucursal(transaccionDataAccess.getSucursal(connexion,transaccion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(transaccion.getSucursal(),isDeep,deepLoadType,clases);
				
		transaccion.setModulo(transaccionDataAccess.getModulo(connexion,transaccion));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transaccion.getModulo(),isDeep,deepLoadType,clases);
				
		transaccion.setTipoTransa(transaccionDataAccess.getTipoTransa(connexion,transaccion));
		TipoTransaLogic tipotransaLogic= new TipoTransaLogic(connexion);
		tipotransaLogic.deepLoad(transaccion.getTipoTransa(),isDeep,deepLoadType,clases);
				
		transaccion.setTipoComprobante(transaccionDataAccess.getTipoComprobante(connexion,transaccion));
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(transaccion.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		transaccion.setTipoTransaccionModulo(transaccionDataAccess.getTipoTransaccionModulo(connexion,transaccion));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(transaccion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		transaccion.setTipoRetencion(transaccionDataAccess.getTipoRetencion(connexion,transaccion));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(transaccion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		transaccion.setCuentaContable(transaccionDataAccess.getCuentaContable(connexion,transaccion));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(transaccion.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccion.setEmpresa(transaccionDataAccess.getEmpresa(connexion,transaccion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(transaccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				transaccion.setSucursal(transaccionDataAccess.getSucursal(connexion,transaccion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(transaccion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transaccion.setModulo(transaccionDataAccess.getModulo(connexion,transaccion));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(transaccion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransa.class)) {
				transaccion.setTipoTransa(transaccionDataAccess.getTipoTransa(connexion,transaccion));
				TipoTransaLogic tipotransaLogic= new TipoTransaLogic(connexion);
				tipotransaLogic.deepLoad(transaccion.getTipoTransa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				transaccion.setTipoComprobante(transaccionDataAccess.getTipoComprobante(connexion,transaccion));
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepLoad(transaccion.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				transaccion.setTipoTransaccionModulo(transaccionDataAccess.getTipoTransaccionModulo(connexion,transaccion));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(transaccion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				transaccion.setTipoRetencion(transaccionDataAccess.getTipoRetencion(connexion,transaccion));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(transaccion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				transaccion.setCuentaContable(transaccionDataAccess.getCuentaContable(connexion,transaccion));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(transaccion.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			transaccion.setEmpresa(transaccionDataAccess.getEmpresa(connexion,transaccion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(transaccion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setSucursal(transaccionDataAccess.getSucursal(connexion,transaccion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(transaccion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setModulo(transaccionDataAccess.getModulo(connexion,transaccion));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(transaccion.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoTransa(transaccionDataAccess.getTipoTransa(connexion,transaccion));
			TipoTransaLogic tipotransaLogic= new TipoTransaLogic(connexion);
			tipotransaLogic.deepLoad(transaccion.getTipoTransa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoComprobante(transaccionDataAccess.getTipoComprobante(connexion,transaccion));
			TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
			tipocomprobanteLogic.deepLoad(transaccion.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoTransaccionModulo(transaccionDataAccess.getTipoTransaccionModulo(connexion,transaccion));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(transaccion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setTipoRetencion(transaccionDataAccess.getTipoRetencion(connexion,transaccion));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(transaccion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccion.setCuentaContable(transaccionDataAccess.getCuentaContable(connexion,transaccion));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(transaccion.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Transaccion transaccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TransaccionLogicAdditional.updateTransaccionToSave(transaccion,this.arrDatoGeneral);
			
TransaccionDataAccess.save(transaccion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transaccion.getEmpresa(),connexion);

		SucursalDataAccess.save(transaccion.getSucursal(),connexion);

		ModuloDataAccess.save(transaccion.getModulo(),connexion);

		TipoTransaDataAccess.save(transaccion.getTipoTransa(),connexion);

		TipoComprobanteDataAccess.save(transaccion.getTipoComprobante(),connexion);

		TipoTransaccionModuloDataAccess.save(transaccion.getTipoTransaccionModulo(),connexion);

		TipoRetencionDataAccess.save(transaccion.getTipoRetencion(),connexion);

		CuentaContableDataAccess.save(transaccion.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transaccion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(transaccion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transaccion.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransa.class)) {
				TipoTransaDataAccess.save(transaccion.getTipoTransa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(transaccion.getTipoComprobante(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(transaccion.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(transaccion.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(transaccion.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transaccion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transaccion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(transaccion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(transaccion.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(transaccion.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transaccion.getModulo(),isDeep,deepLoadType,clases);
				

		TipoTransaDataAccess.save(transaccion.getTipoTransa(),connexion);
		TipoTransaLogic tipotransaLogic= new TipoTransaLogic(connexion);
		tipotransaLogic.deepLoad(transaccion.getTipoTransa(),isDeep,deepLoadType,clases);
				

		TipoComprobanteDataAccess.save(transaccion.getTipoComprobante(),connexion);
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(transaccion.getTipoComprobante(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(transaccion.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(transaccion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(transaccion.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(transaccion.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(transaccion.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(transaccion.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transaccion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(transaccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(transaccion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(transaccion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transaccion.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(transaccion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransa.class)) {
				TipoTransaDataAccess.save(transaccion.getTipoTransa(),connexion);
				TipoTransaLogic tipotransaLogic= new TipoTransaLogic(connexion);
				tipotransaLogic.deepSave(transaccion.getTipoTransa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(transaccion.getTipoComprobante(),connexion);
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepSave(transaccion.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(transaccion.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(transaccion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(transaccion.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(transaccion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(transaccion.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(transaccion.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Transaccion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(transaccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(transaccion);
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
			this.deepLoad(this.transaccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Transaccion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(transaccions!=null) {
				for(Transaccion transaccion:transaccions) {
					this.deepLoad(transaccion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(transaccions);
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
			if(transaccions!=null) {
				for(Transaccion transaccion:transaccions) {
					this.deepLoad(transaccion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(transaccions);
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
			this.getNewConnexionToDeep(Transaccion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(transaccion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Transaccion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(transaccions!=null) {
				for(Transaccion transaccion:transaccions) {
					this.deepSave(transaccion,isDeep,deepLoadType,clases);
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
			if(transaccions!=null) {
				for(Transaccion transaccion:transaccions) {
					this.deepSave(transaccion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTransaccionsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TransaccionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TransaccionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsBusquedaPorIdModuloPorTipoTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorTipoTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsBusquedaPorIdModuloPorTipoTransaccion(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorTipoTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TransaccionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TransaccionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TransaccionConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TransaccionConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransaccionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransaccionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdTipoComprobanteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,TransaccionConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdTipoComprobante(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,TransaccionConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,TransaccionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,TransaccionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdTipoTransaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transa,TransaccionConstantesFunciones.IDTIPOTRANSA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransa);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdTipoTransa(String sFinalQuery,Pagination pagination,Long id_tipo_transa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transa,TransaccionConstantesFunciones.IDTIPOTRANSA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransa);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionsFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionsFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionPorIdPorEmprePorSucuPorModuPorTipoTransaWithConnection(Long id,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_tipo_transaccion_modulo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TransaccionConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransaccionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			transaccion=transaccionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionPorIdPorEmprePorSucuPorModuPorTipoTransa(Long id,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_tipo_transaccion_modulo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TransaccionConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransaccionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			transaccion=transaccionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.transaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(this.transaccion);
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
			if(TransaccionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Transaccion transaccion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TransaccionConstantesFunciones.ISCONAUDITORIA) {
				if(transaccion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionDataAccess.TABLENAME, transaccion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionLogic.registrarAuditoriaDetallesTransaccion(connexion,transaccion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(transaccion.getIsDeleted()) {
					/*if(!transaccion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TransaccionDataAccess.TABLENAME, transaccion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TransaccionLogic.registrarAuditoriaDetallesTransaccion(connexion,transaccion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionDataAccess.TABLENAME, transaccion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(transaccion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionDataAccess.TABLENAME, transaccion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionLogic.registrarAuditoriaDetallesTransaccion(connexion,transaccion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTransaccion(Connexion connexion,Transaccion transaccion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(transaccion.getIsNew()||!transaccion.getid_empresa().equals(transaccion.getTransaccionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_empresa()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_empresa().toString();
				}
				if(transaccion.getid_empresa()!=null)
				{
					strValorNuevo=transaccion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getid_sucursal().equals(transaccion.getTransaccionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_sucursal()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_sucursal().toString();
				}
				if(transaccion.getid_sucursal()!=null)
				{
					strValorNuevo=transaccion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getcodigo().equals(transaccion.getTransaccionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getcodigo()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getcodigo();
				}
				if(transaccion.getcodigo()!=null)
				{
					strValorNuevo=transaccion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getnombre().equals(transaccion.getTransaccionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getnombre()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getnombre();
				}
				if(transaccion.getnombre()!=null)
				{
					strValorNuevo=transaccion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getid_modulo().equals(transaccion.getTransaccionOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_modulo()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_modulo().toString();
				}
				if(transaccion.getid_modulo()!=null)
				{
					strValorNuevo=transaccion.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getid_tipo_transa().equals(transaccion.getTransaccionOriginal().getid_tipo_transa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_tipo_transa()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_tipo_transa().toString();
				}
				if(transaccion.getid_tipo_transa()!=null)
				{
					strValorNuevo=transaccion.getid_tipo_transa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDTIPOTRANSA,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getid_tipo_comprobante().equals(transaccion.getTransaccionOriginal().getid_tipo_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_tipo_comprobante()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_tipo_comprobante().toString();
				}
				if(transaccion.getid_tipo_comprobante()!=null)
				{
					strValorNuevo=transaccion.getid_tipo_comprobante().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDTIPOCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getid_tipo_transaccion_modulo().equals(transaccion.getTransaccionOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(transaccion.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=transaccion.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getid_tipo_retencion().equals(transaccion.getTransaccionOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_tipo_retencion().toString();
				}
				if(transaccion.getid_tipo_retencion()!=null)
				{
					strValorNuevo=transaccion.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getid_cuenta_contable().equals(transaccion.getTransaccionOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getid_cuenta_contable().toString();
				}
				if(transaccion.getid_cuenta_contable()!=null)
				{
					strValorNuevo=transaccion.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(transaccion.getIsNew()||!transaccion.getdescripcion().equals(transaccion.getTransaccionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccion.getTransaccionOriginal().getdescripcion()!=null)
				{
					strValorActual=transaccion.getTransaccionOriginal().getdescripcion();
				}
				if(transaccion.getdescripcion()!=null)
				{
					strValorNuevo=transaccion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTransaccionRelacionesWithConnection(Transaccion transaccion) throws Exception {

		if(!transaccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionRelacionesBase(transaccion,true);
		}
	}

	public void saveTransaccionRelaciones(Transaccion transaccion)throws Exception {

		if(!transaccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionRelacionesBase(transaccion,false);
		}
	}

	public void saveTransaccionRelacionesBase(Transaccion transaccion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Transaccion-saveRelacionesWithConnection");}
	

			this.setTransaccion(transaccion);

			if(TransaccionLogicAdditional.validarSaveRelaciones(transaccion,this)) {

				TransaccionLogicAdditional.updateRelacionesToSave(transaccion,this);

				if((transaccion.getIsNew()||transaccion.getIsChanged())&&!transaccion.getIsDeleted()) {
					this.saveTransaccion();
					this.saveTransaccionRelacionesDetalles();

				} else if(transaccion.getIsDeleted()) {
					this.saveTransaccionRelacionesDetalles();
					this.saveTransaccion();
				}

				TransaccionLogicAdditional.updateRelacionesToSaveAfter(transaccion,this);

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
	
	
	private void saveTransaccionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionConstantesFunciones.getClassesForeignKeysOfTransaccion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionConstantesFunciones.getClassesRelationshipsOfTransaccion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
