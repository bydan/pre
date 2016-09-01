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
import com.bydan.erp.importaciones.util.CostoGastoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.CostoGastoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.CostoGastoImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.CostoGastoImpor;
import com.bydan.erp.importaciones.business.logic.CostoGastoImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CostoGastoImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CostoGastoImporLogic.class);
	
	protected CostoGastoImporDataAccess costogastoimporDataAccess; 	
	protected CostoGastoImpor costogastoimpor;
	protected List<CostoGastoImpor> costogastoimpors;
	protected Object costogastoimporObject;	
	protected List<Object> costogastoimporsObject;
	
	public static ClassValidator<CostoGastoImpor> costogastoimporValidator = new ClassValidator<CostoGastoImpor>(CostoGastoImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CostoGastoImporLogicAdditional costogastoimporLogicAdditional=null;
	
	public CostoGastoImporLogicAdditional getCostoGastoImporLogicAdditional() {
		return this.costogastoimporLogicAdditional;
	}
	
	public void setCostoGastoImporLogicAdditional(CostoGastoImporLogicAdditional costogastoimporLogicAdditional) {
		try {
			this.costogastoimporLogicAdditional=costogastoimporLogicAdditional;
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
	
	
	
	
	public  CostoGastoImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.costogastoimporDataAccess = new CostoGastoImporDataAccess();
			
			this.costogastoimpors= new ArrayList<CostoGastoImpor>();
			this.costogastoimpor= new CostoGastoImpor();
			
			this.costogastoimporObject=new Object();
			this.costogastoimporsObject=new ArrayList<Object>();
				
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
			
			this.costogastoimporDataAccess.setConnexionType(this.connexionType);
			this.costogastoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CostoGastoImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.costogastoimporDataAccess = new CostoGastoImporDataAccess();
			this.costogastoimpors= new ArrayList<CostoGastoImpor>();
			this.costogastoimpor= new CostoGastoImpor();
			this.costogastoimporObject=new Object();
			this.costogastoimporsObject=new ArrayList<Object>();
			
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
			
			this.costogastoimporDataAccess.setConnexionType(this.connexionType);
			this.costogastoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CostoGastoImpor getCostoGastoImpor() throws Exception {	
		CostoGastoImporLogicAdditional.checkCostoGastoImporToGet(costogastoimpor,this.datosCliente,this.arrDatoGeneral);
		CostoGastoImporLogicAdditional.updateCostoGastoImporToGet(costogastoimpor,this.arrDatoGeneral);
		
		return costogastoimpor;
	}
		
	public void setCostoGastoImpor(CostoGastoImpor newCostoGastoImpor) {
		this.costogastoimpor = newCostoGastoImpor;
	}
	
	public CostoGastoImporDataAccess getCostoGastoImporDataAccess() {
		return costogastoimporDataAccess;
	}
	
	public void setCostoGastoImporDataAccess(CostoGastoImporDataAccess newcostogastoimporDataAccess) {
		this.costogastoimporDataAccess = newcostogastoimporDataAccess;
	}
	
	public List<CostoGastoImpor> getCostoGastoImpors() throws Exception {		
		this.quitarCostoGastoImporsNulos();
		
		CostoGastoImporLogicAdditional.checkCostoGastoImporToGets(costogastoimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (CostoGastoImpor costogastoimporLocal: costogastoimpors ) {
			CostoGastoImporLogicAdditional.updateCostoGastoImporToGet(costogastoimporLocal,this.arrDatoGeneral);
		}
		
		return costogastoimpors;
	}
	
	public void setCostoGastoImpors(List<CostoGastoImpor> newCostoGastoImpors) {
		this.costogastoimpors = newCostoGastoImpors;
	}
	
	public Object getCostoGastoImporObject() {	
		this.costogastoimporObject=this.costogastoimporDataAccess.getEntityObject();
		return this.costogastoimporObject;
	}
		
	public void setCostoGastoImporObject(Object newCostoGastoImporObject) {
		this.costogastoimporObject = newCostoGastoImporObject;
	}
	
	public List<Object> getCostoGastoImporsObject() {		
		this.costogastoimporsObject=this.costogastoimporDataAccess.getEntitiesObject();
		return this.costogastoimporsObject;
	}
		
	public void setCostoGastoImporsObject(List<Object> newCostoGastoImporsObject) {
		this.costogastoimporsObject = newCostoGastoImporsObject;
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
		
		if(this.costogastoimporDataAccess!=null) {
			this.costogastoimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			costogastoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			costogastoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		costogastoimpor = new  CostoGastoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			costogastoimpor=costogastoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.costogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpor);
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
		costogastoimpor = new  CostoGastoImpor();
		  		  
        try {
			
			costogastoimpor=costogastoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.costogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		costogastoimpor = new  CostoGastoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			costogastoimpor=costogastoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.costogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpor);
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
		costogastoimpor = new  CostoGastoImpor();
		  		  
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
		costogastoimpor = new  CostoGastoImpor();
		  		  
        try {
			
			costogastoimpor=costogastoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.costogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		costogastoimpor = new  CostoGastoImpor();
		  		  
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
		costogastoimpor = new  CostoGastoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =costogastoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		costogastoimpor = new  CostoGastoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=costogastoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		costogastoimpor = new  CostoGastoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =costogastoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		costogastoimpor = new  CostoGastoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=costogastoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		costogastoimpor = new  CostoGastoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =costogastoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		costogastoimpor = new  CostoGastoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=costogastoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
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
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
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
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
        try {			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
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
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
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
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
        try {
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
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
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
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
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		costogastoimpor = new  CostoGastoImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpor=costogastoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpor);
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
		costogastoimpor = new  CostoGastoImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpor=costogastoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
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
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		  		  
        try {
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCostoGastoImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getTodosCostoGastoImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
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
	
	public  void  getTodosCostoGastoImpors(String sFinalQuery,Pagination pagination)throws Exception {
		costogastoimpors = new  ArrayList<CostoGastoImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCostoGastoImpor(costogastoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCostoGastoImpor(CostoGastoImpor costogastoimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(costogastoimpor.getIsNew() || costogastoimpor.getIsChanged()) { 
			this.invalidValues = costogastoimporValidator.getInvalidValues(costogastoimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(costogastoimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCostoGastoImpor(List<CostoGastoImpor> CostoGastoImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CostoGastoImpor costogastoimporLocal:costogastoimpors) {				
			estaValidadoObjeto=this.validarGuardarCostoGastoImpor(costogastoimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCostoGastoImpor(List<CostoGastoImpor> CostoGastoImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCostoGastoImpor(costogastoimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCostoGastoImpor(CostoGastoImpor CostoGastoImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCostoGastoImpor(costogastoimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CostoGastoImpor costogastoimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+costogastoimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CostoGastoImporConstantesFunciones.getCostoGastoImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"costogastoimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CostoGastoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CostoGastoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCostoGastoImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-saveCostoGastoImporWithConnection");connexion.begin();			
			
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSave(this.costogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CostoGastoImporLogicAdditional.updateCostoGastoImporToSave(this.costogastoimpor,this.arrDatoGeneral);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.costogastoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCostoGastoImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCostoGastoImpor(this.costogastoimpor)) {
				CostoGastoImporDataAccess.save(this.costogastoimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.costogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSaveAfter(this.costogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCostoGastoImpor();
			
			connexion.commit();			
			
			if(this.costogastoimpor.getIsDeleted()) {
				this.costogastoimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCostoGastoImpor()throws Exception {	
		try {	
			
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSave(this.costogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CostoGastoImporLogicAdditional.updateCostoGastoImporToSave(this.costogastoimpor,this.arrDatoGeneral);
			
			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.costogastoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCostoGastoImpor(this.costogastoimpor)) {			
				CostoGastoImporDataAccess.save(this.costogastoimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.costogastoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSaveAfter(this.costogastoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.costogastoimpor.getIsDeleted()) {
				this.costogastoimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCostoGastoImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-saveCostoGastoImporsWithConnection");connexion.begin();			
			
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSaves(costogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCostoGastoImpors();
			
			Boolean validadoTodosCostoGastoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CostoGastoImpor costogastoimporLocal:costogastoimpors) {		
				if(costogastoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CostoGastoImporLogicAdditional.updateCostoGastoImporToSave(costogastoimporLocal,this.arrDatoGeneral);
	        	
				CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),costogastoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCostoGastoImpor(costogastoimporLocal)) {
					CostoGastoImporDataAccess.save(costogastoimporLocal, connexion);				
				} else {
					validadoTodosCostoGastoImpor=false;
				}
			}
			
			if(!validadoTodosCostoGastoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSavesAfter(costogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCostoGastoImpors();
			
			connexion.commit();		
			
			this.quitarCostoGastoImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCostoGastoImpors()throws Exception {				
		 try {	
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSaves(costogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCostoGastoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CostoGastoImpor costogastoimporLocal:costogastoimpors) {				
				if(costogastoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CostoGastoImporLogicAdditional.updateCostoGastoImporToSave(costogastoimporLocal,this.arrDatoGeneral);
	        	
				CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),costogastoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCostoGastoImpor(costogastoimporLocal)) {				
					CostoGastoImporDataAccess.save(costogastoimporLocal, connexion);				
				} else {
					validadoTodosCostoGastoImpor=false;
				}
			}
			
			if(!validadoTodosCostoGastoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CostoGastoImporLogicAdditional.checkCostoGastoImporToSavesAfter(costogastoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCostoGastoImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CostoGastoImporParameterReturnGeneral procesarAccionCostoGastoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CostoGastoImpor> costogastoimpors,CostoGastoImporParameterReturnGeneral costogastoimporParameterGeneral)throws Exception {
		 try {	
			CostoGastoImporParameterReturnGeneral costogastoimporReturnGeneral=new CostoGastoImporParameterReturnGeneral();
	
			CostoGastoImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,costogastoimpors,costogastoimporParameterGeneral,costogastoimporReturnGeneral);
			
			return costogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CostoGastoImporParameterReturnGeneral procesarAccionCostoGastoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CostoGastoImpor> costogastoimpors,CostoGastoImporParameterReturnGeneral costogastoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-procesarAccionCostoGastoImporsWithConnection");connexion.begin();			
			
			CostoGastoImporParameterReturnGeneral costogastoimporReturnGeneral=new CostoGastoImporParameterReturnGeneral();
	
			CostoGastoImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,costogastoimpors,costogastoimporParameterGeneral,costogastoimporReturnGeneral);
			
			this.connexion.commit();
			
			return costogastoimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CostoGastoImporParameterReturnGeneral procesarEventosCostoGastoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CostoGastoImpor> costogastoimpors,CostoGastoImpor costogastoimpor,CostoGastoImporParameterReturnGeneral costogastoimporParameterGeneral,Boolean isEsNuevoCostoGastoImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			CostoGastoImporParameterReturnGeneral costogastoimporReturnGeneral=new CostoGastoImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				costogastoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CostoGastoImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,costogastoimpors,costogastoimpor,costogastoimporParameterGeneral,costogastoimporReturnGeneral,isEsNuevoCostoGastoImpor,clases);
			
			return costogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CostoGastoImporParameterReturnGeneral procesarEventosCostoGastoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CostoGastoImpor> costogastoimpors,CostoGastoImpor costogastoimpor,CostoGastoImporParameterReturnGeneral costogastoimporParameterGeneral,Boolean isEsNuevoCostoGastoImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-procesarEventosCostoGastoImporsWithConnection");connexion.begin();			
			
			CostoGastoImporParameterReturnGeneral costogastoimporReturnGeneral=new CostoGastoImporParameterReturnGeneral();
	
			costogastoimporReturnGeneral.setCostoGastoImpor(costogastoimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				costogastoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CostoGastoImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,costogastoimpors,costogastoimpor,costogastoimporParameterGeneral,costogastoimporReturnGeneral,isEsNuevoCostoGastoImpor,clases);
			
			this.connexion.commit();
			
			return costogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CostoGastoImporParameterReturnGeneral procesarImportacionCostoGastoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CostoGastoImporParameterReturnGeneral costogastoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-procesarImportacionCostoGastoImporsWithConnection");connexion.begin();			
			
			CostoGastoImporParameterReturnGeneral costogastoimporReturnGeneral=new CostoGastoImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.costogastoimpors=new ArrayList<CostoGastoImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.costogastoimpor=new CostoGastoImpor();
				
				
				if(conColumnasBase) {this.costogastoimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.costogastoimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.costogastoimpor.setnombre(arrColumnas[iColumn++]);
				this.costogastoimpor.setes_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_agrupa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_prorratea(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_flete(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_arancel(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_seguro(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_total_general(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.costogastoimpor.setcon_digitado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.costogastoimpors.add(this.costogastoimpor);
			}
			
			this.saveCostoGastoImpors();
			
			this.connexion.commit();
			
			costogastoimporReturnGeneral.setConRetornoEstaProcesado(true);
			costogastoimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return costogastoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCostoGastoImporsEliminados() throws Exception {				
		
		List<CostoGastoImpor> costogastoimporsAux= new ArrayList<CostoGastoImpor>();
		
		for(CostoGastoImpor costogastoimpor:costogastoimpors) {
			if(!costogastoimpor.getIsDeleted()) {
				costogastoimporsAux.add(costogastoimpor);
			}
		}
		
		costogastoimpors=costogastoimporsAux;
	}
	
	public void quitarCostoGastoImporsNulos() throws Exception {				
		
		List<CostoGastoImpor> costogastoimporsAux= new ArrayList<CostoGastoImpor>();
		
		for(CostoGastoImpor costogastoimpor : this.costogastoimpors) {
			if(costogastoimpor==null) {
				costogastoimporsAux.add(costogastoimpor);
			}
		}
		
		//this.costogastoimpors=costogastoimporsAux;
		
		this.costogastoimpors.removeAll(costogastoimporsAux);
	}
	
	public void getSetVersionRowCostoGastoImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(costogastoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((costogastoimpor.getIsDeleted() || (costogastoimpor.getIsChanged()&&!costogastoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=costogastoimporDataAccess.getSetVersionRowCostoGastoImpor(connexion,costogastoimpor.getId());
				
				if(!costogastoimpor.getVersionRow().equals(timestamp)) {	
					costogastoimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				costogastoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCostoGastoImpor()throws Exception {	
		
		if(costogastoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((costogastoimpor.getIsDeleted() || (costogastoimpor.getIsChanged()&&!costogastoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=costogastoimporDataAccess.getSetVersionRowCostoGastoImpor(connexion,costogastoimpor.getId());
			
			try {							
				if(!costogastoimpor.getVersionRow().equals(timestamp)) {	
					costogastoimpor.setVersionRow(timestamp);
				}
				
				costogastoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCostoGastoImporsWithConnection()throws Exception {	
		if(costogastoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CostoGastoImpor costogastoimporAux:costogastoimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(costogastoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(costogastoimporAux.getIsDeleted() || (costogastoimporAux.getIsChanged()&&!costogastoimporAux.getIsNew())) {
						
						timestamp=costogastoimporDataAccess.getSetVersionRowCostoGastoImpor(connexion,costogastoimporAux.getId());
						
						if(!costogastoimpor.getVersionRow().equals(timestamp)) {	
							costogastoimporAux.setVersionRow(timestamp);
						}
								
						costogastoimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCostoGastoImpors()throws Exception {	
		if(costogastoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CostoGastoImpor costogastoimporAux:costogastoimpors) {
					if(costogastoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(costogastoimporAux.getIsDeleted() || (costogastoimporAux.getIsChanged()&&!costogastoimporAux.getIsNew())) {
						
						timestamp=costogastoimporDataAccess.getSetVersionRowCostoGastoImpor(connexion,costogastoimporAux.getId());
						
						if(!costogastoimporAux.getVersionRow().equals(timestamp)) {	
							costogastoimporAux.setVersionRow(timestamp);
						}
						
													
						costogastoimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CostoGastoImporParameterReturnGeneral cargarCombosLoteForeignKeyCostoGastoImporWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoCostoGastoImpor) throws Exception {
		CostoGastoImporParameterReturnGeneral  costogastoimporReturnGeneral =new CostoGastoImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyCostoGastoImporWithConnection");connexion.begin();
			
			costogastoimporReturnGeneral =new CostoGastoImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			costogastoimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			costogastoimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoCostoGastoImpor> tipocostogastoimporsForeignKey=new ArrayList<TipoCostoGastoImpor>();
			TipoCostoGastoImporLogic tipocostogastoimporLogic=new TipoCostoGastoImporLogic();
			tipocostogastoimporLogic.setConnexion(this.connexion);
			tipocostogastoimporLogic.getTipoCostoGastoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCostoGastoImpor.equals("NONE")) {
				tipocostogastoimporLogic.getTodosTipoCostoGastoImpors(finalQueryGlobalTipoCostoGastoImpor,new Pagination());
				tipocostogastoimporsForeignKey=tipocostogastoimporLogic.getTipoCostoGastoImpors();
			}

			costogastoimporReturnGeneral.settipocostogastoimporsForeignKey(tipocostogastoimporsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return costogastoimporReturnGeneral;
	}
	
	public CostoGastoImporParameterReturnGeneral cargarCombosLoteForeignKeyCostoGastoImpor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoCostoGastoImpor) throws Exception {
		CostoGastoImporParameterReturnGeneral  costogastoimporReturnGeneral =new CostoGastoImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			costogastoimporReturnGeneral =new CostoGastoImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			costogastoimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			costogastoimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoCostoGastoImpor> tipocostogastoimporsForeignKey=new ArrayList<TipoCostoGastoImpor>();
			TipoCostoGastoImporLogic tipocostogastoimporLogic=new TipoCostoGastoImporLogic();
			tipocostogastoimporLogic.setConnexion(this.connexion);
			tipocostogastoimporLogic.getTipoCostoGastoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCostoGastoImpor.equals("NONE")) {
				tipocostogastoimporLogic.getTodosTipoCostoGastoImpors(finalQueryGlobalTipoCostoGastoImpor,new Pagination());
				tipocostogastoimporsForeignKey=tipocostogastoimporLogic.getTipoCostoGastoImpors();
			}

			costogastoimporReturnGeneral.settipocostogastoimporsForeignKey(tipocostogastoimporsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return costogastoimporReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCostoGastoImporWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic=new DetalleLiquidacionImporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCostoGastoImporWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleLiquidacionImpor.class));
											
			

			detalleliquidacionimporLogic.setConnexion(this.getConnexion());
			detalleliquidacionimporLogic.setDatosCliente(this.datosCliente);
			detalleliquidacionimporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CostoGastoImpor costogastoimpor:this.costogastoimpors) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleLiquidacionImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleliquidacionimporLogic.setDetalleLiquidacionImpors(costogastoimpor.detalleliquidacionimpors);
				detalleliquidacionimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CostoGastoImpor costogastoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CostoGastoImporLogicAdditional.updateCostoGastoImporToGet(costogastoimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		costogastoimpor.setEmpresa(costogastoimporDataAccess.getEmpresa(connexion,costogastoimpor));
		costogastoimpor.setSucursal(costogastoimporDataAccess.getSucursal(connexion,costogastoimpor));
		costogastoimpor.setTipoCostoGastoImpor(costogastoimporDataAccess.getTipoCostoGastoImpor(connexion,costogastoimpor));
		costogastoimpor.setDetalleLiquidacionImpors(costogastoimporDataAccess.getDetalleLiquidacionImpors(connexion,costogastoimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				costogastoimpor.setEmpresa(costogastoimporDataAccess.getEmpresa(connexion,costogastoimpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				costogastoimpor.setSucursal(costogastoimporDataAccess.getSucursal(connexion,costogastoimpor));
				continue;
			}

			if(clas.clas.equals(TipoCostoGastoImpor.class)) {
				costogastoimpor.setTipoCostoGastoImpor(costogastoimporDataAccess.getTipoCostoGastoImpor(connexion,costogastoimpor));
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				costogastoimpor.setDetalleLiquidacionImpors(costogastoimporDataAccess.getDetalleLiquidacionImpors(connexion,costogastoimpor));

				if(this.isConDeep) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(this.connexion);
					detalleliquidacionimporLogic.setDetalleLiquidacionImpors(costogastoimpor.getDetalleLiquidacionImpors());
					ArrayList<Classe> classesLocal=DetalleLiquidacionImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleliquidacionimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(detalleliquidacionimporLogic.getDetalleLiquidacionImpors());
					costogastoimpor.setDetalleLiquidacionImpors(detalleliquidacionimporLogic.getDetalleLiquidacionImpors());
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
			costogastoimpor.setEmpresa(costogastoimporDataAccess.getEmpresa(connexion,costogastoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			costogastoimpor.setSucursal(costogastoimporDataAccess.getSucursal(connexion,costogastoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCostoGastoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			costogastoimpor.setTipoCostoGastoImpor(costogastoimporDataAccess.getTipoCostoGastoImpor(connexion,costogastoimpor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpor.class));
			costogastoimpor.setDetalleLiquidacionImpors(costogastoimporDataAccess.getDetalleLiquidacionImpors(connexion,costogastoimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		costogastoimpor.setEmpresa(costogastoimporDataAccess.getEmpresa(connexion,costogastoimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(costogastoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		costogastoimpor.setSucursal(costogastoimporDataAccess.getSucursal(connexion,costogastoimpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(costogastoimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		costogastoimpor.setTipoCostoGastoImpor(costogastoimporDataAccess.getTipoCostoGastoImpor(connexion,costogastoimpor));
		TipoCostoGastoImporLogic tipocostogastoimporLogic= new TipoCostoGastoImporLogic(connexion);
		tipocostogastoimporLogic.deepLoad(costogastoimpor.getTipoCostoGastoImpor(),isDeep,deepLoadType,clases);
				

		costogastoimpor.setDetalleLiquidacionImpors(costogastoimporDataAccess.getDetalleLiquidacionImpors(connexion,costogastoimpor));

		for(DetalleLiquidacionImpor detalleliquidacionimpor:costogastoimpor.getDetalleLiquidacionImpors()) {
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
			detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				costogastoimpor.setEmpresa(costogastoimporDataAccess.getEmpresa(connexion,costogastoimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(costogastoimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				costogastoimpor.setSucursal(costogastoimporDataAccess.getSucursal(connexion,costogastoimpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(costogastoimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCostoGastoImpor.class)) {
				costogastoimpor.setTipoCostoGastoImpor(costogastoimporDataAccess.getTipoCostoGastoImpor(connexion,costogastoimpor));
				TipoCostoGastoImporLogic tipocostogastoimporLogic= new TipoCostoGastoImporLogic(connexion);
				tipocostogastoimporLogic.deepLoad(costogastoimpor.getTipoCostoGastoImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				costogastoimpor.setDetalleLiquidacionImpors(costogastoimporDataAccess.getDetalleLiquidacionImpors(connexion,costogastoimpor));

				for(DetalleLiquidacionImpor detalleliquidacionimpor:costogastoimpor.getDetalleLiquidacionImpors()) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
					detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
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
			costogastoimpor.setEmpresa(costogastoimporDataAccess.getEmpresa(connexion,costogastoimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(costogastoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			costogastoimpor.setSucursal(costogastoimporDataAccess.getSucursal(connexion,costogastoimpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(costogastoimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCostoGastoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			costogastoimpor.setTipoCostoGastoImpor(costogastoimporDataAccess.getTipoCostoGastoImpor(connexion,costogastoimpor));
			TipoCostoGastoImporLogic tipocostogastoimporLogic= new TipoCostoGastoImporLogic(connexion);
			tipocostogastoimporLogic.deepLoad(costogastoimpor.getTipoCostoGastoImpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpor.class));
			costogastoimpor.setDetalleLiquidacionImpors(costogastoimporDataAccess.getDetalleLiquidacionImpors(connexion,costogastoimpor));

			for(DetalleLiquidacionImpor detalleliquidacionimpor:costogastoimpor.getDetalleLiquidacionImpors()) {
				DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
				detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CostoGastoImpor costogastoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CostoGastoImporLogicAdditional.updateCostoGastoImporToSave(costogastoimpor,this.arrDatoGeneral);
			
CostoGastoImporDataAccess.save(costogastoimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(costogastoimpor.getEmpresa(),connexion);

		SucursalDataAccess.save(costogastoimpor.getSucursal(),connexion);

		TipoCostoGastoImporDataAccess.save(costogastoimpor.getTipoCostoGastoImpor(),connexion);

		for(DetalleLiquidacionImpor detalleliquidacionimpor:costogastoimpor.getDetalleLiquidacionImpors()) {
			detalleliquidacionimpor.setid_costo_gasto_impor(costogastoimpor.getId());
			DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(costogastoimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(costogastoimpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCostoGastoImpor.class)) {
				TipoCostoGastoImporDataAccess.save(costogastoimpor.getTipoCostoGastoImpor(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpor detalleliquidacionimpor:costogastoimpor.getDetalleLiquidacionImpors()) {
					detalleliquidacionimpor.setid_costo_gasto_impor(costogastoimpor.getId());
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(costogastoimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(costogastoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(costogastoimpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(costogastoimpor.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoCostoGastoImporDataAccess.save(costogastoimpor.getTipoCostoGastoImpor(),connexion);
		TipoCostoGastoImporLogic tipocostogastoimporLogic= new TipoCostoGastoImporLogic(connexion);
		tipocostogastoimporLogic.deepLoad(costogastoimpor.getTipoCostoGastoImpor(),isDeep,deepLoadType,clases);
				

		for(DetalleLiquidacionImpor detalleliquidacionimpor:costogastoimpor.getDetalleLiquidacionImpors()) {
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
			detalleliquidacionimpor.setid_costo_gasto_impor(costogastoimpor.getId());
			DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
			detalleliquidacionimporLogic.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(costogastoimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(costogastoimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(costogastoimpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(costogastoimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCostoGastoImpor.class)) {
				TipoCostoGastoImporDataAccess.save(costogastoimpor.getTipoCostoGastoImpor(),connexion);
				TipoCostoGastoImporLogic tipocostogastoimporLogic= new TipoCostoGastoImporLogic(connexion);
				tipocostogastoimporLogic.deepSave(costogastoimpor.getTipoCostoGastoImpor(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpor detalleliquidacionimpor:costogastoimpor.getDetalleLiquidacionImpors()) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
					detalleliquidacionimpor.setid_costo_gasto_impor(costogastoimpor.getId());
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
					detalleliquidacionimporLogic.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CostoGastoImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(costogastoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(costogastoimpor);
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
			this.deepLoad(this.costogastoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CostoGastoImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(costogastoimpors!=null) {
				for(CostoGastoImpor costogastoimpor:costogastoimpors) {
					this.deepLoad(costogastoimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(costogastoimpors);
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
			if(costogastoimpors!=null) {
				for(CostoGastoImpor costogastoimpor:costogastoimpors) {
					this.deepLoad(costogastoimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(costogastoimpors);
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
			this.getNewConnexionToDeep(CostoGastoImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(costogastoimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CostoGastoImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(costogastoimpors!=null) {
				for(CostoGastoImpor costogastoimpor:costogastoimpors) {
					this.deepSave(costogastoimpor,isDeep,deepLoadType,clases);
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
			if(costogastoimpors!=null) {
				for(CostoGastoImpor costogastoimpor:costogastoimpors) {
					this.deepSave(costogastoimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCostoGastoImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CostoGastoImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCostoGastoImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CostoGastoImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCostoGastoImporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CostoGastoImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCostoGastoImporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CostoGastoImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCostoGastoImporsFK_IdTipoCostoGastoImporWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_costo_gasto_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CostoGastoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCostoGastoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCostoGastoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costo_gasto_impor,CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCostoGastoImpor);

			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCostoGastoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCostoGastoImporsFK_IdTipoCostoGastoImpor(String sFinalQuery,Pagination pagination,Long id_tipo_costo_gasto_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCostoGastoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCostoGastoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costo_gasto_impor,CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCostoGastoImpor);

			CostoGastoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCostoGastoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CostoGastoImporConstantesFunciones.refrescarForeignKeysDescripcionesCostoGastoImpor(this.costogastoimpors);
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
			if(CostoGastoImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CostoGastoImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CostoGastoImpor costogastoimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CostoGastoImporConstantesFunciones.ISCONAUDITORIA) {
				if(costogastoimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CostoGastoImporDataAccess.TABLENAME, costogastoimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CostoGastoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CostoGastoImporLogic.registrarAuditoriaDetallesCostoGastoImpor(connexion,costogastoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(costogastoimpor.getIsDeleted()) {
					/*if(!costogastoimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CostoGastoImporDataAccess.TABLENAME, costogastoimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CostoGastoImporLogic.registrarAuditoriaDetallesCostoGastoImpor(connexion,costogastoimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CostoGastoImporDataAccess.TABLENAME, costogastoimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(costogastoimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CostoGastoImporDataAccess.TABLENAME, costogastoimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CostoGastoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CostoGastoImporLogic.registrarAuditoriaDetallesCostoGastoImpor(connexion,costogastoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCostoGastoImpor(Connexion connexion,CostoGastoImpor costogastoimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getid_empresa().equals(costogastoimpor.getCostoGastoImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getid_empresa()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getid_empresa().toString();
				}
				if(costogastoimpor.getid_empresa()!=null)
				{
					strValorNuevo=costogastoimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getid_sucursal().equals(costogastoimpor.getCostoGastoImporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getid_sucursal()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getid_sucursal().toString();
				}
				if(costogastoimpor.getid_sucursal()!=null)
				{
					strValorNuevo=costogastoimpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getid_tipo_costo_gasto_impor().equals(costogastoimpor.getCostoGastoImporOriginal().getid_tipo_costo_gasto_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getid_tipo_costo_gasto_impor()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getid_tipo_costo_gasto_impor().toString();
				}
				if(costogastoimpor.getid_tipo_costo_gasto_impor()!=null)
				{
					strValorNuevo=costogastoimpor.getid_tipo_costo_gasto_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getnombre().equals(costogastoimpor.getCostoGastoImporOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getnombre()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getnombre();
				}
				if(costogastoimpor.getnombre()!=null)
				{
					strValorNuevo=costogastoimpor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getes_activo().equals(costogastoimpor.getCostoGastoImporOriginal().getes_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getes_activo()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getes_activo().toString();
				}
				if(costogastoimpor.getes_activo()!=null)
				{
					strValorNuevo=costogastoimpor.getes_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_agrupa().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_agrupa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_agrupa()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_agrupa().toString();
				}
				if(costogastoimpor.getcon_agrupa()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_agrupa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONAGRUPA,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_prorratea().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_prorratea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_prorratea()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_prorratea().toString();
				}
				if(costogastoimpor.getcon_prorratea()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_prorratea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONPRORRATEA,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_factura().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_factura()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_factura().toString();
				}
				if(costogastoimpor.getcon_factura()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_flete().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_flete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_flete()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_flete().toString();
				}
				if(costogastoimpor.getcon_flete()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_flete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONFLETE,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_arancel().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_arancel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_arancel()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_arancel().toString();
				}
				if(costogastoimpor.getcon_arancel()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_arancel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONARANCEL,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_seguro().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_seguro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_seguro()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_seguro().toString();
				}
				if(costogastoimpor.getcon_seguro()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_seguro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONSEGURO,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_total_general().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_total_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_total_general()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_total_general().toString();
				}
				if(costogastoimpor.getcon_total_general()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_total_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONTOTALGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(costogastoimpor.getIsNew()||!costogastoimpor.getcon_digitado().equals(costogastoimpor.getCostoGastoImporOriginal().getcon_digitado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(costogastoimpor.getCostoGastoImporOriginal().getcon_digitado()!=null)
				{
					strValorActual=costogastoimpor.getCostoGastoImporOriginal().getcon_digitado().toString();
				}
				if(costogastoimpor.getcon_digitado()!=null)
				{
					strValorNuevo=costogastoimpor.getcon_digitado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CostoGastoImporConstantesFunciones.CONDIGITADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCostoGastoImporRelacionesWithConnection(CostoGastoImpor costogastoimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors) throws Exception {

		if(!costogastoimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCostoGastoImporRelacionesBase(costogastoimpor,detalleliquidacionimpors,true);
		}
	}

	public void saveCostoGastoImporRelaciones(CostoGastoImpor costogastoimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors)throws Exception {

		if(!costogastoimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCostoGastoImporRelacionesBase(costogastoimpor,detalleliquidacionimpors,false);
		}
	}

	public void saveCostoGastoImporRelacionesBase(CostoGastoImpor costogastoimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CostoGastoImpor-saveRelacionesWithConnection");}
	
			costogastoimpor.setDetalleLiquidacionImpors(detalleliquidacionimpors);

			this.setCostoGastoImpor(costogastoimpor);

			if(CostoGastoImporLogicAdditional.validarSaveRelaciones(costogastoimpor,this)) {

				CostoGastoImporLogicAdditional.updateRelacionesToSave(costogastoimpor,this);

				if((costogastoimpor.getIsNew()||costogastoimpor.getIsChanged())&&!costogastoimpor.getIsDeleted()) {
					this.saveCostoGastoImpor();
					this.saveCostoGastoImporRelacionesDetalles(detalleliquidacionimpors);

				} else if(costogastoimpor.getIsDeleted()) {
					this.saveCostoGastoImporRelacionesDetalles(detalleliquidacionimpors);
					this.saveCostoGastoImpor();
				}

				CostoGastoImporLogicAdditional.updateRelacionesToSaveAfter(costogastoimpor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleLiquidacionImporConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpors(detalleliquidacionimpors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCostoGastoImporRelacionesDetalles(List<DetalleLiquidacionImpor> detalleliquidacionimpors)throws Exception {
		try {
	

			Long idCostoGastoImporActual=this.getCostoGastoImpor().getId();

			DetalleLiquidacionImporLogic detalleliquidacionimporLogic_Desde_CostoGastoImpor=new DetalleLiquidacionImporLogic();
			detalleliquidacionimporLogic_Desde_CostoGastoImpor.setDetalleLiquidacionImpors(detalleliquidacionimpors);

			detalleliquidacionimporLogic_Desde_CostoGastoImpor.setConnexion(this.getConnexion());
			detalleliquidacionimporLogic_Desde_CostoGastoImpor.setDatosCliente(this.datosCliente);

			for(DetalleLiquidacionImpor detalleliquidacionimpor_Desde_CostoGastoImpor:detalleliquidacionimporLogic_Desde_CostoGastoImpor.getDetalleLiquidacionImpors()) {
				detalleliquidacionimpor_Desde_CostoGastoImpor.setid_costo_gasto_impor(idCostoGastoImporActual);
			}

			detalleliquidacionimporLogic_Desde_CostoGastoImpor.saveDetalleLiquidacionImpors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CostoGastoImporConstantesFunciones.getClassesForeignKeysOfCostoGastoImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CostoGastoImporConstantesFunciones.getClassesRelationshipsOfCostoGastoImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
