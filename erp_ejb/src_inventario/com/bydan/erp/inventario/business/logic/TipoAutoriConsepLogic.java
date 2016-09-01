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
import com.bydan.erp.inventario.util.TipoAutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.TipoAutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoAutoriConsepParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoAutoriConsep;
//import com.bydan.erp.inventario.business.logic.TipoAutoriConsepLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoAutoriConsepLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoAutoriConsepLogic.class);
	
	protected TipoAutoriConsepDataAccess tipoautoriconsepDataAccess; 	
	protected TipoAutoriConsep tipoautoriconsep;
	protected List<TipoAutoriConsep> tipoautoriconseps;
	protected Object tipoautoriconsepObject;	
	protected List<Object> tipoautoriconsepsObject;
	
	public static ClassValidator<TipoAutoriConsep> tipoautoriconsepValidator = new ClassValidator<TipoAutoriConsep>(TipoAutoriConsep.class);	
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
	
	
	
	
	public  TipoAutoriConsepLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoautoriconsepDataAccess = new TipoAutoriConsepDataAccess();
			
			this.tipoautoriconseps= new ArrayList<TipoAutoriConsep>();
			this.tipoautoriconsep= new TipoAutoriConsep();
			
			this.tipoautoriconsepObject=new Object();
			this.tipoautoriconsepsObject=new ArrayList<Object>();
				
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
			
			this.tipoautoriconsepDataAccess.setConnexionType(this.connexionType);
			this.tipoautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoAutoriConsepLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoautoriconsepDataAccess = new TipoAutoriConsepDataAccess();
			this.tipoautoriconseps= new ArrayList<TipoAutoriConsep>();
			this.tipoautoriconsep= new TipoAutoriConsep();
			this.tipoautoriconsepObject=new Object();
			this.tipoautoriconsepsObject=new ArrayList<Object>();
			
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
			
			this.tipoautoriconsepDataAccess.setConnexionType(this.connexionType);
			this.tipoautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoAutoriConsep getTipoAutoriConsep() throws Exception {	
		//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToGet(tipoautoriconsep,this.datosCliente,this.arrDatoGeneral);
		//TipoAutoriConsepLogicAdditional.updateTipoAutoriConsepToGet(tipoautoriconsep,this.arrDatoGeneral);
		
		return tipoautoriconsep;
	}
		
	public void setTipoAutoriConsep(TipoAutoriConsep newTipoAutoriConsep) {
		this.tipoautoriconsep = newTipoAutoriConsep;
	}
	
	public TipoAutoriConsepDataAccess getTipoAutoriConsepDataAccess() {
		return tipoautoriconsepDataAccess;
	}
	
	public void setTipoAutoriConsepDataAccess(TipoAutoriConsepDataAccess newtipoautoriconsepDataAccess) {
		this.tipoautoriconsepDataAccess = newtipoautoriconsepDataAccess;
	}
	
	public List<TipoAutoriConsep> getTipoAutoriConseps() throws Exception {		
		this.quitarTipoAutoriConsepsNulos();
		
		//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToGets(tipoautoriconseps,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoAutoriConsep tipoautoriconsepLocal: tipoautoriconseps ) {
			//TipoAutoriConsepLogicAdditional.updateTipoAutoriConsepToGet(tipoautoriconsepLocal,this.arrDatoGeneral);
		}
		
		return tipoautoriconseps;
	}
	
	public void setTipoAutoriConseps(List<TipoAutoriConsep> newTipoAutoriConseps) {
		this.tipoautoriconseps = newTipoAutoriConseps;
	}
	
	public Object getTipoAutoriConsepObject() {	
		this.tipoautoriconsepObject=this.tipoautoriconsepDataAccess.getEntityObject();
		return this.tipoautoriconsepObject;
	}
		
	public void setTipoAutoriConsepObject(Object newTipoAutoriConsepObject) {
		this.tipoautoriconsepObject = newTipoAutoriConsepObject;
	}
	
	public List<Object> getTipoAutoriConsepsObject() {		
		this.tipoautoriconsepsObject=this.tipoautoriconsepDataAccess.getEntitiesObject();
		return this.tipoautoriconsepsObject;
	}
		
	public void setTipoAutoriConsepsObject(List<Object> newTipoAutoriConsepsObject) {
		this.tipoautoriconsepsObject = newTipoAutoriConsepsObject;
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
		
		if(this.tipoautoriconsepDataAccess!=null) {
			this.tipoautoriconsepDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoautoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoautoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoautoriconsep = new  TipoAutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoautoriconsep=tipoautoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconsep);
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
		tipoautoriconsep = new  TipoAutoriConsep();
		  		  
        try {
			
			tipoautoriconsep=tipoautoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoautoriconsep = new  TipoAutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoautoriconsep=tipoautoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconsep);
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
		tipoautoriconsep = new  TipoAutoriConsep();
		  		  
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
		tipoautoriconsep = new  TipoAutoriConsep();
		  		  
        try {
			
			tipoautoriconsep=tipoautoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoautoriconsep = new  TipoAutoriConsep();
		  		  
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
		tipoautoriconsep = new  TipoAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoautoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoautoriconsep = new  TipoAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoautoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoautoriconsep = new  TipoAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoautoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoautoriconsep = new  TipoAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoautoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoautoriconsep = new  TipoAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoautoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoautoriconsep = new  TipoAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoautoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
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
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		  		  
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
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		  		  
        try {			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		  		  
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
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
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
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		  		  
        try {
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
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
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
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
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoautoriconsep = new  TipoAutoriConsep();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconsep=tipoautoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconsep);
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
		tipoautoriconsep = new  TipoAutoriConsep();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconsep=tipoautoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoAutoriConsepsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getTodosTipoAutoriConsepsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
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
	
	public  void  getTodosTipoAutoriConseps(String sFinalQuery,Pagination pagination)throws Exception {
		tipoautoriconseps = new  ArrayList<TipoAutoriConsep>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAutoriConsep(tipoautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoAutoriConsep(TipoAutoriConsep tipoautoriconsep) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoautoriconsep.getIsNew() || tipoautoriconsep.getIsChanged()) { 
			this.invalidValues = tipoautoriconsepValidator.getInvalidValues(tipoautoriconsep);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoautoriconsep);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoAutoriConsep(List<TipoAutoriConsep> TipoAutoriConseps) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoAutoriConsep tipoautoriconsepLocal:tipoautoriconseps) {				
			estaValidadoObjeto=this.validarGuardarTipoAutoriConsep(tipoautoriconsepLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoAutoriConsep(List<TipoAutoriConsep> TipoAutoriConseps) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAutoriConsep(tipoautoriconseps)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoAutoriConsep(TipoAutoriConsep TipoAutoriConsep) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAutoriConsep(tipoautoriconsep)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoAutoriConsep tipoautoriconsep) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoautoriconsep.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoAutoriConsepConstantesFunciones.getTipoAutoriConsepLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoautoriconsep","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoAutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoAutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoAutoriConsepWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-saveTipoAutoriConsepWithConnection");connexion.begin();			
			
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSave(this.tipoautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoAutoriConsepLogicAdditional.updateTipoAutoriConsepToSave(this.tipoautoriconsep,this.arrDatoGeneral);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoautoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoAutoriConsep();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAutoriConsep(this.tipoautoriconsep)) {
				TipoAutoriConsepDataAccess.save(this.tipoautoriconsep, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSaveAfter(this.tipoautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAutoriConsep();
			
			connexion.commit();			
			
			if(this.tipoautoriconsep.getIsDeleted()) {
				this.tipoautoriconsep=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoAutoriConsep()throws Exception {	
		try {	
			
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSave(this.tipoautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoAutoriConsepLogicAdditional.updateTipoAutoriConsepToSave(this.tipoautoriconsep,this.arrDatoGeneral);
			
			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoautoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAutoriConsep(this.tipoautoriconsep)) {			
				TipoAutoriConsepDataAccess.save(this.tipoautoriconsep, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSaveAfter(this.tipoautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoautoriconsep.getIsDeleted()) {
				this.tipoautoriconsep=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoAutoriConsepsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-saveTipoAutoriConsepsWithConnection");connexion.begin();			
			
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSaves(tipoautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoAutoriConseps();
			
			Boolean validadoTodosTipoAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAutoriConsep tipoautoriconsepLocal:tipoautoriconseps) {		
				if(tipoautoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoAutoriConsepLogicAdditional.updateTipoAutoriConsepToSave(tipoautoriconsepLocal,this.arrDatoGeneral);
	        	
				TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoautoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAutoriConsep(tipoautoriconsepLocal)) {
					TipoAutoriConsepDataAccess.save(tipoautoriconsepLocal, connexion);				
				} else {
					validadoTodosTipoAutoriConsep=false;
				}
			}
			
			if(!validadoTodosTipoAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSavesAfter(tipoautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAutoriConseps();
			
			connexion.commit();		
			
			this.quitarTipoAutoriConsepsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoAutoriConseps()throws Exception {				
		 try {	
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSaves(tipoautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAutoriConsep tipoautoriconsepLocal:tipoautoriconseps) {				
				if(tipoautoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoAutoriConsepLogicAdditional.updateTipoAutoriConsepToSave(tipoautoriconsepLocal,this.arrDatoGeneral);
	        	
				TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoautoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAutoriConsep(tipoautoriconsepLocal)) {				
					TipoAutoriConsepDataAccess.save(tipoautoriconsepLocal, connexion);				
				} else {
					validadoTodosTipoAutoriConsep=false;
				}
			}
			
			if(!validadoTodosTipoAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoAutoriConsepLogicAdditional.checkTipoAutoriConsepToSavesAfter(tipoautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoAutoriConsepsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAutoriConsepParameterReturnGeneral procesarAccionTipoAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAutoriConsep> tipoautoriconseps,TipoAutoriConsepParameterReturnGeneral tipoautoriconsepParameterGeneral)throws Exception {
		 try {	
			TipoAutoriConsepParameterReturnGeneral tipoautoriconsepReturnGeneral=new TipoAutoriConsepParameterReturnGeneral();
	
			
			return tipoautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAutoriConsepParameterReturnGeneral procesarAccionTipoAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAutoriConsep> tipoautoriconseps,TipoAutoriConsepParameterReturnGeneral tipoautoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-procesarAccionTipoAutoriConsepsWithConnection");connexion.begin();			
			
			TipoAutoriConsepParameterReturnGeneral tipoautoriconsepReturnGeneral=new TipoAutoriConsepParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAutoriConsepParameterReturnGeneral procesarEventosTipoAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAutoriConsep> tipoautoriconseps,TipoAutoriConsep tipoautoriconsep,TipoAutoriConsepParameterReturnGeneral tipoautoriconsepParameterGeneral,Boolean isEsNuevoTipoAutoriConsep,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoAutoriConsepParameterReturnGeneral tipoautoriconsepReturnGeneral=new TipoAutoriConsepParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoautoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoAutoriConsepParameterReturnGeneral procesarEventosTipoAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAutoriConsep> tipoautoriconseps,TipoAutoriConsep tipoautoriconsep,TipoAutoriConsepParameterReturnGeneral tipoautoriconsepParameterGeneral,Boolean isEsNuevoTipoAutoriConsep,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-procesarEventosTipoAutoriConsepsWithConnection");connexion.begin();			
			
			TipoAutoriConsepParameterReturnGeneral tipoautoriconsepReturnGeneral=new TipoAutoriConsepParameterReturnGeneral();
	
			tipoautoriconsepReturnGeneral.setTipoAutoriConsep(tipoautoriconsep);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoautoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAutoriConsepParameterReturnGeneral procesarImportacionTipoAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoAutoriConsepParameterReturnGeneral tipoautoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-procesarImportacionTipoAutoriConsepsWithConnection");connexion.begin();			
			
			TipoAutoriConsepParameterReturnGeneral tipoautoriconsepReturnGeneral=new TipoAutoriConsepParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoautoriconseps=new ArrayList<TipoAutoriConsep>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoautoriconsep=new TipoAutoriConsep();
				
				
				if(conColumnasBase) {this.tipoautoriconsep.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoautoriconsep.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoautoriconsep.setcodigo(arrColumnas[iColumn++]);
				this.tipoautoriconsep.setnombre(arrColumnas[iColumn++]);
				
				this.tipoautoriconseps.add(this.tipoautoriconsep);
			}
			
			this.saveTipoAutoriConseps();
			
			this.connexion.commit();
			
			tipoautoriconsepReturnGeneral.setConRetornoEstaProcesado(true);
			tipoautoriconsepReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoAutoriConsepsEliminados() throws Exception {				
		
		List<TipoAutoriConsep> tipoautoriconsepsAux= new ArrayList<TipoAutoriConsep>();
		
		for(TipoAutoriConsep tipoautoriconsep:tipoautoriconseps) {
			if(!tipoautoriconsep.getIsDeleted()) {
				tipoautoriconsepsAux.add(tipoautoriconsep);
			}
		}
		
		tipoautoriconseps=tipoautoriconsepsAux;
	}
	
	public void quitarTipoAutoriConsepsNulos() throws Exception {				
		
		List<TipoAutoriConsep> tipoautoriconsepsAux= new ArrayList<TipoAutoriConsep>();
		
		for(TipoAutoriConsep tipoautoriconsep : this.tipoautoriconseps) {
			if(tipoautoriconsep==null) {
				tipoautoriconsepsAux.add(tipoautoriconsep);
			}
		}
		
		//this.tipoautoriconseps=tipoautoriconsepsAux;
		
		this.tipoautoriconseps.removeAll(tipoautoriconsepsAux);
	}
	
	public void getSetVersionRowTipoAutoriConsepWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoautoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoautoriconsep.getIsDeleted() || (tipoautoriconsep.getIsChanged()&&!tipoautoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoautoriconsepDataAccess.getSetVersionRowTipoAutoriConsep(connexion,tipoautoriconsep.getId());
				
				if(!tipoautoriconsep.getVersionRow().equals(timestamp)) {	
					tipoautoriconsep.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoautoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoAutoriConsep()throws Exception {	
		
		if(tipoautoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoautoriconsep.getIsDeleted() || (tipoautoriconsep.getIsChanged()&&!tipoautoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoautoriconsepDataAccess.getSetVersionRowTipoAutoriConsep(connexion,tipoautoriconsep.getId());
			
			try {							
				if(!tipoautoriconsep.getVersionRow().equals(timestamp)) {	
					tipoautoriconsep.setVersionRow(timestamp);
				}
				
				tipoautoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoAutoriConsepsWithConnection()throws Exception {	
		if(tipoautoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoAutoriConsep tipoautoriconsepAux:tipoautoriconseps) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoautoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoautoriconsepAux.getIsDeleted() || (tipoautoriconsepAux.getIsChanged()&&!tipoautoriconsepAux.getIsNew())) {
						
						timestamp=tipoautoriconsepDataAccess.getSetVersionRowTipoAutoriConsep(connexion,tipoautoriconsepAux.getId());
						
						if(!tipoautoriconsep.getVersionRow().equals(timestamp)) {	
							tipoautoriconsepAux.setVersionRow(timestamp);
						}
								
						tipoautoriconsepAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoAutoriConseps()throws Exception {	
		if(tipoautoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoAutoriConsep tipoautoriconsepAux:tipoautoriconseps) {
					if(tipoautoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoautoriconsepAux.getIsDeleted() || (tipoautoriconsepAux.getIsChanged()&&!tipoautoriconsepAux.getIsNew())) {
						
						timestamp=tipoautoriconsepDataAccess.getSetVersionRowTipoAutoriConsep(connexion,tipoautoriconsepAux.getId());
						
						if(!tipoautoriconsepAux.getVersionRow().equals(timestamp)) {	
							tipoautoriconsepAux.setVersionRow(timestamp);
						}
						
													
						tipoautoriconsepAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoAutoriConsepWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			AutoriConsepLogic autoriconsepLogic=new AutoriConsepLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoAutoriConsepWithConnection");connexion.begin();
			
			
			classes.add(new Classe(AutoriConsep.class));
											
			

			autoriconsepLogic.setConnexion(this.getConnexion());
			autoriconsepLogic.setDatosCliente(this.datosCliente);
			autoriconsepLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoAutoriConsep tipoautoriconsep:this.tipoautoriconseps) {
				

				classes=new ArrayList<Classe>();
				classes=AutoriConsepConstantesFunciones.getClassesForeignKeysOfAutoriConsep(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoriconsepLogic.setAutoriConseps(tipoautoriconsep.autoriconseps);
				autoriconsepLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoAutoriConsep tipoautoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoAutoriConsepLogicAdditional.updateTipoAutoriConsepToGet(tipoautoriconsep,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoautoriconsep.setAutoriConseps(tipoautoriconsepDataAccess.getAutoriConseps(connexion,tipoautoriconsep));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoautoriconsep.setAutoriConseps(tipoautoriconsepDataAccess.getAutoriConseps(connexion,tipoautoriconsep));

				if(this.isConDeep) {
					AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(this.connexion);
					autoriconsepLogic.setAutoriConseps(tipoautoriconsep.getAutoriConseps());
					ArrayList<Classe> classesLocal=AutoriConsepConstantesFunciones.getClassesForeignKeysOfAutoriConsep(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoriconsepLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(autoriconsepLogic.getAutoriConseps());
					tipoautoriconsep.setAutoriConseps(autoriconsepLogic.getAutoriConseps());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriConsep.class));
			tipoautoriconsep.setAutoriConseps(tipoautoriconsepDataAccess.getAutoriConseps(connexion,tipoautoriconsep));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoautoriconsep.setAutoriConseps(tipoautoriconsepDataAccess.getAutoriConseps(connexion,tipoautoriconsep));

		for(AutoriConsep autoriconsep:tipoautoriconsep.getAutoriConseps()) {
			AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
			autoriconsepLogic.deepLoad(autoriconsep,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoautoriconsep.setAutoriConseps(tipoautoriconsepDataAccess.getAutoriConseps(connexion,tipoautoriconsep));

				for(AutoriConsep autoriconsep:tipoautoriconsep.getAutoriConseps()) {
					AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
					autoriconsepLogic.deepLoad(autoriconsep,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriConsep.class));
			tipoautoriconsep.setAutoriConseps(tipoautoriconsepDataAccess.getAutoriConseps(connexion,tipoautoriconsep));

			for(AutoriConsep autoriconsep:tipoautoriconsep.getAutoriConseps()) {
				AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
				autoriconsepLogic.deepLoad(autoriconsep,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoAutoriConsep tipoautoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoAutoriConsep.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoautoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(tipoautoriconsep);
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
			this.deepLoad(this.tipoautoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoAutoriConsep.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoautoriconseps!=null) {
				for(TipoAutoriConsep tipoautoriconsep:tipoautoriconseps) {
					this.deepLoad(tipoautoriconsep,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(tipoautoriconseps);
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
			if(tipoautoriconseps!=null) {
				for(TipoAutoriConsep tipoautoriconsep:tipoautoriconseps) {
					this.deepLoad(tipoautoriconsep,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(tipoautoriconseps);
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
	
	
	public void getTipoAutoriConsepsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoAutoriConsepConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoAutoriConsepsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoAutoriConsepConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoAutoriConsepsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoAutoriConsepConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoAutoriConsepsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoAutoriConsepConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoautoriconseps=tipoautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesTipoAutoriConsep(this.tipoautoriconseps);
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
			if(TipoAutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAutoriConsepDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoAutoriConsep tipoautoriconsep,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoAutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				if(tipoautoriconsep.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAutoriConsepDataAccess.TABLENAME, tipoautoriconsep.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAutoriConsepLogic.registrarAuditoriaDetallesTipoAutoriConsep(connexion,tipoautoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoautoriconsep.getIsDeleted()) {
					/*if(!tipoautoriconsep.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoAutoriConsepDataAccess.TABLENAME, tipoautoriconsep.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoAutoriConsepLogic.registrarAuditoriaDetallesTipoAutoriConsep(connexion,tipoautoriconsep,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAutoriConsepDataAccess.TABLENAME, tipoautoriconsep.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoautoriconsep.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAutoriConsepDataAccess.TABLENAME, tipoautoriconsep.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAutoriConsepLogic.registrarAuditoriaDetallesTipoAutoriConsep(connexion,tipoautoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoAutoriConsep(Connexion connexion,TipoAutoriConsep tipoautoriconsep)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoautoriconsep.getIsNew()||!tipoautoriconsep.getcodigo().equals(tipoautoriconsep.getTipoAutoriConsepOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoautoriconsep.getTipoAutoriConsepOriginal().getcodigo()!=null)
				{
					strValorActual=tipoautoriconsep.getTipoAutoriConsepOriginal().getcodigo();
				}
				if(tipoautoriconsep.getcodigo()!=null)
				{
					strValorNuevo=tipoautoriconsep.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAutoriConsepConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoautoriconsep.getIsNew()||!tipoautoriconsep.getnombre().equals(tipoautoriconsep.getTipoAutoriConsepOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoautoriconsep.getTipoAutoriConsepOriginal().getnombre()!=null)
				{
					strValorActual=tipoautoriconsep.getTipoAutoriConsepOriginal().getnombre();
				}
				if(tipoautoriconsep.getnombre()!=null)
				{
					strValorNuevo=tipoautoriconsep.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAutoriConsepConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAutoriConsepConstantesFunciones.getClassesForeignKeysOfTipoAutoriConsep(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAutoriConsepConstantesFunciones.getClassesRelationshipsOfTipoAutoriConsep(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
