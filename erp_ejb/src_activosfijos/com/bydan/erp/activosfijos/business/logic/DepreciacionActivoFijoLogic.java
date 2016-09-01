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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.DepreciacionActivoFijo;
import com.bydan.erp.activosfijos.business.logic.DepreciacionActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DepreciacionActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DepreciacionActivoFijoLogic.class);
	
	protected DepreciacionActivoFijoDataAccess depreciacionactivofijoDataAccess; 	
	protected DepreciacionActivoFijo depreciacionactivofijo;
	protected List<DepreciacionActivoFijo> depreciacionactivofijos;
	protected Object depreciacionactivofijoObject;	
	protected List<Object> depreciacionactivofijosObject;
	
	public static ClassValidator<DepreciacionActivoFijo> depreciacionactivofijoValidator = new ClassValidator<DepreciacionActivoFijo>(DepreciacionActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DepreciacionActivoFijoLogicAdditional depreciacionactivofijoLogicAdditional=null;
	
	public DepreciacionActivoFijoLogicAdditional getDepreciacionActivoFijoLogicAdditional() {
		return this.depreciacionactivofijoLogicAdditional;
	}
	
	public void setDepreciacionActivoFijoLogicAdditional(DepreciacionActivoFijoLogicAdditional depreciacionactivofijoLogicAdditional) {
		try {
			this.depreciacionactivofijoLogicAdditional=depreciacionactivofijoLogicAdditional;
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
	
	
	
	
	public  DepreciacionActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.depreciacionactivofijoDataAccess = new DepreciacionActivoFijoDataAccess();
			
			this.depreciacionactivofijos= new ArrayList<DepreciacionActivoFijo>();
			this.depreciacionactivofijo= new DepreciacionActivoFijo();
			
			this.depreciacionactivofijoObject=new Object();
			this.depreciacionactivofijosObject=new ArrayList<Object>();
				
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
			
			this.depreciacionactivofijoDataAccess.setConnexionType(this.connexionType);
			this.depreciacionactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DepreciacionActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.depreciacionactivofijoDataAccess = new DepreciacionActivoFijoDataAccess();
			this.depreciacionactivofijos= new ArrayList<DepreciacionActivoFijo>();
			this.depreciacionactivofijo= new DepreciacionActivoFijo();
			this.depreciacionactivofijoObject=new Object();
			this.depreciacionactivofijosObject=new ArrayList<Object>();
			
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
			
			this.depreciacionactivofijoDataAccess.setConnexionType(this.connexionType);
			this.depreciacionactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DepreciacionActivoFijo getDepreciacionActivoFijo() throws Exception {	
		DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToGet(depreciacionactivofijo,this.datosCliente,this.arrDatoGeneral);
		DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToGet(depreciacionactivofijo,this.arrDatoGeneral);
		
		return depreciacionactivofijo;
	}
		
	public void setDepreciacionActivoFijo(DepreciacionActivoFijo newDepreciacionActivoFijo) {
		this.depreciacionactivofijo = newDepreciacionActivoFijo;
	}
	
	public DepreciacionActivoFijoDataAccess getDepreciacionActivoFijoDataAccess() {
		return depreciacionactivofijoDataAccess;
	}
	
	public void setDepreciacionActivoFijoDataAccess(DepreciacionActivoFijoDataAccess newdepreciacionactivofijoDataAccess) {
		this.depreciacionactivofijoDataAccess = newdepreciacionactivofijoDataAccess;
	}
	
	public List<DepreciacionActivoFijo> getDepreciacionActivoFijos() throws Exception {		
		this.quitarDepreciacionActivoFijosNulos();
		
		DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToGets(depreciacionactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (DepreciacionActivoFijo depreciacionactivofijoLocal: depreciacionactivofijos ) {
			DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToGet(depreciacionactivofijoLocal,this.arrDatoGeneral);
		}
		
		return depreciacionactivofijos;
	}
	
	public void setDepreciacionActivoFijos(List<DepreciacionActivoFijo> newDepreciacionActivoFijos) {
		this.depreciacionactivofijos = newDepreciacionActivoFijos;
	}
	
	public Object getDepreciacionActivoFijoObject() {	
		this.depreciacionactivofijoObject=this.depreciacionactivofijoDataAccess.getEntityObject();
		return this.depreciacionactivofijoObject;
	}
		
	public void setDepreciacionActivoFijoObject(Object newDepreciacionActivoFijoObject) {
		this.depreciacionactivofijoObject = newDepreciacionActivoFijoObject;
	}
	
	public List<Object> getDepreciacionActivoFijosObject() {		
		this.depreciacionactivofijosObject=this.depreciacionactivofijoDataAccess.getEntitiesObject();
		return this.depreciacionactivofijosObject;
	}
		
	public void setDepreciacionActivoFijosObject(List<Object> newDepreciacionActivoFijosObject) {
		this.depreciacionactivofijosObject = newDepreciacionActivoFijosObject;
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
		
		if(this.depreciacionactivofijoDataAccess!=null) {
			this.depreciacionactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			depreciacionactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			depreciacionactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			depreciacionactivofijo=depreciacionactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.depreciacionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijo);
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  		  
        try {
			
			depreciacionactivofijo=depreciacionactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.depreciacionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			depreciacionactivofijo=depreciacionactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.depreciacionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijo);
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  		  
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  		  
        try {
			
			depreciacionactivofijo=depreciacionactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.depreciacionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  		  
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =depreciacionactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=depreciacionactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =depreciacionactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=depreciacionactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =depreciacionactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=depreciacionactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
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
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
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
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
        try {			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
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
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
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
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
        try {
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
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
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
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
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijo=depreciacionactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijo);
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
		depreciacionactivofijo = new  DepreciacionActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijo=depreciacionactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
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
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		  		  
        try {
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDepreciacionActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getTodosDepreciacionActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
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
	
	public  void  getTodosDepreciacionActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		depreciacionactivofijos = new  ArrayList<DepreciacionActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDepreciacionActivoFijo(depreciacionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(depreciacionactivofijo.getIsNew() || depreciacionactivofijo.getIsChanged()) { 
			this.invalidValues = depreciacionactivofijoValidator.getInvalidValues(depreciacionactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(depreciacionactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDepreciacionActivoFijo(List<DepreciacionActivoFijo> DepreciacionActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DepreciacionActivoFijo depreciacionactivofijoLocal:depreciacionactivofijos) {				
			estaValidadoObjeto=this.validarGuardarDepreciacionActivoFijo(depreciacionactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDepreciacionActivoFijo(List<DepreciacionActivoFijo> DepreciacionActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDepreciacionActivoFijo(depreciacionactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDepreciacionActivoFijo(DepreciacionActivoFijo DepreciacionActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDepreciacionActivoFijo(depreciacionactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DepreciacionActivoFijo depreciacionactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+depreciacionactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DepreciacionActivoFijoConstantesFunciones.getDepreciacionActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"depreciacionactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DepreciacionActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DepreciacionActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDepreciacionActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-saveDepreciacionActivoFijoWithConnection");connexion.begin();			
			
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSave(this.depreciacionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToSave(this.depreciacionactivofijo,this.arrDatoGeneral);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.depreciacionactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDepreciacionActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDepreciacionActivoFijo(this.depreciacionactivofijo)) {
				DepreciacionActivoFijoDataAccess.save(this.depreciacionactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.depreciacionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSaveAfter(this.depreciacionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDepreciacionActivoFijo();
			
			connexion.commit();			
			
			if(this.depreciacionactivofijo.getIsDeleted()) {
				this.depreciacionactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDepreciacionActivoFijo()throws Exception {	
		try {	
			
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSave(this.depreciacionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToSave(this.depreciacionactivofijo,this.arrDatoGeneral);
			
			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.depreciacionactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDepreciacionActivoFijo(this.depreciacionactivofijo)) {			
				DepreciacionActivoFijoDataAccess.save(this.depreciacionactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.depreciacionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSaveAfter(this.depreciacionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.depreciacionactivofijo.getIsDeleted()) {
				this.depreciacionactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDepreciacionActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-saveDepreciacionActivoFijosWithConnection");connexion.begin();			
			
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSaves(depreciacionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDepreciacionActivoFijos();
			
			Boolean validadoTodosDepreciacionActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DepreciacionActivoFijo depreciacionactivofijoLocal:depreciacionactivofijos) {		
				if(depreciacionactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToSave(depreciacionactivofijoLocal,this.arrDatoGeneral);
	        	
				DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),depreciacionactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDepreciacionActivoFijo(depreciacionactivofijoLocal)) {
					DepreciacionActivoFijoDataAccess.save(depreciacionactivofijoLocal, connexion);				
				} else {
					validadoTodosDepreciacionActivoFijo=false;
				}
			}
			
			if(!validadoTodosDepreciacionActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSavesAfter(depreciacionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDepreciacionActivoFijos();
			
			connexion.commit();		
			
			this.quitarDepreciacionActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDepreciacionActivoFijos()throws Exception {				
		 try {	
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSaves(depreciacionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDepreciacionActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DepreciacionActivoFijo depreciacionactivofijoLocal:depreciacionactivofijos) {				
				if(depreciacionactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToSave(depreciacionactivofijoLocal,this.arrDatoGeneral);
	        	
				DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),depreciacionactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDepreciacionActivoFijo(depreciacionactivofijoLocal)) {				
					DepreciacionActivoFijoDataAccess.save(depreciacionactivofijoLocal, connexion);				
				} else {
					validadoTodosDepreciacionActivoFijo=false;
				}
			}
			
			if(!validadoTodosDepreciacionActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DepreciacionActivoFijoLogicAdditional.checkDepreciacionActivoFijoToSavesAfter(depreciacionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDepreciacionActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DepreciacionActivoFijoParameterReturnGeneral procesarAccionDepreciacionActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DepreciacionActivoFijo> depreciacionactivofijos,DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoParameterGeneral)throws Exception {
		 try {	
			DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoReturnGeneral=new DepreciacionActivoFijoParameterReturnGeneral();
	
			DepreciacionActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,depreciacionactivofijos,depreciacionactivofijoParameterGeneral,depreciacionactivofijoReturnGeneral);
			
			return depreciacionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DepreciacionActivoFijoParameterReturnGeneral procesarAccionDepreciacionActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DepreciacionActivoFijo> depreciacionactivofijos,DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-procesarAccionDepreciacionActivoFijosWithConnection");connexion.begin();			
			
			DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoReturnGeneral=new DepreciacionActivoFijoParameterReturnGeneral();
	
			DepreciacionActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,depreciacionactivofijos,depreciacionactivofijoParameterGeneral,depreciacionactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return depreciacionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DepreciacionActivoFijoParameterReturnGeneral procesarEventosDepreciacionActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DepreciacionActivoFijo> depreciacionactivofijos,DepreciacionActivoFijo depreciacionactivofijo,DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoParameterGeneral,Boolean isEsNuevoDepreciacionActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoReturnGeneral=new DepreciacionActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				depreciacionactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DepreciacionActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,depreciacionactivofijos,depreciacionactivofijo,depreciacionactivofijoParameterGeneral,depreciacionactivofijoReturnGeneral,isEsNuevoDepreciacionActivoFijo,clases);
			
			return depreciacionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DepreciacionActivoFijoParameterReturnGeneral procesarEventosDepreciacionActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DepreciacionActivoFijo> depreciacionactivofijos,DepreciacionActivoFijo depreciacionactivofijo,DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoParameterGeneral,Boolean isEsNuevoDepreciacionActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-procesarEventosDepreciacionActivoFijosWithConnection");connexion.begin();			
			
			DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoReturnGeneral=new DepreciacionActivoFijoParameterReturnGeneral();
	
			depreciacionactivofijoReturnGeneral.setDepreciacionActivoFijo(depreciacionactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				depreciacionactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DepreciacionActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,depreciacionactivofijos,depreciacionactivofijo,depreciacionactivofijoParameterGeneral,depreciacionactivofijoReturnGeneral,isEsNuevoDepreciacionActivoFijo,clases);
			
			this.connexion.commit();
			
			return depreciacionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DepreciacionActivoFijoParameterReturnGeneral procesarImportacionDepreciacionActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-procesarImportacionDepreciacionActivoFijosWithConnection");connexion.begin();			
			
			DepreciacionActivoFijoParameterReturnGeneral depreciacionactivofijoReturnGeneral=new DepreciacionActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.depreciacionactivofijos=new ArrayList<DepreciacionActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.depreciacionactivofijo=new DepreciacionActivoFijo();
				
				
				if(conColumnasBase) {this.depreciacionactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.depreciacionactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.depreciacionactivofijo.setfecha_compra(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.depreciacionactivofijo.setfecha_depre_acti(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.depreciacionactivofijo.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.depreciacionactivofijo.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.depreciacionactivofijo.setvalor_acumulado(Double.parseDouble(arrColumnas[iColumn++]));
				this.depreciacionactivofijo.setvalor_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.depreciacionactivofijo.setvalor_gasto(Double.parseDouble(arrColumnas[iColumn++]));
				this.depreciacionactivofijo.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.depreciacionactivofijos.add(this.depreciacionactivofijo);
			}
			
			this.saveDepreciacionActivoFijos();
			
			this.connexion.commit();
			
			depreciacionactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			depreciacionactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return depreciacionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDepreciacionActivoFijosEliminados() throws Exception {				
		
		List<DepreciacionActivoFijo> depreciacionactivofijosAux= new ArrayList<DepreciacionActivoFijo>();
		
		for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos) {
			if(!depreciacionactivofijo.getIsDeleted()) {
				depreciacionactivofijosAux.add(depreciacionactivofijo);
			}
		}
		
		depreciacionactivofijos=depreciacionactivofijosAux;
	}
	
	public void quitarDepreciacionActivoFijosNulos() throws Exception {				
		
		List<DepreciacionActivoFijo> depreciacionactivofijosAux= new ArrayList<DepreciacionActivoFijo>();
		
		for(DepreciacionActivoFijo depreciacionactivofijo : this.depreciacionactivofijos) {
			if(depreciacionactivofijo==null) {
				depreciacionactivofijosAux.add(depreciacionactivofijo);
			}
		}
		
		//this.depreciacionactivofijos=depreciacionactivofijosAux;
		
		this.depreciacionactivofijos.removeAll(depreciacionactivofijosAux);
	}
	
	public void getSetVersionRowDepreciacionActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(depreciacionactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((depreciacionactivofijo.getIsDeleted() || (depreciacionactivofijo.getIsChanged()&&!depreciacionactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=depreciacionactivofijoDataAccess.getSetVersionRowDepreciacionActivoFijo(connexion,depreciacionactivofijo.getId());
				
				if(!depreciacionactivofijo.getVersionRow().equals(timestamp)) {	
					depreciacionactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				depreciacionactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDepreciacionActivoFijo()throws Exception {	
		
		if(depreciacionactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((depreciacionactivofijo.getIsDeleted() || (depreciacionactivofijo.getIsChanged()&&!depreciacionactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=depreciacionactivofijoDataAccess.getSetVersionRowDepreciacionActivoFijo(connexion,depreciacionactivofijo.getId());
			
			try {							
				if(!depreciacionactivofijo.getVersionRow().equals(timestamp)) {	
					depreciacionactivofijo.setVersionRow(timestamp);
				}
				
				depreciacionactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDepreciacionActivoFijosWithConnection()throws Exception {	
		if(depreciacionactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DepreciacionActivoFijo depreciacionactivofijoAux:depreciacionactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(depreciacionactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(depreciacionactivofijoAux.getIsDeleted() || (depreciacionactivofijoAux.getIsChanged()&&!depreciacionactivofijoAux.getIsNew())) {
						
						timestamp=depreciacionactivofijoDataAccess.getSetVersionRowDepreciacionActivoFijo(connexion,depreciacionactivofijoAux.getId());
						
						if(!depreciacionactivofijo.getVersionRow().equals(timestamp)) {	
							depreciacionactivofijoAux.setVersionRow(timestamp);
						}
								
						depreciacionactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDepreciacionActivoFijos()throws Exception {	
		if(depreciacionactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DepreciacionActivoFijo depreciacionactivofijoAux:depreciacionactivofijos) {
					if(depreciacionactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(depreciacionactivofijoAux.getIsDeleted() || (depreciacionactivofijoAux.getIsChanged()&&!depreciacionactivofijoAux.getIsNew())) {
						
						timestamp=depreciacionactivofijoDataAccess.getSetVersionRowDepreciacionActivoFijo(connexion,depreciacionactivofijoAux.getId());
						
						if(!depreciacionactivofijoAux.getVersionRow().equals(timestamp)) {	
							depreciacionactivofijoAux.setVersionRow(timestamp);
						}
						
													
						depreciacionactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DepreciacionActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyDepreciacionActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalTipoDepreciacionEmpresa,String finalQueryGlobalEstadoDepreActi,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DepreciacionActivoFijoParameterReturnGeneral  depreciacionactivofijoReturnGeneral =new DepreciacionActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyDepreciacionActivoFijoWithConnection");connexion.begin();
			
			depreciacionactivofijoReturnGeneral =new DepreciacionActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			depreciacionactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			depreciacionactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			depreciacionactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey=new ArrayList<TipoDepreciacionEmpresa>();
			TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic=new TipoDepreciacionEmpresaLogic();
			tipodepreciacionempresaLogic.setConnexion(this.connexion);
			tipodepreciacionempresaLogic.getTipoDepreciacionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDepreciacionEmpresa.equals("NONE")) {
				tipodepreciacionempresaLogic.getTodosTipoDepreciacionEmpresas(finalQueryGlobalTipoDepreciacionEmpresa,new Pagination());
				tipodepreciacionempresasForeignKey=tipodepreciacionempresaLogic.getTipoDepreciacionEmpresas();
			}

			depreciacionactivofijoReturnGeneral.settipodepreciacionempresasForeignKey(tipodepreciacionempresasForeignKey);


			List<EstadoDepreActi> estadodepreactisForeignKey=new ArrayList<EstadoDepreActi>();
			EstadoDepreActiLogic estadodepreactiLogic=new EstadoDepreActiLogic();
			estadodepreactiLogic.setConnexion(this.connexion);
			estadodepreactiLogic.getEstadoDepreActiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDepreActi.equals("NONE")) {
				estadodepreactiLogic.getTodosEstadoDepreActis(finalQueryGlobalEstadoDepreActi,new Pagination());
				estadodepreactisForeignKey=estadodepreactiLogic.getEstadoDepreActis();
			}

			depreciacionactivofijoReturnGeneral.setestadodepreactisForeignKey(estadodepreactisForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			depreciacionactivofijoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			depreciacionactivofijoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return depreciacionactivofijoReturnGeneral;
	}
	
	public DepreciacionActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyDepreciacionActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalTipoDepreciacionEmpresa,String finalQueryGlobalEstadoDepreActi,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DepreciacionActivoFijoParameterReturnGeneral  depreciacionactivofijoReturnGeneral =new DepreciacionActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			depreciacionactivofijoReturnGeneral =new DepreciacionActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			depreciacionactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			depreciacionactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			depreciacionactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey=new ArrayList<TipoDepreciacionEmpresa>();
			TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic=new TipoDepreciacionEmpresaLogic();
			tipodepreciacionempresaLogic.setConnexion(this.connexion);
			tipodepreciacionempresaLogic.getTipoDepreciacionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDepreciacionEmpresa.equals("NONE")) {
				tipodepreciacionempresaLogic.getTodosTipoDepreciacionEmpresas(finalQueryGlobalTipoDepreciacionEmpresa,new Pagination());
				tipodepreciacionempresasForeignKey=tipodepreciacionempresaLogic.getTipoDepreciacionEmpresas();
			}

			depreciacionactivofijoReturnGeneral.settipodepreciacionempresasForeignKey(tipodepreciacionempresasForeignKey);


			List<EstadoDepreActi> estadodepreactisForeignKey=new ArrayList<EstadoDepreActi>();
			EstadoDepreActiLogic estadodepreactiLogic=new EstadoDepreActiLogic();
			estadodepreactiLogic.setConnexion(this.connexion);
			estadodepreactiLogic.getEstadoDepreActiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDepreActi.equals("NONE")) {
				estadodepreactiLogic.getTodosEstadoDepreActis(finalQueryGlobalEstadoDepreActi,new Pagination());
				estadodepreactisForeignKey=estadodepreactiLogic.getEstadoDepreActis();
			}

			depreciacionactivofijoReturnGeneral.setestadodepreactisForeignKey(estadodepreactisForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			depreciacionactivofijoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			depreciacionactivofijoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return depreciacionactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(DepreciacionActivoFijo depreciacionactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToGet(depreciacionactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		depreciacionactivofijo.setEmpresa(depreciacionactivofijoDataAccess.getEmpresa(connexion,depreciacionactivofijo));
		depreciacionactivofijo.setSucursal(depreciacionactivofijoDataAccess.getSucursal(connexion,depreciacionactivofijo));
		depreciacionactivofijo.setDetalleActivoFijo(depreciacionactivofijoDataAccess.getDetalleActivoFijo(connexion,depreciacionactivofijo));
		depreciacionactivofijo.setTipoDepreciacionEmpresa(depreciacionactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,depreciacionactivofijo));
		depreciacionactivofijo.setEstadoDepreActi(depreciacionactivofijoDataAccess.getEstadoDepreActi(connexion,depreciacionactivofijo));
		depreciacionactivofijo.setAnio(depreciacionactivofijoDataAccess.getAnio(connexion,depreciacionactivofijo));
		depreciacionactivofijo.setMes(depreciacionactivofijoDataAccess.getMes(connexion,depreciacionactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				depreciacionactivofijo.setEmpresa(depreciacionactivofijoDataAccess.getEmpresa(connexion,depreciacionactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				depreciacionactivofijo.setSucursal(depreciacionactivofijoDataAccess.getSucursal(connexion,depreciacionactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				depreciacionactivofijo.setDetalleActivoFijo(depreciacionactivofijoDataAccess.getDetalleActivoFijo(connexion,depreciacionactivofijo));
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				depreciacionactivofijo.setTipoDepreciacionEmpresa(depreciacionactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,depreciacionactivofijo));
				continue;
			}

			if(clas.clas.equals(EstadoDepreActi.class)) {
				depreciacionactivofijo.setEstadoDepreActi(depreciacionactivofijoDataAccess.getEstadoDepreActi(connexion,depreciacionactivofijo));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				depreciacionactivofijo.setAnio(depreciacionactivofijoDataAccess.getAnio(connexion,depreciacionactivofijo));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				depreciacionactivofijo.setMes(depreciacionactivofijoDataAccess.getMes(connexion,depreciacionactivofijo));
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
			depreciacionactivofijo.setEmpresa(depreciacionactivofijoDataAccess.getEmpresa(connexion,depreciacionactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setSucursal(depreciacionactivofijoDataAccess.getSucursal(connexion,depreciacionactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setDetalleActivoFijo(depreciacionactivofijoDataAccess.getDetalleActivoFijo(connexion,depreciacionactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setTipoDepreciacionEmpresa(depreciacionactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,depreciacionactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDepreActi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setEstadoDepreActi(depreciacionactivofijoDataAccess.getEstadoDepreActi(connexion,depreciacionactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setAnio(depreciacionactivofijoDataAccess.getAnio(connexion,depreciacionactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setMes(depreciacionactivofijoDataAccess.getMes(connexion,depreciacionactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		depreciacionactivofijo.setEmpresa(depreciacionactivofijoDataAccess.getEmpresa(connexion,depreciacionactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(depreciacionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		depreciacionactivofijo.setSucursal(depreciacionactivofijoDataAccess.getSucursal(connexion,depreciacionactivofijo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(depreciacionactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		depreciacionactivofijo.setDetalleActivoFijo(depreciacionactivofijoDataAccess.getDetalleActivoFijo(connexion,depreciacionactivofijo));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(depreciacionactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		depreciacionactivofijo.setTipoDepreciacionEmpresa(depreciacionactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,depreciacionactivofijo));
		TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
		tipodepreciacionempresaLogic.deepLoad(depreciacionactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);
				
		depreciacionactivofijo.setEstadoDepreActi(depreciacionactivofijoDataAccess.getEstadoDepreActi(connexion,depreciacionactivofijo));
		EstadoDepreActiLogic estadodepreactiLogic= new EstadoDepreActiLogic(connexion);
		estadodepreactiLogic.deepLoad(depreciacionactivofijo.getEstadoDepreActi(),isDeep,deepLoadType,clases);
				
		depreciacionactivofijo.setAnio(depreciacionactivofijoDataAccess.getAnio(connexion,depreciacionactivofijo));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(depreciacionactivofijo.getAnio(),isDeep,deepLoadType,clases);
				
		depreciacionactivofijo.setMes(depreciacionactivofijoDataAccess.getMes(connexion,depreciacionactivofijo));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(depreciacionactivofijo.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				depreciacionactivofijo.setEmpresa(depreciacionactivofijoDataAccess.getEmpresa(connexion,depreciacionactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(depreciacionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				depreciacionactivofijo.setSucursal(depreciacionactivofijoDataAccess.getSucursal(connexion,depreciacionactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(depreciacionactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				depreciacionactivofijo.setDetalleActivoFijo(depreciacionactivofijoDataAccess.getDetalleActivoFijo(connexion,depreciacionactivofijo));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(depreciacionactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				depreciacionactivofijo.setTipoDepreciacionEmpresa(depreciacionactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,depreciacionactivofijo));
				TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
				tipodepreciacionempresaLogic.deepLoad(depreciacionactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDepreActi.class)) {
				depreciacionactivofijo.setEstadoDepreActi(depreciacionactivofijoDataAccess.getEstadoDepreActi(connexion,depreciacionactivofijo));
				EstadoDepreActiLogic estadodepreactiLogic= new EstadoDepreActiLogic(connexion);
				estadodepreactiLogic.deepLoad(depreciacionactivofijo.getEstadoDepreActi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				depreciacionactivofijo.setAnio(depreciacionactivofijoDataAccess.getAnio(connexion,depreciacionactivofijo));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(depreciacionactivofijo.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				depreciacionactivofijo.setMes(depreciacionactivofijoDataAccess.getMes(connexion,depreciacionactivofijo));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(depreciacionactivofijo.getMes(),isDeep,deepLoadType,clases);				
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
			depreciacionactivofijo.setEmpresa(depreciacionactivofijoDataAccess.getEmpresa(connexion,depreciacionactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(depreciacionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setSucursal(depreciacionactivofijoDataAccess.getSucursal(connexion,depreciacionactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(depreciacionactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setDetalleActivoFijo(depreciacionactivofijoDataAccess.getDetalleActivoFijo(connexion,depreciacionactivofijo));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(depreciacionactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setTipoDepreciacionEmpresa(depreciacionactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,depreciacionactivofijo));
			TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
			tipodepreciacionempresaLogic.deepLoad(depreciacionactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDepreActi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setEstadoDepreActi(depreciacionactivofijoDataAccess.getEstadoDepreActi(connexion,depreciacionactivofijo));
			EstadoDepreActiLogic estadodepreactiLogic= new EstadoDepreActiLogic(connexion);
			estadodepreactiLogic.deepLoad(depreciacionactivofijo.getEstadoDepreActi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setAnio(depreciacionactivofijoDataAccess.getAnio(connexion,depreciacionactivofijo));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(depreciacionactivofijo.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			depreciacionactivofijo.setMes(depreciacionactivofijoDataAccess.getMes(connexion,depreciacionactivofijo));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(depreciacionactivofijo.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DepreciacionActivoFijo depreciacionactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DepreciacionActivoFijoLogicAdditional.updateDepreciacionActivoFijoToSave(depreciacionactivofijo,this.arrDatoGeneral);
			
DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(depreciacionactivofijo.getEmpresa(),connexion);

		SucursalDataAccess.save(depreciacionactivofijo.getSucursal(),connexion);

		DetalleActivoFijoDataAccess.save(depreciacionactivofijo.getDetalleActivoFijo(),connexion);

		TipoDepreciacionEmpresaDataAccess.save(depreciacionactivofijo.getTipoDepreciacionEmpresa(),connexion);

		EstadoDepreActiDataAccess.save(depreciacionactivofijo.getEstadoDepreActi(),connexion);

		AnioDataAccess.save(depreciacionactivofijo.getAnio(),connexion);

		MesDataAccess.save(depreciacionactivofijo.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(depreciacionactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(depreciacionactivofijo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(depreciacionactivofijo.getDetalleActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				TipoDepreciacionEmpresaDataAccess.save(depreciacionactivofijo.getTipoDepreciacionEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDepreActi.class)) {
				EstadoDepreActiDataAccess.save(depreciacionactivofijo.getEstadoDepreActi(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(depreciacionactivofijo.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(depreciacionactivofijo.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(depreciacionactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(depreciacionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(depreciacionactivofijo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(depreciacionactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(depreciacionactivofijo.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(depreciacionactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		TipoDepreciacionEmpresaDataAccess.save(depreciacionactivofijo.getTipoDepreciacionEmpresa(),connexion);
		TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
		tipodepreciacionempresaLogic.deepLoad(depreciacionactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);
				

		EstadoDepreActiDataAccess.save(depreciacionactivofijo.getEstadoDepreActi(),connexion);
		EstadoDepreActiLogic estadodepreactiLogic= new EstadoDepreActiLogic(connexion);
		estadodepreactiLogic.deepLoad(depreciacionactivofijo.getEstadoDepreActi(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(depreciacionactivofijo.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(depreciacionactivofijo.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(depreciacionactivofijo.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(depreciacionactivofijo.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(depreciacionactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(depreciacionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(depreciacionactivofijo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(depreciacionactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(depreciacionactivofijo.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(depreciacionactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				TipoDepreciacionEmpresaDataAccess.save(depreciacionactivofijo.getTipoDepreciacionEmpresa(),connexion);
				TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
				tipodepreciacionempresaLogic.deepSave(depreciacionactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDepreActi.class)) {
				EstadoDepreActiDataAccess.save(depreciacionactivofijo.getEstadoDepreActi(),connexion);
				EstadoDepreActiLogic estadodepreactiLogic= new EstadoDepreActiLogic(connexion);
				estadodepreactiLogic.deepSave(depreciacionactivofijo.getEstadoDepreActi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(depreciacionactivofijo.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(depreciacionactivofijo.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(depreciacionactivofijo.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(depreciacionactivofijo.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DepreciacionActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(depreciacionactivofijo);
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
			this.deepLoad(this.depreciacionactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DepreciacionActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(depreciacionactivofijos!=null) {
				for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos) {
					this.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(depreciacionactivofijos);
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
			if(depreciacionactivofijos!=null) {
				for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos) {
					this.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(depreciacionactivofijos);
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
			this.getNewConnexionToDeep(DepreciacionActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(depreciacionactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DepreciacionActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(depreciacionactivofijos!=null) {
				for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos) {
					this.deepSave(depreciacionactivofijo,isDeep,deepLoadType,clases);
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
			if(depreciacionactivofijos!=null) {
				for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos) {
					this.deepSave(depreciacionactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDepreciacionActivoFijosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DepreciacionActivoFijoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDepreciacionActivoFijosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DepreciacionActivoFijoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDepreciacionActivoFijosFK_IdDepreciacionActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_depre_acti)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDepreActi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDepreActi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_depre_acti,DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDepreActi);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDepreciacionActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDepreciacionActivoFijosFK_IdDepreciacionActivoFijo(String sFinalQuery,Pagination pagination,Long id_estado_depre_acti)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDepreActi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDepreActi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_depre_acti,DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDepreActi);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDepreciacionActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDepreciacionActivoFijosFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDepreciacionActivoFijosFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDepreciacionActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DepreciacionActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDepreciacionActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DepreciacionActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDepreciacionActivoFijosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DepreciacionActivoFijoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDepreciacionActivoFijosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DepreciacionActivoFijoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDepreciacionActivoFijosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDepreciacionActivoFijosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDepreciacionActivoFijosFK_IdTipoDepreciacionEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_depreciacion_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DepreciacionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDepreciacionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDepreciacionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_depreciacion_empresa,DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDepreciacionEmpresa);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDepreciacionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDepreciacionActivoFijosFK_IdTipoDepreciacionEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_depreciacion_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDepreciacionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDepreciacionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_depreciacion_empresa,DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDepreciacionEmpresa);

			DepreciacionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDepreciacionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(this.depreciacionactivofijos);
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
			if(DepreciacionActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DepreciacionActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DepreciacionActivoFijo depreciacionactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DepreciacionActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(depreciacionactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DepreciacionActivoFijoDataAccess.TABLENAME, depreciacionactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DepreciacionActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DepreciacionActivoFijoLogic.registrarAuditoriaDetallesDepreciacionActivoFijo(connexion,depreciacionactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(depreciacionactivofijo.getIsDeleted()) {
					/*if(!depreciacionactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DepreciacionActivoFijoDataAccess.TABLENAME, depreciacionactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DepreciacionActivoFijoLogic.registrarAuditoriaDetallesDepreciacionActivoFijo(connexion,depreciacionactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DepreciacionActivoFijoDataAccess.TABLENAME, depreciacionactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(depreciacionactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DepreciacionActivoFijoDataAccess.TABLENAME, depreciacionactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DepreciacionActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DepreciacionActivoFijoLogic.registrarAuditoriaDetallesDepreciacionActivoFijo(connexion,depreciacionactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDepreciacionActivoFijo(Connexion connexion,DepreciacionActivoFijo depreciacionactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getid_empresa().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_empresa().toString();
				}
				if(depreciacionactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getid_sucursal().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_sucursal()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_sucursal().toString();
				}
				if(depreciacionactivofijo.getid_sucursal()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getid_detalle_activo_fijo().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_detalle_activo_fijo().toString();
				}
				if(depreciacionactivofijo.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getid_tipo_depreciacion_empresa().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_tipo_depreciacion_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_tipo_depreciacion_empresa()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_tipo_depreciacion_empresa().toString();
				}
				if(depreciacionactivofijo.getid_tipo_depreciacion_empresa()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getid_tipo_depreciacion_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getid_estado_depre_acti().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_estado_depre_acti()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_estado_depre_acti()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_estado_depre_acti().toString();
				}
				if(depreciacionactivofijo.getid_estado_depre_acti()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getid_estado_depre_acti().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getid_anio().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_anio()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_anio().toString();
				}
				if(depreciacionactivofijo.getid_anio()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getid_mes().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_mes()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getid_mes().toString();
				}
				if(depreciacionactivofijo.getid_mes()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getfecha_compra().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha_compra()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha_compra().toString();
				}
				if(depreciacionactivofijo.getfecha_compra()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getfecha_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getfecha_depre_acti().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha_depre_acti()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha_depre_acti()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha_depre_acti().toString();
				}
				if(depreciacionactivofijo.getfecha_depre_acti()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getfecha_depre_acti().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getporcentaje().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getporcentaje()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getporcentaje().toString();
				}
				if(depreciacionactivofijo.getporcentaje()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getcosto().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getcosto()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getcosto().toString();
				}
				if(depreciacionactivofijo.getcosto()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getvalor_acumulado().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_acumulado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_acumulado()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_acumulado().toString();
				}
				if(depreciacionactivofijo.getvalor_acumulado()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getvalor_acumulado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getvalor_total().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_total()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_total().toString();
				}
				if(depreciacionactivofijo.getvalor_total()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getvalor_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.VALORTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getvalor_gasto().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_gasto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_gasto()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getvalor_gasto().toString();
				}
				if(depreciacionactivofijo.getvalor_gasto()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getvalor_gasto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.VALORGASTO,strValorActual,strValorNuevo);
			}	
			
			if(depreciacionactivofijo.getIsNew()||!depreciacionactivofijo.getfecha().equals(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha()!=null)
				{
					strValorActual=depreciacionactivofijo.getDepreciacionActivoFijoOriginal().getfecha().toString();
				}
				if(depreciacionactivofijo.getfecha()!=null)
				{
					strValorNuevo=depreciacionactivofijo.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DepreciacionActivoFijoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDepreciacionActivoFijoRelacionesWithConnection(DepreciacionActivoFijo depreciacionactivofijo) throws Exception {

		if(!depreciacionactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDepreciacionActivoFijoRelacionesBase(depreciacionactivofijo,true);
		}
	}

	public void saveDepreciacionActivoFijoRelaciones(DepreciacionActivoFijo depreciacionactivofijo)throws Exception {

		if(!depreciacionactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDepreciacionActivoFijoRelacionesBase(depreciacionactivofijo,false);
		}
	}

	public void saveDepreciacionActivoFijoRelacionesBase(DepreciacionActivoFijo depreciacionactivofijo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DepreciacionActivoFijo-saveRelacionesWithConnection");}
	

			this.setDepreciacionActivoFijo(depreciacionactivofijo);

			if(DepreciacionActivoFijoLogicAdditional.validarSaveRelaciones(depreciacionactivofijo,this)) {

				DepreciacionActivoFijoLogicAdditional.updateRelacionesToSave(depreciacionactivofijo,this);

				if((depreciacionactivofijo.getIsNew()||depreciacionactivofijo.getIsChanged())&&!depreciacionactivofijo.getIsDeleted()) {
					this.saveDepreciacionActivoFijo();
					this.saveDepreciacionActivoFijoRelacionesDetalles();

				} else if(depreciacionactivofijo.getIsDeleted()) {
					this.saveDepreciacionActivoFijoRelacionesDetalles();
					this.saveDepreciacionActivoFijo();
				}

				DepreciacionActivoFijoLogicAdditional.updateRelacionesToSaveAfter(depreciacionactivofijo,this);

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
	
	
	private void saveDepreciacionActivoFijoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDepreciacionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DepreciacionActivoFijoConstantesFunciones.getClassesForeignKeysOfDepreciacionActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDepreciacionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DepreciacionActivoFijoConstantesFunciones.getClassesRelationshipsOfDepreciacionActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
