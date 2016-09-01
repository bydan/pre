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
import com.bydan.erp.activosfijos.util.ParteActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.ParteActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.ParteActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.ParteActivoFijo;
import com.bydan.erp.activosfijos.business.logic.ParteActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParteActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParteActivoFijoLogic.class);
	
	protected ParteActivoFijoDataAccess parteactivofijoDataAccess; 	
	protected ParteActivoFijo parteactivofijo;
	protected List<ParteActivoFijo> parteactivofijos;
	protected Object parteactivofijoObject;	
	protected List<Object> parteactivofijosObject;
	
	public static ClassValidator<ParteActivoFijo> parteactivofijoValidator = new ClassValidator<ParteActivoFijo>(ParteActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParteActivoFijoLogicAdditional parteactivofijoLogicAdditional=null;
	
	public ParteActivoFijoLogicAdditional getParteActivoFijoLogicAdditional() {
		return this.parteactivofijoLogicAdditional;
	}
	
	public void setParteActivoFijoLogicAdditional(ParteActivoFijoLogicAdditional parteactivofijoLogicAdditional) {
		try {
			this.parteactivofijoLogicAdditional=parteactivofijoLogicAdditional;
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
	
	
	
	
	public  ParteActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parteactivofijoDataAccess = new ParteActivoFijoDataAccess();
			
			this.parteactivofijos= new ArrayList<ParteActivoFijo>();
			this.parteactivofijo= new ParteActivoFijo();
			
			this.parteactivofijoObject=new Object();
			this.parteactivofijosObject=new ArrayList<Object>();
				
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
			
			this.parteactivofijoDataAccess.setConnexionType(this.connexionType);
			this.parteactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParteActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parteactivofijoDataAccess = new ParteActivoFijoDataAccess();
			this.parteactivofijos= new ArrayList<ParteActivoFijo>();
			this.parteactivofijo= new ParteActivoFijo();
			this.parteactivofijoObject=new Object();
			this.parteactivofijosObject=new ArrayList<Object>();
			
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
			
			this.parteactivofijoDataAccess.setConnexionType(this.connexionType);
			this.parteactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParteActivoFijo getParteActivoFijo() throws Exception {	
		ParteActivoFijoLogicAdditional.checkParteActivoFijoToGet(parteactivofijo,this.datosCliente,this.arrDatoGeneral);
		ParteActivoFijoLogicAdditional.updateParteActivoFijoToGet(parteactivofijo,this.arrDatoGeneral);
		
		return parteactivofijo;
	}
		
	public void setParteActivoFijo(ParteActivoFijo newParteActivoFijo) {
		this.parteactivofijo = newParteActivoFijo;
	}
	
	public ParteActivoFijoDataAccess getParteActivoFijoDataAccess() {
		return parteactivofijoDataAccess;
	}
	
	public void setParteActivoFijoDataAccess(ParteActivoFijoDataAccess newparteactivofijoDataAccess) {
		this.parteactivofijoDataAccess = newparteactivofijoDataAccess;
	}
	
	public List<ParteActivoFijo> getParteActivoFijos() throws Exception {		
		this.quitarParteActivoFijosNulos();
		
		ParteActivoFijoLogicAdditional.checkParteActivoFijoToGets(parteactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParteActivoFijo parteactivofijoLocal: parteactivofijos ) {
			ParteActivoFijoLogicAdditional.updateParteActivoFijoToGet(parteactivofijoLocal,this.arrDatoGeneral);
		}
		
		return parteactivofijos;
	}
	
	public void setParteActivoFijos(List<ParteActivoFijo> newParteActivoFijos) {
		this.parteactivofijos = newParteActivoFijos;
	}
	
	public Object getParteActivoFijoObject() {	
		this.parteactivofijoObject=this.parteactivofijoDataAccess.getEntityObject();
		return this.parteactivofijoObject;
	}
		
	public void setParteActivoFijoObject(Object newParteActivoFijoObject) {
		this.parteactivofijoObject = newParteActivoFijoObject;
	}
	
	public List<Object> getParteActivoFijosObject() {		
		this.parteactivofijosObject=this.parteactivofijoDataAccess.getEntitiesObject();
		return this.parteactivofijosObject;
	}
		
	public void setParteActivoFijosObject(List<Object> newParteActivoFijosObject) {
		this.parteactivofijosObject = newParteActivoFijosObject;
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
		
		if(this.parteactivofijoDataAccess!=null) {
			this.parteactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parteactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parteactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parteactivofijo = new  ParteActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parteactivofijo=parteactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parteactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijo);
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
		parteactivofijo = new  ParteActivoFijo();
		  		  
        try {
			
			parteactivofijo=parteactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parteactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parteactivofijo = new  ParteActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parteactivofijo=parteactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parteactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijo);
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
		parteactivofijo = new  ParteActivoFijo();
		  		  
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
		parteactivofijo = new  ParteActivoFijo();
		  		  
        try {
			
			parteactivofijo=parteactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parteactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parteactivofijo = new  ParteActivoFijo();
		  		  
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
		parteactivofijo = new  ParteActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parteactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parteactivofijo = new  ParteActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parteactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parteactivofijo = new  ParteActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parteactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parteactivofijo = new  ParteActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parteactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parteactivofijo = new  ParteActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parteactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parteactivofijo = new  ParteActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parteactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
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
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
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
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
        try {			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
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
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
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
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
        try {
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
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
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
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
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parteactivofijo = new  ParteActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijo=parteactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijo);
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
		parteactivofijo = new  ParteActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijo=parteactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
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
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		  		  
        try {
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParteActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getTodosParteActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
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
	
	public  void  getTodosParteActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		parteactivofijos = new  ArrayList<ParteActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParteActivoFijo(parteactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParteActivoFijo(ParteActivoFijo parteactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(parteactivofijo.getIsNew() || parteactivofijo.getIsChanged()) { 
			this.invalidValues = parteactivofijoValidator.getInvalidValues(parteactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parteactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParteActivoFijo(List<ParteActivoFijo> ParteActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParteActivoFijo parteactivofijoLocal:parteactivofijos) {				
			estaValidadoObjeto=this.validarGuardarParteActivoFijo(parteactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParteActivoFijo(List<ParteActivoFijo> ParteActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParteActivoFijo(parteactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParteActivoFijo(ParteActivoFijo ParteActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParteActivoFijo(parteactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParteActivoFijo parteactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parteactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParteActivoFijoConstantesFunciones.getParteActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parteactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParteActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParteActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParteActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-saveParteActivoFijoWithConnection");connexion.begin();			
			
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSave(this.parteactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParteActivoFijoLogicAdditional.updateParteActivoFijoToSave(this.parteactivofijo,this.arrDatoGeneral);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parteactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParteActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParteActivoFijo(this.parteactivofijo)) {
				ParteActivoFijoDataAccess.save(this.parteactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parteactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSaveAfter(this.parteactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParteActivoFijo();
			
			connexion.commit();			
			
			if(this.parteactivofijo.getIsDeleted()) {
				this.parteactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParteActivoFijo()throws Exception {	
		try {	
			
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSave(this.parteactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParteActivoFijoLogicAdditional.updateParteActivoFijoToSave(this.parteactivofijo,this.arrDatoGeneral);
			
			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parteactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParteActivoFijo(this.parteactivofijo)) {			
				ParteActivoFijoDataAccess.save(this.parteactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parteactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSaveAfter(this.parteactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parteactivofijo.getIsDeleted()) {
				this.parteactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParteActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-saveParteActivoFijosWithConnection");connexion.begin();			
			
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSaves(parteactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParteActivoFijos();
			
			Boolean validadoTodosParteActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParteActivoFijo parteactivofijoLocal:parteactivofijos) {		
				if(parteactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParteActivoFijoLogicAdditional.updateParteActivoFijoToSave(parteactivofijoLocal,this.arrDatoGeneral);
	        	
				ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parteactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParteActivoFijo(parteactivofijoLocal)) {
					ParteActivoFijoDataAccess.save(parteactivofijoLocal, connexion);				
				} else {
					validadoTodosParteActivoFijo=false;
				}
			}
			
			if(!validadoTodosParteActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSavesAfter(parteactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParteActivoFijos();
			
			connexion.commit();		
			
			this.quitarParteActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParteActivoFijos()throws Exception {				
		 try {	
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSaves(parteactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParteActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParteActivoFijo parteactivofijoLocal:parteactivofijos) {				
				if(parteactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParteActivoFijoLogicAdditional.updateParteActivoFijoToSave(parteactivofijoLocal,this.arrDatoGeneral);
	        	
				ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parteactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParteActivoFijo(parteactivofijoLocal)) {				
					ParteActivoFijoDataAccess.save(parteactivofijoLocal, connexion);				
				} else {
					validadoTodosParteActivoFijo=false;
				}
			}
			
			if(!validadoTodosParteActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParteActivoFijoLogicAdditional.checkParteActivoFijoToSavesAfter(parteactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParteActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParteActivoFijoParameterReturnGeneral procesarAccionParteActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParteActivoFijo> parteactivofijos,ParteActivoFijoParameterReturnGeneral parteactivofijoParameterGeneral)throws Exception {
		 try {	
			ParteActivoFijoParameterReturnGeneral parteactivofijoReturnGeneral=new ParteActivoFijoParameterReturnGeneral();
	
			ParteActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parteactivofijos,parteactivofijoParameterGeneral,parteactivofijoReturnGeneral);
			
			return parteactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParteActivoFijoParameterReturnGeneral procesarAccionParteActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParteActivoFijo> parteactivofijos,ParteActivoFijoParameterReturnGeneral parteactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-procesarAccionParteActivoFijosWithConnection");connexion.begin();			
			
			ParteActivoFijoParameterReturnGeneral parteactivofijoReturnGeneral=new ParteActivoFijoParameterReturnGeneral();
	
			ParteActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parteactivofijos,parteactivofijoParameterGeneral,parteactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return parteactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParteActivoFijoParameterReturnGeneral procesarEventosParteActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParteActivoFijo> parteactivofijos,ParteActivoFijo parteactivofijo,ParteActivoFijoParameterReturnGeneral parteactivofijoParameterGeneral,Boolean isEsNuevoParteActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParteActivoFijoParameterReturnGeneral parteactivofijoReturnGeneral=new ParteActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parteactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParteActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parteactivofijos,parteactivofijo,parteactivofijoParameterGeneral,parteactivofijoReturnGeneral,isEsNuevoParteActivoFijo,clases);
			
			return parteactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParteActivoFijoParameterReturnGeneral procesarEventosParteActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParteActivoFijo> parteactivofijos,ParteActivoFijo parteactivofijo,ParteActivoFijoParameterReturnGeneral parteactivofijoParameterGeneral,Boolean isEsNuevoParteActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-procesarEventosParteActivoFijosWithConnection");connexion.begin();			
			
			ParteActivoFijoParameterReturnGeneral parteactivofijoReturnGeneral=new ParteActivoFijoParameterReturnGeneral();
	
			parteactivofijoReturnGeneral.setParteActivoFijo(parteactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parteactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParteActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parteactivofijos,parteactivofijo,parteactivofijoParameterGeneral,parteactivofijoReturnGeneral,isEsNuevoParteActivoFijo,clases);
			
			this.connexion.commit();
			
			return parteactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParteActivoFijoParameterReturnGeneral procesarImportacionParteActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParteActivoFijoParameterReturnGeneral parteactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-procesarImportacionParteActivoFijosWithConnection");connexion.begin();			
			
			ParteActivoFijoParameterReturnGeneral parteactivofijoReturnGeneral=new ParteActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parteactivofijos=new ArrayList<ParteActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parteactivofijo=new ParteActivoFijo();
				
				
				if(conColumnasBase) {this.parteactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parteactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parteactivofijo.setcodigo(arrColumnas[iColumn++]);
				this.parteactivofijo.setnombre(arrColumnas[iColumn++]);
				this.parteactivofijo.setmarca(arrColumnas[iColumn++]);
				this.parteactivofijo.setserie(arrColumnas[iColumn++]);
				this.parteactivofijo.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.parteactivofijo.setfoto(arrColumnas[iColumn++]);
				
				this.parteactivofijos.add(this.parteactivofijo);
			}
			
			this.saveParteActivoFijos();
			
			this.connexion.commit();
			
			parteactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			parteactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parteactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParteActivoFijosEliminados() throws Exception {				
		
		List<ParteActivoFijo> parteactivofijosAux= new ArrayList<ParteActivoFijo>();
		
		for(ParteActivoFijo parteactivofijo:parteactivofijos) {
			if(!parteactivofijo.getIsDeleted()) {
				parteactivofijosAux.add(parteactivofijo);
			}
		}
		
		parteactivofijos=parteactivofijosAux;
	}
	
	public void quitarParteActivoFijosNulos() throws Exception {				
		
		List<ParteActivoFijo> parteactivofijosAux= new ArrayList<ParteActivoFijo>();
		
		for(ParteActivoFijo parteactivofijo : this.parteactivofijos) {
			if(parteactivofijo==null) {
				parteactivofijosAux.add(parteactivofijo);
			}
		}
		
		//this.parteactivofijos=parteactivofijosAux;
		
		this.parteactivofijos.removeAll(parteactivofijosAux);
	}
	
	public void getSetVersionRowParteActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parteactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parteactivofijo.getIsDeleted() || (parteactivofijo.getIsChanged()&&!parteactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parteactivofijoDataAccess.getSetVersionRowParteActivoFijo(connexion,parteactivofijo.getId());
				
				if(!parteactivofijo.getVersionRow().equals(timestamp)) {	
					parteactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parteactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParteActivoFijo()throws Exception {	
		
		if(parteactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parteactivofijo.getIsDeleted() || (parteactivofijo.getIsChanged()&&!parteactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parteactivofijoDataAccess.getSetVersionRowParteActivoFijo(connexion,parteactivofijo.getId());
			
			try {							
				if(!parteactivofijo.getVersionRow().equals(timestamp)) {	
					parteactivofijo.setVersionRow(timestamp);
				}
				
				parteactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParteActivoFijosWithConnection()throws Exception {	
		if(parteactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParteActivoFijo parteactivofijoAux:parteactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parteactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parteactivofijoAux.getIsDeleted() || (parteactivofijoAux.getIsChanged()&&!parteactivofijoAux.getIsNew())) {
						
						timestamp=parteactivofijoDataAccess.getSetVersionRowParteActivoFijo(connexion,parteactivofijoAux.getId());
						
						if(!parteactivofijo.getVersionRow().equals(timestamp)) {	
							parteactivofijoAux.setVersionRow(timestamp);
						}
								
						parteactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParteActivoFijos()throws Exception {	
		if(parteactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParteActivoFijo parteactivofijoAux:parteactivofijos) {
					if(parteactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parteactivofijoAux.getIsDeleted() || (parteactivofijoAux.getIsChanged()&&!parteactivofijoAux.getIsNew())) {
						
						timestamp=parteactivofijoDataAccess.getSetVersionRowParteActivoFijo(connexion,parteactivofijoAux.getId());
						
						if(!parteactivofijoAux.getVersionRow().equals(timestamp)) {	
							parteactivofijoAux.setVersionRow(timestamp);
						}
						
													
						parteactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParteActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyParteActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstadoActivoFijo,String finalQueryGlobalDetalleActivoFijo) throws Exception {
		ParteActivoFijoParameterReturnGeneral  parteactivofijoReturnGeneral =new ParteActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyParteActivoFijoWithConnection");connexion.begin();
			
			parteactivofijoReturnGeneral =new ParteActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parteactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parteactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<EstadoActivoFijo> estadoactivofijosForeignKey=new ArrayList<EstadoActivoFijo>();
			EstadoActivoFijoLogic estadoactivofijoLogic=new EstadoActivoFijoLogic();
			estadoactivofijoLogic.setConnexion(this.connexion);
			estadoactivofijoLogic.getEstadoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoActivoFijo.equals("NONE")) {
				estadoactivofijoLogic.getTodosEstadoActivoFijos(finalQueryGlobalEstadoActivoFijo,new Pagination());
				estadoactivofijosForeignKey=estadoactivofijoLogic.getEstadoActivoFijos();
			}

			parteactivofijoReturnGeneral.setestadoactivofijosForeignKey(estadoactivofijosForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			parteactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parteactivofijoReturnGeneral;
	}
	
	public ParteActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyParteActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstadoActivoFijo,String finalQueryGlobalDetalleActivoFijo) throws Exception {
		ParteActivoFijoParameterReturnGeneral  parteactivofijoReturnGeneral =new ParteActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parteactivofijoReturnGeneral =new ParteActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parteactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parteactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<EstadoActivoFijo> estadoactivofijosForeignKey=new ArrayList<EstadoActivoFijo>();
			EstadoActivoFijoLogic estadoactivofijoLogic=new EstadoActivoFijoLogic();
			estadoactivofijoLogic.setConnexion(this.connexion);
			estadoactivofijoLogic.getEstadoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoActivoFijo.equals("NONE")) {
				estadoactivofijoLogic.getTodosEstadoActivoFijos(finalQueryGlobalEstadoActivoFijo,new Pagination());
				estadoactivofijosForeignKey=estadoactivofijoLogic.getEstadoActivoFijos();
			}

			parteactivofijoReturnGeneral.setestadoactivofijosForeignKey(estadoactivofijosForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			parteactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parteactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(ParteActivoFijo parteactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParteActivoFijoLogicAdditional.updateParteActivoFijoToGet(parteactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parteactivofijo.setEmpresa(parteactivofijoDataAccess.getEmpresa(connexion,parteactivofijo));
		parteactivofijo.setSucursal(parteactivofijoDataAccess.getSucursal(connexion,parteactivofijo));
		parteactivofijo.setEstadoActivoFijo(parteactivofijoDataAccess.getEstadoActivoFijo(connexion,parteactivofijo));
		parteactivofijo.setDetalleActivoFijo(parteactivofijoDataAccess.getDetalleActivoFijo(connexion,parteactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parteactivofijo.setEmpresa(parteactivofijoDataAccess.getEmpresa(connexion,parteactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parteactivofijo.setSucursal(parteactivofijoDataAccess.getSucursal(connexion,parteactivofijo));
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				parteactivofijo.setEstadoActivoFijo(parteactivofijoDataAccess.getEstadoActivoFijo(connexion,parteactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				parteactivofijo.setDetalleActivoFijo(parteactivofijoDataAccess.getDetalleActivoFijo(connexion,parteactivofijo));
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
			parteactivofijo.setEmpresa(parteactivofijoDataAccess.getEmpresa(connexion,parteactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parteactivofijo.setSucursal(parteactivofijoDataAccess.getSucursal(connexion,parteactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parteactivofijo.setEstadoActivoFijo(parteactivofijoDataAccess.getEstadoActivoFijo(connexion,parteactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parteactivofijo.setDetalleActivoFijo(parteactivofijoDataAccess.getDetalleActivoFijo(connexion,parteactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parteactivofijo.setEmpresa(parteactivofijoDataAccess.getEmpresa(connexion,parteactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parteactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		parteactivofijo.setSucursal(parteactivofijoDataAccess.getSucursal(connexion,parteactivofijo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parteactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		parteactivofijo.setEstadoActivoFijo(parteactivofijoDataAccess.getEstadoActivoFijo(connexion,parteactivofijo));
		EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
		estadoactivofijoLogic.deepLoad(parteactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);
				
		parteactivofijo.setDetalleActivoFijo(parteactivofijoDataAccess.getDetalleActivoFijo(connexion,parteactivofijo));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(parteactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parteactivofijo.setEmpresa(parteactivofijoDataAccess.getEmpresa(connexion,parteactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parteactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parteactivofijo.setSucursal(parteactivofijoDataAccess.getSucursal(connexion,parteactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parteactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				parteactivofijo.setEstadoActivoFijo(parteactivofijoDataAccess.getEstadoActivoFijo(connexion,parteactivofijo));
				EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
				estadoactivofijoLogic.deepLoad(parteactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				parteactivofijo.setDetalleActivoFijo(parteactivofijoDataAccess.getDetalleActivoFijo(connexion,parteactivofijo));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(parteactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
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
			parteactivofijo.setEmpresa(parteactivofijoDataAccess.getEmpresa(connexion,parteactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parteactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parteactivofijo.setSucursal(parteactivofijoDataAccess.getSucursal(connexion,parteactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parteactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parteactivofijo.setEstadoActivoFijo(parteactivofijoDataAccess.getEstadoActivoFijo(connexion,parteactivofijo));
			EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
			estadoactivofijoLogic.deepLoad(parteactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parteactivofijo.setDetalleActivoFijo(parteactivofijoDataAccess.getDetalleActivoFijo(connexion,parteactivofijo));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(parteactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParteActivoFijo parteactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParteActivoFijoLogicAdditional.updateParteActivoFijoToSave(parteactivofijo,this.arrDatoGeneral);
			
ParteActivoFijoDataAccess.save(parteactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parteactivofijo.getEmpresa(),connexion);

		SucursalDataAccess.save(parteactivofijo.getSucursal(),connexion);

		EstadoActivoFijoDataAccess.save(parteactivofijo.getEstadoActivoFijo(),connexion);

		DetalleActivoFijoDataAccess.save(parteactivofijo.getDetalleActivoFijo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parteactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parteactivofijo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				EstadoActivoFijoDataAccess.save(parteactivofijo.getEstadoActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(parteactivofijo.getDetalleActivoFijo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parteactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parteactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parteactivofijo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parteactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				

		EstadoActivoFijoDataAccess.save(parteactivofijo.getEstadoActivoFijo(),connexion);
		EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
		estadoactivofijoLogic.deepLoad(parteactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(parteactivofijo.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(parteactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parteactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parteactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parteactivofijo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parteactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				EstadoActivoFijoDataAccess.save(parteactivofijo.getEstadoActivoFijo(),connexion);
				EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
				estadoactivofijoLogic.deepSave(parteactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(parteactivofijo.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(parteactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParteActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parteactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(parteactivofijo);
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
			this.deepLoad(this.parteactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParteActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parteactivofijos!=null) {
				for(ParteActivoFijo parteactivofijo:parteactivofijos) {
					this.deepLoad(parteactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(parteactivofijos);
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
			if(parteactivofijos!=null) {
				for(ParteActivoFijo parteactivofijo:parteactivofijos) {
					this.deepLoad(parteactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(parteactivofijos);
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
			this.getNewConnexionToDeep(ParteActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parteactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParteActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parteactivofijos!=null) {
				for(ParteActivoFijo parteactivofijo:parteactivofijos) {
					this.deepSave(parteactivofijo,isDeep,deepLoadType,clases);
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
			if(parteactivofijos!=null) {
				for(ParteActivoFijo parteactivofijo:parteactivofijos) {
					this.deepSave(parteactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParteActivoFijosFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParteActivoFijosFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParteActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParteActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParteActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParteActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParteActivoFijosFK_IdEstadoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_activo_fijo,ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoActivoFijo);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParteActivoFijosFK_IdEstadoActivoFijo(String sFinalQuery,Pagination pagination,Long id_estado_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_activo_fijo,ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoActivoFijo);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParteActivoFijosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParteActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParteActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParteActivoFijosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParteActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParteActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(this.parteactivofijos);
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
			if(ParteActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParteActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParteActivoFijo parteactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParteActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(parteactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParteActivoFijoDataAccess.TABLENAME, parteactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParteActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParteActivoFijoLogic.registrarAuditoriaDetallesParteActivoFijo(connexion,parteactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parteactivofijo.getIsDeleted()) {
					/*if(!parteactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParteActivoFijoDataAccess.TABLENAME, parteactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParteActivoFijoLogic.registrarAuditoriaDetallesParteActivoFijo(connexion,parteactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParteActivoFijoDataAccess.TABLENAME, parteactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parteactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParteActivoFijoDataAccess.TABLENAME, parteactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParteActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParteActivoFijoLogic.registrarAuditoriaDetallesParteActivoFijo(connexion,parteactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParteActivoFijo(Connexion connexion,ParteActivoFijo parteactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getid_empresa().equals(parteactivofijo.getParteActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getid_empresa().toString();
				}
				if(parteactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=parteactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getid_sucursal().equals(parteactivofijo.getParteActivoFijoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getid_sucursal()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getid_sucursal().toString();
				}
				if(parteactivofijo.getid_sucursal()!=null)
				{
					strValorNuevo=parteactivofijo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getid_estado_activo_fijo().equals(parteactivofijo.getParteActivoFijoOriginal().getid_estado_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getid_estado_activo_fijo()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getid_estado_activo_fijo().toString();
				}
				if(parteactivofijo.getid_estado_activo_fijo()!=null)
				{
					strValorNuevo=parteactivofijo.getid_estado_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getid_detalle_activo_fijo().equals(parteactivofijo.getParteActivoFijoOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getid_detalle_activo_fijo().toString();
				}
				if(parteactivofijo.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=parteactivofijo.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getcodigo().equals(parteactivofijo.getParteActivoFijoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getcodigo()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getcodigo();
				}
				if(parteactivofijo.getcodigo()!=null)
				{
					strValorNuevo=parteactivofijo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getnombre().equals(parteactivofijo.getParteActivoFijoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getnombre()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getnombre();
				}
				if(parteactivofijo.getnombre()!=null)
				{
					strValorNuevo=parteactivofijo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getmarca().equals(parteactivofijo.getParteActivoFijoOriginal().getmarca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getmarca()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getmarca();
				}
				if(parteactivofijo.getmarca()!=null)
				{
					strValorNuevo=parteactivofijo.getmarca() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.MARCA,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getserie().equals(parteactivofijo.getParteActivoFijoOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getserie()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getserie();
				}
				if(parteactivofijo.getserie()!=null)
				{
					strValorNuevo=parteactivofijo.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getcantidad().equals(parteactivofijo.getParteActivoFijoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getcantidad()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getcantidad().toString();
				}
				if(parteactivofijo.getcantidad()!=null)
				{
					strValorNuevo=parteactivofijo.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(parteactivofijo.getIsNew()||!parteactivofijo.getfoto().equals(parteactivofijo.getParteActivoFijoOriginal().getfoto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parteactivofijo.getParteActivoFijoOriginal().getfoto()!=null)
				{
					strValorActual=parteactivofijo.getParteActivoFijoOriginal().getfoto();
				}
				if(parteactivofijo.getfoto()!=null)
				{
					strValorNuevo=parteactivofijo.getfoto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParteActivoFijoConstantesFunciones.FOTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParteActivoFijoRelacionesWithConnection(ParteActivoFijo parteactivofijo) throws Exception {

		if(!parteactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParteActivoFijoRelacionesBase(parteactivofijo,true);
		}
	}

	public void saveParteActivoFijoRelaciones(ParteActivoFijo parteactivofijo)throws Exception {

		if(!parteactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParteActivoFijoRelacionesBase(parteactivofijo,false);
		}
	}

	public void saveParteActivoFijoRelacionesBase(ParteActivoFijo parteactivofijo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParteActivoFijo-saveRelacionesWithConnection");}
	

			this.setParteActivoFijo(parteactivofijo);

			if(ParteActivoFijoLogicAdditional.validarSaveRelaciones(parteactivofijo,this)) {

				ParteActivoFijoLogicAdditional.updateRelacionesToSave(parteactivofijo,this);

				if((parteactivofijo.getIsNew()||parteactivofijo.getIsChanged())&&!parteactivofijo.getIsDeleted()) {
					this.saveParteActivoFijo();
					this.saveParteActivoFijoRelacionesDetalles();

				} else if(parteactivofijo.getIsDeleted()) {
					this.saveParteActivoFijoRelacionesDetalles();
					this.saveParteActivoFijo();
				}

				ParteActivoFijoLogicAdditional.updateRelacionesToSaveAfter(parteactivofijo,this);

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
	
	
	private void saveParteActivoFijoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParteActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParteActivoFijoConstantesFunciones.getClassesForeignKeysOfParteActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParteActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParteActivoFijoConstantesFunciones.getClassesRelationshipsOfParteActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
