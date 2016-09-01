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
import com.bydan.erp.contabilidad.util.AsientoContableCajaChicaConstantesFunciones;
import com.bydan.erp.contabilidad.util.AsientoContableCajaChicaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.AsientoContableCajaChicaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.AsientoContableCajaChica;
import com.bydan.erp.contabilidad.business.logic.AsientoContableCajaChicaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class AsientoContableCajaChicaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AsientoContableCajaChicaLogic.class);
	
	protected AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess; 	
	protected AsientoContableCajaChica asientocontablecajachica;
	protected List<AsientoContableCajaChica> asientocontablecajachicas;
	protected Object asientocontablecajachicaObject;	
	protected List<Object> asientocontablecajachicasObject;
	
	public static ClassValidator<AsientoContableCajaChica> asientocontablecajachicaValidator = new ClassValidator<AsientoContableCajaChica>(AsientoContableCajaChica.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AsientoContableCajaChicaLogicAdditional asientocontablecajachicaLogicAdditional=null;
	
	public AsientoContableCajaChicaLogicAdditional getAsientoContableCajaChicaLogicAdditional() {
		return this.asientocontablecajachicaLogicAdditional;
	}
	
	public void setAsientoContableCajaChicaLogicAdditional(AsientoContableCajaChicaLogicAdditional asientocontablecajachicaLogicAdditional) {
		try {
			this.asientocontablecajachicaLogicAdditional=asientocontablecajachicaLogicAdditional;
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
	
	
	
	
	public  AsientoContableCajaChicaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.asientocontablecajachicaDataAccess = new AsientoContableCajaChicaDataAccess();
			
			this.asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();
			this.asientocontablecajachica= new AsientoContableCajaChica();
			
			this.asientocontablecajachicaObject=new Object();
			this.asientocontablecajachicasObject=new ArrayList<Object>();
				
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
			
			this.asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			this.asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AsientoContableCajaChicaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.asientocontablecajachicaDataAccess = new AsientoContableCajaChicaDataAccess();
			this.asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();
			this.asientocontablecajachica= new AsientoContableCajaChica();
			this.asientocontablecajachicaObject=new Object();
			this.asientocontablecajachicasObject=new ArrayList<Object>();
			
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
			
			this.asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			this.asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AsientoContableCajaChica getAsientoContableCajaChica() throws Exception {	
		AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToGet(asientocontablecajachica,this.datosCliente,this.arrDatoGeneral);
		AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToGet(asientocontablecajachica,this.arrDatoGeneral);
		
		return asientocontablecajachica;
	}
		
	public void setAsientoContableCajaChica(AsientoContableCajaChica newAsientoContableCajaChica) {
		this.asientocontablecajachica = newAsientoContableCajaChica;
	}
	
	public AsientoContableCajaChicaDataAccess getAsientoContableCajaChicaDataAccess() {
		return asientocontablecajachicaDataAccess;
	}
	
	public void setAsientoContableCajaChicaDataAccess(AsientoContableCajaChicaDataAccess newasientocontablecajachicaDataAccess) {
		this.asientocontablecajachicaDataAccess = newasientocontablecajachicaDataAccess;
	}
	
	public List<AsientoContableCajaChica> getAsientoContableCajaChicas() throws Exception {		
		this.quitarAsientoContableCajaChicasNulos();
		
		AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToGets(asientocontablecajachicas,this.datosCliente,this.arrDatoGeneral);
		
		for (AsientoContableCajaChica asientocontablecajachicaLocal: asientocontablecajachicas ) {
			AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToGet(asientocontablecajachicaLocal,this.arrDatoGeneral);
		}
		
		return asientocontablecajachicas;
	}
	
	public void setAsientoContableCajaChicas(List<AsientoContableCajaChica> newAsientoContableCajaChicas) {
		this.asientocontablecajachicas = newAsientoContableCajaChicas;
	}
	
	public Object getAsientoContableCajaChicaObject() {	
		this.asientocontablecajachicaObject=this.asientocontablecajachicaDataAccess.getEntityObject();
		return this.asientocontablecajachicaObject;
	}
		
	public void setAsientoContableCajaChicaObject(Object newAsientoContableCajaChicaObject) {
		this.asientocontablecajachicaObject = newAsientoContableCajaChicaObject;
	}
	
	public List<Object> getAsientoContableCajaChicasObject() {		
		this.asientocontablecajachicasObject=this.asientocontablecajachicaDataAccess.getEntitiesObject();
		return this.asientocontablecajachicasObject;
	}
		
	public void setAsientoContableCajaChicasObject(List<Object> newAsientoContableCajaChicasObject) {
		this.asientocontablecajachicasObject = newAsientoContableCajaChicasObject;
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
		
		if(this.asientocontablecajachicaDataAccess!=null) {
			this.asientocontablecajachicaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			asientocontablecajachicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			asientocontablecajachicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		asientocontablecajachica = new  AsientoContableCajaChica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asientocontablecajachica=asientocontablecajachicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachica);
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		  		  
        try {
			
			asientocontablecajachica=asientocontablecajachicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		asientocontablecajachica = new  AsientoContableCajaChica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asientocontablecajachica=asientocontablecajachicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachica);
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		  		  
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		  		  
        try {
			
			asientocontablecajachica=asientocontablecajachicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		asientocontablecajachica = new  AsientoContableCajaChica();
		  		  
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =asientocontablecajachicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=asientocontablecajachicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asientocontablecajachica = new  AsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =asientocontablecajachicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=asientocontablecajachicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asientocontablecajachica = new  AsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =asientocontablecajachicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=asientocontablecajachicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
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
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
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
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
        try {			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
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
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
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
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
        try {
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
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
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
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
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		asientocontablecajachica = new  AsientoContableCajaChica();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachica=asientocontablecajachicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachica);
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
		asientocontablecajachica = new  AsientoContableCajaChica();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachica=asientocontablecajachicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
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
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		  		  
        try {
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAsientoContableCajaChicasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getTodosAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
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
	
	public  void  getTodosAsientoContableCajaChicas(String sFinalQuery,Pagination pagination)throws Exception {
		asientocontablecajachicas = new  ArrayList<AsientoContableCajaChica>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsientoContableCajaChica(asientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachica) throws Exception {
		Boolean estaValidado=false;
		
		if(asientocontablecajachica.getIsNew() || asientocontablecajachica.getIsChanged()) { 
			this.invalidValues = asientocontablecajachicaValidator.getInvalidValues(asientocontablecajachica);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(asientocontablecajachica);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAsientoContableCajaChica(List<AsientoContableCajaChica> AsientoContableCajaChicas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AsientoContableCajaChica asientocontablecajachicaLocal:asientocontablecajachicas) {				
			estaValidadoObjeto=this.validarGuardarAsientoContableCajaChica(asientocontablecajachicaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAsientoContableCajaChica(List<AsientoContableCajaChica> AsientoContableCajaChicas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsientoContableCajaChica(asientocontablecajachicas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAsientoContableCajaChica(AsientoContableCajaChica AsientoContableCajaChica) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsientoContableCajaChica(asientocontablecajachica)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AsientoContableCajaChica asientocontablecajachica) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+asientocontablecajachica.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AsientoContableCajaChicaConstantesFunciones.getAsientoContableCajaChicaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"asientocontablecajachica","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AsientoContableCajaChicaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AsientoContableCajaChicaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAsientoContableCajaChicaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-saveAsientoContableCajaChicaWithConnection");connexion.begin();			
			
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSave(this.asientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToSave(this.asientocontablecajachica,this.arrDatoGeneral);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asientocontablecajachica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAsientoContableCajaChica();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsientoContableCajaChica(this.asientocontablecajachica)) {
				AsientoContableCajaChicaDataAccess.save(this.asientocontablecajachica, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.asientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSaveAfter(this.asientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsientoContableCajaChica();
			
			connexion.commit();			
			
			if(this.asientocontablecajachica.getIsDeleted()) {
				this.asientocontablecajachica=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAsientoContableCajaChica()throws Exception {	
		try {	
			
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSave(this.asientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToSave(this.asientocontablecajachica,this.arrDatoGeneral);
			
			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asientocontablecajachica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsientoContableCajaChica(this.asientocontablecajachica)) {			
				AsientoContableCajaChicaDataAccess.save(this.asientocontablecajachica, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.asientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSaveAfter(this.asientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.asientocontablecajachica.getIsDeleted()) {
				this.asientocontablecajachica=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAsientoContableCajaChicasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-saveAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSaves(asientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAsientoContableCajaChicas();
			
			Boolean validadoTodosAsientoContableCajaChica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsientoContableCajaChica asientocontablecajachicaLocal:asientocontablecajachicas) {		
				if(asientocontablecajachicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToSave(asientocontablecajachicaLocal,this.arrDatoGeneral);
	        	
				AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asientocontablecajachicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsientoContableCajaChica(asientocontablecajachicaLocal)) {
					AsientoContableCajaChicaDataAccess.save(asientocontablecajachicaLocal, connexion);				
				} else {
					validadoTodosAsientoContableCajaChica=false;
				}
			}
			
			if(!validadoTodosAsientoContableCajaChica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSavesAfter(asientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsientoContableCajaChicas();
			
			connexion.commit();		
			
			this.quitarAsientoContableCajaChicasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAsientoContableCajaChicas()throws Exception {				
		 try {	
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSaves(asientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAsientoContableCajaChica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsientoContableCajaChica asientocontablecajachicaLocal:asientocontablecajachicas) {				
				if(asientocontablecajachicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToSave(asientocontablecajachicaLocal,this.arrDatoGeneral);
	        	
				AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asientocontablecajachicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsientoContableCajaChica(asientocontablecajachicaLocal)) {				
					AsientoContableCajaChicaDataAccess.save(asientocontablecajachicaLocal, connexion);				
				} else {
					validadoTodosAsientoContableCajaChica=false;
				}
			}
			
			if(!validadoTodosAsientoContableCajaChica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsientoContableCajaChicaLogicAdditional.checkAsientoContableCajaChicaToSavesAfter(asientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAsientoContableCajaChicasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsientoContableCajaChicaParameterReturnGeneral procesarAccionAsientoContableCajaChicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsientoContableCajaChica> asientocontablecajachicas,AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaParameterGeneral)throws Exception {
		 try {	
			AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaReturnGeneral=new AsientoContableCajaChicaParameterReturnGeneral();
	
			AsientoContableCajaChicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asientocontablecajachicas,asientocontablecajachicaParameterGeneral,asientocontablecajachicaReturnGeneral);
			
			return asientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsientoContableCajaChicaParameterReturnGeneral procesarAccionAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsientoContableCajaChica> asientocontablecajachicas,AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-procesarAccionAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaReturnGeneral=new AsientoContableCajaChicaParameterReturnGeneral();
	
			AsientoContableCajaChicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asientocontablecajachicas,asientocontablecajachicaParameterGeneral,asientocontablecajachicaReturnGeneral);
			
			this.connexion.commit();
			
			return asientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsientoContableCajaChicaParameterReturnGeneral procesarEventosAsientoContableCajaChicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsientoContableCajaChica> asientocontablecajachicas,AsientoContableCajaChica asientocontablecajachica,AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaParameterGeneral,Boolean isEsNuevoAsientoContableCajaChica,ArrayList<Classe> clases)throws Exception {
		 try {	
			AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaReturnGeneral=new AsientoContableCajaChicaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asientocontablecajachicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsientoContableCajaChicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asientocontablecajachicas,asientocontablecajachica,asientocontablecajachicaParameterGeneral,asientocontablecajachicaReturnGeneral,isEsNuevoAsientoContableCajaChica,clases);
			
			return asientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AsientoContableCajaChicaParameterReturnGeneral procesarEventosAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsientoContableCajaChica> asientocontablecajachicas,AsientoContableCajaChica asientocontablecajachica,AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaParameterGeneral,Boolean isEsNuevoAsientoContableCajaChica,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-procesarEventosAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaReturnGeneral=new AsientoContableCajaChicaParameterReturnGeneral();
	
			asientocontablecajachicaReturnGeneral.setAsientoContableCajaChica(asientocontablecajachica);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asientocontablecajachicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsientoContableCajaChicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asientocontablecajachicas,asientocontablecajachica,asientocontablecajachicaParameterGeneral,asientocontablecajachicaReturnGeneral,isEsNuevoAsientoContableCajaChica,clases);
			
			this.connexion.commit();
			
			return asientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsientoContableCajaChicaParameterReturnGeneral procesarImportacionAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-procesarImportacionAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			AsientoContableCajaChicaParameterReturnGeneral asientocontablecajachicaReturnGeneral=new AsientoContableCajaChicaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.asientocontablecajachicas=new ArrayList<AsientoContableCajaChica>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.asientocontablecajachica=new AsientoContableCajaChica();
				
				
				if(conColumnasBase) {this.asientocontablecajachica.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.asientocontablecajachica.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.asientocontablecajachica.setsecuencial(Long.parseLong(arrColumnas[iColumn++]));
				this.asientocontablecajachica.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.asientocontablecajachica.setes_proveedor(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.asientocontablecajachica.setdetalle(arrColumnas[iColumn++]);
				
				this.asientocontablecajachicas.add(this.asientocontablecajachica);
			}
			
			this.saveAsientoContableCajaChicas();
			
			this.connexion.commit();
			
			asientocontablecajachicaReturnGeneral.setConRetornoEstaProcesado(true);
			asientocontablecajachicaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return asientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAsientoContableCajaChicasEliminados() throws Exception {				
		
		List<AsientoContableCajaChica> asientocontablecajachicasAux= new ArrayList<AsientoContableCajaChica>();
		
		for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas) {
			if(!asientocontablecajachica.getIsDeleted()) {
				asientocontablecajachicasAux.add(asientocontablecajachica);
			}
		}
		
		asientocontablecajachicas=asientocontablecajachicasAux;
	}
	
	public void quitarAsientoContableCajaChicasNulos() throws Exception {				
		
		List<AsientoContableCajaChica> asientocontablecajachicasAux= new ArrayList<AsientoContableCajaChica>();
		
		for(AsientoContableCajaChica asientocontablecajachica : this.asientocontablecajachicas) {
			if(asientocontablecajachica==null) {
				asientocontablecajachicasAux.add(asientocontablecajachica);
			}
		}
		
		//this.asientocontablecajachicas=asientocontablecajachicasAux;
		
		this.asientocontablecajachicas.removeAll(asientocontablecajachicasAux);
	}
	
	public void getSetVersionRowAsientoContableCajaChicaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(asientocontablecajachica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((asientocontablecajachica.getIsDeleted() || (asientocontablecajachica.getIsChanged()&&!asientocontablecajachica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=asientocontablecajachicaDataAccess.getSetVersionRowAsientoContableCajaChica(connexion,asientocontablecajachica.getId());
				
				if(!asientocontablecajachica.getVersionRow().equals(timestamp)) {	
					asientocontablecajachica.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				asientocontablecajachica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAsientoContableCajaChica()throws Exception {	
		
		if(asientocontablecajachica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((asientocontablecajachica.getIsDeleted() || (asientocontablecajachica.getIsChanged()&&!asientocontablecajachica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=asientocontablecajachicaDataAccess.getSetVersionRowAsientoContableCajaChica(connexion,asientocontablecajachica.getId());
			
			try {							
				if(!asientocontablecajachica.getVersionRow().equals(timestamp)) {	
					asientocontablecajachica.setVersionRow(timestamp);
				}
				
				asientocontablecajachica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAsientoContableCajaChicasWithConnection()throws Exception {	
		if(asientocontablecajachicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AsientoContableCajaChica asientocontablecajachicaAux:asientocontablecajachicas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(asientocontablecajachicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asientocontablecajachicaAux.getIsDeleted() || (asientocontablecajachicaAux.getIsChanged()&&!asientocontablecajachicaAux.getIsNew())) {
						
						timestamp=asientocontablecajachicaDataAccess.getSetVersionRowAsientoContableCajaChica(connexion,asientocontablecajachicaAux.getId());
						
						if(!asientocontablecajachica.getVersionRow().equals(timestamp)) {	
							asientocontablecajachicaAux.setVersionRow(timestamp);
						}
								
						asientocontablecajachicaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAsientoContableCajaChicas()throws Exception {	
		if(asientocontablecajachicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AsientoContableCajaChica asientocontablecajachicaAux:asientocontablecajachicas) {
					if(asientocontablecajachicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asientocontablecajachicaAux.getIsDeleted() || (asientocontablecajachicaAux.getIsChanged()&&!asientocontablecajachicaAux.getIsNew())) {
						
						timestamp=asientocontablecajachicaDataAccess.getSetVersionRowAsientoContableCajaChica(connexion,asientocontablecajachicaAux.getId());
						
						if(!asientocontablecajachicaAux.getVersionRow().equals(timestamp)) {	
							asientocontablecajachicaAux.setVersionRow(timestamp);
						}
						
													
						asientocontablecajachicaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AsientoContableCajaChicaParameterReturnGeneral cargarCombosLoteForeignKeyAsientoContableCajaChicaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalUsuario,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalEstadoAsientoContableCajaChica,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoDocumento,String finalQueryGlobalCuentaContable,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTipoMovimientoModulo) throws Exception {
		AsientoContableCajaChicaParameterReturnGeneral  asientocontablecajachicaReturnGeneral =new AsientoContableCajaChicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-cargarCombosLoteForeignKeyAsientoContableCajaChicaWithConnection");connexion.begin();
			
			asientocontablecajachicaReturnGeneral =new AsientoContableCajaChicaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asientocontablecajachicaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			asientocontablecajachicaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			asientocontablecajachicaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			asientocontablecajachicaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			asientocontablecajachicaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			asientocontablecajachicaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			asientocontablecajachicaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			asientocontablecajachicaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asientocontablecajachicaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasForeignKey=new ArrayList<EstadoAsientoContableCajaChica>();
			EstadoAsientoContableCajaChicaLogic estadoasientocontablecajachicaLogic=new EstadoAsientoContableCajaChicaLogic();
			estadoasientocontablecajachicaLogic.setConnexion(this.connexion);
			estadoasientocontablecajachicaLogic.getEstadoAsientoContableCajaChicaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAsientoContableCajaChica.equals("NONE")) {
				estadoasientocontablecajachicaLogic.getTodosEstadoAsientoContableCajaChicas(finalQueryGlobalEstadoAsientoContableCajaChica,new Pagination());
				estadoasientocontablecajachicasForeignKey=estadoasientocontablecajachicaLogic.getEstadoAsientoContableCajaChicas();
			}

			asientocontablecajachicaReturnGeneral.setestadoasientocontablecajachicasForeignKey(estadoasientocontablecajachicasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			asientocontablecajachicaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			asientocontablecajachicaReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			asientocontablecajachicaReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			asientocontablecajachicaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			asientocontablecajachicaReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			asientocontablecajachicaReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			asientocontablecajachicaReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			asientocontablecajachicaReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return asientocontablecajachicaReturnGeneral;
	}
	
	public AsientoContableCajaChicaParameterReturnGeneral cargarCombosLoteForeignKeyAsientoContableCajaChica(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalUsuario,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalEstadoAsientoContableCajaChica,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoDocumento,String finalQueryGlobalCuentaContable,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTipoMovimientoModulo) throws Exception {
		AsientoContableCajaChicaParameterReturnGeneral  asientocontablecajachicaReturnGeneral =new AsientoContableCajaChicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			asientocontablecajachicaReturnGeneral =new AsientoContableCajaChicaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asientocontablecajachicaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			asientocontablecajachicaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			asientocontablecajachicaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			asientocontablecajachicaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			asientocontablecajachicaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			asientocontablecajachicaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			asientocontablecajachicaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			asientocontablecajachicaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asientocontablecajachicaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasForeignKey=new ArrayList<EstadoAsientoContableCajaChica>();
			EstadoAsientoContableCajaChicaLogic estadoasientocontablecajachicaLogic=new EstadoAsientoContableCajaChicaLogic();
			estadoasientocontablecajachicaLogic.setConnexion(this.connexion);
			estadoasientocontablecajachicaLogic.getEstadoAsientoContableCajaChicaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAsientoContableCajaChica.equals("NONE")) {
				estadoasientocontablecajachicaLogic.getTodosEstadoAsientoContableCajaChicas(finalQueryGlobalEstadoAsientoContableCajaChica,new Pagination());
				estadoasientocontablecajachicasForeignKey=estadoasientocontablecajachicaLogic.getEstadoAsientoContableCajaChicas();
			}

			asientocontablecajachicaReturnGeneral.setestadoasientocontablecajachicasForeignKey(estadoasientocontablecajachicasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			asientocontablecajachicaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			asientocontablecajachicaReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			asientocontablecajachicaReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			asientocontablecajachicaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			asientocontablecajachicaReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			asientocontablecajachicaReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			asientocontablecajachicaReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			asientocontablecajachicaReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return asientocontablecajachicaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyAsientoContableCajaChicaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic=new DetalleAsientoContableCajaChicaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyAsientoContableCajaChicaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleAsientoContableCajaChica.class));
											
			

			detalleasientocontablecajachicaLogic.setConnexion(this.getConnexion());
			detalleasientocontablecajachicaLogic.setDatosCliente(this.datosCliente);
			detalleasientocontablecajachicaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(AsientoContableCajaChica asientocontablecajachica:this.asientocontablecajachicas) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleAsientoContableCajaChicaConstantesFunciones.getClassesForeignKeysOfDetalleAsientoContableCajaChica(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleasientocontablecajachicaLogic.setDetalleAsientoContableCajaChicas(asientocontablecajachica.detalleasientocontablecajachicas);
				detalleasientocontablecajachicaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(AsientoContableCajaChica asientocontablecajachica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToGet(asientocontablecajachica,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asientocontablecajachica.setEmpresa(asientocontablecajachicaDataAccess.getEmpresa(connexion,asientocontablecajachica));
		asientocontablecajachica.setSucursal(asientocontablecajachicaDataAccess.getSucursal(connexion,asientocontablecajachica));
		asientocontablecajachica.setEjercicio(asientocontablecajachicaDataAccess.getEjercicio(connexion,asientocontablecajachica));
		asientocontablecajachica.setPeriodo(asientocontablecajachicaDataAccess.getPeriodo(connexion,asientocontablecajachica));
		asientocontablecajachica.setUsuario(asientocontablecajachicaDataAccess.getUsuario(connexion,asientocontablecajachica));
		asientocontablecajachica.setAnio(asientocontablecajachicaDataAccess.getAnio(connexion,asientocontablecajachica));
		asientocontablecajachica.setMes(asientocontablecajachicaDataAccess.getMes(connexion,asientocontablecajachica));
		asientocontablecajachica.setMoneda(asientocontablecajachicaDataAccess.getMoneda(connexion,asientocontablecajachica));
		asientocontablecajachica.setEmpleado(asientocontablecajachicaDataAccess.getEmpleado(connexion,asientocontablecajachica));
		asientocontablecajachica.setEstadoAsientoContableCajaChica(asientocontablecajachicaDataAccess.getEstadoAsientoContableCajaChica(connexion,asientocontablecajachica));
		asientocontablecajachica.setCliente(asientocontablecajachicaDataAccess.getCliente(connexion,asientocontablecajachica));
		asientocontablecajachica.setTransaccion(asientocontablecajachicaDataAccess.getTransaccion(connexion,asientocontablecajachica));
		asientocontablecajachica.setTipoDocumento(asientocontablecajachicaDataAccess.getTipoDocumento(connexion,asientocontablecajachica));
		asientocontablecajachica.setCuentaContable(asientocontablecajachicaDataAccess.getCuentaContable(connexion,asientocontablecajachica));
		asientocontablecajachica.setModulo(asientocontablecajachicaDataAccess.getModulo(connexion,asientocontablecajachica));
		asientocontablecajachica.setTipoMovimiento(asientocontablecajachicaDataAccess.getTipoMovimiento(connexion,asientocontablecajachica));
		asientocontablecajachica.setTipoTransaccionModulo(asientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,asientocontablecajachica));
		asientocontablecajachica.setTipoMovimientoModulo(asientocontablecajachicaDataAccess.getTipoMovimientoModulo(connexion,asientocontablecajachica));
		asientocontablecajachica.setDetalleAsientoContableCajaChicas(asientocontablecajachicaDataAccess.getDetalleAsientoContableCajaChicas(connexion,asientocontablecajachica));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asientocontablecajachica.setEmpresa(asientocontablecajachicaDataAccess.getEmpresa(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				asientocontablecajachica.setSucursal(asientocontablecajachicaDataAccess.getSucursal(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				asientocontablecajachica.setEjercicio(asientocontablecajachicaDataAccess.getEjercicio(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				asientocontablecajachica.setPeriodo(asientocontablecajachicaDataAccess.getPeriodo(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				asientocontablecajachica.setUsuario(asientocontablecajachicaDataAccess.getUsuario(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				asientocontablecajachica.setAnio(asientocontablecajachicaDataAccess.getAnio(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				asientocontablecajachica.setMes(asientocontablecajachicaDataAccess.getMes(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				asientocontablecajachica.setMoneda(asientocontablecajachicaDataAccess.getMoneda(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asientocontablecajachica.setEmpleado(asientocontablecajachicaDataAccess.getEmpleado(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContableCajaChica.class)) {
				asientocontablecajachica.setEstadoAsientoContableCajaChica(asientocontablecajachicaDataAccess.getEstadoAsientoContableCajaChica(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				asientocontablecajachica.setCliente(asientocontablecajachicaDataAccess.getCliente(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				asientocontablecajachica.setTransaccion(asientocontablecajachicaDataAccess.getTransaccion(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				asientocontablecajachica.setTipoDocumento(asientocontablecajachicaDataAccess.getTipoDocumento(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				asientocontablecajachica.setCuentaContable(asientocontablecajachicaDataAccess.getCuentaContable(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				asientocontablecajachica.setModulo(asientocontablecajachicaDataAccess.getModulo(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				asientocontablecajachica.setTipoMovimiento(asientocontablecajachicaDataAccess.getTipoMovimiento(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				asientocontablecajachica.setTipoTransaccionModulo(asientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				asientocontablecajachica.setTipoMovimientoModulo(asientocontablecajachicaDataAccess.getTipoMovimientoModulo(connexion,asientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(DetalleAsientoContableCajaChica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontablecajachica.setDetalleAsientoContableCajaChicas(asientocontablecajachicaDataAccess.getDetalleAsientoContableCajaChicas(connexion,asientocontablecajachica));

				if(this.isConDeep) {
					DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic= new DetalleAsientoContableCajaChicaLogic(this.connexion);
					detalleasientocontablecajachicaLogic.setDetalleAsientoContableCajaChicas(asientocontablecajachica.getDetalleAsientoContableCajaChicas());
					ArrayList<Classe> classesLocal=DetalleAsientoContableCajaChicaConstantesFunciones.getClassesForeignKeysOfDetalleAsientoContableCajaChica(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleasientocontablecajachicaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(detalleasientocontablecajachicaLogic.getDetalleAsientoContableCajaChicas());
					asientocontablecajachica.setDetalleAsientoContableCajaChicas(detalleasientocontablecajachicaLogic.getDetalleAsientoContableCajaChicas());
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
			asientocontablecajachica.setEmpresa(asientocontablecajachicaDataAccess.getEmpresa(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setSucursal(asientocontablecajachicaDataAccess.getSucursal(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setEjercicio(asientocontablecajachicaDataAccess.getEjercicio(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setPeriodo(asientocontablecajachicaDataAccess.getPeriodo(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setUsuario(asientocontablecajachicaDataAccess.getUsuario(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setAnio(asientocontablecajachicaDataAccess.getAnio(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setMes(asientocontablecajachicaDataAccess.getMes(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setMoneda(asientocontablecajachicaDataAccess.getMoneda(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setEmpleado(asientocontablecajachicaDataAccess.getEmpleado(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAsientoContableCajaChica.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setEstadoAsientoContableCajaChica(asientocontablecajachicaDataAccess.getEstadoAsientoContableCajaChica(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setCliente(asientocontablecajachicaDataAccess.getCliente(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTransaccion(asientocontablecajachicaDataAccess.getTransaccion(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoDocumento(asientocontablecajachicaDataAccess.getTipoDocumento(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setCuentaContable(asientocontablecajachicaDataAccess.getCuentaContable(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setModulo(asientocontablecajachicaDataAccess.getModulo(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoMovimiento(asientocontablecajachicaDataAccess.getTipoMovimiento(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoTransaccionModulo(asientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,asientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoMovimientoModulo(asientocontablecajachicaDataAccess.getTipoMovimientoModulo(connexion,asientocontablecajachica));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleAsientoContableCajaChica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleAsientoContableCajaChica.class));
			asientocontablecajachica.setDetalleAsientoContableCajaChicas(asientocontablecajachicaDataAccess.getDetalleAsientoContableCajaChicas(connexion,asientocontablecajachica));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asientocontablecajachica.setEmpresa(asientocontablecajachicaDataAccess.getEmpresa(connexion,asientocontablecajachica));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setSucursal(asientocontablecajachicaDataAccess.getSucursal(connexion,asientocontablecajachica));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(asientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setEjercicio(asientocontablecajachicaDataAccess.getEjercicio(connexion,asientocontablecajachica));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(asientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setPeriodo(asientocontablecajachicaDataAccess.getPeriodo(connexion,asientocontablecajachica));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(asientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setUsuario(asientocontablecajachicaDataAccess.getUsuario(connexion,asientocontablecajachica));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(asientocontablecajachica.getUsuario(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setAnio(asientocontablecajachicaDataAccess.getAnio(connexion,asientocontablecajachica));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(asientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setMes(asientocontablecajachicaDataAccess.getMes(connexion,asientocontablecajachica));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(asientocontablecajachica.getMes(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setMoneda(asientocontablecajachicaDataAccess.getMoneda(connexion,asientocontablecajachica));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(asientocontablecajachica.getMoneda(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setEmpleado(asientocontablecajachicaDataAccess.getEmpleado(connexion,asientocontablecajachica));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asientocontablecajachica.getEmpleado(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setEstadoAsientoContableCajaChica(asientocontablecajachicaDataAccess.getEstadoAsientoContableCajaChica(connexion,asientocontablecajachica));
		EstadoAsientoContableCajaChicaLogic estadoasientocontablecajachicaLogic= new EstadoAsientoContableCajaChicaLogic(connexion);
		estadoasientocontablecajachicaLogic.deepLoad(asientocontablecajachica.getEstadoAsientoContableCajaChica(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setCliente(asientocontablecajachicaDataAccess.getCliente(connexion,asientocontablecajachica));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(asientocontablecajachica.getCliente(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setTransaccion(asientocontablecajachicaDataAccess.getTransaccion(connexion,asientocontablecajachica));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(asientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setTipoDocumento(asientocontablecajachicaDataAccess.getTipoDocumento(connexion,asientocontablecajachica));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(asientocontablecajachica.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setCuentaContable(asientocontablecajachicaDataAccess.getCuentaContable(connexion,asientocontablecajachica));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(asientocontablecajachica.getCuentaContable(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setModulo(asientocontablecajachicaDataAccess.getModulo(connexion,asientocontablecajachica));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(asientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setTipoMovimiento(asientocontablecajachicaDataAccess.getTipoMovimiento(connexion,asientocontablecajachica));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(asientocontablecajachica.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setTipoTransaccionModulo(asientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,asientocontablecajachica));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(asientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		asientocontablecajachica.setTipoMovimientoModulo(asientocontablecajachicaDataAccess.getTipoMovimientoModulo(connexion,asientocontablecajachica));
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(asientocontablecajachica.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		asientocontablecajachica.setDetalleAsientoContableCajaChicas(asientocontablecajachicaDataAccess.getDetalleAsientoContableCajaChicas(connexion,asientocontablecajachica));

		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:asientocontablecajachica.getDetalleAsientoContableCajaChicas()) {
			DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic= new DetalleAsientoContableCajaChicaLogic(connexion);
			detalleasientocontablecajachicaLogic.deepLoad(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asientocontablecajachica.setEmpresa(asientocontablecajachicaDataAccess.getEmpresa(connexion,asientocontablecajachica));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(asientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				asientocontablecajachica.setSucursal(asientocontablecajachicaDataAccess.getSucursal(connexion,asientocontablecajachica));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(asientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				asientocontablecajachica.setEjercicio(asientocontablecajachicaDataAccess.getEjercicio(connexion,asientocontablecajachica));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(asientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				asientocontablecajachica.setPeriodo(asientocontablecajachicaDataAccess.getPeriodo(connexion,asientocontablecajachica));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(asientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				asientocontablecajachica.setUsuario(asientocontablecajachicaDataAccess.getUsuario(connexion,asientocontablecajachica));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(asientocontablecajachica.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				asientocontablecajachica.setAnio(asientocontablecajachicaDataAccess.getAnio(connexion,asientocontablecajachica));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(asientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				asientocontablecajachica.setMes(asientocontablecajachicaDataAccess.getMes(connexion,asientocontablecajachica));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(asientocontablecajachica.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				asientocontablecajachica.setMoneda(asientocontablecajachicaDataAccess.getMoneda(connexion,asientocontablecajachica));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(asientocontablecajachica.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asientocontablecajachica.setEmpleado(asientocontablecajachicaDataAccess.getEmpleado(connexion,asientocontablecajachica));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(asientocontablecajachica.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContableCajaChica.class)) {
				asientocontablecajachica.setEstadoAsientoContableCajaChica(asientocontablecajachicaDataAccess.getEstadoAsientoContableCajaChica(connexion,asientocontablecajachica));
				EstadoAsientoContableCajaChicaLogic estadoasientocontablecajachicaLogic= new EstadoAsientoContableCajaChicaLogic(connexion);
				estadoasientocontablecajachicaLogic.deepLoad(asientocontablecajachica.getEstadoAsientoContableCajaChica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				asientocontablecajachica.setCliente(asientocontablecajachicaDataAccess.getCliente(connexion,asientocontablecajachica));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(asientocontablecajachica.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				asientocontablecajachica.setTransaccion(asientocontablecajachicaDataAccess.getTransaccion(connexion,asientocontablecajachica));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(asientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				asientocontablecajachica.setTipoDocumento(asientocontablecajachicaDataAccess.getTipoDocumento(connexion,asientocontablecajachica));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(asientocontablecajachica.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				asientocontablecajachica.setCuentaContable(asientocontablecajachicaDataAccess.getCuentaContable(connexion,asientocontablecajachica));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(asientocontablecajachica.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				asientocontablecajachica.setModulo(asientocontablecajachicaDataAccess.getModulo(connexion,asientocontablecajachica));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(asientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				asientocontablecajachica.setTipoMovimiento(asientocontablecajachicaDataAccess.getTipoMovimiento(connexion,asientocontablecajachica));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(asientocontablecajachica.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				asientocontablecajachica.setTipoTransaccionModulo(asientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,asientocontablecajachica));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(asientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				asientocontablecajachica.setTipoMovimientoModulo(asientocontablecajachicaDataAccess.getTipoMovimientoModulo(connexion,asientocontablecajachica));
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepLoad(asientocontablecajachica.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleAsientoContableCajaChica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontablecajachica.setDetalleAsientoContableCajaChicas(asientocontablecajachicaDataAccess.getDetalleAsientoContableCajaChicas(connexion,asientocontablecajachica));

				for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:asientocontablecajachica.getDetalleAsientoContableCajaChicas()) {
					DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic= new DetalleAsientoContableCajaChicaLogic(connexion);
					detalleasientocontablecajachicaLogic.deepLoad(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
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
			asientocontablecajachica.setEmpresa(asientocontablecajachicaDataAccess.getEmpresa(connexion,asientocontablecajachica));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(asientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setSucursal(asientocontablecajachicaDataAccess.getSucursal(connexion,asientocontablecajachica));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(asientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setEjercicio(asientocontablecajachicaDataAccess.getEjercicio(connexion,asientocontablecajachica));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(asientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setPeriodo(asientocontablecajachicaDataAccess.getPeriodo(connexion,asientocontablecajachica));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(asientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setUsuario(asientocontablecajachicaDataAccess.getUsuario(connexion,asientocontablecajachica));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(asientocontablecajachica.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setAnio(asientocontablecajachicaDataAccess.getAnio(connexion,asientocontablecajachica));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(asientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setMes(asientocontablecajachicaDataAccess.getMes(connexion,asientocontablecajachica));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(asientocontablecajachica.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setMoneda(asientocontablecajachicaDataAccess.getMoneda(connexion,asientocontablecajachica));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(asientocontablecajachica.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setEmpleado(asientocontablecajachicaDataAccess.getEmpleado(connexion,asientocontablecajachica));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(asientocontablecajachica.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAsientoContableCajaChica.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setEstadoAsientoContableCajaChica(asientocontablecajachicaDataAccess.getEstadoAsientoContableCajaChica(connexion,asientocontablecajachica));
			EstadoAsientoContableCajaChicaLogic estadoasientocontablecajachicaLogic= new EstadoAsientoContableCajaChicaLogic(connexion);
			estadoasientocontablecajachicaLogic.deepLoad(asientocontablecajachica.getEstadoAsientoContableCajaChica(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setCliente(asientocontablecajachicaDataAccess.getCliente(connexion,asientocontablecajachica));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(asientocontablecajachica.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTransaccion(asientocontablecajachicaDataAccess.getTransaccion(connexion,asientocontablecajachica));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(asientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoDocumento(asientocontablecajachicaDataAccess.getTipoDocumento(connexion,asientocontablecajachica));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(asientocontablecajachica.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setCuentaContable(asientocontablecajachicaDataAccess.getCuentaContable(connexion,asientocontablecajachica));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(asientocontablecajachica.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setModulo(asientocontablecajachicaDataAccess.getModulo(connexion,asientocontablecajachica));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(asientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoMovimiento(asientocontablecajachicaDataAccess.getTipoMovimiento(connexion,asientocontablecajachica));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(asientocontablecajachica.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoTransaccionModulo(asientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,asientocontablecajachica));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(asientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontablecajachica.setTipoMovimientoModulo(asientocontablecajachicaDataAccess.getTipoMovimientoModulo(connexion,asientocontablecajachica));
			TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
			tipomovimientomoduloLogic.deepLoad(asientocontablecajachica.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleAsientoContableCajaChica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleAsientoContableCajaChica.class));
			asientocontablecajachica.setDetalleAsientoContableCajaChicas(asientocontablecajachicaDataAccess.getDetalleAsientoContableCajaChicas(connexion,asientocontablecajachica));

			for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:asientocontablecajachica.getDetalleAsientoContableCajaChicas()) {
				DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic= new DetalleAsientoContableCajaChicaLogic(connexion);
				detalleasientocontablecajachicaLogic.deepLoad(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AsientoContableCajaChica asientocontablecajachica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AsientoContableCajaChicaLogicAdditional.updateAsientoContableCajaChicaToSave(asientocontablecajachica,this.arrDatoGeneral);
			
AsientoContableCajaChicaDataAccess.save(asientocontablecajachica, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asientocontablecajachica.getEmpresa(),connexion);

		SucursalDataAccess.save(asientocontablecajachica.getSucursal(),connexion);

		EjercicioDataAccess.save(asientocontablecajachica.getEjercicio(),connexion);

		PeriodoDataAccess.save(asientocontablecajachica.getPeriodo(),connexion);

		UsuarioDataAccess.save(asientocontablecajachica.getUsuario(),connexion);

		AnioDataAccess.save(asientocontablecajachica.getAnio(),connexion);

		MesDataAccess.save(asientocontablecajachica.getMes(),connexion);

		MonedaDataAccess.save(asientocontablecajachica.getMoneda(),connexion);

		EmpleadoDataAccess.save(asientocontablecajachica.getEmpleado(),connexion);

		EstadoAsientoContableCajaChicaDataAccess.save(asientocontablecajachica.getEstadoAsientoContableCajaChica(),connexion);

		ClienteDataAccess.save(asientocontablecajachica.getCliente(),connexion);

		TransaccionDataAccess.save(asientocontablecajachica.getTransaccion(),connexion);

		TipoDocumentoDataAccess.save(asientocontablecajachica.getTipoDocumento(),connexion);

		CuentaContableDataAccess.save(asientocontablecajachica.getCuentaContable(),connexion);

		ModuloDataAccess.save(asientocontablecajachica.getModulo(),connexion);

		TipoMovimientoDataAccess.save(asientocontablecajachica.getTipoMovimiento(),connexion);

		TipoTransaccionModuloDataAccess.save(asientocontablecajachica.getTipoTransaccionModulo(),connexion);

		TipoMovimientoModuloDataAccess.save(asientocontablecajachica.getTipoMovimientoModulo(),connexion);

		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:asientocontablecajachica.getDetalleAsientoContableCajaChicas()) {
			detalleasientocontablecajachica.setid_asiento_contable_caja_chica(asientocontablecajachica.getId());
			DetalleAsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asientocontablecajachica.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(asientocontablecajachica.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(asientocontablecajachica.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(asientocontablecajachica.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(asientocontablecajachica.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(asientocontablecajachica.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(asientocontablecajachica.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(asientocontablecajachica.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asientocontablecajachica.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContableCajaChica.class)) {
				EstadoAsientoContableCajaChicaDataAccess.save(asientocontablecajachica.getEstadoAsientoContableCajaChica(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(asientocontablecajachica.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(asientocontablecajachica.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(asientocontablecajachica.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(asientocontablecajachica.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(asientocontablecajachica.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(asientocontablecajachica.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(asientocontablecajachica.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(asientocontablecajachica.getTipoMovimientoModulo(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleAsientoContableCajaChica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:asientocontablecajachica.getDetalleAsientoContableCajaChicas()) {
					detalleasientocontablecajachica.setid_asiento_contable_caja_chica(asientocontablecajachica.getId());
					DetalleAsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asientocontablecajachica.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(asientocontablecajachica.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(asientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(asientocontablecajachica.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(asientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(asientocontablecajachica.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(asientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(asientocontablecajachica.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(asientocontablecajachica.getUsuario(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(asientocontablecajachica.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(asientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(asientocontablecajachica.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(asientocontablecajachica.getMes(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(asientocontablecajachica.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(asientocontablecajachica.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(asientocontablecajachica.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asientocontablecajachica.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstadoAsientoContableCajaChicaDataAccess.save(asientocontablecajachica.getEstadoAsientoContableCajaChica(),connexion);
		EstadoAsientoContableCajaChicaLogic estadoasientocontablecajachicaLogic= new EstadoAsientoContableCajaChicaLogic(connexion);
		estadoasientocontablecajachicaLogic.deepLoad(asientocontablecajachica.getEstadoAsientoContableCajaChica(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(asientocontablecajachica.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(asientocontablecajachica.getCliente(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(asientocontablecajachica.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(asientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(asientocontablecajachica.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(asientocontablecajachica.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(asientocontablecajachica.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(asientocontablecajachica.getCuentaContable(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(asientocontablecajachica.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(asientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(asientocontablecajachica.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(asientocontablecajachica.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(asientocontablecajachica.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(asientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		TipoMovimientoModuloDataAccess.save(asientocontablecajachica.getTipoMovimientoModulo(),connexion);
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(asientocontablecajachica.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:asientocontablecajachica.getDetalleAsientoContableCajaChicas()) {
			DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic= new DetalleAsientoContableCajaChicaLogic(connexion);
			detalleasientocontablecajachica.setid_asiento_contable_caja_chica(asientocontablecajachica.getId());
			DetalleAsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica,connexion);
			detalleasientocontablecajachicaLogic.deepSave(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asientocontablecajachica.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(asientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(asientocontablecajachica.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(asientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(asientocontablecajachica.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(asientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(asientocontablecajachica.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(asientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(asientocontablecajachica.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(asientocontablecajachica.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(asientocontablecajachica.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(asientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(asientocontablecajachica.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(asientocontablecajachica.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(asientocontablecajachica.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(asientocontablecajachica.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asientocontablecajachica.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(asientocontablecajachica.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContableCajaChica.class)) {
				EstadoAsientoContableCajaChicaDataAccess.save(asientocontablecajachica.getEstadoAsientoContableCajaChica(),connexion);
				EstadoAsientoContableCajaChicaLogic estadoasientocontablecajachicaLogic= new EstadoAsientoContableCajaChicaLogic(connexion);
				estadoasientocontablecajachicaLogic.deepSave(asientocontablecajachica.getEstadoAsientoContableCajaChica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(asientocontablecajachica.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(asientocontablecajachica.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(asientocontablecajachica.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(asientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(asientocontablecajachica.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(asientocontablecajachica.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(asientocontablecajachica.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(asientocontablecajachica.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(asientocontablecajachica.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(asientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(asientocontablecajachica.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(asientocontablecajachica.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(asientocontablecajachica.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(asientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(asientocontablecajachica.getTipoMovimientoModulo(),connexion);
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepSave(asientocontablecajachica.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleAsientoContableCajaChica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:asientocontablecajachica.getDetalleAsientoContableCajaChicas()) {
					DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic= new DetalleAsientoContableCajaChicaLogic(connexion);
					detalleasientocontablecajachica.setid_asiento_contable_caja_chica(asientocontablecajachica.getId());
					DetalleAsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica,connexion);
					detalleasientocontablecajachicaLogic.deepSave(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(AsientoContableCajaChica.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(asientocontablecajachica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(asientocontablecajachica);
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
			this.deepLoad(this.asientocontablecajachica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AsientoContableCajaChica.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(asientocontablecajachicas!=null) {
				for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas) {
					this.deepLoad(asientocontablecajachica,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(asientocontablecajachicas);
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
			if(asientocontablecajachicas!=null) {
				for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas) {
					this.deepLoad(asientocontablecajachica,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(asientocontablecajachicas);
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
			this.getNewConnexionToDeep(AsientoContableCajaChica.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(asientocontablecajachica,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AsientoContableCajaChica.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(asientocontablecajachicas!=null) {
				for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas) {
					this.deepSave(asientocontablecajachica,isDeep,deepLoadType,clases);
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
			if(asientocontablecajachicas!=null) {
				for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas) {
					this.deepSave(asientocontablecajachica,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAsientoContableCajaChicasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,AsientoContableCajaChicaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,AsientoContableCajaChicaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AsientoContableCajaChicaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AsientoContableCajaChicaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsientoContableCajaChicaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsientoContableCajaChicaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdEstadoAsientoContableCajaChicaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAsientoContableCajaChica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAsientoContableCajaChica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_asiento_contable,AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAsientoContableCajaChica);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoAsientoContableCajaChica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdEstadoAsientoContableCajaChica(String sFinalQuery,Pagination pagination,Long id_estado_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAsientoContableCajaChica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAsientoContableCajaChica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_asiento_contable,AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAsientoContableCajaChica);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoAsientoContableCajaChica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,AsientoContableCajaChicaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,AsientoContableCajaChicaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AsientoContableCajaChicaConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AsientoContableCajaChicaConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,AsientoContableCajaChicaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,AsientoContableCajaChicaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,AsientoContableCajaChicaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,AsientoContableCajaChicaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContableCajaChicasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AsientoContableCajaChicaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContableCajaChicasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AsientoContableCajaChicaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContableCajaChica(this.asientocontablecajachicas);
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
			if(AsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableCajaChicaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AsientoContableCajaChica asientocontablecajachica,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIA) {
				if(asientocontablecajachica.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableCajaChicaDataAccess.TABLENAME, asientocontablecajachica.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsientoContableCajaChicaLogic.registrarAuditoriaDetallesAsientoContableCajaChica(connexion,asientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(asientocontablecajachica.getIsDeleted()) {
					/*if(!asientocontablecajachica.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AsientoContableCajaChicaDataAccess.TABLENAME, asientocontablecajachica.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AsientoContableCajaChicaLogic.registrarAuditoriaDetallesAsientoContableCajaChica(connexion,asientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableCajaChicaDataAccess.TABLENAME, asientocontablecajachica.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(asientocontablecajachica.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableCajaChicaDataAccess.TABLENAME, asientocontablecajachica.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsientoContableCajaChicaLogic.registrarAuditoriaDetallesAsientoContableCajaChica(connexion,asientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAsientoContableCajaChica(Connexion connexion,AsientoContableCajaChica asientocontablecajachica)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_empresa().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_empresa()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_empresa().toString();
				}
				if(asientocontablecajachica.getid_empresa()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_sucursal().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_sucursal()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_sucursal().toString();
				}
				if(asientocontablecajachica.getid_sucursal()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_ejercicio().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_ejercicio().toString();
				}
				if(asientocontablecajachica.getid_ejercicio()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_periodo().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_periodo()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_periodo().toString();
				}
				if(asientocontablecajachica.getid_periodo()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_usuario().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_usuario()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_usuario().toString();
				}
				if(asientocontablecajachica.getid_usuario()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_anio().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_anio()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_anio().toString();
				}
				if(asientocontablecajachica.getid_anio()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_mes().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_mes()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_mes().toString();
				}
				if(asientocontablecajachica.getid_mes()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getsecuencial().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getsecuencial()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getsecuencial().toString();
				}
				if(asientocontablecajachica.getsecuencial()!=null)
				{
					strValorNuevo=asientocontablecajachica.getsecuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_moneda().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_moneda()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_moneda().toString();
				}
				if(asientocontablecajachica.getid_moneda()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getfecha().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getfecha()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getfecha().toString();
				}
				if(asientocontablecajachica.getfecha()!=null)
				{
					strValorNuevo=asientocontablecajachica.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_empleado().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_empleado()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_empleado().toString();
				}
				if(asientocontablecajachica.getid_empleado()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_estado_asiento_contable().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_estado_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_estado_asiento_contable()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_estado_asiento_contable().toString();
				}
				if(asientocontablecajachica.getid_estado_asiento_contable()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_estado_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getes_proveedor().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getes_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getes_proveedor()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getes_proveedor().toString();
				}
				if(asientocontablecajachica.getes_proveedor()!=null)
				{
					strValorNuevo=asientocontablecajachica.getes_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_cliente().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_cliente()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_cliente().toString();
				}
				if(asientocontablecajachica.getid_cliente()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_transaccion().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_transaccion()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_transaccion().toString();
				}
				if(asientocontablecajachica.getid_transaccion()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_tipo_documento().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_documento().toString();
				}
				if(asientocontablecajachica.getid_tipo_documento()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_cuenta_contable().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_cuenta_contable().toString();
				}
				if(asientocontablecajachica.getid_cuenta_contable()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getdetalle().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getdetalle()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getdetalle();
				}
				if(asientocontablecajachica.getdetalle()!=null)
				{
					strValorNuevo=asientocontablecajachica.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_modulo().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_modulo()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_modulo().toString();
				}
				if(asientocontablecajachica.getid_modulo()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_tipo_movimiento().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_movimiento().toString();
				}
				if(asientocontablecajachica.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_tipo_transaccion_modulo().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(asientocontablecajachica.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontablecajachica.getIsNew()||!asientocontablecajachica.getid_tipo_movimiento_modulo().equals(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_movimiento_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_movimiento_modulo()!=null)
				{
					strValorActual=asientocontablecajachica.getAsientoContableCajaChicaOriginal().getid_tipo_movimiento_modulo().toString();
				}
				if(asientocontablecajachica.getid_tipo_movimiento_modulo()!=null)
				{
					strValorNuevo=asientocontablecajachica.getid_tipo_movimiento_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAsientoContableCajaChicaRelacionesWithConnection(AsientoContableCajaChica asientocontablecajachica,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas) throws Exception {

		if(!asientocontablecajachica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsientoContableCajaChicaRelacionesBase(asientocontablecajachica,detalleasientocontablecajachicas,true);
		}
	}

	public void saveAsientoContableCajaChicaRelaciones(AsientoContableCajaChica asientocontablecajachica,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas)throws Exception {

		if(!asientocontablecajachica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsientoContableCajaChicaRelacionesBase(asientocontablecajachica,detalleasientocontablecajachicas,false);
		}
	}

	public void saveAsientoContableCajaChicaRelacionesBase(AsientoContableCajaChica asientocontablecajachica,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AsientoContableCajaChica-saveRelacionesWithConnection");}
	
			asientocontablecajachica.setDetalleAsientoContableCajaChicas(detalleasientocontablecajachicas);

			this.setAsientoContableCajaChica(asientocontablecajachica);

			if(AsientoContableCajaChicaLogicAdditional.validarSaveRelaciones(asientocontablecajachica,this)) {

				AsientoContableCajaChicaLogicAdditional.updateRelacionesToSave(asientocontablecajachica,this);

				if((asientocontablecajachica.getIsNew()||asientocontablecajachica.getIsChanged())&&!asientocontablecajachica.getIsDeleted()) {
					this.saveAsientoContableCajaChica();
					this.saveAsientoContableCajaChicaRelacionesDetalles(detalleasientocontablecajachicas);

				} else if(asientocontablecajachica.getIsDeleted()) {
					this.saveAsientoContableCajaChicaRelacionesDetalles(detalleasientocontablecajachicas);
					this.saveAsientoContableCajaChica();
				}

				AsientoContableCajaChicaLogicAdditional.updateRelacionesToSaveAfter(asientocontablecajachica,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleAsientoContableCajaChicaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleAsientoContableCajaChicas(detalleasientocontablecajachicas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveAsientoContableCajaChicaRelacionesDetalles(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas)throws Exception {
		try {
	

			Long idAsientoContableCajaChicaActual=this.getAsientoContableCajaChica().getId();

			DetalleAsientoContableCajaChicaLogic detalleasientocontablecajachicaLogic_Desde_AsientoContableCajaChica=new DetalleAsientoContableCajaChicaLogic();
			detalleasientocontablecajachicaLogic_Desde_AsientoContableCajaChica.setDetalleAsientoContableCajaChicas(detalleasientocontablecajachicas);

			detalleasientocontablecajachicaLogic_Desde_AsientoContableCajaChica.setConnexion(this.getConnexion());
			detalleasientocontablecajachicaLogic_Desde_AsientoContableCajaChica.setDatosCliente(this.datosCliente);

			for(DetalleAsientoContableCajaChica detalleasientocontablecajachica_Desde_AsientoContableCajaChica:detalleasientocontablecajachicaLogic_Desde_AsientoContableCajaChica.getDetalleAsientoContableCajaChicas()) {
				detalleasientocontablecajachica_Desde_AsientoContableCajaChica.setid_asiento_contable_caja_chica(idAsientoContableCajaChicaActual);
			}

			detalleasientocontablecajachicaLogic_Desde_AsientoContableCajaChica.saveDetalleAsientoContableCajaChicas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsientoContableCajaChicaConstantesFunciones.getClassesForeignKeysOfAsientoContableCajaChica(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsOfAsientoContableCajaChica(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
