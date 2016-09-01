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
import com.bydan.erp.inventario.util.CentroCostoValorConstantesFunciones;
import com.bydan.erp.inventario.util.CentroCostoValorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CentroCostoValorParameterGeneral;
import com.bydan.erp.inventario.business.entity.CentroCostoValor;
import com.bydan.erp.inventario.business.logic.CentroCostoValorLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CentroCostoValorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CentroCostoValorLogic.class);
	
	protected CentroCostoValorDataAccess centrocostovalorDataAccess; 	
	protected CentroCostoValor centrocostovalor;
	protected List<CentroCostoValor> centrocostovalors;
	protected Object centrocostovalorObject;	
	protected List<Object> centrocostovalorsObject;
	
	public static ClassValidator<CentroCostoValor> centrocostovalorValidator = new ClassValidator<CentroCostoValor>(CentroCostoValor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CentroCostoValorLogicAdditional centrocostovalorLogicAdditional=null;
	
	public CentroCostoValorLogicAdditional getCentroCostoValorLogicAdditional() {
		return this.centrocostovalorLogicAdditional;
	}
	
	public void setCentroCostoValorLogicAdditional(CentroCostoValorLogicAdditional centrocostovalorLogicAdditional) {
		try {
			this.centrocostovalorLogicAdditional=centrocostovalorLogicAdditional;
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
	
	
	
	
	public  CentroCostoValorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.centrocostovalorDataAccess = new CentroCostoValorDataAccess();
			
			this.centrocostovalors= new ArrayList<CentroCostoValor>();
			this.centrocostovalor= new CentroCostoValor();
			
			this.centrocostovalorObject=new Object();
			this.centrocostovalorsObject=new ArrayList<Object>();
				
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
			
			this.centrocostovalorDataAccess.setConnexionType(this.connexionType);
			this.centrocostovalorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CentroCostoValorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.centrocostovalorDataAccess = new CentroCostoValorDataAccess();
			this.centrocostovalors= new ArrayList<CentroCostoValor>();
			this.centrocostovalor= new CentroCostoValor();
			this.centrocostovalorObject=new Object();
			this.centrocostovalorsObject=new ArrayList<Object>();
			
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
			
			this.centrocostovalorDataAccess.setConnexionType(this.connexionType);
			this.centrocostovalorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CentroCostoValor getCentroCostoValor() throws Exception {	
		CentroCostoValorLogicAdditional.checkCentroCostoValorToGet(centrocostovalor,this.datosCliente,this.arrDatoGeneral);
		CentroCostoValorLogicAdditional.updateCentroCostoValorToGet(centrocostovalor,this.arrDatoGeneral);
		
		return centrocostovalor;
	}
		
	public void setCentroCostoValor(CentroCostoValor newCentroCostoValor) {
		this.centrocostovalor = newCentroCostoValor;
	}
	
	public CentroCostoValorDataAccess getCentroCostoValorDataAccess() {
		return centrocostovalorDataAccess;
	}
	
	public void setCentroCostoValorDataAccess(CentroCostoValorDataAccess newcentrocostovalorDataAccess) {
		this.centrocostovalorDataAccess = newcentrocostovalorDataAccess;
	}
	
	public List<CentroCostoValor> getCentroCostoValors() throws Exception {		
		this.quitarCentroCostoValorsNulos();
		
		CentroCostoValorLogicAdditional.checkCentroCostoValorToGets(centrocostovalors,this.datosCliente,this.arrDatoGeneral);
		
		for (CentroCostoValor centrocostovalorLocal: centrocostovalors ) {
			CentroCostoValorLogicAdditional.updateCentroCostoValorToGet(centrocostovalorLocal,this.arrDatoGeneral);
		}
		
		return centrocostovalors;
	}
	
	public void setCentroCostoValors(List<CentroCostoValor> newCentroCostoValors) {
		this.centrocostovalors = newCentroCostoValors;
	}
	
	public Object getCentroCostoValorObject() {	
		this.centrocostovalorObject=this.centrocostovalorDataAccess.getEntityObject();
		return this.centrocostovalorObject;
	}
		
	public void setCentroCostoValorObject(Object newCentroCostoValorObject) {
		this.centrocostovalorObject = newCentroCostoValorObject;
	}
	
	public List<Object> getCentroCostoValorsObject() {		
		this.centrocostovalorsObject=this.centrocostovalorDataAccess.getEntitiesObject();
		return this.centrocostovalorsObject;
	}
		
	public void setCentroCostoValorsObject(List<Object> newCentroCostoValorsObject) {
		this.centrocostovalorsObject = newCentroCostoValorsObject;
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
		
		if(this.centrocostovalorDataAccess!=null) {
			this.centrocostovalorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			centrocostovalorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			centrocostovalorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		centrocostovalor = new  CentroCostoValor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			centrocostovalor=centrocostovalorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostovalor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalor);
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
		centrocostovalor = new  CentroCostoValor();
		  		  
        try {
			
			centrocostovalor=centrocostovalorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostovalor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		centrocostovalor = new  CentroCostoValor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			centrocostovalor=centrocostovalorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostovalor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalor);
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
		centrocostovalor = new  CentroCostoValor();
		  		  
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
		centrocostovalor = new  CentroCostoValor();
		  		  
        try {
			
			centrocostovalor=centrocostovalorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centrocostovalor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		centrocostovalor = new  CentroCostoValor();
		  		  
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
		centrocostovalor = new  CentroCostoValor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =centrocostovalorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centrocostovalor = new  CentroCostoValor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=centrocostovalorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		centrocostovalor = new  CentroCostoValor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =centrocostovalorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centrocostovalor = new  CentroCostoValor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=centrocostovalorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		centrocostovalor = new  CentroCostoValor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =centrocostovalorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centrocostovalor = new  CentroCostoValor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=centrocostovalorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
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
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
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
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
        try {			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
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
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
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
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
        try {
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
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
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
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
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		centrocostovalor = new  CentroCostoValor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalor=centrocostovalorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalor);
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
		centrocostovalor = new  CentroCostoValor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalor=centrocostovalorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
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
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		  		  
        try {
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCentroCostoValorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getTodosCentroCostoValorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
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
	
	public  void  getTodosCentroCostoValors(String sFinalQuery,Pagination pagination)throws Exception {
		centrocostovalors = new  ArrayList<CentroCostoValor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCentroCostoValor(centrocostovalors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCentroCostoValor(CentroCostoValor centrocostovalor) throws Exception {
		Boolean estaValidado=false;
		
		if(centrocostovalor.getIsNew() || centrocostovalor.getIsChanged()) { 
			this.invalidValues = centrocostovalorValidator.getInvalidValues(centrocostovalor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(centrocostovalor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCentroCostoValor(List<CentroCostoValor> CentroCostoValors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CentroCostoValor centrocostovalorLocal:centrocostovalors) {				
			estaValidadoObjeto=this.validarGuardarCentroCostoValor(centrocostovalorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCentroCostoValor(List<CentroCostoValor> CentroCostoValors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCentroCostoValor(centrocostovalors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCentroCostoValor(CentroCostoValor CentroCostoValor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCentroCostoValor(centrocostovalor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CentroCostoValor centrocostovalor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+centrocostovalor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CentroCostoValorConstantesFunciones.getCentroCostoValorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"centrocostovalor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CentroCostoValorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CentroCostoValorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCentroCostoValorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-saveCentroCostoValorWithConnection");connexion.begin();			
			
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSave(this.centrocostovalor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CentroCostoValorLogicAdditional.updateCentroCostoValorToSave(this.centrocostovalor,this.arrDatoGeneral);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.centrocostovalor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCentroCostoValor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCentroCostoValor(this.centrocostovalor)) {
				CentroCostoValorDataAccess.save(this.centrocostovalor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.centrocostovalor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSaveAfter(this.centrocostovalor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCentroCostoValor();
			
			connexion.commit();			
			
			if(this.centrocostovalor.getIsDeleted()) {
				this.centrocostovalor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCentroCostoValor()throws Exception {	
		try {	
			
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSave(this.centrocostovalor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CentroCostoValorLogicAdditional.updateCentroCostoValorToSave(this.centrocostovalor,this.arrDatoGeneral);
			
			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.centrocostovalor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCentroCostoValor(this.centrocostovalor)) {			
				CentroCostoValorDataAccess.save(this.centrocostovalor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.centrocostovalor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSaveAfter(this.centrocostovalor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.centrocostovalor.getIsDeleted()) {
				this.centrocostovalor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCentroCostoValorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-saveCentroCostoValorsWithConnection");connexion.begin();			
			
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSaves(centrocostovalors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCentroCostoValors();
			
			Boolean validadoTodosCentroCostoValor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CentroCostoValor centrocostovalorLocal:centrocostovalors) {		
				if(centrocostovalorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CentroCostoValorLogicAdditional.updateCentroCostoValorToSave(centrocostovalorLocal,this.arrDatoGeneral);
	        	
				CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),centrocostovalorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCentroCostoValor(centrocostovalorLocal)) {
					CentroCostoValorDataAccess.save(centrocostovalorLocal, connexion);				
				} else {
					validadoTodosCentroCostoValor=false;
				}
			}
			
			if(!validadoTodosCentroCostoValor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSavesAfter(centrocostovalors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCentroCostoValors();
			
			connexion.commit();		
			
			this.quitarCentroCostoValorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCentroCostoValors()throws Exception {				
		 try {	
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSaves(centrocostovalors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCentroCostoValor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CentroCostoValor centrocostovalorLocal:centrocostovalors) {				
				if(centrocostovalorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CentroCostoValorLogicAdditional.updateCentroCostoValorToSave(centrocostovalorLocal,this.arrDatoGeneral);
	        	
				CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),centrocostovalorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCentroCostoValor(centrocostovalorLocal)) {				
					CentroCostoValorDataAccess.save(centrocostovalorLocal, connexion);				
				} else {
					validadoTodosCentroCostoValor=false;
				}
			}
			
			if(!validadoTodosCentroCostoValor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CentroCostoValorLogicAdditional.checkCentroCostoValorToSavesAfter(centrocostovalors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCentroCostoValorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CentroCostoValorParameterReturnGeneral procesarAccionCentroCostoValors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CentroCostoValor> centrocostovalors,CentroCostoValorParameterReturnGeneral centrocostovalorParameterGeneral)throws Exception {
		 try {	
			CentroCostoValorParameterReturnGeneral centrocostovalorReturnGeneral=new CentroCostoValorParameterReturnGeneral();
	
			CentroCostoValorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,centrocostovalors,centrocostovalorParameterGeneral,centrocostovalorReturnGeneral);
			
			return centrocostovalorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CentroCostoValorParameterReturnGeneral procesarAccionCentroCostoValorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CentroCostoValor> centrocostovalors,CentroCostoValorParameterReturnGeneral centrocostovalorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-procesarAccionCentroCostoValorsWithConnection");connexion.begin();			
			
			CentroCostoValorParameterReturnGeneral centrocostovalorReturnGeneral=new CentroCostoValorParameterReturnGeneral();
	
			CentroCostoValorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,centrocostovalors,centrocostovalorParameterGeneral,centrocostovalorReturnGeneral);
			
			this.connexion.commit();
			
			return centrocostovalorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CentroCostoValorParameterReturnGeneral procesarEventosCentroCostoValors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CentroCostoValor> centrocostovalors,CentroCostoValor centrocostovalor,CentroCostoValorParameterReturnGeneral centrocostovalorParameterGeneral,Boolean isEsNuevoCentroCostoValor,ArrayList<Classe> clases)throws Exception {
		 try {	
			CentroCostoValorParameterReturnGeneral centrocostovalorReturnGeneral=new CentroCostoValorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				centrocostovalorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CentroCostoValorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,centrocostovalors,centrocostovalor,centrocostovalorParameterGeneral,centrocostovalorReturnGeneral,isEsNuevoCentroCostoValor,clases);
			
			return centrocostovalorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CentroCostoValorParameterReturnGeneral procesarEventosCentroCostoValorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CentroCostoValor> centrocostovalors,CentroCostoValor centrocostovalor,CentroCostoValorParameterReturnGeneral centrocostovalorParameterGeneral,Boolean isEsNuevoCentroCostoValor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-procesarEventosCentroCostoValorsWithConnection");connexion.begin();			
			
			CentroCostoValorParameterReturnGeneral centrocostovalorReturnGeneral=new CentroCostoValorParameterReturnGeneral();
	
			centrocostovalorReturnGeneral.setCentroCostoValor(centrocostovalor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				centrocostovalorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CentroCostoValorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,centrocostovalors,centrocostovalor,centrocostovalorParameterGeneral,centrocostovalorReturnGeneral,isEsNuevoCentroCostoValor,clases);
			
			this.connexion.commit();
			
			return centrocostovalorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CentroCostoValorParameterReturnGeneral procesarImportacionCentroCostoValorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CentroCostoValorParameterReturnGeneral centrocostovalorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-procesarImportacionCentroCostoValorsWithConnection");connexion.begin();			
			
			CentroCostoValorParameterReturnGeneral centrocostovalorReturnGeneral=new CentroCostoValorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.centrocostovalors=new ArrayList<CentroCostoValor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.centrocostovalor=new CentroCostoValor();
				
				
				if(conColumnasBase) {this.centrocostovalor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.centrocostovalor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.centrocostovalor.setnombre(arrColumnas[iColumn++]);
				this.centrocostovalor.setenero(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setfebrero(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setmarzo(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setabril(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setmayo(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setjunio(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setjulio(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setagosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setseptiembre(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setoctubre(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setnoviembre(Double.parseDouble(arrColumnas[iColumn++]));
				this.centrocostovalor.setdiciembre(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.centrocostovalors.add(this.centrocostovalor);
			}
			
			this.saveCentroCostoValors();
			
			this.connexion.commit();
			
			centrocostovalorReturnGeneral.setConRetornoEstaProcesado(true);
			centrocostovalorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return centrocostovalorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCentroCostoValorsEliminados() throws Exception {				
		
		List<CentroCostoValor> centrocostovalorsAux= new ArrayList<CentroCostoValor>();
		
		for(CentroCostoValor centrocostovalor:centrocostovalors) {
			if(!centrocostovalor.getIsDeleted()) {
				centrocostovalorsAux.add(centrocostovalor);
			}
		}
		
		centrocostovalors=centrocostovalorsAux;
	}
	
	public void quitarCentroCostoValorsNulos() throws Exception {				
		
		List<CentroCostoValor> centrocostovalorsAux= new ArrayList<CentroCostoValor>();
		
		for(CentroCostoValor centrocostovalor : this.centrocostovalors) {
			if(centrocostovalor==null) {
				centrocostovalorsAux.add(centrocostovalor);
			}
		}
		
		//this.centrocostovalors=centrocostovalorsAux;
		
		this.centrocostovalors.removeAll(centrocostovalorsAux);
	}
	
	public void getSetVersionRowCentroCostoValorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(centrocostovalor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((centrocostovalor.getIsDeleted() || (centrocostovalor.getIsChanged()&&!centrocostovalor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=centrocostovalorDataAccess.getSetVersionRowCentroCostoValor(connexion,centrocostovalor.getId());
				
				if(!centrocostovalor.getVersionRow().equals(timestamp)) {	
					centrocostovalor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				centrocostovalor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCentroCostoValor()throws Exception {	
		
		if(centrocostovalor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((centrocostovalor.getIsDeleted() || (centrocostovalor.getIsChanged()&&!centrocostovalor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=centrocostovalorDataAccess.getSetVersionRowCentroCostoValor(connexion,centrocostovalor.getId());
			
			try {							
				if(!centrocostovalor.getVersionRow().equals(timestamp)) {	
					centrocostovalor.setVersionRow(timestamp);
				}
				
				centrocostovalor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCentroCostoValorsWithConnection()throws Exception {	
		if(centrocostovalors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CentroCostoValor centrocostovalorAux:centrocostovalors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(centrocostovalorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(centrocostovalorAux.getIsDeleted() || (centrocostovalorAux.getIsChanged()&&!centrocostovalorAux.getIsNew())) {
						
						timestamp=centrocostovalorDataAccess.getSetVersionRowCentroCostoValor(connexion,centrocostovalorAux.getId());
						
						if(!centrocostovalor.getVersionRow().equals(timestamp)) {	
							centrocostovalorAux.setVersionRow(timestamp);
						}
								
						centrocostovalorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCentroCostoValors()throws Exception {	
		if(centrocostovalors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CentroCostoValor centrocostovalorAux:centrocostovalors) {
					if(centrocostovalorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(centrocostovalorAux.getIsDeleted() || (centrocostovalorAux.getIsChanged()&&!centrocostovalorAux.getIsNew())) {
						
						timestamp=centrocostovalorDataAccess.getSetVersionRowCentroCostoValor(connexion,centrocostovalorAux.getId());
						
						if(!centrocostovalorAux.getVersionRow().equals(timestamp)) {	
							centrocostovalorAux.setVersionRow(timestamp);
						}
						
													
						centrocostovalorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CentroCostoValorParameterReturnGeneral cargarCombosLoteForeignKeyCentroCostoValorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalCentroCosto) throws Exception {
		CentroCostoValorParameterReturnGeneral  centrocostovalorReturnGeneral =new CentroCostoValorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-cargarCombosLoteForeignKeyCentroCostoValorWithConnection");connexion.begin();
			
			centrocostovalorReturnGeneral =new CentroCostoValorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			centrocostovalorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			centrocostovalorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			centrocostovalorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			centrocostovalorReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return centrocostovalorReturnGeneral;
	}
	
	public CentroCostoValorParameterReturnGeneral cargarCombosLoteForeignKeyCentroCostoValor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalCentroCosto) throws Exception {
		CentroCostoValorParameterReturnGeneral  centrocostovalorReturnGeneral =new CentroCostoValorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			centrocostovalorReturnGeneral =new CentroCostoValorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			centrocostovalorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			centrocostovalorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			centrocostovalorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			centrocostovalorReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return centrocostovalorReturnGeneral;
	}
	
	
	public void deepLoad(CentroCostoValor centrocostovalor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CentroCostoValorLogicAdditional.updateCentroCostoValorToGet(centrocostovalor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		centrocostovalor.setEmpresa(centrocostovalorDataAccess.getEmpresa(connexion,centrocostovalor));
		centrocostovalor.setSucursal(centrocostovalorDataAccess.getSucursal(connexion,centrocostovalor));
		centrocostovalor.setEjercicio(centrocostovalorDataAccess.getEjercicio(connexion,centrocostovalor));
		centrocostovalor.setCentroCosto(centrocostovalorDataAccess.getCentroCosto(connexion,centrocostovalor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				centrocostovalor.setEmpresa(centrocostovalorDataAccess.getEmpresa(connexion,centrocostovalor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				centrocostovalor.setSucursal(centrocostovalorDataAccess.getSucursal(connexion,centrocostovalor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				centrocostovalor.setEjercicio(centrocostovalorDataAccess.getEjercicio(connexion,centrocostovalor));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				centrocostovalor.setCentroCosto(centrocostovalorDataAccess.getCentroCosto(connexion,centrocostovalor));
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
			centrocostovalor.setEmpresa(centrocostovalorDataAccess.getEmpresa(connexion,centrocostovalor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostovalor.setSucursal(centrocostovalorDataAccess.getSucursal(connexion,centrocostovalor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostovalor.setEjercicio(centrocostovalorDataAccess.getEjercicio(connexion,centrocostovalor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostovalor.setCentroCosto(centrocostovalorDataAccess.getCentroCosto(connexion,centrocostovalor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		centrocostovalor.setEmpresa(centrocostovalorDataAccess.getEmpresa(connexion,centrocostovalor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(centrocostovalor.getEmpresa(),isDeep,deepLoadType,clases);
				
		centrocostovalor.setSucursal(centrocostovalorDataAccess.getSucursal(connexion,centrocostovalor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(centrocostovalor.getSucursal(),isDeep,deepLoadType,clases);
				
		centrocostovalor.setEjercicio(centrocostovalorDataAccess.getEjercicio(connexion,centrocostovalor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(centrocostovalor.getEjercicio(),isDeep,deepLoadType,clases);
				
		centrocostovalor.setCentroCosto(centrocostovalorDataAccess.getCentroCosto(connexion,centrocostovalor));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(centrocostovalor.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				centrocostovalor.setEmpresa(centrocostovalorDataAccess.getEmpresa(connexion,centrocostovalor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(centrocostovalor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				centrocostovalor.setSucursal(centrocostovalorDataAccess.getSucursal(connexion,centrocostovalor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(centrocostovalor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				centrocostovalor.setEjercicio(centrocostovalorDataAccess.getEjercicio(connexion,centrocostovalor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(centrocostovalor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				centrocostovalor.setCentroCosto(centrocostovalorDataAccess.getCentroCosto(connexion,centrocostovalor));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(centrocostovalor.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			centrocostovalor.setEmpresa(centrocostovalorDataAccess.getEmpresa(connexion,centrocostovalor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(centrocostovalor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostovalor.setSucursal(centrocostovalorDataAccess.getSucursal(connexion,centrocostovalor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(centrocostovalor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostovalor.setEjercicio(centrocostovalorDataAccess.getEjercicio(connexion,centrocostovalor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(centrocostovalor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centrocostovalor.setCentroCosto(centrocostovalorDataAccess.getCentroCosto(connexion,centrocostovalor));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(centrocostovalor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CentroCostoValor centrocostovalor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CentroCostoValorLogicAdditional.updateCentroCostoValorToSave(centrocostovalor,this.arrDatoGeneral);
			
CentroCostoValorDataAccess.save(centrocostovalor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(centrocostovalor.getEmpresa(),connexion);

		SucursalDataAccess.save(centrocostovalor.getSucursal(),connexion);

		EjercicioDataAccess.save(centrocostovalor.getEjercicio(),connexion);

		CentroCostoDataAccess.save(centrocostovalor.getCentroCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(centrocostovalor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(centrocostovalor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(centrocostovalor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(centrocostovalor.getCentroCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(centrocostovalor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(centrocostovalor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(centrocostovalor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(centrocostovalor.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(centrocostovalor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(centrocostovalor.getEjercicio(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(centrocostovalor.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(centrocostovalor.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(centrocostovalor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(centrocostovalor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(centrocostovalor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(centrocostovalor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(centrocostovalor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(centrocostovalor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(centrocostovalor.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(centrocostovalor.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CentroCostoValor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(centrocostovalor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(centrocostovalor);
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
			this.deepLoad(this.centrocostovalor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CentroCostoValor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(centrocostovalors!=null) {
				for(CentroCostoValor centrocostovalor:centrocostovalors) {
					this.deepLoad(centrocostovalor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(centrocostovalors);
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
			if(centrocostovalors!=null) {
				for(CentroCostoValor centrocostovalor:centrocostovalors) {
					this.deepLoad(centrocostovalor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(centrocostovalors);
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
			this.getNewConnexionToDeep(CentroCostoValor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(centrocostovalor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CentroCostoValor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(centrocostovalors!=null) {
				for(CentroCostoValor centrocostovalor:centrocostovalors) {
					this.deepSave(centrocostovalor,isDeep,deepLoadType,clases);
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
			if(centrocostovalors!=null) {
				for(CentroCostoValor centrocostovalor:centrocostovalors) {
					this.deepSave(centrocostovalor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCentroCostoValorsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CentroCostoValorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoValorsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CentroCostoValorConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoValorsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CentroCostoValorConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoValorsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CentroCostoValorConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoValorsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CentroCostoValorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoValorsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CentroCostoValorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoValorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CentroCostoValorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoValorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CentroCostoValorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroCostoValorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroCostoValor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CentroCostoValorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroCostoValorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CentroCostoValorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CentroCostoValorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroCostoValorConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoValor(this.centrocostovalors);
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
			if(CentroCostoValorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoValorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CentroCostoValor centrocostovalor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CentroCostoValorConstantesFunciones.ISCONAUDITORIA) {
				if(centrocostovalor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoValorDataAccess.TABLENAME, centrocostovalor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CentroCostoValorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CentroCostoValorLogic.registrarAuditoriaDetallesCentroCostoValor(connexion,centrocostovalor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(centrocostovalor.getIsDeleted()) {
					/*if(!centrocostovalor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CentroCostoValorDataAccess.TABLENAME, centrocostovalor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CentroCostoValorLogic.registrarAuditoriaDetallesCentroCostoValor(connexion,centrocostovalor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoValorDataAccess.TABLENAME, centrocostovalor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(centrocostovalor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroCostoValorDataAccess.TABLENAME, centrocostovalor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CentroCostoValorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CentroCostoValorLogic.registrarAuditoriaDetallesCentroCostoValor(connexion,centrocostovalor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCentroCostoValor(Connexion connexion,CentroCostoValor centrocostovalor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getid_empresa().equals(centrocostovalor.getCentroCostoValorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getid_empresa()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getid_empresa().toString();
				}
				if(centrocostovalor.getid_empresa()!=null)
				{
					strValorNuevo=centrocostovalor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getid_sucursal().equals(centrocostovalor.getCentroCostoValorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getid_sucursal()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getid_sucursal().toString();
				}
				if(centrocostovalor.getid_sucursal()!=null)
				{
					strValorNuevo=centrocostovalor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getid_ejercicio().equals(centrocostovalor.getCentroCostoValorOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getid_ejercicio()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getid_ejercicio().toString();
				}
				if(centrocostovalor.getid_ejercicio()!=null)
				{
					strValorNuevo=centrocostovalor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getid_centro_costo().equals(centrocostovalor.getCentroCostoValorOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getid_centro_costo()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getid_centro_costo().toString();
				}
				if(centrocostovalor.getid_centro_costo()!=null)
				{
					strValorNuevo=centrocostovalor.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getnombre().equals(centrocostovalor.getCentroCostoValorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getnombre()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getnombre();
				}
				if(centrocostovalor.getnombre()!=null)
				{
					strValorNuevo=centrocostovalor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getenero().equals(centrocostovalor.getCentroCostoValorOriginal().getenero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getenero()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getenero().toString();
				}
				if(centrocostovalor.getenero()!=null)
				{
					strValorNuevo=centrocostovalor.getenero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.ENERO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getfebrero().equals(centrocostovalor.getCentroCostoValorOriginal().getfebrero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getfebrero()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getfebrero().toString();
				}
				if(centrocostovalor.getfebrero()!=null)
				{
					strValorNuevo=centrocostovalor.getfebrero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.FEBRERO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getmarzo().equals(centrocostovalor.getCentroCostoValorOriginal().getmarzo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getmarzo()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getmarzo().toString();
				}
				if(centrocostovalor.getmarzo()!=null)
				{
					strValorNuevo=centrocostovalor.getmarzo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.MARZO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getabril().equals(centrocostovalor.getCentroCostoValorOriginal().getabril()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getabril()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getabril().toString();
				}
				if(centrocostovalor.getabril()!=null)
				{
					strValorNuevo=centrocostovalor.getabril().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.ABRIL,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getmayo().equals(centrocostovalor.getCentroCostoValorOriginal().getmayo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getmayo()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getmayo().toString();
				}
				if(centrocostovalor.getmayo()!=null)
				{
					strValorNuevo=centrocostovalor.getmayo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.MAYO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getjunio().equals(centrocostovalor.getCentroCostoValorOriginal().getjunio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getjunio()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getjunio().toString();
				}
				if(centrocostovalor.getjunio()!=null)
				{
					strValorNuevo=centrocostovalor.getjunio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.JUNIO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getjulio().equals(centrocostovalor.getCentroCostoValorOriginal().getjulio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getjulio()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getjulio().toString();
				}
				if(centrocostovalor.getjulio()!=null)
				{
					strValorNuevo=centrocostovalor.getjulio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.JULIO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getagosto().equals(centrocostovalor.getCentroCostoValorOriginal().getagosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getagosto()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getagosto().toString();
				}
				if(centrocostovalor.getagosto()!=null)
				{
					strValorNuevo=centrocostovalor.getagosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.AGOSTO,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getseptiembre().equals(centrocostovalor.getCentroCostoValorOriginal().getseptiembre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getseptiembre()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getseptiembre().toString();
				}
				if(centrocostovalor.getseptiembre()!=null)
				{
					strValorNuevo=centrocostovalor.getseptiembre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.SEPTIEMBRE,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getoctubre().equals(centrocostovalor.getCentroCostoValorOriginal().getoctubre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getoctubre()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getoctubre().toString();
				}
				if(centrocostovalor.getoctubre()!=null)
				{
					strValorNuevo=centrocostovalor.getoctubre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.OCTUBRE,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getnoviembre().equals(centrocostovalor.getCentroCostoValorOriginal().getnoviembre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getnoviembre()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getnoviembre().toString();
				}
				if(centrocostovalor.getnoviembre()!=null)
				{
					strValorNuevo=centrocostovalor.getnoviembre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.NOVIEMBRE,strValorActual,strValorNuevo);
			}	
			
			if(centrocostovalor.getIsNew()||!centrocostovalor.getdiciembre().equals(centrocostovalor.getCentroCostoValorOriginal().getdiciembre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centrocostovalor.getCentroCostoValorOriginal().getdiciembre()!=null)
				{
					strValorActual=centrocostovalor.getCentroCostoValorOriginal().getdiciembre().toString();
				}
				if(centrocostovalor.getdiciembre()!=null)
				{
					strValorNuevo=centrocostovalor.getdiciembre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroCostoValorConstantesFunciones.DICIEMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCentroCostoValorRelacionesWithConnection(CentroCostoValor centrocostovalor) throws Exception {

		if(!centrocostovalor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCentroCostoValorRelacionesBase(centrocostovalor,true);
		}
	}

	public void saveCentroCostoValorRelaciones(CentroCostoValor centrocostovalor)throws Exception {

		if(!centrocostovalor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCentroCostoValorRelacionesBase(centrocostovalor,false);
		}
	}

	public void saveCentroCostoValorRelacionesBase(CentroCostoValor centrocostovalor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CentroCostoValor-saveRelacionesWithConnection");}
	

			this.setCentroCostoValor(centrocostovalor);

			if(CentroCostoValorLogicAdditional.validarSaveRelaciones(centrocostovalor,this)) {

				CentroCostoValorLogicAdditional.updateRelacionesToSave(centrocostovalor,this);

				if((centrocostovalor.getIsNew()||centrocostovalor.getIsChanged())&&!centrocostovalor.getIsDeleted()) {
					this.saveCentroCostoValor();
					this.saveCentroCostoValorRelacionesDetalles();

				} else if(centrocostovalor.getIsDeleted()) {
					this.saveCentroCostoValorRelacionesDetalles();
					this.saveCentroCostoValor();
				}

				CentroCostoValorLogicAdditional.updateRelacionesToSaveAfter(centrocostovalor,this);

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
	
	
	private void saveCentroCostoValorRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCentroCostoValor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CentroCostoValorConstantesFunciones.getClassesForeignKeysOfCentroCostoValor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoValor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CentroCostoValorConstantesFunciones.getClassesRelationshipsOfCentroCostoValor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
