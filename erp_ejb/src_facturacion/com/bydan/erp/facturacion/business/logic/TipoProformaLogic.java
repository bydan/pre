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
import com.bydan.erp.facturacion.util.TipoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoProformaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoProforma;
import com.bydan.erp.facturacion.business.logic.TipoProformaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoProformaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProformaLogic.class);
	
	protected TipoProformaDataAccess tipoproformaDataAccess; 	
	protected TipoProforma tipoproforma;
	protected List<TipoProforma> tipoproformas;
	protected Object tipoproformaObject;	
	protected List<Object> tipoproformasObject;
	
	public static ClassValidator<TipoProforma> tipoproformaValidator = new ClassValidator<TipoProforma>(TipoProforma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoProformaLogicAdditional tipoproformaLogicAdditional=null;
	
	public TipoProformaLogicAdditional getTipoProformaLogicAdditional() {
		return this.tipoproformaLogicAdditional;
	}
	
	public void setTipoProformaLogicAdditional(TipoProformaLogicAdditional tipoproformaLogicAdditional) {
		try {
			this.tipoproformaLogicAdditional=tipoproformaLogicAdditional;
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
	
	
	
	
	public  TipoProformaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoproformaDataAccess = new TipoProformaDataAccess();
			
			this.tipoproformas= new ArrayList<TipoProforma>();
			this.tipoproforma= new TipoProforma();
			
			this.tipoproformaObject=new Object();
			this.tipoproformasObject=new ArrayList<Object>();
				
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
			
			this.tipoproformaDataAccess.setConnexionType(this.connexionType);
			this.tipoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProformaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoproformaDataAccess = new TipoProformaDataAccess();
			this.tipoproformas= new ArrayList<TipoProforma>();
			this.tipoproforma= new TipoProforma();
			this.tipoproformaObject=new Object();
			this.tipoproformasObject=new ArrayList<Object>();
			
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
			
			this.tipoproformaDataAccess.setConnexionType(this.connexionType);
			this.tipoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProforma getTipoProforma() throws Exception {	
		TipoProformaLogicAdditional.checkTipoProformaToGet(tipoproforma,this.datosCliente,this.arrDatoGeneral);
		TipoProformaLogicAdditional.updateTipoProformaToGet(tipoproforma,this.arrDatoGeneral);
		
		return tipoproforma;
	}
		
	public void setTipoProforma(TipoProforma newTipoProforma) {
		this.tipoproforma = newTipoProforma;
	}
	
	public TipoProformaDataAccess getTipoProformaDataAccess() {
		return tipoproformaDataAccess;
	}
	
	public void setTipoProformaDataAccess(TipoProformaDataAccess newtipoproformaDataAccess) {
		this.tipoproformaDataAccess = newtipoproformaDataAccess;
	}
	
	public List<TipoProforma> getTipoProformas() throws Exception {		
		this.quitarTipoProformasNulos();
		
		TipoProformaLogicAdditional.checkTipoProformaToGets(tipoproformas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProforma tipoproformaLocal: tipoproformas ) {
			TipoProformaLogicAdditional.updateTipoProformaToGet(tipoproformaLocal,this.arrDatoGeneral);
		}
		
		return tipoproformas;
	}
	
	public void setTipoProformas(List<TipoProforma> newTipoProformas) {
		this.tipoproformas = newTipoProformas;
	}
	
	public Object getTipoProformaObject() {	
		this.tipoproformaObject=this.tipoproformaDataAccess.getEntityObject();
		return this.tipoproformaObject;
	}
		
	public void setTipoProformaObject(Object newTipoProformaObject) {
		this.tipoproformaObject = newTipoProformaObject;
	}
	
	public List<Object> getTipoProformasObject() {		
		this.tipoproformasObject=this.tipoproformaDataAccess.getEntitiesObject();
		return this.tipoproformasObject;
	}
		
	public void setTipoProformasObject(List<Object> newTipoProformasObject) {
		this.tipoproformasObject = newTipoProformasObject;
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
		
		if(this.tipoproformaDataAccess!=null) {
			this.tipoproformaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoproforma = new  TipoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproforma=tipoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproforma);
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
		tipoproforma = new  TipoProforma();
		  		  
        try {
			
			tipoproforma=tipoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoproforma = new  TipoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproforma=tipoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproforma);
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
		tipoproforma = new  TipoProforma();
		  		  
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
		tipoproforma = new  TipoProforma();
		  		  
        try {
			
			tipoproforma=tipoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoproforma = new  TipoProforma();
		  		  
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
		tipoproforma = new  TipoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproforma = new  TipoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproforma = new  TipoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproforma = new  TipoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproforma = new  TipoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproforma = new  TipoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
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
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
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
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
        try {			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
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
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
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
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
        try {
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
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
		tipoproformas = new  ArrayList<TipoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
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
		tipoproformas = new  ArrayList<TipoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoproforma = new  TipoProforma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproforma=tipoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproforma);
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
		tipoproforma = new  TipoProforma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproforma=tipoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
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
		tipoproformas = new  ArrayList<TipoProforma>();
		  		  
        try {
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoProformasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproformas = new  ArrayList<TipoProforma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getTodosTipoProformasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
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
	
	public  void  getTodosTipoProformas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproformas = new  ArrayList<TipoProforma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproformas=tipoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProforma(tipoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProforma(TipoProforma tipoproforma) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoproforma.getIsNew() || tipoproforma.getIsChanged()) { 
			this.invalidValues = tipoproformaValidator.getInvalidValues(tipoproforma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoproforma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProforma(List<TipoProforma> TipoProformas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProforma tipoproformaLocal:tipoproformas) {				
			estaValidadoObjeto=this.validarGuardarTipoProforma(tipoproformaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProforma(List<TipoProforma> TipoProformas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProforma(tipoproformas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProforma(TipoProforma TipoProforma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProforma(tipoproforma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProforma tipoproforma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoproforma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProformaConstantesFunciones.getTipoProformaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoproforma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProformaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-saveTipoProformaWithConnection");connexion.begin();			
			
			TipoProformaLogicAdditional.checkTipoProformaToSave(this.tipoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProformaLogicAdditional.updateTipoProformaToSave(this.tipoproforma,this.arrDatoGeneral);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProforma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProforma(this.tipoproforma)) {
				TipoProformaDataAccess.save(this.tipoproforma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProformaLogicAdditional.checkTipoProformaToSaveAfter(this.tipoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProforma();
			
			connexion.commit();			
			
			if(this.tipoproforma.getIsDeleted()) {
				this.tipoproforma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProforma()throws Exception {	
		try {	
			
			TipoProformaLogicAdditional.checkTipoProformaToSave(this.tipoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProformaLogicAdditional.updateTipoProformaToSave(this.tipoproforma,this.arrDatoGeneral);
			
			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProforma(this.tipoproforma)) {			
				TipoProformaDataAccess.save(this.tipoproforma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProformaLogicAdditional.checkTipoProformaToSaveAfter(this.tipoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoproforma.getIsDeleted()) {
				this.tipoproforma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProformasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-saveTipoProformasWithConnection");connexion.begin();			
			
			TipoProformaLogicAdditional.checkTipoProformaToSaves(tipoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProformas();
			
			Boolean validadoTodosTipoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProforma tipoproformaLocal:tipoproformas) {		
				if(tipoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProformaLogicAdditional.updateTipoProformaToSave(tipoproformaLocal,this.arrDatoGeneral);
	        	
				TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProforma(tipoproformaLocal)) {
					TipoProformaDataAccess.save(tipoproformaLocal, connexion);				
				} else {
					validadoTodosTipoProforma=false;
				}
			}
			
			if(!validadoTodosTipoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProformaLogicAdditional.checkTipoProformaToSavesAfter(tipoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProformas();
			
			connexion.commit();		
			
			this.quitarTipoProformasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProformas()throws Exception {				
		 try {	
			TipoProformaLogicAdditional.checkTipoProformaToSaves(tipoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProforma tipoproformaLocal:tipoproformas) {				
				if(tipoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProformaLogicAdditional.updateTipoProformaToSave(tipoproformaLocal,this.arrDatoGeneral);
	        	
				TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProforma(tipoproformaLocal)) {				
					TipoProformaDataAccess.save(tipoproformaLocal, connexion);				
				} else {
					validadoTodosTipoProforma=false;
				}
			}
			
			if(!validadoTodosTipoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProformaLogicAdditional.checkTipoProformaToSavesAfter(tipoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProformasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProformaParameterReturnGeneral procesarAccionTipoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProforma> tipoproformas,TipoProformaParameterReturnGeneral tipoproformaParameterGeneral)throws Exception {
		 try {	
			TipoProformaParameterReturnGeneral tipoproformaReturnGeneral=new TipoProformaParameterReturnGeneral();
	
			TipoProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoproformas,tipoproformaParameterGeneral,tipoproformaReturnGeneral);
			
			return tipoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProformaParameterReturnGeneral procesarAccionTipoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProforma> tipoproformas,TipoProformaParameterReturnGeneral tipoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-procesarAccionTipoProformasWithConnection");connexion.begin();			
			
			TipoProformaParameterReturnGeneral tipoproformaReturnGeneral=new TipoProformaParameterReturnGeneral();
	
			TipoProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoproformas,tipoproformaParameterGeneral,tipoproformaReturnGeneral);
			
			this.connexion.commit();
			
			return tipoproformaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProformaParameterReturnGeneral procesarEventosTipoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProforma> tipoproformas,TipoProforma tipoproforma,TipoProformaParameterReturnGeneral tipoproformaParameterGeneral,Boolean isEsNuevoTipoProforma,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProformaParameterReturnGeneral tipoproformaReturnGeneral=new TipoProformaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoproformas,tipoproforma,tipoproformaParameterGeneral,tipoproformaReturnGeneral,isEsNuevoTipoProforma,clases);
			
			return tipoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProformaParameterReturnGeneral procesarEventosTipoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProforma> tipoproformas,TipoProforma tipoproforma,TipoProformaParameterReturnGeneral tipoproformaParameterGeneral,Boolean isEsNuevoTipoProforma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-procesarEventosTipoProformasWithConnection");connexion.begin();			
			
			TipoProformaParameterReturnGeneral tipoproformaReturnGeneral=new TipoProformaParameterReturnGeneral();
	
			tipoproformaReturnGeneral.setTipoProforma(tipoproforma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoproformas,tipoproforma,tipoproformaParameterGeneral,tipoproformaReturnGeneral,isEsNuevoTipoProforma,clases);
			
			this.connexion.commit();
			
			return tipoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProformaParameterReturnGeneral procesarImportacionTipoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProformaParameterReturnGeneral tipoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-procesarImportacionTipoProformasWithConnection");connexion.begin();			
			
			TipoProformaParameterReturnGeneral tipoproformaReturnGeneral=new TipoProformaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoproformas=new ArrayList<TipoProforma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoproforma=new TipoProforma();
				
				
				if(conColumnasBase) {this.tipoproforma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoproforma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoproforma.setcodigo(arrColumnas[iColumn++]);
				this.tipoproforma.setnombre(arrColumnas[iColumn++]);
				
				this.tipoproformas.add(this.tipoproforma);
			}
			
			this.saveTipoProformas();
			
			this.connexion.commit();
			
			tipoproformaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoproformaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProformasEliminados() throws Exception {				
		
		List<TipoProforma> tipoproformasAux= new ArrayList<TipoProforma>();
		
		for(TipoProforma tipoproforma:tipoproformas) {
			if(!tipoproforma.getIsDeleted()) {
				tipoproformasAux.add(tipoproforma);
			}
		}
		
		tipoproformas=tipoproformasAux;
	}
	
	public void quitarTipoProformasNulos() throws Exception {				
		
		List<TipoProforma> tipoproformasAux= new ArrayList<TipoProforma>();
		
		for(TipoProforma tipoproforma : this.tipoproformas) {
			if(tipoproforma==null) {
				tipoproformasAux.add(tipoproforma);
			}
		}
		
		//this.tipoproformas=tipoproformasAux;
		
		this.tipoproformas.removeAll(tipoproformasAux);
	}
	
	public void getSetVersionRowTipoProformaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoproforma.getIsDeleted() || (tipoproforma.getIsChanged()&&!tipoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoproformaDataAccess.getSetVersionRowTipoProforma(connexion,tipoproforma.getId());
				
				if(!tipoproforma.getVersionRow().equals(timestamp)) {	
					tipoproforma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProforma()throws Exception {	
		
		if(tipoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoproforma.getIsDeleted() || (tipoproforma.getIsChanged()&&!tipoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoproformaDataAccess.getSetVersionRowTipoProforma(connexion,tipoproforma.getId());
			
			try {							
				if(!tipoproforma.getVersionRow().equals(timestamp)) {	
					tipoproforma.setVersionRow(timestamp);
				}
				
				tipoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProformasWithConnection()throws Exception {	
		if(tipoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProforma tipoproformaAux:tipoproformas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproformaAux.getIsDeleted() || (tipoproformaAux.getIsChanged()&&!tipoproformaAux.getIsNew())) {
						
						timestamp=tipoproformaDataAccess.getSetVersionRowTipoProforma(connexion,tipoproformaAux.getId());
						
						if(!tipoproforma.getVersionRow().equals(timestamp)) {	
							tipoproformaAux.setVersionRow(timestamp);
						}
								
						tipoproformaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProformas()throws Exception {	
		if(tipoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProforma tipoproformaAux:tipoproformas) {
					if(tipoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproformaAux.getIsDeleted() || (tipoproformaAux.getIsChanged()&&!tipoproformaAux.getIsNew())) {
						
						timestamp=tipoproformaDataAccess.getSetVersionRowTipoProforma(connexion,tipoproformaAux.getId());
						
						if(!tipoproformaAux.getVersionRow().equals(timestamp)) {	
							tipoproformaAux.setVersionRow(timestamp);
						}
						
													
						tipoproformaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoProformaParameterReturnGeneral cargarCombosLoteForeignKeyTipoProformaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoProformaParameterReturnGeneral  tipoproformaReturnGeneral =new TipoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoProformaWithConnection");connexion.begin();
			
			tipoproformaReturnGeneral =new TipoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoproformaReturnGeneral;
	}
	
	public TipoProformaParameterReturnGeneral cargarCombosLoteForeignKeyTipoProforma(String finalQueryGlobalEmpresa) throws Exception {
		TipoProformaParameterReturnGeneral  tipoproformaReturnGeneral =new TipoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoproformaReturnGeneral =new TipoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoproformaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoProformaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProformaLogic proformaLogic=new ProformaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProformaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Proforma.class));
											
			

			proformaLogic.setConnexion(this.getConnexion());
			proformaLogic.setDatosCliente(this.datosCliente);
			proformaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProforma tipoproforma:this.tipoproformas) {
				

				classes=new ArrayList<Classe>();
				classes=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				proformaLogic.setProformas(tipoproforma.proformas);
				proformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProforma tipoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoProformaLogicAdditional.updateTipoProformaToGet(tipoproforma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoproforma.setEmpresa(tipoproformaDataAccess.getEmpresa(connexion,tipoproforma));
		tipoproforma.setProformas(tipoproformaDataAccess.getProformas(connexion,tipoproforma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoproforma.setEmpresa(tipoproformaDataAccess.getEmpresa(connexion,tipoproforma));
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproforma.setProformas(tipoproformaDataAccess.getProformas(connexion,tipoproforma));

				if(this.isConDeep) {
					ProformaLogic proformaLogic= new ProformaLogic(this.connexion);
					proformaLogic.setProformas(tipoproforma.getProformas());
					ArrayList<Classe> classesLocal=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					proformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proformaLogic.getProformas());
					tipoproforma.setProformas(proformaLogic.getProformas());
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
			tipoproforma.setEmpresa(tipoproformaDataAccess.getEmpresa(connexion,tipoproforma));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			tipoproforma.setProformas(tipoproformaDataAccess.getProformas(connexion,tipoproforma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoproforma.setEmpresa(tipoproformaDataAccess.getEmpresa(connexion,tipoproforma));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoproforma.setProformas(tipoproformaDataAccess.getProformas(connexion,tipoproforma));

		for(Proforma proforma:tipoproforma.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoproforma.setEmpresa(tipoproformaDataAccess.getEmpresa(connexion,tipoproforma));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproforma.setProformas(tipoproformaDataAccess.getProformas(connexion,tipoproforma));

				for(Proforma proforma:tipoproforma.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
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
			tipoproforma.setEmpresa(tipoproformaDataAccess.getEmpresa(connexion,tipoproforma));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			tipoproforma.setProformas(tipoproformaDataAccess.getProformas(connexion,tipoproforma));

			for(Proforma proforma:tipoproforma.getProformas()) {
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProforma tipoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoProformaLogicAdditional.updateTipoProformaToSave(tipoproforma,this.arrDatoGeneral);
			
TipoProformaDataAccess.save(tipoproforma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoproforma.getEmpresa(),connexion);

		for(Proforma proforma:tipoproforma.getProformas()) {
			proforma.setid_tipo_proforma(tipoproforma.getId());
			ProformaDataAccess.save(proforma,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoproforma.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:tipoproforma.getProformas()) {
					proforma.setid_tipo_proforma(tipoproforma.getId());
					ProformaDataAccess.save(proforma,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoproforma.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Proforma proforma:tipoproforma.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proforma.setid_tipo_proforma(tipoproforma.getId());
			ProformaDataAccess.save(proforma,connexion);
			proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoproforma.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:tipoproforma.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proforma.setid_tipo_proforma(tipoproforma.getId());
					ProformaDataAccess.save(proforma,connexion);
					proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoProforma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(tipoproforma);
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
			this.deepLoad(this.tipoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProforma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoproformas!=null) {
				for(TipoProforma tipoproforma:tipoproformas) {
					this.deepLoad(tipoproforma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(tipoproformas);
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
			if(tipoproformas!=null) {
				for(TipoProforma tipoproforma:tipoproformas) {
					this.deepLoad(tipoproforma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(tipoproformas);
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
			this.getNewConnexionToDeep(TipoProforma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoproforma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoProforma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoproformas!=null) {
				for(TipoProforma tipoproforma:tipoproformas) {
					this.deepSave(tipoproforma,isDeep,deepLoadType,clases);
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
			if(tipoproformas!=null) {
				for(TipoProforma tipoproforma:tipoproformas) {
					this.deepSave(tipoproforma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoProformasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproformas=tipoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProformasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproformas=tipoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProformaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProforma(this.tipoproformas);
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
			if(TipoProformaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProformaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProforma tipoproforma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProformaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoproforma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProformaDataAccess.TABLENAME, tipoproforma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProformaLogic.registrarAuditoriaDetallesTipoProforma(connexion,tipoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoproforma.getIsDeleted()) {
					/*if(!tipoproforma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProformaDataAccess.TABLENAME, tipoproforma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProformaLogic.registrarAuditoriaDetallesTipoProforma(connexion,tipoproforma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProformaDataAccess.TABLENAME, tipoproforma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoproforma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProformaDataAccess.TABLENAME, tipoproforma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProformaLogic.registrarAuditoriaDetallesTipoProforma(connexion,tipoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProforma(Connexion connexion,TipoProforma tipoproforma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoproforma.getIsNew()||!tipoproforma.getid_empresa().equals(tipoproforma.getTipoProformaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproforma.getTipoProformaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoproforma.getTipoProformaOriginal().getid_empresa().toString();
				}
				if(tipoproforma.getid_empresa()!=null)
				{
					strValorNuevo=tipoproforma.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProformaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoproforma.getIsNew()||!tipoproforma.getcodigo().equals(tipoproforma.getTipoProformaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproforma.getTipoProformaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoproforma.getTipoProformaOriginal().getcodigo();
				}
				if(tipoproforma.getcodigo()!=null)
				{
					strValorNuevo=tipoproforma.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProformaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoproforma.getIsNew()||!tipoproforma.getnombre().equals(tipoproforma.getTipoProformaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproforma.getTipoProformaOriginal().getnombre()!=null)
				{
					strValorActual=tipoproforma.getTipoProformaOriginal().getnombre();
				}
				if(tipoproforma.getnombre()!=null)
				{
					strValorNuevo=tipoproforma.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProformaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoProformaRelacionesWithConnection(TipoProforma tipoproforma,List<Proforma> proformas) throws Exception {

		if(!tipoproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProformaRelacionesBase(tipoproforma,proformas,true);
		}
	}

	public void saveTipoProformaRelaciones(TipoProforma tipoproforma,List<Proforma> proformas)throws Exception {

		if(!tipoproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProformaRelacionesBase(tipoproforma,proformas,false);
		}
	}

	public void saveTipoProformaRelacionesBase(TipoProforma tipoproforma,List<Proforma> proformas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoProforma-saveRelacionesWithConnection");}
	
			tipoproforma.setProformas(proformas);

			this.setTipoProforma(tipoproforma);

			if(TipoProformaLogicAdditional.validarSaveRelaciones(tipoproforma,this)) {

				TipoProformaLogicAdditional.updateRelacionesToSave(tipoproforma,this);

				if((tipoproforma.getIsNew()||tipoproforma.getIsChanged())&&!tipoproforma.getIsDeleted()) {
					this.saveTipoProforma();
					this.saveTipoProformaRelacionesDetalles(proformas);

				} else if(tipoproforma.getIsDeleted()) {
					this.saveTipoProformaRelacionesDetalles(proformas);
					this.saveTipoProforma();
				}

				TipoProformaLogicAdditional.updateRelacionesToSaveAfter(tipoproforma,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresProformas(proformas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoProformaRelacionesDetalles(List<Proforma> proformas)throws Exception {
		try {
	

			Long idTipoProformaActual=this.getTipoProforma().getId();

			ProformaLogic proformaLogic_Desde_TipoProforma=new ProformaLogic();
			proformaLogic_Desde_TipoProforma.setProformas(proformas);

			proformaLogic_Desde_TipoProforma.setConnexion(this.getConnexion());
			proformaLogic_Desde_TipoProforma.setDatosCliente(this.datosCliente);

			for(Proforma proforma_Desde_TipoProforma:proformaLogic_Desde_TipoProforma.getProformas()) {
				proforma_Desde_TipoProforma.setid_tipo_proforma(idTipoProformaActual);

				proformaLogic_Desde_TipoProforma.setProforma(proforma_Desde_TipoProforma);
				proformaLogic_Desde_TipoProforma.saveProforma();

				Long idProformaActual=proforma_Desde_TipoProforma.getId();

				TerminoProformaLogic terminoproformaLogic_Desde_Proforma=new TerminoProformaLogic();

				if(proforma_Desde_TipoProforma.getTerminoProformas()==null){
					proforma_Desde_TipoProforma.setTerminoProformas(new ArrayList<TerminoProforma>());
				}

				terminoproformaLogic_Desde_Proforma.setTerminoProformas(proforma_Desde_TipoProforma.getTerminoProformas());

				terminoproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				terminoproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(TerminoProforma terminoproforma_Desde_Proforma:terminoproformaLogic_Desde_Proforma.getTerminoProformas()) {
					terminoproforma_Desde_Proforma.setid_proforma(idProformaActual);

					terminoproformaLogic_Desde_Proforma.setTerminoProforma(terminoproforma_Desde_Proforma);
					terminoproformaLogic_Desde_Proforma.saveTerminoProforma();

					Long idTerminoProformaActual=terminoproforma_Desde_Proforma.getId();

					DetalleTerminoProformaLogic detalleterminoproformaLogic_Desde_TerminoProforma=new DetalleTerminoProformaLogic();

					if(terminoproforma_Desde_Proforma.getDetalleTerminoProformas()==null){
						terminoproforma_Desde_Proforma.setDetalleTerminoProformas(new ArrayList<DetalleTerminoProforma>());
					}

					detalleterminoproformaLogic_Desde_TerminoProforma.setDetalleTerminoProformas(terminoproforma_Desde_Proforma.getDetalleTerminoProformas());

					detalleterminoproformaLogic_Desde_TerminoProforma.setConnexion(this.getConnexion());
					detalleterminoproformaLogic_Desde_TerminoProforma.setDatosCliente(this.datosCliente);

					for(DetalleTerminoProforma detalleterminoproforma_Desde_TerminoProforma:detalleterminoproformaLogic_Desde_TerminoProforma.getDetalleTerminoProformas()) {
						detalleterminoproforma_Desde_TerminoProforma.setid_termino_proforma(idTerminoProformaActual);
					}

					detalleterminoproformaLogic_Desde_TerminoProforma.saveDetalleTerminoProformas();
				}


				DetalleProformaLogic detalleproformaLogic_Desde_Proforma=new DetalleProformaLogic();

				if(proforma_Desde_TipoProforma.getDetalleProformas()==null){
					proforma_Desde_TipoProforma.setDetalleProformas(new ArrayList<DetalleProforma>());
				}

				detalleproformaLogic_Desde_Proforma.setDetalleProformas(proforma_Desde_TipoProforma.getDetalleProformas());

				detalleproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				detalleproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(DetalleProforma detalleproforma_Desde_Proforma:detalleproformaLogic_Desde_Proforma.getDetalleProformas()) {
					detalleproforma_Desde_Proforma.setid_proforma(idProformaActual);
				}

				detalleproformaLogic_Desde_Proforma.saveDetalleProformas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProformaConstantesFunciones.getClassesForeignKeysOfTipoProforma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProformaConstantesFunciones.getClassesRelationshipsOfTipoProforma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
