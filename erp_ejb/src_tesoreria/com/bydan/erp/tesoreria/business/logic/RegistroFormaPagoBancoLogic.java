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
import com.bydan.erp.tesoreria.util.RegistroFormaPagoBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.RegistroFormaPagoBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.RegistroFormaPagoBancoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.RegistroFormaPagoBanco;
import com.bydan.erp.tesoreria.business.logic.RegistroFormaPagoBancoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class RegistroFormaPagoBancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RegistroFormaPagoBancoLogic.class);
	
	protected RegistroFormaPagoBancoDataAccess registroformapagobancoDataAccess; 	
	protected RegistroFormaPagoBanco registroformapagobanco;
	protected List<RegistroFormaPagoBanco> registroformapagobancos;
	protected Object registroformapagobancoObject;	
	protected List<Object> registroformapagobancosObject;
	
	public static ClassValidator<RegistroFormaPagoBanco> registroformapagobancoValidator = new ClassValidator<RegistroFormaPagoBanco>(RegistroFormaPagoBanco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RegistroFormaPagoBancoLogicAdditional registroformapagobancoLogicAdditional=null;
	
	public RegistroFormaPagoBancoLogicAdditional getRegistroFormaPagoBancoLogicAdditional() {
		return this.registroformapagobancoLogicAdditional;
	}
	
	public void setRegistroFormaPagoBancoLogicAdditional(RegistroFormaPagoBancoLogicAdditional registroformapagobancoLogicAdditional) {
		try {
			this.registroformapagobancoLogicAdditional=registroformapagobancoLogicAdditional;
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
	
	
	
	
	public  RegistroFormaPagoBancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.registroformapagobancoDataAccess = new RegistroFormaPagoBancoDataAccess();
			
			this.registroformapagobancos= new ArrayList<RegistroFormaPagoBanco>();
			this.registroformapagobanco= new RegistroFormaPagoBanco();
			
			this.registroformapagobancoObject=new Object();
			this.registroformapagobancosObject=new ArrayList<Object>();
				
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
			
			this.registroformapagobancoDataAccess.setConnexionType(this.connexionType);
			this.registroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RegistroFormaPagoBancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.registroformapagobancoDataAccess = new RegistroFormaPagoBancoDataAccess();
			this.registroformapagobancos= new ArrayList<RegistroFormaPagoBanco>();
			this.registroformapagobanco= new RegistroFormaPagoBanco();
			this.registroformapagobancoObject=new Object();
			this.registroformapagobancosObject=new ArrayList<Object>();
			
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
			
			this.registroformapagobancoDataAccess.setConnexionType(this.connexionType);
			this.registroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RegistroFormaPagoBanco getRegistroFormaPagoBanco() throws Exception {	
		RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToGet(registroformapagobanco,this.datosCliente,this.arrDatoGeneral);
		RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToGet(registroformapagobanco,this.arrDatoGeneral);
		
		return registroformapagobanco;
	}
		
	public void setRegistroFormaPagoBanco(RegistroFormaPagoBanco newRegistroFormaPagoBanco) {
		this.registroformapagobanco = newRegistroFormaPagoBanco;
	}
	
	public RegistroFormaPagoBancoDataAccess getRegistroFormaPagoBancoDataAccess() {
		return registroformapagobancoDataAccess;
	}
	
	public void setRegistroFormaPagoBancoDataAccess(RegistroFormaPagoBancoDataAccess newregistroformapagobancoDataAccess) {
		this.registroformapagobancoDataAccess = newregistroformapagobancoDataAccess;
	}
	
	public List<RegistroFormaPagoBanco> getRegistroFormaPagoBancos() throws Exception {		
		this.quitarRegistroFormaPagoBancosNulos();
		
		RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToGets(registroformapagobancos,this.datosCliente,this.arrDatoGeneral);
		
		for (RegistroFormaPagoBanco registroformapagobancoLocal: registroformapagobancos ) {
			RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToGet(registroformapagobancoLocal,this.arrDatoGeneral);
		}
		
		return registroformapagobancos;
	}
	
	public void setRegistroFormaPagoBancos(List<RegistroFormaPagoBanco> newRegistroFormaPagoBancos) {
		this.registroformapagobancos = newRegistroFormaPagoBancos;
	}
	
	public Object getRegistroFormaPagoBancoObject() {	
		this.registroformapagobancoObject=this.registroformapagobancoDataAccess.getEntityObject();
		return this.registroformapagobancoObject;
	}
		
	public void setRegistroFormaPagoBancoObject(Object newRegistroFormaPagoBancoObject) {
		this.registroformapagobancoObject = newRegistroFormaPagoBancoObject;
	}
	
	public List<Object> getRegistroFormaPagoBancosObject() {		
		this.registroformapagobancosObject=this.registroformapagobancoDataAccess.getEntitiesObject();
		return this.registroformapagobancosObject;
	}
		
	public void setRegistroFormaPagoBancosObject(List<Object> newRegistroFormaPagoBancosObject) {
		this.registroformapagobancosObject = newRegistroFormaPagoBancosObject;
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
		
		if(this.registroformapagobancoDataAccess!=null) {
			this.registroformapagobancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			registroformapagobancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			registroformapagobancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			registroformapagobanco=registroformapagobancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.registroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobanco);
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  		  
        try {
			
			registroformapagobanco=registroformapagobancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.registroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			registroformapagobanco=registroformapagobancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.registroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobanco);
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  		  
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  		  
        try {
			
			registroformapagobanco=registroformapagobancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.registroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  		  
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =registroformapagobancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=registroformapagobancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =registroformapagobancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=registroformapagobancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		registroformapagobanco = new  RegistroFormaPagoBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =registroformapagobancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=registroformapagobancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
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
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
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
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
        try {			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
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
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
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
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
        try {
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
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
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
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
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		registroformapagobanco = new  RegistroFormaPagoBanco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobanco=registroformapagobancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobanco);
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
		registroformapagobanco = new  RegistroFormaPagoBanco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobanco=registroformapagobancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
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
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		  		  
        try {
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRegistroFormaPagoBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getTodosRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
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
	
	public  void  getTodosRegistroFormaPagoBancos(String sFinalQuery,Pagination pagination)throws Exception {
		registroformapagobancos = new  ArrayList<RegistroFormaPagoBanco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRegistroFormaPagoBanco(registroformapagobancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobanco) throws Exception {
		Boolean estaValidado=false;
		
		if(registroformapagobanco.getIsNew() || registroformapagobanco.getIsChanged()) { 
			this.invalidValues = registroformapagobancoValidator.getInvalidValues(registroformapagobanco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(registroformapagobanco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRegistroFormaPagoBanco(List<RegistroFormaPagoBanco> RegistroFormaPagoBancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RegistroFormaPagoBanco registroformapagobancoLocal:registroformapagobancos) {				
			estaValidadoObjeto=this.validarGuardarRegistroFormaPagoBanco(registroformapagobancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRegistroFormaPagoBanco(List<RegistroFormaPagoBanco> RegistroFormaPagoBancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRegistroFormaPagoBanco(registroformapagobancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRegistroFormaPagoBanco(RegistroFormaPagoBanco RegistroFormaPagoBanco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRegistroFormaPagoBanco(registroformapagobanco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RegistroFormaPagoBanco registroformapagobanco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+registroformapagobanco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RegistroFormaPagoBancoConstantesFunciones.getRegistroFormaPagoBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"registroformapagobanco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RegistroFormaPagoBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RegistroFormaPagoBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRegistroFormaPagoBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-saveRegistroFormaPagoBancoWithConnection");connexion.begin();			
			
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSave(this.registroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToSave(this.registroformapagobanco,this.arrDatoGeneral);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.registroformapagobanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRegistroFormaPagoBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRegistroFormaPagoBanco(this.registroformapagobanco)) {
				RegistroFormaPagoBancoDataAccess.save(this.registroformapagobanco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.registroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSaveAfter(this.registroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRegistroFormaPagoBanco();
			
			connexion.commit();			
			
			if(this.registroformapagobanco.getIsDeleted()) {
				this.registroformapagobanco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRegistroFormaPagoBanco()throws Exception {	
		try {	
			
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSave(this.registroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToSave(this.registroformapagobanco,this.arrDatoGeneral);
			
			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.registroformapagobanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRegistroFormaPagoBanco(this.registroformapagobanco)) {			
				RegistroFormaPagoBancoDataAccess.save(this.registroformapagobanco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.registroformapagobanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSaveAfter(this.registroformapagobanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.registroformapagobanco.getIsDeleted()) {
				this.registroformapagobanco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRegistroFormaPagoBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-saveRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSaves(registroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRegistroFormaPagoBancos();
			
			Boolean validadoTodosRegistroFormaPagoBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RegistroFormaPagoBanco registroformapagobancoLocal:registroformapagobancos) {		
				if(registroformapagobancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToSave(registroformapagobancoLocal,this.arrDatoGeneral);
	        	
				RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),registroformapagobancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRegistroFormaPagoBanco(registroformapagobancoLocal)) {
					RegistroFormaPagoBancoDataAccess.save(registroformapagobancoLocal, connexion);				
				} else {
					validadoTodosRegistroFormaPagoBanco=false;
				}
			}
			
			if(!validadoTodosRegistroFormaPagoBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSavesAfter(registroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRegistroFormaPagoBancos();
			
			connexion.commit();		
			
			this.quitarRegistroFormaPagoBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRegistroFormaPagoBancos()throws Exception {				
		 try {	
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSaves(registroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRegistroFormaPagoBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RegistroFormaPagoBanco registroformapagobancoLocal:registroformapagobancos) {				
				if(registroformapagobancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToSave(registroformapagobancoLocal,this.arrDatoGeneral);
	        	
				RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),registroformapagobancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRegistroFormaPagoBanco(registroformapagobancoLocal)) {				
					RegistroFormaPagoBancoDataAccess.save(registroformapagobancoLocal, connexion);				
				} else {
					validadoTodosRegistroFormaPagoBanco=false;
				}
			}
			
			if(!validadoTodosRegistroFormaPagoBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RegistroFormaPagoBancoLogicAdditional.checkRegistroFormaPagoBancoToSavesAfter(registroformapagobancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRegistroFormaPagoBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RegistroFormaPagoBancoParameterReturnGeneral procesarAccionRegistroFormaPagoBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RegistroFormaPagoBanco> registroformapagobancos,RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoParameterGeneral)throws Exception {
		 try {	
			RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoReturnGeneral=new RegistroFormaPagoBancoParameterReturnGeneral();
	
			RegistroFormaPagoBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,registroformapagobancos,registroformapagobancoParameterGeneral,registroformapagobancoReturnGeneral);
			
			return registroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RegistroFormaPagoBancoParameterReturnGeneral procesarAccionRegistroFormaPagoBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RegistroFormaPagoBanco> registroformapagobancos,RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-procesarAccionRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoReturnGeneral=new RegistroFormaPagoBancoParameterReturnGeneral();
	
			RegistroFormaPagoBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,registroformapagobancos,registroformapagobancoParameterGeneral,registroformapagobancoReturnGeneral);
			
			this.connexion.commit();
			
			return registroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RegistroFormaPagoBancoParameterReturnGeneral procesarEventosRegistroFormaPagoBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RegistroFormaPagoBanco> registroformapagobancos,RegistroFormaPagoBanco registroformapagobanco,RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoParameterGeneral,Boolean isEsNuevoRegistroFormaPagoBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoReturnGeneral=new RegistroFormaPagoBancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				registroformapagobancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RegistroFormaPagoBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,registroformapagobancos,registroformapagobanco,registroformapagobancoParameterGeneral,registroformapagobancoReturnGeneral,isEsNuevoRegistroFormaPagoBanco,clases);
			
			return registroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RegistroFormaPagoBancoParameterReturnGeneral procesarEventosRegistroFormaPagoBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RegistroFormaPagoBanco> registroformapagobancos,RegistroFormaPagoBanco registroformapagobanco,RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoParameterGeneral,Boolean isEsNuevoRegistroFormaPagoBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-procesarEventosRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoReturnGeneral=new RegistroFormaPagoBancoParameterReturnGeneral();
	
			registroformapagobancoReturnGeneral.setRegistroFormaPagoBanco(registroformapagobanco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				registroformapagobancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RegistroFormaPagoBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,registroformapagobancos,registroformapagobanco,registroformapagobancoParameterGeneral,registroformapagobancoReturnGeneral,isEsNuevoRegistroFormaPagoBanco,clases);
			
			this.connexion.commit();
			
			return registroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RegistroFormaPagoBancoParameterReturnGeneral procesarImportacionRegistroFormaPagoBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-procesarImportacionRegistroFormaPagoBancosWithConnection");connexion.begin();			
			
			RegistroFormaPagoBancoParameterReturnGeneral registroformapagobancoReturnGeneral=new RegistroFormaPagoBancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.registroformapagobancos=new ArrayList<RegistroFormaPagoBanco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.registroformapagobanco=new RegistroFormaPagoBanco();
				
				
				if(conColumnasBase) {this.registroformapagobanco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.registroformapagobanco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

			this.registroformapagobanco.setnombre_banco(arrColumnas[iColumn++]);
			this.registroformapagobanco.setnombre_girador(arrColumnas[iColumn++]);
				this.registroformapagobanco.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.registroformapagobanco.setnumero_cuenta(arrColumnas[iColumn++]);
				this.registroformapagobanco.setnumero_cheque(arrColumnas[iColumn++]);
				this.registroformapagobanco.setvalor_monto(Double.parseDouble(arrColumnas[iColumn++]));
				this.registroformapagobanco.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.registroformapagobanco.setfecha_vencimiento_original(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.registroformapagobanco.setnumero_cambio(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.registroformapagobancos.add(this.registroformapagobanco);
			}
			
			this.saveRegistroFormaPagoBancos();
			
			this.connexion.commit();
			
			registroformapagobancoReturnGeneral.setConRetornoEstaProcesado(true);
			registroformapagobancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return registroformapagobancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRegistroFormaPagoBancosEliminados() throws Exception {				
		
		List<RegistroFormaPagoBanco> registroformapagobancosAux= new ArrayList<RegistroFormaPagoBanco>();
		
		for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos) {
			if(!registroformapagobanco.getIsDeleted()) {
				registroformapagobancosAux.add(registroformapagobanco);
			}
		}
		
		registroformapagobancos=registroformapagobancosAux;
	}
	
	public void quitarRegistroFormaPagoBancosNulos() throws Exception {				
		
		List<RegistroFormaPagoBanco> registroformapagobancosAux= new ArrayList<RegistroFormaPagoBanco>();
		
		for(RegistroFormaPagoBanco registroformapagobanco : this.registroformapagobancos) {
			if(registroformapagobanco==null) {
				registroformapagobancosAux.add(registroformapagobanco);
			}
		}
		
		//this.registroformapagobancos=registroformapagobancosAux;
		
		this.registroformapagobancos.removeAll(registroformapagobancosAux);
	}
	
	public void getSetVersionRowRegistroFormaPagoBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(registroformapagobanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((registroformapagobanco.getIsDeleted() || (registroformapagobanco.getIsChanged()&&!registroformapagobanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=registroformapagobancoDataAccess.getSetVersionRowRegistroFormaPagoBanco(connexion,registroformapagobanco.getId());
				
				if(!registroformapagobanco.getVersionRow().equals(timestamp)) {	
					registroformapagobanco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				registroformapagobanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRegistroFormaPagoBanco()throws Exception {	
		
		if(registroformapagobanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((registroformapagobanco.getIsDeleted() || (registroformapagobanco.getIsChanged()&&!registroformapagobanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=registroformapagobancoDataAccess.getSetVersionRowRegistroFormaPagoBanco(connexion,registroformapagobanco.getId());
			
			try {							
				if(!registroformapagobanco.getVersionRow().equals(timestamp)) {	
					registroformapagobanco.setVersionRow(timestamp);
				}
				
				registroformapagobanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRegistroFormaPagoBancosWithConnection()throws Exception {	
		if(registroformapagobancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RegistroFormaPagoBanco registroformapagobancoAux:registroformapagobancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(registroformapagobancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(registroformapagobancoAux.getIsDeleted() || (registroformapagobancoAux.getIsChanged()&&!registroformapagobancoAux.getIsNew())) {
						
						timestamp=registroformapagobancoDataAccess.getSetVersionRowRegistroFormaPagoBanco(connexion,registroformapagobancoAux.getId());
						
						if(!registroformapagobanco.getVersionRow().equals(timestamp)) {	
							registroformapagobancoAux.setVersionRow(timestamp);
						}
								
						registroformapagobancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRegistroFormaPagoBancos()throws Exception {	
		if(registroformapagobancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RegistroFormaPagoBanco registroformapagobancoAux:registroformapagobancos) {
					if(registroformapagobancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(registroformapagobancoAux.getIsDeleted() || (registroformapagobancoAux.getIsChanged()&&!registroformapagobancoAux.getIsNew())) {
						
						timestamp=registroformapagobancoDataAccess.getSetVersionRowRegistroFormaPagoBanco(connexion,registroformapagobancoAux.getId());
						
						if(!registroformapagobancoAux.getVersionRow().equals(timestamp)) {	
							registroformapagobancoAux.setVersionRow(timestamp);
						}
						
													
						registroformapagobancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RegistroFormaPagoBancoParameterReturnGeneral cargarCombosLoteForeignKeyRegistroFormaPagoBancoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAsientoContable,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalEstadoRegistroFormaPagoBanco,String finalQueryGlobalCliente,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		RegistroFormaPagoBancoParameterReturnGeneral  registroformapagobancoReturnGeneral =new RegistroFormaPagoBancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-cargarCombosLoteForeignKeyRegistroFormaPagoBancoWithConnection");connexion.begin();
			
			registroformapagobancoReturnGeneral =new RegistroFormaPagoBancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			registroformapagobancoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			registroformapagobancoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			registroformapagobancoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			registroformapagobancoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			registroformapagobancoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			registroformapagobancoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancosForeignKey=new ArrayList<EstadoRegistroFormaPagoBanco>();
			EstadoRegistroFormaPagoBancoLogic estadoregistroformapagobancoLogic=new EstadoRegistroFormaPagoBancoLogic();
			estadoregistroformapagobancoLogic.setConnexion(this.connexion);
			estadoregistroformapagobancoLogic.getEstadoRegistroFormaPagoBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRegistroFormaPagoBanco.equals("NONE")) {
				estadoregistroformapagobancoLogic.getTodosEstadoRegistroFormaPagoBancos(finalQueryGlobalEstadoRegistroFormaPagoBanco,new Pagination());
				estadoregistroformapagobancosForeignKey=estadoregistroformapagobancoLogic.getEstadoRegistroFormaPagoBancos();
			}

			registroformapagobancoReturnGeneral.setestadoregistroformapagobancosForeignKey(estadoregistroformapagobancosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			registroformapagobancoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			registroformapagobancoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			registroformapagobancoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return registroformapagobancoReturnGeneral;
	}
	
	public RegistroFormaPagoBancoParameterReturnGeneral cargarCombosLoteForeignKeyRegistroFormaPagoBanco(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAsientoContable,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalEstadoRegistroFormaPagoBanco,String finalQueryGlobalCliente,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		RegistroFormaPagoBancoParameterReturnGeneral  registroformapagobancoReturnGeneral =new RegistroFormaPagoBancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			registroformapagobancoReturnGeneral =new RegistroFormaPagoBancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			registroformapagobancoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			registroformapagobancoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			registroformapagobancoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			registroformapagobancoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			registroformapagobancoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			registroformapagobancoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancosForeignKey=new ArrayList<EstadoRegistroFormaPagoBanco>();
			EstadoRegistroFormaPagoBancoLogic estadoregistroformapagobancoLogic=new EstadoRegistroFormaPagoBancoLogic();
			estadoregistroformapagobancoLogic.setConnexion(this.connexion);
			estadoregistroformapagobancoLogic.getEstadoRegistroFormaPagoBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRegistroFormaPagoBanco.equals("NONE")) {
				estadoregistroformapagobancoLogic.getTodosEstadoRegistroFormaPagoBancos(finalQueryGlobalEstadoRegistroFormaPagoBanco,new Pagination());
				estadoregistroformapagobancosForeignKey=estadoregistroformapagobancoLogic.getEstadoRegistroFormaPagoBancos();
			}

			registroformapagobancoReturnGeneral.setestadoregistroformapagobancosForeignKey(estadoregistroformapagobancosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			registroformapagobancoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			registroformapagobancoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			registroformapagobancoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return registroformapagobancoReturnGeneral;
	}
	
	
	public void deepLoad(RegistroFormaPagoBanco registroformapagobanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToGet(registroformapagobanco,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		registroformapagobanco.setEmpresa(registroformapagobancoDataAccess.getEmpresa(connexion,registroformapagobanco));
		registroformapagobanco.setSucursal(registroformapagobancoDataAccess.getSucursal(connexion,registroformapagobanco));
		registroformapagobanco.setEjercicio(registroformapagobancoDataAccess.getEjercicio(connexion,registroformapagobanco));
		registroformapagobanco.setPeriodo(registroformapagobancoDataAccess.getPeriodo(connexion,registroformapagobanco));
		registroformapagobanco.setAsientoContable(registroformapagobancoDataAccess.getAsientoContable(connexion,registroformapagobanco));
		registroformapagobanco.setTipoFormaPago(registroformapagobancoDataAccess.getTipoFormaPago(connexion,registroformapagobanco));
		registroformapagobanco.setEstadoRegistroFormaPagoBanco(registroformapagobancoDataAccess.getEstadoRegistroFormaPagoBanco(connexion,registroformapagobanco));
		registroformapagobanco.setCliente(registroformapagobancoDataAccess.getCliente(connexion,registroformapagobanco));
		registroformapagobanco.setAnio(registroformapagobancoDataAccess.getAnio(connexion,registroformapagobanco));
		registroformapagobanco.setMes(registroformapagobancoDataAccess.getMes(connexion,registroformapagobanco));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				registroformapagobanco.setEmpresa(registroformapagobancoDataAccess.getEmpresa(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				registroformapagobanco.setSucursal(registroformapagobancoDataAccess.getSucursal(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				registroformapagobanco.setEjercicio(registroformapagobancoDataAccess.getEjercicio(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				registroformapagobanco.setPeriodo(registroformapagobancoDataAccess.getPeriodo(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				registroformapagobanco.setAsientoContable(registroformapagobancoDataAccess.getAsientoContable(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				registroformapagobanco.setTipoFormaPago(registroformapagobancoDataAccess.getTipoFormaPago(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(EstadoRegistroFormaPagoBanco.class)) {
				registroformapagobanco.setEstadoRegistroFormaPagoBanco(registroformapagobancoDataAccess.getEstadoRegistroFormaPagoBanco(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				registroformapagobanco.setCliente(registroformapagobancoDataAccess.getCliente(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				registroformapagobanco.setAnio(registroformapagobancoDataAccess.getAnio(connexion,registroformapagobanco));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				registroformapagobanco.setMes(registroformapagobancoDataAccess.getMes(connexion,registroformapagobanco));
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
			registroformapagobanco.setEmpresa(registroformapagobancoDataAccess.getEmpresa(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setSucursal(registroformapagobancoDataAccess.getSucursal(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setEjercicio(registroformapagobancoDataAccess.getEjercicio(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setPeriodo(registroformapagobancoDataAccess.getPeriodo(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setAsientoContable(registroformapagobancoDataAccess.getAsientoContable(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setTipoFormaPago(registroformapagobancoDataAccess.getTipoFormaPago(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRegistroFormaPagoBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setEstadoRegistroFormaPagoBanco(registroformapagobancoDataAccess.getEstadoRegistroFormaPagoBanco(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setCliente(registroformapagobancoDataAccess.getCliente(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setAnio(registroformapagobancoDataAccess.getAnio(connexion,registroformapagobanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setMes(registroformapagobancoDataAccess.getMes(connexion,registroformapagobanco));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		registroformapagobanco.setEmpresa(registroformapagobancoDataAccess.getEmpresa(connexion,registroformapagobanco));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(registroformapagobanco.getEmpresa(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setSucursal(registroformapagobancoDataAccess.getSucursal(connexion,registroformapagobanco));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(registroformapagobanco.getSucursal(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setEjercicio(registroformapagobancoDataAccess.getEjercicio(connexion,registroformapagobanco));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(registroformapagobanco.getEjercicio(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setPeriodo(registroformapagobancoDataAccess.getPeriodo(connexion,registroformapagobanco));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(registroformapagobanco.getPeriodo(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setAsientoContable(registroformapagobancoDataAccess.getAsientoContable(connexion,registroformapagobanco));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(registroformapagobanco.getAsientoContable(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setTipoFormaPago(registroformapagobancoDataAccess.getTipoFormaPago(connexion,registroformapagobanco));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(registroformapagobanco.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setEstadoRegistroFormaPagoBanco(registroformapagobancoDataAccess.getEstadoRegistroFormaPagoBanco(connexion,registroformapagobanco));
		EstadoRegistroFormaPagoBancoLogic estadoregistroformapagobancoLogic= new EstadoRegistroFormaPagoBancoLogic(connexion);
		estadoregistroformapagobancoLogic.deepLoad(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setCliente(registroformapagobancoDataAccess.getCliente(connexion,registroformapagobanco));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(registroformapagobanco.getCliente(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setAnio(registroformapagobancoDataAccess.getAnio(connexion,registroformapagobanco));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(registroformapagobanco.getAnio(),isDeep,deepLoadType,clases);
				
		registroformapagobanco.setMes(registroformapagobancoDataAccess.getMes(connexion,registroformapagobanco));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(registroformapagobanco.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				registroformapagobanco.setEmpresa(registroformapagobancoDataAccess.getEmpresa(connexion,registroformapagobanco));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(registroformapagobanco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				registroformapagobanco.setSucursal(registroformapagobancoDataAccess.getSucursal(connexion,registroformapagobanco));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(registroformapagobanco.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				registroformapagobanco.setEjercicio(registroformapagobancoDataAccess.getEjercicio(connexion,registroformapagobanco));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(registroformapagobanco.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				registroformapagobanco.setPeriodo(registroformapagobancoDataAccess.getPeriodo(connexion,registroformapagobanco));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(registroformapagobanco.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				registroformapagobanco.setAsientoContable(registroformapagobancoDataAccess.getAsientoContable(connexion,registroformapagobanco));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(registroformapagobanco.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				registroformapagobanco.setTipoFormaPago(registroformapagobancoDataAccess.getTipoFormaPago(connexion,registroformapagobanco));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(registroformapagobanco.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRegistroFormaPagoBanco.class)) {
				registroformapagobanco.setEstadoRegistroFormaPagoBanco(registroformapagobancoDataAccess.getEstadoRegistroFormaPagoBanco(connexion,registroformapagobanco));
				EstadoRegistroFormaPagoBancoLogic estadoregistroformapagobancoLogic= new EstadoRegistroFormaPagoBancoLogic(connexion);
				estadoregistroformapagobancoLogic.deepLoad(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				registroformapagobanco.setCliente(registroformapagobancoDataAccess.getCliente(connexion,registroformapagobanco));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(registroformapagobanco.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				registroformapagobanco.setAnio(registroformapagobancoDataAccess.getAnio(connexion,registroformapagobanco));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(registroformapagobanco.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				registroformapagobanco.setMes(registroformapagobancoDataAccess.getMes(connexion,registroformapagobanco));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(registroformapagobanco.getMes(),isDeep,deepLoadType,clases);				
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
			registroformapagobanco.setEmpresa(registroformapagobancoDataAccess.getEmpresa(connexion,registroformapagobanco));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(registroformapagobanco.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setSucursal(registroformapagobancoDataAccess.getSucursal(connexion,registroformapagobanco));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(registroformapagobanco.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setEjercicio(registroformapagobancoDataAccess.getEjercicio(connexion,registroformapagobanco));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(registroformapagobanco.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setPeriodo(registroformapagobancoDataAccess.getPeriodo(connexion,registroformapagobanco));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(registroformapagobanco.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setAsientoContable(registroformapagobancoDataAccess.getAsientoContable(connexion,registroformapagobanco));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(registroformapagobanco.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setTipoFormaPago(registroformapagobancoDataAccess.getTipoFormaPago(connexion,registroformapagobanco));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(registroformapagobanco.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRegistroFormaPagoBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setEstadoRegistroFormaPagoBanco(registroformapagobancoDataAccess.getEstadoRegistroFormaPagoBanco(connexion,registroformapagobanco));
			EstadoRegistroFormaPagoBancoLogic estadoregistroformapagobancoLogic= new EstadoRegistroFormaPagoBancoLogic(connexion);
			estadoregistroformapagobancoLogic.deepLoad(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setCliente(registroformapagobancoDataAccess.getCliente(connexion,registroformapagobanco));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(registroformapagobanco.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setAnio(registroformapagobancoDataAccess.getAnio(connexion,registroformapagobanco));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(registroformapagobanco.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			registroformapagobanco.setMes(registroformapagobancoDataAccess.getMes(connexion,registroformapagobanco));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(registroformapagobanco.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RegistroFormaPagoBanco registroformapagobanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RegistroFormaPagoBancoLogicAdditional.updateRegistroFormaPagoBancoToSave(registroformapagobanco,this.arrDatoGeneral);
			
RegistroFormaPagoBancoDataAccess.save(registroformapagobanco, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(registroformapagobanco.getEmpresa(),connexion);

		SucursalDataAccess.save(registroformapagobanco.getSucursal(),connexion);

		EjercicioDataAccess.save(registroformapagobanco.getEjercicio(),connexion);

		PeriodoDataAccess.save(registroformapagobanco.getPeriodo(),connexion);

		AsientoContableDataAccess.save(registroformapagobanco.getAsientoContable(),connexion);

		TipoFormaPagoDataAccess.save(registroformapagobanco.getTipoFormaPago(),connexion);

		EstadoRegistroFormaPagoBancoDataAccess.save(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),connexion);

		ClienteDataAccess.save(registroformapagobanco.getCliente(),connexion);

		AnioDataAccess.save(registroformapagobanco.getAnio(),connexion);

		MesDataAccess.save(registroformapagobanco.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(registroformapagobanco.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(registroformapagobanco.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(registroformapagobanco.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(registroformapagobanco.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(registroformapagobanco.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(registroformapagobanco.getTipoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoRegistroFormaPagoBanco.class)) {
				EstadoRegistroFormaPagoBancoDataAccess.save(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(registroformapagobanco.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(registroformapagobanco.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(registroformapagobanco.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(registroformapagobanco.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(registroformapagobanco.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(registroformapagobanco.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(registroformapagobanco.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(registroformapagobanco.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(registroformapagobanco.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(registroformapagobanco.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(registroformapagobanco.getPeriodo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(registroformapagobanco.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(registroformapagobanco.getAsientoContable(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(registroformapagobanco.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(registroformapagobanco.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		EstadoRegistroFormaPagoBancoDataAccess.save(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),connexion);
		EstadoRegistroFormaPagoBancoLogic estadoregistroformapagobancoLogic= new EstadoRegistroFormaPagoBancoLogic(connexion);
		estadoregistroformapagobancoLogic.deepLoad(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(registroformapagobanco.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(registroformapagobanco.getCliente(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(registroformapagobanco.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(registroformapagobanco.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(registroformapagobanco.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(registroformapagobanco.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(registroformapagobanco.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(registroformapagobanco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(registroformapagobanco.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(registroformapagobanco.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(registroformapagobanco.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(registroformapagobanco.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(registroformapagobanco.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(registroformapagobanco.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(registroformapagobanco.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(registroformapagobanco.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(registroformapagobanco.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(registroformapagobanco.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRegistroFormaPagoBanco.class)) {
				EstadoRegistroFormaPagoBancoDataAccess.save(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),connexion);
				EstadoRegistroFormaPagoBancoLogic estadoregistroformapagobancoLogic= new EstadoRegistroFormaPagoBancoLogic(connexion);
				estadoregistroformapagobancoLogic.deepSave(registroformapagobanco.getEstadoRegistroFormaPagoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(registroformapagobanco.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(registroformapagobanco.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(registroformapagobanco.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(registroformapagobanco.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(registroformapagobanco.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(registroformapagobanco.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RegistroFormaPagoBanco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(registroformapagobanco);
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
			this.deepLoad(this.registroformapagobanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RegistroFormaPagoBanco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(registroformapagobancos!=null) {
				for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos) {
					this.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(registroformapagobancos);
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
			if(registroformapagobancos!=null) {
				for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos) {
					this.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(registroformapagobancos);
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
			this.getNewConnexionToDeep(RegistroFormaPagoBanco.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(registroformapagobanco,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RegistroFormaPagoBanco.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(registroformapagobancos!=null) {
				for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos) {
					this.deepSave(registroformapagobanco,isDeep,deepLoadType,clases);
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
			if(registroformapagobancos!=null) {
				for(RegistroFormaPagoBanco registroformapagobanco:registroformapagobancos) {
					this.deepSave(registroformapagobanco,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRegistroFormaPagoBancosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,RegistroFormaPagoBancoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,RegistroFormaPagoBancoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdEstadoRegistroFormaPagoBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_registro_forma_pago_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRegistroFormaPagoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRegistroFormaPagoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_registro_forma_pago_banco,RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRegistroFormaPagoBanco);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRegistroFormaPagoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdEstadoRegistroFormaPagoBanco(String sFinalQuery,Pagination pagination,Long id_estado_registro_forma_pago_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRegistroFormaPagoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRegistroFormaPagoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_registro_forma_pago_banco,RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRegistroFormaPagoBanco);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRegistroFormaPagoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,RegistroFormaPagoBancoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,RegistroFormaPagoBancoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,RegistroFormaPagoBancoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,RegistroFormaPagoBancoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRegistroFormaPagoBancosFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RegistroFormaPagoBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRegistroFormaPagoBancosFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			RegistroFormaPagoBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(this.registroformapagobancos);
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
			if(RegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RegistroFormaPagoBancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RegistroFormaPagoBanco registroformapagobanco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIA) {
				if(registroformapagobanco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RegistroFormaPagoBancoDataAccess.TABLENAME, registroformapagobanco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RegistroFormaPagoBancoLogic.registrarAuditoriaDetallesRegistroFormaPagoBanco(connexion,registroformapagobanco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(registroformapagobanco.getIsDeleted()) {
					/*if(!registroformapagobanco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RegistroFormaPagoBancoDataAccess.TABLENAME, registroformapagobanco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RegistroFormaPagoBancoLogic.registrarAuditoriaDetallesRegistroFormaPagoBanco(connexion,registroformapagobanco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RegistroFormaPagoBancoDataAccess.TABLENAME, registroformapagobanco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(registroformapagobanco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RegistroFormaPagoBancoDataAccess.TABLENAME, registroformapagobanco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RegistroFormaPagoBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RegistroFormaPagoBancoLogic.registrarAuditoriaDetallesRegistroFormaPagoBanco(connexion,registroformapagobanco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRegistroFormaPagoBanco(Connexion connexion,RegistroFormaPagoBanco registroformapagobanco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_empresa().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_empresa()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_empresa().toString();
				}
				if(registroformapagobanco.getid_empresa()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_sucursal().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_sucursal()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_sucursal().toString();
				}
				if(registroformapagobanco.getid_sucursal()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_ejercicio().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_ejercicio().toString();
				}
				if(registroformapagobanco.getid_ejercicio()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_periodo().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_periodo()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_periodo().toString();
				}
				if(registroformapagobanco.getid_periodo()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_asiento_contable().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_asiento_contable().toString();
				}
				if(registroformapagobanco.getid_asiento_contable()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_tipo_forma_pago().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_tipo_forma_pago().toString();
				}
				if(registroformapagobanco.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_estado_registro_forma_pago_banco().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_estado_registro_forma_pago_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_estado_registro_forma_pago_banco()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_estado_registro_forma_pago_banco().toString();
				}
				if(registroformapagobanco.getid_estado_registro_forma_pago_banco()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_estado_registro_forma_pago_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_cliente().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_cliente()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_cliente().toString();
				}
				if(registroformapagobanco.getid_cliente()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getnombre_banco().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnombre_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnombre_banco()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnombre_banco();
				}
				if(registroformapagobanco.getnombre_banco()!=null)
				{
					strValorNuevo=registroformapagobanco.getnombre_banco() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getnombre_girador().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnombre_girador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnombre_girador()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnombre_girador();
				}
				if(registroformapagobanco.getnombre_girador()!=null)
				{
					strValorNuevo=registroformapagobanco.getnombre_girador() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getfecha_vencimiento().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha_vencimiento().toString();
				}
				if(registroformapagobanco.getfecha_vencimiento()!=null)
				{
					strValorNuevo=registroformapagobanco.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getnumero_cuenta().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cuenta()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cuenta();
				}
				if(registroformapagobanco.getnumero_cuenta()!=null)
				{
					strValorNuevo=registroformapagobanco.getnumero_cuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getnumero_cheque().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cheque()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cheque();
				}
				if(registroformapagobanco.getnumero_cheque()!=null)
				{
					strValorNuevo=registroformapagobanco.getnumero_cheque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getvalor_monto().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getvalor_monto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getvalor_monto()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getvalor_monto().toString();
				}
				if(registroformapagobanco.getvalor_monto()!=null)
				{
					strValorNuevo=registroformapagobanco.getvalor_monto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.VALORMONTO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getfecha().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha().toString();
				}
				if(registroformapagobanco.getfecha()!=null)
				{
					strValorNuevo=registroformapagobanco.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getfecha_vencimiento_original().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha_vencimiento_original()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha_vencimiento_original()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getfecha_vencimiento_original().toString();
				}
				if(registroformapagobanco.getfecha_vencimiento_original()!=null)
				{
					strValorNuevo=registroformapagobanco.getfecha_vencimiento_original().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getnumero_cambio().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cambio()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getnumero_cambio().toString();
				}
				if(registroformapagobanco.getnumero_cambio()!=null)
				{
					strValorNuevo=registroformapagobanco.getnumero_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_anio().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_anio()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_anio().toString();
				}
				if(registroformapagobanco.getid_anio()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(registroformapagobanco.getIsNew()||!registroformapagobanco.getid_mes().equals(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_mes()!=null)
				{
					strValorActual=registroformapagobanco.getRegistroFormaPagoBancoOriginal().getid_mes().toString();
				}
				if(registroformapagobanco.getid_mes()!=null)
				{
					strValorNuevo=registroformapagobanco.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RegistroFormaPagoBancoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRegistroFormaPagoBancoRelacionesWithConnection(RegistroFormaPagoBanco registroformapagobanco) throws Exception {

		if(!registroformapagobanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRegistroFormaPagoBancoRelacionesBase(registroformapagobanco,true);
		}
	}

	public void saveRegistroFormaPagoBancoRelaciones(RegistroFormaPagoBanco registroformapagobanco)throws Exception {

		if(!registroformapagobanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRegistroFormaPagoBancoRelacionesBase(registroformapagobanco,false);
		}
	}

	public void saveRegistroFormaPagoBancoRelacionesBase(RegistroFormaPagoBanco registroformapagobanco,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RegistroFormaPagoBanco-saveRelacionesWithConnection");}
	

			this.setRegistroFormaPagoBanco(registroformapagobanco);

			if(RegistroFormaPagoBancoLogicAdditional.validarSaveRelaciones(registroformapagobanco,this)) {

				RegistroFormaPagoBancoLogicAdditional.updateRelacionesToSave(registroformapagobanco,this);

				if((registroformapagobanco.getIsNew()||registroformapagobanco.getIsChanged())&&!registroformapagobanco.getIsDeleted()) {
					this.saveRegistroFormaPagoBanco();
					this.saveRegistroFormaPagoBancoRelacionesDetalles();

				} else if(registroformapagobanco.getIsDeleted()) {
					this.saveRegistroFormaPagoBancoRelacionesDetalles();
					this.saveRegistroFormaPagoBanco();
				}

				RegistroFormaPagoBancoLogicAdditional.updateRelacionesToSaveAfter(registroformapagobanco,this);

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
	
	
	private void saveRegistroFormaPagoBancoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RegistroFormaPagoBancoConstantesFunciones.getClassesForeignKeysOfRegistroFormaPagoBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RegistroFormaPagoBancoConstantesFunciones.getClassesRelationshipsOfRegistroFormaPagoBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
