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
import com.bydan.erp.contabilidad.util.ParametroPlanillaConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroPlanillaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroPlanillaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ParametroPlanilla;
import com.bydan.erp.contabilidad.business.logic.ParametroPlanillaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroPlanillaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroPlanillaLogic.class);
	
	protected ParametroPlanillaDataAccess parametroplanillaDataAccess; 	
	protected ParametroPlanilla parametroplanilla;
	protected List<ParametroPlanilla> parametroplanillas;
	protected Object parametroplanillaObject;	
	protected List<Object> parametroplanillasObject;
	
	public static ClassValidator<ParametroPlanilla> parametroplanillaValidator = new ClassValidator<ParametroPlanilla>(ParametroPlanilla.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroPlanillaLogicAdditional parametroplanillaLogicAdditional=null;
	
	public ParametroPlanillaLogicAdditional getParametroPlanillaLogicAdditional() {
		return this.parametroplanillaLogicAdditional;
	}
	
	public void setParametroPlanillaLogicAdditional(ParametroPlanillaLogicAdditional parametroplanillaLogicAdditional) {
		try {
			this.parametroplanillaLogicAdditional=parametroplanillaLogicAdditional;
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
	
	
	
	
	public  ParametroPlanillaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametroplanillaDataAccess = new ParametroPlanillaDataAccess();
			
			this.parametroplanillas= new ArrayList<ParametroPlanilla>();
			this.parametroplanilla= new ParametroPlanilla();
			
			this.parametroplanillaObject=new Object();
			this.parametroplanillasObject=new ArrayList<Object>();
				
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
			
			this.parametroplanillaDataAccess.setConnexionType(this.connexionType);
			this.parametroplanillaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroPlanillaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametroplanillaDataAccess = new ParametroPlanillaDataAccess();
			this.parametroplanillas= new ArrayList<ParametroPlanilla>();
			this.parametroplanilla= new ParametroPlanilla();
			this.parametroplanillaObject=new Object();
			this.parametroplanillasObject=new ArrayList<Object>();
			
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
			
			this.parametroplanillaDataAccess.setConnexionType(this.connexionType);
			this.parametroplanillaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroPlanilla getParametroPlanilla() throws Exception {	
		ParametroPlanillaLogicAdditional.checkParametroPlanillaToGet(parametroplanilla,this.datosCliente,this.arrDatoGeneral);
		ParametroPlanillaLogicAdditional.updateParametroPlanillaToGet(parametroplanilla,this.arrDatoGeneral);
		
		return parametroplanilla;
	}
		
	public void setParametroPlanilla(ParametroPlanilla newParametroPlanilla) {
		this.parametroplanilla = newParametroPlanilla;
	}
	
	public ParametroPlanillaDataAccess getParametroPlanillaDataAccess() {
		return parametroplanillaDataAccess;
	}
	
	public void setParametroPlanillaDataAccess(ParametroPlanillaDataAccess newparametroplanillaDataAccess) {
		this.parametroplanillaDataAccess = newparametroplanillaDataAccess;
	}
	
	public List<ParametroPlanilla> getParametroPlanillas() throws Exception {		
		this.quitarParametroPlanillasNulos();
		
		ParametroPlanillaLogicAdditional.checkParametroPlanillaToGets(parametroplanillas,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroPlanilla parametroplanillaLocal: parametroplanillas ) {
			ParametroPlanillaLogicAdditional.updateParametroPlanillaToGet(parametroplanillaLocal,this.arrDatoGeneral);
		}
		
		return parametroplanillas;
	}
	
	public void setParametroPlanillas(List<ParametroPlanilla> newParametroPlanillas) {
		this.parametroplanillas = newParametroPlanillas;
	}
	
	public Object getParametroPlanillaObject() {	
		this.parametroplanillaObject=this.parametroplanillaDataAccess.getEntityObject();
		return this.parametroplanillaObject;
	}
		
	public void setParametroPlanillaObject(Object newParametroPlanillaObject) {
		this.parametroplanillaObject = newParametroPlanillaObject;
	}
	
	public List<Object> getParametroPlanillasObject() {		
		this.parametroplanillasObject=this.parametroplanillaDataAccess.getEntitiesObject();
		return this.parametroplanillasObject;
	}
		
	public void setParametroPlanillasObject(List<Object> newParametroPlanillasObject) {
		this.parametroplanillasObject = newParametroPlanillasObject;
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
		
		if(this.parametroplanillaDataAccess!=null) {
			this.parametroplanillaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametroplanillaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametroplanillaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroplanilla = new  ParametroPlanilla();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroplanilla=parametroplanillaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroplanilla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanilla);
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
		parametroplanilla = new  ParametroPlanilla();
		  		  
        try {
			
			parametroplanilla=parametroplanillaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroplanilla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanilla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroplanilla = new  ParametroPlanilla();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroplanilla=parametroplanillaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroplanilla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanilla);
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
		parametroplanilla = new  ParametroPlanilla();
		  		  
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
		parametroplanilla = new  ParametroPlanilla();
		  		  
        try {
			
			parametroplanilla=parametroplanillaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroplanilla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanilla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroplanilla = new  ParametroPlanilla();
		  		  
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
		parametroplanilla = new  ParametroPlanilla();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametroplanillaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroplanilla = new  ParametroPlanilla();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametroplanillaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroplanilla = new  ParametroPlanilla();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametroplanillaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroplanilla = new  ParametroPlanilla();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametroplanillaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroplanilla = new  ParametroPlanilla();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametroplanillaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroplanilla = new  ParametroPlanilla();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametroplanillaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
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
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
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
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
        try {			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
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
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
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
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
        try {
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
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
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
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
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroplanilla = new  ParametroPlanilla();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanilla=parametroplanillaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanilla);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanilla);
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
		parametroplanilla = new  ParametroPlanilla();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanilla=parametroplanillaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanilla);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanilla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
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
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		  		  
        try {
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroPlanillasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getTodosParametroPlanillasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
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
	
	public  void  getTodosParametroPlanillas(String sFinalQuery,Pagination pagination)throws Exception {
		parametroplanillas = new  ArrayList<ParametroPlanilla>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroPlanilla(parametroplanillas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroPlanilla(ParametroPlanilla parametroplanilla) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroplanilla.getIsNew() || parametroplanilla.getIsChanged()) { 
			this.invalidValues = parametroplanillaValidator.getInvalidValues(parametroplanilla);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroplanilla);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroPlanilla(List<ParametroPlanilla> ParametroPlanillas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroPlanilla parametroplanillaLocal:parametroplanillas) {				
			estaValidadoObjeto=this.validarGuardarParametroPlanilla(parametroplanillaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroPlanilla(List<ParametroPlanilla> ParametroPlanillas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroPlanilla(parametroplanillas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroPlanilla(ParametroPlanilla ParametroPlanilla) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroPlanilla(parametroplanilla)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroPlanilla parametroplanilla) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroplanilla.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroPlanillaConstantesFunciones.getParametroPlanillaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroplanilla","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroPlanillaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroPlanillaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroPlanillaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-saveParametroPlanillaWithConnection");connexion.begin();			
			
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSave(this.parametroplanilla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroPlanillaLogicAdditional.updateParametroPlanillaToSave(this.parametroplanilla,this.arrDatoGeneral);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroplanilla,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroPlanilla();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroPlanilla(this.parametroplanilla)) {
				ParametroPlanillaDataAccess.save(this.parametroplanilla, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroplanilla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSaveAfter(this.parametroplanilla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroPlanilla();
			
			connexion.commit();			
			
			if(this.parametroplanilla.getIsDeleted()) {
				this.parametroplanilla=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroPlanilla()throws Exception {	
		try {	
			
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSave(this.parametroplanilla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroPlanillaLogicAdditional.updateParametroPlanillaToSave(this.parametroplanilla,this.arrDatoGeneral);
			
			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroplanilla,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroPlanilla(this.parametroplanilla)) {			
				ParametroPlanillaDataAccess.save(this.parametroplanilla, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroplanilla,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSaveAfter(this.parametroplanilla,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroplanilla.getIsDeleted()) {
				this.parametroplanilla=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroPlanillasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-saveParametroPlanillasWithConnection");connexion.begin();			
			
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSaves(parametroplanillas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroPlanillas();
			
			Boolean validadoTodosParametroPlanilla=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroPlanilla parametroplanillaLocal:parametroplanillas) {		
				if(parametroplanillaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroPlanillaLogicAdditional.updateParametroPlanillaToSave(parametroplanillaLocal,this.arrDatoGeneral);
	        	
				ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroplanillaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroPlanilla(parametroplanillaLocal)) {
					ParametroPlanillaDataAccess.save(parametroplanillaLocal, connexion);				
				} else {
					validadoTodosParametroPlanilla=false;
				}
			}
			
			if(!validadoTodosParametroPlanilla) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSavesAfter(parametroplanillas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroPlanillas();
			
			connexion.commit();		
			
			this.quitarParametroPlanillasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroPlanillas()throws Exception {				
		 try {	
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSaves(parametroplanillas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroPlanilla=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroPlanilla parametroplanillaLocal:parametroplanillas) {				
				if(parametroplanillaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroPlanillaLogicAdditional.updateParametroPlanillaToSave(parametroplanillaLocal,this.arrDatoGeneral);
	        	
				ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroplanillaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroPlanilla(parametroplanillaLocal)) {				
					ParametroPlanillaDataAccess.save(parametroplanillaLocal, connexion);				
				} else {
					validadoTodosParametroPlanilla=false;
				}
			}
			
			if(!validadoTodosParametroPlanilla) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroPlanillaLogicAdditional.checkParametroPlanillaToSavesAfter(parametroplanillas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroPlanillasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroPlanillaParameterReturnGeneral procesarAccionParametroPlanillas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroPlanilla> parametroplanillas,ParametroPlanillaParameterReturnGeneral parametroplanillaParameterGeneral)throws Exception {
		 try {	
			ParametroPlanillaParameterReturnGeneral parametroplanillaReturnGeneral=new ParametroPlanillaParameterReturnGeneral();
	
			ParametroPlanillaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroplanillas,parametroplanillaParameterGeneral,parametroplanillaReturnGeneral);
			
			return parametroplanillaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroPlanillaParameterReturnGeneral procesarAccionParametroPlanillasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroPlanilla> parametroplanillas,ParametroPlanillaParameterReturnGeneral parametroplanillaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-procesarAccionParametroPlanillasWithConnection");connexion.begin();			
			
			ParametroPlanillaParameterReturnGeneral parametroplanillaReturnGeneral=new ParametroPlanillaParameterReturnGeneral();
	
			ParametroPlanillaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroplanillas,parametroplanillaParameterGeneral,parametroplanillaReturnGeneral);
			
			this.connexion.commit();
			
			return parametroplanillaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroPlanillaParameterReturnGeneral procesarEventosParametroPlanillas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroPlanilla> parametroplanillas,ParametroPlanilla parametroplanilla,ParametroPlanillaParameterReturnGeneral parametroplanillaParameterGeneral,Boolean isEsNuevoParametroPlanilla,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroPlanillaParameterReturnGeneral parametroplanillaReturnGeneral=new ParametroPlanillaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroplanillaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroPlanillaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroplanillas,parametroplanilla,parametroplanillaParameterGeneral,parametroplanillaReturnGeneral,isEsNuevoParametroPlanilla,clases);
			
			return parametroplanillaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroPlanillaParameterReturnGeneral procesarEventosParametroPlanillasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroPlanilla> parametroplanillas,ParametroPlanilla parametroplanilla,ParametroPlanillaParameterReturnGeneral parametroplanillaParameterGeneral,Boolean isEsNuevoParametroPlanilla,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-procesarEventosParametroPlanillasWithConnection");connexion.begin();			
			
			ParametroPlanillaParameterReturnGeneral parametroplanillaReturnGeneral=new ParametroPlanillaParameterReturnGeneral();
	
			parametroplanillaReturnGeneral.setParametroPlanilla(parametroplanilla);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroplanillaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroPlanillaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroplanillas,parametroplanilla,parametroplanillaParameterGeneral,parametroplanillaReturnGeneral,isEsNuevoParametroPlanilla,clases);
			
			this.connexion.commit();
			
			return parametroplanillaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroPlanillaParameterReturnGeneral procesarImportacionParametroPlanillasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroPlanillaParameterReturnGeneral parametroplanillaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-procesarImportacionParametroPlanillasWithConnection");connexion.begin();			
			
			ParametroPlanillaParameterReturnGeneral parametroplanillaReturnGeneral=new ParametroPlanillaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametroplanillas=new ArrayList<ParametroPlanilla>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroplanilla=new ParametroPlanilla();
				
				
				if(conColumnasBase) {this.parametroplanilla.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroplanilla.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametroplanillas.add(this.parametroplanilla);
			}
			
			this.saveParametroPlanillas();
			
			this.connexion.commit();
			
			parametroplanillaReturnGeneral.setConRetornoEstaProcesado(true);
			parametroplanillaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametroplanillaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroPlanillasEliminados() throws Exception {				
		
		List<ParametroPlanilla> parametroplanillasAux= new ArrayList<ParametroPlanilla>();
		
		for(ParametroPlanilla parametroplanilla:parametroplanillas) {
			if(!parametroplanilla.getIsDeleted()) {
				parametroplanillasAux.add(parametroplanilla);
			}
		}
		
		parametroplanillas=parametroplanillasAux;
	}
	
	public void quitarParametroPlanillasNulos() throws Exception {				
		
		List<ParametroPlanilla> parametroplanillasAux= new ArrayList<ParametroPlanilla>();
		
		for(ParametroPlanilla parametroplanilla : this.parametroplanillas) {
			if(parametroplanilla==null) {
				parametroplanillasAux.add(parametroplanilla);
			}
		}
		
		//this.parametroplanillas=parametroplanillasAux;
		
		this.parametroplanillas.removeAll(parametroplanillasAux);
	}
	
	public void getSetVersionRowParametroPlanillaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroplanilla.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroplanilla.getIsDeleted() || (parametroplanilla.getIsChanged()&&!parametroplanilla.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametroplanillaDataAccess.getSetVersionRowParametroPlanilla(connexion,parametroplanilla.getId());
				
				if(!parametroplanilla.getVersionRow().equals(timestamp)) {	
					parametroplanilla.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroplanilla.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroPlanilla()throws Exception {	
		
		if(parametroplanilla.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroplanilla.getIsDeleted() || (parametroplanilla.getIsChanged()&&!parametroplanilla.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametroplanillaDataAccess.getSetVersionRowParametroPlanilla(connexion,parametroplanilla.getId());
			
			try {							
				if(!parametroplanilla.getVersionRow().equals(timestamp)) {	
					parametroplanilla.setVersionRow(timestamp);
				}
				
				parametroplanilla.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroPlanillasWithConnection()throws Exception {	
		if(parametroplanillas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroPlanilla parametroplanillaAux:parametroplanillas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametroplanillaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroplanillaAux.getIsDeleted() || (parametroplanillaAux.getIsChanged()&&!parametroplanillaAux.getIsNew())) {
						
						timestamp=parametroplanillaDataAccess.getSetVersionRowParametroPlanilla(connexion,parametroplanillaAux.getId());
						
						if(!parametroplanilla.getVersionRow().equals(timestamp)) {	
							parametroplanillaAux.setVersionRow(timestamp);
						}
								
						parametroplanillaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroPlanillas()throws Exception {	
		if(parametroplanillas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroPlanilla parametroplanillaAux:parametroplanillas) {
					if(parametroplanillaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroplanillaAux.getIsDeleted() || (parametroplanillaAux.getIsChanged()&&!parametroplanillaAux.getIsNew())) {
						
						timestamp=parametroplanillaDataAccess.getSetVersionRowParametroPlanilla(connexion,parametroplanillaAux.getId());
						
						if(!parametroplanillaAux.getVersionRow().equals(timestamp)) {	
							parametroplanillaAux.setVersionRow(timestamp);
						}
						
													
						parametroplanillaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroPlanillaParameterReturnGeneral cargarCombosLoteForeignKeyParametroPlanillaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableInicial,String finalQueryGlobalCuentaContableFinal) throws Exception {
		ParametroPlanillaParameterReturnGeneral  parametroplanillaReturnGeneral =new ParametroPlanillaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroPlanillaWithConnection");connexion.begin();
			
			parametroplanillaReturnGeneral =new ParametroPlanillaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroplanillaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontableinicialsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinicialLogic=new CuentaContableLogic();
			cuentacontableinicialLogic.setConnexion(this.connexion);
			cuentacontableinicialLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInicial.equals("NONE")) {
				cuentacontableinicialLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInicial,new Pagination());
				cuentacontableinicialsForeignKey=cuentacontableinicialLogic.getCuentaContables();
			}

			parametroplanillaReturnGeneral.setcuentacontableinicialsForeignKey(cuentacontableinicialsForeignKey);


			List<CuentaContable> cuentacontablefinalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefinalLogic=new CuentaContableLogic();
			cuentacontablefinalLogic.setConnexion(this.connexion);
			cuentacontablefinalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFinal.equals("NONE")) {
				cuentacontablefinalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFinal,new Pagination());
				cuentacontablefinalsForeignKey=cuentacontablefinalLogic.getCuentaContables();
			}

			parametroplanillaReturnGeneral.setcuentacontablefinalsForeignKey(cuentacontablefinalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametroplanillaReturnGeneral;
	}
	
	public ParametroPlanillaParameterReturnGeneral cargarCombosLoteForeignKeyParametroPlanilla(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableInicial,String finalQueryGlobalCuentaContableFinal) throws Exception {
		ParametroPlanillaParameterReturnGeneral  parametroplanillaReturnGeneral =new ParametroPlanillaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametroplanillaReturnGeneral =new ParametroPlanillaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroplanillaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontableinicialsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinicialLogic=new CuentaContableLogic();
			cuentacontableinicialLogic.setConnexion(this.connexion);
			cuentacontableinicialLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInicial.equals("NONE")) {
				cuentacontableinicialLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInicial,new Pagination());
				cuentacontableinicialsForeignKey=cuentacontableinicialLogic.getCuentaContables();
			}

			parametroplanillaReturnGeneral.setcuentacontableinicialsForeignKey(cuentacontableinicialsForeignKey);


			List<CuentaContable> cuentacontablefinalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablefinalLogic=new CuentaContableLogic();
			cuentacontablefinalLogic.setConnexion(this.connexion);
			cuentacontablefinalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableFinal.equals("NONE")) {
				cuentacontablefinalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableFinal,new Pagination());
				cuentacontablefinalsForeignKey=cuentacontablefinalLogic.getCuentaContables();
			}

			parametroplanillaReturnGeneral.setcuentacontablefinalsForeignKey(cuentacontablefinalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametroplanillaReturnGeneral;
	}
	
	
	public void deepLoad(ParametroPlanilla parametroplanilla,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroPlanillaLogicAdditional.updateParametroPlanillaToGet(parametroplanilla,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroplanilla.setEmpresa(parametroplanillaDataAccess.getEmpresa(connexion,parametroplanilla));
		parametroplanilla.setCuentaContableInicial(parametroplanillaDataAccess.getCuentaContableInicial(connexion,parametroplanilla));
		parametroplanilla.setCuentaContableFinal(parametroplanillaDataAccess.getCuentaContableFinal(connexion,parametroplanilla));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroplanilla.setEmpresa(parametroplanillaDataAccess.getEmpresa(connexion,parametroplanilla));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroplanilla.setCuentaContableInicial(parametroplanillaDataAccess.getCuentaContableInicial(connexion,parametroplanilla));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroplanilla.setCuentaContableFinal(parametroplanillaDataAccess.getCuentaContableFinal(connexion,parametroplanilla));
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
			parametroplanilla.setEmpresa(parametroplanillaDataAccess.getEmpresa(connexion,parametroplanilla));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroplanilla.setCuentaContableInicial(parametroplanillaDataAccess.getCuentaContableInicial(connexion,parametroplanilla));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroplanilla.setCuentaContableFinal(parametroplanillaDataAccess.getCuentaContableFinal(connexion,parametroplanilla));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroplanilla.setEmpresa(parametroplanillaDataAccess.getEmpresa(connexion,parametroplanilla));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroplanilla.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametroplanilla.setCuentaContableInicial(parametroplanillaDataAccess.getCuentaContableInicial(connexion,parametroplanilla));
		CuentaContableLogic cuentacontableinicialLogic= new CuentaContableLogic(connexion);
		cuentacontableinicialLogic.deepLoad(parametroplanilla.getCuentaContableInicial(),isDeep,deepLoadType,clases);
				
		parametroplanilla.setCuentaContableFinal(parametroplanillaDataAccess.getCuentaContableFinal(connexion,parametroplanilla));
		CuentaContableLogic cuentacontablefinalLogic= new CuentaContableLogic(connexion);
		cuentacontablefinalLogic.deepLoad(parametroplanilla.getCuentaContableFinal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroplanilla.setEmpresa(parametroplanillaDataAccess.getEmpresa(connexion,parametroplanilla));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroplanilla.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroplanilla.setCuentaContableInicial(parametroplanillaDataAccess.getCuentaContableInicial(connexion,parametroplanilla));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroplanilla.getCuentaContableInicial(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroplanilla.setCuentaContableFinal(parametroplanillaDataAccess.getCuentaContableFinal(connexion,parametroplanilla));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroplanilla.getCuentaContableFinal(),isDeep,deepLoadType,clases);				
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
			parametroplanilla.setEmpresa(parametroplanillaDataAccess.getEmpresa(connexion,parametroplanilla));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroplanilla.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroplanilla.setCuentaContableInicial(parametroplanillaDataAccess.getCuentaContableInicial(connexion,parametroplanilla));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroplanilla.getCuentaContableInicial(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroplanilla.setCuentaContableFinal(parametroplanillaDataAccess.getCuentaContableFinal(connexion,parametroplanilla));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroplanilla.getCuentaContableFinal(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroPlanilla parametroplanilla,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroPlanillaLogicAdditional.updateParametroPlanillaToSave(parametroplanilla,this.arrDatoGeneral);
			
ParametroPlanillaDataAccess.save(parametroplanilla, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroplanilla.getEmpresa(),connexion);

		CuentaContableDataAccess.save(parametroplanilla.getCuentaContableInicial(),connexion);

		CuentaContableDataAccess.save(parametroplanilla.getCuentaContableFinal(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroplanilla.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroplanilla.getCuentaContableInicial(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroplanilla.getCuentaContableFinal(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroplanilla.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroplanilla.getEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroplanilla.getCuentaContableInicial(),connexion);
		CuentaContableLogic cuentacontableinicialLogic= new CuentaContableLogic(connexion);
		cuentacontableinicialLogic.deepLoad(parametroplanilla.getCuentaContableInicial(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroplanilla.getCuentaContableFinal(),connexion);
		CuentaContableLogic cuentacontablefinalLogic= new CuentaContableLogic(connexion);
		cuentacontablefinalLogic.deepLoad(parametroplanilla.getCuentaContableFinal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroplanilla.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametroplanilla.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroplanilla.getCuentaContableInicial(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroplanilla.getCuentaContableInicial(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroplanilla.getCuentaContableFinal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroplanilla.getCuentaContableFinal(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroPlanilla.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroplanilla,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(parametroplanilla);
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
			this.deepLoad(this.parametroplanilla,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanilla);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroPlanilla.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametroplanillas!=null) {
				for(ParametroPlanilla parametroplanilla:parametroplanillas) {
					this.deepLoad(parametroplanilla,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(parametroplanillas);
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
			if(parametroplanillas!=null) {
				for(ParametroPlanilla parametroplanilla:parametroplanillas) {
					this.deepLoad(parametroplanilla,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(parametroplanillas);
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
			this.getNewConnexionToDeep(ParametroPlanilla.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametroplanilla,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroPlanilla.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametroplanillas!=null) {
				for(ParametroPlanilla parametroplanilla:parametroplanillas) {
					this.deepSave(parametroplanilla,isDeep,deepLoadType,clases);
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
			if(parametroplanillas!=null) {
				for(ParametroPlanilla parametroplanilla:parametroplanillas) {
					this.deepSave(parametroplanilla,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroPlanillasFK_IdCuentaContableFinalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_final)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFinal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_final,ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFinal);

			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFinal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroPlanillasFK_IdCuentaContableFinal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_final)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableFinal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_final,ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableFinal);

			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableFinal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroPlanillasFK_IdCuentaContableInicialWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inicial)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInicial= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInicial.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inicial,ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInicial);

			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInicial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroPlanillasFK_IdCuentaContableInicial(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inicial)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInicial= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInicial.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inicial,ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInicial);

			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInicial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroPlanillasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroPlanilla.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroPlanillaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroPlanillasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroPlanillaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroPlanillaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroplanillas=parametroplanillaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroPlanillaConstantesFunciones.refrescarForeignKeysDescripcionesParametroPlanilla(this.parametroplanillas);
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
			if(ParametroPlanillaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroPlanillaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroPlanilla parametroplanilla,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroPlanillaConstantesFunciones.ISCONAUDITORIA) {
				if(parametroplanilla.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroPlanillaDataAccess.TABLENAME, parametroplanilla.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroPlanillaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroPlanillaLogic.registrarAuditoriaDetallesParametroPlanilla(connexion,parametroplanilla,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroplanilla.getIsDeleted()) {
					/*if(!parametroplanilla.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroPlanillaDataAccess.TABLENAME, parametroplanilla.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroPlanillaLogic.registrarAuditoriaDetallesParametroPlanilla(connexion,parametroplanilla,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroPlanillaDataAccess.TABLENAME, parametroplanilla.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroplanilla.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroPlanillaDataAccess.TABLENAME, parametroplanilla.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroPlanillaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroPlanillaLogic.registrarAuditoriaDetallesParametroPlanilla(connexion,parametroplanilla,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroPlanilla(Connexion connexion,ParametroPlanilla parametroplanilla)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroplanilla.getIsNew()||!parametroplanilla.getid_empresa().equals(parametroplanilla.getParametroPlanillaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroplanilla.getParametroPlanillaOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroplanilla.getParametroPlanillaOriginal().getid_empresa().toString();
				}
				if(parametroplanilla.getid_empresa()!=null)
				{
					strValorNuevo=parametroplanilla.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroPlanillaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroplanilla.getIsNew()||!parametroplanilla.getid_cuenta_contable_inicial().equals(parametroplanilla.getParametroPlanillaOriginal().getid_cuenta_contable_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroplanilla.getParametroPlanillaOriginal().getid_cuenta_contable_inicial()!=null)
				{
					strValorActual=parametroplanilla.getParametroPlanillaOriginal().getid_cuenta_contable_inicial().toString();
				}
				if(parametroplanilla.getid_cuenta_contable_inicial()!=null)
				{
					strValorNuevo=parametroplanilla.getid_cuenta_contable_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(parametroplanilla.getIsNew()||!parametroplanilla.getid_cuenta_contable_final().equals(parametroplanilla.getParametroPlanillaOriginal().getid_cuenta_contable_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroplanilla.getParametroPlanillaOriginal().getid_cuenta_contable_final()!=null)
				{
					strValorActual=parametroplanilla.getParametroPlanillaOriginal().getid_cuenta_contable_final().toString();
				}
				if(parametroplanilla.getid_cuenta_contable_final()!=null)
				{
					strValorNuevo=parametroplanilla.getid_cuenta_contable_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroPlanillaConstantesFunciones.IDCUENTACONTABLEFINAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroPlanillaRelacionesWithConnection(ParametroPlanilla parametroplanilla) throws Exception {

		if(!parametroplanilla.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroPlanillaRelacionesBase(parametroplanilla,true);
		}
	}

	public void saveParametroPlanillaRelaciones(ParametroPlanilla parametroplanilla)throws Exception {

		if(!parametroplanilla.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroPlanillaRelacionesBase(parametroplanilla,false);
		}
	}

	public void saveParametroPlanillaRelacionesBase(ParametroPlanilla parametroplanilla,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroPlanilla-saveRelacionesWithConnection");}
	

			this.setParametroPlanilla(parametroplanilla);

			if(ParametroPlanillaLogicAdditional.validarSaveRelaciones(parametroplanilla,this)) {

				ParametroPlanillaLogicAdditional.updateRelacionesToSave(parametroplanilla,this);

				if((parametroplanilla.getIsNew()||parametroplanilla.getIsChanged())&&!parametroplanilla.getIsDeleted()) {
					this.saveParametroPlanilla();
					this.saveParametroPlanillaRelacionesDetalles();

				} else if(parametroplanilla.getIsDeleted()) {
					this.saveParametroPlanillaRelacionesDetalles();
					this.saveParametroPlanilla();
				}

				ParametroPlanillaLogicAdditional.updateRelacionesToSaveAfter(parametroplanilla,this);

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
	
	
	private void saveParametroPlanillaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroPlanilla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroPlanillaConstantesFunciones.getClassesForeignKeysOfParametroPlanilla(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroPlanilla(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroPlanillaConstantesFunciones.getClassesRelationshipsOfParametroPlanilla(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
