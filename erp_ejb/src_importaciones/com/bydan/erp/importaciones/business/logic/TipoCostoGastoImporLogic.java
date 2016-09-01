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
import com.bydan.erp.importaciones.util.TipoCostoGastoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.TipoCostoGastoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.TipoCostoGastoImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.TipoCostoGastoImpor;
//import com.bydan.erp.importaciones.business.logic.TipoCostoGastoImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCostoGastoImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCostoGastoImporLogic.class);
	
	protected TipoCostoGastoImporDataAccess tipocostogastoimporDataAccess; 	
	protected TipoCostoGastoImpor tipocostogastoimpor;
	protected List<TipoCostoGastoImpor> tipocostogastoimpors;
	protected Object tipocostogastoimporObject;	
	protected List<Object> tipocostogastoimporsObject;
	
	public static ClassValidator<TipoCostoGastoImpor> tipocostogastoimporValidator = new ClassValidator<TipoCostoGastoImpor>(TipoCostoGastoImpor.class);	
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
	
	
	
	
	public  TipoCostoGastoImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocostogastoimporDataAccess = new TipoCostoGastoImporDataAccess();
			
			this.tipocostogastoimpors= new ArrayList<TipoCostoGastoImpor>();
			this.tipocostogastoimpor= new TipoCostoGastoImpor();
			
			this.tipocostogastoimporObject=new Object();
			this.tipocostogastoimporsObject=new ArrayList<Object>();
				
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
			
			this.tipocostogastoimporDataAccess.setConnexionType(this.connexionType);
			this.tipocostogastoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCostoGastoImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocostogastoimporDataAccess = new TipoCostoGastoImporDataAccess();
			this.tipocostogastoimpors= new ArrayList<TipoCostoGastoImpor>();
			this.tipocostogastoimpor= new TipoCostoGastoImpor();
			this.tipocostogastoimporObject=new Object();
			this.tipocostogastoimporsObject=new ArrayList<Object>();
			
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
			
			this.tipocostogastoimporDataAccess.setConnexionType(this.connexionType);
			this.tipocostogastoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCostoGastoImpor getTipoCostoGastoImpor() throws Exception {	
		//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToGet(tipocostogastoimpor,this.datosCliente,this.arrDatoGeneral);
		//TipoCostoGastoImporLogicAdditional.updateTipoCostoGastoImporToGet(tipocostogastoimpor,this.arrDatoGeneral);
		
		return tipocostogastoimpor;
	}
		
	public void setTipoCostoGastoImpor(TipoCostoGastoImpor newTipoCostoGastoImpor) {
		this.tipocostogastoimpor = newTipoCostoGastoImpor;
	}
	
	public TipoCostoGastoImporDataAccess getTipoCostoGastoImporDataAccess() {
		return tipocostogastoimporDataAccess;
	}
	
	public void setTipoCostoGastoImporDataAccess(TipoCostoGastoImporDataAccess newtipocostogastoimporDataAccess) {
		this.tipocostogastoimporDataAccess = newtipocostogastoimporDataAccess;
	}
	
	public List<TipoCostoGastoImpor> getTipoCostoGastoImpors() throws Exception {		
		this.quitarTipoCostoGastoImporsNulos();
		
		//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToGets(tipocostogastoimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCostoGastoImpor tipocostogastoimporLocal: tipocostogastoimpors ) {
			//TipoCostoGastoImporLogicAdditional.updateTipoCostoGastoImporToGet(tipocostogastoimporLocal,this.arrDatoGeneral);
		}
		
		return tipocostogastoimpors;
	}
	
	public void setTipoCostoGastoImpors(List<TipoCostoGastoImpor> newTipoCostoGastoImpors) {
		this.tipocostogastoimpors = newTipoCostoGastoImpors;
	}
	
	public Object getTipoCostoGastoImporObject() {	
		this.tipocostogastoimporObject=this.tipocostogastoimporDataAccess.getEntityObject();
		return this.tipocostogastoimporObject;
	}
		
	public void setTipoCostoGastoImporObject(Object newTipoCostoGastoImporObject) {
		this.tipocostogastoimporObject = newTipoCostoGastoImporObject;
	}
	
	public List<Object> getTipoCostoGastoImporsObject() {		
		this.tipocostogastoimporsObject=this.tipocostogastoimporDataAccess.getEntitiesObject();
		return this.tipocostogastoimporsObject;
	}
		
	public void setTipoCostoGastoImporsObject(List<Object> newTipoCostoGastoImporsObject) {
		this.tipocostogastoimporsObject = newTipoCostoGastoImporsObject;
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
		
		if(this.tipocostogastoimporDataAccess!=null) {
			this.tipocostogastoimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocostogastoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocostogastoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocostogastoimpor=tipocostogastoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpor);
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  		  
        try {
			
			tipocostogastoimpor=tipocostogastoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocostogastoimpor=tipocostogastoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpor);
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  		  
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  		  
        try {
			
			tipocostogastoimpor=tipocostogastoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  		  
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocostogastoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocostogastoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocostogastoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocostogastoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocostogastoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocostogastoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
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
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		  		  
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
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		  		  
        try {			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		  		  
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
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
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
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		  		  
        try {
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
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
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
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
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpor=tipocostogastoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpor);
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
		tipocostogastoimpor = new  TipoCostoGastoImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpor=tipocostogastoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoCostoGastoImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-getTodosTipoCostoGastoImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
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
	
	public  void  getTodosTipoCostoGastoImpors(String sFinalQuery,Pagination pagination)throws Exception {
		tipocostogastoimpors = new  ArrayList<TipoCostoGastoImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostogastoimpors=tipocostogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCostoGastoImpor(tipocostogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocostogastoimpor.getIsNew() || tipocostogastoimpor.getIsChanged()) { 
			this.invalidValues = tipocostogastoimporValidator.getInvalidValues(tipocostogastoimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocostogastoimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCostoGastoImpor(List<TipoCostoGastoImpor> TipoCostoGastoImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCostoGastoImpor tipocostogastoimporLocal:tipocostogastoimpors) {				
			estaValidadoObjeto=this.validarGuardarTipoCostoGastoImpor(tipocostogastoimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCostoGastoImpor(List<TipoCostoGastoImpor> TipoCostoGastoImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCostoGastoImpor(tipocostogastoimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCostoGastoImpor(TipoCostoGastoImpor TipoCostoGastoImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCostoGastoImpor(tipocostogastoimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCostoGastoImpor tipocostogastoimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocostogastoimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCostoGastoImporConstantesFunciones.getTipoCostoGastoImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocostogastoimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCostoGastoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCostoGastoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCostoGastoImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-saveTipoCostoGastoImporWithConnection");connexion.begin();			
			
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSave(this.tipocostogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCostoGastoImporLogicAdditional.updateTipoCostoGastoImporToSave(this.tipocostogastoimpor,this.arrDatoGeneral);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocostogastoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCostoGastoImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCostoGastoImpor(this.tipocostogastoimpor)) {
				TipoCostoGastoImporDataAccess.save(this.tipocostogastoimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocostogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSaveAfter(this.tipocostogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCostoGastoImpor();
			
			connexion.commit();			
			
			if(this.tipocostogastoimpor.getIsDeleted()) {
				this.tipocostogastoimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCostoGastoImpor()throws Exception {	
		try {	
			
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSave(this.tipocostogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCostoGastoImporLogicAdditional.updateTipoCostoGastoImporToSave(this.tipocostogastoimpor,this.arrDatoGeneral);
			
			TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocostogastoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCostoGastoImpor(this.tipocostogastoimpor)) {			
				TipoCostoGastoImporDataAccess.save(this.tipocostogastoimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocostogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSaveAfter(this.tipocostogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocostogastoimpor.getIsDeleted()) {
				this.tipocostogastoimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCostoGastoImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-saveTipoCostoGastoImporsWithConnection");connexion.begin();			
			
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSaves(tipocostogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCostoGastoImpors();
			
			Boolean validadoTodosTipoCostoGastoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCostoGastoImpor tipocostogastoimporLocal:tipocostogastoimpors) {		
				if(tipocostogastoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCostoGastoImporLogicAdditional.updateTipoCostoGastoImporToSave(tipocostogastoimporLocal,this.arrDatoGeneral);
	        	
				TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocostogastoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCostoGastoImpor(tipocostogastoimporLocal)) {
					TipoCostoGastoImporDataAccess.save(tipocostogastoimporLocal, connexion);				
				} else {
					validadoTodosTipoCostoGastoImpor=false;
				}
			}
			
			if(!validadoTodosTipoCostoGastoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSavesAfter(tipocostogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCostoGastoImpors();
			
			connexion.commit();		
			
			this.quitarTipoCostoGastoImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCostoGastoImpors()throws Exception {				
		 try {	
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSaves(tipocostogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCostoGastoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCostoGastoImpor tipocostogastoimporLocal:tipocostogastoimpors) {				
				if(tipocostogastoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCostoGastoImporLogicAdditional.updateTipoCostoGastoImporToSave(tipocostogastoimporLocal,this.arrDatoGeneral);
	        	
				TipoCostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocostogastoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCostoGastoImpor(tipocostogastoimporLocal)) {				
					TipoCostoGastoImporDataAccess.save(tipocostogastoimporLocal, connexion);				
				} else {
					validadoTodosTipoCostoGastoImpor=false;
				}
			}
			
			if(!validadoTodosTipoCostoGastoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCostoGastoImporLogicAdditional.checkTipoCostoGastoImporToSavesAfter(tipocostogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCostoGastoImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCostoGastoImporParameterReturnGeneral procesarAccionTipoCostoGastoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCostoGastoImpor> tipocostogastoimpors,TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporParameterGeneral)throws Exception {
		 try {	
			TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporReturnGeneral=new TipoCostoGastoImporParameterReturnGeneral();
	
			
			return tipocostogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCostoGastoImporParameterReturnGeneral procesarAccionTipoCostoGastoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCostoGastoImpor> tipocostogastoimpors,TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-procesarAccionTipoCostoGastoImporsWithConnection");connexion.begin();			
			
			TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporReturnGeneral=new TipoCostoGastoImporParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipocostogastoimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCostoGastoImporParameterReturnGeneral procesarEventosTipoCostoGastoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCostoGastoImpor> tipocostogastoimpors,TipoCostoGastoImpor tipocostogastoimpor,TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporParameterGeneral,Boolean isEsNuevoTipoCostoGastoImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporReturnGeneral=new TipoCostoGastoImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocostogastoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipocostogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCostoGastoImporParameterReturnGeneral procesarEventosTipoCostoGastoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCostoGastoImpor> tipocostogastoimpors,TipoCostoGastoImpor tipocostogastoimpor,TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporParameterGeneral,Boolean isEsNuevoTipoCostoGastoImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-procesarEventosTipoCostoGastoImporsWithConnection");connexion.begin();			
			
			TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporReturnGeneral=new TipoCostoGastoImporParameterReturnGeneral();
	
			tipocostogastoimporReturnGeneral.setTipoCostoGastoImpor(tipocostogastoimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocostogastoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipocostogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCostoGastoImporParameterReturnGeneral procesarImportacionTipoCostoGastoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoGastoImpor.class.getSimpleName()+"-procesarImportacionTipoCostoGastoImporsWithConnection");connexion.begin();			
			
			TipoCostoGastoImporParameterReturnGeneral tipocostogastoimporReturnGeneral=new TipoCostoGastoImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocostogastoimpors=new ArrayList<TipoCostoGastoImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocostogastoimpor=new TipoCostoGastoImpor();
				
				
				if(conColumnasBase) {this.tipocostogastoimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocostogastoimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocostogastoimpor.setcodigo(arrColumnas[iColumn++]);
				this.tipocostogastoimpor.setnombre(arrColumnas[iColumn++]);
				
				this.tipocostogastoimpors.add(this.tipocostogastoimpor);
			}
			
			this.saveTipoCostoGastoImpors();
			
			this.connexion.commit();
			
			tipocostogastoimporReturnGeneral.setConRetornoEstaProcesado(true);
			tipocostogastoimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocostogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCostoGastoImporsEliminados() throws Exception {				
		
		List<TipoCostoGastoImpor> tipocostogastoimporsAux= new ArrayList<TipoCostoGastoImpor>();
		
		for(TipoCostoGastoImpor tipocostogastoimpor:tipocostogastoimpors) {
			if(!tipocostogastoimpor.getIsDeleted()) {
				tipocostogastoimporsAux.add(tipocostogastoimpor);
			}
		}
		
		tipocostogastoimpors=tipocostogastoimporsAux;
	}
	
	public void quitarTipoCostoGastoImporsNulos() throws Exception {				
		
		List<TipoCostoGastoImpor> tipocostogastoimporsAux= new ArrayList<TipoCostoGastoImpor>();
		
		for(TipoCostoGastoImpor tipocostogastoimpor : this.tipocostogastoimpors) {
			if(tipocostogastoimpor==null) {
				tipocostogastoimporsAux.add(tipocostogastoimpor);
			}
		}
		
		//this.tipocostogastoimpors=tipocostogastoimporsAux;
		
		this.tipocostogastoimpors.removeAll(tipocostogastoimporsAux);
	}
	
	public void getSetVersionRowTipoCostoGastoImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocostogastoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocostogastoimpor.getIsDeleted() || (tipocostogastoimpor.getIsChanged()&&!tipocostogastoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocostogastoimporDataAccess.getSetVersionRowTipoCostoGastoImpor(connexion,tipocostogastoimpor.getId());
				
				if(!tipocostogastoimpor.getVersionRow().equals(timestamp)) {	
					tipocostogastoimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocostogastoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCostoGastoImpor()throws Exception {	
		
		if(tipocostogastoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocostogastoimpor.getIsDeleted() || (tipocostogastoimpor.getIsChanged()&&!tipocostogastoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocostogastoimporDataAccess.getSetVersionRowTipoCostoGastoImpor(connexion,tipocostogastoimpor.getId());
			
			try {							
				if(!tipocostogastoimpor.getVersionRow().equals(timestamp)) {	
					tipocostogastoimpor.setVersionRow(timestamp);
				}
				
				tipocostogastoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCostoGastoImporsWithConnection()throws Exception {	
		if(tipocostogastoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCostoGastoImpor tipocostogastoimporAux:tipocostogastoimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocostogastoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocostogastoimporAux.getIsDeleted() || (tipocostogastoimporAux.getIsChanged()&&!tipocostogastoimporAux.getIsNew())) {
						
						timestamp=tipocostogastoimporDataAccess.getSetVersionRowTipoCostoGastoImpor(connexion,tipocostogastoimporAux.getId());
						
						if(!tipocostogastoimpor.getVersionRow().equals(timestamp)) {	
							tipocostogastoimporAux.setVersionRow(timestamp);
						}
								
						tipocostogastoimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCostoGastoImpors()throws Exception {	
		if(tipocostogastoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCostoGastoImpor tipocostogastoimporAux:tipocostogastoimpors) {
					if(tipocostogastoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocostogastoimporAux.getIsDeleted() || (tipocostogastoimporAux.getIsChanged()&&!tipocostogastoimporAux.getIsNew())) {
						
						timestamp=tipocostogastoimporDataAccess.getSetVersionRowTipoCostoGastoImpor(connexion,tipocostogastoimporAux.getId());
						
						if(!tipocostogastoimporAux.getVersionRow().equals(timestamp)) {	
							tipocostogastoimporAux.setVersionRow(timestamp);
						}
						
													
						tipocostogastoimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoCostoGastoImpor tipocostogastoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoCostoGastoImporLogicAdditional.updateTipoCostoGastoImporToGet(tipocostogastoimpor,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCostoGastoImpor tipocostogastoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCostoGastoImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocostogastoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(tipocostogastoimpor);
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
			this.deepLoad(this.tipocostogastoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(this.tipocostogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCostoGastoImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocostogastoimpors!=null) {
				for(TipoCostoGastoImpor tipocostogastoimpor:tipocostogastoimpors) {
					this.deepLoad(tipocostogastoimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(tipocostogastoimpors);
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
			if(tipocostogastoimpors!=null) {
				for(TipoCostoGastoImpor tipocostogastoimpor:tipocostogastoimpors) {
					this.deepLoad(tipocostogastoimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoGastoImpor(tipocostogastoimpors);
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
			if(TipoCostoGastoImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoGastoImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCostoGastoImpor tipocostogastoimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCostoGastoImporConstantesFunciones.ISCONAUDITORIA) {
				if(tipocostogastoimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoGastoImporDataAccess.TABLENAME, tipocostogastoimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCostoGastoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCostoGastoImporLogic.registrarAuditoriaDetallesTipoCostoGastoImpor(connexion,tipocostogastoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocostogastoimpor.getIsDeleted()) {
					/*if(!tipocostogastoimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCostoGastoImporDataAccess.TABLENAME, tipocostogastoimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCostoGastoImporLogic.registrarAuditoriaDetallesTipoCostoGastoImpor(connexion,tipocostogastoimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoGastoImporDataAccess.TABLENAME, tipocostogastoimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocostogastoimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoGastoImporDataAccess.TABLENAME, tipocostogastoimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCostoGastoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCostoGastoImporLogic.registrarAuditoriaDetallesTipoCostoGastoImpor(connexion,tipocostogastoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCostoGastoImpor(Connexion connexion,TipoCostoGastoImpor tipocostogastoimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocostogastoimpor.getIsNew()||!tipocostogastoimpor.getcodigo().equals(tipocostogastoimpor.getTipoCostoGastoImporOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocostogastoimpor.getTipoCostoGastoImporOriginal().getcodigo()!=null)
				{
					strValorActual=tipocostogastoimpor.getTipoCostoGastoImporOriginal().getcodigo();
				}
				if(tipocostogastoimpor.getcodigo()!=null)
				{
					strValorNuevo=tipocostogastoimpor.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCostoGastoImporConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocostogastoimpor.getIsNew()||!tipocostogastoimpor.getnombre().equals(tipocostogastoimpor.getTipoCostoGastoImporOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocostogastoimpor.getTipoCostoGastoImporOriginal().getnombre()!=null)
				{
					strValorActual=tipocostogastoimpor.getTipoCostoGastoImporOriginal().getnombre();
				}
				if(tipocostogastoimpor.getnombre()!=null)
				{
					strValorNuevo=tipocostogastoimpor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCostoGastoImporConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCostoGastoImporConstantesFunciones.getClassesForeignKeysOfTipoCostoGastoImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCostoGastoImporConstantesFunciones.getClassesRelationshipsOfTipoCostoGastoImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
