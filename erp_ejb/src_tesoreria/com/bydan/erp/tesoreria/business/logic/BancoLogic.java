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
import com.bydan.erp.tesoreria.util.BancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.BancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.BancoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.Banco;
import com.bydan.erp.tesoreria.business.logic.BancoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class BancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BancoLogic.class);
	
	protected BancoDataAccess bancoDataAccess; 	
	protected Banco banco;
	protected List<Banco> bancos;
	protected Object bancoObject;	
	protected List<Object> bancosObject;
	
	public static ClassValidator<Banco> bancoValidator = new ClassValidator<Banco>(Banco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BancoLogicAdditional bancoLogicAdditional=null;
	
	public BancoLogicAdditional getBancoLogicAdditional() {
		return this.bancoLogicAdditional;
	}
	
	public void setBancoLogicAdditional(BancoLogicAdditional bancoLogicAdditional) {
		try {
			this.bancoLogicAdditional=bancoLogicAdditional;
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
	
	
	
	
	public  BancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.bancoDataAccess = new BancoDataAccess();
			
			this.bancos= new ArrayList<Banco>();
			this.banco= new Banco();
			
			this.bancoObject=new Object();
			this.bancosObject=new ArrayList<Object>();
				
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
			
			this.bancoDataAccess.setConnexionType(this.connexionType);
			this.bancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.bancoDataAccess = new BancoDataAccess();
			this.bancos= new ArrayList<Banco>();
			this.banco= new Banco();
			this.bancoObject=new Object();
			this.bancosObject=new ArrayList<Object>();
			
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
			
			this.bancoDataAccess.setConnexionType(this.connexionType);
			this.bancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Banco getBanco() throws Exception {	
		BancoLogicAdditional.checkBancoToGet(banco,this.datosCliente,this.arrDatoGeneral);
		BancoLogicAdditional.updateBancoToGet(banco,this.arrDatoGeneral);
		
		return banco;
	}
		
	public void setBanco(Banco newBanco) {
		this.banco = newBanco;
	}
	
	public BancoDataAccess getBancoDataAccess() {
		return bancoDataAccess;
	}
	
	public void setBancoDataAccess(BancoDataAccess newbancoDataAccess) {
		this.bancoDataAccess = newbancoDataAccess;
	}
	
	public List<Banco> getBancos() throws Exception {		
		this.quitarBancosNulos();
		
		BancoLogicAdditional.checkBancoToGets(bancos,this.datosCliente,this.arrDatoGeneral);
		
		for (Banco bancoLocal: bancos ) {
			BancoLogicAdditional.updateBancoToGet(bancoLocal,this.arrDatoGeneral);
		}
		
		return bancos;
	}
	
	public void setBancos(List<Banco> newBancos) {
		this.bancos = newBancos;
	}
	
	public Object getBancoObject() {	
		this.bancoObject=this.bancoDataAccess.getEntityObject();
		return this.bancoObject;
	}
		
	public void setBancoObject(Object newBancoObject) {
		this.bancoObject = newBancoObject;
	}
	
	public List<Object> getBancosObject() {		
		this.bancosObject=this.bancoDataAccess.getEntitiesObject();
		return this.bancosObject;
	}
		
	public void setBancosObject(List<Object> newBancosObject) {
		this.bancosObject = newBancosObject;
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
		
		if(this.bancoDataAccess!=null) {
			this.bancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			bancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			bancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		banco = new  Banco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			banco=bancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.banco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.banco);
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
		banco = new  Banco();
		  		  
        try {
			
			banco=bancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.banco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.banco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		banco = new  Banco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			banco=bancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.banco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.banco);
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
		banco = new  Banco();
		  		  
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
		banco = new  Banco();
		  		  
        try {
			
			banco=bancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.banco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.banco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		banco = new  Banco();
		  		  
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
		banco = new  Banco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =bancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		banco = new  Banco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=bancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		banco = new  Banco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =bancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		banco = new  Banco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=bancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		banco = new  Banco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =bancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		banco = new  Banco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=bancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bancos = new  ArrayList<Banco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
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
		bancos = new  ArrayList<Banco>();
		  		  
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
		bancos = new  ArrayList<Banco>();
		  		  
        try {			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		bancos = new  ArrayList<Banco>();
		  		  
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
		bancos = new  ArrayList<Banco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
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
		bancos = new  ArrayList<Banco>();
		  		  
        try {
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
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
		bancos = new  ArrayList<Banco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
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
		bancos = new  ArrayList<Banco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		banco = new  Banco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			banco=bancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBanco(banco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.banco);
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
		banco = new  Banco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			banco=bancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBanco(banco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.banco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bancos = new  ArrayList<Banco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
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
		bancos = new  ArrayList<Banco>();
		  		  
        try {
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		bancos = new  ArrayList<Banco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getTodosBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
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
	
	public  void  getTodosBancos(String sFinalQuery,Pagination pagination)throws Exception {
		bancos = new  ArrayList<Banco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBanco(bancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBanco(Banco banco) throws Exception {
		Boolean estaValidado=false;
		
		if(banco.getIsNew() || banco.getIsChanged()) { 
			this.invalidValues = bancoValidator.getInvalidValues(banco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(banco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBanco(List<Banco> Bancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Banco bancoLocal:bancos) {				
			estaValidadoObjeto=this.validarGuardarBanco(bancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBanco(List<Banco> Bancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBanco(bancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBanco(Banco Banco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBanco(banco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Banco banco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+banco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BancoConstantesFunciones.getBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"banco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-saveBancoWithConnection");connexion.begin();			
			
			BancoLogicAdditional.checkBancoToSave(this.banco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BancoLogicAdditional.updateBancoToSave(this.banco,this.arrDatoGeneral);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.banco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBanco(this.banco)) {
				BancoDataAccess.save(this.banco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.banco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BancoLogicAdditional.checkBancoToSaveAfter(this.banco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBanco();
			
			connexion.commit();			
			
			if(this.banco.getIsDeleted()) {
				this.banco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBanco()throws Exception {	
		try {	
			
			BancoLogicAdditional.checkBancoToSave(this.banco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BancoLogicAdditional.updateBancoToSave(this.banco,this.arrDatoGeneral);
			
			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.banco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBanco(this.banco)) {			
				BancoDataAccess.save(this.banco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.banco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BancoLogicAdditional.checkBancoToSaveAfter(this.banco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.banco.getIsDeleted()) {
				this.banco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-saveBancosWithConnection");connexion.begin();			
			
			BancoLogicAdditional.checkBancoToSaves(bancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBancos();
			
			Boolean validadoTodosBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Banco bancoLocal:bancos) {		
				if(bancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BancoLogicAdditional.updateBancoToSave(bancoLocal,this.arrDatoGeneral);
	        	
				BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBanco(bancoLocal)) {
					BancoDataAccess.save(bancoLocal, connexion);				
				} else {
					validadoTodosBanco=false;
				}
			}
			
			if(!validadoTodosBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BancoLogicAdditional.checkBancoToSavesAfter(bancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBancos();
			
			connexion.commit();		
			
			this.quitarBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBancos()throws Exception {				
		 try {	
			BancoLogicAdditional.checkBancoToSaves(bancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Banco bancoLocal:bancos) {				
				if(bancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BancoLogicAdditional.updateBancoToSave(bancoLocal,this.arrDatoGeneral);
	        	
				BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBanco(bancoLocal)) {				
					BancoDataAccess.save(bancoLocal, connexion);				
				} else {
					validadoTodosBanco=false;
				}
			}
			
			if(!validadoTodosBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BancoLogicAdditional.checkBancoToSavesAfter(bancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BancoParameterReturnGeneral procesarAccionBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Banco> bancos,BancoParameterReturnGeneral bancoParameterGeneral)throws Exception {
		 try {	
			BancoParameterReturnGeneral bancoReturnGeneral=new BancoParameterReturnGeneral();
	
			BancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bancos,bancoParameterGeneral,bancoReturnGeneral);
			
			return bancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BancoParameterReturnGeneral procesarAccionBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Banco> bancos,BancoParameterReturnGeneral bancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-procesarAccionBancosWithConnection");connexion.begin();			
			
			BancoParameterReturnGeneral bancoReturnGeneral=new BancoParameterReturnGeneral();
	
			BancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bancos,bancoParameterGeneral,bancoReturnGeneral);
			
			this.connexion.commit();
			
			return bancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BancoParameterReturnGeneral procesarEventosBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Banco> bancos,Banco banco,BancoParameterReturnGeneral bancoParameterGeneral,Boolean isEsNuevoBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			BancoParameterReturnGeneral bancoReturnGeneral=new BancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bancos,banco,bancoParameterGeneral,bancoReturnGeneral,isEsNuevoBanco,clases);
			
			return bancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BancoParameterReturnGeneral procesarEventosBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Banco> bancos,Banco banco,BancoParameterReturnGeneral bancoParameterGeneral,Boolean isEsNuevoBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-procesarEventosBancosWithConnection");connexion.begin();			
			
			BancoParameterReturnGeneral bancoReturnGeneral=new BancoParameterReturnGeneral();
	
			bancoReturnGeneral.setBanco(banco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bancos,banco,bancoParameterGeneral,bancoReturnGeneral,isEsNuevoBanco,clases);
			
			this.connexion.commit();
			
			return bancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BancoParameterReturnGeneral procesarImportacionBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BancoParameterReturnGeneral bancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-procesarImportacionBancosWithConnection");connexion.begin();			
			
			BancoParameterReturnGeneral bancoReturnGeneral=new BancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.bancos=new ArrayList<Banco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.banco=new Banco();
				
				
				if(conColumnasBase) {this.banco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.banco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.banco.setcodigo(arrColumnas[iColumn++]);
				this.banco.setcodigo_institucion(arrColumnas[iColumn++]);
				this.banco.setnombre(arrColumnas[iColumn++]);
				this.banco.setdias_efectivo_local(Integer.parseInt(arrColumnas[iColumn++]));
				this.banco.setdias_efectivo_extranjero(Integer.parseInt(arrColumnas[iColumn++]));
				this.banco.setdelimitador(arrColumnas[iColumn++]);
				
				this.bancos.add(this.banco);
			}
			
			this.saveBancos();
			
			this.connexion.commit();
			
			bancoReturnGeneral.setConRetornoEstaProcesado(true);
			bancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return bancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBancosEliminados() throws Exception {				
		
		List<Banco> bancosAux= new ArrayList<Banco>();
		
		for(Banco banco:bancos) {
			if(!banco.getIsDeleted()) {
				bancosAux.add(banco);
			}
		}
		
		bancos=bancosAux;
	}
	
	public void quitarBancosNulos() throws Exception {				
		
		List<Banco> bancosAux= new ArrayList<Banco>();
		
		for(Banco banco : this.bancos) {
			if(banco==null) {
				bancosAux.add(banco);
			}
		}
		
		//this.bancos=bancosAux;
		
		this.bancos.removeAll(bancosAux);
	}
	
	public void getSetVersionRowBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(banco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((banco.getIsDeleted() || (banco.getIsChanged()&&!banco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=bancoDataAccess.getSetVersionRowBanco(connexion,banco.getId());
				
				if(!banco.getVersionRow().equals(timestamp)) {	
					banco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				banco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBanco()throws Exception {	
		
		if(banco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((banco.getIsDeleted() || (banco.getIsChanged()&&!banco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=bancoDataAccess.getSetVersionRowBanco(connexion,banco.getId());
			
			try {							
				if(!banco.getVersionRow().equals(timestamp)) {	
					banco.setVersionRow(timestamp);
				}
				
				banco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBancosWithConnection()throws Exception {	
		if(bancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Banco bancoAux:bancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(bancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bancoAux.getIsDeleted() || (bancoAux.getIsChanged()&&!bancoAux.getIsNew())) {
						
						timestamp=bancoDataAccess.getSetVersionRowBanco(connexion,bancoAux.getId());
						
						if(!banco.getVersionRow().equals(timestamp)) {	
							bancoAux.setVersionRow(timestamp);
						}
								
						bancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBancos()throws Exception {	
		if(bancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Banco bancoAux:bancos) {
					if(bancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bancoAux.getIsDeleted() || (bancoAux.getIsChanged()&&!bancoAux.getIsNew())) {
						
						timestamp=bancoDataAccess.getSetVersionRowBanco(connexion,bancoAux.getId());
						
						if(!bancoAux.getVersionRow().equals(timestamp)) {	
							bancoAux.setVersionRow(timestamp);
						}
						
													
						bancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BancoParameterReturnGeneral cargarCombosLoteForeignKeyBancoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoBanco,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalFormato1,String finalQueryGlobalFormato2) throws Exception {
		BancoParameterReturnGeneral  bancoReturnGeneral =new BancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-cargarCombosLoteForeignKeyBancoWithConnection");connexion.begin();
			
			bancoReturnGeneral =new BancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bancoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bancoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoBanco> tipobancosForeignKey=new ArrayList<TipoBanco>();
			TipoBancoLogic tipobancoLogic=new TipoBancoLogic();
			tipobancoLogic.setConnexion(this.connexion);
			//tipobancoLogic.getTipoBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoBanco.equals("NONE")) {
				tipobancoLogic.getTodosTipoBancos(finalQueryGlobalTipoBanco,new Pagination());
				tipobancosForeignKey=tipobancoLogic.getTipoBancos();
			}

			bancoReturnGeneral.settipobancosForeignKey(tipobancosForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			bancoReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			bancoReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<Formato> formato1sForeignKey=new ArrayList<Formato>();
			FormatoLogic formato1Logic=new FormatoLogic();
			formato1Logic.setConnexion(this.connexion);
			formato1Logic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato1.equals("NONE")) {
				formato1Logic.getTodosFormatos(finalQueryGlobalFormato1,new Pagination());
				formato1sForeignKey=formato1Logic.getFormatos();
			}

			bancoReturnGeneral.setformato1sForeignKey(formato1sForeignKey);


			List<Formato> formato2sForeignKey=new ArrayList<Formato>();
			FormatoLogic formato2Logic=new FormatoLogic();
			formato2Logic.setConnexion(this.connexion);
			formato2Logic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato2.equals("NONE")) {
				formato2Logic.getTodosFormatos(finalQueryGlobalFormato2,new Pagination());
				formato2sForeignKey=formato2Logic.getFormatos();
			}

			bancoReturnGeneral.setformato2sForeignKey(formato2sForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return bancoReturnGeneral;
	}
	
	public BancoParameterReturnGeneral cargarCombosLoteForeignKeyBanco(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoBanco,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalFormato1,String finalQueryGlobalFormato2) throws Exception {
		BancoParameterReturnGeneral  bancoReturnGeneral =new BancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			bancoReturnGeneral =new BancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bancoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bancoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoBanco> tipobancosForeignKey=new ArrayList<TipoBanco>();
			TipoBancoLogic tipobancoLogic=new TipoBancoLogic();
			tipobancoLogic.setConnexion(this.connexion);
			//tipobancoLogic.getTipoBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoBanco.equals("NONE")) {
				tipobancoLogic.getTodosTipoBancos(finalQueryGlobalTipoBanco,new Pagination());
				tipobancosForeignKey=tipobancoLogic.getTipoBancos();
			}

			bancoReturnGeneral.settipobancosForeignKey(tipobancosForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			bancoReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			bancoReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<Formato> formato1sForeignKey=new ArrayList<Formato>();
			FormatoLogic formato1Logic=new FormatoLogic();
			formato1Logic.setConnexion(this.connexion);
			formato1Logic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato1.equals("NONE")) {
				formato1Logic.getTodosFormatos(finalQueryGlobalFormato1,new Pagination());
				formato1sForeignKey=formato1Logic.getFormatos();
			}

			bancoReturnGeneral.setformato1sForeignKey(formato1sForeignKey);


			List<Formato> formato2sForeignKey=new ArrayList<Formato>();
			FormatoLogic formato2Logic=new FormatoLogic();
			formato2Logic.setConnexion(this.connexion);
			formato2Logic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato2.equals("NONE")) {
				formato2Logic.getTodosFormatos(finalQueryGlobalFormato2,new Pagination());
				formato2sForeignKey=formato2Logic.getFormatos();
			}

			bancoReturnGeneral.setformato2sForeignKey(formato2sForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return bancoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyBancoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CuentaBancoPunVenLogic cuentabancopunvenLogic=new CuentaBancoPunVenLogic();
			PoliticasClienteLogic politicasclienteLogic=new PoliticasClienteLogic();
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
			AutoriPagoLogic autoripagoLogic=new AutoriPagoLogic();
			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic=new TipoCuentaBancoGeneralLogic();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyBancoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CuentaBancoPunVen.class));
			classes.add(new Classe(PoliticasCliente.class));
			classes.add(new Classe(FormaPagoPuntoVenta.class));
			classes.add(new Classe(TarjetaCredito.class));
			classes.add(new Classe(AutoriPago.class));
			classes.add(new Classe(TipoCuentaBancoGeneral.class));
			classes.add(new Classe(CuentaBanco.class));
											
			

			cuentabancopunvenLogic.setConnexion(this.getConnexion());
			cuentabancopunvenLogic.setDatosCliente(this.datosCliente);
			cuentabancopunvenLogic.setIsConRefrescarForeignKeys(true);

			politicasclienteLogic.setConnexion(this.getConnexion());
			politicasclienteLogic.setDatosCliente(this.datosCliente);
			politicasclienteLogic.setIsConRefrescarForeignKeys(true);

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			tarjetacreditoLogic.setConnexion(this.getConnexion());
			tarjetacreditoLogic.setDatosCliente(this.datosCliente);
			tarjetacreditoLogic.setIsConRefrescarForeignKeys(true);

			autoripagoLogic.setConnexion(this.getConnexion());
			autoripagoLogic.setDatosCliente(this.datosCliente);
			autoripagoLogic.setIsConRefrescarForeignKeys(true);

			tipocuentabancogeneralLogic.setConnexion(this.getConnexion());
			tipocuentabancogeneralLogic.setDatosCliente(this.datosCliente);
			tipocuentabancogeneralLogic.setIsConRefrescarForeignKeys(true);

			cuentabancoLogic.setConnexion(this.getConnexion());
			cuentabancoLogic.setDatosCliente(this.datosCliente);
			cuentabancoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Banco banco:this.bancos) {
				

				classes=new ArrayList<Classe>();
				classes=CuentaBancoPunVenConstantesFunciones.getClassesForeignKeysOfCuentaBancoPunVen(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentabancopunvenLogic.setCuentaBancoPunVens(banco.cuentabancopunvens);
				cuentabancopunvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicasclienteLogic.setPoliticasClientes(banco.politicasclientes);
				politicasclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(banco.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TarjetaCreditoConstantesFunciones.getClassesForeignKeysOfTarjetaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);

				tarjetacreditoLogic.setTarjetaCreditos(banco.tarjetacreditos);
				tarjetacreditoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoripagoLogic.setAutoriPagos(banco.autoripagos);
				autoripagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TipoCuentaBancoGeneralConstantesFunciones.getClassesForeignKeysOfTipoCuentaBancoGeneral(new ArrayList<Classe>(),DeepLoadType.NONE);

				tipocuentabancogeneralLogic.setTipoCuentaBancoGenerals(banco.tipocuentabancogenerals);
				tipocuentabancogeneralLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CuentaBancoConstantesFunciones.getClassesForeignKeysOfCuentaBanco(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentabancoLogic.setCuentaBancos(banco.cuentabancos);
				cuentabancoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Banco banco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BancoLogicAdditional.updateBancoToGet(banco,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		banco.setEmpresa(bancoDataAccess.getEmpresa(connexion,banco));
		banco.setSucursal(bancoDataAccess.getSucursal(connexion,banco));
		banco.setTipoBanco(bancoDataAccess.getTipoBanco(connexion,banco));
		banco.setCuentaContableDebito(bancoDataAccess.getCuentaContableDebito(connexion,banco));
		banco.setCuentaContableCredito(bancoDataAccess.getCuentaContableCredito(connexion,banco));
		banco.setFormato1(bancoDataAccess.getFormato1(connexion,banco));
		banco.setFormato2(bancoDataAccess.getFormato2(connexion,banco));
		banco.setAutoriPagos(bancoDataAccess.getAutoriPagos(connexion,banco));
		banco.setTarjetaCreditos(bancoDataAccess.getTarjetaCreditos(connexion,banco));
		banco.setCuentaBancoPunVens(bancoDataAccess.getCuentaBancoPunVens(connexion,banco));
		banco.setPoliticasClientes(bancoDataAccess.getPoliticasClientes(connexion,banco));
		banco.setFormaPagoPuntoVentas(bancoDataAccess.getFormaPagoPuntoVentas(connexion,banco));
		banco.setCuentaBancos(bancoDataAccess.getCuentaBancos(connexion,banco));
		banco.setTipoCuentaBancoGenerals(bancoDataAccess.getTipoCuentaBancoGenerals(connexion,banco));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				banco.setEmpresa(bancoDataAccess.getEmpresa(connexion,banco));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				banco.setSucursal(bancoDataAccess.getSucursal(connexion,banco));
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				banco.setTipoBanco(bancoDataAccess.getTipoBanco(connexion,banco));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				banco.setCuentaContableDebito(bancoDataAccess.getCuentaContableDebito(connexion,banco));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				banco.setCuentaContableCredito(bancoDataAccess.getCuentaContableCredito(connexion,banco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				banco.setFormato1(bancoDataAccess.getFormato1(connexion,banco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				banco.setFormato2(bancoDataAccess.getFormato2(connexion,banco));
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setAutoriPagos(bancoDataAccess.getAutoriPagos(connexion,banco));

				if(this.isConDeep) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(this.connexion);
					autoripagoLogic.setAutoriPagos(banco.getAutoriPagos());
					ArrayList<Classe> classesLocal=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoripagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(autoripagoLogic.getAutoriPagos());
					banco.setAutoriPagos(autoripagoLogic.getAutoriPagos());
				}

				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setTarjetaCreditos(bancoDataAccess.getTarjetaCreditos(connexion,banco));

				if(this.isConDeep) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(this.connexion);
					tarjetacreditoLogic.setTarjetaCreditos(banco.getTarjetaCreditos());
					ArrayList<Classe> classesLocal=TarjetaCreditoConstantesFunciones.getClassesForeignKeysOfTarjetaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);
					tarjetacreditoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(tarjetacreditoLogic.getTarjetaCreditos());
					banco.setTarjetaCreditos(tarjetacreditoLogic.getTarjetaCreditos());
				}

				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setCuentaBancoPunVens(bancoDataAccess.getCuentaBancoPunVens(connexion,banco));

				if(this.isConDeep) {
					CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(this.connexion);
					cuentabancopunvenLogic.setCuentaBancoPunVens(banco.getCuentaBancoPunVens());
					ArrayList<Classe> classesLocal=CuentaBancoPunVenConstantesFunciones.getClassesForeignKeysOfCuentaBancoPunVen(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentabancopunvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(cuentabancopunvenLogic.getCuentaBancoPunVens());
					banco.setCuentaBancoPunVens(cuentabancopunvenLogic.getCuentaBancoPunVens());
				}

				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setPoliticasClientes(bancoDataAccess.getPoliticasClientes(connexion,banco));

				if(this.isConDeep) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(this.connexion);
					politicasclienteLogic.setPoliticasClientes(banco.getPoliticasClientes());
					ArrayList<Classe> classesLocal=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicasclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclienteLogic.getPoliticasClientes());
					banco.setPoliticasClientes(politicasclienteLogic.getPoliticasClientes());
				}

				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setFormaPagoPuntoVentas(bancoDataAccess.getFormaPagoPuntoVentas(connexion,banco));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(banco.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					banco.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setCuentaBancos(bancoDataAccess.getCuentaBancos(connexion,banco));

				if(this.isConDeep) {
					CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(this.connexion);
					cuentabancoLogic.setCuentaBancos(banco.getCuentaBancos());
					ArrayList<Classe> classesLocal=CuentaBancoConstantesFunciones.getClassesForeignKeysOfCuentaBanco(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentabancoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(cuentabancoLogic.getCuentaBancos());
					banco.setCuentaBancos(cuentabancoLogic.getCuentaBancos());
				}

				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setTipoCuentaBancoGenerals(bancoDataAccess.getTipoCuentaBancoGenerals(connexion,banco));

				if(this.isConDeep) {
					TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(this.connexion);
					tipocuentabancogeneralLogic.setTipoCuentaBancoGenerals(banco.getTipoCuentaBancoGenerals());
					ArrayList<Classe> classesLocal=TipoCuentaBancoGeneralConstantesFunciones.getClassesForeignKeysOfTipoCuentaBancoGeneral(new ArrayList<Classe>(),DeepLoadType.NONE);
					tipocuentabancogeneralLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(tipocuentabancogeneralLogic.getTipoCuentaBancoGenerals());
					banco.setTipoCuentaBancoGenerals(tipocuentabancogeneralLogic.getTipoCuentaBancoGenerals());
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
			banco.setEmpresa(bancoDataAccess.getEmpresa(connexion,banco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setSucursal(bancoDataAccess.getSucursal(connexion,banco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setTipoBanco(bancoDataAccess.getTipoBanco(connexion,banco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setCuentaContableDebito(bancoDataAccess.getCuentaContableDebito(connexion,banco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setCuentaContableCredito(bancoDataAccess.getCuentaContableCredito(connexion,banco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setFormato1(bancoDataAccess.getFormato1(connexion,banco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setFormato2(bancoDataAccess.getFormato2(connexion,banco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			banco.setAutoriPagos(bancoDataAccess.getAutoriPagos(connexion,banco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCredito.class));
			banco.setTarjetaCreditos(bancoDataAccess.getTarjetaCreditos(connexion,banco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBancoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaBancoPunVen.class));
			banco.setCuentaBancoPunVens(bancoDataAccess.getCuentaBancoPunVens(connexion,banco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			banco.setPoliticasClientes(bancoDataAccess.getPoliticasClientes(connexion,banco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			banco.setFormaPagoPuntoVentas(bancoDataAccess.getFormaPagoPuntoVentas(connexion,banco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaBanco.class));
			banco.setCuentaBancos(bancoDataAccess.getCuentaBancos(connexion,banco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoCuentaBancoGeneral.class));
			banco.setTipoCuentaBancoGenerals(bancoDataAccess.getTipoCuentaBancoGenerals(connexion,banco));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		banco.setEmpresa(bancoDataAccess.getEmpresa(connexion,banco));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(banco.getEmpresa(),isDeep,deepLoadType,clases);
				
		banco.setSucursal(bancoDataAccess.getSucursal(connexion,banco));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(banco.getSucursal(),isDeep,deepLoadType,clases);
				
		banco.setTipoBanco(bancoDataAccess.getTipoBanco(connexion,banco));
		TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
		tipobancoLogic.deepLoad(banco.getTipoBanco(),isDeep,deepLoadType,clases);
				
		banco.setCuentaContableDebito(bancoDataAccess.getCuentaContableDebito(connexion,banco));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(banco.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		banco.setCuentaContableCredito(bancoDataAccess.getCuentaContableCredito(connexion,banco));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(banco.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		banco.setFormato1(bancoDataAccess.getFormato1(connexion,banco));
		FormatoLogic formato1Logic= new FormatoLogic(connexion);
		formato1Logic.deepLoad(banco.getFormato1(),isDeep,deepLoadType,clases);
				
		banco.setFormato2(bancoDataAccess.getFormato2(connexion,banco));
		FormatoLogic formato2Logic= new FormatoLogic(connexion);
		formato2Logic.deepLoad(banco.getFormato2(),isDeep,deepLoadType,clases);
				

		banco.setAutoriPagos(bancoDataAccess.getAutoriPagos(connexion,banco));

		for(AutoriPago autoripago:banco.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
		}

		banco.setTarjetaCreditos(bancoDataAccess.getTarjetaCreditos(connexion,banco));

		for(TarjetaCredito tarjetacredito:banco.getTarjetaCreditos()) {
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
		}

		banco.setCuentaBancoPunVens(bancoDataAccess.getCuentaBancoPunVens(connexion,banco));

		for(CuentaBancoPunVen cuentabancopunven:banco.getCuentaBancoPunVens()) {
			CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
			cuentabancopunvenLogic.deepLoad(cuentabancopunven,isDeep,deepLoadType,clases);
		}

		banco.setPoliticasClientes(bancoDataAccess.getPoliticasClientes(connexion,banco));

		for(PoliticasCliente politicascliente:banco.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
		}

		banco.setFormaPagoPuntoVentas(bancoDataAccess.getFormaPagoPuntoVentas(connexion,banco));

		for(FormaPagoPuntoVenta formapagopuntoventa:banco.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}

		banco.setCuentaBancos(bancoDataAccess.getCuentaBancos(connexion,banco));

		for(CuentaBanco cuentabanco:banco.getCuentaBancos()) {
			CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
			cuentabancoLogic.deepLoad(cuentabanco,isDeep,deepLoadType,clases);
		}

		banco.setTipoCuentaBancoGenerals(bancoDataAccess.getTipoCuentaBancoGenerals(connexion,banco));

		for(TipoCuentaBancoGeneral tipocuentabancogeneral:banco.getTipoCuentaBancoGenerals()) {
			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
			tipocuentabancogeneralLogic.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				banco.setEmpresa(bancoDataAccess.getEmpresa(connexion,banco));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(banco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				banco.setSucursal(bancoDataAccess.getSucursal(connexion,banco));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(banco.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				banco.setTipoBanco(bancoDataAccess.getTipoBanco(connexion,banco));
				TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
				tipobancoLogic.deepLoad(banco.getTipoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				banco.setCuentaContableDebito(bancoDataAccess.getCuentaContableDebito(connexion,banco));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(banco.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				banco.setCuentaContableCredito(bancoDataAccess.getCuentaContableCredito(connexion,banco));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(banco.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				banco.setFormato1(bancoDataAccess.getFormato1(connexion,banco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(banco.getFormato1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				banco.setFormato2(bancoDataAccess.getFormato2(connexion,banco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(banco.getFormato2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setAutoriPagos(bancoDataAccess.getAutoriPagos(connexion,banco));

				for(AutoriPago autoripago:banco.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setTarjetaCreditos(bancoDataAccess.getTarjetaCreditos(connexion,banco));

				for(TarjetaCredito tarjetacredito:banco.getTarjetaCreditos()) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
					tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setCuentaBancoPunVens(bancoDataAccess.getCuentaBancoPunVens(connexion,banco));

				for(CuentaBancoPunVen cuentabancopunven:banco.getCuentaBancoPunVens()) {
					CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
					cuentabancopunvenLogic.deepLoad(cuentabancopunven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setPoliticasClientes(bancoDataAccess.getPoliticasClientes(connexion,banco));

				for(PoliticasCliente politicascliente:banco.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setFormaPagoPuntoVentas(bancoDataAccess.getFormaPagoPuntoVentas(connexion,banco));

				for(FormaPagoPuntoVenta formapagopuntoventa:banco.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setCuentaBancos(bancoDataAccess.getCuentaBancos(connexion,banco));

				for(CuentaBanco cuentabanco:banco.getCuentaBancos()) {
					CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
					cuentabancoLogic.deepLoad(cuentabanco,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				banco.setTipoCuentaBancoGenerals(bancoDataAccess.getTipoCuentaBancoGenerals(connexion,banco));

				for(TipoCuentaBancoGeneral tipocuentabancogeneral:banco.getTipoCuentaBancoGenerals()) {
					TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
					tipocuentabancogeneralLogic.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
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
			banco.setEmpresa(bancoDataAccess.getEmpresa(connexion,banco));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(banco.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setSucursal(bancoDataAccess.getSucursal(connexion,banco));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(banco.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setTipoBanco(bancoDataAccess.getTipoBanco(connexion,banco));
			TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
			tipobancoLogic.deepLoad(banco.getTipoBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setCuentaContableDebito(bancoDataAccess.getCuentaContableDebito(connexion,banco));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(banco.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setCuentaContableCredito(bancoDataAccess.getCuentaContableCredito(connexion,banco));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(banco.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setFormato1(bancoDataAccess.getFormato1(connexion,banco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(banco.getFormato1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			banco.setFormato2(bancoDataAccess.getFormato2(connexion,banco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(banco.getFormato2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			banco.setAutoriPagos(bancoDataAccess.getAutoriPagos(connexion,banco));

			for(AutoriPago autoripago:banco.getAutoriPagos()) {
				AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
				autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCredito.class));
			banco.setTarjetaCreditos(bancoDataAccess.getTarjetaCreditos(connexion,banco));

			for(TarjetaCredito tarjetacredito:banco.getTarjetaCreditos()) {
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBancoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaBancoPunVen.class));
			banco.setCuentaBancoPunVens(bancoDataAccess.getCuentaBancoPunVens(connexion,banco));

			for(CuentaBancoPunVen cuentabancopunven:banco.getCuentaBancoPunVens()) {
				CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
				cuentabancopunvenLogic.deepLoad(cuentabancopunven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			banco.setPoliticasClientes(bancoDataAccess.getPoliticasClientes(connexion,banco));

			for(PoliticasCliente politicascliente:banco.getPoliticasClientes()) {
				PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
				politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			banco.setFormaPagoPuntoVentas(bancoDataAccess.getFormaPagoPuntoVentas(connexion,banco));

			for(FormaPagoPuntoVenta formapagopuntoventa:banco.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaBanco.class));
			banco.setCuentaBancos(bancoDataAccess.getCuentaBancos(connexion,banco));

			for(CuentaBanco cuentabanco:banco.getCuentaBancos()) {
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepLoad(cuentabanco,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoCuentaBancoGeneral.class));
			banco.setTipoCuentaBancoGenerals(bancoDataAccess.getTipoCuentaBancoGenerals(connexion,banco));

			for(TipoCuentaBancoGeneral tipocuentabancogeneral:banco.getTipoCuentaBancoGenerals()) {
				TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
				tipocuentabancogeneralLogic.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Banco banco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BancoLogicAdditional.updateBancoToSave(banco,this.arrDatoGeneral);
			
BancoDataAccess.save(banco, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(banco.getEmpresa(),connexion);

		SucursalDataAccess.save(banco.getSucursal(),connexion);

		TipoBancoDataAccess.save(banco.getTipoBanco(),connexion);

		CuentaContableDataAccess.save(banco.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(banco.getCuentaContableCredito(),connexion);

		FormatoDataAccess.save(banco.getFormato1(),connexion);

		FormatoDataAccess.save(banco.getFormato2(),connexion);

		for(AutoriPago autoripago:banco.getAutoriPagos()) {
			autoripago.setid_banco(banco.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
		}

		for(TarjetaCredito tarjetacredito:banco.getTarjetaCreditos()) {
			tarjetacredito.setid_banco(banco.getId());
			TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
		}

		for(CuentaBancoPunVen cuentabancopunven:banco.getCuentaBancoPunVens()) {
			cuentabancopunven.setid_banco(banco.getId());
			CuentaBancoPunVenDataAccess.save(cuentabancopunven,connexion);
		}

		for(PoliticasCliente politicascliente:banco.getPoliticasClientes()) {
			politicascliente.setid_banco(banco.getId());
			PoliticasClienteDataAccess.save(politicascliente,connexion);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:banco.getFormaPagoPuntoVentas()) {
			formapagopuntoventa.setid_banco(banco.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
		}

		for(CuentaBanco cuentabanco:banco.getCuentaBancos()) {
			cuentabanco.setid_banco(banco.getId());
			CuentaBancoDataAccess.save(cuentabanco,connexion);
		}

		for(TipoCuentaBancoGeneral tipocuentabancogeneral:banco.getTipoCuentaBancoGenerals()) {
			tipocuentabancogeneral.setid_banco(banco.getId());
			TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(banco.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(banco.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				TipoBancoDataAccess.save(banco.getTipoBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(banco.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(banco.getCuentaContableCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(banco.getFormato1(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(banco.getFormato2(),connexion);
				continue;
			}


			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:banco.getAutoriPagos()) {
					autoripago.setid_banco(banco.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCredito tarjetacredito:banco.getTarjetaCreditos()) {
					tarjetacredito.setid_banco(banco.getId());
					TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaBancoPunVen cuentabancopunven:banco.getCuentaBancoPunVens()) {
					cuentabancopunven.setid_banco(banco.getId());
					CuentaBancoPunVenDataAccess.save(cuentabancopunven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticasCliente politicascliente:banco.getPoliticasClientes()) {
					politicascliente.setid_banco(banco.getId());
					PoliticasClienteDataAccess.save(politicascliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:banco.getFormaPagoPuntoVentas()) {
					formapagopuntoventa.setid_banco(banco.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaBanco cuentabanco:banco.getCuentaBancos()) {
					cuentabanco.setid_banco(banco.getId());
					CuentaBancoDataAccess.save(cuentabanco,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoCuentaBancoGeneral tipocuentabancogeneral:banco.getTipoCuentaBancoGenerals()) {
					tipocuentabancogeneral.setid_banco(banco.getId());
					TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(banco.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(banco.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(banco.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(banco.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoBancoDataAccess.save(banco.getTipoBanco(),connexion);
		TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
		tipobancoLogic.deepLoad(banco.getTipoBanco(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(banco.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(banco.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(banco.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(banco.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(banco.getFormato1(),connexion);
		FormatoLogic formato1Logic= new FormatoLogic(connexion);
		formato1Logic.deepLoad(banco.getFormato1(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(banco.getFormato2(),connexion);
		FormatoLogic formato2Logic= new FormatoLogic(connexion);
		formato2Logic.deepLoad(banco.getFormato2(),isDeep,deepLoadType,clases);
				

		for(AutoriPago autoripago:banco.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripago.setid_banco(banco.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
			autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
		}

		for(TarjetaCredito tarjetacredito:banco.getTarjetaCreditos()) {
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacredito.setid_banco(banco.getId());
			TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
			tarjetacreditoLogic.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
		}

		for(CuentaBancoPunVen cuentabancopunven:banco.getCuentaBancoPunVens()) {
			CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
			cuentabancopunven.setid_banco(banco.getId());
			CuentaBancoPunVenDataAccess.save(cuentabancopunven,connexion);
			cuentabancopunvenLogic.deepSave(cuentabancopunven,isDeep,deepLoadType,clases);
		}

		for(PoliticasCliente politicascliente:banco.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicascliente.setid_banco(banco.getId());
			PoliticasClienteDataAccess.save(politicascliente,connexion);
			politicasclienteLogic.deepSave(politicascliente,isDeep,deepLoadType,clases);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:banco.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventa.setid_banco(banco.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
			formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
		}

		for(CuentaBanco cuentabanco:banco.getCuentaBancos()) {
			CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
			cuentabanco.setid_banco(banco.getId());
			CuentaBancoDataAccess.save(cuentabanco,connexion);
			cuentabancoLogic.deepSave(cuentabanco,isDeep,deepLoadType,clases);
		}

		for(TipoCuentaBancoGeneral tipocuentabancogeneral:banco.getTipoCuentaBancoGenerals()) {
			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
			tipocuentabancogeneral.setid_banco(banco.getId());
			TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
			tipocuentabancogeneralLogic.deepSave(tipocuentabancogeneral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(banco.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(banco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(banco.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(banco.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				TipoBancoDataAccess.save(banco.getTipoBanco(),connexion);
				TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
				tipobancoLogic.deepSave(banco.getTipoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(banco.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(banco.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(banco.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(banco.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(banco.getFormato1(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(banco.getFormato1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(banco.getFormato2(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(banco.getFormato2(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:banco.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripago.setid_banco(banco.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
					autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCredito tarjetacredito:banco.getTarjetaCreditos()) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
					tarjetacredito.setid_banco(banco.getId());
					TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
					tarjetacreditoLogic.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaBancoPunVen cuentabancopunven:banco.getCuentaBancoPunVens()) {
					CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
					cuentabancopunven.setid_banco(banco.getId());
					CuentaBancoPunVenDataAccess.save(cuentabancopunven,connexion);
					cuentabancopunvenLogic.deepSave(cuentabancopunven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticasCliente politicascliente:banco.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicascliente.setid_banco(banco.getId());
					PoliticasClienteDataAccess.save(politicascliente,connexion);
					politicasclienteLogic.deepSave(politicascliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:banco.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventa.setid_banco(banco.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
					formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaBanco cuentabanco:banco.getCuentaBancos()) {
					CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
					cuentabanco.setid_banco(banco.getId());
					CuentaBancoDataAccess.save(cuentabanco,connexion);
					cuentabancoLogic.deepSave(cuentabanco,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoCuentaBancoGeneral tipocuentabancogeneral:banco.getTipoCuentaBancoGenerals()) {
					TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
					tipocuentabancogeneral.setid_banco(banco.getId());
					TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
					tipocuentabancogeneralLogic.deepSave(tipocuentabancogeneral,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Banco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(banco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(banco);
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
			this.deepLoad(this.banco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.banco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Banco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(bancos!=null) {
				for(Banco banco:bancos) {
					this.deepLoad(banco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(bancos);
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
			if(bancos!=null) {
				for(Banco banco:bancos) {
					this.deepLoad(banco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(bancos);
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
			this.getNewConnexionToDeep(Banco.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(banco,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Banco.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(bancos!=null) {
				for(Banco banco:bancos) {
					this.deepSave(banco,isDeep,deepLoadType,clases);
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
			if(bancos!=null) {
				for(Banco banco:bancos) {
					this.deepSave(banco,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBancosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",BancoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",BancoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosBusquedaPorCodigoInstitucionWithConnection(String sFinalQuery,Pagination pagination,String codigo_institucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigoInstitucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigoInstitucion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo_institucion+"%",BancoConstantesFunciones.CODIGOINSTITUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigoInstitucion);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigoInstitucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosBusquedaPorCodigoInstitucion(String sFinalQuery,Pagination pagination,String codigo_institucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigoInstitucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigoInstitucion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo_institucion+"%",BancoConstantesFunciones.CODIGOINSTITUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigoInstitucion);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigoInstitucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",BancoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",BancoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,BancoConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,BancoConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,BancoConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,BancoConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosFK_IdFormato1WithConnection(String sFinalQuery,Pagination pagination,Long id_formato1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato1,BancoConstantesFunciones.IDFORMATO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato1);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosFK_IdFormato1(String sFinalQuery,Pagination pagination,Long id_formato1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato1,BancoConstantesFunciones.IDFORMATO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato1);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosFK_IdFormato2WithConnection(String sFinalQuery,Pagination pagination,Long id_formato2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato2,BancoConstantesFunciones.IDFORMATO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato2);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosFK_IdFormato2(String sFinalQuery,Pagination pagination,Long id_formato2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato2,BancoConstantesFunciones.IDFORMATO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato2);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BancoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BancoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancosFK_IdTipoBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Banco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_banco,BancoConstantesFunciones.IDTIPOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoBanco);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancosFK_IdTipoBanco(String sFinalQuery,Pagination pagination,Long id_tipo_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_banco,BancoConstantesFunciones.IDTIPOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoBanco);

			BancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancos=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoConstantesFunciones.refrescarForeignKeysDescripcionesBanco(this.bancos);
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
			if(BancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Banco banco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BancoConstantesFunciones.ISCONAUDITORIA) {
				if(banco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoDataAccess.TABLENAME, banco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BancoLogic.registrarAuditoriaDetallesBanco(connexion,banco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(banco.getIsDeleted()) {
					/*if(!banco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BancoDataAccess.TABLENAME, banco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BancoLogic.registrarAuditoriaDetallesBanco(connexion,banco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoDataAccess.TABLENAME, banco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(banco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoDataAccess.TABLENAME, banco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BancoLogic.registrarAuditoriaDetallesBanco(connexion,banco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBanco(Connexion connexion,Banco banco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(banco.getIsNew()||!banco.getid_empresa().equals(banco.getBancoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getid_empresa()!=null)
				{
					strValorActual=banco.getBancoOriginal().getid_empresa().toString();
				}
				if(banco.getid_empresa()!=null)
				{
					strValorNuevo=banco.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getid_sucursal().equals(banco.getBancoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getid_sucursal()!=null)
				{
					strValorActual=banco.getBancoOriginal().getid_sucursal().toString();
				}
				if(banco.getid_sucursal()!=null)
				{
					strValorNuevo=banco.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getcodigo().equals(banco.getBancoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getcodigo()!=null)
				{
					strValorActual=banco.getBancoOriginal().getcodigo();
				}
				if(banco.getcodigo()!=null)
				{
					strValorNuevo=banco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getcodigo_institucion().equals(banco.getBancoOriginal().getcodigo_institucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getcodigo_institucion()!=null)
				{
					strValorActual=banco.getBancoOriginal().getcodigo_institucion();
				}
				if(banco.getcodigo_institucion()!=null)
				{
					strValorNuevo=banco.getcodigo_institucion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.CODIGOINSTITUCION,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getnombre().equals(banco.getBancoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getnombre()!=null)
				{
					strValorActual=banco.getBancoOriginal().getnombre();
				}
				if(banco.getnombre()!=null)
				{
					strValorNuevo=banco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getid_tipo_banco().equals(banco.getBancoOriginal().getid_tipo_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getid_tipo_banco()!=null)
				{
					strValorActual=banco.getBancoOriginal().getid_tipo_banco().toString();
				}
				if(banco.getid_tipo_banco()!=null)
				{
					strValorNuevo=banco.getid_tipo_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.IDTIPOBANCO,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getdias_efectivo_local().equals(banco.getBancoOriginal().getdias_efectivo_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getdias_efectivo_local()!=null)
				{
					strValorActual=banco.getBancoOriginal().getdias_efectivo_local().toString();
				}
				if(banco.getdias_efectivo_local()!=null)
				{
					strValorNuevo=banco.getdias_efectivo_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.DIASEFECTIVOLOCAL,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getdias_efectivo_extranjero().equals(banco.getBancoOriginal().getdias_efectivo_extranjero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getdias_efectivo_extranjero()!=null)
				{
					strValorActual=banco.getBancoOriginal().getdias_efectivo_extranjero().toString();
				}
				if(banco.getdias_efectivo_extranjero()!=null)
				{
					strValorNuevo=banco.getdias_efectivo_extranjero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.DIASEFECTIVOEXTRANJERO,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getid_cuenta_contable_debito().equals(banco.getBancoOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=banco.getBancoOriginal().getid_cuenta_contable_debito().toString();
				}
				if(banco.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=banco.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getid_cuenta_contable_credito().equals(banco.getBancoOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=banco.getBancoOriginal().getid_cuenta_contable_credito().toString();
				}
				if(banco.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=banco.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getdelimitador().equals(banco.getBancoOriginal().getdelimitador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getdelimitador()!=null)
				{
					strValorActual=banco.getBancoOriginal().getdelimitador();
				}
				if(banco.getdelimitador()!=null)
				{
					strValorNuevo=banco.getdelimitador() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.DELIMITADOR,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getid_formato1().equals(banco.getBancoOriginal().getid_formato1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getid_formato1()!=null)
				{
					strValorActual=banco.getBancoOriginal().getid_formato1().toString();
				}
				if(banco.getid_formato1()!=null)
				{
					strValorNuevo=banco.getid_formato1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.IDFORMATO1,strValorActual,strValorNuevo);
			}	
			
			if(banco.getIsNew()||!banco.getid_formato2().equals(banco.getBancoOriginal().getid_formato2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(banco.getBancoOriginal().getid_formato2()!=null)
				{
					strValorActual=banco.getBancoOriginal().getid_formato2().toString();
				}
				if(banco.getid_formato2()!=null)
				{
					strValorNuevo=banco.getid_formato2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoConstantesFunciones.IDFORMATO2,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBancoRelacionesWithConnection(Banco banco,List<AutoriPago> autoripagos,List<TarjetaCredito> tarjetacreditos,List<CuentaBancoPunVen> cuentabancopunvens,List<PoliticasCliente> politicasclientes,List<FormaPagoPuntoVenta> formapagopuntoventas,List<CuentaBanco> cuentabancos,List<TipoCuentaBancoGeneral> tipocuentabancogenerals) throws Exception {

		if(!banco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBancoRelacionesBase(banco,autoripagos,tarjetacreditos,cuentabancopunvens,politicasclientes,formapagopuntoventas,cuentabancos,tipocuentabancogenerals,true);
		}
	}

	public void saveBancoRelaciones(Banco banco,List<AutoriPago> autoripagos,List<TarjetaCredito> tarjetacreditos,List<CuentaBancoPunVen> cuentabancopunvens,List<PoliticasCliente> politicasclientes,List<FormaPagoPuntoVenta> formapagopuntoventas,List<CuentaBanco> cuentabancos,List<TipoCuentaBancoGeneral> tipocuentabancogenerals)throws Exception {

		if(!banco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBancoRelacionesBase(banco,autoripagos,tarjetacreditos,cuentabancopunvens,politicasclientes,formapagopuntoventas,cuentabancos,tipocuentabancogenerals,false);
		}
	}

	public void saveBancoRelacionesBase(Banco banco,List<AutoriPago> autoripagos,List<TarjetaCredito> tarjetacreditos,List<CuentaBancoPunVen> cuentabancopunvens,List<PoliticasCliente> politicasclientes,List<FormaPagoPuntoVenta> formapagopuntoventas,List<CuentaBanco> cuentabancos,List<TipoCuentaBancoGeneral> tipocuentabancogenerals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Banco-saveRelacionesWithConnection");}
	
			banco.setAutoriPagos(autoripagos);
			banco.setTarjetaCreditos(tarjetacreditos);
			banco.setCuentaBancoPunVens(cuentabancopunvens);
			banco.setPoliticasClientes(politicasclientes);
			banco.setFormaPagoPuntoVentas(formapagopuntoventas);
			banco.setCuentaBancos(cuentabancos);
			banco.setTipoCuentaBancoGenerals(tipocuentabancogenerals);

			this.setBanco(banco);

			if(BancoLogicAdditional.validarSaveRelaciones(banco,this)) {

				BancoLogicAdditional.updateRelacionesToSave(banco,this);

				if((banco.getIsNew()||banco.getIsChanged())&&!banco.getIsDeleted()) {
					this.saveBanco();
					this.saveBancoRelacionesDetalles(autoripagos,tarjetacreditos,cuentabancopunvens,politicasclientes,formapagopuntoventas,cuentabancos,tipocuentabancogenerals);

				} else if(banco.getIsDeleted()) {
					this.saveBancoRelacionesDetalles(autoripagos,tarjetacreditos,cuentabancopunvens,politicasclientes,formapagopuntoventas,cuentabancos,tipocuentabancogenerals);
					this.saveBanco();
				}

				BancoLogicAdditional.updateRelacionesToSaveAfter(banco,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			AutoriPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresAutoriPagos(autoripagos,true,true);
			TarjetaCreditoConstantesFunciones.InicializarGeneralEntityAuxiliaresTarjetaCreditos(tarjetacreditos,true,true);
			CuentaBancoPunVenConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaBancoPunVens(cuentabancopunvens,true,true);
			PoliticasClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresPoliticasClientes(politicasclientes,true,true);
			FormaPagoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoPuntoVentas(formapagopuntoventas,true,true);
			CuentaBancoConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaBancos(cuentabancos,true,true);
			TipoCuentaBancoGeneralConstantesFunciones.InicializarGeneralEntityAuxiliaresTipoCuentaBancoGenerals(tipocuentabancogenerals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveBancoRelacionesDetalles(List<AutoriPago> autoripagos,List<TarjetaCredito> tarjetacreditos,List<CuentaBancoPunVen> cuentabancopunvens,List<PoliticasCliente> politicasclientes,List<FormaPagoPuntoVenta> formapagopuntoventas,List<CuentaBanco> cuentabancos,List<TipoCuentaBancoGeneral> tipocuentabancogenerals)throws Exception {
		try {
	

			Long idBancoActual=this.getBanco().getId();

			AutoriPagoLogic autoripagoLogic_Desde_Banco=new AutoriPagoLogic();
			autoripagoLogic_Desde_Banco.setAutoriPagos(autoripagos);

			autoripagoLogic_Desde_Banco.setConnexion(this.getConnexion());
			autoripagoLogic_Desde_Banco.setDatosCliente(this.datosCliente);

			for(AutoriPago autoripago_Desde_Banco:autoripagoLogic_Desde_Banco.getAutoriPagos()) {
				autoripago_Desde_Banco.setid_banco(idBancoActual);
			}

			autoripagoLogic_Desde_Banco.saveAutoriPagos();

			TarjetaCreditoLogic tarjetacreditoLogic_Desde_Banco=new TarjetaCreditoLogic();
			tarjetacreditoLogic_Desde_Banco.setTarjetaCreditos(tarjetacreditos);

			tarjetacreditoLogic_Desde_Banco.setConnexion(this.getConnexion());
			tarjetacreditoLogic_Desde_Banco.setDatosCliente(this.datosCliente);

			for(TarjetaCredito tarjetacredito_Desde_Banco:tarjetacreditoLogic_Desde_Banco.getTarjetaCreditos()) {
				tarjetacredito_Desde_Banco.setid_banco(idBancoActual);

				tarjetacreditoLogic_Desde_Banco.setTarjetaCredito(tarjetacredito_Desde_Banco);
				tarjetacreditoLogic_Desde_Banco.saveTarjetaCredito();

				Long idTarjetaCreditoActual=tarjetacredito_Desde_Banco.getId();

				TarjetaCreditoConexionLogic tarjetacreditoconexionLogic_Desde_TarjetaCredito=new TarjetaCreditoConexionLogic();

				if(tarjetacredito_Desde_Banco.getTarjetaCreditoConexions()==null){
					tarjetacredito_Desde_Banco.setTarjetaCreditoConexions(new ArrayList<TarjetaCreditoConexion>());
				}

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setTarjetaCreditoConexions(tarjetacredito_Desde_Banco.getTarjetaCreditoConexions());

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(TarjetaCreditoConexion tarjetacreditoconexion_Desde_TarjetaCredito:tarjetacreditoconexionLogic_Desde_TarjetaCredito.getTarjetaCreditoConexions()) {
					tarjetacreditoconexion_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.saveTarjetaCreditoConexions();

				TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic_Desde_TarjetaCredito=new TarjetaCreditoDescuentoLogic();

				if(tarjetacredito_Desde_Banco.getTarjetaCreditoDescuentos()==null){
					tarjetacredito_Desde_Banco.setTarjetaCreditoDescuentos(new ArrayList<TarjetaCreditoDescuento>());
				}

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setTarjetaCreditoDescuentos(tarjetacredito_Desde_Banco.getTarjetaCreditoDescuentos());

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(TarjetaCreditoDescuento tarjetacreditodescuento_Desde_TarjetaCredito:tarjetacreditodescuentoLogic_Desde_TarjetaCredito.getTarjetaCreditoDescuentos()) {
					tarjetacreditodescuento_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.saveTarjetaCreditoDescuentos();

				FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_TarjetaCredito=new FormaPagoPuntoVentaLogic();

				if(tarjetacredito_Desde_Banco.getFormaPagoPuntoVentas()==null){
					tarjetacredito_Desde_Banco.setFormaPagoPuntoVentas(new ArrayList<FormaPagoPuntoVenta>());
				}

				formapagopuntoventaLogic_Desde_TarjetaCredito.setFormaPagoPuntoVentas(tarjetacredito_Desde_Banco.getFormaPagoPuntoVentas());

				formapagopuntoventaLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				formapagopuntoventaLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(FormaPagoPuntoVenta formapagopuntoventa_Desde_TarjetaCredito:formapagopuntoventaLogic_Desde_TarjetaCredito.getFormaPagoPuntoVentas()) {
					formapagopuntoventa_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				formapagopuntoventaLogic_Desde_TarjetaCredito.saveFormaPagoPuntoVentas();
			}


			CuentaBancoPunVenLogic cuentabancopunvenLogic_Desde_Banco=new CuentaBancoPunVenLogic();
			cuentabancopunvenLogic_Desde_Banco.setCuentaBancoPunVens(cuentabancopunvens);

			cuentabancopunvenLogic_Desde_Banco.setConnexion(this.getConnexion());
			cuentabancopunvenLogic_Desde_Banco.setDatosCliente(this.datosCliente);

			for(CuentaBancoPunVen cuentabancopunven_Desde_Banco:cuentabancopunvenLogic_Desde_Banco.getCuentaBancoPunVens()) {
				cuentabancopunven_Desde_Banco.setid_banco(idBancoActual);

				cuentabancopunvenLogic_Desde_Banco.setCuentaBancoPunVen(cuentabancopunven_Desde_Banco);
				cuentabancopunvenLogic_Desde_Banco.saveCuentaBancoPunVen();

				Long idCuentaBancoPunVenActual=cuentabancopunven_Desde_Banco.getId();

				FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_CuentaBancoPunVen=new FormaPagoPuntoVentaLogic();

				if(cuentabancopunven_Desde_Banco.getFormaPagoPuntoVentas()==null){
					cuentabancopunven_Desde_Banco.setFormaPagoPuntoVentas(new ArrayList<FormaPagoPuntoVenta>());
				}

				formapagopuntoventaLogic_Desde_CuentaBancoPunVen.setFormaPagoPuntoVentas(cuentabancopunven_Desde_Banco.getFormaPagoPuntoVentas());

				formapagopuntoventaLogic_Desde_CuentaBancoPunVen.setConnexion(this.getConnexion());
				formapagopuntoventaLogic_Desde_CuentaBancoPunVen.setDatosCliente(this.datosCliente);

				for(FormaPagoPuntoVenta formapagopuntoventa_Desde_CuentaBancoPunVen:formapagopuntoventaLogic_Desde_CuentaBancoPunVen.getFormaPagoPuntoVentas()) {
					formapagopuntoventa_Desde_CuentaBancoPunVen.setid_cuenta_banco_pun_ven(idCuentaBancoPunVenActual);
				}

				formapagopuntoventaLogic_Desde_CuentaBancoPunVen.saveFormaPagoPuntoVentas();
			}


			PoliticasClienteLogic politicasclienteLogic_Desde_Banco=new PoliticasClienteLogic();
			politicasclienteLogic_Desde_Banco.setPoliticasClientes(politicasclientes);

			politicasclienteLogic_Desde_Banco.setConnexion(this.getConnexion());
			politicasclienteLogic_Desde_Banco.setDatosCliente(this.datosCliente);

			for(PoliticasCliente politicascliente_Desde_Banco:politicasclienteLogic_Desde_Banco.getPoliticasClientes()) {
				politicascliente_Desde_Banco.setid_banco(idBancoActual);
			}

			politicasclienteLogic_Desde_Banco.savePoliticasClientes();

			FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_Banco=new FormaPagoPuntoVentaLogic();
			formapagopuntoventaLogic_Desde_Banco.setFormaPagoPuntoVentas(formapagopuntoventas);

			formapagopuntoventaLogic_Desde_Banco.setConnexion(this.getConnexion());
			formapagopuntoventaLogic_Desde_Banco.setDatosCliente(this.datosCliente);

			for(FormaPagoPuntoVenta formapagopuntoventa_Desde_Banco:formapagopuntoventaLogic_Desde_Banco.getFormaPagoPuntoVentas()) {
				formapagopuntoventa_Desde_Banco.setid_banco(idBancoActual);
			}

			formapagopuntoventaLogic_Desde_Banco.saveFormaPagoPuntoVentas();

			CuentaBancoLogic cuentabancoLogic_Desde_Banco=new CuentaBancoLogic();
			cuentabancoLogic_Desde_Banco.setCuentaBancos(cuentabancos);

			cuentabancoLogic_Desde_Banco.setConnexion(this.getConnexion());
			cuentabancoLogic_Desde_Banco.setDatosCliente(this.datosCliente);

			for(CuentaBanco cuentabanco_Desde_Banco:cuentabancoLogic_Desde_Banco.getCuentaBancos()) {
				cuentabanco_Desde_Banco.setid_banco(idBancoActual);

				cuentabancoLogic_Desde_Banco.setCuentaBanco(cuentabanco_Desde_Banco);
				cuentabancoLogic_Desde_Banco.saveCuentaBanco();

				Long idCuentaBancoActual=cuentabanco_Desde_Banco.getId();

				PagoAutoLogic pagoautoLogic_Desde_CuentaBanco=new PagoAutoLogic();

				if(cuentabanco_Desde_Banco.getPagoAutos()==null){
					cuentabanco_Desde_Banco.setPagoAutos(new ArrayList<PagoAuto>());
				}

				pagoautoLogic_Desde_CuentaBanco.setPagoAutos(cuentabanco_Desde_Banco.getPagoAutos());

				pagoautoLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
				pagoautoLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

				for(PagoAuto pagoauto_Desde_CuentaBanco:pagoautoLogic_Desde_CuentaBanco.getPagoAutos()) {
					pagoauto_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
				}

				pagoautoLogic_Desde_CuentaBanco.savePagoAutos();

				AutoriPagoOrdenCompraLogic autoripagoordencompraLogic_Desde_CuentaBanco=new AutoriPagoOrdenCompraLogic();

				if(cuentabanco_Desde_Banco.getAutoriPagoOrdenCompras()==null){
					cuentabanco_Desde_Banco.setAutoriPagoOrdenCompras(new ArrayList<AutoriPagoOrdenCompra>());
				}

				autoripagoordencompraLogic_Desde_CuentaBanco.setAutoriPagoOrdenCompras(cuentabanco_Desde_Banco.getAutoriPagoOrdenCompras());

				autoripagoordencompraLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
				autoripagoordencompraLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

				for(AutoriPagoOrdenCompra autoripagoordencompra_Desde_CuentaBanco:autoripagoordencompraLogic_Desde_CuentaBanco.getAutoriPagoOrdenCompras()) {
					autoripagoordencompra_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
				}

				autoripagoordencompraLogic_Desde_CuentaBanco.saveAutoriPagoOrdenCompras();

				DetalleChequeGiradoLogic detallechequegiradoLogic_Desde_CuentaBanco=new DetalleChequeGiradoLogic();

				if(cuentabanco_Desde_Banco.getDetalleChequeGirados()==null){
					cuentabanco_Desde_Banco.setDetalleChequeGirados(new ArrayList<DetalleChequeGirado>());
				}

				detallechequegiradoLogic_Desde_CuentaBanco.setDetalleChequeGirados(cuentabanco_Desde_Banco.getDetalleChequeGirados());

				detallechequegiradoLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
				detallechequegiradoLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

				for(DetalleChequeGirado detallechequegirado_Desde_CuentaBanco:detallechequegiradoLogic_Desde_CuentaBanco.getDetalleChequeGirados()) {
					detallechequegirado_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
				}

				detallechequegiradoLogic_Desde_CuentaBanco.saveDetalleChequeGirados();

				AutoriPagoLogic autoripagoLogic_Desde_CuentaBanco=new AutoriPagoLogic();

				if(cuentabanco_Desde_Banco.getAutoriPagos()==null){
					cuentabanco_Desde_Banco.setAutoriPagos(new ArrayList<AutoriPago>());
				}

				autoripagoLogic_Desde_CuentaBanco.setAutoriPagos(cuentabanco_Desde_Banco.getAutoriPagos());

				autoripagoLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
				autoripagoLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

				for(AutoriPago autoripago_Desde_CuentaBanco:autoripagoLogic_Desde_CuentaBanco.getAutoriPagos()) {
					autoripago_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
				}

				autoripagoLogic_Desde_CuentaBanco.saveAutoriPagos();
			}


			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic_Desde_Banco=new TipoCuentaBancoGeneralLogic();
			tipocuentabancogeneralLogic_Desde_Banco.setTipoCuentaBancoGenerals(tipocuentabancogenerals);

			tipocuentabancogeneralLogic_Desde_Banco.setConnexion(this.getConnexion());
			tipocuentabancogeneralLogic_Desde_Banco.setDatosCliente(this.datosCliente);

			for(TipoCuentaBancoGeneral tipocuentabancogeneral_Desde_Banco:tipocuentabancogeneralLogic_Desde_Banco.getTipoCuentaBancoGenerals()) {
				tipocuentabancogeneral_Desde_Banco.setid_banco(idBancoActual);
			}

			tipocuentabancogeneralLogic_Desde_Banco.saveTipoCuentaBancoGenerals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BancoConstantesFunciones.getClassesForeignKeysOfBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BancoConstantesFunciones.getClassesRelationshipsOfBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
