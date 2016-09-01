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
import com.bydan.erp.inventario.util.AutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.AutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.AutoriConsepParameterGeneral;
import com.bydan.erp.inventario.business.entity.AutoriConsep;
import com.bydan.erp.inventario.business.logic.AutoriConsepLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class AutoriConsepLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AutoriConsepLogic.class);
	
	protected AutoriConsepDataAccess autoriconsepDataAccess; 	
	protected AutoriConsep autoriconsep;
	protected List<AutoriConsep> autoriconseps;
	protected Object autoriconsepObject;	
	protected List<Object> autoriconsepsObject;
	
	public static ClassValidator<AutoriConsep> autoriconsepValidator = new ClassValidator<AutoriConsep>(AutoriConsep.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AutoriConsepLogicAdditional autoriconsepLogicAdditional=null;
	
	public AutoriConsepLogicAdditional getAutoriConsepLogicAdditional() {
		return this.autoriconsepLogicAdditional;
	}
	
	public void setAutoriConsepLogicAdditional(AutoriConsepLogicAdditional autoriconsepLogicAdditional) {
		try {
			this.autoriconsepLogicAdditional=autoriconsepLogicAdditional;
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
	
	
	
	
	public  AutoriConsepLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.autoriconsepDataAccess = new AutoriConsepDataAccess();
			
			this.autoriconseps= new ArrayList<AutoriConsep>();
			this.autoriconsep= new AutoriConsep();
			
			this.autoriconsepObject=new Object();
			this.autoriconsepsObject=new ArrayList<Object>();
				
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
			
			this.autoriconsepDataAccess.setConnexionType(this.connexionType);
			this.autoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AutoriConsepLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.autoriconsepDataAccess = new AutoriConsepDataAccess();
			this.autoriconseps= new ArrayList<AutoriConsep>();
			this.autoriconsep= new AutoriConsep();
			this.autoriconsepObject=new Object();
			this.autoriconsepsObject=new ArrayList<Object>();
			
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
			
			this.autoriconsepDataAccess.setConnexionType(this.connexionType);
			this.autoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AutoriConsep getAutoriConsep() throws Exception {	
		AutoriConsepLogicAdditional.checkAutoriConsepToGet(autoriconsep,this.datosCliente,this.arrDatoGeneral);
		AutoriConsepLogicAdditional.updateAutoriConsepToGet(autoriconsep,this.arrDatoGeneral);
		
		return autoriconsep;
	}
		
	public void setAutoriConsep(AutoriConsep newAutoriConsep) {
		this.autoriconsep = newAutoriConsep;
	}
	
	public AutoriConsepDataAccess getAutoriConsepDataAccess() {
		return autoriconsepDataAccess;
	}
	
	public void setAutoriConsepDataAccess(AutoriConsepDataAccess newautoriconsepDataAccess) {
		this.autoriconsepDataAccess = newautoriconsepDataAccess;
	}
	
	public List<AutoriConsep> getAutoriConseps() throws Exception {		
		this.quitarAutoriConsepsNulos();
		
		AutoriConsepLogicAdditional.checkAutoriConsepToGets(autoriconseps,this.datosCliente,this.arrDatoGeneral);
		
		for (AutoriConsep autoriconsepLocal: autoriconseps ) {
			AutoriConsepLogicAdditional.updateAutoriConsepToGet(autoriconsepLocal,this.arrDatoGeneral);
		}
		
		return autoriconseps;
	}
	
	public void setAutoriConseps(List<AutoriConsep> newAutoriConseps) {
		this.autoriconseps = newAutoriConseps;
	}
	
	public Object getAutoriConsepObject() {	
		this.autoriconsepObject=this.autoriconsepDataAccess.getEntityObject();
		return this.autoriconsepObject;
	}
		
	public void setAutoriConsepObject(Object newAutoriConsepObject) {
		this.autoriconsepObject = newAutoriConsepObject;
	}
	
	public List<Object> getAutoriConsepsObject() {		
		this.autoriconsepsObject=this.autoriconsepDataAccess.getEntitiesObject();
		return this.autoriconsepsObject;
	}
		
	public void setAutoriConsepsObject(List<Object> newAutoriConsepsObject) {
		this.autoriconsepsObject = newAutoriConsepsObject;
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
		
		if(this.autoriconsepDataAccess!=null) {
			this.autoriconsepDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			autoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			autoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		autoriconsep = new  AutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoriconsep=autoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconsep);
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
		autoriconsep = new  AutoriConsep();
		  		  
        try {
			
			autoriconsep=autoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		autoriconsep = new  AutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoriconsep=autoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconsep);
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
		autoriconsep = new  AutoriConsep();
		  		  
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
		autoriconsep = new  AutoriConsep();
		  		  
        try {
			
			autoriconsep=autoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		autoriconsep = new  AutoriConsep();
		  		  
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
		autoriconsep = new  AutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =autoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoriconsep = new  AutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=autoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoriconsep = new  AutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =autoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoriconsep = new  AutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=autoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoriconsep = new  AutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =autoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoriconsep = new  AutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=autoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
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
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
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
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
        try {			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
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
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
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
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
        try {
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
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
		autoriconseps = new  ArrayList<AutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
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
		autoriconseps = new  ArrayList<AutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		autoriconsep = new  AutoriConsep();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconsep=autoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconsep);
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
		autoriconsep = new  AutoriConsep();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconsep=autoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
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
		autoriconseps = new  ArrayList<AutoriConsep>();
		  		  
        try {
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAutoriConsepsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		autoriconseps = new  ArrayList<AutoriConsep>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getTodosAutoriConsepsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
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
	
	public  void  getTodosAutoriConseps(String sFinalQuery,Pagination pagination)throws Exception {
		autoriconseps = new  ArrayList<AutoriConsep>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriConsep(autoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAutoriConsep(AutoriConsep autoriconsep) throws Exception {
		Boolean estaValidado=false;
		
		if(autoriconsep.getIsNew() || autoriconsep.getIsChanged()) { 
			this.invalidValues = autoriconsepValidator.getInvalidValues(autoriconsep);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(autoriconsep);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAutoriConsep(List<AutoriConsep> AutoriConseps) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AutoriConsep autoriconsepLocal:autoriconseps) {				
			estaValidadoObjeto=this.validarGuardarAutoriConsep(autoriconsepLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAutoriConsep(List<AutoriConsep> AutoriConseps) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriConsep(autoriconseps)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAutoriConsep(AutoriConsep AutoriConsep) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriConsep(autoriconsep)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AutoriConsep autoriconsep) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+autoriconsep.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AutoriConsepConstantesFunciones.getAutoriConsepLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"autoriconsep","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAutoriConsepWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-saveAutoriConsepWithConnection");connexion.begin();			
			
			AutoriConsepLogicAdditional.checkAutoriConsepToSave(this.autoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriConsepLogicAdditional.updateAutoriConsepToSave(this.autoriconsep,this.arrDatoGeneral);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAutoriConsep();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriConsep(this.autoriconsep)) {
				AutoriConsepDataAccess.save(this.autoriconsep, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.autoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriConsepLogicAdditional.checkAutoriConsepToSaveAfter(this.autoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriConsep();
			
			connexion.commit();			
			
			if(this.autoriconsep.getIsDeleted()) {
				this.autoriconsep=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAutoriConsep()throws Exception {	
		try {	
			
			AutoriConsepLogicAdditional.checkAutoriConsepToSave(this.autoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriConsepLogicAdditional.updateAutoriConsepToSave(this.autoriconsep,this.arrDatoGeneral);
			
			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriConsep(this.autoriconsep)) {			
				AutoriConsepDataAccess.save(this.autoriconsep, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.autoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriConsepLogicAdditional.checkAutoriConsepToSaveAfter(this.autoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.autoriconsep.getIsDeleted()) {
				this.autoriconsep=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAutoriConsepsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-saveAutoriConsepsWithConnection");connexion.begin();			
			
			AutoriConsepLogicAdditional.checkAutoriConsepToSaves(autoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAutoriConseps();
			
			Boolean validadoTodosAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriConsep autoriconsepLocal:autoriconseps) {		
				if(autoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriConsepLogicAdditional.updateAutoriConsepToSave(autoriconsepLocal,this.arrDatoGeneral);
	        	
				AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriConsep(autoriconsepLocal)) {
					AutoriConsepDataAccess.save(autoriconsepLocal, connexion);				
				} else {
					validadoTodosAutoriConsep=false;
				}
			}
			
			if(!validadoTodosAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriConsepLogicAdditional.checkAutoriConsepToSavesAfter(autoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriConseps();
			
			connexion.commit();		
			
			this.quitarAutoriConsepsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAutoriConseps()throws Exception {				
		 try {	
			AutoriConsepLogicAdditional.checkAutoriConsepToSaves(autoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriConsep autoriconsepLocal:autoriconseps) {				
				if(autoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriConsepLogicAdditional.updateAutoriConsepToSave(autoriconsepLocal,this.arrDatoGeneral);
	        	
				AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriConsep(autoriconsepLocal)) {				
					AutoriConsepDataAccess.save(autoriconsepLocal, connexion);				
				} else {
					validadoTodosAutoriConsep=false;
				}
			}
			
			if(!validadoTodosAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriConsepLogicAdditional.checkAutoriConsepToSavesAfter(autoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAutoriConsepsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriConsepParameterReturnGeneral procesarAccionAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriConsep> autoriconseps,AutoriConsepParameterReturnGeneral autoriconsepParameterGeneral)throws Exception {
		 try {	
			AutoriConsepParameterReturnGeneral autoriconsepReturnGeneral=new AutoriConsepParameterReturnGeneral();
	
			AutoriConsepLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoriconseps,autoriconsepParameterGeneral,autoriconsepReturnGeneral);
			
			return autoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriConsepParameterReturnGeneral procesarAccionAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriConsep> autoriconseps,AutoriConsepParameterReturnGeneral autoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-procesarAccionAutoriConsepsWithConnection");connexion.begin();			
			
			AutoriConsepParameterReturnGeneral autoriconsepReturnGeneral=new AutoriConsepParameterReturnGeneral();
	
			AutoriConsepLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoriconseps,autoriconsepParameterGeneral,autoriconsepReturnGeneral);
			
			this.connexion.commit();
			
			return autoriconsepReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriConsepParameterReturnGeneral procesarEventosAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriConsep> autoriconseps,AutoriConsep autoriconsep,AutoriConsepParameterReturnGeneral autoriconsepParameterGeneral,Boolean isEsNuevoAutoriConsep,ArrayList<Classe> clases)throws Exception {
		 try {	
			AutoriConsepParameterReturnGeneral autoriconsepReturnGeneral=new AutoriConsepParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriConsepLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoriconseps,autoriconsep,autoriconsepParameterGeneral,autoriconsepReturnGeneral,isEsNuevoAutoriConsep,clases);
			
			return autoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AutoriConsepParameterReturnGeneral procesarEventosAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriConsep> autoriconseps,AutoriConsep autoriconsep,AutoriConsepParameterReturnGeneral autoriconsepParameterGeneral,Boolean isEsNuevoAutoriConsep,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-procesarEventosAutoriConsepsWithConnection");connexion.begin();			
			
			AutoriConsepParameterReturnGeneral autoriconsepReturnGeneral=new AutoriConsepParameterReturnGeneral();
	
			autoriconsepReturnGeneral.setAutoriConsep(autoriconsep);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriConsepLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoriconseps,autoriconsep,autoriconsepParameterGeneral,autoriconsepReturnGeneral,isEsNuevoAutoriConsep,clases);
			
			this.connexion.commit();
			
			return autoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriConsepParameterReturnGeneral procesarImportacionAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AutoriConsepParameterReturnGeneral autoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-procesarImportacionAutoriConsepsWithConnection");connexion.begin();			
			
			AutoriConsepParameterReturnGeneral autoriconsepReturnGeneral=new AutoriConsepParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.autoriconseps=new ArrayList<AutoriConsep>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.autoriconsep=new AutoriConsep();
				
				
				if(conColumnasBase) {this.autoriconsep.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.autoriconsep.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.autoriconsep.setes_empresa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.autoriconsep.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.autoriconsep.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoriconsep.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoriconsep.setfecha_ultima(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoriconsep.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoriconsep.setdescripcion(arrColumnas[iColumn++]);
				
				this.autoriconseps.add(this.autoriconsep);
			}
			
			this.saveAutoriConseps();
			
			this.connexion.commit();
			
			autoriconsepReturnGeneral.setConRetornoEstaProcesado(true);
			autoriconsepReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return autoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAutoriConsepsEliminados() throws Exception {				
		
		List<AutoriConsep> autoriconsepsAux= new ArrayList<AutoriConsep>();
		
		for(AutoriConsep autoriconsep:autoriconseps) {
			if(!autoriconsep.getIsDeleted()) {
				autoriconsepsAux.add(autoriconsep);
			}
		}
		
		autoriconseps=autoriconsepsAux;
	}
	
	public void quitarAutoriConsepsNulos() throws Exception {				
		
		List<AutoriConsep> autoriconsepsAux= new ArrayList<AutoriConsep>();
		
		for(AutoriConsep autoriconsep : this.autoriconseps) {
			if(autoriconsep==null) {
				autoriconsepsAux.add(autoriconsep);
			}
		}
		
		//this.autoriconseps=autoriconsepsAux;
		
		this.autoriconseps.removeAll(autoriconsepsAux);
	}
	
	public void getSetVersionRowAutoriConsepWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(autoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((autoriconsep.getIsDeleted() || (autoriconsep.getIsChanged()&&!autoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=autoriconsepDataAccess.getSetVersionRowAutoriConsep(connexion,autoriconsep.getId());
				
				if(!autoriconsep.getVersionRow().equals(timestamp)) {	
					autoriconsep.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				autoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAutoriConsep()throws Exception {	
		
		if(autoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((autoriconsep.getIsDeleted() || (autoriconsep.getIsChanged()&&!autoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=autoriconsepDataAccess.getSetVersionRowAutoriConsep(connexion,autoriconsep.getId());
			
			try {							
				if(!autoriconsep.getVersionRow().equals(timestamp)) {	
					autoriconsep.setVersionRow(timestamp);
				}
				
				autoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAutoriConsepsWithConnection()throws Exception {	
		if(autoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AutoriConsep autoriconsepAux:autoriconseps) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(autoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoriconsepAux.getIsDeleted() || (autoriconsepAux.getIsChanged()&&!autoriconsepAux.getIsNew())) {
						
						timestamp=autoriconsepDataAccess.getSetVersionRowAutoriConsep(connexion,autoriconsepAux.getId());
						
						if(!autoriconsep.getVersionRow().equals(timestamp)) {	
							autoriconsepAux.setVersionRow(timestamp);
						}
								
						autoriconsepAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAutoriConseps()throws Exception {	
		if(autoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AutoriConsep autoriconsepAux:autoriconseps) {
					if(autoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoriconsepAux.getIsDeleted() || (autoriconsepAux.getIsChanged()&&!autoriconsepAux.getIsNew())) {
						
						timestamp=autoriconsepDataAccess.getSetVersionRowAutoriConsep(connexion,autoriconsepAux.getId());
						
						if(!autoriconsepAux.getVersionRow().equals(timestamp)) {	
							autoriconsepAux.setVersionRow(timestamp);
						}
						
													
						autoriconsepAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AutoriConsepParameterReturnGeneral cargarCombosLoteForeignKeyAutoriConsepWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalUsuario,String finalQueryGlobalCliente,String finalQueryGlobalTipoAutoriConsep,String finalQueryGlobalEmpleado) throws Exception {
		AutoriConsepParameterReturnGeneral  autoriconsepReturnGeneral =new AutoriConsepParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-cargarCombosLoteForeignKeyAutoriConsepWithConnection");connexion.begin();
			
			autoriconsepReturnGeneral =new AutoriConsepParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoriconsepReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			autoriconsepReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			autoriconsepReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoAutoriConsep> tipoautoriconsepsForeignKey=new ArrayList<TipoAutoriConsep>();
			TipoAutoriConsepLogic tipoautoriconsepLogic=new TipoAutoriConsepLogic();
			tipoautoriconsepLogic.setConnexion(this.connexion);
			tipoautoriconsepLogic.getTipoAutoriConsepDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAutoriConsep.equals("NONE")) {
				tipoautoriconsepLogic.getTodosTipoAutoriConseps(finalQueryGlobalTipoAutoriConsep,new Pagination());
				tipoautoriconsepsForeignKey=tipoautoriconsepLogic.getTipoAutoriConseps();
			}

			autoriconsepReturnGeneral.settipoautoriconsepsForeignKey(tipoautoriconsepsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			autoriconsepReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return autoriconsepReturnGeneral;
	}
	
	public AutoriConsepParameterReturnGeneral cargarCombosLoteForeignKeyAutoriConsep(String finalQueryGlobalEmpresa,String finalQueryGlobalUsuario,String finalQueryGlobalCliente,String finalQueryGlobalTipoAutoriConsep,String finalQueryGlobalEmpleado) throws Exception {
		AutoriConsepParameterReturnGeneral  autoriconsepReturnGeneral =new AutoriConsepParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			autoriconsepReturnGeneral =new AutoriConsepParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoriconsepReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			autoriconsepReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			autoriconsepReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoAutoriConsep> tipoautoriconsepsForeignKey=new ArrayList<TipoAutoriConsep>();
			TipoAutoriConsepLogic tipoautoriconsepLogic=new TipoAutoriConsepLogic();
			tipoautoriconsepLogic.setConnexion(this.connexion);
			tipoautoriconsepLogic.getTipoAutoriConsepDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAutoriConsep.equals("NONE")) {
				tipoautoriconsepLogic.getTodosTipoAutoriConseps(finalQueryGlobalTipoAutoriConsep,new Pagination());
				tipoautoriconsepsForeignKey=tipoautoriconsepLogic.getTipoAutoriConseps();
			}

			autoriconsepReturnGeneral.settipoautoriconsepsForeignKey(tipoautoriconsepsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			autoriconsepReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return autoriconsepReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyAutoriConsepWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleAutoriConsepLogic detalleautoriconsepLogic=new DetalleAutoriConsepLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyAutoriConsepWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleAutoriConsep.class));
											
			

			detalleautoriconsepLogic.setConnexion(this.getConnexion());
			detalleautoriconsepLogic.setDatosCliente(this.datosCliente);
			detalleautoriconsepLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(AutoriConsep autoriconsep:this.autoriconseps) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleAutoriConsepConstantesFunciones.getClassesForeignKeysOfDetalleAutoriConsep(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleautoriconsepLogic.setDetalleAutoriConseps(autoriconsep.detalleautoriconseps);
				detalleautoriconsepLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(AutoriConsep autoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AutoriConsepLogicAdditional.updateAutoriConsepToGet(autoriconsep,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoriconsep.setEmpresa(autoriconsepDataAccess.getEmpresa(connexion,autoriconsep));
		autoriconsep.setUsuario(autoriconsepDataAccess.getUsuario(connexion,autoriconsep));
		autoriconsep.setCliente(autoriconsepDataAccess.getCliente(connexion,autoriconsep));
		autoriconsep.setTipoAutoriConsep(autoriconsepDataAccess.getTipoAutoriConsep(connexion,autoriconsep));
		autoriconsep.setEmpleado(autoriconsepDataAccess.getEmpleado(connexion,autoriconsep));
		autoriconsep.setDetalleAutoriConseps(autoriconsepDataAccess.getDetalleAutoriConseps(connexion,autoriconsep));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autoriconsep.setEmpresa(autoriconsepDataAccess.getEmpresa(connexion,autoriconsep));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				autoriconsep.setUsuario(autoriconsepDataAccess.getUsuario(connexion,autoriconsep));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				autoriconsep.setCliente(autoriconsepDataAccess.getCliente(connexion,autoriconsep));
				continue;
			}

			if(clas.clas.equals(TipoAutoriConsep.class)) {
				autoriconsep.setTipoAutoriConsep(autoriconsepDataAccess.getTipoAutoriConsep(connexion,autoriconsep));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				autoriconsep.setEmpleado(autoriconsepDataAccess.getEmpleado(connexion,autoriconsep));
				continue;
			}

			if(clas.clas.equals(DetalleAutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				autoriconsep.setDetalleAutoriConseps(autoriconsepDataAccess.getDetalleAutoriConseps(connexion,autoriconsep));

				if(this.isConDeep) {
					DetalleAutoriConsepLogic detalleautoriconsepLogic= new DetalleAutoriConsepLogic(this.connexion);
					detalleautoriconsepLogic.setDetalleAutoriConseps(autoriconsep.getDetalleAutoriConseps());
					ArrayList<Classe> classesLocal=DetalleAutoriConsepConstantesFunciones.getClassesForeignKeysOfDetalleAutoriConsep(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleautoriconsepLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(detalleautoriconsepLogic.getDetalleAutoriConseps());
					autoriconsep.setDetalleAutoriConseps(detalleautoriconsepLogic.getDetalleAutoriConseps());
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
			autoriconsep.setEmpresa(autoriconsepDataAccess.getEmpresa(connexion,autoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setUsuario(autoriconsepDataAccess.getUsuario(connexion,autoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setCliente(autoriconsepDataAccess.getCliente(connexion,autoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAutoriConsep.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setTipoAutoriConsep(autoriconsepDataAccess.getTipoAutoriConsep(connexion,autoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setEmpleado(autoriconsepDataAccess.getEmpleado(connexion,autoriconsep));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleAutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleAutoriConsep.class));
			autoriconsep.setDetalleAutoriConseps(autoriconsepDataAccess.getDetalleAutoriConseps(connexion,autoriconsep));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoriconsep.setEmpresa(autoriconsepDataAccess.getEmpresa(connexion,autoriconsep));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoriconsep.getEmpresa(),isDeep,deepLoadType,clases);
				
		autoriconsep.setUsuario(autoriconsepDataAccess.getUsuario(connexion,autoriconsep));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(autoriconsep.getUsuario(),isDeep,deepLoadType,clases);
				
		autoriconsep.setCliente(autoriconsepDataAccess.getCliente(connexion,autoriconsep));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(autoriconsep.getCliente(),isDeep,deepLoadType,clases);
				
		autoriconsep.setTipoAutoriConsep(autoriconsepDataAccess.getTipoAutoriConsep(connexion,autoriconsep));
		TipoAutoriConsepLogic tipoautoriconsepLogic= new TipoAutoriConsepLogic(connexion);
		tipoautoriconsepLogic.deepLoad(autoriconsep.getTipoAutoriConsep(),isDeep,deepLoadType,clases);
				
		autoriconsep.setEmpleado(autoriconsepDataAccess.getEmpleado(connexion,autoriconsep));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(autoriconsep.getEmpleado(),isDeep,deepLoadType,clases);
				

		autoriconsep.setDetalleAutoriConseps(autoriconsepDataAccess.getDetalleAutoriConseps(connexion,autoriconsep));

		for(DetalleAutoriConsep detalleautoriconsep:autoriconsep.getDetalleAutoriConseps()) {
			DetalleAutoriConsepLogic detalleautoriconsepLogic= new DetalleAutoriConsepLogic(connexion);
			detalleautoriconsepLogic.deepLoad(detalleautoriconsep,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autoriconsep.setEmpresa(autoriconsepDataAccess.getEmpresa(connexion,autoriconsep));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(autoriconsep.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				autoriconsep.setUsuario(autoriconsepDataAccess.getUsuario(connexion,autoriconsep));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(autoriconsep.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				autoriconsep.setCliente(autoriconsepDataAccess.getCliente(connexion,autoriconsep));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(autoriconsep.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAutoriConsep.class)) {
				autoriconsep.setTipoAutoriConsep(autoriconsepDataAccess.getTipoAutoriConsep(connexion,autoriconsep));
				TipoAutoriConsepLogic tipoautoriconsepLogic= new TipoAutoriConsepLogic(connexion);
				tipoautoriconsepLogic.deepLoad(autoriconsep.getTipoAutoriConsep(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				autoriconsep.setEmpleado(autoriconsepDataAccess.getEmpleado(connexion,autoriconsep));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(autoriconsep.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleAutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				autoriconsep.setDetalleAutoriConseps(autoriconsepDataAccess.getDetalleAutoriConseps(connexion,autoriconsep));

				for(DetalleAutoriConsep detalleautoriconsep:autoriconsep.getDetalleAutoriConseps()) {
					DetalleAutoriConsepLogic detalleautoriconsepLogic= new DetalleAutoriConsepLogic(connexion);
					detalleautoriconsepLogic.deepLoad(detalleautoriconsep,isDeep,deepLoadType,clases);
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
			autoriconsep.setEmpresa(autoriconsepDataAccess.getEmpresa(connexion,autoriconsep));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(autoriconsep.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setUsuario(autoriconsepDataAccess.getUsuario(connexion,autoriconsep));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(autoriconsep.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setCliente(autoriconsepDataAccess.getCliente(connexion,autoriconsep));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(autoriconsep.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAutoriConsep.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setTipoAutoriConsep(autoriconsepDataAccess.getTipoAutoriConsep(connexion,autoriconsep));
			TipoAutoriConsepLogic tipoautoriconsepLogic= new TipoAutoriConsepLogic(connexion);
			tipoautoriconsepLogic.deepLoad(autoriconsep.getTipoAutoriConsep(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriconsep.setEmpleado(autoriconsepDataAccess.getEmpleado(connexion,autoriconsep));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(autoriconsep.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleAutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleAutoriConsep.class));
			autoriconsep.setDetalleAutoriConseps(autoriconsepDataAccess.getDetalleAutoriConseps(connexion,autoriconsep));

			for(DetalleAutoriConsep detalleautoriconsep:autoriconsep.getDetalleAutoriConseps()) {
				DetalleAutoriConsepLogic detalleautoriconsepLogic= new DetalleAutoriConsepLogic(connexion);
				detalleautoriconsepLogic.deepLoad(detalleautoriconsep,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AutoriConsep autoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AutoriConsepLogicAdditional.updateAutoriConsepToSave(autoriconsep,this.arrDatoGeneral);
			
AutoriConsepDataAccess.save(autoriconsep, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autoriconsep.getEmpresa(),connexion);

		UsuarioDataAccess.save(autoriconsep.getUsuario(),connexion);

		ClienteDataAccess.save(autoriconsep.getCliente(),connexion);

		TipoAutoriConsepDataAccess.save(autoriconsep.getTipoAutoriConsep(),connexion);

		EmpleadoDataAccess.save(autoriconsep.getEmpleado(),connexion);

		for(DetalleAutoriConsep detalleautoriconsep:autoriconsep.getDetalleAutoriConseps()) {
			detalleautoriconsep.setid_autori_consep(autoriconsep.getId());
			DetalleAutoriConsepDataAccess.save(detalleautoriconsep,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoriconsep.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(autoriconsep.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(autoriconsep.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoAutoriConsep.class)) {
				TipoAutoriConsepDataAccess.save(autoriconsep.getTipoAutoriConsep(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(autoriconsep.getEmpleado(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleAutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleAutoriConsep detalleautoriconsep:autoriconsep.getDetalleAutoriConseps()) {
					detalleautoriconsep.setid_autori_consep(autoriconsep.getId());
					DetalleAutoriConsepDataAccess.save(detalleautoriconsep,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autoriconsep.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoriconsep.getEmpresa(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(autoriconsep.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(autoriconsep.getUsuario(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(autoriconsep.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(autoriconsep.getCliente(),isDeep,deepLoadType,clases);
				

		TipoAutoriConsepDataAccess.save(autoriconsep.getTipoAutoriConsep(),connexion);
		TipoAutoriConsepLogic tipoautoriconsepLogic= new TipoAutoriConsepLogic(connexion);
		tipoautoriconsepLogic.deepLoad(autoriconsep.getTipoAutoriConsep(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(autoriconsep.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(autoriconsep.getEmpleado(),isDeep,deepLoadType,clases);
				

		for(DetalleAutoriConsep detalleautoriconsep:autoriconsep.getDetalleAutoriConseps()) {
			DetalleAutoriConsepLogic detalleautoriconsepLogic= new DetalleAutoriConsepLogic(connexion);
			detalleautoriconsep.setid_autori_consep(autoriconsep.getId());
			DetalleAutoriConsepDataAccess.save(detalleautoriconsep,connexion);
			detalleautoriconsepLogic.deepSave(detalleautoriconsep,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoriconsep.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(autoriconsep.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(autoriconsep.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(autoriconsep.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(autoriconsep.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(autoriconsep.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAutoriConsep.class)) {
				TipoAutoriConsepDataAccess.save(autoriconsep.getTipoAutoriConsep(),connexion);
				TipoAutoriConsepLogic tipoautoriconsepLogic= new TipoAutoriConsepLogic(connexion);
				tipoautoriconsepLogic.deepSave(autoriconsep.getTipoAutoriConsep(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(autoriconsep.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(autoriconsep.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleAutoriConsep.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleAutoriConsep detalleautoriconsep:autoriconsep.getDetalleAutoriConseps()) {
					DetalleAutoriConsepLogic detalleautoriconsepLogic= new DetalleAutoriConsepLogic(connexion);
					detalleautoriconsep.setid_autori_consep(autoriconsep.getId());
					DetalleAutoriConsepDataAccess.save(detalleautoriconsep,connexion);
					detalleautoriconsepLogic.deepSave(detalleautoriconsep,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(AutoriConsep.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(autoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(autoriconsep);
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
			this.deepLoad(this.autoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AutoriConsep.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(autoriconseps!=null) {
				for(AutoriConsep autoriconsep:autoriconseps) {
					this.deepLoad(autoriconsep,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(autoriconseps);
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
			if(autoriconseps!=null) {
				for(AutoriConsep autoriconsep:autoriconseps) {
					this.deepLoad(autoriconsep,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(autoriconseps);
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
			this.getNewConnexionToDeep(AutoriConsep.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(autoriconsep,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AutoriConsep.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(autoriconseps!=null) {
				for(AutoriConsep autoriconsep:autoriconseps) {
					this.deepSave(autoriconsep,isDeep,deepLoadType,clases);
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
			if(autoriconseps!=null) {
				for(AutoriConsep autoriconsep:autoriconseps) {
					this.deepSave(autoriconsep,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAutoriConsepsBusquedaPorNumeroAutorizacionWithConnection(String sFinalQuery,Pagination pagination,String numero_autorizacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroAutorizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroAutorizacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_autorizacion+"%",AutoriConsepConstantesFunciones.NUMEROAUTORIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroAutorizacion);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroAutorizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriConsepsBusquedaPorNumeroAutorizacion(String sFinalQuery,Pagination pagination,String numero_autorizacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroAutorizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroAutorizacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_autorizacion+"%",AutoriConsepConstantesFunciones.NUMEROAUTORIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroAutorizacion);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroAutorizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriConsepsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AutoriConsepConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriConsepsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AutoriConsepConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriConsepsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AutoriConsepConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriConsepsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AutoriConsepConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriConsepsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriConsepConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriConsepsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriConsepConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriConsepsFK_IdTipoAutoriConsepWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_autori_consep)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAutoriConsep= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAutoriConsep.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_autori_consep,AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAutoriConsep);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAutoriConsep","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriConsepsFK_IdTipoAutoriConsep(String sFinalQuery,Pagination pagination,Long id_tipo_autori_consep)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAutoriConsep= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAutoriConsep.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_autori_consep,AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAutoriConsep);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAutoriConsep","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriConsepsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AutoriConsepConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriConsepsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AutoriConsepConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesAutoriConsep(this.autoriconseps);
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
			if(AutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriConsepDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AutoriConsep autoriconsep,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				if(autoriconsep.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriConsepDataAccess.TABLENAME, autoriconsep.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriConsepLogic.registrarAuditoriaDetallesAutoriConsep(connexion,autoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(autoriconsep.getIsDeleted()) {
					/*if(!autoriconsep.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AutoriConsepDataAccess.TABLENAME, autoriconsep.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AutoriConsepLogic.registrarAuditoriaDetallesAutoriConsep(connexion,autoriconsep,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriConsepDataAccess.TABLENAME, autoriconsep.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(autoriconsep.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriConsepDataAccess.TABLENAME, autoriconsep.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriConsepLogic.registrarAuditoriaDetallesAutoriConsep(connexion,autoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAutoriConsep(Connexion connexion,AutoriConsep autoriconsep)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(autoriconsep.getIsNew()||!autoriconsep.getid_empresa().equals(autoriconsep.getAutoriConsepOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getid_empresa()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getid_empresa().toString();
				}
				if(autoriconsep.getid_empresa()!=null)
				{
					strValorNuevo=autoriconsep.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getid_usuario().equals(autoriconsep.getAutoriConsepOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getid_usuario()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getid_usuario().toString();
				}
				if(autoriconsep.getid_usuario()!=null)
				{
					strValorNuevo=autoriconsep.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getes_empresa().equals(autoriconsep.getAutoriConsepOriginal().getes_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getes_empresa()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getes_empresa().toString();
				}
				if(autoriconsep.getes_empresa()!=null)
				{
					strValorNuevo=autoriconsep.getes_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.ESEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getid_cliente().equals(autoriconsep.getAutoriConsepOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getid_cliente()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getid_cliente().toString();
				}
				if(autoriconsep.getid_cliente()!=null)
				{
					strValorNuevo=autoriconsep.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getnumero_autorizacion().equals(autoriconsep.getAutoriConsepOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getnumero_autorizacion();
				}
				if(autoriconsep.getnumero_autorizacion()!=null)
				{
					strValorNuevo=autoriconsep.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getid_tipo_autori_consep().equals(autoriconsep.getAutoriConsepOriginal().getid_tipo_autori_consep()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getid_tipo_autori_consep()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getid_tipo_autori_consep().toString();
				}
				if(autoriconsep.getid_tipo_autori_consep()!=null)
				{
					strValorNuevo=autoriconsep.getid_tipo_autori_consep().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getid_empleado().equals(autoriconsep.getAutoriConsepOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getid_empleado()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getid_empleado().toString();
				}
				if(autoriconsep.getid_empleado()!=null)
				{
					strValorNuevo=autoriconsep.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getfecha_emision().equals(autoriconsep.getAutoriConsepOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getfecha_emision()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getfecha_emision().toString();
				}
				if(autoriconsep.getfecha_emision()!=null)
				{
					strValorNuevo=autoriconsep.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getfecha_vencimiento().equals(autoriconsep.getAutoriConsepOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getfecha_vencimiento().toString();
				}
				if(autoriconsep.getfecha_vencimiento()!=null)
				{
					strValorNuevo=autoriconsep.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getfecha_ultima().equals(autoriconsep.getAutoriConsepOriginal().getfecha_ultima()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getfecha_ultima()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getfecha_ultima().toString();
				}
				if(autoriconsep.getfecha_ultima()!=null)
				{
					strValorNuevo=autoriconsep.getfecha_ultima().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.FECHAULTIMA,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getfecha().equals(autoriconsep.getAutoriConsepOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getfecha()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getfecha().toString();
				}
				if(autoriconsep.getfecha()!=null)
				{
					strValorNuevo=autoriconsep.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getdescripcion().equals(autoriconsep.getAutoriConsepOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getdescripcion()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getdescripcion();
				}
				if(autoriconsep.getdescripcion()!=null)
				{
					strValorNuevo=autoriconsep.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(autoriconsep.getIsNew()||!autoriconsep.getnombre().equals(autoriconsep.getAutoriConsepOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriconsep.getAutoriConsepOriginal().getnombre()!=null)
				{
					strValorActual=autoriconsep.getAutoriConsepOriginal().getnombre();
				}
				if(autoriconsep.getnombre()!=null)
				{
					strValorNuevo=autoriconsep.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriConsepConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAutoriConsepRelacionesWithConnection(AutoriConsep autoriconsep,List<DetalleAutoriConsep> detalleautoriconseps) throws Exception {

		if(!autoriconsep.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriConsepRelacionesBase(autoriconsep,detalleautoriconseps,true);
		}
	}

	public void saveAutoriConsepRelaciones(AutoriConsep autoriconsep,List<DetalleAutoriConsep> detalleautoriconseps)throws Exception {

		if(!autoriconsep.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriConsepRelacionesBase(autoriconsep,detalleautoriconseps,false);
		}
	}

	public void saveAutoriConsepRelacionesBase(AutoriConsep autoriconsep,List<DetalleAutoriConsep> detalleautoriconseps,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AutoriConsep-saveRelacionesWithConnection");}
	
			autoriconsep.setDetalleAutoriConseps(detalleautoriconseps);

			this.setAutoriConsep(autoriconsep);

			if(AutoriConsepLogicAdditional.validarSaveRelaciones(autoriconsep,this)) {

				AutoriConsepLogicAdditional.updateRelacionesToSave(autoriconsep,this);

				if((autoriconsep.getIsNew()||autoriconsep.getIsChanged())&&!autoriconsep.getIsDeleted()) {
					this.saveAutoriConsep();
					this.saveAutoriConsepRelacionesDetalles(detalleautoriconseps);

				} else if(autoriconsep.getIsDeleted()) {
					this.saveAutoriConsepRelacionesDetalles(detalleautoriconseps);
					this.saveAutoriConsep();
				}

				AutoriConsepLogicAdditional.updateRelacionesToSaveAfter(autoriconsep,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleAutoriConsepConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleAutoriConseps(detalleautoriconseps,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveAutoriConsepRelacionesDetalles(List<DetalleAutoriConsep> detalleautoriconseps)throws Exception {
		try {
	

			Long idAutoriConsepActual=this.getAutoriConsep().getId();

			DetalleAutoriConsepLogic detalleautoriconsepLogic_Desde_AutoriConsep=new DetalleAutoriConsepLogic();
			detalleautoriconsepLogic_Desde_AutoriConsep.setDetalleAutoriConseps(detalleautoriconseps);

			detalleautoriconsepLogic_Desde_AutoriConsep.setConnexion(this.getConnexion());
			detalleautoriconsepLogic_Desde_AutoriConsep.setDatosCliente(this.datosCliente);

			for(DetalleAutoriConsep detalleautoriconsep_Desde_AutoriConsep:detalleautoriconsepLogic_Desde_AutoriConsep.getDetalleAutoriConseps()) {
				detalleautoriconsep_Desde_AutoriConsep.setid_autori_consep(idAutoriConsepActual);
			}

			detalleautoriconsepLogic_Desde_AutoriConsep.saveDetalleAutoriConseps();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriConsepConstantesFunciones.getClassesForeignKeysOfAutoriConsep(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriConsepConstantesFunciones.getClassesRelationshipsOfAutoriConsep(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
