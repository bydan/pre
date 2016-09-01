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
import com.bydan.erp.tesoreria.util.ChequePostFechadoConstantesFunciones;
import com.bydan.erp.tesoreria.util.ChequePostFechadoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.ChequePostFechadoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.ChequePostFechado;
import com.bydan.erp.tesoreria.business.logic.ChequePostFechadoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class ChequePostFechadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ChequePostFechadoLogic.class);
	
	protected ChequePostFechadoDataAccess chequepostfechadoDataAccess; 	
	protected ChequePostFechado chequepostfechado;
	protected List<ChequePostFechado> chequepostfechados;
	protected Object chequepostfechadoObject;	
	protected List<Object> chequepostfechadosObject;
	
	public static ClassValidator<ChequePostFechado> chequepostfechadoValidator = new ClassValidator<ChequePostFechado>(ChequePostFechado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ChequePostFechadoLogicAdditional chequepostfechadoLogicAdditional=null;
	
	public ChequePostFechadoLogicAdditional getChequePostFechadoLogicAdditional() {
		return this.chequepostfechadoLogicAdditional;
	}
	
	public void setChequePostFechadoLogicAdditional(ChequePostFechadoLogicAdditional chequepostfechadoLogicAdditional) {
		try {
			this.chequepostfechadoLogicAdditional=chequepostfechadoLogicAdditional;
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
	
	
	
	
	public  ChequePostFechadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.chequepostfechadoDataAccess = new ChequePostFechadoDataAccess();
			
			this.chequepostfechados= new ArrayList<ChequePostFechado>();
			this.chequepostfechado= new ChequePostFechado();
			
			this.chequepostfechadoObject=new Object();
			this.chequepostfechadosObject=new ArrayList<Object>();
				
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
			
			this.chequepostfechadoDataAccess.setConnexionType(this.connexionType);
			this.chequepostfechadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ChequePostFechadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.chequepostfechadoDataAccess = new ChequePostFechadoDataAccess();
			this.chequepostfechados= new ArrayList<ChequePostFechado>();
			this.chequepostfechado= new ChequePostFechado();
			this.chequepostfechadoObject=new Object();
			this.chequepostfechadosObject=new ArrayList<Object>();
			
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
			
			this.chequepostfechadoDataAccess.setConnexionType(this.connexionType);
			this.chequepostfechadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ChequePostFechado getChequePostFechado() throws Exception {	
		ChequePostFechadoLogicAdditional.checkChequePostFechadoToGet(chequepostfechado,this.datosCliente,this.arrDatoGeneral);
		ChequePostFechadoLogicAdditional.updateChequePostFechadoToGet(chequepostfechado,this.arrDatoGeneral);
		
		return chequepostfechado;
	}
		
	public void setChequePostFechado(ChequePostFechado newChequePostFechado) {
		this.chequepostfechado = newChequePostFechado;
	}
	
	public ChequePostFechadoDataAccess getChequePostFechadoDataAccess() {
		return chequepostfechadoDataAccess;
	}
	
	public void setChequePostFechadoDataAccess(ChequePostFechadoDataAccess newchequepostfechadoDataAccess) {
		this.chequepostfechadoDataAccess = newchequepostfechadoDataAccess;
	}
	
	public List<ChequePostFechado> getChequePostFechados() throws Exception {		
		this.quitarChequePostFechadosNulos();
		
		ChequePostFechadoLogicAdditional.checkChequePostFechadoToGets(chequepostfechados,this.datosCliente,this.arrDatoGeneral);
		
		for (ChequePostFechado chequepostfechadoLocal: chequepostfechados ) {
			ChequePostFechadoLogicAdditional.updateChequePostFechadoToGet(chequepostfechadoLocal,this.arrDatoGeneral);
		}
		
		return chequepostfechados;
	}
	
	public void setChequePostFechados(List<ChequePostFechado> newChequePostFechados) {
		this.chequepostfechados = newChequePostFechados;
	}
	
	public Object getChequePostFechadoObject() {	
		this.chequepostfechadoObject=this.chequepostfechadoDataAccess.getEntityObject();
		return this.chequepostfechadoObject;
	}
		
	public void setChequePostFechadoObject(Object newChequePostFechadoObject) {
		this.chequepostfechadoObject = newChequePostFechadoObject;
	}
	
	public List<Object> getChequePostFechadosObject() {		
		this.chequepostfechadosObject=this.chequepostfechadoDataAccess.getEntitiesObject();
		return this.chequepostfechadosObject;
	}
		
	public void setChequePostFechadosObject(List<Object> newChequePostFechadosObject) {
		this.chequepostfechadosObject = newChequePostFechadosObject;
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
		
		if(this.chequepostfechadoDataAccess!=null) {
			this.chequepostfechadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			chequepostfechadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			chequepostfechadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		chequepostfechado = new  ChequePostFechado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			chequepostfechado=chequepostfechadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.chequepostfechado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechado);
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
		chequepostfechado = new  ChequePostFechado();
		  		  
        try {
			
			chequepostfechado=chequepostfechadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.chequepostfechado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		chequepostfechado = new  ChequePostFechado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			chequepostfechado=chequepostfechadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.chequepostfechado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechado);
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
		chequepostfechado = new  ChequePostFechado();
		  		  
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
		chequepostfechado = new  ChequePostFechado();
		  		  
        try {
			
			chequepostfechado=chequepostfechadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.chequepostfechado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		chequepostfechado = new  ChequePostFechado();
		  		  
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
		chequepostfechado = new  ChequePostFechado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =chequepostfechadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		chequepostfechado = new  ChequePostFechado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=chequepostfechadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		chequepostfechado = new  ChequePostFechado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =chequepostfechadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		chequepostfechado = new  ChequePostFechado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=chequepostfechadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		chequepostfechado = new  ChequePostFechado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =chequepostfechadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		chequepostfechado = new  ChequePostFechado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=chequepostfechadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
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
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
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
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
        try {			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
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
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
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
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
        try {
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
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
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
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
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		chequepostfechado = new  ChequePostFechado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechado=chequepostfechadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechado);
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
		chequepostfechado = new  ChequePostFechado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechado=chequepostfechadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
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
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		  		  
        try {
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosChequePostFechadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getTodosChequePostFechadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
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
	
	public  void  getTodosChequePostFechados(String sFinalQuery,Pagination pagination)throws Exception {
		chequepostfechados = new  ArrayList<ChequePostFechado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarChequePostFechado(chequepostfechados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarChequePostFechado(ChequePostFechado chequepostfechado) throws Exception {
		Boolean estaValidado=false;
		
		if(chequepostfechado.getIsNew() || chequepostfechado.getIsChanged()) { 
			this.invalidValues = chequepostfechadoValidator.getInvalidValues(chequepostfechado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(chequepostfechado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarChequePostFechado(List<ChequePostFechado> ChequePostFechados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ChequePostFechado chequepostfechadoLocal:chequepostfechados) {				
			estaValidadoObjeto=this.validarGuardarChequePostFechado(chequepostfechadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarChequePostFechado(List<ChequePostFechado> ChequePostFechados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarChequePostFechado(chequepostfechados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarChequePostFechado(ChequePostFechado ChequePostFechado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarChequePostFechado(chequepostfechado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ChequePostFechado chequepostfechado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+chequepostfechado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ChequePostFechadoConstantesFunciones.getChequePostFechadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"chequepostfechado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ChequePostFechadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ChequePostFechadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveChequePostFechadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-saveChequePostFechadoWithConnection");connexion.begin();			
			
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSave(this.chequepostfechado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ChequePostFechadoLogicAdditional.updateChequePostFechadoToSave(this.chequepostfechado,this.arrDatoGeneral);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.chequepostfechado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowChequePostFechado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarChequePostFechado(this.chequepostfechado)) {
				ChequePostFechadoDataAccess.save(this.chequepostfechado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.chequepostfechado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSaveAfter(this.chequepostfechado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowChequePostFechado();
			
			connexion.commit();			
			
			if(this.chequepostfechado.getIsDeleted()) {
				this.chequepostfechado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveChequePostFechado()throws Exception {	
		try {	
			
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSave(this.chequepostfechado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ChequePostFechadoLogicAdditional.updateChequePostFechadoToSave(this.chequepostfechado,this.arrDatoGeneral);
			
			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.chequepostfechado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarChequePostFechado(this.chequepostfechado)) {			
				ChequePostFechadoDataAccess.save(this.chequepostfechado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.chequepostfechado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSaveAfter(this.chequepostfechado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.chequepostfechado.getIsDeleted()) {
				this.chequepostfechado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveChequePostFechadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-saveChequePostFechadosWithConnection");connexion.begin();			
			
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSaves(chequepostfechados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowChequePostFechados();
			
			Boolean validadoTodosChequePostFechado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ChequePostFechado chequepostfechadoLocal:chequepostfechados) {		
				if(chequepostfechadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ChequePostFechadoLogicAdditional.updateChequePostFechadoToSave(chequepostfechadoLocal,this.arrDatoGeneral);
	        	
				ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),chequepostfechadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarChequePostFechado(chequepostfechadoLocal)) {
					ChequePostFechadoDataAccess.save(chequepostfechadoLocal, connexion);				
				} else {
					validadoTodosChequePostFechado=false;
				}
			}
			
			if(!validadoTodosChequePostFechado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSavesAfter(chequepostfechados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowChequePostFechados();
			
			connexion.commit();		
			
			this.quitarChequePostFechadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveChequePostFechados()throws Exception {				
		 try {	
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSaves(chequepostfechados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosChequePostFechado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ChequePostFechado chequepostfechadoLocal:chequepostfechados) {				
				if(chequepostfechadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ChequePostFechadoLogicAdditional.updateChequePostFechadoToSave(chequepostfechadoLocal,this.arrDatoGeneral);
	        	
				ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),chequepostfechadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarChequePostFechado(chequepostfechadoLocal)) {				
					ChequePostFechadoDataAccess.save(chequepostfechadoLocal, connexion);				
				} else {
					validadoTodosChequePostFechado=false;
				}
			}
			
			if(!validadoTodosChequePostFechado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ChequePostFechadoLogicAdditional.checkChequePostFechadoToSavesAfter(chequepostfechados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarChequePostFechadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ChequePostFechadoParameterReturnGeneral procesarAccionChequePostFechados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ChequePostFechado> chequepostfechados,ChequePostFechadoParameterReturnGeneral chequepostfechadoParameterGeneral)throws Exception {
		 try {	
			ChequePostFechadoParameterReturnGeneral chequepostfechadoReturnGeneral=new ChequePostFechadoParameterReturnGeneral();
	
			ChequePostFechadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,chequepostfechados,chequepostfechadoParameterGeneral,chequepostfechadoReturnGeneral);
			
			return chequepostfechadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ChequePostFechadoParameterReturnGeneral procesarAccionChequePostFechadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ChequePostFechado> chequepostfechados,ChequePostFechadoParameterReturnGeneral chequepostfechadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-procesarAccionChequePostFechadosWithConnection");connexion.begin();			
			
			ChequePostFechadoParameterReturnGeneral chequepostfechadoReturnGeneral=new ChequePostFechadoParameterReturnGeneral();
	
			ChequePostFechadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,chequepostfechados,chequepostfechadoParameterGeneral,chequepostfechadoReturnGeneral);
			
			this.connexion.commit();
			
			return chequepostfechadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ChequePostFechadoParameterReturnGeneral procesarEventosChequePostFechados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ChequePostFechado> chequepostfechados,ChequePostFechado chequepostfechado,ChequePostFechadoParameterReturnGeneral chequepostfechadoParameterGeneral,Boolean isEsNuevoChequePostFechado,ArrayList<Classe> clases)throws Exception {
		 try {	
			ChequePostFechadoParameterReturnGeneral chequepostfechadoReturnGeneral=new ChequePostFechadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				chequepostfechadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ChequePostFechadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,chequepostfechados,chequepostfechado,chequepostfechadoParameterGeneral,chequepostfechadoReturnGeneral,isEsNuevoChequePostFechado,clases);
			
			return chequepostfechadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ChequePostFechadoParameterReturnGeneral procesarEventosChequePostFechadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ChequePostFechado> chequepostfechados,ChequePostFechado chequepostfechado,ChequePostFechadoParameterReturnGeneral chequepostfechadoParameterGeneral,Boolean isEsNuevoChequePostFechado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-procesarEventosChequePostFechadosWithConnection");connexion.begin();			
			
			ChequePostFechadoParameterReturnGeneral chequepostfechadoReturnGeneral=new ChequePostFechadoParameterReturnGeneral();
	
			chequepostfechadoReturnGeneral.setChequePostFechado(chequepostfechado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				chequepostfechadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ChequePostFechadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,chequepostfechados,chequepostfechado,chequepostfechadoParameterGeneral,chequepostfechadoReturnGeneral,isEsNuevoChequePostFechado,clases);
			
			this.connexion.commit();
			
			return chequepostfechadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ChequePostFechadoParameterReturnGeneral procesarImportacionChequePostFechadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ChequePostFechadoParameterReturnGeneral chequepostfechadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-procesarImportacionChequePostFechadosWithConnection");connexion.begin();			
			
			ChequePostFechadoParameterReturnGeneral chequepostfechadoReturnGeneral=new ChequePostFechadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.chequepostfechados=new ArrayList<ChequePostFechado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.chequepostfechado=new ChequePostFechado();
				
				
				if(conColumnasBase) {this.chequepostfechado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.chequepostfechado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.chequepostfechado.setnombre_gira(arrColumnas[iColumn++]);
				this.chequepostfechado.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.chequepostfechado.setfecha_vencimiento_original(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.chequepostfechado.setnumero(arrColumnas[iColumn++]);
				this.chequepostfechado.setnumero_cheque(arrColumnas[iColumn++]);
				this.chequepostfechado.setdescripcion(arrColumnas[iColumn++]);
				
				this.chequepostfechados.add(this.chequepostfechado);
			}
			
			this.saveChequePostFechados();
			
			this.connexion.commit();
			
			chequepostfechadoReturnGeneral.setConRetornoEstaProcesado(true);
			chequepostfechadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return chequepostfechadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarChequePostFechadosEliminados() throws Exception {				
		
		List<ChequePostFechado> chequepostfechadosAux= new ArrayList<ChequePostFechado>();
		
		for(ChequePostFechado chequepostfechado:chequepostfechados) {
			if(!chequepostfechado.getIsDeleted()) {
				chequepostfechadosAux.add(chequepostfechado);
			}
		}
		
		chequepostfechados=chequepostfechadosAux;
	}
	
	public void quitarChequePostFechadosNulos() throws Exception {				
		
		List<ChequePostFechado> chequepostfechadosAux= new ArrayList<ChequePostFechado>();
		
		for(ChequePostFechado chequepostfechado : this.chequepostfechados) {
			if(chequepostfechado==null) {
				chequepostfechadosAux.add(chequepostfechado);
			}
		}
		
		//this.chequepostfechados=chequepostfechadosAux;
		
		this.chequepostfechados.removeAll(chequepostfechadosAux);
	}
	
	public void getSetVersionRowChequePostFechadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(chequepostfechado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((chequepostfechado.getIsDeleted() || (chequepostfechado.getIsChanged()&&!chequepostfechado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=chequepostfechadoDataAccess.getSetVersionRowChequePostFechado(connexion,chequepostfechado.getId());
				
				if(!chequepostfechado.getVersionRow().equals(timestamp)) {	
					chequepostfechado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				chequepostfechado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowChequePostFechado()throws Exception {	
		
		if(chequepostfechado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((chequepostfechado.getIsDeleted() || (chequepostfechado.getIsChanged()&&!chequepostfechado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=chequepostfechadoDataAccess.getSetVersionRowChequePostFechado(connexion,chequepostfechado.getId());
			
			try {							
				if(!chequepostfechado.getVersionRow().equals(timestamp)) {	
					chequepostfechado.setVersionRow(timestamp);
				}
				
				chequepostfechado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowChequePostFechadosWithConnection()throws Exception {	
		if(chequepostfechados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ChequePostFechado chequepostfechadoAux:chequepostfechados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(chequepostfechadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(chequepostfechadoAux.getIsDeleted() || (chequepostfechadoAux.getIsChanged()&&!chequepostfechadoAux.getIsNew())) {
						
						timestamp=chequepostfechadoDataAccess.getSetVersionRowChequePostFechado(connexion,chequepostfechadoAux.getId());
						
						if(!chequepostfechado.getVersionRow().equals(timestamp)) {	
							chequepostfechadoAux.setVersionRow(timestamp);
						}
								
						chequepostfechadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowChequePostFechados()throws Exception {	
		if(chequepostfechados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ChequePostFechado chequepostfechadoAux:chequepostfechados) {
					if(chequepostfechadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(chequepostfechadoAux.getIsDeleted() || (chequepostfechadoAux.getIsChanged()&&!chequepostfechadoAux.getIsNew())) {
						
						timestamp=chequepostfechadoDataAccess.getSetVersionRowChequePostFechado(connexion,chequepostfechadoAux.getId());
						
						if(!chequepostfechadoAux.getVersionRow().equals(timestamp)) {	
							chequepostfechadoAux.setVersionRow(timestamp);
						}
						
													
						chequepostfechadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ChequePostFechadoParameterReturnGeneral cargarCombosLoteForeignKeyChequePostFechadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalAsientoContable,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		ChequePostFechadoParameterReturnGeneral  chequepostfechadoReturnGeneral =new ChequePostFechadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-cargarCombosLoteForeignKeyChequePostFechadoWithConnection");connexion.begin();
			
			chequepostfechadoReturnGeneral =new ChequePostFechadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			chequepostfechadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			chequepostfechadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			chequepostfechadoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			chequepostfechadoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			chequepostfechadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			chequepostfechadoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			chequepostfechadoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			chequepostfechadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			chequepostfechadoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return chequepostfechadoReturnGeneral;
	}
	
	public ChequePostFechadoParameterReturnGeneral cargarCombosLoteForeignKeyChequePostFechado(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalAsientoContable,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		ChequePostFechadoParameterReturnGeneral  chequepostfechadoReturnGeneral =new ChequePostFechadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			chequepostfechadoReturnGeneral =new ChequePostFechadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			chequepostfechadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			chequepostfechadoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			chequepostfechadoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			chequepostfechadoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			chequepostfechadoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			chequepostfechadoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			chequepostfechadoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			chequepostfechadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			chequepostfechadoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return chequepostfechadoReturnGeneral;
	}
	
	
	public void deepLoad(ChequePostFechado chequepostfechado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ChequePostFechadoLogicAdditional.updateChequePostFechadoToGet(chequepostfechado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		chequepostfechado.setEmpresa(chequepostfechadoDataAccess.getEmpresa(connexion,chequepostfechado));
		chequepostfechado.setSucursal(chequepostfechadoDataAccess.getSucursal(connexion,chequepostfechado));
		chequepostfechado.setCliente(chequepostfechadoDataAccess.getCliente(connexion,chequepostfechado));
		chequepostfechado.setAsientoContable(chequepostfechadoDataAccess.getAsientoContable(connexion,chequepostfechado));
		chequepostfechado.setEjercicio(chequepostfechadoDataAccess.getEjercicio(connexion,chequepostfechado));
		chequepostfechado.setPeriodo(chequepostfechadoDataAccess.getPeriodo(connexion,chequepostfechado));
		chequepostfechado.setTipoFormaPago(chequepostfechadoDataAccess.getTipoFormaPago(connexion,chequepostfechado));
		chequepostfechado.setAnio(chequepostfechadoDataAccess.getAnio(connexion,chequepostfechado));
		chequepostfechado.setMes(chequepostfechadoDataAccess.getMes(connexion,chequepostfechado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				chequepostfechado.setEmpresa(chequepostfechadoDataAccess.getEmpresa(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				chequepostfechado.setSucursal(chequepostfechadoDataAccess.getSucursal(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				chequepostfechado.setCliente(chequepostfechadoDataAccess.getCliente(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				chequepostfechado.setAsientoContable(chequepostfechadoDataAccess.getAsientoContable(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				chequepostfechado.setEjercicio(chequepostfechadoDataAccess.getEjercicio(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				chequepostfechado.setPeriodo(chequepostfechadoDataAccess.getPeriodo(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				chequepostfechado.setTipoFormaPago(chequepostfechadoDataAccess.getTipoFormaPago(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				chequepostfechado.setAnio(chequepostfechadoDataAccess.getAnio(connexion,chequepostfechado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				chequepostfechado.setMes(chequepostfechadoDataAccess.getMes(connexion,chequepostfechado));
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
			chequepostfechado.setEmpresa(chequepostfechadoDataAccess.getEmpresa(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setSucursal(chequepostfechadoDataAccess.getSucursal(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setCliente(chequepostfechadoDataAccess.getCliente(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setAsientoContable(chequepostfechadoDataAccess.getAsientoContable(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setEjercicio(chequepostfechadoDataAccess.getEjercicio(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setPeriodo(chequepostfechadoDataAccess.getPeriodo(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setTipoFormaPago(chequepostfechadoDataAccess.getTipoFormaPago(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setAnio(chequepostfechadoDataAccess.getAnio(connexion,chequepostfechado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setMes(chequepostfechadoDataAccess.getMes(connexion,chequepostfechado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		chequepostfechado.setEmpresa(chequepostfechadoDataAccess.getEmpresa(connexion,chequepostfechado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(chequepostfechado.getEmpresa(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setSucursal(chequepostfechadoDataAccess.getSucursal(connexion,chequepostfechado));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(chequepostfechado.getSucursal(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setCliente(chequepostfechadoDataAccess.getCliente(connexion,chequepostfechado));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(chequepostfechado.getCliente(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setAsientoContable(chequepostfechadoDataAccess.getAsientoContable(connexion,chequepostfechado));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(chequepostfechado.getAsientoContable(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setEjercicio(chequepostfechadoDataAccess.getEjercicio(connexion,chequepostfechado));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(chequepostfechado.getEjercicio(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setPeriodo(chequepostfechadoDataAccess.getPeriodo(connexion,chequepostfechado));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(chequepostfechado.getPeriodo(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setTipoFormaPago(chequepostfechadoDataAccess.getTipoFormaPago(connexion,chequepostfechado));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(chequepostfechado.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setAnio(chequepostfechadoDataAccess.getAnio(connexion,chequepostfechado));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(chequepostfechado.getAnio(),isDeep,deepLoadType,clases);
				
		chequepostfechado.setMes(chequepostfechadoDataAccess.getMes(connexion,chequepostfechado));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(chequepostfechado.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				chequepostfechado.setEmpresa(chequepostfechadoDataAccess.getEmpresa(connexion,chequepostfechado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(chequepostfechado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				chequepostfechado.setSucursal(chequepostfechadoDataAccess.getSucursal(connexion,chequepostfechado));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(chequepostfechado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				chequepostfechado.setCliente(chequepostfechadoDataAccess.getCliente(connexion,chequepostfechado));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(chequepostfechado.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				chequepostfechado.setAsientoContable(chequepostfechadoDataAccess.getAsientoContable(connexion,chequepostfechado));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(chequepostfechado.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				chequepostfechado.setEjercicio(chequepostfechadoDataAccess.getEjercicio(connexion,chequepostfechado));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(chequepostfechado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				chequepostfechado.setPeriodo(chequepostfechadoDataAccess.getPeriodo(connexion,chequepostfechado));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(chequepostfechado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				chequepostfechado.setTipoFormaPago(chequepostfechadoDataAccess.getTipoFormaPago(connexion,chequepostfechado));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(chequepostfechado.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				chequepostfechado.setAnio(chequepostfechadoDataAccess.getAnio(connexion,chequepostfechado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(chequepostfechado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				chequepostfechado.setMes(chequepostfechadoDataAccess.getMes(connexion,chequepostfechado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(chequepostfechado.getMes(),isDeep,deepLoadType,clases);				
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
			chequepostfechado.setEmpresa(chequepostfechadoDataAccess.getEmpresa(connexion,chequepostfechado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(chequepostfechado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setSucursal(chequepostfechadoDataAccess.getSucursal(connexion,chequepostfechado));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(chequepostfechado.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setCliente(chequepostfechadoDataAccess.getCliente(connexion,chequepostfechado));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(chequepostfechado.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setAsientoContable(chequepostfechadoDataAccess.getAsientoContable(connexion,chequepostfechado));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(chequepostfechado.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setEjercicio(chequepostfechadoDataAccess.getEjercicio(connexion,chequepostfechado));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(chequepostfechado.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setPeriodo(chequepostfechadoDataAccess.getPeriodo(connexion,chequepostfechado));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(chequepostfechado.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setTipoFormaPago(chequepostfechadoDataAccess.getTipoFormaPago(connexion,chequepostfechado));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(chequepostfechado.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setAnio(chequepostfechadoDataAccess.getAnio(connexion,chequepostfechado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(chequepostfechado.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			chequepostfechado.setMes(chequepostfechadoDataAccess.getMes(connexion,chequepostfechado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(chequepostfechado.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ChequePostFechado chequepostfechado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ChequePostFechadoLogicAdditional.updateChequePostFechadoToSave(chequepostfechado,this.arrDatoGeneral);
			
ChequePostFechadoDataAccess.save(chequepostfechado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(chequepostfechado.getEmpresa(),connexion);

		SucursalDataAccess.save(chequepostfechado.getSucursal(),connexion);

		ClienteDataAccess.save(chequepostfechado.getCliente(),connexion);

		AsientoContableDataAccess.save(chequepostfechado.getAsientoContable(),connexion);

		EjercicioDataAccess.save(chequepostfechado.getEjercicio(),connexion);

		PeriodoDataAccess.save(chequepostfechado.getPeriodo(),connexion);

		TipoFormaPagoDataAccess.save(chequepostfechado.getTipoFormaPago(),connexion);

		AnioDataAccess.save(chequepostfechado.getAnio(),connexion);

		MesDataAccess.save(chequepostfechado.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(chequepostfechado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(chequepostfechado.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(chequepostfechado.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(chequepostfechado.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(chequepostfechado.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(chequepostfechado.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(chequepostfechado.getTipoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(chequepostfechado.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(chequepostfechado.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(chequepostfechado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(chequepostfechado.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(chequepostfechado.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(chequepostfechado.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(chequepostfechado.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(chequepostfechado.getCliente(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(chequepostfechado.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(chequepostfechado.getAsientoContable(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(chequepostfechado.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(chequepostfechado.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(chequepostfechado.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(chequepostfechado.getPeriodo(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(chequepostfechado.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(chequepostfechado.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(chequepostfechado.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(chequepostfechado.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(chequepostfechado.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(chequepostfechado.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(chequepostfechado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(chequepostfechado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(chequepostfechado.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(chequepostfechado.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(chequepostfechado.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(chequepostfechado.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(chequepostfechado.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(chequepostfechado.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(chequepostfechado.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(chequepostfechado.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(chequepostfechado.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(chequepostfechado.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(chequepostfechado.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(chequepostfechado.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(chequepostfechado.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(chequepostfechado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(chequepostfechado.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(chequepostfechado.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ChequePostFechado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(chequepostfechado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(chequepostfechado);
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
			this.deepLoad(this.chequepostfechado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ChequePostFechado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(chequepostfechados!=null) {
				for(ChequePostFechado chequepostfechado:chequepostfechados) {
					this.deepLoad(chequepostfechado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(chequepostfechados);
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
			if(chequepostfechados!=null) {
				for(ChequePostFechado chequepostfechado:chequepostfechados) {
					this.deepLoad(chequepostfechado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(chequepostfechados);
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
			this.getNewConnexionToDeep(ChequePostFechado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(chequepostfechado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ChequePostFechado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(chequepostfechados!=null) {
				for(ChequePostFechado chequepostfechado:chequepostfechados) {
					this.deepSave(chequepostfechado,isDeep,deepLoadType,clases);
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
			if(chequepostfechados!=null) {
				for(ChequePostFechado chequepostfechado:chequepostfechados) {
					this.deepSave(chequepostfechado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getChequePostFechadosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ChequePostFechadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ChequePostFechadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ChequePostFechadoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ChequePostFechadoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ChequePostFechadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ChequePostFechadoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ChequePostFechadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ChequePostFechadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ChequePostFechadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ChequePostFechadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ChequePostFechadoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ChequePostFechadoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ChequePostFechadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ChequePostFechadoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getChequePostFechadosFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ChequePostFechado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getChequePostFechadosFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			ChequePostFechadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(this.chequepostfechados);
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
			if(ChequePostFechadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ChequePostFechadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ChequePostFechado chequepostfechado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ChequePostFechadoConstantesFunciones.ISCONAUDITORIA) {
				if(chequepostfechado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ChequePostFechadoDataAccess.TABLENAME, chequepostfechado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ChequePostFechadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ChequePostFechadoLogic.registrarAuditoriaDetallesChequePostFechado(connexion,chequepostfechado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(chequepostfechado.getIsDeleted()) {
					/*if(!chequepostfechado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ChequePostFechadoDataAccess.TABLENAME, chequepostfechado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ChequePostFechadoLogic.registrarAuditoriaDetallesChequePostFechado(connexion,chequepostfechado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ChequePostFechadoDataAccess.TABLENAME, chequepostfechado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(chequepostfechado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ChequePostFechadoDataAccess.TABLENAME, chequepostfechado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ChequePostFechadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ChequePostFechadoLogic.registrarAuditoriaDetallesChequePostFechado(connexion,chequepostfechado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesChequePostFechado(Connexion connexion,ChequePostFechado chequepostfechado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_empresa().equals(chequepostfechado.getChequePostFechadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_empresa()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_empresa().toString();
				}
				if(chequepostfechado.getid_empresa()!=null)
				{
					strValorNuevo=chequepostfechado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_sucursal().equals(chequepostfechado.getChequePostFechadoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_sucursal()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_sucursal().toString();
				}
				if(chequepostfechado.getid_sucursal()!=null)
				{
					strValorNuevo=chequepostfechado.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_cliente().equals(chequepostfechado.getChequePostFechadoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_cliente()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_cliente().toString();
				}
				if(chequepostfechado.getid_cliente()!=null)
				{
					strValorNuevo=chequepostfechado.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_asiento_contable().equals(chequepostfechado.getChequePostFechadoOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_asiento_contable().toString();
				}
				if(chequepostfechado.getid_asiento_contable()!=null)
				{
					strValorNuevo=chequepostfechado.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_ejercicio().equals(chequepostfechado.getChequePostFechadoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_ejercicio().toString();
				}
				if(chequepostfechado.getid_ejercicio()!=null)
				{
					strValorNuevo=chequepostfechado.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_periodo().equals(chequepostfechado.getChequePostFechadoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_periodo()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_periodo().toString();
				}
				if(chequepostfechado.getid_periodo()!=null)
				{
					strValorNuevo=chequepostfechado.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_tipo_forma_pago().equals(chequepostfechado.getChequePostFechadoOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_tipo_forma_pago().toString();
				}
				if(chequepostfechado.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=chequepostfechado.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getnombre_gira().equals(chequepostfechado.getChequePostFechadoOriginal().getnombre_gira()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getnombre_gira()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getnombre_gira();
				}
				if(chequepostfechado.getnombre_gira()!=null)
				{
					strValorNuevo=chequepostfechado.getnombre_gira() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.NOMBREGIRA,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getfecha_vencimiento().equals(chequepostfechado.getChequePostFechadoOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getfecha_vencimiento().toString();
				}
				if(chequepostfechado.getfecha_vencimiento()!=null)
				{
					strValorNuevo=chequepostfechado.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getfecha_vencimiento_original().equals(chequepostfechado.getChequePostFechadoOriginal().getfecha_vencimiento_original()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getfecha_vencimiento_original()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getfecha_vencimiento_original().toString();
				}
				if(chequepostfechado.getfecha_vencimiento_original()!=null)
				{
					strValorNuevo=chequepostfechado.getfecha_vencimiento_original().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.FECHAVENCIMIENTOORIGINAL,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getnumero().equals(chequepostfechado.getChequePostFechadoOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getnumero()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getnumero();
				}
				if(chequepostfechado.getnumero()!=null)
				{
					strValorNuevo=chequepostfechado.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getnumero_cheque().equals(chequepostfechado.getChequePostFechadoOriginal().getnumero_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getnumero_cheque()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getnumero_cheque();
				}
				if(chequepostfechado.getnumero_cheque()!=null)
				{
					strValorNuevo=chequepostfechado.getnumero_cheque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.NUMEROCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getdescripcion().equals(chequepostfechado.getChequePostFechadoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getdescripcion()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getdescripcion();
				}
				if(chequepostfechado.getdescripcion()!=null)
				{
					strValorNuevo=chequepostfechado.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_anio().equals(chequepostfechado.getChequePostFechadoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_anio()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_anio().toString();
				}
				if(chequepostfechado.getid_anio()!=null)
				{
					strValorNuevo=chequepostfechado.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(chequepostfechado.getIsNew()||!chequepostfechado.getid_mes().equals(chequepostfechado.getChequePostFechadoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(chequepostfechado.getChequePostFechadoOriginal().getid_mes()!=null)
				{
					strValorActual=chequepostfechado.getChequePostFechadoOriginal().getid_mes().toString();
				}
				if(chequepostfechado.getid_mes()!=null)
				{
					strValorNuevo=chequepostfechado.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ChequePostFechadoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveChequePostFechadoRelacionesWithConnection(ChequePostFechado chequepostfechado) throws Exception {

		if(!chequepostfechado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveChequePostFechadoRelacionesBase(chequepostfechado,true);
		}
	}

	public void saveChequePostFechadoRelaciones(ChequePostFechado chequepostfechado)throws Exception {

		if(!chequepostfechado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveChequePostFechadoRelacionesBase(chequepostfechado,false);
		}
	}

	public void saveChequePostFechadoRelacionesBase(ChequePostFechado chequepostfechado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ChequePostFechado-saveRelacionesWithConnection");}
	

			this.setChequePostFechado(chequepostfechado);

			if(ChequePostFechadoLogicAdditional.validarSaveRelaciones(chequepostfechado,this)) {

				ChequePostFechadoLogicAdditional.updateRelacionesToSave(chequepostfechado,this);

				if((chequepostfechado.getIsNew()||chequepostfechado.getIsChanged())&&!chequepostfechado.getIsDeleted()) {
					this.saveChequePostFechado();
					this.saveChequePostFechadoRelacionesDetalles();

				} else if(chequepostfechado.getIsDeleted()) {
					this.saveChequePostFechadoRelacionesDetalles();
					this.saveChequePostFechado();
				}

				ChequePostFechadoLogicAdditional.updateRelacionesToSaveAfter(chequepostfechado,this);

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
	
	
	private void saveChequePostFechadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfChequePostFechado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ChequePostFechadoConstantesFunciones.getClassesForeignKeysOfChequePostFechado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfChequePostFechado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ChequePostFechadoConstantesFunciones.getClassesRelationshipsOfChequePostFechado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
