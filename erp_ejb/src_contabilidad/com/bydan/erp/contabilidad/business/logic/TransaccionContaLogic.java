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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.TransaccionContaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TransaccionContaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TransaccionContaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TransaccionConta;
import com.bydan.erp.contabilidad.business.logic.TransaccionContaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.sris.business.logic.*;


import com.bydan.erp.sris.util.*;


import com.bydan.erp.sris.business.dataaccess.*;








@SuppressWarnings("unused")
public class TransaccionContaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TransaccionContaLogic.class);
	
	protected TransaccionContaDataAccess transaccioncontaDataAccess; 	
	protected TransaccionConta transaccionconta;
	protected List<TransaccionConta> transaccioncontas;
	protected Object transaccioncontaObject;	
	protected List<Object> transaccioncontasObject;
	
	public static ClassValidator<TransaccionConta> transaccioncontaValidator = new ClassValidator<TransaccionConta>(TransaccionConta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TransaccionContaLogicAdditional transaccioncontaLogicAdditional=null;
	
	public TransaccionContaLogicAdditional getTransaccionContaLogicAdditional() {
		return this.transaccioncontaLogicAdditional;
	}
	
	public void setTransaccionContaLogicAdditional(TransaccionContaLogicAdditional transaccioncontaLogicAdditional) {
		try {
			this.transaccioncontaLogicAdditional=transaccioncontaLogicAdditional;
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
	
	
	
	
	public  TransaccionContaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.transaccioncontaDataAccess = new TransaccionContaDataAccess();
			
			this.transaccioncontas= new ArrayList<TransaccionConta>();
			this.transaccionconta= new TransaccionConta();
			
			this.transaccioncontaObject=new Object();
			this.transaccioncontasObject=new ArrayList<Object>();
				
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
			
			this.transaccioncontaDataAccess.setConnexionType(this.connexionType);
			this.transaccioncontaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransaccionContaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.transaccioncontaDataAccess = new TransaccionContaDataAccess();
			this.transaccioncontas= new ArrayList<TransaccionConta>();
			this.transaccionconta= new TransaccionConta();
			this.transaccioncontaObject=new Object();
			this.transaccioncontasObject=new ArrayList<Object>();
			
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
			
			this.transaccioncontaDataAccess.setConnexionType(this.connexionType);
			this.transaccioncontaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TransaccionConta getTransaccionConta() throws Exception {	
		TransaccionContaLogicAdditional.checkTransaccionContaToGet(transaccionconta,this.datosCliente,this.arrDatoGeneral);
		TransaccionContaLogicAdditional.updateTransaccionContaToGet(transaccionconta,this.arrDatoGeneral);
		
		return transaccionconta;
	}
		
	public void setTransaccionConta(TransaccionConta newTransaccionConta) {
		this.transaccionconta = newTransaccionConta;
	}
	
	public TransaccionContaDataAccess getTransaccionContaDataAccess() {
		return transaccioncontaDataAccess;
	}
	
	public void setTransaccionContaDataAccess(TransaccionContaDataAccess newtransaccioncontaDataAccess) {
		this.transaccioncontaDataAccess = newtransaccioncontaDataAccess;
	}
	
	public List<TransaccionConta> getTransaccionContas() throws Exception {		
		this.quitarTransaccionContasNulos();
		
		TransaccionContaLogicAdditional.checkTransaccionContaToGets(transaccioncontas,this.datosCliente,this.arrDatoGeneral);
		
		for (TransaccionConta transaccioncontaLocal: transaccioncontas ) {
			TransaccionContaLogicAdditional.updateTransaccionContaToGet(transaccioncontaLocal,this.arrDatoGeneral);
		}
		
		return transaccioncontas;
	}
	
	public void setTransaccionContas(List<TransaccionConta> newTransaccionContas) {
		this.transaccioncontas = newTransaccionContas;
	}
	
	public Object getTransaccionContaObject() {	
		this.transaccioncontaObject=this.transaccioncontaDataAccess.getEntityObject();
		return this.transaccioncontaObject;
	}
		
	public void setTransaccionContaObject(Object newTransaccionContaObject) {
		this.transaccioncontaObject = newTransaccionContaObject;
	}
	
	public List<Object> getTransaccionContasObject() {		
		this.transaccioncontasObject=this.transaccioncontaDataAccess.getEntitiesObject();
		return this.transaccioncontasObject;
	}
		
	public void setTransaccionContasObject(List<Object> newTransaccionContasObject) {
		this.transaccioncontasObject = newTransaccionContasObject;
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
		
		if(this.transaccioncontaDataAccess!=null) {
			this.transaccioncontaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			transaccioncontaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			transaccioncontaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		transaccionconta = new  TransaccionConta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccionconta=transaccioncontaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
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
		transaccionconta = new  TransaccionConta();
		  		  
        try {
			
			transaccionconta=transaccioncontaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		transaccionconta = new  TransaccionConta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccionconta=transaccioncontaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
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
		transaccionconta = new  TransaccionConta();
		  		  
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
		transaccionconta = new  TransaccionConta();
		  		  
        try {
			
			transaccionconta=transaccioncontaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		transaccionconta = new  TransaccionConta();
		  		  
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
		transaccionconta = new  TransaccionConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =transaccioncontaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccionconta = new  TransaccionConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=transaccioncontaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccionconta = new  TransaccionConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =transaccioncontaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccionconta = new  TransaccionConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=transaccioncontaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccionconta = new  TransaccionConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =transaccioncontaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccionconta = new  TransaccionConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=transaccioncontaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
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
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
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
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
        try {			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
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
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
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
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
        try {
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
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
		transaccioncontas = new  ArrayList<TransaccionConta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
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
		transaccioncontas = new  ArrayList<TransaccionConta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		transaccionconta = new  TransaccionConta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionconta=transaccioncontaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccionconta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
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
		transaccionconta = new  TransaccionConta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionconta=transaccioncontaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccionconta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
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
		transaccioncontas = new  ArrayList<TransaccionConta>();
		  		  
        try {
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTransaccionContasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		transaccioncontas = new  ArrayList<TransaccionConta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getTodosTransaccionContasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
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
	
	public  void  getTodosTransaccionContas(String sFinalQuery,Pagination pagination)throws Exception {
		transaccioncontas = new  ArrayList<TransaccionConta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionConta(transaccioncontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTransaccionConta(TransaccionConta transaccionconta) throws Exception {
		Boolean estaValidado=false;
		
		if(transaccionconta.getIsNew() || transaccionconta.getIsChanged()) { 
			this.invalidValues = transaccioncontaValidator.getInvalidValues(transaccionconta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(transaccionconta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTransaccionConta(List<TransaccionConta> TransaccionContas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TransaccionConta transaccioncontaLocal:transaccioncontas) {				
			estaValidadoObjeto=this.validarGuardarTransaccionConta(transaccioncontaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTransaccionConta(List<TransaccionConta> TransaccionContas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionConta(transaccioncontas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTransaccionConta(TransaccionConta TransaccionConta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionConta(transaccionconta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TransaccionConta transaccionconta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+transaccionconta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TransaccionContaConstantesFunciones.getTransaccionContaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"transaccionconta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TransaccionContaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TransaccionContaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTransaccionContaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-saveTransaccionContaWithConnection");connexion.begin();			
			
			TransaccionContaLogicAdditional.checkTransaccionContaToSave(this.transaccionconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionContaLogicAdditional.updateTransaccionContaToSave(this.transaccionconta,this.arrDatoGeneral);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccionconta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionConta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionConta(this.transaccionconta)) {
				TransaccionContaDataAccess.save(this.transaccionconta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionContaLogicAdditional.checkTransaccionContaToSaveAfter(this.transaccionconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionConta();
			
			connexion.commit();			
			
			if(this.transaccionconta.getIsDeleted()) {
				this.transaccionconta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTransaccionConta()throws Exception {	
		try {	
			
			TransaccionContaLogicAdditional.checkTransaccionContaToSave(this.transaccionconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionContaLogicAdditional.updateTransaccionContaToSave(this.transaccionconta,this.arrDatoGeneral);
			
			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccionconta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionConta(this.transaccionconta)) {			
				TransaccionContaDataAccess.save(this.transaccionconta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionContaLogicAdditional.checkTransaccionContaToSaveAfter(this.transaccionconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.transaccionconta.getIsDeleted()) {
				this.transaccionconta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTransaccionContasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-saveTransaccionContasWithConnection");connexion.begin();			
			
			TransaccionContaLogicAdditional.checkTransaccionContaToSaves(transaccioncontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionContas();
			
			Boolean validadoTodosTransaccionConta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionConta transaccioncontaLocal:transaccioncontas) {		
				if(transaccioncontaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionContaLogicAdditional.updateTransaccionContaToSave(transaccioncontaLocal,this.arrDatoGeneral);
	        	
				TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccioncontaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionConta(transaccioncontaLocal)) {
					TransaccionContaDataAccess.save(transaccioncontaLocal, connexion);				
				} else {
					validadoTodosTransaccionConta=false;
				}
			}
			
			if(!validadoTodosTransaccionConta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionContaLogicAdditional.checkTransaccionContaToSavesAfter(transaccioncontas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionContas();
			
			connexion.commit();		
			
			this.quitarTransaccionContasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTransaccionContas()throws Exception {				
		 try {	
			TransaccionContaLogicAdditional.checkTransaccionContaToSaves(transaccioncontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTransaccionConta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionConta transaccioncontaLocal:transaccioncontas) {				
				if(transaccioncontaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionContaLogicAdditional.updateTransaccionContaToSave(transaccioncontaLocal,this.arrDatoGeneral);
	        	
				TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccioncontaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionConta(transaccioncontaLocal)) {				
					TransaccionContaDataAccess.save(transaccioncontaLocal, connexion);				
				} else {
					validadoTodosTransaccionConta=false;
				}
			}
			
			if(!validadoTodosTransaccionConta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionContaLogicAdditional.checkTransaccionContaToSavesAfter(transaccioncontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTransaccionContasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionContaParameterReturnGeneral procesarAccionTransaccionContas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionConta> transaccioncontas,TransaccionContaParameterReturnGeneral transaccioncontaParameterGeneral)throws Exception {
		 try {	
			TransaccionContaParameterReturnGeneral transaccioncontaReturnGeneral=new TransaccionContaParameterReturnGeneral();
	
			TransaccionContaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccioncontas,transaccioncontaParameterGeneral,transaccioncontaReturnGeneral);
			
			return transaccioncontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionContaParameterReturnGeneral procesarAccionTransaccionContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionConta> transaccioncontas,TransaccionContaParameterReturnGeneral transaccioncontaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-procesarAccionTransaccionContasWithConnection");connexion.begin();			
			
			TransaccionContaParameterReturnGeneral transaccioncontaReturnGeneral=new TransaccionContaParameterReturnGeneral();
	
			TransaccionContaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccioncontas,transaccioncontaParameterGeneral,transaccioncontaReturnGeneral);
			
			this.connexion.commit();
			
			return transaccioncontaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionContaParameterReturnGeneral procesarEventosTransaccionContas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionConta> transaccioncontas,TransaccionConta transaccionconta,TransaccionContaParameterReturnGeneral transaccioncontaParameterGeneral,Boolean isEsNuevoTransaccionConta,ArrayList<Classe> clases)throws Exception {
		 try {	
			TransaccionContaParameterReturnGeneral transaccioncontaReturnGeneral=new TransaccionContaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccioncontaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionContaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccioncontas,transaccionconta,transaccioncontaParameterGeneral,transaccioncontaReturnGeneral,isEsNuevoTransaccionConta,clases);
			
			return transaccioncontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TransaccionContaParameterReturnGeneral procesarEventosTransaccionContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionConta> transaccioncontas,TransaccionConta transaccionconta,TransaccionContaParameterReturnGeneral transaccioncontaParameterGeneral,Boolean isEsNuevoTransaccionConta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-procesarEventosTransaccionContasWithConnection");connexion.begin();			
			
			TransaccionContaParameterReturnGeneral transaccioncontaReturnGeneral=new TransaccionContaParameterReturnGeneral();
	
			transaccioncontaReturnGeneral.setTransaccionConta(transaccionconta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccioncontaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionContaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccioncontas,transaccionconta,transaccioncontaParameterGeneral,transaccioncontaReturnGeneral,isEsNuevoTransaccionConta,clases);
			
			this.connexion.commit();
			
			return transaccioncontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionContaParameterReturnGeneral procesarImportacionTransaccionContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TransaccionContaParameterReturnGeneral transaccioncontaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-procesarImportacionTransaccionContasWithConnection");connexion.begin();			
			
			TransaccionContaParameterReturnGeneral transaccioncontaReturnGeneral=new TransaccionContaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.transaccioncontas=new ArrayList<TransaccionConta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.transaccionconta=new TransaccionConta();
				
				
				if(conColumnasBase) {this.transaccionconta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.transaccionconta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.transaccionconta.setcodigo(arrColumnas[iColumn++]);
				this.transaccionconta.setnombre(arrColumnas[iColumn++]);
				
				this.transaccioncontas.add(this.transaccionconta);
			}
			
			this.saveTransaccionContas();
			
			this.connexion.commit();
			
			transaccioncontaReturnGeneral.setConRetornoEstaProcesado(true);
			transaccioncontaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return transaccioncontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTransaccionContasEliminados() throws Exception {				
		
		List<TransaccionConta> transaccioncontasAux= new ArrayList<TransaccionConta>();
		
		for(TransaccionConta transaccionconta:transaccioncontas) {
			if(!transaccionconta.getIsDeleted()) {
				transaccioncontasAux.add(transaccionconta);
			}
		}
		
		transaccioncontas=transaccioncontasAux;
	}
	
	public void quitarTransaccionContasNulos() throws Exception {				
		
		List<TransaccionConta> transaccioncontasAux= new ArrayList<TransaccionConta>();
		
		for(TransaccionConta transaccionconta : this.transaccioncontas) {
			if(transaccionconta==null) {
				transaccioncontasAux.add(transaccionconta);
			}
		}
		
		//this.transaccioncontas=transaccioncontasAux;
		
		this.transaccioncontas.removeAll(transaccioncontasAux);
	}
	
	public void getSetVersionRowTransaccionContaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(transaccionconta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((transaccionconta.getIsDeleted() || (transaccionconta.getIsChanged()&&!transaccionconta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=transaccioncontaDataAccess.getSetVersionRowTransaccionConta(connexion,transaccionconta.getId());
				
				if(!transaccionconta.getVersionRow().equals(timestamp)) {	
					transaccionconta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				transaccionconta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTransaccionConta()throws Exception {	
		
		if(transaccionconta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((transaccionconta.getIsDeleted() || (transaccionconta.getIsChanged()&&!transaccionconta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=transaccioncontaDataAccess.getSetVersionRowTransaccionConta(connexion,transaccionconta.getId());
			
			try {							
				if(!transaccionconta.getVersionRow().equals(timestamp)) {	
					transaccionconta.setVersionRow(timestamp);
				}
				
				transaccionconta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTransaccionContasWithConnection()throws Exception {	
		if(transaccioncontas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TransaccionConta transaccioncontaAux:transaccioncontas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(transaccioncontaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccioncontaAux.getIsDeleted() || (transaccioncontaAux.getIsChanged()&&!transaccioncontaAux.getIsNew())) {
						
						timestamp=transaccioncontaDataAccess.getSetVersionRowTransaccionConta(connexion,transaccioncontaAux.getId());
						
						if(!transaccionconta.getVersionRow().equals(timestamp)) {	
							transaccioncontaAux.setVersionRow(timestamp);
						}
								
						transaccioncontaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTransaccionContas()throws Exception {	
		if(transaccioncontas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TransaccionConta transaccioncontaAux:transaccioncontas) {
					if(transaccioncontaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccioncontaAux.getIsDeleted() || (transaccioncontaAux.getIsChanged()&&!transaccioncontaAux.getIsNew())) {
						
						timestamp=transaccioncontaDataAccess.getSetVersionRowTransaccionConta(connexion,transaccioncontaAux.getId());
						
						if(!transaccioncontaAux.getVersionRow().equals(timestamp)) {	
							transaccioncontaAux.setVersionRow(timestamp);
						}
						
													
						transaccioncontaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTransaccionContaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TransaccionLocalLogic transaccionlocalLogic=new TransaccionLocalLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTransaccionContaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TransaccionLocal.class));
											
			

			transaccionlocalLogic.setConnexion(this.getConnexion());
			transaccionlocalLogic.setDatosCliente(this.datosCliente);
			transaccionlocalLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TransaccionConta transaccionconta:this.transaccioncontas) {
				

				classes=new ArrayList<Classe>();
				classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionlocalLogic.setTransaccionLocals(transaccionconta.transaccionlocals);
				transaccionlocalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TransaccionConta transaccionconta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransaccionContaLogicAdditional.updateTransaccionContaToGet(transaccionconta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccionconta.setTransaccionLocals(transaccioncontaDataAccess.getTransaccionLocals(connexion,transaccionconta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				transaccionconta.setTransaccionLocals(transaccioncontaDataAccess.getTransaccionLocals(connexion,transaccionconta));

				if(this.isConDeep) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(this.connexion);
					transaccionlocalLogic.setTransaccionLocals(transaccionconta.getTransaccionLocals());
					ArrayList<Classe> classesLocal=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionlocalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocalLogic.getTransaccionLocals());
					transaccionconta.setTransaccionLocals(transaccionlocalLogic.getTransaccionLocals());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			transaccionconta.setTransaccionLocals(transaccioncontaDataAccess.getTransaccionLocals(connexion,transaccionconta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		transaccionconta.setTransaccionLocals(transaccioncontaDataAccess.getTransaccionLocals(connexion,transaccionconta));

		for(TransaccionLocal transaccionlocal:transaccionconta.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				transaccionconta.setTransaccionLocals(transaccioncontaDataAccess.getTransaccionLocals(connexion,transaccionconta));

				for(TransaccionLocal transaccionlocal:transaccionconta.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			transaccionconta.setTransaccionLocals(transaccioncontaDataAccess.getTransaccionLocals(connexion,transaccionconta));

			for(TransaccionLocal transaccionlocal:transaccionconta.getTransaccionLocals()) {
				TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
				transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TransaccionConta transaccionconta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TransaccionContaLogicAdditional.updateTransaccionContaToSave(transaccionconta,this.arrDatoGeneral);
			
TransaccionContaDataAccess.save(transaccionconta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TransaccionLocal transaccionlocal:transaccionconta.getTransaccionLocals()) {
			transaccionlocal.setid_transaccion_conta(transaccionconta.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:transaccionconta.getTransaccionLocals()) {
					transaccionlocal.setid_transaccion_conta(transaccionconta.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TransaccionLocal transaccionlocal:transaccionconta.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocal.setid_transaccion_conta(transaccionconta.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
			transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:transaccionconta.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocal.setid_transaccion_conta(transaccionconta.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
					transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TransaccionConta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(transaccionconta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(transaccionconta);
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
			this.deepLoad(this.transaccionconta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TransaccionConta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(transaccioncontas!=null) {
				for(TransaccionConta transaccionconta:transaccioncontas) {
					this.deepLoad(transaccionconta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(transaccioncontas);
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
			if(transaccioncontas!=null) {
				for(TransaccionConta transaccionconta:transaccioncontas) {
					this.deepLoad(transaccionconta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(transaccioncontas);
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
			this.getNewConnexionToDeep(TransaccionConta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(transaccionconta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TransaccionConta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(transaccioncontas!=null) {
				for(TransaccionConta transaccionconta:transaccioncontas) {
					this.deepSave(transaccionconta,isDeep,deepLoadType,clases);
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
			if(transaccioncontas!=null) {
				for(TransaccionConta transaccionconta:transaccioncontas) {
					this.deepSave(transaccionconta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTransaccionContasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TransaccionContaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionContasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TransaccionContaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionContasBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TransaccionContaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionContasBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TransaccionContaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionContasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TransaccionContaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionContasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TransaccionContaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TransaccionContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccioncontas=transaccioncontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccioncontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionContaPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TransaccionContaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			transaccionconta=transaccioncontaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionContaPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TransaccionContaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			transaccionconta=transaccioncontaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.transaccionconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TransaccionContaConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionConta(this.transaccionconta);
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
			if(TransaccionContaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionContaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TransaccionConta transaccionconta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TransaccionContaConstantesFunciones.ISCONAUDITORIA) {
				if(transaccionconta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionContaDataAccess.TABLENAME, transaccionconta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionContaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionContaLogic.registrarAuditoriaDetallesTransaccionConta(connexion,transaccionconta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(transaccionconta.getIsDeleted()) {
					/*if(!transaccionconta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TransaccionContaDataAccess.TABLENAME, transaccionconta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TransaccionContaLogic.registrarAuditoriaDetallesTransaccionConta(connexion,transaccionconta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionContaDataAccess.TABLENAME, transaccionconta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(transaccionconta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionContaDataAccess.TABLENAME, transaccionconta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionContaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionContaLogic.registrarAuditoriaDetallesTransaccionConta(connexion,transaccionconta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTransaccionConta(Connexion connexion,TransaccionConta transaccionconta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(transaccionconta.getIsNew()||!transaccionconta.getcodigo().equals(transaccionconta.getTransaccionContaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionconta.getTransaccionContaOriginal().getcodigo()!=null)
				{
					strValorActual=transaccionconta.getTransaccionContaOriginal().getcodigo();
				}
				if(transaccionconta.getcodigo()!=null)
				{
					strValorNuevo=transaccionconta.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionContaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(transaccionconta.getIsNew()||!transaccionconta.getnombre().equals(transaccionconta.getTransaccionContaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccionconta.getTransaccionContaOriginal().getnombre()!=null)
				{
					strValorActual=transaccionconta.getTransaccionContaOriginal().getnombre();
				}
				if(transaccionconta.getnombre()!=null)
				{
					strValorNuevo=transaccionconta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionContaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTransaccionContaRelacionesWithConnection(TransaccionConta transaccionconta,List<TransaccionLocal> transaccionlocals) throws Exception {

		if(!transaccionconta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionContaRelacionesBase(transaccionconta,transaccionlocals,true);
		}
	}

	public void saveTransaccionContaRelaciones(TransaccionConta transaccionconta,List<TransaccionLocal> transaccionlocals)throws Exception {

		if(!transaccionconta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionContaRelacionesBase(transaccionconta,transaccionlocals,false);
		}
	}

	public void saveTransaccionContaRelacionesBase(TransaccionConta transaccionconta,List<TransaccionLocal> transaccionlocals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TransaccionConta-saveRelacionesWithConnection");}
	
			transaccionconta.setTransaccionLocals(transaccionlocals);

			this.setTransaccionConta(transaccionconta);

				if((transaccionconta.getIsNew()||transaccionconta.getIsChanged())&&!transaccionconta.getIsDeleted()) {
					this.saveTransaccionConta();
					this.saveTransaccionContaRelacionesDetalles(transaccionlocals);

				} else if(transaccionconta.getIsDeleted()) {
					this.saveTransaccionContaRelacionesDetalles(transaccionlocals);
					this.saveTransaccionConta();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TransaccionLocalConstantesFunciones.InicializarGeneralEntityAuxiliaresTransaccionLocals(transaccionlocals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTransaccionContaRelacionesDetalles(List<TransaccionLocal> transaccionlocals)throws Exception {
		try {
	

			Long idTransaccionContaActual=this.getTransaccionConta().getId();

			TransaccionLocalLogic transaccionlocalLogic_Desde_TransaccionConta=new TransaccionLocalLogic();
			transaccionlocalLogic_Desde_TransaccionConta.setTransaccionLocals(transaccionlocals);

			transaccionlocalLogic_Desde_TransaccionConta.setConnexion(this.getConnexion());
			transaccionlocalLogic_Desde_TransaccionConta.setDatosCliente(this.datosCliente);

			for(TransaccionLocal transaccionlocal_Desde_TransaccionConta:transaccionlocalLogic_Desde_TransaccionConta.getTransaccionLocals()) {
				transaccionlocal_Desde_TransaccionConta.setid_transaccion_conta(idTransaccionContaActual);
			}

			transaccionlocalLogic_Desde_TransaccionConta.saveTransaccionLocals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionContaConstantesFunciones.getClassesForeignKeysOfTransaccionConta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionContaConstantesFunciones.getClassesRelationshipsOfTransaccionConta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
