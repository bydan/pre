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
import com.bydan.erp.nomina.util.AsistenciaDiariaConstantesFunciones;
import com.bydan.erp.nomina.util.AsistenciaDiariaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AsistenciaDiariaParameterGeneral;
import com.bydan.erp.nomina.business.entity.AsistenciaDiaria;
import com.bydan.erp.nomina.business.logic.AsistenciaDiariaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class AsistenciaDiariaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AsistenciaDiariaLogic.class);
	
	protected AsistenciaDiariaDataAccess asistenciadiariaDataAccess; 	
	protected AsistenciaDiaria asistenciadiaria;
	protected List<AsistenciaDiaria> asistenciadiarias;
	protected Object asistenciadiariaObject;	
	protected List<Object> asistenciadiariasObject;
	
	public static ClassValidator<AsistenciaDiaria> asistenciadiariaValidator = new ClassValidator<AsistenciaDiaria>(AsistenciaDiaria.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AsistenciaDiariaLogicAdditional asistenciadiariaLogicAdditional=null;
	
	public AsistenciaDiariaLogicAdditional getAsistenciaDiariaLogicAdditional() {
		return this.asistenciadiariaLogicAdditional;
	}
	
	public void setAsistenciaDiariaLogicAdditional(AsistenciaDiariaLogicAdditional asistenciadiariaLogicAdditional) {
		try {
			this.asistenciadiariaLogicAdditional=asistenciadiariaLogicAdditional;
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
	
	
	
	
	public  AsistenciaDiariaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.asistenciadiariaDataAccess = new AsistenciaDiariaDataAccess();
			
			this.asistenciadiarias= new ArrayList<AsistenciaDiaria>();
			this.asistenciadiaria= new AsistenciaDiaria();
			
			this.asistenciadiariaObject=new Object();
			this.asistenciadiariasObject=new ArrayList<Object>();
				
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
			
			this.asistenciadiariaDataAccess.setConnexionType(this.connexionType);
			this.asistenciadiariaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AsistenciaDiariaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.asistenciadiariaDataAccess = new AsistenciaDiariaDataAccess();
			this.asistenciadiarias= new ArrayList<AsistenciaDiaria>();
			this.asistenciadiaria= new AsistenciaDiaria();
			this.asistenciadiariaObject=new Object();
			this.asistenciadiariasObject=new ArrayList<Object>();
			
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
			
			this.asistenciadiariaDataAccess.setConnexionType(this.connexionType);
			this.asistenciadiariaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AsistenciaDiaria getAsistenciaDiaria() throws Exception {	
		AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToGet(asistenciadiaria,this.datosCliente,this.arrDatoGeneral);
		AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToGet(asistenciadiaria,this.arrDatoGeneral);
		
		return asistenciadiaria;
	}
		
	public void setAsistenciaDiaria(AsistenciaDiaria newAsistenciaDiaria) {
		this.asistenciadiaria = newAsistenciaDiaria;
	}
	
	public AsistenciaDiariaDataAccess getAsistenciaDiariaDataAccess() {
		return asistenciadiariaDataAccess;
	}
	
	public void setAsistenciaDiariaDataAccess(AsistenciaDiariaDataAccess newasistenciadiariaDataAccess) {
		this.asistenciadiariaDataAccess = newasistenciadiariaDataAccess;
	}
	
	public List<AsistenciaDiaria> getAsistenciaDiarias() throws Exception {		
		this.quitarAsistenciaDiariasNulos();
		
		AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToGets(asistenciadiarias,this.datosCliente,this.arrDatoGeneral);
		
		for (AsistenciaDiaria asistenciadiariaLocal: asistenciadiarias ) {
			AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToGet(asistenciadiariaLocal,this.arrDatoGeneral);
		}
		
		return asistenciadiarias;
	}
	
	public void setAsistenciaDiarias(List<AsistenciaDiaria> newAsistenciaDiarias) {
		this.asistenciadiarias = newAsistenciaDiarias;
	}
	
	public Object getAsistenciaDiariaObject() {	
		this.asistenciadiariaObject=this.asistenciadiariaDataAccess.getEntityObject();
		return this.asistenciadiariaObject;
	}
		
	public void setAsistenciaDiariaObject(Object newAsistenciaDiariaObject) {
		this.asistenciadiariaObject = newAsistenciaDiariaObject;
	}
	
	public List<Object> getAsistenciaDiariasObject() {		
		this.asistenciadiariasObject=this.asistenciadiariaDataAccess.getEntitiesObject();
		return this.asistenciadiariasObject;
	}
		
	public void setAsistenciaDiariasObject(List<Object> newAsistenciaDiariasObject) {
		this.asistenciadiariasObject = newAsistenciaDiariasObject;
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
		
		if(this.asistenciadiariaDataAccess!=null) {
			this.asistenciadiariaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			asistenciadiariaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			asistenciadiariaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		asistenciadiaria = new  AsistenciaDiaria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asistenciadiaria=asistenciadiariaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciadiaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiaria);
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
		asistenciadiaria = new  AsistenciaDiaria();
		  		  
        try {
			
			asistenciadiaria=asistenciadiariaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciadiaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		asistenciadiaria = new  AsistenciaDiaria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asistenciadiaria=asistenciadiariaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciadiaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiaria);
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
		asistenciadiaria = new  AsistenciaDiaria();
		  		  
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
		asistenciadiaria = new  AsistenciaDiaria();
		  		  
        try {
			
			asistenciadiaria=asistenciadiariaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciadiaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		asistenciadiaria = new  AsistenciaDiaria();
		  		  
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
		asistenciadiaria = new  AsistenciaDiaria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =asistenciadiariaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciadiaria = new  AsistenciaDiaria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=asistenciadiariaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asistenciadiaria = new  AsistenciaDiaria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =asistenciadiariaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciadiaria = new  AsistenciaDiaria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=asistenciadiariaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asistenciadiaria = new  AsistenciaDiaria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =asistenciadiariaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciadiaria = new  AsistenciaDiaria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=asistenciadiariaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
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
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
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
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
        try {			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
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
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
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
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
        try {
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
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
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
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
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		asistenciadiaria = new  AsistenciaDiaria();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiaria=asistenciadiariaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiaria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiaria);
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
		asistenciadiaria = new  AsistenciaDiaria();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiaria=asistenciadiariaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiaria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
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
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		  		  
        try {
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAsistenciaDiariasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getTodosAsistenciaDiariasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
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
	
	public  void  getTodosAsistenciaDiarias(String sFinalQuery,Pagination pagination)throws Exception {
		asistenciadiarias = new  ArrayList<AsistenciaDiaria>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsistenciaDiaria(asistenciadiarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAsistenciaDiaria(AsistenciaDiaria asistenciadiaria) throws Exception {
		Boolean estaValidado=false;
		
		if(asistenciadiaria.getIsNew() || asistenciadiaria.getIsChanged()) { 
			this.invalidValues = asistenciadiariaValidator.getInvalidValues(asistenciadiaria);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(asistenciadiaria);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAsistenciaDiaria(List<AsistenciaDiaria> AsistenciaDiarias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AsistenciaDiaria asistenciadiariaLocal:asistenciadiarias) {				
			estaValidadoObjeto=this.validarGuardarAsistenciaDiaria(asistenciadiariaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAsistenciaDiaria(List<AsistenciaDiaria> AsistenciaDiarias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsistenciaDiaria(asistenciadiarias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAsistenciaDiaria(AsistenciaDiaria AsistenciaDiaria) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsistenciaDiaria(asistenciadiaria)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AsistenciaDiaria asistenciadiaria) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+asistenciadiaria.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AsistenciaDiariaConstantesFunciones.getAsistenciaDiariaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"asistenciadiaria","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AsistenciaDiariaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AsistenciaDiariaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAsistenciaDiariaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-saveAsistenciaDiariaWithConnection");connexion.begin();			
			
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSave(this.asistenciadiaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToSave(this.asistenciadiaria,this.arrDatoGeneral);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asistenciadiaria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAsistenciaDiaria();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsistenciaDiaria(this.asistenciadiaria)) {
				AsistenciaDiariaDataAccess.save(this.asistenciadiaria, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.asistenciadiaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSaveAfter(this.asistenciadiaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsistenciaDiaria();
			
			connexion.commit();			
			
			if(this.asistenciadiaria.getIsDeleted()) {
				this.asistenciadiaria=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAsistenciaDiaria()throws Exception {	
		try {	
			
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSave(this.asistenciadiaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToSave(this.asistenciadiaria,this.arrDatoGeneral);
			
			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asistenciadiaria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsistenciaDiaria(this.asistenciadiaria)) {			
				AsistenciaDiariaDataAccess.save(this.asistenciadiaria, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.asistenciadiaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSaveAfter(this.asistenciadiaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.asistenciadiaria.getIsDeleted()) {
				this.asistenciadiaria=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAsistenciaDiariasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-saveAsistenciaDiariasWithConnection");connexion.begin();			
			
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSaves(asistenciadiarias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAsistenciaDiarias();
			
			Boolean validadoTodosAsistenciaDiaria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsistenciaDiaria asistenciadiariaLocal:asistenciadiarias) {		
				if(asistenciadiariaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToSave(asistenciadiariaLocal,this.arrDatoGeneral);
	        	
				AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asistenciadiariaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsistenciaDiaria(asistenciadiariaLocal)) {
					AsistenciaDiariaDataAccess.save(asistenciadiariaLocal, connexion);				
				} else {
					validadoTodosAsistenciaDiaria=false;
				}
			}
			
			if(!validadoTodosAsistenciaDiaria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSavesAfter(asistenciadiarias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsistenciaDiarias();
			
			connexion.commit();		
			
			this.quitarAsistenciaDiariasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAsistenciaDiarias()throws Exception {				
		 try {	
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSaves(asistenciadiarias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAsistenciaDiaria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsistenciaDiaria asistenciadiariaLocal:asistenciadiarias) {				
				if(asistenciadiariaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToSave(asistenciadiariaLocal,this.arrDatoGeneral);
	        	
				AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asistenciadiariaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsistenciaDiaria(asistenciadiariaLocal)) {				
					AsistenciaDiariaDataAccess.save(asistenciadiariaLocal, connexion);				
				} else {
					validadoTodosAsistenciaDiaria=false;
				}
			}
			
			if(!validadoTodosAsistenciaDiaria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsistenciaDiariaLogicAdditional.checkAsistenciaDiariaToSavesAfter(asistenciadiarias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAsistenciaDiariasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsistenciaDiariaParameterReturnGeneral procesarAccionAsistenciaDiarias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsistenciaDiaria> asistenciadiarias,AsistenciaDiariaParameterReturnGeneral asistenciadiariaParameterGeneral)throws Exception {
		 try {	
			AsistenciaDiariaParameterReturnGeneral asistenciadiariaReturnGeneral=new AsistenciaDiariaParameterReturnGeneral();
	
			AsistenciaDiariaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asistenciadiarias,asistenciadiariaParameterGeneral,asistenciadiariaReturnGeneral);
			
			return asistenciadiariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsistenciaDiariaParameterReturnGeneral procesarAccionAsistenciaDiariasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsistenciaDiaria> asistenciadiarias,AsistenciaDiariaParameterReturnGeneral asistenciadiariaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-procesarAccionAsistenciaDiariasWithConnection");connexion.begin();			
			
			AsistenciaDiariaParameterReturnGeneral asistenciadiariaReturnGeneral=new AsistenciaDiariaParameterReturnGeneral();
	
			AsistenciaDiariaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asistenciadiarias,asistenciadiariaParameterGeneral,asistenciadiariaReturnGeneral);
			
			this.connexion.commit();
			
			return asistenciadiariaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsistenciaDiariaParameterReturnGeneral procesarEventosAsistenciaDiarias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsistenciaDiaria> asistenciadiarias,AsistenciaDiaria asistenciadiaria,AsistenciaDiariaParameterReturnGeneral asistenciadiariaParameterGeneral,Boolean isEsNuevoAsistenciaDiaria,ArrayList<Classe> clases)throws Exception {
		 try {	
			AsistenciaDiariaParameterReturnGeneral asistenciadiariaReturnGeneral=new AsistenciaDiariaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asistenciadiariaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsistenciaDiariaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asistenciadiarias,asistenciadiaria,asistenciadiariaParameterGeneral,asistenciadiariaReturnGeneral,isEsNuevoAsistenciaDiaria,clases);
			
			return asistenciadiariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AsistenciaDiariaParameterReturnGeneral procesarEventosAsistenciaDiariasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsistenciaDiaria> asistenciadiarias,AsistenciaDiaria asistenciadiaria,AsistenciaDiariaParameterReturnGeneral asistenciadiariaParameterGeneral,Boolean isEsNuevoAsistenciaDiaria,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-procesarEventosAsistenciaDiariasWithConnection");connexion.begin();			
			
			AsistenciaDiariaParameterReturnGeneral asistenciadiariaReturnGeneral=new AsistenciaDiariaParameterReturnGeneral();
	
			asistenciadiariaReturnGeneral.setAsistenciaDiaria(asistenciadiaria);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asistenciadiariaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsistenciaDiariaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asistenciadiarias,asistenciadiaria,asistenciadiariaParameterGeneral,asistenciadiariaReturnGeneral,isEsNuevoAsistenciaDiaria,clases);
			
			this.connexion.commit();
			
			return asistenciadiariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsistenciaDiariaParameterReturnGeneral procesarImportacionAsistenciaDiariasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AsistenciaDiariaParameterReturnGeneral asistenciadiariaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-procesarImportacionAsistenciaDiariasWithConnection");connexion.begin();			
			
			AsistenciaDiariaParameterReturnGeneral asistenciadiariaReturnGeneral=new AsistenciaDiariaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.asistenciadiarias=new ArrayList<AsistenciaDiaria>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.asistenciadiaria=new AsistenciaDiaria();
				
				
				if(conColumnasBase) {this.asistenciadiaria.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.asistenciadiaria.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.asistenciadiaria.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.asistenciadiaria.sethora(arrColumnas[iColumn++]);
				this.asistenciadiaria.sethoras_atraso(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciadiaria.sethoras_falta(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciadiaria.sethoras_permiso(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciadiaria.sethoras_extra25(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciadiaria.sethoras_extra50(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciadiaria.sethoras_extra100(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciadiaria.setdescripcion(arrColumnas[iColumn++]);
				
				this.asistenciadiarias.add(this.asistenciadiaria);
			}
			
			this.saveAsistenciaDiarias();
			
			this.connexion.commit();
			
			asistenciadiariaReturnGeneral.setConRetornoEstaProcesado(true);
			asistenciadiariaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return asistenciadiariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAsistenciaDiariasEliminados() throws Exception {				
		
		List<AsistenciaDiaria> asistenciadiariasAux= new ArrayList<AsistenciaDiaria>();
		
		for(AsistenciaDiaria asistenciadiaria:asistenciadiarias) {
			if(!asistenciadiaria.getIsDeleted()) {
				asistenciadiariasAux.add(asistenciadiaria);
			}
		}
		
		asistenciadiarias=asistenciadiariasAux;
	}
	
	public void quitarAsistenciaDiariasNulos() throws Exception {				
		
		List<AsistenciaDiaria> asistenciadiariasAux= new ArrayList<AsistenciaDiaria>();
		
		for(AsistenciaDiaria asistenciadiaria : this.asistenciadiarias) {
			if(asistenciadiaria==null) {
				asistenciadiariasAux.add(asistenciadiaria);
			}
		}
		
		//this.asistenciadiarias=asistenciadiariasAux;
		
		this.asistenciadiarias.removeAll(asistenciadiariasAux);
	}
	
	public void getSetVersionRowAsistenciaDiariaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(asistenciadiaria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((asistenciadiaria.getIsDeleted() || (asistenciadiaria.getIsChanged()&&!asistenciadiaria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=asistenciadiariaDataAccess.getSetVersionRowAsistenciaDiaria(connexion,asistenciadiaria.getId());
				
				if(!asistenciadiaria.getVersionRow().equals(timestamp)) {	
					asistenciadiaria.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				asistenciadiaria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAsistenciaDiaria()throws Exception {	
		
		if(asistenciadiaria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((asistenciadiaria.getIsDeleted() || (asistenciadiaria.getIsChanged()&&!asistenciadiaria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=asistenciadiariaDataAccess.getSetVersionRowAsistenciaDiaria(connexion,asistenciadiaria.getId());
			
			try {							
				if(!asistenciadiaria.getVersionRow().equals(timestamp)) {	
					asistenciadiaria.setVersionRow(timestamp);
				}
				
				asistenciadiaria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAsistenciaDiariasWithConnection()throws Exception {	
		if(asistenciadiarias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AsistenciaDiaria asistenciadiariaAux:asistenciadiarias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(asistenciadiariaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asistenciadiariaAux.getIsDeleted() || (asistenciadiariaAux.getIsChanged()&&!asistenciadiariaAux.getIsNew())) {
						
						timestamp=asistenciadiariaDataAccess.getSetVersionRowAsistenciaDiaria(connexion,asistenciadiariaAux.getId());
						
						if(!asistenciadiaria.getVersionRow().equals(timestamp)) {	
							asistenciadiariaAux.setVersionRow(timestamp);
						}
								
						asistenciadiariaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAsistenciaDiarias()throws Exception {	
		if(asistenciadiarias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AsistenciaDiaria asistenciadiariaAux:asistenciadiarias) {
					if(asistenciadiariaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asistenciadiariaAux.getIsDeleted() || (asistenciadiariaAux.getIsChanged()&&!asistenciadiariaAux.getIsNew())) {
						
						timestamp=asistenciadiariaDataAccess.getSetVersionRowAsistenciaDiaria(connexion,asistenciadiariaAux.getId());
						
						if(!asistenciadiariaAux.getVersionRow().equals(timestamp)) {	
							asistenciadiariaAux.setVersionRow(timestamp);
						}
						
													
						asistenciadiariaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AsistenciaDiariaParameterReturnGeneral cargarCombosLoteForeignKeyAsistenciaDiariaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEstructuraSeccion) throws Exception {
		AsistenciaDiariaParameterReturnGeneral  asistenciadiariaReturnGeneral =new AsistenciaDiariaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-cargarCombosLoteForeignKeyAsistenciaDiariaWithConnection");connexion.begin();
			
			asistenciadiariaReturnGeneral =new AsistenciaDiariaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asistenciadiariaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asistenciadiariaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			asistenciadiariaReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Estructura> estructuraseccionsForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraseccionLogic=new EstructuraLogic();
			estructuraseccionLogic.setConnexion(this.connexion);
			estructuraseccionLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraSeccion.equals("NONE")) {
				estructuraseccionLogic.getTodosEstructuras(finalQueryGlobalEstructuraSeccion,new Pagination());
				estructuraseccionsForeignKey=estructuraseccionLogic.getEstructuras();
			}

			asistenciadiariaReturnGeneral.setestructuraseccionsForeignKey(estructuraseccionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return asistenciadiariaReturnGeneral;
	}
	
	public AsistenciaDiariaParameterReturnGeneral cargarCombosLoteForeignKeyAsistenciaDiaria(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEstructuraSeccion) throws Exception {
		AsistenciaDiariaParameterReturnGeneral  asistenciadiariaReturnGeneral =new AsistenciaDiariaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			asistenciadiariaReturnGeneral =new AsistenciaDiariaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asistenciadiariaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asistenciadiariaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			asistenciadiariaReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Estructura> estructuraseccionsForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraseccionLogic=new EstructuraLogic();
			estructuraseccionLogic.setConnexion(this.connexion);
			estructuraseccionLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructuraSeccion.equals("NONE")) {
				estructuraseccionLogic.getTodosEstructuras(finalQueryGlobalEstructuraSeccion,new Pagination());
				estructuraseccionsForeignKey=estructuraseccionLogic.getEstructuras();
			}

			asistenciadiariaReturnGeneral.setestructuraseccionsForeignKey(estructuraseccionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return asistenciadiariaReturnGeneral;
	}
	
	
	public void deepLoad(AsistenciaDiaria asistenciadiaria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToGet(asistenciadiaria,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asistenciadiaria.setEmpresa(asistenciadiariaDataAccess.getEmpresa(connexion,asistenciadiaria));
		asistenciadiaria.setEmpleado(asistenciadiariaDataAccess.getEmpleado(connexion,asistenciadiaria));
		asistenciadiaria.setEstructura(asistenciadiariaDataAccess.getEstructura(connexion,asistenciadiaria));
		asistenciadiaria.setEstructuraSeccion(asistenciadiariaDataAccess.getEstructuraSeccion(connexion,asistenciadiaria));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asistenciadiaria.setEmpresa(asistenciadiariaDataAccess.getEmpresa(connexion,asistenciadiaria));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asistenciadiaria.setEmpleado(asistenciadiariaDataAccess.getEmpleado(connexion,asistenciadiaria));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				asistenciadiaria.setEstructura(asistenciadiariaDataAccess.getEstructura(connexion,asistenciadiaria));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				asistenciadiaria.setEstructuraSeccion(asistenciadiariaDataAccess.getEstructuraSeccion(connexion,asistenciadiaria));
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
			asistenciadiaria.setEmpresa(asistenciadiariaDataAccess.getEmpresa(connexion,asistenciadiaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciadiaria.setEmpleado(asistenciadiariaDataAccess.getEmpleado(connexion,asistenciadiaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciadiaria.setEstructura(asistenciadiariaDataAccess.getEstructura(connexion,asistenciadiaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciadiaria.setEstructuraSeccion(asistenciadiariaDataAccess.getEstructuraSeccion(connexion,asistenciadiaria));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asistenciadiaria.setEmpresa(asistenciadiariaDataAccess.getEmpresa(connexion,asistenciadiaria));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asistenciadiaria.getEmpresa(),isDeep,deepLoadType,clases);
				
		asistenciadiaria.setEmpleado(asistenciadiariaDataAccess.getEmpleado(connexion,asistenciadiaria));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asistenciadiaria.getEmpleado(),isDeep,deepLoadType,clases);
				
		asistenciadiaria.setEstructura(asistenciadiariaDataAccess.getEstructura(connexion,asistenciadiaria));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(asistenciadiaria.getEstructura(),isDeep,deepLoadType,clases);
				
		asistenciadiaria.setEstructuraSeccion(asistenciadiariaDataAccess.getEstructuraSeccion(connexion,asistenciadiaria));
		EstructuraLogic estructuraseccionLogic= new EstructuraLogic(connexion);
		estructuraseccionLogic.deepLoad(asistenciadiaria.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asistenciadiaria.setEmpresa(asistenciadiariaDataAccess.getEmpresa(connexion,asistenciadiaria));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(asistenciadiaria.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asistenciadiaria.setEmpleado(asistenciadiariaDataAccess.getEmpleado(connexion,asistenciadiaria));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(asistenciadiaria.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				asistenciadiaria.setEstructura(asistenciadiariaDataAccess.getEstructura(connexion,asistenciadiaria));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(asistenciadiaria.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				asistenciadiaria.setEstructuraSeccion(asistenciadiariaDataAccess.getEstructuraSeccion(connexion,asistenciadiaria));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(asistenciadiaria.getEstructuraSeccion(),isDeep,deepLoadType,clases);				
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
			asistenciadiaria.setEmpresa(asistenciadiariaDataAccess.getEmpresa(connexion,asistenciadiaria));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(asistenciadiaria.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciadiaria.setEmpleado(asistenciadiariaDataAccess.getEmpleado(connexion,asistenciadiaria));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(asistenciadiaria.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciadiaria.setEstructura(asistenciadiariaDataAccess.getEstructura(connexion,asistenciadiaria));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(asistenciadiaria.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciadiaria.setEstructuraSeccion(asistenciadiariaDataAccess.getEstructuraSeccion(connexion,asistenciadiaria));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(asistenciadiaria.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AsistenciaDiaria asistenciadiaria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AsistenciaDiariaLogicAdditional.updateAsistenciaDiariaToSave(asistenciadiaria,this.arrDatoGeneral);
			
AsistenciaDiariaDataAccess.save(asistenciadiaria, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asistenciadiaria.getEmpresa(),connexion);

		EmpleadoDataAccess.save(asistenciadiaria.getEmpleado(),connexion);

		EstructuraDataAccess.save(asistenciadiaria.getEstructura(),connexion);

		EstructuraDataAccess.save(asistenciadiaria.getEstructuraSeccion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asistenciadiaria.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asistenciadiaria.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(asistenciadiaria.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(asistenciadiaria.getEstructuraSeccion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asistenciadiaria.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asistenciadiaria.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(asistenciadiaria.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asistenciadiaria.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(asistenciadiaria.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(asistenciadiaria.getEstructura(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(asistenciadiaria.getEstructuraSeccion(),connexion);
		EstructuraLogic estructuraseccionLogic= new EstructuraLogic(connexion);
		estructuraseccionLogic.deepLoad(asistenciadiaria.getEstructuraSeccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asistenciadiaria.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(asistenciadiaria.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asistenciadiaria.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(asistenciadiaria.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(asistenciadiaria.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(asistenciadiaria.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(asistenciadiaria.getEstructuraSeccion(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(asistenciadiaria.getEstructuraSeccion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AsistenciaDiaria.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(asistenciadiaria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(asistenciadiaria);
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
			this.deepLoad(this.asistenciadiaria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AsistenciaDiaria.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(asistenciadiarias!=null) {
				for(AsistenciaDiaria asistenciadiaria:asistenciadiarias) {
					this.deepLoad(asistenciadiaria,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(asistenciadiarias);
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
			if(asistenciadiarias!=null) {
				for(AsistenciaDiaria asistenciadiaria:asistenciadiarias) {
					this.deepLoad(asistenciadiaria,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(asistenciadiarias);
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
			this.getNewConnexionToDeep(AsistenciaDiaria.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(asistenciadiaria,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AsistenciaDiaria.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(asistenciadiarias!=null) {
				for(AsistenciaDiaria asistenciadiaria:asistenciadiarias) {
					this.deepSave(asistenciadiaria,isDeep,deepLoadType,clases);
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
			if(asistenciadiarias!=null) {
				for(AsistenciaDiaria asistenciadiaria:asistenciadiarias) {
					this.deepSave(asistenciadiaria,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAsistenciaDiariasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsistenciaDiariaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaDiariasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsistenciaDiariaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaDiariasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsistenciaDiariaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaDiariasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsistenciaDiariaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaDiariasFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,AsistenciaDiariaConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaDiariasFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,AsistenciaDiariaConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaDiariasFK_IdEstructuraSeccionWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura_seccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaDiaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraSeccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraSeccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_seccion,AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraSeccion);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraSeccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaDiariasFK_IdEstructuraSeccion(String sFinalQuery,Pagination pagination,Long id_estructura_seccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructuraSeccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructuraSeccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura_seccion,AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructuraSeccion);

			AsistenciaDiariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructuraSeccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(this.asistenciadiarias);
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
			if(AsistenciaDiariaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaDiariaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AsistenciaDiaria asistenciadiaria,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AsistenciaDiariaConstantesFunciones.ISCONAUDITORIA) {
				if(asistenciadiaria.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaDiariaDataAccess.TABLENAME, asistenciadiaria.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsistenciaDiariaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsistenciaDiariaLogic.registrarAuditoriaDetallesAsistenciaDiaria(connexion,asistenciadiaria,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(asistenciadiaria.getIsDeleted()) {
					/*if(!asistenciadiaria.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AsistenciaDiariaDataAccess.TABLENAME, asistenciadiaria.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AsistenciaDiariaLogic.registrarAuditoriaDetallesAsistenciaDiaria(connexion,asistenciadiaria,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaDiariaDataAccess.TABLENAME, asistenciadiaria.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(asistenciadiaria.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaDiariaDataAccess.TABLENAME, asistenciadiaria.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsistenciaDiariaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsistenciaDiariaLogic.registrarAuditoriaDetallesAsistenciaDiaria(connexion,asistenciadiaria,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAsistenciaDiaria(Connexion connexion,AsistenciaDiaria asistenciadiaria)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.getid_empresa().equals(asistenciadiaria.getAsistenciaDiariaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().getid_empresa()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().getid_empresa().toString();
				}
				if(asistenciadiaria.getid_empresa()!=null)
				{
					strValorNuevo=asistenciadiaria.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.getid_empleado().equals(asistenciadiaria.getAsistenciaDiariaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().getid_empleado()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().getid_empleado().toString();
				}
				if(asistenciadiaria.getid_empleado()!=null)
				{
					strValorNuevo=asistenciadiaria.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.getid_estructura().equals(asistenciadiaria.getAsistenciaDiariaOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().getid_estructura()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().getid_estructura().toString();
				}
				if(asistenciadiaria.getid_estructura()!=null)
				{
					strValorNuevo=asistenciadiaria.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.getid_estructura_seccion().equals(asistenciadiaria.getAsistenciaDiariaOriginal().getid_estructura_seccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().getid_estructura_seccion()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().getid_estructura_seccion().toString();
				}
				if(asistenciadiaria.getid_estructura_seccion()!=null)
				{
					strValorNuevo=asistenciadiaria.getid_estructura_seccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.getfecha().equals(asistenciadiaria.getAsistenciaDiariaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().getfecha()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().getfecha().toString();
				}
				if(asistenciadiaria.getfecha()!=null)
				{
					strValorNuevo=asistenciadiaria.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.gethora().equals(asistenciadiaria.getAsistenciaDiariaOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().gethora()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().gethora().toString();
				}
				if(asistenciadiaria.gethora()!=null)
				{
					strValorNuevo=asistenciadiaria.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.gethoras_atraso().equals(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_atraso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_atraso()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_atraso().toString();
				}
				if(asistenciadiaria.gethoras_atraso()!=null)
				{
					strValorNuevo=asistenciadiaria.gethoras_atraso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.HORASATRASO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.gethoras_falta().equals(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_falta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_falta()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_falta().toString();
				}
				if(asistenciadiaria.gethoras_falta()!=null)
				{
					strValorNuevo=asistenciadiaria.gethoras_falta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.HORASFALTA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.gethoras_permiso().equals(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_permiso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_permiso()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_permiso().toString();
				}
				if(asistenciadiaria.gethoras_permiso()!=null)
				{
					strValorNuevo=asistenciadiaria.gethoras_permiso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.HORASPERMISO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.gethoras_extra25().equals(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra25()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra25()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra25().toString();
				}
				if(asistenciadiaria.gethoras_extra25()!=null)
				{
					strValorNuevo=asistenciadiaria.gethoras_extra25().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.HORASEXTRA25,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.gethoras_extra50().equals(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra50()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra50()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra50().toString();
				}
				if(asistenciadiaria.gethoras_extra50()!=null)
				{
					strValorNuevo=asistenciadiaria.gethoras_extra50().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.HORASEXTRA50,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.gethoras_extra100().equals(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra100()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra100()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().gethoras_extra100().toString();
				}
				if(asistenciadiaria.gethoras_extra100()!=null)
				{
					strValorNuevo=asistenciadiaria.gethoras_extra100().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.HORASEXTRA100,strValorActual,strValorNuevo);
			}	
			
			if(asistenciadiaria.getIsNew()||!asistenciadiaria.getdescripcion().equals(asistenciadiaria.getAsistenciaDiariaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciadiaria.getAsistenciaDiariaOriginal().getdescripcion()!=null)
				{
					strValorActual=asistenciadiaria.getAsistenciaDiariaOriginal().getdescripcion();
				}
				if(asistenciadiaria.getdescripcion()!=null)
				{
					strValorNuevo=asistenciadiaria.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaDiariaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAsistenciaDiariaRelacionesWithConnection(AsistenciaDiaria asistenciadiaria) throws Exception {

		if(!asistenciadiaria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsistenciaDiariaRelacionesBase(asistenciadiaria,true);
		}
	}

	public void saveAsistenciaDiariaRelaciones(AsistenciaDiaria asistenciadiaria)throws Exception {

		if(!asistenciadiaria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsistenciaDiariaRelacionesBase(asistenciadiaria,false);
		}
	}

	public void saveAsistenciaDiariaRelacionesBase(AsistenciaDiaria asistenciadiaria,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AsistenciaDiaria-saveRelacionesWithConnection");}
	

			this.setAsistenciaDiaria(asistenciadiaria);

			if(AsistenciaDiariaLogicAdditional.validarSaveRelaciones(asistenciadiaria,this)) {

				AsistenciaDiariaLogicAdditional.updateRelacionesToSave(asistenciadiaria,this);

				if((asistenciadiaria.getIsNew()||asistenciadiaria.getIsChanged())&&!asistenciadiaria.getIsDeleted()) {
					this.saveAsistenciaDiaria();
					this.saveAsistenciaDiariaRelacionesDetalles();

				} else if(asistenciadiaria.getIsDeleted()) {
					this.saveAsistenciaDiariaRelacionesDetalles();
					this.saveAsistenciaDiaria();
				}

				AsistenciaDiariaLogicAdditional.updateRelacionesToSaveAfter(asistenciadiaria,this);

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
	
	
	private void saveAsistenciaDiariaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAsistenciaDiaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsistenciaDiariaConstantesFunciones.getClassesForeignKeysOfAsistenciaDiaria(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaDiaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsistenciaDiariaConstantesFunciones.getClassesRelationshipsOfAsistenciaDiaria(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
