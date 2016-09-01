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
import com.bydan.erp.nomina.util.VestimentaConstantesFunciones;
import com.bydan.erp.nomina.util.VestimentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.VestimentaParameterGeneral;
import com.bydan.erp.nomina.business.entity.Vestimenta;
import com.bydan.erp.nomina.business.logic.VestimentaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class VestimentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VestimentaLogic.class);
	
	protected VestimentaDataAccess vestimentaDataAccess; 	
	protected Vestimenta vestimenta;
	protected List<Vestimenta> vestimentas;
	protected Object vestimentaObject;	
	protected List<Object> vestimentasObject;
	
	public static ClassValidator<Vestimenta> vestimentaValidator = new ClassValidator<Vestimenta>(Vestimenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VestimentaLogicAdditional vestimentaLogicAdditional=null;
	
	public VestimentaLogicAdditional getVestimentaLogicAdditional() {
		return this.vestimentaLogicAdditional;
	}
	
	public void setVestimentaLogicAdditional(VestimentaLogicAdditional vestimentaLogicAdditional) {
		try {
			this.vestimentaLogicAdditional=vestimentaLogicAdditional;
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
	
	
	
	
	public  VestimentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.vestimentaDataAccess = new VestimentaDataAccess();
			
			this.vestimentas= new ArrayList<Vestimenta>();
			this.vestimenta= new Vestimenta();
			
			this.vestimentaObject=new Object();
			this.vestimentasObject=new ArrayList<Object>();
				
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
			
			this.vestimentaDataAccess.setConnexionType(this.connexionType);
			this.vestimentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VestimentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.vestimentaDataAccess = new VestimentaDataAccess();
			this.vestimentas= new ArrayList<Vestimenta>();
			this.vestimenta= new Vestimenta();
			this.vestimentaObject=new Object();
			this.vestimentasObject=new ArrayList<Object>();
			
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
			
			this.vestimentaDataAccess.setConnexionType(this.connexionType);
			this.vestimentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Vestimenta getVestimenta() throws Exception {	
		VestimentaLogicAdditional.checkVestimentaToGet(vestimenta,this.datosCliente,this.arrDatoGeneral);
		VestimentaLogicAdditional.updateVestimentaToGet(vestimenta,this.arrDatoGeneral);
		
		return vestimenta;
	}
		
	public void setVestimenta(Vestimenta newVestimenta) {
		this.vestimenta = newVestimenta;
	}
	
	public VestimentaDataAccess getVestimentaDataAccess() {
		return vestimentaDataAccess;
	}
	
	public void setVestimentaDataAccess(VestimentaDataAccess newvestimentaDataAccess) {
		this.vestimentaDataAccess = newvestimentaDataAccess;
	}
	
	public List<Vestimenta> getVestimentas() throws Exception {		
		this.quitarVestimentasNulos();
		
		VestimentaLogicAdditional.checkVestimentaToGets(vestimentas,this.datosCliente,this.arrDatoGeneral);
		
		for (Vestimenta vestimentaLocal: vestimentas ) {
			VestimentaLogicAdditional.updateVestimentaToGet(vestimentaLocal,this.arrDatoGeneral);
		}
		
		return vestimentas;
	}
	
	public void setVestimentas(List<Vestimenta> newVestimentas) {
		this.vestimentas = newVestimentas;
	}
	
	public Object getVestimentaObject() {	
		this.vestimentaObject=this.vestimentaDataAccess.getEntityObject();
		return this.vestimentaObject;
	}
		
	public void setVestimentaObject(Object newVestimentaObject) {
		this.vestimentaObject = newVestimentaObject;
	}
	
	public List<Object> getVestimentasObject() {		
		this.vestimentasObject=this.vestimentaDataAccess.getEntitiesObject();
		return this.vestimentasObject;
	}
		
	public void setVestimentasObject(List<Object> newVestimentasObject) {
		this.vestimentasObject = newVestimentasObject;
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
		
		if(this.vestimentaDataAccess!=null) {
			this.vestimentaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			vestimentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			vestimentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		vestimenta = new  Vestimenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vestimenta=vestimentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vestimenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimenta);
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
		vestimenta = new  Vestimenta();
		  		  
        try {
			
			vestimenta=vestimentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vestimenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vestimenta = new  Vestimenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vestimenta=vestimentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vestimenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimenta);
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
		vestimenta = new  Vestimenta();
		  		  
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
		vestimenta = new  Vestimenta();
		  		  
        try {
			
			vestimenta=vestimentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vestimenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		vestimenta = new  Vestimenta();
		  		  
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
		vestimenta = new  Vestimenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =vestimentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vestimenta = new  Vestimenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=vestimentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vestimenta = new  Vestimenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =vestimentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vestimenta = new  Vestimenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=vestimentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vestimenta = new  Vestimenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =vestimentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vestimenta = new  Vestimenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=vestimentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
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
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
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
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
        try {			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
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
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
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
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
        try {
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
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
		vestimentas = new  ArrayList<Vestimenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
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
		vestimentas = new  ArrayList<Vestimenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vestimenta = new  Vestimenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimenta=vestimentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimenta);
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
		vestimenta = new  Vestimenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimenta=vestimentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
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
		vestimentas = new  ArrayList<Vestimenta>();
		  		  
        try {
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVestimentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		vestimentas = new  ArrayList<Vestimenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getTodosVestimentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
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
	
	public  void  getTodosVestimentas(String sFinalQuery,Pagination pagination)throws Exception {
		vestimentas = new  ArrayList<Vestimenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vestimentas=vestimentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVestimenta(vestimentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVestimenta(Vestimenta vestimenta) throws Exception {
		Boolean estaValidado=false;
		
		if(vestimenta.getIsNew() || vestimenta.getIsChanged()) { 
			this.invalidValues = vestimentaValidator.getInvalidValues(vestimenta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(vestimenta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVestimenta(List<Vestimenta> Vestimentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Vestimenta vestimentaLocal:vestimentas) {				
			estaValidadoObjeto=this.validarGuardarVestimenta(vestimentaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVestimenta(List<Vestimenta> Vestimentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVestimenta(vestimentas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVestimenta(Vestimenta Vestimenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVestimenta(vestimenta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Vestimenta vestimenta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+vestimenta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VestimentaConstantesFunciones.getVestimentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"vestimenta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VestimentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VestimentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVestimentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-saveVestimentaWithConnection");connexion.begin();			
			
			VestimentaLogicAdditional.checkVestimentaToSave(this.vestimenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VestimentaLogicAdditional.updateVestimentaToSave(this.vestimenta,this.arrDatoGeneral);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vestimenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVestimenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVestimenta(this.vestimenta)) {
				VestimentaDataAccess.save(this.vestimenta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.vestimenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VestimentaLogicAdditional.checkVestimentaToSaveAfter(this.vestimenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVestimenta();
			
			connexion.commit();			
			
			if(this.vestimenta.getIsDeleted()) {
				this.vestimenta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVestimenta()throws Exception {	
		try {	
			
			VestimentaLogicAdditional.checkVestimentaToSave(this.vestimenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VestimentaLogicAdditional.updateVestimentaToSave(this.vestimenta,this.arrDatoGeneral);
			
			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vestimenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVestimenta(this.vestimenta)) {			
				VestimentaDataAccess.save(this.vestimenta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.vestimenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VestimentaLogicAdditional.checkVestimentaToSaveAfter(this.vestimenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.vestimenta.getIsDeleted()) {
				this.vestimenta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVestimentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-saveVestimentasWithConnection");connexion.begin();			
			
			VestimentaLogicAdditional.checkVestimentaToSaves(vestimentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVestimentas();
			
			Boolean validadoTodosVestimenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Vestimenta vestimentaLocal:vestimentas) {		
				if(vestimentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VestimentaLogicAdditional.updateVestimentaToSave(vestimentaLocal,this.arrDatoGeneral);
	        	
				VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vestimentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVestimenta(vestimentaLocal)) {
					VestimentaDataAccess.save(vestimentaLocal, connexion);				
				} else {
					validadoTodosVestimenta=false;
				}
			}
			
			if(!validadoTodosVestimenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VestimentaLogicAdditional.checkVestimentaToSavesAfter(vestimentas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVestimentas();
			
			connexion.commit();		
			
			this.quitarVestimentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVestimentas()throws Exception {				
		 try {	
			VestimentaLogicAdditional.checkVestimentaToSaves(vestimentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVestimenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Vestimenta vestimentaLocal:vestimentas) {				
				if(vestimentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VestimentaLogicAdditional.updateVestimentaToSave(vestimentaLocal,this.arrDatoGeneral);
	        	
				VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vestimentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVestimenta(vestimentaLocal)) {				
					VestimentaDataAccess.save(vestimentaLocal, connexion);				
				} else {
					validadoTodosVestimenta=false;
				}
			}
			
			if(!validadoTodosVestimenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VestimentaLogicAdditional.checkVestimentaToSavesAfter(vestimentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVestimentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VestimentaParameterReturnGeneral procesarAccionVestimentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Vestimenta> vestimentas,VestimentaParameterReturnGeneral vestimentaParameterGeneral)throws Exception {
		 try {	
			VestimentaParameterReturnGeneral vestimentaReturnGeneral=new VestimentaParameterReturnGeneral();
	
			VestimentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vestimentas,vestimentaParameterGeneral,vestimentaReturnGeneral);
			
			return vestimentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VestimentaParameterReturnGeneral procesarAccionVestimentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Vestimenta> vestimentas,VestimentaParameterReturnGeneral vestimentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-procesarAccionVestimentasWithConnection");connexion.begin();			
			
			VestimentaParameterReturnGeneral vestimentaReturnGeneral=new VestimentaParameterReturnGeneral();
	
			VestimentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vestimentas,vestimentaParameterGeneral,vestimentaReturnGeneral);
			
			this.connexion.commit();
			
			return vestimentaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VestimentaParameterReturnGeneral procesarEventosVestimentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Vestimenta> vestimentas,Vestimenta vestimenta,VestimentaParameterReturnGeneral vestimentaParameterGeneral,Boolean isEsNuevoVestimenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			VestimentaParameterReturnGeneral vestimentaReturnGeneral=new VestimentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vestimentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VestimentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vestimentas,vestimenta,vestimentaParameterGeneral,vestimentaReturnGeneral,isEsNuevoVestimenta,clases);
			
			return vestimentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VestimentaParameterReturnGeneral procesarEventosVestimentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Vestimenta> vestimentas,Vestimenta vestimenta,VestimentaParameterReturnGeneral vestimentaParameterGeneral,Boolean isEsNuevoVestimenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-procesarEventosVestimentasWithConnection");connexion.begin();			
			
			VestimentaParameterReturnGeneral vestimentaReturnGeneral=new VestimentaParameterReturnGeneral();
	
			vestimentaReturnGeneral.setVestimenta(vestimenta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vestimentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VestimentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vestimentas,vestimenta,vestimentaParameterGeneral,vestimentaReturnGeneral,isEsNuevoVestimenta,clases);
			
			this.connexion.commit();
			
			return vestimentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VestimentaParameterReturnGeneral procesarImportacionVestimentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VestimentaParameterReturnGeneral vestimentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-procesarImportacionVestimentasWithConnection");connexion.begin();			
			
			VestimentaParameterReturnGeneral vestimentaReturnGeneral=new VestimentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.vestimentas=new ArrayList<Vestimenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.vestimenta=new Vestimenta();
				
				
				if(conColumnasBase) {this.vestimenta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.vestimenta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.vestimenta.setnombre(arrColumnas[iColumn++]);
				
				this.vestimentas.add(this.vestimenta);
			}
			
			this.saveVestimentas();
			
			this.connexion.commit();
			
			vestimentaReturnGeneral.setConRetornoEstaProcesado(true);
			vestimentaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return vestimentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVestimentasEliminados() throws Exception {				
		
		List<Vestimenta> vestimentasAux= new ArrayList<Vestimenta>();
		
		for(Vestimenta vestimenta:vestimentas) {
			if(!vestimenta.getIsDeleted()) {
				vestimentasAux.add(vestimenta);
			}
		}
		
		vestimentas=vestimentasAux;
	}
	
	public void quitarVestimentasNulos() throws Exception {				
		
		List<Vestimenta> vestimentasAux= new ArrayList<Vestimenta>();
		
		for(Vestimenta vestimenta : this.vestimentas) {
			if(vestimenta==null) {
				vestimentasAux.add(vestimenta);
			}
		}
		
		//this.vestimentas=vestimentasAux;
		
		this.vestimentas.removeAll(vestimentasAux);
	}
	
	public void getSetVersionRowVestimentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(vestimenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((vestimenta.getIsDeleted() || (vestimenta.getIsChanged()&&!vestimenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=vestimentaDataAccess.getSetVersionRowVestimenta(connexion,vestimenta.getId());
				
				if(!vestimenta.getVersionRow().equals(timestamp)) {	
					vestimenta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				vestimenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVestimenta()throws Exception {	
		
		if(vestimenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((vestimenta.getIsDeleted() || (vestimenta.getIsChanged()&&!vestimenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=vestimentaDataAccess.getSetVersionRowVestimenta(connexion,vestimenta.getId());
			
			try {							
				if(!vestimenta.getVersionRow().equals(timestamp)) {	
					vestimenta.setVersionRow(timestamp);
				}
				
				vestimenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVestimentasWithConnection()throws Exception {	
		if(vestimentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Vestimenta vestimentaAux:vestimentas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(vestimentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vestimentaAux.getIsDeleted() || (vestimentaAux.getIsChanged()&&!vestimentaAux.getIsNew())) {
						
						timestamp=vestimentaDataAccess.getSetVersionRowVestimenta(connexion,vestimentaAux.getId());
						
						if(!vestimenta.getVersionRow().equals(timestamp)) {	
							vestimentaAux.setVersionRow(timestamp);
						}
								
						vestimentaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVestimentas()throws Exception {	
		if(vestimentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Vestimenta vestimentaAux:vestimentas) {
					if(vestimentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vestimentaAux.getIsDeleted() || (vestimentaAux.getIsChanged()&&!vestimentaAux.getIsNew())) {
						
						timestamp=vestimentaDataAccess.getSetVersionRowVestimenta(connexion,vestimentaAux.getId());
						
						if(!vestimentaAux.getVersionRow().equals(timestamp)) {	
							vestimentaAux.setVersionRow(timestamp);
						}
						
													
						vestimentaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VestimentaParameterReturnGeneral cargarCombosLoteForeignKeyVestimentaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		VestimentaParameterReturnGeneral  vestimentaReturnGeneral =new VestimentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyVestimentaWithConnection");connexion.begin();
			
			vestimentaReturnGeneral =new VestimentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vestimentaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return vestimentaReturnGeneral;
	}
	
	public VestimentaParameterReturnGeneral cargarCombosLoteForeignKeyVestimenta(String finalQueryGlobalEmpresa) throws Exception {
		VestimentaParameterReturnGeneral  vestimentaReturnGeneral =new VestimentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			vestimentaReturnGeneral =new VestimentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vestimentaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return vestimentaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyVestimentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TallaVestidoLogic tallavestidoLogic=new TallaVestidoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyVestimentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TallaVestido.class));
											
			

			tallavestidoLogic.setConnexion(this.getConnexion());
			tallavestidoLogic.setDatosCliente(this.datosCliente);
			tallavestidoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Vestimenta vestimenta:this.vestimentas) {
				

				classes=new ArrayList<Classe>();
				classes=TallaVestidoConstantesFunciones.getClassesForeignKeysOfTallaVestido(new ArrayList<Classe>(),DeepLoadType.NONE);

				tallavestidoLogic.setTallaVestidos(vestimenta.tallavestidos);
				tallavestidoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Vestimenta vestimenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VestimentaLogicAdditional.updateVestimentaToGet(vestimenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vestimenta.setEmpresa(vestimentaDataAccess.getEmpresa(connexion,vestimenta));
		vestimenta.setTallaVestidos(vestimentaDataAccess.getTallaVestidos(connexion,vestimenta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vestimenta.setEmpresa(vestimentaDataAccess.getEmpresa(connexion,vestimenta));
				continue;
			}

			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vestimenta.setTallaVestidos(vestimentaDataAccess.getTallaVestidos(connexion,vestimenta));

				if(this.isConDeep) {
					TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(this.connexion);
					tallavestidoLogic.setTallaVestidos(vestimenta.getTallaVestidos());
					ArrayList<Classe> classesLocal=TallaVestidoConstantesFunciones.getClassesForeignKeysOfTallaVestido(new ArrayList<Classe>(),DeepLoadType.NONE);
					tallavestidoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(tallavestidoLogic.getTallaVestidos());
					vestimenta.setTallaVestidos(tallavestidoLogic.getTallaVestidos());
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
			vestimenta.setEmpresa(vestimentaDataAccess.getEmpresa(connexion,vestimenta));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TallaVestido.class));
			vestimenta.setTallaVestidos(vestimentaDataAccess.getTallaVestidos(connexion,vestimenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vestimenta.setEmpresa(vestimentaDataAccess.getEmpresa(connexion,vestimenta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vestimenta.getEmpresa(),isDeep,deepLoadType,clases);
				

		vestimenta.setTallaVestidos(vestimentaDataAccess.getTallaVestidos(connexion,vestimenta));

		for(TallaVestido tallavestido:vestimenta.getTallaVestidos()) {
			TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
			tallavestidoLogic.deepLoad(tallavestido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vestimenta.setEmpresa(vestimentaDataAccess.getEmpresa(connexion,vestimenta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(vestimenta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				vestimenta.setTallaVestidos(vestimentaDataAccess.getTallaVestidos(connexion,vestimenta));

				for(TallaVestido tallavestido:vestimenta.getTallaVestidos()) {
					TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
					tallavestidoLogic.deepLoad(tallavestido,isDeep,deepLoadType,clases);
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
			vestimenta.setEmpresa(vestimentaDataAccess.getEmpresa(connexion,vestimenta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(vestimenta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TallaVestido.class));
			vestimenta.setTallaVestidos(vestimentaDataAccess.getTallaVestidos(connexion,vestimenta));

			for(TallaVestido tallavestido:vestimenta.getTallaVestidos()) {
				TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
				tallavestidoLogic.deepLoad(tallavestido,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Vestimenta vestimenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VestimentaLogicAdditional.updateVestimentaToSave(vestimenta,this.arrDatoGeneral);
			
VestimentaDataAccess.save(vestimenta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vestimenta.getEmpresa(),connexion);

		for(TallaVestido tallavestido:vestimenta.getTallaVestidos()) {
			tallavestido.setid_vestimenta(vestimenta.getId());
			TallaVestidoDataAccess.save(tallavestido,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vestimenta.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TallaVestido tallavestido:vestimenta.getTallaVestidos()) {
					tallavestido.setid_vestimenta(vestimenta.getId());
					TallaVestidoDataAccess.save(tallavestido,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vestimenta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vestimenta.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(TallaVestido tallavestido:vestimenta.getTallaVestidos()) {
			TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
			tallavestido.setid_vestimenta(vestimenta.getId());
			TallaVestidoDataAccess.save(tallavestido,connexion);
			tallavestidoLogic.deepSave(tallavestido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vestimenta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(vestimenta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TallaVestido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TallaVestido tallavestido:vestimenta.getTallaVestidos()) {
					TallaVestidoLogic tallavestidoLogic= new TallaVestidoLogic(connexion);
					tallavestido.setid_vestimenta(vestimenta.getId());
					TallaVestidoDataAccess.save(tallavestido,connexion);
					tallavestidoLogic.deepSave(tallavestido,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Vestimenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(vestimenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(vestimenta);
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
			this.deepLoad(this.vestimenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Vestimenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(vestimentas!=null) {
				for(Vestimenta vestimenta:vestimentas) {
					this.deepLoad(vestimenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(vestimentas);
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
			if(vestimentas!=null) {
				for(Vestimenta vestimenta:vestimentas) {
					this.deepLoad(vestimenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(vestimentas);
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
			this.getNewConnexionToDeep(Vestimenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(vestimenta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Vestimenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(vestimentas!=null) {
				for(Vestimenta vestimenta:vestimentas) {
					this.deepSave(vestimenta,isDeep,deepLoadType,clases);
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
			if(vestimentas!=null) {
				for(Vestimenta vestimenta:vestimentas) {
					this.deepSave(vestimenta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVestimentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Vestimenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VestimentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vestimentas=vestimentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVestimentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VestimentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VestimentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vestimentas=vestimentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VestimentaConstantesFunciones.refrescarForeignKeysDescripcionesVestimenta(this.vestimentas);
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
			if(VestimentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VestimentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Vestimenta vestimenta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VestimentaConstantesFunciones.ISCONAUDITORIA) {
				if(vestimenta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VestimentaDataAccess.TABLENAME, vestimenta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VestimentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VestimentaLogic.registrarAuditoriaDetallesVestimenta(connexion,vestimenta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(vestimenta.getIsDeleted()) {
					/*if(!vestimenta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VestimentaDataAccess.TABLENAME, vestimenta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VestimentaLogic.registrarAuditoriaDetallesVestimenta(connexion,vestimenta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VestimentaDataAccess.TABLENAME, vestimenta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(vestimenta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VestimentaDataAccess.TABLENAME, vestimenta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VestimentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VestimentaLogic.registrarAuditoriaDetallesVestimenta(connexion,vestimenta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVestimenta(Connexion connexion,Vestimenta vestimenta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(vestimenta.getIsNew()||!vestimenta.getid_empresa().equals(vestimenta.getVestimentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vestimenta.getVestimentaOriginal().getid_empresa()!=null)
				{
					strValorActual=vestimenta.getVestimentaOriginal().getid_empresa().toString();
				}
				if(vestimenta.getid_empresa()!=null)
				{
					strValorNuevo=vestimenta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VestimentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(vestimenta.getIsNew()||!vestimenta.getnombre().equals(vestimenta.getVestimentaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vestimenta.getVestimentaOriginal().getnombre()!=null)
				{
					strValorActual=vestimenta.getVestimentaOriginal().getnombre();
				}
				if(vestimenta.getnombre()!=null)
				{
					strValorNuevo=vestimenta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VestimentaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVestimentaRelacionesWithConnection(Vestimenta vestimenta,List<TallaVestido> tallavestidos) throws Exception {

		if(!vestimenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVestimentaRelacionesBase(vestimenta,tallavestidos,true);
		}
	}

	public void saveVestimentaRelaciones(Vestimenta vestimenta,List<TallaVestido> tallavestidos)throws Exception {

		if(!vestimenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVestimentaRelacionesBase(vestimenta,tallavestidos,false);
		}
	}

	public void saveVestimentaRelacionesBase(Vestimenta vestimenta,List<TallaVestido> tallavestidos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Vestimenta-saveRelacionesWithConnection");}
	
			vestimenta.setTallaVestidos(tallavestidos);

			this.setVestimenta(vestimenta);

			if(VestimentaLogicAdditional.validarSaveRelaciones(vestimenta,this)) {

				VestimentaLogicAdditional.updateRelacionesToSave(vestimenta,this);

				if((vestimenta.getIsNew()||vestimenta.getIsChanged())&&!vestimenta.getIsDeleted()) {
					this.saveVestimenta();
					this.saveVestimentaRelacionesDetalles(tallavestidos);

				} else if(vestimenta.getIsDeleted()) {
					this.saveVestimentaRelacionesDetalles(tallavestidos);
					this.saveVestimenta();
				}

				VestimentaLogicAdditional.updateRelacionesToSaveAfter(vestimenta,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TallaVestidoConstantesFunciones.InicializarGeneralEntityAuxiliaresTallaVestidos(tallavestidos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveVestimentaRelacionesDetalles(List<TallaVestido> tallavestidos)throws Exception {
		try {
	

			Long idVestimentaActual=this.getVestimenta().getId();

			TallaVestidoLogic tallavestidoLogic_Desde_Vestimenta=new TallaVestidoLogic();
			tallavestidoLogic_Desde_Vestimenta.setTallaVestidos(tallavestidos);

			tallavestidoLogic_Desde_Vestimenta.setConnexion(this.getConnexion());
			tallavestidoLogic_Desde_Vestimenta.setDatosCliente(this.datosCliente);

			for(TallaVestido tallavestido_Desde_Vestimenta:tallavestidoLogic_Desde_Vestimenta.getTallaVestidos()) {
				tallavestido_Desde_Vestimenta.setid_vestimenta(idVestimentaActual);
			}

			tallavestidoLogic_Desde_Vestimenta.saveTallaVestidos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVestimenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VestimentaConstantesFunciones.getClassesForeignKeysOfVestimenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVestimenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VestimentaConstantesFunciones.getClassesRelationshipsOfVestimenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
