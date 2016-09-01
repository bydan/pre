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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.ParametroContaDetalleConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroContaDetalleParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroContaDetalleParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ParametroContaDetalle;
import com.bydan.erp.contabilidad.business.logic.ParametroContaDetalleLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ParametroContaDetalleLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroContaDetalleLogic.class);
	
	protected ParametroContaDetalleDataAccess parametrocontadetalleDataAccess; 	
	protected ParametroContaDetalle parametrocontadetalle;
	protected List<ParametroContaDetalle> parametrocontadetalles;
	protected Object parametrocontadetalleObject;	
	protected List<Object> parametrocontadetallesObject;
	
	public static ClassValidator<ParametroContaDetalle> parametrocontadetalleValidator = new ClassValidator<ParametroContaDetalle>(ParametroContaDetalle.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroContaDetalleLogicAdditional parametrocontadetalleLogicAdditional=null;
	
	public ParametroContaDetalleLogicAdditional getParametroContaDetalleLogicAdditional() {
		return this.parametrocontadetalleLogicAdditional;
	}
	
	public void setParametroContaDetalleLogicAdditional(ParametroContaDetalleLogicAdditional parametrocontadetalleLogicAdditional) {
		try {
			this.parametrocontadetalleLogicAdditional=parametrocontadetalleLogicAdditional;
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
	
	
	
	
	public  ParametroContaDetalleLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrocontadetalleDataAccess = new ParametroContaDetalleDataAccess();
			
			this.parametrocontadetalles= new ArrayList<ParametroContaDetalle>();
			this.parametrocontadetalle= new ParametroContaDetalle();
			
			this.parametrocontadetalleObject=new Object();
			this.parametrocontadetallesObject=new ArrayList<Object>();
				
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
			
			this.parametrocontadetalleDataAccess.setConnexionType(this.connexionType);
			this.parametrocontadetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroContaDetalleLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrocontadetalleDataAccess = new ParametroContaDetalleDataAccess();
			this.parametrocontadetalles= new ArrayList<ParametroContaDetalle>();
			this.parametrocontadetalle= new ParametroContaDetalle();
			this.parametrocontadetalleObject=new Object();
			this.parametrocontadetallesObject=new ArrayList<Object>();
			
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
			
			this.parametrocontadetalleDataAccess.setConnexionType(this.connexionType);
			this.parametrocontadetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroContaDetalle getParametroContaDetalle() throws Exception {	
		ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToGet(parametrocontadetalle,this.datosCliente,this.arrDatoGeneral);
		ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToGet(parametrocontadetalle,this.arrDatoGeneral);
		
		return parametrocontadetalle;
	}
		
	public void setParametroContaDetalle(ParametroContaDetalle newParametroContaDetalle) {
		this.parametrocontadetalle = newParametroContaDetalle;
	}
	
	public ParametroContaDetalleDataAccess getParametroContaDetalleDataAccess() {
		return parametrocontadetalleDataAccess;
	}
	
	public void setParametroContaDetalleDataAccess(ParametroContaDetalleDataAccess newparametrocontadetalleDataAccess) {
		this.parametrocontadetalleDataAccess = newparametrocontadetalleDataAccess;
	}
	
	public List<ParametroContaDetalle> getParametroContaDetalles() throws Exception {		
		this.quitarParametroContaDetallesNulos();
		
		ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToGets(parametrocontadetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroContaDetalle parametrocontadetalleLocal: parametrocontadetalles ) {
			ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToGet(parametrocontadetalleLocal,this.arrDatoGeneral);
		}
		
		return parametrocontadetalles;
	}
	
	public void setParametroContaDetalles(List<ParametroContaDetalle> newParametroContaDetalles) {
		this.parametrocontadetalles = newParametroContaDetalles;
	}
	
	public Object getParametroContaDetalleObject() {	
		this.parametrocontadetalleObject=this.parametrocontadetalleDataAccess.getEntityObject();
		return this.parametrocontadetalleObject;
	}
		
	public void setParametroContaDetalleObject(Object newParametroContaDetalleObject) {
		this.parametrocontadetalleObject = newParametroContaDetalleObject;
	}
	
	public List<Object> getParametroContaDetallesObject() {		
		this.parametrocontadetallesObject=this.parametrocontadetalleDataAccess.getEntitiesObject();
		return this.parametrocontadetallesObject;
	}
		
	public void setParametroContaDetallesObject(List<Object> newParametroContaDetallesObject) {
		this.parametrocontadetallesObject = newParametroContaDetallesObject;
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
		
		if(this.parametrocontadetalleDataAccess!=null) {
			this.parametrocontadetalleDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrocontadetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrocontadetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrocontadetalle = new  ParametroContaDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocontadetalle=parametrocontadetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalle);
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
		parametrocontadetalle = new  ParametroContaDetalle();
		  		  
        try {
			
			parametrocontadetalle=parametrocontadetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrocontadetalle = new  ParametroContaDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocontadetalle=parametrocontadetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalle);
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
		parametrocontadetalle = new  ParametroContaDetalle();
		  		  
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
		parametrocontadetalle = new  ParametroContaDetalle();
		  		  
        try {
			
			parametrocontadetalle=parametrocontadetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrocontadetalle = new  ParametroContaDetalle();
		  		  
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
		parametrocontadetalle = new  ParametroContaDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrocontadetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocontadetalle = new  ParametroContaDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrocontadetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocontadetalle = new  ParametroContaDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrocontadetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocontadetalle = new  ParametroContaDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrocontadetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocontadetalle = new  ParametroContaDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrocontadetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocontadetalle = new  ParametroContaDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrocontadetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
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
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
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
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
        try {			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
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
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
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
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
        try {
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
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
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
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
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrocontadetalle = new  ParametroContaDetalle();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalle=parametrocontadetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalle);
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
		parametrocontadetalle = new  ParametroContaDetalle();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalle=parametrocontadetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
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
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		  		  
        try {
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroContaDetallesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getTodosParametroContaDetallesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
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
	
	public  void  getTodosParametroContaDetalles(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocontadetalles = new  ArrayList<ParametroContaDetalle>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroContaDetalle(parametrocontadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroContaDetalle(ParametroContaDetalle parametrocontadetalle) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrocontadetalle.getIsNew() || parametrocontadetalle.getIsChanged()) { 
			this.invalidValues = parametrocontadetalleValidator.getInvalidValues(parametrocontadetalle);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrocontadetalle);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroContaDetalle(List<ParametroContaDetalle> ParametroContaDetalles) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroContaDetalle parametrocontadetalleLocal:parametrocontadetalles) {				
			estaValidadoObjeto=this.validarGuardarParametroContaDetalle(parametrocontadetalleLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroContaDetalle(List<ParametroContaDetalle> ParametroContaDetalles) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroContaDetalle(parametrocontadetalles)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroContaDetalle(ParametroContaDetalle ParametroContaDetalle) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroContaDetalle(parametrocontadetalle)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroContaDetalle parametrocontadetalle) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrocontadetalle.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroContaDetalleConstantesFunciones.getParametroContaDetalleLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrocontadetalle","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroContaDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroContaDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroContaDetalleWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-saveParametroContaDetalleWithConnection");connexion.begin();			
			
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSave(this.parametrocontadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToSave(this.parametrocontadetalle,this.arrDatoGeneral);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocontadetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroContaDetalle();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroContaDetalle(this.parametrocontadetalle)) {
				ParametroContaDetalleDataAccess.save(this.parametrocontadetalle, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrocontadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSaveAfter(this.parametrocontadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroContaDetalle();
			
			connexion.commit();			
			
			if(this.parametrocontadetalle.getIsDeleted()) {
				this.parametrocontadetalle=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroContaDetalle()throws Exception {	
		try {	
			
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSave(this.parametrocontadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToSave(this.parametrocontadetalle,this.arrDatoGeneral);
			
			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocontadetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroContaDetalle(this.parametrocontadetalle)) {			
				ParametroContaDetalleDataAccess.save(this.parametrocontadetalle, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrocontadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSaveAfter(this.parametrocontadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrocontadetalle.getIsDeleted()) {
				this.parametrocontadetalle=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroContaDetallesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-saveParametroContaDetallesWithConnection");connexion.begin();			
			
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSaves(parametrocontadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroContaDetalles();
			
			Boolean validadoTodosParametroContaDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroContaDetalle parametrocontadetalleLocal:parametrocontadetalles) {		
				if(parametrocontadetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToSave(parametrocontadetalleLocal,this.arrDatoGeneral);
	        	
				ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocontadetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroContaDetalle(parametrocontadetalleLocal)) {
					ParametroContaDetalleDataAccess.save(parametrocontadetalleLocal, connexion);				
				} else {
					validadoTodosParametroContaDetalle=false;
				}
			}
			
			if(!validadoTodosParametroContaDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSavesAfter(parametrocontadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroContaDetalles();
			
			connexion.commit();		
			
			this.quitarParametroContaDetallesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroContaDetalles()throws Exception {				
		 try {	
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSaves(parametrocontadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroContaDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroContaDetalle parametrocontadetalleLocal:parametrocontadetalles) {				
				if(parametrocontadetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToSave(parametrocontadetalleLocal,this.arrDatoGeneral);
	        	
				ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocontadetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroContaDetalle(parametrocontadetalleLocal)) {				
					ParametroContaDetalleDataAccess.save(parametrocontadetalleLocal, connexion);				
				} else {
					validadoTodosParametroContaDetalle=false;
				}
			}
			
			if(!validadoTodosParametroContaDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroContaDetalleLogicAdditional.checkParametroContaDetalleToSavesAfter(parametrocontadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroContaDetallesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroContaDetalleParameterReturnGeneral procesarAccionParametroContaDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroContaDetalle> parametrocontadetalles,ParametroContaDetalleParameterReturnGeneral parametrocontadetalleParameterGeneral)throws Exception {
		 try {	
			ParametroContaDetalleParameterReturnGeneral parametrocontadetalleReturnGeneral=new ParametroContaDetalleParameterReturnGeneral();
	
			ParametroContaDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocontadetalles,parametrocontadetalleParameterGeneral,parametrocontadetalleReturnGeneral);
			
			return parametrocontadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroContaDetalleParameterReturnGeneral procesarAccionParametroContaDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroContaDetalle> parametrocontadetalles,ParametroContaDetalleParameterReturnGeneral parametrocontadetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-procesarAccionParametroContaDetallesWithConnection");connexion.begin();			
			
			ParametroContaDetalleParameterReturnGeneral parametrocontadetalleReturnGeneral=new ParametroContaDetalleParameterReturnGeneral();
	
			ParametroContaDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocontadetalles,parametrocontadetalleParameterGeneral,parametrocontadetalleReturnGeneral);
			
			this.connexion.commit();
			
			return parametrocontadetalleReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroContaDetalleParameterReturnGeneral procesarEventosParametroContaDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroContaDetalle> parametrocontadetalles,ParametroContaDetalle parametrocontadetalle,ParametroContaDetalleParameterReturnGeneral parametrocontadetalleParameterGeneral,Boolean isEsNuevoParametroContaDetalle,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroContaDetalleParameterReturnGeneral parametrocontadetalleReturnGeneral=new ParametroContaDetalleParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocontadetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroContaDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocontadetalles,parametrocontadetalle,parametrocontadetalleParameterGeneral,parametrocontadetalleReturnGeneral,isEsNuevoParametroContaDetalle,clases);
			
			return parametrocontadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroContaDetalleParameterReturnGeneral procesarEventosParametroContaDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroContaDetalle> parametrocontadetalles,ParametroContaDetalle parametrocontadetalle,ParametroContaDetalleParameterReturnGeneral parametrocontadetalleParameterGeneral,Boolean isEsNuevoParametroContaDetalle,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-procesarEventosParametroContaDetallesWithConnection");connexion.begin();			
			
			ParametroContaDetalleParameterReturnGeneral parametrocontadetalleReturnGeneral=new ParametroContaDetalleParameterReturnGeneral();
	
			parametrocontadetalleReturnGeneral.setParametroContaDetalle(parametrocontadetalle);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocontadetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroContaDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocontadetalles,parametrocontadetalle,parametrocontadetalleParameterGeneral,parametrocontadetalleReturnGeneral,isEsNuevoParametroContaDetalle,clases);
			
			this.connexion.commit();
			
			return parametrocontadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroContaDetalleParameterReturnGeneral procesarImportacionParametroContaDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroContaDetalleParameterReturnGeneral parametrocontadetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-procesarImportacionParametroContaDetallesWithConnection");connexion.begin();			
			
			ParametroContaDetalleParameterReturnGeneral parametrocontadetalleReturnGeneral=new ParametroContaDetalleParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrocontadetalles=new ArrayList<ParametroContaDetalle>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrocontadetalle=new ParametroContaDetalle();
				
				
				if(conColumnasBase) {this.parametrocontadetalle.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrocontadetalle.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametrocontadetalles.add(this.parametrocontadetalle);
			}
			
			this.saveParametroContaDetalles();
			
			this.connexion.commit();
			
			parametrocontadetalleReturnGeneral.setConRetornoEstaProcesado(true);
			parametrocontadetalleReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrocontadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroContaDetallesEliminados() throws Exception {				
		
		List<ParametroContaDetalle> parametrocontadetallesAux= new ArrayList<ParametroContaDetalle>();
		
		for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles) {
			if(!parametrocontadetalle.getIsDeleted()) {
				parametrocontadetallesAux.add(parametrocontadetalle);
			}
		}
		
		parametrocontadetalles=parametrocontadetallesAux;
	}
	
	public void quitarParametroContaDetallesNulos() throws Exception {				
		
		List<ParametroContaDetalle> parametrocontadetallesAux= new ArrayList<ParametroContaDetalle>();
		
		for(ParametroContaDetalle parametrocontadetalle : this.parametrocontadetalles) {
			if(parametrocontadetalle==null) {
				parametrocontadetallesAux.add(parametrocontadetalle);
			}
		}
		
		//this.parametrocontadetalles=parametrocontadetallesAux;
		
		this.parametrocontadetalles.removeAll(parametrocontadetallesAux);
	}
	
	public void getSetVersionRowParametroContaDetalleWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrocontadetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrocontadetalle.getIsDeleted() || (parametrocontadetalle.getIsChanged()&&!parametrocontadetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrocontadetalleDataAccess.getSetVersionRowParametroContaDetalle(connexion,parametrocontadetalle.getId());
				
				if(!parametrocontadetalle.getVersionRow().equals(timestamp)) {	
					parametrocontadetalle.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrocontadetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroContaDetalle()throws Exception {	
		
		if(parametrocontadetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrocontadetalle.getIsDeleted() || (parametrocontadetalle.getIsChanged()&&!parametrocontadetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrocontadetalleDataAccess.getSetVersionRowParametroContaDetalle(connexion,parametrocontadetalle.getId());
			
			try {							
				if(!parametrocontadetalle.getVersionRow().equals(timestamp)) {	
					parametrocontadetalle.setVersionRow(timestamp);
				}
				
				parametrocontadetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroContaDetallesWithConnection()throws Exception {	
		if(parametrocontadetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroContaDetalle parametrocontadetalleAux:parametrocontadetalles) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrocontadetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocontadetalleAux.getIsDeleted() || (parametrocontadetalleAux.getIsChanged()&&!parametrocontadetalleAux.getIsNew())) {
						
						timestamp=parametrocontadetalleDataAccess.getSetVersionRowParametroContaDetalle(connexion,parametrocontadetalleAux.getId());
						
						if(!parametrocontadetalle.getVersionRow().equals(timestamp)) {	
							parametrocontadetalleAux.setVersionRow(timestamp);
						}
								
						parametrocontadetalleAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroContaDetalles()throws Exception {	
		if(parametrocontadetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroContaDetalle parametrocontadetalleAux:parametrocontadetalles) {
					if(parametrocontadetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocontadetalleAux.getIsDeleted() || (parametrocontadetalleAux.getIsChanged()&&!parametrocontadetalleAux.getIsNew())) {
						
						timestamp=parametrocontadetalleDataAccess.getSetVersionRowParametroContaDetalle(connexion,parametrocontadetalleAux.getId());
						
						if(!parametrocontadetalleAux.getVersionRow().equals(timestamp)) {	
							parametrocontadetalleAux.setVersionRow(timestamp);
						}
						
													
						parametrocontadetalleAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroContaDetalleParameterReturnGeneral cargarCombosLoteForeignKeyParametroContaDetalleWithConnection(String finalQueryGlobalParametroConta,String finalQueryGlobalTipoParametroConta,String finalQueryGlobalCuentaContable) throws Exception {
		ParametroContaDetalleParameterReturnGeneral  parametrocontadetalleReturnGeneral =new ParametroContaDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroContaDetalleWithConnection");connexion.begin();
			
			parametrocontadetalleReturnGeneral =new ParametroContaDetalleParameterReturnGeneral();
			
			

			List<ParametroConta> parametrocontasForeignKey=new ArrayList<ParametroConta>();
			ParametroContaLogic parametrocontaLogic=new ParametroContaLogic();
			parametrocontaLogic.setConnexion(this.connexion);
			parametrocontaLogic.getParametroContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParametroConta.equals("NONE")) {
				parametrocontaLogic.getTodosParametroContas(finalQueryGlobalParametroConta,new Pagination());
				parametrocontasForeignKey=parametrocontaLogic.getParametroContas();
			}

			parametrocontadetalleReturnGeneral.setparametrocontasForeignKey(parametrocontasForeignKey);


			List<TipoParametroConta> tipoparametrocontasForeignKey=new ArrayList<TipoParametroConta>();
			TipoParametroContaLogic tipoparametrocontaLogic=new TipoParametroContaLogic();
			tipoparametrocontaLogic.setConnexion(this.connexion);
			tipoparametrocontaLogic.getTipoParametroContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParametroConta.equals("NONE")) {
				tipoparametrocontaLogic.getTodosTipoParametroContas(finalQueryGlobalTipoParametroConta,new Pagination());
				tipoparametrocontasForeignKey=tipoparametrocontaLogic.getTipoParametroContas();
			}

			parametrocontadetalleReturnGeneral.settipoparametrocontasForeignKey(tipoparametrocontasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			parametrocontadetalleReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrocontadetalleReturnGeneral;
	}
	
	public ParametroContaDetalleParameterReturnGeneral cargarCombosLoteForeignKeyParametroContaDetalle(String finalQueryGlobalParametroConta,String finalQueryGlobalTipoParametroConta,String finalQueryGlobalCuentaContable) throws Exception {
		ParametroContaDetalleParameterReturnGeneral  parametrocontadetalleReturnGeneral =new ParametroContaDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrocontadetalleReturnGeneral =new ParametroContaDetalleParameterReturnGeneral();
			
			

			List<ParametroConta> parametrocontasForeignKey=new ArrayList<ParametroConta>();
			ParametroContaLogic parametrocontaLogic=new ParametroContaLogic();
			parametrocontaLogic.setConnexion(this.connexion);
			parametrocontaLogic.getParametroContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParametroConta.equals("NONE")) {
				parametrocontaLogic.getTodosParametroContas(finalQueryGlobalParametroConta,new Pagination());
				parametrocontasForeignKey=parametrocontaLogic.getParametroContas();
			}

			parametrocontadetalleReturnGeneral.setparametrocontasForeignKey(parametrocontasForeignKey);


			List<TipoParametroConta> tipoparametrocontasForeignKey=new ArrayList<TipoParametroConta>();
			TipoParametroContaLogic tipoparametrocontaLogic=new TipoParametroContaLogic();
			tipoparametrocontaLogic.setConnexion(this.connexion);
			tipoparametrocontaLogic.getTipoParametroContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParametroConta.equals("NONE")) {
				tipoparametrocontaLogic.getTodosTipoParametroContas(finalQueryGlobalTipoParametroConta,new Pagination());
				tipoparametrocontasForeignKey=tipoparametrocontaLogic.getTipoParametroContas();
			}

			parametrocontadetalleReturnGeneral.settipoparametrocontasForeignKey(tipoparametrocontasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			parametrocontadetalleReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrocontadetalleReturnGeneral;
	}
	
	
	public void deepLoad(ParametroContaDetalle parametrocontadetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToGet(parametrocontadetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocontadetalle.setParametroConta(parametrocontadetalleDataAccess.getParametroConta(connexion,parametrocontadetalle));
		parametrocontadetalle.setTipoParametroConta(parametrocontadetalleDataAccess.getTipoParametroConta(connexion,parametrocontadetalle));
		parametrocontadetalle.setCuentaContable(parametrocontadetalleDataAccess.getCuentaContable(connexion,parametrocontadetalle));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroConta.class)) {
				parametrocontadetalle.setParametroConta(parametrocontadetalleDataAccess.getParametroConta(connexion,parametrocontadetalle));
				continue;
			}

			if(clas.clas.equals(TipoParametroConta.class)) {
				parametrocontadetalle.setTipoParametroConta(parametrocontadetalleDataAccess.getTipoParametroConta(connexion,parametrocontadetalle));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrocontadetalle.setCuentaContable(parametrocontadetalleDataAccess.getCuentaContable(connexion,parametrocontadetalle));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontadetalle.setParametroConta(parametrocontadetalleDataAccess.getParametroConta(connexion,parametrocontadetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParametroConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontadetalle.setTipoParametroConta(parametrocontadetalleDataAccess.getTipoParametroConta(connexion,parametrocontadetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontadetalle.setCuentaContable(parametrocontadetalleDataAccess.getCuentaContable(connexion,parametrocontadetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocontadetalle.setParametroConta(parametrocontadetalleDataAccess.getParametroConta(connexion,parametrocontadetalle));
		ParametroContaLogic parametrocontaLogic= new ParametroContaLogic(connexion);
		parametrocontaLogic.deepLoad(parametrocontadetalle.getParametroConta(),isDeep,deepLoadType,clases);
				
		parametrocontadetalle.setTipoParametroConta(parametrocontadetalleDataAccess.getTipoParametroConta(connexion,parametrocontadetalle));
		TipoParametroContaLogic tipoparametrocontaLogic= new TipoParametroContaLogic(connexion);
		tipoparametrocontaLogic.deepLoad(parametrocontadetalle.getTipoParametroConta(),isDeep,deepLoadType,clases);
				
		parametrocontadetalle.setCuentaContable(parametrocontadetalleDataAccess.getCuentaContable(connexion,parametrocontadetalle));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(parametrocontadetalle.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroConta.class)) {
				parametrocontadetalle.setParametroConta(parametrocontadetalleDataAccess.getParametroConta(connexion,parametrocontadetalle));
				ParametroContaLogic parametrocontaLogic= new ParametroContaLogic(connexion);
				parametrocontaLogic.deepLoad(parametrocontadetalle.getParametroConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParametroConta.class)) {
				parametrocontadetalle.setTipoParametroConta(parametrocontadetalleDataAccess.getTipoParametroConta(connexion,parametrocontadetalle));
				TipoParametroContaLogic tipoparametrocontaLogic= new TipoParametroContaLogic(connexion);
				tipoparametrocontaLogic.deepLoad(parametrocontadetalle.getTipoParametroConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrocontadetalle.setCuentaContable(parametrocontadetalleDataAccess.getCuentaContable(connexion,parametrocontadetalle));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrocontadetalle.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontadetalle.setParametroConta(parametrocontadetalleDataAccess.getParametroConta(connexion,parametrocontadetalle));
			ParametroContaLogic parametrocontaLogic= new ParametroContaLogic(connexion);
			parametrocontaLogic.deepLoad(parametrocontadetalle.getParametroConta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParametroConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontadetalle.setTipoParametroConta(parametrocontadetalleDataAccess.getTipoParametroConta(connexion,parametrocontadetalle));
			TipoParametroContaLogic tipoparametrocontaLogic= new TipoParametroContaLogic(connexion);
			tipoparametrocontaLogic.deepLoad(parametrocontadetalle.getTipoParametroConta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontadetalle.setCuentaContable(parametrocontadetalleDataAccess.getCuentaContable(connexion,parametrocontadetalle));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrocontadetalle.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroContaDetalle parametrocontadetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroContaDetalleLogicAdditional.updateParametroContaDetalleToSave(parametrocontadetalle,this.arrDatoGeneral);
			
ParametroContaDetalleDataAccess.save(parametrocontadetalle, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ParametroContaDataAccess.save(parametrocontadetalle.getParametroConta(),connexion);

		TipoParametroContaDataAccess.save(parametrocontadetalle.getTipoParametroConta(),connexion);

		CuentaContableDataAccess.save(parametrocontadetalle.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroConta.class)) {
				ParametroContaDataAccess.save(parametrocontadetalle.getParametroConta(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoParametroConta.class)) {
				TipoParametroContaDataAccess.save(parametrocontadetalle.getTipoParametroConta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrocontadetalle.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ParametroContaDataAccess.save(parametrocontadetalle.getParametroConta(),connexion);
		ParametroContaLogic parametrocontaLogic= new ParametroContaLogic(connexion);
		parametrocontaLogic.deepLoad(parametrocontadetalle.getParametroConta(),isDeep,deepLoadType,clases);
				

		TipoParametroContaDataAccess.save(parametrocontadetalle.getTipoParametroConta(),connexion);
		TipoParametroContaLogic tipoparametrocontaLogic= new TipoParametroContaLogic(connexion);
		tipoparametrocontaLogic.deepLoad(parametrocontadetalle.getTipoParametroConta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrocontadetalle.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(parametrocontadetalle.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroConta.class)) {
				ParametroContaDataAccess.save(parametrocontadetalle.getParametroConta(),connexion);
				ParametroContaLogic parametrocontaLogic= new ParametroContaLogic(connexion);
				parametrocontaLogic.deepSave(parametrocontadetalle.getParametroConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParametroConta.class)) {
				TipoParametroContaDataAccess.save(parametrocontadetalle.getTipoParametroConta(),connexion);
				TipoParametroContaLogic tipoparametrocontaLogic= new TipoParametroContaLogic(connexion);
				tipoparametrocontaLogic.deepSave(parametrocontadetalle.getTipoParametroConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrocontadetalle.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrocontadetalle.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroContaDetalle.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(parametrocontadetalle);
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
			this.deepLoad(this.parametrocontadetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroContaDetalle.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrocontadetalles!=null) {
				for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles) {
					this.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(parametrocontadetalles);
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
			if(parametrocontadetalles!=null) {
				for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles) {
					this.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(parametrocontadetalles);
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
			this.getNewConnexionToDeep(ParametroContaDetalle.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrocontadetalle,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroContaDetalle.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrocontadetalles!=null) {
				for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles) {
					this.deepSave(parametrocontadetalle,isDeep,deepLoadType,clases);
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
			if(parametrocontadetalles!=null) {
				for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles) {
					this.deepSave(parametrocontadetalle,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroContaDetallesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContaDetallesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContaDetallesFK_IdParametroContaWithConnection(String sFinalQuery,Pagination pagination,Long id_parametro_conta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParametroConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParametroConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parametro_conta,ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParametroConta);

			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContaDetallesFK_IdParametroConta(String sFinalQuery,Pagination pagination,Long id_parametro_conta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParametroConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParametroConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parametro_conta,ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParametroConta);

			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContaDetallesFK_IdParametroContaDetalleWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_parametro_conta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContaDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParametroConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParametroConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_parametro_conta,ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParametroConta);

			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroContaDetalle","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContaDetallesFK_IdParametroContaDetalle(String sFinalQuery,Pagination pagination,Long id_tipo_parametro_conta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParametroConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParametroConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_parametro_conta,ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParametroConta);

			ParametroContaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroContaDetalle","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontadetalles=parametrocontadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(this.parametrocontadetalles);
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
			if(ParametroContaDetalleConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDetalleDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroContaDetalle parametrocontadetalle,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroContaDetalleConstantesFunciones.ISCONAUDITORIA) {
				if(parametrocontadetalle.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDetalleDataAccess.TABLENAME, parametrocontadetalle.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroContaDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroContaDetalleLogic.registrarAuditoriaDetallesParametroContaDetalle(connexion,parametrocontadetalle,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrocontadetalle.getIsDeleted()) {
					/*if(!parametrocontadetalle.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroContaDetalleDataAccess.TABLENAME, parametrocontadetalle.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroContaDetalleLogic.registrarAuditoriaDetallesParametroContaDetalle(connexion,parametrocontadetalle,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDetalleDataAccess.TABLENAME, parametrocontadetalle.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrocontadetalle.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDetalleDataAccess.TABLENAME, parametrocontadetalle.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroContaDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroContaDetalleLogic.registrarAuditoriaDetallesParametroContaDetalle(connexion,parametrocontadetalle,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroContaDetalle(Connexion connexion,ParametroContaDetalle parametrocontadetalle)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrocontadetalle.getIsNew()||!parametrocontadetalle.getid_parametro_conta().equals(parametrocontadetalle.getParametroContaDetalleOriginal().getid_parametro_conta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontadetalle.getParametroContaDetalleOriginal().getid_parametro_conta()!=null)
				{
					strValorActual=parametrocontadetalle.getParametroContaDetalleOriginal().getid_parametro_conta().toString();
				}
				if(parametrocontadetalle.getid_parametro_conta()!=null)
				{
					strValorNuevo=parametrocontadetalle.getid_parametro_conta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontadetalle.getIsNew()||!parametrocontadetalle.getid_tipo_parametro_conta().equals(parametrocontadetalle.getParametroContaDetalleOriginal().getid_tipo_parametro_conta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontadetalle.getParametroContaDetalleOriginal().getid_tipo_parametro_conta()!=null)
				{
					strValorActual=parametrocontadetalle.getParametroContaDetalleOriginal().getid_tipo_parametro_conta().toString();
				}
				if(parametrocontadetalle.getid_tipo_parametro_conta()!=null)
				{
					strValorNuevo=parametrocontadetalle.getid_tipo_parametro_conta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontadetalle.getIsNew()||!parametrocontadetalle.getid_cuenta_contable().equals(parametrocontadetalle.getParametroContaDetalleOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontadetalle.getParametroContaDetalleOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=parametrocontadetalle.getParametroContaDetalleOriginal().getid_cuenta_contable().toString();
				}
				if(parametrocontadetalle.getid_cuenta_contable()!=null)
				{
					strValorNuevo=parametrocontadetalle.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroContaDetalleRelacionesWithConnection(ParametroContaDetalle parametrocontadetalle) throws Exception {

		if(!parametrocontadetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroContaDetalleRelacionesBase(parametrocontadetalle,true);
		}
	}

	public void saveParametroContaDetalleRelaciones(ParametroContaDetalle parametrocontadetalle)throws Exception {

		if(!parametrocontadetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroContaDetalleRelacionesBase(parametrocontadetalle,false);
		}
	}

	public void saveParametroContaDetalleRelacionesBase(ParametroContaDetalle parametrocontadetalle,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroContaDetalle-saveRelacionesWithConnection");}
	

			this.setParametroContaDetalle(parametrocontadetalle);

			if(ParametroContaDetalleLogicAdditional.validarSaveRelaciones(parametrocontadetalle,this)) {

				ParametroContaDetalleLogicAdditional.updateRelacionesToSave(parametrocontadetalle,this);

				if((parametrocontadetalle.getIsNew()||parametrocontadetalle.getIsChanged())&&!parametrocontadetalle.getIsDeleted()) {
					this.saveParametroContaDetalle();
					this.saveParametroContaDetalleRelacionesDetalles();

				} else if(parametrocontadetalle.getIsDeleted()) {
					this.saveParametroContaDetalleRelacionesDetalles();
					this.saveParametroContaDetalle();
				}

				ParametroContaDetalleLogicAdditional.updateRelacionesToSaveAfter(parametrocontadetalle,this);

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
	
	
	private void saveParametroContaDetalleRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroContaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroContaDetalleConstantesFunciones.getClassesForeignKeysOfParametroContaDetalle(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroContaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroContaDetalleConstantesFunciones.getClassesRelationshipsOfParametroContaDetalle(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
