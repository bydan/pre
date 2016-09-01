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
import com.bydan.erp.inventario.util.NovedadSeguimientoConstantesFunciones;
import com.bydan.erp.inventario.util.NovedadSeguimientoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.NovedadSeguimientoParameterGeneral;
import com.bydan.erp.inventario.business.entity.NovedadSeguimiento;
import com.bydan.erp.inventario.business.logic.NovedadSeguimientoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class NovedadSeguimientoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NovedadSeguimientoLogic.class);
	
	protected NovedadSeguimientoDataAccess novedadseguimientoDataAccess; 	
	protected NovedadSeguimiento novedadseguimiento;
	protected List<NovedadSeguimiento> novedadseguimientos;
	protected Object novedadseguimientoObject;	
	protected List<Object> novedadseguimientosObject;
	
	public static ClassValidator<NovedadSeguimiento> novedadseguimientoValidator = new ClassValidator<NovedadSeguimiento>(NovedadSeguimiento.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NovedadSeguimientoLogicAdditional novedadseguimientoLogicAdditional=null;
	
	public NovedadSeguimientoLogicAdditional getNovedadSeguimientoLogicAdditional() {
		return this.novedadseguimientoLogicAdditional;
	}
	
	public void setNovedadSeguimientoLogicAdditional(NovedadSeguimientoLogicAdditional novedadseguimientoLogicAdditional) {
		try {
			this.novedadseguimientoLogicAdditional=novedadseguimientoLogicAdditional;
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
	
	
	
	
	public  NovedadSeguimientoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.novedadseguimientoDataAccess = new NovedadSeguimientoDataAccess();
			
			this.novedadseguimientos= new ArrayList<NovedadSeguimiento>();
			this.novedadseguimiento= new NovedadSeguimiento();
			
			this.novedadseguimientoObject=new Object();
			this.novedadseguimientosObject=new ArrayList<Object>();
				
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
			
			this.novedadseguimientoDataAccess.setConnexionType(this.connexionType);
			this.novedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NovedadSeguimientoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.novedadseguimientoDataAccess = new NovedadSeguimientoDataAccess();
			this.novedadseguimientos= new ArrayList<NovedadSeguimiento>();
			this.novedadseguimiento= new NovedadSeguimiento();
			this.novedadseguimientoObject=new Object();
			this.novedadseguimientosObject=new ArrayList<Object>();
			
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
			
			this.novedadseguimientoDataAccess.setConnexionType(this.connexionType);
			this.novedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NovedadSeguimiento getNovedadSeguimiento() throws Exception {	
		NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToGet(novedadseguimiento,this.datosCliente,this.arrDatoGeneral);
		NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToGet(novedadseguimiento,this.arrDatoGeneral);
		
		return novedadseguimiento;
	}
		
	public void setNovedadSeguimiento(NovedadSeguimiento newNovedadSeguimiento) {
		this.novedadseguimiento = newNovedadSeguimiento;
	}
	
	public NovedadSeguimientoDataAccess getNovedadSeguimientoDataAccess() {
		return novedadseguimientoDataAccess;
	}
	
	public void setNovedadSeguimientoDataAccess(NovedadSeguimientoDataAccess newnovedadseguimientoDataAccess) {
		this.novedadseguimientoDataAccess = newnovedadseguimientoDataAccess;
	}
	
	public List<NovedadSeguimiento> getNovedadSeguimientos() throws Exception {		
		this.quitarNovedadSeguimientosNulos();
		
		NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToGets(novedadseguimientos,this.datosCliente,this.arrDatoGeneral);
		
		for (NovedadSeguimiento novedadseguimientoLocal: novedadseguimientos ) {
			NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToGet(novedadseguimientoLocal,this.arrDatoGeneral);
		}
		
		return novedadseguimientos;
	}
	
	public void setNovedadSeguimientos(List<NovedadSeguimiento> newNovedadSeguimientos) {
		this.novedadseguimientos = newNovedadSeguimientos;
	}
	
	public Object getNovedadSeguimientoObject() {	
		this.novedadseguimientoObject=this.novedadseguimientoDataAccess.getEntityObject();
		return this.novedadseguimientoObject;
	}
		
	public void setNovedadSeguimientoObject(Object newNovedadSeguimientoObject) {
		this.novedadseguimientoObject = newNovedadSeguimientoObject;
	}
	
	public List<Object> getNovedadSeguimientosObject() {		
		this.novedadseguimientosObject=this.novedadseguimientoDataAccess.getEntitiesObject();
		return this.novedadseguimientosObject;
	}
		
	public void setNovedadSeguimientosObject(List<Object> newNovedadSeguimientosObject) {
		this.novedadseguimientosObject = newNovedadSeguimientosObject;
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
		
		if(this.novedadseguimientoDataAccess!=null) {
			this.novedadseguimientoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			novedadseguimientoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			novedadseguimientoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		novedadseguimiento = new  NovedadSeguimiento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			novedadseguimiento=novedadseguimientoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimiento);
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
		novedadseguimiento = new  NovedadSeguimiento();
		  		  
        try {
			
			novedadseguimiento=novedadseguimientoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		novedadseguimiento = new  NovedadSeguimiento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			novedadseguimiento=novedadseguimientoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimiento);
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
		novedadseguimiento = new  NovedadSeguimiento();
		  		  
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
		novedadseguimiento = new  NovedadSeguimiento();
		  		  
        try {
			
			novedadseguimiento=novedadseguimientoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.novedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		novedadseguimiento = new  NovedadSeguimiento();
		  		  
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
		novedadseguimiento = new  NovedadSeguimiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =novedadseguimientoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadseguimiento = new  NovedadSeguimiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=novedadseguimientoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		novedadseguimiento = new  NovedadSeguimiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =novedadseguimientoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadseguimiento = new  NovedadSeguimiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=novedadseguimientoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		novedadseguimiento = new  NovedadSeguimiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =novedadseguimientoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		novedadseguimiento = new  NovedadSeguimiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=novedadseguimientoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
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
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
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
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
        try {			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
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
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
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
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
        try {
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
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
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
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
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		novedadseguimiento = new  NovedadSeguimiento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimiento=novedadseguimientoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimiento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimiento);
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
		novedadseguimiento = new  NovedadSeguimiento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimiento=novedadseguimientoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimiento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
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
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		  		  
        try {
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNovedadSeguimientosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getTodosNovedadSeguimientosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
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
	
	public  void  getTodosNovedadSeguimientos(String sFinalQuery,Pagination pagination)throws Exception {
		novedadseguimientos = new  ArrayList<NovedadSeguimiento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNovedadSeguimiento(novedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNovedadSeguimiento(NovedadSeguimiento novedadseguimiento) throws Exception {
		Boolean estaValidado=false;
		
		if(novedadseguimiento.getIsNew() || novedadseguimiento.getIsChanged()) { 
			this.invalidValues = novedadseguimientoValidator.getInvalidValues(novedadseguimiento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(novedadseguimiento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNovedadSeguimiento(List<NovedadSeguimiento> NovedadSeguimientos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NovedadSeguimiento novedadseguimientoLocal:novedadseguimientos) {				
			estaValidadoObjeto=this.validarGuardarNovedadSeguimiento(novedadseguimientoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNovedadSeguimiento(List<NovedadSeguimiento> NovedadSeguimientos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNovedadSeguimiento(novedadseguimientos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNovedadSeguimiento(NovedadSeguimiento NovedadSeguimiento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNovedadSeguimiento(novedadseguimiento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NovedadSeguimiento novedadseguimiento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+novedadseguimiento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NovedadSeguimientoConstantesFunciones.getNovedadSeguimientoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"novedadseguimiento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NovedadSeguimientoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NovedadSeguimientoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNovedadSeguimientoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-saveNovedadSeguimientoWithConnection");connexion.begin();			
			
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSave(this.novedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToSave(this.novedadseguimiento,this.arrDatoGeneral);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.novedadseguimiento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNovedadSeguimiento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNovedadSeguimiento(this.novedadseguimiento)) {
				NovedadSeguimientoDataAccess.save(this.novedadseguimiento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.novedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSaveAfter(this.novedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNovedadSeguimiento();
			
			connexion.commit();			
			
			if(this.novedadseguimiento.getIsDeleted()) {
				this.novedadseguimiento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNovedadSeguimiento()throws Exception {	
		try {	
			
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSave(this.novedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToSave(this.novedadseguimiento,this.arrDatoGeneral);
			
			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.novedadseguimiento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNovedadSeguimiento(this.novedadseguimiento)) {			
				NovedadSeguimientoDataAccess.save(this.novedadseguimiento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.novedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSaveAfter(this.novedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.novedadseguimiento.getIsDeleted()) {
				this.novedadseguimiento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNovedadSeguimientosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-saveNovedadSeguimientosWithConnection");connexion.begin();			
			
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSaves(novedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNovedadSeguimientos();
			
			Boolean validadoTodosNovedadSeguimiento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NovedadSeguimiento novedadseguimientoLocal:novedadseguimientos) {		
				if(novedadseguimientoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToSave(novedadseguimientoLocal,this.arrDatoGeneral);
	        	
				NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),novedadseguimientoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNovedadSeguimiento(novedadseguimientoLocal)) {
					NovedadSeguimientoDataAccess.save(novedadseguimientoLocal, connexion);				
				} else {
					validadoTodosNovedadSeguimiento=false;
				}
			}
			
			if(!validadoTodosNovedadSeguimiento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSavesAfter(novedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNovedadSeguimientos();
			
			connexion.commit();		
			
			this.quitarNovedadSeguimientosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNovedadSeguimientos()throws Exception {				
		 try {	
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSaves(novedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNovedadSeguimiento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NovedadSeguimiento novedadseguimientoLocal:novedadseguimientos) {				
				if(novedadseguimientoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToSave(novedadseguimientoLocal,this.arrDatoGeneral);
	        	
				NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),novedadseguimientoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNovedadSeguimiento(novedadseguimientoLocal)) {				
					NovedadSeguimientoDataAccess.save(novedadseguimientoLocal, connexion);				
				} else {
					validadoTodosNovedadSeguimiento=false;
				}
			}
			
			if(!validadoTodosNovedadSeguimiento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NovedadSeguimientoLogicAdditional.checkNovedadSeguimientoToSavesAfter(novedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNovedadSeguimientosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NovedadSeguimientoParameterReturnGeneral procesarAccionNovedadSeguimientos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NovedadSeguimiento> novedadseguimientos,NovedadSeguimientoParameterReturnGeneral novedadseguimientoParameterGeneral)throws Exception {
		 try {	
			NovedadSeguimientoParameterReturnGeneral novedadseguimientoReturnGeneral=new NovedadSeguimientoParameterReturnGeneral();
	
			NovedadSeguimientoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,novedadseguimientos,novedadseguimientoParameterGeneral,novedadseguimientoReturnGeneral);
			
			return novedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NovedadSeguimientoParameterReturnGeneral procesarAccionNovedadSeguimientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NovedadSeguimiento> novedadseguimientos,NovedadSeguimientoParameterReturnGeneral novedadseguimientoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-procesarAccionNovedadSeguimientosWithConnection");connexion.begin();			
			
			NovedadSeguimientoParameterReturnGeneral novedadseguimientoReturnGeneral=new NovedadSeguimientoParameterReturnGeneral();
	
			NovedadSeguimientoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,novedadseguimientos,novedadseguimientoParameterGeneral,novedadseguimientoReturnGeneral);
			
			this.connexion.commit();
			
			return novedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NovedadSeguimientoParameterReturnGeneral procesarEventosNovedadSeguimientos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NovedadSeguimiento> novedadseguimientos,NovedadSeguimiento novedadseguimiento,NovedadSeguimientoParameterReturnGeneral novedadseguimientoParameterGeneral,Boolean isEsNuevoNovedadSeguimiento,ArrayList<Classe> clases)throws Exception {
		 try {	
			NovedadSeguimientoParameterReturnGeneral novedadseguimientoReturnGeneral=new NovedadSeguimientoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				novedadseguimientoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NovedadSeguimientoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,novedadseguimientos,novedadseguimiento,novedadseguimientoParameterGeneral,novedadseguimientoReturnGeneral,isEsNuevoNovedadSeguimiento,clases);
			
			return novedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NovedadSeguimientoParameterReturnGeneral procesarEventosNovedadSeguimientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NovedadSeguimiento> novedadseguimientos,NovedadSeguimiento novedadseguimiento,NovedadSeguimientoParameterReturnGeneral novedadseguimientoParameterGeneral,Boolean isEsNuevoNovedadSeguimiento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-procesarEventosNovedadSeguimientosWithConnection");connexion.begin();			
			
			NovedadSeguimientoParameterReturnGeneral novedadseguimientoReturnGeneral=new NovedadSeguimientoParameterReturnGeneral();
	
			novedadseguimientoReturnGeneral.setNovedadSeguimiento(novedadseguimiento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				novedadseguimientoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NovedadSeguimientoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,novedadseguimientos,novedadseguimiento,novedadseguimientoParameterGeneral,novedadseguimientoReturnGeneral,isEsNuevoNovedadSeguimiento,clases);
			
			this.connexion.commit();
			
			return novedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NovedadSeguimientoParameterReturnGeneral procesarImportacionNovedadSeguimientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NovedadSeguimientoParameterReturnGeneral novedadseguimientoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-procesarImportacionNovedadSeguimientosWithConnection");connexion.begin();			
			
			NovedadSeguimientoParameterReturnGeneral novedadseguimientoReturnGeneral=new NovedadSeguimientoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.novedadseguimientos=new ArrayList<NovedadSeguimiento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.novedadseguimiento=new NovedadSeguimiento();
				
				
				if(conColumnasBase) {this.novedadseguimiento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.novedadseguimiento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.novedadseguimiento.setnumero_comprobante(arrColumnas[iColumn++]);
				this.novedadseguimiento.setfecha_novedad(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.novedadseguimiento.setfecha_seguimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.novedadseguimiento.setdescripcion(arrColumnas[iColumn++]);
				
				this.novedadseguimientos.add(this.novedadseguimiento);
			}
			
			this.saveNovedadSeguimientos();
			
			this.connexion.commit();
			
			novedadseguimientoReturnGeneral.setConRetornoEstaProcesado(true);
			novedadseguimientoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return novedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNovedadSeguimientosEliminados() throws Exception {				
		
		List<NovedadSeguimiento> novedadseguimientosAux= new ArrayList<NovedadSeguimiento>();
		
		for(NovedadSeguimiento novedadseguimiento:novedadseguimientos) {
			if(!novedadseguimiento.getIsDeleted()) {
				novedadseguimientosAux.add(novedadseguimiento);
			}
		}
		
		novedadseguimientos=novedadseguimientosAux;
	}
	
	public void quitarNovedadSeguimientosNulos() throws Exception {				
		
		List<NovedadSeguimiento> novedadseguimientosAux= new ArrayList<NovedadSeguimiento>();
		
		for(NovedadSeguimiento novedadseguimiento : this.novedadseguimientos) {
			if(novedadseguimiento==null) {
				novedadseguimientosAux.add(novedadseguimiento);
			}
		}
		
		//this.novedadseguimientos=novedadseguimientosAux;
		
		this.novedadseguimientos.removeAll(novedadseguimientosAux);
	}
	
	public void getSetVersionRowNovedadSeguimientoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(novedadseguimiento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((novedadseguimiento.getIsDeleted() || (novedadseguimiento.getIsChanged()&&!novedadseguimiento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=novedadseguimientoDataAccess.getSetVersionRowNovedadSeguimiento(connexion,novedadseguimiento.getId());
				
				if(!novedadseguimiento.getVersionRow().equals(timestamp)) {	
					novedadseguimiento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				novedadseguimiento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNovedadSeguimiento()throws Exception {	
		
		if(novedadseguimiento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((novedadseguimiento.getIsDeleted() || (novedadseguimiento.getIsChanged()&&!novedadseguimiento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=novedadseguimientoDataAccess.getSetVersionRowNovedadSeguimiento(connexion,novedadseguimiento.getId());
			
			try {							
				if(!novedadseguimiento.getVersionRow().equals(timestamp)) {	
					novedadseguimiento.setVersionRow(timestamp);
				}
				
				novedadseguimiento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNovedadSeguimientosWithConnection()throws Exception {	
		if(novedadseguimientos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NovedadSeguimiento novedadseguimientoAux:novedadseguimientos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(novedadseguimientoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(novedadseguimientoAux.getIsDeleted() || (novedadseguimientoAux.getIsChanged()&&!novedadseguimientoAux.getIsNew())) {
						
						timestamp=novedadseguimientoDataAccess.getSetVersionRowNovedadSeguimiento(connexion,novedadseguimientoAux.getId());
						
						if(!novedadseguimiento.getVersionRow().equals(timestamp)) {	
							novedadseguimientoAux.setVersionRow(timestamp);
						}
								
						novedadseguimientoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNovedadSeguimientos()throws Exception {	
		if(novedadseguimientos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NovedadSeguimiento novedadseguimientoAux:novedadseguimientos) {
					if(novedadseguimientoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(novedadseguimientoAux.getIsDeleted() || (novedadseguimientoAux.getIsChanged()&&!novedadseguimientoAux.getIsNew())) {
						
						timestamp=novedadseguimientoDataAccess.getSetVersionRowNovedadSeguimiento(connexion,novedadseguimientoAux.getId());
						
						if(!novedadseguimientoAux.getVersionRow().equals(timestamp)) {	
							novedadseguimientoAux.setVersionRow(timestamp);
						}
						
													
						novedadseguimientoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NovedadSeguimientoParameterReturnGeneral cargarCombosLoteForeignKeyNovedadSeguimientoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleMovimientoInventario,String finalQueryGlobalNovedadProducto,String finalQueryGlobalEstadoNovedadSeguimiento) throws Exception {
		NovedadSeguimientoParameterReturnGeneral  novedadseguimientoReturnGeneral =new NovedadSeguimientoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-cargarCombosLoteForeignKeyNovedadSeguimientoWithConnection");connexion.begin();
			
			novedadseguimientoReturnGeneral =new NovedadSeguimientoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			novedadseguimientoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			novedadseguimientoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleMovimientoInventario> detallemovimientoinventariosForeignKey=new ArrayList<DetalleMovimientoInventario>();
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
			detallemovimientoinventarioLogic.setConnexion(this.connexion);
			detallemovimientoinventarioLogic.getDetalleMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleMovimientoInventario.equals("NONE")) {
				detallemovimientoinventarioLogic.getTodosDetalleMovimientoInventarios(finalQueryGlobalDetalleMovimientoInventario,new Pagination());
				detallemovimientoinventariosForeignKey=detallemovimientoinventarioLogic.getDetalleMovimientoInventarios();
			}

			novedadseguimientoReturnGeneral.setdetallemovimientoinventariosForeignKey(detallemovimientoinventariosForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			novedadseguimientoReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<EstadoNovedadSeguimiento> estadonovedadseguimientosForeignKey=new ArrayList<EstadoNovedadSeguimiento>();
			EstadoNovedadSeguimientoLogic estadonovedadseguimientoLogic=new EstadoNovedadSeguimientoLogic();
			estadonovedadseguimientoLogic.setConnexion(this.connexion);
			estadonovedadseguimientoLogic.getEstadoNovedadSeguimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNovedadSeguimiento.equals("NONE")) {
				estadonovedadseguimientoLogic.getTodosEstadoNovedadSeguimientos(finalQueryGlobalEstadoNovedadSeguimiento,new Pagination());
				estadonovedadseguimientosForeignKey=estadonovedadseguimientoLogic.getEstadoNovedadSeguimientos();
			}

			novedadseguimientoReturnGeneral.setestadonovedadseguimientosForeignKey(estadonovedadseguimientosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return novedadseguimientoReturnGeneral;
	}
	
	public NovedadSeguimientoParameterReturnGeneral cargarCombosLoteForeignKeyNovedadSeguimiento(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleMovimientoInventario,String finalQueryGlobalNovedadProducto,String finalQueryGlobalEstadoNovedadSeguimiento) throws Exception {
		NovedadSeguimientoParameterReturnGeneral  novedadseguimientoReturnGeneral =new NovedadSeguimientoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			novedadseguimientoReturnGeneral =new NovedadSeguimientoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			novedadseguimientoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			novedadseguimientoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleMovimientoInventario> detallemovimientoinventariosForeignKey=new ArrayList<DetalleMovimientoInventario>();
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
			detallemovimientoinventarioLogic.setConnexion(this.connexion);
			detallemovimientoinventarioLogic.getDetalleMovimientoInventarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleMovimientoInventario.equals("NONE")) {
				detallemovimientoinventarioLogic.getTodosDetalleMovimientoInventarios(finalQueryGlobalDetalleMovimientoInventario,new Pagination());
				detallemovimientoinventariosForeignKey=detallemovimientoinventarioLogic.getDetalleMovimientoInventarios();
			}

			novedadseguimientoReturnGeneral.setdetallemovimientoinventariosForeignKey(detallemovimientoinventariosForeignKey);


			List<NovedadProducto> novedadproductosForeignKey=new ArrayList<NovedadProducto>();
			NovedadProductoLogic novedadproductoLogic=new NovedadProductoLogic();
			novedadproductoLogic.setConnexion(this.connexion);
			novedadproductoLogic.getNovedadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNovedadProducto.equals("NONE")) {
				novedadproductoLogic.getTodosNovedadProductos(finalQueryGlobalNovedadProducto,new Pagination());
				novedadproductosForeignKey=novedadproductoLogic.getNovedadProductos();
			}

			novedadseguimientoReturnGeneral.setnovedadproductosForeignKey(novedadproductosForeignKey);


			List<EstadoNovedadSeguimiento> estadonovedadseguimientosForeignKey=new ArrayList<EstadoNovedadSeguimiento>();
			EstadoNovedadSeguimientoLogic estadonovedadseguimientoLogic=new EstadoNovedadSeguimientoLogic();
			estadonovedadseguimientoLogic.setConnexion(this.connexion);
			estadonovedadseguimientoLogic.getEstadoNovedadSeguimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNovedadSeguimiento.equals("NONE")) {
				estadonovedadseguimientoLogic.getTodosEstadoNovedadSeguimientos(finalQueryGlobalEstadoNovedadSeguimiento,new Pagination());
				estadonovedadseguimientosForeignKey=estadonovedadseguimientoLogic.getEstadoNovedadSeguimientos();
			}

			novedadseguimientoReturnGeneral.setestadonovedadseguimientosForeignKey(estadonovedadseguimientosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return novedadseguimientoReturnGeneral;
	}
	
	
	public void deepLoad(NovedadSeguimiento novedadseguimiento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToGet(novedadseguimiento,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		novedadseguimiento.setEmpresa(novedadseguimientoDataAccess.getEmpresa(connexion,novedadseguimiento));
		novedadseguimiento.setSucursal(novedadseguimientoDataAccess.getSucursal(connexion,novedadseguimiento));
		novedadseguimiento.setDetalleMovimientoInventario(novedadseguimientoDataAccess.getDetalleMovimientoInventario(connexion,novedadseguimiento));
		novedadseguimiento.setNovedadProducto(novedadseguimientoDataAccess.getNovedadProducto(connexion,novedadseguimiento));
		novedadseguimiento.setEstadoNovedadSeguimiento(novedadseguimientoDataAccess.getEstadoNovedadSeguimiento(connexion,novedadseguimiento));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				novedadseguimiento.setEmpresa(novedadseguimientoDataAccess.getEmpresa(connexion,novedadseguimiento));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				novedadseguimiento.setSucursal(novedadseguimientoDataAccess.getSucursal(connexion,novedadseguimiento));
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)) {
				novedadseguimiento.setDetalleMovimientoInventario(novedadseguimientoDataAccess.getDetalleMovimientoInventario(connexion,novedadseguimiento));
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				novedadseguimiento.setNovedadProducto(novedadseguimientoDataAccess.getNovedadProducto(connexion,novedadseguimiento));
				continue;
			}

			if(clas.clas.equals(EstadoNovedadSeguimiento.class)) {
				novedadseguimiento.setEstadoNovedadSeguimiento(novedadseguimientoDataAccess.getEstadoNovedadSeguimiento(connexion,novedadseguimiento));
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
			novedadseguimiento.setEmpresa(novedadseguimientoDataAccess.getEmpresa(connexion,novedadseguimiento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setSucursal(novedadseguimientoDataAccess.getSucursal(connexion,novedadseguimiento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setDetalleMovimientoInventario(novedadseguimientoDataAccess.getDetalleMovimientoInventario(connexion,novedadseguimiento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setNovedadProducto(novedadseguimientoDataAccess.getNovedadProducto(connexion,novedadseguimiento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNovedadSeguimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setEstadoNovedadSeguimiento(novedadseguimientoDataAccess.getEstadoNovedadSeguimiento(connexion,novedadseguimiento));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		novedadseguimiento.setEmpresa(novedadseguimientoDataAccess.getEmpresa(connexion,novedadseguimiento));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(novedadseguimiento.getEmpresa(),isDeep,deepLoadType,clases);
				
		novedadseguimiento.setSucursal(novedadseguimientoDataAccess.getSucursal(connexion,novedadseguimiento));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(novedadseguimiento.getSucursal(),isDeep,deepLoadType,clases);
				
		novedadseguimiento.setDetalleMovimientoInventario(novedadseguimientoDataAccess.getDetalleMovimientoInventario(connexion,novedadseguimiento));
		DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
		detallemovimientoinventarioLogic.deepLoad(novedadseguimiento.getDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				
		novedadseguimiento.setNovedadProducto(novedadseguimientoDataAccess.getNovedadProducto(connexion,novedadseguimiento));
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(novedadseguimiento.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		novedadseguimiento.setEstadoNovedadSeguimiento(novedadseguimientoDataAccess.getEstadoNovedadSeguimiento(connexion,novedadseguimiento));
		EstadoNovedadSeguimientoLogic estadonovedadseguimientoLogic= new EstadoNovedadSeguimientoLogic(connexion);
		estadonovedadseguimientoLogic.deepLoad(novedadseguimiento.getEstadoNovedadSeguimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				novedadseguimiento.setEmpresa(novedadseguimientoDataAccess.getEmpresa(connexion,novedadseguimiento));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(novedadseguimiento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				novedadseguimiento.setSucursal(novedadseguimientoDataAccess.getSucursal(connexion,novedadseguimiento));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(novedadseguimiento.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)) {
				novedadseguimiento.setDetalleMovimientoInventario(novedadseguimientoDataAccess.getDetalleMovimientoInventario(connexion,novedadseguimiento));
				DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
				detallemovimientoinventarioLogic.deepLoad(novedadseguimiento.getDetalleMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				novedadseguimiento.setNovedadProducto(novedadseguimientoDataAccess.getNovedadProducto(connexion,novedadseguimiento));
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepLoad(novedadseguimiento.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNovedadSeguimiento.class)) {
				novedadseguimiento.setEstadoNovedadSeguimiento(novedadseguimientoDataAccess.getEstadoNovedadSeguimiento(connexion,novedadseguimiento));
				EstadoNovedadSeguimientoLogic estadonovedadseguimientoLogic= new EstadoNovedadSeguimientoLogic(connexion);
				estadonovedadseguimientoLogic.deepLoad(novedadseguimiento.getEstadoNovedadSeguimiento(),isDeep,deepLoadType,clases);				
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
			novedadseguimiento.setEmpresa(novedadseguimientoDataAccess.getEmpresa(connexion,novedadseguimiento));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(novedadseguimiento.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setSucursal(novedadseguimientoDataAccess.getSucursal(connexion,novedadseguimiento));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(novedadseguimiento.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMovimientoInventario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setDetalleMovimientoInventario(novedadseguimientoDataAccess.getDetalleMovimientoInventario(connexion,novedadseguimiento));
			DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
			detallemovimientoinventarioLogic.deepLoad(novedadseguimiento.getDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NovedadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setNovedadProducto(novedadseguimientoDataAccess.getNovedadProducto(connexion,novedadseguimiento));
			NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
			novedadproductoLogic.deepLoad(novedadseguimiento.getNovedadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNovedadSeguimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			novedadseguimiento.setEstadoNovedadSeguimiento(novedadseguimientoDataAccess.getEstadoNovedadSeguimiento(connexion,novedadseguimiento));
			EstadoNovedadSeguimientoLogic estadonovedadseguimientoLogic= new EstadoNovedadSeguimientoLogic(connexion);
			estadonovedadseguimientoLogic.deepLoad(novedadseguimiento.getEstadoNovedadSeguimiento(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NovedadSeguimiento novedadseguimiento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NovedadSeguimientoLogicAdditional.updateNovedadSeguimientoToSave(novedadseguimiento,this.arrDatoGeneral);
			
NovedadSeguimientoDataAccess.save(novedadseguimiento, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(novedadseguimiento.getEmpresa(),connexion);

		SucursalDataAccess.save(novedadseguimiento.getSucursal(),connexion);

		DetalleMovimientoInventarioDataAccess.save(novedadseguimiento.getDetalleMovimientoInventario(),connexion);

		NovedadProductoDataAccess.save(novedadseguimiento.getNovedadProducto(),connexion);

		EstadoNovedadSeguimientoDataAccess.save(novedadseguimiento.getEstadoNovedadSeguimiento(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(novedadseguimiento.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(novedadseguimiento.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)) {
				DetalleMovimientoInventarioDataAccess.save(novedadseguimiento.getDetalleMovimientoInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(novedadseguimiento.getNovedadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoNovedadSeguimiento.class)) {
				EstadoNovedadSeguimientoDataAccess.save(novedadseguimiento.getEstadoNovedadSeguimiento(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(novedadseguimiento.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(novedadseguimiento.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(novedadseguimiento.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(novedadseguimiento.getSucursal(),isDeep,deepLoadType,clases);
				

		DetalleMovimientoInventarioDataAccess.save(novedadseguimiento.getDetalleMovimientoInventario(),connexion);
		DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
		detallemovimientoinventarioLogic.deepLoad(novedadseguimiento.getDetalleMovimientoInventario(),isDeep,deepLoadType,clases);
				

		NovedadProductoDataAccess.save(novedadseguimiento.getNovedadProducto(),connexion);
		NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
		novedadproductoLogic.deepLoad(novedadseguimiento.getNovedadProducto(),isDeep,deepLoadType,clases);
				

		EstadoNovedadSeguimientoDataAccess.save(novedadseguimiento.getEstadoNovedadSeguimiento(),connexion);
		EstadoNovedadSeguimientoLogic estadonovedadseguimientoLogic= new EstadoNovedadSeguimientoLogic(connexion);
		estadonovedadseguimientoLogic.deepLoad(novedadseguimiento.getEstadoNovedadSeguimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(novedadseguimiento.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(novedadseguimiento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(novedadseguimiento.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(novedadseguimiento.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleMovimientoInventario.class)) {
				DetalleMovimientoInventarioDataAccess.save(novedadseguimiento.getDetalleMovimientoInventario(),connexion);
				DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic= new DetalleMovimientoInventarioLogic(connexion);
				detallemovimientoinventarioLogic.deepSave(novedadseguimiento.getDetalleMovimientoInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NovedadProducto.class)) {
				NovedadProductoDataAccess.save(novedadseguimiento.getNovedadProducto(),connexion);
				NovedadProductoLogic novedadproductoLogic= new NovedadProductoLogic(connexion);
				novedadproductoLogic.deepSave(novedadseguimiento.getNovedadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNovedadSeguimiento.class)) {
				EstadoNovedadSeguimientoDataAccess.save(novedadseguimiento.getEstadoNovedadSeguimiento(),connexion);
				EstadoNovedadSeguimientoLogic estadonovedadseguimientoLogic= new EstadoNovedadSeguimientoLogic(connexion);
				estadonovedadseguimientoLogic.deepSave(novedadseguimiento.getEstadoNovedadSeguimiento(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(NovedadSeguimiento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(novedadseguimiento);
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
			this.deepLoad(this.novedadseguimiento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NovedadSeguimiento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(novedadseguimientos!=null) {
				for(NovedadSeguimiento novedadseguimiento:novedadseguimientos) {
					this.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(novedadseguimientos);
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
			if(novedadseguimientos!=null) {
				for(NovedadSeguimiento novedadseguimiento:novedadseguimientos) {
					this.deepLoad(novedadseguimiento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(novedadseguimientos);
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
			this.getNewConnexionToDeep(NovedadSeguimiento.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(novedadseguimiento,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NovedadSeguimiento.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(novedadseguimientos!=null) {
				for(NovedadSeguimiento novedadseguimiento:novedadseguimientos) {
					this.deepSave(novedadseguimiento,isDeep,deepLoadType,clases);
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
			if(novedadseguimientos!=null) {
				for(NovedadSeguimiento novedadseguimiento:novedadseguimientos) {
					this.deepSave(novedadseguimiento,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNovedadSeguimientosFK_IdDetalleMovimientoInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_movimiento_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_movimiento_inventario,NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleMovimientoInventario);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadSeguimientosFK_IdDetalleMovimientoInventario(String sFinalQuery,Pagination pagination,Long id_detalle_movimiento_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleMovimientoInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleMovimientoInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_movimiento_inventario,NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleMovimientoInventario);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleMovimientoInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadSeguimientosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NovedadSeguimientoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadSeguimientosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NovedadSeguimientoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadSeguimientosFK_IdEstadoNovedadSeguimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_novedad_seguimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNovedadSeguimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNovedadSeguimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_novedad_seguimiento,NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNovedadSeguimiento);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNovedadSeguimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadSeguimientosFK_IdEstadoNovedadSeguimiento(String sFinalQuery,Pagination pagination,Long id_estado_novedad_seguimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNovedadSeguimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNovedadSeguimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_novedad_seguimiento,NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNovedadSeguimiento);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNovedadSeguimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadSeguimientosFK_IdNovedadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadSeguimientosFK_IdNovedadProducto(String sFinalQuery,Pagination pagination,Long id_novedad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNovedadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNovedadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_novedad_producto,NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNovedadProducto);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNovedadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNovedadSeguimientosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NovedadSeguimiento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NovedadSeguimientoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNovedadSeguimientosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NovedadSeguimientoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesNovedadSeguimiento(this.novedadseguimientos);
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
			if(NovedadSeguimientoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadSeguimientoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NovedadSeguimiento novedadseguimiento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NovedadSeguimientoConstantesFunciones.ISCONAUDITORIA) {
				if(novedadseguimiento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadSeguimientoDataAccess.TABLENAME, novedadseguimiento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NovedadSeguimientoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NovedadSeguimientoLogic.registrarAuditoriaDetallesNovedadSeguimiento(connexion,novedadseguimiento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(novedadseguimiento.getIsDeleted()) {
					/*if(!novedadseguimiento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NovedadSeguimientoDataAccess.TABLENAME, novedadseguimiento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NovedadSeguimientoLogic.registrarAuditoriaDetallesNovedadSeguimiento(connexion,novedadseguimiento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadSeguimientoDataAccess.TABLENAME, novedadseguimiento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(novedadseguimiento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NovedadSeguimientoDataAccess.TABLENAME, novedadseguimiento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NovedadSeguimientoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NovedadSeguimientoLogic.registrarAuditoriaDetallesNovedadSeguimiento(connexion,novedadseguimiento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNovedadSeguimiento(Connexion connexion,NovedadSeguimiento novedadseguimiento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getid_empresa().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getid_empresa()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getid_empresa().toString();
				}
				if(novedadseguimiento.getid_empresa()!=null)
				{
					strValorNuevo=novedadseguimiento.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getid_sucursal().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getid_sucursal()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getid_sucursal().toString();
				}
				if(novedadseguimiento.getid_sucursal()!=null)
				{
					strValorNuevo=novedadseguimiento.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getid_detalle_movimiento_inventario().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getid_detalle_movimiento_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getid_detalle_movimiento_inventario()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getid_detalle_movimiento_inventario().toString();
				}
				if(novedadseguimiento.getid_detalle_movimiento_inventario()!=null)
				{
					strValorNuevo=novedadseguimiento.getid_detalle_movimiento_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getid_novedad_producto().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getid_novedad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getid_novedad_producto()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getid_novedad_producto().toString();
				}
				if(novedadseguimiento.getid_novedad_producto()!=null)
				{
					strValorNuevo=novedadseguimiento.getid_novedad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getnumero_comprobante().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getnumero_comprobante();
				}
				if(novedadseguimiento.getnumero_comprobante()!=null)
				{
					strValorNuevo=novedadseguimiento.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getfecha_novedad().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getfecha_novedad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getfecha_novedad()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getfecha_novedad().toString();
				}
				if(novedadseguimiento.getfecha_novedad()!=null)
				{
					strValorNuevo=novedadseguimiento.getfecha_novedad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.FECHANOVEDAD,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getfecha_seguimiento().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getfecha_seguimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getfecha_seguimiento()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getfecha_seguimiento().toString();
				}
				if(novedadseguimiento.getfecha_seguimiento()!=null)
				{
					strValorNuevo=novedadseguimiento.getfecha_seguimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getdescripcion().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getdescripcion()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getdescripcion();
				}
				if(novedadseguimiento.getdescripcion()!=null)
				{
					strValorNuevo=novedadseguimiento.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(novedadseguimiento.getIsNew()||!novedadseguimiento.getid_estado_novedad_seguimiento().equals(novedadseguimiento.getNovedadSeguimientoOriginal().getid_estado_novedad_seguimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(novedadseguimiento.getNovedadSeguimientoOriginal().getid_estado_novedad_seguimiento()!=null)
				{
					strValorActual=novedadseguimiento.getNovedadSeguimientoOriginal().getid_estado_novedad_seguimiento().toString();
				}
				if(novedadseguimiento.getid_estado_novedad_seguimiento()!=null)
				{
					strValorNuevo=novedadseguimiento.getid_estado_novedad_seguimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNovedadSeguimientoRelacionesWithConnection(NovedadSeguimiento novedadseguimiento) throws Exception {

		if(!novedadseguimiento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNovedadSeguimientoRelacionesBase(novedadseguimiento,true);
		}
	}

	public void saveNovedadSeguimientoRelaciones(NovedadSeguimiento novedadseguimiento)throws Exception {

		if(!novedadseguimiento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNovedadSeguimientoRelacionesBase(novedadseguimiento,false);
		}
	}

	public void saveNovedadSeguimientoRelacionesBase(NovedadSeguimiento novedadseguimiento,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NovedadSeguimiento-saveRelacionesWithConnection");}
	

			this.setNovedadSeguimiento(novedadseguimiento);

			if(NovedadSeguimientoLogicAdditional.validarSaveRelaciones(novedadseguimiento,this)) {

				NovedadSeguimientoLogicAdditional.updateRelacionesToSave(novedadseguimiento,this);

				if((novedadseguimiento.getIsNew()||novedadseguimiento.getIsChanged())&&!novedadseguimiento.getIsDeleted()) {
					this.saveNovedadSeguimiento();
					this.saveNovedadSeguimientoRelacionesDetalles();

				} else if(novedadseguimiento.getIsDeleted()) {
					this.saveNovedadSeguimientoRelacionesDetalles();
					this.saveNovedadSeguimiento();
				}

				NovedadSeguimientoLogicAdditional.updateRelacionesToSaveAfter(novedadseguimiento,this);

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
	
	
	private void saveNovedadSeguimientoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NovedadSeguimientoConstantesFunciones.getClassesForeignKeysOfNovedadSeguimiento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NovedadSeguimientoConstantesFunciones.getClassesRelationshipsOfNovedadSeguimiento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
