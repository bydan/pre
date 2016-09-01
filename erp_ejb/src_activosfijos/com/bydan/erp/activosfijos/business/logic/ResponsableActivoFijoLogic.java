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
import com.bydan.erp.activosfijos.util.ResponsableActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.ResponsableActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.ResponsableActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.ResponsableActivoFijo;
import com.bydan.erp.activosfijos.business.logic.ResponsableActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class ResponsableActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ResponsableActivoFijoLogic.class);
	
	protected ResponsableActivoFijoDataAccess responsableactivofijoDataAccess; 	
	protected ResponsableActivoFijo responsableactivofijo;
	protected List<ResponsableActivoFijo> responsableactivofijos;
	protected Object responsableactivofijoObject;	
	protected List<Object> responsableactivofijosObject;
	
	public static ClassValidator<ResponsableActivoFijo> responsableactivofijoValidator = new ClassValidator<ResponsableActivoFijo>(ResponsableActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ResponsableActivoFijoLogicAdditional responsableactivofijoLogicAdditional=null;
	
	public ResponsableActivoFijoLogicAdditional getResponsableActivoFijoLogicAdditional() {
		return this.responsableactivofijoLogicAdditional;
	}
	
	public void setResponsableActivoFijoLogicAdditional(ResponsableActivoFijoLogicAdditional responsableactivofijoLogicAdditional) {
		try {
			this.responsableactivofijoLogicAdditional=responsableactivofijoLogicAdditional;
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
	
	
	
	
	public  ResponsableActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.responsableactivofijoDataAccess = new ResponsableActivoFijoDataAccess();
			
			this.responsableactivofijos= new ArrayList<ResponsableActivoFijo>();
			this.responsableactivofijo= new ResponsableActivoFijo();
			
			this.responsableactivofijoObject=new Object();
			this.responsableactivofijosObject=new ArrayList<Object>();
				
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
			
			this.responsableactivofijoDataAccess.setConnexionType(this.connexionType);
			this.responsableactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ResponsableActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.responsableactivofijoDataAccess = new ResponsableActivoFijoDataAccess();
			this.responsableactivofijos= new ArrayList<ResponsableActivoFijo>();
			this.responsableactivofijo= new ResponsableActivoFijo();
			this.responsableactivofijoObject=new Object();
			this.responsableactivofijosObject=new ArrayList<Object>();
			
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
			
			this.responsableactivofijoDataAccess.setConnexionType(this.connexionType);
			this.responsableactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ResponsableActivoFijo getResponsableActivoFijo() throws Exception {	
		ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToGet(responsableactivofijo,this.datosCliente,this.arrDatoGeneral);
		ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToGet(responsableactivofijo,this.arrDatoGeneral);
		
		return responsableactivofijo;
	}
		
	public void setResponsableActivoFijo(ResponsableActivoFijo newResponsableActivoFijo) {
		this.responsableactivofijo = newResponsableActivoFijo;
	}
	
	public ResponsableActivoFijoDataAccess getResponsableActivoFijoDataAccess() {
		return responsableactivofijoDataAccess;
	}
	
	public void setResponsableActivoFijoDataAccess(ResponsableActivoFijoDataAccess newresponsableactivofijoDataAccess) {
		this.responsableactivofijoDataAccess = newresponsableactivofijoDataAccess;
	}
	
	public List<ResponsableActivoFijo> getResponsableActivoFijos() throws Exception {		
		this.quitarResponsableActivoFijosNulos();
		
		ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToGets(responsableactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (ResponsableActivoFijo responsableactivofijoLocal: responsableactivofijos ) {
			ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToGet(responsableactivofijoLocal,this.arrDatoGeneral);
		}
		
		return responsableactivofijos;
	}
	
	public void setResponsableActivoFijos(List<ResponsableActivoFijo> newResponsableActivoFijos) {
		this.responsableactivofijos = newResponsableActivoFijos;
	}
	
	public Object getResponsableActivoFijoObject() {	
		this.responsableactivofijoObject=this.responsableactivofijoDataAccess.getEntityObject();
		return this.responsableactivofijoObject;
	}
		
	public void setResponsableActivoFijoObject(Object newResponsableActivoFijoObject) {
		this.responsableactivofijoObject = newResponsableActivoFijoObject;
	}
	
	public List<Object> getResponsableActivoFijosObject() {		
		this.responsableactivofijosObject=this.responsableactivofijoDataAccess.getEntitiesObject();
		return this.responsableactivofijosObject;
	}
		
	public void setResponsableActivoFijosObject(List<Object> newResponsableActivoFijosObject) {
		this.responsableactivofijosObject = newResponsableActivoFijosObject;
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
		
		if(this.responsableactivofijoDataAccess!=null) {
			this.responsableactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			responsableactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			responsableactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		responsableactivofijo = new  ResponsableActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			responsableactivofijo=responsableactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsableactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijo);
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
		responsableactivofijo = new  ResponsableActivoFijo();
		  		  
        try {
			
			responsableactivofijo=responsableactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsableactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		responsableactivofijo = new  ResponsableActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			responsableactivofijo=responsableactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsableactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijo);
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
		responsableactivofijo = new  ResponsableActivoFijo();
		  		  
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
		responsableactivofijo = new  ResponsableActivoFijo();
		  		  
        try {
			
			responsableactivofijo=responsableactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsableactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		responsableactivofijo = new  ResponsableActivoFijo();
		  		  
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
		responsableactivofijo = new  ResponsableActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =responsableactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsableactivofijo = new  ResponsableActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=responsableactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		responsableactivofijo = new  ResponsableActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =responsableactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsableactivofijo = new  ResponsableActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=responsableactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		responsableactivofijo = new  ResponsableActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =responsableactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsableactivofijo = new  ResponsableActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=responsableactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
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
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
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
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
        try {			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
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
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
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
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
        try {
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
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
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
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
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		responsableactivofijo = new  ResponsableActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijo=responsableactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijo);
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
		responsableactivofijo = new  ResponsableActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijo=responsableactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
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
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		  		  
        try {
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosResponsableActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getTodosResponsableActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
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
	
	public  void  getTodosResponsableActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		responsableactivofijos = new  ArrayList<ResponsableActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResponsableActivoFijo(responsableactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarResponsableActivoFijo(ResponsableActivoFijo responsableactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(responsableactivofijo.getIsNew() || responsableactivofijo.getIsChanged()) { 
			this.invalidValues = responsableactivofijoValidator.getInvalidValues(responsableactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(responsableactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarResponsableActivoFijo(List<ResponsableActivoFijo> ResponsableActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ResponsableActivoFijo responsableactivofijoLocal:responsableactivofijos) {				
			estaValidadoObjeto=this.validarGuardarResponsableActivoFijo(responsableactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarResponsableActivoFijo(List<ResponsableActivoFijo> ResponsableActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResponsableActivoFijo(responsableactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarResponsableActivoFijo(ResponsableActivoFijo ResponsableActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResponsableActivoFijo(responsableactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ResponsableActivoFijo responsableactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+responsableactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ResponsableActivoFijoConstantesFunciones.getResponsableActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"responsableactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ResponsableActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ResponsableActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveResponsableActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-saveResponsableActivoFijoWithConnection");connexion.begin();			
			
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSave(this.responsableactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToSave(this.responsableactivofijo,this.arrDatoGeneral);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.responsableactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowResponsableActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResponsableActivoFijo(this.responsableactivofijo)) {
				ResponsableActivoFijoDataAccess.save(this.responsableactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.responsableactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSaveAfter(this.responsableactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResponsableActivoFijo();
			
			connexion.commit();			
			
			if(this.responsableactivofijo.getIsDeleted()) {
				this.responsableactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveResponsableActivoFijo()throws Exception {	
		try {	
			
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSave(this.responsableactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToSave(this.responsableactivofijo,this.arrDatoGeneral);
			
			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.responsableactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResponsableActivoFijo(this.responsableactivofijo)) {			
				ResponsableActivoFijoDataAccess.save(this.responsableactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.responsableactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSaveAfter(this.responsableactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.responsableactivofijo.getIsDeleted()) {
				this.responsableactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveResponsableActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-saveResponsableActivoFijosWithConnection");connexion.begin();			
			
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSaves(responsableactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowResponsableActivoFijos();
			
			Boolean validadoTodosResponsableActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ResponsableActivoFijo responsableactivofijoLocal:responsableactivofijos) {		
				if(responsableactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToSave(responsableactivofijoLocal,this.arrDatoGeneral);
	        	
				ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),responsableactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResponsableActivoFijo(responsableactivofijoLocal)) {
					ResponsableActivoFijoDataAccess.save(responsableactivofijoLocal, connexion);				
				} else {
					validadoTodosResponsableActivoFijo=false;
				}
			}
			
			if(!validadoTodosResponsableActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSavesAfter(responsableactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResponsableActivoFijos();
			
			connexion.commit();		
			
			this.quitarResponsableActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveResponsableActivoFijos()throws Exception {				
		 try {	
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSaves(responsableactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosResponsableActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ResponsableActivoFijo responsableactivofijoLocal:responsableactivofijos) {				
				if(responsableactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToSave(responsableactivofijoLocal,this.arrDatoGeneral);
	        	
				ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),responsableactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResponsableActivoFijo(responsableactivofijoLocal)) {				
					ResponsableActivoFijoDataAccess.save(responsableactivofijoLocal, connexion);				
				} else {
					validadoTodosResponsableActivoFijo=false;
				}
			}
			
			if(!validadoTodosResponsableActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResponsableActivoFijoLogicAdditional.checkResponsableActivoFijoToSavesAfter(responsableactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarResponsableActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResponsableActivoFijoParameterReturnGeneral procesarAccionResponsableActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResponsableActivoFijo> responsableactivofijos,ResponsableActivoFijoParameterReturnGeneral responsableactivofijoParameterGeneral)throws Exception {
		 try {	
			ResponsableActivoFijoParameterReturnGeneral responsableactivofijoReturnGeneral=new ResponsableActivoFijoParameterReturnGeneral();
	
			ResponsableActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,responsableactivofijos,responsableactivofijoParameterGeneral,responsableactivofijoReturnGeneral);
			
			return responsableactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResponsableActivoFijoParameterReturnGeneral procesarAccionResponsableActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResponsableActivoFijo> responsableactivofijos,ResponsableActivoFijoParameterReturnGeneral responsableactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-procesarAccionResponsableActivoFijosWithConnection");connexion.begin();			
			
			ResponsableActivoFijoParameterReturnGeneral responsableactivofijoReturnGeneral=new ResponsableActivoFijoParameterReturnGeneral();
	
			ResponsableActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,responsableactivofijos,responsableactivofijoParameterGeneral,responsableactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return responsableactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResponsableActivoFijoParameterReturnGeneral procesarEventosResponsableActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ResponsableActivoFijo> responsableactivofijos,ResponsableActivoFijo responsableactivofijo,ResponsableActivoFijoParameterReturnGeneral responsableactivofijoParameterGeneral,Boolean isEsNuevoResponsableActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			ResponsableActivoFijoParameterReturnGeneral responsableactivofijoReturnGeneral=new ResponsableActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				responsableactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResponsableActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,responsableactivofijos,responsableactivofijo,responsableactivofijoParameterGeneral,responsableactivofijoReturnGeneral,isEsNuevoResponsableActivoFijo,clases);
			
			return responsableactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ResponsableActivoFijoParameterReturnGeneral procesarEventosResponsableActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ResponsableActivoFijo> responsableactivofijos,ResponsableActivoFijo responsableactivofijo,ResponsableActivoFijoParameterReturnGeneral responsableactivofijoParameterGeneral,Boolean isEsNuevoResponsableActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-procesarEventosResponsableActivoFijosWithConnection");connexion.begin();			
			
			ResponsableActivoFijoParameterReturnGeneral responsableactivofijoReturnGeneral=new ResponsableActivoFijoParameterReturnGeneral();
	
			responsableactivofijoReturnGeneral.setResponsableActivoFijo(responsableactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				responsableactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResponsableActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,responsableactivofijos,responsableactivofijo,responsableactivofijoParameterGeneral,responsableactivofijoReturnGeneral,isEsNuevoResponsableActivoFijo,clases);
			
			this.connexion.commit();
			
			return responsableactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResponsableActivoFijoParameterReturnGeneral procesarImportacionResponsableActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ResponsableActivoFijoParameterReturnGeneral responsableactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-procesarImportacionResponsableActivoFijosWithConnection");connexion.begin();			
			
			ResponsableActivoFijoParameterReturnGeneral responsableactivofijoReturnGeneral=new ResponsableActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.responsableactivofijos=new ArrayList<ResponsableActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.responsableactivofijo=new ResponsableActivoFijo();
				
				
				if(conColumnasBase) {this.responsableactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.responsableactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.responsableactivofijo.setubicacion(arrColumnas[iColumn++]);
				this.responsableactivofijo.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.responsableactivofijo.setdescripcion(arrColumnas[iColumn++]);
				
				this.responsableactivofijos.add(this.responsableactivofijo);
			}
			
			this.saveResponsableActivoFijos();
			
			this.connexion.commit();
			
			responsableactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			responsableactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return responsableactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarResponsableActivoFijosEliminados() throws Exception {				
		
		List<ResponsableActivoFijo> responsableactivofijosAux= new ArrayList<ResponsableActivoFijo>();
		
		for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos) {
			if(!responsableactivofijo.getIsDeleted()) {
				responsableactivofijosAux.add(responsableactivofijo);
			}
		}
		
		responsableactivofijos=responsableactivofijosAux;
	}
	
	public void quitarResponsableActivoFijosNulos() throws Exception {				
		
		List<ResponsableActivoFijo> responsableactivofijosAux= new ArrayList<ResponsableActivoFijo>();
		
		for(ResponsableActivoFijo responsableactivofijo : this.responsableactivofijos) {
			if(responsableactivofijo==null) {
				responsableactivofijosAux.add(responsableactivofijo);
			}
		}
		
		//this.responsableactivofijos=responsableactivofijosAux;
		
		this.responsableactivofijos.removeAll(responsableactivofijosAux);
	}
	
	public void getSetVersionRowResponsableActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(responsableactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((responsableactivofijo.getIsDeleted() || (responsableactivofijo.getIsChanged()&&!responsableactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=responsableactivofijoDataAccess.getSetVersionRowResponsableActivoFijo(connexion,responsableactivofijo.getId());
				
				if(!responsableactivofijo.getVersionRow().equals(timestamp)) {	
					responsableactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				responsableactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowResponsableActivoFijo()throws Exception {	
		
		if(responsableactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((responsableactivofijo.getIsDeleted() || (responsableactivofijo.getIsChanged()&&!responsableactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=responsableactivofijoDataAccess.getSetVersionRowResponsableActivoFijo(connexion,responsableactivofijo.getId());
			
			try {							
				if(!responsableactivofijo.getVersionRow().equals(timestamp)) {	
					responsableactivofijo.setVersionRow(timestamp);
				}
				
				responsableactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowResponsableActivoFijosWithConnection()throws Exception {	
		if(responsableactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ResponsableActivoFijo responsableactivofijoAux:responsableactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(responsableactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(responsableactivofijoAux.getIsDeleted() || (responsableactivofijoAux.getIsChanged()&&!responsableactivofijoAux.getIsNew())) {
						
						timestamp=responsableactivofijoDataAccess.getSetVersionRowResponsableActivoFijo(connexion,responsableactivofijoAux.getId());
						
						if(!responsableactivofijo.getVersionRow().equals(timestamp)) {	
							responsableactivofijoAux.setVersionRow(timestamp);
						}
								
						responsableactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowResponsableActivoFijos()throws Exception {	
		if(responsableactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ResponsableActivoFijo responsableactivofijoAux:responsableactivofijos) {
					if(responsableactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(responsableactivofijoAux.getIsDeleted() || (responsableactivofijoAux.getIsChanged()&&!responsableactivofijoAux.getIsNew())) {
						
						timestamp=responsableactivofijoDataAccess.getSetVersionRowResponsableActivoFijo(connexion,responsableactivofijoAux.getId());
						
						if(!responsableactivofijoAux.getVersionRow().equals(timestamp)) {	
							responsableactivofijoAux.setVersionRow(timestamp);
						}
						
													
						responsableactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ResponsableActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyResponsableActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado) throws Exception {
		ResponsableActivoFijoParameterReturnGeneral  responsableactivofijoReturnGeneral =new ResponsableActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyResponsableActivoFijoWithConnection");connexion.begin();
			
			responsableactivofijoReturnGeneral =new ResponsableActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			responsableactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			responsableactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			responsableactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			responsableactivofijoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			responsableactivofijoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return responsableactivofijoReturnGeneral;
	}
	
	public ResponsableActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyResponsableActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleado) throws Exception {
		ResponsableActivoFijoParameterReturnGeneral  responsableactivofijoReturnGeneral =new ResponsableActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			responsableactivofijoReturnGeneral =new ResponsableActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			responsableactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			responsableactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			responsableactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			responsableactivofijoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			responsableactivofijoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return responsableactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(ResponsableActivoFijo responsableactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToGet(responsableactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		responsableactivofijo.setEmpresa(responsableactivofijoDataAccess.getEmpresa(connexion,responsableactivofijo));
		responsableactivofijo.setSucursal(responsableactivofijoDataAccess.getSucursal(connexion,responsableactivofijo));
		responsableactivofijo.setDetalleActivoFijo(responsableactivofijoDataAccess.getDetalleActivoFijo(connexion,responsableactivofijo));
		responsableactivofijo.setEstructura(responsableactivofijoDataAccess.getEstructura(connexion,responsableactivofijo));
		responsableactivofijo.setEmpleado(responsableactivofijoDataAccess.getEmpleado(connexion,responsableactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				responsableactivofijo.setEmpresa(responsableactivofijoDataAccess.getEmpresa(connexion,responsableactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				responsableactivofijo.setSucursal(responsableactivofijoDataAccess.getSucursal(connexion,responsableactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				responsableactivofijo.setDetalleActivoFijo(responsableactivofijoDataAccess.getDetalleActivoFijo(connexion,responsableactivofijo));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				responsableactivofijo.setEstructura(responsableactivofijoDataAccess.getEstructura(connexion,responsableactivofijo));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				responsableactivofijo.setEmpleado(responsableactivofijoDataAccess.getEmpleado(connexion,responsableactivofijo));
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
			responsableactivofijo.setEmpresa(responsableactivofijoDataAccess.getEmpresa(connexion,responsableactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setSucursal(responsableactivofijoDataAccess.getSucursal(connexion,responsableactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setDetalleActivoFijo(responsableactivofijoDataAccess.getDetalleActivoFijo(connexion,responsableactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setEstructura(responsableactivofijoDataAccess.getEstructura(connexion,responsableactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setEmpleado(responsableactivofijoDataAccess.getEmpleado(connexion,responsableactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		responsableactivofijo.setEmpresa(responsableactivofijoDataAccess.getEmpresa(connexion,responsableactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(responsableactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		responsableactivofijo.setSucursal(responsableactivofijoDataAccess.getSucursal(connexion,responsableactivofijo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(responsableactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		responsableactivofijo.setDetalleActivoFijo(responsableactivofijoDataAccess.getDetalleActivoFijo(connexion,responsableactivofijo));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(responsableactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		responsableactivofijo.setEstructura(responsableactivofijoDataAccess.getEstructura(connexion,responsableactivofijo));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(responsableactivofijo.getEstructura(),isDeep,deepLoadType,clases);
				
		responsableactivofijo.setEmpleado(responsableactivofijoDataAccess.getEmpleado(connexion,responsableactivofijo));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(responsableactivofijo.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				responsableactivofijo.setEmpresa(responsableactivofijoDataAccess.getEmpresa(connexion,responsableactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(responsableactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				responsableactivofijo.setSucursal(responsableactivofijoDataAccess.getSucursal(connexion,responsableactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(responsableactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				responsableactivofijo.setDetalleActivoFijo(responsableactivofijoDataAccess.getDetalleActivoFijo(connexion,responsableactivofijo));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(responsableactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				responsableactivofijo.setEstructura(responsableactivofijoDataAccess.getEstructura(connexion,responsableactivofijo));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(responsableactivofijo.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				responsableactivofijo.setEmpleado(responsableactivofijoDataAccess.getEmpleado(connexion,responsableactivofijo));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(responsableactivofijo.getEmpleado(),isDeep,deepLoadType,clases);				
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
			responsableactivofijo.setEmpresa(responsableactivofijoDataAccess.getEmpresa(connexion,responsableactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(responsableactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setSucursal(responsableactivofijoDataAccess.getSucursal(connexion,responsableactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(responsableactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setDetalleActivoFijo(responsableactivofijoDataAccess.getDetalleActivoFijo(connexion,responsableactivofijo));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(responsableactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setEstructura(responsableactivofijoDataAccess.getEstructura(connexion,responsableactivofijo));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(responsableactivofijo.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsableactivofijo.setEmpleado(responsableactivofijoDataAccess.getEmpleado(connexion,responsableactivofijo));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(responsableactivofijo.getEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ResponsableActivoFijo responsableactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ResponsableActivoFijoLogicAdditional.updateResponsableActivoFijoToSave(responsableactivofijo,this.arrDatoGeneral);
			
ResponsableActivoFijoDataAccess.save(responsableactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(responsableactivofijo.getEmpresa(),connexion);

		SucursalDataAccess.save(responsableactivofijo.getSucursal(),connexion);

		DetalleActivoFijoDataAccess.save(responsableactivofijo.getDetalleActivoFijo(),connexion);

		EstructuraDataAccess.save(responsableactivofijo.getEstructura(),connexion);

		EmpleadoDataAccess.save(responsableactivofijo.getEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(responsableactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(responsableactivofijo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(responsableactivofijo.getDetalleActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(responsableactivofijo.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(responsableactivofijo.getEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(responsableactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(responsableactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(responsableactivofijo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(responsableactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(responsableactivofijo.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(responsableactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(responsableactivofijo.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(responsableactivofijo.getEstructura(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(responsableactivofijo.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(responsableactivofijo.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(responsableactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(responsableactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(responsableactivofijo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(responsableactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(responsableactivofijo.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(responsableactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(responsableactivofijo.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(responsableactivofijo.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(responsableactivofijo.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(responsableactivofijo.getEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ResponsableActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(responsableactivofijo);
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
			this.deepLoad(this.responsableactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ResponsableActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(responsableactivofijos!=null) {
				for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos) {
					this.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(responsableactivofijos);
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
			if(responsableactivofijos!=null) {
				for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos) {
					this.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(responsableactivofijos);
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
			this.getNewConnexionToDeep(ResponsableActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(responsableactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ResponsableActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(responsableactivofijos!=null) {
				for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos) {
					this.deepSave(responsableactivofijo,isDeep,deepLoadType,clases);
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
			if(responsableactivofijos!=null) {
				for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos) {
					this.deepSave(responsableactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getResponsableActivoFijosFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableActivoFijosFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsableActivoFijosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ResponsableActivoFijoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableActivoFijosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ResponsableActivoFijoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsableActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsableActivoFijosFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableActivoFijosFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsableActivoFijosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableActivoFijosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ResponsableActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(this.responsableactivofijos);
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
			if(ResponsableActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ResponsableActivoFijo responsableactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ResponsableActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(responsableactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableActivoFijoDataAccess.TABLENAME, responsableactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResponsableActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResponsableActivoFijoLogic.registrarAuditoriaDetallesResponsableActivoFijo(connexion,responsableactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(responsableactivofijo.getIsDeleted()) {
					/*if(!responsableactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ResponsableActivoFijoDataAccess.TABLENAME, responsableactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ResponsableActivoFijoLogic.registrarAuditoriaDetallesResponsableActivoFijo(connexion,responsableactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableActivoFijoDataAccess.TABLENAME, responsableactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(responsableactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableActivoFijoDataAccess.TABLENAME, responsableactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResponsableActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResponsableActivoFijoLogic.registrarAuditoriaDetallesResponsableActivoFijo(connexion,responsableactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesResponsableActivoFijo(Connexion connexion,ResponsableActivoFijo responsableactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getid_empresa().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getid_empresa().toString();
				}
				if(responsableactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=responsableactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getid_sucursal().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getid_sucursal()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getid_sucursal().toString();
				}
				if(responsableactivofijo.getid_sucursal()!=null)
				{
					strValorNuevo=responsableactivofijo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getid_detalle_activo_fijo().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getid_detalle_activo_fijo().toString();
				}
				if(responsableactivofijo.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=responsableactivofijo.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getid_estructura().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getid_estructura()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getid_estructura().toString();
				}
				if(responsableactivofijo.getid_estructura()!=null)
				{
					strValorNuevo=responsableactivofijo.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getid_empleado().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getid_empleado()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getid_empleado().toString();
				}
				if(responsableactivofijo.getid_empleado()!=null)
				{
					strValorNuevo=responsableactivofijo.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getubicacion().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getubicacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getubicacion()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getubicacion();
				}
				if(responsableactivofijo.getubicacion()!=null)
				{
					strValorNuevo=responsableactivofijo.getubicacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.UBICACION,strValorActual,strValorNuevo);
			}	
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getfecha().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getfecha()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getfecha().toString();
				}
				if(responsableactivofijo.getfecha()!=null)
				{
					strValorNuevo=responsableactivofijo.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(responsableactivofijo.getIsNew()||!responsableactivofijo.getdescripcion().equals(responsableactivofijo.getResponsableActivoFijoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsableactivofijo.getResponsableActivoFijoOriginal().getdescripcion()!=null)
				{
					strValorActual=responsableactivofijo.getResponsableActivoFijoOriginal().getdescripcion();
				}
				if(responsableactivofijo.getdescripcion()!=null)
				{
					strValorNuevo=responsableactivofijo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableActivoFijoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveResponsableActivoFijoRelacionesWithConnection(ResponsableActivoFijo responsableactivofijo) throws Exception {

		if(!responsableactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResponsableActivoFijoRelacionesBase(responsableactivofijo,true);
		}
	}

	public void saveResponsableActivoFijoRelaciones(ResponsableActivoFijo responsableactivofijo)throws Exception {

		if(!responsableactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResponsableActivoFijoRelacionesBase(responsableactivofijo,false);
		}
	}

	public void saveResponsableActivoFijoRelacionesBase(ResponsableActivoFijo responsableactivofijo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ResponsableActivoFijo-saveRelacionesWithConnection");}
	

			this.setResponsableActivoFijo(responsableactivofijo);

			if(ResponsableActivoFijoLogicAdditional.validarSaveRelaciones(responsableactivofijo,this)) {

				ResponsableActivoFijoLogicAdditional.updateRelacionesToSave(responsableactivofijo,this);

				if((responsableactivofijo.getIsNew()||responsableactivofijo.getIsChanged())&&!responsableactivofijo.getIsDeleted()) {
					this.saveResponsableActivoFijo();
					this.saveResponsableActivoFijoRelacionesDetalles();

				} else if(responsableactivofijo.getIsDeleted()) {
					this.saveResponsableActivoFijoRelacionesDetalles();
					this.saveResponsableActivoFijo();
				}

				ResponsableActivoFijoLogicAdditional.updateRelacionesToSaveAfter(responsableactivofijo,this);

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
	
	
	private void saveResponsableActivoFijoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfResponsableActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResponsableActivoFijoConstantesFunciones.getClassesForeignKeysOfResponsableActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsableActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResponsableActivoFijoConstantesFunciones.getClassesRelationshipsOfResponsableActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
