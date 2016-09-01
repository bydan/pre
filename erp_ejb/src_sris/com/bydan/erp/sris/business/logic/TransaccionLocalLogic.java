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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.TransaccionLocalConstantesFunciones;
import com.bydan.erp.sris.util.TransaccionLocalParameterReturnGeneral;
//import com.bydan.erp.sris.util.TransaccionLocalParameterGeneral;
import com.bydan.erp.sris.business.entity.TransaccionLocal;
import com.bydan.erp.sris.business.logic.TransaccionLocalLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TransaccionLocalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TransaccionLocalLogic.class);
	
	protected TransaccionLocalDataAccess transaccionlocalDataAccess; 	
	protected TransaccionLocal transaccionlocal;
	protected List<TransaccionLocal> transaccionlocals;
	protected Object transaccionlocalObject;	
	protected List<Object> transaccionlocalsObject;
	
	public static ClassValidator<TransaccionLocal> transaccionlocalValidator = new ClassValidator<TransaccionLocal>(TransaccionLocal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TransaccionLocalLogicAdditional transaccionlocalLogicAdditional=null;
	
	public TransaccionLocalLogicAdditional getTransaccionLocalLogicAdditional() {
		return this.transaccionlocalLogicAdditional;
	}
	
	public void setTransaccionLocalLogicAdditional(TransaccionLocalLogicAdditional transaccionlocalLogicAdditional) {
		try {
			this.transaccionlocalLogicAdditional=transaccionlocalLogicAdditional;
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
	
	
	
	
	public  TransaccionLocalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.transaccionlocalDataAccess = new TransaccionLocalDataAccess();
			
			this.transaccionlocals= new ArrayList<TransaccionLocal>();
			this.transaccionlocal= new TransaccionLocal();
			
			this.transaccionlocalObject=new Object();
			this.transaccionlocalsObject=new ArrayList<Object>();
				
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
			
			this.transaccionlocalDataAccess.setConnexionType(this.connexionType);
			this.transaccionlocalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransaccionLocalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.transaccionlocalDataAccess = new TransaccionLocalDataAccess();
			this.transaccionlocals= new ArrayList<TransaccionLocal>();
			this.transaccionlocal= new TransaccionLocal();
			this.transaccionlocalObject=new Object();
			this.transaccionlocalsObject=new ArrayList<Object>();
			
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
			
			this.transaccionlocalDataAccess.setConnexionType(this.connexionType);
			this.transaccionlocalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TransaccionLocal getTransaccionLocal() throws Exception {	
		TransaccionLocalLogicAdditional.checkTransaccionLocalToGet(transaccionlocal,this.datosCliente,this.arrDatoGeneral);
		TransaccionLocalLogicAdditional.updateTransaccionLocalToGet(transaccionlocal,this.arrDatoGeneral);
		
		return transaccionlocal;
	}
		
	public void setTransaccionLocal(TransaccionLocal newTransaccionLocal) {
		this.transaccionlocal = newTransaccionLocal;
	}
	
	public TransaccionLocalDataAccess getTransaccionLocalDataAccess() {
		return transaccionlocalDataAccess;
	}
	
	public void setTransaccionLocalDataAccess(TransaccionLocalDataAccess newtransaccionlocalDataAccess) {
		this.transaccionlocalDataAccess = newtransaccionlocalDataAccess;
	}
	
	public List<TransaccionLocal> getTransaccionLocals() throws Exception {		
		this.quitarTransaccionLocalsNulos();
		
		TransaccionLocalLogicAdditional.checkTransaccionLocalToGets(transaccionlocals,this.datosCliente,this.arrDatoGeneral);
		
		for (TransaccionLocal transaccionlocalLocal: transaccionlocals ) {
			TransaccionLocalLogicAdditional.updateTransaccionLocalToGet(transaccionlocalLocal,this.arrDatoGeneral);
		}
		
		return transaccionlocals;
	}
	
	public void setTransaccionLocals(List<TransaccionLocal> newTransaccionLocals) {
		this.transaccionlocals = newTransaccionLocals;
	}
	
	public Object getTransaccionLocalObject() {	
		this.transaccionlocalObject=this.transaccionlocalDataAccess.getEntityObject();
		return this.transaccionlocalObject;
	}
		
	public void setTransaccionLocalObject(Object newTransaccionLocalObject) {
		this.transaccionlocalObject = newTransaccionLocalObject;
	}
	
	public List<Object> getTransaccionLocalsObject() {		
		this.transaccionlocalsObject=this.transaccionlocalDataAccess.getEntitiesObject();
		return this.transaccionlocalsObject;
	}
		
	public void setTransaccionLocalsObject(List<Object> newTransaccionLocalsObject) {
		this.transaccionlocalsObject = newTransaccionLocalsObject;
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
		
		if(this.transaccionlocalDataAccess!=null) {
			this.transaccionlocalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			transaccionlocalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			transaccionlocalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		transaccionlocal = new  TransaccionLocal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccionlocal=transaccionlocalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionlocal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocal);
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
		transaccionlocal = new  TransaccionLocal();
		  		  
        try {
			
			transaccionlocal=transaccionlocalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionlocal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		transaccionlocal = new  TransaccionLocal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccionlocal=transaccionlocalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionlocal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocal);
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
		transaccionlocal = new  TransaccionLocal();
		  		  
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
		transaccionlocal = new  TransaccionLocal();
		  		  
        try {
			
			transaccionlocal=transaccionlocalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionlocal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		transaccionlocal = new  TransaccionLocal();
		  		  
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
		transaccionlocal = new  TransaccionLocal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =transaccionlocalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccionlocal = new  TransaccionLocal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=transaccionlocalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccionlocal = new  TransaccionLocal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =transaccionlocalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccionlocal = new  TransaccionLocal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=transaccionlocalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccionlocal = new  TransaccionLocal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =transaccionlocalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccionlocal = new  TransaccionLocal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=transaccionlocalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
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
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
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
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
        try {			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
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
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
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
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
        try {
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
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
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
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
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		transaccionlocal = new  TransaccionLocal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocal=transaccionlocalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocal);
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
		transaccionlocal = new  TransaccionLocal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocal=transaccionlocalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
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
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		  		  
        try {
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTransaccionLocalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getTodosTransaccionLocalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
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
	
	public  void  getTodosTransaccionLocals(String sFinalQuery,Pagination pagination)throws Exception {
		transaccionlocals = new  ArrayList<TransaccionLocal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionLocal(transaccionlocals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTransaccionLocal(TransaccionLocal transaccionlocal) throws Exception {
		Boolean estaValidado=false;
		
		if(transaccionlocal.getIsNew() || transaccionlocal.getIsChanged()) { 
			this.invalidValues = transaccionlocalValidator.getInvalidValues(transaccionlocal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(transaccionlocal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTransaccionLocal(List<TransaccionLocal> TransaccionLocals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TransaccionLocal transaccionlocalLocal:transaccionlocals) {				
			estaValidadoObjeto=this.validarGuardarTransaccionLocal(transaccionlocalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTransaccionLocal(List<TransaccionLocal> TransaccionLocals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionLocal(transaccionlocals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTransaccionLocal(TransaccionLocal TransaccionLocal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionLocal(transaccionlocal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TransaccionLocal transaccionlocal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+transaccionlocal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TransaccionLocalConstantesFunciones.getTransaccionLocalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"transaccionlocal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TransaccionLocalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TransaccionLocalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTransaccionLocalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-saveTransaccionLocalWithConnection");connexion.begin();			
			
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSave(this.transaccionlocal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionLocalLogicAdditional.updateTransaccionLocalToSave(this.transaccionlocal,this.arrDatoGeneral);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccionlocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionLocal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionLocal(this.transaccionlocal)) {
				TransaccionLocalDataAccess.save(this.transaccionlocal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.transaccionlocal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSaveAfter(this.transaccionlocal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionLocal();
			
			connexion.commit();			
			
			if(this.transaccionlocal.getIsDeleted()) {
				this.transaccionlocal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTransaccionLocal()throws Exception {	
		try {	
			
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSave(this.transaccionlocal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionLocalLogicAdditional.updateTransaccionLocalToSave(this.transaccionlocal,this.arrDatoGeneral);
			
			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccionlocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionLocal(this.transaccionlocal)) {			
				TransaccionLocalDataAccess.save(this.transaccionlocal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.transaccionlocal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSaveAfter(this.transaccionlocal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.transaccionlocal.getIsDeleted()) {
				this.transaccionlocal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTransaccionLocalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-saveTransaccionLocalsWithConnection");connexion.begin();			
			
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSaves(transaccionlocals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionLocals();
			
			Boolean validadoTodosTransaccionLocal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionLocal transaccionlocalLocal:transaccionlocals) {		
				if(transaccionlocalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionLocalLogicAdditional.updateTransaccionLocalToSave(transaccionlocalLocal,this.arrDatoGeneral);
	        	
				TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccionlocalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionLocal(transaccionlocalLocal)) {
					TransaccionLocalDataAccess.save(transaccionlocalLocal, connexion);				
				} else {
					validadoTodosTransaccionLocal=false;
				}
			}
			
			if(!validadoTodosTransaccionLocal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSavesAfter(transaccionlocals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionLocals();
			
			connexion.commit();		
			
			this.quitarTransaccionLocalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTransaccionLocals()throws Exception {				
		 try {	
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSaves(transaccionlocals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTransaccionLocal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionLocal transaccionlocalLocal:transaccionlocals) {				
				if(transaccionlocalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionLocalLogicAdditional.updateTransaccionLocalToSave(transaccionlocalLocal,this.arrDatoGeneral);
	        	
				TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccionlocalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionLocal(transaccionlocalLocal)) {				
					TransaccionLocalDataAccess.save(transaccionlocalLocal, connexion);				
				} else {
					validadoTodosTransaccionLocal=false;
				}
			}
			
			if(!validadoTodosTransaccionLocal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionLocalLogicAdditional.checkTransaccionLocalToSavesAfter(transaccionlocals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTransaccionLocalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionLocalParameterReturnGeneral procesarAccionTransaccionLocals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionLocal> transaccionlocals,TransaccionLocalParameterReturnGeneral transaccionlocalParameterGeneral)throws Exception {
		 try {	
			TransaccionLocalParameterReturnGeneral transaccionlocalReturnGeneral=new TransaccionLocalParameterReturnGeneral();
	
			TransaccionLocalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccionlocals,transaccionlocalParameterGeneral,transaccionlocalReturnGeneral);
			
			return transaccionlocalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionLocalParameterReturnGeneral procesarAccionTransaccionLocalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionLocal> transaccionlocals,TransaccionLocalParameterReturnGeneral transaccionlocalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-procesarAccionTransaccionLocalsWithConnection");connexion.begin();			
			
			TransaccionLocalParameterReturnGeneral transaccionlocalReturnGeneral=new TransaccionLocalParameterReturnGeneral();
	
			TransaccionLocalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccionlocals,transaccionlocalParameterGeneral,transaccionlocalReturnGeneral);
			
			this.connexion.commit();
			
			return transaccionlocalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionLocalParameterReturnGeneral procesarEventosTransaccionLocals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionLocal> transaccionlocals,TransaccionLocal transaccionlocal,TransaccionLocalParameterReturnGeneral transaccionlocalParameterGeneral,Boolean isEsNuevoTransaccionLocal,ArrayList<Classe> clases)throws Exception {
		 try {	
			TransaccionLocalParameterReturnGeneral transaccionlocalReturnGeneral=new TransaccionLocalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccionlocalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionLocalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccionlocals,transaccionlocal,transaccionlocalParameterGeneral,transaccionlocalReturnGeneral,isEsNuevoTransaccionLocal,clases);
			
			return transaccionlocalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TransaccionLocalParameterReturnGeneral procesarEventosTransaccionLocalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionLocal> transaccionlocals,TransaccionLocal transaccionlocal,TransaccionLocalParameterReturnGeneral transaccionlocalParameterGeneral,Boolean isEsNuevoTransaccionLocal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-procesarEventosTransaccionLocalsWithConnection");connexion.begin();			
			
			TransaccionLocalParameterReturnGeneral transaccionlocalReturnGeneral=new TransaccionLocalParameterReturnGeneral();
	
			transaccionlocalReturnGeneral.setTransaccionLocal(transaccionlocal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccionlocalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionLocalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccionlocals,transaccionlocal,transaccionlocalParameterGeneral,transaccionlocalReturnGeneral,isEsNuevoTransaccionLocal,clases);
			
			this.connexion.commit();
			
			return transaccionlocalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionLocalParameterReturnGeneral procesarImportacionTransaccionLocalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TransaccionLocalParameterReturnGeneral transaccionlocalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-procesarImportacionTransaccionLocalsWithConnection");connexion.begin();			
			
			TransaccionLocalParameterReturnGeneral transaccionlocalReturnGeneral=new TransaccionLocalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.transaccionlocals=new ArrayList<TransaccionLocal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.transaccionlocal=new TransaccionLocal();
				
				
				if(conColumnasBase) {this.transaccionlocal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.transaccionlocal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.transaccionlocal.setruc(arrColumnas[iColumn++]);
				this.transaccionlocal.setrazon_social(arrColumnas[iColumn++]);
				this.transaccionlocal.setidentificacion(arrColumnas[iColumn++]);
				this.transaccionlocal.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.transaccionlocal.setfecha_registro_contable(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.transaccionlocal.setnumero_secuencial(arrColumnas[iColumn++]);
				this.transaccionlocal.setnumero_serie(arrColumnas[iColumn++]);
				this.transaccionlocal.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.transaccionlocal.setfecha_caducidad(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.transaccionlocal.setnumero_documento_contable(arrColumnas[iColumn++]);
				this.transaccionlocal.setes_rise(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.transaccionlocal.setbienes_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setbienes_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setservicios_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setservicios_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setmonto_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setmonto_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.settransfe_iva_retener(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setpresta_iva_retener(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.settransfe_iva_retenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setpresta_iva_retenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.transaccionlocal.setpermite_devolucion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.transaccionlocals.add(this.transaccionlocal);
			}
			
			this.saveTransaccionLocals();
			
			this.connexion.commit();
			
			transaccionlocalReturnGeneral.setConRetornoEstaProcesado(true);
			transaccionlocalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return transaccionlocalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTransaccionLocalsEliminados() throws Exception {				
		
		List<TransaccionLocal> transaccionlocalsAux= new ArrayList<TransaccionLocal>();
		
		for(TransaccionLocal transaccionlocal:transaccionlocals) {
			if(!transaccionlocal.getIsDeleted()) {
				transaccionlocalsAux.add(transaccionlocal);
			}
		}
		
		transaccionlocals=transaccionlocalsAux;
	}
	
	public void quitarTransaccionLocalsNulos() throws Exception {				
		
		List<TransaccionLocal> transaccionlocalsAux= new ArrayList<TransaccionLocal>();
		
		for(TransaccionLocal transaccionlocal : this.transaccionlocals) {
			if(transaccionlocal==null) {
				transaccionlocalsAux.add(transaccionlocal);
			}
		}
		
		//this.transaccionlocals=transaccionlocalsAux;
		
		this.transaccionlocals.removeAll(transaccionlocalsAux);
	}
	
	public void getSetVersionRowTransaccionLocalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(transaccionlocal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((transaccionlocal.getIsDeleted() || (transaccionlocal.getIsChanged()&&!transaccionlocal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=transaccionlocalDataAccess.getSetVersionRowTransaccionLocal(connexion,transaccionlocal.getId());
				
				if(!transaccionlocal.getVersionRow().equals(timestamp)) {	
					transaccionlocal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				transaccionlocal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTransaccionLocal()throws Exception {	
		
		if(transaccionlocal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((transaccionlocal.getIsDeleted() || (transaccionlocal.getIsChanged()&&!transaccionlocal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=transaccionlocalDataAccess.getSetVersionRowTransaccionLocal(connexion,transaccionlocal.getId());
			
			try {							
				if(!transaccionlocal.getVersionRow().equals(timestamp)) {	
					transaccionlocal.setVersionRow(timestamp);
				}
				
				transaccionlocal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTransaccionLocalsWithConnection()throws Exception {	
		if(transaccionlocals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TransaccionLocal transaccionlocalAux:transaccionlocals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(transaccionlocalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccionlocalAux.getIsDeleted() || (transaccionlocalAux.getIsChanged()&&!transaccionlocalAux.getIsNew())) {
						
						timestamp=transaccionlocalDataAccess.getSetVersionRowTransaccionLocal(connexion,transaccionlocalAux.getId());
						
						if(!transaccionlocal.getVersionRow().equals(timestamp)) {	
							transaccionlocalAux.setVersionRow(timestamp);
						}
								
						transaccionlocalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTransaccionLocals()throws Exception {	
		if(transaccionlocals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TransaccionLocal transaccionlocalAux:transaccionlocals) {
					if(transaccionlocalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccionlocalAux.getIsDeleted() || (transaccionlocalAux.getIsChanged()&&!transaccionlocalAux.getIsNew())) {
						
						timestamp=transaccionlocalDataAccess.getSetVersionRowTransaccionLocal(connexion,transaccionlocalAux.getId());
						
						if(!transaccionlocalAux.getVersionRow().equals(timestamp)) {	
							transaccionlocalAux.setVersionRow(timestamp);
						}
						
													
						transaccionlocalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TransaccionLocalParameterReturnGeneral cargarCombosLoteForeignKeyTransaccionLocalWithConnection(String finalQueryGlobalCompra,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalTransaccionConta,String finalQueryGlobalCliente,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTributario,String finalQueryGlobalAsientoContable,String finalQueryGlobalTipoIva,String finalQueryGlobalTipoRetencionIva,String finalQueryGlobalTipoRetencionIvaPresta) throws Exception {
		TransaccionLocalParameterReturnGeneral  transaccionlocalReturnGeneral =new TransaccionLocalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-cargarCombosLoteForeignKeyTransaccionLocalWithConnection");connexion.begin();
			
			transaccionlocalReturnGeneral =new TransaccionLocalParameterReturnGeneral();
			
			

			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			transaccionlocalReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			transaccionlocalReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<TransaccionConta> transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
			TransaccionContaLogic transaccioncontaLogic=new TransaccionContaLogic();
			transaccioncontaLogic.setConnexion(this.connexion);
			transaccioncontaLogic.getTransaccionContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionConta.equals("NONE")) {
				transaccioncontaLogic.getTodosTransaccionContas(finalQueryGlobalTransaccionConta,new Pagination());
				transaccioncontasForeignKey=transaccioncontaLogic.getTransaccionContas();
			}

			transaccionlocalReturnGeneral.settransaccioncontasForeignKey(transaccioncontasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			transaccionlocalReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			transaccionlocalReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			transaccionlocalReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			transaccionlocalReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			transaccionlocalReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);


			List<TipoRetencionIva> tiporetencionivasForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaLogic=new TipoRetencionIvaLogic();
			tiporetencionivaLogic.setConnexion(this.connexion);
			tiporetencionivaLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva.equals("NONE")) {
				tiporetencionivaLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIva,new Pagination());
				tiporetencionivasForeignKey=tiporetencionivaLogic.getTipoRetencionIvas();
			}

			transaccionlocalReturnGeneral.settiporetencionivasForeignKey(tiporetencionivasForeignKey);


			List<TipoRetencionIva> tiporetencionivaprestasForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaprestaLogic=new TipoRetencionIvaLogic();
			tiporetencionivaprestaLogic.setConnexion(this.connexion);
			tiporetencionivaprestaLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaPresta.equals("NONE")) {
				tiporetencionivaprestaLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIvaPresta,new Pagination());
				tiporetencionivaprestasForeignKey=tiporetencionivaprestaLogic.getTipoRetencionIvas();
			}

			transaccionlocalReturnGeneral.settiporetencionivaprestasForeignKey(tiporetencionivaprestasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return transaccionlocalReturnGeneral;
	}
	
	public TransaccionLocalParameterReturnGeneral cargarCombosLoteForeignKeyTransaccionLocal(String finalQueryGlobalCompra,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalTransaccionConta,String finalQueryGlobalCliente,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTributario,String finalQueryGlobalAsientoContable,String finalQueryGlobalTipoIva,String finalQueryGlobalTipoRetencionIva,String finalQueryGlobalTipoRetencionIvaPresta) throws Exception {
		TransaccionLocalParameterReturnGeneral  transaccionlocalReturnGeneral =new TransaccionLocalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			transaccionlocalReturnGeneral =new TransaccionLocalParameterReturnGeneral();
			
			

			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			transaccionlocalReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			transaccionlocalReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<TransaccionConta> transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
			TransaccionContaLogic transaccioncontaLogic=new TransaccionContaLogic();
			transaccioncontaLogic.setConnexion(this.connexion);
			transaccioncontaLogic.getTransaccionContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionConta.equals("NONE")) {
				transaccioncontaLogic.getTodosTransaccionContas(finalQueryGlobalTransaccionConta,new Pagination());
				transaccioncontasForeignKey=transaccioncontaLogic.getTransaccionContas();
			}

			transaccionlocalReturnGeneral.settransaccioncontasForeignKey(transaccioncontasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			transaccionlocalReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			transaccionlocalReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			transaccionlocalReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			transaccionlocalReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			transaccionlocalReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);


			List<TipoRetencionIva> tiporetencionivasForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaLogic=new TipoRetencionIvaLogic();
			tiporetencionivaLogic.setConnexion(this.connexion);
			tiporetencionivaLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva.equals("NONE")) {
				tiporetencionivaLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIva,new Pagination());
				tiporetencionivasForeignKey=tiporetencionivaLogic.getTipoRetencionIvas();
			}

			transaccionlocalReturnGeneral.settiporetencionivasForeignKey(tiporetencionivasForeignKey);


			List<TipoRetencionIva> tiporetencionivaprestasForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaprestaLogic=new TipoRetencionIvaLogic();
			tiporetencionivaprestaLogic.setConnexion(this.connexion);
			tiporetencionivaprestaLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIvaPresta.equals("NONE")) {
				tiporetencionivaprestaLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIvaPresta,new Pagination());
				tiporetencionivaprestasForeignKey=tiporetencionivaprestaLogic.getTipoRetencionIvas();
			}

			transaccionlocalReturnGeneral.settiporetencionivaprestasForeignKey(tiporetencionivaprestasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return transaccionlocalReturnGeneral;
	}
	
	
	public void deepLoad(TransaccionLocal transaccionlocal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransaccionLocalLogicAdditional.updateTransaccionLocalToGet(transaccionlocal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccionlocal.setCompra(transaccionlocalDataAccess.getCompra(connexion,transaccionlocal));
		transaccionlocal.setPeriodoDeclara(transaccionlocalDataAccess.getPeriodoDeclara(connexion,transaccionlocal));
		transaccionlocal.setTransaccionConta(transaccionlocalDataAccess.getTransaccionConta(connexion,transaccionlocal));
		transaccionlocal.setCliente(transaccionlocalDataAccess.getCliente(connexion,transaccionlocal));
		transaccionlocal.setTipoComprobante(transaccionlocalDataAccess.getTipoComprobante(connexion,transaccionlocal));
		transaccionlocal.setTipoTributario(transaccionlocalDataAccess.getTipoTributario(connexion,transaccionlocal));
		transaccionlocal.setAsientoContable(transaccionlocalDataAccess.getAsientoContable(connexion,transaccionlocal));
		transaccionlocal.setTipoIva(transaccionlocalDataAccess.getTipoIva(connexion,transaccionlocal));
		transaccionlocal.setTipoRetencionIva(transaccionlocalDataAccess.getTipoRetencionIva(connexion,transaccionlocal));
		transaccionlocal.setTipoRetencionIvaPresta(transaccionlocalDataAccess.getTipoRetencionIvaPresta(connexion,transaccionlocal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				transaccionlocal.setCompra(transaccionlocalDataAccess.getCompra(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				transaccionlocal.setPeriodoDeclara(transaccionlocalDataAccess.getPeriodoDeclara(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				transaccionlocal.setTransaccionConta(transaccionlocalDataAccess.getTransaccionConta(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				transaccionlocal.setCliente(transaccionlocalDataAccess.getCliente(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				transaccionlocal.setTipoComprobante(transaccionlocalDataAccess.getTipoComprobante(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				transaccionlocal.setTipoTributario(transaccionlocalDataAccess.getTipoTributario(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				transaccionlocal.setAsientoContable(transaccionlocalDataAccess.getAsientoContable(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				transaccionlocal.setTipoIva(transaccionlocalDataAccess.getTipoIva(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				transaccionlocal.setTipoRetencionIva(transaccionlocalDataAccess.getTipoRetencionIva(connexion,transaccionlocal));
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				transaccionlocal.setTipoRetencionIvaPresta(transaccionlocalDataAccess.getTipoRetencionIvaPresta(connexion,transaccionlocal));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setCompra(transaccionlocalDataAccess.getCompra(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setPeriodoDeclara(transaccionlocalDataAccess.getPeriodoDeclara(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTransaccionConta(transaccionlocalDataAccess.getTransaccionConta(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setCliente(transaccionlocalDataAccess.getCliente(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoComprobante(transaccionlocalDataAccess.getTipoComprobante(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoTributario(transaccionlocalDataAccess.getTipoTributario(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setAsientoContable(transaccionlocalDataAccess.getAsientoContable(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoIva(transaccionlocalDataAccess.getTipoIva(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoRetencionIva(transaccionlocalDataAccess.getTipoRetencionIva(connexion,transaccionlocal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoRetencionIvaPresta(transaccionlocalDataAccess.getTipoRetencionIvaPresta(connexion,transaccionlocal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccionlocal.setCompra(transaccionlocalDataAccess.getCompra(connexion,transaccionlocal));
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(transaccionlocal.getCompra(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setPeriodoDeclara(transaccionlocalDataAccess.getPeriodoDeclara(connexion,transaccionlocal));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(transaccionlocal.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setTransaccionConta(transaccionlocalDataAccess.getTransaccionConta(connexion,transaccionlocal));
		TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
		transaccioncontaLogic.deepLoad(transaccionlocal.getTransaccionConta(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setCliente(transaccionlocalDataAccess.getCliente(connexion,transaccionlocal));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(transaccionlocal.getCliente(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setTipoComprobante(transaccionlocalDataAccess.getTipoComprobante(connexion,transaccionlocal));
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(transaccionlocal.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setTipoTributario(transaccionlocalDataAccess.getTipoTributario(connexion,transaccionlocal));
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(transaccionlocal.getTipoTributario(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setAsientoContable(transaccionlocalDataAccess.getAsientoContable(connexion,transaccionlocal));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(transaccionlocal.getAsientoContable(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setTipoIva(transaccionlocalDataAccess.getTipoIva(connexion,transaccionlocal));
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(transaccionlocal.getTipoIva(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setTipoRetencionIva(transaccionlocalDataAccess.getTipoRetencionIva(connexion,transaccionlocal));
		TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaLogic.deepLoad(transaccionlocal.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		transaccionlocal.setTipoRetencionIvaPresta(transaccionlocalDataAccess.getTipoRetencionIvaPresta(connexion,transaccionlocal));
		TipoRetencionIvaLogic tiporetencionivaprestaLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaprestaLogic.deepLoad(transaccionlocal.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				transaccionlocal.setCompra(transaccionlocalDataAccess.getCompra(connexion,transaccionlocal));
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepLoad(transaccionlocal.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				transaccionlocal.setPeriodoDeclara(transaccionlocalDataAccess.getPeriodoDeclara(connexion,transaccionlocal));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(transaccionlocal.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				transaccionlocal.setTransaccionConta(transaccionlocalDataAccess.getTransaccionConta(connexion,transaccionlocal));
				TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
				transaccioncontaLogic.deepLoad(transaccionlocal.getTransaccionConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				transaccionlocal.setCliente(transaccionlocalDataAccess.getCliente(connexion,transaccionlocal));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(transaccionlocal.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				transaccionlocal.setTipoComprobante(transaccionlocalDataAccess.getTipoComprobante(connexion,transaccionlocal));
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepLoad(transaccionlocal.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				transaccionlocal.setTipoTributario(transaccionlocalDataAccess.getTipoTributario(connexion,transaccionlocal));
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepLoad(transaccionlocal.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				transaccionlocal.setAsientoContable(transaccionlocalDataAccess.getAsientoContable(connexion,transaccionlocal));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(transaccionlocal.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				transaccionlocal.setTipoIva(transaccionlocalDataAccess.getTipoIva(connexion,transaccionlocal));
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepLoad(transaccionlocal.getTipoIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				transaccionlocal.setTipoRetencionIva(transaccionlocalDataAccess.getTipoRetencionIva(connexion,transaccionlocal));
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepLoad(transaccionlocal.getTipoRetencionIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				transaccionlocal.setTipoRetencionIvaPresta(transaccionlocalDataAccess.getTipoRetencionIvaPresta(connexion,transaccionlocal));
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepLoad(transaccionlocal.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setCompra(transaccionlocalDataAccess.getCompra(connexion,transaccionlocal));
			CompraLogic compraLogic= new CompraLogic(connexion);
			compraLogic.deepLoad(transaccionlocal.getCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setPeriodoDeclara(transaccionlocalDataAccess.getPeriodoDeclara(connexion,transaccionlocal));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(transaccionlocal.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTransaccionConta(transaccionlocalDataAccess.getTransaccionConta(connexion,transaccionlocal));
			TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
			transaccioncontaLogic.deepLoad(transaccionlocal.getTransaccionConta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setCliente(transaccionlocalDataAccess.getCliente(connexion,transaccionlocal));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(transaccionlocal.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoComprobante(transaccionlocalDataAccess.getTipoComprobante(connexion,transaccionlocal));
			TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
			tipocomprobanteLogic.deepLoad(transaccionlocal.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoTributario(transaccionlocalDataAccess.getTipoTributario(connexion,transaccionlocal));
			TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
			tipotributarioLogic.deepLoad(transaccionlocal.getTipoTributario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setAsientoContable(transaccionlocalDataAccess.getAsientoContable(connexion,transaccionlocal));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(transaccionlocal.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoIva(transaccionlocalDataAccess.getTipoIva(connexion,transaccionlocal));
			TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
			tipoivaLogic.deepLoad(transaccionlocal.getTipoIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoRetencionIva(transaccionlocalDataAccess.getTipoRetencionIva(connexion,transaccionlocal));
			TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
			tiporetencionivaLogic.deepLoad(transaccionlocal.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccionlocal.setTipoRetencionIvaPresta(transaccionlocalDataAccess.getTipoRetencionIvaPresta(connexion,transaccionlocal));
			TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
			tiporetencionivaLogic.deepLoad(transaccionlocal.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TransaccionLocal transaccionlocal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TransaccionLocalLogicAdditional.updateTransaccionLocalToSave(transaccionlocal,this.arrDatoGeneral);
			
TransaccionLocalDataAccess.save(transaccionlocal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CompraDataAccess.save(transaccionlocal.getCompra(),connexion);

		PeriodoDeclaraDataAccess.save(transaccionlocal.getPeriodoDeclara(),connexion);

		TransaccionContaDataAccess.save(transaccionlocal.getTransaccionConta(),connexion);

		ClienteDataAccess.save(transaccionlocal.getCliente(),connexion);

		TipoComprobanteDataAccess.save(transaccionlocal.getTipoComprobante(),connexion);

		TipoTributarioDataAccess.save(transaccionlocal.getTipoTributario(),connexion);

		AsientoContableDataAccess.save(transaccionlocal.getAsientoContable(),connexion);

		TipoIvaDataAccess.save(transaccionlocal.getTipoIva(),connexion);

		TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIva(),connexion);

		TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIvaPresta(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(transaccionlocal.getCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(transaccionlocal.getPeriodoDeclara(),connexion);
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				TransaccionContaDataAccess.save(transaccionlocal.getTransaccionConta(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(transaccionlocal.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(transaccionlocal.getTipoComprobante(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(transaccionlocal.getTipoTributario(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(transaccionlocal.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(transaccionlocal.getTipoIva(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIva(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIvaPresta(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CompraDataAccess.save(transaccionlocal.getCompra(),connexion);
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(transaccionlocal.getCompra(),isDeep,deepLoadType,clases);
				

		PeriodoDeclaraDataAccess.save(transaccionlocal.getPeriodoDeclara(),connexion);
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(transaccionlocal.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				

		TransaccionContaDataAccess.save(transaccionlocal.getTransaccionConta(),connexion);
		TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
		transaccioncontaLogic.deepLoad(transaccionlocal.getTransaccionConta(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(transaccionlocal.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(transaccionlocal.getCliente(),isDeep,deepLoadType,clases);
				

		TipoComprobanteDataAccess.save(transaccionlocal.getTipoComprobante(),connexion);
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(transaccionlocal.getTipoComprobante(),isDeep,deepLoadType,clases);
				

		TipoTributarioDataAccess.save(transaccionlocal.getTipoTributario(),connexion);
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(transaccionlocal.getTipoTributario(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(transaccionlocal.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(transaccionlocal.getAsientoContable(),isDeep,deepLoadType,clases);
				

		TipoIvaDataAccess.save(transaccionlocal.getTipoIva(),connexion);
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(transaccionlocal.getTipoIva(),isDeep,deepLoadType,clases);
				

		TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIva(),connexion);
		TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaLogic.deepLoad(transaccionlocal.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				

		TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIvaPresta(),connexion);
		TipoRetencionIvaLogic tiporetencionivaprestaLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaprestaLogic.deepLoad(transaccionlocal.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(transaccionlocal.getCompra(),connexion);
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepSave(transaccionlocal.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(transaccionlocal.getPeriodoDeclara(),connexion);
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepSave(transaccionlocal.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				TransaccionContaDataAccess.save(transaccionlocal.getTransaccionConta(),connexion);
				TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
				transaccioncontaLogic.deepSave(transaccionlocal.getTransaccionConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(transaccionlocal.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(transaccionlocal.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(transaccionlocal.getTipoComprobante(),connexion);
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepSave(transaccionlocal.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(transaccionlocal.getTipoTributario(),connexion);
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepSave(transaccionlocal.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(transaccionlocal.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(transaccionlocal.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(transaccionlocal.getTipoIva(),connexion);
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepSave(transaccionlocal.getTipoIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIva(),connexion);
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepSave(transaccionlocal.getTipoRetencionIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(transaccionlocal.getTipoRetencionIvaPresta(),connexion);
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepSave(transaccionlocal.getTipoRetencionIvaPresta(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TransaccionLocal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocal);
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
			this.deepLoad(this.transaccionlocal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TransaccionLocal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(transaccionlocals!=null) {
				for(TransaccionLocal transaccionlocal:transaccionlocals) {
					this.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocals);
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
			if(transaccionlocals!=null) {
				for(TransaccionLocal transaccionlocal:transaccionlocals) {
					this.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocals);
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
			this.getNewConnexionToDeep(TransaccionLocal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(transaccionlocal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TransaccionLocal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(transaccionlocals!=null) {
				for(TransaccionLocal transaccionlocal:transaccionlocals) {
					this.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
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
			if(transaccionlocals!=null) {
				for(TransaccionLocal transaccionlocal:transaccionlocals) {
					this.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTransaccionLocalsFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,TransaccionLocalConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,TransaccionLocalConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,TransaccionLocalConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdCompra(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,TransaccionLocalConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdPeriodoDeclaraWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,TransaccionLocalConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdPeriodoDeclara(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,TransaccionLocalConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdTipoComprobanteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdTipoComprobante(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdTipoIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,TransaccionLocalConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdTipoIva(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,TransaccionLocalConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdTipoRetencionIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva,TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdTipoRetencionIva(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva,TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdTipoRetencionIvaPrestaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_presta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaPresta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaPresta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_presta,TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaPresta);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaPresta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdTipoRetencionIvaPresta(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva_presta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIvaPresta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIvaPresta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva_presta,TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIvaPresta);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIvaPresta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdTipoTributarioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdTipoTributario(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionLocalsFK_IdTransaccionContaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_conta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionLocal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_conta,TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionConta);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionLocalsFK_IdTransaccionConta(String sFinalQuery,Pagination pagination,Long id_transaccion_conta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_conta,TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionConta);

			TransaccionLocalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(this.transaccionlocals);
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
			if(TransaccionLocalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionLocalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TransaccionLocal transaccionlocal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TransaccionLocalConstantesFunciones.ISCONAUDITORIA) {
				if(transaccionlocal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionLocalDataAccess.TABLENAME, transaccionlocal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionLocalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionLocalLogic.registrarAuditoriaDetallesTransaccionLocal(connexion,transaccionlocal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(transaccionlocal.getIsDeleted()) {
					/*if(!transaccionlocal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TransaccionLocalDataAccess.TABLENAME, transaccionlocal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TransaccionLocalLogic.registrarAuditoriaDetallesTransaccionLocal(connexion,transaccionlocal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionLocalDataAccess.TABLENAME, transaccionlocal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(transaccionlocal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionLocalDataAccess.TABLENAME, transaccionlocal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionLocalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionLocalLogic.registrarAuditoriaDetallesTransaccionLocal(connexion,transaccionlocal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTransaccionLocal(Connexion connexion,TransaccionLocal transaccionlocal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_compra().equals(transaccionlocal.getTransaccionLocalOriginal().getid_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_compra()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_compra().toString();
				}
				if(transaccionlocal.getid_compra()!=null)
				{
					strValorNuevo=transaccionlocal.getid_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getruc().equals(transaccionlocal.getTransaccionLocalOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getruc()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getruc();
				}
				if(transaccionlocal.getruc()!=null)
				{
					strValorNuevo=transaccionlocal.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getrazon_social().equals(transaccionlocal.getTransaccionLocalOriginal().getrazon_social()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getrazon_social()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getrazon_social();
				}
				if(transaccionlocal.getrazon_social()!=null)
				{
					strValorNuevo=transaccionlocal.getrazon_social() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.RAZONSOCIAL,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_periodo_declara().equals(transaccionlocal.getTransaccionLocalOriginal().getid_periodo_declara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_periodo_declara()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_periodo_declara().toString();
				}
				if(transaccionlocal.getid_periodo_declara()!=null)
				{
					strValorNuevo=transaccionlocal.getid_periodo_declara().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDPERIODODECLARA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_transaccion_conta().equals(transaccionlocal.getTransaccionLocalOriginal().getid_transaccion_conta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_transaccion_conta()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_transaccion_conta().toString();
				}
				if(transaccionlocal.getid_transaccion_conta()!=null)
				{
					strValorNuevo=transaccionlocal.getid_transaccion_conta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_cliente().equals(transaccionlocal.getTransaccionLocalOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_cliente()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_cliente().toString();
				}
				if(transaccionlocal.getid_cliente()!=null)
				{
					strValorNuevo=transaccionlocal.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getidentificacion().equals(transaccionlocal.getTransaccionLocalOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getidentificacion()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getidentificacion();
				}
				if(transaccionlocal.getidentificacion()!=null)
				{
					strValorNuevo=transaccionlocal.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_tipo_comprobante().equals(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_comprobante()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_tipo_comprobante().toString();
				}
				if(transaccionlocal.getid_tipo_comprobante()!=null)
				{
					strValorNuevo=transaccionlocal.getid_tipo_comprobante().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getfecha_emision().equals(transaccionlocal.getTransaccionLocalOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getfecha_emision()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getfecha_emision().toString();
				}
				if(transaccionlocal.getfecha_emision()!=null)
				{
					strValorNuevo=transaccionlocal.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getfecha_registro_contable().equals(transaccionlocal.getTransaccionLocalOriginal().getfecha_registro_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getfecha_registro_contable()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getfecha_registro_contable().toString();
				}
				if(transaccionlocal.getfecha_registro_contable()!=null)
				{
					strValorNuevo=transaccionlocal.getfecha_registro_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getnumero_secuencial().equals(transaccionlocal.getTransaccionLocalOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getnumero_secuencial();
				}
				if(transaccionlocal.getnumero_secuencial()!=null)
				{
					strValorNuevo=transaccionlocal.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getnumero_serie().equals(transaccionlocal.getTransaccionLocalOriginal().getnumero_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getnumero_serie()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getnumero_serie();
				}
				if(transaccionlocal.getnumero_serie()!=null)
				{
					strValorNuevo=transaccionlocal.getnumero_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.NUMEROSERIE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getnumero_autorizacion().equals(transaccionlocal.getTransaccionLocalOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getnumero_autorizacion();
				}
				if(transaccionlocal.getnumero_autorizacion()!=null)
				{
					strValorNuevo=transaccionlocal.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getfecha_caducidad().equals(transaccionlocal.getTransaccionLocalOriginal().getfecha_caducidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getfecha_caducidad()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getfecha_caducidad().toString();
				}
				if(transaccionlocal.getfecha_caducidad()!=null)
				{
					strValorNuevo=transaccionlocal.getfecha_caducidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.FECHACADUCIDAD,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_tipo_tributario().equals(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_tributario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_tributario()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_tipo_tributario().toString();
				}
				if(transaccionlocal.getid_tipo_tributario()!=null)
				{
					strValorNuevo=transaccionlocal.getid_tipo_tributario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getnumero_documento_contable().equals(transaccionlocal.getTransaccionLocalOriginal().getnumero_documento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getnumero_documento_contable()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getnumero_documento_contable();
				}
				if(transaccionlocal.getnumero_documento_contable()!=null)
				{
					strValorNuevo=transaccionlocal.getnumero_documento_contable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_asiento_contable().equals(transaccionlocal.getTransaccionLocalOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_asiento_contable().toString();
				}
				if(transaccionlocal.getid_asiento_contable()!=null)
				{
					strValorNuevo=transaccionlocal.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getes_rise().equals(transaccionlocal.getTransaccionLocalOriginal().getes_rise()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getes_rise()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getes_rise().toString();
				}
				if(transaccionlocal.getes_rise()!=null)
				{
					strValorNuevo=transaccionlocal.getes_rise().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.ESRISE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getbienes_iva().equals(transaccionlocal.getTransaccionLocalOriginal().getbienes_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getbienes_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getbienes_iva().toString();
				}
				if(transaccionlocal.getbienes_iva()!=null)
				{
					strValorNuevo=transaccionlocal.getbienes_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.BIENESIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getbienes_sin_iva().equals(transaccionlocal.getTransaccionLocalOriginal().getbienes_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getbienes_sin_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getbienes_sin_iva().toString();
				}
				if(transaccionlocal.getbienes_sin_iva()!=null)
				{
					strValorNuevo=transaccionlocal.getbienes_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.BIENESSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_tipo_iva().equals(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_tipo_iva().toString();
				}
				if(transaccionlocal.getid_tipo_iva()!=null)
				{
					strValorNuevo=transaccionlocal.getid_tipo_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDTIPOIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getservicios_iva().equals(transaccionlocal.getTransaccionLocalOriginal().getservicios_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getservicios_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getservicios_iva().toString();
				}
				if(transaccionlocal.getservicios_iva()!=null)
				{
					strValorNuevo=transaccionlocal.getservicios_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.SERVICIOSIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getservicios_sin_iva().equals(transaccionlocal.getTransaccionLocalOriginal().getservicios_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getservicios_sin_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getservicios_sin_iva().toString();
				}
				if(transaccionlocal.getservicios_sin_iva()!=null)
				{
					strValorNuevo=transaccionlocal.getservicios_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.SERVICIOSSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getmonto_iva().equals(transaccionlocal.getTransaccionLocalOriginal().getmonto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getmonto_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getmonto_iva().toString();
				}
				if(transaccionlocal.getmonto_iva()!=null)
				{
					strValorNuevo=transaccionlocal.getmonto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.MONTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.gettotal_iva().equals(transaccionlocal.getTransaccionLocalOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().gettotal_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().gettotal_iva().toString();
				}
				if(transaccionlocal.gettotal_iva()!=null)
				{
					strValorNuevo=transaccionlocal.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.gettotal_sin_iva().equals(transaccionlocal.getTransaccionLocalOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().gettotal_sin_iva().toString();
				}
				if(transaccionlocal.gettotal_sin_iva()!=null)
				{
					strValorNuevo=transaccionlocal.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getmonto_ice().equals(transaccionlocal.getTransaccionLocalOriginal().getmonto_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getmonto_ice()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getmonto_ice().toString();
				}
				if(transaccionlocal.getmonto_ice()!=null)
				{
					strValorNuevo=transaccionlocal.getmonto_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.MONTOICE,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.gettransfe_iva_retener().equals(transaccionlocal.getTransaccionLocalOriginal().gettransfe_iva_retener()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().gettransfe_iva_retener()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().gettransfe_iva_retener().toString();
				}
				if(transaccionlocal.gettransfe_iva_retener()!=null)
				{
					strValorNuevo=transaccionlocal.gettransfe_iva_retener().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.TRANSFEIVARETENER,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getpresta_iva_retener().equals(transaccionlocal.getTransaccionLocalOriginal().getpresta_iva_retener()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getpresta_iva_retener()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getpresta_iva_retener().toString();
				}
				if(transaccionlocal.getpresta_iva_retener()!=null)
				{
					strValorNuevo=transaccionlocal.getpresta_iva_retener().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.PRESTAIVARETENER,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_tipo_retencion_iva().equals(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_retencion_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_retencion_iva()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_tipo_retencion_iva().toString();
				}
				if(transaccionlocal.getid_tipo_retencion_iva()!=null)
				{
					strValorNuevo=transaccionlocal.getid_tipo_retencion_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getid_tipo_retencion_iva_presta().equals(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_retencion_iva_presta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getid_tipo_retencion_iva_presta()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getid_tipo_retencion_iva_presta().toString();
				}
				if(transaccionlocal.getid_tipo_retencion_iva_presta()!=null)
				{
					strValorNuevo=transaccionlocal.getid_tipo_retencion_iva_presta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.gettransfe_iva_retenido().equals(transaccionlocal.getTransaccionLocalOriginal().gettransfe_iva_retenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().gettransfe_iva_retenido()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().gettransfe_iva_retenido().toString();
				}
				if(transaccionlocal.gettransfe_iva_retenido()!=null)
				{
					strValorNuevo=transaccionlocal.gettransfe_iva_retenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getpresta_iva_retenido().equals(transaccionlocal.getTransaccionLocalOriginal().getpresta_iva_retenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getpresta_iva_retenido()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getpresta_iva_retenido().toString();
				}
				if(transaccionlocal.getpresta_iva_retenido()!=null)
				{
					strValorNuevo=transaccionlocal.getpresta_iva_retenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO,strValorActual,strValorNuevo);
			}	
			
			if(transaccionlocal.getIsNew()||!transaccionlocal.getpermite_devolucion().equals(transaccionlocal.getTransaccionLocalOriginal().getpermite_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionlocal.getTransaccionLocalOriginal().getpermite_devolucion()!=null)
				{
					strValorActual=transaccionlocal.getTransaccionLocalOriginal().getpermite_devolucion().toString();
				}
				if(transaccionlocal.getpermite_devolucion()!=null)
				{
					strValorNuevo=transaccionlocal.getpermite_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTransaccionLocalRelacionesWithConnection(TransaccionLocal transaccionlocal) throws Exception {

		if(!transaccionlocal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionLocalRelacionesBase(transaccionlocal,true);
		}
	}

	public void saveTransaccionLocalRelaciones(TransaccionLocal transaccionlocal)throws Exception {

		if(!transaccionlocal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionLocalRelacionesBase(transaccionlocal,false);
		}
	}

	public void saveTransaccionLocalRelacionesBase(TransaccionLocal transaccionlocal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TransaccionLocal-saveRelacionesWithConnection");}
	

			this.setTransaccionLocal(transaccionlocal);

			if(TransaccionLocalLogicAdditional.validarSaveRelaciones(transaccionlocal,this)) {

				TransaccionLocalLogicAdditional.updateRelacionesToSave(transaccionlocal,this);

				if((transaccionlocal.getIsNew()||transaccionlocal.getIsChanged())&&!transaccionlocal.getIsDeleted()) {
					this.saveTransaccionLocal();
					this.saveTransaccionLocalRelacionesDetalles();

				} else if(transaccionlocal.getIsDeleted()) {
					this.saveTransaccionLocalRelacionesDetalles();
					this.saveTransaccionLocal();
				}

				TransaccionLocalLogicAdditional.updateRelacionesToSaveAfter(transaccionlocal,this);

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
	
	
	private void saveTransaccionLocalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionLocal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionLocal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionLocalConstantesFunciones.getClassesRelationshipsOfTransaccionLocal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
