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
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.importaciones.util.TipoProrrateoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.TipoProrrateoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.TipoProrrateoImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.TipoProrrateoImpor;
//import com.bydan.erp.importaciones.business.logic.TipoProrrateoImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoProrrateoImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProrrateoImporLogic.class);
	
	protected TipoProrrateoImporDataAccess tipoprorrateoimporDataAccess; 	
	protected TipoProrrateoImpor tipoprorrateoimpor;
	protected List<TipoProrrateoImpor> tipoprorrateoimpors;
	protected Object tipoprorrateoimporObject;	
	protected List<Object> tipoprorrateoimporsObject;
	
	public static ClassValidator<TipoProrrateoImpor> tipoprorrateoimporValidator = new ClassValidator<TipoProrrateoImpor>(TipoProrrateoImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoProrrateoImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprorrateoimporDataAccess = new TipoProrrateoImporDataAccess();
			
			this.tipoprorrateoimpors= new ArrayList<TipoProrrateoImpor>();
			this.tipoprorrateoimpor= new TipoProrrateoImpor();
			
			this.tipoprorrateoimporObject=new Object();
			this.tipoprorrateoimporsObject=new ArrayList<Object>();
				
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
			
			this.tipoprorrateoimporDataAccess.setConnexionType(this.connexionType);
			this.tipoprorrateoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProrrateoImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprorrateoimporDataAccess = new TipoProrrateoImporDataAccess();
			this.tipoprorrateoimpors= new ArrayList<TipoProrrateoImpor>();
			this.tipoprorrateoimpor= new TipoProrrateoImpor();
			this.tipoprorrateoimporObject=new Object();
			this.tipoprorrateoimporsObject=new ArrayList<Object>();
			
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
			
			this.tipoprorrateoimporDataAccess.setConnexionType(this.connexionType);
			this.tipoprorrateoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProrrateoImpor getTipoProrrateoImpor() throws Exception {	
		//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToGet(tipoprorrateoimpor,this.datosCliente,this.arrDatoGeneral);
		//TipoProrrateoImporLogicAdditional.updateTipoProrrateoImporToGet(tipoprorrateoimpor,this.arrDatoGeneral);
		
		return tipoprorrateoimpor;
	}
		
	public void setTipoProrrateoImpor(TipoProrrateoImpor newTipoProrrateoImpor) {
		this.tipoprorrateoimpor = newTipoProrrateoImpor;
	}
	
	public TipoProrrateoImporDataAccess getTipoProrrateoImporDataAccess() {
		return tipoprorrateoimporDataAccess;
	}
	
	public void setTipoProrrateoImporDataAccess(TipoProrrateoImporDataAccess newtipoprorrateoimporDataAccess) {
		this.tipoprorrateoimporDataAccess = newtipoprorrateoimporDataAccess;
	}
	
	public List<TipoProrrateoImpor> getTipoProrrateoImpors() throws Exception {		
		this.quitarTipoProrrateoImporsNulos();
		
		//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToGets(tipoprorrateoimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProrrateoImpor tipoprorrateoimporLocal: tipoprorrateoimpors ) {
			//TipoProrrateoImporLogicAdditional.updateTipoProrrateoImporToGet(tipoprorrateoimporLocal,this.arrDatoGeneral);
		}
		
		return tipoprorrateoimpors;
	}
	
	public void setTipoProrrateoImpors(List<TipoProrrateoImpor> newTipoProrrateoImpors) {
		this.tipoprorrateoimpors = newTipoProrrateoImpors;
	}
	
	public Object getTipoProrrateoImporObject() {	
		this.tipoprorrateoimporObject=this.tipoprorrateoimporDataAccess.getEntityObject();
		return this.tipoprorrateoimporObject;
	}
		
	public void setTipoProrrateoImporObject(Object newTipoProrrateoImporObject) {
		this.tipoprorrateoimporObject = newTipoProrrateoImporObject;
	}
	
	public List<Object> getTipoProrrateoImporsObject() {		
		this.tipoprorrateoimporsObject=this.tipoprorrateoimporDataAccess.getEntitiesObject();
		return this.tipoprorrateoimporsObject;
	}
		
	public void setTipoProrrateoImporsObject(List<Object> newTipoProrrateoImporsObject) {
		this.tipoprorrateoimporsObject = newTipoProrrateoImporsObject;
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
		
		if(this.tipoprorrateoimporDataAccess!=null) {
			this.tipoprorrateoimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprorrateoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprorrateoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprorrateoimpor=tipoprorrateoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprorrateoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpor);
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  		  
        try {
			
			tipoprorrateoimpor=tipoprorrateoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprorrateoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprorrateoimpor=tipoprorrateoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprorrateoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpor);
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  		  
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  		  
        try {
			
			tipoprorrateoimpor=tipoprorrateoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprorrateoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  		  
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprorrateoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprorrateoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprorrateoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprorrateoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprorrateoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprorrateoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
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
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		  		  
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
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		  		  
        try {			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		  		  
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
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
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
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		  		  
        try {
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
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
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
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
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpor=tipoprorrateoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpor);
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
		tipoprorrateoimpor = new  TipoProrrateoImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpor=tipoprorrateoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoProrrateoImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-getTodosTipoProrrateoImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
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
	
	public  void  getTodosTipoProrrateoImpors(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprorrateoimpors = new  ArrayList<TipoProrrateoImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprorrateoimpors=tipoprorrateoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProrrateoImpor(tipoprorrateoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProrrateoImpor(TipoProrrateoImpor tipoprorrateoimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprorrateoimpor.getIsNew() || tipoprorrateoimpor.getIsChanged()) { 
			this.invalidValues = tipoprorrateoimporValidator.getInvalidValues(tipoprorrateoimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprorrateoimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProrrateoImpor(List<TipoProrrateoImpor> TipoProrrateoImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProrrateoImpor tipoprorrateoimporLocal:tipoprorrateoimpors) {				
			estaValidadoObjeto=this.validarGuardarTipoProrrateoImpor(tipoprorrateoimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProrrateoImpor(List<TipoProrrateoImpor> TipoProrrateoImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProrrateoImpor(tipoprorrateoimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProrrateoImpor(TipoProrrateoImpor TipoProrrateoImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProrrateoImpor(tipoprorrateoimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProrrateoImpor tipoprorrateoimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprorrateoimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProrrateoImporConstantesFunciones.getTipoProrrateoImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprorrateoimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProrrateoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProrrateoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProrrateoImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-saveTipoProrrateoImporWithConnection");connexion.begin();			
			
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSave(this.tipoprorrateoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProrrateoImporLogicAdditional.updateTipoProrrateoImporToSave(this.tipoprorrateoimpor,this.arrDatoGeneral);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprorrateoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProrrateoImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProrrateoImpor(this.tipoprorrateoimpor)) {
				TipoProrrateoImporDataAccess.save(this.tipoprorrateoimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprorrateoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSaveAfter(this.tipoprorrateoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProrrateoImpor();
			
			connexion.commit();			
			
			if(this.tipoprorrateoimpor.getIsDeleted()) {
				this.tipoprorrateoimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProrrateoImpor()throws Exception {	
		try {	
			
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSave(this.tipoprorrateoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProrrateoImporLogicAdditional.updateTipoProrrateoImporToSave(this.tipoprorrateoimpor,this.arrDatoGeneral);
			
			TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprorrateoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProrrateoImpor(this.tipoprorrateoimpor)) {			
				TipoProrrateoImporDataAccess.save(this.tipoprorrateoimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprorrateoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSaveAfter(this.tipoprorrateoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprorrateoimpor.getIsDeleted()) {
				this.tipoprorrateoimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProrrateoImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-saveTipoProrrateoImporsWithConnection");connexion.begin();			
			
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSaves(tipoprorrateoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProrrateoImpors();
			
			Boolean validadoTodosTipoProrrateoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProrrateoImpor tipoprorrateoimporLocal:tipoprorrateoimpors) {		
				if(tipoprorrateoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProrrateoImporLogicAdditional.updateTipoProrrateoImporToSave(tipoprorrateoimporLocal,this.arrDatoGeneral);
	        	
				TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprorrateoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProrrateoImpor(tipoprorrateoimporLocal)) {
					TipoProrrateoImporDataAccess.save(tipoprorrateoimporLocal, connexion);				
				} else {
					validadoTodosTipoProrrateoImpor=false;
				}
			}
			
			if(!validadoTodosTipoProrrateoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSavesAfter(tipoprorrateoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProrrateoImpors();
			
			connexion.commit();		
			
			this.quitarTipoProrrateoImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProrrateoImpors()throws Exception {				
		 try {	
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSaves(tipoprorrateoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProrrateoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProrrateoImpor tipoprorrateoimporLocal:tipoprorrateoimpors) {				
				if(tipoprorrateoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProrrateoImporLogicAdditional.updateTipoProrrateoImporToSave(tipoprorrateoimporLocal,this.arrDatoGeneral);
	        	
				TipoProrrateoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprorrateoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProrrateoImpor(tipoprorrateoimporLocal)) {				
					TipoProrrateoImporDataAccess.save(tipoprorrateoimporLocal, connexion);				
				} else {
					validadoTodosTipoProrrateoImpor=false;
				}
			}
			
			if(!validadoTodosTipoProrrateoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProrrateoImporLogicAdditional.checkTipoProrrateoImporToSavesAfter(tipoprorrateoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProrrateoImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProrrateoImporParameterReturnGeneral procesarAccionTipoProrrateoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProrrateoImpor> tipoprorrateoimpors,TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporParameterGeneral)throws Exception {
		 try {	
			TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporReturnGeneral=new TipoProrrateoImporParameterReturnGeneral();
	
			
			return tipoprorrateoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProrrateoImporParameterReturnGeneral procesarAccionTipoProrrateoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProrrateoImpor> tipoprorrateoimpors,TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-procesarAccionTipoProrrateoImporsWithConnection");connexion.begin();			
			
			TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporReturnGeneral=new TipoProrrateoImporParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoprorrateoimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProrrateoImporParameterReturnGeneral procesarEventosTipoProrrateoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProrrateoImpor> tipoprorrateoimpors,TipoProrrateoImpor tipoprorrateoimpor,TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporParameterGeneral,Boolean isEsNuevoTipoProrrateoImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporReturnGeneral=new TipoProrrateoImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprorrateoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoprorrateoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProrrateoImporParameterReturnGeneral procesarEventosTipoProrrateoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProrrateoImpor> tipoprorrateoimpors,TipoProrrateoImpor tipoprorrateoimpor,TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporParameterGeneral,Boolean isEsNuevoTipoProrrateoImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-procesarEventosTipoProrrateoImporsWithConnection");connexion.begin();			
			
			TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporReturnGeneral=new TipoProrrateoImporParameterReturnGeneral();
	
			tipoprorrateoimporReturnGeneral.setTipoProrrateoImpor(tipoprorrateoimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprorrateoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoprorrateoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProrrateoImporParameterReturnGeneral procesarImportacionTipoProrrateoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProrrateoImpor.class.getSimpleName()+"-procesarImportacionTipoProrrateoImporsWithConnection");connexion.begin();			
			
			TipoProrrateoImporParameterReturnGeneral tipoprorrateoimporReturnGeneral=new TipoProrrateoImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprorrateoimpors=new ArrayList<TipoProrrateoImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprorrateoimpor=new TipoProrrateoImpor();
				
				
				if(conColumnasBase) {this.tipoprorrateoimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprorrateoimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprorrateoimpor.setcodigo(arrColumnas[iColumn++]);
				this.tipoprorrateoimpor.setnombre(arrColumnas[iColumn++]);
				
				this.tipoprorrateoimpors.add(this.tipoprorrateoimpor);
			}
			
			this.saveTipoProrrateoImpors();
			
			this.connexion.commit();
			
			tipoprorrateoimporReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprorrateoimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprorrateoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProrrateoImporsEliminados() throws Exception {				
		
		List<TipoProrrateoImpor> tipoprorrateoimporsAux= new ArrayList<TipoProrrateoImpor>();
		
		for(TipoProrrateoImpor tipoprorrateoimpor:tipoprorrateoimpors) {
			if(!tipoprorrateoimpor.getIsDeleted()) {
				tipoprorrateoimporsAux.add(tipoprorrateoimpor);
			}
		}
		
		tipoprorrateoimpors=tipoprorrateoimporsAux;
	}
	
	public void quitarTipoProrrateoImporsNulos() throws Exception {				
		
		List<TipoProrrateoImpor> tipoprorrateoimporsAux= new ArrayList<TipoProrrateoImpor>();
		
		for(TipoProrrateoImpor tipoprorrateoimpor : this.tipoprorrateoimpors) {
			if(tipoprorrateoimpor==null) {
				tipoprorrateoimporsAux.add(tipoprorrateoimpor);
			}
		}
		
		//this.tipoprorrateoimpors=tipoprorrateoimporsAux;
		
		this.tipoprorrateoimpors.removeAll(tipoprorrateoimporsAux);
	}
	
	public void getSetVersionRowTipoProrrateoImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprorrateoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprorrateoimpor.getIsDeleted() || (tipoprorrateoimpor.getIsChanged()&&!tipoprorrateoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprorrateoimporDataAccess.getSetVersionRowTipoProrrateoImpor(connexion,tipoprorrateoimpor.getId());
				
				if(!tipoprorrateoimpor.getVersionRow().equals(timestamp)) {	
					tipoprorrateoimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprorrateoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProrrateoImpor()throws Exception {	
		
		if(tipoprorrateoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprorrateoimpor.getIsDeleted() || (tipoprorrateoimpor.getIsChanged()&&!tipoprorrateoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprorrateoimporDataAccess.getSetVersionRowTipoProrrateoImpor(connexion,tipoprorrateoimpor.getId());
			
			try {							
				if(!tipoprorrateoimpor.getVersionRow().equals(timestamp)) {	
					tipoprorrateoimpor.setVersionRow(timestamp);
				}
				
				tipoprorrateoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProrrateoImporsWithConnection()throws Exception {	
		if(tipoprorrateoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProrrateoImpor tipoprorrateoimporAux:tipoprorrateoimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprorrateoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprorrateoimporAux.getIsDeleted() || (tipoprorrateoimporAux.getIsChanged()&&!tipoprorrateoimporAux.getIsNew())) {
						
						timestamp=tipoprorrateoimporDataAccess.getSetVersionRowTipoProrrateoImpor(connexion,tipoprorrateoimporAux.getId());
						
						if(!tipoprorrateoimpor.getVersionRow().equals(timestamp)) {	
							tipoprorrateoimporAux.setVersionRow(timestamp);
						}
								
						tipoprorrateoimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProrrateoImpors()throws Exception {	
		if(tipoprorrateoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProrrateoImpor tipoprorrateoimporAux:tipoprorrateoimpors) {
					if(tipoprorrateoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprorrateoimporAux.getIsDeleted() || (tipoprorrateoimporAux.getIsChanged()&&!tipoprorrateoimporAux.getIsNew())) {
						
						timestamp=tipoprorrateoimporDataAccess.getSetVersionRowTipoProrrateoImpor(connexion,tipoprorrateoimporAux.getId());
						
						if(!tipoprorrateoimporAux.getVersionRow().equals(timestamp)) {	
							tipoprorrateoimporAux.setVersionRow(timestamp);
						}
						
													
						tipoprorrateoimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoProrrateoImpor tipoprorrateoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoProrrateoImporLogicAdditional.updateTipoProrrateoImporToGet(tipoprorrateoimpor,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProrrateoImpor tipoprorrateoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProrrateoImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprorrateoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(tipoprorrateoimpor);
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
			this.deepLoad(this.tipoprorrateoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(this.tipoprorrateoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProrrateoImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprorrateoimpors!=null) {
				for(TipoProrrateoImpor tipoprorrateoimpor:tipoprorrateoimpors) {
					this.deepLoad(tipoprorrateoimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(tipoprorrateoimpors);
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
			if(tipoprorrateoimpors!=null) {
				for(TipoProrrateoImpor tipoprorrateoimpor:tipoprorrateoimpors) {
					this.deepLoad(tipoprorrateoimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProrrateoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoProrrateoImpor(tipoprorrateoimpors);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProrrateoImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProrrateoImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProrrateoImpor tipoprorrateoimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProrrateoImporConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprorrateoimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProrrateoImporDataAccess.TABLENAME, tipoprorrateoimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProrrateoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProrrateoImporLogic.registrarAuditoriaDetallesTipoProrrateoImpor(connexion,tipoprorrateoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprorrateoimpor.getIsDeleted()) {
					/*if(!tipoprorrateoimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProrrateoImporDataAccess.TABLENAME, tipoprorrateoimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProrrateoImporLogic.registrarAuditoriaDetallesTipoProrrateoImpor(connexion,tipoprorrateoimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProrrateoImporDataAccess.TABLENAME, tipoprorrateoimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprorrateoimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProrrateoImporDataAccess.TABLENAME, tipoprorrateoimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProrrateoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProrrateoImporLogic.registrarAuditoriaDetallesTipoProrrateoImpor(connexion,tipoprorrateoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProrrateoImpor(Connexion connexion,TipoProrrateoImpor tipoprorrateoimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprorrateoimpor.getIsNew()||!tipoprorrateoimpor.getcodigo().equals(tipoprorrateoimpor.getTipoProrrateoImporOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprorrateoimpor.getTipoProrrateoImporOriginal().getcodigo()!=null)
				{
					strValorActual=tipoprorrateoimpor.getTipoProrrateoImporOriginal().getcodigo();
				}
				if(tipoprorrateoimpor.getcodigo()!=null)
				{
					strValorNuevo=tipoprorrateoimpor.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProrrateoImporConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprorrateoimpor.getIsNew()||!tipoprorrateoimpor.getnombre().equals(tipoprorrateoimpor.getTipoProrrateoImporOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprorrateoimpor.getTipoProrrateoImporOriginal().getnombre()!=null)
				{
					strValorActual=tipoprorrateoimpor.getTipoProrrateoImporOriginal().getnombre();
				}
				if(tipoprorrateoimpor.getnombre()!=null)
				{
					strValorNuevo=tipoprorrateoimpor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProrrateoImporConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProrrateoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProrrateoImporConstantesFunciones.getClassesForeignKeysOfTipoProrrateoImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProrrateoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProrrateoImporConstantesFunciones.getClassesRelationshipsOfTipoProrrateoImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
