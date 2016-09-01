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
import com.bydan.erp.nomina.util.DatoGeneralEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.DatoGeneralEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DatoGeneralEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.DatoGeneralEmpleado;
import com.bydan.erp.nomina.business.logic.DatoGeneralEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class DatoGeneralEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DatoGeneralEmpleadoLogic.class);
	
	protected DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess; 	
	protected DatoGeneralEmpleado datogeneralempleado;
	protected List<DatoGeneralEmpleado> datogeneralempleados;
	protected Object datogeneralempleadoObject;	
	protected List<Object> datogeneralempleadosObject;
	
	public static ClassValidator<DatoGeneralEmpleado> datogeneralempleadoValidator = new ClassValidator<DatoGeneralEmpleado>(DatoGeneralEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DatoGeneralEmpleadoLogicAdditional datogeneralempleadoLogicAdditional=null;
	
	public DatoGeneralEmpleadoLogicAdditional getDatoGeneralEmpleadoLogicAdditional() {
		return this.datogeneralempleadoLogicAdditional;
	}
	
	public void setDatoGeneralEmpleadoLogicAdditional(DatoGeneralEmpleadoLogicAdditional datogeneralempleadoLogicAdditional) {
		try {
			this.datogeneralempleadoLogicAdditional=datogeneralempleadoLogicAdditional;
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
	
	
	
	
	public  DatoGeneralEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.datogeneralempleadoDataAccess = new DatoGeneralEmpleadoDataAccess();
			
			this.datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();
			this.datogeneralempleado= new DatoGeneralEmpleado();
			
			this.datogeneralempleadoObject=new Object();
			this.datogeneralempleadosObject=new ArrayList<Object>();
				
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
			
			this.datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			this.datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DatoGeneralEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.datogeneralempleadoDataAccess = new DatoGeneralEmpleadoDataAccess();
			this.datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();
			this.datogeneralempleado= new DatoGeneralEmpleado();
			this.datogeneralempleadoObject=new Object();
			this.datogeneralempleadosObject=new ArrayList<Object>();
			
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
			
			this.datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			this.datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DatoGeneralEmpleado getDatoGeneralEmpleado() throws Exception {	
		DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToGet(datogeneralempleado,this.datosCliente,this.arrDatoGeneral);
		DatoGeneralEmpleadoLogicAdditional.updateDatoGeneralEmpleadoToGet(datogeneralempleado,this.arrDatoGeneral);
		
		return datogeneralempleado;
	}
		
	public void setDatoGeneralEmpleado(DatoGeneralEmpleado newDatoGeneralEmpleado) {
		this.datogeneralempleado = newDatoGeneralEmpleado;
	}
	
	public DatoGeneralEmpleadoDataAccess getDatoGeneralEmpleadoDataAccess() {
		return datogeneralempleadoDataAccess;
	}
	
	public void setDatoGeneralEmpleadoDataAccess(DatoGeneralEmpleadoDataAccess newdatogeneralempleadoDataAccess) {
		this.datogeneralempleadoDataAccess = newdatogeneralempleadoDataAccess;
	}
	
	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() throws Exception {		
		this.quitarDatoGeneralEmpleadosNulos();
		
		DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToGets(datogeneralempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (DatoGeneralEmpleado datogeneralempleadoLocal: datogeneralempleados ) {
			DatoGeneralEmpleadoLogicAdditional.updateDatoGeneralEmpleadoToGet(datogeneralempleadoLocal,this.arrDatoGeneral);
		}
		
		return datogeneralempleados;
	}
	
	public void setDatoGeneralEmpleados(List<DatoGeneralEmpleado> newDatoGeneralEmpleados) {
		this.datogeneralempleados = newDatoGeneralEmpleados;
	}
	
	public Object getDatoGeneralEmpleadoObject() {	
		this.datogeneralempleadoObject=this.datogeneralempleadoDataAccess.getEntityObject();
		return this.datogeneralempleadoObject;
	}
		
	public void setDatoGeneralEmpleadoObject(Object newDatoGeneralEmpleadoObject) {
		this.datogeneralempleadoObject = newDatoGeneralEmpleadoObject;
	}
	
	public List<Object> getDatoGeneralEmpleadosObject() {		
		this.datogeneralempleadosObject=this.datogeneralempleadoDataAccess.getEntitiesObject();
		return this.datogeneralempleadosObject;
	}
		
	public void setDatoGeneralEmpleadosObject(List<Object> newDatoGeneralEmpleadosObject) {
		this.datogeneralempleadosObject = newDatoGeneralEmpleadosObject;
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
		
		if(this.datogeneralempleadoDataAccess!=null) {
			this.datogeneralempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			datogeneralempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			datogeneralempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		datogeneralempleado = new  DatoGeneralEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datogeneralempleado=datogeneralempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleado);
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		  		  
        try {
			
			datogeneralempleado=datogeneralempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		datogeneralempleado = new  DatoGeneralEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datogeneralempleado=datogeneralempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleado);
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		  		  
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		  		  
        try {
			
			datogeneralempleado=datogeneralempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		datogeneralempleado = new  DatoGeneralEmpleado();
		  		  
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =datogeneralempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=datogeneralempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datogeneralempleado = new  DatoGeneralEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =datogeneralempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=datogeneralempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datogeneralempleado = new  DatoGeneralEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =datogeneralempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=datogeneralempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
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
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		  		  
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
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		  		  
        try {			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		  		  
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
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
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
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		  		  
        try {
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
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
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
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
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		datogeneralempleado = new  DatoGeneralEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleado=datogeneralempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleado);
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
		datogeneralempleado = new  DatoGeneralEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleado=datogeneralempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosDatoGeneralEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getTodosDatoGeneralEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
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
	
	public  void  getTodosDatoGeneralEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		datogeneralempleados = new  ArrayList<DatoGeneralEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoGeneralEmpleado(datogeneralempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(datogeneralempleado.getIsNew() || datogeneralempleado.getIsChanged()) { 
			this.invalidValues = datogeneralempleadoValidator.getInvalidValues(datogeneralempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(datogeneralempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDatoGeneralEmpleado(List<DatoGeneralEmpleado> DatoGeneralEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DatoGeneralEmpleado datogeneralempleadoLocal:datogeneralempleados) {				
			estaValidadoObjeto=this.validarGuardarDatoGeneralEmpleado(datogeneralempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDatoGeneralEmpleado(List<DatoGeneralEmpleado> DatoGeneralEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoGeneralEmpleado(datogeneralempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDatoGeneralEmpleado(DatoGeneralEmpleado DatoGeneralEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoGeneralEmpleado(datogeneralempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+datogeneralempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DatoGeneralEmpleadoConstantesFunciones.getDatoGeneralEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"datogeneralempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DatoGeneralEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DatoGeneralEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDatoGeneralEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-saveDatoGeneralEmpleadoWithConnection");connexion.begin();			
			
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSave(this.datogeneralempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoGeneralEmpleadoLogicAdditional.updateDatoGeneralEmpleadoToSave(this.datogeneralempleado,this.arrDatoGeneral);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datogeneralempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDatoGeneralEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoGeneralEmpleado(this.datogeneralempleado)) {
				DatoGeneralEmpleadoDataAccess.save(this.datogeneralempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.datogeneralempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSaveAfter(this.datogeneralempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoGeneralEmpleado();
			
			connexion.commit();			
			
			if(this.datogeneralempleado.getIsDeleted()) {
				this.datogeneralempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDatoGeneralEmpleado()throws Exception {	
		try {	
			
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSave(this.datogeneralempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoGeneralEmpleadoLogicAdditional.updateDatoGeneralEmpleadoToSave(this.datogeneralempleado,this.arrDatoGeneral);
			
			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datogeneralempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoGeneralEmpleado(this.datogeneralempleado)) {			
				DatoGeneralEmpleadoDataAccess.save(this.datogeneralempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.datogeneralempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSaveAfter(this.datogeneralempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.datogeneralempleado.getIsDeleted()) {
				this.datogeneralempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDatoGeneralEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-saveDatoGeneralEmpleadosWithConnection");connexion.begin();			
			
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSaves(datogeneralempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDatoGeneralEmpleados();
			
			Boolean validadoTodosDatoGeneralEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoGeneralEmpleado datogeneralempleadoLocal:datogeneralempleados) {		
				if(datogeneralempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoGeneralEmpleadoLogicAdditional.updateDatoGeneralEmpleadoToSave(datogeneralempleadoLocal,this.arrDatoGeneral);
	        	
				DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datogeneralempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoGeneralEmpleado(datogeneralempleadoLocal)) {
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleadoLocal, connexion);				
				} else {
					validadoTodosDatoGeneralEmpleado=false;
				}
			}
			
			if(!validadoTodosDatoGeneralEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSavesAfter(datogeneralempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoGeneralEmpleados();
			
			connexion.commit();		
			
			this.quitarDatoGeneralEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDatoGeneralEmpleados()throws Exception {				
		 try {	
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSaves(datogeneralempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDatoGeneralEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoGeneralEmpleado datogeneralempleadoLocal:datogeneralempleados) {				
				if(datogeneralempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoGeneralEmpleadoLogicAdditional.updateDatoGeneralEmpleadoToSave(datogeneralempleadoLocal,this.arrDatoGeneral);
	        	
				DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datogeneralempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoGeneralEmpleado(datogeneralempleadoLocal)) {				
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleadoLocal, connexion);				
				} else {
					validadoTodosDatoGeneralEmpleado=false;
				}
			}
			
			if(!validadoTodosDatoGeneralEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoGeneralEmpleadoLogicAdditional.checkDatoGeneralEmpleadoToSavesAfter(datogeneralempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDatoGeneralEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoGeneralEmpleadoParameterReturnGeneral procesarAccionDatoGeneralEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoGeneralEmpleado> datogeneralempleados,DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoParameterGeneral)throws Exception {
		 try {	
			DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoReturnGeneral=new DatoGeneralEmpleadoParameterReturnGeneral();
	
			DatoGeneralEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datogeneralempleados,datogeneralempleadoParameterGeneral,datogeneralempleadoReturnGeneral);
			
			return datogeneralempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoGeneralEmpleadoParameterReturnGeneral procesarAccionDatoGeneralEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoGeneralEmpleado> datogeneralempleados,DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-procesarAccionDatoGeneralEmpleadosWithConnection");connexion.begin();			
			
			DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoReturnGeneral=new DatoGeneralEmpleadoParameterReturnGeneral();
	
			DatoGeneralEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datogeneralempleados,datogeneralempleadoParameterGeneral,datogeneralempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return datogeneralempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoGeneralEmpleadoParameterReturnGeneral procesarEventosDatoGeneralEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoGeneralEmpleado> datogeneralempleados,DatoGeneralEmpleado datogeneralempleado,DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoParameterGeneral,Boolean isEsNuevoDatoGeneralEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoReturnGeneral=new DatoGeneralEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datogeneralempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoGeneralEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datogeneralempleados,datogeneralempleado,datogeneralempleadoParameterGeneral,datogeneralempleadoReturnGeneral,isEsNuevoDatoGeneralEmpleado,clases);
			
			return datogeneralempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DatoGeneralEmpleadoParameterReturnGeneral procesarEventosDatoGeneralEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoGeneralEmpleado> datogeneralempleados,DatoGeneralEmpleado datogeneralempleado,DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoParameterGeneral,Boolean isEsNuevoDatoGeneralEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-procesarEventosDatoGeneralEmpleadosWithConnection");connexion.begin();			
			
			DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoReturnGeneral=new DatoGeneralEmpleadoParameterReturnGeneral();
	
			datogeneralempleadoReturnGeneral.setDatoGeneralEmpleado(datogeneralempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datogeneralempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoGeneralEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datogeneralempleados,datogeneralempleado,datogeneralempleadoParameterGeneral,datogeneralempleadoReturnGeneral,isEsNuevoDatoGeneralEmpleado,clases);
			
			this.connexion.commit();
			
			return datogeneralempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoGeneralEmpleadoParameterReturnGeneral procesarImportacionDatoGeneralEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-procesarImportacionDatoGeneralEmpleadosWithConnection");connexion.begin();			
			
			DatoGeneralEmpleadoParameterReturnGeneral datogeneralempleadoReturnGeneral=new DatoGeneralEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.datogeneralempleados=new ArrayList<DatoGeneralEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.datogeneralempleado=new DatoGeneralEmpleado();
				
				
				if(conColumnasBase) {this.datogeneralempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.datogeneralempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.datogeneralempleado.setcarnet_iess(arrColumnas[iColumn++]);
				this.datogeneralempleado.setsectorial_iess(arrColumnas[iColumn++]);
				this.datogeneralempleado.setfecha_nacimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.datogeneralempleado.setfecha_fallece(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.datogeneralempleado.setvalor_evaluacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setnumero_horas(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setvalor_hora(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setsalario(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setnumero_contrato(arrColumnas[iColumn++]);
				this.datogeneralempleado.setvalor1(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setvalor2(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setvalor3(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setvalor4(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setvalor5(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setvalor6(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setcon_aporta_seguro_social(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datogeneralempleado.setcon_recibe_horas_extras(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datogeneralempleado.setcon_descuento_impuestos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datogeneralempleado.setpension_alimenticia(Double.parseDouble(arrColumnas[iColumn++]));
				this.datogeneralempleado.setcon_pago_por_horas(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datogeneralempleado.setcon_anticipo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datogeneralempleado.setlibreta_militar(arrColumnas[iColumn++]);
				this.datogeneralempleado.setnumero_cuenta(arrColumnas[iColumn++]);
				
				this.datogeneralempleados.add(this.datogeneralempleado);
			}
			
			this.saveDatoGeneralEmpleados();
			
			this.connexion.commit();
			
			datogeneralempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			datogeneralempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return datogeneralempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDatoGeneralEmpleadosEliminados() throws Exception {				
		
		List<DatoGeneralEmpleado> datogeneralempleadosAux= new ArrayList<DatoGeneralEmpleado>();
		
		for(DatoGeneralEmpleado datogeneralempleado:datogeneralempleados) {
			if(!datogeneralempleado.getIsDeleted()) {
				datogeneralempleadosAux.add(datogeneralempleado);
			}
		}
		
		datogeneralempleados=datogeneralempleadosAux;
	}
	
	public void quitarDatoGeneralEmpleadosNulos() throws Exception {				
		
		List<DatoGeneralEmpleado> datogeneralempleadosAux= new ArrayList<DatoGeneralEmpleado>();
		
		for(DatoGeneralEmpleado datogeneralempleado : this.datogeneralempleados) {
			if(datogeneralempleado==null) {
				datogeneralempleadosAux.add(datogeneralempleado);
			}
		}
		
		//this.datogeneralempleados=datogeneralempleadosAux;
		
		this.datogeneralempleados.removeAll(datogeneralempleadosAux);
	}
	
	public void getSetVersionRowDatoGeneralEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(datogeneralempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((datogeneralempleado.getIsDeleted() || (datogeneralempleado.getIsChanged()&&!datogeneralempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=datogeneralempleadoDataAccess.getSetVersionRowDatoGeneralEmpleado(connexion,datogeneralempleado.getId());
				
				if(!datogeneralempleado.getVersionRow().equals(timestamp)) {	
					datogeneralempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				datogeneralempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDatoGeneralEmpleado()throws Exception {	
		
		if(datogeneralempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((datogeneralempleado.getIsDeleted() || (datogeneralempleado.getIsChanged()&&!datogeneralempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=datogeneralempleadoDataAccess.getSetVersionRowDatoGeneralEmpleado(connexion,datogeneralempleado.getId());
			
			try {							
				if(!datogeneralempleado.getVersionRow().equals(timestamp)) {	
					datogeneralempleado.setVersionRow(timestamp);
				}
				
				datogeneralempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDatoGeneralEmpleadosWithConnection()throws Exception {	
		if(datogeneralempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DatoGeneralEmpleado datogeneralempleadoAux:datogeneralempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(datogeneralempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datogeneralempleadoAux.getIsDeleted() || (datogeneralempleadoAux.getIsChanged()&&!datogeneralempleadoAux.getIsNew())) {
						
						timestamp=datogeneralempleadoDataAccess.getSetVersionRowDatoGeneralEmpleado(connexion,datogeneralempleadoAux.getId());
						
						if(!datogeneralempleado.getVersionRow().equals(timestamp)) {	
							datogeneralempleadoAux.setVersionRow(timestamp);
						}
								
						datogeneralempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDatoGeneralEmpleados()throws Exception {	
		if(datogeneralempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DatoGeneralEmpleado datogeneralempleadoAux:datogeneralempleados) {
					if(datogeneralempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datogeneralempleadoAux.getIsDeleted() || (datogeneralempleadoAux.getIsChanged()&&!datogeneralempleadoAux.getIsNew())) {
						
						timestamp=datogeneralempleadoDataAccess.getSetVersionRowDatoGeneralEmpleado(connexion,datogeneralempleadoAux.getId());
						
						if(!datogeneralempleadoAux.getVersionRow().equals(timestamp)) {	
							datogeneralempleadoAux.setVersionRow(timestamp);
						}
						
													
						datogeneralempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DatoGeneralEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyDatoGeneralEmpleadoWithConnection(String finalQueryGlobalEmpleado,String finalQueryGlobalNumeroPatronal,String finalQueryGlobalTipoAfiliacion,String finalQueryGlobalPais,String finalQueryGlobalProvincia,String finalQueryGlobalCanton,String finalQueryGlobalParroquia,String finalQueryGlobalMoneda,String finalQueryGlobalTipoContrato,String finalQueryGlobalTipoLibretaMili,String finalQueryGlobalTipoGrupoFormaPago,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal,String finalQueryGlobalTipoSangre) throws Exception {
		DatoGeneralEmpleadoParameterReturnGeneral  datogeneralempleadoReturnGeneral =new DatoGeneralEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyDatoGeneralEmpleadoWithConnection");connexion.begin();
			
			datogeneralempleadoReturnGeneral =new DatoGeneralEmpleadoParameterReturnGeneral();
			
			

			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			datogeneralempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<NumeroPatronal> numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
			NumeroPatronalLogic numeropatronalLogic=new NumeroPatronalLogic();
			numeropatronalLogic.setConnexion(this.connexion);
			numeropatronalLogic.getNumeroPatronalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNumeroPatronal.equals("NONE")) {
				numeropatronalLogic.getTodosNumeroPatronals(finalQueryGlobalNumeroPatronal,new Pagination());
				numeropatronalsForeignKey=numeropatronalLogic.getNumeroPatronals();
			}

			datogeneralempleadoReturnGeneral.setnumeropatronalsForeignKey(numeropatronalsForeignKey);


			List<TipoAfiliacion> tipoafiliacionsForeignKey=new ArrayList<TipoAfiliacion>();
			TipoAfiliacionLogic tipoafiliacionLogic=new TipoAfiliacionLogic();
			tipoafiliacionLogic.setConnexion(this.connexion);
			tipoafiliacionLogic.getTipoAfiliacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAfiliacion.equals("NONE")) {
				tipoafiliacionLogic.getTodosTipoAfiliacions(finalQueryGlobalTipoAfiliacion,new Pagination());
				tipoafiliacionsForeignKey=tipoafiliacionLogic.getTipoAfiliacions();
			}

			datogeneralempleadoReturnGeneral.settipoafiliacionsForeignKey(tipoafiliacionsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			datogeneralempleadoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			datogeneralempleadoReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			datogeneralempleadoReturnGeneral.setcantonsForeignKey(cantonsForeignKey);


			List<Parroquia> parroquiasForeignKey=new ArrayList<Parroquia>();
			ParroquiaLogic parroquiaLogic=new ParroquiaLogic();
			parroquiaLogic.setConnexion(this.connexion);
			parroquiaLogic.getParroquiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParroquia.equals("NONE")) {
				parroquiaLogic.getTodosParroquias(finalQueryGlobalParroquia,new Pagination());
				parroquiasForeignKey=parroquiaLogic.getParroquias();
			}

			datogeneralempleadoReturnGeneral.setparroquiasForeignKey(parroquiasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			datogeneralempleadoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoContrato> tipocontratosForeignKey=new ArrayList<TipoContrato>();
			TipoContratoLogic tipocontratoLogic=new TipoContratoLogic();
			tipocontratoLogic.setConnexion(this.connexion);
			tipocontratoLogic.getTipoContratoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoContrato.equals("NONE")) {
				tipocontratoLogic.getTodosTipoContratos(finalQueryGlobalTipoContrato,new Pagination());
				tipocontratosForeignKey=tipocontratoLogic.getTipoContratos();
			}

			datogeneralempleadoReturnGeneral.settipocontratosForeignKey(tipocontratosForeignKey);


			List<TipoLibretaMili> tipolibretamilisForeignKey=new ArrayList<TipoLibretaMili>();
			TipoLibretaMiliLogic tipolibretamiliLogic=new TipoLibretaMiliLogic();
			tipolibretamiliLogic.setConnexion(this.connexion);
			tipolibretamiliLogic.getTipoLibretaMiliDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLibretaMili.equals("NONE")) {
				tipolibretamiliLogic.getTodosTipoLibretaMilis(finalQueryGlobalTipoLibretaMili,new Pagination());
				tipolibretamilisForeignKey=tipolibretamiliLogic.getTipoLibretaMilis();
			}

			datogeneralempleadoReturnGeneral.settipolibretamilisForeignKey(tipolibretamilisForeignKey);


			List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic=new TipoGrupoFormaPagoLogic();
			tipogrupoformapagoLogic.setConnexion(this.connexion);
			tipogrupoformapagoLogic.getTipoGrupoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFormaPago.equals("NONE")) {
				tipogrupoformapagoLogic.getTodosTipoGrupoFormaPagos(finalQueryGlobalTipoGrupoFormaPago,new Pagination());
				tipogrupoformapagosForeignKey=tipogrupoformapagoLogic.getTipoGrupoFormaPagos();
			}

			datogeneralempleadoReturnGeneral.settipogrupoformapagosForeignKey(tipogrupoformapagosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			datogeneralempleadoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			datogeneralempleadoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);


			List<TipoSangre> tiposangresForeignKey=new ArrayList<TipoSangre>();
			TipoSangreLogic tiposangreLogic=new TipoSangreLogic();
			tiposangreLogic.setConnexion(this.connexion);
			tiposangreLogic.getTipoSangreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoSangre.equals("NONE")) {
				tiposangreLogic.getTodosTipoSangres(finalQueryGlobalTipoSangre,new Pagination());
				tiposangresForeignKey=tiposangreLogic.getTipoSangres();
			}

			datogeneralempleadoReturnGeneral.settiposangresForeignKey(tiposangresForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return datogeneralempleadoReturnGeneral;
	}
	
	public DatoGeneralEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyDatoGeneralEmpleado(String finalQueryGlobalEmpleado,String finalQueryGlobalNumeroPatronal,String finalQueryGlobalTipoAfiliacion,String finalQueryGlobalPais,String finalQueryGlobalProvincia,String finalQueryGlobalCanton,String finalQueryGlobalParroquia,String finalQueryGlobalMoneda,String finalQueryGlobalTipoContrato,String finalQueryGlobalTipoLibretaMili,String finalQueryGlobalTipoGrupoFormaPago,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal,String finalQueryGlobalTipoSangre) throws Exception {
		DatoGeneralEmpleadoParameterReturnGeneral  datogeneralempleadoReturnGeneral =new DatoGeneralEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			datogeneralempleadoReturnGeneral =new DatoGeneralEmpleadoParameterReturnGeneral();
			
			

			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			datogeneralempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<NumeroPatronal> numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
			NumeroPatronalLogic numeropatronalLogic=new NumeroPatronalLogic();
			numeropatronalLogic.setConnexion(this.connexion);
			numeropatronalLogic.getNumeroPatronalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNumeroPatronal.equals("NONE")) {
				numeropatronalLogic.getTodosNumeroPatronals(finalQueryGlobalNumeroPatronal,new Pagination());
				numeropatronalsForeignKey=numeropatronalLogic.getNumeroPatronals();
			}

			datogeneralempleadoReturnGeneral.setnumeropatronalsForeignKey(numeropatronalsForeignKey);


			List<TipoAfiliacion> tipoafiliacionsForeignKey=new ArrayList<TipoAfiliacion>();
			TipoAfiliacionLogic tipoafiliacionLogic=new TipoAfiliacionLogic();
			tipoafiliacionLogic.setConnexion(this.connexion);
			tipoafiliacionLogic.getTipoAfiliacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAfiliacion.equals("NONE")) {
				tipoafiliacionLogic.getTodosTipoAfiliacions(finalQueryGlobalTipoAfiliacion,new Pagination());
				tipoafiliacionsForeignKey=tipoafiliacionLogic.getTipoAfiliacions();
			}

			datogeneralempleadoReturnGeneral.settipoafiliacionsForeignKey(tipoafiliacionsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			datogeneralempleadoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			datogeneralempleadoReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			datogeneralempleadoReturnGeneral.setcantonsForeignKey(cantonsForeignKey);


			List<Parroquia> parroquiasForeignKey=new ArrayList<Parroquia>();
			ParroquiaLogic parroquiaLogic=new ParroquiaLogic();
			parroquiaLogic.setConnexion(this.connexion);
			parroquiaLogic.getParroquiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParroquia.equals("NONE")) {
				parroquiaLogic.getTodosParroquias(finalQueryGlobalParroquia,new Pagination());
				parroquiasForeignKey=parroquiaLogic.getParroquias();
			}

			datogeneralempleadoReturnGeneral.setparroquiasForeignKey(parroquiasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			datogeneralempleadoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoContrato> tipocontratosForeignKey=new ArrayList<TipoContrato>();
			TipoContratoLogic tipocontratoLogic=new TipoContratoLogic();
			tipocontratoLogic.setConnexion(this.connexion);
			tipocontratoLogic.getTipoContratoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoContrato.equals("NONE")) {
				tipocontratoLogic.getTodosTipoContratos(finalQueryGlobalTipoContrato,new Pagination());
				tipocontratosForeignKey=tipocontratoLogic.getTipoContratos();
			}

			datogeneralempleadoReturnGeneral.settipocontratosForeignKey(tipocontratosForeignKey);


			List<TipoLibretaMili> tipolibretamilisForeignKey=new ArrayList<TipoLibretaMili>();
			TipoLibretaMiliLogic tipolibretamiliLogic=new TipoLibretaMiliLogic();
			tipolibretamiliLogic.setConnexion(this.connexion);
			tipolibretamiliLogic.getTipoLibretaMiliDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLibretaMili.equals("NONE")) {
				tipolibretamiliLogic.getTodosTipoLibretaMilis(finalQueryGlobalTipoLibretaMili,new Pagination());
				tipolibretamilisForeignKey=tipolibretamiliLogic.getTipoLibretaMilis();
			}

			datogeneralempleadoReturnGeneral.settipolibretamilisForeignKey(tipolibretamilisForeignKey);


			List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic=new TipoGrupoFormaPagoLogic();
			tipogrupoformapagoLogic.setConnexion(this.connexion);
			tipogrupoformapagoLogic.getTipoGrupoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFormaPago.equals("NONE")) {
				tipogrupoformapagoLogic.getTodosTipoGrupoFormaPagos(finalQueryGlobalTipoGrupoFormaPago,new Pagination());
				tipogrupoformapagosForeignKey=tipogrupoformapagoLogic.getTipoGrupoFormaPagos();
			}

			datogeneralempleadoReturnGeneral.settipogrupoformapagosForeignKey(tipogrupoformapagosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			datogeneralempleadoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			datogeneralempleadoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);


			List<TipoSangre> tiposangresForeignKey=new ArrayList<TipoSangre>();
			TipoSangreLogic tiposangreLogic=new TipoSangreLogic();
			tiposangreLogic.setConnexion(this.connexion);
			tiposangreLogic.getTipoSangreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoSangre.equals("NONE")) {
				tiposangreLogic.getTodosTipoSangres(finalQueryGlobalTipoSangre,new Pagination());
				tiposangresForeignKey=tiposangreLogic.getTipoSangres();
			}

			datogeneralempleadoReturnGeneral.settiposangresForeignKey(tiposangresForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return datogeneralempleadoReturnGeneral;
	}
	
	
	public void deepLoad(DatoGeneralEmpleado datogeneralempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DatoGeneralEmpleadoLogicAdditional.updateDatoGeneralEmpleadoToGet(datogeneralempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datogeneralempleado.setEmpleado(datogeneralempleadoDataAccess.getEmpleado(connexion,datogeneralempleado));
		datogeneralempleado.setNumeroPatronal(datogeneralempleadoDataAccess.getNumeroPatronal(connexion,datogeneralempleado));
		datogeneralempleado.setTipoAfiliacion(datogeneralempleadoDataAccess.getTipoAfiliacion(connexion,datogeneralempleado));
		datogeneralempleado.setPais(datogeneralempleadoDataAccess.getPais(connexion,datogeneralempleado));
		datogeneralempleado.setProvincia(datogeneralempleadoDataAccess.getProvincia(connexion,datogeneralempleado));
		datogeneralempleado.setCanton(datogeneralempleadoDataAccess.getCanton(connexion,datogeneralempleado));
		datogeneralempleado.setParroquia(datogeneralempleadoDataAccess.getParroquia(connexion,datogeneralempleado));
		datogeneralempleado.setMoneda(datogeneralempleadoDataAccess.getMoneda(connexion,datogeneralempleado));
		datogeneralempleado.setTipoContrato(datogeneralempleadoDataAccess.getTipoContrato(connexion,datogeneralempleado));
		datogeneralempleado.setTipoLibretaMili(datogeneralempleadoDataAccess.getTipoLibretaMili(connexion,datogeneralempleado));
		datogeneralempleado.setTipoGrupoFormaPago(datogeneralempleadoDataAccess.getTipoGrupoFormaPago(connexion,datogeneralempleado));
		datogeneralempleado.setBanco(datogeneralempleadoDataAccess.getBanco(connexion,datogeneralempleado));
		datogeneralempleado.setTipoCuentaBancoGlobal(datogeneralempleadoDataAccess.getTipoCuentaBancoGlobal(connexion,datogeneralempleado));
		datogeneralempleado.setTipoSangre(datogeneralempleadoDataAccess.getTipoSangre(connexion,datogeneralempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				datogeneralempleado.setEmpleado(datogeneralempleadoDataAccess.getEmpleado(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				datogeneralempleado.setNumeroPatronal(datogeneralempleadoDataAccess.getNumeroPatronal(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(TipoAfiliacion.class)) {
				datogeneralempleado.setTipoAfiliacion(datogeneralempleadoDataAccess.getTipoAfiliacion(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				datogeneralempleado.setPais(datogeneralempleadoDataAccess.getPais(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				datogeneralempleado.setProvincia(datogeneralempleadoDataAccess.getProvincia(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				datogeneralempleado.setCanton(datogeneralempleadoDataAccess.getCanton(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				datogeneralempleado.setParroquia(datogeneralempleadoDataAccess.getParroquia(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				datogeneralempleado.setMoneda(datogeneralempleadoDataAccess.getMoneda(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(TipoContrato.class)) {
				datogeneralempleado.setTipoContrato(datogeneralempleadoDataAccess.getTipoContrato(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(TipoLibretaMili.class)) {
				datogeneralempleado.setTipoLibretaMili(datogeneralempleadoDataAccess.getTipoLibretaMili(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				datogeneralempleado.setTipoGrupoFormaPago(datogeneralempleadoDataAccess.getTipoGrupoFormaPago(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				datogeneralempleado.setBanco(datogeneralempleadoDataAccess.getBanco(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				datogeneralempleado.setTipoCuentaBancoGlobal(datogeneralempleadoDataAccess.getTipoCuentaBancoGlobal(connexion,datogeneralempleado));
				continue;
			}

			if(clas.clas.equals(TipoSangre.class)) {
				datogeneralempleado.setTipoSangre(datogeneralempleadoDataAccess.getTipoSangre(connexion,datogeneralempleado));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setEmpleado(datogeneralempleadoDataAccess.getEmpleado(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setNumeroPatronal(datogeneralempleadoDataAccess.getNumeroPatronal(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoAfiliacion(datogeneralempleadoDataAccess.getTipoAfiliacion(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setPais(datogeneralempleadoDataAccess.getPais(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setProvincia(datogeneralempleadoDataAccess.getProvincia(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setCanton(datogeneralempleadoDataAccess.getCanton(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setParroquia(datogeneralempleadoDataAccess.getParroquia(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setMoneda(datogeneralempleadoDataAccess.getMoneda(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoContrato(datogeneralempleadoDataAccess.getTipoContrato(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLibretaMili.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoLibretaMili(datogeneralempleadoDataAccess.getTipoLibretaMili(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoGrupoFormaPago(datogeneralempleadoDataAccess.getTipoGrupoFormaPago(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setBanco(datogeneralempleadoDataAccess.getBanco(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoCuentaBancoGlobal(datogeneralempleadoDataAccess.getTipoCuentaBancoGlobal(connexion,datogeneralempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoSangre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoSangre(datogeneralempleadoDataAccess.getTipoSangre(connexion,datogeneralempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datogeneralempleado.setEmpleado(datogeneralempleadoDataAccess.getEmpleado(connexion,datogeneralempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(datogeneralempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setNumeroPatronal(datogeneralempleadoDataAccess.getNumeroPatronal(connexion,datogeneralempleado));
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(datogeneralempleado.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setTipoAfiliacion(datogeneralempleadoDataAccess.getTipoAfiliacion(connexion,datogeneralempleado));
		TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
		tipoafiliacionLogic.deepLoad(datogeneralempleado.getTipoAfiliacion(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setPais(datogeneralempleadoDataAccess.getPais(connexion,datogeneralempleado));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(datogeneralempleado.getPais(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setProvincia(datogeneralempleadoDataAccess.getProvincia(connexion,datogeneralempleado));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(datogeneralempleado.getProvincia(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setCanton(datogeneralempleadoDataAccess.getCanton(connexion,datogeneralempleado));
		CantonLogic cantonLogic= new CantonLogic(connexion);
		cantonLogic.deepLoad(datogeneralempleado.getCanton(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setParroquia(datogeneralempleadoDataAccess.getParroquia(connexion,datogeneralempleado));
		ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
		parroquiaLogic.deepLoad(datogeneralempleado.getParroquia(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setMoneda(datogeneralempleadoDataAccess.getMoneda(connexion,datogeneralempleado));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(datogeneralempleado.getMoneda(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setTipoContrato(datogeneralempleadoDataAccess.getTipoContrato(connexion,datogeneralempleado));
		TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
		tipocontratoLogic.deepLoad(datogeneralempleado.getTipoContrato(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setTipoLibretaMili(datogeneralempleadoDataAccess.getTipoLibretaMili(connexion,datogeneralempleado));
		TipoLibretaMiliLogic tipolibretamiliLogic= new TipoLibretaMiliLogic(connexion);
		tipolibretamiliLogic.deepLoad(datogeneralempleado.getTipoLibretaMili(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setTipoGrupoFormaPago(datogeneralempleadoDataAccess.getTipoGrupoFormaPago(connexion,datogeneralempleado));
		TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
		tipogrupoformapagoLogic.deepLoad(datogeneralempleado.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setBanco(datogeneralempleadoDataAccess.getBanco(connexion,datogeneralempleado));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(datogeneralempleado.getBanco(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setTipoCuentaBancoGlobal(datogeneralempleadoDataAccess.getTipoCuentaBancoGlobal(connexion,datogeneralempleado));
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(datogeneralempleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		datogeneralempleado.setTipoSangre(datogeneralempleadoDataAccess.getTipoSangre(connexion,datogeneralempleado));
		TipoSangreLogic tiposangreLogic= new TipoSangreLogic(connexion);
		tiposangreLogic.deepLoad(datogeneralempleado.getTipoSangre(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				datogeneralempleado.setEmpleado(datogeneralempleadoDataAccess.getEmpleado(connexion,datogeneralempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(datogeneralempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				datogeneralempleado.setNumeroPatronal(datogeneralempleadoDataAccess.getNumeroPatronal(connexion,datogeneralempleado));
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepLoad(datogeneralempleado.getNumeroPatronal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAfiliacion.class)) {
				datogeneralempleado.setTipoAfiliacion(datogeneralempleadoDataAccess.getTipoAfiliacion(connexion,datogeneralempleado));
				TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
				tipoafiliacionLogic.deepLoad(datogeneralempleado.getTipoAfiliacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				datogeneralempleado.setPais(datogeneralempleadoDataAccess.getPais(connexion,datogeneralempleado));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(datogeneralempleado.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				datogeneralempleado.setProvincia(datogeneralempleadoDataAccess.getProvincia(connexion,datogeneralempleado));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(datogeneralempleado.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				datogeneralempleado.setCanton(datogeneralempleadoDataAccess.getCanton(connexion,datogeneralempleado));
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepLoad(datogeneralempleado.getCanton(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				datogeneralempleado.setParroquia(datogeneralempleadoDataAccess.getParroquia(connexion,datogeneralempleado));
				ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
				parroquiaLogic.deepLoad(datogeneralempleado.getParroquia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				datogeneralempleado.setMoneda(datogeneralempleadoDataAccess.getMoneda(connexion,datogeneralempleado));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(datogeneralempleado.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoContrato.class)) {
				datogeneralempleado.setTipoContrato(datogeneralempleadoDataAccess.getTipoContrato(connexion,datogeneralempleado));
				TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
				tipocontratoLogic.deepLoad(datogeneralempleado.getTipoContrato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLibretaMili.class)) {
				datogeneralempleado.setTipoLibretaMili(datogeneralempleadoDataAccess.getTipoLibretaMili(connexion,datogeneralempleado));
				TipoLibretaMiliLogic tipolibretamiliLogic= new TipoLibretaMiliLogic(connexion);
				tipolibretamiliLogic.deepLoad(datogeneralempleado.getTipoLibretaMili(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				datogeneralempleado.setTipoGrupoFormaPago(datogeneralempleadoDataAccess.getTipoGrupoFormaPago(connexion,datogeneralempleado));
				TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
				tipogrupoformapagoLogic.deepLoad(datogeneralempleado.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				datogeneralempleado.setBanco(datogeneralempleadoDataAccess.getBanco(connexion,datogeneralempleado));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(datogeneralempleado.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				datogeneralempleado.setTipoCuentaBancoGlobal(datogeneralempleadoDataAccess.getTipoCuentaBancoGlobal(connexion,datogeneralempleado));
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepLoad(datogeneralempleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoSangre.class)) {
				datogeneralempleado.setTipoSangre(datogeneralempleadoDataAccess.getTipoSangre(connexion,datogeneralempleado));
				TipoSangreLogic tiposangreLogic= new TipoSangreLogic(connexion);
				tiposangreLogic.deepLoad(datogeneralempleado.getTipoSangre(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setEmpleado(datogeneralempleadoDataAccess.getEmpleado(connexion,datogeneralempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(datogeneralempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setNumeroPatronal(datogeneralempleadoDataAccess.getNumeroPatronal(connexion,datogeneralempleado));
			NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
			numeropatronalLogic.deepLoad(datogeneralempleado.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoAfiliacion(datogeneralempleadoDataAccess.getTipoAfiliacion(connexion,datogeneralempleado));
			TipoAfiliacionLogic tipoafiliacionLogic= new TipoAfiliacionLogic(connexion);
			tipoafiliacionLogic.deepLoad(datogeneralempleado.getTipoAfiliacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setPais(datogeneralempleadoDataAccess.getPais(connexion,datogeneralempleado));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(datogeneralempleado.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setProvincia(datogeneralempleadoDataAccess.getProvincia(connexion,datogeneralempleado));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(datogeneralempleado.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setCanton(datogeneralempleadoDataAccess.getCanton(connexion,datogeneralempleado));
			CantonLogic cantonLogic= new CantonLogic(connexion);
			cantonLogic.deepLoad(datogeneralempleado.getCanton(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setParroquia(datogeneralempleadoDataAccess.getParroquia(connexion,datogeneralempleado));
			ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
			parroquiaLogic.deepLoad(datogeneralempleado.getParroquia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setMoneda(datogeneralempleadoDataAccess.getMoneda(connexion,datogeneralempleado));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(datogeneralempleado.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoContrato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoContrato(datogeneralempleadoDataAccess.getTipoContrato(connexion,datogeneralempleado));
			TipoContratoLogic tipocontratoLogic= new TipoContratoLogic(connexion);
			tipocontratoLogic.deepLoad(datogeneralempleado.getTipoContrato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLibretaMili.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoLibretaMili(datogeneralempleadoDataAccess.getTipoLibretaMili(connexion,datogeneralempleado));
			TipoLibretaMiliLogic tipolibretamiliLogic= new TipoLibretaMiliLogic(connexion);
			tipolibretamiliLogic.deepLoad(datogeneralempleado.getTipoLibretaMili(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoGrupoFormaPago(datogeneralempleadoDataAccess.getTipoGrupoFormaPago(connexion,datogeneralempleado));
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
			tipogrupoformapagoLogic.deepLoad(datogeneralempleado.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setBanco(datogeneralempleadoDataAccess.getBanco(connexion,datogeneralempleado));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(datogeneralempleado.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoCuentaBancoGlobal(datogeneralempleadoDataAccess.getTipoCuentaBancoGlobal(connexion,datogeneralempleado));
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
			tipocuentabancoglobalLogic.deepLoad(datogeneralempleado.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoSangre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralempleado.setTipoSangre(datogeneralempleadoDataAccess.getTipoSangre(connexion,datogeneralempleado));
			TipoSangreLogic tiposangreLogic= new TipoSangreLogic(connexion);
			tiposangreLogic.deepLoad(datogeneralempleado.getTipoSangre(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DatoGeneralEmpleado datogeneralempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DatoGeneralEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleado);
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
			this.deepLoad(this.datogeneralempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DatoGeneralEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(datogeneralempleados!=null) {
				for(DatoGeneralEmpleado datogeneralempleado:datogeneralempleados) {
					this.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleados);
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
			if(datogeneralempleados!=null) {
				for(DatoGeneralEmpleado datogeneralempleado:datogeneralempleados) {
					this.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleados);
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
	
	
	public void getDatoGeneralEmpleadosFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,DatoGeneralEmpleadoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,DatoGeneralEmpleadoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdCantonWithConnection(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,DatoGeneralEmpleadoConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdCanton(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,DatoGeneralEmpleadoConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DatoGeneralEmpleadoConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DatoGeneralEmpleadoConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DatoGeneralEmpleadoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DatoGeneralEmpleadoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdNumeroPatronalWithConnection(String sFinalQuery,Pagination pagination,Long id_numero_patronal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNumeroPatronal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNumeroPatronal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_numero_patronal,DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNumeroPatronal);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNumeroPatronal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdNumeroPatronal(String sFinalQuery,Pagination pagination,Long id_numero_patronal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNumeroPatronal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNumeroPatronal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_numero_patronal,DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNumeroPatronal);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNumeroPatronal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,DatoGeneralEmpleadoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,DatoGeneralEmpleadoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdParroquiaWithConnection(String sFinalQuery,Pagination pagination,Long id_parroquia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParroquia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParroquia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parroquia,DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParroquia);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParroquia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdParroquia(String sFinalQuery,Pagination pagination,Long id_parroquia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParroquia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParroquia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parroquia,DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParroquia);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParroquia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoAfiliacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_afiliacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAfiliacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAfiliacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_afiliacion,DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAfiliacion);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAfiliacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoAfiliacion(String sFinalQuery,Pagination pagination,Long id_tipo_afiliacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAfiliacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAfiliacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_afiliacion,DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAfiliacion);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAfiliacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoContratoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_contrato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoContrato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoContrato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_contrato,DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoContrato);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoContrato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoContrato(String sFinalQuery,Pagination pagination,Long id_tipo_contrato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoContrato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoContrato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_contrato,DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoContrato);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoContrato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoCuentaBancoGlobalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoCuentaBancoGlobal(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoGrupoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_forma_pago,DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFormaPago);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoGrupoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_forma_pago,DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFormaPago);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoLibretaMiliWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_libreta_mili)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLibretaMili= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLibretaMili.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_libreta_mili,DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLibretaMili);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLibretaMili","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoLibretaMili(String sFinalQuery,Pagination pagination,Long id_tipo_libreta_mili)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLibretaMili= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLibretaMili.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_libreta_mili,DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLibretaMili);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLibretaMili","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoSangreWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_sangre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoSangre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoSangre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_sangre,DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoSangre);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoSangre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralEmpleadosFK_IdTipoSangre(String sFinalQuery,Pagination pagination,Long id_tipo_sangre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoSangre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoSangre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_sangre,DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoSangre);

			DatoGeneralEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoSangre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(this.datogeneralempleados);
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
			if(DatoGeneralEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DatoGeneralEmpleado datogeneralempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DatoGeneralEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(datogeneralempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralEmpleadoDataAccess.TABLENAME, datogeneralempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoGeneralEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoGeneralEmpleadoLogic.registrarAuditoriaDetallesDatoGeneralEmpleado(connexion,datogeneralempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(datogeneralempleado.getIsDeleted()) {
					/*if(!datogeneralempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DatoGeneralEmpleadoDataAccess.TABLENAME, datogeneralempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DatoGeneralEmpleadoLogic.registrarAuditoriaDetallesDatoGeneralEmpleado(connexion,datogeneralempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralEmpleadoDataAccess.TABLENAME, datogeneralempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(datogeneralempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralEmpleadoDataAccess.TABLENAME, datogeneralempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoGeneralEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoGeneralEmpleadoLogic.registrarAuditoriaDetallesDatoGeneralEmpleado(connexion,datogeneralempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDatoGeneralEmpleado(Connexion connexion,DatoGeneralEmpleado datogeneralempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_numero_patronal().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_numero_patronal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_numero_patronal()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_numero_patronal().toString();
				}
				if(datogeneralempleado.getid_numero_patronal()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_numero_patronal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_tipo_afiliacion().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_afiliacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_afiliacion()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_afiliacion().toString();
				}
				if(datogeneralempleado.getid_tipo_afiliacion()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_tipo_afiliacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getcarnet_iess().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcarnet_iess()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcarnet_iess()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcarnet_iess();
				}
				if(datogeneralempleado.getcarnet_iess()!=null)
				{
					strValorNuevo=datogeneralempleado.getcarnet_iess() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.CARNETIESS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getsectorial_iess().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getsectorial_iess()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getsectorial_iess()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getsectorial_iess();
				}
				if(datogeneralempleado.getsectorial_iess()!=null)
				{
					strValorNuevo=datogeneralempleado.getsectorial_iess() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_pais().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_pais()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_pais().toString();
				}
				if(datogeneralempleado.getid_pais()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_provincia().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_provincia()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_provincia().toString();
				}
				if(datogeneralempleado.getid_provincia()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_canton().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_canton()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_canton()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_canton().toString();
				}
				if(datogeneralempleado.getid_canton()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_canton().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDCANTON,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_parroquia().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_parroquia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_parroquia()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_parroquia().toString();
				}
				if(datogeneralempleado.getid_parroquia()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_parroquia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getfecha_nacimiento().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getfecha_nacimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getfecha_nacimiento()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getfecha_nacimiento().toString();
				}
				if(datogeneralempleado.getfecha_nacimiento()!=null)
				{
					strValorNuevo=datogeneralempleado.getfecha_nacimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getfecha_fallece().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getfecha_fallece()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getfecha_fallece()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getfecha_fallece().toString();
				}
				if(datogeneralempleado.getfecha_fallece()!=null)
				{
					strValorNuevo=datogeneralempleado.getfecha_fallece().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor_evaluacion().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor_evaluacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor_evaluacion()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor_evaluacion().toString();
				}
				if(datogeneralempleado.getvalor_evaluacion()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor_evaluacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getnumero_horas().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_horas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_horas()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_horas().toString();
				}
				if(datogeneralempleado.getnumero_horas()!=null)
				{
					strValorNuevo=datogeneralempleado.getnumero_horas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor_hora().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor_hora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor_hora()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor_hora().toString();
				}
				if(datogeneralempleado.getvalor_hora()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor_hora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALORHORA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getsalario().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getsalario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getsalario()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getsalario().toString();
				}
				if(datogeneralempleado.getsalario()!=null)
				{
					strValorNuevo=datogeneralempleado.getsalario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.SALARIO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_moneda().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_moneda()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_moneda().toString();
				}
				if(datogeneralempleado.getid_moneda()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getnumero_contrato().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_contrato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_contrato()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_contrato();
				}
				if(datogeneralempleado.getnumero_contrato()!=null)
				{
					strValorNuevo=datogeneralempleado.getnumero_contrato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_tipo_contrato().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_contrato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_contrato()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_contrato().toString();
				}
				if(datogeneralempleado.getid_tipo_contrato()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_tipo_contrato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor1().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor1()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor1().toString();
				}
				if(datogeneralempleado.getvalor1()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALOR1,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor2().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor2()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor2().toString();
				}
				if(datogeneralempleado.getvalor2()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALOR2,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor3().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor3()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor3().toString();
				}
				if(datogeneralempleado.getvalor3()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALOR3,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor4().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor4()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor4().toString();
				}
				if(datogeneralempleado.getvalor4()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALOR4,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor5().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor5()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor5().toString();
				}
				if(datogeneralempleado.getvalor5()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALOR5,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getvalor6().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor6()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor6()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getvalor6().toString();
				}
				if(datogeneralempleado.getvalor6()!=null)
				{
					strValorNuevo=datogeneralempleado.getvalor6().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.VALOR6,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getcon_aporta_seguro_social().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_aporta_seguro_social()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_aporta_seguro_social()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_aporta_seguro_social().toString();
				}
				if(datogeneralempleado.getcon_aporta_seguro_social()!=null)
				{
					strValorNuevo=datogeneralempleado.getcon_aporta_seguro_social().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getcon_recibe_horas_extras().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_recibe_horas_extras()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_recibe_horas_extras()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_recibe_horas_extras().toString();
				}
				if(datogeneralempleado.getcon_recibe_horas_extras()!=null)
				{
					strValorNuevo=datogeneralempleado.getcon_recibe_horas_extras().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getcon_descuento_impuestos().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_descuento_impuestos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_descuento_impuestos()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_descuento_impuestos().toString();
				}
				if(datogeneralempleado.getcon_descuento_impuestos()!=null)
				{
					strValorNuevo=datogeneralempleado.getcon_descuento_impuestos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getpension_alimenticia().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getpension_alimenticia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getpension_alimenticia()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getpension_alimenticia().toString();
				}
				if(datogeneralempleado.getpension_alimenticia()!=null)
				{
					strValorNuevo=datogeneralempleado.getpension_alimenticia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getcon_pago_por_horas().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_pago_por_horas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_pago_por_horas()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_pago_por_horas().toString();
				}
				if(datogeneralempleado.getcon_pago_por_horas()!=null)
				{
					strValorNuevo=datogeneralempleado.getcon_pago_por_horas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getcon_anticipo().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_anticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_anticipo()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getcon_anticipo().toString();
				}
				if(datogeneralempleado.getcon_anticipo()!=null)
				{
					strValorNuevo=datogeneralempleado.getcon_anticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_tipo_libreta_mili().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_libreta_mili()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_libreta_mili()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_libreta_mili().toString();
				}
				if(datogeneralempleado.getid_tipo_libreta_mili()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_tipo_libreta_mili().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getlibreta_militar().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getlibreta_militar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getlibreta_militar()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getlibreta_militar();
				}
				if(datogeneralempleado.getlibreta_militar()!=null)
				{
					strValorNuevo=datogeneralempleado.getlibreta_militar() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_tipo_grupo_forma_pago().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_grupo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_grupo_forma_pago()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_grupo_forma_pago().toString();
				}
				if(datogeneralempleado.getid_tipo_grupo_forma_pago()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_tipo_grupo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_banco().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_banco()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_banco().toString();
				}
				if(datogeneralempleado.getid_banco()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_tipo_cuenta_banco_global().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_cuenta_banco_global()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_cuenta_banco_global()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_cuenta_banco_global().toString();
				}
				if(datogeneralempleado.getid_tipo_cuenta_banco_global()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_tipo_cuenta_banco_global().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getnumero_cuenta().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_cuenta()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getnumero_cuenta();
				}
				if(datogeneralempleado.getnumero_cuenta()!=null)
				{
					strValorNuevo=datogeneralempleado.getnumero_cuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralempleado.getIsNew()||!datogeneralempleado.getid_tipo_sangre().equals(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_sangre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_sangre()!=null)
				{
					strValorActual=datogeneralempleado.getDatoGeneralEmpleadoOriginal().getid_tipo_sangre().toString();
				}
				if(datogeneralempleado.getid_tipo_sangre()!=null)
				{
					strValorNuevo=datogeneralempleado.getid_tipo_sangre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDatoGeneralEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoGeneralEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoGeneralEmpleadoConstantesFunciones.getClassesRelationshipsOfDatoGeneralEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
