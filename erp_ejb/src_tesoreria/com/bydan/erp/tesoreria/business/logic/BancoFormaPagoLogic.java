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
import com.bydan.erp.tesoreria.util.BancoFormaPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.BancoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.BancoFormaPagoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.BancoFormaPago;
import com.bydan.erp.tesoreria.business.logic.BancoFormaPagoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class BancoFormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BancoFormaPagoLogic.class);
	
	protected BancoFormaPagoDataAccess bancoformapagoDataAccess; 	
	protected BancoFormaPago bancoformapago;
	protected List<BancoFormaPago> bancoformapagos;
	protected Object bancoformapagoObject;	
	protected List<Object> bancoformapagosObject;
	
	public static ClassValidator<BancoFormaPago> bancoformapagoValidator = new ClassValidator<BancoFormaPago>(BancoFormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BancoFormaPagoLogicAdditional bancoformapagoLogicAdditional=null;
	
	public BancoFormaPagoLogicAdditional getBancoFormaPagoLogicAdditional() {
		return this.bancoformapagoLogicAdditional;
	}
	
	public void setBancoFormaPagoLogicAdditional(BancoFormaPagoLogicAdditional bancoformapagoLogicAdditional) {
		try {
			this.bancoformapagoLogicAdditional=bancoformapagoLogicAdditional;
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
	
	
	
	
	public  BancoFormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.bancoformapagoDataAccess = new BancoFormaPagoDataAccess();
			
			this.bancoformapagos= new ArrayList<BancoFormaPago>();
			this.bancoformapago= new BancoFormaPago();
			
			this.bancoformapagoObject=new Object();
			this.bancoformapagosObject=new ArrayList<Object>();
				
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
			
			this.bancoformapagoDataAccess.setConnexionType(this.connexionType);
			this.bancoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BancoFormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.bancoformapagoDataAccess = new BancoFormaPagoDataAccess();
			this.bancoformapagos= new ArrayList<BancoFormaPago>();
			this.bancoformapago= new BancoFormaPago();
			this.bancoformapagoObject=new Object();
			this.bancoformapagosObject=new ArrayList<Object>();
			
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
			
			this.bancoformapagoDataAccess.setConnexionType(this.connexionType);
			this.bancoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BancoFormaPago getBancoFormaPago() throws Exception {	
		BancoFormaPagoLogicAdditional.checkBancoFormaPagoToGet(bancoformapago,this.datosCliente,this.arrDatoGeneral);
		BancoFormaPagoLogicAdditional.updateBancoFormaPagoToGet(bancoformapago,this.arrDatoGeneral);
		
		return bancoformapago;
	}
		
	public void setBancoFormaPago(BancoFormaPago newBancoFormaPago) {
		this.bancoformapago = newBancoFormaPago;
	}
	
	public BancoFormaPagoDataAccess getBancoFormaPagoDataAccess() {
		return bancoformapagoDataAccess;
	}
	
	public void setBancoFormaPagoDataAccess(BancoFormaPagoDataAccess newbancoformapagoDataAccess) {
		this.bancoformapagoDataAccess = newbancoformapagoDataAccess;
	}
	
	public List<BancoFormaPago> getBancoFormaPagos() throws Exception {		
		this.quitarBancoFormaPagosNulos();
		
		BancoFormaPagoLogicAdditional.checkBancoFormaPagoToGets(bancoformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (BancoFormaPago bancoformapagoLocal: bancoformapagos ) {
			BancoFormaPagoLogicAdditional.updateBancoFormaPagoToGet(bancoformapagoLocal,this.arrDatoGeneral);
		}
		
		return bancoformapagos;
	}
	
	public void setBancoFormaPagos(List<BancoFormaPago> newBancoFormaPagos) {
		this.bancoformapagos = newBancoFormaPagos;
	}
	
	public Object getBancoFormaPagoObject() {	
		this.bancoformapagoObject=this.bancoformapagoDataAccess.getEntityObject();
		return this.bancoformapagoObject;
	}
		
	public void setBancoFormaPagoObject(Object newBancoFormaPagoObject) {
		this.bancoformapagoObject = newBancoFormaPagoObject;
	}
	
	public List<Object> getBancoFormaPagosObject() {		
		this.bancoformapagosObject=this.bancoformapagoDataAccess.getEntitiesObject();
		return this.bancoformapagosObject;
	}
		
	public void setBancoFormaPagosObject(List<Object> newBancoFormaPagosObject) {
		this.bancoformapagosObject = newBancoFormaPagosObject;
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
		
		if(this.bancoformapagoDataAccess!=null) {
			this.bancoformapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			bancoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			bancoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		bancoformapago = new  BancoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bancoformapago=bancoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapago);
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
		bancoformapago = new  BancoFormaPago();
		  		  
        try {
			
			bancoformapago=bancoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		bancoformapago = new  BancoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bancoformapago=bancoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapago);
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
		bancoformapago = new  BancoFormaPago();
		  		  
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
		bancoformapago = new  BancoFormaPago();
		  		  
        try {
			
			bancoformapago=bancoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		bancoformapago = new  BancoFormaPago();
		  		  
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
		bancoformapago = new  BancoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =bancoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bancoformapago = new  BancoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=bancoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bancoformapago = new  BancoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =bancoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bancoformapago = new  BancoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=bancoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bancoformapago = new  BancoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =bancoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bancoformapago = new  BancoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=bancoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
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
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
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
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
        try {			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
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
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
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
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
        try {
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
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
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
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
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		bancoformapago = new  BancoFormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapago=bancoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapago);
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
		bancoformapago = new  BancoFormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapago=bancoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
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
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		  		  
        try {
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBancoFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getTodosBancoFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
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
	
	public  void  getTodosBancoFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		bancoformapagos = new  ArrayList<BancoFormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBancoFormaPago(bancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBancoFormaPago(BancoFormaPago bancoformapago) throws Exception {
		Boolean estaValidado=false;
		
		if(bancoformapago.getIsNew() || bancoformapago.getIsChanged()) { 
			this.invalidValues = bancoformapagoValidator.getInvalidValues(bancoformapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(bancoformapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBancoFormaPago(List<BancoFormaPago> BancoFormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(BancoFormaPago bancoformapagoLocal:bancoformapagos) {				
			estaValidadoObjeto=this.validarGuardarBancoFormaPago(bancoformapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBancoFormaPago(List<BancoFormaPago> BancoFormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBancoFormaPago(bancoformapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBancoFormaPago(BancoFormaPago BancoFormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBancoFormaPago(bancoformapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(BancoFormaPago bancoformapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+bancoformapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BancoFormaPagoConstantesFunciones.getBancoFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"bancoformapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BancoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BancoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBancoFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-saveBancoFormaPagoWithConnection");connexion.begin();			
			
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSave(this.bancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BancoFormaPagoLogicAdditional.updateBancoFormaPagoToSave(this.bancoformapago,this.arrDatoGeneral);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bancoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBancoFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBancoFormaPago(this.bancoformapago)) {
				BancoFormaPagoDataAccess.save(this.bancoformapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.bancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSaveAfter(this.bancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBancoFormaPago();
			
			connexion.commit();			
			
			if(this.bancoformapago.getIsDeleted()) {
				this.bancoformapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBancoFormaPago()throws Exception {	
		try {	
			
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSave(this.bancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BancoFormaPagoLogicAdditional.updateBancoFormaPagoToSave(this.bancoformapago,this.arrDatoGeneral);
			
			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bancoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBancoFormaPago(this.bancoformapago)) {			
				BancoFormaPagoDataAccess.save(this.bancoformapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.bancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSaveAfter(this.bancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.bancoformapago.getIsDeleted()) {
				this.bancoformapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBancoFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-saveBancoFormaPagosWithConnection");connexion.begin();			
			
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSaves(bancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBancoFormaPagos();
			
			Boolean validadoTodosBancoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BancoFormaPago bancoformapagoLocal:bancoformapagos) {		
				if(bancoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BancoFormaPagoLogicAdditional.updateBancoFormaPagoToSave(bancoformapagoLocal,this.arrDatoGeneral);
	        	
				BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bancoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBancoFormaPago(bancoformapagoLocal)) {
					BancoFormaPagoDataAccess.save(bancoformapagoLocal, connexion);				
				} else {
					validadoTodosBancoFormaPago=false;
				}
			}
			
			if(!validadoTodosBancoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSavesAfter(bancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBancoFormaPagos();
			
			connexion.commit();		
			
			this.quitarBancoFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBancoFormaPagos()throws Exception {				
		 try {	
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSaves(bancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBancoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BancoFormaPago bancoformapagoLocal:bancoformapagos) {				
				if(bancoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BancoFormaPagoLogicAdditional.updateBancoFormaPagoToSave(bancoformapagoLocal,this.arrDatoGeneral);
	        	
				BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bancoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBancoFormaPago(bancoformapagoLocal)) {				
					BancoFormaPagoDataAccess.save(bancoformapagoLocal, connexion);				
				} else {
					validadoTodosBancoFormaPago=false;
				}
			}
			
			if(!validadoTodosBancoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BancoFormaPagoLogicAdditional.checkBancoFormaPagoToSavesAfter(bancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBancoFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BancoFormaPagoParameterReturnGeneral procesarAccionBancoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BancoFormaPago> bancoformapagos,BancoFormaPagoParameterReturnGeneral bancoformapagoParameterGeneral)throws Exception {
		 try {	
			BancoFormaPagoParameterReturnGeneral bancoformapagoReturnGeneral=new BancoFormaPagoParameterReturnGeneral();
	
			BancoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bancoformapagos,bancoformapagoParameterGeneral,bancoformapagoReturnGeneral);
			
			return bancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BancoFormaPagoParameterReturnGeneral procesarAccionBancoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BancoFormaPago> bancoformapagos,BancoFormaPagoParameterReturnGeneral bancoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-procesarAccionBancoFormaPagosWithConnection");connexion.begin();			
			
			BancoFormaPagoParameterReturnGeneral bancoformapagoReturnGeneral=new BancoFormaPagoParameterReturnGeneral();
	
			BancoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bancoformapagos,bancoformapagoParameterGeneral,bancoformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return bancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BancoFormaPagoParameterReturnGeneral procesarEventosBancoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BancoFormaPago> bancoformapagos,BancoFormaPago bancoformapago,BancoFormaPagoParameterReturnGeneral bancoformapagoParameterGeneral,Boolean isEsNuevoBancoFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			BancoFormaPagoParameterReturnGeneral bancoformapagoReturnGeneral=new BancoFormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bancoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BancoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bancoformapagos,bancoformapago,bancoformapagoParameterGeneral,bancoformapagoReturnGeneral,isEsNuevoBancoFormaPago,clases);
			
			return bancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BancoFormaPagoParameterReturnGeneral procesarEventosBancoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BancoFormaPago> bancoformapagos,BancoFormaPago bancoformapago,BancoFormaPagoParameterReturnGeneral bancoformapagoParameterGeneral,Boolean isEsNuevoBancoFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-procesarEventosBancoFormaPagosWithConnection");connexion.begin();			
			
			BancoFormaPagoParameterReturnGeneral bancoformapagoReturnGeneral=new BancoFormaPagoParameterReturnGeneral();
	
			bancoformapagoReturnGeneral.setBancoFormaPago(bancoformapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bancoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BancoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bancoformapagos,bancoformapago,bancoformapagoParameterGeneral,bancoformapagoReturnGeneral,isEsNuevoBancoFormaPago,clases);
			
			this.connexion.commit();
			
			return bancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BancoFormaPagoParameterReturnGeneral procesarImportacionBancoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BancoFormaPagoParameterReturnGeneral bancoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-procesarImportacionBancoFormaPagosWithConnection");connexion.begin();			
			
			BancoFormaPagoParameterReturnGeneral bancoformapagoReturnGeneral=new BancoFormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.bancoformapagos=new ArrayList<BancoFormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.bancoformapago=new BancoFormaPago();
				
				
				if(conColumnasBase) {this.bancoformapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.bancoformapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.bancoformapago.setnombre_banco(arrColumnas[iColumn++]);
				this.bancoformapago.setnombre_girador(arrColumnas[iColumn++]);
				this.bancoformapago.setfecha_vence(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.bancoformapago.setnumero_cuenta_banco(arrColumnas[iColumn++]);
				this.bancoformapago.setnumero_cheque(arrColumnas[iColumn++]);
				this.bancoformapago.setvalor_monto(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.bancoformapagos.add(this.bancoformapago);
			}
			
			this.saveBancoFormaPagos();
			
			this.connexion.commit();
			
			bancoformapagoReturnGeneral.setConRetornoEstaProcesado(true);
			bancoformapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return bancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBancoFormaPagosEliminados() throws Exception {				
		
		List<BancoFormaPago> bancoformapagosAux= new ArrayList<BancoFormaPago>();
		
		for(BancoFormaPago bancoformapago:bancoformapagos) {
			if(!bancoformapago.getIsDeleted()) {
				bancoformapagosAux.add(bancoformapago);
			}
		}
		
		bancoformapagos=bancoformapagosAux;
	}
	
	public void quitarBancoFormaPagosNulos() throws Exception {				
		
		List<BancoFormaPago> bancoformapagosAux= new ArrayList<BancoFormaPago>();
		
		for(BancoFormaPago bancoformapago : this.bancoformapagos) {
			if(bancoformapago==null) {
				bancoformapagosAux.add(bancoformapago);
			}
		}
		
		//this.bancoformapagos=bancoformapagosAux;
		
		this.bancoformapagos.removeAll(bancoformapagosAux);
	}
	
	public void getSetVersionRowBancoFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(bancoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((bancoformapago.getIsDeleted() || (bancoformapago.getIsChanged()&&!bancoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=bancoformapagoDataAccess.getSetVersionRowBancoFormaPago(connexion,bancoformapago.getId());
				
				if(!bancoformapago.getVersionRow().equals(timestamp)) {	
					bancoformapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				bancoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBancoFormaPago()throws Exception {	
		
		if(bancoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((bancoformapago.getIsDeleted() || (bancoformapago.getIsChanged()&&!bancoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=bancoformapagoDataAccess.getSetVersionRowBancoFormaPago(connexion,bancoformapago.getId());
			
			try {							
				if(!bancoformapago.getVersionRow().equals(timestamp)) {	
					bancoformapago.setVersionRow(timestamp);
				}
				
				bancoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBancoFormaPagosWithConnection()throws Exception {	
		if(bancoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(BancoFormaPago bancoformapagoAux:bancoformapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(bancoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bancoformapagoAux.getIsDeleted() || (bancoformapagoAux.getIsChanged()&&!bancoformapagoAux.getIsNew())) {
						
						timestamp=bancoformapagoDataAccess.getSetVersionRowBancoFormaPago(connexion,bancoformapagoAux.getId());
						
						if(!bancoformapago.getVersionRow().equals(timestamp)) {	
							bancoformapagoAux.setVersionRow(timestamp);
						}
								
						bancoformapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBancoFormaPagos()throws Exception {	
		if(bancoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(BancoFormaPago bancoformapagoAux:bancoformapagos) {
					if(bancoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bancoformapagoAux.getIsDeleted() || (bancoformapagoAux.getIsChanged()&&!bancoformapagoAux.getIsNew())) {
						
						timestamp=bancoformapagoDataAccess.getSetVersionRowBancoFormaPago(connexion,bancoformapagoAux.getId());
						
						if(!bancoformapagoAux.getVersionRow().equals(timestamp)) {	
							bancoformapagoAux.setVersionRow(timestamp);
						}
						
													
						bancoformapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BancoFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyBancoFormaPagoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFactura,String finalQueryGlobalDetaFormaPago,String finalQueryGlobalTipoBancoFormaPago,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		BancoFormaPagoParameterReturnGeneral  bancoformapagoReturnGeneral =new BancoFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyBancoFormaPagoWithConnection");connexion.begin();
			
			bancoformapagoReturnGeneral =new BancoFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bancoformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bancoformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			bancoformapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			bancoformapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			bancoformapagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<DetaFormaPago> detaformapagosForeignKey=new ArrayList<DetaFormaPago>();
			DetaFormaPagoLogic detaformapagoLogic=new DetaFormaPagoLogic();
			detaformapagoLogic.setConnexion(this.connexion);
			detaformapagoLogic.getDetaFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetaFormaPago.equals("NONE")) {
				detaformapagoLogic.getTodosDetaFormaPagos(finalQueryGlobalDetaFormaPago,new Pagination());
				detaformapagosForeignKey=detaformapagoLogic.getDetaFormaPagos();
			}

			bancoformapagoReturnGeneral.setdetaformapagosForeignKey(detaformapagosForeignKey);


			List<TipoBancoFormaPago> tipobancoformapagosForeignKey=new ArrayList<TipoBancoFormaPago>();
			TipoBancoFormaPagoLogic tipobancoformapagoLogic=new TipoBancoFormaPagoLogic();
			tipobancoformapagoLogic.setConnexion(this.connexion);
			tipobancoformapagoLogic.getTipoBancoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoBancoFormaPago.equals("NONE")) {
				tipobancoformapagoLogic.getTodosTipoBancoFormaPagos(finalQueryGlobalTipoBancoFormaPago,new Pagination());
				tipobancoformapagosForeignKey=tipobancoformapagoLogic.getTipoBancoFormaPagos();
			}

			bancoformapagoReturnGeneral.settipobancoformapagosForeignKey(tipobancoformapagosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			bancoformapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			bancoformapagoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return bancoformapagoReturnGeneral;
	}
	
	public BancoFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyBancoFormaPago(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFactura,String finalQueryGlobalDetaFormaPago,String finalQueryGlobalTipoBancoFormaPago,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		BancoFormaPagoParameterReturnGeneral  bancoformapagoReturnGeneral =new BancoFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			bancoformapagoReturnGeneral =new BancoFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bancoformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			bancoformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			bancoformapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			bancoformapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			bancoformapagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<DetaFormaPago> detaformapagosForeignKey=new ArrayList<DetaFormaPago>();
			DetaFormaPagoLogic detaformapagoLogic=new DetaFormaPagoLogic();
			detaformapagoLogic.setConnexion(this.connexion);
			detaformapagoLogic.getDetaFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetaFormaPago.equals("NONE")) {
				detaformapagoLogic.getTodosDetaFormaPagos(finalQueryGlobalDetaFormaPago,new Pagination());
				detaformapagosForeignKey=detaformapagoLogic.getDetaFormaPagos();
			}

			bancoformapagoReturnGeneral.setdetaformapagosForeignKey(detaformapagosForeignKey);


			List<TipoBancoFormaPago> tipobancoformapagosForeignKey=new ArrayList<TipoBancoFormaPago>();
			TipoBancoFormaPagoLogic tipobancoformapagoLogic=new TipoBancoFormaPagoLogic();
			tipobancoformapagoLogic.setConnexion(this.connexion);
			tipobancoformapagoLogic.getTipoBancoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoBancoFormaPago.equals("NONE")) {
				tipobancoformapagoLogic.getTodosTipoBancoFormaPagos(finalQueryGlobalTipoBancoFormaPago,new Pagination());
				tipobancoformapagosForeignKey=tipobancoformapagoLogic.getTipoBancoFormaPagos();
			}

			bancoformapagoReturnGeneral.settipobancoformapagosForeignKey(tipobancoformapagosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			bancoformapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			bancoformapagoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return bancoformapagoReturnGeneral;
	}
	
	
	public void deepLoad(BancoFormaPago bancoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BancoFormaPagoLogicAdditional.updateBancoFormaPagoToGet(bancoformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bancoformapago.setEmpresa(bancoformapagoDataAccess.getEmpresa(connexion,bancoformapago));
		bancoformapago.setSucursal(bancoformapagoDataAccess.getSucursal(connexion,bancoformapago));
		bancoformapago.setEjercicio(bancoformapagoDataAccess.getEjercicio(connexion,bancoformapago));
		bancoformapago.setPeriodo(bancoformapagoDataAccess.getPeriodo(connexion,bancoformapago));
		bancoformapago.setFactura(bancoformapagoDataAccess.getFactura(connexion,bancoformapago));
		bancoformapago.setDetaFormaPago(bancoformapagoDataAccess.getDetaFormaPago(connexion,bancoformapago));
		bancoformapago.setTipoBancoFormaPago(bancoformapagoDataAccess.getTipoBancoFormaPago(connexion,bancoformapago));
		bancoformapago.setAnio(bancoformapagoDataAccess.getAnio(connexion,bancoformapago));
		bancoformapago.setMes(bancoformapagoDataAccess.getMes(connexion,bancoformapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bancoformapago.setEmpresa(bancoformapagoDataAccess.getEmpresa(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				bancoformapago.setSucursal(bancoformapagoDataAccess.getSucursal(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				bancoformapago.setEjercicio(bancoformapagoDataAccess.getEjercicio(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				bancoformapago.setPeriodo(bancoformapagoDataAccess.getPeriodo(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				bancoformapago.setFactura(bancoformapagoDataAccess.getFactura(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)) {
				bancoformapago.setDetaFormaPago(bancoformapagoDataAccess.getDetaFormaPago(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(TipoBancoFormaPago.class)) {
				bancoformapago.setTipoBancoFormaPago(bancoformapagoDataAccess.getTipoBancoFormaPago(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				bancoformapago.setAnio(bancoformapagoDataAccess.getAnio(connexion,bancoformapago));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				bancoformapago.setMes(bancoformapagoDataAccess.getMes(connexion,bancoformapago));
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
			bancoformapago.setEmpresa(bancoformapagoDataAccess.getEmpresa(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setSucursal(bancoformapagoDataAccess.getSucursal(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setEjercicio(bancoformapagoDataAccess.getEjercicio(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setPeriodo(bancoformapagoDataAccess.getPeriodo(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setFactura(bancoformapagoDataAccess.getFactura(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setDetaFormaPago(bancoformapagoDataAccess.getDetaFormaPago(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBancoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setTipoBancoFormaPago(bancoformapagoDataAccess.getTipoBancoFormaPago(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setAnio(bancoformapagoDataAccess.getAnio(connexion,bancoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setMes(bancoformapagoDataAccess.getMes(connexion,bancoformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bancoformapago.setEmpresa(bancoformapagoDataAccess.getEmpresa(connexion,bancoformapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bancoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		bancoformapago.setSucursal(bancoformapagoDataAccess.getSucursal(connexion,bancoformapago));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(bancoformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		bancoformapago.setEjercicio(bancoformapagoDataAccess.getEjercicio(connexion,bancoformapago));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(bancoformapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		bancoformapago.setPeriodo(bancoformapagoDataAccess.getPeriodo(connexion,bancoformapago));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(bancoformapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		bancoformapago.setFactura(bancoformapagoDataAccess.getFactura(connexion,bancoformapago));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(bancoformapago.getFactura(),isDeep,deepLoadType,clases);
				
		bancoformapago.setDetaFormaPago(bancoformapagoDataAccess.getDetaFormaPago(connexion,bancoformapago));
		DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
		detaformapagoLogic.deepLoad(bancoformapago.getDetaFormaPago(),isDeep,deepLoadType,clases);
				
		bancoformapago.setTipoBancoFormaPago(bancoformapagoDataAccess.getTipoBancoFormaPago(connexion,bancoformapago));
		TipoBancoFormaPagoLogic tipobancoformapagoLogic= new TipoBancoFormaPagoLogic(connexion);
		tipobancoformapagoLogic.deepLoad(bancoformapago.getTipoBancoFormaPago(),isDeep,deepLoadType,clases);
				
		bancoformapago.setAnio(bancoformapagoDataAccess.getAnio(connexion,bancoformapago));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(bancoformapago.getAnio(),isDeep,deepLoadType,clases);
				
		bancoformapago.setMes(bancoformapagoDataAccess.getMes(connexion,bancoformapago));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(bancoformapago.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bancoformapago.setEmpresa(bancoformapagoDataAccess.getEmpresa(connexion,bancoformapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(bancoformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				bancoformapago.setSucursal(bancoformapagoDataAccess.getSucursal(connexion,bancoformapago));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(bancoformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				bancoformapago.setEjercicio(bancoformapagoDataAccess.getEjercicio(connexion,bancoformapago));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(bancoformapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				bancoformapago.setPeriodo(bancoformapagoDataAccess.getPeriodo(connexion,bancoformapago));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(bancoformapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				bancoformapago.setFactura(bancoformapagoDataAccess.getFactura(connexion,bancoformapago));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(bancoformapago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)) {
				bancoformapago.setDetaFormaPago(bancoformapagoDataAccess.getDetaFormaPago(connexion,bancoformapago));
				DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
				detaformapagoLogic.deepLoad(bancoformapago.getDetaFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoBancoFormaPago.class)) {
				bancoformapago.setTipoBancoFormaPago(bancoformapagoDataAccess.getTipoBancoFormaPago(connexion,bancoformapago));
				TipoBancoFormaPagoLogic tipobancoformapagoLogic= new TipoBancoFormaPagoLogic(connexion);
				tipobancoformapagoLogic.deepLoad(bancoformapago.getTipoBancoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				bancoformapago.setAnio(bancoformapagoDataAccess.getAnio(connexion,bancoformapago));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(bancoformapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				bancoformapago.setMes(bancoformapagoDataAccess.getMes(connexion,bancoformapago));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(bancoformapago.getMes(),isDeep,deepLoadType,clases);				
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
			bancoformapago.setEmpresa(bancoformapagoDataAccess.getEmpresa(connexion,bancoformapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(bancoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setSucursal(bancoformapagoDataAccess.getSucursal(connexion,bancoformapago));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(bancoformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setEjercicio(bancoformapagoDataAccess.getEjercicio(connexion,bancoformapago));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(bancoformapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setPeriodo(bancoformapagoDataAccess.getPeriodo(connexion,bancoformapago));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(bancoformapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setFactura(bancoformapagoDataAccess.getFactura(connexion,bancoformapago));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(bancoformapago.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setDetaFormaPago(bancoformapagoDataAccess.getDetaFormaPago(connexion,bancoformapago));
			DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
			detaformapagoLogic.deepLoad(bancoformapago.getDetaFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBancoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setTipoBancoFormaPago(bancoformapagoDataAccess.getTipoBancoFormaPago(connexion,bancoformapago));
			TipoBancoFormaPagoLogic tipobancoformapagoLogic= new TipoBancoFormaPagoLogic(connexion);
			tipobancoformapagoLogic.deepLoad(bancoformapago.getTipoBancoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setAnio(bancoformapagoDataAccess.getAnio(connexion,bancoformapago));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(bancoformapago.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancoformapago.setMes(bancoformapagoDataAccess.getMes(connexion,bancoformapago));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(bancoformapago.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(BancoFormaPago bancoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BancoFormaPagoLogicAdditional.updateBancoFormaPagoToSave(bancoformapago,this.arrDatoGeneral);
			
BancoFormaPagoDataAccess.save(bancoformapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bancoformapago.getEmpresa(),connexion);

		SucursalDataAccess.save(bancoformapago.getSucursal(),connexion);

		EjercicioDataAccess.save(bancoformapago.getEjercicio(),connexion);

		PeriodoDataAccess.save(bancoformapago.getPeriodo(),connexion);

		FacturaDataAccess.save(bancoformapago.getFactura(),connexion);

		DetaFormaPagoDataAccess.save(bancoformapago.getDetaFormaPago(),connexion);

		TipoBancoFormaPagoDataAccess.save(bancoformapago.getTipoBancoFormaPago(),connexion);

		AnioDataAccess.save(bancoformapago.getAnio(),connexion);

		MesDataAccess.save(bancoformapago.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bancoformapago.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(bancoformapago.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(bancoformapago.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(bancoformapago.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(bancoformapago.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)) {
				DetaFormaPagoDataAccess.save(bancoformapago.getDetaFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoBancoFormaPago.class)) {
				TipoBancoFormaPagoDataAccess.save(bancoformapago.getTipoBancoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(bancoformapago.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(bancoformapago.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bancoformapago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bancoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(bancoformapago.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(bancoformapago.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(bancoformapago.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(bancoformapago.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(bancoformapago.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(bancoformapago.getPeriodo(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(bancoformapago.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(bancoformapago.getFactura(),isDeep,deepLoadType,clases);
				

		DetaFormaPagoDataAccess.save(bancoformapago.getDetaFormaPago(),connexion);
		DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
		detaformapagoLogic.deepLoad(bancoformapago.getDetaFormaPago(),isDeep,deepLoadType,clases);
				

		TipoBancoFormaPagoDataAccess.save(bancoformapago.getTipoBancoFormaPago(),connexion);
		TipoBancoFormaPagoLogic tipobancoformapagoLogic= new TipoBancoFormaPagoLogic(connexion);
		tipobancoformapagoLogic.deepLoad(bancoformapago.getTipoBancoFormaPago(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(bancoformapago.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(bancoformapago.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(bancoformapago.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(bancoformapago.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bancoformapago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(bancoformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(bancoformapago.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(bancoformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(bancoformapago.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(bancoformapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(bancoformapago.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(bancoformapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(bancoformapago.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(bancoformapago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)) {
				DetaFormaPagoDataAccess.save(bancoformapago.getDetaFormaPago(),connexion);
				DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
				detaformapagoLogic.deepSave(bancoformapago.getDetaFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoBancoFormaPago.class)) {
				TipoBancoFormaPagoDataAccess.save(bancoformapago.getTipoBancoFormaPago(),connexion);
				TipoBancoFormaPagoLogic tipobancoformapagoLogic= new TipoBancoFormaPagoLogic(connexion);
				tipobancoformapagoLogic.deepSave(bancoformapago.getTipoBancoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(bancoformapago.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(bancoformapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(bancoformapago.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(bancoformapago.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(BancoFormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(bancoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(bancoformapago);
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
			this.deepLoad(this.bancoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(BancoFormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(bancoformapagos!=null) {
				for(BancoFormaPago bancoformapago:bancoformapagos) {
					this.deepLoad(bancoformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(bancoformapagos);
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
			if(bancoformapagos!=null) {
				for(BancoFormaPago bancoformapago:bancoformapagos) {
					this.deepLoad(bancoformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(bancoformapagos);
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
			this.getNewConnexionToDeep(BancoFormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(bancoformapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(BancoFormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(bancoformapagos!=null) {
				for(BancoFormaPago bancoformapago:bancoformapagos) {
					this.deepSave(bancoformapago,isDeep,deepLoadType,clases);
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
			if(bancoformapagos!=null) {
				for(BancoFormaPago bancoformapago:bancoformapagos) {
					this.deepSave(bancoformapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBancoFormaPagosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,BancoFormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,BancoFormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdBancoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_banco_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoBancoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoBancoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_banco_forma_pago,BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoBancoFormaPago);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBancoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdBancoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_banco_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoBancoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoBancoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_banco_forma_pago,BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoBancoFormaPago);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBancoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdDetaFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_deta_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetaFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetaFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_deta_forma_pago,BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetaFormaPago);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetaFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdDetaFormaPago(String sFinalQuery,Pagination pagination,Long id_deta_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetaFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetaFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_deta_forma_pago,BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetaFormaPago);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetaFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,BancoFormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,BancoFormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BancoFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BancoFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,BancoFormaPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,BancoFormaPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,BancoFormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,BancoFormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,BancoFormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,BancoFormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoFormaPagosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BancoFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoFormaPagosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,BancoFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			BancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancoformapagos=bancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(this.bancoformapagos);
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
			if(BancoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoFormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,BancoFormaPago bancoformapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BancoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(bancoformapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoFormaPagoDataAccess.TABLENAME, bancoformapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BancoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BancoFormaPagoLogic.registrarAuditoriaDetallesBancoFormaPago(connexion,bancoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(bancoformapago.getIsDeleted()) {
					/*if(!bancoformapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BancoFormaPagoDataAccess.TABLENAME, bancoformapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BancoFormaPagoLogic.registrarAuditoriaDetallesBancoFormaPago(connexion,bancoformapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoFormaPagoDataAccess.TABLENAME, bancoformapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(bancoformapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoFormaPagoDataAccess.TABLENAME, bancoformapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BancoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BancoFormaPagoLogic.registrarAuditoriaDetallesBancoFormaPago(connexion,bancoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBancoFormaPago(Connexion connexion,BancoFormaPago bancoformapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_empresa().equals(bancoformapago.getBancoFormaPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_empresa().toString();
				}
				if(bancoformapago.getid_empresa()!=null)
				{
					strValorNuevo=bancoformapago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_sucursal().equals(bancoformapago.getBancoFormaPagoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_sucursal()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_sucursal().toString();
				}
				if(bancoformapago.getid_sucursal()!=null)
				{
					strValorNuevo=bancoformapago.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_ejercicio().equals(bancoformapago.getBancoFormaPagoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_ejercicio().toString();
				}
				if(bancoformapago.getid_ejercicio()!=null)
				{
					strValorNuevo=bancoformapago.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_periodo().equals(bancoformapago.getBancoFormaPagoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_periodo()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_periodo().toString();
				}
				if(bancoformapago.getid_periodo()!=null)
				{
					strValorNuevo=bancoformapago.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_factura().equals(bancoformapago.getBancoFormaPagoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_factura()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_factura().toString();
				}
				if(bancoformapago.getid_factura()!=null)
				{
					strValorNuevo=bancoformapago.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_deta_forma_pago().equals(bancoformapago.getBancoFormaPagoOriginal().getid_deta_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_deta_forma_pago()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_deta_forma_pago().toString();
				}
				if(bancoformapago.getid_deta_forma_pago()!=null)
				{
					strValorNuevo=bancoformapago.getid_deta_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_tipo_banco_forma_pago().equals(bancoformapago.getBancoFormaPagoOriginal().getid_tipo_banco_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_tipo_banco_forma_pago()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_tipo_banco_forma_pago().toString();
				}
				if(bancoformapago.getid_tipo_banco_forma_pago()!=null)
				{
					strValorNuevo=bancoformapago.getid_tipo_banco_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getnombre_banco().equals(bancoformapago.getBancoFormaPagoOriginal().getnombre_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getnombre_banco()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getnombre_banco();
				}
				if(bancoformapago.getnombre_banco()!=null)
				{
					strValorNuevo=bancoformapago.getnombre_banco() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.NOMBREBANCO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getnombre_girador().equals(bancoformapago.getBancoFormaPagoOriginal().getnombre_girador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getnombre_girador()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getnombre_girador();
				}
				if(bancoformapago.getnombre_girador()!=null)
				{
					strValorNuevo=bancoformapago.getnombre_girador() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.NOMBREGIRADOR,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getfecha_vence().equals(bancoformapago.getBancoFormaPagoOriginal().getfecha_vence()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getfecha_vence()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getfecha_vence().toString();
				}
				if(bancoformapago.getfecha_vence()!=null)
				{
					strValorNuevo=bancoformapago.getfecha_vence().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.FECHAVENCE,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getnumero_cuenta_banco().equals(bancoformapago.getBancoFormaPagoOriginal().getnumero_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getnumero_cuenta_banco()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getnumero_cuenta_banco();
				}
				if(bancoformapago.getnumero_cuenta_banco()!=null)
				{
					strValorNuevo=bancoformapago.getnumero_cuenta_banco() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getnumero_cheque().equals(bancoformapago.getBancoFormaPagoOriginal().getnumero_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getnumero_cheque()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getnumero_cheque();
				}
				if(bancoformapago.getnumero_cheque()!=null)
				{
					strValorNuevo=bancoformapago.getnumero_cheque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.NUMEROCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getvalor_monto().equals(bancoformapago.getBancoFormaPagoOriginal().getvalor_monto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getvalor_monto()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getvalor_monto().toString();
				}
				if(bancoformapago.getvalor_monto()!=null)
				{
					strValorNuevo=bancoformapago.getvalor_monto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.VALORMONTO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_anio().equals(bancoformapago.getBancoFormaPagoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_anio()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_anio().toString();
				}
				if(bancoformapago.getid_anio()!=null)
				{
					strValorNuevo=bancoformapago.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(bancoformapago.getIsNew()||!bancoformapago.getid_mes().equals(bancoformapago.getBancoFormaPagoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancoformapago.getBancoFormaPagoOriginal().getid_mes()!=null)
				{
					strValorActual=bancoformapago.getBancoFormaPagoOriginal().getid_mes().toString();
				}
				if(bancoformapago.getid_mes()!=null)
				{
					strValorNuevo=bancoformapago.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoFormaPagoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBancoFormaPagoRelacionesWithConnection(BancoFormaPago bancoformapago) throws Exception {

		if(!bancoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBancoFormaPagoRelacionesBase(bancoformapago,true);
		}
	}

	public void saveBancoFormaPagoRelaciones(BancoFormaPago bancoformapago)throws Exception {

		if(!bancoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBancoFormaPagoRelacionesBase(bancoformapago,false);
		}
	}

	public void saveBancoFormaPagoRelacionesBase(BancoFormaPago bancoformapago,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("BancoFormaPago-saveRelacionesWithConnection");}
	

			this.setBancoFormaPago(bancoformapago);

			if(BancoFormaPagoLogicAdditional.validarSaveRelaciones(bancoformapago,this)) {

				BancoFormaPagoLogicAdditional.updateRelacionesToSave(bancoformapago,this);

				if((bancoformapago.getIsNew()||bancoformapago.getIsChanged())&&!bancoformapago.getIsDeleted()) {
					this.saveBancoFormaPago();
					this.saveBancoFormaPagoRelacionesDetalles();

				} else if(bancoformapago.getIsDeleted()) {
					this.saveBancoFormaPagoRelacionesDetalles();
					this.saveBancoFormaPago();
				}

				BancoFormaPagoLogicAdditional.updateRelacionesToSaveAfter(bancoformapago,this);

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
	
	
	private void saveBancoFormaPagoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BancoFormaPagoConstantesFunciones.getClassesForeignKeysOfBancoFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BancoFormaPagoConstantesFunciones.getClassesRelationshipsOfBancoFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
