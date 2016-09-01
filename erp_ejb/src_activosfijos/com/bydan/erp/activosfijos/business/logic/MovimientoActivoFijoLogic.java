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
import com.bydan.erp.activosfijos.util.MovimientoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.MovimientoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.MovimientoActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.MovimientoActivoFijo;
import com.bydan.erp.activosfijos.business.logic.MovimientoActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class MovimientoActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MovimientoActivoFijoLogic.class);
	
	protected MovimientoActivoFijoDataAccess movimientoactivofijoDataAccess; 	
	protected MovimientoActivoFijo movimientoactivofijo;
	protected List<MovimientoActivoFijo> movimientoactivofijos;
	protected Object movimientoactivofijoObject;	
	protected List<Object> movimientoactivofijosObject;
	
	public static ClassValidator<MovimientoActivoFijo> movimientoactivofijoValidator = new ClassValidator<MovimientoActivoFijo>(MovimientoActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MovimientoActivoFijoLogicAdditional movimientoactivofijoLogicAdditional=null;
	
	public MovimientoActivoFijoLogicAdditional getMovimientoActivoFijoLogicAdditional() {
		return this.movimientoactivofijoLogicAdditional;
	}
	
	public void setMovimientoActivoFijoLogicAdditional(MovimientoActivoFijoLogicAdditional movimientoactivofijoLogicAdditional) {
		try {
			this.movimientoactivofijoLogicAdditional=movimientoactivofijoLogicAdditional;
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
	
	
	
	
	public  MovimientoActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.movimientoactivofijoDataAccess = new MovimientoActivoFijoDataAccess();
			
			this.movimientoactivofijos= new ArrayList<MovimientoActivoFijo>();
			this.movimientoactivofijo= new MovimientoActivoFijo();
			
			this.movimientoactivofijoObject=new Object();
			this.movimientoactivofijosObject=new ArrayList<Object>();
				
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
			
			this.movimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.movimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MovimientoActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.movimientoactivofijoDataAccess = new MovimientoActivoFijoDataAccess();
			this.movimientoactivofijos= new ArrayList<MovimientoActivoFijo>();
			this.movimientoactivofijo= new MovimientoActivoFijo();
			this.movimientoactivofijoObject=new Object();
			this.movimientoactivofijosObject=new ArrayList<Object>();
			
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
			
			this.movimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.movimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MovimientoActivoFijo getMovimientoActivoFijo() throws Exception {	
		MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToGet(movimientoactivofijo,this.datosCliente,this.arrDatoGeneral);
		MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToGet(movimientoactivofijo,this.arrDatoGeneral);
		
		return movimientoactivofijo;
	}
		
	public void setMovimientoActivoFijo(MovimientoActivoFijo newMovimientoActivoFijo) {
		this.movimientoactivofijo = newMovimientoActivoFijo;
	}
	
	public MovimientoActivoFijoDataAccess getMovimientoActivoFijoDataAccess() {
		return movimientoactivofijoDataAccess;
	}
	
	public void setMovimientoActivoFijoDataAccess(MovimientoActivoFijoDataAccess newmovimientoactivofijoDataAccess) {
		this.movimientoactivofijoDataAccess = newmovimientoactivofijoDataAccess;
	}
	
	public List<MovimientoActivoFijo> getMovimientoActivoFijos() throws Exception {		
		this.quitarMovimientoActivoFijosNulos();
		
		MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToGets(movimientoactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (MovimientoActivoFijo movimientoactivofijoLocal: movimientoactivofijos ) {
			MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToGet(movimientoactivofijoLocal,this.arrDatoGeneral);
		}
		
		return movimientoactivofijos;
	}
	
	public void setMovimientoActivoFijos(List<MovimientoActivoFijo> newMovimientoActivoFijos) {
		this.movimientoactivofijos = newMovimientoActivoFijos;
	}
	
	public Object getMovimientoActivoFijoObject() {	
		this.movimientoactivofijoObject=this.movimientoactivofijoDataAccess.getEntityObject();
		return this.movimientoactivofijoObject;
	}
		
	public void setMovimientoActivoFijoObject(Object newMovimientoActivoFijoObject) {
		this.movimientoactivofijoObject = newMovimientoActivoFijoObject;
	}
	
	public List<Object> getMovimientoActivoFijosObject() {		
		this.movimientoactivofijosObject=this.movimientoactivofijoDataAccess.getEntitiesObject();
		return this.movimientoactivofijosObject;
	}
		
	public void setMovimientoActivoFijosObject(List<Object> newMovimientoActivoFijosObject) {
		this.movimientoactivofijosObject = newMovimientoActivoFijosObject;
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
		
		if(this.movimientoactivofijoDataAccess!=null) {
			this.movimientoactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			movimientoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			movimientoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		movimientoactivofijo = new  MovimientoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			movimientoactivofijo=movimientoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijo);
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		  		  
        try {
			
			movimientoactivofijo=movimientoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		movimientoactivofijo = new  MovimientoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			movimientoactivofijo=movimientoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijo);
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		  		  
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		  		  
        try {
			
			movimientoactivofijo=movimientoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.movimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		movimientoactivofijo = new  MovimientoActivoFijo();
		  		  
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =movimientoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=movimientoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		movimientoactivofijo = new  MovimientoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =movimientoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=movimientoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		movimientoactivofijo = new  MovimientoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =movimientoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=movimientoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
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
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
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
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
        try {			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
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
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
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
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
        try {
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
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
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
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
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		movimientoactivofijo = new  MovimientoActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijo=movimientoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijo);
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
		movimientoactivofijo = new  MovimientoActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijo=movimientoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
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
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		  		  
        try {
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMovimientoActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getTodosMovimientoActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
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
	
	public  void  getTodosMovimientoActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		movimientoactivofijos = new  ArrayList<MovimientoActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMovimientoActivoFijo(movimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(movimientoactivofijo.getIsNew() || movimientoactivofijo.getIsChanged()) { 
			this.invalidValues = movimientoactivofijoValidator.getInvalidValues(movimientoactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(movimientoactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMovimientoActivoFijo(List<MovimientoActivoFijo> MovimientoActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(MovimientoActivoFijo movimientoactivofijoLocal:movimientoactivofijos) {				
			estaValidadoObjeto=this.validarGuardarMovimientoActivoFijo(movimientoactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMovimientoActivoFijo(List<MovimientoActivoFijo> MovimientoActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMovimientoActivoFijo(movimientoactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMovimientoActivoFijo(MovimientoActivoFijo MovimientoActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMovimientoActivoFijo(movimientoactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(MovimientoActivoFijo movimientoactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+movimientoactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MovimientoActivoFijoConstantesFunciones.getMovimientoActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"movimientoactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MovimientoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MovimientoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMovimientoActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-saveMovimientoActivoFijoWithConnection");connexion.begin();			
			
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSave(this.movimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToSave(this.movimientoactivofijo,this.arrDatoGeneral);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.movimientoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMovimientoActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMovimientoActivoFijo(this.movimientoactivofijo)) {
				MovimientoActivoFijoDataAccess.save(this.movimientoactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.movimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSaveAfter(this.movimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMovimientoActivoFijo();
			
			connexion.commit();			
			
			if(this.movimientoactivofijo.getIsDeleted()) {
				this.movimientoactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMovimientoActivoFijo()throws Exception {	
		try {	
			
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSave(this.movimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToSave(this.movimientoactivofijo,this.arrDatoGeneral);
			
			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.movimientoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMovimientoActivoFijo(this.movimientoactivofijo)) {			
				MovimientoActivoFijoDataAccess.save(this.movimientoactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.movimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSaveAfter(this.movimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.movimientoactivofijo.getIsDeleted()) {
				this.movimientoactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMovimientoActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-saveMovimientoActivoFijosWithConnection");connexion.begin();			
			
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSaves(movimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMovimientoActivoFijos();
			
			Boolean validadoTodosMovimientoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MovimientoActivoFijo movimientoactivofijoLocal:movimientoactivofijos) {		
				if(movimientoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToSave(movimientoactivofijoLocal,this.arrDatoGeneral);
	        	
				MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),movimientoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMovimientoActivoFijo(movimientoactivofijoLocal)) {
					MovimientoActivoFijoDataAccess.save(movimientoactivofijoLocal, connexion);				
				} else {
					validadoTodosMovimientoActivoFijo=false;
				}
			}
			
			if(!validadoTodosMovimientoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSavesAfter(movimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMovimientoActivoFijos();
			
			connexion.commit();		
			
			this.quitarMovimientoActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMovimientoActivoFijos()throws Exception {				
		 try {	
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSaves(movimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMovimientoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MovimientoActivoFijo movimientoactivofijoLocal:movimientoactivofijos) {				
				if(movimientoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToSave(movimientoactivofijoLocal,this.arrDatoGeneral);
	        	
				MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),movimientoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMovimientoActivoFijo(movimientoactivofijoLocal)) {				
					MovimientoActivoFijoDataAccess.save(movimientoactivofijoLocal, connexion);				
				} else {
					validadoTodosMovimientoActivoFijo=false;
				}
			}
			
			if(!validadoTodosMovimientoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MovimientoActivoFijoLogicAdditional.checkMovimientoActivoFijoToSavesAfter(movimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMovimientoActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MovimientoActivoFijoParameterReturnGeneral procesarAccionMovimientoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientoActivoFijo> movimientoactivofijos,MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoParameterGeneral)throws Exception {
		 try {	
			MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoReturnGeneral=new MovimientoActivoFijoParameterReturnGeneral();
	
			MovimientoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientoactivofijos,movimientoactivofijoParameterGeneral,movimientoactivofijoReturnGeneral);
			
			return movimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MovimientoActivoFijoParameterReturnGeneral procesarAccionMovimientoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MovimientoActivoFijo> movimientoactivofijos,MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-procesarAccionMovimientoActivoFijosWithConnection");connexion.begin();			
			
			MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoReturnGeneral=new MovimientoActivoFijoParameterReturnGeneral();
	
			MovimientoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,movimientoactivofijos,movimientoactivofijoParameterGeneral,movimientoactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return movimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MovimientoActivoFijoParameterReturnGeneral procesarEventosMovimientoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MovimientoActivoFijo> movimientoactivofijos,MovimientoActivoFijo movimientoactivofijo,MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoParameterGeneral,Boolean isEsNuevoMovimientoActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoReturnGeneral=new MovimientoActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				movimientoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MovimientoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,movimientoactivofijos,movimientoactivofijo,movimientoactivofijoParameterGeneral,movimientoactivofijoReturnGeneral,isEsNuevoMovimientoActivoFijo,clases);
			
			return movimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MovimientoActivoFijoParameterReturnGeneral procesarEventosMovimientoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MovimientoActivoFijo> movimientoactivofijos,MovimientoActivoFijo movimientoactivofijo,MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoParameterGeneral,Boolean isEsNuevoMovimientoActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-procesarEventosMovimientoActivoFijosWithConnection");connexion.begin();			
			
			MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoReturnGeneral=new MovimientoActivoFijoParameterReturnGeneral();
	
			movimientoactivofijoReturnGeneral.setMovimientoActivoFijo(movimientoactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				movimientoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MovimientoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,movimientoactivofijos,movimientoactivofijo,movimientoactivofijoParameterGeneral,movimientoactivofijoReturnGeneral,isEsNuevoMovimientoActivoFijo,clases);
			
			this.connexion.commit();
			
			return movimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MovimientoActivoFijoParameterReturnGeneral procesarImportacionMovimientoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-procesarImportacionMovimientoActivoFijosWithConnection");connexion.begin();			
			
			MovimientoActivoFijoParameterReturnGeneral movimientoactivofijoReturnGeneral=new MovimientoActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.movimientoactivofijos=new ArrayList<MovimientoActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.movimientoactivofijo=new MovimientoActivoFijo();
				
				
				if(conColumnasBase) {this.movimientoactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.movimientoactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.movimientoactivofijo.setsecuencial(arrColumnas[iColumn++]);
				this.movimientoactivofijo.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.movimientoactivofijo.setnumero_documento(arrColumnas[iColumn++]);
				this.movimientoactivofijo.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoactivofijo.setdepreciacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoactivofijo.setcosto_origen(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoactivofijo.setdepreciacion_origen(Double.parseDouble(arrColumnas[iColumn++]));
				this.movimientoactivofijo.setrazon(arrColumnas[iColumn++]);
				this.movimientoactivofijo.setdescripcion(arrColumnas[iColumn++]);
				
				this.movimientoactivofijos.add(this.movimientoactivofijo);
			}
			
			this.saveMovimientoActivoFijos();
			
			this.connexion.commit();
			
			movimientoactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			movimientoactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return movimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMovimientoActivoFijosEliminados() throws Exception {				
		
		List<MovimientoActivoFijo> movimientoactivofijosAux= new ArrayList<MovimientoActivoFijo>();
		
		for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos) {
			if(!movimientoactivofijo.getIsDeleted()) {
				movimientoactivofijosAux.add(movimientoactivofijo);
			}
		}
		
		movimientoactivofijos=movimientoactivofijosAux;
	}
	
	public void quitarMovimientoActivoFijosNulos() throws Exception {				
		
		List<MovimientoActivoFijo> movimientoactivofijosAux= new ArrayList<MovimientoActivoFijo>();
		
		for(MovimientoActivoFijo movimientoactivofijo : this.movimientoactivofijos) {
			if(movimientoactivofijo==null) {
				movimientoactivofijosAux.add(movimientoactivofijo);
			}
		}
		
		//this.movimientoactivofijos=movimientoactivofijosAux;
		
		this.movimientoactivofijos.removeAll(movimientoactivofijosAux);
	}
	
	public void getSetVersionRowMovimientoActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(movimientoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((movimientoactivofijo.getIsDeleted() || (movimientoactivofijo.getIsChanged()&&!movimientoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=movimientoactivofijoDataAccess.getSetVersionRowMovimientoActivoFijo(connexion,movimientoactivofijo.getId());
				
				if(!movimientoactivofijo.getVersionRow().equals(timestamp)) {	
					movimientoactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				movimientoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMovimientoActivoFijo()throws Exception {	
		
		if(movimientoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((movimientoactivofijo.getIsDeleted() || (movimientoactivofijo.getIsChanged()&&!movimientoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=movimientoactivofijoDataAccess.getSetVersionRowMovimientoActivoFijo(connexion,movimientoactivofijo.getId());
			
			try {							
				if(!movimientoactivofijo.getVersionRow().equals(timestamp)) {	
					movimientoactivofijo.setVersionRow(timestamp);
				}
				
				movimientoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMovimientoActivoFijosWithConnection()throws Exception {	
		if(movimientoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(MovimientoActivoFijo movimientoactivofijoAux:movimientoactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(movimientoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(movimientoactivofijoAux.getIsDeleted() || (movimientoactivofijoAux.getIsChanged()&&!movimientoactivofijoAux.getIsNew())) {
						
						timestamp=movimientoactivofijoDataAccess.getSetVersionRowMovimientoActivoFijo(connexion,movimientoactivofijoAux.getId());
						
						if(!movimientoactivofijo.getVersionRow().equals(timestamp)) {	
							movimientoactivofijoAux.setVersionRow(timestamp);
						}
								
						movimientoactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowMovimientoActivoFijos()throws Exception {	
		if(movimientoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(MovimientoActivoFijo movimientoactivofijoAux:movimientoactivofijos) {
					if(movimientoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(movimientoactivofijoAux.getIsDeleted() || (movimientoactivofijoAux.getIsChanged()&&!movimientoactivofijoAux.getIsNew())) {
						
						timestamp=movimientoactivofijoDataAccess.getSetVersionRowMovimientoActivoFijo(connexion,movimientoactivofijoAux.getId());
						
						if(!movimientoactivofijoAux.getVersionRow().equals(timestamp)) {	
							movimientoactivofijoAux.setVersionRow(timestamp);
						}
						
													
						movimientoactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MovimientoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyMovimientoActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalEmpresaOrigen,String finalQueryGlobalSucursalOrigen,String finalQueryGlobalDetalleActivoFijoOrigen,String finalQueryGlobalEmpresaDestino,String finalQueryGlobalSucursalDestino,String finalQueryGlobalDetalleActivoFijoDestino) throws Exception {
		MovimientoActivoFijoParameterReturnGeneral  movimientoactivofijoReturnGeneral =new MovimientoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyMovimientoActivoFijoWithConnection");connexion.begin();
			
			movimientoactivofijoReturnGeneral =new MovimientoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			movimientoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			movimientoactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			movimientoactivofijoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Empresa> empresaorigensForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaorigenLogic=new EmpresaLogic();
			empresaorigenLogic.setConnexion(this.connexion);
			empresaorigenLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaOrigen.equals("NONE")) {
				empresaorigenLogic.getTodosEmpresas(finalQueryGlobalEmpresaOrigen,new Pagination());
				empresaorigensForeignKey=empresaorigenLogic.getEmpresas();
			}

			movimientoactivofijoReturnGeneral.setempresaorigensForeignKey(empresaorigensForeignKey);


			List<Sucursal> sucursalorigensForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalorigenLogic=new SucursalLogic();
			sucursalorigenLogic.setConnexion(this.connexion);
			sucursalorigenLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalOrigen.equals("NONE")) {
				sucursalorigenLogic.getTodosSucursals(finalQueryGlobalSucursalOrigen,new Pagination());
				sucursalorigensForeignKey=sucursalorigenLogic.getSucursals();
			}

			movimientoactivofijoReturnGeneral.setsucursalorigensForeignKey(sucursalorigensForeignKey);


			List<DetalleActivoFijo> detalleactivofijoorigensForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoorigenLogic=new DetalleActivoFijoLogic();
			detalleactivofijoorigenLogic.setConnexion(this.connexion);
			detalleactivofijoorigenLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijoOrigen.equals("NONE")) {
				detalleactivofijoorigenLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijoOrigen,new Pagination());
				detalleactivofijoorigensForeignKey=detalleactivofijoorigenLogic.getDetalleActivoFijos();
			}

			movimientoactivofijoReturnGeneral.setdetalleactivofijoorigensForeignKey(detalleactivofijoorigensForeignKey);


			List<Empresa> empresadestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresadestinoLogic=new EmpresaLogic();
			empresadestinoLogic.setConnexion(this.connexion);
			empresadestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaDestino.equals("NONE")) {
				empresadestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaDestino,new Pagination());
				empresadestinosForeignKey=empresadestinoLogic.getEmpresas();
			}

			movimientoactivofijoReturnGeneral.setempresadestinosForeignKey(empresadestinosForeignKey);


			List<Sucursal> sucursaldestinosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursaldestinoLogic=new SucursalLogic();
			sucursaldestinoLogic.setConnexion(this.connexion);
			sucursaldestinoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalDestino.equals("NONE")) {
				sucursaldestinoLogic.getTodosSucursals(finalQueryGlobalSucursalDestino,new Pagination());
				sucursaldestinosForeignKey=sucursaldestinoLogic.getSucursals();
			}

			movimientoactivofijoReturnGeneral.setsucursaldestinosForeignKey(sucursaldestinosForeignKey);


			List<DetalleActivoFijo> detalleactivofijodestinosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijodestinoLogic=new DetalleActivoFijoLogic();
			detalleactivofijodestinoLogic.setConnexion(this.connexion);
			detalleactivofijodestinoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijoDestino.equals("NONE")) {
				detalleactivofijodestinoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijoDestino,new Pagination());
				detalleactivofijodestinosForeignKey=detalleactivofijodestinoLogic.getDetalleActivoFijos();
			}

			movimientoactivofijoReturnGeneral.setdetalleactivofijodestinosForeignKey(detalleactivofijodestinosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return movimientoactivofijoReturnGeneral;
	}
	
	public MovimientoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyMovimientoActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalEmpresaOrigen,String finalQueryGlobalSucursalOrigen,String finalQueryGlobalDetalleActivoFijoOrigen,String finalQueryGlobalEmpresaDestino,String finalQueryGlobalSucursalDestino,String finalQueryGlobalDetalleActivoFijoDestino) throws Exception {
		MovimientoActivoFijoParameterReturnGeneral  movimientoactivofijoReturnGeneral =new MovimientoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			movimientoactivofijoReturnGeneral =new MovimientoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			movimientoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			movimientoactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			movimientoactivofijoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Empresa> empresaorigensForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaorigenLogic=new EmpresaLogic();
			empresaorigenLogic.setConnexion(this.connexion);
			empresaorigenLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaOrigen.equals("NONE")) {
				empresaorigenLogic.getTodosEmpresas(finalQueryGlobalEmpresaOrigen,new Pagination());
				empresaorigensForeignKey=empresaorigenLogic.getEmpresas();
			}

			movimientoactivofijoReturnGeneral.setempresaorigensForeignKey(empresaorigensForeignKey);


			List<Sucursal> sucursalorigensForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalorigenLogic=new SucursalLogic();
			sucursalorigenLogic.setConnexion(this.connexion);
			sucursalorigenLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalOrigen.equals("NONE")) {
				sucursalorigenLogic.getTodosSucursals(finalQueryGlobalSucursalOrigen,new Pagination());
				sucursalorigensForeignKey=sucursalorigenLogic.getSucursals();
			}

			movimientoactivofijoReturnGeneral.setsucursalorigensForeignKey(sucursalorigensForeignKey);


			List<DetalleActivoFijo> detalleactivofijoorigensForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoorigenLogic=new DetalleActivoFijoLogic();
			detalleactivofijoorigenLogic.setConnexion(this.connexion);
			detalleactivofijoorigenLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijoOrigen.equals("NONE")) {
				detalleactivofijoorigenLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijoOrigen,new Pagination());
				detalleactivofijoorigensForeignKey=detalleactivofijoorigenLogic.getDetalleActivoFijos();
			}

			movimientoactivofijoReturnGeneral.setdetalleactivofijoorigensForeignKey(detalleactivofijoorigensForeignKey);


			List<Empresa> empresadestinosForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresadestinoLogic=new EmpresaLogic();
			empresadestinoLogic.setConnexion(this.connexion);
			empresadestinoLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresaDestino.equals("NONE")) {
				empresadestinoLogic.getTodosEmpresas(finalQueryGlobalEmpresaDestino,new Pagination());
				empresadestinosForeignKey=empresadestinoLogic.getEmpresas();
			}

			movimientoactivofijoReturnGeneral.setempresadestinosForeignKey(empresadestinosForeignKey);


			List<Sucursal> sucursaldestinosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursaldestinoLogic=new SucursalLogic();
			sucursaldestinoLogic.setConnexion(this.connexion);
			sucursaldestinoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalDestino.equals("NONE")) {
				sucursaldestinoLogic.getTodosSucursals(finalQueryGlobalSucursalDestino,new Pagination());
				sucursaldestinosForeignKey=sucursaldestinoLogic.getSucursals();
			}

			movimientoactivofijoReturnGeneral.setsucursaldestinosForeignKey(sucursaldestinosForeignKey);


			List<DetalleActivoFijo> detalleactivofijodestinosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijodestinoLogic=new DetalleActivoFijoLogic();
			detalleactivofijodestinoLogic.setConnexion(this.connexion);
			detalleactivofijodestinoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijoDestino.equals("NONE")) {
				detalleactivofijodestinoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijoDestino,new Pagination());
				detalleactivofijodestinosForeignKey=detalleactivofijodestinoLogic.getDetalleActivoFijos();
			}

			movimientoactivofijoReturnGeneral.setdetalleactivofijodestinosForeignKey(detalleactivofijodestinosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return movimientoactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(MovimientoActivoFijo movimientoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToGet(movimientoactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientoactivofijo.setEmpresa(movimientoactivofijoDataAccess.getEmpresa(connexion,movimientoactivofijo));
		movimientoactivofijo.setSucursal(movimientoactivofijoDataAccess.getSucursal(connexion,movimientoactivofijo));
		movimientoactivofijo.setUsuario(movimientoactivofijoDataAccess.getUsuario(connexion,movimientoactivofijo));
		movimientoactivofijo.setEmpresaOrigen(movimientoactivofijoDataAccess.getEmpresaOrigen(connexion,movimientoactivofijo));
		movimientoactivofijo.setSucursalOrigen(movimientoactivofijoDataAccess.getSucursalOrigen(connexion,movimientoactivofijo));
		movimientoactivofijo.setDetalleActivoFijoOrigen(movimientoactivofijoDataAccess.getDetalleActivoFijoOrigen(connexion,movimientoactivofijo));
		movimientoactivofijo.setEmpresaDestino(movimientoactivofijoDataAccess.getEmpresaDestino(connexion,movimientoactivofijo));
		movimientoactivofijo.setSucursalDestino(movimientoactivofijoDataAccess.getSucursalDestino(connexion,movimientoactivofijo));
		movimientoactivofijo.setDetalleActivoFijoDestino(movimientoactivofijoDataAccess.getDetalleActivoFijoDestino(connexion,movimientoactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientoactivofijo.setEmpresa(movimientoactivofijoDataAccess.getEmpresa(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoactivofijo.setSucursal(movimientoactivofijoDataAccess.getSucursal(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				movimientoactivofijo.setUsuario(movimientoactivofijoDataAccess.getUsuario(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				movimientoactivofijo.setEmpresaOrigen(movimientoactivofijoDataAccess.getEmpresaOrigen(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoactivofijo.setSucursalOrigen(movimientoactivofijoDataAccess.getSucursalOrigen(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				movimientoactivofijo.setDetalleActivoFijoOrigen(movimientoactivofijoDataAccess.getDetalleActivoFijoOrigen(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				movimientoactivofijo.setEmpresaDestino(movimientoactivofijoDataAccess.getEmpresaDestino(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoactivofijo.setSucursalDestino(movimientoactivofijoDataAccess.getSucursalDestino(connexion,movimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				movimientoactivofijo.setDetalleActivoFijoDestino(movimientoactivofijoDataAccess.getDetalleActivoFijoDestino(connexion,movimientoactivofijo));
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
			movimientoactivofijo.setEmpresa(movimientoactivofijoDataAccess.getEmpresa(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setSucursal(movimientoactivofijoDataAccess.getSucursal(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setUsuario(movimientoactivofijoDataAccess.getUsuario(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setEmpresaOrigen(movimientoactivofijoDataAccess.getEmpresaOrigen(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setSucursalOrigen(movimientoactivofijoDataAccess.getSucursalOrigen(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setDetalleActivoFijoOrigen(movimientoactivofijoDataAccess.getDetalleActivoFijoOrigen(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setEmpresaDestino(movimientoactivofijoDataAccess.getEmpresaDestino(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setSucursalDestino(movimientoactivofijoDataAccess.getSucursalDestino(connexion,movimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setDetalleActivoFijoDestino(movimientoactivofijoDataAccess.getDetalleActivoFijoDestino(connexion,movimientoactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		movimientoactivofijo.setEmpresa(movimientoactivofijoDataAccess.getEmpresa(connexion,movimientoactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(movimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setSucursal(movimientoactivofijoDataAccess.getSucursal(connexion,movimientoactivofijo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(movimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setUsuario(movimientoactivofijoDataAccess.getUsuario(connexion,movimientoactivofijo));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(movimientoactivofijo.getUsuario(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setEmpresaOrigen(movimientoactivofijoDataAccess.getEmpresaOrigen(connexion,movimientoactivofijo));
		EmpresaLogic empresaorigenLogic= new EmpresaLogic(connexion);
		empresaorigenLogic.deepLoad(movimientoactivofijo.getEmpresaOrigen(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setSucursalOrigen(movimientoactivofijoDataAccess.getSucursalOrigen(connexion,movimientoactivofijo));
		SucursalLogic sucursalorigenLogic= new SucursalLogic(connexion);
		sucursalorigenLogic.deepLoad(movimientoactivofijo.getSucursalOrigen(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setDetalleActivoFijoOrigen(movimientoactivofijoDataAccess.getDetalleActivoFijoOrigen(connexion,movimientoactivofijo));
		DetalleActivoFijoLogic detalleactivofijoorigenLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoorigenLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoOrigen(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setEmpresaDestino(movimientoactivofijoDataAccess.getEmpresaDestino(connexion,movimientoactivofijo));
		EmpresaLogic empresadestinoLogic= new EmpresaLogic(connexion);
		empresadestinoLogic.deepLoad(movimientoactivofijo.getEmpresaDestino(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setSucursalDestino(movimientoactivofijoDataAccess.getSucursalDestino(connexion,movimientoactivofijo));
		SucursalLogic sucursaldestinoLogic= new SucursalLogic(connexion);
		sucursaldestinoLogic.deepLoad(movimientoactivofijo.getSucursalDestino(),isDeep,deepLoadType,clases);
				
		movimientoactivofijo.setDetalleActivoFijoDestino(movimientoactivofijoDataAccess.getDetalleActivoFijoDestino(connexion,movimientoactivofijo));
		DetalleActivoFijoLogic detalleactivofijodestinoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijodestinoLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoDestino(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				movimientoactivofijo.setEmpresa(movimientoactivofijoDataAccess.getEmpresa(connexion,movimientoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(movimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoactivofijo.setSucursal(movimientoactivofijoDataAccess.getSucursal(connexion,movimientoactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(movimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				movimientoactivofijo.setUsuario(movimientoactivofijoDataAccess.getUsuario(connexion,movimientoactivofijo));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(movimientoactivofijo.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				movimientoactivofijo.setEmpresaOrigen(movimientoactivofijoDataAccess.getEmpresaOrigen(connexion,movimientoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(movimientoactivofijo.getEmpresaOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoactivofijo.setSucursalOrigen(movimientoactivofijoDataAccess.getSucursalOrigen(connexion,movimientoactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(movimientoactivofijo.getSucursalOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				movimientoactivofijo.setDetalleActivoFijoOrigen(movimientoactivofijoDataAccess.getDetalleActivoFijoOrigen(connexion,movimientoactivofijo));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				movimientoactivofijo.setEmpresaDestino(movimientoactivofijoDataAccess.getEmpresaDestino(connexion,movimientoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(movimientoactivofijo.getEmpresaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				movimientoactivofijo.setSucursalDestino(movimientoactivofijoDataAccess.getSucursalDestino(connexion,movimientoactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(movimientoactivofijo.getSucursalDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				movimientoactivofijo.setDetalleActivoFijoDestino(movimientoactivofijoDataAccess.getDetalleActivoFijoDestino(connexion,movimientoactivofijo));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoDestino(),isDeep,deepLoadType,clases);				
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
			movimientoactivofijo.setEmpresa(movimientoactivofijoDataAccess.getEmpresa(connexion,movimientoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(movimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setSucursal(movimientoactivofijoDataAccess.getSucursal(connexion,movimientoactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(movimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setUsuario(movimientoactivofijoDataAccess.getUsuario(connexion,movimientoactivofijo));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(movimientoactivofijo.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setEmpresaOrigen(movimientoactivofijoDataAccess.getEmpresaOrigen(connexion,movimientoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(movimientoactivofijo.getEmpresaOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setSucursalOrigen(movimientoactivofijoDataAccess.getSucursalOrigen(connexion,movimientoactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(movimientoactivofijo.getSucursalOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setDetalleActivoFijoOrigen(movimientoactivofijoDataAccess.getDetalleActivoFijoOrigen(connexion,movimientoactivofijo));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setEmpresaDestino(movimientoactivofijoDataAccess.getEmpresaDestino(connexion,movimientoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(movimientoactivofijo.getEmpresaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setSucursalDestino(movimientoactivofijoDataAccess.getSucursalDestino(connexion,movimientoactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(movimientoactivofijo.getSucursalDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			movimientoactivofijo.setDetalleActivoFijoDestino(movimientoactivofijoDataAccess.getDetalleActivoFijoDestino(connexion,movimientoactivofijo));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoDestino(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(MovimientoActivoFijo movimientoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MovimientoActivoFijoLogicAdditional.updateMovimientoActivoFijoToSave(movimientoactivofijo,this.arrDatoGeneral);
			
MovimientoActivoFijoDataAccess.save(movimientoactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(movimientoactivofijo.getEmpresa(),connexion);

		SucursalDataAccess.save(movimientoactivofijo.getSucursal(),connexion);

		UsuarioDataAccess.save(movimientoactivofijo.getUsuario(),connexion);

		EmpresaDataAccess.save(movimientoactivofijo.getEmpresaOrigen(),connexion);

		SucursalDataAccess.save(movimientoactivofijo.getSucursalOrigen(),connexion);

		DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoOrigen(),connexion);

		EmpresaDataAccess.save(movimientoactivofijo.getEmpresaDestino(),connexion);

		SucursalDataAccess.save(movimientoactivofijo.getSucursalDestino(),connexion);

		DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoDestino(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoactivofijo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(movimientoactivofijo.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoactivofijo.getEmpresaOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoactivofijo.getSucursalOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoactivofijo.getEmpresaDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoactivofijo.getSucursalDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoDestino(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(movimientoactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(movimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(movimientoactivofijo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(movimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(movimientoactivofijo.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(movimientoactivofijo.getUsuario(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(movimientoactivofijo.getEmpresaOrigen(),connexion);
		EmpresaLogic empresaorigenLogic= new EmpresaLogic(connexion);
		empresaorigenLogic.deepLoad(movimientoactivofijo.getEmpresaOrigen(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(movimientoactivofijo.getSucursalOrigen(),connexion);
		SucursalLogic sucursalorigenLogic= new SucursalLogic(connexion);
		sucursalorigenLogic.deepLoad(movimientoactivofijo.getSucursalOrigen(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoOrigen(),connexion);
		DetalleActivoFijoLogic detalleactivofijoorigenLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoorigenLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoOrigen(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(movimientoactivofijo.getEmpresaDestino(),connexion);
		EmpresaLogic empresadestinoLogic= new EmpresaLogic(connexion);
		empresadestinoLogic.deepLoad(movimientoactivofijo.getEmpresaDestino(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(movimientoactivofijo.getSucursalDestino(),connexion);
		SucursalLogic sucursaldestinoLogic= new SucursalLogic(connexion);
		sucursaldestinoLogic.deepLoad(movimientoactivofijo.getSucursalDestino(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoDestino(),connexion);
		DetalleActivoFijoLogic detalleactivofijodestinoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijodestinoLogic.deepLoad(movimientoactivofijo.getDetalleActivoFijoDestino(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(movimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoactivofijo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(movimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(movimientoactivofijo.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(movimientoactivofijo.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoactivofijo.getEmpresaOrigen(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(movimientoactivofijo.getEmpresaOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoactivofijo.getSucursalOrigen(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(movimientoactivofijo.getSucursalOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoOrigen(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(movimientoactivofijo.getDetalleActivoFijoOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(movimientoactivofijo.getEmpresaDestino(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(movimientoactivofijo.getEmpresaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(movimientoactivofijo.getSucursalDestino(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(movimientoactivofijo.getSucursalDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(movimientoactivofijo.getDetalleActivoFijoDestino(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(movimientoactivofijo.getDetalleActivoFijoDestino(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(MovimientoActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(movimientoactivofijo);
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
			this.deepLoad(this.movimientoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MovimientoActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(movimientoactivofijos!=null) {
				for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos) {
					this.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(movimientoactivofijos);
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
			if(movimientoactivofijos!=null) {
				for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos) {
					this.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(movimientoactivofijos);
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
			this.getNewConnexionToDeep(MovimientoActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(movimientoactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(MovimientoActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(movimientoactivofijos!=null) {
				for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos) {
					this.deepSave(movimientoactivofijo,isDeep,deepLoadType,clases);
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
			if(movimientoactivofijos!=null) {
				for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos) {
					this.deepSave(movimientoactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMovimientoActivoFijosFK_IdDetalleActivoFijoDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijoDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijoDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo_destino,MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijoDestino);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijoDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdDetalleActivoFijoDestino(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijoDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijoDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo_destino,MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijoDestino);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijoDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdDetalleActivoFijoOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijoOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijoOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo_origen,MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijoOrigen);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijoOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdDetalleActivoFijoOrigen(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijoOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijoOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo_origen,MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijoOrigen);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijoOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MovimientoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MovimientoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdEmpresaDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_destino,MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaDestino);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdEmpresaDestino(String sFinalQuery,Pagination pagination,Long id_empresa_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_destino,MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaDestino);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdEmpresaOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_origen,MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaOrigen);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdEmpresaOrigen(String sFinalQuery,Pagination pagination,Long id_empresa_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresaOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresaOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa_origen,MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresaOrigen);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresaOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MovimientoActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MovimientoActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdSucursalDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_destino,MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalDestino);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdSucursalDestino(String sFinalQuery,Pagination pagination,Long id_sucursal_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_destino,MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalDestino);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdSucursalOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_origen,MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalOrigen);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdSucursalOrigen(String sFinalQuery,Pagination pagination,Long id_sucursal_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_origen,MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalOrigen);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMovimientoActivoFijosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MovimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,MovimientoActivoFijoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMovimientoActivoFijosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,MovimientoActivoFijoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			MovimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(this.movimientoactivofijos);
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
			if(MovimientoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,MovimientoActivoFijo movimientoactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MovimientoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(movimientoactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoActivoFijoDataAccess.TABLENAME, movimientoactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MovimientoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MovimientoActivoFijoLogic.registrarAuditoriaDetallesMovimientoActivoFijo(connexion,movimientoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(movimientoactivofijo.getIsDeleted()) {
					/*if(!movimientoactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MovimientoActivoFijoDataAccess.TABLENAME, movimientoactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MovimientoActivoFijoLogic.registrarAuditoriaDetallesMovimientoActivoFijo(connexion,movimientoactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoActivoFijoDataAccess.TABLENAME, movimientoactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(movimientoactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MovimientoActivoFijoDataAccess.TABLENAME, movimientoactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MovimientoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MovimientoActivoFijoLogic.registrarAuditoriaDetallesMovimientoActivoFijo(connexion,movimientoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMovimientoActivoFijo(Connexion connexion,MovimientoActivoFijo movimientoactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_empresa().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa().toString();
				}
				if(movimientoactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_sucursal().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal().toString();
				}
				if(movimientoactivofijo.getid_sucursal()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_usuario().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_usuario()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_usuario().toString();
				}
				if(movimientoactivofijo.getid_usuario()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getsecuencial().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getsecuencial()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getsecuencial();
				}
				if(movimientoactivofijo.getsecuencial()!=null)
				{
					strValorNuevo=movimientoactivofijo.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_empresa_origen().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa_origen()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa_origen().toString();
				}
				if(movimientoactivofijo.getid_empresa_origen()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_empresa_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_sucursal_origen().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal_origen()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal_origen().toString();
				}
				if(movimientoactivofijo.getid_sucursal_origen()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_sucursal_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_detalle_activo_fijo_origen().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_detalle_activo_fijo_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_detalle_activo_fijo_origen()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_detalle_activo_fijo_origen().toString();
				}
				if(movimientoactivofijo.getid_detalle_activo_fijo_origen()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_detalle_activo_fijo_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_empresa_destino().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa_destino()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_empresa_destino().toString();
				}
				if(movimientoactivofijo.getid_empresa_destino()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_empresa_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_sucursal_destino().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal_destino()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_sucursal_destino().toString();
				}
				if(movimientoactivofijo.getid_sucursal_destino()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_sucursal_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getid_detalle_activo_fijo_destino().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_detalle_activo_fijo_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_detalle_activo_fijo_destino()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getid_detalle_activo_fijo_destino().toString();
				}
				if(movimientoactivofijo.getid_detalle_activo_fijo_destino()!=null)
				{
					strValorNuevo=movimientoactivofijo.getid_detalle_activo_fijo_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getfecha().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getfecha()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getfecha().toString();
				}
				if(movimientoactivofijo.getfecha()!=null)
				{
					strValorNuevo=movimientoactivofijo.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getnumero_documento().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getnumero_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getnumero_documento()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getnumero_documento();
				}
				if(movimientoactivofijo.getnumero_documento()!=null)
				{
					strValorNuevo=movimientoactivofijo.getnumero_documento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getcosto().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getcosto()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getcosto().toString();
				}
				if(movimientoactivofijo.getcosto()!=null)
				{
					strValorNuevo=movimientoactivofijo.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getdepreciacion().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getdepreciacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getdepreciacion()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getdepreciacion().toString();
				}
				if(movimientoactivofijo.getdepreciacion()!=null)
				{
					strValorNuevo=movimientoactivofijo.getdepreciacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.DEPRECIACION,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getcosto_origen().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getcosto_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getcosto_origen()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getcosto_origen().toString();
				}
				if(movimientoactivofijo.getcosto_origen()!=null)
				{
					strValorNuevo=movimientoactivofijo.getcosto_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.COSTOORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getdepreciacion_origen().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getdepreciacion_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getdepreciacion_origen()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getdepreciacion_origen().toString();
				}
				if(movimientoactivofijo.getdepreciacion_origen()!=null)
				{
					strValorNuevo=movimientoactivofijo.getdepreciacion_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getrazon().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getrazon()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getrazon()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getrazon();
				}
				if(movimientoactivofijo.getrazon()!=null)
				{
					strValorNuevo=movimientoactivofijo.getrazon() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.RAZON,strValorActual,strValorNuevo);
			}	
			
			if(movimientoactivofijo.getIsNew()||!movimientoactivofijo.getdescripcion().equals(movimientoactivofijo.getMovimientoActivoFijoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(movimientoactivofijo.getMovimientoActivoFijoOriginal().getdescripcion()!=null)
				{
					strValorActual=movimientoactivofijo.getMovimientoActivoFijoOriginal().getdescripcion();
				}
				if(movimientoactivofijo.getdescripcion()!=null)
				{
					strValorNuevo=movimientoactivofijo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MovimientoActivoFijoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMovimientoActivoFijoRelacionesWithConnection(MovimientoActivoFijo movimientoactivofijo) throws Exception {

		if(!movimientoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMovimientoActivoFijoRelacionesBase(movimientoactivofijo,true);
		}
	}

	public void saveMovimientoActivoFijoRelaciones(MovimientoActivoFijo movimientoactivofijo)throws Exception {

		if(!movimientoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMovimientoActivoFijoRelacionesBase(movimientoactivofijo,false);
		}
	}

	public void saveMovimientoActivoFijoRelacionesBase(MovimientoActivoFijo movimientoactivofijo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("MovimientoActivoFijo-saveRelacionesWithConnection");}
	

			this.setMovimientoActivoFijo(movimientoactivofijo);

			if(MovimientoActivoFijoLogicAdditional.validarSaveRelaciones(movimientoactivofijo,this)) {

				MovimientoActivoFijoLogicAdditional.updateRelacionesToSave(movimientoactivofijo,this);

				if((movimientoactivofijo.getIsNew()||movimientoactivofijo.getIsChanged())&&!movimientoactivofijo.getIsDeleted()) {
					this.saveMovimientoActivoFijo();
					this.saveMovimientoActivoFijoRelacionesDetalles();

				} else if(movimientoactivofijo.getIsDeleted()) {
					this.saveMovimientoActivoFijoRelacionesDetalles();
					this.saveMovimientoActivoFijo();
				}

				MovimientoActivoFijoLogicAdditional.updateRelacionesToSaveAfter(movimientoactivofijo,this);

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
	
	
	private void saveMovimientoActivoFijoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMovimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MovimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMovimientoActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MovimientoActivoFijoConstantesFunciones.getClassesRelationshipsOfMovimientoActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
