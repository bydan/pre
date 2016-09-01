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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.FacturaImpresionConstantesFunciones;
import com.bydan.erp.facturacion.util.FacturaImpresionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.FacturaImpresionParameterGeneral;
import com.bydan.erp.facturacion.business.entity.FacturaImpresion;
import com.bydan.erp.facturacion.business.logic.FacturaImpresionLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FacturaImpresionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FacturaImpresionLogic.class);
	
	protected FacturaImpresionDataAccess facturaimpresionDataAccess; 	
	protected FacturaImpresion facturaimpresion;
	protected List<FacturaImpresion> facturaimpresions;
	protected Object facturaimpresionObject;	
	protected List<Object> facturaimpresionsObject;
	
	public static ClassValidator<FacturaImpresion> facturaimpresionValidator = new ClassValidator<FacturaImpresion>(FacturaImpresion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FacturaImpresionLogicAdditional facturaimpresionLogicAdditional=null;
	
	public FacturaImpresionLogicAdditional getFacturaImpresionLogicAdditional() {
		return this.facturaimpresionLogicAdditional;
	}
	
	public void setFacturaImpresionLogicAdditional(FacturaImpresionLogicAdditional facturaimpresionLogicAdditional) {
		try {
			this.facturaimpresionLogicAdditional=facturaimpresionLogicAdditional;
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
	
	
	
	
	public  FacturaImpresionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.facturaimpresionDataAccess = new FacturaImpresionDataAccess();
			
			this.facturaimpresions= new ArrayList<FacturaImpresion>();
			this.facturaimpresion= new FacturaImpresion();
			
			this.facturaimpresionObject=new Object();
			this.facturaimpresionsObject=new ArrayList<Object>();
				
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
			
			this.facturaimpresionDataAccess.setConnexionType(this.connexionType);
			this.facturaimpresionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturaImpresionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.facturaimpresionDataAccess = new FacturaImpresionDataAccess();
			this.facturaimpresions= new ArrayList<FacturaImpresion>();
			this.facturaimpresion= new FacturaImpresion();
			this.facturaimpresionObject=new Object();
			this.facturaimpresionsObject=new ArrayList<Object>();
			
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
			
			this.facturaimpresionDataAccess.setConnexionType(this.connexionType);
			this.facturaimpresionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturaImpresion getFacturaImpresion() throws Exception {	
		FacturaImpresionLogicAdditional.checkFacturaImpresionToGet(facturaimpresion,this.datosCliente,this.arrDatoGeneral);
		FacturaImpresionLogicAdditional.updateFacturaImpresionToGet(facturaimpresion,this.arrDatoGeneral);
		
		return facturaimpresion;
	}
		
	public void setFacturaImpresion(FacturaImpresion newFacturaImpresion) {
		this.facturaimpresion = newFacturaImpresion;
	}
	
	public FacturaImpresionDataAccess getFacturaImpresionDataAccess() {
		return facturaimpresionDataAccess;
	}
	
	public void setFacturaImpresionDataAccess(FacturaImpresionDataAccess newfacturaimpresionDataAccess) {
		this.facturaimpresionDataAccess = newfacturaimpresionDataAccess;
	}
	
	public List<FacturaImpresion> getFacturaImpresions() throws Exception {		
		this.quitarFacturaImpresionsNulos();
		
		FacturaImpresionLogicAdditional.checkFacturaImpresionToGets(facturaimpresions,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturaImpresion facturaimpresionLocal: facturaimpresions ) {
			FacturaImpresionLogicAdditional.updateFacturaImpresionToGet(facturaimpresionLocal,this.arrDatoGeneral);
		}
		
		return facturaimpresions;
	}
	
	public void setFacturaImpresions(List<FacturaImpresion> newFacturaImpresions) {
		this.facturaimpresions = newFacturaImpresions;
	}
	
	public Object getFacturaImpresionObject() {	
		this.facturaimpresionObject=this.facturaimpresionDataAccess.getEntityObject();
		return this.facturaimpresionObject;
	}
		
	public void setFacturaImpresionObject(Object newFacturaImpresionObject) {
		this.facturaimpresionObject = newFacturaImpresionObject;
	}
	
	public List<Object> getFacturaImpresionsObject() {		
		this.facturaimpresionsObject=this.facturaimpresionDataAccess.getEntitiesObject();
		return this.facturaimpresionsObject;
	}
		
	public void setFacturaImpresionsObject(List<Object> newFacturaImpresionsObject) {
		this.facturaimpresionsObject = newFacturaImpresionsObject;
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
		
		if(this.facturaimpresionDataAccess!=null) {
			this.facturaimpresionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			facturaimpresionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			facturaimpresionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		facturaimpresion = new  FacturaImpresion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturaimpresion=facturaimpresionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaimpresion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresion);
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
		facturaimpresion = new  FacturaImpresion();
		  		  
        try {
			
			facturaimpresion=facturaimpresionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaimpresion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		facturaimpresion = new  FacturaImpresion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturaimpresion=facturaimpresionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaimpresion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresion);
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
		facturaimpresion = new  FacturaImpresion();
		  		  
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
		facturaimpresion = new  FacturaImpresion();
		  		  
        try {
			
			facturaimpresion=facturaimpresionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaimpresion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		facturaimpresion = new  FacturaImpresion();
		  		  
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
		facturaimpresion = new  FacturaImpresion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =facturaimpresionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaimpresion = new  FacturaImpresion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=facturaimpresionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturaimpresion = new  FacturaImpresion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =facturaimpresionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaimpresion = new  FacturaImpresion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=facturaimpresionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturaimpresion = new  FacturaImpresion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =facturaimpresionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaimpresion = new  FacturaImpresion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=facturaimpresionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
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
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
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
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
        try {			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
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
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
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
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
        try {
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
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
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
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
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		facturaimpresion = new  FacturaImpresion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresion=facturaimpresionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresion);
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
		facturaimpresion = new  FacturaImpresion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresion=facturaimpresionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
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
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		  		  
        try {
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFacturaImpresionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getTodosFacturaImpresionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
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
	
	public  void  getTodosFacturaImpresions(String sFinalQuery,Pagination pagination)throws Exception {
		facturaimpresions = new  ArrayList<FacturaImpresion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaImpresion(facturaimpresions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFacturaImpresion(FacturaImpresion facturaimpresion) throws Exception {
		Boolean estaValidado=false;
		
		if(facturaimpresion.getIsNew() || facturaimpresion.getIsChanged()) { 
			this.invalidValues = facturaimpresionValidator.getInvalidValues(facturaimpresion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(facturaimpresion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFacturaImpresion(List<FacturaImpresion> FacturaImpresions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FacturaImpresion facturaimpresionLocal:facturaimpresions) {				
			estaValidadoObjeto=this.validarGuardarFacturaImpresion(facturaimpresionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFacturaImpresion(List<FacturaImpresion> FacturaImpresions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaImpresion(facturaimpresions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFacturaImpresion(FacturaImpresion FacturaImpresion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaImpresion(facturaimpresion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FacturaImpresion facturaimpresion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+facturaimpresion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FacturaImpresionConstantesFunciones.getFacturaImpresionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"facturaimpresion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FacturaImpresionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FacturaImpresionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFacturaImpresionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-saveFacturaImpresionWithConnection");connexion.begin();			
			
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSave(this.facturaimpresion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaImpresionLogicAdditional.updateFacturaImpresionToSave(this.facturaimpresion,this.arrDatoGeneral);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturaimpresion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFacturaImpresion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaImpresion(this.facturaimpresion)) {
				FacturaImpresionDataAccess.save(this.facturaimpresion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.facturaimpresion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSaveAfter(this.facturaimpresion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaImpresion();
			
			connexion.commit();			
			
			if(this.facturaimpresion.getIsDeleted()) {
				this.facturaimpresion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFacturaImpresion()throws Exception {	
		try {	
			
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSave(this.facturaimpresion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaImpresionLogicAdditional.updateFacturaImpresionToSave(this.facturaimpresion,this.arrDatoGeneral);
			
			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturaimpresion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaImpresion(this.facturaimpresion)) {			
				FacturaImpresionDataAccess.save(this.facturaimpresion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.facturaimpresion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSaveAfter(this.facturaimpresion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.facturaimpresion.getIsDeleted()) {
				this.facturaimpresion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFacturaImpresionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-saveFacturaImpresionsWithConnection");connexion.begin();			
			
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSaves(facturaimpresions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFacturaImpresions();
			
			Boolean validadoTodosFacturaImpresion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaImpresion facturaimpresionLocal:facturaimpresions) {		
				if(facturaimpresionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaImpresionLogicAdditional.updateFacturaImpresionToSave(facturaimpresionLocal,this.arrDatoGeneral);
	        	
				FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaimpresionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaImpresion(facturaimpresionLocal)) {
					FacturaImpresionDataAccess.save(facturaimpresionLocal, connexion);				
				} else {
					validadoTodosFacturaImpresion=false;
				}
			}
			
			if(!validadoTodosFacturaImpresion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSavesAfter(facturaimpresions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaImpresions();
			
			connexion.commit();		
			
			this.quitarFacturaImpresionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFacturaImpresions()throws Exception {				
		 try {	
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSaves(facturaimpresions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFacturaImpresion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaImpresion facturaimpresionLocal:facturaimpresions) {				
				if(facturaimpresionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaImpresionLogicAdditional.updateFacturaImpresionToSave(facturaimpresionLocal,this.arrDatoGeneral);
	        	
				FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaimpresionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaImpresion(facturaimpresionLocal)) {				
					FacturaImpresionDataAccess.save(facturaimpresionLocal, connexion);				
				} else {
					validadoTodosFacturaImpresion=false;
				}
			}
			
			if(!validadoTodosFacturaImpresion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaImpresionLogicAdditional.checkFacturaImpresionToSavesAfter(facturaimpresions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFacturaImpresionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaImpresionParameterReturnGeneral procesarAccionFacturaImpresions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaImpresion> facturaimpresions,FacturaImpresionParameterReturnGeneral facturaimpresionParameterGeneral)throws Exception {
		 try {	
			FacturaImpresionParameterReturnGeneral facturaimpresionReturnGeneral=new FacturaImpresionParameterReturnGeneral();
	
			FacturaImpresionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaimpresions,facturaimpresionParameterGeneral,facturaimpresionReturnGeneral);
			
			return facturaimpresionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaImpresionParameterReturnGeneral procesarAccionFacturaImpresionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaImpresion> facturaimpresions,FacturaImpresionParameterReturnGeneral facturaimpresionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-procesarAccionFacturaImpresionsWithConnection");connexion.begin();			
			
			FacturaImpresionParameterReturnGeneral facturaimpresionReturnGeneral=new FacturaImpresionParameterReturnGeneral();
	
			FacturaImpresionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaimpresions,facturaimpresionParameterGeneral,facturaimpresionReturnGeneral);
			
			this.connexion.commit();
			
			return facturaimpresionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaImpresionParameterReturnGeneral procesarEventosFacturaImpresions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaImpresion> facturaimpresions,FacturaImpresion facturaimpresion,FacturaImpresionParameterReturnGeneral facturaimpresionParameterGeneral,Boolean isEsNuevoFacturaImpresion,ArrayList<Classe> clases)throws Exception {
		 try {	
			FacturaImpresionParameterReturnGeneral facturaimpresionReturnGeneral=new FacturaImpresionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaimpresionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaImpresionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturaimpresions,facturaimpresion,facturaimpresionParameterGeneral,facturaimpresionReturnGeneral,isEsNuevoFacturaImpresion,clases);
			
			return facturaimpresionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FacturaImpresionParameterReturnGeneral procesarEventosFacturaImpresionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaImpresion> facturaimpresions,FacturaImpresion facturaimpresion,FacturaImpresionParameterReturnGeneral facturaimpresionParameterGeneral,Boolean isEsNuevoFacturaImpresion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-procesarEventosFacturaImpresionsWithConnection");connexion.begin();			
			
			FacturaImpresionParameterReturnGeneral facturaimpresionReturnGeneral=new FacturaImpresionParameterReturnGeneral();
	
			facturaimpresionReturnGeneral.setFacturaImpresion(facturaimpresion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaimpresionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaImpresionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturaimpresions,facturaimpresion,facturaimpresionParameterGeneral,facturaimpresionReturnGeneral,isEsNuevoFacturaImpresion,clases);
			
			this.connexion.commit();
			
			return facturaimpresionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaImpresionParameterReturnGeneral procesarImportacionFacturaImpresionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FacturaImpresionParameterReturnGeneral facturaimpresionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-procesarImportacionFacturaImpresionsWithConnection");connexion.begin();			
			
			FacturaImpresionParameterReturnGeneral facturaimpresionReturnGeneral=new FacturaImpresionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.facturaimpresions=new ArrayList<FacturaImpresion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.facturaimpresion=new FacturaImpresion();
				
				
				if(conColumnasBase) {this.facturaimpresion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.facturaimpresion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.facturaimpresions.add(this.facturaimpresion);
			}
			
			this.saveFacturaImpresions();
			
			this.connexion.commit();
			
			facturaimpresionReturnGeneral.setConRetornoEstaProcesado(true);
			facturaimpresionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return facturaimpresionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFacturaImpresionsEliminados() throws Exception {				
		
		List<FacturaImpresion> facturaimpresionsAux= new ArrayList<FacturaImpresion>();
		
		for(FacturaImpresion facturaimpresion:facturaimpresions) {
			if(!facturaimpresion.getIsDeleted()) {
				facturaimpresionsAux.add(facturaimpresion);
			}
		}
		
		facturaimpresions=facturaimpresionsAux;
	}
	
	public void quitarFacturaImpresionsNulos() throws Exception {				
		
		List<FacturaImpresion> facturaimpresionsAux= new ArrayList<FacturaImpresion>();
		
		for(FacturaImpresion facturaimpresion : this.facturaimpresions) {
			if(facturaimpresion==null) {
				facturaimpresionsAux.add(facturaimpresion);
			}
		}
		
		//this.facturaimpresions=facturaimpresionsAux;
		
		this.facturaimpresions.removeAll(facturaimpresionsAux);
	}
	
	public void getSetVersionRowFacturaImpresionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(facturaimpresion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((facturaimpresion.getIsDeleted() || (facturaimpresion.getIsChanged()&&!facturaimpresion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=facturaimpresionDataAccess.getSetVersionRowFacturaImpresion(connexion,facturaimpresion.getId());
				
				if(!facturaimpresion.getVersionRow().equals(timestamp)) {	
					facturaimpresion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				facturaimpresion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFacturaImpresion()throws Exception {	
		
		if(facturaimpresion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((facturaimpresion.getIsDeleted() || (facturaimpresion.getIsChanged()&&!facturaimpresion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=facturaimpresionDataAccess.getSetVersionRowFacturaImpresion(connexion,facturaimpresion.getId());
			
			try {							
				if(!facturaimpresion.getVersionRow().equals(timestamp)) {	
					facturaimpresion.setVersionRow(timestamp);
				}
				
				facturaimpresion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFacturaImpresionsWithConnection()throws Exception {	
		if(facturaimpresions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FacturaImpresion facturaimpresionAux:facturaimpresions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(facturaimpresionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaimpresionAux.getIsDeleted() || (facturaimpresionAux.getIsChanged()&&!facturaimpresionAux.getIsNew())) {
						
						timestamp=facturaimpresionDataAccess.getSetVersionRowFacturaImpresion(connexion,facturaimpresionAux.getId());
						
						if(!facturaimpresion.getVersionRow().equals(timestamp)) {	
							facturaimpresionAux.setVersionRow(timestamp);
						}
								
						facturaimpresionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFacturaImpresions()throws Exception {	
		if(facturaimpresions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FacturaImpresion facturaimpresionAux:facturaimpresions) {
					if(facturaimpresionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaimpresionAux.getIsDeleted() || (facturaimpresionAux.getIsChanged()&&!facturaimpresionAux.getIsNew())) {
						
						timestamp=facturaimpresionDataAccess.getSetVersionRowFacturaImpresion(connexion,facturaimpresionAux.getId());
						
						if(!facturaimpresionAux.getVersionRow().equals(timestamp)) {	
							facturaimpresionAux.setVersionRow(timestamp);
						}
						
													
						facturaimpresionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FacturaImpresionParameterReturnGeneral cargarCombosLoteForeignKeyFacturaImpresionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFactura,String finalQueryGlobalEstadoFactuImpre) throws Exception {
		FacturaImpresionParameterReturnGeneral  facturaimpresionReturnGeneral =new FacturaImpresionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-cargarCombosLoteForeignKeyFacturaImpresionWithConnection");connexion.begin();
			
			facturaimpresionReturnGeneral =new FacturaImpresionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaimpresionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaimpresionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			facturaimpresionReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<EstadoFactuImpre> estadofactuimpresForeignKey=new ArrayList<EstadoFactuImpre>();
			EstadoFactuImpreLogic estadofactuimpreLogic=new EstadoFactuImpreLogic();
			estadofactuimpreLogic.setConnexion(this.connexion);
			estadofactuimpreLogic.getEstadoFactuImpreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoFactuImpre.equals("NONE")) {
				estadofactuimpreLogic.getTodosEstadoFactuImpres(finalQueryGlobalEstadoFactuImpre,new Pagination());
				estadofactuimpresForeignKey=estadofactuimpreLogic.getEstadoFactuImpres();
			}

			facturaimpresionReturnGeneral.setestadofactuimpresForeignKey(estadofactuimpresForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return facturaimpresionReturnGeneral;
	}
	
	public FacturaImpresionParameterReturnGeneral cargarCombosLoteForeignKeyFacturaImpresion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalFactura,String finalQueryGlobalEstadoFactuImpre) throws Exception {
		FacturaImpresionParameterReturnGeneral  facturaimpresionReturnGeneral =new FacturaImpresionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			facturaimpresionReturnGeneral =new FacturaImpresionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaimpresionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaimpresionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			facturaimpresionReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<EstadoFactuImpre> estadofactuimpresForeignKey=new ArrayList<EstadoFactuImpre>();
			EstadoFactuImpreLogic estadofactuimpreLogic=new EstadoFactuImpreLogic();
			estadofactuimpreLogic.setConnexion(this.connexion);
			estadofactuimpreLogic.getEstadoFactuImpreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoFactuImpre.equals("NONE")) {
				estadofactuimpreLogic.getTodosEstadoFactuImpres(finalQueryGlobalEstadoFactuImpre,new Pagination());
				estadofactuimpresForeignKey=estadofactuimpreLogic.getEstadoFactuImpres();
			}

			facturaimpresionReturnGeneral.setestadofactuimpresForeignKey(estadofactuimpresForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return facturaimpresionReturnGeneral;
	}
	
	
	public void deepLoad(FacturaImpresion facturaimpresion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturaImpresionLogicAdditional.updateFacturaImpresionToGet(facturaimpresion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaimpresion.setEmpresa(facturaimpresionDataAccess.getEmpresa(connexion,facturaimpresion));
		facturaimpresion.setSucursal(facturaimpresionDataAccess.getSucursal(connexion,facturaimpresion));
		facturaimpresion.setFactura(facturaimpresionDataAccess.getFactura(connexion,facturaimpresion));
		facturaimpresion.setEstadoFactuImpre(facturaimpresionDataAccess.getEstadoFactuImpre(connexion,facturaimpresion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaimpresion.setEmpresa(facturaimpresionDataAccess.getEmpresa(connexion,facturaimpresion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturaimpresion.setSucursal(facturaimpresionDataAccess.getSucursal(connexion,facturaimpresion));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				facturaimpresion.setFactura(facturaimpresionDataAccess.getFactura(connexion,facturaimpresion));
				continue;
			}

			if(clas.clas.equals(EstadoFactuImpre.class)) {
				facturaimpresion.setEstadoFactuImpre(facturaimpresionDataAccess.getEstadoFactuImpre(connexion,facturaimpresion));
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
			facturaimpresion.setEmpresa(facturaimpresionDataAccess.getEmpresa(connexion,facturaimpresion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaimpresion.setSucursal(facturaimpresionDataAccess.getSucursal(connexion,facturaimpresion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaimpresion.setFactura(facturaimpresionDataAccess.getFactura(connexion,facturaimpresion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoFactuImpre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaimpresion.setEstadoFactuImpre(facturaimpresionDataAccess.getEstadoFactuImpre(connexion,facturaimpresion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaimpresion.setEmpresa(facturaimpresionDataAccess.getEmpresa(connexion,facturaimpresion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturaimpresion.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturaimpresion.setSucursal(facturaimpresionDataAccess.getSucursal(connexion,facturaimpresion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturaimpresion.getSucursal(),isDeep,deepLoadType,clases);
				
		facturaimpresion.setFactura(facturaimpresionDataAccess.getFactura(connexion,facturaimpresion));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(facturaimpresion.getFactura(),isDeep,deepLoadType,clases);
				
		facturaimpresion.setEstadoFactuImpre(facturaimpresionDataAccess.getEstadoFactuImpre(connexion,facturaimpresion));
		EstadoFactuImpreLogic estadofactuimpreLogic= new EstadoFactuImpreLogic(connexion);
		estadofactuimpreLogic.deepLoad(facturaimpresion.getEstadoFactuImpre(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaimpresion.setEmpresa(facturaimpresionDataAccess.getEmpresa(connexion,facturaimpresion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturaimpresion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturaimpresion.setSucursal(facturaimpresionDataAccess.getSucursal(connexion,facturaimpresion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(facturaimpresion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				facturaimpresion.setFactura(facturaimpresionDataAccess.getFactura(connexion,facturaimpresion));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(facturaimpresion.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoFactuImpre.class)) {
				facturaimpresion.setEstadoFactuImpre(facturaimpresionDataAccess.getEstadoFactuImpre(connexion,facturaimpresion));
				EstadoFactuImpreLogic estadofactuimpreLogic= new EstadoFactuImpreLogic(connexion);
				estadofactuimpreLogic.deepLoad(facturaimpresion.getEstadoFactuImpre(),isDeep,deepLoadType,clases);				
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
			facturaimpresion.setEmpresa(facturaimpresionDataAccess.getEmpresa(connexion,facturaimpresion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturaimpresion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaimpresion.setSucursal(facturaimpresionDataAccess.getSucursal(connexion,facturaimpresion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(facturaimpresion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaimpresion.setFactura(facturaimpresionDataAccess.getFactura(connexion,facturaimpresion));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(facturaimpresion.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoFactuImpre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaimpresion.setEstadoFactuImpre(facturaimpresionDataAccess.getEstadoFactuImpre(connexion,facturaimpresion));
			EstadoFactuImpreLogic estadofactuimpreLogic= new EstadoFactuImpreLogic(connexion);
			estadofactuimpreLogic.deepLoad(facturaimpresion.getEstadoFactuImpre(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FacturaImpresion facturaimpresion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FacturaImpresionLogicAdditional.updateFacturaImpresionToSave(facturaimpresion,this.arrDatoGeneral);
			
FacturaImpresionDataAccess.save(facturaimpresion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturaimpresion.getEmpresa(),connexion);

		SucursalDataAccess.save(facturaimpresion.getSucursal(),connexion);

		FacturaDataAccess.save(facturaimpresion.getFactura(),connexion);

		EstadoFactuImpreDataAccess.save(facturaimpresion.getEstadoFactuImpre(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturaimpresion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturaimpresion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(facturaimpresion.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoFactuImpre.class)) {
				EstadoFactuImpreDataAccess.save(facturaimpresion.getEstadoFactuImpre(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturaimpresion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturaimpresion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(facturaimpresion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturaimpresion.getSucursal(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(facturaimpresion.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(facturaimpresion.getFactura(),isDeep,deepLoadType,clases);
				

		EstadoFactuImpreDataAccess.save(facturaimpresion.getEstadoFactuImpre(),connexion);
		EstadoFactuImpreLogic estadofactuimpreLogic= new EstadoFactuImpreLogic(connexion);
		estadofactuimpreLogic.deepLoad(facturaimpresion.getEstadoFactuImpre(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturaimpresion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(facturaimpresion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturaimpresion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(facturaimpresion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(facturaimpresion.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(facturaimpresion.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoFactuImpre.class)) {
				EstadoFactuImpreDataAccess.save(facturaimpresion.getEstadoFactuImpre(),connexion);
				EstadoFactuImpreLogic estadofactuimpreLogic= new EstadoFactuImpreLogic(connexion);
				estadofactuimpreLogic.deepSave(facturaimpresion.getEstadoFactuImpre(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FacturaImpresion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(facturaimpresion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(facturaimpresion);
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
			this.deepLoad(this.facturaimpresion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FacturaImpresion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(facturaimpresions!=null) {
				for(FacturaImpresion facturaimpresion:facturaimpresions) {
					this.deepLoad(facturaimpresion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(facturaimpresions);
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
			if(facturaimpresions!=null) {
				for(FacturaImpresion facturaimpresion:facturaimpresions) {
					this.deepLoad(facturaimpresion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(facturaimpresions);
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
			this.getNewConnexionToDeep(FacturaImpresion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(facturaimpresion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FacturaImpresion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(facturaimpresions!=null) {
				for(FacturaImpresion facturaimpresion:facturaimpresions) {
					this.deepSave(facturaimpresion,isDeep,deepLoadType,clases);
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
			if(facturaimpresions!=null) {
				for(FacturaImpresion facturaimpresion:facturaimpresions) {
					this.deepSave(facturaimpresion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFacturaImpresionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaImpresionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaImpresionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaImpresionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaImpresionsFK_IdEstadoFactuImpreWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_factu_impre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoFactuImpre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoFactuImpre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_factu_impre,FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoFactuImpre);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoFactuImpre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaImpresionsFK_IdEstadoFactuImpre(String sFinalQuery,Pagination pagination,Long id_estado_factu_impre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoFactuImpre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoFactuImpre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_factu_impre,FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoFactuImpre);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoFactuImpre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaImpresionsFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,FacturaImpresionConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaImpresionsFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,FacturaImpresionConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaImpresionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaImpresion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaImpresionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaImpresionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaImpresionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaImpresionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(this.facturaimpresions);
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
			if(FacturaImpresionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaImpresionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FacturaImpresion facturaimpresion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FacturaImpresionConstantesFunciones.ISCONAUDITORIA) {
				if(facturaimpresion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaImpresionDataAccess.TABLENAME, facturaimpresion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaImpresionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaImpresionLogic.registrarAuditoriaDetallesFacturaImpresion(connexion,facturaimpresion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(facturaimpresion.getIsDeleted()) {
					/*if(!facturaimpresion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FacturaImpresionDataAccess.TABLENAME, facturaimpresion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FacturaImpresionLogic.registrarAuditoriaDetallesFacturaImpresion(connexion,facturaimpresion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaImpresionDataAccess.TABLENAME, facturaimpresion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(facturaimpresion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaImpresionDataAccess.TABLENAME, facturaimpresion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaImpresionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaImpresionLogic.registrarAuditoriaDetallesFacturaImpresion(connexion,facturaimpresion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFacturaImpresion(Connexion connexion,FacturaImpresion facturaimpresion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(facturaimpresion.getIsNew()||!facturaimpresion.getid_empresa().equals(facturaimpresion.getFacturaImpresionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaimpresion.getFacturaImpresionOriginal().getid_empresa()!=null)
				{
					strValorActual=facturaimpresion.getFacturaImpresionOriginal().getid_empresa().toString();
				}
				if(facturaimpresion.getid_empresa()!=null)
				{
					strValorNuevo=facturaimpresion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaImpresionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(facturaimpresion.getIsNew()||!facturaimpresion.getid_sucursal().equals(facturaimpresion.getFacturaImpresionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaimpresion.getFacturaImpresionOriginal().getid_sucursal()!=null)
				{
					strValorActual=facturaimpresion.getFacturaImpresionOriginal().getid_sucursal().toString();
				}
				if(facturaimpresion.getid_sucursal()!=null)
				{
					strValorNuevo=facturaimpresion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaImpresionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(facturaimpresion.getIsNew()||!facturaimpresion.getid_factura().equals(facturaimpresion.getFacturaImpresionOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaimpresion.getFacturaImpresionOriginal().getid_factura()!=null)
				{
					strValorActual=facturaimpresion.getFacturaImpresionOriginal().getid_factura().toString();
				}
				if(facturaimpresion.getid_factura()!=null)
				{
					strValorNuevo=facturaimpresion.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaImpresionConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(facturaimpresion.getIsNew()||!facturaimpresion.getid_estado_factu_impre().equals(facturaimpresion.getFacturaImpresionOriginal().getid_estado_factu_impre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaimpresion.getFacturaImpresionOriginal().getid_estado_factu_impre()!=null)
				{
					strValorActual=facturaimpresion.getFacturaImpresionOriginal().getid_estado_factu_impre().toString();
				}
				if(facturaimpresion.getid_estado_factu_impre()!=null)
				{
					strValorNuevo=facturaimpresion.getid_estado_factu_impre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFacturaImpresionRelacionesWithConnection(FacturaImpresion facturaimpresion) throws Exception {

		if(!facturaimpresion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaImpresionRelacionesBase(facturaimpresion,true);
		}
	}

	public void saveFacturaImpresionRelaciones(FacturaImpresion facturaimpresion)throws Exception {

		if(!facturaimpresion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaImpresionRelacionesBase(facturaimpresion,false);
		}
	}

	public void saveFacturaImpresionRelacionesBase(FacturaImpresion facturaimpresion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FacturaImpresion-saveRelacionesWithConnection");}
	

			this.setFacturaImpresion(facturaimpresion);

			if(FacturaImpresionLogicAdditional.validarSaveRelaciones(facturaimpresion,this)) {

				FacturaImpresionLogicAdditional.updateRelacionesToSave(facturaimpresion,this);

				if((facturaimpresion.getIsNew()||facturaimpresion.getIsChanged())&&!facturaimpresion.getIsDeleted()) {
					this.saveFacturaImpresion();
					this.saveFacturaImpresionRelacionesDetalles();

				} else if(facturaimpresion.getIsDeleted()) {
					this.saveFacturaImpresionRelacionesDetalles();
					this.saveFacturaImpresion();
				}

				FacturaImpresionLogicAdditional.updateRelacionesToSaveAfter(facturaimpresion,this);

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
	
	
	private void saveFacturaImpresionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaImpresion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaImpresionConstantesFunciones.getClassesForeignKeysOfFacturaImpresion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaImpresion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaImpresionConstantesFunciones.getClassesRelationshipsOfFacturaImpresion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
