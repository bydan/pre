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
import com.bydan.erp.cartera.util.TipoAreaLaboConstantesFunciones;
import com.bydan.erp.cartera.util.TipoAreaLaboParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoAreaLaboParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoAreaLabo;
import com.bydan.erp.cartera.business.logic.TipoAreaLaboLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoAreaLaboLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoAreaLaboLogic.class);
	
	protected TipoAreaLaboDataAccess tipoarealaboDataAccess; 	
	protected TipoAreaLabo tipoarealabo;
	protected List<TipoAreaLabo> tipoarealabos;
	protected Object tipoarealaboObject;	
	protected List<Object> tipoarealabosObject;
	
	public static ClassValidator<TipoAreaLabo> tipoarealaboValidator = new ClassValidator<TipoAreaLabo>(TipoAreaLabo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoAreaLaboLogicAdditional tipoarealaboLogicAdditional=null;
	
	public TipoAreaLaboLogicAdditional getTipoAreaLaboLogicAdditional() {
		return this.tipoarealaboLogicAdditional;
	}
	
	public void setTipoAreaLaboLogicAdditional(TipoAreaLaboLogicAdditional tipoarealaboLogicAdditional) {
		try {
			this.tipoarealaboLogicAdditional=tipoarealaboLogicAdditional;
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
	
	
	
	
	public  TipoAreaLaboLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoarealaboDataAccess = new TipoAreaLaboDataAccess();
			
			this.tipoarealabos= new ArrayList<TipoAreaLabo>();
			this.tipoarealabo= new TipoAreaLabo();
			
			this.tipoarealaboObject=new Object();
			this.tipoarealabosObject=new ArrayList<Object>();
				
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
			
			this.tipoarealaboDataAccess.setConnexionType(this.connexionType);
			this.tipoarealaboDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoAreaLaboLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoarealaboDataAccess = new TipoAreaLaboDataAccess();
			this.tipoarealabos= new ArrayList<TipoAreaLabo>();
			this.tipoarealabo= new TipoAreaLabo();
			this.tipoarealaboObject=new Object();
			this.tipoarealabosObject=new ArrayList<Object>();
			
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
			
			this.tipoarealaboDataAccess.setConnexionType(this.connexionType);
			this.tipoarealaboDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoAreaLabo getTipoAreaLabo() throws Exception {	
		TipoAreaLaboLogicAdditional.checkTipoAreaLaboToGet(tipoarealabo,this.datosCliente,this.arrDatoGeneral);
		TipoAreaLaboLogicAdditional.updateTipoAreaLaboToGet(tipoarealabo,this.arrDatoGeneral);
		
		return tipoarealabo;
	}
		
	public void setTipoAreaLabo(TipoAreaLabo newTipoAreaLabo) {
		this.tipoarealabo = newTipoAreaLabo;
	}
	
	public TipoAreaLaboDataAccess getTipoAreaLaboDataAccess() {
		return tipoarealaboDataAccess;
	}
	
	public void setTipoAreaLaboDataAccess(TipoAreaLaboDataAccess newtipoarealaboDataAccess) {
		this.tipoarealaboDataAccess = newtipoarealaboDataAccess;
	}
	
	public List<TipoAreaLabo> getTipoAreaLabos() throws Exception {		
		this.quitarTipoAreaLabosNulos();
		
		TipoAreaLaboLogicAdditional.checkTipoAreaLaboToGets(tipoarealabos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoAreaLabo tipoarealaboLocal: tipoarealabos ) {
			TipoAreaLaboLogicAdditional.updateTipoAreaLaboToGet(tipoarealaboLocal,this.arrDatoGeneral);
		}
		
		return tipoarealabos;
	}
	
	public void setTipoAreaLabos(List<TipoAreaLabo> newTipoAreaLabos) {
		this.tipoarealabos = newTipoAreaLabos;
	}
	
	public Object getTipoAreaLaboObject() {	
		this.tipoarealaboObject=this.tipoarealaboDataAccess.getEntityObject();
		return this.tipoarealaboObject;
	}
		
	public void setTipoAreaLaboObject(Object newTipoAreaLaboObject) {
		this.tipoarealaboObject = newTipoAreaLaboObject;
	}
	
	public List<Object> getTipoAreaLabosObject() {		
		this.tipoarealabosObject=this.tipoarealaboDataAccess.getEntitiesObject();
		return this.tipoarealabosObject;
	}
		
	public void setTipoAreaLabosObject(List<Object> newTipoAreaLabosObject) {
		this.tipoarealabosObject = newTipoAreaLabosObject;
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
		
		if(this.tipoarealaboDataAccess!=null) {
			this.tipoarealaboDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoarealaboDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoarealaboDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoarealabo = new  TipoAreaLabo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoarealabo=tipoarealaboDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoarealabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabo);
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
		tipoarealabo = new  TipoAreaLabo();
		  		  
        try {
			
			tipoarealabo=tipoarealaboDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoarealabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoarealabo = new  TipoAreaLabo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoarealabo=tipoarealaboDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoarealabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabo);
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
		tipoarealabo = new  TipoAreaLabo();
		  		  
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
		tipoarealabo = new  TipoAreaLabo();
		  		  
        try {
			
			tipoarealabo=tipoarealaboDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoarealabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoarealabo = new  TipoAreaLabo();
		  		  
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
		tipoarealabo = new  TipoAreaLabo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoarealaboDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoarealabo = new  TipoAreaLabo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoarealaboDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoarealabo = new  TipoAreaLabo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoarealaboDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoarealabo = new  TipoAreaLabo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoarealaboDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoarealabo = new  TipoAreaLabo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoarealaboDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoarealabo = new  TipoAreaLabo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoarealaboDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
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
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
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
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
        try {			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
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
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
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
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
        try {
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
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
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
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
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoarealabo = new  TipoAreaLabo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabo=tipoarealaboDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabo);
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
		tipoarealabo = new  TipoAreaLabo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabo=tipoarealaboDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
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
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		  		  
        try {
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoAreaLabosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getTodosTipoAreaLabosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
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
	
	public  void  getTodosTipoAreaLabos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoarealabos = new  ArrayList<TipoAreaLabo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAreaLabo(tipoarealabos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoAreaLabo(TipoAreaLabo tipoarealabo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoarealabo.getIsNew() || tipoarealabo.getIsChanged()) { 
			this.invalidValues = tipoarealaboValidator.getInvalidValues(tipoarealabo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoarealabo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoAreaLabo(List<TipoAreaLabo> TipoAreaLabos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoAreaLabo tipoarealaboLocal:tipoarealabos) {				
			estaValidadoObjeto=this.validarGuardarTipoAreaLabo(tipoarealaboLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoAreaLabo(List<TipoAreaLabo> TipoAreaLabos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAreaLabo(tipoarealabos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoAreaLabo(TipoAreaLabo TipoAreaLabo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAreaLabo(tipoarealabo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoAreaLabo tipoarealabo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoarealabo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoAreaLaboConstantesFunciones.getTipoAreaLaboLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoarealabo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoAreaLaboConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoAreaLaboConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoAreaLaboWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-saveTipoAreaLaboWithConnection");connexion.begin();			
			
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSave(this.tipoarealabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAreaLaboLogicAdditional.updateTipoAreaLaboToSave(this.tipoarealabo,this.arrDatoGeneral);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoarealabo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoAreaLabo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAreaLabo(this.tipoarealabo)) {
				TipoAreaLaboDataAccess.save(this.tipoarealabo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoarealabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSaveAfter(this.tipoarealabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAreaLabo();
			
			connexion.commit();			
			
			if(this.tipoarealabo.getIsDeleted()) {
				this.tipoarealabo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoAreaLabo()throws Exception {	
		try {	
			
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSave(this.tipoarealabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAreaLaboLogicAdditional.updateTipoAreaLaboToSave(this.tipoarealabo,this.arrDatoGeneral);
			
			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoarealabo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAreaLabo(this.tipoarealabo)) {			
				TipoAreaLaboDataAccess.save(this.tipoarealabo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoarealabo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSaveAfter(this.tipoarealabo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoarealabo.getIsDeleted()) {
				this.tipoarealabo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoAreaLabosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-saveTipoAreaLabosWithConnection");connexion.begin();			
			
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSaves(tipoarealabos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoAreaLabos();
			
			Boolean validadoTodosTipoAreaLabo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAreaLabo tipoarealaboLocal:tipoarealabos) {		
				if(tipoarealaboLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAreaLaboLogicAdditional.updateTipoAreaLaboToSave(tipoarealaboLocal,this.arrDatoGeneral);
	        	
				TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoarealaboLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAreaLabo(tipoarealaboLocal)) {
					TipoAreaLaboDataAccess.save(tipoarealaboLocal, connexion);				
				} else {
					validadoTodosTipoAreaLabo=false;
				}
			}
			
			if(!validadoTodosTipoAreaLabo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSavesAfter(tipoarealabos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAreaLabos();
			
			connexion.commit();		
			
			this.quitarTipoAreaLabosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoAreaLabos()throws Exception {				
		 try {	
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSaves(tipoarealabos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoAreaLabo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAreaLabo tipoarealaboLocal:tipoarealabos) {				
				if(tipoarealaboLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAreaLaboLogicAdditional.updateTipoAreaLaboToSave(tipoarealaboLocal,this.arrDatoGeneral);
	        	
				TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoarealaboLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAreaLabo(tipoarealaboLocal)) {				
					TipoAreaLaboDataAccess.save(tipoarealaboLocal, connexion);				
				} else {
					validadoTodosTipoAreaLabo=false;
				}
			}
			
			if(!validadoTodosTipoAreaLabo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAreaLaboLogicAdditional.checkTipoAreaLaboToSavesAfter(tipoarealabos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoAreaLabosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAreaLaboParameterReturnGeneral procesarAccionTipoAreaLabos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAreaLabo> tipoarealabos,TipoAreaLaboParameterReturnGeneral tipoarealaboParameterGeneral)throws Exception {
		 try {	
			TipoAreaLaboParameterReturnGeneral tipoarealaboReturnGeneral=new TipoAreaLaboParameterReturnGeneral();
	
			TipoAreaLaboLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoarealabos,tipoarealaboParameterGeneral,tipoarealaboReturnGeneral);
			
			return tipoarealaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAreaLaboParameterReturnGeneral procesarAccionTipoAreaLabosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAreaLabo> tipoarealabos,TipoAreaLaboParameterReturnGeneral tipoarealaboParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-procesarAccionTipoAreaLabosWithConnection");connexion.begin();			
			
			TipoAreaLaboParameterReturnGeneral tipoarealaboReturnGeneral=new TipoAreaLaboParameterReturnGeneral();
	
			TipoAreaLaboLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoarealabos,tipoarealaboParameterGeneral,tipoarealaboReturnGeneral);
			
			this.connexion.commit();
			
			return tipoarealaboReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAreaLaboParameterReturnGeneral procesarEventosTipoAreaLabos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAreaLabo> tipoarealabos,TipoAreaLabo tipoarealabo,TipoAreaLaboParameterReturnGeneral tipoarealaboParameterGeneral,Boolean isEsNuevoTipoAreaLabo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoAreaLaboParameterReturnGeneral tipoarealaboReturnGeneral=new TipoAreaLaboParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoarealaboReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAreaLaboLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoarealabos,tipoarealabo,tipoarealaboParameterGeneral,tipoarealaboReturnGeneral,isEsNuevoTipoAreaLabo,clases);
			
			return tipoarealaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoAreaLaboParameterReturnGeneral procesarEventosTipoAreaLabosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAreaLabo> tipoarealabos,TipoAreaLabo tipoarealabo,TipoAreaLaboParameterReturnGeneral tipoarealaboParameterGeneral,Boolean isEsNuevoTipoAreaLabo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-procesarEventosTipoAreaLabosWithConnection");connexion.begin();			
			
			TipoAreaLaboParameterReturnGeneral tipoarealaboReturnGeneral=new TipoAreaLaboParameterReturnGeneral();
	
			tipoarealaboReturnGeneral.setTipoAreaLabo(tipoarealabo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoarealaboReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAreaLaboLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoarealabos,tipoarealabo,tipoarealaboParameterGeneral,tipoarealaboReturnGeneral,isEsNuevoTipoAreaLabo,clases);
			
			this.connexion.commit();
			
			return tipoarealaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAreaLaboParameterReturnGeneral procesarImportacionTipoAreaLabosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoAreaLaboParameterReturnGeneral tipoarealaboParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-procesarImportacionTipoAreaLabosWithConnection");connexion.begin();			
			
			TipoAreaLaboParameterReturnGeneral tipoarealaboReturnGeneral=new TipoAreaLaboParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoarealabos=new ArrayList<TipoAreaLabo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoarealabo=new TipoAreaLabo();
				
				
				if(conColumnasBase) {this.tipoarealabo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoarealabo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoarealabo.setcodigo(arrColumnas[iColumn++]);
				this.tipoarealabo.setnombre(arrColumnas[iColumn++]);
				
				this.tipoarealabos.add(this.tipoarealabo);
			}
			
			this.saveTipoAreaLabos();
			
			this.connexion.commit();
			
			tipoarealaboReturnGeneral.setConRetornoEstaProcesado(true);
			tipoarealaboReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoarealaboReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoAreaLabosEliminados() throws Exception {				
		
		List<TipoAreaLabo> tipoarealabosAux= new ArrayList<TipoAreaLabo>();
		
		for(TipoAreaLabo tipoarealabo:tipoarealabos) {
			if(!tipoarealabo.getIsDeleted()) {
				tipoarealabosAux.add(tipoarealabo);
			}
		}
		
		tipoarealabos=tipoarealabosAux;
	}
	
	public void quitarTipoAreaLabosNulos() throws Exception {				
		
		List<TipoAreaLabo> tipoarealabosAux= new ArrayList<TipoAreaLabo>();
		
		for(TipoAreaLabo tipoarealabo : this.tipoarealabos) {
			if(tipoarealabo==null) {
				tipoarealabosAux.add(tipoarealabo);
			}
		}
		
		//this.tipoarealabos=tipoarealabosAux;
		
		this.tipoarealabos.removeAll(tipoarealabosAux);
	}
	
	public void getSetVersionRowTipoAreaLaboWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoarealabo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoarealabo.getIsDeleted() || (tipoarealabo.getIsChanged()&&!tipoarealabo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoarealaboDataAccess.getSetVersionRowTipoAreaLabo(connexion,tipoarealabo.getId());
				
				if(!tipoarealabo.getVersionRow().equals(timestamp)) {	
					tipoarealabo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoarealabo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoAreaLabo()throws Exception {	
		
		if(tipoarealabo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoarealabo.getIsDeleted() || (tipoarealabo.getIsChanged()&&!tipoarealabo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoarealaboDataAccess.getSetVersionRowTipoAreaLabo(connexion,tipoarealabo.getId());
			
			try {							
				if(!tipoarealabo.getVersionRow().equals(timestamp)) {	
					tipoarealabo.setVersionRow(timestamp);
				}
				
				tipoarealabo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoAreaLabosWithConnection()throws Exception {	
		if(tipoarealabos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoAreaLabo tipoarealaboAux:tipoarealabos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoarealaboAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoarealaboAux.getIsDeleted() || (tipoarealaboAux.getIsChanged()&&!tipoarealaboAux.getIsNew())) {
						
						timestamp=tipoarealaboDataAccess.getSetVersionRowTipoAreaLabo(connexion,tipoarealaboAux.getId());
						
						if(!tipoarealabo.getVersionRow().equals(timestamp)) {	
							tipoarealaboAux.setVersionRow(timestamp);
						}
								
						tipoarealaboAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoAreaLabos()throws Exception {	
		if(tipoarealabos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoAreaLabo tipoarealaboAux:tipoarealabos) {
					if(tipoarealaboAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoarealaboAux.getIsDeleted() || (tipoarealaboAux.getIsChanged()&&!tipoarealaboAux.getIsNew())) {
						
						timestamp=tipoarealaboDataAccess.getSetVersionRowTipoAreaLabo(connexion,tipoarealaboAux.getId());
						
						if(!tipoarealaboAux.getVersionRow().equals(timestamp)) {	
							tipoarealaboAux.setVersionRow(timestamp);
						}
						
													
						tipoarealaboAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoAreaLaboParameterReturnGeneral cargarCombosLoteForeignKeyTipoAreaLaboWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoAreaLaboParameterReturnGeneral  tipoarealaboReturnGeneral =new TipoAreaLaboParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoAreaLaboWithConnection");connexion.begin();
			
			tipoarealaboReturnGeneral =new TipoAreaLaboParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoarealaboReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoarealaboReturnGeneral;
	}
	
	public TipoAreaLaboParameterReturnGeneral cargarCombosLoteForeignKeyTipoAreaLabo(String finalQueryGlobalEmpresa) throws Exception {
		TipoAreaLaboParameterReturnGeneral  tipoarealaboReturnGeneral =new TipoAreaLaboParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoarealaboReturnGeneral =new TipoAreaLaboParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoarealaboReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoarealaboReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoAreaLaboWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			InformacionLaboralLogic informacionlaboralLogic=new InformacionLaboralLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoAreaLaboWithConnection");connexion.begin();
			
			
			classes.add(new Classe(InformacionLaboral.class));
											
			

			informacionlaboralLogic.setConnexion(this.getConnexion());
			informacionlaboralLogic.setDatosCliente(this.datosCliente);
			informacionlaboralLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoAreaLabo tipoarealabo:this.tipoarealabos) {
				

				classes=new ArrayList<Classe>();
				classes=InformacionLaboralConstantesFunciones.getClassesForeignKeysOfInformacionLaboral(new ArrayList<Classe>(),DeepLoadType.NONE);

				informacionlaboralLogic.setInformacionLaborals(tipoarealabo.informacionlaborals);
				informacionlaboralLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoAreaLabo tipoarealabo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoAreaLaboLogicAdditional.updateTipoAreaLaboToGet(tipoarealabo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoarealabo.setEmpresa(tipoarealaboDataAccess.getEmpresa(connexion,tipoarealabo));
		tipoarealabo.setInformacionLaborals(tipoarealaboDataAccess.getInformacionLaborals(connexion,tipoarealabo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoarealabo.setEmpresa(tipoarealaboDataAccess.getEmpresa(connexion,tipoarealabo));
				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoarealabo.setInformacionLaborals(tipoarealaboDataAccess.getInformacionLaborals(connexion,tipoarealabo));

				if(this.isConDeep) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(this.connexion);
					informacionlaboralLogic.setInformacionLaborals(tipoarealabo.getInformacionLaborals());
					ArrayList<Classe> classesLocal=InformacionLaboralConstantesFunciones.getClassesForeignKeysOfInformacionLaboral(new ArrayList<Classe>(),DeepLoadType.NONE);
					informacionlaboralLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(informacionlaboralLogic.getInformacionLaborals());
					tipoarealabo.setInformacionLaborals(informacionlaboralLogic.getInformacionLaborals());
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
			tipoarealabo.setEmpresa(tipoarealaboDataAccess.getEmpresa(connexion,tipoarealabo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionLaboral.class));
			tipoarealabo.setInformacionLaborals(tipoarealaboDataAccess.getInformacionLaborals(connexion,tipoarealabo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoarealabo.setEmpresa(tipoarealaboDataAccess.getEmpresa(connexion,tipoarealabo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoarealabo.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoarealabo.setInformacionLaborals(tipoarealaboDataAccess.getInformacionLaborals(connexion,tipoarealabo));

		for(InformacionLaboral informacionlaboral:tipoarealabo.getInformacionLaborals()) {
			InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
			informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoarealabo.setEmpresa(tipoarealaboDataAccess.getEmpresa(connexion,tipoarealabo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoarealabo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoarealabo.setInformacionLaborals(tipoarealaboDataAccess.getInformacionLaborals(connexion,tipoarealabo));

				for(InformacionLaboral informacionlaboral:tipoarealabo.getInformacionLaborals()) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
					informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
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
			tipoarealabo.setEmpresa(tipoarealaboDataAccess.getEmpresa(connexion,tipoarealabo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoarealabo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionLaboral.class));
			tipoarealabo.setInformacionLaborals(tipoarealaboDataAccess.getInformacionLaborals(connexion,tipoarealabo));

			for(InformacionLaboral informacionlaboral:tipoarealabo.getInformacionLaborals()) {
				InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
				informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoAreaLabo tipoarealabo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoAreaLaboLogicAdditional.updateTipoAreaLaboToSave(tipoarealabo,this.arrDatoGeneral);
			
TipoAreaLaboDataAccess.save(tipoarealabo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoarealabo.getEmpresa(),connexion);

		for(InformacionLaboral informacionlaboral:tipoarealabo.getInformacionLaborals()) {
			informacionlaboral.setidvalorclientearealaboral(tipoarealabo.getId());
			InformacionLaboralDataAccess.save(informacionlaboral,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoarealabo.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionLaboral informacionlaboral:tipoarealabo.getInformacionLaborals()) {
					informacionlaboral.setidvalorclientearealaboral(tipoarealabo.getId());
					InformacionLaboralDataAccess.save(informacionlaboral,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoarealabo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoarealabo.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(InformacionLaboral informacionlaboral:tipoarealabo.getInformacionLaborals()) {
			InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
			informacionlaboral.setidvalorclientearealaboral(tipoarealabo.getId());
			InformacionLaboralDataAccess.save(informacionlaboral,connexion);
			informacionlaboralLogic.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoarealabo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoarealabo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionLaboral informacionlaboral:tipoarealabo.getInformacionLaborals()) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
					informacionlaboral.setidvalorclientearealaboral(tipoarealabo.getId());
					InformacionLaboralDataAccess.save(informacionlaboral,connexion);
					informacionlaboralLogic.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoAreaLabo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoarealabo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(tipoarealabo);
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
			this.deepLoad(this.tipoarealabo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoAreaLabo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoarealabos!=null) {
				for(TipoAreaLabo tipoarealabo:tipoarealabos) {
					this.deepLoad(tipoarealabo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(tipoarealabos);
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
			if(tipoarealabos!=null) {
				for(TipoAreaLabo tipoarealabo:tipoarealabos) {
					this.deepLoad(tipoarealabo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(tipoarealabos);
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
			this.getNewConnexionToDeep(TipoAreaLabo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoarealabo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoAreaLabo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoarealabos!=null) {
				for(TipoAreaLabo tipoarealabo:tipoarealabos) {
					this.deepSave(tipoarealabo,isDeep,deepLoadType,clases);
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
			if(tipoarealabos!=null) {
				for(TipoAreaLabo tipoarealabo:tipoarealabos) {
					this.deepSave(tipoarealabo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoAreaLabosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaLabo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAreaLaboConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoAreaLabosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAreaLaboConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAreaLaboLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoarealabos=tipoarealaboDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAreaLaboConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaLabo(this.tipoarealabos);
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
			if(TipoAreaLaboConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaLaboDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoAreaLabo tipoarealabo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoAreaLaboConstantesFunciones.ISCONAUDITORIA) {
				if(tipoarealabo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaLaboDataAccess.TABLENAME, tipoarealabo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAreaLaboConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAreaLaboLogic.registrarAuditoriaDetallesTipoAreaLabo(connexion,tipoarealabo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoarealabo.getIsDeleted()) {
					/*if(!tipoarealabo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoAreaLaboDataAccess.TABLENAME, tipoarealabo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoAreaLaboLogic.registrarAuditoriaDetallesTipoAreaLabo(connexion,tipoarealabo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaLaboDataAccess.TABLENAME, tipoarealabo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoarealabo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaLaboDataAccess.TABLENAME, tipoarealabo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAreaLaboConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAreaLaboLogic.registrarAuditoriaDetallesTipoAreaLabo(connexion,tipoarealabo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoAreaLabo(Connexion connexion,TipoAreaLabo tipoarealabo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoarealabo.getIsNew()||!tipoarealabo.getid_empresa().equals(tipoarealabo.getTipoAreaLaboOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoarealabo.getTipoAreaLaboOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoarealabo.getTipoAreaLaboOriginal().getid_empresa().toString();
				}
				if(tipoarealabo.getid_empresa()!=null)
				{
					strValorNuevo=tipoarealabo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAreaLaboConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoarealabo.getIsNew()||!tipoarealabo.getcodigo().equals(tipoarealabo.getTipoAreaLaboOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoarealabo.getTipoAreaLaboOriginal().getcodigo()!=null)
				{
					strValorActual=tipoarealabo.getTipoAreaLaboOriginal().getcodigo();
				}
				if(tipoarealabo.getcodigo()!=null)
				{
					strValorNuevo=tipoarealabo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAreaLaboConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoarealabo.getIsNew()||!tipoarealabo.getnombre().equals(tipoarealabo.getTipoAreaLaboOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoarealabo.getTipoAreaLaboOriginal().getnombre()!=null)
				{
					strValorActual=tipoarealabo.getTipoAreaLaboOriginal().getnombre();
				}
				if(tipoarealabo.getnombre()!=null)
				{
					strValorNuevo=tipoarealabo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAreaLaboConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoAreaLaboRelacionesWithConnection(TipoAreaLabo tipoarealabo,List<InformacionLaboral> informacionlaborals) throws Exception {

		if(!tipoarealabo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAreaLaboRelacionesBase(tipoarealabo,informacionlaborals,true);
		}
	}

	public void saveTipoAreaLaboRelaciones(TipoAreaLabo tipoarealabo,List<InformacionLaboral> informacionlaborals)throws Exception {

		if(!tipoarealabo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAreaLaboRelacionesBase(tipoarealabo,informacionlaborals,false);
		}
	}

	public void saveTipoAreaLaboRelacionesBase(TipoAreaLabo tipoarealabo,List<InformacionLaboral> informacionlaborals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoAreaLabo-saveRelacionesWithConnection");}
	
			tipoarealabo.setInformacionLaborals(informacionlaborals);

			this.setTipoAreaLabo(tipoarealabo);

			if(TipoAreaLaboLogicAdditional.validarSaveRelaciones(tipoarealabo,this)) {

				TipoAreaLaboLogicAdditional.updateRelacionesToSave(tipoarealabo,this);

				if((tipoarealabo.getIsNew()||tipoarealabo.getIsChanged())&&!tipoarealabo.getIsDeleted()) {
					this.saveTipoAreaLabo();
					this.saveTipoAreaLaboRelacionesDetalles(informacionlaborals);

				} else if(tipoarealabo.getIsDeleted()) {
					this.saveTipoAreaLaboRelacionesDetalles(informacionlaborals);
					this.saveTipoAreaLabo();
				}

				TipoAreaLaboLogicAdditional.updateRelacionesToSaveAfter(tipoarealabo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			InformacionLaboralConstantesFunciones.InicializarGeneralEntityAuxiliaresInformacionLaborals(informacionlaborals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoAreaLaboRelacionesDetalles(List<InformacionLaboral> informacionlaborals)throws Exception {
		try {
	

			Long idTipoAreaLaboActual=this.getTipoAreaLabo().getId();

			InformacionLaboralLogic informacionlaboralLogic_Desde_TipoAreaLabo=new InformacionLaboralLogic();
			informacionlaboralLogic_Desde_TipoAreaLabo.setInformacionLaborals(informacionlaborals);

			informacionlaboralLogic_Desde_TipoAreaLabo.setConnexion(this.getConnexion());
			informacionlaboralLogic_Desde_TipoAreaLabo.setDatosCliente(this.datosCliente);

			for(InformacionLaboral informacionlaboral_Desde_TipoAreaLabo:informacionlaboralLogic_Desde_TipoAreaLabo.getInformacionLaborals()) {
				informacionlaboral_Desde_TipoAreaLabo.setidvalorclientearealaboral(idTipoAreaLaboActual);
			}

			informacionlaboralLogic_Desde_TipoAreaLabo.saveInformacionLaborals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAreaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAreaLaboConstantesFunciones.getClassesForeignKeysOfTipoAreaLabo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAreaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAreaLaboConstantesFunciones.getClassesRelationshipsOfTipoAreaLabo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
