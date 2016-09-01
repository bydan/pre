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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.DiaFeriadoConstantesFunciones;
import com.bydan.erp.nomina.util.DiaFeriadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DiaFeriadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.DiaFeriado;
import com.bydan.erp.nomina.business.logic.DiaFeriadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DiaFeriadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DiaFeriadoLogic.class);
	
	protected DiaFeriadoDataAccess diaferiadoDataAccess; 	
	protected DiaFeriado diaferiado;
	protected List<DiaFeriado> diaferiados;
	protected Object diaferiadoObject;	
	protected List<Object> diaferiadosObject;
	
	public static ClassValidator<DiaFeriado> diaferiadoValidator = new ClassValidator<DiaFeriado>(DiaFeriado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DiaFeriadoLogicAdditional diaferiadoLogicAdditional=null;
	
	public DiaFeriadoLogicAdditional getDiaFeriadoLogicAdditional() {
		return this.diaferiadoLogicAdditional;
	}
	
	public void setDiaFeriadoLogicAdditional(DiaFeriadoLogicAdditional diaferiadoLogicAdditional) {
		try {
			this.diaferiadoLogicAdditional=diaferiadoLogicAdditional;
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
	
	
	
	
	public  DiaFeriadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.diaferiadoDataAccess = new DiaFeriadoDataAccess();
			
			this.diaferiados= new ArrayList<DiaFeriado>();
			this.diaferiado= new DiaFeriado();
			
			this.diaferiadoObject=new Object();
			this.diaferiadosObject=new ArrayList<Object>();
				
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
			
			this.diaferiadoDataAccess.setConnexionType(this.connexionType);
			this.diaferiadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DiaFeriadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.diaferiadoDataAccess = new DiaFeriadoDataAccess();
			this.diaferiados= new ArrayList<DiaFeriado>();
			this.diaferiado= new DiaFeriado();
			this.diaferiadoObject=new Object();
			this.diaferiadosObject=new ArrayList<Object>();
			
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
			
			this.diaferiadoDataAccess.setConnexionType(this.connexionType);
			this.diaferiadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DiaFeriado getDiaFeriado() throws Exception {	
		DiaFeriadoLogicAdditional.checkDiaFeriadoToGet(diaferiado,this.datosCliente,this.arrDatoGeneral);
		DiaFeriadoLogicAdditional.updateDiaFeriadoToGet(diaferiado,this.arrDatoGeneral);
		
		return diaferiado;
	}
		
	public void setDiaFeriado(DiaFeriado newDiaFeriado) {
		this.diaferiado = newDiaFeriado;
	}
	
	public DiaFeriadoDataAccess getDiaFeriadoDataAccess() {
		return diaferiadoDataAccess;
	}
	
	public void setDiaFeriadoDataAccess(DiaFeriadoDataAccess newdiaferiadoDataAccess) {
		this.diaferiadoDataAccess = newdiaferiadoDataAccess;
	}
	
	public List<DiaFeriado> getDiaFeriados() throws Exception {		
		this.quitarDiaFeriadosNulos();
		
		DiaFeriadoLogicAdditional.checkDiaFeriadoToGets(diaferiados,this.datosCliente,this.arrDatoGeneral);
		
		for (DiaFeriado diaferiadoLocal: diaferiados ) {
			DiaFeriadoLogicAdditional.updateDiaFeriadoToGet(diaferiadoLocal,this.arrDatoGeneral);
		}
		
		return diaferiados;
	}
	
	public void setDiaFeriados(List<DiaFeriado> newDiaFeriados) {
		this.diaferiados = newDiaFeriados;
	}
	
	public Object getDiaFeriadoObject() {	
		this.diaferiadoObject=this.diaferiadoDataAccess.getEntityObject();
		return this.diaferiadoObject;
	}
		
	public void setDiaFeriadoObject(Object newDiaFeriadoObject) {
		this.diaferiadoObject = newDiaFeriadoObject;
	}
	
	public List<Object> getDiaFeriadosObject() {		
		this.diaferiadosObject=this.diaferiadoDataAccess.getEntitiesObject();
		return this.diaferiadosObject;
	}
		
	public void setDiaFeriadosObject(List<Object> newDiaFeriadosObject) {
		this.diaferiadosObject = newDiaFeriadosObject;
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
		
		if(this.diaferiadoDataAccess!=null) {
			this.diaferiadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			diaferiadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			diaferiadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		diaferiado = new  DiaFeriado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			diaferiado=diaferiadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.diaferiado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiado);
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
		diaferiado = new  DiaFeriado();
		  		  
        try {
			
			diaferiado=diaferiadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.diaferiado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		diaferiado = new  DiaFeriado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			diaferiado=diaferiadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.diaferiado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiado);
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
		diaferiado = new  DiaFeriado();
		  		  
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
		diaferiado = new  DiaFeriado();
		  		  
        try {
			
			diaferiado=diaferiadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.diaferiado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		diaferiado = new  DiaFeriado();
		  		  
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
		diaferiado = new  DiaFeriado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =diaferiadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		diaferiado = new  DiaFeriado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=diaferiadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		diaferiado = new  DiaFeriado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =diaferiadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		diaferiado = new  DiaFeriado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=diaferiadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		diaferiado = new  DiaFeriado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =diaferiadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		diaferiado = new  DiaFeriado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=diaferiadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
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
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
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
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
        try {			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
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
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
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
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
        try {
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
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
		diaferiados = new  ArrayList<DiaFeriado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
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
		diaferiados = new  ArrayList<DiaFeriado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		diaferiado = new  DiaFeriado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiado=diaferiadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiado);
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
		diaferiado = new  DiaFeriado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiado=diaferiadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
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
		diaferiados = new  ArrayList<DiaFeriado>();
		  		  
        try {
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDiaFeriadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		diaferiados = new  ArrayList<DiaFeriado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getTodosDiaFeriadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
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
	
	public  void  getTodosDiaFeriados(String sFinalQuery,Pagination pagination)throws Exception {
		diaferiados = new  ArrayList<DiaFeriado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDiaFeriado(diaferiados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDiaFeriado(DiaFeriado diaferiado) throws Exception {
		Boolean estaValidado=false;
		
		if(diaferiado.getIsNew() || diaferiado.getIsChanged()) { 
			this.invalidValues = diaferiadoValidator.getInvalidValues(diaferiado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(diaferiado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDiaFeriado(List<DiaFeriado> DiaFeriados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DiaFeriado diaferiadoLocal:diaferiados) {				
			estaValidadoObjeto=this.validarGuardarDiaFeriado(diaferiadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDiaFeriado(List<DiaFeriado> DiaFeriados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDiaFeriado(diaferiados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDiaFeriado(DiaFeriado DiaFeriado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDiaFeriado(diaferiado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DiaFeriado diaferiado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+diaferiado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DiaFeriadoConstantesFunciones.getDiaFeriadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"diaferiado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DiaFeriadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DiaFeriadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDiaFeriadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-saveDiaFeriadoWithConnection");connexion.begin();			
			
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSave(this.diaferiado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DiaFeriadoLogicAdditional.updateDiaFeriadoToSave(this.diaferiado,this.arrDatoGeneral);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.diaferiado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDiaFeriado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDiaFeriado(this.diaferiado)) {
				DiaFeriadoDataAccess.save(this.diaferiado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.diaferiado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSaveAfter(this.diaferiado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDiaFeriado();
			
			connexion.commit();			
			
			if(this.diaferiado.getIsDeleted()) {
				this.diaferiado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDiaFeriado()throws Exception {	
		try {	
			
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSave(this.diaferiado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DiaFeriadoLogicAdditional.updateDiaFeriadoToSave(this.diaferiado,this.arrDatoGeneral);
			
			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.diaferiado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDiaFeriado(this.diaferiado)) {			
				DiaFeriadoDataAccess.save(this.diaferiado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.diaferiado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSaveAfter(this.diaferiado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.diaferiado.getIsDeleted()) {
				this.diaferiado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDiaFeriadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-saveDiaFeriadosWithConnection");connexion.begin();			
			
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSaves(diaferiados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDiaFeriados();
			
			Boolean validadoTodosDiaFeriado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DiaFeriado diaferiadoLocal:diaferiados) {		
				if(diaferiadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DiaFeriadoLogicAdditional.updateDiaFeriadoToSave(diaferiadoLocal,this.arrDatoGeneral);
	        	
				DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),diaferiadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDiaFeriado(diaferiadoLocal)) {
					DiaFeriadoDataAccess.save(diaferiadoLocal, connexion);				
				} else {
					validadoTodosDiaFeriado=false;
				}
			}
			
			if(!validadoTodosDiaFeriado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSavesAfter(diaferiados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDiaFeriados();
			
			connexion.commit();		
			
			this.quitarDiaFeriadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDiaFeriados()throws Exception {				
		 try {	
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSaves(diaferiados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDiaFeriado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DiaFeriado diaferiadoLocal:diaferiados) {				
				if(diaferiadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DiaFeriadoLogicAdditional.updateDiaFeriadoToSave(diaferiadoLocal,this.arrDatoGeneral);
	        	
				DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),diaferiadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDiaFeriado(diaferiadoLocal)) {				
					DiaFeriadoDataAccess.save(diaferiadoLocal, connexion);				
				} else {
					validadoTodosDiaFeriado=false;
				}
			}
			
			if(!validadoTodosDiaFeriado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DiaFeriadoLogicAdditional.checkDiaFeriadoToSavesAfter(diaferiados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDiaFeriadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DiaFeriadoParameterReturnGeneral procesarAccionDiaFeriados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiaFeriado> diaferiados,DiaFeriadoParameterReturnGeneral diaferiadoParameterGeneral)throws Exception {
		 try {	
			DiaFeriadoParameterReturnGeneral diaferiadoReturnGeneral=new DiaFeriadoParameterReturnGeneral();
	
			DiaFeriadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diaferiados,diaferiadoParameterGeneral,diaferiadoReturnGeneral);
			
			return diaferiadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DiaFeriadoParameterReturnGeneral procesarAccionDiaFeriadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DiaFeriado> diaferiados,DiaFeriadoParameterReturnGeneral diaferiadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-procesarAccionDiaFeriadosWithConnection");connexion.begin();			
			
			DiaFeriadoParameterReturnGeneral diaferiadoReturnGeneral=new DiaFeriadoParameterReturnGeneral();
	
			DiaFeriadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,diaferiados,diaferiadoParameterGeneral,diaferiadoReturnGeneral);
			
			this.connexion.commit();
			
			return diaferiadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DiaFeriadoParameterReturnGeneral procesarEventosDiaFeriados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DiaFeriado> diaferiados,DiaFeriado diaferiado,DiaFeriadoParameterReturnGeneral diaferiadoParameterGeneral,Boolean isEsNuevoDiaFeriado,ArrayList<Classe> clases)throws Exception {
		 try {	
			DiaFeriadoParameterReturnGeneral diaferiadoReturnGeneral=new DiaFeriadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				diaferiadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DiaFeriadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,diaferiados,diaferiado,diaferiadoParameterGeneral,diaferiadoReturnGeneral,isEsNuevoDiaFeriado,clases);
			
			return diaferiadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DiaFeriadoParameterReturnGeneral procesarEventosDiaFeriadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DiaFeriado> diaferiados,DiaFeriado diaferiado,DiaFeriadoParameterReturnGeneral diaferiadoParameterGeneral,Boolean isEsNuevoDiaFeriado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-procesarEventosDiaFeriadosWithConnection");connexion.begin();			
			
			DiaFeriadoParameterReturnGeneral diaferiadoReturnGeneral=new DiaFeriadoParameterReturnGeneral();
	
			diaferiadoReturnGeneral.setDiaFeriado(diaferiado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				diaferiadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DiaFeriadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,diaferiados,diaferiado,diaferiadoParameterGeneral,diaferiadoReturnGeneral,isEsNuevoDiaFeriado,clases);
			
			this.connexion.commit();
			
			return diaferiadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DiaFeriadoParameterReturnGeneral procesarImportacionDiaFeriadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DiaFeriadoParameterReturnGeneral diaferiadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-procesarImportacionDiaFeriadosWithConnection");connexion.begin();			
			
			DiaFeriadoParameterReturnGeneral diaferiadoReturnGeneral=new DiaFeriadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.diaferiados=new ArrayList<DiaFeriado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.diaferiado=new DiaFeriado();
				
				
				if(conColumnasBase) {this.diaferiado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.diaferiado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.diaferiado.setnombre(arrColumnas[iColumn++]);
				this.diaferiado.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.diaferiado.setdia(Integer.parseInt(arrColumnas[iColumn++]));
				this.diaferiado.setdescripcion(arrColumnas[iColumn++]);
				this.diaferiado.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.diaferiados.add(this.diaferiado);
			}
			
			this.saveDiaFeriados();
			
			this.connexion.commit();
			
			diaferiadoReturnGeneral.setConRetornoEstaProcesado(true);
			diaferiadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return diaferiadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDiaFeriadosEliminados() throws Exception {				
		
		List<DiaFeriado> diaferiadosAux= new ArrayList<DiaFeriado>();
		
		for(DiaFeriado diaferiado:diaferiados) {
			if(!diaferiado.getIsDeleted()) {
				diaferiadosAux.add(diaferiado);
			}
		}
		
		diaferiados=diaferiadosAux;
	}
	
	public void quitarDiaFeriadosNulos() throws Exception {				
		
		List<DiaFeriado> diaferiadosAux= new ArrayList<DiaFeriado>();
		
		for(DiaFeriado diaferiado : this.diaferiados) {
			if(diaferiado==null) {
				diaferiadosAux.add(diaferiado);
			}
		}
		
		//this.diaferiados=diaferiadosAux;
		
		this.diaferiados.removeAll(diaferiadosAux);
	}
	
	public void getSetVersionRowDiaFeriadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(diaferiado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((diaferiado.getIsDeleted() || (diaferiado.getIsChanged()&&!diaferiado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=diaferiadoDataAccess.getSetVersionRowDiaFeriado(connexion,diaferiado.getId());
				
				if(!diaferiado.getVersionRow().equals(timestamp)) {	
					diaferiado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				diaferiado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDiaFeriado()throws Exception {	
		
		if(diaferiado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((diaferiado.getIsDeleted() || (diaferiado.getIsChanged()&&!diaferiado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=diaferiadoDataAccess.getSetVersionRowDiaFeriado(connexion,diaferiado.getId());
			
			try {							
				if(!diaferiado.getVersionRow().equals(timestamp)) {	
					diaferiado.setVersionRow(timestamp);
				}
				
				diaferiado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDiaFeriadosWithConnection()throws Exception {	
		if(diaferiados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DiaFeriado diaferiadoAux:diaferiados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(diaferiadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(diaferiadoAux.getIsDeleted() || (diaferiadoAux.getIsChanged()&&!diaferiadoAux.getIsNew())) {
						
						timestamp=diaferiadoDataAccess.getSetVersionRowDiaFeriado(connexion,diaferiadoAux.getId());
						
						if(!diaferiado.getVersionRow().equals(timestamp)) {	
							diaferiadoAux.setVersionRow(timestamp);
						}
								
						diaferiadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDiaFeriados()throws Exception {	
		if(diaferiados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DiaFeriado diaferiadoAux:diaferiados) {
					if(diaferiadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(diaferiadoAux.getIsDeleted() || (diaferiadoAux.getIsChanged()&&!diaferiadoAux.getIsNew())) {
						
						timestamp=diaferiadoDataAccess.getSetVersionRowDiaFeriado(connexion,diaferiadoAux.getId());
						
						if(!diaferiadoAux.getVersionRow().equals(timestamp)) {	
							diaferiadoAux.setVersionRow(timestamp);
						}
						
													
						diaferiadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DiaFeriadoParameterReturnGeneral cargarCombosLoteForeignKeyDiaFeriadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalMes,String finalQueryGlobalAnio) throws Exception {
		DiaFeriadoParameterReturnGeneral  diaferiadoReturnGeneral =new DiaFeriadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-cargarCombosLoteForeignKeyDiaFeriadoWithConnection");connexion.begin();
			
			diaferiadoReturnGeneral =new DiaFeriadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			diaferiadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			diaferiadoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			diaferiadoReturnGeneral.setaniosForeignKey(aniosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return diaferiadoReturnGeneral;
	}
	
	public DiaFeriadoParameterReturnGeneral cargarCombosLoteForeignKeyDiaFeriado(String finalQueryGlobalEmpresa,String finalQueryGlobalMes,String finalQueryGlobalAnio) throws Exception {
		DiaFeriadoParameterReturnGeneral  diaferiadoReturnGeneral =new DiaFeriadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			diaferiadoReturnGeneral =new DiaFeriadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			diaferiadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			diaferiadoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			diaferiadoReturnGeneral.setaniosForeignKey(aniosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return diaferiadoReturnGeneral;
	}
	
	
	public void deepLoad(DiaFeriado diaferiado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DiaFeriadoLogicAdditional.updateDiaFeriadoToGet(diaferiado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diaferiado.setEmpresa(diaferiadoDataAccess.getEmpresa(connexion,diaferiado));
		diaferiado.setMes(diaferiadoDataAccess.getMes(connexion,diaferiado));
		diaferiado.setAnio(diaferiadoDataAccess.getAnio(connexion,diaferiado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				diaferiado.setEmpresa(diaferiadoDataAccess.getEmpresa(connexion,diaferiado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				diaferiado.setMes(diaferiadoDataAccess.getMes(connexion,diaferiado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				diaferiado.setAnio(diaferiadoDataAccess.getAnio(connexion,diaferiado));
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
			diaferiado.setEmpresa(diaferiadoDataAccess.getEmpresa(connexion,diaferiado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diaferiado.setMes(diaferiadoDataAccess.getMes(connexion,diaferiado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diaferiado.setAnio(diaferiadoDataAccess.getAnio(connexion,diaferiado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		diaferiado.setEmpresa(diaferiadoDataAccess.getEmpresa(connexion,diaferiado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(diaferiado.getEmpresa(),isDeep,deepLoadType,clases);
				
		diaferiado.setMes(diaferiadoDataAccess.getMes(connexion,diaferiado));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(diaferiado.getMes(),isDeep,deepLoadType,clases);
				
		diaferiado.setAnio(diaferiadoDataAccess.getAnio(connexion,diaferiado));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(diaferiado.getAnio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				diaferiado.setEmpresa(diaferiadoDataAccess.getEmpresa(connexion,diaferiado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(diaferiado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				diaferiado.setMes(diaferiadoDataAccess.getMes(connexion,diaferiado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(diaferiado.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				diaferiado.setAnio(diaferiadoDataAccess.getAnio(connexion,diaferiado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(diaferiado.getAnio(),isDeep,deepLoadType,clases);				
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
			diaferiado.setEmpresa(diaferiadoDataAccess.getEmpresa(connexion,diaferiado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(diaferiado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diaferiado.setMes(diaferiadoDataAccess.getMes(connexion,diaferiado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(diaferiado.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			diaferiado.setAnio(diaferiadoDataAccess.getAnio(connexion,diaferiado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(diaferiado.getAnio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DiaFeriado diaferiado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DiaFeriadoLogicAdditional.updateDiaFeriadoToSave(diaferiado,this.arrDatoGeneral);
			
DiaFeriadoDataAccess.save(diaferiado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(diaferiado.getEmpresa(),connexion);

		MesDataAccess.save(diaferiado.getMes(),connexion);

		AnioDataAccess.save(diaferiado.getAnio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(diaferiado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(diaferiado.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(diaferiado.getAnio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(diaferiado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(diaferiado.getEmpresa(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(diaferiado.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(diaferiado.getMes(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(diaferiado.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(diaferiado.getAnio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(diaferiado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(diaferiado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(diaferiado.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(diaferiado.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(diaferiado.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(diaferiado.getAnio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DiaFeriado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(diaferiado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(diaferiado);
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
			this.deepLoad(this.diaferiado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DiaFeriado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(diaferiados!=null) {
				for(DiaFeriado diaferiado:diaferiados) {
					this.deepLoad(diaferiado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(diaferiados);
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
			if(diaferiados!=null) {
				for(DiaFeriado diaferiado:diaferiados) {
					this.deepLoad(diaferiado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(diaferiados);
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
			this.getNewConnexionToDeep(DiaFeriado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(diaferiado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DiaFeriado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(diaferiados!=null) {
				for(DiaFeriado diaferiado:diaferiados) {
					this.deepSave(diaferiado,isDeep,deepLoadType,clases);
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
			if(diaferiados!=null) {
				for(DiaFeriado diaferiado:diaferiados) {
					this.deepSave(diaferiado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDiaFeriadosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DiaFeriadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDiaFeriadosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DiaFeriadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDiaFeriadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DiaFeriadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDiaFeriadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DiaFeriadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDiaFeriadosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DiaFeriado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DiaFeriadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDiaFeriadosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DiaFeriadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DiaFeriadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			diaferiados=diaferiadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DiaFeriadoConstantesFunciones.refrescarForeignKeysDescripcionesDiaFeriado(this.diaferiados);
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
			if(DiaFeriadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DiaFeriadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DiaFeriado diaferiado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DiaFeriadoConstantesFunciones.ISCONAUDITORIA) {
				if(diaferiado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DiaFeriadoDataAccess.TABLENAME, diaferiado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DiaFeriadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DiaFeriadoLogic.registrarAuditoriaDetallesDiaFeriado(connexion,diaferiado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(diaferiado.getIsDeleted()) {
					/*if(!diaferiado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DiaFeriadoDataAccess.TABLENAME, diaferiado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DiaFeriadoLogic.registrarAuditoriaDetallesDiaFeriado(connexion,diaferiado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DiaFeriadoDataAccess.TABLENAME, diaferiado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(diaferiado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DiaFeriadoDataAccess.TABLENAME, diaferiado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DiaFeriadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DiaFeriadoLogic.registrarAuditoriaDetallesDiaFeriado(connexion,diaferiado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDiaFeriado(Connexion connexion,DiaFeriado diaferiado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(diaferiado.getIsNew()||!diaferiado.getid_empresa().equals(diaferiado.getDiaFeriadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getid_empresa()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getid_empresa().toString();
				}
				if(diaferiado.getid_empresa()!=null)
				{
					strValorNuevo=diaferiado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(diaferiado.getIsNew()||!diaferiado.getnombre().equals(diaferiado.getDiaFeriadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getnombre()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getnombre();
				}
				if(diaferiado.getnombre()!=null)
				{
					strValorNuevo=diaferiado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(diaferiado.getIsNew()||!diaferiado.getfecha().equals(diaferiado.getDiaFeriadoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getfecha()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getfecha().toString();
				}
				if(diaferiado.getfecha()!=null)
				{
					strValorNuevo=diaferiado.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(diaferiado.getIsNew()||!diaferiado.getdia().equals(diaferiado.getDiaFeriadoOriginal().getdia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getdia()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getdia().toString();
				}
				if(diaferiado.getdia()!=null)
				{
					strValorNuevo=diaferiado.getdia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.DIA,strValorActual,strValorNuevo);
			}	
			
			if(diaferiado.getIsNew()||!diaferiado.getid_mes().equals(diaferiado.getDiaFeriadoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getid_mes()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getid_mes().toString();
				}
				if(diaferiado.getid_mes()!=null)
				{
					strValorNuevo=diaferiado.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(diaferiado.getIsNew()||!diaferiado.getid_anio().equals(diaferiado.getDiaFeriadoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getid_anio()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getid_anio().toString();
				}
				if(diaferiado.getid_anio()!=null)
				{
					strValorNuevo=diaferiado.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(diaferiado.getIsNew()||!diaferiado.getdescripcion().equals(diaferiado.getDiaFeriadoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getdescripcion()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getdescripcion();
				}
				if(diaferiado.getdescripcion()!=null)
				{
					strValorNuevo=diaferiado.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(diaferiado.getIsNew()||!diaferiado.getesta_activo().equals(diaferiado.getDiaFeriadoOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(diaferiado.getDiaFeriadoOriginal().getesta_activo()!=null)
				{
					strValorActual=diaferiado.getDiaFeriadoOriginal().getesta_activo().toString();
				}
				if(diaferiado.getesta_activo()!=null)
				{
					strValorNuevo=diaferiado.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DiaFeriadoConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDiaFeriadoRelacionesWithConnection(DiaFeriado diaferiado) throws Exception {

		if(!diaferiado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDiaFeriadoRelacionesBase(diaferiado,true);
		}
	}

	public void saveDiaFeriadoRelaciones(DiaFeriado diaferiado)throws Exception {

		if(!diaferiado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDiaFeriadoRelacionesBase(diaferiado,false);
		}
	}

	public void saveDiaFeriadoRelacionesBase(DiaFeriado diaferiado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DiaFeriado-saveRelacionesWithConnection");}
	

			this.setDiaFeriado(diaferiado);

			if(DiaFeriadoLogicAdditional.validarSaveRelaciones(diaferiado,this)) {

				DiaFeriadoLogicAdditional.updateRelacionesToSave(diaferiado,this);

				if((diaferiado.getIsNew()||diaferiado.getIsChanged())&&!diaferiado.getIsDeleted()) {
					this.saveDiaFeriado();
					this.saveDiaFeriadoRelacionesDetalles();

				} else if(diaferiado.getIsDeleted()) {
					this.saveDiaFeriadoRelacionesDetalles();
					this.saveDiaFeriado();
				}

				DiaFeriadoLogicAdditional.updateRelacionesToSaveAfter(diaferiado,this);

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
	
	
	private void saveDiaFeriadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDiaFeriado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DiaFeriadoConstantesFunciones.getClassesForeignKeysOfDiaFeriado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiaFeriado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DiaFeriadoConstantesFunciones.getClassesRelationshipsOfDiaFeriado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
