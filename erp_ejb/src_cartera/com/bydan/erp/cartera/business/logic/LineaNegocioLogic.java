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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.LineaNegocioConstantesFunciones;
import com.bydan.erp.cartera.util.LineaNegocioParameterReturnGeneral;
//import com.bydan.erp.cartera.util.LineaNegocioParameterGeneral;
import com.bydan.erp.cartera.business.entity.LineaNegocio;
//import com.bydan.erp.cartera.business.logic.LineaNegocioLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class LineaNegocioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LineaNegocioLogic.class);
	
	protected LineaNegocioDataAccess lineanegocioDataAccess; 	
	protected LineaNegocio lineanegocio;
	protected List<LineaNegocio> lineanegocios;
	protected Object lineanegocioObject;	
	protected List<Object> lineanegociosObject;
	
	public static ClassValidator<LineaNegocio> lineanegocioValidator = new ClassValidator<LineaNegocio>(LineaNegocio.class);	
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
	
	
	
	
	public  LineaNegocioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.lineanegocioDataAccess = new LineaNegocioDataAccess();
			
			this.lineanegocios= new ArrayList<LineaNegocio>();
			this.lineanegocio= new LineaNegocio();
			
			this.lineanegocioObject=new Object();
			this.lineanegociosObject=new ArrayList<Object>();
				
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
			
			this.lineanegocioDataAccess.setConnexionType(this.connexionType);
			this.lineanegocioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LineaNegocioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.lineanegocioDataAccess = new LineaNegocioDataAccess();
			this.lineanegocios= new ArrayList<LineaNegocio>();
			this.lineanegocio= new LineaNegocio();
			this.lineanegocioObject=new Object();
			this.lineanegociosObject=new ArrayList<Object>();
			
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
			
			this.lineanegocioDataAccess.setConnexionType(this.connexionType);
			this.lineanegocioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public LineaNegocio getLineaNegocio() throws Exception {	
		//LineaNegocioLogicAdditional.checkLineaNegocioToGet(lineanegocio,this.datosCliente,this.arrDatoGeneral);
		//LineaNegocioLogicAdditional.updateLineaNegocioToGet(lineanegocio,this.arrDatoGeneral);
		
		return lineanegocio;
	}
		
	public void setLineaNegocio(LineaNegocio newLineaNegocio) {
		this.lineanegocio = newLineaNegocio;
	}
	
	public LineaNegocioDataAccess getLineaNegocioDataAccess() {
		return lineanegocioDataAccess;
	}
	
	public void setLineaNegocioDataAccess(LineaNegocioDataAccess newlineanegocioDataAccess) {
		this.lineanegocioDataAccess = newlineanegocioDataAccess;
	}
	
	public List<LineaNegocio> getLineaNegocios() throws Exception {		
		this.quitarLineaNegociosNulos();
		
		//LineaNegocioLogicAdditional.checkLineaNegocioToGets(lineanegocios,this.datosCliente,this.arrDatoGeneral);
		
		for (LineaNegocio lineanegocioLocal: lineanegocios ) {
			//LineaNegocioLogicAdditional.updateLineaNegocioToGet(lineanegocioLocal,this.arrDatoGeneral);
		}
		
		return lineanegocios;
	}
	
	public void setLineaNegocios(List<LineaNegocio> newLineaNegocios) {
		this.lineanegocios = newLineaNegocios;
	}
	
	public Object getLineaNegocioObject() {	
		this.lineanegocioObject=this.lineanegocioDataAccess.getEntityObject();
		return this.lineanegocioObject;
	}
		
	public void setLineaNegocioObject(Object newLineaNegocioObject) {
		this.lineanegocioObject = newLineaNegocioObject;
	}
	
	public List<Object> getLineaNegociosObject() {		
		this.lineanegociosObject=this.lineanegocioDataAccess.getEntitiesObject();
		return this.lineanegociosObject;
	}
		
	public void setLineaNegociosObject(List<Object> newLineaNegociosObject) {
		this.lineanegociosObject = newLineaNegociosObject;
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
		
		if(this.lineanegocioDataAccess!=null) {
			this.lineanegocioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			lineanegocioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			lineanegocioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		lineanegocio = new  LineaNegocio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lineanegocio=lineanegocioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineanegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocio);
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
		lineanegocio = new  LineaNegocio();
		  		  
        try {
			
			lineanegocio=lineanegocioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineanegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		lineanegocio = new  LineaNegocio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lineanegocio=lineanegocioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineanegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocio);
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
		lineanegocio = new  LineaNegocio();
		  		  
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
		lineanegocio = new  LineaNegocio();
		  		  
        try {
			
			lineanegocio=lineanegocioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineanegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		lineanegocio = new  LineaNegocio();
		  		  
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
		lineanegocio = new  LineaNegocio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =lineanegocioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lineanegocio = new  LineaNegocio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=lineanegocioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineanegocio = new  LineaNegocio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =lineanegocioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lineanegocio = new  LineaNegocio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=lineanegocioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineanegocio = new  LineaNegocio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =lineanegocioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lineanegocio = new  LineaNegocio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=lineanegocioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineanegocios = new  ArrayList<LineaNegocio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
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
		lineanegocios = new  ArrayList<LineaNegocio>();
		  		  
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
		lineanegocios = new  ArrayList<LineaNegocio>();
		  		  
        try {			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		lineanegocios = new  ArrayList<LineaNegocio>();
		  		  
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
		lineanegocios = new  ArrayList<LineaNegocio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
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
		lineanegocios = new  ArrayList<LineaNegocio>();
		  		  
        try {
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
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
		lineanegocios = new  ArrayList<LineaNegocio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
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
		lineanegocios = new  ArrayList<LineaNegocio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		lineanegocio = new  LineaNegocio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocio=lineanegocioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaNegocio(lineanegocio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocio);
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
		lineanegocio = new  LineaNegocio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocio=lineanegocioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaNegocio(lineanegocio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosLineaNegociosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		lineanegocios = new  ArrayList<LineaNegocio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getTodosLineaNegociosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
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
	
	public  void  getTodosLineaNegocios(String sFinalQuery,Pagination pagination)throws Exception {
		lineanegocios = new  ArrayList<LineaNegocio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLineaNegocio(lineanegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLineaNegocio(LineaNegocio lineanegocio) throws Exception {
		Boolean estaValidado=false;
		
		if(lineanegocio.getIsNew() || lineanegocio.getIsChanged()) { 
			this.invalidValues = lineanegocioValidator.getInvalidValues(lineanegocio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(lineanegocio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLineaNegocio(List<LineaNegocio> LineaNegocios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(LineaNegocio lineanegocioLocal:lineanegocios) {				
			estaValidadoObjeto=this.validarGuardarLineaNegocio(lineanegocioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLineaNegocio(List<LineaNegocio> LineaNegocios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLineaNegocio(lineanegocios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLineaNegocio(LineaNegocio LineaNegocio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLineaNegocio(lineanegocio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(LineaNegocio lineanegocio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+lineanegocio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LineaNegocioConstantesFunciones.getLineaNegocioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"lineanegocio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LineaNegocioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LineaNegocioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLineaNegocioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-saveLineaNegocioWithConnection");connexion.begin();			
			
			//LineaNegocioLogicAdditional.checkLineaNegocioToSave(this.lineanegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//LineaNegocioLogicAdditional.updateLineaNegocioToSave(this.lineanegocio,this.arrDatoGeneral);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lineanegocio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLineaNegocio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLineaNegocio(this.lineanegocio)) {
				LineaNegocioDataAccess.save(this.lineanegocio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.lineanegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//LineaNegocioLogicAdditional.checkLineaNegocioToSaveAfter(this.lineanegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLineaNegocio();
			
			connexion.commit();			
			
			if(this.lineanegocio.getIsDeleted()) {
				this.lineanegocio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLineaNegocio()throws Exception {	
		try {	
			
			//LineaNegocioLogicAdditional.checkLineaNegocioToSave(this.lineanegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//LineaNegocioLogicAdditional.updateLineaNegocioToSave(this.lineanegocio,this.arrDatoGeneral);
			
			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lineanegocio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLineaNegocio(this.lineanegocio)) {			
				LineaNegocioDataAccess.save(this.lineanegocio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.lineanegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//LineaNegocioLogicAdditional.checkLineaNegocioToSaveAfter(this.lineanegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.lineanegocio.getIsDeleted()) {
				this.lineanegocio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLineaNegociosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-saveLineaNegociosWithConnection");connexion.begin();			
			
			//LineaNegocioLogicAdditional.checkLineaNegocioToSaves(lineanegocios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLineaNegocios();
			
			Boolean validadoTodosLineaNegocio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LineaNegocio lineanegocioLocal:lineanegocios) {		
				if(lineanegocioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//LineaNegocioLogicAdditional.updateLineaNegocioToSave(lineanegocioLocal,this.arrDatoGeneral);
	        	
				LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineanegocioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLineaNegocio(lineanegocioLocal)) {
					LineaNegocioDataAccess.save(lineanegocioLocal, connexion);				
				} else {
					validadoTodosLineaNegocio=false;
				}
			}
			
			if(!validadoTodosLineaNegocio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//LineaNegocioLogicAdditional.checkLineaNegocioToSavesAfter(lineanegocios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLineaNegocios();
			
			connexion.commit();		
			
			this.quitarLineaNegociosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLineaNegocios()throws Exception {				
		 try {	
			//LineaNegocioLogicAdditional.checkLineaNegocioToSaves(lineanegocios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLineaNegocio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LineaNegocio lineanegocioLocal:lineanegocios) {				
				if(lineanegocioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//LineaNegocioLogicAdditional.updateLineaNegocioToSave(lineanegocioLocal,this.arrDatoGeneral);
	        	
				LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineanegocioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLineaNegocio(lineanegocioLocal)) {				
					LineaNegocioDataAccess.save(lineanegocioLocal, connexion);				
				} else {
					validadoTodosLineaNegocio=false;
				}
			}
			
			if(!validadoTodosLineaNegocio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//LineaNegocioLogicAdditional.checkLineaNegocioToSavesAfter(lineanegocios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLineaNegociosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaNegocioParameterReturnGeneral procesarAccionLineaNegocios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LineaNegocio> lineanegocios,LineaNegocioParameterReturnGeneral lineanegocioParameterGeneral)throws Exception {
		 try {	
			LineaNegocioParameterReturnGeneral lineanegocioReturnGeneral=new LineaNegocioParameterReturnGeneral();
	
			
			return lineanegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaNegocioParameterReturnGeneral procesarAccionLineaNegociosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LineaNegocio> lineanegocios,LineaNegocioParameterReturnGeneral lineanegocioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-procesarAccionLineaNegociosWithConnection");connexion.begin();			
			
			LineaNegocioParameterReturnGeneral lineanegocioReturnGeneral=new LineaNegocioParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return lineanegocioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaNegocioParameterReturnGeneral procesarEventosLineaNegocios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LineaNegocio> lineanegocios,LineaNegocio lineanegocio,LineaNegocioParameterReturnGeneral lineanegocioParameterGeneral,Boolean isEsNuevoLineaNegocio,ArrayList<Classe> clases)throws Exception {
		 try {	
			LineaNegocioParameterReturnGeneral lineanegocioReturnGeneral=new LineaNegocioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineanegocioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return lineanegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LineaNegocioParameterReturnGeneral procesarEventosLineaNegociosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LineaNegocio> lineanegocios,LineaNegocio lineanegocio,LineaNegocioParameterReturnGeneral lineanegocioParameterGeneral,Boolean isEsNuevoLineaNegocio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-procesarEventosLineaNegociosWithConnection");connexion.begin();			
			
			LineaNegocioParameterReturnGeneral lineanegocioReturnGeneral=new LineaNegocioParameterReturnGeneral();
	
			lineanegocioReturnGeneral.setLineaNegocio(lineanegocio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineanegocioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return lineanegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaNegocioParameterReturnGeneral procesarImportacionLineaNegociosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LineaNegocioParameterReturnGeneral lineanegocioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-procesarImportacionLineaNegociosWithConnection");connexion.begin();			
			
			LineaNegocioParameterReturnGeneral lineanegocioReturnGeneral=new LineaNegocioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.lineanegocios=new ArrayList<LineaNegocio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.lineanegocio=new LineaNegocio();
				
				
				if(conColumnasBase) {this.lineanegocio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.lineanegocio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.lineanegocio.setcodigo(arrColumnas[iColumn++]);
				this.lineanegocio.setnombre(arrColumnas[iColumn++]);
				
				this.lineanegocios.add(this.lineanegocio);
			}
			
			this.saveLineaNegocios();
			
			this.connexion.commit();
			
			lineanegocioReturnGeneral.setConRetornoEstaProcesado(true);
			lineanegocioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return lineanegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLineaNegociosEliminados() throws Exception {				
		
		List<LineaNegocio> lineanegociosAux= new ArrayList<LineaNegocio>();
		
		for(LineaNegocio lineanegocio:lineanegocios) {
			if(!lineanegocio.getIsDeleted()) {
				lineanegociosAux.add(lineanegocio);
			}
		}
		
		lineanegocios=lineanegociosAux;
	}
	
	public void quitarLineaNegociosNulos() throws Exception {				
		
		List<LineaNegocio> lineanegociosAux= new ArrayList<LineaNegocio>();
		
		for(LineaNegocio lineanegocio : this.lineanegocios) {
			if(lineanegocio==null) {
				lineanegociosAux.add(lineanegocio);
			}
		}
		
		//this.lineanegocios=lineanegociosAux;
		
		this.lineanegocios.removeAll(lineanegociosAux);
	}
	
	public void getSetVersionRowLineaNegocioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(lineanegocio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((lineanegocio.getIsDeleted() || (lineanegocio.getIsChanged()&&!lineanegocio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=lineanegocioDataAccess.getSetVersionRowLineaNegocio(connexion,lineanegocio.getId());
				
				if(!lineanegocio.getVersionRow().equals(timestamp)) {	
					lineanegocio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				lineanegocio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLineaNegocio()throws Exception {	
		
		if(lineanegocio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((lineanegocio.getIsDeleted() || (lineanegocio.getIsChanged()&&!lineanegocio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=lineanegocioDataAccess.getSetVersionRowLineaNegocio(connexion,lineanegocio.getId());
			
			try {							
				if(!lineanegocio.getVersionRow().equals(timestamp)) {	
					lineanegocio.setVersionRow(timestamp);
				}
				
				lineanegocio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLineaNegociosWithConnection()throws Exception {	
		if(lineanegocios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(LineaNegocio lineanegocioAux:lineanegocios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(lineanegocioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineanegocioAux.getIsDeleted() || (lineanegocioAux.getIsChanged()&&!lineanegocioAux.getIsNew())) {
						
						timestamp=lineanegocioDataAccess.getSetVersionRowLineaNegocio(connexion,lineanegocioAux.getId());
						
						if(!lineanegocio.getVersionRow().equals(timestamp)) {	
							lineanegocioAux.setVersionRow(timestamp);
						}
								
						lineanegocioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowLineaNegocios()throws Exception {	
		if(lineanegocios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(LineaNegocio lineanegocioAux:lineanegocios) {
					if(lineanegocioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineanegocioAux.getIsDeleted() || (lineanegocioAux.getIsChanged()&&!lineanegocioAux.getIsNew())) {
						
						timestamp=lineanegocioDataAccess.getSetVersionRowLineaNegocio(connexion,lineanegocioAux.getId());
						
						if(!lineanegocioAux.getVersionRow().equals(timestamp)) {	
							lineanegocioAux.setVersionRow(timestamp);
						}
						
													
						lineanegocioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LineaNegocioParameterReturnGeneral cargarCombosLoteForeignKeyLineaNegocioWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		LineaNegocioParameterReturnGeneral  lineanegocioReturnGeneral =new LineaNegocioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-cargarCombosLoteForeignKeyLineaNegocioWithConnection");connexion.begin();
			
			lineanegocioReturnGeneral =new LineaNegocioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineanegocioReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return lineanegocioReturnGeneral;
	}
	
	public LineaNegocioParameterReturnGeneral cargarCombosLoteForeignKeyLineaNegocio(String finalQueryGlobalEmpresa) throws Exception {
		LineaNegocioParameterReturnGeneral  lineanegocioReturnGeneral =new LineaNegocioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			lineanegocioReturnGeneral =new LineaNegocioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineanegocioReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return lineanegocioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyLineaNegocioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PoliticasClienteLogic politicasclienteLogic=new PoliticasClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyLineaNegocioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PoliticasCliente.class));
											
			

			politicasclienteLogic.setConnexion(this.getConnexion());
			politicasclienteLogic.setDatosCliente(this.datosCliente);
			politicasclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(LineaNegocio lineanegocio:this.lineanegocios) {
				

				classes=new ArrayList<Classe>();
				classes=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicasclienteLogic.setPoliticasClientes(lineanegocio.politicasclientes);
				politicasclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(LineaNegocio lineanegocio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//LineaNegocioLogicAdditional.updateLineaNegocioToGet(lineanegocio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lineanegocio.setEmpresa(lineanegocioDataAccess.getEmpresa(connexion,lineanegocio));
		lineanegocio.setPoliticasClientes(lineanegocioDataAccess.getPoliticasClientes(connexion,lineanegocio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				lineanegocio.setEmpresa(lineanegocioDataAccess.getEmpresa(connexion,lineanegocio));
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				lineanegocio.setPoliticasClientes(lineanegocioDataAccess.getPoliticasClientes(connexion,lineanegocio));

				if(this.isConDeep) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(this.connexion);
					politicasclienteLogic.setPoliticasClientes(lineanegocio.getPoliticasClientes());
					ArrayList<Classe> classesLocal=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicasclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclienteLogic.getPoliticasClientes());
					lineanegocio.setPoliticasClientes(politicasclienteLogic.getPoliticasClientes());
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
			lineanegocio.setEmpresa(lineanegocioDataAccess.getEmpresa(connexion,lineanegocio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			lineanegocio.setPoliticasClientes(lineanegocioDataAccess.getPoliticasClientes(connexion,lineanegocio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lineanegocio.setEmpresa(lineanegocioDataAccess.getEmpresa(connexion,lineanegocio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(lineanegocio.getEmpresa(),isDeep,deepLoadType,clases);
				

		lineanegocio.setPoliticasClientes(lineanegocioDataAccess.getPoliticasClientes(connexion,lineanegocio));

		for(PoliticasCliente politicascliente:lineanegocio.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				lineanegocio.setEmpresa(lineanegocioDataAccess.getEmpresa(connexion,lineanegocio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(lineanegocio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				lineanegocio.setPoliticasClientes(lineanegocioDataAccess.getPoliticasClientes(connexion,lineanegocio));

				for(PoliticasCliente politicascliente:lineanegocio.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
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
			lineanegocio.setEmpresa(lineanegocioDataAccess.getEmpresa(connexion,lineanegocio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(lineanegocio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			lineanegocio.setPoliticasClientes(lineanegocioDataAccess.getPoliticasClientes(connexion,lineanegocio));

			for(PoliticasCliente politicascliente:lineanegocio.getPoliticasClientes()) {
				PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
				politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(LineaNegocio lineanegocio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LineaNegocio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(lineanegocio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(lineanegocio);
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
			this.deepLoad(this.lineanegocio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LineaNegocio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(lineanegocios!=null) {
				for(LineaNegocio lineanegocio:lineanegocios) {
					this.deepLoad(lineanegocio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(lineanegocios);
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
			if(lineanegocios!=null) {
				for(LineaNegocio lineanegocio:lineanegocios) {
					this.deepLoad(lineanegocio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(lineanegocios);
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
	
	
	public void getLineaNegociosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LineaNegocioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaNegociosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LineaNegocioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaNegociosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LineaNegocioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaNegociosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LineaNegocioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaNegociosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaNegocio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaNegocioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaNegociosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaNegocioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineanegocios=lineanegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaNegocioConstantesFunciones.refrescarForeignKeysDescripcionesLineaNegocio(this.lineanegocios);
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
			if(LineaNegocioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaNegocioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,LineaNegocio lineanegocio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LineaNegocioConstantesFunciones.ISCONAUDITORIA) {
				if(lineanegocio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaNegocioDataAccess.TABLENAME, lineanegocio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaNegocioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaNegocioLogic.registrarAuditoriaDetallesLineaNegocio(connexion,lineanegocio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(lineanegocio.getIsDeleted()) {
					/*if(!lineanegocio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LineaNegocioDataAccess.TABLENAME, lineanegocio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LineaNegocioLogic.registrarAuditoriaDetallesLineaNegocio(connexion,lineanegocio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaNegocioDataAccess.TABLENAME, lineanegocio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(lineanegocio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaNegocioDataAccess.TABLENAME, lineanegocio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaNegocioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaNegocioLogic.registrarAuditoriaDetallesLineaNegocio(connexion,lineanegocio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLineaNegocio(Connexion connexion,LineaNegocio lineanegocio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(lineanegocio.getIsNew()||!lineanegocio.getid_empresa().equals(lineanegocio.getLineaNegocioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineanegocio.getLineaNegocioOriginal().getid_empresa()!=null)
				{
					strValorActual=lineanegocio.getLineaNegocioOriginal().getid_empresa().toString();
				}
				if(lineanegocio.getid_empresa()!=null)
				{
					strValorNuevo=lineanegocio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaNegocioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(lineanegocio.getIsNew()||!lineanegocio.getcodigo().equals(lineanegocio.getLineaNegocioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineanegocio.getLineaNegocioOriginal().getcodigo()!=null)
				{
					strValorActual=lineanegocio.getLineaNegocioOriginal().getcodigo();
				}
				if(lineanegocio.getcodigo()!=null)
				{
					strValorNuevo=lineanegocio.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaNegocioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(lineanegocio.getIsNew()||!lineanegocio.getnombre().equals(lineanegocio.getLineaNegocioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineanegocio.getLineaNegocioOriginal().getnombre()!=null)
				{
					strValorActual=lineanegocio.getLineaNegocioOriginal().getnombre();
				}
				if(lineanegocio.getnombre()!=null)
				{
					strValorNuevo=lineanegocio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaNegocioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLineaNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaNegocioConstantesFunciones.getClassesForeignKeysOfLineaNegocio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaNegocioConstantesFunciones.getClassesRelationshipsOfLineaNegocio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
