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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.AutoriSriConstantesFunciones;
import com.bydan.erp.facturacion.util.AutoriSriParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.AutoriSriParameterGeneral;
import com.bydan.erp.facturacion.business.entity.AutoriSri;
import com.bydan.erp.facturacion.business.logic.AutoriSriLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class AutoriSriLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AutoriSriLogic.class);
	
	protected AutoriSriDataAccess autorisriDataAccess; 	
	protected AutoriSri autorisri;
	protected List<AutoriSri> autorisris;
	protected Object autorisriObject;	
	protected List<Object> autorisrisObject;
	
	public static ClassValidator<AutoriSri> autorisriValidator = new ClassValidator<AutoriSri>(AutoriSri.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AutoriSriLogicAdditional autorisriLogicAdditional=null;
	
	public AutoriSriLogicAdditional getAutoriSriLogicAdditional() {
		return this.autorisriLogicAdditional;
	}
	
	public void setAutoriSriLogicAdditional(AutoriSriLogicAdditional autorisriLogicAdditional) {
		try {
			this.autorisriLogicAdditional=autorisriLogicAdditional;
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
	
	
	
	
	public  AutoriSriLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.autorisriDataAccess = new AutoriSriDataAccess();
			
			this.autorisris= new ArrayList<AutoriSri>();
			this.autorisri= new AutoriSri();
			
			this.autorisriObject=new Object();
			this.autorisrisObject=new ArrayList<Object>();
				
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
			
			this.autorisriDataAccess.setConnexionType(this.connexionType);
			this.autorisriDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AutoriSriLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.autorisriDataAccess = new AutoriSriDataAccess();
			this.autorisris= new ArrayList<AutoriSri>();
			this.autorisri= new AutoriSri();
			this.autorisriObject=new Object();
			this.autorisrisObject=new ArrayList<Object>();
			
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
			
			this.autorisriDataAccess.setConnexionType(this.connexionType);
			this.autorisriDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AutoriSri getAutoriSri() throws Exception {	
		AutoriSriLogicAdditional.checkAutoriSriToGet(autorisri,this.datosCliente,this.arrDatoGeneral);
		AutoriSriLogicAdditional.updateAutoriSriToGet(autorisri,this.arrDatoGeneral);
		
		return autorisri;
	}
		
	public void setAutoriSri(AutoriSri newAutoriSri) {
		this.autorisri = newAutoriSri;
	}
	
	public AutoriSriDataAccess getAutoriSriDataAccess() {
		return autorisriDataAccess;
	}
	
	public void setAutoriSriDataAccess(AutoriSriDataAccess newautorisriDataAccess) {
		this.autorisriDataAccess = newautorisriDataAccess;
	}
	
	public List<AutoriSri> getAutoriSris() throws Exception {		
		this.quitarAutoriSrisNulos();
		
		AutoriSriLogicAdditional.checkAutoriSriToGets(autorisris,this.datosCliente,this.arrDatoGeneral);
		
		for (AutoriSri autorisriLocal: autorisris ) {
			AutoriSriLogicAdditional.updateAutoriSriToGet(autorisriLocal,this.arrDatoGeneral);
		}
		
		return autorisris;
	}
	
	public void setAutoriSris(List<AutoriSri> newAutoriSris) {
		this.autorisris = newAutoriSris;
	}
	
	public Object getAutoriSriObject() {	
		this.autorisriObject=this.autorisriDataAccess.getEntityObject();
		return this.autorisriObject;
	}
		
	public void setAutoriSriObject(Object newAutoriSriObject) {
		this.autorisriObject = newAutoriSriObject;
	}
	
	public List<Object> getAutoriSrisObject() {		
		this.autorisrisObject=this.autorisriDataAccess.getEntitiesObject();
		return this.autorisrisObject;
	}
		
	public void setAutoriSrisObject(List<Object> newAutoriSrisObject) {
		this.autorisrisObject = newAutoriSrisObject;
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
		
		if(this.autorisriDataAccess!=null) {
			this.autorisriDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			autorisriDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			autorisriDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		autorisri = new  AutoriSri();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autorisri=autorisriDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autorisri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisri);
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
		autorisri = new  AutoriSri();
		  		  
        try {
			
			autorisri=autorisriDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autorisri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		autorisri = new  AutoriSri();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autorisri=autorisriDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autorisri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisri);
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
		autorisri = new  AutoriSri();
		  		  
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
		autorisri = new  AutoriSri();
		  		  
        try {
			
			autorisri=autorisriDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autorisri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		autorisri = new  AutoriSri();
		  		  
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
		autorisri = new  AutoriSri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =autorisriDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autorisri = new  AutoriSri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=autorisriDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autorisri = new  AutoriSri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =autorisriDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autorisri = new  AutoriSri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=autorisriDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autorisri = new  AutoriSri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =autorisriDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autorisri = new  AutoriSri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=autorisriDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autorisris = new  ArrayList<AutoriSri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
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
		autorisris = new  ArrayList<AutoriSri>();
		  		  
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
		autorisris = new  ArrayList<AutoriSri>();
		  		  
        try {			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		autorisris = new  ArrayList<AutoriSri>();
		  		  
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
		autorisris = new  ArrayList<AutoriSri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
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
		autorisris = new  ArrayList<AutoriSri>();
		  		  
        try {
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
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
		autorisris = new  ArrayList<AutoriSri>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
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
		autorisris = new  ArrayList<AutoriSri>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		autorisri = new  AutoriSri();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisri=autorisriDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisri);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisri);
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
		autorisri = new  AutoriSri();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisri=autorisriDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisri);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autorisris = new  ArrayList<AutoriSri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
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
		autorisris = new  ArrayList<AutoriSri>();
		  		  
        try {
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAutoriSrisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		autorisris = new  ArrayList<AutoriSri>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getTodosAutoriSrisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
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
	
	public  void  getTodosAutoriSris(String sFinalQuery,Pagination pagination)throws Exception {
		autorisris = new  ArrayList<AutoriSri>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriSri(autorisris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAutoriSri(AutoriSri autorisri) throws Exception {
		Boolean estaValidado=false;
		
		if(autorisri.getIsNew() || autorisri.getIsChanged()) { 
			this.invalidValues = autorisriValidator.getInvalidValues(autorisri);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(autorisri);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAutoriSri(List<AutoriSri> AutoriSris) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AutoriSri autorisriLocal:autorisris) {				
			estaValidadoObjeto=this.validarGuardarAutoriSri(autorisriLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAutoriSri(List<AutoriSri> AutoriSris) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriSri(autorisris)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAutoriSri(AutoriSri AutoriSri) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriSri(autorisri)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AutoriSri autorisri) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+autorisri.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AutoriSriConstantesFunciones.getAutoriSriLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"autorisri","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AutoriSriConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AutoriSriConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAutoriSriWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-saveAutoriSriWithConnection");connexion.begin();			
			
			AutoriSriLogicAdditional.checkAutoriSriToSave(this.autorisri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriSriLogicAdditional.updateAutoriSriToSave(this.autorisri,this.arrDatoGeneral);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autorisri,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAutoriSri();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriSri(this.autorisri)) {
				AutoriSriDataAccess.save(this.autorisri, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.autorisri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriSriLogicAdditional.checkAutoriSriToSaveAfter(this.autorisri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriSri();
			
			connexion.commit();			
			
			if(this.autorisri.getIsDeleted()) {
				this.autorisri=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAutoriSri()throws Exception {	
		try {	
			
			AutoriSriLogicAdditional.checkAutoriSriToSave(this.autorisri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriSriLogicAdditional.updateAutoriSriToSave(this.autorisri,this.arrDatoGeneral);
			
			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autorisri,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriSri(this.autorisri)) {			
				AutoriSriDataAccess.save(this.autorisri, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.autorisri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriSriLogicAdditional.checkAutoriSriToSaveAfter(this.autorisri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.autorisri.getIsDeleted()) {
				this.autorisri=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAutoriSrisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-saveAutoriSrisWithConnection");connexion.begin();			
			
			AutoriSriLogicAdditional.checkAutoriSriToSaves(autorisris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAutoriSris();
			
			Boolean validadoTodosAutoriSri=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriSri autorisriLocal:autorisris) {		
				if(autorisriLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriSriLogicAdditional.updateAutoriSriToSave(autorisriLocal,this.arrDatoGeneral);
	        	
				AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autorisriLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriSri(autorisriLocal)) {
					AutoriSriDataAccess.save(autorisriLocal, connexion);				
				} else {
					validadoTodosAutoriSri=false;
				}
			}
			
			if(!validadoTodosAutoriSri) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriSriLogicAdditional.checkAutoriSriToSavesAfter(autorisris,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriSris();
			
			connexion.commit();		
			
			this.quitarAutoriSrisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAutoriSris()throws Exception {				
		 try {	
			AutoriSriLogicAdditional.checkAutoriSriToSaves(autorisris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAutoriSri=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriSri autorisriLocal:autorisris) {				
				if(autorisriLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriSriLogicAdditional.updateAutoriSriToSave(autorisriLocal,this.arrDatoGeneral);
	        	
				AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autorisriLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriSri(autorisriLocal)) {				
					AutoriSriDataAccess.save(autorisriLocal, connexion);				
				} else {
					validadoTodosAutoriSri=false;
				}
			}
			
			if(!validadoTodosAutoriSri) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriSriLogicAdditional.checkAutoriSriToSavesAfter(autorisris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAutoriSrisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriSriParameterReturnGeneral procesarAccionAutoriSris(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriSri> autorisris,AutoriSriParameterReturnGeneral autorisriParameterGeneral)throws Exception {
		 try {	
			AutoriSriParameterReturnGeneral autorisriReturnGeneral=new AutoriSriParameterReturnGeneral();
	
			AutoriSriLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autorisris,autorisriParameterGeneral,autorisriReturnGeneral);
			
			return autorisriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriSriParameterReturnGeneral procesarAccionAutoriSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriSri> autorisris,AutoriSriParameterReturnGeneral autorisriParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-procesarAccionAutoriSrisWithConnection");connexion.begin();			
			
			AutoriSriParameterReturnGeneral autorisriReturnGeneral=new AutoriSriParameterReturnGeneral();
	
			AutoriSriLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autorisris,autorisriParameterGeneral,autorisriReturnGeneral);
			
			this.connexion.commit();
			
			return autorisriReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriSriParameterReturnGeneral procesarEventosAutoriSris(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriSri> autorisris,AutoriSri autorisri,AutoriSriParameterReturnGeneral autorisriParameterGeneral,Boolean isEsNuevoAutoriSri,ArrayList<Classe> clases)throws Exception {
		 try {	
			AutoriSriParameterReturnGeneral autorisriReturnGeneral=new AutoriSriParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autorisriReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriSriLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autorisris,autorisri,autorisriParameterGeneral,autorisriReturnGeneral,isEsNuevoAutoriSri,clases);
			
			return autorisriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AutoriSriParameterReturnGeneral procesarEventosAutoriSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriSri> autorisris,AutoriSri autorisri,AutoriSriParameterReturnGeneral autorisriParameterGeneral,Boolean isEsNuevoAutoriSri,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-procesarEventosAutoriSrisWithConnection");connexion.begin();			
			
			AutoriSriParameterReturnGeneral autorisriReturnGeneral=new AutoriSriParameterReturnGeneral();
	
			autorisriReturnGeneral.setAutoriSri(autorisri);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autorisriReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriSriLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autorisris,autorisri,autorisriParameterGeneral,autorisriReturnGeneral,isEsNuevoAutoriSri,clases);
			
			this.connexion.commit();
			
			return autorisriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriSriParameterReturnGeneral procesarImportacionAutoriSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AutoriSriParameterReturnGeneral autorisriParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-procesarImportacionAutoriSrisWithConnection");connexion.begin();			
			
			AutoriSriParameterReturnGeneral autorisriReturnGeneral=new AutoriSriParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.autorisris=new ArrayList<AutoriSri>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.autorisri=new AutoriSri();
				
				
				if(conColumnasBase) {this.autorisri.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.autorisri.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.autorisri.setnumero_secuencial(arrColumnas[iColumn++]);
				this.autorisri.setnumero_autor(arrColumnas[iColumn++]);
				this.autorisri.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autorisri.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autorisri.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.autorisris.add(this.autorisri);
			}
			
			this.saveAutoriSris();
			
			this.connexion.commit();
			
			autorisriReturnGeneral.setConRetornoEstaProcesado(true);
			autorisriReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return autorisriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAutoriSrisEliminados() throws Exception {				
		
		List<AutoriSri> autorisrisAux= new ArrayList<AutoriSri>();
		
		for(AutoriSri autorisri:autorisris) {
			if(!autorisri.getIsDeleted()) {
				autorisrisAux.add(autorisri);
			}
		}
		
		autorisris=autorisrisAux;
	}
	
	public void quitarAutoriSrisNulos() throws Exception {				
		
		List<AutoriSri> autorisrisAux= new ArrayList<AutoriSri>();
		
		for(AutoriSri autorisri : this.autorisris) {
			if(autorisri==null) {
				autorisrisAux.add(autorisri);
			}
		}
		
		//this.autorisris=autorisrisAux;
		
		this.autorisris.removeAll(autorisrisAux);
	}
	
	public void getSetVersionRowAutoriSriWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(autorisri.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((autorisri.getIsDeleted() || (autorisri.getIsChanged()&&!autorisri.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=autorisriDataAccess.getSetVersionRowAutoriSri(connexion,autorisri.getId());
				
				if(!autorisri.getVersionRow().equals(timestamp)) {	
					autorisri.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				autorisri.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAutoriSri()throws Exception {	
		
		if(autorisri.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((autorisri.getIsDeleted() || (autorisri.getIsChanged()&&!autorisri.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=autorisriDataAccess.getSetVersionRowAutoriSri(connexion,autorisri.getId());
			
			try {							
				if(!autorisri.getVersionRow().equals(timestamp)) {	
					autorisri.setVersionRow(timestamp);
				}
				
				autorisri.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAutoriSrisWithConnection()throws Exception {	
		if(autorisris!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AutoriSri autorisriAux:autorisris) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(autorisriAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autorisriAux.getIsDeleted() || (autorisriAux.getIsChanged()&&!autorisriAux.getIsNew())) {
						
						timestamp=autorisriDataAccess.getSetVersionRowAutoriSri(connexion,autorisriAux.getId());
						
						if(!autorisri.getVersionRow().equals(timestamp)) {	
							autorisriAux.setVersionRow(timestamp);
						}
								
						autorisriAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAutoriSris()throws Exception {	
		if(autorisris!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AutoriSri autorisriAux:autorisris) {
					if(autorisriAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autorisriAux.getIsDeleted() || (autorisriAux.getIsChanged()&&!autorisriAux.getIsNew())) {
						
						timestamp=autorisriDataAccess.getSetVersionRowAutoriSri(connexion,autorisriAux.getId());
						
						if(!autorisriAux.getVersionRow().equals(timestamp)) {	
							autorisriAux.setVersionRow(timestamp);
						}
						
													
						autorisriAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AutoriSriParameterReturnGeneral cargarCombosLoteForeignKeyAutoriSriWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoDocumentoGeneral) throws Exception {
		AutoriSriParameterReturnGeneral  autorisriReturnGeneral =new AutoriSriParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-cargarCombosLoteForeignKeyAutoriSriWithConnection");connexion.begin();
			
			autorisriReturnGeneral =new AutoriSriParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autorisriReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autorisriReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			autorisriReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return autorisriReturnGeneral;
	}
	
	public AutoriSriParameterReturnGeneral cargarCombosLoteForeignKeyAutoriSri(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoDocumentoGeneral) throws Exception {
		AutoriSriParameterReturnGeneral  autorisriReturnGeneral =new AutoriSriParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			autorisriReturnGeneral =new AutoriSriParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autorisriReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autorisriReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			autorisriReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return autorisriReturnGeneral;
	}
	
	
	public void deepLoad(AutoriSri autorisri,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AutoriSriLogicAdditional.updateAutoriSriToGet(autorisri,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autorisri.setEmpresa(autorisriDataAccess.getEmpresa(connexion,autorisri));
		autorisri.setSucursal(autorisriDataAccess.getSucursal(connexion,autorisri));
		autorisri.setTipoDocumentoGeneral(autorisriDataAccess.getTipoDocumentoGeneral(connexion,autorisri));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autorisri.setEmpresa(autorisriDataAccess.getEmpresa(connexion,autorisri));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autorisri.setSucursal(autorisriDataAccess.getSucursal(connexion,autorisri));
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				autorisri.setTipoDocumentoGeneral(autorisriDataAccess.getTipoDocumentoGeneral(connexion,autorisri));
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
			autorisri.setEmpresa(autorisriDataAccess.getEmpresa(connexion,autorisri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autorisri.setSucursal(autorisriDataAccess.getSucursal(connexion,autorisri));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autorisri.setTipoDocumentoGeneral(autorisriDataAccess.getTipoDocumentoGeneral(connexion,autorisri));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autorisri.setEmpresa(autorisriDataAccess.getEmpresa(connexion,autorisri));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autorisri.getEmpresa(),isDeep,deepLoadType,clases);
				
		autorisri.setSucursal(autorisriDataAccess.getSucursal(connexion,autorisri));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autorisri.getSucursal(),isDeep,deepLoadType,clases);
				
		autorisri.setTipoDocumentoGeneral(autorisriDataAccess.getTipoDocumentoGeneral(connexion,autorisri));
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(autorisri.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autorisri.setEmpresa(autorisriDataAccess.getEmpresa(connexion,autorisri));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(autorisri.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autorisri.setSucursal(autorisriDataAccess.getSucursal(connexion,autorisri));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(autorisri.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				autorisri.setTipoDocumentoGeneral(autorisriDataAccess.getTipoDocumentoGeneral(connexion,autorisri));
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepLoad(autorisri.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
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
			autorisri.setEmpresa(autorisriDataAccess.getEmpresa(connexion,autorisri));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(autorisri.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autorisri.setSucursal(autorisriDataAccess.getSucursal(connexion,autorisri));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(autorisri.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autorisri.setTipoDocumentoGeneral(autorisriDataAccess.getTipoDocumentoGeneral(connexion,autorisri));
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
			tipodocumentogeneralLogic.deepLoad(autorisri.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AutoriSri autorisri,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AutoriSriLogicAdditional.updateAutoriSriToSave(autorisri,this.arrDatoGeneral);
			
AutoriSriDataAccess.save(autorisri, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autorisri.getEmpresa(),connexion);

		SucursalDataAccess.save(autorisri.getSucursal(),connexion);

		TipoDocumentoGeneralDataAccess.save(autorisri.getTipoDocumentoGeneral(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autorisri.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autorisri.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(autorisri.getTipoDocumentoGeneral(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autorisri.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autorisri.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(autorisri.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autorisri.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoDocumentoGeneralDataAccess.save(autorisri.getTipoDocumentoGeneral(),connexion);
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(autorisri.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autorisri.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(autorisri.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autorisri.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(autorisri.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(autorisri.getTipoDocumentoGeneral(),connexion);
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepSave(autorisri.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AutoriSri.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(autorisri,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(autorisri);
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
			this.deepLoad(this.autorisri,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AutoriSri.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(autorisris!=null) {
				for(AutoriSri autorisri:autorisris) {
					this.deepLoad(autorisri,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(autorisris);
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
			if(autorisris!=null) {
				for(AutoriSri autorisri:autorisris) {
					this.deepLoad(autorisri,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(autorisris);
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
			this.getNewConnexionToDeep(AutoriSri.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(autorisri,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AutoriSri.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(autorisris!=null) {
				for(AutoriSri autorisri:autorisris) {
					this.deepSave(autorisri,isDeep,deepLoadType,clases);
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
			if(autorisris!=null) {
				for(AutoriSri autorisri:autorisris) {
					this.deepSave(autorisri,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAutoriSrisBusquedaPorFechaFinWithConnection(String sFinalQuery,Pagination pagination,Date fecha_fin)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaFin.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_fin,AutoriSriConstantesFunciones.FECHAFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaFin);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriSrisBusquedaPorFechaFin(String sFinalQuery,Pagination pagination,Date fecha_fin)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaFin.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_fin,AutoriSriConstantesFunciones.FECHAFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaFin);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriSrisBusquedaPorFechaInicioWithConnection(String sFinalQuery,Pagination pagination,Date fecha_inicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaInicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaInicio.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_inicio,AutoriSriConstantesFunciones.FECHAINICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaInicio);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaInicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriSrisBusquedaPorFechaInicio(String sFinalQuery,Pagination pagination,Date fecha_inicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaInicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaInicio.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_inicio,AutoriSriConstantesFunciones.FECHAINICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaInicio);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaInicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriSrisBusquedaPorNumeroAutorWithConnection(String sFinalQuery,Pagination pagination,String numero_autor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroAutor= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroAutor.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_autor+"%",AutoriSriConstantesFunciones.NUMEROAUTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroAutor);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroAutor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriSrisBusquedaPorNumeroAutor(String sFinalQuery,Pagination pagination,String numero_autor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroAutor= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroAutor.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_autor+"%",AutoriSriConstantesFunciones.NUMEROAUTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroAutor);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroAutor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriSrisBusquedaPorNumeroSecuencialWithConnection(String sFinalQuery,Pagination pagination,String numero_secuencial)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroSecuencial= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroSecuencial.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_secuencial+"%",AutoriSriConstantesFunciones.NUMEROSECUENCIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroSecuencial);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroSecuencial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriSrisBusquedaPorNumeroSecuencial(String sFinalQuery,Pagination pagination,String numero_secuencial)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroSecuencial= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroSecuencial.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_secuencial+"%",AutoriSriConstantesFunciones.NUMEROSECUENCIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroSecuencial);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroSecuencial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriSrisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriSriConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriSrisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriSriConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriSrisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriSriConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriSrisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriSriConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriSrisFK_IdTipoDocumentoGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriSrisFK_IdTipoDocumentoGeneral(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			AutoriSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriSriConstantesFunciones.refrescarForeignKeysDescripcionesAutoriSri(this.autorisris);
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
			if(AutoriSriConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriSriDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AutoriSri autorisri,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AutoriSriConstantesFunciones.ISCONAUDITORIA) {
				if(autorisri.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriSriDataAccess.TABLENAME, autorisri.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriSriConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriSriLogic.registrarAuditoriaDetallesAutoriSri(connexion,autorisri,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(autorisri.getIsDeleted()) {
					/*if(!autorisri.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AutoriSriDataAccess.TABLENAME, autorisri.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AutoriSriLogic.registrarAuditoriaDetallesAutoriSri(connexion,autorisri,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriSriDataAccess.TABLENAME, autorisri.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(autorisri.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriSriDataAccess.TABLENAME, autorisri.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriSriConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriSriLogic.registrarAuditoriaDetallesAutoriSri(connexion,autorisri,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAutoriSri(Connexion connexion,AutoriSri autorisri)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(autorisri.getIsNew()||!autorisri.getid_empresa().equals(autorisri.getAutoriSriOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getid_empresa()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getid_empresa().toString();
				}
				if(autorisri.getid_empresa()!=null)
				{
					strValorNuevo=autorisri.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(autorisri.getIsNew()||!autorisri.getid_sucursal().equals(autorisri.getAutoriSriOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getid_sucursal()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getid_sucursal().toString();
				}
				if(autorisri.getid_sucursal()!=null)
				{
					strValorNuevo=autorisri.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(autorisri.getIsNew()||!autorisri.getid_tipo_documento_general().equals(autorisri.getAutoriSriOriginal().getid_tipo_documento_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getid_tipo_documento_general()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getid_tipo_documento_general().toString();
				}
				if(autorisri.getid_tipo_documento_general()!=null)
				{
					strValorNuevo=autorisri.getid_tipo_documento_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.IDTIPODOCUMENTOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(autorisri.getIsNew()||!autorisri.getnumero_secuencial().equals(autorisri.getAutoriSriOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getnumero_secuencial();
				}
				if(autorisri.getnumero_secuencial()!=null)
				{
					strValorNuevo=autorisri.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(autorisri.getIsNew()||!autorisri.getnumero_autor().equals(autorisri.getAutoriSriOriginal().getnumero_autor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getnumero_autor()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getnumero_autor();
				}
				if(autorisri.getnumero_autor()!=null)
				{
					strValorNuevo=autorisri.getnumero_autor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.NUMEROAUTOR,strValorActual,strValorNuevo);
			}	
			
			if(autorisri.getIsNew()||!autorisri.getfecha_inicio().equals(autorisri.getAutoriSriOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getfecha_inicio()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getfecha_inicio().toString();
				}
				if(autorisri.getfecha_inicio()!=null)
				{
					strValorNuevo=autorisri.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(autorisri.getIsNew()||!autorisri.getfecha_fin().equals(autorisri.getAutoriSriOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getfecha_fin()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getfecha_fin().toString();
				}
				if(autorisri.getfecha_fin()!=null)
				{
					strValorNuevo=autorisri.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(autorisri.getIsNew()||!autorisri.getesta_activo().equals(autorisri.getAutoriSriOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autorisri.getAutoriSriOriginal().getesta_activo()!=null)
				{
					strValorActual=autorisri.getAutoriSriOriginal().getesta_activo().toString();
				}
				if(autorisri.getesta_activo()!=null)
				{
					strValorNuevo=autorisri.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriSriConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAutoriSriRelacionesWithConnection(AutoriSri autorisri) throws Exception {

		if(!autorisri.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriSriRelacionesBase(autorisri,true);
		}
	}

	public void saveAutoriSriRelaciones(AutoriSri autorisri)throws Exception {

		if(!autorisri.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriSriRelacionesBase(autorisri,false);
		}
	}

	public void saveAutoriSriRelacionesBase(AutoriSri autorisri,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AutoriSri-saveRelacionesWithConnection");}
	

			this.setAutoriSri(autorisri);

			if(AutoriSriLogicAdditional.validarSaveRelaciones(autorisri,this)) {

				AutoriSriLogicAdditional.updateRelacionesToSave(autorisri,this);

				if((autorisri.getIsNew()||autorisri.getIsChanged())&&!autorisri.getIsDeleted()) {
					this.saveAutoriSri();
					this.saveAutoriSriRelacionesDetalles();

				} else if(autorisri.getIsDeleted()) {
					this.saveAutoriSriRelacionesDetalles();
					this.saveAutoriSri();
				}

				AutoriSriLogicAdditional.updateRelacionesToSaveAfter(autorisri,this);

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
	
	
	private void saveAutoriSriRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriSriConstantesFunciones.getClassesForeignKeysOfAutoriSri(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriSriConstantesFunciones.getClassesRelationshipsOfAutoriSri(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
